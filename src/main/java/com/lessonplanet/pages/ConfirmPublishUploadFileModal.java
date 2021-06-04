package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class ConfirmPublishUploadFileModal extends LpUiBasePage {

    private static final String AGREEMENT_CHECKBOX = "[class='boolean rights-checkbox']";
    private static final String PUBLISH_COLLECTION_BUTTON = "[class='modal-footer'] [class='btn btn-success']";
    private static final String DO_NOT_INCLUDE_FILE_OPTION = "[class*='radio-row'] div[class='pt15']:nth-child(3) input";
    private static final String INCLUDE_FILE_OPTION = "[class*='radio-row'] div[class='pt15']:nth-child(2) input";

    public ConfirmPublishUploadFileModal(WebDriver driver) {
        super(driver);
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
