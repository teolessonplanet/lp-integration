import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.util.Random;

public class StepTwoTest extends BaseTest {

    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private StepOnePage stepOnePage;
    private StepTwoModal stepTwoModal;
    private StepTwoPage stepTwoPage;
    private MyAccountPage myAccountPage;
    private SubscriptionSuccessPage subscriptionSuccessPage;
    private StepOneModal stepOneModal;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        headerPage = new HeaderPage(webDriver);
        stepOnePage = new StepOnePage(webDriver);
        stepTwoModal = new StepTwoModal(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        subscriptionSuccessPage = new SubscriptionSuccessPage(webDriver);
        stepOneModal = new StepOneModal(webDriver);
    }

    public void initAndReachStepTwoPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
        reachStepTwoPage();
    }

    public void reachStepTwoPage() {
        lpHomePage.loadPage();
        stepOnePage.completeStepOne(TestData.GET_NEW_EMAIL(), TestData.VALID_PASSWORD);
        headerPage.clickOnUpgradeMeButton(false);
    }

    @Test(description = "Step 2 - lessonp-5252:Step2 Modal - User supplies invalid/valid form data")
    public void testLessonp_5252() {
        lpHomePage.loadPage();
        headerPage.clickOnTryItFree(false);
        stepOneModal.typeEmail(TestData.GET_NEW_EMAIL());
        stepOneModal.typePassword(TestData.VALID_PASSWORD);
        stepOneModal.clickOnGetStartedToday();

        //check errors for invalid Card number, Expiration date and Cvv error
        stepTwoModal.typeCardNumber(TestData.INVALID_CARD_NUMBER);
        stepTwoModal.typeExpiration(TestData.INVALID_CARD_EXPIRATION);
        stepTwoModal.typeCvv(TestData.INVALID_CARD_CVV);
        stepTwoModal.clickOnStartMembership();
        Assert.assertEquals(stepTwoModal.getCardNumberError(), TestData.INVALID_CARD_NUMBER_ERROR_MESSAGE);
        Assert.assertEquals(stepTwoModal.getExpirationError(), TestData.INVALID_CARD_EXPIRATION_ERROR_MESSAGE);
        Assert.assertEquals(stepTwoModal.getCvvError(), TestData.INVALID_CARD_CVV_ERROR_MESSAGE);
        stepTwoModal.clearCardNumber();
        stepTwoModal.clearExpiration();
        stepTwoModal.clearCvv();

        stepTwoModal.clickOnStartMembership();
        // All 6 errors should be displayed
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

        final String offerToSelect = getRandomOffer();
        stepTwoModal.selectOffer(offerToSelect);

        stepTwoModal.clickOnStartMembership();
        Assert.assertEquals(subscriptionSuccessPage.getTitle(), TestData.SUBSCRIPTION_SUCCESS_PAGE_TITLE);
        // check if selected subscription is met
        myAccountPage.loadPage();
        Assert.assertTrue(offerToSelect.contains(myAccountPage.getPlan().toLowerCase()));
    }

    @Test(description = "Step 2 - lessonp-5253:Step2 Static - User supplies invalid/valid form data")
    public void testLessonp_5253() {
        lpHomePage.loadPage();
        headerPage.clickOnTryItFree(true);
        stepOnePage.typeEmail(TestData.GET_NEW_EMAIL());
        stepOnePage.typePassword(TestData.VALID_PASSWORD);
        stepOnePage.clickOnGetFreeTrialButton();

        //check errors for invalid Card number, Expiration date and Cvv error
        stepTwoPage.typeCardNumber(TestData.INVALID_CARD_NUMBER);
        stepTwoPage.typeExpiration(TestData.INVALID_CARD_EXPIRATION);
        stepTwoPage.typeCvv(TestData.INVALID_CARD_CVV);
        stepTwoPage.clickOnStartMembership();
        Assert.assertEquals(TestData.INVALID_CARD_NUMBER_ERROR_MESSAGE, stepTwoPage.getCardNumberError());
        Assert.assertEquals(TestData.INVALID_CARD_EXPIRATION_ERROR_MESSAGE, stepTwoPage.getExpirationError());
        Assert.assertEquals(TestData.INVALID_CARD_CVV_ERROR_MESSAGE, stepTwoPage.getCvvError());
        stepTwoPage.clearCardNumber();
        stepTwoPage.clearExpiration();
        stepTwoPage.clearCvv();

        stepTwoModal.clickOnStartMembership();
        // All 6 errors should be displayed
        Assert.assertEquals(stepTwoPage.getFirstNameError(), TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE);
        Assert.assertEquals(stepTwoPage.getLastNameError(), TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE);
        Assert.assertEquals(stepTwoPage.getCardNumberError(), TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE);
        Assert.assertEquals(stepTwoPage.getExpirationError(), TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE);
        Assert.assertEquals(stepTwoPage.getCvvError(), TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE);
        Assert.assertEquals(stepTwoPage.getZipCodeError(), TestData.THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE);

        stepTwoPage.typeFirstName(TestData.FIRSTNAME);
        stepTwoPage.typeLastName(TestData.LASTNAME);
        stepTwoPage.typeCardNumber(TestData.CARD_NUMBER);
        stepTwoPage.typeExpiration(TestData.CARD_EXPIRATION);
        stepTwoPage.typeCvv(TestData.CARD_CVV);
        stepTwoPage.typeZipCode(TestData.ZIP_CODE);

        final String offerToSelect = getRandomOffer();
        stepTwoPage.selectOffer(offerToSelect);

        stepTwoPage.clickOnStartMembership();
        Assert.assertEquals(subscriptionSuccessPage.getTitle(), TestData.SUBSCRIPTION_SUCCESS_PAGE_TITLE);
        // check if selected subscription is met
        myAccountPage.loadPage();
        Assert.assertTrue(offerToSelect.contains(myAccountPage.getPlan().toLowerCase()));
    }

    private String getRandomOffer() {
        String[] offers = {TestData.PLAN_STARTER, TestData.PLAN_PRO};
        Random random = new Random();
        int randomNumber = random.nextInt(offers.length);
        return offers[randomNumber];
    }
}
