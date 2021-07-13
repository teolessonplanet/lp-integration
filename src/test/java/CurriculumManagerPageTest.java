import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import util.TestData;

import java.io.File;

public class CurriculumManagerPageTest extends BaseTest {
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private CurriculumManagerPage curriculumManagerPage;
    private CreateNewFolderModal createNewFolderModal;
    private EditCollectionModal editCollectionModal;
    private EditResourceModal editResourceModal;
    private DiscoverResourcesPage discoverResourcesPage;
    private CollectionBuilderPage collectionBuilderPage;
    private CopyToModal copyToModal;
    private UpgradeMaxFolderModal upgradeMaxFolderModal;
    private UpgradeAssignModal upgradeAssignModal;
    private UpgradeUploadModal upgradeUploadModal;
    private RrpModal rrpModal;
    private RrpPage rrpPage;
    private RemoveModal removeModal;
    private PublishResourceModal publishResourceModal;
    private UploadFileModal uploadFileModal;
    private AssignModal assignModal;
    private StepTwoPage stepTwoPage;
    private ManageMembershipPage manageMembershipPage;
    private MoveToModal moveToModal;
    private DeleteFolderModal deleteFolderModal;
    private DeleteCollectionBuilderResourceModal deleteCollectionBuilderResourceModal;
    private PublishedFolderModal publishedFolderModal;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        manageMembershipPage = new ManageMembershipPage(webDriver);
        headerPage = new HeaderPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        rrpModal = new RrpModal(webDriver);
        rrpPage = new RrpPage(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        createNewFolderModal = new CreateNewFolderModal(webDriver);
        upgradeMaxFolderModal = new UpgradeMaxFolderModal(webDriver);
        upgradeAssignModal = new UpgradeAssignModal(webDriver);
        upgradeUploadModal = new UpgradeUploadModal(webDriver);
        editCollectionModal = new EditCollectionModal(webDriver);
        editResourceModal = new EditResourceModal(webDriver);
        copyToModal = new CopyToModal(webDriver);
        removeModal = new RemoveModal(webDriver);
        publishResourceModal = new PublishResourceModal(webDriver);
        uploadFileModal = new UploadFileModal(webDriver);
        assignModal = new AssignModal(webDriver);
        moveToModal = new MoveToModal(webDriver);
        deleteFolderModal = new DeleteFolderModal(webDriver);
        deleteCollectionBuilderResourceModal = new DeleteCollectionBuilderResourceModal(webDriver);
        publishedFolderModal = new PublishedFolderModal(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Visitor - Curriculum Manager - lessonp-3258: Access Curriculum Manager Page")
    public void testLessonp_3258() {
        lpHomePage.loadPage();
        testAccessCurriculumManagerPageFromHeader(false);
        testAccessCurriculumManagerPageFromSearchPage(false);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5538: Access Curriculum Manager Page")
    public void testLessonp_5538() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testAccessCurriculumManagerPageFromHeader(true);
        testAccessCurriculumManagerPageFromSearchPage(true);
        testSortByDropdown();
        testListView();
    }

    @Test(description = "All Active Users - Curriculum Manager - lessonp-5554: Access Curriculum Manager Page")
    public void testLessonp_5554() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testAccessCurriculumManagerPageFromHeader(true);
        testAccessCurriculumManagerPageFromSearchPage(true);
        testSortByDropdown();
        testListView();
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5614: Create Collections")
    public void testLessonp_5614() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[0]);
    }

    @Test(description = "All Active Users - Curriculum Manager - lessonp-5615: Create Collections")
    public void testLessonp_5615() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[0]);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5535: Upload Resource & My Uploads Folder")
    public void testLessonp_5535() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testUploadResourceFromMyResources(TestData.PLAN_FREEMIUM, false);
        testMyUploadsFolderActions(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Starter membership - Curriculum Manager - lessonp- 5542: Upload Resource & My Uploads Folder")
    public void testLessonp_5542() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testUploadResourceFromMyResources(TestData.PLAN_STARTER, false);
        testMyUploadsFolderActions(TestData.PLAN_STARTER);
    }

    @Ignore
    @Test(description = "Prime membership - Curriculum Manager - lessonp- 5543: Upload Resource & My Uploads Folder")
    public void testLessonp_5543() {
//        stepTwoPage.createNewAccount(TestData.PLAN_PRIME);
//        testUploadResourceFromMyResources(TestData.PLAN_PRIME, false);
//        testMyUploadsFolderActions(TestData.PLAN_PRIME);
    }

    @Test(description = "Pro membership - Curriculum Manager - lessonp- 5544: Upload Resource & My Uploads Folder")
    public void testLessonp_5544() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testUploadResourceFromMyResources(TestData.PLAN_PRO, false);
        testMyUploadsFolderActions(TestData.PLAN_PRO);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5536: Favorite Resource & My Favorites Folder")
    public void testLessonp_5536() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testFavoriteResources(TestData.PLAN_FREEMIUM);
        testMyFavoritesFolderActions(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Starter membership - Curriculum Manager - lessonp- 5545: Favorite Resource & My Favorites Folder")
    public void testLessonp_5545() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testFavoriteResources(TestData.PLAN_STARTER);
        testMyFavoritesFolderActions(TestData.PLAN_STARTER);
    }

    @Ignore
    @Test(description = "Prime membership - Curriculum Manager - lessonp- 5546: Favorite Resource & My Favorites Folder")
    public void testLessonp_5546() {
//        stepTwoPage.createNewAccount(TestData.PLAN_PRIME);
//        testFavoriteResources(TestData.PLAN_PRIME);
//        testMyFavoritesFolderActions(TestData.PLAN_PRIME);
    }

    @Test(description = "Pro membership - Curriculum Manager - lessonp- 5547: Favorite Resource & My Favorites Folder")
    public void testLessonp_5547() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testFavoriteResources(TestData.PLAN_PRO);
        testMyFavoritesFolderActions(TestData.PLAN_PRO);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5537: Collection: Actions Dropdown")
    public void testLessonp_5537() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        curriculumManagerPage.loadPage();
        testCreateFolderFromCurriculumManager(TestData.NEW_COLLECTION_NAME, TestData.FOLDER_TYPE[0]);
        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.FOLDER_TYPE[0]);
        testFolderActions(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Starter membership - Curriculum Manager - lessonp-5548: Collection: Actions Dropdown")
    public void testLessonp_5548() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        curriculumManagerPage.loadPage();
        testCreateFolderFromCurriculumManager(TestData.NEW_COLLECTION_NAME, TestData.FOLDER_TYPE[0]);
        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.FOLDER_TYPE[0]);
        testFolderActions(TestData.PLAN_STARTER);
    }

    @Ignore
    @Test(description = "Prime membership - Curriculum Manager - lessonp-5549: Collection: Actions Dropdown")
    public void testLessonp_5549() {
//        stepTwoPage.createNewAccount(TestData.PLAN_PRIME);
//        curriculumManagerPage.loadPage();
//        testCreateFolderFromCurriculumManager(TestData.NEW_COLLECTION_NAME, TestData.FOLDER_TYPE[0]);
//        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.COLLECTION_FOLDER_TYPE);
//        testFolderActions(TestData.PLAN_PRIME);
    }

    @Test(description = "Pro membership - Curriculum Manager - lessonp-5550: Collection: Actions Dropdown")
    public void testLessonp_5550() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        curriculumManagerPage.loadPage();
        testCreateFolderFromCurriculumManager(TestData.NEW_COLLECTION_NAME, TestData.FOLDER_TYPE[0]);
        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.FOLDER_TYPE[0]);
        testFolderActions(TestData.PLAN_PRO);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5539: Folder Actions Dropdown")
    public void testLessonp_5539() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        curriculumManagerPage.loadPage();
        testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.FOLDER_TYPE[3]);
        testFolderActions(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Starter membership - Curriculum Manager - lessonp-5552: Folder Actions Dropdown")
    public void testLessonp_5991() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        curriculumManagerPage.loadPage();
        testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.FOLDER_TYPE[3]);
        testFolderActions(TestData.PLAN_STARTER);
    }

    @Ignore
    @Test(description = "Prime membership - Curriculum Manager - lessonp-5552: Folder Actions Dropdown")
    public void testLessonp_5276() {
//        stepTwoPage.createNewAccount(TestData.PLAN_PRIME);
//        curriculumManagerPage.loadPage();
//        testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
//        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.LESSON_FOLDER_TYPE);
//        testFolderActions(TestData.PLAN_PRIME);
    }

    @Test(description = "Pro membership - Curriculum Manager - lessonp-5552: Folder Actions Dropdown")
    public void testLessonp_5022() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        curriculumManagerPage.loadPage();
        testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.FOLDER_TYPE[3]);
        testFolderActions(TestData.PLAN_PRO);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5677:Dragging folders into another folder")
    public void testLessonp_5677() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        curriculumManagerPage.loadPage();
        testDraggingFoldersIntoAnotherFolder(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Curriculum Manager - lessonp-5738:Dragging folders into another folder")
    public void testLessonp_5738() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        curriculumManagerPage.loadPage();
        testDraggingFoldersIntoAnotherFolder(TestData.PLAN_STARTER);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5681:Drilled in functionality & buttons")
    public void testLessonp_5681() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testDrilledInViewAndFunctionality(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Curriculum Manager - lessonp-5739:Drilled in view & functionality")
    public void testLessonp_5739() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testDrilledInViewAndFunctionality(TestData.PLAN_STARTER);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5964:Drag folders into the CB")
    public void testLessonp_5964() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testDragAndDrop(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Curriculum Manager - lessonp-5747:Drag folders into the CB")
    public void testLessonp_5747() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testDragAndDrop(TestData.PLAN_PRO);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5893:Drilled in view")
    public void testLessonp_5893() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testDrilledInViewAndFunctionality(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5670:Create Folders (Curriculum Sets)")
    public void testLessonp_5670() {
        testNestedFolders(TestData.PLAN_FREEMIUM, TestData.FOLDER_TYPE[1]);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5671:Create Folders (Chapters)")
    public void testLessonp_5671() {
        testNestedFolders(TestData.PLAN_FREEMIUM, TestData.FOLDER_TYPE[2]);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5671:Create Folders (Lessons)")
    public void testLessonp_5672() {
        testNestedFolders(TestData.PLAN_FREEMIUM, TestData.FOLDER_TYPE[3]);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5671:Create Folders (Assessment Sets)")
    public void testLessonp_5673() {
        testNestedFolders(TestData.PLAN_FREEMIUM, TestData.FOLDER_TYPE[4]);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5674:Create Folders (Unit Modules)")
    public void testLessonp_5674() {
        testNestedFolders(TestData.PLAN_FREEMIUM, TestData.FOLDER_TYPE[5]);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5675:Create Folders (Course Folders)")
    public void testLessonp_5675() {
        testNestedFolders(TestData.PLAN_FREEMIUM, TestData.FOLDER_TYPE[6]);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5676:Create Folders (Root Folders)")
    public void testLessonp_5676() {
        testNestedFolders(TestData.PLAN_FREEMIUM, TestData.FOLDER_TYPE[7]);
    }

    @Test(description = "Active user - Curriculum Manager - lessonp-5737:Create Folders (Curriculum Sets)")
    public void testLessonp_5737() {
        testNestedFolders(TestData.PLAN_STARTER, TestData.FOLDER_TYPE[1]);
    }

    @Test(description = "Active user - Curriculum Manager - lessonp-5741:Create Folders (Chapters)")
    public void testLessonp_5741() {
        testNestedFolders(TestData.PLAN_STARTER, TestData.FOLDER_TYPE[2]);
    }

    @Test(description = "Active user - Curriculum Manager - lessonp-5742:Create Folders (Lessons)")
    public void testLessonp_5742() {
        testNestedFolders(TestData.PLAN_PRO, TestData.FOLDER_TYPE[3]);
    }

    @Test(description = "Active user - Curriculum Manager - lessonp-5743:Create Folders (Assessment Sets)")
    public void testLessonp_5743() {
        testNestedFolders(TestData.PLAN_STARTER, TestData.FOLDER_TYPE[4]);
    }

    @Test(description = "Active user - Curriculum Manager - lessonp-5744:Create Folders (Unit Modules)")
    public void testLessonp_5744() {
        testNestedFolders(TestData.PLAN_STARTER, TestData.FOLDER_TYPE[5]);
    }

    @Test(description = "Active user - Curriculum Manager - lessonp-5745:Create Folders (Course Folders)")
    public void testLessonp_5745() {
        testNestedFolders(TestData.PLAN_STARTER, TestData.FOLDER_TYPE[6]);
    }

    @Test(description = "Active user - Curriculum Manager - lessonp-5746:Create Folders (Root Folders)")
    public void testLessonp_5746() {
        testNestedFolders(TestData.PLAN_PRO, TestData.FOLDER_TYPE[7]);
    }

    private void testNestedFolders(String accountPlan, String folderType) {
        stepTwoPage.createNewAccount(accountPlan);
        curriculumManagerPage.loadPage();
        testMaxLimitOfFoldersCreated(folderType);
    }

    public void testAccessCurriculumManagerPageFromHeader(boolean loggedIn) {
        headerPage.hoverOverDiscoverButton();
        headerPage.clickOnCurriculumManagerButton();
        if (!loggedIn) {
            Assert.assertTrue(headerPage.isSignInPopupLinkDisplayed());
            Assert.assertTrue(headerPage.isSignUpPopupLinkDisplayed());
        } else {
            Assert.assertEquals(headerPage.getPath(), TestData.CURRICULUM_MANAGER_PATH);
        }
    }

    public void testAccessCurriculumManagerPageFromSearchPage(boolean loggedIn) {
        discoverResourcesPage.loadPage();
        collectionBuilderPage.clickOnMyResources();
        if (!loggedIn) {
            Assert.assertTrue(collectionBuilderPage.isMyResourcesButtonSignInPopupLinkDisplayed());
            Assert.assertTrue(collectionBuilderPage.isMyResourcesButtonSignUpPopupLinkDisplayed());
        } else {
            Assert.assertEquals(discoverResourcesPage.getPath(), TestData.CURRICULUM_MANAGER_PATH);
        }
    }

    public void testCreateCollectionFromCollectionBuilder(String folderName) {
        collectionBuilderPage.clickOnDropdown();
        collectionBuilderPage.clickOnCreateNewCollection();
        createNewFolderModal.waitForModal();
        createNewFolderModal.typeName(folderName);
        createNewFolderModal.clickOnCreateFolderButton();
    }

    public void testCreateFolderFromCurriculumManager(String folderName, String folderType) {
        curriculumManagerPage.clickOnCreateAFolderButton();
        createNewFolderModal.waitForModal();
        createNewFolderModal.typeName(folderName);
        createNewFolderModal.chooseFolderType(folderType);
        createNewFolderModal.typeDescription(TestData.NEW_FOLDER_DESCRIPTION);
        createNewFolderModal.clickOnCreateFolderButton();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
        //Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.CREATED_MESSAGE));
        //curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertEquals(curriculumManagerPage.getFolderTitle(), folderName);
        Assert.assertEquals(curriculumManagerPage.getFolderType(), folderType);
        Assert.assertEquals(curriculumManagerPage.getFolderStatus(), TestData.PRIVATE_STATUS);
    }

    public void testMaxLimitOfFoldersCreated(String folderType) {
        testCreateThreeFolders(folderType);
        curriculumManagerPage.clickOnCreateAFolderButton();
        if (upgradeMaxFolderModal.isModalDisplayed()) {
            testUpgradeModalFromMaxFolderLimit();
        } else {
            createNewFolderModal.chooseFolderType(folderType);
            createNewFolderModal.typeName(TestData.NEW_FOLDER_NAME);
            createNewFolderModal.typeDescription(TestData.NEW_FOLDER_DESCRIPTION);
            createNewFolderModal.clickOnCreateFolderButton();
        }
    }

    public void testCreateThreeFolders(String folderType) {
        curriculumManagerPage.loadPage();
        for (int i = 0; i <= 2; i++) {
            testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, folderType);
        }
    }

    public void testUpgradeModalFromMaxFolderLimit() {
        upgradeMaxFolderModal.waitForModal();
        Assert.assertEquals(upgradeMaxFolderModal.getUpgradeModalText(), TestData.UPGRADE_MODAL_TEXT_FROM_MAX_FOLDER_LIMIT);
        upgradeMaxFolderModal.clickOnUpgradeMeButton();
        Assert.assertTrue(lpHomePage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
        stepTwoPage.goBackOnePage();
    }

    public void testDeleteFolder() {
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnDeleteButton();
        removeModal.waitForModal();
        removeModal.clickOnRemoveButton();
        //    Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.REMOVED_MESSAGE));
        curriculumManagerPage.waitForNotificationToDisappear();
    }

    public void testUploadResourceFromMyResources(String accountPlanText, boolean publishedResource) {
        curriculumManagerPage.loadPage();
        if (!accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            testCreateFolderFromCurriculumManager(TestData.NEW_COLLECTION_NAME, TestData.FOLDER_TYPE[0]);
        }
        curriculumManagerPage.clickOnUploadResourceButton();
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            testUpgradeModalFromUploadButton();
        } else {
            testUpload(false, accountPlanText, publishedResource);
            curriculumManagerPage.waitForRefreshIconToDisappear();
            Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
            testIsUploadResourceDisplayed(publishedResource);
        }
    }

    public void testUpload(boolean editCollection, String accountPlanText, boolean publishedResource) {
        uploadFileModal.waitForModal();
        File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "images" + File.separator + "test-upload-file.png");
        uploadFileModal.uploadUsingTextInput(file.getPath());
        uploadFileModal.selectGrade(TestData.UPLOAD_YOUR_FILE_GRADE);
        uploadFileModal.selectSubject(TestData.UPLOAD_YOUR_FILE_SUBJECT);
        uploadFileModal.selectResourceType(TestData.UPLOAD_YOUR_FILE_RESOURCE_TYPE);
        uploadFileModal.typeDescription(TestData.NEW_COLLECTION_DESCRIPTION);
        if (!editCollection) {
            uploadFileModal.selectFolder();
        }
        uploadFileModal.clickOnUploadButton();
        if (publishedResource) {
            uploadFileModal.clickOnPublishOnLessonPlanetButton();
            publishResourceModal();
        } else {
            if ((accountPlanText.equals(TestData.VALID_EMAIL_RSL_SBCEO) || accountPlanText.equals(TestData.VALID_EMAIL_CSL_COBB) || accountPlanText.equals(TestData.VALID_EMAIL_CSL_HENRY)) && !editCollection) {
                uploadFileModal.hoverOverDisabledPublishButton();
                Assert.assertEquals(uploadFileModal.getDisabledPublishButtonPopoverText(), TestData.DISABLED_PUBLISH_UPLOADED_FILE_POPOVER_TEXT);
            }
            uploadFileModal.clickOnDoneButton();
        }
    }

    public void testIsUploadResourceDisplayed(boolean publishedResource) {
        curriculumManagerPage.clickOnMyUploadsFolder();
        curriculumManagerPage.waitForRefreshIconToDisappear();
        Assert.assertTrue(curriculumManagerPage.isUploadResourceDisplayed());
        curriculumManagerPage.clickOnUploadedFileInfoIcon();
        if (!publishedResource) {
            Assert.assertEquals(curriculumManagerPage.getUploadResourceStatus(), TestData.PRIVATE_STATUS);
            Assert.assertEquals(curriculumManagerPage.getUploadResourceTitle(), TestData.UPLOAD_RESOURCE_TITLE);
        } else {
            Assert.assertEquals(curriculumManagerPage.getUploadResourceStatus(), TestData.PUBLISHED_RESOURCE_STATUS);
            Assert.assertEquals(curriculumManagerPage.getUploadResourceTitle(), TestData.PUBLISH_RESOURCE_TITLE);
        }
    }

    public void testUpgradeModalFromUploadButton() {
        upgradeUploadModal.waitForModal();
        Assert.assertEquals(upgradeUploadModal.getUpgradeModalText(), TestData.UPGRADE_MODAL_TEXT_FROM_UPLOAD_BUTTON);
        upgradeUploadModal.clickOnGetFullAccessNowButton();
        Assert.assertTrue(lpHomePage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
        stepTwoPage.goBackOnePage();
    }

    public void testRemoveUploadResource(String accountPlanText) {
        if (!accountPlanText.equals(TestData.PLAN_PRO)) {
            curriculumManagerPage.clickOnMyUploadsFolder();
        }
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnDeleteButton();
        removeModal.clickOnRemoveButton();
        //Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.REMOVED_MESSAGE));
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertFalse(curriculumManagerPage.isUploadResourceDisplayed());
    }

    public void testMyFavoritesFolderActions(String accountPlanText) {
        testPlayResource(accountPlanText);
        testAssignResource(accountPlanText, TestData.ASSIGN_RESOURCE_MODAL_TEXT);
        testGoToResource(accountPlanText);
        testRemoveFavoriteResource();
    }

    public void testFavoriteRegularResource(String accountPlanText) {
        discoverResourcesPage.loadSearchPageInListView();
        if (accountPlanText.equals(TestData.VALID_EMAIL_CSL_HENRY) || accountPlanText.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            discoverResourcesPage.expandProvidersFacet();
        }
        discoverResourcesPage.checkLessonPlanetProvider();
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            discoverResourcesPage.clickSeeReview(false);
        } else {
            discoverResourcesPage.clickSeeFullReview(false);
        }
        testFavoriteButton(TestData.REGULAR_RESOURCE_STATUS, TestData.RESOURCE_TYPE_LESSON);
    }

    public void testFavoriteButton(String resourceStatus, String resourceType) {
        rrpModal.waitForModal();
        rrpModal.clickOnFavoriteButton();
        rrpModal.clickOnViewFavoritesLink();
        curriculumManagerPage.waitForLinkToLoad();
        Assert.assertEquals(curriculumManagerPage.getMyFavoritesFolderStatus(), TestData.PRIVATE_STATUS);
        curriculumManagerPage.clickOnMyFavoritesFolder();
        curriculumManagerPage.waitForRefreshIconToDisappear();
        Assert.assertTrue(curriculumManagerPage.isFavoriteResourceDisplayed());
        curriculumManagerPage.clickOnFavoriteResourceInfoIcon();
        Assert.assertEquals(curriculumManagerPage.getFavoriteResourceStatus(), resourceStatus);
        Assert.assertEquals(curriculumManagerPage.getFavoriteResourceType(), resourceType);
    }

    public void testPlayResource(String accountPlanText) {
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnPlayFavoriteButton();
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            testUpgradeModalFromAssignButton(accountPlanText, TestData.UPGRADE_MODAL_TEXT_FROM_PLAY_BUTTON);
            curriculumManagerPage.clickOnMyFavoritesFolder();
        } else {
            testCurriculumPlayerURL();
            Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
            if (curriculumManagerPage.isActionsDropdownOptionsDisplayed()) {
                curriculumManagerPage.clickOnActionsDropdown();
            }
        }
    }

    public void testUpgradeModalFromAssignButton(String accountPlanText, String bodyText) {
        upgradeAssignModal.waitForModal();
        Assert.assertEquals(upgradeAssignModal.getUpgradeModalText(), bodyText);
        upgradeAssignModal.clickOnUpgradeMeButton();
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertTrue(lpHomePage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
            Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
            stepTwoPage.goBackOnePage();
        } else {
            Assert.assertTrue(lpHomePage.getUrl().contains(TestData.MANAGE_MEMBERSHIP_PAGE_PATH));
            Assert.assertEquals(TestData.MANAGE_MEMBERSHIP_TITLE_MESSAGE, manageMembershipPage.getTitleText());
            manageMembershipPage.goBackOnePage();
        }
    }

    public void testCurriculumPlayerURL() {
        curriculumManagerPage.focusDriverToLastTab();
        curriculumManagerPage.waitForLinkToLoad();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_PLAYER_PATH));
        curriculumManagerPage.closeTab();
    }

    public void testAssignResource(String accountPlanText, String assignBodyText) {
        if (assignBodyText.equals(TestData.ASSIGN_FOLDER_MODAL_TEXT)) {
            curriculumManagerPage.clickOnAFolder();
        }
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnAssignButton();
        if (!accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            testAssignModal(assignBodyText);
            Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
        } else {
            testUpgradeModalFromAssignButton(accountPlanText, TestData.UPGRADE_MODAL_TEXT_FROM_ASSIGN_BUTTON);
        }
    }

    public void testAssignModal(String assignBodyText) {
        assignModal.waitForModal();
        Assert.assertTrue(assignModal.getAssignModalText().contains(assignBodyText));
        assignModal.typeAccessKey(TestData.VALID_PASSWORD);
        assignModal.clickOnSaveButton();
        assignModal.clickOnCopyButton();
        Assert.assertTrue(assignModal.getCopiedLinkPopoverText().contains(TestData.COPIED_POPOVER_TEXT));
        assignModal.clickOnResetAccessKeyLink();
        Assert.assertTrue(assignModal.isAccessKeyFieldDisplayed());
        assignModal.clickOnCloseButton();
    }

    public void testGoToResource(String accountPlanText) {
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            curriculumManagerPage.clickOnMyFavoritesFolder();
        }
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnGoToResourceButton();
        rrpModal.waitForModal();
        Assert.assertTrue(rrpPage.isTitleDisplayed());
        rrpModal.clickCloseModal();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
    }

    public void testRemoveFavoriteResource() {
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnUnFavoriteButton();
        removeModal.clickOnRemoveButton();
        //Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.REMOVED_FAVORITE_RESOURCE_MESSAGE));
        curriculumManagerPage.waitForNotificationToDisappear();
    }

    public void testMyUploadsFolderActions(String accountPlanText) {
        Assert.assertEquals(curriculumManagerPage.getMyUploadsFolderStatus(), TestData.PRIVATE_STATUS);
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(curriculumManagerPage.getMyUploadsFolderItemNumber(), TestData.ZERO_RESOURCES);
            curriculumManagerPage.clickOnMyUploadsFolder();
            Assert.assertFalse(curriculumManagerPage.isMyUploadsFolderActionsDropdownDisplayed());
        } else {
            testEditResource();
            testPlayResource(accountPlanText);
            if ((!accountPlanText.equals(TestData.VALID_EMAIL_RSL_SBCEO)) && (!accountPlanText.equals(TestData.VALID_EMAIL_CSL_HENRY)) && (!accountPlanText.equals(TestData.VALID_EMAIL_CSL_COBB))) {
                testPublishUploadResourceFromActionsDropdown();
            }
            testAssignResource(accountPlanText, TestData.ASSIGN_RESOURCE_MODAL_TEXT);
            testRemoveUploadResource(accountPlanText);
        }
    }

    public void testEditResource() {
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnEditButton();
        editResourceModal.waitForModal();
        editResourceModal.typeTitle(TestData.EDIT_TITLE);
        editResourceModal.clickOnUpdateButton();
        //curriculumManagerPage.waitForRefreshIconToDisappear();
        Assert.assertEquals(curriculumManagerPage.getUploadResourceTitle(), TestData.UPLOAD_RESOURCE_EDIT_TITLE);
    }

    public void testPublishUploadResourceFromActionsDropdown() {
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnPublishButton();
        publishResourceModal();
        curriculumManagerPage.waitForRefreshIconToDisappear();
        Assert.assertEquals(curriculumManagerPage.getUploadResourceStatus(), TestData.PUBLISHED_STATUS);
        Assert.assertEquals(curriculumManagerPage.getUploadResourceTitle(), TestData.PUBLISH_RESOURCE_TITLE);
    }

    public void publishResourceModal() {
        publishResourceModal.waitForModal();
        publishResourceModal.typeTitle(TestData.PUBLISH_RESOURCE_TITLE);
        publishResourceModal.clickAgreementOption();
        publishResourceModal.clickOnPublishResourceButton();
    }

    public void testFolderActions(String accountPlanText) {
        testPlayFolderWithNoItems();
        if (!accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            testPublishFolderWithNoItems();
        }
        testAddRequiredInformationToPublishCollection(accountPlanText);
        testPlayFolderWithItems();
        if (!accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            testPublishFolderWithItems(accountPlanText);
        }
        testAssignResource(accountPlanText, TestData.ASSIGN_FOLDER_MODAL_TEXT);
        testMaxLimitOfFoldersCopied();
        testMoveFolder();
        testDeleteFolder();
    }

    public void testMoveFolder() {
        int foldersNumber = curriculumManagerPage.getFoldersNumber();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnMoveToOption();
        moveToModal.waitForModal();
        moveToModal.clickOnDestinationFolder();
        moveToModal.clickOnMoveToSelectedFolderButton();
        // Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.MOVED_MESSAGE));
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertEquals(curriculumManagerPage.getFoldersNumber(), foldersNumber - 1);
    }

    public void testAddRequiredInformationToPublishCollection(String accountPlanText) {
        testAddRegularResourceToFolder(accountPlanText);
        testCheckResourceIsAddedInFolder(TestData.ONE_RESOURCES);
        if ((!accountPlanText.equals(TestData.VALID_EMAIL_RSL_SBCEO)) && (!accountPlanText.equals(TestData.VALID_EMAIL_CSL_HENRY)) && (!accountPlanText.equals(TestData.VALID_EMAIL_CSL_COBB)) && (!accountPlanText.equals(TestData.PLAN_PRO))) {
            testAddSharedResourceToFolder();
        } else {
            testAddRegularResourceToFolder(accountPlanText);
        }
        testCheckResourceIsAddedInFolder(TestData.TWO_RESOURCES);
    }

    public void testAddRegularResourceToFolder(String accountPlanText) {
        discoverResourcesPage.loadSearchPageInListView();
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            discoverResourcesPage.clickSeeReview(false);
        } else {
            discoverResourcesPage.clickSeeFullReview(false);
        }
        testAddToFolderButton();
    }

    public void testAddSharedResourceToFolder() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.expandProvidersFacet();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(false);
        testAddToFolderButton();
    }

    public void testAddToFolderButton() {
        rrpModal.waitForModal();
        rrpModal.clickOnAddToFolderDropdown();
        rrpModal.clickCollectionFromAddToCollectionDropdown();
        rrpModal.clickAddToFolderButton();
        //Assert.assertTrue(rrpModal.getNotificationText().contains(TestData.RESOURCE_ADDED_TO_FOLDER_MESSAGE));
    }

    public void testCheckResourceIsAddedInFolder(String itemNumber) {
        curriculumManagerPage.loadPage();
        Assert.assertEquals(curriculumManagerPage.getFolderItemNumber(), Integer.parseInt(itemNumber.replaceAll("[()]", "")));
        curriculumManagerPage.clickOnAFolder();
        Assert.assertTrue(curriculumManagerPage.isResourceInFolderDisplayed());
    }

    public void testPlayFolderWithItems() {
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.hoverOverPlayFolderButton();
        Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.PLAY_FOLDER_WITH_ITEMS_POPOVER_TEXT);
        curriculumManagerPage.clickOnPlayFolderButton();
        testCurriculumPlayerURL();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
    }

    public void testPlayFolderWithNoItems() {
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.hoverOverPlayFolderButton();
        Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.PLAY_FOLDER_WITH_NO_ITEMS_POPOVER_TEXT);
    }

    public void testPublishFolderWithItems(String accountPlanText) {
        curriculumManagerPage.clickOnAFolder();
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.hoverOverPublishButton();
        Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.PUBLISH_FOLDER_ADDITIONAL_INFORMATION_TEXT);

        //from here:
        curriculumManagerPage.clickOnEditButton();
        editCollectionModal.clickMoreDropdown();
        editCollectionModal.clickOnPublishOption();
        editCollectionModal.completePublishCollectionRequirements(accountPlanText, TestData.EDIT_COLLECTION_GRADE_HIGHER_ED, TestData.EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION, TestData.NEW_COLLECTION_DESCRIPTION);
        editCollectionModal.clickOnCloseButton();

        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.hoverOverPublishButton();
        Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.PUBLISH_FOLDER_WITH_ITEMS_POPOVER_TEXT);

        curriculumManagerPage.clickOnPublishButton();
        testPublishFolderModal(accountPlanText);
        curriculumManagerPage.waitForRefreshIconToDisappear();
        Assert.assertEquals(curriculumManagerPage.getFolderStatus(), TestData.PRIVATE_AND_PUBLISHED_STATUS);
    }

    public void testPublishFolderModal(String accountPlanText) {
        editCollectionModal.clickOnPublishCollectionButton();

        if (!accountPlanText.equals(TestData.VALID_EMAIL_CSL_HENRY) && !accountPlanText.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            publishedFolderModal.clickOnCloseButton();
        } else {
            //   Assert.assertTrue(editCollectionModal.getAlertNotificationText().contains(TestData.CSL_PUBLISHED_COLLECTION_NOTIFICATION_TEXT));
        }
        editCollectionModal.clickOnCloseButton();
        curriculumManagerPage.waitForRefreshIconToDisappear();
        Assert.assertEquals(TestData.PRIVATE_AND_PUBLISHED_STATUS, curriculumManagerPage.getFolderStatus());
    }

    public void testPublishFolderWithNoItems() {
        curriculumManagerPage.hoverOverPublishButton();
        Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.PUBLISH_FOLDER_WITH_NO_ITEMS_POPOVER_TEXT);
    }

    public void testMaxLimitOfFoldersCopied() {
        for (int i = 0; i < 2; i++) {
            testCopyToButton();
            testCopyFolder();
        }
        testCopyToButton();
        if (!upgradeMaxFolderModal.isModalDisplayed()) {
            testCopyFolder();
        } else {
            testUpgradeModalFromMaxFolderLimit();
            if (curriculumManagerPage.getFoldersNumber() == 0 || curriculumManagerPage.getFoldersNumber() == 1) {
                curriculumManagerPage.refreshPageAndDismissBrowserAlert();
            }
        }
    }

    public void testCopyToButton() {
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnCopyToButton();
    }

    public void testCopyFolder() {
        int foldersNumber = curriculumManagerPage.getFoldersNumber();
        copyToModal.waitForModal();
        copyToModal.typeName(TestData.COPIED_FOLDER_NAME);
        copyToModal.clickMyResourcesDestinationFolder();
        copyToModal.clickOnCopyToSelectedFolderButton();
        // Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.COPIED_MESSAGE));
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertEquals(curriculumManagerPage.getFolderTitle(), TestData.COPIED_FOLDER_NAME);
        Assert.assertEquals(curriculumManagerPage.getFoldersNumber(), foldersNumber + 1);
    }

    public void testListView() {
        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnShowAndHideDetailsButton();
        Assert.assertFalse(curriculumManagerPage.isDateColumnDisplayed());
        Assert.assertFalse(curriculumManagerPage.isStatusColumnDisplayed());
        curriculumManagerPage.clickOnShowAndHideDetailsButton();
        Assert.assertTrue(curriculumManagerPage.isStatusColumnDisplayed());
        Assert.assertTrue(curriculumManagerPage.isDateColumnDisplayed());
    }

    public void testSortByDropdown() {
        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnSortByDropdown();
        Assert.assertTrue(curriculumManagerPage.isResourceTitleOptionDisplayed());
        Assert.assertTrue(curriculumManagerPage.isStatusOptionDisplayed());
        Assert.assertTrue(curriculumManagerPage.isDateOptionDisplayed());
    }

    public void testFavoriteResources(String accountPlanText) {
        testFavoriteRegularResource(accountPlanText);
        if ((!accountPlanText.equals(TestData.VALID_EMAIL_RSL_SBCEO)) && (!accountPlanText.equals(TestData.VALID_EMAIL_CSL_HENRY)) && (!accountPlanText.equals(TestData.VALID_EMAIL_CSL_COBB)) && (!accountPlanText.equals(TestData.PLAN_PRO))) {
            testFavoriteSharedResource();
        }
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            testFavoriteFreeSampleResource();
        }
    }

    private void testFavoriteSharedResource() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.expandProvidersFacet();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(false);
        testFavoriteButton(TestData.SHARED_RESOURCE_STATUS, TestData.RESOURCE_TYPE_ARTICLE);
    }

    private void testFavoriteFreeSampleResource() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickFreeFullAccessReview(false);
        testFavoriteButton(TestData.FREE_SAMPLE_RESOURCE_STATUS, TestData.RESOURCE_TYPE_PRESENTATION);
    }

    protected void testDraggingFoldersIntoAnotherFolder(String accountPlan) {
        curriculumManagerPage.loadPage();
        int currentNoOfFolders = curriculumManagerPage.getCountFolders();
        testCreateThreeFolders(TestData.FOLDER_TYPE[0]);
        Assert.assertEquals(curriculumManagerPage.getCountFolders(), currentNoOfFolders + 3);
        Assert.assertEquals(curriculumManagerPage.getFolderItemNumber(), 0);
        curriculumManagerPage.loadPage();
        curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getFolder(0), curriculumManagerPage.getFolder(2));
        curriculumManagerPage.loadPage();
        if (currentNoOfFolders + 2 <= TestData.CURRICULUM_MANAGER_PAGINATION_MAX_FOLDERS) {
            Assert.assertEquals(curriculumManagerPage.getCountFolders(), currentNoOfFolders + 2);
        } else {
            Assert.assertEquals(curriculumManagerPage.getCountFolders(), TestData.CURRICULUM_MANAGER_PAGINATION_MAX_FOLDERS);
        }
        curriculumManagerPage.clickOnAFolder();
        Assert.assertEquals(curriculumManagerPage.getFolderItemNumber(), 1);
        curriculumManagerPage.clickOnCreateAFolderButton();
        if (accountPlan.endsWith(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(TestData.UPGRADE_MODAL_TEXT_FROM_MAX_FOLDER_LIMIT, upgradeMaxFolderModal.getUpgradeModalText());
        } else {
            createNewFolderModal.waitForModal();
            Assert.assertEquals(TestData.CREATE_A_NEW_FOLDER_MODAL_TITLE, createNewFolderModal.getCreateNewFolderModalTitleFromMyResources());
        }
    }

    private void createNestedFoldersRequirement() {
        curriculumManagerPage.loadPage();
        testCreateThreeFolders(TestData.FOLDER_TYPE[0]);
        curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getFolder(0), curriculumManagerPage.getFolder(2));
        curriculumManagerPage.loadPage();
        curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getFolder(1), curriculumManagerPage.getFolder(0));
        curriculumManagerPage.loadPage();
    }

    protected void testDrilledInViewAndFunctionality(String accountPlan) {
        createNestedFoldersRequirement();

        curriculumManagerPage.clickOnFolder(0);
        Assert.assertEquals(curriculumManagerPage.getCountFolderChilds(), 2);
        WebElement folder0 = curriculumManagerPage.getFolder(0);
        curriculumManagerPage.clickOnActionsDropdownButton(folder0);
        Assert.assertTrue(curriculumManagerPage.isPlayFolderButtonDisplayed(folder0));
        Assert.assertTrue(curriculumManagerPage.isCopyFolderToButtonDisplayed(folder0));
        Assert.assertTrue(curriculumManagerPage.isMoveFolderToButtonDisplayed(folder0));
        Assert.assertTrue(curriculumManagerPage.isDeleteFolderButtonDisplayed(folder0));

        curriculumManagerPage.hoverOverChild(0);
        curriculumManagerPage.clickOnViewFolderButton();

        curriculumManagerPage.waitForLoad();
        Assert.assertEquals(curriculumManagerPage.getCountBreadcrumbs(), 3);
        Assert.assertTrue(curriculumManagerPage.getPath().startsWith(TestData.CURRICULUM_MANAGER_PAGE_PATH + TestData.CURRICULUM_MANAGER_FOLDERS_SUFIX_PATH));
        Assert.assertEquals(TestData.NEW_FOLDER_NAME, curriculumManagerPage.getBreadcrumbLastItemText());
        Assert.assertTrue(curriculumManagerPage.isActionsHeaderButtonDisplayed());

        curriculumManagerPage.clickOnActionsFromHeaderDropdownButton();
        Assert.assertTrue(curriculumManagerPage.isEditFolderButtonDisplayed(null));
        Assert.assertTrue(curriculumManagerPage.isPlayFolderButtonDisplayed(null));
        Assert.assertTrue(curriculumManagerPage.isPlayFolderButtonDisabled(null));
        Assert.assertTrue(curriculumManagerPage.isAssignFolderButtonDisplayed(null));
        Assert.assertTrue(curriculumManagerPage.isAssignFolderButtonDisplayed(null));
        if (!accountPlan.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertTrue(curriculumManagerPage.isPublishFolderButtonDisplayed(null));
        }
        Assert.assertTrue(curriculumManagerPage.isCopyFolderToButtonDisplayed(null));
        Assert.assertTrue(curriculumManagerPage.isMoveFolderToButtonDisplayed(null));
        Assert.assertTrue(curriculumManagerPage.isDeleteFolderButtonDisplayed(null));

        curriculumManagerPage.clickOnEditFolderButton(null);
        editCollectionModal.waitForModal();
        String folderTitle = TestData.GET_NEW_EMAIL();
        editCollectionModal.clickEditDetails();
        editCollectionModal.typeTitle(folderTitle);

        editCollectionModal.clickOnAddItemsDropdown();
        editCollectionModal.clickOnPixabayImageOption();
        editCollectionModal.searchPixabayImage(TestData.PIXABAY_IMAGE_TITLE);
        editCollectionModal.clickPixabaySearchButton();
        editCollectionModal.clickOnPixabayImage(0);
        editCollectionModal.clickAddSelectedToFolderButton();
        editCollectionModal.clickOnCloseButton();

        curriculumManagerPage.refreshPageAndDismissBrowserAlert();

        curriculumManagerPage.clickOnActionsFromHeaderDropdownButton();
        curriculumManagerPage.clickOnPlayFolderButton(null);
        testCurriculumPlayerURL();
        curriculumManagerPage.focusDriverToLastTab();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));

        curriculumManagerPage.refreshPageAndDismissBrowserAlert();
        curriculumManagerPage.clickOnActionsFromHeaderDropdownButton();
        curriculumManagerPage.clickOnAssignFolderButton(null);

        if (accountPlan.equals(TestData.PLAN_FREEMIUM)) {
            testUpgradeModalFromAssignButton(TestData.PLAN_FREEMIUM, TestData.UPGRADE_MODAL_TEXT_FROM_ASSIGN_BUTTON);

        } else {
            testAssignModal(TestData.ASSIGN_FOLDER_PLAYER_MODAL_TEXT);
            Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
        }

        curriculumManagerPage.clickOnActionsFromHeaderDropdownButton();
        curriculumManagerPage.clickOnDeleteFolderButton(null);
        Assert.assertEquals(TestData.DELETE_FOLDER_MODAL_TITLE_TEXT, deleteFolderModal.getTitleText());
        Assert.assertEquals(TestData.DELETE_FOLDER_MESSAGE_TEXT, deleteFolderModal.getContentText());
        deleteFolderModal.clickOnDeleteButton();
        Assert.assertEquals(2, curriculumManagerPage.getCountBreadcrumbs());

        testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[2]);

        curriculumManagerPage.clickOnCreateAFolderButton();
        if (accountPlan.equals(TestData.PLAN_FREEMIUM)) {
            upgradeUploadModal.waitForModal();
            Assert.assertEquals(TestData.UPGRADE_MODAL_TEXT_FROM_MAX_FOLDER_LIMIT, upgradeMaxFolderModal.getUpgradeModalText());
            upgradeMaxFolderModal.clickOnCloseButton();
        } else {
            createNewFolderModal.waitForModal();
            createNewFolderModal.clickOnCancelButton();
        }

        curriculumManagerPage.clickOnUploadResourceButton();
        if (accountPlan.equals(TestData.PLAN_FREEMIUM)) {
            upgradeUploadModal.waitForModal();
            Assert.assertEquals(upgradeUploadModal.getUpgradeModalText(), TestData.UPGRADE_MODAL_TEXT_FROM_UPLOAD_BUTTON);
            upgradeUploadModal.clickOnCloseButton();
        } else {
            uploadFileModal.waitForModal();
            testUpload(false, accountPlan, false);
            curriculumManagerPage.clickOnFolder(0);
            Assert.assertEquals(curriculumManagerPage.getCountFolderChilds(), 1);
            curriculumManagerPage.clickOnFolder(0);
        }

        curriculumManagerPage.clickOnActionsFromHeaderDropdownButton();
        curriculumManagerPage.clickOnCopyFolderToButton(null);

        if (accountPlan.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(TestData.UPGRADE_MODAL_TEXT_FROM_MAX_FOLDER_LIMIT, upgradeMaxFolderModal.getUpgradeModalText());
            upgradeMaxFolderModal.clickOnCloseButton();
        } else {
            copyToModal.waitForModal();
            copyToModal.clickMyResourcesDestinationFolder();
            copyToModal.clickOnCopyToSelectedFolderButton();
        }

        curriculumManagerPage.clickOnActionsFromHeaderDropdownButton();
        curriculumManagerPage.clickOnMoveFolderToButton(null);

        if (accountPlan.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertTrue(moveToModal.getMoveToModalBodyText().contains("please create a folder in My Resources"));
            moveToModal.clickOnCancelButton();
        } else {
            moveToModal.clickOnDestinationFolder();
            moveToModal.clickOnMoveToSelectedFolderButton();
        }

        if (accountPlan.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertTrue(curriculumManagerPage.getPath().startsWith(TestData.CURRICULUM_MANAGER_PAGE_PATH + TestData.CURRICULUM_MANAGER_FOLDERS_SUFIX_PATH));
        } else {
            Assert.assertEquals(curriculumManagerPage.getPath(), TestData.CURRICULUM_MANAGER_PATH);
        }
    }

    protected void testDragAndDrop(String accountPlan) {
        testCreateThreeFolders(TestData.FOLDER_TYPE[3]);

        Assert.assertFalse(collectionBuilderPage.isGetStartedTextDisplayed());
        Assert.assertTrue(collectionBuilderPage.getCreateOrOpenDropdownText().startsWith(TestData.NEW_FOLDER_NAME));
        curriculumManagerPage.clickOnActionsDropdownButton(curriculumManagerPage.getFolder(0));
        curriculumManagerPage.clickOnDeleteFolderButton(curriculumManagerPage.getFolder(0));
        deleteFolderModal.clickOnDeleteButton();

        collectionBuilderPage.waitForLoadingIconToDisappear();
        collectionBuilderPage.waitUntilGetStartedTextIsDisplayed();
        Assert.assertTrue(collectionBuilderPage.isGetStartedTextDisplayed());
        Assert.assertEquals(collectionBuilderPage.getCreateOrOpenDropdownText(), TestData.COLLECTION_BUILDER_CREATE_OR_OPEN_DROPDOWN_TEXT);

        curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getFolder(0), collectionBuilderPage.getGetStartedNonDroppableArea());
        Assert.assertTrue(collectionBuilderPage.isGetStartedTextDisplayed());
        Assert.assertEquals(collectionBuilderPage.getCreateOrOpenDropdownText(), TestData.COLLECTION_BUILDER_CREATE_OR_OPEN_DROPDOWN_TEXT);

        collectionBuilderPage.clickOnDropdown();
        collectionBuilderPage.clickOnFolderFromDropdown(0);
        curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getFolder(0), collectionBuilderPage.getCollectionDroppableZone());
        checkItems(1);

        curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getFolder(0), collectionBuilderPage.getCollectionDroppableZone());
        if (accountPlan.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(collectionBuilderPage.getCollectionBuilderAlertText(), TestData.COLLECTION_BUILDER_UPGRADE_YOUR_MEMBERSHIP_TEXT);
        } else {
            checkItems(2);
        }

        if (!accountPlan.equals(TestData.PLAN_FREEMIUM)) {
            testDeleteItemsFromCollectionBuilder(1);
            curriculumManagerPage.loadPage();
        }
        testDeleteItemsFromCollectionBuilder(0);
    }

    private void checkItems(int numberOfFolders) {
        curriculumManagerPage.loadPage();
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), numberOfFolders);
        Assert.assertEquals(collectionBuilderPage.getNumberOfItemsInCollection(), numberOfFolders);
        curriculumManagerPage.clickOnFolder(0);
        Assert.assertEquals(curriculumManagerPage.getCountFolderChilds(), numberOfFolders);
    }

    private void testDeleteItemsFromCollectionBuilder(int noOfFoldersExpectedToLeft) {
        collectionBuilderPage.hoverOverCollectionBuilderItem(0);
        collectionBuilderPage.clickOnXButton(0);
        deleteCollectionBuilderResourceModal.waitForModal();
        deleteCollectionBuilderResourceModal.clickOnDeleteResourceButton();
        Assert.assertEquals(collectionBuilderPage.getNumberOfItemsInCollection(), noOfFoldersExpectedToLeft);
        if (noOfFoldersExpectedToLeft == 0) {
            Assert.assertEquals(collectionBuilderPage.getDragAndDropText(), TestData.COLLECTION_BUILDER_DRAG_AND_DROP_TEXT);
        }
    }
}
