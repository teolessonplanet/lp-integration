package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import logs.Log;
import util.TestData;
import org.openqa.selenium.WebElement;

import java.security.InvalidParameterException;
import java.util.List;

public class StepTwoPage extends LpUiBasePage {

    private static final String TITLE_TEXT = "[class='panel-title']";
    private static final String FIRSTNAME_INPUT = "#firstname";
    private static final String LASTNAME_INPUT = "#lastname";
    private static final String CARD_NUMBER_INPUT = "#cc_number";
    private static final String EXPIRATION_INPUT = "#cc_exp_month_yr";
    private static final String CVV_INPUT = "#cc_cvv";
    private static final String ZIPCODE_INPUT = "#postal_code";
    private static final String START_MEMBERSHIP_BUTTON = "input#js-submit-btn.btn.btn-success.btn-lg.pt15.pb15";
    private static final String SELECT_OFFER_BUTTON = "[class*='btn-offer']";
    private static final String ERROR_SUFFIX = "-error";

    private static final String STAGING_CREATE_USER_URL = "https://staging.lessonplanet.com/users/auto/create?user_type=%s&user_email=%s";

    private StepOnePage stepOnePage = new StepOnePage(driver);
    private LpHomePage lpHomePage = new LpHomePage(driver);
    private HeaderPage headerPage = new HeaderPage(driver);

    public StepTwoPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.STEP_TWO_PAGE_PATH);
    }

    public String getTitleText() {
        return getTextForElement(TITLE_TEXT);
    }

    public void typeFirstName(String firstName) {
        sendKeys(FIRSTNAME_INPUT, firstName);
    }

    public String getFirstNameError() {
        return getTextForElement(FIRSTNAME_INPUT + ERROR_SUFFIX);
    }

    public void typeLastName(String lastName) {
        sendKeys(LASTNAME_INPUT, lastName);
    }

    public String getLastNameError() {
        return getTextForElement(LASTNAME_INPUT + ERROR_SUFFIX);
    }

    public void typeCardNumber(String cardNumber) {
        sendKeys(CARD_NUMBER_INPUT, cardNumber);
    }

    public void clearCardNumber() {
        clearText(CARD_NUMBER_INPUT);
    }

    public String getCardNumberError() {
        return getTextForElement(CARD_NUMBER_INPUT + ERROR_SUFFIX);
    }

    public void typeExpiration(String expiration) {
        sendKeys(EXPIRATION_INPUT, expiration);
    }

    public void clearExpiration() {
        clearText(EXPIRATION_INPUT);
    }

    public String getExpirationError() {
        return getTextForElement(EXPIRATION_INPUT + ERROR_SUFFIX);
    }

    public void typeCvv(String cvv) {
        sendKeys(CVV_INPUT, cvv);
    }

    public void clearCvv() {
        clearText(CVV_INPUT);
    }

    public String getCvvError() {
        return getTextForElement(CVV_INPUT + ERROR_SUFFIX);
    }

    public void typeZipCode(String zipCode) {
        sendKeys(ZIPCODE_INPUT, zipCode);
    }

    public String getZipCodeError() {
        return getTextForElement(ZIPCODE_INPUT + ERROR_SUFFIX);
    }

    public void selectOffer(String offer) {
        List<WebElement> options = findElements(SELECT_OFFER_BUTTON);
        switch (offer) {
            case TestData.PLAN_STARTER:
                clickElement(options, 0);
                break;
            case TestData.PLAN_PRO:
                clickElement(options, 1);
                break;
            default:
                Log.error("No option is selected");
                break;
        }
    }

    public void clickOnStartMembership() {
        clickElement(START_MEMBERSHIP_BUTTON);
    }

    public void completeStepTwoPageWith(String offer) {
        typeFirstName(TestData.FIRSTNAME);
        typeLastName(TestData.LASTNAME);
        typeCardNumber(TestData.CARD_NUMBER);
        typeExpiration(TestData.CARD_EXPIRATION);
        typeCvv(TestData.CARD_CVV);
        typeZipCode(TestData.ZIP_CODE);
        selectOffer(offer);
        waitForPageLoad();
        clickOnStartMembership();
        waitForPageLoad();
    }

    public String createNewAccount(String accountPlan) throws InvalidParameterException {
        if (!(accountPlan.equals(TestData.PLAN_VISITOR) || accountPlan.equals(TestData.PLAN_FREEMIUM) || accountPlan.equals(TestData.PLAN_STARTER) ||  accountPlan.equals(TestData.PLAN_PRO))) {
            throw new InvalidParameterException("The plan " + accountPlan + " is not valid");
        }
        String email = TestData.GET_NEW_EMAIL();
        boolean accountCreated = false;

        if (!TestData.IP_IS_WHITELISTED) {
            lpHomePage.loadPage();
        }

        if (STAGING_CREATE_USER_URL.startsWith(TestData.SERVER_URL)) {
            if (accountPlan.equals(TestData.PLAN_FREEMIUM) || accountPlan.equals(TestData.PLAN_STARTER) || accountPlan.equals(TestData.PLAN_PRO)) {
                // creates freemium || starter || pro via endpoint
                driver.get(String.format(STAGING_CREATE_USER_URL, accountPlan, email));
                lpHomePage.loadPage();
                if (headerPage.isUsernameDropDownDisplayed()) {
                    Log.info("Account created via endpoint");
                    accountCreated = true;
                }
            } else {
                // we have visitor account
                lpHomePage.loadPage();
                email = null;
                accountCreated = true;
            }
        }

        if (!accountCreated || !STAGING_CREATE_USER_URL.startsWith(TestData.SERVER_URL)) {
            if (accountPlan.equals(TestData.PLAN_FREEMIUM) || accountPlan.equals(TestData.PLAN_STARTER) || accountPlan.equals(TestData.PLAN_PRO)) {
                if (getUrl().equals(TestData.LP_HOME_PAGE_PATH) || getUrl().equals(TestData.EMPTY_URL)) {
                    lpHomePage.loadPage();
                }
                stepOnePage.completeStepOne(email, TestData.VALID_PASSWORD);
                if (accountPlan.equals(TestData.PLAN_STARTER) || accountPlan.equals(TestData.PLAN_PRO)) {
                    final String currentPath = getPath();
                    loadPage();
                    completeStepTwoPageWith(accountPlan);
                    loadUrl(currentPath);
                }
                Log.info("Account created via UI");
            } else {
                // we have visitor account
                email = null;
            }
        }
        return email;
    }
}
