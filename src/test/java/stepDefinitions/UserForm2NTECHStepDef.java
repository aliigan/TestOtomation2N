package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import testClases.UserForm2NTECH;
import util.DriverFactory;

public class UserForm2NTECHStepDef {

    WebDriver driver = DriverFactory.getDriver();
    UserForm2NTECH userform = new UserForm2NTECH(driver);
    @When("Write name surname as {string}")
    public void writeNameSurnameAs(String name) {
        userform.writeNameSurnameAs(name);
    }

    @And("Write birtdate as {string}")
    public void writeBirtdateAs(String birtdate) {
        userform.writeBirtdateAs(birtdate);
    }

    @And("Write Turkish Identification number as {string}")
    public void writeTurkishIdentificationNumberAs(String idNumber) {
        userform.writeTurkishIdentificationNumberAs(idNumber);
    }

    @And("Write mobile number as {string}")
    public void writeMobileNumberAs(String mobile) {
        userform.writeMobileNumberAs(mobile);
    }

    @And("Write mail as {string}")
    public void writeMailAs(String mail) {
        userform.writeMailAs(mail);
    }

    @And("Upload CV")
    public void uploadCV() {
        userform.uploadCV();
    }

    @And("Select education as {string}")
    public void selectEducationAs(String education) {
        userform.selectEducationAs(education);
    }

    @And("Click to next button")
    public void clickToNextButton() {
        userform.clickToNextButton();
    }

    @Then("User must be on details page")
    public void userMustBeOnDetailsPage() {
        userform.userMustBeOnDetailsPage();
    }

    @When("Select  position as {string}")
    public void selectPositionAs(String position) {
        userform.selectPositionAs(position);
    }

    @And("Click to send button")
    public void clickToSendButton() {
        userform.clickToSendButton();
    }

    @Then("The form must be sent successfully")
    public void theFormMustBeSentSuccessfully() {
        userform.theFormMustBeSentSuccessfully();
    }
}
