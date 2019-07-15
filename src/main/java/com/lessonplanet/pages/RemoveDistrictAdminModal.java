package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class RemoveDistrictAdminModal extends AddADistrictAdminModal {

    private static final String MODAL_TEXT = "[class='content']";

    public RemoveDistrictAdminModal(WebDriver driver) {
        super(driver);
    }

    public String getModalText() {
        return getTextForElement(MODAL_TEXT);
    }

    public void clickOnRemoveButton() {
        clickElement(CONFIRMATION_BUTTON);
    }
}
