package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CollectionRrpModal extends CollectionRrp {
    private static final String COLLECTION_RRP_MODAL = "#resource-modal";
    private static final String CLOSE_MODAL_BUTTON = "[class*='resource-modal-close']";

    public CollectionRrpModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(COLLECTION_RRP_MODAL);
    }

    public boolean isCollectionTitleDisplayed() {
        waitForModal();
        return super.isCollectionTitleDisplayed();
    }

    public void clickOnSaveCollectionButton(){
        super.clickOnSaveCollectionButton();
    }

    public void clickCloseModal() {
        clickElement(CLOSE_MODAL_BUTTON);
    }
}
