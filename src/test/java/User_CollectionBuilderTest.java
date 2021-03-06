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
    private BecomeALessonPlanetFreeMemberModal becomeALessonPlanetFreeMemberModal;
    private RrpModal rrpModal;
    private RrpPage rrpPage;
    private BrowseBySubjectPage browseBySubjectPage;
    private User_CurriculumManagerPageTest user_curriculumManagerPageTest;
    private CurriculumManagerPage curriculumManagerPage;
    private CreateNewFolderModal createNewFolderModal;
    private EditFolderModal editFolderModal;
    private StepTwoPage stepTwoPage;

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        rrpModal = new RrpModal(webDriver);
        rrpPage = new RrpPage(webDriver);
        deleteCollectionBuilderResourceModal = new DeleteCollectionBuilderResourceModal(webDriver);
        becomeALessonPlanetFreeMemberModal = new BecomeALessonPlanetFreeMemberModal(webDriver);
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
        user_curriculumManagerPageTest = new User_CurriculumManagerPageTest();
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        createNewFolderModal = new CreateNewFolderModal(webDriver);
        editFolderModal = new EditFolderModal(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
    }

    @Test(description = "Visitor: Collection Builder - C2044: Collection Builder Buttons", groups = {"visitor"})
    public void testC2044() {
        testCollectionBuilderButtonsAppearance(TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor: Collection Builder - C2045: Collection Builder Items", groups = {"visitor"})
    public void testC2045() {
        testCollectionBuilderItemsAppearance(TestData.PLAN_VISITOR, 3);
    }

    @Test(description = "Free Member - Collection Builder - C2134: Collection Builder Buttons", groups = {"freemium"})
    public void testC2134() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testCollectionBuilderButtonsAppearance(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Free Member - Collection Builder - C2135: Collection Builder Items", groups = {"freemium"})
    public void testC2135() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testCollectionBuilderItemsAppearance(TestData.PLAN_FREEMIUM, 10);
    }

    @Test(description = "Active User - Collection Builder - Search - C2254: Collection Builder Buttons", groups = {"activeUser"})
    public void testC2254() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testCollectionBuilderButtonsAppearance(TestData.PLAN_STARTER);
    }

    @Test(description = "Active User - Collection Builder - Search - C2255: Collection Builder Items", groups = {"activeUser"})
    public void testC2255() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testCollectionBuilderItemsAppearance(TestData.PLAN_STARTER, 10);
    }

    public void testDragAndDropItem(String accountPlanText) {
        if (accountPlanText.equals(TestData.PLAN_VISITOR) || accountPlanText.equals(TestData.PLAN_FREEMIUM)) {
            List<WebElement> getFreeAccessResources = browseBySubjectPage.getAllFreeAccessButtons();
            browseBySubjectPage.dragAndDrop(getFreeAccessResources.get(0), collectionBuilderPage.getCollectionDroppableZone());
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
//                Assert.assertEquals(collectionBuilderPage.getCollectionBuilderAlertText(), TestData.EXISTING_RESOURCE_COLLECTION_ERROR_TEXT);
                Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 2);
                for (int i = 2; i <= 2; i++) {
                    discoverResourcesPage.dragAndDrop(getFreeAccessResources.get(i), collectionBuilderPage.getCollectionDroppableZone());
                    if (becomeALessonPlanetFreeMemberModal.isModalDisplayed()) {
                        dismissBecomeALessonPlanetFreeMemberModal();
                    }
                }
                Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 3);
                break;
            case TestData.PLAN_STARTER:
            case TestData.PLAN_FREEMIUM:
            case TestData.VALID_EMAIL_RSL_SBCEO:
            case TestData.VALID_EMAIL_CSL_HENRY:
            case TestData.VALID_EMAIL_CSL_COBB:
                List<WebElement> getFullReviewResources = discoverResourcesPage.getAllSeeFullReviewButtons();
                for (int i = 0; i <= 9; i++) {
                    discoverResourcesPage.dragAndDrop(getFullReviewResources.get(i), collectionBuilderPage.getCollectionDroppableZone());
                }

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
        collectionBuilderPage.isViewMyResourcesButtonDisplayed();
        if (accountPlanText.equals(TestData.PLAN_VISITOR)) {
            collectionBuilderPage.clickOnViewMyResourcesButton();
            Assert.assertTrue(collectionBuilderPage.isViewMyResourcesButtonSignInPopupLinkDisplayed());
            Assert.assertTrue(collectionBuilderPage.isViewMyResourcesButtonSignUpPopupLinkDisplayed());
        } else {
            collectionBuilderPage.clickOnViewMyResourcesButton();
            Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
            curriculumManagerPage.goBackOnePage();
        }
    }

    public void testCollectionBuilderButtons(String accountPlanText) {
        collectionBuilderPage.isMyCollectionDropdownDisplayed();
        collectionBuilderPage.isEditFolderButtonDisplayed();
        if (accountPlanText.equals(TestData.PLAN_VISITOR)) {
            collectionBuilderPage.clickOnDropdown();
            testSignInOrJoinNowModal();
            collectionBuilderPage.clickOnEditFolderButton(false);
            testSignInOrJoinNowModal();
        } else {
            user_curriculumManagerPageTest.initTest(webDriver);
            user_curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder(TestData.NEW_COLLECTION_NAME);
            collectionBuilderPage.clickOnEditFolderButton(false);
            editFolderModal.waitForModal();
            editFolderModal.clickOnCloseButton();
        }
    }

    public void testCollectionBuilderItem() {
        String collectionBuilderItemTitle = collectionBuilderPage.getCollectionBuilderItemTitle(0);
        int collectionBuilderItemsNumber = collectionBuilderPage.getCollectionBuilderItemsNumber();
        collectionBuilderPage.clickOnCollectionBuilderItem(0);
        rrpModal.waitForModal();
        Assert.assertEquals(rrpModal.getTitleText(), collectionBuilderItemTitle);
        rrpModal.clickOnRrpModalXButton();
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
        collectionBuilderPage.clickOnCreateNewFolderOption();
        createNewFolderModal.typeName(TestData.NEW_FOLDER_NAME);
        createNewFolderModal.clickOnCreateFolderButton();
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
        if (accountPlan.equals(TestData.PLAN_VISITOR)) {
            Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), itemNumber);
        } else {
            Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), itemNumber + 1);
        }
        testDragAndDropItem(accountPlan);
        if (accountPlan.equals(TestData.PLAN_VISITOR)) {
            dismissBecomeALessonPlanetFreeMemberModal();
        }
        if (accountPlan.equals(TestData.PLAN_VISITOR)) {
            Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), itemNumber);
        } else {
            Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), itemNumber + 2);
        }

        if (!accountPlan.equals(TestData.PLAN_VISITOR)) {
            curriculumManagerPage.loadPage();
            Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), itemNumber + 2);
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
        discoverResourcesPage.clickOnOpenFolder(true);
        Assert.assertTrue(discoverResourcesPage.getPath().contains(TestData.OPEN_FOLDER_PATH));
    }
}
