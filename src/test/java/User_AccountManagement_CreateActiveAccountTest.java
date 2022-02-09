import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import util.TestData;

public class User_AccountManagement_CreateActiveAccountTest extends BaseTest {
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private StepOneModal stepOneModal;
    private StepTwoModal stepTwoModal;
    private SubscriptionSuccessPage subscriptionSuccessPage;
    private MyAccountPage myAccountPage;
    private PricingPage pricingPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        headerPage = new HeaderPage(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        stepTwoModal = new StepTwoModal(webDriver);
        subscriptionSuccessPage = new SubscriptionSuccessPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        pricingPage = new PricingPage(webDriver);
    }

    @Test(description = "Account Management - Create a Starter account - C2306: Create a Starter Account - Try it Free button", groups = {"accountManagement"})
    public void testC2306() {
        testCreateAccountViaTryItFree(TestData.PLAN_STARTER);
    }

    @Test(description = "Account Management - Create a Pro account - C2308: Create a Pro Account - Try it Free button", groups = {"accountManagement"})
    public void testC2308() {
        testCreateAccountViaTryItFree(TestData.PLAN_PRO);
    }

    @Test(description = "Account Management - Create a PRO account - C2309: Create a Pro Account - Pricing button\n", groups = {"accountManagement"})
    public void testC2309() {
        testCreateAccountViaPricing(TestData.PLAN_PRO);
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
        stepOneModal.clickOnGetStartedTodayButton();

        stepTwoModal.clickOnStartMembershipButton();
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
        stepTwoModal.clickOnStartMembershipButton();

        Assert.assertEquals(subscriptionSuccessPage.getTitle(), TestData.SUBSCRIPTION_SUCCESS_PAGE_TITLE);
        subscriptionSuccessPage.clickOnGetStartedButton();
        Assert.assertEquals(lpHomePage.getAlertMessageText(), TestData.THANK_YOU_FOR_UPDATING_TEXT);
        myAccountPage.loadPage();
        if(!plan.equals(TestData.PLAN_PRO)){
            Assert.assertTrue(plan.startsWith(myAccountPage.getPlan().toLowerCase()));
        } else {
            Assert.assertTrue(myAccountPage.getPlan().contains(TestData.PRO_OPTION_TEXT));
        }
    }
}
