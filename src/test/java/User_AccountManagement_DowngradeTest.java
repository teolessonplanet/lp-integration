import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class User_AccountManagement_DowngradeTest extends BaseTest {
    private static final int expectedDaysToExpire = 11;
    private LpHomePage lpHomePage;
    private User_AccountManagement_StepTwoTest user_AccountManagement_stepTwoTest;
    private MyAccountPage myAccountPage;
    private CustomMembershipPage customMembershipPage;
    private StepOnePage stepOnePage;
    private ManageMembershipPage manageMembershipPage;
    private StepTwoPage stepTwoPage;
    private CancelModal cancelModal;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        customMembershipPage = new CustomMembershipPage(webDriver);
        stepOnePage = new StepOnePage(webDriver);
        manageMembershipPage = new ManageMembershipPage(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        cancelModal = new CancelModal(webDriver);
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

    private void testDowngrade(String subscriptionToTest, String lowerSubscription) {
        user_AccountManagement_stepTwoTest = new User_AccountManagement_StepTwoTest();
        user_AccountManagement_stepTwoTest.initAndReachStepTwoPage(webDriver);

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
}
