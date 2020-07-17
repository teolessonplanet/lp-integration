import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RrpDirectoryPageTest extends BaseTest {
    private BrowseBySubjectPage browseBySubjectPage;
    private CollectionRrpModal collectionRrpModal;
    private CollectionRrpPage collectionRrpPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private RrpSearchPageTest rrpSearchPageTest;
    private RrpModal rrpModal;
    private StepTwoPage stepTwoPage;

    @BeforeMethod
    public void beforeMethod() {
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
        collectionRrpModal = new CollectionRrpModal(webDriver);
        rrpModal = new RrpModal(webDriver);
        collectionRrpPage = new CollectionRrpPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        rrpSearchPageTest = new RrpSearchPageTest();
        stepTwoPage = new StepTwoPage(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
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
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testLpResourceOverview(TestData.PLAN_FREEMIUM, true);
    }

    @Test(description = "Freemium - Directory Page - RRP Static - RRP Overview - lessonp-4703:Resource Static Page Overview")
    public void testLessonp_4703() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testLpResourceOverview(TestData.PLAN_FREEMIUM, false);
    }

    @Test(description = "Active - Directory Page - RRP Modal - RRP Overview - lessonp-4846:Resource Modal Overview")
    public void testLessonp_4846() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testLpResourceOverview(TestData.PLAN_PRO, true);
    }

    @Test(description = "Active - Directory Page - RRP Static - RRP Overview - lessonp-4824:Resource Static Page Overview")
    public void testLessonp_4824() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testLpResourceOverview(TestData.PLAN_PRO, false);
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
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testCollectionOverview(TestData.PLAN_FREEMIUM, true);
    }

    @Test(description = "Freemium - Directory Page - RRP Static - RRP Overview - lessonp-4705:Collection Static Page Overview")
    public void testLessonp_4705() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testCollectionOverview(TestData.PLAN_FREEMIUM, false);
    }

    @Test(description = "Active user - Directory Page - RRP Modal - RRP Overview - lessonp-4847:Collection Modal Overview")
    public void testLessonp_4847() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testCollectionOverview(TestData.PLAN_PRO, true);
    }

    @Test(description = "Active user - Directory Page - RRP Static - RRP Overview - lessonp-4826:Collection Static Page Overview")
    public void testLessonp_4826() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testCollectionOverview(TestData.PLAN_PRO, false);
    }

    @Test(description = " Visitor - Directory Page - RRP Modal - RRP Buttons: lessonp-4612: LP Resource Main Buttons")
    public void testLessonp_4612() {
        testLpResourceMainButtonsForVisitor(true);
    }

    @Test(description = "Visitor - Directory Page - RRP Static - RRP Buttons - lessonp-4610: LP Resource Main Buttons")
    public void testLessonp_4610() {
        testLpResourceMainButtonsForVisitor(false);
        rrpSearchPageTest.testStartYourFreeTrialTryItFreeButton();
        rrpSearchPageTest.testSeeSimilarResourcesDropdown();
        rrpSearchPageTest.testSeeSimilarResourcesTryItFreeButton();
    }

    @Test(description = "Freemium - Directory page - Rrp Modal - Rrp Buttons - Lp resources - lessonp-4684:Main Buttons")
    public void testLessonp_4684() {
        testLpResourceMainButtons(true);
    }

    @Test(description = "Freemium - Directory page - Rrp Static - Rrp Buttons - Lp resources - lessonp-4713:Main Buttons")
    public void testLessonp_4713() {
        testLpResourceMainButtons(false);
    }

    @Test(description = "Active user - Directory page - Rrp Modal - Rrp Buttons - Lp resources - lessonp-4849:Main Buttons")
    public void testLessonp_4849() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testLpResourceMainButtonsForActiveUser(true);
    }

    @Test(description = "Active user - Directory page - Rrp Static - Rrp Buttons - Lp Resources - lessonp-4827:Main Buttons")
    public void testLessonp_4827() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testLpResourceMainButtonsForActiveUser(false);
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

    @Test(description = "Freemium - Directory page - Rrp Modal - Rrp Buttons - Collections - lessonp-4696:Main Buttons")
    public void testLessonp_4696() {
        testCollectionButtonsForFreemium(true);
    }

    @Test(description = "Freemium - Directory page - Rrp Static - Rrp Buttons - Collections - lessonp-4725:Main Buttons")
    public void testLessonp_4725() {
        testCollectionButtonsForFreemium(false);
    }

    @Test(description = "Active user - Directory page - Rrp Modal - Rrp Buttons - Collections - lessonp-4825:Main Buttons")
    public void testLessonp_4825() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        reachDirectoryPage();
        browseBySubjectPage.clickSeeCollection(true);
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testCollectionMainButtons(true, TestData.PLAN_PRO);
    }

    @Test(description = "Active user - Directory page - Rrp Static - Rrp Buttons - lessonp-5627:Collection Main Buttons")
    public void testLessonp_5627() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        reachDirectoryPage();
        browseBySubjectPage.clickSeeCollection(true);
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testCollectionRRPOverview(false, TestData.PLAN_PRO);
        rrpSearchPageTest.testPanelItemsOverview(false);
    }

    protected void testLpResourceOverview(String accountPlan, boolean inModal) {
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

    private void testLpResourceMainButtons(boolean inModal) {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        reachDirectoryPage();
        browseBySubjectPage.clickSeeReview(!inModal);
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testLpResourceMainButtons(inModal, false);
    }

    protected void testLpResourceMainButtonsForActiveUser(boolean inModal) {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeReview(!inModal);
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testRegularResourceRRPOverview(inModal, TestData.PLAN_PRO);
    }

    private void testLpResourceMainButtonsForVisitor(boolean inModal) {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeReview(!inModal);
        if (inModal) {
            Assert.assertTrue(rrpModal.getModalId().contains(browseBySubjectPage.getRegularResourceCardDataId(0)));
        }
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testFavoriteButton(inModal);
        rrpSearchPageTest.testResourceGetFreeAccessForTenDaysButton(inModal);
        rrpSearchPageTest.testThumbnailForRegularResource(inModal, TestData.PLAN_VISITOR);
    }

    private void testCollectionButtonsForFreemium(boolean inModal) {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        reachDirectoryPage();
        browseBySubjectPage.clickSeeCollection(!inModal);

        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testCollectionMainButtonsForFreemium(inModal);
    }

    protected void testCollectionOverview(String accountPlan, boolean inModal) {
        reachDirectoryPage();
        browseBySubjectPage.clickSeeCollection(!inModal);
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testCollectionRRPOverview(inModal, accountPlan);
        rrpSearchPageTest.testPanelItemsOverview(inModal);
    }
}
