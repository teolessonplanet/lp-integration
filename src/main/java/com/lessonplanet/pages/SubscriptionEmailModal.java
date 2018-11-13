package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class SubscriptionEmailModal extends LpUiBasePage {

    private static final String SUBSCRIPTION_MODAL = "[class*='modal-body']";
    private static final String CLOSE_BUTTON = "[class*='close']";

    public SubscriptionEmailModal(WebDriver driver) {
        super(driver);
    }

    public String getSubscriptionModalText() {
        return getTextForElement(SUBSCRIPTION_MODAL);
    }

    public void clickOnCloseButton() {
        clickElement(findElements(CLOSE_BUTTON), 0);
    }
}
