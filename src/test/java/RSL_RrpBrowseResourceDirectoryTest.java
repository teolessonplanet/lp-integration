import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_RrpBrowseResourceDirectoryTest extends BaseTest {
    private LoginPage loginPage;
    private User_RrpBrowseResourceDirectoryTest user_rrpBrowseResourceDirectoryTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_rrpBrowseResourceDirectoryTest = new User_RrpBrowseResourceDirectoryTest();
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_rrpBrowseResourceDirectoryTest.initTest(webDriver);
    }

    @Test(description = "Regular SL - RRP Browse Resource Directory - Rrp Modal - C2418: Resource Modal Overview", groups = {"rsl"})
    public void testC2418() {
        user_rrpBrowseResourceDirectoryTest.testLpResourceOverview(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - RRP Browse Resource Directory - Rrp Static - C2422: Resource Static Page Overview", groups = {"rsl"})
    public void testC2422() {
        user_rrpBrowseResourceDirectoryTest.testLpResourceOverview(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - RRP Browse Resource Directory - Rrp Modal - C2417: Collection Modal Overview", groups = {"rsl"})
    public void testC2417() {
        user_rrpBrowseResourceDirectoryTest.testCollectionOverview(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - RRP Browse Resource Directory - Rrp Modal - C2421: Collection Static Page Overview", groups = {"rsl"})
    public void testC2421() {
        user_rrpBrowseResourceDirectoryTest.testCollectionOverview(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - RRP Browse Resource Directory - Rrp Modal - C2419: LP Resources Main Buttons", groups = {"rsl"})
    public void testC2419() {
        user_rrpBrowseResourceDirectoryTest.testLpResourceMainButtonsForActiveUser(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - RRP Browse Resource Directory - Rrp Static - C2423: LP Resources Main Buttons", groups = {"rsl"})
    public void testC2423() {
        user_rrpBrowseResourceDirectoryTest.testLpResourceMainButtonsForActiveUser(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - RRP Browse Resource Directory - Rrp Modal - C2429: Collection Main Buttons", groups = {"rsl"})
    public void testC2429() {
        user_rrpBrowseResourceDirectoryTest.testLpResourceMainButtonsForActiveUser(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - RRP Browse Resource Directory - Rrp Static - C2424: Collection Main Buttons", groups = {"rsl"})
    public void testC2424() {
        user_rrpBrowseResourceDirectoryTest.testLpResourceMainButtonsForActiveUser(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }
}
