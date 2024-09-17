package base;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class ScreenshotOnFailureExtension implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        try {
            Object testInstance = context.getRequiredTestInstance();
            WebDriver driver = ((UIBaseTest) testInstance).getDriver();

            if (driver instanceof TakesScreenshot) {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File targetFile = new File("target/screenshots/screenshot_" + System.currentTimeMillis() + ".png");
                FileUtils.copyFile(screenshot, targetFile);
                System.out.println("Screenshot saved to: " + targetFile.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw throwable;
    }
}

