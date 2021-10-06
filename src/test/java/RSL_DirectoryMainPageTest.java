import com.lessonplanet.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_DirectoryMainPageTest extends BaseTest {

    private LoginPage loginPage;
    private User_DirectoryMainPageTest user_directoryMainPageTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_directoryMainPageTest = new User_DirectoryMainPageTest();
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Regular SL - Directory Page - Main Page - lessonp-5178: Page UI")
    public void testLessonp_5178() {
        testPageUi(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Directory Page - Main Page - lessonp-5179: Thumbnails")
    public void testLessonp_5179() {
        testThumbnails(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Directory Page - Main Page - lessonp-5180: Links")
    public void testLessonp_5180() {
        testLinks(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Directory Page - Main Page - lessonp-5181: Show All button")
    public void testLessonp_5181() {
        testShowAllButton(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Directory Page - Main Page - lessonp-5182: Categories modal")
    public void testLessonp_5182() {
        testCategoriesModal(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    private void initDirectoryTestAndLogin(String account) {
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        user_directoryMainPageTest.initTest(webDriver);
    }

    protected void testPageUi(String account) {
        initDirectoryTestAndLogin(account);
        user_directoryMainPageTest.testPageUi();
    }

    protected void testThumbnails(String account) {
        initDirectoryTestAndLogin(account);
        user_directoryMainPageTest.testThumbnails();
    }

    protected void testLinks(String account) {
        initDirectoryTestAndLogin(account);
        user_directoryMainPageTest.testLinks();
    }

    protected void testShowAllButton(String account) {
        initDirectoryTestAndLogin(account);
        user_directoryMainPageTest.testShowAllButton();
    }

    protected void testCategoriesModal(String account) {
        initDirectoryTestAndLogin(account);
        user_directoryMainPageTest.testCategoriesModal();
    }
}
