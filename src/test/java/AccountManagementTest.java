import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class AccountManagementTest extends BaseTest {
    private static final int expectedDaysToExpire = 11;
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private StepOneModal stepOneModal;
    private DiscoverResourcesPage discoverResourcesPage;
    private CollectionBuilderPage collectionBuilderPage;
    private BecomeALessonPlanetFreeMemberModal becomeALessonPlanetFreeMemberModal;
    private FreeMemberLimitedAccessModal freeMemberLimitedAccessModal;
    private ThanksForJoiningModal thanksForJoiningModal;
    private StepTwoTest stepTwoTest;
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
    private ContactUsPage contactUsPage;
    private FAQPage faqPage;
    private EditCollectionModal editCollectionModal;
    private CollectionRrpModal collectionRrpModal;
    private RrpPage rrpPage;
    private UpgradeMaxItemsCollectionModal upgradeMaxItemsCollectionModal;
    private CurriculumManagerPage curriculumManagerPage;
    private UpgradeAssignModal upgradeAssignModal;
    private CurriculumManagerPageTest curriculumManagerTest;

    @BeforeMethod
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
        contactUsPage = new ContactUsPage(webDriver);
        faqPage = new FAQPage(webDriver);
        editCollectionModal = new EditCollectionModal(webDriver);
        collectionRrpModal = new CollectionRrpModal(webDriver);
        rrpPage = new RrpPage(webDriver);
        upgradeMaxItemsCollectionModal = new UpgradeMaxItemsCollectionModal(webDriver);
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        upgradeAssignModal = new UpgradeAssignModal(webDriver);
        curriculumManagerTest = new CurriculumManagerPageTest();
    }

    public void reachAccountManagementPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Account management - Create a Free Member account - lessonp-717: Try It Free button")
    public void testLessonp_717() {
        lpHomePage.loadPage();
        Assert.assertEquals(headerPage.getTryItFreeButtonBackgroundColor(), TestData.TRY_IT_FREE_BUTTON_BACKGROUND_COLOR);
        headerPage.clickOnTryItFree(false);
        Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
    }

    @Test(description = "Account management - Create a Free Member account - lessonp-692: Through the 'Become a Lesson Planet Free Member' modal")
    public void testLessonp_692() {
        discoverResourcesPage.loadPage();
        discoverResourcesPage.changeToListView();
        List<WebElement> getFreeAccessResources = discoverResourcesPage.getAllFreeAccessButtons();
        discoverResourcesPage.dragAndDrop(getFreeAccessResources.get(0), collectionBuilderPage.getCollectionDroppableZone());
        becomeALessonPlanetFreeMemberModal.waitForModal();
        becomeALessonPlanetFreeMemberModal.clickOnFreeMemberLink();
        freeMemberLimitedAccessModal.typeEmailAddress(TestData.GET_NEW_EMAIL());
        freeMemberLimitedAccessModal.typePassword(TestData.VALID_PASSWORD);
        freeMemberLimitedAccessModal.clickOnGetStartedButton();
        Assert.assertEquals(thanksForJoiningModal.getModalText(), TestData.THANKS_FOR_JOINING_MODAL_TEXT);
    }

    @Test(description = "Account management - Create a Free Member account - lessonp-693: Quitting Step 2 registration process")
    public void testLessonp_693() {
        stepTwoTest = new StepTwoTest();
        stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.goBackOnePage();
        Assert.assertEquals(headerPage.getUpgradeMeButtonBackgroundColor(), TestData.TRY_IT_FREE_BUTTON_BACKGROUND_COLOR);
        myAccountPage.loadPage();
        Assert.assertEquals(myAccountPage.getPlan(), TestData.FREE_MEMBERSHIP_TEXT);
    }

    @Test(description = "Account management - Create a Free Member account - lessonp-694: After membership is canceled")
    public void testLessonp_694() {
        stepTwoTest = new StepTwoTest();
        stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.completeStepTwoPageWith(TestData.STARTER_OPTION_TEXT);

        myAccountPage.loadPage();
        Assert.assertEquals(myAccountPage.getPlan(), TestData.STARTER_OPTION_TEXT);

        customMembershipPage.loadPage();
        customMembershipPage.clickOnSpecialOffersAndCancellationsLink();
        customMembershipPage.clickOnReasonsDropdown();
        customMembershipPage.selectOptionFromDropDown(TestData.THE_MEMBERSHIP_FEE_WAS_TOO_EXPENSIVE_FOR_ME_TEXT);
        customMembershipPage.clickOnContinueInput();
        cancelModal.clickOnNoThanksConfirmCancellationButton();
        Assert.assertTrue(myAccountPage.isRenewNowButtonDisplayed());
        Assert.assertTrue(myAccountPage.isStatusDateDisplayed());
        Assert.assertEquals(myAccountPage.getPlan(), TestData.STARTER_OPTION_TEXT);

        Assert.assertTrue(TestData.COMPARE_EQUAL_DATES(myAccountPage.getStatusDate(), TestData.ADD_DAYS_TO_DATE(TestData.GET_CURRENT_DATE(), expectedDaysToExpire)));
    }

    @Test(description = "Account management - Downgrade - lessonp-682: From Freemium membership")
    public void testLessonp_682() {
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

    @Test(description = "Account management - Downgrade - lessonp-948: From Pro membership")
    public void testLessonp_948() {
        testDowngrade(TestData.PRO_OPTION_TEXT, TestData.PRIME_OPTION_TEXT);
    }

    @Test(description = "Account management - Downgrade - lessonp-947: From Prime membership")
    public void testLessonp_947() {
        testDowngrade(TestData.PRIME_OPTION_TEXT, TestData.STARTER_OPTION_TEXT);
    }

    @Test(description = "Account management - Downgrade - lessonp-683: From Starter membership")
    public void testLessonp_983() {
        testDowngrade(TestData.STARTER_OPTION_TEXT, TestData.STARTER_OPTION_TEXT);
    }

    @Test(description = "Account management - Upgrade a Free Member - lessonp-687: From <Get Free Access> button on a resource card")
    public void testLessonp_687() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testUpgradeFreeMemberFromGetFreeAccessButton();
    }

    @Test(description = "Account management - Upgrade a Free Member - lessonp-688: From <Upgrade for Full Review> button on the RRP")
    public void testLessonp_688() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testUpgradeFreeMemberFromUpgradeForFullReviewButton();
    }

    @Test(description = "Account management - Upgrade a Free Member - lessonp-686: From uploading a file from Collection Builder, Edit Collection Modal and Curriculum Manager")
    public void testLessonp_686() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testUpgradeFreeMemberFromUploadButtonFromCollectionBuilder();
        testUpgradeFreeMemberFromUploadButtonFromEditCollectionModal();
        testUpgradeFreeMemberFromUploadButtonFromCurriculumManagerPage();
    }

    @Test(description = "Account management - Upgrade a Free Member - lessonp-684: Free members exceeds the allowed number of collections created")
    public void testLessonp_684() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testUpgradeFreeMemberFromExceededNumberOfCollectionsCreated();
    }

    @Test(description = "Account management - Upgrade a Free Member - lessonp-1000: Free member tries to save a 4th collection")
    public void testLessonp_1000() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testUpgradeFreeMemberFromSaving4thCollection();
    }

    @Test(description = "AAccount management - Upgrade a Free Member - lessonp-690: Free member tries to assign a favorite resource and a collection")
    public void testLessonp_690() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testUpgradeFreeMemberFromAssignResourceButton();
        testUpgradeFreeMemberFromAssignCollectionButton();
    }

    @Test(description = "Account management - Upgrade a Free Member - lessonp-685: Free member exceeds the allowed number of items inside a created collection")
    public void testLessonp_685() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testUpgradeFreeMemberFromExceededNumberOfItemsInsideACreatedCollection();
    }

    @Test(description = "Account management - Upgrade a Free Member - lessonp-689: Free member tries to save a collection containing more than 10 items")
    public void testLessonp_689() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testUpgradeFreeMemberFromExceededNumberOfItemsInsideASavedCollection();
    }

    @Test(description = "Account management - Upgrade a Free Member - lessonp-3884: Free member clicks any of the <Upgrade Me> or <Get Full Access> buttons")
    public void testLessonp_3884() {
        stepTwoPage.createNewAccount(TestData.FREE_MEMBERSHIP_TEXT);
        testUpgradeFreeMemberFromUpgradeMeButtons();
        testUpgradeFreeMemberFromGetFullAccessButtons();
    }

    @Test(description = "Account management - Upgrade a Pro membership - lessonp-673: No upgrade possible (Pro $72)")
    public void testLessonp_673() {
        stepTwoTest = new StepTwoTest();
        stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.completeStepTwoPageWith(TestData.PRO_OPTION_TEXT);

        myAccountPage.loadPage();
        Assert.assertEquals(myAccountPage.getPlan(), TestData.PRO_OPTION_TEXT);
        Assert.assertFalse(myAccountPage.isUpgradeYourPlanButtonDisplayed());
        myAccountPage.clickOnManageMembershipLink();
        Assert.assertEquals(manageMembershipPage.getTitleText(), TestData.MANAGE_MEMBERSHIP_TITLE_MESSAGE);
        //Only PRO available
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(0), TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Account management - Upgrade a Prime membership - lessonp-675: From Search page")
    public void testLessonp_675() {
        stepTwoTest = new StepTwoTest();
        stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.completeStepTwoPageWith(TestData.PRIME_OPTION_TEXT);

        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnUpgradeMeNowButton();

        Assert.assertEquals(manageMembershipPage.getNumberOfDisplayedOffers(), 2);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(0), TestData.PRIME_OPTION_TEXT);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(1), TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Account management - Upgrade a Prime membership - lessonp-676: From My Account page")
    public void testLessonp_676() {
        stepTwoTest = new StepTwoTest();
        stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.completeStepTwoPageWith(TestData.PRIME_OPTION_TEXT);

        myAccountPage.loadPage();
        myAccountPage.clickOnUpgradeYourPlanButton();

        Assert.assertEquals(manageMembershipPage.getNumberOfDisplayedOffers(), 2);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(0), TestData.PRIME_OPTION_TEXT);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(1), TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Account management - Upgrade a Prime membership - lessonp-677: From the Assign modal")
    public void testLessonp_677() {
        stepTwoTest = new StepTwoTest();
        stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.completeStepTwoPageWith(TestData.PRIME_OPTION_TEXT);

        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeFullReview(false);
        rrpModal.waitForModal();
        rrpModal.clickOnFavoriteButton();

        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnMyFavoritesFolder();

        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnAssignButton();

        upgradeAssignModal.waitForModal();
        upgradeAssignModal.clickOnUpgradeMeButton();

        Assert.assertEquals(manageMembershipPage.getNumberOfDisplayedOffers(), 2);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(0), TestData.PRIME_OPTION_TEXT);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(1), TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Account management - Upgrade a Starter membership - lessonp-678: From Search page")
    public void testLessonp_678() {
        stepTwoTest = new StepTwoTest();
        stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.completeStepTwoPageWith(TestData.STARTER_OPTION_TEXT);

        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnUpgradeMeNowButton();

        Assert.assertEquals(manageMembershipPage.getNumberOfDisplayedOffers(), 3);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(0), TestData.STARTER_OPTION_TEXT);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(1), TestData.PRIME_OPTION_TEXT);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(2), TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Account management - Upgrade a Starter membership - lessonp-679: From My Account page")
    public void testLessonp_679() {
        stepTwoTest = new StepTwoTest();
        stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.completeStepTwoPageWith(TestData.STARTER_OPTION_TEXT);

        myAccountPage.loadPage();
        myAccountPage.clickOnUpgradeYourPlanButton();

        Assert.assertEquals(manageMembershipPage.getNumberOfDisplayedOffers(), 3);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(0), TestData.STARTER_OPTION_TEXT);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(1), TestData.PRIME_OPTION_TEXT);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(2), TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Account management - Upgrade a Starter membership - lessonp-680: From the Assign modal")
    public void testLessonp_680() {
        stepTwoTest = new StepTwoTest();
        stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.completeStepTwoPageWith(TestData.STARTER_OPTION_TEXT);

        discoverResourcesPage.loadPage();
        discoverResourcesPage.changeToListView();
        discoverResourcesPage.clickSeeFullReview(false);
        rrpModal.waitForModal();
        rrpModal.clickOnFavoriteButton();

        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnMyFavoritesFolder();

        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnAssignButton();

        upgradeAssignModal.waitForModal();
        upgradeAssignModal.clickOnUpgradeMeButton();

        Assert.assertEquals(manageMembershipPage.getTitleText(), TestData.MANAGE_MEMBERSHIP_TITLE_MESSAGE);
        Assert.assertEquals(manageMembershipPage.getNumberOfDisplayedOffers(), 2);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(0), TestData.STARTER_OPTION_TEXT);
        Assert.assertEquals(manageMembershipPage.getDisplayedOffers().get(1), TestData.PRO_OPTION_TEXT);
    }

    private void testDowngrade(String subscriptionToTest, String lowerSubscription) {
        stepTwoTest = new StepTwoTest();
        stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.completeStepTwoPageWith(subscriptionToTest);

        myAccountPage.loadPage();
        Assert.assertEquals(myAccountPage.getPlan(), subscriptionToTest);
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
        Assert.assertEquals(myAccountPage.getPlan(), lowerSubscription);

        if (!subscriptionToTest.equals(TestData.STARTER_OPTION_TEXT)) {
            manageMembershipPage.loadPage();
            manageMembershipPage.upgradeSubscriptionAndReturn(subscriptionToTest);
        }
        customMembershipPage.loadPage();

        customMembershipPage.clickOnSpecialOffersAndCancellationsLink();
        customMembershipPage.clickOnReasonsDropdown();
        customMembershipPage.selectOptionFromDropDown(TestData.THE_MEMBERSHIP_FEE_WAS_TOO_EXPENSIVE_FOR_ME_TEXT);
        customMembershipPage.clickOnContinueInput();

        if (subscriptionToTest.equals(TestData.STARTER_OPTION_TEXT)) {
            Assert.assertEquals(cancelModal.getModalTitleText(), TestData.CANCEL_MODAL_FROM_STARTER_MONTHLY_TITLE_TEXT);
            Assert.assertEquals(cancelModal.getCancelQuestionText(), TestData.CANCEL_MODAL_FROM_STARTER_MONTHLY_QUESTION_TEXT);
            Assert.assertEquals(cancelModal.getModalYourCurrentMembershipText(), TestData.CANCEL_MODAL_FROM_STARTER_MONTHLY_YOUR_CURRENT_MEMBERSHIP_TEXT);
            Assert.assertEquals(cancelModal.getModalIndividualMembershipText(), TestData.CANCEL_MODAL_FROM_STARTER_MONTHLY_INDIVIDUAL_MEMBERSHIP_TEXT);
            Assert.assertEquals(cancelModal.getRenewalAmountText(), TestData.CANCEL_MODAL_FROM_STARTER_MONTHLY_RENEWAL_AMOUNT_TEXT);
            Assert.assertTrue(cancelModal.getRenewalDateText().contains(TestData.CANCEL_MODAL_FROM_STARTER_MONTHLY_RENEWAL_DATE_TEXT));
        } else {
            checkCancelModalTexts(subscriptionToTest);
        }
        if (!subscriptionToTest.equals(TestData.STARTER_OPTION_TEXT)) {
            cancelModal.clickOnNoThanksConfirmCancellationButton();
        } else {
            cancelModal.clickOnConfirmCancellation();
        }
        myAccountPage.loadPage();

        Assert.assertTrue(myAccountPage.isRenewNowButtonDisplayed());
        Assert.assertTrue(myAccountPage.isStatusDateDisplayed());
        Assert.assertEquals(myAccountPage.getPlan(), subscriptionToTest);
        Assert.assertTrue(TestData.COMPARE_EQUAL_DATES(myAccountPage.getStatusDate(), TestData.ADD_DAYS_TO_DATE(TestData.GET_CURRENT_DATE(), expectedDaysToExpire)));
    }

    private void checkCancelModalTexts(String subscriptionToTest) {
        if (subscriptionToTest.equals(TestData.PRO_OPTION_TEXT)) {
            Assert.assertEquals(cancelModal.getModalWantToTryACheaperPlanText(), TestData.CANCEL_MODAL_CHEAPER_TEXT);
            Assert.assertEquals(cancelModal.getModalIndividualMembershipText(), TestData.PRIME_OPTION_TEXT);
            Assert.assertEquals(cancelModal.getNumberOfCollectionsText(), TestData.CANCEL_MODAL_FROM_PRO_COLLECTION_NO_TEXT);
            Assert.assertEquals(cancelModal.getFreeTrialText(), TestData.CANCEL_MODAL_TRIAL_TIME_TEXT);
            Assert.assertEquals(cancelModal.getBillingText(), TestData.CANCEL_MODAL_FROM_PRO_BILLED_ANNUALLY_TEXT);

        } else if ((subscriptionToTest.equals(TestData.PRIME_OPTION_TEXT))) {
            Assert.assertEquals(cancelModal.getModalWantToTryACheaperPlanText(), TestData.CANCEL_MODAL_CHEAPER_TEXT);
            Assert.assertEquals(cancelModal.getModalIndividualMembershipText(), TestData.STARTER_OPTION_TEXT);
            Assert.assertEquals(cancelModal.getNumberOfCollectionsText(), TestData.CANCEL_MODAL_FROM_PRIME_COLLECTION_NO_TEXT);
            Assert.assertEquals(cancelModal.getFreeTrialText(), TestData.CANCEL_MODAL_TRIAL_TIME_TEXT);
            Assert.assertEquals(cancelModal.getBillingText(), TestData.CANCEL_MODAL_FROM_PRIME_BILLED_ANNUALLY_TEXT);
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

    private void testUpgradeFreeMemberFromUploadButtonFromCollectionBuilder() {
        discoverResourcesPage.loadPage();
        collectionBuilderPage.clickUploadButton();
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testUpgradeModalFromUploadButton();
    }

    private void testUpgradeFreeMemberFromUploadButtonFromEditCollectionModal() {
        discoverResourcesPage.loadPage();
        curriculumManagerTest.testCreateCollectionFromCollectionBuilder();
        collectionBuilderPage.clickOnEditCollection();
        editCollectionModal.waitForModal();
        editCollectionModal.clickOnCollectionActionsDropdown();
        editCollectionModal.clickUploadAFileButton();
        curriculumManagerTest.testUpgradeModalFromUploadButton();
    }

    private void testUpgradeFreeMemberFromUploadButtonFromCurriculumManagerPage() {
        curriculumManagerTest.testUploadResourceUsingTextInput(TestData.FREE_MEMBERSHIP_TEXT);
    }

    private void testUpgradeFreeMemberFromExceededNumberOfCollectionsCreated() {
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testMaxLimitOfCollectionsCreated();
    }

    private void testUpgradeFreeMemberFromSaving4thCollection() {
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testCreateThreeCollections();
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        collectionRrpModal.waitForModal();
        collectionRrpModal.clickSaveCollectionButtonActiveUser();
        curriculumManagerTest.testUpgradeModalFromMaxCollectionLimit();
    }

    private void testUpgradeFreeMemberFromAssignResourceButton() {
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testFavoriteRegularResource(TestData.FREE_MEMBERSHIP_TEXT);
        curriculumManagerTest.testAssignResource(TestData.FREE_MEMBERSHIP_TEXT, TestData.ASSIGN_RESOURCE_MODAL_TEXT);
    }

    private void testUpgradeFreeMemberFromAssignCollectionButton() {
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testCreateCollectionFromCurriculumManager(TestData.NEW_COLLECTION_NAME);
        curriculumManagerTest.testAddRegularResourceToCollection(TestData.FREE_MEMBERSHIP_TEXT);
        curriculumManagerTest.testAddSharedResourceToCollection();
        curriculumManagerTest.testAssignResource(TestData.FREE_MEMBERSHIP_TEXT, TestData.ASSIGN_COLLECTION_MODAL_TEXT);
    }

    private void testUpgradeFreeMemberFromExceededNumberOfItemsInsideACreatedCollection() {
        discoverResourcesPage.loadPage();
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testCreateCollectionFromCollectionBuilder();
        discoverResourcesPage.clickOnListView();
        List<WebElement> getFreeAccessResources = discoverResourcesPage.getAllFreeAccessButtons();
        for (int i = 0; i <= 10; i++) {
            discoverResourcesPage.dragAndDrop(getFreeAccessResources.get(i), collectionBuilderPage.getCollectionDroppableZone());
        }
        testUpgradeModalFromMaxItemsInsideCollection(TestData.UPGRADE_MODAL_TEXT_FROM_EXCEEDED_ITEMS_INSIDE_CREATED_COLLECTION);
    }

    private void testUpgradeFreeMemberFromExceededNumberOfItemsInsideASavedCollection() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        List<WebElement> getCollectionResources = discoverResourcesPage.getAllSeeCollectionsButtons();
        for (int i = 1; i < 24; i++) {
            if (collectionRrpModal.getCollectionItemsCount() <= 10) {
                collectionRrpModal.clickCloseModal();
                discoverResourcesPage.openInANewTabOrClick(getCollectionResources.get(i), false);
            }
        }
        collectionRrpModal.clickSaveCollectionButtonActiveUser();
        testUpgradeModalFromMaxItemsInsideCollection(TestData.UPGRADE_MODAL_TEXT_FROM_EXCEEDED_ITEMS_INSIDE_SAVED_COLLECTION);
    }

    public void testUpgradeModalFromMaxItemsInsideCollection(String bodyText) {
        upgradeMaxItemsCollectionModal.waitForModal();
        Assert.assertEquals(upgradeMaxItemsCollectionModal.getUpgradeModalText(), bodyText);
        upgradeMaxItemsCollectionModal.clickOnUpgradeMeButton(false);
        checkStepTwoPageSameTab();
    }

    private void testUpgradeFreeMemberFromUpgradeMeButtons() {
        testUpgradeFromHeader();
        testUpgradeFromMyAccountPage();
        testUpgradeFromHomePage();
        testUpgradeFromRrpPage();
        testUpgradeFromWhatMembersSayWidgetDirectoryPage();
        testUpgradeFromWhatMembersSayWidgetArticlesPage();
        testUpgradeFromWhatMembersSayWidgetContactUsPage();
        testUpgradeFromWhatMembersSayWidgetTestimonialsPage();
        testUpgradeFromWhatMembersSayWidgetFAQPage();
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

    private void testUpgradeFromHomePage() {
        lpHomePage.loadPage();
        lpHomePage.clickOnUpgradeMeButton(true);
        checkStepTwoPageNewTab();
        lpHomePage.clickOnUpgradeMeButton(false);
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

    private void testUpgradeFromWhatMembersSayWidgetContactUsPage() {
        contactUsPage.loadPage();
        testClickSubscriptionButtonFromWhatMembersSayWidget();
    }

    private void testUpgradeFromWhatMembersSayWidgetTestimonialsPage() {
        testimonialsPage.loadPage();
        testClickSubscriptionButtonFromWhatMembersSayWidget();
    }

    private void testUpgradeFromWhatMembersSayWidgetFAQPage() {
        faqPage.loadPage();
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
