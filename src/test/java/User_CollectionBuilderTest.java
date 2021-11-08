import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.util.List;

public class User_CollectionBuilderTest extends BaseTest {

    private DiscoverResourcesPage discoverResourcesPage;
    private CollectionBuilderPage collectionBuilderPage;
    private DeleteCollectionBuilderResourceModal deleteCollectionBuilderResourceModal;
    private CollectionBuilderVideoModal collectionBuilderVideoModal;
    private BecomeALessonPlanetFreeMemberModal becomeALessonPlanetFreeMemberModal;
    private RrpModal rrpModal;
    private RrpPage rrpPage;
    private BrowseBySubjectPage browseBySubjectPage;
    private User_CurriculumManagerPageTest user_curriculumManagerPageTest;
    private CurriculumManagerPage curriculumManagerPage;
    private User_AccountManagementTest user_accountManagementTest;
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
        user_curriculumManagerPageTest = new User_CurriculumManagerPageTest();
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        user_accountManagementTest = new User_AccountManagementTest();
        createNewFolderModal = new CreateNewFolderModal(webDriver);
        editCollectionModal = new EditCollectionModal(webDriver);
        upgradeMaxItemsCollectionModal = new UpgradeMaxItemsCollectionModal(webDriver);
        upgradeMaxFolderModal = new UpgradeMaxFolderModal(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
    }

    @Test(description = "Visitor: Collection Builder - lessonp-431: Collection Builder Buttons")
    public void testLessonp_431() {
        testCollectionBuilderButtonsAppearance(TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor: Collection Builder - lessonp-4378: Collection Builder Items")
    public void testLessonp_4378() {
        testCollectionBuilderItemsAppearance(TestData.PLAN_VISITOR, 3);
    }

    @Test(description = "Free Member - Collection Builder - lessonp-548: Collection Builder Buttons")
    public void testLessonp_548() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testCollectionBuilderButtonsAppearance(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Free Member - Collection Builder - lessonp-4381: Collection Builder Items")
    public void testLessonp_4381() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testCollectionBuilderItemsAppearance(TestData.PLAN_FREEMIUM, 10);
    }

    @Test(description = "Active User - Collection Builder - Search - lessonp-4914: Collection Builder Buttons")
    public void testLessonp_4914() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testCollectionBuilderButtonsAppearance(TestData.PLAN_STARTER);
    }

    @Test(description = "Active User - Collection Builder - Search - lessonp-4915: Collection Builder Items")
    public void testLessonp_4915() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testCollectionBuilderItemsAppearance(TestData.PLAN_STARTER, 10);
    }

    public void testDragAndDropItem(String accountPlanText) {
        if (accountPlanText.equals(TestData.PLAN_VISITOR) || accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            List<WebElement> getFreeAccessResources = browseBySubjectPage.getAllFreeAccessButtons();
            browseBySubjectPage.dragAndDrop(getFreeAccessResources.get(0), collectionBuilderPage.getCollectionDroppableZone());
            if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
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
            case TestData.PLAN_VISITOR:
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
            case TestData.PLAN_FREEMIUM:
                List<WebElement> getFreeAccessResources1 = discoverResourcesPage.getAllFreeAccessButtons();
                for (int i = 0; i <= 9; i++) {
                    discoverResourcesPage.dragAndDrop(getFreeAccessResources1.get(i), collectionBuilderPage.getCollectionDroppableZone());
                }
                Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 10);
                discoverResourcesPage.dragAndDrop(getFreeAccessResources1.get(0), collectionBuilderPage.getCollectionDroppableZone());
                user_accountManagementTest.reachAccountManagementPage(webDriver);
                user_accountManagementTest.testUpgradeModalFromMaxItemsInsideCollection(TestData.UPGRADE_MODAL_TEXT_FROM_EXCEEDED_ITEMS_INSIDE_CREATED_FOLDER);
                discoverResourcesPage.goBackOnePage();
                collectionBuilderPage.waitForLoadingIconToDisappear();
                Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 10);
                break;
            case TestData.PLAN_STARTER:
            case TestData.VALID_EMAIL_RSL_SBCEO:
            case TestData.VALID_EMAIL_CSL_HENRY:
            case TestData.VALID_EMAIL_CSL_COBB:
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
        if (accountPlanText.equals(TestData.PLAN_VISITOR)) {
            collectionBuilderPage.clickOnMyResources();
            Assert.assertTrue(collectionBuilderPage.isMyResourcesButtonSignInPopupLinkDisplayed());
            Assert.assertTrue(collectionBuilderPage.isMyResourcesButtonSignUpPopupLinkDisplayed());
        } else {
            collectionBuilderPage.clickOnMyResources();
            Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
            curriculumManagerPage.goBackOnePage();
        }
    }

    public void testCollectionBuilderButtons(String accountPlanText) {
        collectionBuilderPage.isMyCollectionDropdownDisplayed();
        collectionBuilderPage.isEditFolderButtonDisplayed();
        if (accountPlanText.equals(TestData.PLAN_VISITOR)) {
            collectionBuilderPage.isCollectionVideoBannerDisplayed();
            collectionBuilderPage.clickOnDropdown();
            testSignInOrJoinNowModal();
            collectionBuilderPage.clickOnEditFolder(false);
            testSignInOrJoinNowModal();
            collectionBuilderPage.clickOnCollectionBuilderVideoBanner();
            collectionBuilderVideoModal.waitForModal();
            collectionBuilderVideoModal.clickOnXButton();
        } else {
            user_curriculumManagerPageTest.initTest(webDriver);
            user_curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder(TestData.NEW_COLLECTION_NAME);
            collectionBuilderPage.clickOnEditFolder(false);
            editCollectionModal.waitForModal();
            editCollectionModal.clickOnCloseButton();
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
        if (accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            upgradeMaxFolderModal.waitForModal();
            upgradeMaxFolderModal.clickOnCloseButton();
        } else {
            createNewFolderModal.typeName(TestData.NEW_FOLDER_NAME);
            createNewFolderModal.clickOnCreateFolderButton();
        }
    }

    public void testCollectionBuilderButtonsAppearance(String accountPlan) {
        discoverResourcesPage.loadPage();
        testCollectionBuilderButtons(accountPlan);
        testMyResourcesButton(accountPlan);
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        testCollectionBuilderButtons(accountPlan);
        testMyResourcesButton(accountPlan);
        if (!accountPlan.equals(TestData.PLAN_VISITOR)) {
            curriculumManagerPage.loadPage();
            testCollectionBuilderButtons(accountPlan);
            testMaxCollectionCreated(accountPlan);
        }
        discoverResourcesPage.loadSearchPageInListView();
        if (accountPlan.equals(TestData.VALID_EMAIL_CSL_HENRY) || accountPlan.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            discoverResourcesPage.expandProvidersFacet();
            goToFolderNavigator(TestData.FACET_PROVIDERS_MCGRAW_HILL_EDUCATION, TestData.FACET_CATEGORY_RESOURCES_TYPE_UNIT_MODULES);
            testCollectionBuilderButtons(TestData.VALID_EMAIL_CSL_HENRY);
            testMaxCollectionCreated(TestData.VALID_EMAIL_CSL_HENRY);
            testMyResourcesButton(accountPlan);
        }
    }

    public void testCollectionBuilderItemsAppearance(String accountPlan, int itemNumber) {
        discoverResourcesPage.loadSearchPageInListView();
        if (!accountPlan.equals(TestData.PLAN_VISITOR)) {
            user_curriculumManagerPageTest.initTest(webDriver);
            user_curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder(TestData.NEW_FOLDER_NAME);
        }
        if (!accountPlan.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            discoverResourcesPage.expandProvidersFacet();
            discoverResourcesPage.checkLessonPlanetProvider();
        }
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);
        testDragAndDropMaxItemsInsideCollection(accountPlan);
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        if (accountPlan.equals(TestData.PLAN_VISITOR) || accountPlan.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), itemNumber);
        } else {
            Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), itemNumber + 1);
        }
        testDragAndDropItem(accountPlan);
        if (accountPlan.equals(TestData.PLAN_VISITOR)) {
            dismissBecomeALessonPlanetFreeMemberModal();
        }
        if (accountPlan.equals(TestData.PLAN_VISITOR) || accountPlan.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), itemNumber);
        } else {
            Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), itemNumber + 2);
        }

        if (!accountPlan.equals(TestData.PLAN_VISITOR)) {
            curriculumManagerPage.loadPage();
            if (accountPlan.equals(TestData.PLAN_FREEMIUM)) {
                Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), itemNumber);
            } else {
                Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), itemNumber + 2);
            }
        }
        testCollectionBuilderItem();

        if (accountPlan.equals(TestData.VALID_EMAIL_CSL_HENRY) || accountPlan.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            goToFolderNavigator(TestData.FACET_PROVIDERS_MCGRAW_HILL_EDUCATION, TestData.FACET_CATEGORY_RESOURCES_TYPE_UNIT_MODULES);
            Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), itemNumber + 1);
            testCollectionBuilderItem();
        }
    }

    public void goToFolderNavigator(String provider, String folderType) {
        discoverResourcesPage.loadPage();
        discoverResourcesPage.expandProviderFacetIfCollapsed();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_PROVIDERS, provider);
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, folderType);
        discoverResourcesPage.clickOpenFolder(true);
        Assert.assertTrue(discoverResourcesPage.getPath().contains(TestData.OPEN_FOLDER_PATH));
    }
}