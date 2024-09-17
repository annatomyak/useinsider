package base;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.WebDriver;
import ui.enums.BrowserType;
import ui.utils.ConfigLoader;
import ui.utils.DriverFactory;

import java.io.IOException;

import static ui.utils.ConfigProperty.BASE_URL;
import static ui.utils.ConfigProperty.BROWSER;


abstract public class UIBaseTest {
    protected static WebDriver driver;


    @BeforeEach
    public void setUp() throws IOException {
        String browser = System.getProperty(BROWSER).toUpperCase();
        String url = System.getProperty(BASE_URL);
        if (browser == null || url == null) {
            ConfigLoader.readProperties();
            browser = System.getProperty(BROWSER, browser);
            url = System.getProperty(BASE_URL, url);
        }
        driver = DriverFactory.getDriver(BrowserType.valueOf(browser));
        openMainPage(url);

    }

    public void openMainPage(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}
