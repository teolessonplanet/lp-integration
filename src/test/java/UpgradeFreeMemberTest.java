import com.lessonplanet.pages.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;
import java.util.List;

public class UpgradeFreeMemberTest extends BaseTest {

    private LpHomePage lpHomePage;
    private DiscoverResourcesPage discoverResourcesPage;
    private StepOnePage stepOnePage;
    private StepTwoPage stepTwoPage;
    private RrpPage rrpPage;
    private UpgradeMaxItemsCollectionModal upgradeMaxItemsCollectionModal;
    private CollectionBuilderPage collectionBuilderPage;
    private CollectionRrpModal collectionRrpModal;
    private EditCollectionModal editCollectionModal;
    private HeaderPage headerPage;
    private MyAccountPage myAccountPage;
    private StateStandardsPage stateStandardsPage;
    private BrowseBySubjectPage browseBySubjectPage;
    private StartYourTenDayFreeTrialWidget startYourTenDayFreeTrialWidget;
    private CurriculumManagerTest curriculumManagerTest;
    private RrpModal rrpModal;
    private ArticlesPage articlesPage;
    private TestimonialsPage testimonialsPage;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        stepOnePage = new StepOnePage(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        rrpPage = new RrpPage(webDriver);
        upgradeMaxItemsCollectionModal = new UpgradeMaxItemsCollectionModal(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        collectionRrpModal = new CollectionRrpModal(webDriver);
        editCollectionModal = new EditCollectionModal(webDriver);
        headerPage = new HeaderPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        startYourTenDayFreeTrialWidget = new StartYourTenDayFreeTrialWidget(webDriver);
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
        stateStandardsPage = new StateStandardsPage(webDriver);
        curriculumManagerTest = new CurriculumManagerTest();
        rrpModal = new RrpModal(webDriver);
        articlesPage = new ArticlesPage(webDriver);
        testimonialsPage = new TestimonialsPage(webDriver);
        createAFreeMemberAccount();
    }

    private void createAFreeMemberAccount(){
        lpHomePage.loadPage();
        stepOnePage.completeStepOne(TestData.GET_NEW_EMAIL(), TestData.VALID_PASSWORD);
    }

    @Test(description = "lessonp-687: Free member clicks the <Get Free Access> button on a resource card")
    public void testLessonp_687() {
        testUpgradeFreeMemberFromGetFreeAccessButton();
    }

    @Test(description = "lessonp-688: Free member clicks the <Upgrade for Full Review> button on the RRP")
    public void testLessonp_688() {
        testUpgradeFreeMemberFromUpgradeForFullReviewButton();
    }

    @Test(description = "lessonp-686: Free member tries to upload a file from Collection Builder, Curriculum Manager and Edit Collection Modal")
    public void testLessonp_686() {
        testUpgradeFreeMemberFromUploadButtonFromCollectionBuilder();
        testUpgradeFreeMemberFromUploadButtonFromCurriculumManagerPage();
        testUpgradeFreeMemberFromUploadButtonFromEditCollectionModal();
    }

    @Test(description = "lessonp-684: Free members exceeds the allowed nr of collections created")
    public void testLessonp_684() {
        testUpgradeFreeMemberFromExceededNumberOfCollectionsCreated();
    }

    @Test(description = "lessonp-1000:Free member tries to save a 4th collection")
        public void testLessonp_1000() {
        testUpgradeFreeMemberFromExceededNumberOfCollectionsSaved();
    }

    @Test(description = "lessonp-690:Free member tries to assign a favorite resource and a collection")
    public void testLessonp_690() {
        testUpgradeFreeMemberFromAssignResource();
        testUpgradeFreeMemberFromAssignCollection();
    }

    @Test(description = "lessonp-685:Free members exceeds the allowed nr of items inside a created collection")
    public void testLessonp_685() {
        testUpgradeFreeMemberFromExceededNumberOfItemsInsideACreatedCollection();
    }

    @Test(description = "lessonp-689:Free member tries to save a collection containing more than 10 items")
    public void testLessonp_689() {
        testUpgradeFreeMemberFromExceededNumberOfItemsInsideASavedCollection();
    }

    @Test(description = "lessonp-3884: Freemium member clicks any of the <Upgrade Me> or <Get Full Access> buttons")
    public void testLessonp_3884() {
        testUpgradeFreeMemberFromUpgradeMeButton();
        testUpgradeFreeMemberFromGetFullAccessButton();
    }

    private void testUpgradeFreeMemberFromGetFreeAccessButton(){
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickGetFreeAccess(true);
        checkPageTitleAndPageUrl();
    }

    private void checkPageTitleAndPageUrl(){
        Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE );
        Assert.assertTrue(lpHomePage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
    }

    private void testUpgradeFreeMemberFromUpgradeForFullReviewButton(){
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        rrpModal.waitForModal();
        rrpModal.clickOnUpgradeForFullReviewButton(true);
        checkPageTitleAndPageUrl();
    }

    private void testUpgradeFreeMemberFromUploadButtonFromCollectionBuilder(){
        discoverResourcesPage.loadPage();
        collectionBuilderPage.clickOnUploadButton();
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testUpgradeModalFromUploadButton();
    }

    private void testUpgradeFreeMemberFromUploadButtonFromCurriculumManagerPage(){
        curriculumManagerTest.testUploadResourceUsingTextInput(TestData.FREE_MEMBERSHIP_TEXT);
    }

    private void testUpgradeFreeMemberFromUploadButtonFromEditCollectionModal(){
        curriculumManagerTest.testCreateCollectionFromCollectionBuilder();
        collectionBuilderPage.clickOnEditCollection();
        editCollectionModal.waitForModal();
        editCollectionModal.clickOnUploadAFileButton();
        curriculumManagerTest.testUpgradeModalFromUploadButton();
    }

    private void testUpgradeFreeMemberFromExceededNumberOfCollectionsCreated(){
        curriculumManagerTest = new CurriculumManagerTest();
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testMaxLimitOfCollectionsCreated();
    }

    private void testUpgradeFreeMemberFromExceededNumberOfCollectionsSaved(){
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testCreateThreeCollections();
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        collectionRrpModal.waitForModal();
        collectionRrpModal.clickOnSaveCollectionButton();
        curriculumManagerTest.testUpgradeModalFromMaxCollectionLimit();
    }

    private void testUpgradeFreeMemberFromAssignResource() {
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testFavoriteRegularResource(TestData.FREE_MEMBERSHIP_TEXT);
        curriculumManagerTest.testAssignResource(TestData.FREE_MEMBERSHIP_TEXT, TestData.ASSIGN_RESOURCE_MODAL_TEXT);
    }

    private void testUpgradeFreeMemberFromAssignCollection(){
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testCreateCollectionFromCurriculumManager(TestData.NEW_COLLECTION_NAME);
        curriculumManagerTest.testAddRequiredInformationToCollection(TestData.FREE_MEMBERSHIP_TEXT);
        curriculumManagerTest.testAssignResource(TestData.FREE_MEMBERSHIP_TEXT, TestData.ASSIGN_COLLECTION_MODAL_TEXT);
    }

    private void testUpgradeFreeMemberFromExceededNumberOfItemsInsideACreatedCollection(){
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testCreateCollectionFromCollectionBuilder();
        discoverResourcesPage.clickOnListView();
        List<WebElement> getFreeAccessResources = discoverResourcesPage.getAllFreeAccessButtons();
        for (int i=0; i<=10; i++){
            discoverResourcesPage.dragAndDrop(getFreeAccessResources.get(i), collectionBuilderPage.getCollectionDroppableZone());
        }
        testUpgradeModalFromMaxItemsInsideCollection(TestData.UPGRADE_MODAL_TEXT_FROM_EXCEEDED_ITEMS_INSIDE_CREATED_COLLECTION);
    }

    private void testUpgradeFreeMemberFromExceededNumberOfItemsInsideASavedCollection(){
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        while (collectionRrpModal.getItemsCount()<=10){
            collectionRrpModal.clickCloseModal();
            discoverResourcesPage.clickOnNextButton();
            discoverResourcesPage.clickSeeCollection(false);
        }
        collectionRrpModal.clickOnSaveCollectionButton();
        testUpgradeModalFromMaxItemsInsideCollection(TestData.UPGRADE_MODAL_TEXT_FROM_EXCEEDED_ITEMS_INSIDE_SAVED_COLLECTION);
    }

    private void testUpgradeModalFromMaxItemsInsideCollection (String bodyText){
        upgradeMaxItemsCollectionModal.waitForModal();
        Assert.assertEquals(upgradeMaxItemsCollectionModal.getUpgradeModalText(), bodyText);
        upgradeMaxItemsCollectionModal.clickOnUpgradeMeButton();
        checkPageTitleAndPageUrl();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButton(){
        testUpgradeFreeMemberFromUpgradeMeButtonFromHeader();
        testUpgradeFreeMemberFromUpgradeMeButtonFromStartYourFreeTrialRrpPage();
        testUpgradeFreeMemberFromUpgradeMeButtonFromRrpPage();
        testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMemberSayDirectoryPage();
        testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMemberSayArticlesPage();
        testUpgradeFreeMemberFromUpgradeMeButtonFromMyAccountPage();
        testUpgradeFreeMemberFromUpgradeMeButtonFromHomePage();
    }

    private void testUpgradeFreeMemberFromGetFullAccessButton(){
        testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialStandardsPage();
        testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialDirectoryPage();
        testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialArticlesPage();
        testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialTestimonialsPage();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromHeader(){
        lpHomePage.loadPage();
        headerPage.clickOnUpgradeMeButton(true);
        checkPageTitleAndPageUrl();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromStartYourFreeTrialRrpPage(){
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        rrpPage.clickOnStartYourFreeTrialGreenButton(true);
        checkPageTitleAndPageUrl();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromRrpPage(){
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        rrpPage.clickOnGreenButtonFromBottomPage(true);
        checkPageTitleAndPageUrl();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMemberSayDirectoryPage(){
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
//        browseBySubjectPage.clickWhatMembersSayGreenButton(true);
        checkPageTitleAndPageUrl();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMemberSayArticlesPage(){
        articlesPage.loadPage();
     //   articlesPage.clickWhatMembersSayGreenButton(true);
        checkPageTitleAndPageUrl();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromMyAccountPage(){
        myAccountPage.loadPage();
        myAccountPage.clickOnUpgradeMeButton(true);
        checkPageTitleAndPageUrl();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromHomePage(){
        lpHomePage.loadPage();
        lpHomePage.clickOnUpgradeMeButton(true);
        checkPageTitleAndPageUrl();
    }

    private void testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialDirectoryPage(){
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(true);
   //     testStepTwoPageUrlAndTitle();
        }

    private void testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialStandardsPage(){
        stateStandardsPage.loadPage();
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(true);
     //   testStepTwoPageUrlAndTitle();
    }

    private void testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialArticlesPage(){
        articlesPage.loadPage();
    //    startYourTenDayFreeTrialWidget.clickStartYourTenDaysFreeTrialGreenButton(true);
        checkPageTitleAndPageUrl();
    }

    private void testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialTestimonialsPage(){
        testimonialsPage.loadPage();
    //    startYourTenDayFreeTrialWidget.clickStartYourTenDaysFreeTrialGreenButton(true);
        checkPageTitleAndPageUrl();
    }
}
