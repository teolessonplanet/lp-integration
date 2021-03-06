package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import logs.Log;
import util.TestData;

public class LoginPage extends LpUiBasePage {

    private static final String EMAIL_INPUT = "#user_login";
    private static final String PASSWORD_INPUT = "#user_password";
    private static final String SIGN_IN_BUTTON = "input[class='btn btn-action']";
    private static final String CONTENT_ALERT_MESSAGE = "[class*='alert-dismissable']";

    private static final String STAGING_LOGIN_URL = "https://staging.lessonplanet.com/users/auto/login?user_email=";

    private HeaderPage headerPage;

    public LoginPage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
    }

    public void loadPage() {
        loadUrl(TestData.LOGIN_PAGE_PATH);
    }

    public void typeEmail(String email) {
        sendKeys(EMAIL_INPUT, email);
    }

    public void typePassword(String password) {
        sendKeys(PASSWORD_INPUT, password);
    }

    public void clickOnSignInButton() {
        clickElement(SIGN_IN_BUTTON);
    }

    public String getContentAlertMessage() {
        return getTextForElement(CONTENT_ALERT_MESSAGE);
    }

    /**
     * Accesses the login page, performs the login, verifies the login and after that it returns to the original URL
     */
    public void performLogin(String email, String password) {
        if (getUrl().equals(TestData.EMPTY_URL)) {
            loadUrl(TestData.LP_HOME_PAGE_PATH);
        }
        boolean loggedIn = false;

        if (STAGING_LOGIN_URL.startsWith(TestData.SERVER_URL)) {
            driver.get(STAGING_LOGIN_URL + email);
            if (headerPage.isUsernameDropDownDisplayed()) {
                Log.info("Successful login via endpoint");
                loggedIn = true;
            }
        }

        if (!loggedIn || !STAGING_LOGIN_URL.startsWith(TestData.SERVER_URL)) {
            final String path = getPath();
            loadPage();
            typeEmail(email);
            typePassword(password);
            clickOnSignInButton();
            if (headerPage.isUsernameDropDownDisplayed()) {
                Log.info("Successful login via UI");
                loadUrl(path);
            } else {
                throw new Error("Invalid login error with: " + email + ":" + password);
            }
        }
    }
}
