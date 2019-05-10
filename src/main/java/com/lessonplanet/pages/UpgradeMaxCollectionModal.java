package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class UpgradeMaxCollectionModal extends LpUiBasePage {

    private static final String UPGRADE_MODAL = "#collection-limit-hit-modal";
    private static final String UPGRADE_MODAL_TEXT= "#collection-limit-hit-modal [class='modal-body']";
    private static final String UPGRADE_ME_BUTTON = "#collection-limit-hit-modal [href='/subscription/new']";

    public UpgradeMaxCollectionModal(WebDriver driver) {
        super(driver);
    }

    public boolean isModalDisplayed(){
        return isElementDisplayed(UPGRADE_MODAL);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(UPGRADE_MODAL);
    }

    public String getUpgradeModalText() {
        return getTextForElement(UPGRADE_MODAL_TEXT);
    }

    public void clickOnUpgradeMeButton(){
        clickElement(UPGRADE_ME_BUTTON);
    }
}