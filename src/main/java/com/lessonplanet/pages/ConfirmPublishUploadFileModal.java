package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class ConfirmPublishUploadFileModal extends LpUiBasePage {

    private static final String CONFIRM_PUBLISH_UPLOAD_RESOURCE_MODAL = "#confirm-share-uploads-modal";
    private static final String AGREEMENT_CHECKBOX = "[class='boolean']";
    private static final String PUBLISH_COLLECTION_BUTTON = "#share-private-submit";

    public ConfirmPublishUploadFileModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(CONFIRM_PUBLISH_UPLOAD_RESOURCE_MODAL);
    }

    public void clickAgreementOption() {
        clickElement(AGREEMENT_CHECKBOX);
    }

    public void clickOnPublishCollectionButton() {
        clickElement(PUBLISH_COLLECTION_BUTTON);
    }
}
