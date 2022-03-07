import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_BrowseResourceDirectory_SubjectsTest extends BaseTest {
    private LoginPage loginPage;
    private RSL_BrowseResourceDirectory_SubjectsTest rsl_BrowseResource_directorySubjectsTest;
    private User_BrowseResourceDirectory_SubjectsTest user_BrowseResource_directorySubjectsTest;

    @BeforeMethod(alwaysRun = true)
    private void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rsl_BrowseResource_directorySubjectsTest = new RSL_BrowseResourceDirectory_SubjectsTest();
        user_BrowseResource_directorySubjectsTest = new User_BrowseResourceDirectory_SubjectsTest();
    }

    @Test(description = "Custom SL - Browse Resource Directory - Subjects - C2464: Page UI", groups = {"csl"})
    public void testC2464() {
        rsl_BrowseResource_directorySubjectsTest.initTest(webDriver);
        rsl_BrowseResource_directorySubjectsTest.testPageUi(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Browse Resource Directory - Subjects - C2465: Resource Tiles", groups = {"csl"})
    public void testC2465() {
        rsl_BrowseResource_directorySubjectsTest.initTest(webDriver);
        rsl_BrowseResource_directorySubjectsTest.testResourceTiles(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Browse Resource Directory - Subjects - C2466: RRP modal (Individual resources)", groups = {"csl"})
    public void testC2466() {
        rsl_BrowseResource_directorySubjectsTest.initTest(webDriver);
        rsl_BrowseResource_directorySubjectsTest.testRrpIndividualResource(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Browse Resource Directory - Subjects - C2467: RRP modal (Collections)", groups = {"csl"})
    public void testC2467() {
        rsl_BrowseResource_directorySubjectsTest.initTest(webDriver);
        rsl_BrowseResource_directorySubjectsTest.testRrpCollection(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Browse Resource Directory - Subjects - C2468: RRP static (Individual resources)", groups = {"csl"})
    public void testC2468() {
        rsl_BrowseResource_directorySubjectsTest.initTest(webDriver);
        rsl_BrowseResource_directorySubjectsTest.testRrpIndividualResource(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Browse Resource Directory - Subjects - C2469: RRP static (Collections)", groups = {"csl"})
    public void testC2469() {
        rsl_BrowseResource_directorySubjectsTest.initTest(webDriver);
        rsl_BrowseResource_directorySubjectsTest.testRrpCollection(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Browse Resource Directory - Subjects - C2470: Browse by Subject", groups = {"csl"})
    public void testC2470() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_BrowseResource_directorySubjectsTest.initTest(webDriver);
        user_BrowseResource_directorySubjectsTest.testBrowseBySubject(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Browse Resource Directory - Subjects - C2471: Related Topics", groups = {"csl"})
    public void testC2471() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_BrowseResource_directorySubjectsTest.initTest(webDriver);
        user_BrowseResource_directorySubjectsTest.testRelatedTopics();
    }
}