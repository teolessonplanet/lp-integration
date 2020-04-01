import com.lessonplanet.pages.DiscoverResourcesPage;
import com.lessonplanet.pages.LoginPage;
import com.lessonplanet.pages.ResourcesPage;
import com.lessonplanet.pages.Rrp;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_RrpSearchPageTest extends BaseTest {

    private RSL_RrpSearchPageTest rsl_rrpSearchPageTest;
    private LoginPage loginPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private ResourcesPage resourcesPage;
    private Rrp rrp;
    private RRPSearchPageTest rrpSearchPageTest;

    @BeforeMethod
    private void beforeMethod() {
        rsl_rrpSearchPageTest = new RSL_RrpSearchPageTest();
        loginPage = new LoginPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        rrp = new Rrp(webDriver);
        resourcesPage = new ResourcesPage(webDriver);
        rrpSearchPageTest = new RRPSearchPageTest();
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-1311:LP Resource Modal Overview")
    public void lessonp_1311() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testResourcePageOverview(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-1363:LP Resource Static Page Overview")
    public void lessonp_1363() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testResourcePageOverview(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-4479:Collection Modal Overview")
    public void lessonp_4479() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionPageOverview(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-4480:Collection Static Page Overview")
    public void lessonp_4480() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionPageOverview(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-4951:Site Specific Resource Modal Overview")
    public void lessonp_4951() {
        testSiteSpecificRrp(true);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-4977:Site Specific Resource Static Page Overview")
    public void lessonp_4977() {
        testSiteSpecificRrp(false);
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-4950:Proprietary Resource Modal Overview")
    public void lessonp_4950() {
//        testProprietaryResource(false);
        testProprietaryResource(true);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-4979:Proprietary Resource Static Page Overview")
    public void lessonp_4979() {
        testProprietaryResource(false);
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-5569:Folder (HMH/McGraw) Modal Overview")
    public void lessonp_5569() {
        testFolderHmhMcGraw(true);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-5569:Folder (HMH/McGraw) Modal Overview")
    public void lessonp_5570() {
        testFolderHmhMcGraw(false);
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-5661:LP Resource Main Buttons")
    public void lessonp_5661() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testLpMainButtons(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-4955:LP Resource Main Buttons")
    public void lessonp_4955() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testLpMainButtons(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Search page - Rrp Modal - RRP Overview - lessonp-4956:Collection Main Buttons")
    public void lessonp_4956() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionMainButtons(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Search page - Rrp Static - RRP Overview - lessonp-4956:Collection Main Buttons")
    public void lessonp_4982() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionMainButtons(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Search page - Rrp Modal - RRP Overview - lessonp-4953:Site Specific Resource Main Buttons")
    public void lessonp_4953() {
        testSiteSpecificRrpMainButtons(true);
    }

    @Test(description = "Custom SL - Search page - Rrp Modal - RRP Overview - lessonp-4983:Site Specific Resource Main Buttons")
    public void lessonp_4983() {
        testSiteSpecificRrpMainButtons(false);
    }

    @Test(description = "Custom SL - Search page - Rrp Modal - RRP Overview - lessonp-5583:Folder (HMH/McGraw) Main Buttons")
    public void lessonp_5583() {
        testFolderHmhRrpMainButton(true);

    }

    @Test(description = "Custom SL - Search page - Rrp Modal - RRP Overview - lessonp-5595:Folder (HMH/McGraw) Resource Main Buttons")
    public void lessonp_5595() {
        testFolderHmhRrpMainButton(false);
    }

    private void initTestAndLogin(String account) {
        rsl_rrpSearchPageTest.initTest(webDriver);
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        discoverResourcesPage.loadSearchPageInListView();
    }

    private void testSiteSpecificRrp(boolean inModal) {
        initTestAndLogin(TestData.VALID_EMAIL_CSL_HENRY);

        discoverResourcesPage.selectFacetFilter(TestData.FACET_PROVIDERS, TestData.FACET_PROVIDERS_HENRY_COUNTRY_SCHOOLS);
        discoverResourcesPage.clickSeeFullReview(!inModal);
        Assert.assertEquals(TestData.FACET_PROVIDERS_HENRY_COUNTRY_SCHOOLS, rrp.getResourcePoolName());

        testCommonProperties(inModal);
    }

    private void testProprietaryResource(boolean inModal) {
        initTestAndLogin(TestData.VALID_EMAIL_CSL_HENRY);

        discoverResourcesPage.selectFacetFilter(TestData.FACET_PROVIDERS, TestData.FACET_PROVIDERS_CLAIRMONT_PRESS);
        resourcesPage.clickSeeFullReview(!inModal);

        Assert.assertTrue(rrp.isGoToResourceButtonDisplayed());
        Assert.assertTrue(rrp.isAddToFolderDropdownDisplayed());
        Assert.assertTrue(rrp.isFavoriteButtonDisplayed() || rrp.isFavoriteButtonDisabledDisplayed());
        Assert.assertFalse(rrp.isFullReviewDisplayed());
        Assert.assertEquals(rrp.getResourcePoolName(), TestData.FACET_PROVIDERS_CLAIRMONT_PRESS);

        testCommonProperties(inModal);
    }

    private void testFolderHmhMcGraw(boolean inModal) {
        initTestAndLogin(TestData.VALID_EMAIL_CSL_QA_CUSTOM);

        discoverResourcesPage.selectFacetFilter(TestData.FACET_PROVIDERS, TestData.FACET_PROVIDERS_MCGRAW_HILL_EDUCATION);
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_CURRICULUM_SETS);
        discoverResourcesPage.clickFolderDetails(!inModal);

        Assert.assertTrue(rrp.isOpenFolderButtonDisplayed());
        Assert.assertTrue(rrp.isFavoriteButtonDisplayed() || rrp.isFavoriteButtonDisabledDisplayed());

        Assert.assertTrue(rrp.isBreadcrumbsContainerDisplayed());
        Assert.assertEquals(rrp.getResourcePoolName(), TestData.FACET_PROVIDERS_MCGRAW_HILL_EDUCATION);

        testCommonProperties(inModal);
    }

    private void testCommonProperties(boolean inModal) {
        Assert.assertFalse(rrp.isShareButtonDisplayed());
        Assert.assertTrue(rrp.isReviewerRatingDisplayed());
        Assert.assertFalse(rrp.isAddACommentButtonDisplayed());
        if (inModal) {
            Assert.assertTrue(rrp.isNextButtonDisplayed());
        } else {
            Assert.assertFalse(rrp.isNextButtonDisplayed());
        }
    }

    private void testSiteSpecificRrpMainButtons(boolean inModal) {
        initTestAndLogin(TestData.VALID_EMAIL_CSL_HENRY);

        discoverResourcesPage.selectFacetFilter(TestData.FACET_PROVIDERS, TestData.FACET_PROVIDERS_HENRY_COUNTRY_SCHOOLS);
        discoverResourcesPage.clickSeeFullReview(!inModal);
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testRegularResourceRRPOverview(inModal, TestData.VALID_EMAIL_CSL_HENRY);
        if (inModal) {
            Assert.assertTrue(rrp.isNextButtonDisplayed());
        }
        rrpSearchPageTest.testAddToNewCollection(inModal);
    }

    private void testFolderHmhRrpMainButton(boolean inModal) {
        initTestAndLogin(TestData.VALID_EMAIL_CSL_QA_CUSTOM);

        discoverResourcesPage.selectFacetFilter(TestData.FACET_PROVIDERS, TestData.FACET_PROVIDERS_MCGRAW_HILL_EDUCATION);
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_CURRICULUM_SETS);

        discoverResourcesPage.clickFolderDetails(false);

        if (rrp.isFavoriteButtonDisplayed()) {
            rrp.clickOnFavoriteButton();
            Assert.assertEquals(rrp.getNotificationText(), TestData.RESOURCE_ADDED_TO_FAVORITES_MESSAGE);
        } else {
            Assert.assertTrue(rrp.isFavoriteButtonDisabledDisplayed());
        }
        if (inModal) {
            Assert.assertTrue(rrp.isNextButtonDisplayed());
        }
        Assert.assertTrue(rrp.isFolderDetailsDropdownDisplayed());
        Assert.assertTrue(rrp.getNumberOfBreadcrumbsItems() > 0);
        rrp.clickOnBreadcrumbsItem(0);
        Assert.assertEquals(TestData.DISCOVER_RESOURCES_PAGE_PATH, rrp.getPath());
    }
}
