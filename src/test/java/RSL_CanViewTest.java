import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.util.List;

public class RSL_CanViewTest extends BaseTest {
    private LoginPage loginPage;
    private CurriculumManagerPageTest curriculumManagerPageTest;
    private CurriculumManagerPage curriculumManagerPage;
    private ShareFolderModal shareFolderModal;
    private CopyToModal copyToModal;
    private RemoveSharedFolderModal removeSharedFolderModal;
    private CollectionBuilderPage collectionBuilderPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private AssignModal assignModal;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        curriculumManagerPageTest = new CurriculumManagerPageTest();
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        shareFolderModal = new ShareFolderModal(webDriver);
        copyToModal = new CopyToModal(webDriver);
        removeSharedFolderModal = new RemoveSharedFolderModal(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        assignModal = new AssignModal(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "RSL - Shared With Me - lessonp-5965: Main Page", priority = 1)
    public void testLessonp_5965() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        testSharedWithMePage();
    }

    @Test(description = "RSL - Shared With Me - lessonp-5966: Share a folder - Can View Permission", priority = 2)
    public void testLessonp_5966() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        testShareFolder(TestData.VALID_EMAIL_RSL_SBCEO, TestData.SHARE_FOLDER_MODAL_RSL_OWNER_NAME, TestData.RSL_SBCEO_EXISTING_TEACHER_EMAIL, TestData.RSL_SBCEO_TEACHER_FIRST_NAME, TestData.RSL_SBCEO_TEACHER_LAST_NAME, TestData.RSL_SBCEO_EXISTING_DISTRICT_ADMIN_EMAIL, TestData.RSL_SBCEO_DA_FIRST_NAME, TestData.RSL_SBCEO_DA_LAST_NAME);
    }

    @Test(description = "RSL - Shared With Me - lessonp-5989: Drag-and-drop items - Can View Permission", priority = 3)
    public void testLessonp_5989() {
        loginPage.performLogin(TestData.RSL_SBCEO_EXISTING_TEACHER_EMAIL, TestData.VALID_PASSWORD);
        testDragAndDrop();
    }

    @Test(description = "RSL - Shared With Me - lessonp-6012: Verify shared folder - Can View Permission", priority = 4)
    public void testLessonp_6012() {
        loginPage.performLogin(TestData.RSL_SBCEO_EXISTING_TEACHER_EMAIL, TestData.VALID_PASSWORD);
        testVerifyFolder();
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

    public void testShareFolder(String ownerEmail, String ownerName, String teacherEmail, String teacherFirstName, String teacherLastName, String districtAdminEmail, String districtAdminFirstName, String districtAdminLastName) {
        curriculumManagerPage.loadPage();
        curriculumManagerPageTest.initTest(webDriver);
        curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.GET_CURRENT_TIME() + TestData.SHARED_FOLDER_NAME + TestData.SHARE_FOLDER_MODAL_DEFAULT_PERMISSION_TEXT, TestData.FOLDER_TYPE[0]);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);
        List<WebElement> getFullReviewResources = discoverResourcesPage.getAllSeeFullReviewButtons();
        discoverResourcesPage.dragAndDrop(getFullReviewResources.get(0), collectionBuilderPage.getCollectionDroppableZone());
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_COLLECTIONS_TYPES);
        List<WebElement> getSeeCollectionResources = discoverResourcesPage.getAllSeeCollectionsButtons();
        discoverResourcesPage.dragAndDrop(getSeeCollectionResources.get(0), collectionBuilderPage.getCollectionDroppableZone());

        curriculumManagerPage.loadPage();
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
        Assert.assertEquals(shareFolderModal.getUserPermission(), TestData.SHARE_FOLDER_MODAL_DEFAULT_PERMISSION_TEXT);
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
        // Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.SHARED_WITH_ME_PAGE_NOTIFICATION_TEXT));

        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnShareFolderButton();
        shareFolderModal.waitForModal();
        Assert.assertEquals(shareFolderModal.getFolderStatus(), TestData.SHARE_FOLDER_MODAL_FOLDER_SHARED_STATUS);
    }

    public void testDragAndDrop() {
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
        Assert.assertEquals(collectionBuilderPage.getNumberOfItemsInCollection(), sharedFolderChildrenNumber);
        Assert.assertEquals(curriculumManagerPage.getCountFolderChilds(), sharedFolderChildrenNumber);

        //drag & drop a Shared folder into the same shared folder from Collection Builder
        curriculumManagerPage.refreshPageAndDismissBrowserAlert();
        curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getFolder(0), collectionBuilderPage.getCollectionDroppableZone());
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertEquals(collectionBuilderPage.getNumberOfItemsInCollection(), sharedFolderChildrenNumber);
        Assert.assertEquals(curriculumManagerPage.getFoldersNumber(), foldersNumber);

        //create a new collection: it won't be displayed on Shared with me Page
        curriculumManagerPageTest.initTest(webDriver);
        curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder(TestData.NEW_COLLECTION_NAME);
        Assert.assertEquals(curriculumManagerPage.getFoldersNumber(), foldersNumber);

        //drag&drop shared folder resource inside the collection in the Collection Builder
        curriculumManagerPage.clickOnFolder(0);
        curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getExpandedFolderChild(0), collectionBuilderPage.getCollectionDroppableZone());
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertEquals(collectionBuilderPage.getNumberOfItemsInCollection(), 1);
        curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getExpandedFolderChild(1), collectionBuilderPage.getCollectionDroppableZone());
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertEquals(collectionBuilderPage.getNumberOfItemsInCollection(), 2);

        //drag&drop a shared folder inside the collection in the Collection Builder
        curriculumManagerPage.clickOnFolder(0);
        curriculumManagerPage.customDragAndDrop(curriculumManagerPage.getFolder(0), collectionBuilderPage.getCollectionDroppableZone());
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertEquals(collectionBuilderPage.getNumberOfItemsInCollection(), 3);
        Assert.assertEquals(curriculumManagerPage.getFoldersNumber(), foldersNumber);
    }

    public void testVerifyFolder() {
        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnSharedWithMeTabButton();
        Assert.assertEquals(curriculumManagerPage.getPath(), TestData.SHARED_WITH_ME_PAGE_PATH);
        int foldersNumber = curriculumManagerPage.getFoldersNumber();
        Assert.assertEquals(curriculumManagerPage.getFolderType(), TestData.FOLDER_TYPE[0]);
        Assert.assertTrue(curriculumManagerPage.getFolderStatus().contains(TestData.SHARED_WITH_ME_PAGE_FOLDER_STATUS));

        curriculumManagerPage.clickOnActionsDropdown();
        Assert.assertTrue(curriculumManagerPage.isPlayFolderButtonDisplayed(null));
        Assert.assertTrue(curriculumManagerPage.isAssignFolderButtonDisplayed(null));
        Assert.assertTrue(curriculumManagerPage.isCopyFolderToButtonDisplayed(null));
        Assert.assertTrue(curriculumManagerPage.isShareFolderButtonDisplayed(null));
        Assert.assertTrue(curriculumManagerPage.isRemoveFolderToButtonDisplayed(null));

        curriculumManagerPage.clickOnPlayFolderButton(null);
        curriculumManagerPageTest.initTest(webDriver);
        curriculumManagerPageTest.testCurriculumPlayerURL();
        curriculumManagerPage.focusDriverToLastTab();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.SHARED_WITH_ME_PAGE_PATH));

        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnAssignFolderButton(null);
        assignModal.typeAccessKey(TestData.VALID_PASSWORD);
        assignModal.clickOnSaveButton();
        assignModal.clickOnCloseButton();

        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnCopyFolderToButton(null);
        copyToModal.waitForModal();
        copyToModal.clickMyResourcesDestinationFolder();
        copyToModal.clickOnCopyToSelectedFolderButton();

        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnShareFolderButton();
        Assert.assertTrue(shareFolderModal.isShareFolderModalDisplayed());
        Assert.assertEquals(shareFolderModal.getFolderStatus(), TestData.SHARE_FOLDER_MODAL_FOLDER_SHARED_STATUS);
        shareFolderModal.clickOnCancelButton();

        curriculumManagerPage.clickOnFolder(0);
        Assert.assertEquals(curriculumManagerPage.getCountFolderChilds(), 2);
        WebElement resource0 = curriculumManagerPage.getExpandedFolderChild(0);
        WebElement resource1 = curriculumManagerPage.getFolderLastChild();
        curriculumManagerPage.clickOnFolderResourceInfoIcon(0);
        Assert.assertEquals(curriculumManagerPage.getChildFolderStatus(0), TestData.SHARED_WITH_ME_PAGE_PERMISSION_VIEW_ONLY);

        curriculumManagerPage.clickOnActionsDropdownButton(resource0);
        Assert.assertTrue(curriculumManagerPage.isCopyFolderToButtonDisplayed(resource0));
        Assert.assertTrue(curriculumManagerPage.isAssignFolderButtonDisplayed(resource0));
        Assert.assertTrue(curriculumManagerPage.isPlayFolderButtonDisplayed(resource0));

        curriculumManagerPage.clickOnActionsDropdownButton(resource0);
        curriculumManagerPage.clickOnActionsDropdownButton(resource1);
        Assert.assertTrue(curriculumManagerPage.isCopyFolderToButtonDisplayed(resource1));
        curriculumManagerPage.clickOnActionsDropdownButton(resource1);

        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnRemoveFolderButton(null);
        removeSharedFolderModal.waitForModal();
        removeSharedFolderModal.clickOnContinueButton();
        Assert.assertEquals(curriculumManagerPage.getFoldersNumber(), foldersNumber - 1);
    }
}
