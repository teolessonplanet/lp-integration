import com.lessonplanet.pages.DiscoverResourcesPage;
import com.lessonplanet.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_RrpSearchPageTest extends BaseTest {

    private LoginPage loginPage;
    private RRPSearchPageTest rrpSearchPageTest;
    DiscoverResourcesPage discoverResourcesPage;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rrpSearchPageTest = new RRPSearchPageTest();
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
    }

    public void initTest(WebDriver webDriver) {
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
        testCollectionPageOverview(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - Search Page - RRP Static - RRP Overview - lessonp-5563:Unit Module Static Page Overview")
    public void testLessonp_5563() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        rrpSearchPageTest.initTest(webDriver);
        DiscoverResourcesPage discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollectionUnit(true);
        testCollectionPageOverview(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - Search Page - RRP Modal - RRP Overview - lessonp-5145:LP Main Buttons")
    public void testLessonp_5145() {
        testLpMainButtons(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - Search Page - RRP Static - RRP Overview - lessonp-5160:LP Main Buttons")
    public void testLessonp_5160() {
        testLpMainButtons(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - Search Page - RRP Modal - RRP Overview - lessonp-5151:Collection Main Buttons")
    public void testLessonp_5151() {
        testCollectionMainButtons(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - Search Page - RRP Static - RRP Overview - lessonp-5166:Collection Main Buttons")
    public void testLessonp_5166() {
        testCollectionMainButtons(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - Search page - Rrp Modal - RRP Overview - lessonp-5598:Unit Module Main Buttons")
    public void testLessonp_5598() {
        testCollectionUnitMainButtons(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - Search page - Rrp Static - RRP Overview - lessonp-5605:Unit Module Main Buttons")
    public void testLessonp_5605() {
        testCollectionUnitMainButtons(TestData.VALID_EMAIL_RSL_SBCEO, false);
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

    protected void testLpMainButtons(String account, boolean inModal) {
        rrpSearchPageTest.initTest(webDriver);
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        rrpSearchPageTest.initTest(webDriver);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeeFullReview(!inModal);
        rrpSearchPageTest.testLpResourceCommonButtons(inModal, account);
    }

    protected void testCollectionMainButtons(String account, boolean inModal) {
        rrpSearchPageTest.initTest(webDriver);
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        rrpSearchPageTest.testCollectionMainButtons(inModal, account);
    }

    protected void testCollectionUnitMainButtons(String account, boolean inModal) {
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        rrpSearchPageTest.initTest(webDriver);
        DiscoverResourcesPage discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollectionUnit(!inModal);
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testCollectionOrUnitMainButtons(inModal, account);
    }
}
