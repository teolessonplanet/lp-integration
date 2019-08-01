package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class UpgradeAssignModal extends LpUiBasePage {
    private static final String UPGRADE_MODAL = "#popup-modal";
    private static final String UPGRADE_MODAL_TEXT = "#popup-modal [class='modal-body']";
    private static final String UPGRADE_ME_BUTTON = "#popup-modal [class='get-now-btn']";

    public UpgradeAssignModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(UPGRADE_MODAL);
    }

    public String getUpgradeModalText() {
        return getTextForElement(UPGRADE_MODAL_TEXT);
    }

    public void clickOnUpgradeMeButton() {
        clickElement(UPGRADE_ME_BUTTON);
    }
}
