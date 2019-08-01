package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;
import org.openqa.selenium.WebElement;

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

    public StepTwoPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return getTextForElement(TITLE_TEXT);
    }

    public void typeFirstName(String firstName) {
        sendKeys(FIRSTNAME_INPUT, firstName);
    }

    public void typeLastName(String lastName) {
        sendKeys(LASTNAME_INPUT, lastName);
    }

    public void typeCardNumber(String cardNumber) {
        sendKeys(CARD_NUMBER_INPUT, cardNumber);
    }

    public void typeExpiration(String expiration) {
        sendKeys(EXPIRATION_INPUT, expiration);
    }

    public void typeCvv(String cvv) {
        sendKeys(CVV_INPUT, cvv);
    }

    public void typeZipCode(String zipCode) {
        sendKeys(ZIPCODE_INPUT, zipCode);
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
}
