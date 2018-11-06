package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CollectionRrpModal extends RrpModal {
    
    private static final String COLLECTION_TITLE_TEXT = "div h1";
    private static final String RRP_MODAL = "#resource-modal";

    public CollectionRrpModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(RRP_MODAL);
    }

    public boolean isCollectionTitleDisplayed() {
        waitForModal();
        return isElementDisplayed(COLLECTION_TITLE_TEXT);
    }
}
