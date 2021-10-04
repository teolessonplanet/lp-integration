import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_HeaderTest extends BaseTest {
    private LoginPage loginPage;
    private Regular_User_HeaderTest headerTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        headerTest = new Regular_User_HeaderTest();
    }

    @Test(description = "Cobb SL - Header - lessonp-5894: Header buttons")
    public void testLessonp_5894() {
        headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        headerTest.testHeaderButtons(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Header - lessonp-5383: Search box")
    public void testLessonp_5383() {
        headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        headerTest.testSearchBoxKeywordFunctionality(TestData.VALID_EMAIL_CSL_COBB);
    }
}
