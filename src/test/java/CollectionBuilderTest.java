import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.util.List;

public class CollectionBuilderTest extends BaseTest {

    private DiscoverResourcesPage discoverResourcesPage;
    private CollectionBuilderPage collectionBuilderPage;
    private DeleteCollectionBuilderResourceModal deleteCollectionBuilderResourceModal;
    private CollectionBuilderVideoModal collectionBuilderVideoModal;
    private BecomeALessonPlanetFreeMemberModal becomeALessonPlanetFreeMemberModal;
    private RrpModal rrpModal;
    private RrpPage rrpPage;
    private BrowseBySubjectPage browseBySubjectPage;
    private CurriculumManagerPageTest curriculumManagerPageTest;
    private CurriculumManagerPage curriculumManagerPage;
    private AccountManagementTest accountManagementTest;
    private CreateNewFolderModal createNewFolderModal;
    private EditCollectionModal editCollectionModal;
    private UpgradeMaxItemsCollectionModal upgradeMaxItemsCollectionModal;
    private UpgradeMaxFolderModal upgradeMaxFolderModal;
    private StepTwoPage stepTwoPage;

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @BeforeMethod
    public void beforeMethod() {
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        rrpModal = new RrpModal(webDriver);
        rrpPage = new RrpPage(webDriver);
        deleteCollectionBuilderResourceModal = new DeleteCollectionBuilderResourceModal(webDriver);
        collectionBuilderVideoModal = new CollectionBuilderVideoModal(webDriver);
        becomeALessonPlanetFreeMemberModal = new BecomeALessonPlanetFreeMemberModal(webDriver);
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
        curriculumManagerPageTest = new CurriculumManagerPageTest();
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        accountManagementTest = new AccountManagementTest();
        createNewFolderModal = new CreateNewFolderModal(webDriver);
        editCollectionModal = new EditCollectionModal(webDriver);
        upgradeMaxItemsCollectionModal = new UpgradeMaxItemsCollectionModal(webDriver);
        upgradeMaxFolderModal = new UpgradeMaxFolderModal(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
    }

    @Test(description = "Visitor: Collection Builder - lessonp-431: Collection Builder Buttons")
    public void testLessonp_431() {
        discoverResourcesPage.loadPage();
        testMyResourcesButton(TestData.INVALID_EMAIL);
        testCollectionBuilderButtons(TestData.INVALID_EMAIL);
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        testCollectionBuilderButtons(TestData.INVALID_EMAIL);
        testMyResourcesButton(TestData.INVALID_EMAIL);
    }

    @Test(description = "Visitor: Collection Builder - lessonp-4378: Collection Builder Items")
    public void testLessonp_4378() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);
        testDragAndDropMaxItemsInsideCollection(TestData.INVALID_EMAIL);
        discoverResourcesPage.refreshPageAndDismissBrowserAlert();
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 3);
        testDragAndDropItem(TestData.INVALID_EMAIL);
        dismissBecomeALessonPlanetFreeMemberModal();
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 3);
        testCollectionBuilderItem();
    }

    @Test(description = "Freemium - Collection Builder - lessonp-548: Collection Builder Buttons")
    public void testLessonp_548() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        discoverResourcesPage.loadPage();
        testMyResourcesButton(TestData.FREE_MEMBERSHIP_TEXT);
        testCollectionBuilderButtons(TestData.FREE_MEMBERSHIP_TEXT);
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        testMyResourcesButton(TestData.FREE_MEMBERSHIP_TEXT);
        testCollectionBuilderButtons(TestData.FREE_MEMBERSHIP_TEXT);
        curriculumManagerPage.loadPage();
        testCollectionBuilderButtons(TestData.FREE_MEMBERSHIP_TEXT);
        testMaxCollectionCreated(TestData.FREE_MEMBERSHIP_TEXT);
    }

    @Test(description = "Freemium - Collection Builder - lessonp-4381: Collection Builder Items")
    public void testLessonp_4381() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);
        curriculumManagerPageTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder();
        testDragAndDropMaxItemsInsideCollection(TestData.FREE_MEMBERSHIP_TEXT);
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 10);
        testDragAndDropItem(TestData.FREE_MEMBERSHIP_TEXT);
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 10);
        curriculumManagerPage.loadPage();
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 10);
        testCollectionBuilderItem();
    }

    @Test(description = "Active User - Collection Builder - Search - lessonp-4914: Collection Builder Buttons")
    public void testLessonp_4914() {
        stepTwoPage.createNewAccount(TestData.STARTER_OPTION_TEXT);
        discoverResourcesPage.loadPage();
        testMyResourcesButton(TestData.STARTER_OPTION_TEXT);
        testCollectionBuilderButtons(TestData.STARTER_OPTION_TEXT);
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        testMyResourcesButton(TestData.STARTER_OPTION_TEXT);
        testCollectionBuilderButtons(TestData.STARTER_OPTION_TEXT);
        curriculumManagerPage.loadPage();
        testCollectionBuilderButtons(TestData.STARTER_OPTION_TEXT);
        testMaxCollectionCreated(TestData.STARTER_OPTION_TEXT);
    }

    @Test(description = "Active User - Collection Builder - Search - lessonp-4915: Collection Builder Items")
    public void testLessonp_4915() {
        stepTwoPage.createNewAccount(TestData.STARTER_OPTION_TEXT);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);
        curriculumManagerPageTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder();
        testDragAndDropMaxItemsInsideCollection(TestData.STARTER_OPTION_TEXT);
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 11);
        testDragAndDropItem(TestData.STARTER_OPTION_TEXT);
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 12);
        curriculumManagerPage.loadPage();
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 12);
        testCollectionBuilderItem();
    }

    public void testDragAndDropItem(String accountPlanText) {
        if (accountPlanText.equals(TestData.INVALID_EMAIL) || accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
            List<WebElement> getFreeAccessResources = browseBySubjectPage.getAllFreeAccessButtons();
            browseBySubjectPage.dragAndDrop(getFreeAccessResources.get(0), collectionBuilderPage.getCollectionDroppableZone());
            if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
                upgradeMaxItemsCollectionModal.waitForModal();
                upgradeMaxItemsCollectionModal.clickOnCloseModalButton();
            }
        } else {
            List<WebElement> getFullReviewResources = discoverResourcesPage.getAllSeeFullReviewButtons();
            discoverResourcesPage.dragAndDrop(getFullReviewResources.get(0), collectionBuilderPage.getCollectionDroppableZone());
        }
    }

    public void testDragAndDropMaxItemsInsideCollection(String accountPlanText) {
        switch (accountPlanText) {
            case TestData.INVALID_EMAIL:
                List<WebElement> getFreeAccessResources = discoverResourcesPage.getAllFreeAccessButtons();
                discoverResourcesPage.dragAndDrop(getFreeAccessResources.get(0), collectionBuilderPage.getCollectionDroppableZone());
                dismissBecomeALessonPlanetFreeMemberModal();
                discoverResourcesPage.dragAndDrop(getFreeAccessResources.get(0), collectionBuilderPage.getCollectionDroppableZone());
                Assert.assertEquals(collectionBuilderPage.getCollectionBuilderAlertText(), TestData.EXISTING_RESOURCE_COLLECTION_ERROR_TEXT);
                Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 1);
                for (int i = 1; i <= 2; i++) {
                    discoverResourcesPage.dragAndDrop(getFreeAccessResources.get(i), collectionBuilderPage.getCollectionDroppableZone());
                    if (becomeALessonPlanetFreeMemberModal.isModalDisplayed()) {
                        dismissBecomeALessonPlanetFreeMemberModal();
                    }
                }
                collectionBuilderPage.waitForLoadingIconToDisappear();
                Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 3);
                break;
            case TestData.FREE_MEMBERSHIP_TEXT:
                List<WebElement> getFreeAccessResources1 = discoverResourcesPage.getAllFreeAccessButtons();
                for (int i = 0; i <= 9; i++) {
                    discoverResourcesPage.dragAndDrop(getFreeAccessResources1.get(i), collectionBuilderPage.getCollectionDroppableZone());
                }
                Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 10);
                discoverResourcesPage.dragAndDrop(getFreeAccessResources1.get(0), collectionBuilderPage.getCollectionDroppableZone());
                accountManagementTest.reachAccountManagementPage(webDriver);
                accountManagementTest.testUpgradeModalFromMaxItemsInsideCollection(TestData.UPGRADE_MODAL_TEXT_FROM_EXCEEDED_ITEMS_INSIDE_CREATED_COLLECTION);
                discoverResourcesPage.goBackOnePage();
                collectionBuilderPage.waitForLoadingIconToDisappear();
                Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 10);
                break;
            case TestData.STARTER_OPTION_TEXT:
            case TestData.VALID_EMAIL_RSL_SBCEO:
                List<WebElement> getFullReviewResources = discoverResourcesPage.getAllSeeFullReviewButtons();
                for (int i = 0; i <= 9; i++) {
                    discoverResourcesPage.dragAndDrop(getFullReviewResources.get(i), collectionBuilderPage.getCollectionDroppableZone());
                }
                collectionBuilderPage.waitForLoadingIconToDisappear();
                Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 10);
                discoverResourcesPage.dragAndDrop(getFullReviewResources.get(0), collectionBuilderPage.getCollectionDroppableZone());
                Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 11);
                break;
        }
    }

    public void dismissBecomeALessonPlanetFreeMemberModal() {
        becomeALessonPlanetFreeMemberModal.waitForModal();
        becomeALessonPlanetFreeMemberModal.clickOnCloseModalButton();
    }

    public void testMyResourcesButton(String accountPlanText) {
        collectionBuilderPage.isMyResourcesButtonDisplayed();
        if (accountPlanText.equals(TestData.INVALID_EMAIL)) {
            collectionBuilderPage.clickOnMyResources();
            testSignInOrJoinNowModal();
        } else {
            collectionBuilderPage.clickOnMyResources();
            Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
            curriculumManagerPage.goBackOnePage();
        }
    }

    public void testCollectionBuilderButtons(String accountPlanText) {
        collectionBuilderPage.isMyCollectionDropdownDisplayed();
        collectionBuilderPage.isEditFolderButtonDisplayed();
        collectionBuilderPage.isUploadButtonDisplayed();
        collectionBuilderPage.isAddALinkButtonDisplayed();
        if (accountPlanText.equals(TestData.INVALID_EMAIL)) {
            collectionBuilderPage.isCollectionVideoBannerDisplayed();
            collectionBuilderPage.clickOnDropdown();
            testSignInOrJoinNowModal();
            collectionBuilderPage.clickOnEditFolder(false);
            testSignInOrJoinNowModal();
            collectionBuilderPage.clickUploadButton();
            testSignInOrJoinNowModal();
            collectionBuilderPage.clickAddALinkButton();
            testSignInOrJoinNowModal();
            collectionBuilderPage.clickOnCollectionBuilderVideoBanner();
            collectionBuilderVideoModal.waitForModal();
            collectionBuilderVideoModal.clickOnXButton();
        } else {
            curriculumManagerPageTest.reachCurriculumManagerPage(webDriver);
            curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder();
            collectionBuilderPage.clickOnEditFolder(false);
            editCollectionModal.waitForModal();
            editCollectionModal.clickOnCloseButton();
            testAddLink();
            Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 1);
            collectionBuilderPage.clickUploadButton();
            curriculumManagerPageTest.reachCurriculumManagerPage(webDriver);
            if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
                curriculumManagerPageTest.testUpgradeModalFromUploadButton();
                Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 1);
            } else {
                curriculumManagerPageTest.testUpload(false, accountPlanText);
                Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 2);
            }
        }
    }

    public void testCollectionBuilderItem() {
        String collectionBuilderItemTitle = collectionBuilderPage.getCollectionBuilderItemTitle(0);
        int collectionBuilderItemsNumber = collectionBuilderPage.getCollectionBuilderItemsNumber();
        collectionBuilderPage.clickOnCollectionBuilderItem(0);
        rrpModal.waitForModal();
        Assert.assertEquals(rrpModal.getTitleText(), collectionBuilderItemTitle);
        rrpModal.clickCloseModal();
        collectionBuilderPage.openResourceInANewTab(0);
        browseBySubjectPage.waitForNewTab();
        browseBySubjectPage.focusDriverToLastTab();
        browseBySubjectPage.waitForLinkToLoad();
        Assert.assertEquals(rrpPage.getTitleText(), collectionBuilderItemTitle);
        browseBySubjectPage.closeTab();
        browseBySubjectPage.waitForPageLoad();
        collectionBuilderPage.hoverOverCollectionBuilderItem(0);
        collectionBuilderPage.clickOnXButton(0);
        deleteCollectionBuilderResourceModal.waitForModal();
        deleteCollectionBuilderResourceModal.clickOnDeleteResourceButton();
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), collectionBuilderItemsNumber - 1);
    }

    private void testSignInOrJoinNowModal() {
        Assert.assertTrue(collectionBuilderPage.isSignInPopupLinkDisplayed());
        Assert.assertTrue(collectionBuilderPage.isSignUpPopupLinkDisplayed());
    }

    public void testMaxCollectionCreated(String accountPlanText) {
        discoverResourcesPage.loadPage();
        collectionBuilderPage.clickOnDropdown();
        collectionBuilderPage.clickOnCreateNewCollection();
        if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
            upgradeMaxFolderModal.waitForModal();
            upgradeMaxFolderModal.clickOnCloseButton();
        } else {
            createNewFolderModal.typeName(TestData.NEW_FOLDER_NAME);
            createNewFolderModal.clickOnCreateFolderButton();
        }
    }

    public void testAddLink() {
        collectionBuilderPage.clickAddALinkButton();
        collectionBuilderPage.typeUrl(TestData.COLLECTION_BUILDER_LINK);
        collectionBuilderPage.typeName(TestData.NEW_FOLDER_NAME);
        collectionBuilderPage.clickAddToFolderButton();
        collectionBuilderPage.openResourceInANewTab(0);
        Assert.assertEquals(discoverResourcesPage.getUrl(), TestData.COLLECTION_BUILDER_LINK);
        discoverResourcesPage.closeTab();
    }
}
