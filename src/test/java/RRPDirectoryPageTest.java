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

    public void reachDirectoryPage() {
        discoverResourcesPage.loadSearchPageInListView();
        browseBySubjectPage.loadPage(TestData.LANGUAGE_ARTS_RESEAERCH_PAGE_2_PATH);
    }

    @Test(description = "Visitor - Directory Page - RRP Modal - RRP Overview: lessonp-3284: Resource Modal Overview")
    public void testLessonp_3284() {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeReview(false);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testRegularResourceRRPOverview(true, TestData.INVALID_EMAIL);
    }

    @Test(description = "Visitor - Directory Page - RRP Modal - RRP Overview: lessonp-3285: Collection Modal Overview")
    public void testLessonp_3285() {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeCollection(false);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testCollectionRRPOverview(true, TestData.INVALID_EMAIL);
        rrpSearchPageTest.testPanelItemsOverview(true);
    }

    @Test(description = "Visitor - Directory Page - RRP Static - RRP Overview: lessonp-3308: Resource Static Page Overview)")
    public void testLessonp_3308() {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeReview(true);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testRegularResourceRRPOverview(false, TestData.INVALID_EMAIL);
        rrpSearchPageTest.testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE, TestData.INVALID_EMAIL);
        rrpSearchPageTest.testSimilarResourcesSectionOverview(TestData.INVALID_EMAIL);
    }

    @Test(description = "Visitor - Directory Page  - RRP Static - RRP Overview: lessonp-3309: Collection Static Page Overview")
    public void testLessonp_3309() {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeCollection(true);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testCollectionRRPOverview(false, TestData.INVALID_EMAIL);
        rrpSearchPageTest.testPanelItemsOverview(false);
    }

    @Test(description = " Visitor - Directory Page - RRP Modal - RRP Buttons: lessonp-4612: LP Resource Main Buttons")
    public void testLessonp_4612() {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeReview(false);
        Assert.assertTrue(rrpModal.getModalId().contains(browseBySubjectPage.getRegularResourceCardDataId(0)));
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testFavoriteButton(true);
        rrpSearchPageTest.testResourceGetFreeAccessForTenDaysButton(true);
        rrpSearchPageTest.testThumbnailForRegularResource(true, TestData.INVALID_EMAIL);
    }

    @Test(description = "Visitor - Directory Page - RRP Modal - RRP Buttons - lessonp-4611: Collection Main Buttons")
    public void testLessonp_4611() {
        reachDirectoryPage();
        String firstCollectionCardTitle = browseBySubjectPage.getCollectionCardTitle(0);
        browseBySubjectPage.clickSeeCollection(false);
        Assert.assertEquals(collectionRrpModal.getCollectionTitleText(), firstCollectionCardTitle);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testSaveCollectionButton(true, TestData.INVALID_EMAIL);
        rrpSearchPageTest.testCollectionGetFreeAccessForTenDaysButton(true);
        collectionRrpModal.clickPanelItem(0);
        rrpSearchPageTest.testItemViewerSection(true);
        collectionRrpModal.clickSeeFullReviewsLink();
        rrpSearchPageTest.testItemViewerSection(true);
    }

    @Test(description = "Visitor - Directory Page - RRP Static - RRP Buttons - lessonp-4610: LP Resource Main Buttons")
    public void testLessonp_4610() {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeReview(true);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testFavoriteButton(false);
        rrpSearchPageTest.testResourceGetFreeAccessForTenDaysButton(false);
        rrpSearchPageTest.testThumbnailForRegularResource(false, TestData.INVALID_EMAIL);
        rrpSearchPageTest.testStartYourFreeTrialTryItFreeButton();
        rrpSearchPageTest.testSeeSimilarResourcesDropdown();
        rrpSearchPageTest.testSeeSimilarResourcesTryItFreeButton();
    }

    @Test(description = "Visitor - Directory Page - RRP Static - RRP Buttons - lessonp-4613: Collection Main Buttons")
    public void testLessonp_4613() {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeCollection(true);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testSaveCollectionButton(false, TestData.INVALID_EMAIL);
        rrpSearchPageTest.testCollectionGetFreeAccessForTenDaysButton(false);
        collectionRrpPage.clickPanelItem(0);
        rrpSearchPageTest.testItemViewerSection(false);
        collectionRrpPage.clickSeeFullReviewsLink();
        rrpSearchPageTest.testItemViewerSection(false);
    }
}
