import com.lessonplanet.pages.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import util.TestData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User_AccountManagementTest extends BaseTest {
    private static final int expectedDaysToExpire = 11;
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private StepOneModal stepOneModal;
    private DiscoverResourcesPage discoverResourcesPage;
    private CollectionBuilderPage collectionBuilderPage;
    private BecomeALessonPlanetFreeMemberModal becomeALessonPlanetFreeMemberModal;
    private FreeMemberLimitedAccessModal freeMemberLimitedAccessModal;
    private ThanksForJoiningModal thanksForJoiningModal;
    private User_StepTwoTest user_stepTwoTest;
    private MyAccountPage myAccountPage;
    private CustomMembershipPage customMembershipPage;
    private StepOnePage stepOnePage;
    private ManageMembershipPage manageMembershipPage;
    private StepTwoPage stepTwoPage;
    private CancelModal cancelModal;
    private RrpModal rrpModal;
    private StartYourTenDayFreeTrialWidget startYourTenDayFreeTrialWidget;
    private BrowseBySubjectPage browseBySubjectPage;
    private ArticlesPage articlesPage;
    private TestimonialsPage testimonialsPage;
    private WhatMembersSayWidget whatMembersSayWidget;
    private EditCollectionModal editCollectionModal;
    private RrpPage rrpPage;
    private CurriculumManagerPage curriculumManagerPage;
    private User_CurriculumManagerPageTest curriculumManagerTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        headerPage = new HeaderPage(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        becomeALessonPlanetFreeMemberModal = new BecomeALessonPlanetFreeMemberModal(webDriver);
        freeMemberLimitedAccessModal = new FreeMemberLimitedAccessModal(webDriver);
        thanksForJoiningModal = new ThanksForJoiningModal(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        customMembershipPage = new CustomMembershipPage(webDriver);
        stepOnePage = new StepOnePage(webDriver);
        manageMembershipPage = new ManageMembershipPage(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        cancelModal = new CancelModal(webDriver);
        rrpModal = new RrpModal(webDriver);
        startYourTenDayFreeTrialWidget = new StartYourTenDayFreeTrialWidget(webDriver);
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
        articlesPage = new ArticlesPage(webDriver);
        testimonialsPage = new TestimonialsPage(webDriver);
        whatMembersSayWidget = new WhatMembersSayWidget(webDriver);
        editCollectionModal = new EditCollectionModal(webDriver);
        rrpPage = new RrpPage(webDriver);
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        curriculumManagerTest = new User_CurriculumManagerPageTest();
    }

    @Test(description = "Account management - Create a Free Member account - C2443: Try It Free button", groups = {"accountManagement"})
    public void testC2443() {
        lpHomePage.loadPage();
        Assert.assertEquals(headerPage.getTryItFreeButtonBackgroundColor(), TestData.TRY_IT_FREE_BUTTON_BACKGROUND_COLOR);
        headerPage.clickOnTryItFree(false);
        Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
    }

    @Test(description = "Account management - Create a Free Member account - C2444: Through the 'Become a Lesson Planet Free Member' modal", groups = {"accountManagement"})
    public void testC2444() {
        discoverResourcesPage.loadPage();
        discoverResourcesPage.changeToListView();
        discoverResourcesPage.selectFacetViaShortcut(new ArrayList<>(Arrays.asList(TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS)));
        List<WebElement> getFreeAccessResources = discoverResourcesPage.getAllFreeAccessButtons();
        discoverResourcesPage.dragAndDrop(getFreeAccessResources.get(0), collectionBuilderPage.getCollectionDroppableZone());
        becomeALessonPlanetFreeMemberModal.waitForModal();
        becomeALessonPlanetFreeMemberModal.clickOnFreeMemberLink();
        freeMemberLimitedAccessModal.typeEmailAddress(TestData.GET_NEW_EMAIL());
        freeMemberLimitedAccessModal.typePassword(TestData.VALID_PASSWORD);
        freeMemberLimitedAccessModal.clickOnGetStartedButton();
        Assert.assertEquals(thanksForJoiningModal.getModalText(), TestData.THANKS_FOR_JOINING_MODAL_TEXT);
    }

    @Test(description = "Account management - Create a Free Member account - C2445: Quitting Step 2 registration process", groups = {"accountManagement"})
    public void testC2445() {
        user_stepTwoTest = new User_StepTwoTest();
        user_stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.goBackOnePage();
        Assert.assertEquals(headerPage.getUpgradeMeButtonBackgroundColor(), TestData.TRY_IT_FREE_BUTTON_BACKGROUND_COLOR);
        myAccountPage.loadPage();
        Assert.assertEquals(myAccountPage.getPlan(), TestData.FREE_MEMBERSHIP_TEXT);
    }

    @Test(description = "Account management - Create a Free Member account - C2446: After membership is canceled", groups = {"accountManagement"})
    public void testC2446() {
        user_stepTwoTest = new User_StepTwoTest();
        user_stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.completeStepTwoPageWith(TestData.PLAN_STARTER);

        myAccountPage.loadPage();
        Assert.assertTrue(TestData.PLAN_STARTER.startsWith(myAccountPage.getPlan().toLowerCase()));

        customMembershipPage.loadPage();
        customMembershipPage.clickOnSpecialOffersAndCancellationsLink();
        customMembershipPage.clickOnReasonsDropdown();
        customMembershipPage.selectOptionFromDropDown(TestData.THE_MEMBERSHIP_FEE_WAS_TOO_EXPENSIVE_FOR_ME_TEXT);
        customMembershipPage.clickOnContinueInput();
        cancelModal.clickOnNoThanksConfirmCancellationButton();
        Assert.assertTrue(myAccountPage.isRenewNowButtonDisplayed());
        Assert.assertTrue(myAccountPage.isStatusDateDisplayed());
        Assert.assertTrue(TestData.PLAN_STARTER.startsWith(myAccountPage.getPlan().toLowerCase()));

        Assert.assertTrue(TestData.COMPARE_EQUAL_DATES(myAccountPage.getStatusDate(), TestData.ADD_DAYS_TO_DATE(TestData.GET_CURRENT_DATE(), expectedDaysToExpire)));
    }

    @Test(description = "Account management - Downgrade - C2449: From Freemium membership", groups = {"accountManagement"})
    public void testC2449() {
        lpHomePage.loadPage();
        stepOnePage.completeStepOne(TestData.GET_NEW_EMAIL(), TestData.VALID_PASSWORD);
        myAccountPage.loadPage();
        Assert.assertEquals(myAccountPage.getPlan(), TestData.FREE_MEMBERSHIP_TEXT);
        Assert.assertFalse(myAccountPage.isManageMembershipLinkDisplayed());
        manageMembershipPage.loadPage();
        Assert.assertFalse(manageMembershipPage.getPath().equals(TestData.MANAGE_MEMBERSHIP_PAGE_PATH));
        Assert.assertTrue(stepTwoPage.getPath().equals(TestData.STEP_ONE_PAGE_PATH));
        Assert.assertTrue(stepTwoPage.getTitleText().equals(TestData.STEP_TWO_TITLE_MESSAGE));
    }

    @Test(description = "Account management - Downgrade - C2448: From Pro membership", groups = {"accountManagement"})
    public void testC2448() {
        testDowngrade(TestData.PLAN_PRO, TestData.PLAN_STARTER);
    }

    @Test(description = "Account management - Downgrade - C2447: From Starter membership", groups = {"accountManagement"})
    public void testC2447() {
        testDowngrade(TestData.PLAN_STARTER, TestData.PLAN_STARTER);
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
        user_stepTwoTest = new User_StepTwoTest();
        user_stepTwoTest.initAndReachStepTwoPage(webDriver);
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
        user_stepTwoTest = new User_StepTwoTest();
        user_stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.completeStepTwoPageWith(TestData.PLAN_STARTER);

        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnUpgradeMeNowButton();

        Assert.assertEquals(manageMembershipPage.getNumberOfDisplayedOffers(), 2);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(0), TestData.STARTER_OPTION_TEXT);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(1), TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Account management - Upgrade a Starter membership - C2431: From My Account page", groups = {"accountManagement"})
    public void testC2431() {
        user_stepTwoTest = new User_StepTwoTest();
        user_stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.completeStepTwoPageWith(TestData.PLAN_STARTER);

        myAccountPage.loadPage();
        myAccountPage.clickOnUpgradeYourPlanButton();

        Assert.assertEquals(manageMembershipPage.getNumberOfDisplayedOffers(), 2);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(0), TestData.STARTER_OPTION_TEXT);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(1), TestData.PRO_OPTION_TEXT);
    }

    private void testDowngrade(String subscriptionToTest, String lowerSubscription) {
        user_stepTwoTest = new User_StepTwoTest();
        user_stepTwoTest.initAndReachStepTwoPage(webDriver);

        stepTwoPage.completeStepTwoPageWith(subscriptionToTest);

        myAccountPage.loadPage();
        if (subscriptionToTest.equals(TestData.PLAN_PRO)) {
            Assert.assertEquals(myAccountPage.getPlan(), TestData.PRO_OPTION_TEXT);
        } else {
            Assert.assertTrue(subscriptionToTest.contains(myAccountPage.getPlan().toLowerCase()));
        }
        myAccountPage.clickOnManageMembershipLink();
        Assert.assertTrue(manageMembershipPage.getPath().equals(TestData.MANAGE_MEMBERSHIP_PAGE_PATH));
        manageMembershipPage.clickOnMoreAccountOptionsButton();

        customMembershipPage.clickOnSpecialOffersAndCancellationsLink();
        customMembershipPage.clickOnReasonsDropdown();
        customMembershipPage.selectOptionFromDropDown(TestData.THE_MEMBERSHIP_FEE_WAS_TOO_EXPENSIVE_FOR_ME_TEXT);
        customMembershipPage.clickOnContinueInput();

        checkCancelModalTexts(subscriptionToTest);
        cancelModal.clickOnYesSignUpInput();
        myAccountPage.loadPage();
        Assert.assertTrue(lowerSubscription.contains(myAccountPage.getPlan().toLowerCase()));

        if (!subscriptionToTest.equals(TestData.PLAN_STARTER)) {
            manageMembershipPage.loadPage();
            manageMembershipPage.upgradeSubscriptionAndReturn(subscriptionToTest);
        }
        customMembershipPage.loadPage();

        customMembershipPage.clickOnSpecialOffersAndCancellationsLink();
        customMembershipPage.clickOnReasonsDropdown();
        customMembershipPage.selectOptionFromDropDown(TestData.THE_MEMBERSHIP_FEE_WAS_TOO_EXPENSIVE_FOR_ME_TEXT);
        customMembershipPage.clickOnContinueInput();

        if (subscriptionToTest.equals(TestData.PLAN_STARTER)) {
            Assert.assertEquals(cancelModal.getModalTitleText(), TestData.CANCEL_MODAL_FROM_STARTER_MONTHLY_TITLE_TEXT);
            Assert.assertEquals(cancelModal.getCancelQuestionText(), TestData.CANCEL_MODAL_FROM_STARTER_MONTHLY_QUESTION_TEXT);
            Assert.assertEquals(cancelModal.getModalYourCurrentMembershipText(), TestData.CANCEL_MODAL_FROM_STARTER_MONTHLY_YOUR_CURRENT_MEMBERSHIP_TEXT);
            Assert.assertEquals(cancelModal.getModalIndividualMembershipText(), TestData.CANCEL_MODAL_FROM_STARTER_MONTHLY_INDIVIDUAL_MEMBERSHIP_TEXT);
            Assert.assertEquals(cancelModal.getRenewalAmountText(), TestData.CANCEL_MODAL_FROM_STARTER_MONTHLY_RENEWAL_AMOUNT_TEXT);
            Assert.assertTrue(cancelModal.getRenewalDateText().contains(TestData.CANCEL_MODAL_FROM_STARTER_MONTHLY_RENEWAL_DATE_TEXT));
        } else {
            checkCancelModalTexts(subscriptionToTest);
        }
        if (!subscriptionToTest.equals(TestData.PLAN_STARTER)) {
            cancelModal.clickOnNoThanksConfirmCancellationButton();
        } else {
            cancelModal.clickOnConfirmCancellation();
        }
        myAccountPage.loadPage();

        Assert.assertTrue(myAccountPage.isRenewNowButtonDisplayed());
        Assert.assertTrue(myAccountPage.isStatusDateDisplayed());
        if (subscriptionToTest.equals(TestData.PLAN_PRO)) {
            Assert.assertEquals(myAccountPage.getPlan(), TestData.PRO_OPTION_TEXT);
        } else {
            Assert.assertTrue(subscriptionToTest.contains(myAccountPage.getPlan().toLowerCase()));
        }
        Assert.assertTrue(TestData.COMPARE_EQUAL_DATES(myAccountPage.getStatusDate(), TestData.ADD_DAYS_TO_DATE(TestData.GET_CURRENT_DATE(), expectedDaysToExpire)));
    }

    private void checkCancelModalTexts(String subscriptionToTest) {
        if (subscriptionToTest.equals(TestData.PLAN_PRO)) {
            Assert.assertEquals(cancelModal.getModalWantToTryACheaperPlanText(), TestData.CANCEL_MODAL_CHEAPER_TEXT);
            Assert.assertTrue(TestData.PLAN_STARTER.startsWith(cancelModal.getModalIndividualMembershipText().toLowerCase()));
            Assert.assertEquals(cancelModal.getNumberOfCollectionsText(), TestData.CANCEL_MODAL_FROM_PRO_COLLECTION_NO_TEXT);
            Assert.assertEquals(cancelModal.getFreeTrialText(), TestData.CANCEL_MODAL_TRIAL_TIME_TEXT);
            Assert.assertEquals(cancelModal.getBillingText(), TestData.CANCEL_MODAL_FROM_PRO_BILLED_ANNUALLY_TEXT);
        } else {
            Assert.assertEquals(cancelModal.getModalWantToTryACheaperPlanText(), TestData.CANCEL_MODAL_FROM_STARTER_QUESTION_TEXT);
            Assert.assertEquals(cancelModal.getModalYourCurrentMembershipText(), TestData.CANCEL_MODAL_FROM_STARTER_MONTHLY_PLAN_TEXT);
            Assert.assertEquals(cancelModal.getFullAccessMessageText(), TestData.CANCEL_MODAL_FROM_STARTER_FULL_ACCESS_TEXT);
            Assert.assertEquals(cancelModal.getRenewalAmountText(), TestData.CANCEL_MODAL_FROM_STARTER_START_MY_MEMBERSHIP_TEXT);
        }
    }

    private void testUpgradeFreeMemberFromGetFreeAccessButton() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickGetFreeAccess(true);
        checkStepTwoPageNewTab();
        discoverResourcesPage.clickGetFreeAccess(false);
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
        discoverResourcesPage.clickSeeReview(false);
        rrpModal.waitForModal();
        rrpModal.clickUpgradeForFullReviewButton(true);
        checkStepTwoPageNewTab();
        rrpModal.clickUpgradeForFullReviewButton(false);
        checkStepTwoPageSameTab();
    }

    private void testUpgradeFreeMemberFromUploadButtonFromEditCollectionModal() {
        discoverResourcesPage.loadPage();
        curriculumManagerTest.initTest(webDriver);
        curriculumManagerTest.testCreateCollectionFromCollectionBuilder(TestData.NEW_COLLECTION_NAME);
        collectionBuilderPage.clickOnEditFolder(false);
        editCollectionModal.waitForModal();
        editCollectionModal.clickOnAddItemsDropdown();
        editCollectionModal.clickFileUploadButton();
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
        discoverResourcesPage.clickSeeReview(true);
        rrpPage.clickStartYourFreeTrialUpgradeMeButton(true);
        checkStepTwoPageNewTab();
        rrpPage.clickBottomPageUpgradeMeButton(true);
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
        whatMembersSayWidget.clickSubscriptionButton(true);
        checkStepTwoPageNewTab();
        whatMembersSayWidget.clickSubscriptionButton(false);
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
