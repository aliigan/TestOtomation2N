package util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Hooks {
    WebDriver driver;
    Properties properties;

    @Before
    public void before(){
        properties = ConfigReader.initializeProperties();
        driver = DriverFactory2nHaber.initializeDriver();
    }

    @After
    public  void after(){

//        driver.quit();
    }
}
