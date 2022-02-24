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

    @Test(description = "Custom SL - RRP Search - RRP Modal - RRP Overview - C2522:LP Resource Modal Overview", groups = {"csl"})
    public void testC2522() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testResourcePageOverview(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - RRP Search - RRP Static - RRP Overview - C2513:LP Resource Static Page Overview", groups = {"csl"})
    public void testC2513() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testResourcePageOverview(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - RRP Search - RRP Modal - RRP Overview - C2523:Collection Modal Overview", groups = {"csl"})
    public void testC2523() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionPageOverview(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - RRP Search - RRP Static - RRP Overview - C2514:Collection Static Page Overview", groups = {"csl"})
    public void testC2514() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionPageOverview(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - RRP Search - RRP Modal - RRP Overview - C2521:Site Specific Resource Modal Overview", groups = {"csl"})
    public void testC2521() {
        testSiteSpecificRrp(true, TestData.VALID_EMAIL_CSL_HENRY, TestData.FACET_PROVIDERS_HENRY_COUNTRY_SCHOOLS);
    }

    @Test(description = "Custom SL - RRP Search - RRP Static - RRP Overview - C2512:Site Specific Resource Static Page Overview", groups = {"csl"})
    public void testC2512() {
        testSiteSpecificRrp(false, TestData.VALID_EMAIL_CSL_HENRY, TestData.FACET_PROVIDERS_HENRY_COUNTRY_SCHOOLS);
    }

    @Test(description = "Custom SL - RRP Search - RRP Modal - RRP Overview - C2520:Proprietary Resource Modal Overview", groups = {"csl"})
    public void testC2520() {
        testProprietaryResource(true, TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - RRP Search - RRP Static - RRP Overview - C2511:Proprietary Resource Static Page Overview", groups = {"csl"})
    public void testC2511() {
        testProprietaryResource(false, TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - RRP Search - RRP Modal - RRP Overview - C2519:Folder (HMH/McGraw) Modal Overview", groups = {"csl"})
    public void testC2519() {
        testFolderHmhMcGraw(true, TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - RRP Search - RRP Static - RRP Overview - C2510:Folder (HMH/McGraw) Modal Overview", groups = {"csl"})
    public void testC2510() {
        testFolderHmhMcGraw(false, TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - RRP Search - RRP Modal - RRP Overview - C2527:LP Resource Main Buttons", groups = {"csl"})
    public void testC2527() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testLpMainButtons(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - RRP Search - RRP Static - RRP Overview - C2518:LP Resource Main Buttons", groups = {"csl"})
    public void testC2518() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testLpMainButtons(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - RRP Search - Rrp Modal - RRP Overview - C2526:Collection Main Buttons", groups = {"csl"})
    public void testC2526() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionMainButtons(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - RRP Search - Rrp Static - RRP Overview -C2517:Collection Main Buttons", groups = {"csl"})
    public void testC2517() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionMainButtons(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - RRP Search - Rrp Modal - RRP Overview - C2525:Site Specific Resource Main Buttons", groups = {"csl"})
    public void testC2525() {
        testSiteSpecificRrpMainButtons(true, TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - RRP Search - Rrp Modal - RRP Overview - C2516:Site Specific Resource Main Buttons", groups = {"csl"})
    public void testC2516() {
        testSiteSpecificRrpMainButtons(false, TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - RRP Search - Rrp Modal - RRP Overview - C2524:Folder (HMH/McGraw) Main Buttons", groups = {"csl"})
    public void testC2524() {
        testFolderHmhRrpMainButton(true, TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - RRP Search - Rrp Modal - RRP Overview - C2515:Folder (HMH/McGraw) Resource Main Buttons", groups = {"csl"})
    public void testC2515() {
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
