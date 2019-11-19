import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.WebDriverFactory;

public class BaseTest {
    protected WebDriver webDriver;
    private WebDriverFactory webDriverFactory;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        webDriverFactory = new WebDriverFactory();
        webDriver = webDriverFactory.getInstance();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
