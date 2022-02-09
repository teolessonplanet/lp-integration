package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class EditSchoolModal extends EditOrganizationModal {

    public EditSchoolModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getOrganizationShortNameInput() {
        return getElementAttribute(ORGANIZATION_SHORT_NAME_INPUT, "value", 0);
    }

    public void typeSchoolName(String name) {
        sendKeys(ORGANIZATION_NAME_INPUT, name);
    }

    public void clearSchoolName() {
        clearTextUsingActions(ORGANIZATION_NAME_INPUT);
    }

    public String getSchoolName() {
        return getElementAttribute(ORGANIZATION_NAME_INPUT, "value", 0);
    }
}
