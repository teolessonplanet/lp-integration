package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class UpgradeModal extends LpUiBasePage {

    private static final String UPGRADE_MODAL_FROM_MAX_ITEMS_INSIDE_COLLECTION_LIMIT = "#max-items-limit-hit-modal";
    private static final String UPGRADE_MODAL_TEXT_FROM_MAX_ITEMS_INSIDE_COLLECTION_LIMIT = "#max-items-limit-hit-modal [class='modal-body']";
    private static final String UPGRADE_ME_BUTTON_FROM_MAX_ITEMS_INSIDE_COLLECTION_LIMIT = "#max-items-limit-hit-modal [class='get-now-btn']";
    private static final String UPGRADE_ME_BUTTON = "#popup-modal [class='get-now-btn']";

    public UpgradeModal(WebDriver driver) {
        super(driver);
    }

    public void waitForUpgradeModalFromMaxItemsLimit(){
        waitForBootstrapModalToBeVisible(UPGRADE_MODAL_FROM_MAX_ITEMS_INSIDE_COLLECTION_LIMIT);
    }

    public String getTextFromUpgradeModalFromMaxItemsLimit(){
        return getTextForElement(UPGRADE_MODAL_TEXT_FROM_MAX_ITEMS_INSIDE_COLLECTION_LIMIT);
    }

    public void clickOnUpgradeMeButton(){
        clickElement(UPGRADE_ME_BUTTON);
    }

}
