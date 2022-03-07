import com.lessonplanet.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_BrowseResourceDirectory_MainPageTest extends BaseTest {

    private LoginPage loginPage;
    private User_BrowseResourceDirectory_MainPageTest user_BrowseResource_directoryMainPageTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_BrowseResource_directoryMainPageTest = new User_BrowseResourceDirectory_MainPageTest();
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Regular SL - Browse Resource Directory - Main Page - C2404: Page UI", groups = {"rsl"})
    public void testC2404() {
        testPageUi(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Browse Resource Directory - Main Page - C2405: Thumbnails", groups = {"rsl"})
    public void testC2405() {
        testThumbnails(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Browse Resource Directory - Main Page - C2406: Links", groups = {"rsl"})
    public void testC2406() {
        testLinks(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Browse Resource Directory - Main Page - C2407: Show All button", groups = {"rsl"})
    public void testC2407() {
        testShowAllButton(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Browse Resource Directory - Main Page - C2408: Categories modal", groups = {"rsl"})
    public void testC2408() {
        testCategoriesModal(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    private void initDirectoryTestAndLogin(String account) {
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        user_BrowseResource_directoryMainPageTest.initTest(webDriver);
    }

    protected void testPageUi(String account) {
        initDirectoryTestAndLogin(account);
        user_BrowseResource_directoryMainPageTest.testPageUi();
    }

    protected void testThumbnails(String account) {
        initDirectoryTestAndLogin(account);
        user_BrowseResource_directoryMainPageTest.testThumbnails();
    }

    protected void testLinks(String account) {
        initDirectoryTestAndLogin(account);
        user_BrowseResource_directoryMainPageTest.testLinks();
    }

    protected void testShowAllButton(String account) {
        initDirectoryTestAndLogin(account);
        user_BrowseResource_directoryMainPageTest.testShowAllButton();
    }

    protected void testCategoriesModal(String account) {
        initDirectoryTestAndLogin(account);
        user_BrowseResource_directoryMainPageTest.testCategoriesModal();
    }
}
