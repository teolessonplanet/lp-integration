import com.lessonplanet.pages.StepTwoPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import util.WebDriverFactory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class BaseTest {
    protected WebDriver webDriver;
    private StepTwoPage stepTwoPage;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverFactory.getDriverFromInternet();
    }

    @BeforeMethod(alwaysRun = true)
    public void init() {
        webDriver = WebDriverFactory.getInstance();
        stepTwoPage = new StepTwoPage(webDriver);
    }

    protected String createNewUser(String accountPlan) {
        String account = stepTwoPage.createNewAccount(accountPlan);
        webDriver.manage().deleteAllCookies();
        return account;
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator  + "screenshots\\" + testResult.getName() + "-"
                + Arrays.toString(testResult.getParameters()) + ".jpg"));
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
