package util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ElementHelper {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public ElementHelper(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public WebElement presenceElement(By key){
        return wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    public WebElement findElement(By key){
        WebElement element = presenceElement(key);
        return element;
    }

    public void sendKey(By key, String text){
        findElement(key).sendKeys(text);
//        actions.sendKeys(Keys.ENTER).perform();
    }
    public void sendKey(WebDriver driver, By key, String text){
        WebElement element = driver.findElement(key);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    public void checkVisible(By key){
        wait.until(ExpectedConditions.visibilityOf(findElement(key)));
    }

    public void click(By key){
        findElement(key).click();
    }

    public void sleep(long milisecond){
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void scrollByAmount(WebDriver driver, int amount) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0])", amount);
    }


    public void testWebElementText(By key, String expected) {
        WebElement element = driver.findElement(key);
        String actualText = element.getText().trim();
        assertEquals( actualText, expected, "The text of the web element does not meet the expected value.");
    }


    public void deleteAll(By key){
        WebElement element = driver.findElement(key);
        element.clear();
    }

    public void doubleClick(By key){
        WebElement element = driver.findElement(key);
        actions.doubleClick(element).perform();
    }

    public void rightClick(By key){
        WebElement element = driver.findElement(key);
        actions.contextClick(element).perform();
    }

    public void leftClick(By key){
        WebElement element = driver.findElement(key);
        actions.click(element).perform();
    }

    public void scrollToElement(By key){
        WebElement element = driver.findElement(key);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public boolean isElementPresent(WebDriver driver, By by) {
        List<WebElement> elements = driver.findElements(by);
        return elements.size() > 0;
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }


    public boolean isElementVisible(By locator) {
        try {
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return button.isDisplayed() &&
                    !button.getCssValue("display").equals("none") &&
                    !button.getCssValue("visibility").equals("hidden");
        } catch (Exception e) {
            return false;
        }

    }

    public void hoverOver(WebDriver driver, By locator, Actions actions){
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element);
    }

    public void selectValue(WebDriver driver,String selectId, int index){
        WebElement element = driver.findElement(By.id(selectId));
        Select select = new Select(element);
        select.selectByIndex(index);
    }
}
