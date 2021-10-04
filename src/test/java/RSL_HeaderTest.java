import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_HeaderTest extends BaseTest {
    private LoginPage loginPage;
    private Regular_User_HeaderTest headerTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        headerTest = new Regular_User_HeaderTest();
    }

    @Test(description = "Regular SL - Header - lessonp-4619: Header buttons")
    public void testLessonp_4619() {
        headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        headerTest.testHeaderButtons(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Header - lessonp-4144: Search box (keyword functionality)")
    public void testLessonp_4144() {
        headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        headerTest.testSearchBoxKeywordFunctionality(TestData.VALID_EMAIL_RSL_SBCEO);
    }
}
