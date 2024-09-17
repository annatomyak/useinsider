package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.WaitUtils;

public class MainPage extends BasicPage {
    @FindBy(xpath = "//a[text()='Accept All']")
    public WebElement acceptCookiesButton;

    WaitUtils waitUtils = new WaitUtils(driver);

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnNavigationMenuItems(String option) {
        WebElement menuDropdown = driver.findElement(By.xpath(String.format("//*[@id='navbarNavDropdown']//a[normalize-space(text())='%s']", option)));
        menuDropdown.click();
    }

    public void goToCompanyPages(String option) {
        WebElement companyDropdown = driver.findElement(By.xpath(String.format("//a[text()='%s']", option)));
        companyDropdown.click();

    }

    public void acceptCookies() {
        acceptCookiesButton.click();

    }
}
