package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import util.DriverFactory2nHaber;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions", "util"},
        tags = "@UserForm",
        plugin = {"summary", "pretty", "html:Reports/CucumberReport/Reports.html"}
)
public class Runner extends AbstractTestNGCucumberTests {
    static WebDriver driver = DriverFactory2nHaber.getDriver();
}
