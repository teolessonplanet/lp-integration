package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class ConfirmShareUploadModal extends LpUiBasePage {

    private static final String PUBLISH_COLLECTION_BUTTON = "#confirm-share-uploads-modal [class='modal-body'] #share-private-submit";
    private static final String MODAL_TEXT = "#confirm-share-uploads-modal [class='modal-body'] h4";

    public ConfirmShareUploadModal(WebDriver driver) {
        super(driver);
    }

    public String getModalText() {
        return getTextForElement(MODAL_TEXT);
    }

    public void clickOnPublishCollectionButton() {
        clickElement(PUBLISH_COLLECTION_BUTTON);
    }
}
