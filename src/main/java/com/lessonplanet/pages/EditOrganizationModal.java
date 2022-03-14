package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public abstract class EditOrganizationModal extends LpUiBasePage {

    protected static final String ORGANIZATION_NAME_INPUT = "div.form-group:nth-child(1) [class='form-control']";
    protected static final String ORGANIZATION_SHORT_NAME_INPUT = "div.form-group:nth-child(2) [class='form-control']";
    private static final String ORGANIZATION_SHORT_NAME_INFO_ICON = "div.form-group:nth-child(2) [class*='popup']";
    private static final String ORGANIZATION_SHORT_NAME_INFO_ICON_POPOVER_TEXT = "div.form-group:nth-child(2) [class*='popuptext']";
    private static final String ADMIN_PUBLISH_CHECKBOX = "[name='allow_all_admins_to_publish']";
    private static final String ADMIN_PUBLISH_OPTION_TEXT = "[class='form-group-inner']:nth-child(2)";
    private static final String TEACHER_PUBLISH_CHECKBOX = "[name='allow_all_teachers_to_publish']";
    private static final String TEACHER_PUBLISH_OPTION_TEXT = "[class='form-group-inner']:nth-child(3)";
    private static final String CONFIRMATION_BUTTON = "[class='lp-button lp-small-button lp-orange-button']";
    private static final String CANCEL_BUTTON = "[class='lp-button lp-small-button lp-white-button']";
    private static final String X_BUTTON = "[class='close']";

    public EditOrganizationModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForReactModalToBeVisible();
    }

    public void hoverOverOrganizationShortNameInfoIcon() {
        hoverOverElement(ORGANIZATION_SHORT_NAME_INFO_ICON, true);
    }

    public String getOrganizationShortNameInfoIconPopoverText() {
        return getTextForElement(ORGANIZATION_SHORT_NAME_INFO_ICON_POPOVER_TEXT);
    }

    public void typeOrganizationShortName(String name) {
        clearText(ORGANIZATION_SHORT_NAME_INPUT);
        sendKeys(ORGANIZATION_SHORT_NAME_INPUT, name);
    }

    public abstract String getOrganizationShortNameInput();

    public boolean isAdminPublishCheckboxDisplayed() {
        return isElementDisplayed(ADMIN_PUBLISH_CHECKBOX);
    }

    public String getAdminPublishOptionText() {
        return getTextForElement(ADMIN_PUBLISH_OPTION_TEXT);
    }

    public boolean isTeacherPublishCheckboxDisplayed() {
        return isElementDisplayed(TEACHER_PUBLISH_CHECKBOX);
    }

    public String getTeacherPublishOptionText() {
        return getTextForElement(TEACHER_PUBLISH_OPTION_TEXT);
    }

    public void clickOnTeacherPublishCheckbox() {
        clickElement(TEACHER_PUBLISH_CHECKBOX);
    }

    public boolean isAdminPublishCheckboxDisabled() {
        waitForModal();
        return getElementAttribute(ADMIN_PUBLISH_CHECKBOX, "disabled", 0).equals("true");
    }

    public boolean isTeacherPublishCheckboxDisabled() {
        waitForModal();
        return getElementAttribute(TEACHER_PUBLISH_CHECKBOX, "disabled", 0).equals("true");
    }

    public boolean isAdminPublishCheckboxChecked() {
        waitForModal();
        return getElementAttribute(ADMIN_PUBLISH_CHECKBOX, "checked", 0).equals("true");
    }

    public boolean isTeacherPublishCheckboxChecked() {
        waitForModal();
        return getElementAttribute(TEACHER_PUBLISH_CHECKBOX, "checked", 0).equals("true");
    }

    public void clickOnCancelButton() {
        clickElement(CANCEL_BUTTON);
    }

    public void clickOnXButton() {
        clickElement(X_BUTTON);
    }

    public void clickOnSaveButton() {
        clickElement(CONFIRMATION_BUTTON);
    }
}