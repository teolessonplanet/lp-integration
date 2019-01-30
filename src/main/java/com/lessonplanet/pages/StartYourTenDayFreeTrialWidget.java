package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

public class StartYourTenDayFreeTrialWidget extends ResourcesPage {

    private static final String SIDE_WIDGETS = "[class*='side-widget']";
    private static final String START_YOUR_TEN_DAYS_FREE_TRIAL_SUBSCRIPTION_BUTTON = "a[href='/subscription/new']";

    public StartYourTenDayFreeTrialWidget(WebDriver driver) {
        super(driver);
    }

    public String getStartYourTenDaysFreeTrialContentAsText() {
        return getTextForElement(getCategoryFromLeftSide(SIDE_WIDGETS, TestData.SIDE_WIDGET_START_YOUR_TEN_DAYS_FREE_TRIAL));
    }

    public void clickOnSubscriptionButton(boolean inANewTab) {
        WebElement subscriptionButton = findElements(getCategoryFromLeftSide(SIDE_WIDGETS, TestData.SIDE_WIDGET_START_YOUR_TEN_DAYS_FREE_TRIAL), START_YOUR_TEN_DAYS_FREE_TRIAL_SUBSCRIPTION_BUTTON).get(0);
        openInANewTabOrClick(subscriptionButton, inANewTab);
    }
}
