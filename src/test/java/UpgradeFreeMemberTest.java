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
    private WhatMembersSayWidget whatMembersSayWidget;
    private StateStandardsPage stateStandardsPage;
    private BrowseBySubjectPage browseBySubjectPage;
    private StartYourTenDayFreeTrialWidget startYourTenDayFreeTrialWidget;
    private CurriculumManagerTest curriculumManagerTest;
    private RrpModal rrpModal;
    private ArticlesPage articlesPage;
    private TestimonialsPage testimonialsPage;
    private ContactUsPage contactUsPage;
    private FAQPage faqPage;

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
        whatMembersSayWidget = new WhatMembersSayWidget(webDriver);
        contactUsPage = new ContactUsPage(webDriver);
        faqPage = new FAQPage(webDriver);
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

    @Test(description = "lessonp-686: Free member tries to upload a file from Collection Builder, Edit Collection Modal and Curriculum Manager")
    public void testLessonp_686() {
        testUpgradeFreeMemberFromUploadButtonFromCollectionBuilder();
        testUpgradeFreeMemberFromUploadButtonFromEditCollectionModal();
        testUpgradeFreeMemberFromUploadButtonFromCurriculumManagerPage();
    }

    @Test(description = "lessonp-684: Free members exceeds the allowed number of collections created")
    public void testLessonp_684() {
        testUpgradeFreeMemberFromExceededNumberOfCollectionsCreated();
    }

    @Test(description = "lessonp-1000: Free member tries to save a 4th collection")
        public void testLessonp_1000() {
        testUpgradeFreeMemberFromSaving4thCollection();
    }

    @Test(description = "lessonp-690: Free member tries to assign a favorite resource and a collection")
    public void testLessonp_690() {
        testUpgradeFreeMemberFromAssignResourceButton();
        testUpgradeFreeMemberFromAssignCollectionButton();
    }

    @Test(description = "lessonp-685: Free member exceeds the allowed number of items inside a created collection")
    public void testLessonp_685() {
        testUpgradeFreeMemberFromExceededNumberOfItemsInsideACreatedCollection();
    }

    @Test(description = "lessonp-689: Free member tries to save a collection containing more than 10 items")
    public void testLessonp_689() {
        testUpgradeFreeMemberFromExceededNumberOfItemsInsideASavedCollection();
    }

    @Test(description = "lessonp-3884: Free member clicks any of the <Upgrade Me> or <Get Full Access> buttons")
    public void testLessonp_3884() {
        testUpgradeFreeMemberFromUpgradeMeButtons();
        testUpgradeFreeMemberFromGetFullAccessButtons();
    }

    private void testUpgradeFreeMemberFromGetFreeAccessButton(){
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickGetFreeAccess(true);
        checkStepTwoPage();
        discoverResourcesPage.clickGetFreeAccess(false);
        checkStepTwoModal();
    }

    private void checkStepTwoPage(){
        Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE );
        Assert.assertTrue(stepTwoPage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
        stepTwoPage.closeTab();
    }

    private void checkStepTwoModal(){
        Assert.assertEquals(stepTwoModal.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
        stepTwoModal.clickOnCloseModal();
    }

    private void testUpgradeFreeMemberFromUpgradeForFullReviewButton(){
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        rrpModal.waitForModal();
        rrpModal.clickUpgradeForFullReviewButton(true);
        checkStepTwoPage();
        rrpModal.clickUpgradeForFullReviewButton(false);
        checkStepTwoModal();
    }

    private void testUpgradeFreeMemberFromUploadButtonFromCollectionBuilder(){
        discoverResourcesPage.loadPage();
        collectionBuilderPage.clickUploadButton();
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testUpgradeModalFromUploadButton();
    }

    private void testUpgradeFreeMemberFromUploadButtonFromEditCollectionModal(){
        curriculumManagerTest.testCreateCollectionFromCollectionBuilder();
        collectionBuilderPage.clickOnEditCollection();
        editCollectionModal.waitForModal();
        editCollectionModal.clickUploadAFileButton();
        curriculumManagerTest.testUpgradeModalFromUploadButton();
    }

    private void testUpgradeFreeMemberFromUploadButtonFromCurriculumManagerPage(){
        curriculumManagerTest.testUploadResourceUsingTextInput(TestData.FREE_MEMBERSHIP_TEXT);
    }

    private void testUpgradeFreeMemberFromExceededNumberOfCollectionsCreated(){
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testMaxLimitOfCollectionsCreated();
    }

    private void testUpgradeFreeMemberFromSaving4thCollection(){
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testCreateThreeCollections();
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        collectionRrpModal.waitForModal();
        collectionRrpModal.clickSaveCollectionButton();
        curriculumManagerTest.testUpgradeModalFromMaxCollectionLimit();
    }

    private void testUpgradeFreeMemberFromAssignResourceButton() {
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testFavoriteRegularResource(TestData.FREE_MEMBERSHIP_TEXT);
        curriculumManagerTest.testAssignResource(TestData.FREE_MEMBERSHIP_TEXT, TestData.ASSIGN_RESOURCE_MODAL_TEXT);
    }

    private void testUpgradeFreeMemberFromAssignCollectionButton(){
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testCreateCollectionFromCurriculumManager(TestData.NEW_COLLECTION_NAME);
        curriculumManagerTest.testAddRegularResourceToCollection(TestData.FREE_MEMBERSHIP_TEXT);
        curriculumManagerTest.testAddSharedResourceToCollection();
        curriculumManagerTest.testAssignResource(TestData.FREE_MEMBERSHIP_TEXT, TestData.ASSIGN_COLLECTION_MODAL_TEXT);
    }

    private void testUpgradeFreeMemberFromExceededNumberOfItemsInsideACreatedCollection(){
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testCreateCollectionFromCollectionBuilder();
        discoverResourcesPage.clickOnListView();
        List<WebElement> getFreeAccessResources = discoverResourcesPage.getAllFreeAccessButtons();
        for (int i=0; i<=10; i++) {
            discoverResourcesPage.dragAndDrop(getFreeAccessResources.get(i), collectionBuilderPage.getCollectionDroppableZone());
        }
        testUpgradeModalFromMaxItemsInsideCollection(TestData.UPGRADE_MODAL_TEXT_FROM_EXCEEDED_ITEMS_INSIDE_CREATED_COLLECTION);
    }

    private void testUpgradeFreeMemberFromExceededNumberOfItemsInsideASavedCollection() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        List<WebElement> getCollectionResources = discoverResourcesPage.getAllSeeCollectionsButtons();
        for (int i=1; i<24; i++) {
            if (collectionRrpModal.getCollectionItemsCount() <= 10) {
                collectionRrpModal.clickCloseModal();
                discoverResourcesPage.openInANewTabOrClick(getCollectionResources.get(i), false);
            }
        }
        collectionRrpModal.clickSaveCollectionButton();
        testUpgradeModalFromMaxItemsInsideCollection(TestData.UPGRADE_MODAL_TEXT_FROM_EXCEEDED_ITEMS_INSIDE_SAVED_COLLECTION);
    }

    private void testUpgradeModalFromMaxItemsInsideCollection(String bodyText){
        upgradeMaxItemsCollectionModal.waitForModal();
        Assert.assertEquals(upgradeMaxItemsCollectionModal.getUpgradeModalText(), bodyText);
        upgradeMaxItemsCollectionModal.clickOnUpgradeMeButton(true);
        checkStepTwoPage();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtons(){
        testUpgradeFreeMemberFromUpgradeMeButtonFromHeader();
        testUpgradeFreeMemberFromUpgradeMeButtonFromMyAccountPage();
        testUpgradeFreeMemberFromUpgradeMeButtonFromHomePage();
        testUpgradeFreeMemberFromUpgradeMeButtonFromRrpPage();
        testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMembersSayWidgetDirectoryPage();
        testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMembersSayWidgetArticlesPage();
        testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMembersSayWidgetContactUsPage();
        testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMembersSayWidgetTestimonialsPage();
        testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMembersSayWidgetFAQPage();
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
        checkStepTwoPage();
        headerPage.clickOnUpgradeMeButton(false);
        checkStepTwoModal();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromMyAccountPage(){
        myAccountPage.loadPage();
        myAccountPage.clickOnUpgradeMeButton(true);
        checkStepTwoPage();
        myAccountPage.clickOnUpgradeMeButton(false);
        checkStepTwoModal();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromHomePage(){
        lpHomePage.loadPage();
        lpHomePage.clickOnUpgradeMeButton(true);
        checkStepTwoPage();
        lpHomePage.clickOnUpgradeMeButton(false);
        checkStepTwoModal();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromRrpPage(){
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        rrpPage.clickStartYourFreeTrialSubscriptionButton(true);
        checkStepTwoPage();
        rrpPage.clickBottomPageSubscriptionButton(true);
        checkStepTwoPage();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMembersSayWidgetDirectoryPage(){
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        testClickSubscriptionButtonFromWhatMembersSayWidget();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMembersSayWidgetArticlesPage(){
        articlesPage.loadPage();
        testClickSubscriptionButtonFromWhatMembersSayWidget();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMembersSayWidgetContactUsPage(){
        contactUsPage.loadPage();
        testClickSubscriptionButtonFromWhatMembersSayWidget();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMembersSayWidgetTestimonialsPage(){
        testimonialsPage.loadPage();
        testClickSubscriptionButtonFromWhatMembersSayWidget();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtonFromWhatMembersSayWidgetFAQPage(){
        faqPage.loadPage();
        testClickSubscriptionButtonFromWhatMembersSayWidget();
    }

    private void testClickSubscriptionButtonFromWhatMembersSayWidget(){
        whatMembersSayWidget.clickSubscriptionButton(true);
        checkStepTwoPage();
        whatMembersSayWidget.clickSubscriptionButton(false);
        checkStepTwoModal();
    }

    private void testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialWidgetDirectoryPage() {
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        testClickSubscriptionButtonFromStartYourFreeTrialWidget();
    }

    private void testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialWidgetStandardsPage(){
        stateStandardsPage.loadPage();
        testClickSubscriptionButtonFromStartYourFreeTrialWidget();
    }

    private void testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialWidgetArticlesPage(){
        articlesPage.loadPage();
        testClickSubscriptionButtonFromStartYourFreeTrialWidget();
    }

    private void testUpgradeFreeMemberFromGetFullAccessButtonFromStartYourFreeTrialWidgetTestimonialsPage(){
        testimonialsPage.loadPage();
        testClickSubscriptionButtonFromStartYourFreeTrialWidget();
    }

    private void testClickSubscriptionButtonFromStartYourFreeTrialWidget(){
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(true);
        checkStepTwoPage();
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(false);
        checkStepTwoModal();
    }
}
