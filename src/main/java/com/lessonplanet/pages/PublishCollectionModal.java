package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class PublishCollectionModal extends LpUiBasePage {

    private static final String PUBLISH_COLLECTION_MODAL = "#share-collection-modal";
    private static final String CLOSE_BUTTON = "[class*='btn-modal-green']";

    public PublishCollectionModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(PUBLISH_COLLECTION_MODAL);
    }

    public void clickOnCloseButton() {
        clickElement(CLOSE_BUTTON);
    }
}
