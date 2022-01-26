package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class EditTeacherModal extends EditDistrictModal {

    private static final String FIRST_NAME_INPUT = "[name='firstname']";
    private static final String LAST_NAME_INPUT = "[name='lastname']";
    private static final String EMAIL_INPUT = "[name='email']";
    private static final String ERROR_TEXT = "[class*='has-error'] [class*='help-block']";
    private static final String PUBLISH_CHECKBOX = "[name='site_license_publisher']";
    private static final String TEACHER_ROLE = "[name='site_license_teacher']";
    private static final String SCHOOL_ADMIN_ROLE = "[name='site_license_school_admin']";
    private static final String DISTRICT_ADMIN_ROLE = "[name='site_license_district_admin']";

    public EditTeacherModal(WebDriver driver) {
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

    public boolean isTeacherRoleChecked() {
        return getElementAttribute(TEACHER_ROLE, "checked").equals("true");
    }

    public boolean isSchoolAdminRoleChecked() {
        return getElementAttribute(SCHOOL_ADMIN_ROLE, "checked").equals("true");
    }

    public boolean isDistrictAdminRoleChecked() {
        return getElementAttribute(DISTRICT_ADMIN_ROLE, "checked").equals("true");
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

    public void clickPublishCheckbox() {
        clickElement(PUBLISH_CHECKBOX);
    }

    public boolean isPublishCheckboxChecked() {
        waitForModal();
        return getElementAttribute(PUBLISH_CHECKBOX, "checked", 0).equals("true");
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

    public boolean isTeacherRoleDisabled() {
        return getElementAttribute(TEACHER_ROLE, "disabled", 0).equals("true");
    }

    public boolean isSchoolAdminRoleDisabled() {
        return getElementAttribute(SCHOOL_ADMIN_ROLE, "disabled", 0).equals("true");
    }

    public boolean isDistrictAdminRoleDisabled() {
        return getElementAttribute(DISTRICT_ADMIN_ROLE, "disabled", 0).equals("true");
    }
}
