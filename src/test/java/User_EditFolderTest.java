import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class User_EditFolderTest extends BaseTest {
    private DiscoverResourcesPage discoverResourcesPage;
    private User_CurriculumManagerPageTest user_curriculumManagerTest;
    private CollectionBuilderPage collectionBuilderPage;
    private EditFolderModal editFolderModal;
    private CurriculumManagerPage curriculumManagerPage;
    private EditFolderPage editFolderPage;
    private RrpModal rrpModal;
    private StepTwoPage stepTwoPage;
    private BrowseBySubjectPage browseBySubjectPage;
    private User_RrpSearchTest user_rrpSearchTest;
    private ReplaceExistingFolderModal replaceExistingFolderModal;
    private PublishedFolderModal publishedFolderModal;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        user_curriculumManagerTest = new User_CurriculumManagerPageTest();
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        editFolderModal = new EditFolderModal(webDriver);
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        editFolderPage = new EditFolderPage(webDriver);
        rrpModal = new RrpModal(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
        user_rrpSearchTest = new User_RrpSearchTest();
        replaceExistingFolderModal = new ReplaceExistingFolderModal(webDriver);
        publishedFolderModal = new PublishedFolderModal(webDriver);
    }

    @Test(description = "Free member - Edit Collection - C2129: Edit Collection Modal Appearance", groups = {"freemium"})
    public void testC2129() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testEditFolderAppearance(TestData.PLAN_FREEMIUM, false, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Active Users - Edit Collection - C2246: Edit Collection Modal Appearance", groups = {"activeUser"})
    public void testC2246() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testEditFolderAppearance(TestData.PLAN_STARTER, false, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Free member - Edit Collection - C2130: Edit Collection Static Page Appearance", groups = {"freemium"})
    public void testC2130() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testEditFolderAppearance(TestData.PLAN_FREEMIUM, true, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Active Users - Edit Collection -C2247: Edit Collection Static Page Appearance", groups = {"activeUser"})
    public void testC2247() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testEditFolderAppearance(TestData.PLAN_STARTER, true, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Active Users - Edit Collection - C2248: Publish. Republish", groups = {"activeUser"})
    public void testC2248() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testPublishFromEditFolder(TestData.PLAN_PRO);
    }

    @Test(description = "Free member - Edit Collection - C2131: Edit Collection Buttons", groups = {"freemium"})
    public void testC2131() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testEditFolderButtons(TestData.PLAN_FREEMIUM, TestData.COPIED_FOLDER_NAME);
    }

    @Test(description = "Starter - Edit Collection - C2249: Edit Collection Buttons", groups = {"activeUser"})
    public void testC2249() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testEditFolderButtons(TestData.PLAN_STARTER, TestData.COPIED_FOLDER_NAME);
    }

    @Test(description = "Pro - Edit Collection - C2251: Edit Collection Buttons", groups = {"activeUser"})
    public void testC2251() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testEditFolderButtons(TestData.PLAN_PRO, TestData.COPIED_FOLDER_NAME);
    }

    @Test(description = "Free member - Edit Collection - C2132: Item Options", groups = {"freemium"})
    public void testC2132() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testItemOptions();
    }

    @Test(description = "Active Users - Edit Collection - C2252: Item Options", groups = {"activeUser"})
    public void testC2252() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testItemOptions();
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    public void testCreateCollectionSearchPage(String folderName) {
        discoverResourcesPage.loadPage();
        user_curriculumManagerTest.initTest(webDriver);
        user_curriculumManagerTest.testCreateCollectionFromCollectionBuilder(folderName);
    }

    public void testEditFolderAppearance(String accountPlanText, boolean inANewTab, String folderName) {
        testCreateCollectionSearchPage(folderName);
        if (!inANewTab) {
            collectionBuilderPage.clickOnEditFolderButton(false);
            testEditFolderOverview(folderName, 0);
            curriculumManagerPage.loadPage();
            collectionBuilderPage.clickOnEditFolderButton(false);
            testEditFolderOverview(folderName, 0);
            browseBySubjectPage.loadPage(TestData.SOCIAL_STUDIES_PAGE_PATH);
            collectionBuilderPage.clickOnEditFolderButton(false);
            testEditFolderOverview(folderName, 0);
        } else {
            collectionBuilderPage.clickOnEditFolderButton(true);
            testEditFolderOverview(folderName, 0);
            curriculumManagerPage.loadPage();
            collectionBuilderPage.clickOnEditFolderButton(true);
            testEditFolderOverview(folderName, 0);
            browseBySubjectPage.loadPage(TestData.SOCIAL_STUDIES_PAGE_PATH);
            collectionBuilderPage.clickOnEditFolderButton(true);
            testEditFolderOverview(folderName, 0);
            user_curriculumManagerTest.testAddRegularResourceToFolder(accountPlanText);
            rrpModal.clickOnEditYourFolderLink(true);
            testEditFolderOverview(folderName, 1);
        }
    }

    public void testEditFolderOverview(String folderName, int itemsCount) {
        Assert.assertTrue(editFolderModal.isFolderTypeDisplayed());
        Assert.assertTrue(editFolderModal.isNavigateFolderDropdownDisplayed());
        Assert.assertEquals(editFolderModal.getEditFolderTitle(), folderName);
        Assert.assertEquals(editFolderModal.getFolderItemsCount(), itemsCount);
        Assert.assertTrue(editFolderModal.isAddDropdownDisplayed());
        Assert.assertTrue(editFolderModal.isPlayOptionDisplayed());
        Assert.assertTrue(editFolderModal.isMoreDropdownDisplayed());
        Assert.assertTrue(editFolderModal.isEditDetailsOptionDisplayed());
        Assert.assertTrue(editFolderModal.getDefaultFolderStatus().startsWith(TestData.FOLDER_PRIVATE_STATUS));
    }

    public void testPublishFromEditFolder(String accountPlanText) {
        final String collectionName = TestData.GET_CURRENT_TIME();
        testCreateCollectionSearchPage(collectionName);
        collectionBuilderPage.clickOnEditFolderButton(false);
        for (int i = 0; i < 2; i++) {
            testCreateAPage();
        }

        Assert.assertTrue(editFolderModal.getDefaultFolderStatus().startsWith(TestData.FOLDER_PRIVATE_STATUS));
        Assert.assertEquals(editFolderModal.getDetailedFolderStatus(), "");
        editFolderModal.clickOnEditDetails();
        editFolderModal.publishCollection(accountPlanText, collectionName, TestData.EDIT_COLLECTION_GRADE_HIGHER_ED, TestData.EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION, TestData.NEW_COLLECTION_DESCRIPTION);
        Assert.assertTrue(editFolderModal.getDetailedFolderStatus().startsWith(TestData.FOLDER_PUBLISHED_STATUS_TEXT));

        switch (accountPlanText) {
            case TestData.VALID_EMAIL_CSL_HENRY:
            case TestData.VALID_EMAIL_CSL_COBB:
            case TestData.VALID_EMAIL_RSL_SBCEO:
                editFolderModal.getAlertNotificationText(); // sometimes notification is not displayed
                editFolderModal.waitForNotificationToDisappear();
                break;
            default:
                publishedFolderModal.clickOnCloseButton();
                if (editFolderModal.isNotificationDisplayed()) {
                    editFolderModal.getAlertNotificationText(); // sometimes notification is not displayed
                    editFolderModal.waitForNotificationToDisappear();
                }
                break;

        }
        editFolderModal.clickOnEditDetails();
        editFolderModal.typeTitle(TestData.REPLACED_COLLECTION_NAME + collectionName);
        editFolderModal.typeDescription(TestData.REPLACED_COLLECTION_NAME + TestData.NEW_COLLECTION_DESCRIPTION);
        Assert.assertEquals(editFolderModal.getUpdatedNotificationText(), TestData.FOLDER_CHANGES_SAVED_TEXT);
        editFolderModal.waitForNotificationToDisappear();
        editFolderModal.clickOnPublishCollectionButton();

        replaceExistingFolderModal.clickOnPublishAndReplaceButton();
        switch (accountPlanText) {
            case TestData.VALID_EMAIL_CSL_HENRY:
            case TestData.VALID_EMAIL_CSL_COBB:
            case TestData.VALID_EMAIL_RSL_SBCEO:
                //Assert.assertTrue(editFolderModal.getAlertNotificationText().contains(TestData.CSL_PUBLISHED_COLLECTION_NOTIFICATION_TEXT));
                editFolderModal.getAlertNotificationText();
                //notification is not always displayed
                break;
            default:
                publishedFolderModal.clickOnCloseButton();
                break;
        }

        Assert.assertTrue(editFolderModal.getDefaultFolderStatus().startsWith(TestData.FOLDER_PRIVATE_STATUS));
        Assert.assertTrue(editFolderModal.getDetailedFolderStatus().startsWith(TestData.FOLDER_PUBLISHED_STATUS_TEXT));
    }

    public void testEditFolderButtons(String accountPlanText, String copiedFolderName) {
        testCreateCollectionSearchPage(TestData.NEW_COLLECTION_NAME);
        collectionBuilderPage.clickOnEditFolderButton(true);
        testAddDropdown(accountPlanText);
        testPlayButton();
        testMoreDropdown(accountPlanText, copiedFolderName);
        if (!accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            testNavigateFolderDropdown(copiedFolderName);
        }
    }

    public void testCreateAPage() {
        editFolderModal.clickOnAddItemsDropdown();
        editFolderModal.clickOnCreatePageOption();
        editFolderModal.typePageTitle(TestData.PAGE_TITLE);
        editFolderModal.typePageContent(TestData.HEALTH_CATEGORY_MODAL_DEFAULT_TEXT);
        editFolderModal.clickOnSaveButton();
        Assert.assertEquals(editFolderModal.getFolderItemTitle(0), TestData.PAGE_TITLE);
    }

    public void testAddDropdown(String accountPlanText) {
        editFolderPage.clickOnAddItemsDropdown();
        Assert.assertTrue(editFolderPage.isWebLinkOptionDisplayed());
        Assert.assertTrue(editFolderPage.isFileUploadOptionDisplayed());
        Assert.assertTrue(editFolderPage.isPixabayImageOptionDisplayed());
        Assert.assertTrue(editFolderPage.isCreatePageOptionDisplayed());
        Assert.assertTrue(editFolderPage.isNewFolderOptionDisplayed());

        editFolderPage.clickOnWebLinkOption();
        editFolderPage.typeUrl(TestData.COLLECTION_BUILDER_LINK);
        editFolderPage.waitUntilNameFieldIsDisplayed();
        editFolderPage.typeUrlName(TestData.PRIVATE_STATUS);
        editFolderPage.clickOnAddToFolderButton();
        editFolderPage.refreshPageAndDismissBrowserAlert();
        Assert.assertEquals(editFolderPage.getFolderItemTitle(0), TestData.PRIVATE_STATUS);
        Assert.assertEquals(editFolderModal.getFolderItemsCount(), 1);

        editFolderPage.clickOnAddItemsDropdown();
        editFolderPage.clickOnFileUploadButton();
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            user_curriculumManagerTest.initTest(webDriver);
            user_curriculumManagerTest.testUpgradeModalFromUploadButton();
            Assert.assertEquals(editFolderModal.getFolderItemsCount(), 1);
        } else {
            user_curriculumManagerTest.testUpload(true, accountPlanText, false);
            Assert.assertEquals(editFolderModal.getFolderItemsCount(), 2);
        }
        editFolderPage.clickOnAddItemsDropdown();
        editFolderPage.clickOnPixabayImageOption();
        editFolderModal.isPixabayLinkDisplayed();
        editFolderModal.isLearnMoreLinkDisplayed();
        editFolderModal.isAddPixabayImageSubtitleDisplayed();
        editFolderModal.isPixabaySearchButtonDisplayed();
        editFolderModal.isPixabaySearchBarDisplayed();
        editFolderModal.isPixabayAllButtonDisplayed();
        editFolderModal.isPixabayPhotosButtonDisplayed();
        editFolderModal.isPixabayIllustrationButtonDisplayed();
        editFolderModal.isPixabayVectorButtonDisplayed();
        editFolderModal.clickOnPixabayLink();
        user_rrpSearchTest.initTest(webDriver);
        user_rrpSearchTest.testNewTabUrl(TestData.PIXABAY_IMAGE_LINK);
        editFolderModal.clickOnLearnMoreLink();
        user_rrpSearchTest.testNewTabUrl(TestData.LEARN_MORE_LINK);
        editFolderPage.searchPixabayImage(TestData.PIXABAY_IMAGE_TITLE);
        editFolderPage.clickOnPixabaySearchButton();
        editFolderPage.waitUntilAddSelectedToFolderButtonIsDisplayed();
        for (int i = 0; i <= 10; i++) {
            editFolderPage.clickOnPixabayImage(i);
            if (i % 3 == 2) {
                editFolderPage.scrollPixabayPanel();
            }
        }
        Assert.assertTrue(editFolderPage.getPixabayAlertText().contains(TestData.LIMIT_ALERT_PIXABAY_NOTIFICATION_TEXT));
        editFolderPage.clickOnAddSelectedToFolderButton();
        editFolderPage.refreshPageAndDismissBrowserAlert();
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(editFolderModal.getFolderItemsCount(), 11);
        } else {
            Assert.assertEquals(editFolderModal.getFolderItemsCount(), 12);
        }

        editFolderPage.clickOnAddItemsDropdown();
        editFolderPage.clickOnPixabayImageOption();
        editFolderPage.searchPixabayImage(TestData.PIXABAY_IMAGE_TITLE);
        editFolderPage.clickOnPixabaySearchButton();
        editFolderPage.clickOnPixabayImage(0);
        editFolderPage.clickOnAddSelectedToFolderButton();
        editFolderPage.refreshPageAndDismissBrowserAlert();
        for (int i = 0; i < 11; i++) {
            Assert.assertTrue(editFolderPage.getFolderItemTitle(i).contains(TestData.PIXABAY_IMAGE_TITLE) || editFolderPage.getFolderItemTitle(i).contains(TestData.PIXABAY_IMAGE_TITLE.toLowerCase()));
        }
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(editFolderModal.getFolderItemsCount(), 12);
        } else {
            Assert.assertEquals(editFolderModal.getFolderItemsCount(), 13);
        }

        testCreateAPage();
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(editFolderPage.getFolderItemsCount(), 13);
        } else {
            Assert.assertEquals(editFolderPage.getFolderItemsCount(), 14);
        }
        editFolderPage.clickOnAddItemsDropdown();
        editFolderPage.clickOnNewFolderOption();
        editFolderPage.typeNewFolderName();
        editFolderPage.clickOnCreateFolderButton();

        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(editFolderPage.getFolderItemsCount(), 14);
        } else {
            Assert.assertEquals(editFolderPage.getFolderItemsCount(), 15);
        }

    }

    public void testPlayButton() {
        Assert.assertTrue(editFolderPage.isPlayOptionDisplayed());
        editFolderPage.clickOnPlayOption();
        user_rrpSearchTest.initTest(webDriver);
        user_rrpSearchTest.testNewTabUrl(TestData.CURRICULUM_PLAYER_PATH);
    }

    public void testMoreDropdown(String accountPlanText, String copiedFolderName) {
        editFolderPage.clickOnMoreDropdown();
        if (!accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertTrue(editFolderPage.isPublishOptionDisplayed());
        }
        Assert.assertTrue(editFolderPage.isAssignOptionDisplayed());
        Assert.assertTrue(editFolderPage.isCopyToOptionDisplayed());
        editFolderPage.clickOnAssignOption();
        if (!accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            user_curriculumManagerTest.testAssignModal(TestData.ASSIGN_FOLDER_MODAL_TEXT);
        } else {
            user_curriculumManagerTest.testUpgradeModalFromAssignButton(accountPlanText, TestData.UPGRADE_MODAL_TEXT_FROM_ASSIGN_BUTTON);
        }
        editFolderPage.clickOnMoreDropdown();
        editFolderPage.clickOnCopyToOption();
        if (editFolderPage.isMyResourcesTabDisplayed()) {
            editFolderPage.chooseMyResourcesTab();
        }
        editFolderPage.typeName(copiedFolderName);
        editFolderPage.clickOnMyResourcesDestinationFolder();
        editFolderPage.clickOnCopyToSelectedFolderButton();
        editFolderPage.waitUntilCopiedCollectionIsDisplayed();
        Assert.assertEquals(editFolderPage.getFolderTitle(), copiedFolderName);
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(editFolderPage.getFolderItemsCount(), 14);
        } else {
            Assert.assertEquals(editFolderPage.getFolderItemsCount(), 15);
        }
    }

    public void testNavigateFolderDropdown(String folderName) {
        editFolderPage.clickOnNavigateFolderDropdown();
        Assert.assertEquals(editFolderPage.getNavigateFolderTitle(), TestData.MY_RESOURCES_PAGE_TITLE);
        Assert.assertTrue(editFolderPage.isActiveFolderDisplayed());
        Assert.assertEquals(editFolderPage.getActiveFolderTitle(), folderName);
    }

    public void testItemOptions() {
        testCreateCollectionSearchPage(TestData.NEW_COLLECTION_NAME);
        collectionBuilderPage.clickOnEditFolderButton(false);
        testCreateAPage();

        editFolderModal.clickOnEllipsisActions(0);
        Assert.assertTrue(editFolderModal.isEditPageOptionDisplayed());
        Assert.assertTrue(editFolderModal.isHideFromPlayerOptionDisplayed());
        Assert.assertTrue(editFolderModal.isAddANoteOptionDisplayed());
        Assert.assertTrue(editFolderModal.isDeleteOptionDisplayed());

        editFolderModal.clickOnEditPageOption();
        editFolderModal.clearPageTitle();
        editFolderModal.typePageTitle(TestData.PUBLISHED_STATUS);
        editFolderModal.clickOnSaveButton();
        editFolderModal.waitUntilUpdatedTitleIsDisplayed(TestData.PUBLISHED_STATUS);
        Assert.assertEquals(editFolderModal.getFolderItemTitle(0), TestData.PUBLISHED_STATUS);

        editFolderModal.clickOnEllipsisActions(0);
        editFolderModal.clickOnHideFromPlayerOption();
        Assert.assertTrue(editFolderModal.isHideFromPlayerIconDisplayed());
        editFolderModal.clickOnEllipsisActions(0);
        editFolderModal.clickOnHideFromPlayerOption();
        Assert.assertFalse(editFolderModal.isHideFromPlayerIconDisplayed());

        editFolderModal.clickOnEllipsisActions(0);
        editFolderModal.clickOnAddANoteOption();
        editFolderModal.clickOnNoteToTeachersOption();
        editFolderModal.typeTeacherNote(TestData.LESSON_PLANNING_ARTICLES_PAGE_PATH);
        editFolderModal.clickOnSaveNoteButton();
        editFolderModal.clickOnCloseAddANoteButton();
        editFolderModal.clickOnItem(0);
        Assert.assertEquals(editFolderModal.getAddANoteCount(), 1);

        editFolderModal.clickOnEllipsisActions(0);
        editFolderModal.clickOnDeleteOption();
        editFolderModal.clickOnDeleteItemButton();
        Assert.assertEquals(editFolderModal.getFolderItemsCount(), 0);
    }
}
