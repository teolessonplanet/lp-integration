package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class UpgradeMaxCollectionModal extends LpUiBasePage {

    private static final String UPGRADE_MODAL_FROM_MAX_COLLECTION_LIMIT = "#collection-limit-hit-modal";
    private static final String UPGRADE_MODAL_TEXT_FROM_MAX_COLLECTION_LIMIT = "#collection-limit-hit-modal [class='modal-body']";
    private static final String UPGRADE_ME_BUTTON_FROM_MAX_COLLECTION_LIMIT = "#collection-limit-hit-modal [href='/subscription/new']";

    public UpgradeMaxCollectionModal(WebDriver driver) {
        super(driver);
    }

    public boolean isUpgradeModalFromMaxCollectionLimitDisplayed(){
        return isElementDisplayed(UPGRADE_MODAL_FROM_MAX_COLLECTION_LIMIT);
    }

    public void waitForUpgradeModalFromMaxCollectionLimit() {
        waitForBootstrapModalToBeVisible(UPGRADE_MODAL_FROM_MAX_COLLECTION_LIMIT);
    }

    public String getTextFromUpgradeModalFromMaxCollectionLimit() {
        return getTextForElement(UPGRADE_MODAL_TEXT_FROM_MAX_COLLECTION_LIMIT);
    }

    public void clickOnUpgradeMeButtonFromMaxCollectionLimit(){
        clickElement(UPGRADE_ME_BUTTON_FROM_MAX_COLLECTION_LIMIT);
    }
}
