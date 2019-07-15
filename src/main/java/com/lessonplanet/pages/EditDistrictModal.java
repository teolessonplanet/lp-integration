package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class EditDistrictModal extends AddADistrictAdminModal {

    protected static final String ORGANIZATION_NAME_INPUT = "div.form-group:nth-child(1) [class='form-control']";
    private static final String ORGANIZATION_NAME_INFO_ICON = "div.form-group:nth-child(1) [class*='popup']";
    private static final String ORGANIZATION_NAME_INFO_ICON_POPOVER_TEXT = "div.form-group:nth-child(1) [class*='popuptext']";
    private static final String ORGANIZATION_SHORT_NAME_INPUT = "div.form-group:nth-child(2) [class='form-control']";
    private static final String ORGANIZATION_SHORT_NAME_INFO_ICON = "div.form-group:nth-child(2) [class*='popup']";
    private static final String ORGANIZATION_SHORT_NAME_INFO_ICON_POPOVER_TEXT = "div.form-group:nth-child(2) [class*='popuptext']";
    private static final String X_BUTTON = "[class='close']";

    public EditDistrictModal(WebDriver driver) {
        super(driver);
    }

    public String getDistrictName() {
        return getElementAttribute(ORGANIZATION_NAME_INPUT, "value", 0);
    }

    public void hoverOverDistrictNameInfoIcon() {
        hoverOverElement(ORGANIZATION_NAME_INFO_ICON);
    }

    public String getDistrictNameInfoIconPopoverText() {
        return getTextForElement(ORGANIZATION_NAME_INFO_ICON_POPOVER_TEXT);
    }

    public String getDistrictShortName() {
        return getElementAttribute(ORGANIZATION_SHORT_NAME_INPUT, "value", 0);
    }

    public void typeOrganizationShortName(String name) {
        clearText(ORGANIZATION_SHORT_NAME_INPUT);
        sendKeys(ORGANIZATION_SHORT_NAME_INPUT, name);
    }

    public void hoverOverOrganizationShortNameInfoIcon() {
        hoverOverElement(ORGANIZATION_SHORT_NAME_INFO_ICON, true);
    }

    public String getOrganizationShortNameInfoIconPopoverText() {
        return getTextForElement(ORGANIZATION_SHORT_NAME_INFO_ICON_POPOVER_TEXT);
    }

    public void clickXButton() {
        clickElement(X_BUTTON);
    }

    public void clickOnSaveButton() {
        clickElement(CONFIRMATION_BUTTON);
    }
}
