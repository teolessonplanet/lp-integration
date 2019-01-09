package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class ThanksForJoiningModal extends LpUiBasePage {

    private static final String THANKS_FOR_JOINING_MODAL = "#free-signup-confirmation";
    private static final String MODAL_TEXT = "#free-signup-confirmation div[class='modal-body'] p";

    public ThanksForJoiningModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(THANKS_FOR_JOINING_MODAL);
    }

    public String getModalText() {
        waitForModal();
        return getTextForElement(MODAL_TEXT);
    }
}
