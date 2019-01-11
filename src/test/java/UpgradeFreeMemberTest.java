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
    private StepTwoPage stepTwoPage;
    private RrpPage rrpPage;
    private RrpModal rrpModal;
    private UpgradeModal upgradeModal;
    private CollectionBuilderPage collectionBuilderPage;
    private EditCollectionModal editCollectionModal;
    private CurriculumManagerTest curriculumManagerTest;
    private StepOnePage stepOnePage;
    private UpgradeUploadModal upgradeUploadModal;
    private UpgradeAssignModal upgradeAssignModal;
    private UpgradeMaxCollectionModal upgradeMaxCollectionModal;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        rrpPage = new RrpPage(webDriver);
        rrpModal = new RrpModal(webDriver);
        upgradeModal = new UpgradeModal(webDriver);
        upgradeUploadModal = new UpgradeUploadModal(webDriver);
        upgradeAssignModal = new UpgradeAssignModal(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        editCollectionModal = new EditCollectionModal(webDriver);
        stepOnePage = new StepOnePage(webDriver);
        upgradeMaxCollectionModal = new UpgradeMaxCollectionModal(webDriver);
        curriculumManagerTest = new CurriculumManagerTest();
        createAFreemiumAccount();
    }

    private void createAFreemiumAccount(){
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

    @Test(description = "lessonp-686: Free member tries to upload a file from Collection Builder, Curriculum Manager and Edit Collection")
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

    @Test(description = "lessonp-685:Free members exceeds the allowed nr of items inside a collection")
    public void testLessonp_685() {
        testUpgradeFreeMemberFromExceededNumberOfItemsInsideACreatedCollection();
    }

    @Test(description = "lessonp-689:Free member tries to save a collection containing more than 10 items")
    public void testLessonp_689() {
        testUpgradeFreeMemberFromExceededNumberOfItemsInsideASavedCollection();
    }

    private void testUpgradeFreeMemberFromGetFreeAccessButton(){
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickGetFreeAccess(true);
        testStepTwoPageUrlAndTitle();
    }

    private void testStepTwoPageUrlAndTitle(){
        Assert.assertTrue(lpHomePage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
    }

    private void testUpgradeFreeMemberFromUpgradeForFullReviewButton(){
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        rrpPage.clickOnUpgradeForFullReviewButton();
        testStepTwoPageUrlAndTitle();
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
        editCollectionModal.clickOnUploadButton();
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
        rrpModal.clickOnSaveCollectionButton();
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
     //   testUpgradeModalFromMaxItemsInsideCollection(TestData.UPGRADE_MODAL_TEXT_FROM_EXCEEDED_ITEMS_INSIDE_CREATED_COLLECTION);
    }

    private void testUpgradeFreeMemberFromExceededNumberOfItemsInsideASavedCollection(){
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        rrpModal.clickOnSaveCollectionButton();
    //    testUpgradeModalFromMaxItemsInsideCollection(TestData.UPGRADE_MODAL_TEXT_FROM_EXCEEDED_ITEMS_INSIDE_SAVED_COLLECTION);
    }

    private void testUpgradeModalFromMaxItemsInsideCollection (String bodyText){
        upgradeModal.waitForUpgradeModalFromMaxItemsLimit();
        Assert.assertEquals(upgradeModal.getTextFromUpgradeModalFromMaxItemsLimit(), bodyText);
        upgradeModal.clickOnUpgradeMeButton();
        testStepTwoPageUrlAndTitle();
    }
}
