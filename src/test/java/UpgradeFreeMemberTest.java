import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;
import org.openqa.selenium.WebElement;

import java.util.List;

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
    }

    @Test(description = "lessonp-687: Freemium member clicks the Get Free Access button on a resource card")
    public void testLessonp_687() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testUpgradeFreeMemberFromGetFreeAccessButton();
    }

    @Test(description = "lessonp-688: Freemium member clicks the Upgrade for Full Review button on the RRP")
    public void testLessonp_688() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testUpgradeFreeMemberFromUpgradeforFullReviewButton();
    }

    @Test(description = "lessonp-686: Freemium member tries to upload a file")
    public void testLessonp_686() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testUpgradeFreeMemberFromUploadButton();
    }

    @Test(description = "lessonp-684: Freemium members exceeds the allowed nr of collections")
    public void testLessonp_684() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testUpgradeFreeMemberFromNumberOfCollectionsExcedeedCreated();
    }

    @Test(description = "lessonp-1000:Freemium member tries to save a 4th collection")
        public void testLessonp_1000() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testUpgradeFreeMemberFromNumberOfCollectionsExcedeedSaved();
    }

    @Test(description = "lessonp-690:Freemium member tries to Assign a favorited resource or a collection")
    public void testLessonp_690() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testUpgradeFreeMemberFromAssignButton(TestData.VALID_EMAIL_FREEMIUM);
    }
/*
    @Test(description = "lessonp-685:Freemium members exceeds the allowed nr of items inside a collection")
    public void testLessonp_685() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testUpgradeFreeMemberFromNumberOfItemsExcedeedInsideCollectionCreated();
    }

    @Test(description = "lessonp-689:Freemium member tries to save a collection containing more than 10 items")
    public void testLessonp_689() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testUpgradeFreeMemberFromNumberOfItemsExcedeedInsideCollectionSaved();
    }
  */
    private void testUpgradeFreeMemberFromGetFreeAccessButton(){
        discoverResourcesPage.loadPage();
        discoverResourcesPage.clickOnListView();
        discoverResourcesPage.clickGetFreeAccess(false);
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoModal.getTitleText());
        stepTwoModal.clickOnCloseModal();
    }

    private void testUpgradeFreeMemberFromUpgradeforFullReviewButton(){
        discoverResourcesPage.loadPage();
        discoverResourcesPage.clickOnListView();
        discoverResourcesPage.clickSeeReview(false);
        rrpModal.clickOnUpgradeForFullReviewButton();
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoModal.getTitleText());
        stepTwoModal.clickOnCloseModal();
    }

    private void testUpgradeFreeMemberFromUploadButton(){
        testUpgradeFreeMemberFromUploadButtonFromCollectionBuilder();
        testUpgradeFreeMemberFromUploadButtonFromCurriculumManager();
        testUpgradeFreeMemberFromUploadButtonFromEditCollectionModal();
    }

    private void testUpgradeFreeMemberFromUploadButtonFromCollectionBuilder(){
        discoverResourcesPage.loadPage();
        collectionBuilderPage.clickOnUploadButton();
        upgradeModal.waitForUpgradeModalFromUpload();
        Assert.assertEquals(upgradeModal.getTextFromUpgradeModalFromUpload(), TestData.UPGRADE_MODAL_TEXT_FROM_UPLOAD);
        upgradeModal.clickOnUpgradeButton();

        Assert.assertTrue(lpHomePage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
    }

    private void testUpgradeFreeMemberFromUploadButtonFromCurriculumManager(){
        curriculumManagerPage.loadPage(TestData.CURRICULUM_MANAGER_PATH);
        curriculumManagerPage.clickOnUploadResourceButton();
        upgradeModal.waitForUpgradeModalFromUpload();
        Assert.assertEquals(upgradeModal.getTextFromUpgradeModalFromUpload(), TestData.UPGRADE_MODAL_TEXT_FROM_UPLOAD);
        upgradeModal.clickOnUpgradeButton();
        Assert.assertTrue(lpHomePage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
    }

    private void testUpgradeFreeMemberFromUploadButtonFromEditCollectionModal(){
        curriculumManagerPage.loadPage(TestData.CURRICULUM_MANAGER_PATH);
        curriculumManagerTest.testCreateCollectionFromCurriculumManager(TestData.collectionName[1]);
        curriculumManagerPage.clickOnEditButton();
        editCollectionModal.waitForModal();
        editCollectionModal.clickOnUploadButton();
        upgradeModal.waitForUpgradeModalFromUpload();
        Assert.assertEquals(upgradeModal.getTextFromUpgradeModalFromUpload(), TestData.UPGRADE_MODAL_TEXT_FROM_UPLOAD);
        upgradeModal.clickOnUpgradeButton();
        Assert.assertTrue(lpHomePage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
        curriculumManagerPage.loadPage(TestData.CURRICULUM_MANAGER_PATH);
        curriculumManagerTest.testDeleteCollections();
    }

    private void testUpgradeFreeMemberFromNumberOfCollectionsExcedeedCreated(){
        curriculumManagerPage.loadPage(TestData.CURRICULUM_MANAGER_PATH);
        for(int i=0; i<=2; i++) {
            curriculumManagerTest.testCreateCollectionFromCurriculumManager(TestData.collectionName[i]);
        }
        curriculumManagerPage.clickOnCreateACollectionButton();
        upgradeModal.waitForUpgradeModalFromCopy();
        Assert.assertEquals(upgradeModal.getTextFromUpgradeModalFromCopy(), TestData.UPGRADE_MODAL_TEXT_FROM_COLLECTION);
        upgradeModal.clickOnUpgradeButton();
        Assert.assertTrue(lpHomePage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
        curriculumManagerPage.loadPage(TestData.CURRICULUM_MANAGER_PATH);
        curriculumManagerTest.testDeleteCollections();
    }

    private void testUpgradeFreeMemberFromNumberOfCollectionsExcedeedSaved(){
        curriculumManagerPage.loadPage(TestData.CURRICULUM_MANAGER_PATH);
        for(int i=0; i<=2; i++) {
            curriculumManagerTest.testCreateCollectionFromCurriculumManager(TestData.collectionName[i]);
        }
        discoverResourcesPage.loadPage();
        discoverResourcesPage.clickSeeCollection(false);
        rrpModal.clickOnSaveCollectionButton();
        upgradeModal.waitForUpgradeModalFromCopy();
        Assert.assertEquals(upgradeModal.getTextFromUpgradeModalFromCopy(), TestData.UPGRADE_MODAL_TEXT_FROM_COLLECTION);
        upgradeModal.clickOnUpgradeButtonFromCopy();
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
        Assert.assertTrue(lpHomePage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
        curriculumManagerPage.loadPage(TestData.CURRICULUM_MANAGER_PATH);
        curriculumManagerTest.testDeleteCollections();
    }

    private void testUpgradeFreeMemberFromAssignButton(String account){
        curriculumManagerTest.testFavoriteRegularResource(account);
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnAssignButton();
        upgradeModal.waitForUpgradeModalFromAssign();
        Assert.assertEquals(upgradeModal.getTextFromUpgradeModalFromAssign(), TestData.UPGRADE_MODAL_TEXT_FROM_ASSIGN);
        upgradeModal.clickOnUpgradeButtonFromAssign();
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
        Assert.assertTrue(lpHomePage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));

        curriculumManagerPage.loadPage(TestData.CURRICULUM_MANAGER_PATH);
        curriculumManagerTest.testCreateCollectionFromCurriculumManager(TestData.NEW_COLLECTION_NAME);
        curriculumManagerTest.testAddRequiredInformationToCollection(account);
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnAssignButton();
        upgradeModal.waitForUpgradeModalFromAssign();
        Assert.assertEquals(upgradeModal.getTextFromUpgradeModalFromAssign(), TestData.UPGRADE_MODAL_TEXT_FROM_ASSIGN);
        upgradeModal.clickOnUpgradeButtonFromAssign();
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
        Assert.assertTrue(lpHomePage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));

        curriculumManagerPage.loadPage(TestData.CURRICULUM_MANAGER_PATH);
        curriculumManagerTest.testDeleteCollections();
        curriculumManagerPage.clickOnMyFavoritesFolder();
        curriculumManagerTest.testRemoveFavoriteResourceButton();
    }

    private void  testUpgradeFreeMemberFromNumberOfItemsExcedeedInsideCollectionCreated(){
    }

    private void testUpgradeFreeMemberFromNumberOfItemsExcedeedInsideCollectionSaved(){

    }
}
