import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_RrpDirectoryPageTest extends BaseTest {
    private LoginPage loginPage;
    private User_RrpDirectoryPageTest user_rrpDirectoryPageTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_rrpDirectoryPageTest = new User_RrpDirectoryPageTest();
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_rrpDirectoryPageTest.initTest(webDriver);
    }

    @Test(description = "Regular SL - RRP Directory - Rrp Modal - C2418: Resource Modal Overview", groups = {"rsl"})
    public void testC2418() {
        user_rrpDirectoryPageTest.testLpResourceOverview(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - RRP Directory - Rrp Static - C2422: Resource Static Page Overview", groups = {"rsl"})
    public void testC2422() {
        user_rrpDirectoryPageTest.testLpResourceOverview(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - RRP Directory - Rrp Modal - C2417: Collection Modal Overview", groups = {"rsl"})
    public void testC2417() {
        user_rrpDirectoryPageTest.testCollectionOverview(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - RRP Directory - Rrp Modal - C2421: Collection Static Page Overview", groups = {"rsl"})
    public void testC2421() {
        user_rrpDirectoryPageTest.testCollectionOverview(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - RRP Directory - Rrp Modal - C2419: LP Resources Main Buttons", groups = {"rsl"})
    public void testC2419() {
        user_rrpDirectoryPageTest.testLpResourceMainButtonsForActiveUser(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - RRP Directory - Rrp Static - C2423: LP Resources Main Buttons", groups = {"rsl"})
    public void testC2423() {
        user_rrpDirectoryPageTest.testLpResourceMainButtonsForActiveUser(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - RRP Directory - Rrp Modal - C2429: Collection Main Buttons", groups = {"rsl"})
    public void testC2429() {
        user_rrpDirectoryPageTest.testLpResourceMainButtonsForActiveUser(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - RRP Directory - Rrp Static - C2424: Collection Main Buttons", groups = {"rsl"})
    public void testC2424() {
        user_rrpDirectoryPageTest.testLpResourceMainButtonsForActiveUser(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }
}
