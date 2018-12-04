package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class SignInModal extends LpUiBasePage {
    private static final String SIGN_IN_MODAL = "#login-modal";
    private static final String MODAL_TITLE = "h4[class='modal-title']";
    private static final String CLOSE_BUTTON = "[class='close']";

    public SignInModal(WebDriver driver) {
        super(driver);
    }

    public String getModalTitle() {
        waitForBootstrapModalToBeVisible(SIGN_IN_MODAL);
        return getTextForElement(MODAL_TITLE);
    }

    public void clickOnClose() {
        clickElement(CLOSE_BUTTON);
    }
}
