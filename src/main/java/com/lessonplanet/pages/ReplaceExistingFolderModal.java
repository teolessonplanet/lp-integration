package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class ReplaceExistingFolderModal extends LpUiBasePage {

    private static final String REPLACE_EXISTING_FOLDER_MODAL = "#site-specific-metadata-modal";
    private static final String TITLE_INPUT = "#site-specific-metadata-modal h3";
    private static final String PUBLISH_NEW_BUTTON = "#site-specific-metadata-modal [class='modal-footer'] [class*='btn-success']:nth-child(3)";
    private static final String PUBLISH_AND_REPLACE_BUTTON = "#site-specific-metadata-modal [class='modal-footer'] [class*='btn-success']:nth-child(2)";

    public ReplaceExistingFolderModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(REPLACE_EXISTING_FOLDER_MODAL);
    }

    public String getModalTitle() {
        return getTextForElement(TITLE_INPUT);
    }

    public void clickOnPublishNewButton() {
        clickElement(PUBLISH_NEW_BUTTON);
    }

    public void clickOnPublishAndReplaceButton() {
        clickElement(PUBLISH_AND_REPLACE_BUTTON);
    }
}
