package testClases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class UserForm2NTECH {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;
    Actions actions;
    
    public UserForm2NTECH(WebDriver driver){
        this.driver = driver;
        this.elementHelper = new ElementHelper(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void writeNameSurnameAs(String name) {
        By name_ = By.xpath("//input[@id='name']");
        elementHelper.sendKey(name_, name);
    }

    public void writeBirtdateAs(String birtdate) {
        By birtdate_ = By.xpath("//input[@id='birth']");
        elementHelper.sendKey(birtdate_, birtdate);
    }

    public void writeTurkishIdentificationNumberAs(String idNumber) {
        By idNumber_ = By.xpath("//input[@id='tcKimlik']");
        elementHelper.sendKey(idNumber_, idNumber);
    }

    public void writeMobileNumberAs(String mobile) {
        By mobile_ = By.xpath("//input[@id='phone']");
        elementHelper.sendKey(mobile_, mobile);
    }

    public void writeMailAs(String mail) {
        By mail_ = By.xpath("//input[@id='email']");
        elementHelper.sendKey(mail_, mail);
    }

    public void uploadCV() {
        By uploadButton = By.xpath("//label[@class='bg-[#DF1F29] " +
                "text-white py-4 px-4 md:px-10 rounded-r-md cursor-pointer flex " +
                "items-center justify-center']");
        elementHelper.sleep(1000);
        elementHelper.scrollToElement(uploadButton);
        elementHelper.click(uploadButton);
        elementHelper.sleep(1000);

        //günün sonunda readMe dosyasına buranın değiştirlmesi gerektiği eklenmeli
        String filePath = "C:\\Users\\ahmet\\Desktop\\ornek.pdf";
        WebElement uploadElement = driver.findElement(By.id("cv_field"));
        uploadElement.sendKeys(filePath);
        elementHelper.sleep(1000);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_ALT);
    }

    public void selectEducationAs(String education) {
        By education_ = By.xpath("//button[normalize-space()='" + education + "']");
        elementHelper.click(education_);
    }

    public void clickToNextButton() {
        By nextButton = By.xpath("//*[name()='path' and contains(@d,'M502.6 278')]");
        elementHelper.click(nextButton);
    }

    public void userMustBeOnDetailsPage() {
        elementHelper.sleep(500);
        By positionTitle = By.xpath("//span[@class='text-[14px] font-semibold']");
        elementHelper.testWebElementText(positionTitle, "Pozisyon*");
    }

    public void selectPositionAs(String position) {
        By position_ = By.xpath("//span[normalize-space()='" + position + "']");
        elementHelper.click(position_);
    }

    public void clickToSendButton() {
        By sendButton = By.xpath("//div[@class='text-white flex justify-center " +
                "items-center text-[14px] py-2 px-4 rounded-full bg-[#DF1F29] cursor-pointer']");
        elementHelper.scrollToElement(sendButton);
        elementHelper.sleep(500);
        elementHelper.click(sendButton);
    }

    public void theFormMustBeSentSuccessfully() {
        elementHelper.sleep(3000);
        By successfulMessage = By.xpath("//p[@class='text-[16px] flex justify-start " +
                "items-start leading-6']");
        String expectedMessage = "Form Başarı ile gönderildi. Katıldığınız için teşekkür ederiz.";
        elementHelper.testWebElementText(successfulMessage, expectedMessage);
    }
}
