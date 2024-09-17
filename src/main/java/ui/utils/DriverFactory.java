package ui.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ui.enums.BrowserType;


public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver(BrowserType browser) {
        if (driver == null) {
            driver = createDriver(browser);
        }
        return driver;
    }

    private static WebDriver createDriver(BrowserType browser) {
        switch (browser) {
            case CHROME:
                driver = ChromeDriverManager.createDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
