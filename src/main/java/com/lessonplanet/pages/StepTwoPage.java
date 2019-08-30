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

    public String createNewAccount(String accountType) {
        final String email = TestData.GET_NEW_EMAIL();
        boolean accountCreated = false;

        if (STAGING_CREATE_USER_URL.startsWith(TestData.SERVER_URL)) {
            switch (accountType) {
                case TestData.STARTER_OPTION_TEXT:
                    driver.get(String.format(STAGING_CREATE_USER_URL, "starter_24", email));
                    break;
                case TestData.PRIME_OPTION_TEXT:
                    driver.get(String.format(STAGING_CREATE_USER_URL, "prime_36", email));
                    break;
                case TestData.PRO_OPTION_TEXT:
                    driver.get(String.format(STAGING_CREATE_USER_URL, "pro_72_yr", email));
                    break;
                default:
                    driver.get(String.format(STAGING_CREATE_USER_URL, "freemium", email));
                    lpHomePage.loadPage();
                    break;
            }
            if (headerPage.isUsernameDropDownDisplayed()) {
                logger.info("Account created via endpoint");
                accountCreated = true;
            }
        }

        if (!accountCreated || !STAGING_CREATE_USER_URL.startsWith(TestData.SERVER_URL)) {
            if (getUrl().equals(TestData.LP_HOME_PAGE_PATH) || getUrl().equals(TestData.EMPTY_URL)) {
                lpHomePage.loadPage();
            }
            stepOnePage.completeStepOne(email, TestData.VALID_PASSWORD);
            if (accountType.equals(TestData.STARTER_OPTION_TEXT) || accountType.equals(TestData.PRIME_OPTION_TEXT) || accountType.equals(TestData.PRO_OPTION_TEXT)) {
                final String currentPath = getPath();
                loadPage();
                completeStepTwoPageWith(accountType);
                loadUrl(currentPath);
            }
            logger.info("Account created via UI");
        }
        return email;
    }
}
