package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class EditSlUserModal extends LpUiBasePage {

    private static final String FIRST_NAME_INPUT = "[name='firstname']";
    private static final String LAST_NAME_INPUT = "[name='lastname']";
    private static final String EMAIL_INPUT = "[name='email']";
    private static final String ERROR_TEXT = "[class*='has-error'] [class*='help-block']";
    private static final String PUBLISH_CHECKBOX = "[name='site_license_publisher']";
    protected static final String TEACHER_ROLE = "[name='site_license_teacher']";
    protected static final String SCHOOL_ADMIN_ROLE = "[name='site_license_school_admin']";
    protected static final String DISTRICT_ADMIN_ROLE = "[name='site_license_district_admin']";
    private static final String SAVE_BUTTON = "[class='lp-button lp-small-button lp-orange-button']";
    private static final String CANCEL_BUTTON = "[class='lp-button lp-small-button lp-white-button']";

    public EditSlUserModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForReactModalToBeVisible();
    }

    public void typeFirstName(String name) {
        clearText(FIRST_NAME_INPUT);
        sendKeys(FIRST_NAME_INPUT, name);
    }

    public void typeLastName(String name) {
        clearText(LAST_NAME_INPUT);
        sendKeys(LAST_NAME_INPUT, name);
    }

    public void typeEmail(String email) {
        sendKeys(EMAIL_INPUT, email);
    }

    public void clearEmail() {
        clearTextUsingActions(EMAIL_INPUT);
    }

    public String getErrorText() {
        return getTextForElement(ERROR_TEXT);
    }

    public boolean isEmailFieldDisabled() {
        waitForModal();
        return getElementAttribute(EMAIL_INPUT, "disabled", 0).equals("true");
    }

    public boolean isFirstNameFieldDisabled() {
        waitForModal();
        return getElementAttribute(FIRST_NAME_INPUT, "disabled", 0).equals("true");
    }

    public boolean isLastNameFieldDisabled() {
        waitForModal();
        return getElementAttribute(LAST_NAME_INPUT, "disabled", 0).equals("true");
    }

    public void clickOnPublishCheckbox() {
        clickElement(PUBLISH_CHECKBOX);
    }

    public boolean isPublishCheckboxChecked() {
        waitForModal();
        return getElementAttribute(PUBLISH_CHECKBOX, "checked", 0).equals("true");
    }

    public void clickOnCancelButton() {
        clickElement(CANCEL_BUTTON);
    }

    public void clickOnSaveButton() {
        clickElement(SAVE_BUTTON);
    }
}
