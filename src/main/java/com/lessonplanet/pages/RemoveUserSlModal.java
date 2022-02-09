package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public abstract class RemoveUserSlModal extends LpUiBasePage {

    private static final String MODAL_TEXT = "[class='content']";
    private static final String REMOVE_BUTTON = "[class='lp-button lp-small-button lp-orange-button']";

    public RemoveUserSlModal(WebDriver driver) {
        super(driver);
    }

    public String getModalText() {
        return getTextForElement(MODAL_TEXT);
    }

    public void clickOnRemoveButton() {
        clickElement(REMOVE_BUTTON);
    }
}
