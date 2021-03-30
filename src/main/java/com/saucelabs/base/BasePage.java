package com.saucelabs.base;

import com.saucelabs.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import com.saucelabs.utils.Constants;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;
    public static WebDriver initializeDriver(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILE);
        String browser= ConfigReader.getProperty("browser");
        String baseURl=ConfigReader.getProperty("url");
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            default:
                System.out.println("invalid Driver");
                throw new RuntimeException("Invalid Browser Name ....");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseURl);
        return driver;
    }
    public static void tearDown(){
        if (driver !=null){
            driver.quit();
        }
    }

}
