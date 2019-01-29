package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class SubscriptionEmailModal extends LpUiBasePage {

    private static final String SUBSCRIPTION_MODAL = "#subscription-modal-popup";
    private static final String SUBSCRIPTION_MODAL_TEXT = "[class*='modal-body']";
    private static final String CLOSE_BUTTON = "[class*='close']";
    private static final String SUBSCRIPTION_MODAL_ID = "#subscription-modal-popup";

    public SubscriptionEmailModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal(){
        waitForBootstrapModalToBeVisible(SUBSCRIPTION_MODAL);
    }

    public String getSubscriptionModalText() {
        return getTextForElement(SUBSCRIPTION_MODAL_TEXT);
    }

    public void clickOnCloseButton() {
        clickElement(findElements(CLOSE_BUTTON), 0);
    }

    public void waitForModal(){
        waitForBootstrapModalToBeVisible(SUBSCRIPTION_MODAL_ID);
    }
}
