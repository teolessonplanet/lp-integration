package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CollectionNotPublishedModal extends LpUiBasePage {

    private static final String COLLECTION_NOT_PUBLISHED_MODAL = "#empty-collection-modal";
    private static final String COLLECTION_NOT_PUBLISHED_MODAL_TITLE = "#empty-collection-modal h3";
    private static final String COLLECTION_NOT_PUBLISHED_MODAL_TEXT = "#empty-collection-modal [class='modal-body'] [class='mb20']";
    private static final String OK_BUTTON = "#empty-collection-modal [class*='btn btn-primary']";

    public CollectionNotPublishedModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(COLLECTION_NOT_PUBLISHED_MODAL);
    }

    public String getModalTitle(){
        return getTextForElement(COLLECTION_NOT_PUBLISHED_MODAL_TITLE);
    }

    public String getModalText() {
        return getTextForElement(COLLECTION_NOT_PUBLISHED_MODAL_TEXT);
    }

    public void clickOnOkButton(){
        clickElement(OK_BUTTON);
    }
}
