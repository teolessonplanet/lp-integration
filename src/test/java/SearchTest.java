import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class SearchTest extends BaseTest {

    private LpHomePage lpHomePage;
    private DiscoverResourcesPage discoverResourcesPage;
    private RrpPage rrpPage;
    private RrpModal rrpModal;
    private StepOnePage stepOnePage;
    private StepOneModal stepOneModal;
    private StepTwoPage stepTwoPage;
    private StepTwoModal stepTwoModal;
    private CollectionRrpPage collectionRrpPage;
    private CollectionRrpModal collectionRrpModal;
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        rrpPage = new RrpPage(webDriver);
        rrpModal = new RrpModal(webDriver);
        stepOnePage = new StepOnePage(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        stepTwoModal = new StepTwoModal(webDriver);
        collectionRrpPage = new CollectionRrpPage(webDriver);
        collectionRrpModal = new CollectionRrpModal(webDriver);
        loginPage = new LoginPage(webDriver);
    }

    @Test(description = "LP - Regression Tests - Visitor - Search Page - lessonp-494:Keyword search")
    public void testLessonp_494() {
        lpHomePage.loadPage();
        lpHomePage.typeSearchText(TestData.INVALID_SEARCH_WORD);
        lpHomePage.clickOnSearch();
        Assert.assertEquals(TestData.INVALID_SEARCH_MESSAGE, discoverResourcesPage.getSearchMessage());
        Assert.assertTrue(discoverResourcesPage.isSuggestionBlockTextDisplayed());
        Assert.assertEquals(TestData.SUGGESTIONS_BLOCK_MESSAGE, discoverResourcesPage.getSuggestionsBlockText());

        lpHomePage.loadPage();
        lpHomePage.typeSearchText(TestData.VALID_SEARCH_WORD);
        lpHomePage.clickOnSearch();
        Assert.assertTrue(TestData.ZERO_RESOURCES_FOUND < discoverResourcesPage.getTotalResults());
        Assert.assertFalse(discoverResourcesPage.isSuggestionBlockTextDisplayed());
    }

    @Test(description = "LP - Regression Tests - Visitor - Search Page - lessonp-493:Keywordless search")
    public void testLessonp_493() {
        lpHomePage.loadPage();
        lpHomePage.clickOnSearch();
        Assert.assertFalse(discoverResourcesPage.isSuggestionBlockTextDisplayed());
        Assert.assertEquals(TestData.SHOWING_ALL_REVIEWED_RESROUCES_MESSAGE, discoverResourcesPage.getSearchMessage());
        Assert.assertEquals(TestData.TOTAL_RESOURCES_PER_PAGE, discoverResourcesPage.getCountResourcesInThumbnailMode());
    }

    @Test(description = "LP - Regression Tests - Visitor - Search Page - lessonp-487:Cards layout")
    public void testLessonp_487() {
        lpHomePage.loadPage();
        lpHomePage.clickOnSearch();
        Assert.assertEquals(discoverResourcesPage.getCountResourcesInThumbnailMode(), TestData.TOTAL_RESOURCES_PER_PAGE);
        discoverResourcesPage.clickOnTiledView();
        Assert.assertEquals(discoverResourcesPage.getCountResourcesInTiledMode(), TestData.TOTAL_RESOURCES_PER_PAGE);
        discoverResourcesPage.clickOnListView();
        Assert.assertEquals(discoverResourcesPage.getCountResourcesInListMode(), TestData.TOTAL_RESOURCES_PER_PAGE);
        discoverResourcesPage.clickThumbnailView();
        Assert.assertEquals(discoverResourcesPage.getCountResourcesInThumbnailMode(), TestData.TOTAL_RESOURCES_PER_PAGE);
    }

    @Test(description = "LP - Regression Tests - Visitor - Search Page - lessonp-489:User clicks result card")
    public void testLessonp_489() {
        testUserClicksResultCard(TestData.INVALID_EMAIL);
    }

    @Test(description = "LP - Regression Tests - Freemium - Search Page - lessonp-503:User clicks result card")
    public void testLessonp_503() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testUserClicksResultCard(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "LP - Regression Tests - Active user - Search Page - lessonp-601:User clicks result card")
    public void testLessonp_601() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testUserClicksResultCard(TestData.VALID_EMAIL_ADMIN);
    }

    @Test(description = "LP - Regression Tests - Visitor - Search Page - lessonp-491:User clicks 'See Review' footer button (LP resource)")
    public void testLessonp_491() {
        testSeeReviewButton();
    }

    @Test(description = "LP - Regression Tests - Freemium - Search Page - lessonp-505:User clicks 'See Review' footer button (LP resource)")
    public void testLessonp_505() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testSeeReviewButton();
    }

    @Test(description = "LP - Regression Tests - Visitor - Search Page - lessonp-490:User clicks 'Get Free Access' footer button")
    public void testLessonp_490() {
        reachSearchPageInListView();
        discoverResourcesPage.clickGetFreeAccess(true);
        Assert.assertTrue(stepOnePage.isAlreadyAMemberButtonDisplayed());
        discoverResourcesPage.closeTab();
        discoverResourcesPage.clickGetFreeAccess(false);
        Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
        stepOneModal.clickCloseModal();
    }

    @Test(description = "LP - Regression Tests - Freemium - Search Page - lessonp-504:User clicks 'Get Free Access' footer button")
    public void testLessonp_504() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        reachSearchPageInListView();
        discoverResourcesPage.clickGetFreeAccess(true);
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
        discoverResourcesPage.closeTab();
        discoverResourcesPage.clickGetFreeAccess(false);
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoModal.getTitleText());
    }

    @Test(description = "LP - Regression Tests - Visitor - Search Page - 996:User clicks 'See Preview' footer button (Shared resource)")
    public void testLessonp_996() {
        reachSearchPageInListView();
        testSeePreviewButton();
    }

    @Test(description = "LP - Regression Tests - Freemium - Search Page - 998:User clicks 'See Preview' footer button (Shared resource)")
    public void testLessonp_998() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testSeePreviewButton();
    }

    @Test(description = "LP - Regression Tests - Active user - Search Page - 603:User clicks 'See Preview' footer button (Shared resource)")
    public void testLessonp_603() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testSeePreviewButton();
    }

    @Test(description = "LP - Regression Tests - Visitor - Search Page - 997:User clicks 'Go to Resource' footer button (Shared resource)")
    public void testLessonp_997() {
        testGoToResourceButtonForSharedResource();
    }

    @Test(description = "LP - Regression Tests - Freemium - Search Page - 999:User clicks 'Go to Resource' footer button (Shared resource)")
    public void testLessonp_999() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testGoToResourceButtonForSharedResource();
    }

    @Test(description = "LP - Regression Tests - Active user - Search Page - 602:User clicks 'Go to Resource' footer button (Shared/regular resource)")
    public void testLessonp_602() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testGoToResourceButtonForSharedResource();
        testGoToResourceButtonForRegularResource();
    }

    @Test(description = "LP - Regression Tests - Visitor - Search Page - 492:User clicks 'See Collection' footer button (Collection)")
    public void testLessonp_492() {
        testSeeCollection();
    }

    @Test(description = "LP - Regression Tests - Freemium - Search Page - 507:User clicks 'See Collection' footer button (Collection)")
    public void testLessonp_507() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testSeeCollection();
    }

    @Test(description = "LP - Regression Tests - Active user - Search Page - 605:User clicks 'See Collection' footer button (Collection)")
    public void testLessonp_605() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testSeeCollection();
    }

    @Test(description = "LP - Regression Tests - Freemium - Search Page - 506:User clicks 'Free: Full Access Review' footer button")
    public void testLessonp_506() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        reachSearchPageInListView();
        discoverResourcesPage.clickFreeFullAccessReview(true);
        rrpModal.waitForModal();
        checkRrpSample(false, true, false);
        rrpPage.closeTab();
        discoverResourcesPage.clickFreeFullAccessReview(false);
        rrpModal.waitForModal();
        checkRrpSample(false, true, false);
    }

    @Test(description = "LP - Regression Tests - Active user - Search Page - 604:User clicks 'See Full Review' footer button")
    public void testLessonp_604() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        reachSearchPageInListView();
        discoverResourcesPage.clickSeeFullReview(true);
        rrpModal.waitForModal();
        checkRrpSample(false, false, true);
        rrpPage.closeTab();
        discoverResourcesPage.clickSeeFullReview(false);
        rrpModal.waitForModal();
        checkRrpSample(false, false, true);
    }

    private void testSeeCollection() {
        reachSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        Assert.assertTrue(collectionRrpPage.isSaveCollectionButtonDisplayed());
        rrpPage.closeTab();
        discoverResourcesPage.clickSeeCollection(false);
        Assert.assertTrue(collectionRrpModal.isCollectionTitleDisplayed());
    }

    private void reachSearchPageInListView() {
        lpHomePage.loadPage();
        lpHomePage.clickOnSearch();
        discoverResourcesPage.clickOnListView();
    }

    private void testUserClicksResultCard(String account) {
        reachSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        rrpModal.waitForModal();
        Assert.assertTrue(rrpModal.isTitleDisplayed());
        if (account.equals(TestData.INVALID_EMAIL) || account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
            checkRrpSample(true, false, false);
            if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
                //check free resource
                discoverResourcesPage.loadPage();
                discoverResourcesPage.clickFreeFullAccessReview(false);
                rrpModal.waitForModal();
                checkRrpSample(false, true, false);
            }
        } else {
            checkRrpSample(false, false, true);
        }
        discoverResourcesPage.loadPage();
        discoverResourcesPage.clickSeePreview(false);
        rrpModal.waitForModal();
        Assert.assertTrue(rrpModal.isTitleDisplayed());
        Assert.assertTrue(rrpModal.isGoToResourceButtonDisplayed());
        discoverResourcesPage.loadPage();
        discoverResourcesPage.clickSeeCollection(false);
        Assert.assertTrue(collectionRrpModal.isCollectionTitleDisplayed());
    }

    private void testSeeReviewButton() {
        reachSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        rrpModal.waitForModal();
        Assert.assertTrue(rrpPage.isTitleDisplayed());
        checkRrpSample(true, false, false);
        discoverResourcesPage.closeTab();
        discoverResourcesPage.clickSeeReview(false);
        Assert.assertTrue(rrpModal.isTitleDisplayed());
        checkRrpSample(true, false, false);
        rrpModal.clickCloseModal();
    }

    private void testSeePreviewButton() {
        reachSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        rrpModal.waitForModal();
        Assert.assertTrue(rrpPage.isGoToResourceButtonDisplayed());
        discoverResourcesPage.closeTab();
        discoverResourcesPage.clickSeePreview(false);
        rrpModal.waitForModal();
        Assert.assertTrue(rrpModal.isGoToResourceButtonDisplayed());
        rrpModal.clickCloseModal();
    }

    private void testGoToResourceButtonForSharedResource() {
        reachSearchPageInListView();
        discoverResourcesPage.clickGoToResourceForSharedResource(true);
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.STAGING_SERVER_SHARED_RESOURCE_URL));
        discoverResourcesPage.closeTab();
        discoverResourcesPage.clickGoToResourceForSharedResource(false);
        discoverResourcesPage.waitForNewTab();
        discoverResourcesPage.focusDriverToLastTab();
        discoverResourcesPage.waitForLinkToLoad();
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.STAGING_SERVER_SHARED_RESOURCE_URL));
        discoverResourcesPage.closeTab();
    }

    private void testGoToResourceButtonForRegularResource() {
        discoverResourcesPage.clickGoToResourceForRegularResource(true);
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.STAGING_SERVER_SHARED_RESOURCE_URL_2));
        discoverResourcesPage.closeTab();
        discoverResourcesPage.clickGoToResourceForRegularResource(false);
        discoverResourcesPage.waitForNewTab();
        discoverResourcesPage.focusDriverToLastTab();
        discoverResourcesPage.waitForLinkToLoad();
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.STAGING_SERVER_SHARED_RESOURCE_URL_2));
    }

    private void checkRrpSample(boolean limitedAccess, boolean freeSample, boolean fullReview) {
        if (limitedAccess) {
            Assert.assertTrue(rrpModal.isLimitedAccessReviewDisplayed());
        } else {
            Assert.assertFalse(rrpModal.isLimitedAccessReviewDisplayed());
        }
        if (freeSample) {
            Assert.assertTrue((rrpModal.isFreeSampleDisplayed()));
        } else {
            Assert.assertFalse(rrpModal.isFreeSampleDisplayed());
        }
        if (fullReview) {
            Assert.assertTrue(rrpModal.isFullReviewDisplayed());
        } else {
            Assert.assertFalse(rrpModal.isFullReviewDisplayed());
        }
    }
}
