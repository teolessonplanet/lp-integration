package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class LoginPage extends LpUiBasePage {

    private static final String EMAIL_INPUT = "#user_login";
    private static final String PASSWORD_INPUT = "#user_password";
    private static final String SIGN_IN_BUTTON = "input[class='btn btn-action']";
    private static final String CONTENT_ALERT_MESSAGE = "[class*='alert-dismissable']";

    public LoginPage(WebDriver driver) {
        super(driver);
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
        return findElement(CONTENT_ALERT_MESSAGE).getText();
    }

    /**
     * Accesses the login page, performs the login and after that it returns to the original URL
     */
    public void performLogin(String email, String password) {
        final String path = getPath();
        loadPage();
        typeEmail(email);
        typePassword(password);
        clickOnSignInButton();
        loadUrl(path);
    }
}
