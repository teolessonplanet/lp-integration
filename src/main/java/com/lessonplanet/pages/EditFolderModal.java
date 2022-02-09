package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class EditFolderModal extends EditFolder {
    private static final String EDIT_FOLDER_MODAL = "#edit-collection-modal";
    private static final String CLOSE_BUTTON = "#edit-collection-modal [class*='edit-collection-modal-close']";

    public EditFolderModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(EDIT_FOLDER_MODAL);
    }

    public void clickOnCloseButton() {
        clickElement(CLOSE_BUTTON);
    }
}
