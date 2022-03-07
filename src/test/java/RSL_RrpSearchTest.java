import com.lessonplanet.pages.DiscoverResourcesPage;
import com.lessonplanet.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_RrpSearchTest extends BaseTest {

    private LoginPage loginPage;
    private User_RrpSearchTest user_rrpSearchTest;
    DiscoverResourcesPage discoverResourcesPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_rrpSearchTest = new User_RrpSearchTest();
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Regular SL - RRP Search - RRP Static - RRP Overview - C2394: Resource Static Page Overview", groups = {"rsl"})
    public void testC2394() {
        user_rrpSearchTest.initTest(webDriver);
        testResourcePageOverview(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - RRP Search- RRP Modal - RRP Overview - C2391: Resource Modal Overview", groups = {"rsl"})
    public void testC2391() {
        user_rrpSearchTest.initTest(webDriver);
        testResourcePageOverview(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - RRP Search - RRP Static - RRP Overview - C2395: Collection Static Page Overview", groups = {"rsl"})
    public void testC2395() {
        user_rrpSearchTest.initTest(webDriver);
        testCollectionPageOverview(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - RRP Search - RRP Modal - RRP Overview - C2392: Collection Modal Overview", groups = {"rsl"})
    public void testC2392() {
        user_rrpSearchTest.initTest(webDriver);
        testCollectionPageOverview(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - RRP Search - RRP Modal - RRP Overview - C2393: Unit Module Modal Overview", groups = {"rsl"})
    public void testC2393() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_rrpSearchTest.initTest(webDriver);
        DiscoverResourcesPage discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollectionUnit(false);
        user_rrpSearchTest.testCollectionRRPOverview(true, TestData.VALID_EMAIL_RSL_SBCEO);
        user_rrpSearchTest.testPanelItemsOverview();
    }

    @Test(description = "Regular SL - RRP Search - RRP Static - RRP Overview - C2396: Unit Module Static Page Overview", groups = {"rsl"})
    public void testC2396() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_rrpSearchTest.initTest(webDriver);
        DiscoverResourcesPage discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollectionUnit(true);
        user_rrpSearchTest.testCollectionRRPOverview(false, TestData.VALID_EMAIL_RSL_SBCEO);
        user_rrpSearchTest.testPanelItemsOverview();
    }

    @Test(description = "Regular SL - RRP Search - RRP Modal - RRP Overview - C2385: LP Main Buttons", groups = {"rsl"})
    public void testC2385() {
        testLpMainButtons(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - RRP Search - RRP Static - RRP Overview - C2388: LP Main Buttons", groups = {"rsl"})
    public void testC2388() {
        testLpMainButtons(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - RRP Search - RRP Modal - RRP Overview - C2386: Collection Main Buttons", groups = {"rsl"})
    public void testC2386() {
        testCollectionMainButtons(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - RRP Search - RRP Static - RRP Overview - C2389: Collection Main Buttons", groups = {"rsl"})
    public void testC2389() {
        testCollectionMainButtons(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - RRP Search - Rrp Modal - RRP Overview - C2387: Unit Module Main Buttons", groups = {"rsl"})
    public void testC2387() {
        testCollectionUnitMainButtons(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - RRP Search- Rrp Static - RRP Overview - C2390: Unit Module Main Buttons", groups = {"rsl"})
    public void testC2390() {
        testCollectionUnitMainButtons(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    protected void testResourcePageOverview(String account, boolean inModal) {
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        user_rrpSearchTest.initTest(webDriver);
        user_rrpSearchTest.testResourcePageOverview(account, inModal);
    }

    protected void testCollectionPageOverview(String account, boolean inModal) {
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        user_rrpSearchTest.initTest(webDriver);
        user_rrpSearchTest.testCollectionStaticPageOverview(account, inModal);
    }

    protected void testLpMainButtons(String account, boolean inModal) {
        user_rrpSearchTest.initTest(webDriver);
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        user_rrpSearchTest.initTest(webDriver);
        discoverResourcesPage.loadSearchPageInListView();
        if (account.equals(TestData.VALID_EMAIL_CSL_HENRY)) {
            discoverResourcesPage.expandProvidersFacet();
        }
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeeFullReview(!inModal);
        user_rrpSearchTest.testLpResourceCommonButtons(inModal, account);
    }

    protected void testCollectionMainButtons(String account, boolean inModal) {
        user_rrpSearchTest.initTest(webDriver);
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        user_rrpSearchTest.testCollectionMainButtons(inModal, account);
    }

    protected void testCollectionUnitMainButtons(String account, boolean inModal) {
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        user_rrpSearchTest.initTest(webDriver);
        DiscoverResourcesPage discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollectionUnit(!inModal);
        user_rrpSearchTest.initTest(webDriver);
        user_rrpSearchTest.testCollectionOrUnitMainButtons(inModal, account);
    }
}
