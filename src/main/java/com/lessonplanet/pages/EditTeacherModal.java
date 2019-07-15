package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class EditTeacherModal extends EditDistrictModal {

    private static final String FIRST_NAME_INPUT = "[name='firstname']";
    private static final String LAST_NAME_INPUT = "[name='lastname']";
    private static final String EMAIL_INPUT = "div.row:nth-child(2) [class='form-control']";
    private static final String ERROR_TEXT = "[class*='has-error'] [class*='help-block']";

    public EditTeacherModal(WebDriver driver) {
        super(driver);
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
        clearText(EMAIL_INPUT);
    }

    public String getErrorText() {
        return getTextForElement(ERROR_TEXT);
    }
}
