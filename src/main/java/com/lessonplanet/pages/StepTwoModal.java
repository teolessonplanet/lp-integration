package com.lessonplanet.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

import java.util.List;

public class StepTwoModal extends LpHomePage {
    private static final String STEP_TWO_MODAL = "#step2-modal";
    private static final String TITLE_TEXT = "[class*='modal-header'] h3";
    private static final String CLOSE_MODAL_BUTTON = "[class*='button close']";

    private static final String SELECT_OFFER_BUTTON = "[class*='btn-offer']";

    private static final String FIRSTNAME_INPUT = "#firstname";
    private static final String LASTNAME_INPUT = "#lastname";
    private static final String CARD_NUMBER_INPUT = "#cc_number";
    private static final String EXPIRATION_INPUT = "#cc_exp_month_yr";
    private static final String CVV_INPUT = "#modal_cc_cvv";
    private static final String ZIPCODE_INPUT = "#modal_postal_code";
    private static final String ERROR_SUFFIX = "-error";
    private static final String START_MEMBERSHIP_BUTTON = "#js-submit-btn";

    private static final String BILLING_TERMS_TEXT = "#js-billing-terms";

    private static final Logger logger = LogManager.getRootLogger();

    public StepTwoModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(STEP_TWO_MODAL);
    }

    public String getTitleText() {
        waitForModal();
        return getTextForElement(TITLE_TEXT);
    }

    public void clickOnCloseModal() {
        clickElement(CLOSE_MODAL_BUTTON);
    }

    public void typeFirstName(String firstName) {
        sendKeys(FIRSTNAME_INPUT, firstName);
    }

    public String getFirstNameError() {
        return getTextForElement(FIRSTNAME_INPUT + ERROR_SUFFIX);
    }

    public boolean isFirstNameErrorDisplayed() {
        return isElementClickable(FIRSTNAME_INPUT + ERROR_SUFFIX);
    }

    public void typeLastName(String lastName) {
        sendKeys(LASTNAME_INPUT, lastName);
    }

    public String getLastNameError() {
        return getTextForElement(LASTNAME_INPUT + ERROR_SUFFIX);
    }

    public boolean isLastNameErrorDisplayed() {
        return isElementClickable(LASTNAME_INPUT + ERROR_SUFFIX);
    }

    public void typeCardNumber(String cardNumber) {
        sendKeys(CARD_NUMBER_INPUT, cardNumber);
    }

    public void clearCardNumber() {
        clearText(CARD_NUMBER_INPUT);
    }

    public boolean isCardNumberErrorDisplayed() {
        return isElementClickable(CARD_NUMBER_INPUT + ERROR_SUFFIX);
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

    public boolean isExpirationErrorDispplayed() {
        return isElementClickable(EXPIRATION_INPUT + ERROR_SUFFIX);
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

    public boolean isCvvErrorDisplayed() {
        return isElementClickable(CVV_INPUT + ERROR_SUFFIX);
    }

    public String getCvvError() {
        return getTextForElement(CVV_INPUT + ERROR_SUFFIX);
    }

    public void typeZipCode(String zipCode) {
        sendKeys(ZIPCODE_INPUT, zipCode);
    }

    public boolean isZipCodeErrorDispplayed() {
        return isElementClickable(ZIPCODE_INPUT + ERROR_SUFFIX);
    }

    public String getZipCodeError() {
        return getTextForElement(ZIPCODE_INPUT + ERROR_SUFFIX);
    }

    public void clickOnStartMembership() {
        clickElement(START_MEMBERSHIP_BUTTON);
    }

    public String getSelectedOption() {
        List<WebElement> options = findElements(SELECT_OFFER_BUTTON);
        int index = 3;
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equals(TestData.SELECTED_TEXT)) {
                index = i;
                break;
            }
        }
        switch (index) {
            case 0:
                return TestData.STARTER_OPTION_TEXT;
            case 1:
                return TestData.PRIME_OPTION_TEXT;
            case 2:
                return TestData.PRO_OPTION_TEXT;
            default:
                logger.error("No option is selected");
                return "";
        }
    }

    public void selectOffer(String offer) {
        List<WebElement> options = findElements(SELECT_OFFER_BUTTON);
        switch (offer) {
            case TestData.STARTER_OPTION_TEXT:
                clickElement(options, 0);
                break;
            case TestData.PRIME_OPTION_TEXT:
                clickElement(options, 1);
                break;
            case TestData.PRO_OPTION_TEXT:
                clickElement(options, 2);
                break;
            default:
                logger.error("No option is selected");
                break;
        }
    }

    public void deleteFistNameField() {
        findElement(FIRSTNAME_INPUT).clear();
    }

    public String getBillingTermsText() {
        return getTextForElement(BILLING_TERMS_TEXT);
    }

    public void completeStepTwoModalWith(String offer) {
        waitForModal();
        typeFirstName(TestData.FIRSTNAME);
        typeLastName(TestData.LASTNAME);
        typeCardNumber(TestData.CARD_NUMBER);
        typeExpiration(TestData.CARD_EXPIRATION);
        typeCvv(TestData.CARD_CVV);
        typeZipCode(TestData.ZIP_CODE);
        selectOffer(offer);
        waitForPageLoad();
        clickOnStartMembership();
    }
}
