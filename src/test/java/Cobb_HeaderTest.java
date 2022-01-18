import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_HeaderTest extends BaseTest {
    private LoginPage loginPage;
    private User_HeaderTest user_headerTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_headerTest = new User_HeaderTest();
    }

    @Test(description = "Cobb SL - Header - lessonp-5894: Header buttons", groups = {"cobb"})
    public void testLessonp_5894() {
        user_headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        user_headerTest.testHeaderButtons(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Header - lessonp-5383: Search box", groups = {"cobb"})
    public void testLessonp_5383() {
        user_headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        user_headerTest.testSearchBoxKeywordFunctionality(TestData.VALID_EMAIL_CSL_COBB);
    }
}
