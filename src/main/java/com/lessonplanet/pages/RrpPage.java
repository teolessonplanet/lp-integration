package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class RrpPage extends Rrp {

    private static final String START_YOUR_FREE_TRIAL_SUBSCRIPTION_BUTTON = "[class='panel panel-default'] [class='btn btn-success ']";
    private static final String SUBSCRIPTION_BUTTON = "[class='btn btn-success btn-lg mb10 mt20']";

    public RrpPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnStartYourFreeTrialSubscriptionButton(boolean inANewTab){
        openInANewTabOrClick(START_YOUR_FREE_TRIAL_SUBSCRIPTION_BUTTON, inANewTab);
    }

    public void clickOnBottomPageSubscriptionButton (boolean inANewTab){
        openInANewTabOrClick(SUBSCRIPTION_BUTTON, inANewTab);
    }
}
