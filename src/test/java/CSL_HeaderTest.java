import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_HeaderTest extends BaseTest {
    private LoginPage loginPage;
    private Regular_User_HeaderTest headerTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        headerTest = new Regular_User_HeaderTest();
    }

    @Test(description = "Custom SL - Header - lessonp-5793: Header buttons")
    public void testLessonp_5793() {
        headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        headerTest.testHeaderButtons(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Header - lessonp-4176: Search box (keyword functionality)")
    public void testLessonp_4176() {
        headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        headerTest.testSearchBoxKeywordFunctionality(TestData.VALID_EMAIL_CSL_HENRY);
    }
}
