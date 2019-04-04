import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RRPDirectoryPageTest extends BaseTest {
    private BrowseBySubjectPage browseBySubjectPage;
    private CollectionRrpModal collectionRrpModal;
    private CollectionRrpPage collectionRrpPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private RRPSearchPageTest rrpSearchPageTest;
    private RrpModal rrpModal;

    @BeforeMethod
    public void beforeMethod() {
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
        collectionRrpModal = new CollectionRrpModal(webDriver);
        rrpModal = new RrpModal(webDriver);
        collectionRrpPage = new CollectionRrpPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        rrpSearchPageTest = new RRPSearchPageTest();
    }

    public void reachDirectoryPage(){
        discoverResourcesPage.loadSearchPageInListView();
        browseBySubjectPage.loadPage(TestData.LITERATURE_PAGE_PATH);
    }


    @Test(description = "Visitor: [Directory: RRP Modal - RRP Overview]: lessonp-3284: Resource Modal Overview")
    public void testLessonp_3284() {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeReview(false);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testRegularResourceRRPOverview(true);
    }

    @Test(description = "Visitor: [Directory: RRP Modal - RRP Overview]: lessonp-3285: Collection Modal Overview")
    public void testLessonp_3285() {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeCollection(false);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testCollectionRRPOverview(true);
        rrpSearchPageTest.testPanelItemsOverview(true);
    }

    @Test(description = "Visitor: [Directory: RRP Static - RRP Overview]: lessonp-3308: Resource Static Page Overview)")
    public void testLessonp_3308() {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeReview(true);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testRegularResourceRRPOverview(false);
        rrpSearchPageTest.testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE);
        rrpSearchPageTest.testSimilarResourcesSectionOverview();
    }

    @Test(description = "Visitor: [Directory: RRP Static - RRP Overview]: lessonp-3309: Collection Static Page Overview")
    public void testLessonp_3309() {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeCollection(true);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testCollectionRRPOverview(false);
        rrpSearchPageTest.testPanelItemsOverview(false);
    }

    @Test(description = "Visitor: [Directory: RRP Modal - RRP Buttons -LP Resources]: lessonp-4612: Main Buttons")
    public void testLessonp_4612() {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeReview(false);
        testRegularResourceRRPNavigationButtonsDirectoryPage();
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testFavoriteButton(true);
        discoverResourcesPage.closeTab();
        rrpSearchPageTest.testJoinToSeeThisResourceButton(true);
        discoverResourcesPage.closeTab();
        rrpSearchPageTest.testThumbnail(true, true);
    }

    @Test(description = "Visitor: [Directory: RRP Modal - RRP Buttons - Collections]: lessonp-4611: Main Buttons")
    public void testLessonp_4611() {
        reachDirectoryPage();
        String firstCollectionCardTitle = browseBySubjectPage.getCollectionCardTitle(0);
        String secondCollectionCardTitle = browseBySubjectPage.getCollectionCardTitle(1);
        browseBySubjectPage.clickSeeCollection(false);
        testCollectionRRPNavigationButtonsDirectoryPage(firstCollectionCardTitle, secondCollectionCardTitle);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testSaveCollectionButton(true);
        discoverResourcesPage.closeTab();
        rrpSearchPageTest.testJoinForFullReviewButton(true);
        discoverResourcesPage.closeTab();
        collectionRrpModal.clickPanelItem(0);
        rrpSearchPageTest.testItemViewerSection(true);
        collectionRrpModal.clickSeeFullReviewsLink();
        rrpSearchPageTest.testItemViewerSection(true);
    }

    @Test(description = "Visitor: [Directory: RRP Static - RRP Buttons - LP Resources]: lessonp-4610: Main Buttons")
    public void testLessonp_4610() {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeReview(true);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testFavoriteButton(false);
        discoverResourcesPage.closeTab();
        rrpSearchPageTest.testJoinToSeeThisResourceButton(false);
        discoverResourcesPage.closeTab();
        rrpSearchPageTest.testThumbnail(false, true);
        rrpSearchPageTest.testStartYourFreeTrialTryItFreeButton();
        discoverResourcesPage.closeTab();
        rrpSearchPageTest.testSeeSimilarResourcesDropdown();
        rrpSearchPageTest.testSeeSimilarResourcesTryItFreeButton();
    }

    @Test(description = "Visitor: [Directory: RRP Static - RRP Buttons - Collections]: lessonp-4613: Main Buttons")
    public void testLessonp_4613() {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeCollection(true);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testSaveCollectionButton(false);
        discoverResourcesPage.closeTab();
        rrpSearchPageTest.testJoinForFullReviewButton(false);
        discoverResourcesPage.closeTab();
        collectionRrpPage.clickPanelItem(0);
        rrpSearchPageTest.testItemViewerSection(false);
        collectionRrpPage.clickSeeFullReviewsLink();
        rrpSearchPageTest.testItemViewerSection(false);
    }

    private void testRegularResourceRRPNavigationButtonsDirectoryPage(){
        Assert.assertTrue(rrpModal.getModalId().contains(browseBySubjectPage.getRegularResourceCardDataId(0)));
        Assert.assertTrue(rrpModal.isNextButtonDisplayed());
        rrpModal.clickNextButton();
        Assert.assertTrue(rrpModal.getModalId().contains(browseBySubjectPage.getRegularResourceCardDataId(1)));
        rrpModal.clickPreviousButton();
        Assert.assertTrue((rrpModal.getModalId().contains(browseBySubjectPage.getRegularResourceCardDataId(0))));
    }

    private void testCollectionRRPNavigationButtonsDirectoryPage(String firstCollectionCardTitle, String secondCollectionCardTitle){
        Assert.assertEquals(collectionRrpModal.getCollectionTitleText(), firstCollectionCardTitle);
        collectionRrpModal.clickNextButtonRrp();
        if(rrpModal.getModalId().contains("collection")) {
            Assert.assertEquals(collectionRrpModal.getCollectionTitleText(), secondCollectionCardTitle);
        } else{
            Assert.assertTrue(rrpModal.isTitleDisplayed());
        }
        collectionRrpModal.clickPreviousButtonRrp();
        Assert.assertEquals(collectionRrpModal.getCollectionTitleText(), firstCollectionCardTitle);
    }
}
