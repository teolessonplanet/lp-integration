package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class StepOneModal extends LpUiBasePage {
    private static final String EMAIL_INPUT = "#user_email";
    private static final String PASSWORD_INPUT = "#user_password";
    private static final String SEND_COMMUNICATIONS_CHECKBOX = "#signup-send-communications";
    private static final String GET_STARTED_TODAY_BUTTON = "#submit-signup";
    private static final String CLOSE_MODAL_BUTTON = "[class='close']";

    private static final String EMAIL_ERROR_MESSAGE = "#user_email-error";

    public StepOneModal(WebDriver driver) {
        super(driver);
    }

    public void typeEmail(String email) {
        sendKeys(EMAIL_INPUT, email);
    }

    public void typePassword(String password) {
        sendKeys(PASSWORD_INPUT, password);
    }

    public void clickOnGetStartedToday() {
        clickElement(GET_STARTED_TODAY_BUTTON);
        waitForPageLoad();
    }

    public String getErrorMessage() {
        return findElement(EMAIL_ERROR_MESSAGE).getText();
    }
}
