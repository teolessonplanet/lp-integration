package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CollectionRrpModal extends RrpModal {

    private static final String COLLECTION_TITLE_TEXT = "div h1";

    public CollectionRrpModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitUntilAnimationIsDone(COLLECTION_TITLE_TEXT);
    }

    public boolean isCollectionTitleDisplayed() {
        waitForModal();
        return isElementClickable(COLLECTION_TITLE_TEXT);
    }
}
