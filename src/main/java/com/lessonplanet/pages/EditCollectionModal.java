package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class EditCollectionModal extends EditCollection {
    private static final String EDIT_COLLECTION_MODAL = "#edit-collection-modal";
    private static final String CLOSE_BUTTON = "#edit-collection-modal [class*='edit-collection-modal-close']";

    public EditCollectionModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(EDIT_COLLECTION_MODAL);
    }

    public void clickOnCloseButton() {
        clickElement(CLOSE_BUTTON);
    }
}
