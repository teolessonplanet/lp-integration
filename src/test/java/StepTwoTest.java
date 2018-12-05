import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class StepTwoTest extends BaseTest {

    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private StepOnePage stepOnePage;
    private StepTwoModal stepTwoModal;
    private StepTwoPage stepTwoPage;
    private MyAccountPage myAccountPage;
    private SubscriptionSuccessPage subscriptionSuccessPage;


    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        headerPage = new HeaderPage(webDriver);
        stepOnePage = new StepOnePage(webDriver);
        stepTwoModal = new StepTwoModal(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        subscriptionSuccessPage = new SubscriptionSuccessPage(webDriver);
        reachStepTwoModal();
    }

    private void reachStepTwoModal() {
        lpHomePage.loadPage();
        stepOnePage.completeStepOne(TestData.GET_NEW_EMAIL(), TestData.VALID_PASSWORD);
        headerPage.clickOnUpgradeMeButton();
        stepTwoModal.waitForModal();
    }
    @Test(description = "LP - User Visits Step 2 - lessonp-12:User quits Step 2"
            + "Steps:"
            + "1.Quit Step 2 sign up process"
            + "2.Verify if the user has Freemium subscription")
    public void testLessonp_12() {
        stepTwoModal.clickOnCloseModal();
        myAccountPage.loadPage();
        Assert.assertEquals(TestData.FREE_MEMBERSHIP_TEXT, myAccountPage.getPlan());
    }

    @Test(description = "LP - User Visits Step 2 - lessonp-14:User supplies invalid form data"
            + "Steps:"
            + "1.Insert invalid data and submit"
            + "2.Verify if the errors are displayed"
            + "3.Repeat steps 1&2 until all the errors are checked")
    public void testLessonp_14() {
        //check errors for invalid Card number, Expiration date and Cvv error
        stepTwoModal.typeCardNumber(TestData.INVALID_CARD_NUMBER);
        stepTwoModal.typeExpiration(TestData.INVALID_CARD_EXPIRATION);
        stepTwoModal.typeCvv(TestData.INVALID_CARD_CVV);
        stepTwoModal.clickOnStartMembership();
        Assert.assertEquals(TestData.INVALID_CARD_NUMBER_ERROR_MESSAGE, stepTwoModal.getCardNumberError());
        Assert.assertEquals(TestData.INVALID_CARD_EXPIRATION_ERROR_MESSAGE, stepTwoModal.getExpirationError());
        Assert.assertEquals(TestData.INVALID_CARD_CVV_ERROR_MESSAGE, stepTwoModal.getCvvError());
        stepTwoModal.clearCardNumber();
        stepTwoModal.clearExpiration();
        stepTwoModal.clearCvv();

        stepTwoModal.clickOnStartMembership();
        // All 6 errors should be displayed
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getFirstNameError());
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getLastNameError());
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getCardNumberError());
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getExpirationError());
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getCvvError());
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getZipCodeError());

        stepTwoModal.typeFirstName(TestData.FIRSTNAME);
        stepTwoModal.clickOnStartMembership();
        // 5 errors should be displayed - 1 should not be visible
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getLastNameError());
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getCardNumberError());
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getExpirationError());
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getCvvError());
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getZipCodeError());
        Assert.assertFalse(stepTwoModal.isFirstNameErrorDisplayed());

        stepTwoModal.typeLastName(TestData.LASTNAME);
        stepTwoModal.clickOnStartMembership();
        // 4 errors should be displayed - 2 should not be visible
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getCardNumberError());
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getExpirationError());
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getCvvError());
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getZipCodeError());
        Assert.assertFalse(stepTwoModal.isFirstNameErrorDisplayed());
        Assert.assertFalse(stepTwoModal.isLastNameErrorDisplayed());

        stepTwoModal.typeCardNumber(TestData.CARD_NUMBER);
        stepTwoModal.clickOnStartMembership();
        // 3 errors should be displayed - 3 should not be visible
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getExpirationError());
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getCvvError());
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getZipCodeError());
        Assert.assertFalse(stepTwoModal.isFirstNameErrorDisplayed());
        Assert.assertFalse(stepTwoModal.isLastNameErrorDisplayed());
        Assert.assertFalse(stepTwoModal.isCardNumberErrorDisplayed());

        stepTwoModal.typeExpiration(TestData.CARD_EXPIRATION);
        stepTwoModal.clickOnStartMembership();
        //2 errors should be displayed - 4 should not be visible
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getCvvError());
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getZipCodeError());
        Assert.assertFalse(stepTwoModal.isFirstNameErrorDisplayed());
        Assert.assertFalse(stepTwoModal.isLastNameErrorDisplayed());
        Assert.assertFalse(stepTwoModal.isCardNumberErrorDisplayed());
        Assert.assertFalse(stepTwoModal.isExpirationErrorDispplayed());

        stepTwoModal.typeCvv(TestData.CARD_CVV);
        stepTwoModal.clickOnStartMembership();
        //1 error should be displayed - 5 should not be visible
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getZipCodeError());
        Assert.assertFalse(stepTwoModal.isFirstNameErrorDisplayed());
        Assert.assertFalse(stepTwoModal.isLastNameErrorDisplayed());
        Assert.assertFalse(stepTwoModal.isCardNumberErrorDisplayed());
        Assert.assertFalse(stepTwoModal.isExpirationErrorDispplayed());
        Assert.assertFalse(stepTwoModal.isCvvErrorDisplayed());

        stepTwoModal.deleteFistNameField();
        stepTwoModal.typeZipCode(TestData.CARD_EXPIRATION);
        stepTwoModal.clickOnStartMembership();
        //1 error should be displayed (for FistName field) - 5 should not be visible
        Assert.assertEquals(TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE, stepTwoModal.getFirstNameError());
        Assert.assertFalse(stepTwoModal.isLastNameErrorDisplayed());
        Assert.assertFalse(stepTwoModal.isCardNumberErrorDisplayed());
        Assert.assertFalse(stepTwoModal.isExpirationErrorDispplayed());
        Assert.assertFalse(stepTwoModal.isCvvErrorDisplayed());
        Assert.assertFalse(stepTwoModal.isZipCodeErrorDispplayed());

        stepTwoModal.typeFirstName(TestData.FIRSTNAME);
        stepTwoModal.clickOnStartMembership();
        //the user should be redirected to Subscription Successfully page
        Assert.assertEquals(TestData.SUBSCRIPTION_SUCCESS_PAGE_TITLE, subscriptionSuccessPage.getTitle());
    }

    @Test(description = "LP - User Visits Step 2 - lessonp-13:User supplies valid form data")
    public void testLessonp_13() {
        Assert.assertEquals(TestData.PRIME_OPTION_TEXT, stepTwoModal.getSelectedOption());
        stepTwoModal.typeFirstName(TestData.FIRSTNAME);
        stepTwoModal.typeLastName(TestData.LASTNAME);
        stepTwoModal.typeCardNumber(TestData.CARD_NUMBER);
        stepTwoModal.typeExpiration(TestData.CARD_EXPIRATION);
        stepTwoModal.typeCvv(TestData.CARD_CVV);
        stepTwoModal.typeZipCode(TestData.ZIP_CODE);
        stepTwoModal.clickOnStartMembership();
        Assert.assertEquals(TestData.SUBSCRIPTION_SUCCESS_PAGE_TITLE, subscriptionSuccessPage.getTitle());
        Assert.assertEquals(TestData.SUBSCRIPTION_SUCCESS_PATH, subscriptionSuccessPage.getPath());
        myAccountPage.loadPage();
        Assert.assertEquals(TestData.PRIME_OPTION_TEXT, myAccountPage.getPlan());
    }

    @Test(description = "LP - User Visits Step 2 - lessonp-20:User tries to go back to Step 1 via the browser back button")
    public void testLessonp_20() {
        stepTwoModal.goBackOnePage();
        stepTwoModal.waitForPageLoad();
        Assert.assertFalse(headerPage.isLogoClicable());
        stepOnePage.loadPage();
        // The Step1 is changed with Step2
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
    }

    @Test(description = "LP - User Visits Step 2 - lessonp-17:User changes Default membership plan"
            + "Steps:"
            + "1. Reach Step2 modal"
            + "2. Check billing text for PRIME plan"
            + "3. Select STARTER plan"
            + "4. Check billing text for STARTER plan"
            + "4. Select PRO plan"
            + "6. Check billing text for PRO plan")
    public void testLessonp_17() {
        Assert.assertEquals(TestData.GET_PRIME_BILLING_TERMS_MESSAGE(), stepTwoModal.getBillingTermsText());
        stepTwoModal.selectOffer(TestData.STARTER_OPTION_TEXT);
        stepTwoModal.waitForPageLoad();
        Assert.assertEquals(TestData.GET_STARTER_BILLING_TERMS_MESSAGE(), stepTwoModal.getBillingTermsText());
        stepTwoModal.selectOffer(TestData.PRO_OPTION_TEXT);
        stepTwoModal.waitForPageLoad();
        Assert.assertEquals(TestData.GET_PRO_BILLING_TERMS_MESSAGE(), stepTwoModal.getBillingTermsText());
    }
}
