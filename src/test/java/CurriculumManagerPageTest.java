import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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
    private PublishCollectionModal publishCollectionModal;
    private UploadFileModal uploadFileModal;
    private AssignModal assignModal;
    private BecomeALessonPlanetFreeMemberModal becomeALessonPlanetFreeMemberModal;
    private StepTwoPage stepTwoPage;
    private ManageMembershipPage manageMembershipPage;
    private MoveToModal moveToModal;
    private EditFolder editFolder;

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
        becomeALessonPlanetFreeMemberModal = new BecomeALessonPlanetFreeMemberModal(webDriver);
        createNewFolderModal = new CreateNewFolderModal(webDriver);
        upgradeMaxFolderModal = new UpgradeMaxFolderModal(webDriver);
        upgradeAssignModal = new UpgradeAssignModal(webDriver);
        upgradeUploadModal = new UpgradeUploadModal(webDriver);
        editCollectionModal = new EditCollectionModal(webDriver);
        editResourceModal = new EditResourceModal(webDriver);
        copyToModal = new CopyToModal(webDriver);
        removeModal = new RemoveModal(webDriver);
        publishResourceModal = new PublishResourceModal(webDriver);
        publishCollectionModal = new PublishCollectionModal(webDriver);
        uploadFileModal = new UploadFileModal(webDriver);
        assignModal = new AssignModal(webDriver);
        moveToModal = new MoveToModal(webDriver);
        editFolder = new EditFolder(webDriver);
    }

    public void reachCurriculumManagerPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Visitor - Curriculum Manager - lessonp-3258: Access Curriculum Manager Page")
    public void testLessonp_3258() {
        lpHomePage.loadPage();
        testAccessCurriculumManagerPageFromHeader(false);
        testAccessCurriculumManagerPageFromSearchPage(false);
        testAccessCurriculumManagerPageFromEditCollectionModal(false);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5538: Access Curriculum Manager Page")
    public void testLessonp_5538() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testAccessCurriculumManagerPageFromHeader(true);
        testAccessCurriculumManagerPageFromSearchPage(true);
        testAccessCurriculumManagerPageFromEditCollectionModal(true);
        testSortByDropdown();
        testListView();
    }

    @Test(description = "All Active Users - Curriculum Manager - lessonp-5554: Access Curriculum Manager Page")
    public void testLessonp_5554() {
        stepTwoPage.createNewAccount(TestData.PRIME_OPTION_TEXT);
        testAccessCurriculumManagerPageFromHeader(true);
        testAccessCurriculumManagerPageFromSearchPage(true);
        testAccessCurriculumManagerPageFromEditCollectionModal(true);
        testSortByDropdown();
        testListView();
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5614: Create Collections")
    public void testLessonp_5614() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[0]);
    }

    @Test(description = "All Active Users - Curriculum Manager - lessonp-5615: Create Collections")
    public void testLessonp_5615() {
        stepTwoPage.createNewAccount(TestData.STARTER_OPTION_TEXT);
        testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[0]);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5535: Upload Resource & My Uploads Folder")
    public void testLessonp_5535() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testUploadResourceUsingTextInput(TestData.FREE_MEMBERSHIP_TEXT);
        testMyUploadsFolderActions(TestData.FREE_MEMBERSHIP_TEXT);
    }

    @Test(description = "Starter membership - Curriculum Manager - lessonp- 5542: Upload Resource & My Uploads Folder")
    public void testLessonp_5542() {
        stepTwoPage.createNewAccount(TestData.STARTER_OPTION_TEXT);
        testUploadResourceUsingTextInput(TestData.STARTER_OPTION_TEXT);
        testMyUploadsFolderActions(TestData.STARTER_OPTION_TEXT);
    }

    @Test(description = "Prime membership - Curriculum Manager - lessonp- 5543: Upload Resource & My Uploads Folder")
    public void testLessonp_5543() {
        stepTwoPage.createNewAccount(TestData.PRIME_OPTION_TEXT);
        testUploadResourceUsingTextInput(TestData.PRIME_OPTION_TEXT);
        testMyUploadsFolderActions(TestData.PRIME_OPTION_TEXT);
    }

    @Test(description = "Pro membership - Curriculum Manager - lessonp- 5544: Upload Resource & My Uploads Folder")
    public void testLessonp_5544() {
        stepTwoPage.createNewAccount(TestData.PRO_OPTION_TEXT);
        testUploadResourceUsingTextInput(TestData.PRO_OPTION_TEXT);
        testMyUploadsFolderActions(TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Free memeber - Curriculum Manager - lessonp-5536: Favorite Resource & My Favorites Folder")
    public void testLessonp_5536() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testFavoriteResources(TestData.FREE_MEMBERSHIP_TEXT);
        testMyFavoritesFolderActions(TestData.FREE_MEMBERSHIP_TEXT);
    }

    @Test(description = "Starter membership - Curriculum Manager - lessonp- 5545: Favorite Resource & My Favorites Folder")
    public void testLessonp_5545() {
        stepTwoPage.createNewAccount(TestData.STARTER_OPTION_TEXT);
        testFavoriteResources(TestData.STARTER_OPTION_TEXT);
        testMyFavoritesFolderActions(TestData.STARTER_OPTION_TEXT);
    }

    @Test(description = "Prime membership - Curriculum Manager - lessonp- 5546: Favorite Resource & My Favorites Folder")
    public void testLessonp_5546() {
        stepTwoPage.createNewAccount(TestData.PRIME_OPTION_TEXT);
        testFavoriteResources(TestData.PRIME_OPTION_TEXT);
        testMyFavoritesFolderActions(TestData.PRIME_OPTION_TEXT);
    }

    @Test(description = "Pro membership - Curriculum Manager - lessonp- 5547: Favorite Resource & My Favorites Folder")
    public void testLessonp_5547() {
        stepTwoPage.createNewAccount(TestData.PRO_OPTION_TEXT);
        testFavoriteResources(TestData.PRO_OPTION_TEXT);
        testMyFavoritesFolderActions(TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5537: Collection: Actions Dropdown")
    public void testLessonp_5537() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testCollectionActions(TestData.FREE_MEMBERSHIP_TEXT);
    }

    @Test(description = "Starter membership - Curriculum Manager - lessonp-5548: Collection: Actions Dropdown")
    public void testLessonp_5548() {
        stepTwoPage.createNewAccount(TestData.STARTER_OPTION_TEXT);
        testCollectionActions(TestData.STARTER_OPTION_TEXT);
    }

    @Test(description = "Prime membership - Curriculum Manager - lessonp-5549: Collection: Actions Dropdown")
    public void testLessonp_5549() {
        stepTwoPage.createNewAccount(TestData.PRIME_OPTION_TEXT);
        testCollectionActions(TestData.PRIME_OPTION_TEXT);
    }

    @Test(description = "Pro membership - Curriculum Manager - lessonp-5550: Collection: Actions Dropdown")
    public void testLessonp_5550() {
        stepTwoPage.createNewAccount(TestData.PRO_OPTION_TEXT);
        testCollectionActions(TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Free member - Curriculum Manager - lessonp-5539: Folder Actions Dropdown")
    public void testLessonp_5539() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        curriculumManagerPage.loadPage();
        testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
        testFolderActions();
    }

    @Test(description = "All Active Users - Curriculum Manager - lessonp-5552: Folder Actions Dropdown")
    public void testLessonp_5552() {
        stepTwoPage.createNewAccount(TestData.PRIME_OPTION_TEXT);
        curriculumManagerPage.loadPage();
        testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.LESSON_FOLDER_TYPE);
        testFolderActions();
    }

    private void testAccessCurriculumManagerPageFromHeader(boolean loggedIn) {
        headerPage.hoverOverResourcesButton();
        headerPage.clickOnCurriculumManagerButton();
        if (!loggedIn) {
            Assert.assertTrue(headerPage.isSignInPopupLinkDisplayed());
            Assert.assertTrue(headerPage.isSignUpPopupLinkDisplayed());
        } else {
            Assert.assertEquals(headerPage.getPath(), TestData.CURRICULUM_MANAGER_PATH);
        }
    }

    private void testAccessCurriculumManagerPageFromSearchPage(boolean loggedIn) {
        discoverResourcesPage.loadPage();
        collectionBuilderPage.clickOnMyResources();
        if (!loggedIn) {
            Assert.assertTrue(collectionBuilderPage.isSignInPopupLinkDisplayed());
            Assert.assertTrue(collectionBuilderPage.isSignUpPopupLinkDisplayed());
        } else {
            Assert.assertEquals(discoverResourcesPage.getPath(), TestData.CURRICULUM_MANAGER_PATH);
        }
    }

    private void testAccessCurriculumManagerPageFromEditCollectionModal(boolean loggedIn) {
        if (!loggedIn) {
            discoverResourcesPage.loadSearchPageInListView();
            discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_ARTICLES);
            final WebElement resource = discoverResourcesPage.getFreeAccessResource();
            discoverResourcesPage.dragAndDrop(resource, collectionBuilderPage.getCollectionDroppableZone());
            becomeALessonPlanetFreeMemberModal.waitForModal();
            becomeALessonPlanetFreeMemberModal.clickOnCloseModalButton();
            discoverResourcesPage.waitForLoad();
            collectionBuilderPage.clickOnEditCollection(false);
            Assert.assertTrue(collectionBuilderPage.isSignInPopupLinkDisplayed());
            Assert.assertTrue(collectionBuilderPage.isSignUpPopupLinkDisplayed());
        } else {
            discoverResourcesPage.loadPage();
            testCreateCollectionFromCollectionBuilder();
            collectionBuilderPage.clickOnEditCollection(false);
            editCollectionModal.waitForModal();
            editCollectionModal.clickOnMyResourcesButton();
            Assert.assertEquals(discoverResourcesPage.getPath(), TestData.CURRICULUM_MANAGER_PATH);
        }
    }

    public void testCreateCollectionFromCollectionBuilder() {
        collectionBuilderPage.clickOnDropdown();
        collectionBuilderPage.clickOnCreateNewFolder();
        createNewFolderModal.waitForModal();
        createNewFolderModal.typeName(TestData.NEW_COLLECTION_NAME);
        createNewFolderModal.clickOnCreateFolderButton();
    }

    public void testCreateFolderFromCurriculumManager(String folderName, String folderType) {
        curriculumManagerPage.clickOnCreateAFolderButton();
        createNewFolderModal.waitForModal();
        createNewFolderModal.chooseFolderType(folderType);
        createNewFolderModal.typeName(folderName);
        createNewFolderModal.typeDescription(TestData.NEW_FOLDER_DESCRIPTION);
        createNewFolderModal.clickOnCreateFolderButton();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
        Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.CREATED_MESSAGE));
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertEquals(curriculumManagerPage.getFolderTitle(), folderName);
        Assert.assertEquals(curriculumManagerPage.getFolderStatus(), TestData.PRIVATE_STATUS);
    }

    public void testMaxLimitOfFoldersCreated(String folderType) {
        testCreateThreeFolders(folderType);
        curriculumManagerPage.clickOnCreateAFolderButton();
        if (upgradeMaxFolderModal.isModalDisplayed()) {
            testUpgradeModalFromMaxFolderLimit();
        } else {
            testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, folderType);
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

    private void testDeleteFolder() {
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnDeleteButton();
        removeModal.waitForModal();
        removeModal.clickOnRemoveButton();
        Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.DELETED_MESSAGE));
        curriculumManagerPage.waitForNotificationToDisappear();
    }

    public void testUploadResourceUsingTextInput(String accountPlanText) {
        curriculumManagerPage.loadPage();
        if(!accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)){
            testCreateFolderFromCurriculumManager(TestData.NEW_COLLECTION_NAME, TestData.FOLDER_TYPE[0]);
        }
        curriculumManagerPage.clickOnUploadResourceButton();
        if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
            testUpgradeModalFromUploadButton();
        } else {
            testUpload(false, accountPlanText);
            curriculumManagerPage.waitForRefreshIconToDisappear();
            Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
            testIsUploadResourceDisplayed();
        }
    }

    public void testUpload(boolean editCollection, String accountPlanText) {
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
        if(accountPlanText.equals(TestData.VALID_EMAIL_RSL_SBCEO) && !editCollection){
            uploadFileModal.hoverOverDisabledPublishButton();
            Assert.assertEquals(uploadFileModal.getDisabledPublishButtonPopoverText(), TestData.DISABLED_PUBLISH_UPLOADED_FILE_POPOVER_TEXT);
        }
        uploadFileModal.clickOnDoneButton();
    }

    private void testIsUploadResourceDisplayed() {
        curriculumManagerPage.clickOnMyUploadsFolder();
        curriculumManagerPage.waitForRefreshIconToDisappear();
        Assert.assertTrue(curriculumManagerPage.isUploadResourceDisplayed());
        Assert.assertEquals(curriculumManagerPage.getUploadResourceTitle(), TestData.UPLOAD_RESOURCE_TITLE);
        Assert.assertEquals(curriculumManagerPage.getUploadResourceStatus(), TestData.PRIVATE_STATUS);
    }

    public void testUpgradeModalFromUploadButton() {
        upgradeUploadModal.waitForModal();
        Assert.assertEquals(upgradeUploadModal.getUpgradeModalText(), TestData.UPGRADE_MODAL_TEXT_FROM_UPLOAD_BUTTON);
        upgradeUploadModal.clickOnGetFullAccessNowButton();
        Assert.assertTrue(lpHomePage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
        stepTwoPage.goBackOnePage();
    }

    private void testRemoveUploadResource(String accountPlanText) {
        if (!accountPlanText.equals(TestData.PRO_OPTION_TEXT)) {
            curriculumManagerPage.clickOnMyUploadsFolder();
        }
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnDeleteButton();
        removeModal.clickOnRemoveButton();
        Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.DELETED_MESSAGE));
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertFalse(curriculumManagerPage.isUploadResourceDisplayed());
    }

    private void testMyFavoritesFolderActions(String accountPlanText) {
        testPlayResource(accountPlanText);
        testAssignResource(accountPlanText, TestData.ASSIGN_RESOURCE_MODAL_TEXT);
        testGoToResource(accountPlanText);
        testRemoveFavoriteResource();
    }

    public void testFavoriteRegularResource(String accountPlanText) {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
            discoverResourcesPage.clickSeeReview(false);
        } else {
            discoverResourcesPage.clickSeeFullReview(false);
        }
        testFavoriteButton(TestData.REGULAR_RESOURCE_STATUS);
    }

    private void testFavoriteButton(String resourceStatus) {
        rrpModal.waitForModal();
        rrpModal.clickOnFavoriteButton();
        rrpModal.clickOnViewFavoritesLink();
        curriculumManagerPage.waitForLinkToLoad();
        Assert.assertEquals(curriculumManagerPage.getMyFavoritesFolderStatus(), TestData.PRIVATE_STATUS);
        curriculumManagerPage.clickOnMyFavoritesFolder();
        curriculumManagerPage.waitForRefreshIconToDisappear();
        Assert.assertTrue(curriculumManagerPage.isFavoriteResourceDisplayed());
        Assert.assertEquals(curriculumManagerPage.getFavoriteResourceStatus(), resourceStatus);
    }

    private void testPlayResource(String accountPlanText) {
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnPlayFavoriteButton();
        if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
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
        if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
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
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnAssignButton();
        if (accountPlanText.equals(TestData.PRO_OPTION_TEXT) || accountPlanText.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            testAssignModal(assignBodyText);
            Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
        } else {
            testUpgradeModalFromAssignButton(accountPlanText, TestData.UPGRADE_MODAL_TEXT_FROM_ASSIGN_BUTTON);
        }
    }

    public void testAssignModal(String assignBodyText){
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

    private void testGoToResource(String accountPlanText) {
        if (!accountPlanText.equals(TestData.PRO_OPTION_TEXT)) {
            curriculumManagerPage.clickOnMyFavoritesFolder();
        }
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnGoToResourceButton();
        rrpModal.waitForModal();
        Assert.assertTrue(rrpPage.isTitleDisplayed());
        rrpModal.clickCloseModal();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
    }

    private void testRemoveFavoriteResource() {
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnDeleteButton();
        removeModal.clickOnRemoveButton();
        Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.REMOVED_FAVORITE_RESOURCE_MESSAGE));
        curriculumManagerPage.waitForNotificationToDisappear();
    }

    private void testMyUploadsFolderActions(String accountPlanText) {
        Assert.assertEquals(curriculumManagerPage.getMyUploadsFolderStatus(), TestData.PRIVATE_STATUS);
        if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
            Assert.assertEquals(curriculumManagerPage.getMyUploadsFolderItemNumber(), TestData.ZERO_RESOURCES);
            curriculumManagerPage.clickOnMyUploadsFolder();
            Assert.assertFalse(curriculumManagerPage.isMyUploadsFolderActionsDropdownDisplayed());
        } else {
            testEditResource();
            testPlayResource(accountPlanText);
            testPublishUploadResource();
            testAssignResource(accountPlanText, TestData.ASSIGN_RESOURCE_MODAL_TEXT);
            testRemoveUploadResource(accountPlanText);
        }
    }

    private void testEditResource() {
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnEditButton();
        editResourceModal.waitForModal();
        editResourceModal.typeTitle(TestData.EDIT_TITLE);
        editResourceModal.clickOnUpdateButton();
        curriculumManagerPage.waitForRefreshIconToDisappear();
        Assert.assertEquals(curriculumManagerPage.getUploadResourceTitle(), TestData.UPLOAD_RESOURCE_EDIT_TITLE);
    }

    private void testPublishUploadResource() {
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnPublishButton();
        publishResourceModal.waitForModal();
        publishResourceModal.typeTitle(TestData.PUBLISH_RESOURCE_TITLE);
        publishResourceModal.clickAgreementOption();
        publishResourceModal.clickOnPublishResourceButton();
        curriculumManagerPage.waitForRefreshIconToDisappear();
        Assert.assertEquals(curriculumManagerPage.getUploadResourceStatus(), TestData.PUBLISHED_RESOURCE_STATUS);
        Assert.assertEquals(curriculumManagerPage.getUploadResourceTitle(), TestData.PUBLISH_RESOURCE_TITLE);
    }

    private void testCollectionActions(String accountPlanText) {
        curriculumManagerPage.loadPage();
        testCreateFolderFromCurriculumManager(TestData.NEW_COLLECTION_NAME, TestData.FOLDER_TYPE[0]);
        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.COLLECTION_FOLDER_TYPE);
        testPlayCollectionWithNoItems();
        testPublishCollectionWithNoItems();
        testAddRequiredInformationToPublishCollection(accountPlanText);
        testPlayCollectionWithItems();
        testPublishCollectionWithItems();
        testAssignResource(accountPlanText, TestData.ASSIGN_COLLECTION_MODAL_TEXT);
        testMaxLimitOfFoldersCopied();
        testMoveFolder();
        testDeleteFolder();
    }

    private void testMoveFolder() {
        int foldersNumber = curriculumManagerPage.getFoldersNumber();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnMoveToOption();
        moveToModal.waitForModal();
        moveToModal.clickOnMyResourcesChildDestinationFolder();
        moveToModal.clickOnMoveToSelectedFolderButton();
        Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.MOVED_MESSAGE));
        Assert.assertEquals(curriculumManagerPage.getFoldersNumber(), foldersNumber - 1);
    }

    public void testAddRequiredInformationToPublishCollection(String accountPlanText) {
        testAddRegularResourceToCollection(accountPlanText);
        testCheckResourceIsAddedInCollection(TestData.ONE_RESOURCES);
        testAddSharedResourceToCollection();
        testCheckResourceIsAddedInCollection(TestData.TWO_RESOURCES);
        testEditCollection();
    }

    public void testAddRegularResourceToCollection(String accountPlanText) {
        discoverResourcesPage.loadSearchPageInListView();
        if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
            discoverResourcesPage.clickSeeReview(false);
        } else {
            discoverResourcesPage.clickSeeFullReview(false);
        }
        testAddToCollectionButton();
    }

    public void testAddSharedResourceToCollection() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(false);
        testAddToCollectionButton();
    }

    private void testAddToCollectionButton() {
        rrpModal.waitForModal();
        rrpModal.clickOnAddToFolderDropdown();
        rrpModal.clickCollectionFromAddToCollectionDropdown();
        rrpModal.clickAddToFolderButton();
        Assert.assertTrue(rrpModal.getNotificationText().contains(TestData.RESOURCE_ADDED_TO_COLLECTION_MESSAGE));
    }

    private void testCheckResourceIsAddedInCollection(String itemNumber) {
        curriculumManagerPage.loadPage();
        Assert.assertTrue(curriculumManagerPage.getFolderItemNumber().contains(itemNumber));
        curriculumManagerPage.clickOnAFolder();
        Assert.assertTrue(curriculumManagerPage.isResourceInFolderDisplayed());
    }

    private void testEditCollection() {
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnEditButton();
        testEditCollectionModalDetailsArea();
        editCollectionModal.clickOnCloseButton();
        curriculumManagerPage.waitForRefreshIconToDisappear();
    }

    public void testEditCollectionModalDetailsArea() {
        editCollectionModal.waitForModal();
        editCollectionModal.typeTitle(TestData.EDIT_TITLE);
        editCollectionModal.selectGrade(TestData.EDIT_COLLECTION_GRADE_HIGHER_ED);
        editCollectionModal.selectSubject(TestData.EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION);
        editCollectionModal.typeDescription(TestData.NEW_COLLECTION_DESCRIPTION);
    }

    private void testPlayCollectionWithItems() {
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.hoverOverPlayCollectionButton();
        Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.PLAY_COLLECTION_WITH_ITEMS_POPOVER_TEXT);
        curriculumManagerPage.clickOnPlayCollectionButton();
        testCurriculumPlayerURL();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
    }

    private void testPlayCollectionWithNoItems() {
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.hoverOverPlayCollectionButton();
        Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.PLAY_COLLECTION_WITH_NO_ITEMS_POPOVER_TEXT);
    }

    private void testPublishCollectionWithItems() {
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.hoverOverPublishButton();
        Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.PUBLISH_COLLECTION_WITH_ITEMS_POPOVER_TEXT);
        curriculumManagerPage.clickOnPublishButton();
        testPublishCollectionModal();
        curriculumManagerPage.waitForRefreshIconToDisappear();
        Assert.assertEquals(curriculumManagerPage.getFolderStatus(), TestData.PUBLISHED_STATUS);
    }

    public void testPublishCollectionModal() {
        publishCollectionModal.waitForModal();
        publishCollectionModal.chooseRating();
        publishCollectionModal.chooseAudience();
        publishCollectionModal.typeConcept();
        publishCollectionModal.clickOnPublishCollectionButton();
        publishCollectionModal.clickOnCloseButton();
    }

    private void testPublishCollectionWithNoItems() {
        curriculumManagerPage.hoverOverPublishButton();
        Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.PUBLISH_COLLECTION_WITH_NO_ITEMS_POPOVER_TEXT);
    }

    private void testMaxLimitOfFoldersCopied() {
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

    private void testCopyToButton() {
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnCopyToButton();
    }

    private void testCopyFolder() {
        int foldersNumber = curriculumManagerPage.getFoldersNumber();
        copyToModal.waitForModal();
        copyToModal.typeName(TestData.COPIED_FOLDER_NAME);
        copyToModal.clickMyResourcesDestinationFolder();
        copyToModal.clickOnCopyToSelectedFolderButton();
        Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.CREATED_MESSAGE));
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertEquals(curriculumManagerPage.getFolderTitle(), TestData.COPIED_FOLDER_NAME);
        Assert.assertEquals(curriculumManagerPage.getFoldersNumber(), foldersNumber + 1);
    }

    private void testListView() {
        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnShowAndHideDetailsButton();
        Assert.assertFalse(curriculumManagerPage.isDateColumnDisplayed());
        Assert.assertFalse(curriculumManagerPage.isStatusColumnDisplayed());
        curriculumManagerPage.clickOnShowAndHideDetailsButton();
        Assert.assertTrue(curriculumManagerPage.isStatusColumnDisplayed());
        Assert.assertTrue(curriculumManagerPage.isDateColumnDisplayed());
    }

    private void testSortByDropdown() {
        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnSortByDropdown();
        Assert.assertTrue(curriculumManagerPage.isResourceTitleOptionDisplayed());
        Assert.assertTrue(curriculumManagerPage.isStatusOptionDisplayed());
        Assert.assertTrue(curriculumManagerPage.isDateOptionDisplayed());
    }

    private void testFavoriteResources(String accountPlanText) {
        testFavoriteRegularResource(accountPlanText);
        testFavoriteSharedResource();
        if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
            testFavoriteFreeSampleResource();
        }
    }

    private void testFavoriteSharedResource() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(false);
        testFavoriteButton(TestData.SHARED_RESOURCE_STATUS);
    }

    private void testFavoriteFreeSampleResource() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickFreeFullAccessReview(false);
        testFavoriteButton(TestData.FREE_SAMPLE_RESOURCE_STATUS);
    }

    private void testEditFolder() {
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnEditButton();
        editFolder.waitForModal();
        editFolder.chooseFolderType(TestData.FOLDER_TYPE[2]);
        editFolder.typeName(TestData.NEW_FOLDER_NAME + TestData.EDIT_TITLE);
        editFolder.typeDescription(TestData.NEW_COLLECTION_DESCRIPTION);
        editFolder.clickOnSaveButton();
        if(curriculumManagerPage.getFolderTitle().equals(TestData.NEW_FOLDER_NAME)){
            curriculumManagerPage.clickOnActionsDropdown();
            curriculumManagerPage.clickOnEditButton();
            editFolder.typeName(TestData.NEW_FOLDER_NAME + TestData.EDIT_TITLE);
            editFolder.clickOnSaveButton();
        }
        Assert.assertEquals(curriculumManagerPage.getFolderTitle(), TestData.NEW_FOLDER_NAME + TestData.EDIT_TITLE);
        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.CHAPTER_FOLDER_TYPE);
    }

    private void testFolderActions() {
        testEditFolder();
        testMaxLimitOfFoldersCopied();
        testMoveFolder();
        testDeleteFolder();
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.hoverOverPlayButton();
        Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.PLAY_FOLDER_POPOVER_TEXT);
        curriculumManagerPage.hoverOverPublishButton();
        Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.PUBLISH_FOLDER_POPOVER_TEXT);
        curriculumManagerPage.hoverOverAssignButton();
        Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.ASSIGN_FOLDER_POPOVER_TEXT);
    }
}
