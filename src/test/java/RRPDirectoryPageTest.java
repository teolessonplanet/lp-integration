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
    private StepTwoPage stepTwoPage;

    @BeforeMethod
    public void beforeMethod() {
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
        collectionRrpModal = new CollectionRrpModal(webDriver);
        rrpModal = new RrpModal(webDriver);
        collectionRrpPage = new CollectionRrpPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        rrpSearchPageTest = new RRPSearchPageTest();
        stepTwoPage = new StepTwoPage(webDriver);
    }

    public void reachDirectoryPage() {
        discoverResourcesPage.loadSearchPageInListView();
        browseBySubjectPage.loadPage(TestData.SOCIAL_AND_EMOTIONAL_LEARNING_PATH);
    }

    @Test(description = "Visitor - Directory Page - RRP Modal - RRP Overview: lessonp-3284: Resource Modal Overview")
    public void testLessonp_3284() {
        testLpResourceOverview(TestData.PLAN_VISITOR, true);
    }

    @Test(description = "Visitor - Directory Page - RRP Static - RRP Overview: lessonp-3308: Resource Static Page Overview)")
    public void testLessonp_3308() {
        testLpResourceOverview(TestData.PLAN_VISITOR, false);
    }

    @Test(description = "Freemium - Directory Page - RRP Modal - RRP Overview - lessonp-4674:LP Resource Modal Overview")
    public void testLessonp_4674() {
        testLpResourceOverview(TestData.PLAN_FREEMIUM, true);
    }

    @Test(description = "Freemium - Directory Page - RRP Static - RRP Overview - lessonp-4703:Resource Static Page Overview")
    public void testLessonp_4703() {
        testLpResourceOverview(TestData.PLAN_FREEMIUM, false);
    }

    @Test(description = "Active - Directory Page - RRP Modal - RRP Overview - lessonp-4846:Resource Modal Overview")
    public void testLessonp_4846() {
        testLpResourceOverview(TestData.PLAN_PRO, true);
    }

    @Test(description = "Active - Directory Page - RRP Static - RRP Overview - lessonp-4824:Resource Static Page Overview")
    public void testLessonp_4824() {
        testLpResourceOverview(TestData.PLAN_PRO, false);
    }

    private void testLpResourceOverview(String accountPlan, boolean inModal) {
        stepTwoPage.createNewAccount(accountPlan);
        reachDirectoryPage();
        browseBySubjectPage.clickSeeReview(!inModal);
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testRegularResourceRRPOverview(inModal, accountPlan);
        if (!inModal) {
            if (accountPlan.equals(TestData.PLAN_VISITOR) || accountPlan.equals(TestData.PLAN_FREEMIUM)) {
                rrpSearchPageTest.testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE, accountPlan);
            }
            rrpSearchPageTest.testSimilarResourcesSectionOverview(accountPlan);
        }
    }

    @Test(description = "Visitor - Directory Page - RRP Modal - RRP Overview: lessonp-3285: Collection Modal Overview")
    public void testLessonp_3285() {
        testCollectionOverview(TestData.PLAN_VISITOR, true);
    }

    @Test(description = "Visitor - Directory Page  - RRP Static - RRP Overview: lessonp-3309: Collection Static Page Overview")
    public void testLessonp_3309() {
        testCollectionOverview(TestData.PLAN_VISITOR, false);
    }

    @Test(description = "Freemium - Directory Page - RRP Modal - RRP Overview - lessonp-4677:Collection Modal Overview")
    public void testLessonp_4677() {
        testCollectionOverview(TestData.PLAN_FREEMIUM, true);
    }

    @Test(description = "Freemium - Directory Page - RRP Static - RRP Overview - lessonp-4705:Collection Static Page Overview")
    public void testLessonp_4705() {
        testCollectionOverview(TestData.PLAN_FREEMIUM, false);
    }

    @Test(description = "Active user - Directory Page - RRP Modal - RRP Overview - lessonp-4847:Collection Modal Overview")
    public void testLessonp_4847() {
        testCollectionOverview(TestData.PLAN_PRO, true);
    }

    @Test(description = "Active user - Directory Page - RRP Static - RRP Overview - lessonp-4826:Collection Static Page Overview")
    public void testLessonp_4826() {
        testCollectionOverview(TestData.PLAN_PRO, false);
    }

    private void testCollectionOverview(String accountPlan, boolean inModal) {
        stepTwoPage.createNewAccount(accountPlan);
        reachDirectoryPage();
        browseBySubjectPage.clickSeeCollection(!inModal);
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testCollectionRRPOverview(inModal, accountPlan);
        rrpSearchPageTest.testPanelItemsOverview(inModal);
    }

    @Test(description = " Visitor - Directory Page - RRP Modal - RRP Buttons: lessonp-4612: LP Resource Main Buttons")
    public void testLessonp_4612() {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeReview(false);
        Assert.assertTrue(rrpModal.getModalId().contains(browseBySubjectPage.getRegularResourceCardDataId(0)));
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testFavoriteButton(true);
        rrpSearchPageTest.testResourceGetFreeAccessForTenDaysButton(true);
        rrpSearchPageTest.testThumbnailForRegularResource(true, TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - Directory Page - RRP Modal - RRP Buttons - lessonp-4611: Collection Main Buttons")
    public void testLessonp_4611() {
        reachDirectoryPage();
        String firstCollectionCardTitle = browseBySubjectPage.getCollectionCardTitle(0);
        browseBySubjectPage.clickSeeCollection(false);
        Assert.assertEquals(collectionRrpModal.getCollectionTitleText(), firstCollectionCardTitle);
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testSaveCollectionButton(true, TestData.PLAN_VISITOR);
        rrpSearchPageTest.testCollectionGetFreeAccessForTenDaysButton(true);
        collectionRrpModal.clickPanelItem(0);
        rrpSearchPageTest.testItemViewerSection(true);
        collectionRrpModal.clickSeeFullReviewsLink();
        rrpSearchPageTest.testItemViewerSection(true);
    }

    @Test(description = "Visitor - Directory Page - RRP Static - RRP Buttons - lessonp-4613: Collection Main Buttons")
    public void testLessonp_4613() {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeCollection(true);
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testSaveCollectionButton(false, TestData.PLAN_VISITOR);
        rrpSearchPageTest.testCollectionGetFreeAccessForTenDaysButton(false);
        collectionRrpPage.clickPanelItem(0);
        rrpSearchPageTest.testItemViewerSection(false);
        collectionRrpPage.clickSeeFullReviewsLink();
        rrpSearchPageTest.testItemViewerSection(false);
    }
}
