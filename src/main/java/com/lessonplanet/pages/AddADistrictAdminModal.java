package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class AddADistrictAdminModal extends LpUiBasePage {

    protected static final String CONFIRMATION_BUTTON = "[class='lp-button lp-small-button lp-orange-button']";
    protected static final String TEXT_INPUT = "[class='form-control']";
    private static final String ERROR_NOTIFICATION_TEXT = "[class='help-block error-message']";
    private static final String CANCEL_BUTTON = "[class='lp-button lp-small-button lp-white-button']";

    public AddADistrictAdminModal(WebDriver driver) {
        super(driver);
    }

    public void typeEmail(String email) {
        sendKeys(TEXT_INPUT, email);
    }

    public void clearEmail() {
        clearTextUsingActions(TEXT_INPUT);
    }

    public String getErrorText() {
        return getTextForElement(ERROR_NOTIFICATION_TEXT);
    }

    public void waitForNotificationToBeDisplayed(String text) {
        waitUntilTextIsDisplayed(ERROR_NOTIFICATION_TEXT, text);
    }

    public void clickOnAddButton() {
        clickElement(CONFIRMATION_BUTTON);
    }

    public void clickOnCancelButton() {
        clickElement(CANCEL_BUTTON);
    }
}
