package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class EditSchoolModal extends EditDistrictModal {

    public EditSchoolModal(WebDriver driver) {
        super(driver);
    }

    public void typeSchoolName(String name) {
        sendKeys(ORGANIZATION_NAME_INPUT, name);
    }

    public void clearSchoolName() {
        clearText(ORGANIZATION_NAME_INPUT);
    }

    public String getSchoolName() {
        return getElementAttribute(ORGANIZATION_NAME_INPUT, "value", 0);
    }
}
