package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import testClasses.NewsSearchAndDetails;
import util.DriverFactory;

public class NewsSearchAndDetailsStepDef {
    WebDriver driver = DriverFactory.getDriver();
    NewsSearchAndDetails newsSearchAndDetails = new NewsSearchAndDetails(driver);

    @Given("User is on home page")
    public void userIsOnHomePage() {
        newsSearchAndDetails.userIsOnHomePage();
    }

    @When("Click to search button")
    public void clickToSearchButton() {
        newsSearchAndDetails.clickToSearchButton();
    }

    @And("Type {string} in the search field and search")
    public void typeInTheSearchFieldAndSearch(String search) {
        newsSearchAndDetails.typeInTheSearchFieldAndSearch(search);
    }

    @Then("List of search results should be displayed")
    public void listOfSearchResultsShouldBeDisplayed() {
        newsSearchAndDetails.listOfSearchResultsShouldBeDisplayed();
    }

    @When("User goes to the details of the news number {string}")
    public void userGoesToTheDetailsOfTheNewsNumber(String details) {
        newsSearchAndDetails.userGoesToTheDetailsOfTheNewsNumber(details);
    }

    @Then("News number {string} should be displayed successfully")
    public void newsNumberShouldBeDisplayedSuccessfully(String details) {
        newsSearchAndDetails.newsNumberShouldBeDisplayedSuccessfully(details);
    }
}
