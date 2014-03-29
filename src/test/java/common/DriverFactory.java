package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
        public static WebDriver createDriver(String type) {
            WebDriver driver;
            if (type.equals("chrome")) {
                driver = new ChromeDriver();
                return driver;
            } else if(type.equals("firefox")) {
                driver = new FirefoxDriver();
                return driver;
            }
            else return new FirefoxDriver();
        }
    }