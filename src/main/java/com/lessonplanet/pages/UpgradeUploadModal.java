package com.lessonplanet.pages;
import org.openqa.selenium.WebDriver;

public class UpgradeUploadModal extends LpUiBasePage {
    private static final String UPGRADE_MODAL_FROM_UPLOAD_BUTTON = "#freemium-unauthorized-upload-modal";
    private static final String UPGRADE_MODAL_TEXT_FROM_UPLOAD_BUTTON = "#freemium-unauthorized-upload-modal [class='modal-body']";
    private static final String GET_FULL_ACCESS_NOW_BUTTON = "#freemium-unauthorized-upload-modal [class='get-now-btn']";

    public UpgradeUploadModal(WebDriver driver) {
        super(driver);
    }

    public void waitForUpgradeModalFromUploadButton() {
        waitForBootstrapModalToBeVisible(UPGRADE_MODAL_FROM_UPLOAD_BUTTON);
    }

    public String getTextFromUpgradeModalFromUploadButton() {
        return getTextForElement(UPGRADE_MODAL_TEXT_FROM_UPLOAD_BUTTON);
    }

    public void clickOnGetFullAccessNowButton() {
        clickElement(GET_FULL_ACCESS_NOW_BUTTON);
    }
}
