import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.Browser;
import util.WebDriverFactory;

public class BaseTest {
    protected WebDriver webDriver;
    protected Browser browser;

    @BeforeMethod
    public void init() {
        browser = new Browser();
        browser.setName("firefox");
        webDriver = WebDriverFactory.getInstance(browser);
    }

    @AfterMethod
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
