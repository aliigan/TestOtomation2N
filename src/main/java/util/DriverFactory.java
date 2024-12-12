package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Properties;

public class DriverFactory {
    static WebDriver driver;
    static Properties properties;

    public static WebDriver initializeDriver() {

        properties = ConfigReader.getProperties();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        String url = properties.getProperty("url");
        int pageWait = Integer.parseInt(properties.getProperty("pageLoadTimeOut"));
        int impWait = Integer.parseInt(properties.getProperty("implicityWait"));
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageWait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(impWait));

        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
