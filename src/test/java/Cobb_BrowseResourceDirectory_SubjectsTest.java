import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_BrowseResourceDirectory_SubjectsTest extends BaseTest {
    private LoginPage loginPage;
    private RSL_BrowseResourceDirectory_SubjectsTest rsl_BrowseResource_directorySubjectsTest;
    private User_BrowseResourceDirectory_SubjectsTest user_BrowseResource_directorySubjectsTest;

    @BeforeMethod(alwaysRun = true)
    private void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rsl_BrowseResource_directorySubjectsTest = new RSL_BrowseResourceDirectory_SubjectsTest();
        user_BrowseResource_directorySubjectsTest = new User_BrowseResourceDirectory_SubjectsTest();
    }

    @Test(description = "Cobb SL - Browse Resource Directory  - Subjects - C2610: Page UI", groups = {"cobb"})
    public void testC2610() {
        rsl_BrowseResource_directorySubjectsTest.initTest(webDriver);
        rsl_BrowseResource_directorySubjectsTest.testPageUi(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Browse Resource Directory - Subjects - C2611: Resource Tiles", groups = {"cobb"})
    public void testC2611() {
        rsl_BrowseResource_directorySubjectsTest.initTest(webDriver);
        rsl_BrowseResource_directorySubjectsTest.testResourceTiles(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Browse Resource Directory - Subjects - C2612: RRP modal (Individual resources)", groups = {"cobb"})
    public void testC2612() {
        rsl_BrowseResource_directorySubjectsTest.initTest(webDriver);
        rsl_BrowseResource_directorySubjectsTest.testRrpIndividualResource(TestData.VALID_EMAIL_CSL_COBB, false);
    }

    @Test(description = "Cobb SL - Browse Resource Directory - Subjects - C2613: RRP modal (Collections)", groups = {"cobb"})
    public void testC2613() {
        rsl_BrowseResource_directorySubjectsTest.initTest(webDriver);
        rsl_BrowseResource_directorySubjectsTest.testRrpCollection(TestData.VALID_EMAIL_CSL_COBB, false);
    }

    @Test(description = "Cobb SL -Browse Resource  Directory - Subjects - C2614: RRP static (Individual resources)", groups = {"cobb"})
    public void testC2614() {
        rsl_BrowseResource_directorySubjectsTest.initTest(webDriver);
        rsl_BrowseResource_directorySubjectsTest.testRrpIndividualResource(TestData.VALID_EMAIL_CSL_COBB, true);
    }

    @Test(description = "Cobb SL - Browse Resource Directory - Subjects - C2615: RRP static (Collections)", groups = {"cobb"})
    public void testC2615() {
        rsl_BrowseResource_directorySubjectsTest.initTest(webDriver);
        rsl_BrowseResource_directorySubjectsTest.testRrpCollection(TestData.VALID_EMAIL_CSL_COBB, true);
    }

    @Test(description = "Cobb SL - Browse Resource Directory - Subjects - C2616: Browse by Subject", groups = {"cobb"})
    public void testC2616() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        user_BrowseResource_directorySubjectsTest.initTest(webDriver);
        user_BrowseResource_directorySubjectsTest.testBrowseBySubject(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Browse Resource Directory - Subjects - C2617: Related Topics", groups = {"cobb"})
    public void testC2617() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        user_BrowseResource_directorySubjectsTest.initTest(webDriver);
        user_BrowseResource_directorySubjectsTest.testRelatedTopics();
    }
}
