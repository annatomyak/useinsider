package ui;

import base.UIBaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ui.pages.MainPage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ui.pages.BasicPage.getCurrentUrl;
import static ui.utils.AssertionMessages.*;


public class MainPageTest extends UIBaseTest {
    private MainPage mainPage;


    @BeforeEach
    public void setUp() throws IOException {
        super.setUp();
        mainPage = new MainPage(driver);

    }

    @org.junit.jupiter.api.Test
    public void verifyThatMainPageIsOpened() {
        String expectedUrl = "https://useinsider.com/";
        assertEquals(expectedUrl, getCurrentUrl(), PAGE_URL_INCORRECT);
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
    }
}
