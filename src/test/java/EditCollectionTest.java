import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class EditCollectionTest extends BaseTest {
    private DiscoverResourcesPage discoverResourcesPage;
    private CreateNewFolderModal createNewFolderModal;
    private CurriculumManagerPageTest curriculumManagerTest;
    private CollectionBuilderPage collectionBuilderPage;
    private EditCollectionModal editCollectionModal;
    private CurriculumManagerPage curriculumManagerPage;
    private PublishCollectionModal publishCollectionModal;
    private EditCollectionPage editCollectionPage;
    private RrpModal rrpModal;
    private StepTwoPage stepTwoPage;
    private BrowseBySubjectPage browseBySubjectPage;
    private RrpSearchPageTest rrpSearchPageTest;
    private ReplaceExistingFolderModal replaceExistingFolderModal;

    @BeforeMethod
    public void beforeMethod() {
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        createNewFolderModal = new CreateNewFolderModal(webDriver);
        curriculumManagerTest = new CurriculumManagerPageTest();
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        editCollectionModal = new EditCollectionModal(webDriver);
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        publishCollectionModal = new PublishCollectionModal(webDriver);
        editCollectionPage = new EditCollectionPage(webDriver);
        rrpModal = new RrpModal(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
        rrpSearchPageTest = new RrpSearchPageTest();
        replaceExistingFolderModal = new ReplaceExistingFolderModal(webDriver);
    }

    @Test(description = "Free member - Edit Collection - lessonp-5279: Edit Collection Modal Appearance")
    public void testLessonp_5279() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testEditFolderAppearance(TestData.PLAN_FREEMIUM, false, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Active Users - Edit Collection - lessonp-5280: Edit Collection Modal Appearance")
    public void testLessonp_5280() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testEditFolderAppearance(TestData.PLAN_STARTER, false, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Free member - Edit Collection - lessonp-495: Edit Collection Static Page Appearance")
    public void testLessonp_495() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testEditFolderAppearance(TestData.PLAN_FREEMIUM, true, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Active Users - Edit Collection - lessonp-5169: Edit Collection Static Page Appearance")
    public void testLessonp_5169() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testEditFolderAppearance(TestData.PLAN_STARTER, true, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Active Users - Edit Collection - lessonp-5261: Publish. Republish")
    public void testLessonp_5261() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testPublishFromEditFolder(TestData.PLAN_PRO);
    }

    @Test(description = "Free member - Edit Collection - lessonp-497: Edit Collection Buttons")
    public void testLessonp_497() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testEditFolderButtons(TestData.PLAN_FREEMIUM, TestData.COPIED_FOLDER_NAME);
    }

    @Test(description = "Starter - Edit Collection - lessonp-5272: Edit Collection Buttons")
    public void testLessonp_5272() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testEditFolderButtons(TestData.PLAN_STARTER, TestData.COPIED_FOLDER_NAME);
    }

    @Test(description = "Pro - Edit Collection - lessonp-5640: Edit Collection Buttons")
    public void testLessonp_5640() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testEditFolderButtons(TestData.PLAN_PRO, TestData.COPIED_FOLDER_NAME);
    }

    @Test(description = "Free member - Edit Collection - lessonp-5263: Item Options")
    public void testLessonp_5263() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testItemOptions();
    }

    @Test(description = "Active Users - Edit Collection - lessonp-5264: Item Options")
    public void testLessonp_5264() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testItemOptions();
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    public void testCreateCollectionSearchPage(String folderName) {
        discoverResourcesPage.loadPage();
        curriculumManagerTest.initTest(webDriver);
        curriculumManagerTest.testCreateCollectionFromCollectionBuilder(folderName);
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
            curriculumManagerTest.testAddRegularResourceToFolder(accountPlanText);
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
        Assert.assertEquals(editCollectionModal.getFolderStatus(), TestData.FOLDER_DEFAULT_STATUS);
    }

    public void testPublishFromEditFolder(String accountPlanText) {
        testCreateCollectionSearchPage(TestData.NEW_COLLECTION_NAME);
        collectionBuilderPage.clickOnEditFolder(false);
        Assert.assertEquals(editCollectionModal.getFolderPublishStatusText(), TestData.FOLDER_NOT_PUBLISHED_TEXT);
        if (!accountPlanText.equals(TestData.VALID_EMAIL_CSL_HENRY) && !accountPlanText.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            Assert.assertTrue(editCollectionModal.isWhatIsPublishingLinkDisplayed());
        }
        for (int i = 0; i < 2; i++) {
            testCreateAPage();
        }
        curriculumManagerTest.testEditFolderModalDetailsArea();
        editCollectionModal.waitUntilPublishFolderButtonIsEnabled();
        editCollectionModal.clickOnPublishFolder();
        curriculumManagerTest.testPublishFolderModal(accountPlanText);
        editCollectionModal.isEnabledPublishFolderButtonDisplayed();
        editCollectionModal.typeTitle(TestData.EDIT_TITLE);
        editCollectionModal.clickOnPublishFolder();
        publishCollectionModal.clickOnPublishCollectionButton();
        replaceExistingFolderModal.clickOnPublishNewButton();
        if (!accountPlanText.equals(TestData.VALID_EMAIL_CSL_HENRY) && !accountPlanText.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            publishCollectionModal.clickOnCloseButton();
        } else {
            Assert.assertTrue(editCollectionModal.getAlertNotificationText().contains(TestData.CSL_PUBLISHED_COLLECTION_NOTIFICATION_TEXT));
        }
        editCollectionModal.isEnabledPublishFolderButtonDisplayed();
        editCollectionModal.typeTitle(TestData.EDIT_TITLE);
        editCollectionModal.clickOnPublishFolder();
        publishCollectionModal.clickOnPublishCollectionButton();
        replaceExistingFolderModal.clickOnPublishAndReplaceButton();
        if (!accountPlanText.equals(TestData.VALID_EMAIL_CSL_HENRY) && !accountPlanText.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            publishCollectionModal.clickOnCloseButton();
        } else {
            Assert.assertTrue(editCollectionModal.getAlertNotificationText().contains(TestData.CSL_PUBLISHED_COLLECTION_NOTIFICATION_TEXT));
        }
        editCollectionModal.isEnabledPublishFolderButtonDisplayed();
        editCollectionModal.clickOnCloseButton();
        collectionBuilderPage.clickOnEditFolder(false);
        Assert.assertEquals(editCollectionModal.getFolderPublishStatusText(), (TestData.FOLDER_PUBLISHED_TEXT) + " " + editCollectionPage.getPublishedFolderMonth() + "/" + TestData.getCurrentDateWithTimezone() + "/" + TestData.getCurrentYear() + ".");
        if (!accountPlanText.equals(TestData.VALID_EMAIL_CSL_HENRY) && !accountPlanText.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            Assert.assertTrue(editCollectionModal.isWhatIsPublishingLinkDisplayed());
        }
    }

    public void testEditFolderButtons(String accountPlanText, String copiedFolderName) {
        testCreateCollectionSearchPage(TestData.NEW_COLLECTION_NAME);
        collectionBuilderPage.clickOnEditFolder(true);
        testAddDropdown(accountPlanText);
        testPlayButton();
        testMoreDropdown(accountPlanText, copiedFolderName);
        testNavigateFolderDropdown(copiedFolderName);
    }

    public void testCreateAPage() {
        editCollectionModal.clickOnAddItemsDropdown();
        editCollectionModal.clickOnCreateAPageOption();
        editCollectionModal.typePageTitle(TestData.PAGE_TITLE);
        editCollectionModal.typePageContent(TestData.HEALTH_CATEGORY_MODAL_DEFAULT_TEXT);
        editCollectionModal.clickSaveButton();
        Assert.assertEquals(editCollectionModal.getFolderItemTitle(0), TestData.PAGE_TITLE);
    }

    public void testAddDropdown(String accountPlanText) {
        editCollectionPage.clickOnAddItemsDropdown();
        Assert.assertTrue(editCollectionPage.isAddALinkOptionDisplayed());
        Assert.assertTrue(editCollectionPage.isUploadAFileOptionDisplayed());
        Assert.assertTrue(editCollectionPage.isAddPixabayImageOptionDisplayed());
        Assert.assertTrue(editCollectionPage.isCreateAPageOptionDisplayed());
        Assert.assertTrue(editCollectionPage.isSearchResourcesOptionDisplayed());

        editCollectionPage.clickAddALinkOption();
        editCollectionPage.typeUrl(TestData.COLLECTION_BUILDER_LINK);
        editCollectionPage.waitUntilNameFieldIsDisplayed();
        editCollectionPage.typeUrlName(TestData.PRIVATE_STATUS);
        editCollectionPage.clickAddToFolderButton();
        editCollectionPage.refreshPageAndDismissBrowserAlert();
        Assert.assertEquals(editCollectionPage.getFolderItemTitle(0), TestData.PRIVATE_STATUS);
        Assert.assertEquals(editCollectionModal.getFolderItemsCount(), 1);

        editCollectionPage.clickOnAddItemsDropdown();
        editCollectionPage.clickUploadAFileButton();
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            curriculumManagerTest.testUpgradeModalFromUploadButton();
            Assert.assertEquals(editCollectionModal.getFolderItemsCount(), 1);
        } else {
            curriculumManagerTest.testUpload(true, accountPlanText, false);
            Assert.assertEquals(editCollectionModal.getFolderItemsCount(), 2);
        }
        editCollectionPage.clickOnAddItemsDropdown();
        editCollectionPage.clickOnAddPixabayImageOption();
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
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testNewTabUrl(TestData.PIXABAY_IMAGE_LINK);
        editCollectionModal.clickOnLearnMoreLink();
        rrpSearchPageTest.testNewTabUrl(TestData.LEARN_MORE_LINK);
        editCollectionPage.searchPixabayImage(TestData.PIXABAY_IMAGE_TITLE);
        editCollectionPage.clickPixabaySearchButton();
        editCollectionPage.waitUntilAddSelectedToFolderButtonIsDisplayed();
        for (int i = 0; i <= 10; i++) {
            editCollectionPage.clickOnPixabayImage(i);
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
        editCollectionPage.clickOnAddPixabayImageOption();
        editCollectionPage.searchPixabayImage(TestData.PIXABAY_IMAGE_TITLE);
        editCollectionPage.clickPixabaySearchButton();
        editCollectionPage.clickOnPixabayImage(0);
        editCollectionPage.clickAddSelectedToFolderButton();
        editCollectionPage.refreshPageAndDismissBrowserAlert();
        for (int i = 0; i < 11; i++) {
            Assert.assertEquals(editCollectionPage.getFolderItemTitle(i), TestData.PIXABAY_IMAGE_TITLE);
        }
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(editCollectionModal.getFolderItemsCount(), 12);
        } else {
            Assert.assertEquals(editCollectionModal.getFolderItemsCount(), 13);
        }

        testCreateAPage();
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(editCollectionModal.getFolderItemsCount(), 13);
        } else {
            Assert.assertEquals(editCollectionModal.getFolderItemsCount(), 14);
        }
        editCollectionPage.clickOnAddItemsDropdown();
        editCollectionPage.clickOnSearchResourcesOption();
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.DISCOVER_RESOURCES_PAGE_PATH));
    }

    public void testPlayButton() {
        collectionBuilderPage.clickOnEditFolder(true);
        Assert.assertTrue(editCollectionPage.isPlayOptionDisplayed());
        editCollectionPage.clickPlayOption();
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testNewTabUrl(TestData.CURRICULUM_PLAYER_PATH);
    }

    public void testMoreDropdown(String accountPlanText, String copiedFolderName) {
        editCollectionPage.clickMoreDropdown();
        Assert.assertTrue(editCollectionPage.isAssignOptionDisplayed());
        Assert.assertTrue(editCollectionPage.isCopyToOptionDisplayed());
        editCollectionPage.clickAssignOption();
        if (!accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            curriculumManagerTest.testAssignModal(TestData.ASSIGN_FOLDER_MODAL_TEXT);
        } else {
            curriculumManagerTest.testUpgradeModalFromAssignButton(accountPlanText, TestData.UPGRADE_MODAL_TEXT_FROM_ASSIGN_BUTTON);
        }
        editCollectionPage.clickMoreDropdown();
        editCollectionPage.clickCopyToOption();
        editCollectionPage.typeName(copiedFolderName);
        editCollectionPage.clickMyResourcesDestinationFolder();
        editCollectionPage.clickOnCopyToSelectedFolderButton();
        editCollectionPage.waitUntilCopiedCollectionIsDisplayed();
        Assert.assertEquals(editCollectionPage.getFolderTitle(), copiedFolderName);
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(editCollectionPage.getFolderItemsCount(), 13);
        } else {
            Assert.assertEquals(editCollectionPage.getFolderItemsCount(), 14);
        }
    }

    public void testNavigateFolderDropdown(String folderName) {
        Assert.assertEquals(editCollectionPage.getEditFolderTitle(), folderName);
        Assert.assertTrue(editCollectionPage.isFolderItemsCountDisplayed());
        editCollectionPage.clickNavigateFolderDropdown();
        Assert.assertTrue(editCollectionPage.isCreateNewFolderButtonDisplayed());
        Assert.assertTrue(editCollectionPage.isActiveFolderDisplayed());
        Assert.assertEquals(editCollectionPage.getActiveFolderTitle(), folderName);
        editCollectionPage.clickCreateNewFolderButton();
        createNewFolderModal.waitForModal();
        Assert.assertEquals(createNewFolderModal.getCreateNewFolderModalTitleFromEditCollection(), TestData.CREATE_A_NEW_FOLDER_MODAL_TITLE);
    }

    public void testItemOptions() {
        testCreateCollectionSearchPage(TestData.NEW_COLLECTION_NAME);
        collectionBuilderPage.clickOnEditFolder(false);
        testCreateAPage();

        editCollectionModal.clickEllipsisActions(0);
        Assert.assertTrue(editCollectionModal.isEditPageOptionDisplayed());
        Assert.assertTrue(editCollectionModal.isHideFromPlayerOptionDisplayed());
        Assert.assertTrue(editCollectionModal.isTeacherNoteOptionDisplayed());
        Assert.assertTrue(editCollectionModal.isDeleteOptionDisplayed());

        editCollectionModal.clickEditPageOption();
        editCollectionModal.clearPageTitle();
        editCollectionModal.typePageTitle(TestData.PUBLISHED_STATUS);
        editCollectionModal.clickSaveButton();
        Assert.assertEquals(editCollectionModal.getFolderItemTitle(0), TestData.PUBLISHED_STATUS);

        editCollectionModal.clickEllipsisActions(0);
        editCollectionModal.clickHideFromPlayerOption();
        Assert.assertTrue(editCollectionModal.isHideFromPlayerIconDisplayed());
        editCollectionModal.clickEllipsisActions(0);
        editCollectionModal.clickHideFromPlayerOption();
        Assert.assertFalse(editCollectionModal.isHideFromPlayerIconDisplayed());

        editCollectionModal.clickEllipsisActions(0);
        editCollectionModal.clickTeacherNoteOption();
        editCollectionModal.typeTeacherNote(TestData.LESSON_PLANNING_ARTICLES_PAGE_PATH);
        editCollectionModal.clickSaveNoteButton();
        editCollectionModal.waitUntilNotificationIsDisplayed(TestData.UPDATED_NOTIFICATION_TEXT);
        editCollectionModal.waitForNotificationToDisappear();

        editCollectionModal.clickEllipsisActions(0);
        editCollectionModal.clickDeleteOption();
        editCollectionModal.clickDeleteItemButton();
        Assert.assertEquals(editCollectionModal.getFolderItemsCount(), 0);
    }
}
