import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.io.File;

public class User_CurriculumManagerPageTest extends BaseTest {
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private CurriculumManagerPage curriculumManagerPage;
    private CreateNewFolderModal createNewFolderModal;
    private EditFolderModal editFolderModal;
    private EditResourceModal editResourceModal;
    private DiscoverResourcesPage discoverResourcesPage;
    private CollectionBuilderPage collectionBuilderPage;
    private CopyToModal copyToModal;
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

    @BeforeMethod(alwaysRun = true)
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
        upgradeAssignModal = new UpgradeAssignModal(webDriver);
        upgradeUploadModal = new UpgradeUploadModal(webDriver);
        editFolderModal = new EditFolderModal(webDriver);
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

    @Test(description = "Visitor - Curriculum Manager - C2056: Access Curriculum Manager Page", groups = {"visitor"})
    public void testC2056() {
        lpHomePage.loadPage();
        testAccessCurriculumManagerPageFromHeader(false);
        testAccessCurriculumManagerPageFromSearchPage(false);
    }

    @Test(description = "Free member - Curriculum Manager - C2119: Access Curriculum Manager Page", groups = {"freemium"})
    public void testC2119() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testAccessCurriculumManagerPageFromHeader(true);
        testAccessCurriculumManagerPageFromSearchPage(true);
        testSortByDropdown();
        testListView();
    }

    @Test(description = "All Active Users - Curriculum Manager - C2229: Access Curriculum Manager Page", groups = {"activeUser"})
    public void testC2229() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testAccessCurriculumManagerPageFromHeader(true);
        testAccessCurriculumManagerPageFromSearchPage(true);
        testSortByDropdown();
        testListView();
    }

    @Test(description = "Free member - Curriculum Manager - C2120: Create Collections", groups = {"freemium"})
    public void testC2120() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[0]);
    }

    @Test(description = "All Active Users - Curriculum Manager - C2230: Create Collections", groups = {"activeUser"})
    public void testC2230() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[0]);
    }

    @Test(description = "Free member - Curriculum Manager - C2121: Upload Resource & My Uploads Folder", groups = {"freemium"})
    public void testC2121() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testUploadResourceFromMyResources(TestData.PLAN_FREEMIUM, false);
        testMyUploadsFolderActions(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Starter membership - Curriculum Manager - C2231: Upload Resource & My Uploads Folder", groups = {"activeUser"})
    public void testC2231() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testUploadResourceFromMyResources(TestData.PLAN_STARTER, false);
        testMyUploadsFolderActions(TestData.PLAN_STARTER);
    }

    @Test(description = "Pro membership - Curriculum Manager - C2233: Upload Resource & My Uploads Folder", groups = {"activeUser"})
    public void testC2233() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testUploadResourceFromMyResources(TestData.PLAN_PRO, false);
        testMyUploadsFolderActions(TestData.PLAN_PRO);
    }

    @Test(description = "Free member - Curriculum Manager - C2122: Favorite Resource & My Favorites Folder", groups = {"freemium"})
    public void testC2122() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testFavoriteResources(TestData.PLAN_FREEMIUM);
        testMyFavoritesFolderActions(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Starter membership - Curriculum Manager - C2234: Favorite Resource & My Favorites Folder", groups = {"activeUser"})
    public void testC2234() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testFavoriteResources(TestData.PLAN_STARTER);
        testMyFavoritesFolderActions(TestData.PLAN_STARTER);
    }

    @Test(description = "Pro membership - Curriculum Manager - C2236: Favorite Resource & My Favorites Folder", groups = {"activeUser"})
    public void testC2236() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testFavoriteResources(TestData.PLAN_PRO);
        testMyFavoritesFolderActions(TestData.PLAN_PRO);
    }

    @Test(description = "Free member - Curriculum Manager - C2123: Collection: Actions Dropdown", groups = {"freemium"})
    public void testC2123() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        curriculumManagerPage.loadPage();
        testCreateFolderFromCurriculumManager(TestData.NEW_COLLECTION_NAME, TestData.FOLDER_TYPE[0]);
        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.FOLDER_TYPE[0]);
        testFolderActions(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Starter membership - Curriculum Manager - C2237: Collection: Actions Dropdown", groups = {"activeUser"})
    public void testC2237() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        curriculumManagerPage.loadPage();
        testCreateFolderFromCurriculumManager(TestData.NEW_COLLECTION_NAME, TestData.FOLDER_TYPE[0]);
        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.FOLDER_TYPE[0]);
        testFolderActions(TestData.PLAN_STARTER);
    }

    @Test(description = "Pro membership - Curriculum Manager - C2239: Collection: Actions Dropdown", groups = {"activeUser"})
    public void testC2239() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        curriculumManagerPage.loadPage();
        testCreateFolderFromCurriculumManager(TestData.NEW_COLLECTION_NAME, TestData.FOLDER_TYPE[0]);
        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.FOLDER_TYPE[0]);
        testFolderActions(TestData.PLAN_PRO);
    }

    @Test(description = "Free member - Curriculum Manager - C2124: Folder Actions Dropdown", groups = {"freemium"})
    public void testC2124() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        curriculumManagerPage.loadPage();
        testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.FOLDER_TYPE[3]);
        testFolderActions(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Starter membership - Curriculum Manager - C2240: Folder Actions Dropdown", groups = {"activeUser"})
    public void testC2240() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        curriculumManagerPage.loadPage();
        testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.FOLDER_TYPE[3]);
        testFolderActions(TestData.PLAN_STARTER);
    }

    @Test(description = "Pro membership - Curriculum Manager - C2242: Folder Actions Dropdown", groups = {"activeUser"})
    public void testC2242() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        curriculumManagerPage.loadPage();
        testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.FOLDER_TYPE[3]);
        testFolderActions(TestData.PLAN_PRO);
    }

    @Test(description = "Free member - Curriculum Manager - C2125: Dragging folders into another folder", groups = {"freemium"})
    public void testC2125() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        curriculumManagerPage.loadPage();
        testDraggingFoldersIntoAnotherFolder(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Curriculum Manager - C2243: Dragging folders into another folder", groups = {"activeUser"})
    public void testC2243() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        curriculumManagerPage.loadPage();
        testDraggingFoldersIntoAnotherFolder(TestData.PLAN_STARTER);
    }

    @Test(description = "Free member - Curriculum Manager - C2126: Drilled in functionality & buttons", groups = {"freemium"})
    public void testC2126() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testDrilledInViewAndFunctionality(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Curriculum Manager - C2244: Drilled in view & functionality", groups = {"activeUser"})
    public void testC2244() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testDrilledInViewAndFunctionality(TestData.PLAN_STARTER);
    }

    @Test(description = "Free member - Curriculum Manager - C2128: Drag folders into the CB", groups = {"freemium"})
    public void testC2128() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testDragAndDrop(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Curriculum Manager - C2245: Drag folders into the CB", groups = {"activeUser"})
    public void testC2245() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testDragAndDrop(TestData.PLAN_PRO);
    }

    @Test(description = "Free member - Curriculum Manager - C2127: Drilled in view", groups = {"freemium"})
    public void testC2127() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testDrilledInViewAndFunctionality(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Free member - Curriculum Manager - C2118: Create Folders (Curriculum Sets)", groups = {"freemium"})
    public void testC2118() {
        testNestedFolders(TestData.PLAN_FREEMIUM, TestData.FOLDER_TYPE[1]);
    }

    @Test(description = "Free member - Curriculum Manager - C2117: Create Folders (Chapters)", groups = {"freemium"})
    public void testC2117() {
        testNestedFolders(TestData.PLAN_FREEMIUM, TestData.FOLDER_TYPE[2]);
    }

    @Test(description = "Free member - Curriculum Manager - C2116: Create Folders (Lessons)", groups = {"freemium"})
    public void testC2116() {
        testNestedFolders(TestData.PLAN_FREEMIUM, TestData.FOLDER_TYPE[3]);
    }

    @Test(description = "Free member - Curriculum Manager - C2115: Create Folders (Assessment Sets)", groups = {"freemium"})
    public void testC2115() {
        testNestedFolders(TestData.PLAN_FREEMIUM, TestData.FOLDER_TYPE[4]);
    }

    @Test(description = "Free member - Curriculum Manager - C2114: Create Folders (Unit Modules)", groups = {"freemium"})
    public void testC2114() {
        testNestedFolders(TestData.PLAN_FREEMIUM, TestData.FOLDER_TYPE[5]);
    }

    @Test(description = "Free member - Curriculum Manager - C2113: Create Folders (Course Folders)", groups = {"freemium"})
    public void testC2113() {
        testNestedFolders(TestData.PLAN_FREEMIUM, TestData.FOLDER_TYPE[6]);
    }

    @Test(description = "Free member - Curriculum Manager - C2112: Create Folders (Root Folders)", groups = {"freemium"})
    public void testC2112() {
        testNestedFolders(TestData.PLAN_FREEMIUM, TestData.FOLDER_TYPE[7]);
    }

    @Test(description = "Active user - Curriculum Manager - C2228: Create Folders (Curriculum Sets)", groups = {"activeUser"})
    public void testC2228() {
        testNestedFolders(TestData.PLAN_STARTER, TestData.FOLDER_TYPE[1]);
    }

    @Test(description = "Active user - Curriculum Manager - C2227: Create Folders (Chapters)", groups = {"activeUser"})
    public void testC2227() {
        testNestedFolders(TestData.PLAN_STARTER, TestData.FOLDER_TYPE[2]);
    }

    @Test(description = "Active user - Curriculum Manager - C2226: Create Folders (Lessons)", groups = {"activeUser"})
    public void testC2226() {
        testNestedFolders(TestData.PLAN_PRO, TestData.FOLDER_TYPE[3]);
    }

    @Test(description = "Active user - Curriculum Manager - C2225: Create Folders (Assessment Sets)", groups = {"activeUser"})
    public void testC2225() {
        testNestedFolders(TestData.PLAN_STARTER, TestData.FOLDER_TYPE[4]);
    }

    @Test(description = "Active user - Curriculum Manager - C2224: Create Folders (Unit Modules)", groups = {"activeUser"})
    public void testC2224() {
        testNestedFolders(TestData.PLAN_STARTER, TestData.FOLDER_TYPE[5]);
    }

    @Test(description = "Active user - Curriculum Manager - C2223: Create Folders (Course Folders)", groups = {"activeUser"})
    public void testC2223() {
        testNestedFolders(TestData.PLAN_STARTER, TestData.FOLDER_TYPE[6]);
    }

    @Test(description = "Active user - Curriculum Manager - C2222: Create Folders (Root Folders)", groups = {"activeUser"})
    public void testC2222() {
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
        collectionBuilderPage.clickOnViewMyResourcesButton();
        if (!loggedIn) {
            Assert.assertTrue(collectionBuilderPage.isViewMyResourcesButtonSignInPopupLinkDisplayed());
            Assert.assertTrue(collectionBuilderPage.isViewMyResourcesButtonSignUpPopupLinkDisplayed());
        } else {
            Assert.assertEquals(discoverResourcesPage.getPath(), TestData.CURRICULUM_MANAGER_PATH);
        }
    }

    public void testCreateCollectionFromCollectionBuilder(String folderName) {
        collectionBuilderPage.clickOnDropdown();
        collectionBuilderPage.clickOnCreateNewFolderOption();
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
        //Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.CREATED_NOTIFICATION_TEXT));
        //curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertEquals(curriculumManagerPage.getFolderTitle(), folderName);
        Assert.assertEquals(curriculumManagerPage.getFolderType(), folderType);
        Assert.assertEquals(curriculumManagerPage.getFolderStatus(), TestData.PRIVATE_STATUS);
    }

    public void testMaxLimitOfFoldersCreated(String folderType) {
        testCreateThreeFolders(folderType);
        curriculumManagerPage.clickOnCreateAFolderButton();
        createNewFolderModal.chooseFolderType(folderType);
        createNewFolderModal.typeName(TestData.NEW_FOLDER_NAME);
        createNewFolderModal.typeDescription(TestData.NEW_FOLDER_DESCRIPTION);
        createNewFolderModal.clickOnCreateFolderButton();
    }

    public void testCreateThreeFolders(String folderType) {
        curriculumManagerPage.loadPage();
        for (int i = 0; i <= 2; i++) {
            testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, folderType);
        }
    }

    public void testDeleteFolder() {
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnDeleteButton();
        removeModal.waitForModal();
        removeModal.clickOnRemoveButton();
        //Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.REMOVED_NOTIFICATION_TEXT));
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

    public void testRemoveUploadResource() {
        int uploadedResources = curriculumManagerPage.getUploadedResourcesNumber();
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnDeleteButton();
        removeModal.clickOnRemoveButton();
        //Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.REMOVED_NOTIFICATION_TEXT));
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertEquals(curriculumManagerPage.getUploadedResourcesNumber(), uploadedResources - 1);
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
            discoverResourcesPage.clickOnSeeReview(false);
        } else {
            discoverResourcesPage.clickOnSeeFullReview(false);
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
            curriculumManagerPage.clickOnFirstFolder();
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
        rrpModal.clickOnRrpModalXButton();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
    }

    public void testRemoveFavoriteResource() {
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnUnFavoriteButton();
        removeModal.clickOnRemoveButton();
        //Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.REMOVED_FAVORITE_RESOURCE_NOTIFICATION_TEXT));
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
            testRemoveUploadResource();
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
        Assert.assertEquals(curriculumManagerPage.getUploadResourceTitle(), TestData.PUBLISH_RESOURCE_TITLE);
        curriculumManagerPage.clickOnUploadedFileInfoIcon();
        Assert.assertEquals(curriculumManagerPage.getUploadResourceStatus(), TestData.PUBLISHED_STATUS);
    }

    public void publishResourceModal() {
        publishResourceModal.waitForModal();
        publishResourceModal.typeTitle(TestData.PUBLISH_RESOURCE_TITLE);
        publishResourceModal.selectGrade(TestData.UPLOAD_YOUR_FILE_GRADE);
        publishResourceModal.selectSubject(TestData.UPLOAD_YOUR_FILE_SUBJECT);
        publishResourceModal.selectResourceType(TestData.UPLOAD_YOUR_FILE_RESOURCE_TYPE);
        publishResourceModal.typeDescription(TestData.NEW_COLLECTION_DESCRIPTION);
        publishResourceModal.clickOnAgreementCheckbox();
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
        //Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.MOVED_NOTIFICATION_TEXT));
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
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            discoverResourcesPage.clickOnSeeReview(false);
        } else {
            discoverResourcesPage.clickOnSeeFullReview(false);
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
        rrpModal.clickOnFolderFromAddToFolderDropdown();
        rrpModal.clickOnAddToFolderButton();
        //Assert.assertTrue(rrpModal.getNotificationText().contains(TestData.RESOURCE_ADDED_TO_FOLDER_NOTIFICATION_TEXT));
    }

    public void testCheckResourceIsAddedInFolder(String itemNumber) {
        curriculumManagerPage.loadPage();
        Assert.assertEquals(curriculumManagerPage.getFolderItemNumber(), Integer.parseInt(itemNumber.replaceAll("[()]", "")));
        curriculumManagerPage.clickOnFirstFolder();
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
        curriculumManagerPage.clickOnFirstFolder();
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.hoverOverPublishButton();
        Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.PUBLISH_FOLDER_ADDITIONAL_INFORMATION_TEXT);

        //from here:
        curriculumManagerPage.clickOnEditButton();
        editFolderModal.clickOnMoreDropdown();
        editFolderModal.clickOnPublishOption();
        editFolderModal.completePublishCollectionRequirements(accountPlanText, TestData.EDIT_COLLECTION_GRADE_HIGHER_ED, TestData.EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION, TestData.NEW_COLLECTION_DESCRIPTION);
        editFolderModal.clickOnCloseButton();

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
        editFolderModal.clickOnPublishCollectionButton();

        if (!accountPlanText.equals(TestData.VALID_EMAIL_CSL_HENRY) && !accountPlanText.equals(TestData.VALID_EMAIL_CSL_COBB) && !accountPlanText.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            publishedFolderModal.clickOnCloseButton();
        } else {
            editFolderModal.waitUntilPublishFolderSectionIsNotDisplayed();
        }
        editFolderModal.clickOnCloseButton();
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
        testCopyFolder();
    }

    public void testCopyToButton() {
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnCopyToButton();
    }

    public void testCopyFolder() {
        int foldersNumber = curriculumManagerPage.getFoldersNumber();
        copyToModal.waitForModal();
        if(copyToModal.isMyResourcesTabDisplayed()) {
            copyToModal.chooseMyResourcesTab();
        }
        copyToModal.typeName(TestData.COPIED_FOLDER_NAME);
        copyToModal.clickOnMyResourcesDestinationFolder();
        copyToModal.clickOnCopyToSelectedFolderButton();
        curriculumManagerPage.waitUntilSpinnerIsNotDisplayed();
        //Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.COPIED_NOTIFICATION_TEXT));
        //curriculumManagerPage.waitForNotificationToDisappear();
        curriculumManagerPage.loadPage();
        Assert.assertEquals(curriculumManagerPage.getFolderTitle(), TestData.COPIED_FOLDER_NAME);
       // Assert.assertEquals(curriculumManagerPage.getFoldersNumber(), foldersNumber + 1);
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
        Assert.assertTrue(curriculumManagerPage.isSortByTitleOptionDisplayed());
        Assert.assertTrue(curriculumManagerPage.isSortByStatusOptionDisplayed());
        Assert.assertTrue(curriculumManagerPage.isSortByDateUpdatedOptionDisplayed());
        Assert.assertTrue(curriculumManagerPage.isSortByMyOrderOptionDisplayed());
        Assert.assertTrue(curriculumManagerPage.isSortAscendingOptionDisplayed());
        Assert.assertTrue(curriculumManagerPage.isSortDescendingOptionDisplayed());
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
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickOnFreeFullAccessReview(false);
        testFavoriteButton(TestData.FREE_SAMPLE_RESOURCE_STATUS, TestData.RESOURCE_TYPE_LAB_RESOURCE);
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
        curriculumManagerPage.clickOnFirstFolder();
        Assert.assertEquals(curriculumManagerPage.getFolderItemNumber(), 1);
        curriculumManagerPage.clickOnCreateAFolderButton();
        createNewFolderModal.waitForModal();
        Assert.assertEquals(TestData.CREATE_A_NEW_FOLDER_MODAL_TITLE, createNewFolderModal.getCreateNewFolderModalTitleFromMyResources());
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
        Assert.assertEquals(curriculumManagerPage.getCountFolderChildren(), 2);
        WebElement folder0 = curriculumManagerPage.getFolder(0);
        curriculumManagerPage.clickOnActionsDropdownButton(folder0);
        Assert.assertTrue(curriculumManagerPage.isPlayFolderButtonDisplayed(folder0));
        Assert.assertTrue(curriculumManagerPage.isCopyFolderToButtonDisplayed(folder0));
        Assert.assertTrue(curriculumManagerPage.isMoveFolderToButtonDisplayed(folder0));
        Assert.assertTrue(curriculumManagerPage.isDeleteFolderButtonDisplayed(folder0));

        curriculumManagerPage.hoverOverChild(0);
        curriculumManagerPage.clickOnViewChildFolderButton();

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
        editFolderModal.waitForModal();
        String folderTitle = TestData.GET_NEW_EMAIL();
        editFolderModal.clickOnEditDetails();
        editFolderModal.typeTitle(folderTitle);

        editFolderModal.clickOnAddItemsDropdown();
        editFolderModal.clickOnPixabayImageOption();
        editFolderModal.searchPixabayImage(TestData.PIXABAY_IMAGE_TITLE);
        editFolderModal.clickOnPixabaySearchButton();
        editFolderModal.clickOnPixabayImage(0);
        editFolderModal.clickOnAddSelectedToFolderButton();
        editFolderModal.clickOnCloseButton();

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
        createNewFolderModal.waitForModal();
        createNewFolderModal.clickOnCancelButton();

        curriculumManagerPage.clickOnUploadResourceButton();
        if (accountPlan.equals(TestData.PLAN_FREEMIUM)) {
            upgradeUploadModal.waitForModal();
            Assert.assertEquals(upgradeUploadModal.getUpgradeModalText(), TestData.UPGRADE_MODAL_TEXT_FROM_UPLOAD_BUTTON);
            upgradeUploadModal.clickOnCloseButton();
        } else {
            uploadFileModal.waitForModal();
            testUpload(false, accountPlan, false);
            Assert.assertEquals(curriculumManagerPage.getUploadedResourceTitle(0), TestData.UPLOAD_RESOURCE_TITLE);
        }

        curriculumManagerPage.clickOnActionsFromHeaderDropdownButton();
        curriculumManagerPage.clickOnCopyFolderToButton(null);
        copyToModal.waitForModal();
        if (copyToModal.isMyResourcesTabDisplayed()) {
            copyToModal.chooseMyResourcesTab();
        }
        copyToModal.clickOnMyResourcesDestinationFolder();
        copyToModal.clickOnCopyToSelectedFolderButton();

        curriculumManagerPage.clickOnActionsFromHeaderDropdownButton();
        curriculumManagerPage.clickOnMoveFolderToButton(null);
        moveToModal.clickOnDestinationFolder();
        moveToModal.clickOnMoveToSelectedFolderButton();

        Assert.assertEquals(curriculumManagerPage.getPath(), TestData.CURRICULUM_MANAGER_PATH);

    }

    protected void testDragAndDrop(String accountPlan) {
        testCreateThreeFolders(TestData.FOLDER_TYPE[3]);

        Assert.assertFalse(collectionBuilderPage.isGetStartedTextDisplayed());
        Assert.assertTrue(collectionBuilderPage.getCreateOrOpenDropdownText().startsWith(TestData.NEW_FOLDER_NAME));
        curriculumManagerPage.clickOnActionsDropdownButton(curriculumManagerPage.getFolder(0));
        curriculumManagerPage.clickOnDeleteFolderButton(curriculumManagerPage.getFolder(0));
        deleteFolderModal.clickOnDeleteButton();

        curriculumManagerPage.refreshPageAndDismissBrowserAlert();

        Assert.assertEquals(collectionBuilderPage.getCreateOrOpenDropdownText(), "Select Existing");

        collectionBuilderPage.clickOnDropdown();
        collectionBuilderPage.clickOnFolderFromDropdown(0);
        curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getFolder(0), collectionBuilderPage.getCollectionDroppableZone());
        checkItems(1);

        curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getFolder(0), collectionBuilderPage.getCollectionDroppableZone());
        checkItems(2);

        testDeleteItemsFromCollectionBuilder(1);
        curriculumManagerPage.loadPage();
        testDeleteItemsFromCollectionBuilder(0);
    }

    private void checkItems(int numberOfFolders) {
        curriculumManagerPage.loadPage();
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), numberOfFolders);
        Assert.assertEquals(collectionBuilderPage.getNumberOfItemsInCollection(), numberOfFolders);
        curriculumManagerPage.clickOnFolder(0);
        Assert.assertEquals(curriculumManagerPage.getCountFolderChildren(), numberOfFolders);
    }

    private void testDeleteItemsFromCollectionBuilder(int noOfFoldersExpectedToLeft) {
        collectionBuilderPage.hoverOverCollectionBuilderItem(0);
        collectionBuilderPage.clickOnXButton(0);
        deleteCollectionBuilderResourceModal.waitForModal();
        deleteCollectionBuilderResourceModal.clickOnDeleteResourceButton();
        Assert.assertEquals(collectionBuilderPage.getNumberOfItemsInCollection(), noOfFoldersExpectedToLeft);
    }
}
