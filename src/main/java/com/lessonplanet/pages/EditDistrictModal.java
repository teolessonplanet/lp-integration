package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class EditDistrictModal extends EditOrganizationModal {

    private static final String ORGANIZATION_NAME_INFO_ICON = "div.form-group:nth-child(1) [class*='popup']";
    private static final String ORGANIZATION_NAME_INFO_ICON_POPOVER_TEXT = "div.form-group:nth-child(1) [class*='popuptext']";

    public EditDistrictModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getOrganizationShortNameInput() {
        return getElementAttribute(ORGANIZATION_SHORT_NAME_INPUT, "value", 0);
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
}