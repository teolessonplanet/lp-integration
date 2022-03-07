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
    private EditCollectionModal editCollectionModal;
    private CurriculumManagerPage curriculumManagerPage;
    private EditCollectionPage editCollectionPage;
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
        editCollectionModal = new EditCollectionModal(webDriver);
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        editCollectionPage = new EditCollectionPage(webDriver);
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
            collectionBuilderPage.clickOnEditFolder(false);
            testEditFolderOverview(folderName, 0);
            curriculumManagerPage.loadPage();
            collectionBuilderPage.clickOnEditFolder(false);
            testEditFolderOverview(folderName, 0);
            browseBySubjectPage.loadPage(TestData.SOCIAL_STUDIES_PAGE_PATH);
            collectionBuilderPage.clickOnEditFolder(false);
            testEditFolderOverview(folderName, 0);
        } else {
            collectionBuilderPage.clickOnEditFolder(true);
            testEditFolderOverview(folderName, 0);
            curriculumManagerPage.loadPage();
            collectionBuilderPage.clickOnEditFolder(true);
            testEditFolderOverview(folderName, 0);
            browseBySubjectPage.loadPage(TestData.SOCIAL_STUDIES_PAGE_PATH);
            collectionBuilderPage.clickOnEditFolder(true);
            testEditFolderOverview(folderName, 0);
            user_curriculumManagerTest.testAddRegularResourceToFolder(accountPlanText);
            rrpModal.clickEditYourCollectionLink(true);
            testEditFolderOverview(folderName, 1);
        }
    }

    public void testEditFolderOverview(String folderName, int itemsCount) {
        Assert.assertTrue(editCollectionModal.isFolderTypeDisplayed());
        Assert.assertTrue(editCollectionModal.isNavigateFolderDropdownDisplayed());
        Assert.assertEquals(editCollectionModal.getEditFolderTitle(), folderName);
        Assert.assertEquals(editCollectionModal.getFolderItemsCount(), itemsCount);
        Assert.assertTrue(editCollectionModal.isAddDropdownDisplayed());
        Assert.assertTrue(editCollectionModal.isPlayOptionDisplayed());
        Assert.assertTrue(editCollectionModal.isMoreDropdownDisplayed());
        Assert.assertTrue(editCollectionModal.isEditDetailsOptionDisplayed());
        Assert.assertTrue(editCollectionModal.getDefaultFolderStatus().startsWith(TestData.FOLDER_PRIVATE_STATUS));
    }

    public void testPublishFromEditFolder(String accountPlanText) {
        final String collectionName = TestData.GET_CURRENT_TIME();
        testCreateCollectionSearchPage(collectionName);
        collectionBuilderPage.clickOnEditFolder(false);
        for (int i = 0; i < 2; i++) {
            testCreateAPage();
        }

        Assert.assertTrue(editCollectionModal.getDefaultFolderStatus().startsWith(TestData.FOLDER_PRIVATE_STATUS));
        Assert.assertEquals(editCollectionModal.getDetailedFolderStatus(), "");
        editCollectionModal.clickEditDetails();
        editCollectionModal.publishCollection(accountPlanText, collectionName, TestData.EDIT_COLLECTION_GRADE_HIGHER_ED, TestData.EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION, TestData.NEW_COLLECTION_DESCRIPTION);
        Assert.assertTrue(editCollectionModal.getDetailedFolderStatus().startsWith(TestData.FOLDER_PUBLISHED_STATUS_TEXT));

        switch (accountPlanText) {
            case TestData.VALID_EMAIL_CSL_HENRY:
            case TestData.VALID_EMAIL_CSL_COBB:
            case TestData.VALID_EMAIL_RSL_SBCEO:
                editCollectionModal.getAlertNotificationText(); // sometimes notification is not displayed
                editCollectionModal.waitForNotificationToDisappear();
                break;
            default:
                publishedFolderModal.clickOnCloseButton();
                if (editCollectionModal.isNotificationDisplayed()) {
                    editCollectionModal.getAlertNotificationText(); // sometimes notification is not displayed
                    editCollectionModal.waitForNotificationToDisappear();
                }
                break;

        }
        editCollectionModal.clickEditDetails();
        editCollectionModal.typeTitle(TestData.REPLACED_COLLECTION_NAME + collectionName);
        editCollectionModal.typeDescription(TestData.REPLACED_COLLECTION_NAME + TestData.NEW_COLLECTION_DESCRIPTION);
        Assert.assertEquals(editCollectionModal.getUpdatedNotificationText(), TestData.FOLDER_CHANGES_SAVED_TEXT);
        editCollectionModal.waitForNotificationToDisappear();
        editCollectionModal.clickOnPublishCollectionButton();

        replaceExistingFolderModal.clickOnPublishAndReplaceButton();
        switch (accountPlanText) {
            case TestData.VALID_EMAIL_CSL_HENRY:
            case TestData.VALID_EMAIL_CSL_COBB:
            case TestData.VALID_EMAIL_RSL_SBCEO:
                //Assert.assertTrue(editCollectionModal.getAlertNotificationText().contains(TestData.CSL_PUBLISHED_COLLECTION_NOTIFICATION_TEXT));
                editCollectionModal.getAlertNotificationText();
                //notification is not always displayed
                break;
            default:
                publishedFolderModal.clickOnCloseButton();
                break;
        }

        Assert.assertTrue(editCollectionModal.getDefaultFolderStatus().startsWith(TestData.FOLDER_PRIVATE_STATUS));
        Assert.assertTrue(editCollectionModal.getDetailedFolderStatus().startsWith(TestData.FOLDER_PUBLISHED_STATUS_TEXT));
    }

    public void testEditFolderButtons(String accountPlanText, String copiedFolderName) {
        testCreateCollectionSearchPage(TestData.NEW_COLLECTION_NAME);
        collectionBuilderPage.clickOnEditFolder(true);
        testAddDropdown(accountPlanText);
        testPlayButton();
        testMoreDropdown(accountPlanText, copiedFolderName);
        if (!accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            testNavigateFolderDropdown(copiedFolderName);
        }
    }

    public void testCreateAPage() {
        editCollectionModal.clickOnAddItemsDropdown();
        editCollectionModal.clickOnCreatePageOption();
        editCollectionModal.typePageTitle(TestData.PAGE_TITLE);
        editCollectionModal.typePageContent(TestData.HEALTH_CATEGORY_MODAL_DEFAULT_TEXT);
        editCollectionModal.clickSaveButton();
        Assert.assertEquals(editCollectionModal.getFolderItemTitle(0), TestData.PAGE_TITLE);
    }

    public void testAddDropdown(String accountPlanText) {
        editCollectionPage.clickOnAddItemsDropdown();
        Assert.assertTrue(editCollectionPage.isWebLinkOptionDisplayed());
        Assert.assertTrue(editCollectionPage.isFileUploadOptionDisplayed());
        Assert.assertTrue(editCollectionPage.isPixabayImageOptionDisplayed());
        Assert.assertTrue(editCollectionPage.isCreatePageOptionDisplayed());
        Assert.assertTrue(editCollectionPage.isNewFolderOptionDisplayed());

        editCollectionPage.clickWebLinkOption();
        editCollectionPage.typeUrl(TestData.COLLECTION_BUILDER_LINK);
        editCollectionPage.waitUntilNameFieldIsDisplayed();
        editCollectionPage.typeUrlName(TestData.PRIVATE_STATUS);
        editCollectionPage.clickAddToFolderButton();
        editCollectionPage.refreshPageAndDismissBrowserAlert();
        Assert.assertEquals(editCollectionPage.getFolderItemTitle(0), TestData.PRIVATE_STATUS);
        Assert.assertEquals(editCollectionModal.getFolderItemsCount(), 1);

        editCollectionPage.clickOnAddItemsDropdown();
        editCollectionPage.clickFileUploadButton();
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            user_curriculumManagerTest.initTest(webDriver);
            user_curriculumManagerTest.testUpgradeModalFromUploadButton();
            Assert.assertEquals(editCollectionModal.getFolderItemsCount(), 1);
        } else {
            user_curriculumManagerTest.testUpload(true, accountPlanText, false);
            Assert.assertEquals(editCollectionModal.getFolderItemsCount(), 2);
        }
        editCollectionPage.clickOnAddItemsDropdown();
        editCollectionPage.clickOnPixabayImageOption();
        editCollectionModal.isPixabayLinkDisplayed();
        editCollectionModal.isLearnMoreLinkDisplayed();
        editCollectionModal.isAddPixabayImageSubtitleDisplayed();
        editCollectionModal.isPixabaySearchButtonDisplayed();
        editCollectionModal.isPixabaySearchBarDisplayed();
        editCollectionModal.isPixabayAllButtonDisplayed();
        editCollectionModal.isPixabayPhotosButtonDisplayed();
        editCollectionModal.isPixabayIllustrationButtonDisplayed();
        editCollectionModal.isPixabayVectorButtonDisplayed();
        editCollectionModal.clickOnPixabayLink();
        user_rrpSearchTest.initTest(webDriver);
        user_rrpSearchTest.testNewTabUrl(TestData.PIXABAY_IMAGE_LINK);
        editCollectionModal.clickOnLearnMoreLink();
        user_rrpSearchTest.testNewTabUrl(TestData.LEARN_MORE_LINK);
        editCollectionPage.searchPixabayImage(TestData.PIXABAY_IMAGE_TITLE);
        editCollectionPage.clickPixabaySearchButton();
        editCollectionPage.waitUntilAddSelectedToFolderButtonIsDisplayed();
        for (int i = 0; i <= 10; i++) {
            editCollectionPage.clickOnPixabayImage(i);
            if (i % 3 == 2) {
                editCollectionPage.scrollPixabayPanel();
            }
        }
        Assert.assertTrue(editCollectionPage.getPixabayAlertText().contains(TestData.LIMIT_ALERT_PIXABAY_NOTIFICATION_TEXT));
        editCollectionPage.clickAddSelectedToFolderButton();
        editCollectionPage.refreshPageAndDismissBrowserAlert();
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(editCollectionModal.getFolderItemsCount(), 11);
        } else {
            Assert.assertEquals(editCollectionModal.getFolderItemsCount(), 12);
        }

        editCollectionPage.clickOnAddItemsDropdown();
        editCollectionPage.clickOnPixabayImageOption();
        editCollectionPage.searchPixabayImage(TestData.PIXABAY_IMAGE_TITLE);
        editCollectionPage.clickPixabaySearchButton();
        editCollectionPage.clickOnPixabayImage(0);
        editCollectionPage.clickAddSelectedToFolderButton();
        editCollectionPage.refreshPageAndDismissBrowserAlert();
        for (int i = 0; i < 11; i++) {
            Assert.assertTrue(editCollectionPage.getFolderItemTitle(i).contains(TestData.PIXABAY_IMAGE_TITLE) || editCollectionPage.getFolderItemTitle(i).contains(TestData.PIXABAY_IMAGE_TITLE.toLowerCase()));
        }
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(editCollectionModal.getFolderItemsCount(), 12);
        } else {
            Assert.assertEquals(editCollectionModal.getFolderItemsCount(), 13);
        }

        testCreateAPage();
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(editCollectionPage.getFolderItemsCount(), 13);
        } else {
            Assert.assertEquals(editCollectionPage.getFolderItemsCount(), 14);
        }
        editCollectionPage.clickOnAddItemsDropdown();
        editCollectionPage.clickOnNewFolderOption();
        editCollectionPage.typeNewFolderName();
        editCollectionPage.clickOnCreateFolderButton();

        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(editCollectionPage.getFolderItemsCount(), 14);
        } else {
            Assert.assertEquals(editCollectionPage.getFolderItemsCount(), 15);
        }

    }

    public void testPlayButton() {
        Assert.assertTrue(editCollectionPage.isPlayOptionDisplayed());
        editCollectionPage.clickPlayOption();
        user_rrpSearchTest.initTest(webDriver);
        user_rrpSearchTest.testNewTabUrl(TestData.CURRICULUM_PLAYER_PATH);
    }

    public void testMoreDropdown(String accountPlanText, String copiedFolderName) {
        editCollectionPage.clickMoreDropdown();
        if (!accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertTrue(editCollectionPage.isPublishOptionDisplayed());
        }
        Assert.assertTrue(editCollectionPage.isAssignOptionDisplayed());
        Assert.assertTrue(editCollectionPage.isCopyToOptionDisplayed());
        editCollectionPage.clickAssignOption();
        if (!accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            user_curriculumManagerTest.testAssignModal(TestData.ASSIGN_FOLDER_MODAL_TEXT);
        } else {
            user_curriculumManagerTest.testUpgradeModalFromAssignButton(accountPlanText, TestData.UPGRADE_MODAL_TEXT_FROM_ASSIGN_BUTTON);
        }
        editCollectionPage.clickMoreDropdown();
        editCollectionPage.clickCopyToOption();
        if (editCollectionPage.isMyResourcesTabDisplayed()) {
            editCollectionPage.chooseMyResourcesTab();
        }
        editCollectionPage.typeName(copiedFolderName);
        editCollectionPage.clickMyResourcesDestinationFolder();
        editCollectionPage.clickOnCopyToSelectedFolderButton();
        editCollectionPage.waitUntilCopiedCollectionIsDisplayed();
        Assert.assertEquals(editCollectionPage.getFolderTitle(), copiedFolderName);
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(editCollectionPage.getFolderItemsCount(), 14);
        } else {
            Assert.assertEquals(editCollectionPage.getFolderItemsCount(), 15);
        }
    }

    public void testNavigateFolderDropdown(String folderName) {
        editCollectionPage.clickNavigateFolderDropdown();
        Assert.assertEquals(editCollectionPage.getNavigateFolderTitle(), TestData.MY_RESOURCES_PAGE_TITLE);
        Assert.assertTrue(editCollectionPage.isActiveFolderDisplayed());
        Assert.assertEquals(editCollectionPage.getActiveFolderTitle(), folderName);
    }

    public void testItemOptions() {
        testCreateCollectionSearchPage(TestData.NEW_COLLECTION_NAME);
        collectionBuilderPage.clickOnEditFolder(false);
        testCreateAPage();

        editCollectionModal.clickEllipsisActions(0);
        Assert.assertTrue(editCollectionModal.isEditPageOptionDisplayed());
        Assert.assertTrue(editCollectionModal.isHideFromPlayerOptionDisplayed());
        Assert.assertTrue(editCollectionModal.isAddANoteOptionDisplayed());
        Assert.assertTrue(editCollectionModal.isDeleteOptionDisplayed());

        editCollectionModal.clickEditPageOption();
        editCollectionModal.clearPageTitle();
        editCollectionModal.typePageTitle(TestData.PUBLISHED_STATUS);
        editCollectionModal.clickSaveButton();
        editCollectionModal.waitUntilUpdatedTitleIsDisplayed(TestData.PUBLISHED_STATUS);
        Assert.assertEquals(editCollectionModal.getFolderItemTitle(0), TestData.PUBLISHED_STATUS);

        editCollectionModal.clickEllipsisActions(0);
        editCollectionModal.clickHideFromPlayerOption();
        Assert.assertTrue(editCollectionModal.isHideFromPlayerIconDisplayed());
        editCollectionModal.clickEllipsisActions(0);
        editCollectionModal.clickHideFromPlayerOption();
        Assert.assertFalse(editCollectionModal.isHideFromPlayerIconDisplayed());

        editCollectionModal.clickEllipsisActions(0);
        editCollectionModal.clickAddANoteOption();
        editCollectionModal.clickOnNoteToTeachersOption();
        editCollectionModal.typeTeacherNote(TestData.LESSON_PLANNING_ARTICLES_PAGE_PATH);
        editCollectionModal.clickSaveNoteButton();
        editCollectionModal.clickOnCloseAddANoteButton();
        editCollectionModal.clickOnItem(0);
        Assert.assertEquals(editCollectionModal.getAddANoteCount(), 1);

        editCollectionModal.clickEllipsisActions(0);
        editCollectionModal.clickDeleteOption();
        editCollectionModal.clickDeleteItemButton();
        Assert.assertEquals(editCollectionModal.getFolderItemsCount(), 0);
    }
}
