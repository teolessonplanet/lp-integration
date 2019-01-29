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
    private StepTwoModal stepTwoModal;
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
        stepTwoModal = new StepTwoModal(webDriver);
        rrpPage = new RrpPage(webDriver);
        rrpModal = new RrpModal(webDriver);
        curriculumManagerTest = new CurriculumManagerTest();
        upgradeMaxItemsCollectionModal = new UpgradeMaxItemsCollectionModal(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        collectionRrpModal = new CollectionRrpModal(webDriver);
        editCollectionModal = new EditCollectionModal(webDriver);
        headerPage = new HeaderPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        startYourTenDayFreeTrialWidget = new StartYourTenDayFreeTrialWidget(webDriver);
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
        stateStandardsPage = new StateStandardsPage(webDriver);
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
        testUpgradeFreeMemberFromUploadButtonFromEditCollectionModal();
        testUpgradeFreeMemberFromUploadButtonFromCurriculumManagerPage();
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
        testUpgradeFreeMemberFromUpgradeMeButtons();
        testUpgradeFreeMemberFromGetFullAccessButtons();
    }

    private void testUpgradeFreeMemberFromGetFreeAccessButton(){
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickGetFreeAccess(true);
        Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE );
        discoverResourcesPage.closeTab();
        discoverResourcesPage.clickGetFreeAccess(false);
        Assert.assertEquals(stepTwoModal.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
    }

    private void testUpgradeFreeMemberFromUpgradeForFullReviewButton(){
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        rrpModal.waitForModal();
        rrpModal.clickOnUpgradeForFullReviewButton(true);
        Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE );
        discoverResourcesPage.closeTab();
        rrpModal.clickOnUpgradeForFullReviewButton(false);
        Assert.assertEquals(stepTwoModal.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
    }

    private void testUpgradeFreeMemberFromUploadButtonFromCollectionBuilder(){
        discoverResourcesPage.loadPage();
        collectionBuilderPage.clickOnUploadButton();
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testUpgradeModalFromUploadButton();
    }

    private void testUpgradeFreeMemberFromUploadButtonFromEditCollectionModal(){
        curriculumManagerTest.testCreateCollectionFromCollectionBuilder();
        collectionBuilderPage.clickOnEditCollection();
        editCollectionModal.waitForModal();
        editCollectionModal.clickOnUploadAFileButton();
        curriculumManagerTest.testUpgradeModalFromUploadButton();
    }

    private void testUpgradeFreeMemberFromUploadButtonFromCurriculumManagerPage(){
        curriculumManagerTest.testUploadResourceUsingTextInput(TestData.FREE_MEMBERSHIP_TEXT);
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
        while (collectionRrpModal.getCollectionItemsCount()<=10){
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
        Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE );
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtons(){
        testUpgradeFreeMemberFromUpgradeMeButtonFromHeader();
        testUpgradeFreeMemberFromUpgradeMeButtonFromStartYourFreeTrialWidgetRrpPage();
        testUpgradeFreeMemberFromUpgradeMeButtonFromRrpPage();
        testUpgradeFreeMemberFromUpgradeMeButtonFromMyAccountPage();testUpgradeFreeMemberFromUpgradeMeButtonFromHomePage();
        testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMembersSayWidgetDirectoryPage();
        testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMembersSayWidgetArticlesPage();
    }

    private void testUpgradeFreeMemberFromGetFullAccessButtons(){
        testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialWidgetDirectoryPage();
        testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialWidgetStandardsPage();
        testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialWidgetArticlesPage();
        testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialWidgetTestimonialsPage();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromHeader(){
        lpHomePage.loadPage();
        headerPage.clickOnUpgradeMeButton(true);
        Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE );
        headerPage.closeTab();
        headerPage.clickOnUpgradeMeButton(false);
        Assert.assertEquals(stepTwoModal.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromStartYourFreeTrialWidgetRrpPage(){
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        rrpPage.clickOnStartYourFreeTrialSubscriptionButton(true);
        Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE );
        discoverResourcesPage.closeTab();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromRrpPage(){
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        rrpPage.clickOnBottomPageSubscriptionButton(true);
        Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE );
        discoverResourcesPage.closeTab();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMemberSayDirectoryPage(){
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
      //  browseBySubjectPage.clickOnWhatMembersSaySubscriptionButton(false);

        browseBySubjectPage.waitForLoad();
     //   browseBySubjectPage.clickOnWhatMembersSaySubscriptionButton(true);

        browseBySubjectPage.closeTab();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMemberSayArticlesPage(){
        articlesPage.loadPage();
     //   articlesPage.clickOnWhatMembersSaySubscriptionButton(false);

        articlesPage.waitForLoad();
       // articlesPage.clickOnWhatMembersSaySubscriptionButton(true);

        articlesPage.closeTab();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromMyAccountPage(){
        myAccountPage.loadPage();
        myAccountPage.clickOnUpgradeMeButton(true);
        Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE );
        myAccountPage.closeTab();
        myAccountPage.clickOnUpgradeMeButton(false);
        Assert.assertEquals(stepTwoModal.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromHomePage(){
        lpHomePage.loadPage();
        lpHomePage.clickOnUpgradeMeButton(true);
        Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE );
        lpHomePage.closeTab();
        lpHomePage.clickOnUpgradeMeButton(false);
        Assert.assertEquals(stepTwoModal.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMembersSayWidgetDirectoryPage(){
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
    //   browseBySubjectPage.clickOnWhatMembersSaySubscriptionButton(true);
        Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE );
        browseBySubjectPage.closeTab();
   //     browseBySubjectPage.clickOnWhatMembersSaySubscriptionButton(false);
        Assert.assertEquals(stepTwoModal.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMembersSayWidgetArticlesPage(){
        articlesPage.loadPage();
    //    articlesPage.clickOnWhatMembersSaySubscriptionButton(true);
        Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE );
        articlesPage.closeTab();
     //   articlesPage.clickOnWhatMembersSaySubscriptionButton(false);
        Assert.assertEquals(stepTwoModal.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
    }

    private void testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialWidgetDirectoryPage(){
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(true);
        Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE );
        browseBySubjectPage.closeTab();
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(false);
        Assert.assertEquals(stepTwoModal.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
        }

    private void testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialWidgetStandardsPage(){
        stateStandardsPage.loadPage();
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(true);
        Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE );
        stateStandardsPage.closeTab();
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(false);
        Assert.assertEquals(stepTwoModal.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
    }

    private void testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialWidgetArticlesPage(){
        articlesPage.loadPage();
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(true);
        Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE );
        articlesPage.closeTab();
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(false);
        Assert.assertEquals(stepTwoModal.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
    }

    private void testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialWidgetTestimonialsPage(){
        testimonialsPage.loadPage();
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(true);
        Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE );
        testimonialsPage.closeTab();
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(false);
        Assert.assertEquals(stepTwoModal.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
    }
}
