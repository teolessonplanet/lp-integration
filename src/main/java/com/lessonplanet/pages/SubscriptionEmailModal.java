package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class SubscriptionEmailModal extends LpUiBasePage {

    private static final String SUBSCRIPTION_MODAL = "[class*='modal-body']";
    private static final String CLOSE_BUTTON = "[class*='close']";

    public SubscriptionEmailModal(WebDriver driver) {
        super(driver);
    }

    public String getSubscriptionModalText() {
        return findElement(SUBSCRIPTION_MODAL).getText();
    }

    public void clickOnCloseButton() {
        findElements(CLOSE_BUTTON).get(0).click();
    }
}
