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

    @BeforeMethod
    private void beforeMethod() {
        rsl_rrpSearchPageTest = new RSL_RrpSearchPageTest();
        loginPage = new LoginPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        rrp = new Rrp(webDriver);
        resourcesPage = new ResourcesPage(webDriver);
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-1311:LP Resource Modal Overview")
    public void lessonp_1311() {
        rsl_rrpSearchPageTest.initiTest(webDriver);
        rsl_rrpSearchPageTest.testResourcePageOverview(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-1363:LP Resource Static Page Overview")
    public void lessonp_1363() {
        rsl_rrpSearchPageTest.initiTest(webDriver);
        rsl_rrpSearchPageTest.testResourcePageOverview(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-4479:Collection Modal Overview")
    public void lessonp_4479() {
        rsl_rrpSearchPageTest.initiTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionPageOverview(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-4480:Collection Static Page Overview")
    public void lessonp_4480() {
        rsl_rrpSearchPageTest.initiTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionPageOverview(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-4951:Site Specific Resource Modal Overview")
    public void lessonp_4951() {
        testSiteSpecificRrp(false);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-4977:Site Specific Resource Static Page Overview")
    public void lessonp_4977() {
        testSiteSpecificRrp(true);
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-4950:Proprietary Resource Modal Overview")
    public void lessonp_4950() {
        testProprietaryResource(false);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-4979:Proprietary Resource Static Page Overview")
    public void lessonp_4979() {
        testProprietaryResource(true);
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-5569:Folder (HMH/McGraw) Modal Overview")
    public void lessonp_5569() {
        testFolderHmhMcGraw(false);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-5569:Folder (HMH/McGraw) Modal Overview")
    public void lessonp_5570() {
        testFolderHmhMcGraw(true);
    }

    private void testSiteSpecificRrp(boolean inANewTab) {
        rsl_rrpSearchPageTest.initiTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        discoverResourcesPage.loadSearchPageInListView();

        discoverResourcesPage.selectFacetFilter(TestData.FACET_PROVIDERS, TestData.FACET_PROVIDERS_HENRY_COUNTRY_SCHOOLS);
        discoverResourcesPage.clickSeeFullReview(inANewTab);

        Assert.assertEquals(TestData.FACET_PROVIDERS_HENRY_COUNTRY_SCHOOLS, rrp.getResourcePoolName());

        testCommonProperties(inANewTab);
    }

    private void testProprietaryResource(boolean inANewTab) {
        rsl_rrpSearchPageTest.initiTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        discoverResourcesPage.loadSearchPageInListView();

        discoverResourcesPage.selectFacetFilter(TestData.FACET_PROVIDERS, TestData.FACET_PROVIDERS_CRAIRMONT_PRESS);
        resourcesPage.clickSeeFullReview(inANewTab);

        Assert.assertTrue(rrp.isGoToResourceButtonDisplayed());
        Assert.assertTrue(rrp.isAddToFolderDropdownDisplayed());
        Assert.assertTrue(rrp.isFavoriteButtonDisplayed() || rrp.isFavoriteButtonDisabledDisplayed());
        Assert.assertFalse(rrp.isFullReviewDisplayed());
        Assert.assertEquals(rrp.getResourcePoolName(), TestData.FACET_PROVIDERS_CRAIRMONT_PRESS);

        testCommonProperties(inANewTab);
    }

    private void testFolderHmhMcGraw(boolean inANewTab) {
        rsl_rrpSearchPageTest.initiTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        discoverResourcesPage.loadSearchPageInListView();

        discoverResourcesPage.selectFacetFilter(TestData.FACET_PROVIDERS, TestData.FACET_PROVIDERS_MCGRAW_HILL_EDUCATION);
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_CURRICULUM_SETS);
        discoverResourcesPage.clickFolderDetails(inANewTab);

        Assert.assertTrue(rrp.isOpenFolderButtonDisplayed());
        Assert.assertTrue(rrp.isFavoriteButtonDisplayed() || rrp.isFavoriteButtonDisabledDisplayed());

        Assert.assertTrue(rrp.isBreadcrumbsContainerDisplayed());
        Assert.assertEquals(rrp.getResourcePoolName(), TestData.FACET_PROVIDERS_MCGRAW_HILL_EDUCATION);

        testCommonProperties(inANewTab);
    }

    private void testCommonProperties(boolean inANewTab) {
        Assert.assertFalse(rrp.isShareButtonDisplayed());
        Assert.assertTrue(rrp.isReviewerRatingDisplayed());
        Assert.assertFalse(rrp.isAddACommentButtonDisplayed());
        if (!inANewTab) {
            Assert.assertTrue(rrp.isNextButtonDisplayed());
        } else {
            Assert.assertFalse(rrp.isNextButtonDisplayed());
        }
    }
}
