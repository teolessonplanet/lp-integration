import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private CollectionRrpPage collectionRrpPage;
    private CollectionRrpModal collectionRrpModal;
    private LoginPage loginPage;
    private HeaderPage headerPage;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        rrpPage = new RrpPage(webDriver);
        rrpModal = new RrpModal(webDriver);
        stepOnePage = new StepOnePage(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        collectionRrpPage = new CollectionRrpPage(webDriver);
        collectionRrpModal = new CollectionRrpModal(webDriver);
        loginPage = new LoginPage(webDriver);
        headerPage = new HeaderPage(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Visitor - Search Page - lessonp-494: Keyword search")
    public void testLessonp_494() {
        testKeywordSearch(TestData.INVALID_EMAIL);
    }

    @Test(description = "Visitor - Search Page - lessonp-493: Keywordless search")
    public void testLessonp_493() {
        testKeywordlessSearch(TestData.INVALID_EMAIL);
    }

    @Test(description = "Visitor - Search Page - lessonp-487: Cards layout")
    public void testLessonp_487() {
        lpHomePage.loadPage();
        headerPage.clickOnSearchButton();
        Assert.assertEquals(discoverResourcesPage.getCountUnlockedResourcesInThumbnailMode(), TestData.TOTAL_RESOURCES_PER_PAGE);
        discoverResourcesPage.clickOnTiledView();
        Assert.assertEquals(discoverResourcesPage.getCountUnlockedResourcesInTiledMode(), TestData.TOTAL_RESOURCES_PER_PAGE);
        discoverResourcesPage.clickOnListView();
        Assert.assertEquals(discoverResourcesPage.getCountUnlockedResourcesInListMode(), TestData.TOTAL_RESOURCES_PER_PAGE);
        discoverResourcesPage.clickOnThumbnailView();
        Assert.assertEquals(discoverResourcesPage.getCountUnlockedResourcesInThumbnailMode(), TestData.TOTAL_RESOURCES_PER_PAGE);
    }

    @Test(description = "Visitor - Search Page - lessonp-4747: User clicks result card")
    public void testLessonp_4747() {
        testUserClicksResultCard(TestData.INVALID_EMAIL);
    }

    @Test(description = "Free member - Search Page - lessonp-503: User clicks result card")
    public void testLessonp_503() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testUserClicksResultCard(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Active user - Search Page - lessonp-601: User clicks result card")
    public void testLessonp_601() {
        loginPage.performLogin(TestData.VALID_EMAIL_ACTIVE, TestData.VALID_PASSWORD);
        testUserClicksResultCard(TestData.VALID_EMAIL_ACTIVE);
    }

    @Test(description = "Visitor - Search Page - lessonp-491: User clicks 'See Review' footer button (LP resource)")
    public void testLessonp_491() {
        testSeeReviewButton();
    }

    @Test(description = "Free member - Search Page - lessonp-505: User clicks 'See Review' footer button (LP resource)")
    public void testLessonp_505() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testSeeReviewButton();
    }

    @Test(description = "Visitor - Search Page - lessonp-490: User clicks 'Get Free Access' footer button")
    public void testLessonp_490() {
        reachSearchPageInListView();
        discoverResourcesPage.clickGetFreeAccess(true);
        Assert.assertTrue(stepOnePage.isAlreadyAMemberButtonDisplayed());
        discoverResourcesPage.closeTab();
        discoverResourcesPage.clickGetFreeAccess(false);
        Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
        stepOneModal.clickCloseModal();
    }

    @Test(description = "Free member - Search Page - lessonp-504: User clicks 'Get Free Access' footer button")
    public void testLessonp_504() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        reachSearchPageInListView();
        discoverResourcesPage.clickGetFreeAccess(true);
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
        discoverResourcesPage.closeTab();
        discoverResourcesPage.clickGetFreeAccess(false);
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
    }

    @Test(description = "Visitor - Search Page - lessonp-996: User clicks 'See Preview' footer button (Shared resource)")
    public void testLessonp_996() {
        reachSearchPageInListView();
        testSeePreviewButton();
    }

    @Test(description = "Free member - Search Page - lessonp-998: User clicks 'See Preview' footer button (Shared resource)")
    public void testLessonp_998() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testSeePreviewButton();
    }

    @Test(description = "Active user - Search Page - lessonp-603: User clicks 'See Preview' footer button (Shared resource)")
    public void testLessonp_603() {
        loginPage.performLogin(TestData.VALID_EMAIL_ACTIVE, TestData.VALID_PASSWORD);
        testSeePreviewButton();
    }

    @Test(description = "Visitor - Search Page - lessonp-997: User clicks 'Go to Resource' footer button (Shared resource)")
    public void testLessonp_997() {
        testGoToResourceButtonForSharedResource();
    }

    @Test(description = "Free member - Search Page - lessonp-999: User clicks 'Go to Resource' footer button (Shared resource)")
    public void testLessonp_999() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testGoToResourceButtonForSharedResource();
    }

    @Test(description = "Active user - Search Page - lessonp-602: User clicks 'Go to Resource' footer button (Shared/regular resource)")
    public void testLessonp_602() {
        loginPage.performLogin(TestData.VALID_EMAIL_ACTIVE, TestData.VALID_PASSWORD);
        testGoToResourceButtonForSharedResource();
        testGoToResourceButtonForRegularResource();
    }

    @Test(description = "Visitor - Search Page - lessonp-492: User clicks 'See Collection' footer button (Collection)")
    public void testLessonp_492() {
        testSeeCollection();
    }

    @Test(description = "Freemium - Search Page - lessonp-507: User clicks 'See Collection' footer button (Collection)")
    public void testLessonp_507() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testSeeCollection();
    }

    @Test(description = "Active user - Search Page - lessonp-605: User clicks 'See Collection' footer button (Collection)")
    public void testLessonp_605() {
        loginPage.performLogin(TestData.VALID_EMAIL_ACTIVE, TestData.VALID_PASSWORD);
        testSeeCollection();
    }

    @Test(description = "Free member - Search Page - lessonp-506: User clicks 'Free: Full Access Review' footer button")
    public void testLessonp_506() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        reachSearchPageInListView();
        discoverResourcesPage.clickFreeFullAccessReview(true);
        checkRrpSample(false, true, false);
        rrpPage.closeTab();
        discoverResourcesPage.clickFreeFullAccessReview(false);
        rrpModal.waitForModal();
        checkRrpSample(false, true, false);
    }

    @Test(description = "Active user - Search Page - lessonp-604: User clicks 'See Full Review' footer button")
    public void testLessonp_604() {
        loginPage.performLogin(TestData.VALID_EMAIL_ACTIVE, TestData.VALID_PASSWORD);
        testSeeFullReviewButton();
    }

    @Test(description = "Visitor - Search Page - lessonp-3956: Cards details - LP resource")
    public void testLessonp_3956() {
        testLpResource(TestData.INVALID_EMAIL, false);
    }

    @Test(description = "Visitor - Search Page - lessonp-3957: Cards details - Collection")
    public void testLessonp_3957() {
        testCollectionResource();
    }

    @Test(description = "Visitor - Search Page - lessonp-3958: Cards details - Shared resource")
    public void testLessonp_3958() {
        testSharedResource();
    }

    @Test(description = "Free member - Search Page - lessonp-3993: Cards details - LP resource")
    public void testLessonp_3993() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testLpResource(TestData.VALID_EMAIL_FREEMIUM, false);
    }

    @Test(description = "Free member - Search Page - lessonp-4002:Cards details - Sample resource")
    public void testLessonp_4002() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testLpResource(TestData.VALID_EMAIL_FREEMIUM, true);
    }

    @Test(description = "Free member - Search Page - lessonp-3994: Cards details - Collection")
    public void testLessonp_3994() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testCollectionResource();
    }

    @Test(description = "Free member - Search Page - lessonp-3995: Cards details - Shared resource")
    public void testLessonp_3995() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testSharedResource();
    }

    @Test(description = "Active user - Search Page - lessonp-4007:Cards details - LP resource")
    public void testLessonp_4007() {
        loginPage.performLogin(TestData.VALID_EMAIL_ACTIVE, TestData.VALID_PASSWORD);
        testLpResource(TestData.VALID_EMAIL_ACTIVE, false);
    }

    @Test(description = "Active user - Search Page - lessonp-4008: Cards details - Collection")
    public void testLessonp_4008() {
        loginPage.performLogin(TestData.VALID_EMAIL_ACTIVE, TestData.VALID_PASSWORD);
        testCollectionResource();
    }

    @Test(description = "Active user - Search Page - lessonp-4009: Cards details - Shared resource")
    public void testLessonp_4009() {
        loginPage.performLogin(TestData.VALID_EMAIL_ACTIVE, TestData.VALID_PASSWORD);
        testSharedResource();
    }

    protected void testSeeCollection() {
        reachSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        Assert.assertTrue(collectionRrpPage.isSaveCollectionButtonDisplayed());
        rrpPage.closeTab();
        discoverResourcesPage.clickSeeCollection(false);
        Assert.assertTrue(collectionRrpModal.isCollectionTitleDisplayed());
    }

    protected void testKeywordSearch(String account) {
        lpHomePage.loadPage();
        headerPage.typeSearchText(TestData.INVALID_SEARCH_WORD);
        headerPage.clickOnSearchButton();
        if (!account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            Assert.assertEquals(discoverResourcesPage.getSearchMessage(), TestData.INVALID_SEARCH_MESSAGE);
        } else {
            Assert.assertTrue(discoverResourcesPage.getSearchMessage().contains(TestData.SEARCH_MESSAGE_FOUND_1) & discoverResourcesPage.getSearchMessage().contains(TestData.SEARCH_MESSAGE_FOUND_2));
        }
        Assert.assertTrue(discoverResourcesPage.isSuggestionBlockTextDisplayed());
        Assert.assertEquals(TestData.SUGGESTIONS_BLOCK_MESSAGE, discoverResourcesPage.getSuggestionsBlockText());

        lpHomePage.loadPage();
        headerPage.clickOnClearSearchButton();
        headerPage.typeSearchText(TestData.VALID_SEARCH_WORD);
        headerPage.clickOnSearchButton();
        Assert.assertTrue(TestData.ZERO_RESOURCES_FOUND < discoverResourcesPage.getTotalResults());
        Assert.assertFalse(discoverResourcesPage.isSuggestionBlockTextDisplayed());
    }

    protected void testKeywordlessSearch(String account) {
        lpHomePage.loadPage();
        headerPage.clickOnSearchButton();
        Assert.assertFalse(discoverResourcesPage.isSuggestionBlockTextDisplayed());
        if (!account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            Assert.assertEquals(discoverResourcesPage.getSearchMessage(), TestData.SHOWING_ALL_REVIEWED_RESOURCES_MESSAGE);
            Assert.assertEquals(discoverResourcesPage.getCountUnlockedResourcesInThumbnailMode(), TestData.TOTAL_RESOURCES_PER_PAGE);
        } else {
            // https://lessonplanet.atlassian.net/browse/BC-2923 -> temporary fix // TODO: remove hack fix
            headerPage.hoverOverDiscoverButton();
            headerPage.clickOnDiscoverResourcesButton();
            Assert.assertEquals(discoverResourcesPage.getSearchMessage(), TestData.SHOWING_ALL_RESOURCES_MESSAGE);
            discoverResourcesPage.clickOnThumbnailView();
            Assert.assertEquals(discoverResourcesPage.getCountUnlockedResourcesInThumbnailMode(), TestData.TOTAL_RESOURCES_PER_PAGE);
        }
    }

    protected void reachSearchPageInListView() {
        discoverResourcesPage.loadPage();
        discoverResourcesPage.clickOnListView();
    }

    private void testUserClicksResultCard(String account) {
        reachSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
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
        discoverResourcesPage.checkLessonPlanetProvider();
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
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(true);
        Assert.assertTrue(rrpPage.isGoToResourceButtonDisplayed());
        discoverResourcesPage.closeTab();
        discoverResourcesPage.clickSeePreview(false);
        rrpModal.waitForModal();
        Assert.assertTrue(rrpModal.isGoToResourceButtonDisplayed());
        rrpModal.clickCloseModal();
    }

    private void testGoToResourceButtonForSharedResource() {
        reachSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickGoToResourceForSharedResource(true);
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.STAGING_SERVER_SHARED_RESOURCE_URL));
        discoverResourcesPage.closeTab();
        final int tabsOpened = discoverResourcesPage.getCountOpenedTabs();
        discoverResourcesPage.clickGoToResourceForSharedResource(false);
        // the resource is opened in the same tab or in a new one
        if (tabsOpened != discoverResourcesPage.getCountOpenedTabs()) {
            discoverResourcesPage.waitForNewTab();
            discoverResourcesPage.focusDriverToLastTab();
        }
        discoverResourcesPage.waitForLinkToLoad();
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.STAGING_SERVER_SHARED_RESOURCE_URL));
        if (tabsOpened != discoverResourcesPage.getCountOpenedTabs()) {
            discoverResourcesPage.closeTab();
        } else {
            discoverResourcesPage.goBackOnePage();
        }
    }

    protected void testGoToResourceButtonForRegularResource() {
        discoverResourcesPage.clickGoToResourceForRegularResource(true);
        String currentUrl = discoverResourcesPage.getUrl();
        boolean assertResult = currentUrl.contains(TestData.STAGING_SERVER_SHARED_RESOURCE_URL_2) || !currentUrl.contains(TestData.SERVER_URL);
        Assert.assertTrue(assertResult);
        discoverResourcesPage.closeTab();
        discoverResourcesPage.clickGoToResourceForRegularResource(false);
        discoverResourcesPage.waitForNewTab();
        discoverResourcesPage.focusDriverToLastTab();
        discoverResourcesPage.waitForLinkToLoad();
        currentUrl = discoverResourcesPage.getUrl();
        assertResult = currentUrl.contains(TestData.STAGING_SERVER_SHARED_RESOURCE_URL_2) || !currentUrl.contains(TestData.SERVER_URL);
        Assert.assertTrue(assertResult);
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

    private void testCommonItems(WebElement card) {
        Assert.assertTrue(discoverResourcesPage.isCardIconDisplayed(card));
        Assert.assertTrue(discoverResourcesPage.isCardTitleDisplayed(card));
        Assert.assertTrue(discoverResourcesPage.isCardResourceTypeDisplayed(card));
        Assert.assertTrue(discoverResourcesPage.isCardGraduationDisplayed(card));
    }

    protected void testLpResource(String account, boolean freeSample) {
        WebElement lpResourceCard;
        discoverResourcesPage.loadPage();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickOnThumbnailView();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_ARTICLES);

        lpResourceCard = getLpResourceCard(account, freeSample);
        discoverResourcesPage.scrollToTop();
        testCommonItems(lpResourceCard);
        if (!(account.equals(TestData.VALID_EMAIL_ACTIVE) || account.equals(TestData.VALID_EMAIL_RSL_SBCEO))) {
            if (freeSample) {
                Assert.assertTrue(discoverResourcesPage.getFreeFullAccessButtonTextForCard(lpResourceCard).equals(TestData.LP_HOME_PAGE_PATH));
                Assert.assertTrue(discoverResourcesPage.isFreeSampleStampIconDisplayed(lpResourceCard));
            } else {
                Assert.assertTrue(discoverResourcesPage.getFreeAccessButtonText(lpResourceCard).equals(TestData.LP_HOME_PAGE_PATH));
                Assert.assertTrue(discoverResourcesPage.getSeeReviewButtonText(lpResourceCard).equals(TestData.LP_HOME_PAGE_PATH));
            }
        } else {
            Assert.assertTrue(discoverResourcesPage.getGoToResourceButtonTextForRegularCard(lpResourceCard).equals(TestData.LP_HOME_PAGE_PATH));
            Assert.assertTrue(discoverResourcesPage.getSeeFullReviewButtonTextForRegularCard(lpResourceCard).equals(TestData.LP_HOME_PAGE_PATH));
        }

        Assert.assertTrue(discoverResourcesPage.isCardResourceTypeDisplayed(lpResourceCard));
        Assert.assertTrue(discoverResourcesPage.isCardStarRatingDisplayed(lpResourceCard));

        discoverResourcesPage.hoverOverElement(lpResourceCard, true);
        Assert.assertNotEquals(TestData.LP_HOME_PAGE_PATH, discoverResourcesPage.getCardDescription(lpResourceCard));

        testCommonItems(lpResourceCard);
        verifyLpResourceButtons(account, freeSample, lpResourceCard);

        Assert.assertTrue(discoverResourcesPage.isCardResourceTypeDisplayed(lpResourceCard));
        Assert.assertTrue(discoverResourcesPage.isCardStarRatingDisplayed(lpResourceCard));

        discoverResourcesPage.clickOnTiledView();
        lpResourceCard = getLpResourceCard(account, freeSample);

        Assert.assertNotEquals(TestData.LP_HOME_PAGE_PATH, discoverResourcesPage.getCardDescription(lpResourceCard));
        testCommonItems(lpResourceCard);
        verifyLpResourceButtons(account, freeSample, lpResourceCard);
        Assert.assertTrue(discoverResourcesPage.isCardStarRatingDisplayed(lpResourceCard));

        discoverResourcesPage.clickOnListView();
        lpResourceCard = getLpResourceCard(account, freeSample);
        Assert.assertNotEquals(TestData.LP_HOME_PAGE_PATH, discoverResourcesPage.getCardDescription(lpResourceCard));

        testCommonItems(lpResourceCard);
        verifyLpResourceButtons(account, freeSample, lpResourceCard);
//        Assert.assertTrue(discoverResourcesPage.isCardUniversityDisplayed(lpResourceCard));
    }

    protected void testCollectionResource() {
        discoverResourcesPage.loadPage();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickOnThumbnailView();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_COLLECTIONS_TYPES);

        WebElement collectionResourceCard = discoverResourcesPage.getCollectionCards().get(0);

        Assert.assertTrue(discoverResourcesPage.getSeeCollectionButtonTextForCard(collectionResourceCard).equals(TestData.LP_HOME_PAGE_PATH));
        testCommonItems(collectionResourceCard);

        discoverResourcesPage.hoverOverElement(collectionResourceCard, true);
        Assert.assertNotEquals(TestData.LP_HOME_PAGE_PATH, discoverResourcesPage.getCardDescription(collectionResourceCard));
        testCommonItems(collectionResourceCard);
        Assert.assertEquals(discoverResourcesPage.getSeeCollectionButtonTextForCard(collectionResourceCard), TestData.SEE_COLLECTION_BUTTON_TEXT);

        discoverResourcesPage.clickOnTiledView();
        collectionResourceCard = discoverResourcesPage.getCollectionCards().get(0);
        Assert.assertNotEquals(TestData.LP_HOME_PAGE_PATH, discoverResourcesPage.getCardDescription(collectionResourceCard));
        testCommonItems(collectionResourceCard);
        Assert.assertEquals(discoverResourcesPage.getSeeCollectionButtonTextForCard(collectionResourceCard), TestData.SEE_COLLECTION_BUTTON_TEXT);

        discoverResourcesPage.clickOnListView();
        collectionResourceCard = discoverResourcesPage.getCollectionCards().get(0);
        Assert.assertNotEquals(TestData.LP_HOME_PAGE_PATH, discoverResourcesPage.getCardDescription(collectionResourceCard));
        testCommonItems(collectionResourceCard);
        Assert.assertEquals(discoverResourcesPage.getSeeCollectionButtonTextForCard(collectionResourceCard), TestData.SEE_COLLECTION_BUTTON_TEXT);
    }

    protected void testSharedResource() {
        discoverResourcesPage.loadPage();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickOnThumbnailView();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_ARTICLES);
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_SUBJECTS, TestData.FACET_CATEGORY_SUBJECTS_TYPE_SOCIAL_STUDIES_AND_HISTORY);

        WebElement sharedResourceCard = discoverResourcesPage.getSharedResourcesCards().get(0);

        Assert.assertTrue(discoverResourcesPage.getGoToResourceButtonTextForSharedCard(sharedResourceCard).equals(TestData.LP_HOME_PAGE_PATH));
        Assert.assertTrue(discoverResourcesPage.getSeePreviewButtonTextForSharedCard(sharedResourceCard).equals(TestData.LP_HOME_PAGE_PATH));

        testCommonItems(sharedResourceCard);
        Assert.assertTrue(discoverResourcesPage.isCardSharedResourceTagInThumbnailViewDisplayed(sharedResourceCard));

        discoverResourcesPage.hoverOverElement(sharedResourceCard, true);
        Assert.assertNotEquals(TestData.LP_HOME_PAGE_PATH, discoverResourcesPage.getCardDescription(sharedResourceCard));

        testCommonItems(sharedResourceCard);
        Assert.assertTrue(discoverResourcesPage.isCardSharedResourceTagInThumbnailViewDisplayed(sharedResourceCard));
        Assert.assertEquals(discoverResourcesPage.getGoToResourceButtonTextForSharedCard(sharedResourceCard), TestData.GO_TO_RESOURCE_BUTTON_TEXT);
        Assert.assertEquals(discoverResourcesPage.getSeePreviewButtonTextForSharedCard(sharedResourceCard), TestData.SEE_PREVIEW_BUTTON_TEXT);

        discoverResourcesPage.clickOnTiledView();
        sharedResourceCard = discoverResourcesPage.getSharedResourcesCards().get(0);
        Assert.assertNotEquals(TestData.LP_HOME_PAGE_PATH, discoverResourcesPage.getCardDescription(sharedResourceCard));

        testCommonItems(sharedResourceCard);
        Assert.assertTrue(discoverResourcesPage.isCardSharedResourceTagInListOrTiledViewDisplayed(sharedResourceCard));
        Assert.assertEquals(discoverResourcesPage.getGoToResourceButtonTextForSharedCard(sharedResourceCard), TestData.GO_TO_RESOURCE_BUTTON_TEXT);
        Assert.assertEquals(discoverResourcesPage.getSeePreviewButtonTextForSharedCard(sharedResourceCard), TestData.SEE_PREVIEW_BUTTON_TEXT);

        discoverResourcesPage.clickOnListView();
        sharedResourceCard = discoverResourcesPage.getSharedResourcesCards().get(0);
        Assert.assertNotEquals(TestData.LP_HOME_PAGE_PATH, discoverResourcesPage.getCardDescription(sharedResourceCard));

        testCommonItems(sharedResourceCard);
        Assert.assertTrue(discoverResourcesPage.isCardSharedResourceTagInListOrTiledViewDisplayed(sharedResourceCard));
        Assert.assertEquals(discoverResourcesPage.getGoToResourceButtonTextForSharedCard(sharedResourceCard), TestData.GO_TO_RESOURCE_BUTTON_TEXT);
        Assert.assertEquals(discoverResourcesPage.getSeePreviewButtonTextForSharedCard(sharedResourceCard), TestData.SEE_PREVIEW_BUTTON_TEXT);
    }

    private WebElement getLpResourceCard(String account, boolean freeSample) {
        discoverResourcesPage.waitForLoad();
        WebElement lpResourceCard;
        if (!(account.equals(TestData.VALID_EMAIL_ACTIVE) || account.equals(TestData.VALID_EMAIL_RSL_SBCEO))) {
            if (freeSample) {
                lpResourceCard = discoverResourcesPage.getSampleResourceCards().get(0);
            } else {
                lpResourceCard = discoverResourcesPage.getLimitedLpResourcesCards().get(0);
            }
        } else {
            lpResourceCard = discoverResourcesPage.getFullLpResourcesCards().get(0);
        }
        return lpResourceCard;
    }

    private void verifyLpResourceButtons(String account, boolean freeSample, WebElement lpResourceCard) {
        if (!(account.equals(TestData.VALID_EMAIL_ACTIVE) || account.equals(TestData.VALID_EMAIL_RSL_SBCEO))) {
            if (freeSample) {
                Assert.assertTrue(discoverResourcesPage.getFreeFullAccessButtonTextForCard(lpResourceCard).equals(TestData.FREE_SAMPLE_BUTTON_TEXT));
                Assert.assertTrue(discoverResourcesPage.isFreeSampleStampIconDisplayed(lpResourceCard));
            } else {
                Assert.assertTrue(discoverResourcesPage.getFreeAccessButtonText(lpResourceCard).equals(TestData.GET_FREE_ACCESS_BUTTON_TEXT));
                Assert.assertTrue(discoverResourcesPage.getSeeReviewButtonText(lpResourceCard).equals(TestData.SEE_REVIEW_BUTTON_TEXT));
            }
        } else {
            Assert.assertTrue(discoverResourcesPage.getGoToResourceButtonTextForRegularCard(lpResourceCard).equals(TestData.GO_TO_RESOURCE_BUTTON_TEXT));
            Assert.assertTrue(discoverResourcesPage.getSeeFullReviewButtonTextForRegularCard(lpResourceCard).equals(TestData.SEE_FULL_REVIEW_BUTTON_TEXT));
        }
    }

    protected void testSeeFullReviewButton() {
        reachSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeeFullReview(true);
        checkRrpSample(false, false, true);
        rrpPage.closeTab();
        discoverResourcesPage.clickSeeFullReview(false);
        rrpModal.waitForModal();
        checkRrpSample(false, false, true);
    }
}
