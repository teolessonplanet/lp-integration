import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class User_SearchTest extends BaseTest {

    private LpHomePage lpHomePage;
    private DiscoverResourcesPage discoverResourcesPage;
    private RrpPage rrpPage;
    private RrpModal rrpModal;
    private StepOnePage stepOnePage;
    private StepOneModal stepOneModal;
    private StepTwoPage stepTwoPage;
    private CollectionRrpPage collectionRrpPage;
    private CollectionRrpModal collectionRrpModal;
    private HeaderPage headerPage;

    @BeforeMethod(alwaysRun = true)
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
        headerPage = new HeaderPage(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Visitor - Search - C2073: Keyword search", groups = {"visitor"})
    public void testC2073() {
        testKeywordSearch(TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - Search - C2074: Keywordless search", groups = {"visitor"})
    public void testC2074() {
        testKeywordlessSearch(TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - Search - C2075: Cards layout", groups = {"visitor"})
    public void testC2075() {
        lpHomePage.loadPage();
        headerPage.clickOnSearchButton();
        Assert.assertTrue(discoverResourcesPage.getCountUnlockedResourcesInThumbnailMode() % TestData.TOTAL_RESOURCES_PER_PAGE == 0);
        discoverResourcesPage.clickOnTiledView();
        Assert.assertTrue(discoverResourcesPage.getCountUnlockedResourcesInTiledMode() % TestData.TOTAL_RESOURCES_PER_PAGE == 0);
        discoverResourcesPage.clickOnListView();
        Assert.assertTrue(discoverResourcesPage.getCountUnlockedResourcesInListMode() % TestData.TOTAL_RESOURCES_PER_PAGE == 0);
        discoverResourcesPage.clickOnThumbnailView();
        Assert.assertTrue(discoverResourcesPage.getCountUnlockedResourcesInThumbnailMode() % TestData.TOTAL_RESOURCES_PER_PAGE == 0);
    }

    @Test(description = "Visitor - Search - C2076: User clicks result card", groups = {"visitor"})
    public void testC2076() {
        testUserClicksResultCard(TestData.PLAN_VISITOR);
    }

    @Test(description = "Free member - Search - C2147: User clicks result card", groups = {"freemium"})
    public void testC2147() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testUserClicksResultCard(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Search - C2269: User clicks result card", groups = {"activeUser"})
    public void testC2269() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testUserClicksResultCard(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Search - C2079: User clicks 'See Review' footer button (LP resource)", groups = {"visitor"})
    public void testC2079() {
        testSeeReviewButton();
    }

    @Test(description = "Free member - Search - C2148: User clicks 'See Review' footer button (LP resource)", groups = {"freemium"})
    public void testC2148() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testSeeReviewButton();
    }

    @Test(description = "Visitor - Search - C2080: User clicks 'Get Free Access' footer button", groups = {"visitor"})
    public void testC2080() {
        reachSearchPageInListView();
        discoverResourcesPage.clickGetFreeAccess(true);
        Assert.assertTrue(stepOnePage.isAlreadyAMemberButtonDisplayed());
        discoverResourcesPage.closeTab();
        discoverResourcesPage.clickGetFreeAccess(false);
        Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
        stepOneModal.clickCloseModal();
    }

    @Test(description = "Free member - Search - C2149: User clicks 'Get Free Access' footer button", groups = {"freemium"})
    public void testC2149() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        reachSearchPageInListView();
        discoverResourcesPage.clickGetFreeAccess(true);
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
        discoverResourcesPage.closeTab();
        discoverResourcesPage.clickGetFreeAccess(false);
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
    }

    @Test(description = "Visitor - Search - C2081: User clicks 'See Preview' footer button (Shared resource)", groups = {"visitor"})
    public void testC2081() {
        reachSearchPageInListView();
        testSeePreviewButton();
    }

    @Test(description = "Free member - Search - C2150: User clicks 'See Preview' footer button (Shared resource)", groups = {"freemium"})
    public void testC2150() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testSeePreviewButton();
    }

    @Test(description = "Active user - Search - C2271: User clicks 'See Preview' footer button (Shared resource)", groups = {"activeUser"})
    public void testC2271() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testSeePreviewButton();
    }

    @Test(description = "Visitor - Search - C2082: User clicks 'Go to Resource' footer button (Shared resource)", groups = {"visitor"})
    public void testC2082() {
        testGoToResourceButtonForSharedResource();
    }

    @Test(description = "Free member - Search - C2151: User clicks 'Go to Resource' footer button (Shared resource)", groups = {"freemium"})
    public void testC2151() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testGoToResourceButtonForSharedResource();
    }

    @Test(description = "Active user - Search - C2270: User clicks 'Go to Resource' footer button (Shared/regular resource)", groups = {"activeUser"})
    public void testC2270() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testGoToResourceButtonForSharedResource();
        testGoToResourceButtonForRegularResource(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Search - C2083: User clicks 'See Collection' footer button (Collection)", groups = {"visitor"})
    public void testC2083() {
        testSeeCollection();
    }

    @Test(description = "Freemium - Search - C2152: User clicks 'See Collection' footer button (Collection)", groups = {"freemium"})
    public void testC2152() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testSeeCollection();
    }

    @Test(description = "Active user - Search - C2272: User clicks 'See Collection' footer button (Collection)", groups = {"activeUser"})
    public void testC2272() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testSeeCollection();
    }

    @Test(description = "Free member - Search - C2153: User clicks 'Free: Full Access Review' footer button", groups = {"freemium"})
    public void testC2153() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        reachSearchPageInListView();
        discoverResourcesPage.clickFreeFullAccessReview(true);
        checkRrpSample(false, true, false);
        rrpPage.closeTab();
        discoverResourcesPage.clickFreeFullAccessReview(false);
        rrpModal.waitForModal();
        checkRrpSample(false, true, false);
    }

    @Test(description = "Active user - Search - C2273: User clicks 'See Full Review' footer button", groups = {"activeUser"})
    public void testC2273() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testSeeFullReviewButton(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Search - C2084: Cards details - LP resource", groups = {"visitor"})
    public void testC2084() {
        testLpResource(TestData.PLAN_VISITOR, false);
    }

    @Test(description = "Visitor - Search - C2077: Cards details - Collection", groups = {"visitor"})
    public void testC2077() {
        testCollectionResource();
    }

    @Test(description = "Visitor - Search -  C2078: Cards details - Shared resource", groups = {"visitor"})
    public void testC2078() {
        testSharedResource();
    }

    @Test(description = "Free member - Search - C2154: Cards details - LP resource", groups = {"freemium"})
    public void testC2154() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testLpResource(TestData.PLAN_FREEMIUM, false);
    }

    @Test(description = "Free member - Search - C2155:Cards details - Sample resource", groups = {"freemium"})
    public void testC2155() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testLpResource(TestData.PLAN_FREEMIUM, true);
    }

    @Test(description = "Free member - Search - C2156: Cards details - Collection", groups = {"freemium"})
    public void testC2156() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testCollectionResource();
    }

    @Test(description = "Free member - Search - C2157: Cards details - Shared resource", groups = {"freemium"})
    public void testC2157() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testSharedResource();
    }

    @Test(description = "Active user - Search - C2274:Cards details - LP resource", groups = {"activeUser"})
    public void testC2274() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testLpResource(TestData.PLAN_PRO, false);
    }

    @Test(description = "Active user - Search - C2275: Cards details - Collection", groups = {"activeUser"})
    public void testC2275() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testCollectionResource();
    }

    @Test(description = "Active user - Search - C2276: Cards details - Shared resource", groups = {"activeUser"})
    public void testC2276() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
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
        if (account.equals(TestData.VALID_EMAIL_CSL_COBB) || account.equals(TestData.VALID_EMAIL_CSL_HENRY) || account.equals(TestData.VALID_EMAIL_CSL_QA_CUSTOM) || account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            Assert.assertTrue(discoverResourcesPage.getSearchMessage().contains(TestData.SEARCH_MESSAGE_FOUND_1) & discoverResourcesPage.getSearchMessage().contains(TestData.SEARCH_MESSAGE_FOUND_2));
        } else {
            Assert.assertEquals(discoverResourcesPage.getSearchMessage(), TestData.INVALID_SEARCH_MESSAGE);
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
        if (account.equals(TestData.VALID_EMAIL_CSL_COBB) || account.equals(TestData.VALID_EMAIL_CSL_HENRY) || account.equals(TestData.VALID_EMAIL_CSL_QA_CUSTOM) || account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            // https://lessonplanet.atlassian.net/browse/BC-2923 -> temporary fix // TODO: remove hack fix
            headerPage.hoverOverDiscoverButton();
            headerPage.clickOnDiscoverResourcesButton();
            Assert.assertEquals(discoverResourcesPage.getSearchMessage(), TestData.SHOWING_ALL_RESOURCES_MESSAGE);
            discoverResourcesPage.clickOnThumbnailView();
            Assert.assertTrue(discoverResourcesPage.getCountUnlockedResourcesInThumbnailMode() % TestData.TOTAL_RESOURCES_PER_PAGE == 0);
        } else {
            Assert.assertEquals(discoverResourcesPage.getSearchMessage(), TestData.SHOWING_ALL_REVIEWED_RESOURCES_MESSAGE);
            Assert.assertTrue(discoverResourcesPage.getCountUnlockedResourcesInThumbnailMode() % TestData.TOTAL_RESOURCES_PER_PAGE == 0);
        }
    }

    protected void reachSearchPageInListView() {
        discoverResourcesPage.loadPage();
        discoverResourcesPage.clickOnListView();
    }

    private void testUserClicksResultCard(String account) {
        reachSearchPageInListView();
        discoverResourcesPage.expandProvidersFacet();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeeReview(false);
        rrpModal.waitForModal();
        Assert.assertTrue(rrpModal.isTitleDisplayed());
        if (account.equals(TestData.PLAN_VISITOR) || account.equals(TestData.PLAN_FREEMIUM)) {
            checkRrpSample(true, false, false);
            if (account.equals(TestData.PLAN_FREEMIUM)) {
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
        discoverResourcesPage.expandProvidersFacet();
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
        discoverResourcesPage.expandProvidersFacet();
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

    protected void testGoToResourceButtonForRegularResource(String account) {
        if (account.equals(TestData.VALID_EMAIL_CSL_HENRY) || account.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            discoverResourcesPage.expandProvidersFacet();
        }
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);
        discoverResourcesPage.clickGoToResourceForRegularResource(true);
        String currentUrl = discoverResourcesPage.getUrl();
        boolean assertResult = currentUrl.contains(TestData.SERVER_URL + TestData.STAGING_SERVER_SHARED_RESOURCE_URL_2) || !currentUrl.contains(TestData.SERVER_URL);
        Assert.assertTrue(assertResult);
        discoverResourcesPage.closeTab();
        discoverResourcesPage.clickGoToResourceForRegularResource(false);
        discoverResourcesPage.waitForNewTab();
        discoverResourcesPage.focusDriverToLastTab();
        discoverResourcesPage.waitForLinkToLoad();
        currentUrl = discoverResourcesPage.getUrl();
        assertResult = currentUrl.contains(TestData.SERVER_URL + TestData.STAGING_SERVER_SHARED_RESOURCE_URL_2) || !currentUrl.contains(TestData.SERVER_URL);
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

    protected void testCommonItems(WebElement card) {
        Assert.assertTrue(discoverResourcesPage.isCardIconDisplayed(card));
        Assert.assertTrue(discoverResourcesPage.isCardTitleDisplayed(card));
        Assert.assertTrue(discoverResourcesPage.isCardResourceTypeDisplayed(card));
        Assert.assertTrue(discoverResourcesPage.isCardGraduationDisplayed(card));
    }

    protected void testCommonItemsInThumbnailView(WebElement card) {
        Assert.assertTrue(discoverResourcesPage.isCardIconInThumbnailViewDisplayed(card));
        Assert.assertTrue(discoverResourcesPage.isCardTitleDisplayed(card));
        Assert.assertTrue(discoverResourcesPage.isCardResourceTypeInThumbnailViewDisplayed(card));
        Assert.assertTrue(discoverResourcesPage.isCardGraduationInThumbnailViewDisplayed(card));
    }

    protected void testLpResource(String account, boolean freeSample) {
        WebElement lpResourceCard;
        discoverResourcesPage.loadPage();
        if (account.equals(TestData.VALID_EMAIL_CSL_HENRY) || account.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            discoverResourcesPage.expandProvidersFacet();
        }
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickOnThumbnailView();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_ARTICLES);

        lpResourceCard = getLpResourceCard(account, freeSample, true);
        discoverResourcesPage.scrollToTop();
        testCommonItemsInThumbnailView(lpResourceCard);

        if (account.equals(TestData.PLAN_VISITOR) || account.equals(TestData.PLAN_FREEMIUM)) {
            if (freeSample) {
                Assert.assertTrue(discoverResourcesPage.getFreeFullAccessInThumbnailViewButtonTextForCard(lpResourceCard).equals(TestData.LP_HOME_PAGE_PATH));
                Assert.assertTrue(discoverResourcesPage.isFreeSampleStampIconDisplayed(lpResourceCard));
            } else {
                Assert.assertTrue(discoverResourcesPage.getFreeAccessInThumbnailViewButtonText(lpResourceCard).equals(TestData.LP_HOME_PAGE_PATH));
                Assert.assertTrue(discoverResourcesPage.getSeeReviewInThumbnailViewButtonText(lpResourceCard).equals(TestData.LP_HOME_PAGE_PATH));
            }
        } else {
            Assert.assertTrue(discoverResourcesPage.getGoToResourceInThumbnailViewButtonTextForRegularCard(lpResourceCard).equals(TestData.LP_HOME_PAGE_PATH));
            Assert.assertTrue(discoverResourcesPage.getSeeReviewInThumbnailViewButtonTextForRegularCard(lpResourceCard).equals(TestData.LP_HOME_PAGE_PATH));
        }

        discoverResourcesPage.hoverOverElement(lpResourceCard, true);
        Assert.assertNotEquals(TestData.LP_HOME_PAGE_PATH, discoverResourcesPage.getCardDescription(lpResourceCard));

        testCommonItemsInThumbnailView(lpResourceCard);

        if (account.equals(TestData.PLAN_VISITOR) || account.equals(TestData.PLAN_FREEMIUM)) {
            if (freeSample) {
                Assert.assertTrue(discoverResourcesPage.getFreeFullAccessInThumbnailViewButtonTextForCard(lpResourceCard).equals(TestData.FREE_SAMPLE_BUTTON_TEXT));
                Assert.assertTrue(discoverResourcesPage.isFreeSampleStampIconDisplayed(lpResourceCard));
            } else {
                Assert.assertTrue(discoverResourcesPage.getFreeAccessInThumbnailViewButtonText(lpResourceCard).equals(TestData.GET_FREE_ACCESS_BUTTON_TEXT));
                Assert.assertTrue(discoverResourcesPage.getSeeReviewInThumbnailViewButtonText(lpResourceCard).equals(TestData.SEE_REVIEW_BUTTON_TEXT));
            }
        } else {
            Assert.assertTrue(discoverResourcesPage.getGoToResourceButtonTextForRegularCard(lpResourceCard).equals(TestData.GO_TO_RESOURCE_BUTTON_TEXT));
            Assert.assertTrue(discoverResourcesPage.getSeeReviewInThumbnailViewButtonTextForRegularCard(lpResourceCard).equals(TestData.SEE_REVIEW_BUTTON_TEXT));
        }

        discoverResourcesPage.clickOnTiledView();
        lpResourceCard = getLpResourceCard(account, freeSample, false);

        Assert.assertNotEquals(TestData.LP_HOME_PAGE_PATH, discoverResourcesPage.getCardDescription(lpResourceCard));
        testCommonItems(lpResourceCard);
        verifyLpResourceButtons(account, freeSample, lpResourceCard);

        discoverResourcesPage.clickOnListView();
        lpResourceCard = getLpResourceCard(account, freeSample, false);
        Assert.assertNotEquals(TestData.LP_HOME_PAGE_PATH, discoverResourcesPage.getCardDescription(lpResourceCard));

        testCommonItems(lpResourceCard);
        verifyLpResourceButtons(account, freeSample, lpResourceCard);
        Assert.assertTrue(discoverResourcesPage.isCardUniversityDisplayed(lpResourceCard));
    }

    protected void testCollectionResource() {
        discoverResourcesPage.loadPage();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickOnThumbnailView();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_COLLECTIONS_TYPES);

        discoverResourcesPage.scrollToTop();
        WebElement collectionResourceCard = discoverResourcesPage.getCollectionCardsInThumbnailView().get(0);

        Assert.assertTrue(discoverResourcesPage.getSeeCollectionInThumbnailViewButtonTextForCard(collectionResourceCard).equals(TestData.LP_HOME_PAGE_PATH));
        testCommonItemsInThumbnailView(collectionResourceCard);

        discoverResourcesPage.hoverOverElement(collectionResourceCard, true);
        Assert.assertNotEquals(TestData.LP_HOME_PAGE_PATH, discoverResourcesPage.getCardDescription(collectionResourceCard));
        testCommonItemsInThumbnailView(collectionResourceCard);
        Assert.assertEquals(discoverResourcesPage.getSeeCollectionInThumbnailViewButtonTextForCard(collectionResourceCard), TestData.SEE_FOLDER_BUTTON_TEXT);

        discoverResourcesPage.clickOnTiledView();
        collectionResourceCard = discoverResourcesPage.getCollectionCards().get(0);
        Assert.assertNotEquals(TestData.LP_HOME_PAGE_PATH, discoverResourcesPage.getCardDescription(collectionResourceCard));
        testCommonItems(collectionResourceCard);
        Assert.assertEquals(discoverResourcesPage.getSeeCollectionButtonTextForCard(collectionResourceCard), TestData.SEE_FOLDER_BUTTON_TEXT);

        discoverResourcesPage.clickOnListView();
        collectionResourceCard = discoverResourcesPage.getCollectionCards().get(0);
        Assert.assertNotEquals(TestData.LP_HOME_PAGE_PATH, discoverResourcesPage.getCardDescription(collectionResourceCard));
        testCommonItems(collectionResourceCard);
        Assert.assertEquals(discoverResourcesPage.getSeeCollectionButtonTextForCard(collectionResourceCard), TestData.SEE_FOLDER_BUTTON_TEXT);
    }

    protected void testSharedResource() {
        discoverResourcesPage.loadPath(TestData.SEARCH_PAGE_SHARED_RESOURCES_PATH);
        discoverResourcesPage.clickOnThumbnailView();
        WebElement sharedResourceCard = discoverResourcesPage.getSharedResourcesCardsInThumbnailView().get(0);

        Assert.assertTrue(discoverResourcesPage.getGoToResourceButtonTextForSharedCard(sharedResourceCard).equals(TestData.LP_HOME_PAGE_PATH));
        Assert.assertTrue(discoverResourcesPage.getSeePreviewInThumbnailViewButtonTextForSharedCard(sharedResourceCard).equals(TestData.LP_HOME_PAGE_PATH));

        testCommonItemsInThumbnailView(sharedResourceCard);
        Assert.assertTrue(discoverResourcesPage.isCardSharedResourceTagInThumbnailViewDisplayed(sharedResourceCard));

        discoverResourcesPage.hoverOverElement(sharedResourceCard, true);
        Assert.assertNotEquals(TestData.LP_HOME_PAGE_PATH, discoverResourcesPage.getCardDescription(sharedResourceCard));

        testCommonItemsInThumbnailView(sharedResourceCard);
        Assert.assertTrue(discoverResourcesPage.isCardSharedResourceTagInThumbnailViewDisplayed(sharedResourceCard));
        Assert.assertEquals(discoverResourcesPage.getGoToResourceButtonTextForSharedCard(sharedResourceCard), TestData.GO_TO_RESOURCE_BUTTON_TEXT);
        Assert.assertEquals(discoverResourcesPage.getSeePreviewInThumbnailViewButtonTextForSharedCard(sharedResourceCard), TestData.SEE_PREVIEW_BUTTON_TEXT);

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

    private WebElement getLpResourceCard(String account, boolean freeSample, boolean inThumbnailView) {
        discoverResourcesPage.waitForLoad();
        WebElement lpResourceCard;

        if (account.equals(TestData.PLAN_VISITOR) || account.equals(TestData.PLAN_FREEMIUM)) {
            if (freeSample) {
                if (inThumbnailView) {
                    lpResourceCard = discoverResourcesPage.getSampleResourceCardsInThumbnailView().get(0);
                } else {
                    lpResourceCard = discoverResourcesPage.getSampleResourceCards().get(0);
                }
            } else {
                if (inThumbnailView) {
                    lpResourceCard = discoverResourcesPage.getLimitedLpResourcesCardsInThumbnailView().get(0);
                } else {
                    lpResourceCard = discoverResourcesPage.getLimitedLpResourcesCards().get(0);
                }
            }
        } else {
            lpResourceCard = discoverResourcesPage.getFullLpResourcesCards().get(0);
        }
        return lpResourceCard;
    }

    private void verifyLpResourceButtons(String account, boolean freeSample, WebElement lpResourceCard) {
        if (account.equals(TestData.PLAN_VISITOR) || account.equals(TestData.PLAN_FREEMIUM)) {
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

    protected void testSeeFullReviewButton(String account) {
        reachSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeeFullReview(true);
        if (account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            checkRrpSample(false, false, false);
        } else {
            checkRrpSample(false, false, true);
        }
        rrpPage.closeTab();
        discoverResourcesPage.clickSeeFullReview(false);
        rrpModal.waitForModal();
        if (account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            checkRrpSample(false, false, false);
        } else {
            checkRrpSample(false, false, true);
        }
    }
}
