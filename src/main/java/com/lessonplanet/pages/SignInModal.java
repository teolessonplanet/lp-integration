package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class SignInModal extends LpUiBasePage {
    private static final String SIGN_IN_MODAL = "#login-modal";
    private static final String MODAL_TITLE = "h4[class='modal-title']";
    private static final String CLOSE_BUTTON = "[class='close']";
    private static final String EMAIL_INPUT = "#login-modal #user_login";
    private static final String PASSWORD_INPUT = "#login-modal #user_password";
    private static final String SIGN_IN_BUTTON = "#login-modal [value='Sign in']";

    public SignInModal(WebDriver driver) {
        super(driver);
    }

    public String getModalTitle() {
        waitForBootstrapModalToBeVisible(SIGN_IN_MODAL);
        return getTextForElement(MODAL_TITLE);
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

    public void clickOnClose() {
        clickElement(CLOSE_BUTTON);
    }
}
