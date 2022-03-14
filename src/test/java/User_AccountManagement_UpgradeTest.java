import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class User_AccountManagement_UpgradeTest extends BaseTest {
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private CollectionBuilderPage collectionBuilderPage;
    private User_AccountManagement_StepTwoTest user_AccountManagement_stepTwoTest;
    private MyAccountPage myAccountPage;
    private ManageMembershipPage manageMembershipPage;
    private StepTwoPage stepTwoPage;
    private RrpModal rrpModal;
    private StartYourTenDayFreeTrialWidget startYourTenDayFreeTrialWidget;
    private BrowseBySubjectPage browseBySubjectPage;
    private ArticlesPage articlesPage;
    private TestimonialsPage testimonialsPage;
    private WhatMembersSayWidget whatMembersSayWidget;
    private EditFolderModal editFolderModal;
    private RrpPage rrpPage;
    private CurriculumManagerPage curriculumManagerPage;
    private User_CurriculumManagerPageTest curriculumManagerTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        headerPage = new HeaderPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        manageMembershipPage = new ManageMembershipPage(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        rrpModal = new RrpModal(webDriver);
        startYourTenDayFreeTrialWidget = new StartYourTenDayFreeTrialWidget(webDriver);
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
        articlesPage = new ArticlesPage(webDriver);
        testimonialsPage = new TestimonialsPage(webDriver);
        whatMembersSayWidget = new WhatMembersSayWidget(webDriver);
        editFolderModal = new EditFolderModal(webDriver);
        rrpPage = new RrpPage(webDriver);
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        curriculumManagerTest = new User_CurriculumManagerPageTest();
    }

    @Test(description = "Account management - Upgrade a Free Member - C2434: From <Get Free Access> button on a resource card", groups = {"accountManagement"})
    public void testC2434() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testUpgradeFreeMemberFromGetFreeAccessButton();
    }

    @Test(description = "Account management - Upgrade a Free Member - C2435: From <Upgrade for Full Review> button on the RRP", groups = {"accountManagement"})
    public void testC2435() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testUpgradeFreeMemberFromUpgradeForFullReviewButton();
    }

    @Test(description = "Account management - Upgrade a Free Member - C2436: From uploading a file from Collection Builder, Edit Collection Modal and Curriculum Manager", groups = {"accountManagement"})
    public void testC2436() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testUpgradeFreeMemberFromUploadButtonFromEditCollectionModal();
        testUpgradeFreeMemberFromUploadButtonFromCurriculumManagerPage();
    }

    @Test(description = "Account management - Upgrade a Free Member - C2437: Free members exceeds the allowed number of collections created", groups = {"accountManagement"})
    public void testC2437() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testUpgradeFreeMemberFromExceededNumberOfCollectionsCreated();
    }

    @Test(description = "AAccount management - Upgrade a Free Member - C2439: Free member tries to assign a favorite resource and a collection", groups = {"accountManagement"})
    public void testC2439() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testUpgradeFreeMemberFromAssignResourceButton();
        testUpgradeFreeMemberFromAssignFolderButton();
    }

    @Test(description = "Account management - Upgrade a Free Member - C2442: Free member clicks any of the <Upgrade Me> or <Get Full Access> buttons", groups = {"accountManagement"})
    public void testC2442() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testUpgradeFreeMemberFromUpgradeMeButtons();
        testUpgradeFreeMemberFromGetFullAccessButtons();
    }

    @Test(description = "Account management - Upgrade a Pro membership - C2433: No upgrade possible (Pro $72)", groups = {"accountManagement"})
    public void testC2433() {
        user_AccountManagement_stepTwoTest = new User_AccountManagement_StepTwoTest();
        user_AccountManagement_stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.completeStepTwoPageWith(TestData.PLAN_PRO);

        myAccountPage.loadPage();
        Assert.assertEquals(myAccountPage.getPlan(), TestData.PRO_OPTION_TEXT);
        Assert.assertFalse(myAccountPage.isUpgradeYourPlanButtonDisplayed());
        myAccountPage.clickOnManageMembershipLink();
        Assert.assertEquals(manageMembershipPage.getTitleText(), TestData.MANAGE_MEMBERSHIP_TITLE_MESSAGE);
        //Only PRO available
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(0), TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Account management - Upgrade a Starter membership - C2430: From Search page", groups = {"accountManagement"})
    public void testC2430() {
        user_AccountManagement_stepTwoTest = new User_AccountManagement_StepTwoTest();
        user_AccountManagement_stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.completeStepTwoPageWith(TestData.PLAN_STARTER);

        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnUpgradeMeNowButton();

        Assert.assertEquals(manageMembershipPage.getNumberOfDisplayedOffers(), 2);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(0), TestData.STARTER_OPTION_TEXT);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(1), TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Account management - Upgrade a Starter membership - C2431: From My Account page", groups = {"accountManagement"})
    public void testC2431() {
        user_AccountManagement_stepTwoTest = new User_AccountManagement_StepTwoTest();
        user_AccountManagement_stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.completeStepTwoPageWith(TestData.PLAN_STARTER);

        myAccountPage.loadPage();
        myAccountPage.clickOnUpgradeYourPlanButton();

        Assert.assertEquals(manageMembershipPage.getNumberOfDisplayedOffers(), 2);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(0), TestData.STARTER_OPTION_TEXT);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(1), TestData.PRO_OPTION_TEXT);
    }

    private void testUpgradeFreeMemberFromGetFreeAccessButton() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnGetFreeAccess(true);
        checkStepTwoPageNewTab();
        discoverResourcesPage.clickOnGetFreeAccess(false);
        checkStepTwoPageSameTab();
    }

    private void checkStepTwoPageNewTab() {
        discoverResourcesPage.waitForNewTab();
        discoverResourcesPage.focusDriverToLastTab();
        discoverResourcesPage.waitForLinkToLoad();
        Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
        Assert.assertTrue(stepTwoPage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
        stepTwoPage.closeTab();
    }

    private void checkStepTwoPageSameTab() {
        Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
        Assert.assertTrue(stepTwoPage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
        stepTwoPage.goBackOnePage();
    }

    private void testUpgradeFreeMemberFromUpgradeForFullReviewButton() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeReview(false);
        rrpModal.waitForModal();
        rrpModal.clickOnUpgradeForFullReviewButton(true);
        checkStepTwoPageNewTab();
        rrpModal.clickOnUpgradeForFullReviewButton(false);
        checkStepTwoPageSameTab();
    }

    private void testUpgradeFreeMemberFromUploadButtonFromEditCollectionModal() {
        discoverResourcesPage.loadPage();
        curriculumManagerTest.initTest(webDriver);
        curriculumManagerTest.testCreateCollectionFromCollectionBuilder(TestData.NEW_COLLECTION_NAME);
        collectionBuilderPage.clickOnEditFolderButton(false);
        editFolderModal.waitForModal();
        editFolderModal.clickOnAddItemsDropdown();
        editFolderModal.clickOnFileUploadButton();
        curriculumManagerTest.initTest(webDriver);
        curriculumManagerTest.testUpgradeModalFromUploadButton();
    }

    private void testUpgradeFreeMemberFromUploadButtonFromCurriculumManagerPage() {
        curriculumManagerTest.testUploadResourceFromMyResources(TestData.PLAN_FREEMIUM, false);
    }

    private void testUpgradeFreeMemberFromExceededNumberOfCollectionsCreated() {
        curriculumManagerTest.initTest(webDriver);
        curriculumManagerTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[0]);
    }

    private void testUpgradeFreeMemberFromAssignResourceButton() {
        curriculumManagerTest.initTest(webDriver);
        curriculumManagerTest.testFavoriteRegularResource(TestData.PLAN_FREEMIUM);
        curriculumManagerTest.testAssignResource(TestData.PLAN_FREEMIUM, TestData.ASSIGN_RESOURCE_MODAL_TEXT);
    }

    private void testUpgradeFreeMemberFromAssignFolderButton() {
        curriculumManagerTest.initTest(webDriver);
        curriculumManagerTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[0]);
        curriculumManagerTest.testAddRegularResourceToFolder(TestData.PLAN_FREEMIUM);
        curriculumManagerTest.testAddSharedResourceToFolder();
        curriculumManagerPage.loadPage();
        curriculumManagerTest.testAssignResource(TestData.PLAN_FREEMIUM, TestData.ASSIGN_FOLDER_MODAL_TEXT);
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtons() {
        testUpgradeFromHeader();
        testUpgradeFromMyAccountPage();
        testUpgradeFromRrpPage();
        testUpgradeFromWhatMembersSayWidgetDirectoryPage();
        testUpgradeFromWhatMembersSayWidgetArticlesPage();
        testUpgradeFromWhatMembersSayWidgetTestimonialsPage();
    }

    private void testUpgradeFreeMemberFromGetFullAccessButtons() {
        testUpgradeFromStartYourFreeTrialWidgetDirectoryPage();
        testUpgradeFromStartYourFreeTrialWidgetArticlesPage();
        testUpgradeFromStartYourFreeTrialWidgetTestimonialsPage();
    }

    private void testUpgradeFromHeader() {
        lpHomePage.loadPage();
        headerPage.clickOnUpgradeMeButton(true);
        checkStepTwoPageNewTab();
        headerPage.clickOnUpgradeMeButton(false);
        checkStepTwoPageSameTab();
    }

    private void testUpgradeFromMyAccountPage() {
        myAccountPage.loadPage();
        myAccountPage.clickOnUpgradeMeButton(true);
        checkStepTwoPageNewTab();
        myAccountPage.clickOnUpgradeMeButton(false);
        checkStepTwoPageSameTab();
    }

    private void testUpgradeFromRrpPage() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeReview(true);
        rrpPage.clickOnStartYourFreeTrialUpgradeMeButton(true);
        checkStepTwoPageNewTab();
        rrpPage.clickOnBottomPageUpgradeMeButton(true);
        checkStepTwoPageNewTab();
    }

    private void testUpgradeFromWhatMembersSayWidgetDirectoryPage() {
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        testClickSubscriptionButtonFromWhatMembersSayWidget();
    }

    private void testUpgradeFromWhatMembersSayWidgetArticlesPage() {
        articlesPage.loadPage();
        testClickSubscriptionButtonFromWhatMembersSayWidget();
    }

    private void testUpgradeFromWhatMembersSayWidgetTestimonialsPage() {
        testimonialsPage.loadPage();
        testClickSubscriptionButtonFromWhatMembersSayWidget();
    }

    private void testClickSubscriptionButtonFromWhatMembersSayWidget() {
        whatMembersSayWidget.clickOnSubscriptionButton(true);
        checkStepTwoPageNewTab();
        whatMembersSayWidget.clickOnSubscriptionButton(false);
        checkStepTwoPageSameTab();
    }

    private void testUpgradeFromStartYourFreeTrialWidgetDirectoryPage() {
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        testClickSubscriptionButtonFromStartYourFreeTrialWidget();
    }

    private void testUpgradeFromStartYourFreeTrialWidgetArticlesPage() {
        articlesPage.loadPage();
        testClickSubscriptionButtonFromStartYourFreeTrialWidget();
    }

    private void testUpgradeFromStartYourFreeTrialWidgetTestimonialsPage() {
        testimonialsPage.loadPage();
        testClickSubscriptionButtonFromStartYourFreeTrialWidget();
    }

    private void testClickSubscriptionButtonFromStartYourFreeTrialWidget() {
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(true);
        checkStepTwoPageNewTab();
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(false);
        checkStepTwoPageSameTab();
    }
}