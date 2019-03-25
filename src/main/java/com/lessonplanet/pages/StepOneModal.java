package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class StepOneModal extends LpUiBasePage {
    private static final String STEP_ONE_MODAL = "#signup-modal";
    private static final String TITLE_TEXT = "#signup-modal [class='title']";
    private static final String EMAIL_INPUT = "#user_email";
    private static final String PASSWORD_INPUT = "#user_password";
    private static final String SEND_COMMUNICATIONS_CHECKBOX = "#signup-send-communications";
    private static final String GET_STARTED_TODAY_BUTTON = "#submit-signup";
    private static final String CLOSE_MODAL_BUTTON = "[class*='text-center'] [class='close']";

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
    }

    public String getErrorMessage() {
        return getTextForElement(EMAIL_ERROR_MESSAGE);
    }

    public boolean isTitleTextDisplayed() {
        waitForBootstrapModalToBeVisible(STEP_ONE_MODAL);
        return isElementClickable(TITLE_TEXT);
    }

    public void clickCloseModal() {
        clickElement(CLOSE_MODAL_BUTTON);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(STEP_ONE_MODAL);
    }

    public String getTitleText(){
        return getTextForElement(TITLE_TEXT);
    }
}
