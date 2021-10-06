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

    public void clickOnStartMembership() {
        clickElement(START_MEMBERSHIP_BUTTON);
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
                logger.error("No option is selected");
                break;
        }
    }
}
