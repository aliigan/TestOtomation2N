package testClasses;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;

import java.time.Duration;
import java.util.List;

public class NewsSearchAndDetails {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;
    Actions actions;
    
    public NewsSearchAndDetails(WebDriver driver){
        this.driver = driver;
        this.elementHelper = new ElementHelper(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void userIsOnHomePage() {

    }

    public void clickToSearchButton() {
        By search = By.cssSelector(".e-font-icon-svg.e-fas-search");
        elementHelper.click(search);
    }

    public void typeInTheSearchFieldAndSearch(String search) {
        elementHelper.sleep(3000);
        By searchInput = By.xpath("//input[@placeholder='Keşfet...']");
        elementHelper.sendKey(driver, searchInput, search);
    }

    public void listOfSearchResultsShouldBeDisplayed() {
        By searchResultTitle = By.xpath("//h3[@class='cmsmasters-blog-header-title']");
        Assert.assertTrue(elementHelper.isElementPresent(driver, searchResultTitle));
    }

    public void userGoesToTheDetailsOfTheNewsNumber(String details) {
        List<WebElement> links = driver.findElements(By.cssSelector("div > h3 > a"));
        int newsOrder = Integer.parseInt(details);
        newsOrder -= 1;

        elementHelper.sleep(1000);

        WebElement element = links.get(newsOrder);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        elementHelper.sleep(1000);
        links.get(newsOrder).click();
    }

    public void newsNumberShouldBeDisplayedSuccessfully(String details) {
        elementHelper.sleep(1000);
        By detailsTitle = By.cssSelector("div > h1");
        elementHelper.testWebElementText(detailsTitle, details.trim());
    }
}
