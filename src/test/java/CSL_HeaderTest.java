import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_HeaderTest extends BaseTest {
    private LoginPage loginPage;
    private User_HeaderTest user_headerTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_headerTest = new User_HeaderTest();
    }

    @Test(description = "Custom SL - Header - C2479: Header buttons", groups = {"csl"})
    public void testC2479() {
        user_headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_headerTest.testHeaderButtons(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Header - C2480: Search box (keyword functionality)", groups = {"csl"})
    public void testC2480() {
        user_headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_headerTest.testSearchBoxKeywordFunctionality(TestData.VALID_EMAIL_CSL_HENRY);
    }
}
