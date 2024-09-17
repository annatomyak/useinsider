package ui;

import base.ScreenshotOnFailureExtension;
import base.UIBaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import ui.enums.CompanyPages;
import ui.enums.NavigationBar;
import ui.pages.CareerPage;
import ui.pages.MainPage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ui.utils.AssertionMessages.*;

@ExtendWith(ScreenshotOnFailureExtension.class)
public class CareersPageTest extends UIBaseTest {
    private MainPage mainPage;
    private CareerPage careerPage;


    @BeforeEach
    public void setUp() throws IOException {
        super.setUp();
        mainPage = new MainPage(driver);
        careerPage = new CareerPage(driver);

    }

    @org.junit.jupiter.api.Test
    public void verifyCareersPageContainsRequiredBlocks() {
        mainPage.clickOnNavigationMenuItems(NavigationBar.COMPANY.getValue());
        mainPage.goToCompanyPages(CompanyPages.CAREERS.getValue());

        Assertions.assertTrue(careerPage.locationBlockIsDisplayed(), LOCATION_BLOCK_IS_NOT_DISPLAYED);
        assertEquals(28, careerPage.getCitySize(), CITY_SIZE_INCORRECT);

        Assertions.assertTrue(careerPage.lifeAtInsiderHeaderIsDisplayed(), LIFE_AT_INSIDER_BLOCK_INCORRECT);
        assertEquals(13, careerPage.getImagesLifeAtInsiderCarouselSize(), IMAGES_SIZE_INCORRECT);

        Assertions.assertTrue(careerPage.sectionTeamIsDisplayed(), TEAM_BLOCK_IS_NOT_DISPLAYED);

    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
    }
}
