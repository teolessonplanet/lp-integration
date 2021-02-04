import com.lessonplanet.pages.StepTwoPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.WebDriverFactory;

public class BaseTest {
    protected WebDriver webDriver;
    private WebDriverFactory webDriverFactory;
    private StepTwoPage stepTwoPage;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        webDriverFactory = new WebDriverFactory();
        webDriver = webDriverFactory.getInstance();
        stepTwoPage = new StepTwoPage(webDriver);
    }

    protected String createNewUser(String accountPlan) {
        String account = stepTwoPage.createNewAccount(accountPlan);
        tearDown();
        init();
        return account;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
