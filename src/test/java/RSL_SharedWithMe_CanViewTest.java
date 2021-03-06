import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.util.List;

public class RSL_SharedWithMe_CanViewTest extends BaseTest {
    private LoginPage loginPage;
    private User_CurriculumManagerPageTest user_curriculumManagerPageTest;
    private CurriculumManagerPage curriculumManagerPage;
    private ShareFolderModal shareFolderModal;
    private CopyToModal copyToModal;
    private RemoveSharedFolderModal removeSharedFolderModal;
    private CollectionBuilderPage collectionBuilderPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private AssignModal assignModal;
    private EditFolderModal editFolderModal;
    private ConfirmCopySharedFolderModal confirmCopySharedFolderModal;
    private LimitedResourceAccessModal limitedResourceAccessModal;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_curriculumManagerPageTest = new User_CurriculumManagerPageTest();
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        shareFolderModal = new ShareFolderModal(webDriver);
        copyToModal = new CopyToModal(webDriver);
        removeSharedFolderModal = new RemoveSharedFolderModal(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        assignModal = new AssignModal(webDriver);
        editFolderModal = new EditFolderModal(webDriver);
        confirmCopySharedFolderModal = new ConfirmCopySharedFolderModal(webDriver);
        limitedResourceAccessModal = new LimitedResourceAccessModal(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Regular SL - Shared With Me - Can View -C2330: Main Page", groups = {"rsl"})
    public void testC2330() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        testSharedWithMePage();
    }

    @Test(description = "Regular SL - Shared With Me - Can View -C2331: Share a folder", groups = {"rsl"})
    public void testC2331() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        testShareFolder(TestData.VALID_EMAIL_RSL_SBCEO, TestData.SHARE_FOLDER_MODAL_RSL_OWNER_NAME, TestData.RSL_SBCEO_EXISTING_TEACHER_EMAIL, TestData.RSL_SBCEO_TEACHER_FIRST_NAME, TestData.RSL_SBCEO_TEACHER_LAST_NAME, TestData.RSL_SBCEO_EXISTING_DISTRICT_ADMIN_EMAIL, TestData.RSL_SBCEO_DA_FIRST_NAME, TestData.RSL_SBCEO_DA_LAST_NAME, true);
    }

    @Test(description = "Regular SL - Shared With Me - Can View - C2332: Drag-and-drop items", groups = {"rsl"})
    public void testC2332() {
        loginPage.performLogin(TestData.RSL_SBCEO_EXISTING_TEACHER_EMAIL, TestData.VALID_PASSWORD);
        testDragAndDrop(true);
    }

    @Test(description = "Regular SL - Shared With Me - Can View - C2333: Verify shared folder ", groups = {"rsl"})
    public void testC2333() {
        loginPage.performLogin(TestData.RSL_SBCEO_EXISTING_TEACHER_EMAIL, TestData.VALID_PASSWORD);
        testVerifyFolder(TestData.VALID_EMAIL_RSL_SBCEO, true, TestData.SHARED_FOLDER_STATUS_RSL_OWNER);
    }

    public void testSharedWithMePage() {
        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnSharedWithMeTabButton();
        Assert.assertEquals(curriculumManagerPage.getPath(), TestData.SHARED_WITH_ME_PAGE_PATH);
        if (curriculumManagerPage.isFolderListDisplayed()) {
            Assert.assertTrue(curriculumManagerPage.getFolderStatus().contains(TestData.SHARED_WITH_ME_PAGE_FOLDER_STATUS));
        } else {
            Assert.assertEquals(curriculumManagerPage.getSharedWithMeEmptyPageText(), TestData.SHARED_WITH_ME_PAGE_EMPTY_TEXT);
        }
    }

    public void testShareFolder(String ownerEmail, String ownerName, String teacherEmail, String teacherFirstName, String teacherLastName, String districtAdminEmail, String districtAdminFirstName, String districtAdminLastName, boolean canView) {
        curriculumManagerPage.loadPage();
        user_curriculumManagerPageTest.initTest(webDriver);
        if (!canView) {
            user_curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.GET_CURRENT_TIME() + TestData.SHARED_FOLDER_NAME + TestData.SHARE_FOLDER_MODAL_CAN_EDIT_PERMISSION_TEXT, TestData.FOLDER_TYPE[0]);
        } else {
            user_curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.GET_CURRENT_TIME() + TestData.SHARED_FOLDER_NAME + TestData.SHARE_FOLDER_MODAL_DEFAULT_PERMISSION_TEXT, TestData.FOLDER_TYPE[0]);
        }
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);
        List<WebElement> getFullReviewResources = discoverResourcesPage.getAllSeeFullReviewButtons();
        discoverResourcesPage.dragAndDrop(getFullReviewResources.get(0), collectionBuilderPage.getCollectionDroppableZone());
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_COLLECTIONS_TYPES);

        if (ownerEmail.equals(TestData.VALID_EMAIL_CSL_HENRY) || ownerEmail.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            discoverResourcesPage.expandProvidersFacet();
        }
        discoverResourcesPage.checkLessonPlanetProvider();

        List<WebElement> getSeeCollectionResources = discoverResourcesPage.getAllSeeCollectionsButtons();
        discoverResourcesPage.dragAndDrop(getSeeCollectionResources.get(0), collectionBuilderPage.getCollectionDroppableZone());

        if (limitedResourceAccessModal.isModalDisplayed()) {
            limitedResourceAccessModal.clickOnSaveButton();
        }

        curriculumManagerPage.loadPage();

        curriculumManagerPage.clickOnSortByDropdown();
        curriculumManagerPage.clickOnSortByDate();
        curriculumManagerPage.clickOnSortByDropdown();
        curriculumManagerPage.clickOnSortByDescending();

        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnShareFolderButton();
        shareFolderModal.waitForModal();
        Assert.assertEquals(shareFolderModal.getShareFolderModalTitle(), TestData.SHARE_FOLDER_MODAL_TITLE);
        Assert.assertEquals(shareFolderModal.getFolderStatus(), TestData.SHARE_FOLDER_MODAL_FOLDER_PRIVATE_STATUS);
        Assert.assertEquals(shareFolderModal.getShareFolderModalText(), TestData.SHARE_FOLDER_MODAL_SHARE_WITH_TEXT);
        Assert.assertEquals(shareFolderModal.getAddEmailInputPlaceholderText(), TestData.SHARE_FOLDER_MODAL_ADD_EMAIL_INPUT_PLACEHOLDER_TEXT);
        Assert.assertEquals(shareFolderModal.getPermissionText(), TestData.SHARE_FOLDER_MODAL_DEFAULT_PERMISSION_TEXT);
        Assert.assertEquals(shareFolderModal.getOwnerName(), ownerName);
        Assert.assertEquals(shareFolderModal.getOwnerRole(), TestData.SHARE_FOLDER_MODAL_OWNER_ROLE);
        shareFolderModal.hoverOverOwner();
        Assert.assertEquals(shareFolderModal.getOwnerEmail(), ownerEmail);

        shareFolderModal.typeUser(teacherEmail);
        Assert.assertEquals(shareFolderModal.getUserName(), teacherFirstName + " " + teacherLastName);

        if (!canView) {
            shareFolderModal.chooseCanEditPermissions();
        }

        if (canView) {
            Assert.assertEquals(shareFolderModal.getUserPermission(), TestData.SHARE_FOLDER_MODAL_DEFAULT_PERMISSION_TEXT);
        } else {
            Assert.assertEquals(shareFolderModal.getUserPermission(), TestData.SHARE_FOLDER_MODAL_CAN_EDIT_PERMISSION_TEXT);
        }

        Assert.assertTrue(shareFolderModal.isXButtonDisplayed());
        shareFolderModal.hoverOverUser();
        Assert.assertEquals(shareFolderModal.getUserEmail(), teacherEmail);
        shareFolderModal.typeUser(TestData.STARTER_OPTION_TEXT);
        Assert.assertEquals(shareFolderModal.getNoUserFoundText(), TestData.SHARE_FOLDER_MODAL_NO_USER_FOUND_TEXT);
        shareFolderModal.clearEmailInput();
        shareFolderModal.typeUser(districtAdminEmail);
        Assert.assertEquals(shareFolderModal.getUserName(), districtAdminFirstName + " " + districtAdminLastName);
        shareFolderModal.removeUser();
        Assert.assertEquals(shareFolderModal.getUserName(), teacherFirstName + " " + teacherLastName);
        shareFolderModal.clickOnShareFolderButton();
        //Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.SHARED_NOTIFICATION_TEXT));

        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnShareFolderButton();
        shareFolderModal.waitForModal();
        Assert.assertEquals(shareFolderModal.getFolderStatus(), TestData.SHARE_FOLDER_MODAL_FOLDER_SHARED_STATUS);
    }

    public void testDragAndDrop(boolean canView) {
        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnSharedWithMeTabButton();
        Assert.assertEquals(curriculumManagerPage.getPath(), TestData.SHARED_WITH_ME_PAGE_PATH);
        int sharedFolderChildrenNumber = curriculumManagerPage.getFolderItemNumber();
        int foldersNumber = curriculumManagerPage.getFoldersNumber();

        //select Shared Folder from Collection Builder
        collectionBuilderPage.clickOnDropdown();
        collectionBuilderPage.clickOnSharedFolderFromCollectionBuilder();

        //drag & drop a resource from a Shared Folder into a shared folder from Collection Builder
        curriculumManagerPage.clickOnFolder(0);
        curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getExpandedFolderChild(0), collectionBuilderPage.getCollectionDroppableZone());
        curriculumManagerPage.waitForNotificationToDisappear();
        if (canView) {
            Assert.assertEquals(collectionBuilderPage.getNumberOfItemsInCollection(), sharedFolderChildrenNumber);
            Assert.assertEquals(curriculumManagerPage.getCountFolderChildren(), sharedFolderChildrenNumber);
        } else {
            confirmCopySharedFolderModal.clickOnContinueButton();
            Assert.assertEquals(collectionBuilderPage.getNumberOfItemsInCollection(), sharedFolderChildrenNumber + 1);
            Assert.assertEquals(curriculumManagerPage.getCountFolderChildren(), sharedFolderChildrenNumber + 1);
        }
        //drag & drop a resource from a Shared Folder into a shared folder from Collection Builder
        if(canView) {
            curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getExpandedFolderChild(1), collectionBuilderPage.getCollectionDroppableZone());
        } else {
            curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getExpandedFolderChild(2), collectionBuilderPage.getCollectionDroppableZone());
        }

        if (canView) {
            Assert.assertEquals(collectionBuilderPage.getNumberOfItemsInCollection(), sharedFolderChildrenNumber);
            Assert.assertEquals(curriculumManagerPage.getCountFolderChildren(), sharedFolderChildrenNumber);
        } else {
            Assert.assertEquals(collectionBuilderPage.getNumberOfItemsInCollection(), sharedFolderChildrenNumber + 2);
            Assert.assertEquals(curriculumManagerPage.getCountFolderChildren(), sharedFolderChildrenNumber + 2);
        }

        //drag & drop a Shared folder into the same shared folder from Collection Builder
        //Todo: add wait until loading lines are not displayed (the item is visible inside CB)
        curriculumManagerPage.refreshPageAndDismissBrowserAlert();
        curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getFolder(0), collectionBuilderPage.getCollectionDroppableZone());
        curriculumManagerPage.waitForNotificationToDisappear();

        if (canView) {
            Assert.assertEquals(collectionBuilderPage.getNumberOfItemsInCollection(), sharedFolderChildrenNumber);
            Assert.assertEquals(curriculumManagerPage.getFoldersNumber(), foldersNumber);
        } else {
            confirmCopySharedFolderModal.clickOnContinueButton();
            Assert.assertEquals(collectionBuilderPage.getNumberOfItemsInCollection(), sharedFolderChildrenNumber + 3);
            curriculumManagerPage.clickOnFolder(0);
            Assert.assertEquals(curriculumManagerPage.getCountFolderChildren(), sharedFolderChildrenNumber + 3);
        }
        //create a new collection: it won't be displayed on Shared with me Page
        curriculumManagerPage.refreshPageAndDismissBrowserAlert();
        user_curriculumManagerPageTest.initTest(webDriver);
        user_curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder(TestData.NEW_COLLECTION_NAME);

        Assert.assertEquals(curriculumManagerPage.getFoldersNumber(), foldersNumber);

        //drag&drop shared folder resource inside the collection in the Collection Builder
        curriculumManagerPage.clickOnFolder(0);
        curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getExpandedFolderChild(0), collectionBuilderPage.getCollectionDroppableZone());
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertEquals(collectionBuilderPage.getNumberOfItemsInCollection(), 1);

        //drag&drop shared folder resource inside the collection in the Collection Builder
        curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getExpandedFolderChild(1), collectionBuilderPage.getCollectionDroppableZone());
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertEquals(collectionBuilderPage.getNumberOfItemsInCollection(), 2);

        //drag&drop a shared folder inside the collection in the Collection Builder
        curriculumManagerPage.clickOnFolder(0);
        curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getFolder(0), collectionBuilderPage.getCollectionDroppableZone());
        collectionBuilderPage.waitUntilItemIsDisplayed();
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertEquals(collectionBuilderPage.getNumberOfItemsInCollection(), 3);
        Assert.assertEquals(curriculumManagerPage.getFoldersNumber(), foldersNumber);
    }

    public void testVerifyFolder(String accountPlanText, boolean canView, String ownerName) {
        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnSharedWithMeTabButton();
        Assert.assertEquals(curriculumManagerPage.getPath(), TestData.SHARED_WITH_ME_PAGE_PATH);
        int foldersNumber = curriculumManagerPage.getFoldersNumber();
        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.FOLDER_TYPE[0]);
        Assert.assertTrue(curriculumManagerPage.getFolderStatus().contains(TestData.SHARED_WITH_ME_PAGE_FOLDER_STATUS));

        curriculumManagerPage.clickOnActionsDropdown();
        if (!canView) {
            Assert.assertTrue(curriculumManagerPage.isEditFolderButtonDisplayed(null));
            Assert.assertTrue(curriculumManagerPage.isPublishFolderButtonDisplayed(null));
        }
        Assert.assertTrue(curriculumManagerPage.isPlayFolderButtonDisplayed(null));
        Assert.assertTrue(curriculumManagerPage.isAssignFolderButtonDisplayed(null));
        Assert.assertTrue(curriculumManagerPage.isCopyFolderToButtonDisplayed(null));
        Assert.assertTrue(curriculumManagerPage.isShareFolderButtonDisplayed(null));
        Assert.assertTrue(curriculumManagerPage.isRemoveFolderToButtonDisplayed(null));

        curriculumManagerPage.clickOnPlayFolderButton(null);
        user_curriculumManagerPageTest.initTest(webDriver);
        user_curriculumManagerPageTest.testCurriculumPlayerURL();
        curriculumManagerPage.focusDriverToLastTab();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.SHARED_WITH_ME_PAGE_PATH));

        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnShareFolderButton();
        Assert.assertTrue(shareFolderModal.isShareFolderModalDisplayed());
        Assert.assertEquals(shareFolderModal.getFolderStatus(), TestData.SHARE_FOLDER_MODAL_FOLDER_SHARED_STATUS);
        shareFolderModal.clickOnCancelButton();
        if (!canView) {
            curriculumManagerPage.hoverOverActionsDropdown();
            curriculumManagerPage.clickOnActionsDropdown();
            curriculumManagerPage.clickOnEditButton();
            editFolderModal.waitForModal();
            Assert.assertEquals(editFolderModal.getDefaultFolderStatus(), TestData.FOLDER_PUBLISHED_STATUS);
            Assert.assertEquals(editFolderModal.getDetailedFolderStatus(), TestData.FOLDER_EDITING_STATUS_TEXT);

            editFolderModal.clickOnMoreDropdown();
            editFolderModal.clickOnPublishOption();
            editFolderModal.completePublishCollectionRequirements(accountPlanText, TestData.EDIT_COLLECTION_GRADE_HIGHER_ED, TestData.EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION, TestData.NEW_COLLECTION_DESCRIPTION);
            editFolderModal.clickOnPublishFolder();
            editFolderModal.clickOnCloseButton();

            curriculumManagerPage.waitForRefreshIconToDisappear();
            Assert.assertEquals(TestData.SHARED_WITH_ME_PAGE_FOLDER_STATUS + " " + ownerName, curriculumManagerPage.getFolderStatus());
        }

        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnCopyFolderToButton(null);

        copyToModal.waitForModal();
        if(copyToModal.isMyResourcesTabDisplayed()) {
            copyToModal.chooseMyResourcesTab();
        }
        copyToModal.clickOnMyResourcesDestinationFolder();
        copyToModal.clickOnCopyToSelectedFolderButton();
        curriculumManagerPage.waitUntilSpinnerIsNotDisplayed();

        Assert.assertEquals(curriculumManagerPage.getFoldersNumber(), foldersNumber);

        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnAssignFolderButton(null);
        assignModal.typeAccessKey(TestData.VALID_PASSWORD);
        assignModal.clickOnSaveButton();
        assignModal.clickOnCloseButton();

        curriculumManagerPage.clickOnFolder(0);
        if (canView) {
            Assert.assertEquals(curriculumManagerPage.getCountFolderChildren(), 2);
        }
        WebElement resource0 = curriculumManagerPage.getExpandedFolderChild(0);
        WebElement resource1 = curriculumManagerPage.getFolderLastChild();
        curriculumManagerPage.clickOnFolderResourceInfoIcon(0);
        if (canView) {
            Assert.assertEquals(curriculumManagerPage.getChildFolderStatus(0), TestData.SHARED_WITH_ME_PAGE_PERMISSION_VIEW_ONLY);
        } else {
            Assert.assertEquals(curriculumManagerPage.getChildFolderStatus(0), TestData.SHARED_FOLDER_SHARED_STATUS);
        }

        curriculumManagerPage.clickOnActionsDropdownButton(resource0);
        Assert.assertTrue(curriculumManagerPage.isCopyFolderToButtonDisplayed(resource0));
        Assert.assertTrue(curriculumManagerPage.isAssignFolderButtonDisplayed(resource0));
        Assert.assertTrue(curriculumManagerPage.isPlayFolderButtonDisplayed(resource0));

        if (!canView) {
            Assert.assertTrue(curriculumManagerPage.isPublishFolderButtonDisplayed(resource0));
            Assert.assertTrue(curriculumManagerPage.isEditFolderButtonDisplayed(resource0));
            Assert.assertTrue(curriculumManagerPage.isShareFolderButtonDisplayed(resource0));
            Assert.assertTrue(curriculumManagerPage.isDeleteFolderButtonDisplayed(resource0));
        }
        curriculumManagerPage.clickOnActionsDropdownButton(resource0);
        curriculumManagerPage.clickOnActionsDropdownButton(resource1);
        Assert.assertTrue(curriculumManagerPage.isCopyFolderToButtonDisplayed(resource1));
        if (!canView) {
            Assert.assertTrue(curriculumManagerPage.isDeleteFolderButtonDisplayed(resource1));
        }
        curriculumManagerPage.clickOnActionsDropdownButton(resource1);

        curriculumManagerPage.clickOnFirstFolder();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnRemoveFolderButton(null);
        removeSharedFolderModal.waitForModal();
        removeSharedFolderModal.clickOnContinueButton();
        curriculumManagerPage.waitUntilSpinnerIsNotDisplayed();
        Assert.assertEquals(curriculumManagerPage.getFoldersNumber(), foldersNumber - 1);
    }
}
