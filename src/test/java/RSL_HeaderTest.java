import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_HeaderTest extends BaseTest {
    private LoginPage loginPage;
    private User_HeaderTest user_headerTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_headerTest = new User_HeaderTest();
    }

    @Test(description = "Regular SL - Header - C2376: Header buttons", groups = {"rsl"})
    public void testC2376() {
        user_headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_headerTest.testHeaderButtons(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Header - C2377: Search box (keyword functionality)", groups = {"rsl"})
    public void testC2377() {
        user_headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_headerTest.testSearchBoxKeywordFunctionality(TestData.VALID_EMAIL_RSL_SBCEO);
    }
}
