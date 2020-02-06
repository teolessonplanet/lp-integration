import com.lessonplanet.pages.DiscoverResourcesPage;
import com.lessonplanet.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_RrpSearchPageTest extends BaseTest {

    private LoginPage loginPage;
    private RRPSearchPageTest rrpSearchPageTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rrpSearchPageTest = new RRPSearchPageTest();
    }

    public void initiTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Regular SL - Search Page - RRP Static - RRP Overview - lessonp-5158:Resource Static Page Overview")
    public void testLessonp_5158() {
        rrpSearchPageTest.initTest(webDriver);
        testResourcePageOverview(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - Search Page - RRP Modal - RRP Overview - lessonp-5143:Resource Modal Overview")
    public void testLessonp_5143() {
        rrpSearchPageTest.initTest(webDriver);
        testResourcePageOverview(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - Search Page - RRP Static - RRP Overview - lessonp-5159:Collection Static Page Overview")
    public void testLessonp_5159() {
        rrpSearchPageTest.initTest(webDriver);
        testCollectionPageOverview(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - Search Page - RRP Modal - RRP Overview - lessonp-5144:Collection Modal Overview")
    public void testLessonp_5144() {
        rrpSearchPageTest.initTest(webDriver);
        testCollectionPageOverview(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - Search Page - RRP Modal - RRP Overview - lessonp-5562:Unit Module Modal Overview")
    public void testLessonp_5562() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        rrpSearchPageTest.initTest(webDriver);
        DiscoverResourcesPage discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollectionUnit(false);
        testCollectionPageOverview(TestData.VALID_EMAIL_RSL_SBCEO,false);
    }

    @Test(description = "Regular SL - Search Page - RRP Static - RRP Overview - lessonp-5563:Unit Module Static Page Overview")
    public void testLessonp_5563() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        rrpSearchPageTest.initTest(webDriver);
        DiscoverResourcesPage discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollectionUnit(true);
        testCollectionPageOverview(TestData.VALID_EMAIL_RSL_SBCEO,true);
    }

    protected void testResourcePageOverview(String account, boolean inModal) {
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testResourcePageOverview(account, inModal);
    }

    protected void testCollectionPageOverview(String account, boolean inModal) {
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testCollectionStaticPageOverview(account, inModal);
    }
}
