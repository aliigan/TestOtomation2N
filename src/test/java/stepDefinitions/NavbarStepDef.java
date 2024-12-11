package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import testClases.Navbar;
import util.DriverFactory2nHaber;

public class NavbarStepDef {

    WebDriver driver = DriverFactory2nHaber.getDriver();
    Navbar navbar = new Navbar(driver);
    @Given("User is on home page")
    public void userIsOnHomePage() {
        navbar.userIsOnHomePage();
    }

    @When("The user clicks on all elements in the navbar in order")
    public void theUserClicksOnAllElementsInTheNavbarInOrder() {
        navbar.theUserClicksOnAllElementsInTheNavbarInOrder();
    }

    @Then("After each click, the relevant page should open without any problems")
    public void afterEachClickTheRelevantPageShouldOpenWithoutAnyProblems() {
        navbar.afterEachClickTheRelevantPageShouldOpenWithoutAnyProblems();
    }
}
