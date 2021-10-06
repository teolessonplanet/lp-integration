import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_RrpDirectoryPageTest extends BaseTest {
    private LoginPage loginPage;
    private User_RrpDirectoryPageTest user_rrpDirectoryPageTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_rrpDirectoryPageTest = new User_RrpDirectoryPageTest();
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_rrpDirectoryPageTest.initTest(webDriver);
    }

    @Test(description = "Regular SL - Directory Page - Rrp Modal - lessonp-5191:Resource Modal Overview")
    public void testLessonp_5191() {
        user_rrpDirectoryPageTest.testLpResourceOverview(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - Directory Page - Rrp Static - lessonp-5212:Resource Static Page Overview")
    public void testLessonp_5212() {
        user_rrpDirectoryPageTest.testLpResourceOverview(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - Directory Page - Rrp Modal - lessonp-5192:Collection Modal Overview")
    public void testLessonp_5192() {
        user_rrpDirectoryPageTest.testCollectionOverview(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - Directory Page - Rrp Modal - lessonp-5213:Collection Static Page Overview")
    public void testLessonp_5213() {
        user_rrpDirectoryPageTest.testCollectionOverview(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - Directory Page - Rrp Modal - lessonp-5625:LP Resources Main Buttons")
    public void testLessonp_5625() {
        user_rrpDirectoryPageTest.testLpResourceMainButtonsForActiveUser(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - Directory Page - Rrp Static - lessonp-5631:LP Resources Main Buttons")
    public void testLessonp_5631() {
        user_rrpDirectoryPageTest.testLpResourceMainButtonsForActiveUser(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - Directory Page - Rrp Modal - lessonp-5624:Collection Main Buttons")
    public void testLessonp_5624() {
        user_rrpDirectoryPageTest.testLpResourceMainButtonsForActiveUser(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - Directory Page - Rrp Static - lessonp-5630:Collection Main Buttons")
    public void testLessonp_5630() {
        user_rrpDirectoryPageTest.testLpResourceMainButtonsForActiveUser(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }
}
