package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class ConfirmShareFolderModal extends LpUiBasePage {

    private static final String CONTINUE_BUTTON = "#confirm-publish-without-folders [class*='btn-success confirm']";
    private static final String MODAL_TEXT = "#confirm-publish-without-folders [class='mb20']";

    public ConfirmShareFolderModal(WebDriver driver) {
        super(driver);
    }

    public String getModalText() {
        return getTextForElement(MODAL_TEXT);
    }

    public void clickOnContinueButton() {
        clickElement(CONTINUE_BUTTON);
    }
}
