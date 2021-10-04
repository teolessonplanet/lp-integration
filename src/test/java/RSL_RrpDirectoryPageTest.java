import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_RrpDirectoryPageTest extends BaseTest {
    private LoginPage loginPage;
    private Regular_User_RrpDirectoryPageTest rrpDirectoryPageTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rrpDirectoryPageTest = new Regular_User_RrpDirectoryPageTest();
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        rrpDirectoryPageTest.initTest(webDriver);
    }

    @Test(description = "Regular SL - Directory Page - Rrp Modal - lessonp-5191:Resource Modal Overview")
    public void testLessonp_5191() {
        rrpDirectoryPageTest.testLpResourceOverview(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - Directory Page - Rrp Static - lessonp-5212:Resource Static Page Overview")
    public void testLessonp_5212() {
        rrpDirectoryPageTest.testLpResourceOverview(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - Directory Page - Rrp Modal - lessonp-5192:Collection Modal Overview")
    public void testLessonp_5192() {
        rrpDirectoryPageTest.testCollectionOverview(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - Directory Page - Rrp Modal - lessonp-5213:Collection Static Page Overview")
    public void testLessonp_5213() {
        rrpDirectoryPageTest.testCollectionOverview(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - Directory Page - Rrp Modal - lessonp-5625:LP Resources Main Buttons")
    public void testLessonp_5625() {
        rrpDirectoryPageTest.testLpResourceMainButtonsForActiveUser(TestData.VALID_EMAIL_RSL_SBCEO,true);
    }

    @Test(description = "Regular SL - Directory Page - Rrp Static - lessonp-5631:LP Resources Main Buttons")
    public void testLessonp_5631() {
        rrpDirectoryPageTest.testLpResourceMainButtonsForActiveUser(TestData.VALID_EMAIL_RSL_SBCEO,false);
    }

    @Test(description = "Regular SL - Directory Page - Rrp Modal - lessonp-5624:Collection Main Buttons")
    public void testLessonp_5624() {
        rrpDirectoryPageTest.testLpResourceMainButtonsForActiveUser(TestData.VALID_EMAIL_RSL_SBCEO,true);
    }

    @Test(description = "Regular SL - Directory Page - Rrp Static - lessonp-5630:Collection Main Buttons")
    public void testLessonp_5630() {
        rrpDirectoryPageTest.testLpResourceMainButtonsForActiveUser(TestData.VALID_EMAIL_RSL_SBCEO,false);
    }
}
