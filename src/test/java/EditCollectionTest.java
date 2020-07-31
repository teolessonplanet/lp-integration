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
    }

    @Test(description = "Free member - Edit Collection - lessonp-5279: Edit Collection Modal Appearance")
    public void testLessonp_5279() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testEditFolderAppearance(TestData.PLAN_FREEMIUM, false);
    }

    @Test(description = "Active Users - Edit Collection - lessonp-5280: Edit Collection Modal Appearance")
    public void testLessonp_5280() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testEditFolderAppearance(TestData.PLAN_STARTER, false);
    }

    @Test(description = "Free member - Edit Collection - lessonp-495: Edit Collection Static Page Appearance")
    public void testLessonp_495() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testEditFolderAppearance(TestData.PLAN_FREEMIUM, true);
    }

    @Test(description = "Active Users - Edit Collection - lessonp-5169: Edit Collection Static Page Appearance")
    public void testLessonp_5169() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testEditFolderAppearance(TestData.PLAN_STARTER, true);
    }

    @Test(description = "Free member - Edit Collection - lessonp-982: Publish. Republish")
    public void testLessonp_982() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testPublishFromEditFolder(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active Users - Edit Collection - lessonp-5261: Publish. Republish")
    public void testLessonp_5261() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testPublishFromEditFolder(TestData.PLAN_PRO);
    }

    @Test(description = "Free member - Edit Collection - lessonp-497: Edit Collection Buttons")
    public void testLessonp_497() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testEditFolderButtons(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Starter - Edit Collection - lessonp-5272: Edit Collection Buttons")
    public void testLessonp_5272() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testEditFolderButtons(TestData.PLAN_STARTER);
    }

    @Test(description = "Prime - Edit Collection - lessonp-5639: Edit Collection Buttons")
    public void testLessonp_5639() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRIME);
        testEditFolderButtons(TestData.PLAN_PRIME);
    }

    @Test(description = "Pro - Edit Collection - lessonp-5640: Edit Collection Buttons")
    public void testLessonp_5640() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testEditFolderButtons(TestData.PLAN_PRO);
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

    public void testCreateCollectionSearchPage() {
        discoverResourcesPage.loadPage();
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testCreateCollectionFromCollectionBuilder();
    }

    public void testEditFolderAppearance(String accountPlanText, boolean inANewTab) {
        testCreateCollectionSearchPage();
        if (!inANewTab) {
            collectionBuilderPage.clickOnEditFolder(false);
            Assert.assertEquals(editCollectionModal.getEditFolderTitle(), TestData.EDIT_COLLECTION_TITLE);
            curriculumManagerPage.loadPage();
            collectionBuilderPage.clickOnEditFolder(false);
            Assert.assertEquals(editCollectionModal.getEditFolderTitle(), TestData.EDIT_COLLECTION_TITLE);
            browseBySubjectPage.loadPage(TestData.SOCIAL_STUDIES_PAGE_PATH);
            collectionBuilderPage.clickOnEditFolder(false);
            Assert.assertEquals(editCollectionModal.getEditFolderTitle(), TestData.EDIT_COLLECTION_TITLE);
        } else {
            collectionBuilderPage.clickOnEditFolder(true);
            Assert.assertEquals(editCollectionPage.getEditFolderTitle(), TestData.EDIT_COLLECTION_TITLE);
            curriculumManagerPage.loadPage();
            collectionBuilderPage.clickOnEditFolder(true);
            Assert.assertEquals(editCollectionPage.getEditFolderTitle(), TestData.EDIT_COLLECTION_TITLE);
            browseBySubjectPage.loadPage(TestData.SOCIAL_STUDIES_PAGE_PATH);
            collectionBuilderPage.clickOnEditFolder(true);
            Assert.assertEquals(editCollectionPage.getEditFolderTitle(), TestData.EDIT_COLLECTION_TITLE);
            curriculumManagerTest.testAddRegularResourceToFolder(accountPlanText);
            rrpModal.clickEditYourCollectionLink(true);
            Assert.assertEquals(editCollectionPage.getEditFolderTitle(), TestData.EDIT_COLLECTION_TITLE);
        }
    }

    public void testPublishFromEditFolder(String accountPlanText) {
        testCreateCollectionSearchPage();
        collectionBuilderPage.clickOnEditFolder(false);
        for (int i = 0; i < 2; i++) {
            testCreateAPage();
        }
        curriculumManagerTest.testEditFolderModalDetailsArea();
        editCollectionModal.waitUntilPublishFolderButtonIsEnabled();
        editCollectionModal.clickOnPublishFolder();
        curriculumManagerTest.testPublishFolderModal(accountPlanText);
        editCollectionModal.hoverOverDisabledPublishFolderButton();
        Assert.assertTrue(editCollectionModal.getDisabledPublishFolderPopoverText().contains(TestData.DISABLED_REPUBLISH_BUTTON_POPOVER_TEXT));
        editCollectionModal.typeTitle(TestData.EDIT_TITLE);
        editCollectionModal.waitUntilPublishFolderButtonIsEnabled();
        editCollectionModal.clickOnPublishFolder();
        publishCollectionModal.clickOnPublishCollectionButton();
        editCollectionModal.hoverOverDisabledPublishFolderButton();
        Assert.assertTrue(editCollectionModal.getDisabledPublishFolderPopoverText().contains(TestData.DISABLED_REPUBLISH_BUTTON_POPOVER_TEXT));
    }

    public void testEditFolderButtons(String accountPlanText) {
        testCreateCollectionSearchPage();
        collectionBuilderPage.clickOnEditFolder(true);
        testAddItemsDropdown(accountPlanText);
        testCollectionActionsDropdown(accountPlanText);
        testNavigateFolderDropdown();
    }

    public void testCreateAPage() {
        editCollectionModal.clickOnAddItemsDropdown();
        editCollectionModal.clickOnCreateAPageOption();
        editCollectionModal.typePageTitle(TestData.PAGE_TITLE);
        editCollectionModal.typePageContent(TestData.HEALTH_CATEGORY_MODAL_DEFAULT_TEXT);
        editCollectionModal.clickSaveButton();
        editCollectionModal.waitUntilItemIsAddedIntoFolder();
        Assert.assertEquals(editCollectionModal.getFolderItemTitle(0), TestData.PAGE_TITLE);
    }

    public void testAddItemsDropdown(String accountPlanText) {
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
        Assert.assertEquals(editCollectionPage.getFolderItemsCount(), 1);

        editCollectionPage.clickOnAddItemsDropdown();
        editCollectionPage.clickUploadAFileButton();
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            curriculumManagerTest.testUpgradeModalFromUploadButton();
            Assert.assertEquals(editCollectionPage.getFolderItemsCount(), 1);
        } else {
            curriculumManagerTest.testUpload(true, accountPlanText);
            Assert.assertEquals(editCollectionPage.getFolderItemsCount(), 2);
        }
        editCollectionPage.refreshPageAndDismissBrowserAlert();
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
        if(accountPlanText.equals(TestData.PLAN_FREEMIUM)){
            Assert.assertEquals(editCollectionPage.getFolderItemsCount(), 11);
        } else {
            Assert.assertEquals(editCollectionPage.getFolderItemsCount(), 12);
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
        if(accountPlanText.equals(TestData.PLAN_FREEMIUM)){
            Assert.assertEquals(editCollectionPage.getFolderItemsCount(), 12);
        } else {
            Assert.assertEquals(editCollectionPage.getFolderItemsCount(), 13);
        }

        testCreateAPage();
        editCollectionPage.refreshPageAndDismissBrowserAlert();
        if(accountPlanText.equals(TestData.PLAN_FREEMIUM)){
            Assert.assertEquals(editCollectionPage.getFolderItemsCount(), 13);
        } else {
            Assert.assertEquals(editCollectionPage.getFolderItemsCount(), 14);
        }
        editCollectionPage.clickOnAddItemsDropdown();
        editCollectionPage.clickOnSearchResourcesOption();
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.DISCOVER_RESOURCES_PAGE_PATH));
    }

    public void testCollectionActionsDropdown(String accountPlanText) {
        collectionBuilderPage.clickOnEditFolder(true);
        editCollectionPage.clickActionsDropdown();
        Assert.assertTrue(editCollectionPage.isPlayFolderOptionDisplayed());
        Assert.assertTrue(editCollectionPage.isAssignFolderOptionDisplayed());
        Assert.assertTrue(editCollectionPage.isCopyFolderOptionDisplayed());
        editCollectionPage.clickPlayFolderOption();
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testNewTabUrl(TestData.CURRICULUM_PLAYER_PATH);
        editCollectionPage.clickActionsDropdown();
        editCollectionPage.clickAssignFolderOption();
        if (!accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            curriculumManagerTest.testAssignModal(TestData.ASSIGN_FOLDER_MODAL_TEXT);
        } else {
            curriculumManagerTest.testUpgradeModalFromAssignButton(accountPlanText, TestData.UPGRADE_MODAL_TEXT_FROM_ASSIGN_BUTTON);
        }
        editCollectionPage.clickActionsDropdown();
        editCollectionPage.clickCopyFolderOption();
        editCollectionPage.typeName(TestData.COPIED_FOLDER_NAME);
        editCollectionPage.clickMyResourcesDestinationFolder();
        editCollectionPage.clickOnCreateCopyButton();
        Assert.assertEquals(editCollectionPage.getFolderTitle(), TestData.COPIED_FOLDER_NAME);
    }

    public void testNavigateFolderDropdown() {
        editCollectionPage.clickNavigateFolderDropdown();
        Assert.assertTrue(editCollectionPage.isCreateNewFolderButtonDisplayed());
        editCollectionPage.clickCreateNewFolderButton();
        createNewFolderModal.waitForModal();
        Assert.assertEquals(createNewFolderModal.getTitle(), TestData.CREATE_A_NEW_FOLDER_MODAL_TITLE);
    }

    public void testItemOptions() {
        testCreateCollectionSearchPage();
        collectionBuilderPage.clickOnEditFolder(false);
        testCreateAPage();
        int itemsCount = editCollectionModal.getFolderItemsCount();

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
        Assert.assertEquals(editCollectionModal.getFolderItemsCount(), itemsCount);

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
        Assert.assertEquals(editCollectionModal.getFolderItemsCount(), itemsCount - 1);
    }
}
