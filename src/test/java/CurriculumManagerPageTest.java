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
    private CreateNewCollectionModal createNewCollectionModal;
    private EditCollectionModal editCollectionModal;
    private EditResourceModal editResourceModal;
    private DiscoverResourcesPage discoverResourcesPage;
    private CollectionBuilderPage collectionBuilderPage;
    private CopyCollectionModal copyCollectionModal;
    private UpgradeMaxCollectionModal upgradeMaxCollectionModal;
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
        createNewCollectionModal = new CreateNewCollectionModal(webDriver);
        upgradeMaxCollectionModal = new UpgradeMaxCollectionModal(webDriver);
        upgradeAssignModal = new UpgradeAssignModal(webDriver);
        upgradeUploadModal = new UpgradeUploadModal(webDriver);
        editCollectionModal = new EditCollectionModal(webDriver);
        editResourceModal = new EditResourceModal(webDriver);
        copyCollectionModal = new CopyCollectionModal(webDriver);
        removeModal = new RemoveModal(webDriver);
        publishResourceModal = new PublishResourceModal(webDriver);
        publishCollectionModal = new PublishCollectionModal(webDriver);
        uploadFileModal = new UploadFileModal(webDriver);
        assignModal = new AssignModal(webDriver);
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

    @Test(description = "Free memeber - Curriculum Manager - lessonp-3270: Access Curriculum Manager Page")
    public void testLessonp_3270() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testAccessCurriculumManagerPageFromHeader(true);
        testAccessCurriculumManagerPageFromSearchPage(true);
        testAccessCurriculumManagerPageFromEditCollectionModal(true);
        testSortByDropdown();
        testListView();
    }

    @Test(description = "All Active Users - Curriculum Manager - lessonp-3283: Access Curriculum Manager Page")
    public void testLessonp_3283() {
        stepTwoPage.createNewAccount(TestData.PRIME_OPTION_TEXT);
        testAccessCurriculumManagerPageFromHeader(true);
        testAccessCurriculumManagerPageFromSearchPage(true);
        testAccessCurriculumManagerPageFromEditCollectionModal(true);
        testSortByDropdown();
        testListView();
    }

    @Test(description = "Free memeber - Curriculum Manager - lessonp-3250: Create Collections")
    public void testLessonp_3250() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testMaxLimitOfCollectionsCreated();
    }

    @Test(description = "All Active Users - Curriculum Manager - lessonp-3259: Create Collections")
    public void testLessonp_3259() {
        stepTwoPage.createNewAccount(TestData.STARTER_OPTION_TEXT);
        testMaxLimitOfCollectionsCreated();
    }

    @Test(description = "Free memeber - Curriculum Manager - lessonp-3251: Upload Resource & My Uploads Folder")
    public void testLessonp_3251() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testUploadResourceUsingTextInput(TestData.FREE_MEMBERSHIP_TEXT);
        testMyUploadsFolderActions(TestData.FREE_MEMBERSHIP_TEXT);
    }

    @Test(description = "Starte membership - Curriculum Manager - lessonp- 3972: Upload Resource & My Uploads Folder")
    public void testLessonp_3972() {
        stepTwoPage.createNewAccount(TestData.STARTER_OPTION_TEXT);
        testUploadResourceUsingTextInput(TestData.STARTER_OPTION_TEXT);
        testMyUploadsFolderActions(TestData.STARTER_OPTION_TEXT);
    }

    @Test(description = "Prime membership - Curriculum Manager - lessonp- 3973: Upload Resource & My Uploads Folder")
    public void testLessonp_3973() {
        stepTwoPage.createNewAccount(TestData.PRIME_OPTION_TEXT);
        testUploadResourceUsingTextInput(TestData.PRIME_OPTION_TEXT);
        testMyUploadsFolderActions(TestData.PRIME_OPTION_TEXT);
    }

    @Test(description = "Pro membership - Curriculum Manager - lessonp- 3974: Upload Resource & My Uploads Folder")
    public void testLessonp_3974() {
        stepTwoPage.createNewAccount(TestData.PRO_OPTION_TEXT);
        testUploadResourceUsingTextInput(TestData.PRO_OPTION_TEXT);
        testMyUploadsFolderActions(TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Free memeber - Curriculum Manager - lessonp-3939: Favorite Resource & My Favorites Folder")
    public void testLessonp_3939() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testFavoriteResources(TestData.FREE_MEMBERSHIP_TEXT);
        testMyFavoritesFolderActions(TestData.FREE_MEMBERSHIP_TEXT);
    }

    @Test(description = "Starter membership - Curriculum Manager - lessonp- 3933: Favorite Resource & My Favorites Folder")
    public void testLessonp_3933() {
        stepTwoPage.createNewAccount(TestData.STARTER_OPTION_TEXT);
        testFavoriteResources(TestData.STARTER_OPTION_TEXT);
        testMyFavoritesFolderActions(TestData.STARTER_OPTION_TEXT);
    }

    @Test(description = "Prime membership - Curriculum Manager - lessonp- 3934: Favorite Resource & My Favorites Folder")
    public void testLessonp_3934() {
        stepTwoPage.createNewAccount(TestData.PRIME_OPTION_TEXT);
        testFavoriteResources(TestData.PRIME_OPTION_TEXT);
        testMyFavoritesFolderActions(TestData.PRIME_OPTION_TEXT);
    }

    @Test(description = "Pro membership - Curriculum Manager - lessonp- 3935: Favorite Resource & My Favorites Folder")
    public void testLessonp_3935() {
        stepTwoPage.createNewAccount(TestData.PRO_OPTION_TEXT);
        testFavoriteResources(TestData.PRO_OPTION_TEXT);
        testMyFavoritesFolderActions(TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Free memeber - Curriculum Manager - lessonp-3254: Collection: Actions Dropdown")
    public void testLessonp_3254() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testCollectionFolderActions(TestData.FREE_MEMBERSHIP_TEXT);
    }

    @Test(description = "Starter membership - Curriculum Manager - lessonp-3869: Collection: Actions Dropdown")
    public void testLessonp_3869() {
        stepTwoPage.createNewAccount(TestData.STARTER_OPTION_TEXT);
        testCollectionFolderActions(TestData.STARTER_OPTION_TEXT);
    }

    @Test(description = "Prime membership - Curriculum Manager - lessonp-3871: Collection: Actions Dropdown")
    public void testLessonp_3871() {
        stepTwoPage.createNewAccount(TestData.PRIME_OPTION_TEXT);
        testCollectionFolderActions(TestData.PRIME_OPTION_TEXT);
    }

    @Test(description = "Pro membership - Curriculum Manager - lessonp-3270: Collection: Actions Dropdown")
    public void testLessonp_3870() {
        stepTwoPage.createNewAccount(TestData.PRO_OPTION_TEXT);
        testCollectionFolderActions(TestData.PRO_OPTION_TEXT);
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
            collectionBuilderPage.clickOnEditCollection();
            Assert.assertTrue(collectionBuilderPage.isSignInPopupLinkDisplayed());
            Assert.assertTrue(collectionBuilderPage.isSignUpPopupLinkDisplayed());
        } else {
            discoverResourcesPage.loadPage();
            testCreateCollectionFromCollectionBuilder();
            collectionBuilderPage.clickOnEditCollection();
            editCollectionModal.waitForModal();
            editCollectionModal.clickOnMyResourceButton();
            Assert.assertEquals(discoverResourcesPage.getPath(), TestData.CURRICULUM_MANAGER_PATH);
        }
    }

    public void testCreateCollectionFromCollectionBuilder() {
        collectionBuilderPage.clickOnDropdown();
        collectionBuilderPage.clickOnCreateNewCollection();
        createNewCollectionModal.waitForModal();
        createNewCollectionModal.typeName(TestData.NEW_COLLECTION_NAME);
        createNewCollectionModal.clickOnCreateCollection();
    }

    public void testCreateCollectionFromCurriculumManager(String collectionName) {
        curriculumManagerPage.clickOnCreateACollectionButton();
        createNewCollectionModal.waitForModal();
        createNewCollectionModal.typeName(collectionName);
        createNewCollectionModal.typeDescription(TestData.NEW_COLLECTION_DESCRIPTION);
        createNewCollectionModal.clickOnCreateCollection();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
        Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.CREATED_MESSAGE));
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertEquals(curriculumManagerPage.getCollectionFolderTitle(), collectionName);
        Assert.assertEquals(curriculumManagerPage.getCollectionFolderStatus(), TestData.PRIVATE_STATUS);
    }

    public void testMaxLimitOfCollectionsCreated() {
        testCreateThreeCollections();
        curriculumManagerPage.clickOnCreateACollectionButton();
        if (upgradeMaxCollectionModal.isModalDisplayed()) {
            testUpgradeModalFromMaxCollectionLimit();
        } else {
            testCreateCollectionFromCurriculumManager(TestData.collectionName[3]);
        }
    }

    public void testCreateThreeCollections() {
        curriculumManagerPage.loadPage();
        for (int i = 0; i <= 2; i++) {
            testCreateCollectionFromCurriculumManager(TestData.collectionName[i]);
        }
    }

    public void testUpgradeModalFromMaxCollectionLimit() {
        upgradeMaxCollectionModal.waitForModal();
        Assert.assertEquals(upgradeMaxCollectionModal.getUpgradeModalText(), TestData.UPGRADE_MODAL_TEXT_FROM_MAX_COLLECTION_LIMIT);
        upgradeMaxCollectionModal.clickOnUpgradeMeButton();
        Assert.assertTrue(lpHomePage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
        stepTwoPage.goBackOnePage();
    }

    private void testDeleteCollection() {
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnDeleteButton();
        removeModal.waitForModal();
        removeModal.clickOnRemoveButton();
        Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.DELETED_MESSAGE));
        curriculumManagerPage.waitForNotificationToDisappear();
    }

    public void testUploadResourceUsingTextInput(String accountPlanText) {
        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnUploadResourceButton();
        if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
            testUpgradeModalFromUploadButton();
        } else {
            testUpload(false);
            curriculumManagerPage.waitForRefreshIconToDisappear();
            Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
            testIsUploadResourceDisplayed();
        }
    }

    public void testUpload(boolean existingCollection) {
        uploadFileModal.waitForModal();
        File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "images" + File.separator + "test-upload-file.png");
        uploadFileModal.uploadUsingTextInput(file.getPath());
        uploadFileModal.selectGrade(TestData.UPLOAD_YOUR_FILE_GRADE);
        uploadFileModal.selectSubject(TestData.UPLOAD_YOUR_FILE_SUBJECT);
        uploadFileModal.selectResourceType(TestData.UPLOAD_YOUR_FILE_RESOURCE_TYPE);
        uploadFileModal.typeDescription(TestData.NEW_COLLECTION_DESCRIPTION);
        if (existingCollection) {
            uploadFileModal.selectCollection();
        }
        uploadFileModal.clickOnUploadButton();
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
        curriculumManagerPage.clickOnDeleteButton();
        removeModal.clickOnRemoveButton();
        Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.DELETED_MESSAGE));
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertFalse(curriculumManagerPage.isUploadResourceDisplayed());
    }

    private void testMyFavoritesFolderActions(String accountPlanText) {
        testPlayResource(accountPlanText);
        testShareButton();
        testAssignResource(accountPlanText, TestData.ASSIGN_RESOURCE_MODAL_TEXT);
        testGoToResource(accountPlanText);
        testRemoveFavoriteResource();
    }

    public void testFavoriteRegularResource(String accountPlanText) {
        discoverResourcesPage.loadSearchPageInListView();
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
        curriculumManagerPage.clickOnPlayButton();
        if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
            testUpgradeModalFromAssignButton(accountPlanText, TestData.UPGRADE_MODAL_TEXT_FROM_PLAY_BUTTON);
            curriculumManagerPage.clickOnMyFavoritesFolder();
        } else {
            testCurriculumPlayerURL();
            Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
        }
    }

    private void testUpgradeModalFromAssignButton(String accountPlanText, String bodyText) {
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

    private void testShareButton() {
        curriculumManagerPage.hoverOverShareButton();
        curriculumManagerPage.isFacebookOptionDisplayed();
        curriculumManagerPage.isTwitterOptionDisplayed();
        curriculumManagerPage.isPinterestOptionDisplayed();
        curriculumManagerPage.isEmailOptionDisplayed();
        curriculumManagerPage.isLinkOptionDisplayed();
    }

    public void testAssignResource(String accountPlanText, String assignBodyText) {
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnAssignButton();
        if (accountPlanText.equals(TestData.PRO_OPTION_TEXT)) {
            assignModal.waitForModal();
            Assert.assertTrue(assignModal.getAssignModalText().contains(assignBodyText));
            assignModal.typeAccessKey(TestData.VALID_PASSWORD);
            assignModal.clickOnSaveButton();
            assignModal.clickOnCopyButton();
            Assert.assertTrue(assignModal.getCopiedLinkPopoverText().contains(TestData.COPIED_POPOVER_TEXT));
            assignModal.clickOnResetAccessKeyLink();
            Assert.assertTrue(assignModal.isAccessKeyFieldDisplayed());
            assignModal.clickOnCloseButton();
            Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
        } else {
            testUpgradeModalFromAssignButton(accountPlanText, TestData.UPGRADE_MODAL_TEXT_FROM_ASSIGN_BUTTON);
        }
    }

    private void testGoToResource(String accountPlanText) {
        if (!accountPlanText.equals(TestData.PRO_OPTION_TEXT)) {
            curriculumManagerPage.clickOnMyFavoritesFolder();
        }
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnGoToResourceButton();
        rrpModal.waitForModal();
        Assert.assertTrue(rrpPage.isTitleDisplayed());
        rrpModal.clickCloseModal();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
    }

    private void testRemoveFavoriteResource() {
        curriculumManagerPage.hoverOverActionsDropdown();
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
            Assert.assertFalse(curriculumManagerPage.isActionsDropdownDisplayed());
        } else {
            testEditResource();
            testPlayResource(accountPlanText);
            testPublishUploadResource();
            testAssignResource(accountPlanText, TestData.ASSIGN_RESOURCE_MODAL_TEXT);
            testRemoveUploadResource(accountPlanText);
        }
    }

    private void testEditResource() {
        curriculumManagerPage.clickOnEditButton();
        editResourceModal.waitForModal();
        editResourceModal.typeTitle(TestData.EDIT_TITLE);
        editResourceModal.clickOnUpdateButton();
        curriculumManagerPage.waitForRefreshIconToDisappear();
        Assert.assertEquals(curriculumManagerPage.getUploadResourceTitle(), TestData.UPLOAD_RESOURCE_EDIT_TITLE);
    }

    private void testPublishUploadResource() {
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnPublishButton();
        publishResourceModal.waitForModal();
        publishResourceModal.typeTitle(TestData.PUBLISH_RESOURCE_TITLE);
        publishResourceModal.clickAgreementOption();
        publishResourceModal.clickOnPublishResourceButton();
        curriculumManagerPage.waitForRefreshIconToDisappear();
        Assert.assertEquals(curriculumManagerPage.getUploadResourceStatus(), TestData.PUBLISHED_RESOURCE_STATUS);
        Assert.assertEquals(curriculumManagerPage.getUploadResourceTitle(), TestData.PUBLISH_RESOURCE_TITLE);
    }

    private void testCollectionFolderActions(String accountPlanText) {
        curriculumManagerPage.loadPage();
        testCreateCollectionFromCurriculumManager(TestData.NEW_COLLECTION_NAME);
        testPlayCollectionWithNoItems();
        testPublishCollectionWithNoItems();
        testAddRequiredInformationToPublishCollection(accountPlanText);
        testPlayCollectionWithItems();
        testPublishCollectionWithItems();
        testAssignResource(accountPlanText, TestData.ASSIGN_COLLECTION_MODAL_TEXT);
        testMaxLimitOfCollectionsCopied();
        testDeleteCollection();
    }

    public void testAddRequiredInformationToPublishCollection(String accountPlanText) {
        testAddRegularResourceToCollection(accountPlanText);
        testAddSharedResourceToCollection();
        testEditCollection();
    }

    public void testAddRegularResourceToCollection(String accountPlanText) {
        discoverResourcesPage.loadSearchPageInListView();
        if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
            discoverResourcesPage.clickSeeReview(false);
        } else {
            discoverResourcesPage.clickSeeFullReview(false);
        }
        testAddToCollectionButton(TestData.ONE_RESOURCES);
    }

    public void testAddSharedResourceToCollection() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(false);
        testAddToCollectionButton(TestData.TWO_RESOURCES);
    }

    private void testAddToCollectionButton(String itemNumber) {
        rrpModal.waitForModal();
        rrpModal.clickOnAddToCollectionDropdown();
        rrpModal.clickCollectionFromAddToCollectionDropdown();
        Assert.assertTrue(rrpModal.getNotificationText().contains(TestData.RESOURCE_ADDED_TO_COLLECTION_MESSAGE));
        curriculumManagerPage.loadPage();
        Assert.assertTrue(curriculumManagerPage.getCollectionFolderItemNumber().contains(itemNumber));
        curriculumManagerPage.clickOnACollectionFolder();
        Assert.assertTrue(curriculumManagerPage.isResourceInCollectionDisplayed());
    }

    private void testEditCollection() {
        curriculumManagerPage.clickOnACollectionFolder();
        curriculumManagerPage.clickOnEditButton();
        editCollectionModal.waitForModal();
        editCollectionModal.typeTitle(TestData.EDIT_TITLE);
        editCollectionModal.selectGrade(TestData.EDIT_COLLECTION_GRADE_HIGHER_ED);
        editCollectionModal.selectSubject(TestData.EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION);
        editCollectionModal.typeDescription(TestData.NEW_COLLECTION_DESCRIPTION);
        editCollectionModal.clickOnCloseButton();
        curriculumManagerPage.waitForRefreshIconToDisappear();
    }

    private void testPlayCollectionWithItems() {
        curriculumManagerPage.hoverOverPlayButton();
        Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.PLAY_COLLECTION_WITH_ITEMS_POPOVER_TEXT);
        curriculumManagerPage.clickOnPlayButton();
        testCurriculumPlayerURL();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
    }

    private void testPlayCollectionWithNoItems() {
        curriculumManagerPage.hoverOverPlayButton();
        Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.PLAY_COLLECTION_WITH_NO_ITEMS_POPOVER_TEXT);
    }

    private void testPublishCollectionWithItems() {
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.hoverOverPublishButton();
        Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.PUBLISH_COLLECTION_WITH_ITEMS_POPOVER_TEXT);
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnPublishButton();
        publishCollectionModal.waitForModal();
        publishCollectionModal.chooseRating();
        publishCollectionModal.chooseAudience();
        publishCollectionModal.typeConcept();
        publishCollectionModal.clickOnPublishCollectionButton();
        publishCollectionModal.clickOnCloseButton();
        curriculumManagerPage.waitForRefreshIconToDisappear();
        Assert.assertEquals(curriculumManagerPage.getCollectionFolderStatus(), TestData.PUBLISHED_STATUS);
    }

    private void testPublishCollectionWithNoItems() {
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.hoverOverPublishButton();
        Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.PUBLISH_COLLECTION_WITH_NO_ITEMS_POPOVER_TEXT);
    }

    private void testMaxLimitOfCollectionsCopied() {
        for (int i = 0; i < 2; i++) {
            testCopyButton();
            testCopyCollection();
        }
        testCopyButton();
        if (!upgradeMaxCollectionModal.isModalDisplayed()) {
            testCopyCollection();
        } else {
            testUpgradeModalFromMaxCollectionLimit();
        }
    }

    private void testCopyButton() {
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnCopyCollectionButton();
    }

    private void testCopyCollection() {
        copyCollectionModal.waitForModal();
        copyCollectionModal.typeName(TestData.COPIED_COLLECTION_NAME);
        copyCollectionModal.clickOnCreateCopyButton();
        Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.CREATED_MESSAGE));
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertEquals(curriculumManagerPage.getCollectionFolderTitle(), TestData.COPIED_COLLECTION_NAME);
    }

    private void testListView() {
        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnShowMoreAndLessButton();
        Assert.assertFalse(curriculumManagerPage.isDateColumnDisplayed());
        Assert.assertFalse(curriculumManagerPage.isStatusColumnDisplayed());
        curriculumManagerPage.clickOnShowMoreAndLessButton();
        Assert.assertTrue(curriculumManagerPage.isStatusColumnDisplayed());
        Assert.assertTrue(curriculumManagerPage.isDateColumnDisplayed());
    }

    private void testSortByDropdown() {
        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnSortByDropdown();
        Assert.assertTrue(curriculumManagerPage.isResourceTitleOptionDisplayed());
        Assert.assertTrue(curriculumManagerPage.isStatusOptionDisplayed());
        Assert.assertTrue(curriculumManagerPage.isDateOptionDisplayed());
        Assert.assertTrue(curriculumManagerPage.isMyOrderOptionDisplayed());
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
        discoverResourcesPage.clickSeePreview(false);
        testFavoriteButton(TestData.SHARED_RESOURCE_STATUS);
    }

    private void testFavoriteFreeSampleResource() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickFreeFullAccessReview(false);
        testFavoriteButton(TestData.FREE_SAMPLE_RESOURCE_STATUS);
    }
}
