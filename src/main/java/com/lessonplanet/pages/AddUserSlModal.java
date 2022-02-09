package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public abstract class AddUserSlModal extends LpUiBasePage {

    private static final String EMAIL_INPUT = "[class='form-control']";
    private static final String ERROR_NOTIFICATION_TEXT = "[class='help-block error-message']";
    private static final String ADD_BUTTON = "[class='lp-button lp-small-button lp-orange-button']";

    public AddUserSlModal(WebDriver driver) {
        super(driver);
    }

    public void typeEmail(String email) {
        sendKeys(EMAIL_INPUT, email);
    }

    public void clearEmail() {
        clearTextUsingActions(EMAIL_INPUT);
    }

    public void waitForNotificationToBeDisplayed(String text) {
        waitUntilTextIsDisplayed(ERROR_NOTIFICATION_TEXT, text);
    }

    public void clickOnAddButton() {
        clickElement(ADD_BUTTON);
    }
}
