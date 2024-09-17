package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ui.utils.WaitUtils;

import java.util.List;

import static ui.utils.WaitUtils.untilJqueryIsDone;


public class QualityAssurancePage extends BasicPage {
    @FindBy(xpath = "//a[text()='See all QA jobs']")
    public WebElement seeAllQAJobsButton;

    @FindBy(xpath = "//span[@id='select2-filter-by-location-container']")
    public WebElement filterByLocationField;

    @FindBy(xpath = "//span[@id='select2-filter-by-department-container']")
    public WebElement filterByDepartmentField;

    @FindBy(xpath = "//*[@id='jobs-list']/div")
    public List<WebElement> jobItems;

    @FindBy(xpath = "//div[contains(@class, 'position-location')]")
    private List<WebElement> itemsLocation;

    @FindBy(xpath = "//div[contains(@class, 'position-list')]//p")
    private List<WebElement> itemsJobDepartment;

    public static final String QUALITY_ASSURANCE_PATH = "/careers/quality-assurance/";
    WaitUtils waitUtils = new WaitUtils(driver);
    Actions actions = new Actions(driver);
    String jobsLeverDomain = "jobs.lever.co";

    public QualityAssurancePage(WebDriver driver) {
        super(driver);
    }

    public void openAllQAJobsPage() {
        seeAllQAJobsButton.click();
        untilJqueryIsDone(driver, 20L);
    }

    public QualityAssurancePage openQualityAssurancePage() {
        driver.get(BASE_PAGE_URL + QUALITY_ASSURANCE_PATH);
        return this;
    }

    public void setOptionInDropdownField(String option) {
        WebElement menuDropdown = driver.findElement(By.xpath(String.format("//li[text()='%s']", option)));
        waitUtils.waitForElementVisible(menuDropdown);

        actions.moveToElement(menuDropdown).perform();
        menuDropdown.click();
        untilJqueryIsDone(driver, 20L);
    }

    public void setFilterByLocation(String location) {
        filterByLocationField.click();
        setOptionInDropdownField(location);
    }

    public void setFilterByDepartment(String department) {
        filterByDepartmentField.click();
        setOptionInDropdownField(department);
    }

    public boolean checkThatJobsArePresent() {
        return !jobItems.isEmpty();
    }

    public boolean checkSearchInList(List<WebElement> elements, String text) {
        for (WebElement item : elements) {
            if (item.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkLocationInJobList(String text) {
        return checkSearchInList(itemsLocation, text);
    }

    public boolean checkDepartmentInJobList(String text) {
        return checkSearchInList(itemsJobDepartment, text);
    }

    public void clickViewRoleButton(int indexPosition) {
        WebElement jobBlock = driver.findElement(By.xpath(String.format("//*[@id='jobs-list']/div[%s]", indexPosition)));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: \"instant\", block: \"center\", inline: \"nearest\"});", jobBlock);
        actions.moveToElement(jobBlock).perform();
        WebElement viewRoleButton = driver.findElement(By.xpath(String.format("//*[@id='jobs-list']/div[%s]//a", indexPosition)));
        waitUtils.waitForElementVisible(viewRoleButton);
        viewRoleButton.click();

    }

    public void switchToAnotherTab() {
        String originalHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

    }

    public boolean checkJobsLeverPageIsOpened() {
        switchToAnotherTab();
        return getCurrentUrl().contains(jobsLeverDomain);
    }

}
