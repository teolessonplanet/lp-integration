package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CollectionCreatedModal extends LpUiBasePage {

    private static final String COLLECTION_CREATED_MODAL = "#share-collection-modal";
    private static final String TITLE_TEXT = COLLECTION_CREATED_MODAL + " [class='modal-header'] h3";
    private static final String SUBMIT_BUTTON = COLLECTION_CREATED_MODAL + " #share-unit-submit";

    public CollectionCreatedModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(COLLECTION_CREATED_MODAL);
    }

    public String getTitle() {
        waitForBootstrapModalToBeVisible(COLLECTION_CREATED_MODAL);
        return getTextForElement(TITLE_TEXT);
    }

    public void clickOnSubmitButton() {
        waitForBootstrapModalToBeVisible(COLLECTION_CREATED_MODAL);
        findElement(SUBMIT_BUTTON);
        clickElement(SUBMIT_BUTTON);
        waitForLoad();
    }
}
