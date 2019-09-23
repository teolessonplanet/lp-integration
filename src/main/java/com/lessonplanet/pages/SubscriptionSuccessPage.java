package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class SubscriptionSuccessPage extends LpUiBasePage {

    private static final String TITLE_TEXT = "[class='mt0']";
    private static final String GET_STARTED_BUTTON = "input[class*='btn-primary']";

    public SubscriptionSuccessPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getTextForElement(TITLE_TEXT);
    }

    public void clickOnGetStartedButton() {
        clickElement(GET_STARTED_BUTTON);
    }
}
