package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class UpgradeMaxItemsCollectionModal extends LpUiBasePage {

    private static final String UPGRADE_MODAL = "#max-items-limit-hit-modal";
    private static final String UPGRADE_MODAL_TEXT = "#max-items-limit-hit-modal [class='modal-body']";
    private static final String UPGRADE_ME_BUTTON = "[class*='get-now-btn'][href='/subscription/new']";
    private static final String CLOSE_BUTTON = "#max-items-limit-hit-modal [class*='modal-content'] [class='close']";

    public UpgradeMaxItemsCollectionModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(UPGRADE_MODAL);
    }

    public String getUpgradeModalText() {
        return getTextForElement(UPGRADE_MODAL_TEXT);
    }

    public void clickOnUpgradeMeButton(boolean inANewTab) {
        openInANewTabOrClick(UPGRADE_ME_BUTTON, inANewTab);
    }

    public void clickOnCloseModalButton() {
        clickElement(CLOSE_BUTTON);
    }
}
