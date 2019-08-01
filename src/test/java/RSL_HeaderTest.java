import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_HeaderTest extends BaseTest {
    private LoginPage loginPage;
    private HeaderTest headerTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        headerTest = new HeaderTest();
    }

    @Test(description = "Regular SL - Header - lessonp-4619: Header buttons")
    public void testLessonp_4619() {
        headerTest.initTest(webDriver);
        headerTest.testHeaderButtons(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE);
    }

    @Test(description = "Regular SL - Header - lessonp-4144: Search box (keyword functionality)")
    public void testLessonp_4144() {
        headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        headerTest.testSearchBoxKeywordFunctionality(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE);
    }
}
