import com.lessonplanet.pages.StepTwoPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import util.WebDriverFactory;

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

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
