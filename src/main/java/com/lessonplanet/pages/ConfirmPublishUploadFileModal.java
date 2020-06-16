package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class ConfirmPublishUploadFileModal extends LpUiBasePage {

    private static final String CONFIRM_PUBLISH_UPLOAD_RESOURCE_MODAL = "#confirm-share-uploads-modal";
    private static final String AGREEMENT_CHECKBOX = "[class='boolean']";
    private static final String PUBLISH_COLLECTION_BUTTON = "#share-private-submit";
    private static final String DO_NOT_INCLUDE_FILE_OPTION =  "[class*='radio-row'] div[class='col-md-6']:nth-child(2) input";
    private static final String INCLUDE_FILE_OPTION =  "[class*='radio-row'] div[class='col-md-6']:nth-child(1) input";

    public ConfirmPublishUploadFileModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(CONFIRM_PUBLISH_UPLOAD_RESOURCE_MODAL);
    }

    public void checkAgreementOption() {
        clickElement(AGREEMENT_CHECKBOX);
    }

    public void clickOnPublishCollectionButton() {
        clickElement(PUBLISH_COLLECTION_BUTTON);
    }

    public void clickOnDoNotIncludeFileOption() {
        clickElement(DO_NOT_INCLUDE_FILE_OPTION);
    }

    public void clickOnIncludeFileOption() {
        clickElement(INCLUDE_FILE_OPTION);
    }
}
