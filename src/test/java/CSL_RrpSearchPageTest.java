import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
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
    private User_RrpSearchPageTest user_rrpSearchPageTest;
    private RrpModal rrpModal;
    private RrpPage rrpPage;
    private CollectionRrp collectionRrp;

    @BeforeMethod(alwaysRun = true)
    private void beforeMethod() {
        rsl_rrpSearchPageTest = new RSL_RrpSearchPageTest();
        loginPage = new LoginPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        rrp = new Rrp(webDriver);
        resourcesPage = new ResourcesPage(webDriver);
        user_rrpSearchPageTest = new User_RrpSearchPageTest();
        rrpModal = new RrpModal(webDriver);
        rrpPage = new RrpPage(webDriver);
        collectionRrp = new CollectionRrp(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-1311:LP Resource Modal Overview", groups = {"csl"})
    public void lessonp_1311() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testResourcePageOverview(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-1363:LP Resource Static Page Overview", groups = {"csl"})
    public void lessonp_1363() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testResourcePageOverview(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-4479:Collection Modal Overview", groups = {"csl"})
    public void lessonp_4479() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionPageOverview(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-4480:Collection Static Page Overview", groups = {"csl"})
    public void lessonp_4480() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionPageOverview(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-4951:Site Specific Resource Modal Overview", groups = {"csl"})
    public void lessonp_4951() {
        testSiteSpecificRrp(true, TestData.VALID_EMAIL_CSL_HENRY, TestData.FACET_PROVIDERS_HENRY_COUNTRY_SCHOOLS);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-4977:Site Specific Resource Static Page Overview", groups = {"csl"})
    public void lessonp_4977() {
        testSiteSpecificRrp(false, TestData.VALID_EMAIL_CSL_HENRY, TestData.FACET_PROVIDERS_HENRY_COUNTRY_SCHOOLS);
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-4950:Proprietary Resource Modal Overview", groups = {"csl"})
    public void lessonp_4950() {
        testProprietaryResource(true, TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-4979:Proprietary Resource Static Page Overview", groups = {"csl"})
    public void lessonp_4979() {
        testProprietaryResource(false, TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-5569:Folder (HMH/McGraw) Modal Overview", groups = {"csl"})
    public void lessonp_5569() {
        testFolderHmhMcGraw(true, TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-5569:Folder (HMH/McGraw) Modal Overview", groups = {"csl"})
    public void lessonp_5570() {
        testFolderHmhMcGraw(false, TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-5661:LP Resource Main Buttons", groups = {"csl"})
    public void lessonp_5661() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testLpMainButtons(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-4955:LP Resource Main Buttons", groups = {"csl"})
    public void lessonp_4955() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testLpMainButtons(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Search page - Rrp Modal - RRP Overview - lessonp-4956:Collection Main Buttons", groups = {"csl"})
    public void lessonp_4956() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionMainButtons(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Search page - Rrp Static - RRP Overview - lessonp-4956:Collection Main Buttons", groups = {"csl"})
    public void lessonp_4982() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionMainButtons(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Search page - Rrp Modal - RRP Overview - lessonp-4953:Site Specific Resource Main Buttons", groups = {"csl"})
    public void lessonp_4953() {
        testSiteSpecificRrpMainButtons(true, TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Search page - Rrp Modal - RRP Overview - lessonp-4983:Site Specific Resource Main Buttons", groups = {"csl"})
    public void lessonp_4983() {
        testSiteSpecificRrpMainButtons(false, TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Search page - Rrp Modal - RRP Overview - lessonp-5583:Folder (HMH/McGraw) Main Buttons", groups = {"csl"})
    public void lessonp_5583() {
        testFolderHmhRrpMainButton(true, TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Search page - Rrp Modal - RRP Overview - lessonp-5595:Folder (HMH/McGraw) Resource Main Buttons", groups = {"csl"})
    public void lessonp_5595() {
        testFolderHmhRrpMainButton(false, TestData.VALID_EMAIL_CSL_HENRY);
    }

    private void initTestAndLogin(String account) {
        rsl_rrpSearchPageTest.initTest(webDriver);
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        discoverResourcesPage.loadSearchPageInListView();
    }

    public void testSiteSpecificRrp(boolean inModal, String account, String provider) {
        initTestAndLogin(account);
        discoverResourcesPage.expandProvidersFacet();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_PROVIDERS, provider);
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_HANDOUTS_REFERENCES);
        discoverResourcesPage.clickSeeFullReview(!inModal);
        if (inModal) {
            rrpModal.waitForModal();
            Assert.assertEquals(provider, rrpModal.getResourcePoolName());
        } else {
            Assert.assertEquals(provider, rrpPage.getResourcePoolName());
        }

        testCommonProperties(inModal, account);
    }

    public void testProprietaryResource(boolean inModal, String account) {
        initTestAndLogin(account);
        discoverResourcesPage.expandProvidersFacet();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_PROVIDERS, TestData.FACET_PROVIDERS_CLAIRMONT_PRESS);
        resourcesPage.clickSeeFullReview(!inModal);

        Assert.assertTrue(rrp.isGoToResourceButtonDisplayed());
        Assert.assertTrue(rrp.isAddToFolderDropdownDisplayed());
        Assert.assertTrue(rrp.isFavoriteButtonDisplayed() || rrp.isFavoriteButtonDisabledDisplayed());
        Assert.assertFalse(rrp.isFullReviewDisplayed());
        Assert.assertEquals(rrp.getResourcePoolName(), TestData.FACET_PROVIDERS_CLAIRMONT_PRESS);

        testCommonProperties(inModal, account);
    }

    public void testFolderHmhMcGraw(boolean inModal, String account) {
        initTestAndLogin(account);
        discoverResourcesPage.expandProvidersFacet();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_PROVIDERS, TestData.FACET_PROVIDERS_MCGRAW_HILL_EDUCATION);
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_CURRICULUM_SETS);
        discoverResourcesPage.clickFolderDetails(!inModal);

        Assert.assertTrue(collectionRrp.isOpenFolderButtonDisplayed());
        Assert.assertTrue(collectionRrp.isFavoriteButtonDisplayed() || rrp.isFavoriteButtonDisabledDisplayed());

        Assert.assertTrue(collectionRrp.isBreadcrumbsContainerDisplayed());
        Assert.assertEquals(collectionRrp.getResourcePoolName(), TestData.FACET_PROVIDERS_MCGRAW_HILL_EDUCATION);

        testCommonProperties(inModal, account);
    }

    private void testCommonProperties(boolean inModal, String account) {
        Assert.assertFalse(rrp.isShareButtonDisplayed());
        if (inModal) {
            Assert.assertTrue(rrp.isNextButtonDisplayed());
        } else {
            Assert.assertFalse(rrp.isNextButtonDisplayed());
        }

        user_rrpSearchPageTest.initTest(webDriver);
        user_rrpSearchPageTest.testEducatorRatingSection(account);
    }

    private void testSiteSpecificRrpMainButtons(boolean inModal, String account) {
        initTestAndLogin(account);
        discoverResourcesPage.expandProvidersFacet();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_PROVIDERS, TestData.FACET_PROVIDERS_HENRY_COUNTRY_SCHOOLS);
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_HANDOUTS_REFERENCES);
        discoverResourcesPage.clickSeeFullReview(!inModal);
        rrpPage.clickOnThumbnail();
        testNewTabSiteSpecificResourceUrl(inModal);

        rrpPage.clickGoToResourceButton(inModal);
        testNewTabSiteSpecificResourceUrl(inModal);

        if (inModal) {
            Assert.assertTrue(rrp.isNextButtonDisplayed());
        }
        user_rrpSearchPageTest.initTest(webDriver);
        user_rrpSearchPageTest.testAddToNewCollection();
    }

    public void testNewTabSiteSpecificResourceUrl(boolean modal) {
        discoverResourcesPage.waitForNewTab();
        discoverResourcesPage.focusDriverToLastTab();
        discoverResourcesPage.waitForLinkToLoad();
        Assert.assertFalse(discoverResourcesPage.getUrl().contains(TestData.SERVER_URL));
        discoverResourcesPage.closeTab();
    }

    private void testFolderHmhRrpMainButton(boolean inModal, String account) {
        initTestAndLogin(account);
        discoverResourcesPage.expandProvidersFacet();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_PROVIDERS, TestData.FACET_PROVIDERS_MCGRAW_HILL_EDUCATION);
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_CURRICULUM_SETS);

        discoverResourcesPage.clickFolderDetails(false);

        if (rrp.isFavoriteButtonDisplayed()) {
            rrp.clickOnFavoriteButton();
            Assert.assertTrue(rrp.getNotificationText().contains(TestData.RESOURCE_ADDED_TO_FAVORITES_NOTIFICATION_TEXT));
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
