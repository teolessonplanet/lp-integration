import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import util.TestData;

public class SignupTest extends BaseTest {
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private StepOneModal stepOneModal;
    private StepTwoModal stepTwoModal;
    private SubscriptionSuccessPage subscriptionSuccessPage;
    private MyAccountPage myAccountPage;
    private PricingPage pricingPage;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        headerPage = new HeaderPage(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        stepTwoModal = new StepTwoModal(webDriver);
        subscriptionSuccessPage = new SubscriptionSuccessPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        pricingPage = new PricingPage(webDriver);
    }

    @Test(description = "Active user - Sign Up/Create a Starter account - lessonp-3849:Create a Starter Account - Try it Free button")
    public void testLessonp_3849() {
        testCreateAccountViaTryItFree(TestData.STARTER_OPTION_TEXT);
    }

    @Test(description = "Active user - Sign Up/Create a Starter account - lessonp-3850:Create a Prime Account - Try it Free button")
    public void testLessonp_3850() {
        testCreateAccountViaTryItFree(TestData.PRIME_OPTION_TEXT);
    }

    @Test(description = "Active user - Sign Up/Create a Starter account - lessonp-3851:Create a Pro Account - Try it Free button")
    public void testLessonp_3851() {
        testCreateAccountViaTryItFree(TestData.PRO_OPTION_TEXT);
    }

    @Ignore
    @Deprecated
    @Test(description = "Active user - Sign Up/Create a Starter account - lessonp-3881:Create a Starter Account - Pricing button")
    public void testLessonp_3881() {
        testCreateAccountViaPricing(TestData.STARTER_OPTION_TEXT);
    }

    @Test(description = "Active user - Sign Up/Create a Starter account - lessonp-3882:Create a Prime Account - Pricing button")
    public void testLessonp_3882() {
        testCreateAccountViaPricing(TestData.PRIME_OPTION_TEXT);
    }

    @Ignore
    @Deprecated
    @Test(description = "Active user - Sign Up/Create a Starter account - lessonp-3883:Create a Pro Account - Pricing button\n")
    public void testLessonp_3883() {
        testCreateAccountViaPricing(TestData.PRO_OPTION_TEXT);
    }

    private void testCreateAccountViaTryItFree(String plan) {
        lpHomePage.loadPage();
        headerPage.clickOnTryItFree(false);
        testStepTwo(plan);
    }

    private void testCreateAccountViaPricing(String plan) {
        lpHomePage.loadPage();
        headerPage.clickOnPricingButton();
        pricingPage.selectOffer(plan);
        testStepTwo(plan);
    }

    private void testStepTwo(String plan) {
        stepOneModal.typeEmail(TestData.GET_NEW_EMAIL());
        stepOneModal.typePassword(TestData.VALID_PASSWORD);
        stepOneModal.clickOnGetStartedToday();

        stepTwoModal.clickOnStartMembership();
        Assert.assertEquals(stepTwoModal.getFirstNameError(), TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE);
        Assert.assertEquals(stepTwoModal.getLastNameError(), TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE);
        Assert.assertEquals(stepTwoModal.getCardNumberError(), TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE);
        Assert.assertEquals(stepTwoModal.getExpirationError(), TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE);
        Assert.assertEquals(stepTwoModal.getCvvError(), TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE);
        Assert.assertEquals(stepTwoModal.getZipCodeError(), TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE);

        stepTwoModal.typeFirstName(TestData.FIRSTNAME);
        stepTwoModal.typeLastName(TestData.LASTNAME);
        stepTwoModal.typeCardNumber(TestData.CARD_NUMBER);
        stepTwoModal.typeExpiration(TestData.CARD_EXPIRATION);
        stepTwoModal.typeCvv(TestData.CARD_CVV);
        stepTwoModal.typeZipCode(TestData.ZIP_CODE);
        stepTwoModal.selectOffer(plan);
        stepTwoModal.clickOnStartMembership();

        Assert.assertEquals(subscriptionSuccessPage.getTitle(), TestData.SUBSCRIPTION_SUCCESS_PAGE_TITLE);
        subscriptionSuccessPage.clickOnGetStartedButton();
        Assert.assertEquals(lpHomePage.getAlertMessageText(), TestData.THANK_YOU_FOR_UPDATING_TEXT);
        myAccountPage.loadPage();
        Assert.assertEquals(myAccountPage.getPlan(), plan);
    }
}
