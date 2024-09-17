package ui;

import base.UIBaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import ui.pages.MainPage;
import ui.pages.QualityAssurancePage;

import java.io.IOException;

import static ui.utils.AssertionMessages.*;

public class QualityAssurancePageTest extends UIBaseTest {
    private QualityAssurancePage qualityAssurancePage;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() throws IOException {
        super.setUp();
        qualityAssurancePage = new QualityAssurancePage(driver);
        mainPage = new MainPage(driver);
        mainPage.acceptCookies();
    }

    @org.junit.jupiter.api.Test
    public void verifyJobListIsPresent() {
        qualityAssurancePage.openQualityAssurancePage()
                .openAllQAJobsPage();
        qualityAssurancePage.setFilterByLocation("Istanbul, Turkey");
        qualityAssurancePage.setFilterByDepartment("Quality Assurance");
        Assertions.assertTrue(qualityAssurancePage.checkThatJobsArePresent(), JOBS_ITEMS_NOT_FOUND);
        Assertions.assertTrue(qualityAssurancePage.checkLocationInJobList("Istanbul, Turkey"), LOCATION_INCORRECT);
        Assertions.assertTrue(qualityAssurancePage.checkDepartmentInJobList("Quality Assurance"), DEPARTMENT_INCORRECT);
    }

    @org.junit.jupiter.api.Test
    public void verifyViewRoleButtonOpensLeverApplicationForm() {
        qualityAssurancePage.openQualityAssurancePage()
                .openAllQAJobsPage();
        qualityAssurancePage.setFilterByLocation("Istanbul, Turkey");
        qualityAssurancePage.setFilterByDepartment("Quality Assurance");
        qualityAssurancePage.clickViewRoleButton(1);
        Assertions.assertTrue(qualityAssurancePage.checkJobsLeverPageIsOpened(), PAGE_URL_INCORRECT);

    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
    }
}
