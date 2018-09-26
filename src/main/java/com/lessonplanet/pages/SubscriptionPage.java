package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class SubscriptionPage extends LpUiBasePage {
    private static final String SUBSCRIPTION_TEXT = "[class*='modal-body']";
    private static final String CLOSE_BUTTON ="[class*='close']";

    public SubscriptionPage (WebDriver driver) { super(driver); }

    public String getSubscriptionText() {return findElement(SUBSCRIPTION_TEXT).getText(); }

    public void clickOnCloseButton(){ findElements(CLOSE_BUTTON).get(0).click(); }
}

