package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class PublishedFolderModal extends LpUiBasePage {

    public static final String CLOSE_BUTTON = "#collection-share-thanks-modal button[class$='btn-success']";

    public PublishedFolderModal(WebDriver driver) {
        super(driver);
    }

    public void clickOnCloseButton() {
        clickElement(CLOSE_BUTTON);
    }
}
