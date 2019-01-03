package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class UpgradeModal extends LpUiBasePage {

    private static final String UPGRADE_MODAL_FROM_MAX_COLLECTION_LIMIT = "#collection-limit-hit-modal";
    private static final String UPGRADE_MODAL_TEXT_FROM_MAX_COLLECTION_LIMIT = "#collection-limit-hit-modal [class='modal-body']";
    private static final String UPGRADE_ME_BUTTON_FROM_MAX_COLLECTION_LIMIT = "#collection-limit-hit-modal [href='/subscription/new']";

    private static final String UPGRADE_MODAL_FROM_UPLOAD_BUTTON = "#freemium-unauthorized-upload-modal";
    private static final String UPGRADE_MODAL_TEXT_FROM_UPLOAD_BUTTON = "#freemium-unauthorized-upload-modal [class='modal-body']";
    private static final String GET_FULL_ACCESS_NOW_BUTTON = "#freemium-unauthorized-upload-modal [class='get-now-btn']";

    private static final String UPGRADE_MODAL_FROM_ASSIGN_BUTTON = "#popup-modal";
    private static final String UPGRADE_MODAL_TEXT_FROM_ASSIGN_BUTTON = "#popup-modal [class='modal-body']";
    private static final String UPGRADE_ME_BUTTON_FROM_ASSIGN_MODAL = "#popup-modal [class='get-now-btn']";
    private static final String STEP_TWO_BUTTON = "[href='/subscription/new']";
    private static final String STEP_TWO_BUTTON_COPY = "#collection-limit-hit-modal [href='/subscription/new']";
    private static final String STEP_TWO_BUTTON_ASSIGN = "#popup-modal [class='get-now-btn']";

    private static final String UPGRADE_MAX_ITEMS_MODAL = "#max-items-limit-hit-modal";


    public UpgradeModal(WebDriver driver) {
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

    public void waitForUpgradeModalFromUploadButton() {
        waitForBootstrapModalToBeVisible(UPGRADE_MODAL_FROM_UPLOAD_BUTTON);
    }

    public String getTextFromUpgradeModalFromUploadButton() {
        return getTextForElement(UPGRADE_MODAL_TEXT_FROM_UPLOAD_BUTTON);
    }

    public void clickOnGetFullAccessNowButton(){
        clickElement(GET_FULL_ACCESS_NOW_BUTTON);
    }

    public void waitForUpgradeModalFromAssignButton() {
        waitForBootstrapModalToBeVisible(UPGRADE_MODAL_FROM_ASSIGN_BUTTON);
    }

    public String getTextFromUpgradeModalFromAssignButton() {
        return getTextForElement(UPGRADE_MODAL_TEXT_FROM_ASSIGN_BUTTON);
    }

    public void clickOnUpgradeMeButtonFromAssignModal(){
        clickElement(UPGRADE_ME_BUTTON_FROM_ASSIGN_MODAL);
    }

    public void waitForUpgradeModalFromMaxItemsLimit(){
        waitForBootstrapModalToBeVisible(UPGRADE_MAX_ITEMS_MODAL);
    }

    public void clickOnUpgradeButtonFromAssign(){
        clickElement(STEP_TWO_BUTTON_ASSIGN);
    }

    public void clickOnUpgradeButton(){
        clickElement(STEP_TWO_BUTTON);
    }


    public void clickOnUpgradeButtonFromCopy(){
       // waitForBootstrapModalToBeVisible(UPGRADE_COPY_MODAL);
        //findElement(STEP_TWO_BUTTON);
        clickElement(STEP_TWO_BUTTON_COPY);
      //  waitForLoad();
       // clickElement(STEP_TWO_BUTTON_COPY);
    }

   // public void clickOnGetFullAccessNowButton(){
   //     clickElement(GET_FULL_ACCESS_NOW_BUTTON);
   // }
}
