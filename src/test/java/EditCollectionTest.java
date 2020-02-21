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
    private RRPSearchPageTest rrpSearchPageTest;

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
        rrpSearchPageTest = new RRPSearchPageTest();
    }

    @Test(description = "Free member - Edit Collection - lessonp-5279: Edit Collection Modal Appearance")
    public void testLessonp_5279() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testEditCollectionAppearance(TestData.FREE_MEMBERSHIP_TEXT, false);
    }

    @Test(description = "Active Users - Edit Collection - lessonp-5280: Edit Collection Modal Appearance")
    public void testLessonp_5280() {
        stepTwoPage.createNewAccount(TestData.STARTER_OPTION_TEXT);
        testEditCollectionAppearance(TestData.STARTER_OPTION_TEXT, false);
    }

    @Test(description = "Free member - Edit Collection - lessonp-495: Edit Collection Static Page Appearance")
    public void testLessonp_495() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testEditCollectionAppearance(TestData.FREE_MEMBERSHIP_TEXT, true);
    }

    @Test(description = "Active Users - Edit Collection - lessonp-5169: Edit Collection Static Page Appearance")
    public void testLessonp_5169() {
        stepTwoPage.createNewAccount(TestData.STARTER_OPTION_TEXT);
        testEditCollectionAppearance(TestData.STARTER_OPTION_TEXT, true);
    }

    @Test(description = "Free member - Edit Collection - lessonp-982: Publish. Republish")
    public void testLessonp_982() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testPublishFromEditCollection();
    }

    @Test(description = "Active Users - Edit Collection - lessonp-5261: Publish. Republish")
    public void testLessonp_5261() {
        stepTwoPage.createNewAccount(TestData.PRO_OPTION_TEXT);
        testPublishFromEditCollection();
    }

    @Test(description = "Free member - Edit Collection - lessonp-497: Edit Collection Buttons")
    public void testLessonp_497() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testEditCollectionButtons(TestData.FREE_MEMBERSHIP_TEXT);
    }

    @Test(description = "Starter - Edit Collection - lessonp-5272: Edit Collection Buttons")
    public void testLessonp_5272() {
        stepTwoPage.createNewAccount(TestData.STARTER_OPTION_TEXT);
        testEditCollectionButtons(TestData.STARTER_OPTION_TEXT);
    }

    @Test(description = "Prime - Edit Collection - lessonp-5639: Edit Collection Buttons")
    public void testLessonp_5639() {
        stepTwoPage.createNewAccount(TestData.PRIME_OPTION_TEXT);
        testEditCollectionButtons(TestData.PRIME_OPTION_TEXT);
    }

    @Test(description = "Pro - Edit Collection - lessonp-5640: Edit Collection Buttons")
    public void testLessonp_5640() {
        stepTwoPage.createNewAccount(TestData.PRO_OPTION_TEXT);
        testEditCollectionButtons(TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Free member - Edit Collection - lessonp-5263: Item Options")
    public void testLessonp_5263() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testItemOptions();
    }

    @Test(description = "Active Users - Edit Collection - lessonp-5264: Item Options")
    public void testLessonp_5264() {
        stepTwoPage.createNewAccount(TestData.STARTER_OPTION_TEXT);
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

    public void testEditCollectionAppearance(String accountPlanText, boolean inANewTab) {
        testCreateCollectionSearchPage();
        if (!inANewTab) {
            collectionBuilderPage.clickOnEditCollection(false);
            Assert.assertEquals(editCollectionModal.getEditCollectionTitle(), TestData.EDIT_COLLECTION_TITLE);
            curriculumManagerPage.loadPage();
            collectionBuilderPage.clickOnEditCollection(false);
            Assert.assertEquals(editCollectionModal.getEditCollectionTitle(), TestData.EDIT_COLLECTION_TITLE);
            browseBySubjectPage.loadPage(TestData.SOCIAL_STUDIES_PAGE_PATH);
            collectionBuilderPage.clickOnEditCollection(false);
            Assert.assertEquals(editCollectionModal.getEditCollectionTitle(), TestData.EDIT_COLLECTION_TITLE);
        } else {
            collectionBuilderPage.clickOnEditCollection(true);
            Assert.assertEquals(editCollectionPage.getEditCollectionTitle(), TestData.EDIT_COLLECTION_TITLE);
            curriculumManagerPage.loadPage();
            collectionBuilderPage.clickOnEditCollection(true);
            Assert.assertEquals(editCollectionPage.getEditCollectionTitle(), TestData.EDIT_COLLECTION_TITLE);
            browseBySubjectPage.loadPage(TestData.SOCIAL_STUDIES_PAGE_PATH);
            collectionBuilderPage.clickOnEditCollection(true);
            Assert.assertEquals(editCollectionPage.getEditCollectionTitle(), TestData.EDIT_COLLECTION_TITLE);
            curriculumManagerTest.testAddRegularResourceToCollection(accountPlanText);
            rrpModal.clickEditYourCollectionLink(true);
            Assert.assertEquals(editCollectionPage.getEditCollectionTitle(), TestData.EDIT_COLLECTION_TITLE);
        }
    }

    public void testPublishFromEditCollection() {
        testCreateCollectionSearchPage();
        collectionBuilderPage.clickOnEditCollection(false);
        for (int i = 0; i < 2; i++) {
            testCreateAPage();
        }
        curriculumManagerTest.testEditCollectionModalDetailsArea();
        editCollectionModal.waitUntilPublishCollectionButtonIsEnabled();
        editCollectionModal.clickOnPublishCollection();
        curriculumManagerTest.testPublishCollectionModal();
        editCollectionModal.hoverOverDisabledPublishCollectionButton();
        Assert.assertTrue(editCollectionModal.getDisabledPublishCollectionPopoverText().contains(TestData.DISABLED_REPUBLISH_BUTTON_POPOVER_TEXT));
        editCollectionModal.typeTitle(TestData.EDIT_TITLE);
        editCollectionModal.waitUntilPublishCollectionButtonIsEnabled();
        editCollectionModal.clickOnPublishCollection();
        publishCollectionModal.clickOnPublishCollectionButton();
        editCollectionModal.hoverOverDisabledPublishCollectionButton();
        Assert.assertTrue(editCollectionModal.getDisabledPublishCollectionPopoverText().contains(TestData.DISABLED_REPUBLISH_BUTTON_POPOVER_TEXT));
    }

    public void testEditCollectionButtons(String accountPlanText) {
        testCreateCollectionSearchPage();
        collectionBuilderPage.clickOnEditCollection(true);
        testAddItemsDropdown(accountPlanText);
        testCollectionActionsDropdown(accountPlanText);
        testMyResourcesButton();
        testMyCollectionsDropdown();
    }

    public void testCreateAPage() {
        editCollectionModal.clickOnAddItemsDropdown();
        editCollectionModal.clickOnCreateAPageOption();
        editCollectionModal.typePageTitle(TestData.PAGE_TITLE);
        editCollectionModal.typePageContent(TestData.HEALTH_CATEGORY_MODAL_DEFAULT_TEXT);
        editCollectionModal.clickSaveButton();
        editCollectionModal.waitUntilItemIsAddedIntoCollection();
        Assert.assertEquals(editCollectionModal.getCollectionItemTitle(0), TestData.PAGE_TITLE);
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
        editCollectionPage.clickAddToCollectionButton();
        editCollectionPage.refreshPageAndDismissBrowserAlert();
        Assert.assertEquals(editCollectionPage.getCollectionItemTitle(0), TestData.PRIVATE_STATUS);

        editCollectionPage.clickOnAddItemsDropdown();
        editCollectionPage.clickUploadAFileButton();
        if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
            curriculumManagerTest.testUpgradeModalFromUploadButton();
        } else {
            curriculumManagerTest.testUpload(true, accountPlanText);
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
        editCollectionPage.waitUntilAddSelectedToCollectionButtonIsDisplayed();
        for (int i = 0; i <= 10; i++) {
            editCollectionPage.clickOnPixabayImage(i);
        }
        Assert.assertTrue(editCollectionPage.getPixabayAlertText().contains(TestData.LIMIT_ALERT_PIXABAY_NOTIFICATION_TEXT));
        editCollectionPage.clickAddSelectedToCollectionButton();
        editCollectionPage.waitUntilNotificationIsDisplayed(TestData.IMAGES_ADDED_NOTIFICATION_TEXT);
        editCollectionPage.clickOnAddItemsDropdown();
        editCollectionPage.clickOnAddPixabayImageOption();
        editCollectionPage.searchPixabayImage(TestData.PIXABAY_IMAGE_TITLE);
        editCollectionPage.clickPixabaySearchButton();
        editCollectionPage.clickOnPixabayImage(0);
        editCollectionPage.clickAddSelectedToCollectionButton();
        for (int i = 0; i < 11; i++) {
            Assert.assertEquals(editCollectionPage.getCollectionItemTitle(i), TestData.PIXABAY_IMAGE_TITLE);
        }

        testCreateAPage();

        editCollectionPage.clickOnAddItemsDropdown();
        editCollectionPage.clickOnSearchResourcesOption();
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.DISCOVER_RESOURCES_PAGE_PATH));
    }

    public void testCollectionActionsDropdown(String accountPlanText) {
        collectionBuilderPage.clickOnEditCollection(true);
        editCollectionPage.clickCollectionActionsDropdown();
        Assert.assertTrue(editCollectionPage.isPlayCollectionOptionDisplayed());
        Assert.assertTrue(editCollectionPage.isAssignCollectionOptionDisplayed());
        Assert.assertTrue(editCollectionPage.isCopyCollectionOptionDisplayed());
        editCollectionPage.clickPlayCollectionOption();
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testNewTabUrl(TestData.CURRICULUM_PLAYER_PATH);
        editCollectionPage.clickCollectionActionsDropdown();
        editCollectionPage.clickAssignCollectionOption();
        if (accountPlanText.equals(TestData.PRO_OPTION_TEXT) || accountPlanText.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            curriculumManagerTest.testAssignModal(TestData.ASSIGN_COLLECTION_MODAL_TEXT);
        } else {
            curriculumManagerTest.testUpgradeModalFromAssignButton(accountPlanText, TestData.UPGRADE_MODAL_TEXT_FROM_ASSIGN_BUTTON);
        }
        editCollectionPage.clickCollectionActionsDropdown();
        editCollectionPage.clickCopyCollectionOption();
        editCollectionPage.typeName(TestData.COPIED_FOLDER_NAME);
        editCollectionPage.clickOnCreateCopyButton();
        editCollectionPage.waitUntilNewlyCreatedCollectionIsActive(TestData.COPIED_FOLDER_NAME);
        Assert.assertEquals(editCollectionPage.getActiveCollectionFromMyCollectionHeader(), TestData.COPIED_FOLDER_NAME);
    }

    public void testMyResourcesButton() {
        editCollectionPage.clickOnMyResourcesButton();
        curriculumManagerPage.waitForLoad();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
        curriculumManagerPage.goBackOnePage();
    }

    public void testMyCollectionsDropdown() {
        editCollectionPage.clickMyCollectionDropdown();
        Assert.assertTrue(editCollectionPage.isCreateNewCollectionButtonDisplayed());
        Assert.assertEquals(editCollectionPage.getActiveCollectionFromMyCollectionDropdown(), TestData.COPIED_FOLDER_NAME);
        editCollectionPage.clickCreateNewCollectionButton();
        createNewFolderModal.waitForModal();
        Assert.assertEquals(createNewFolderModal.getTitle(), TestData.CREATE_A_NEW_COLLECTION_TITLE);
    }

    public void testItemOptions() {
        testCreateCollectionSearchPage();
        collectionBuilderPage.clickOnEditCollection(false);
        testCreateAPage();
        int itemsCount = editCollectionModal.getCollectionItemsCount();

        editCollectionModal.clickEllipsisActions(0);
        Assert.assertTrue(editCollectionModal.isEditPageOptionDisplayed());
        Assert.assertTrue(editCollectionModal.isHideFromPlayerOptionDisplayed());
        Assert.assertTrue(editCollectionModal.isTeacherNoteOptionDisplayed());
        Assert.assertTrue(editCollectionModal.isDeleteOptionDisplayed());

        editCollectionModal.clickEditPageOption();
        editCollectionModal.clearPageTitle();
        editCollectionModal.typePageTitle(TestData.PUBLISHED_STATUS);
        editCollectionModal.clickSaveButton();
        Assert.assertEquals(editCollectionModal.getCollectionItemTitle(0), TestData.PUBLISHED_STATUS);
        Assert.assertEquals(editCollectionModal.getCollectionItemsCount(), itemsCount);

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
        Assert.assertEquals(editCollectionModal.getCollectionItemsCount(), itemsCount - 1);
    }
}
