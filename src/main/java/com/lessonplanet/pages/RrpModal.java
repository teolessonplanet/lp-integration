package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class RrpModal extends Rrp {

    private static final String CLOSE_MODAL_BUTTON = "[class*='resource-modal-close']";

    public RrpModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForLoad();
        waitUntilAnimationIsDone(RESOURCE_TITLE_TEXT);
    }

    public void clickCloseModal() {
        clickElement(CLOSE_MODAL_BUTTON);
    }

    public boolean isTitleDisplayed() {
        waitForModal();
        return super.isTitleDisplayed();
    }
}
