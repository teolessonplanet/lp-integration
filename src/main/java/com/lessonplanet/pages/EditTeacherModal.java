package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class EditTeacherModal extends EditDistrictModal {

    private static final String FIRST_NAME_INPUT = "[name='firstname']";
    private static final String LAST_NAME_INPUT = "[name='lastname']";
    private static final String EMAIL_INPUT = "div.row:nth-child(2) [class='form-control']";
    private static final String ERROR_TEXT = "[class*='has-error'] [class*='help-block']";
    private static final String PUBLISHING_OPTION_INFO_ICON = "[class='form-group publishing'] [class*='popup']";
    private static final String PUBLISHING_OPTION_INFO_ICON_POPOVER_TEXT = "[class='form-group publishing'] [class*='popup'] [class*='popuptext']";
    private static final String PUBLISH_CHECKBOX = "[name='can_publish']";
    private static final String PUBLISH_OPTION_TEXT = "[class='form-group publishing'] div div";

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

    public void hoverOverPublishingOptionInfoIcon() {
        hoverOverElement(PUBLISHING_OPTION_INFO_ICON, true);
    }

    public String getPublishingOptionInfoIconPopoverText() {
        return getTextForElement(PUBLISHING_OPTION_INFO_ICON_POPOVER_TEXT);
    }

    public boolean isPublishCheckboxDisplayed() {
        return isElementDisplayed(PUBLISH_CHECKBOX);
    }

    public String getPublishOptionText() {
        return getTextForElement(PUBLISH_OPTION_TEXT);
    }

    public void clickPublishCheckbox() {
        clickElement(PUBLISH_CHECKBOX);
    }

    public boolean isPublishCheckboxChecked() {
        String emailAttribute = getElementAttribute(PUBLISH_CHECKBOX, "checked", 0);
        return emailAttribute.equals("true");
    }

    public boolean isEmailFieldDisabled() {
        String emailAttribute = getElementAttribute(EMAIL_INPUT, "disabled", 0);
        return emailAttribute.equals("true");
    }

    public boolean isFirstNameFieldDisabled() {
        String emailAttribute = getElementAttribute(FIRST_NAME_INPUT, "disabled", 0);
        return emailAttribute.equals("true");
    }

    public boolean isLastNameFieldDisabled() {
        String emailAttribute = getElementAttribute(LAST_NAME_INPUT, "disabled", 0);
        return emailAttribute.equals("true");
    }
}
