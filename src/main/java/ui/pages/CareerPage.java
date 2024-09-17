package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.WaitUtils;

import java.util.List;

public class CareerPage extends BasicPage {
    @FindBy(xpath = "//h3[normalize-space(text())='Our Locations']")
    public WebElement headerOurLocation;

    @FindBy(xpath = "//h2[normalize-space(text())='Life at Insider']")
    public WebElement headerLifeAtInsider;

    @FindBy(xpath = "//div[@class='location-info']/p")
    public List<WebElement> cityElements;

    @FindBy(xpath = "//div[@class='elementor-carousel-image' and @role='img']")
    public List<WebElement> imagesLinks;

    @FindBy(xpath = "//section[@id='career-find-our-calling']")
    public WebElement sectionTeam;

    WaitUtils waitUtils = new WaitUtils(driver);

    public CareerPage(WebDriver driver) {
        super(driver);
    }

    public boolean locationBlockIsDisplayed() {
        return headerOurLocation.isDisplayed();

    }

    public boolean lifeAtInsiderHeaderIsDisplayed() {
        return headerLifeAtInsider.isDisplayed();

    }

    public int getImagesLifeAtInsiderCarouselSize() {
        return imagesLinks.size();
    }

    public int getCitySize() {
        return cityElements.size();
    }

    public boolean sectionTeamIsDisplayed() {
        return sectionTeam.isDisplayed();

    }
}
