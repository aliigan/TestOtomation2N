package util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    }
    public void sendKey(WebDriver driver, By key, String text){
        WebElement element = driver.findElement(key);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
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

    public void testWebElementText(By key, String expected) {
        WebElement element = driver.findElement(key);
        String actualText = element.getText().trim();
        assertEquals( actualText, expected, "The text of the web element does not meet the expected value.");
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

}
