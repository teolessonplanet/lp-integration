package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class ConfirmCopySharedFolderModal extends LpUiBasePage {
    private static final String CONTINUE_BUTTON = "[class='modal-footer'] [class*='btn-primary']";

    public ConfirmCopySharedFolderModal(WebDriver driver) {
        super(driver);
    }

    public void clickOnContinueButton() {
        clickElement(CONTINUE_BUTTON);
    }
}
