package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class RrpModal extends Rrp {
    private static final String RRP_MODAL = "#resource-modal";
    private static final String RRP_X_BUTTON = "[class*='resource-modal-close']";
    private static final String RRP_MODAL_ID = "#resource-modal div";

    public RrpModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(RRP_MODAL);
    }

    public void clickOnRrpModalXButton() {
        clickElement(RRP_X_BUTTON);
    }

    public boolean isTitleDisplayed() {
        waitForModal();
        return super.isTitleDisplayed();
    }

    public String getModalId() {
        waitForModal();
        return getElementId(RRP_MODAL_ID);
    }
}
