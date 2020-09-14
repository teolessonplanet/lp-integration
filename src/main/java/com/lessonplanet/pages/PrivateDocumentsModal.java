package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class PrivateDocumentsModal extends LpUiBasePage {

    private static final String PRIVATE_DOCUMENTS_MODAL_TITLE_TEXT = "#site-specific-confirm-publish-uploads-modal h3";
    private static final String PRIVATE_DOCUMENTS_MODAL = "#site-specific-confirm-publish-uploads-modal";
    private static final String CONTINUE_BUTTON = "#site-specific-confirm-publish-uploads-modal [class='btn btn-success confirm']";

    public PrivateDocumentsModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(PRIVATE_DOCUMENTS_MODAL);
    }

    public String getModalTitleText() {
        return getTextForElement(PRIVATE_DOCUMENTS_MODAL_TITLE_TEXT);
    }

    public void clickOnContinueButton() {
        clickElement(CONTINUE_BUTTON);
    }
}
