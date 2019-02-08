package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class RrpPage extends Rrp {

    private static final String START_YOUR_FREE_TRIAL_SUBSCRIPTION_BUTTON = "a[data-track-click='Upgrade Me'][data-track-label='review_page_button']";
    private static final String BOTTOM_PAGE_SUBSCRIPTION_BUTTON = "a[data-track-click='Upgrade Me'][data-track-label='side_widget_button']";

    public RrpPage(WebDriver driver) {
        super(driver);
    }

    public void clickStartYourFreeTrialSubscriptionButton(boolean inANewTab){
        openInANewTabOrClick(START_YOUR_FREE_TRIAL_SUBSCRIPTION_BUTTON, inANewTab);
    }

    public void clickBottomPageSubscriptionButton (boolean inANewTab){
        openInANewTabOrClick(BOTTOM_PAGE_SUBSCRIPTION_BUTTON, inANewTab);
    }
}
