import com.lessonplanet.pages.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class UpgradeFreeMemberTest extends BaseTest {

    private LpHomePage lpHomePage;
    private LoginPage loginPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private StepTwoModal stepTwoModal;
    private StepTwoPage stepTwoPage;
    private RrpModal rrpModal;
    private UpgradeModal upgradeModal;
    private CollectionBuilderPage collectionBuilderPage;
    private CurriculumManagerPage curriculumManagerPage;
    private EditCollectionModal editCollectionModal;
    private CurriculumManagerTest curriculumManagerTest;
    private StepOnePage stepOnePage;
    private MyAccountPage myAccountPage;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        stepTwoModal = new StepTwoModal(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        rrpModal = new RrpModal(webDriver);
        upgradeModal = new UpgradeModal(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        editCollectionModal = new EditCollectionModal(webDriver);
        curriculumManagerTest = new CurriculumManagerTest(webDriver);
        stepOnePage = new StepOnePage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
    }

    private void createAFreemiumAccount(){
        lpHomePage.loadPage();
        stepOnePage.completeStepOne(TestData.GET_NEW_EMAIL(), TestData.VALID_PASSWORD);
    }

    @Test(description = "lessonp-687: Freemium member clicks the Get Free Access button on a resource card")
    public void testLessonp_687() {
        createAFreemiumAccount();
        testUpgradeFreeMemberFromGetFreeAccessButton();
    }

    @Test(description = "lessonp-688: Freemium member clicks the Upgrade for Full Review button on the RRP")
    public void testLessonp_688() {
        createAFreemiumAccount();
        testUpgradeFreeMemberFromUpgradeforFullReviewButton();
    }

    @Test(description = "lessonp-686: Freemium member tries to upload a file")
    public void testLessonp_686() {
        createAFreemiumAccount();
        testUpgradeFreeMemberFromUploadButton();
    }

    @Test(description = "lessonp-684: Freemium members exceeds the allowed nr of collections created")
    public void testLessonp_684() {
        createAFreemiumAccount();
        testUpgradeFreeMemberFromNumberOfCollectionsExceededCreated();
    }

    @Test(description = "lessonp-1000:Freemium member tries to save a 4th collection")
        public void testLessonp_1000() {
        createAFreemiumAccount();
        testUpgradeFreeMemberFromNumberOfCollectionsExceededSaved();
    }

    @Test(description = "lessonp-690:Freemium member tries to Assign a favorited resource or a collection")
    public void testLessonp_690() {
        createAFreemiumAccount();
        testUpgradeFreeMemberFromAssignButton();
    }

    @Test(description = "lessonp-685:Freemium members exceeds the allowed nr of items inside a collection")
    public void testLessonp_685() {
        createAFreemiumAccount();
        testUpgradeFreeMemberFromNumberOfItemsExceededInsideACreatedCollection();
    }

    @Test(description = "lessonp-689:Freemium member tries to save a collection containing more than 10 items")
    public void testLessonp_689() {
        createAFreemiumAccount();
        testUpgradeFreeMemberFromNumberOfItemsExceededInsideASavedCollection();
    }

    private void testUpgradeFreeMemberFromGetFreeAccessButton(){
        discoverResourcesPage.loadPage();
        discoverResourcesPage.clickOnListView();
        discoverResourcesPage.clickGetFreeAccess(false);
        testStepTwoModal();
    }

    private void testStepTwoModal(){
        Assert.assertTrue(stepTwoModal.isStepTwoModalDisplayed());
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoModal.getTitleText());
        stepTwoModal.clickOnCloseModal();
    }

    private void testUpgradeFreeMemberFromUpgradeforFullReviewButton(){
        discoverResourcesPage.loadPage();
        discoverResourcesPage.clickOnListView();
        discoverResourcesPage.clickSeeReview(false);
        rrpModal.clickOnUpgradeForFullReviewButton();
        testStepTwoModal();
    }

    private void testUpgradeFreeMemberFromUploadButton(){
        testUpgradeFreeMemberFromUploadButtonFromCollectionBuilder();
        testUpgradeFreeMemberFromUploadButtonFromCurriculumManager();
        testUpgradeFreeMemberFromUploadButtonFromEditCollectionModal();
    }

    private void testUpgradeFreeMemberFromUploadButtonFromCollectionBuilder(){
        discoverResourcesPage.loadPage();
        collectionBuilderPage.clickOnUploadButton();
        testDisplayStep2PageFromGetFullAccessButton();
    }

    private void testUpgradeFreeMemberFromUploadButtonFromCurriculumManager(){
        curriculumManagerPage.loadPage(TestData.CURRICULUM_MANAGER_PATH);
        curriculumManagerPage.clickOnUploadResourceButton();
        testDisplayStep2PageFromGetFullAccessButton();
    }

    private void testUpgradeFreeMemberFromUploadButtonFromEditCollectionModal(){
        curriculumManagerPage.loadPage(TestData.CURRICULUM_MANAGER_PATH);
        curriculumManagerTest.testCreateCollectionFromCurriculumManager(TestData.collectionName[1]);
        curriculumManagerPage.clickOnEditButton();
        editCollectionModal.waitForModal();
        editCollectionModal.clickOnUploadButton();
        testDisplayStep2PageFromGetFullAccessButton();
    }

    private void testDisplayStep2PageFromGetFullAccessButton(){
        upgradeModal.waitForUpgradeModalFromUploadButton();
        Assert.assertEquals(upgradeModal.getTextFromUpgradeModalFromUploadButton(), TestData.UPGRADE_MODAL_TEXT_FROM_UPLOAD_BUTTON);
        upgradeModal.clickOnGetFullAccessNow();
        testStepTwoPage();
    }

    private void testStepTwoPage(){
        Assert.assertTrue(lpHomePage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
    }

    private void testUpgradeFreeMemberFromNumberOfCollectionsExceededCreated(){
        curriculumManagerPage.loadPage(TestData.CURRICULUM_MANAGER_PATH);
        for(int i=0; i<=2; i++) {
            curriculumManagerTest.testCreateCollectionFromCurriculumManager(TestData.collectionName[i]);
        }
        curriculumManagerPage.clickOnCreateACollectionButton();
        upgradeModal.waitForUpgradeModalFromMaxCollectionLimit();
        Assert.assertEquals(upgradeModal.getTextFromUpgradeModalFromMaxCollectionLimit(), TestData.UPGRADE_MODAL_TEXT_FROM_EXCEEDED_NR_OF_COLLECTIONS);
        upgradeModal.clickOnUpgradeMeButtonFromMaxCollectionLimit();
        testStepTwoPage();
    }

    private void testUpgradeFreeMemberFromNumberOfCollectionsExceededSaved(){
        curriculumManagerPage.loadPage(TestData.CURRICULUM_MANAGER_PATH);
        for(int i=0; i<=2; i++) {
            curriculumManagerTest.testCreateCollectionFromCurriculumManager(TestData.collectionName[i]);
        }
        discoverResourcesPage.loadPage();
        discoverResourcesPage.clickOnListView();
        discoverResourcesPage.clickSeeCollection(false);
        rrpModal.clickOnSaveCollectionButton();
        upgradeModal.waitForUpgradeModalFromMaxItemsLimit();
        Assert.assertEquals(upgradeModal.getTextFromUpgradeModalFromMaxItemsLimit(), TestData.UPGRADE_MODAL_TEXT_FROM_EXCEEDED_NR_OF_COLLECTIONS);
        upgradeModal.clickOnUpgradeMeButtonFromMaxCollectionLimit();
        testStepTwoPage();
    }

    private void testUpgradeFreeMemberFromAssignButton(){
        curriculumManagerTest.testFavoriteRegularResource(TestData.FREE_MEMBERSHIP_TEXT);
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnAssignButton();
        upgradeModal.waitForUpgradeModalFromAssignButton();
        Assert.assertEquals(upgradeModal.getTextFromUpgradeModalFromAssignButton(), TestData.UPGRADE_MODAL_TEXT_FROM_ASSIGN_BUTTON);
        upgradeModal.clickOnUpgradeButtonFromAssign();
        testStepTwoPage();

        curriculumManagerPage.loadPage(TestData.CURRICULUM_MANAGER_PATH);
        curriculumManagerTest.testCreateCollectionFromCurriculumManager(TestData.NEW_COLLECTION_NAME);
        curriculumManagerTest.testAddRequiredInformationToCollection(TestData.FREE_MEMBERSHIP_TEXT);
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnAssignButton();
        upgradeModal.waitForUpgradeModalFromAssignButton();
        Assert.assertEquals(upgradeModal.getTextFromUpgradeModalFromAssignButton(), TestData.UPGRADE_MODAL_TEXT_FROM_ASSIGN_BUTTON);
        upgradeModal.clickOnUpgradeButtonFromAssign();
        testStepTwoPage();
    }

    private void  testUpgradeFreeMemberFromNumberOfItemsExceededInsideASavedCollection(){
        discoverResourcesPage.loadPage();
        discoverResourcesPage.clickOnListView();
        discoverResourcesPage.clickSeeCollection(false);
        rrpModal.clickOnSaveCollectionButton();
        upgradeModal.waitForUpgradeModalFromMaxItemsLimit();
        Assert.assertEquals(upgradeModal.getTextFromUpgradeModalFromMaxItemsLimit(), TestData.UPGRADE_MODAL_TEXT_FROM_EXCEEDED_ITEMS_INSIDE_COLLECTION);
        upgradeModal.clickOnUpgradeMeButtonFromMaxItemsLimitHitModal();
        testStepTwoPage();
    }

    private void testUpgradeFreeMemberFromNumberOfItemsExceededInsideACreatedCollection(){

    }
}
