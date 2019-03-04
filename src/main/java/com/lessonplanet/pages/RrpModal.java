package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class RrpModal extends Rrp {
    private static final String RRP_MODAL = "#resource-modal";
    private static final String CLOSE_MODAL_BUTTON = "[class*='resource-modal-close']";

    private static final String GO_TO_RESOURCE_BUTTON = "#resource-modal [class*='trk-goto-resource'][href^='/drive/documents/']";

    public RrpModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(RRP_MODAL);
    }

    public void clickCloseModal() {
        clickElement(CLOSE_MODAL_BUTTON);
    }

    public boolean isTitleDisplayed() {
        waitForModal();
        return super.isTitleDisplayed();
    }

    public boolean isGoToResourceButtonDisplayed() {
        return isElementClickable(GO_TO_RESOURCE_BUTTON);
    }
}
