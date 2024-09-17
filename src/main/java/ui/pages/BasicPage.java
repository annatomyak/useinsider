package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static ui.utils.ConfigProperty.BASE_URL;

public class BasicPage {
    protected static WebDriver driver;
    public static final String BASE_PAGE_URL = System.getProperty(BASE_URL);

    public BasicPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
