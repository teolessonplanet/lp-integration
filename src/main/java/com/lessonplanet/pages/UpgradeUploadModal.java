package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class UpgradeUploadModal extends LpUiBasePage {
    private static final String UPGRADE_MODAL = "#freemium-unauthorized-upload-modal";
    private static final String UPGRADE_MODAL_TEXT = "#freemium-unauthorized-upload-modal [class='modal-body']";
    private static final String GET_FULL_ACCESS_NOW_BUTTON = "#freemium-unauthorized-upload-modal [class='get-now-btn']";
    private static final String CLOSE_BUTTON = "[class='modal-footer'] button[class='close']";

    public UpgradeUploadModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(UPGRADE_MODAL);
    }

    public String getUpgradeModalText() {
        return getTextForElement(UPGRADE_MODAL_TEXT);
    }

    public void clickOnGetFullAccessNowButton() {
        clickElement(GET_FULL_ACCESS_NOW_BUTTON);
    }

    public void clickOnCloseButton(){
        clickElement(CLOSE_BUTTON);
    }
}
