package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class RrpPage extends Rrp {
    private static final String UPGRADE_FOR_FULL_REVIEW_BUTTON = "a[href='/subscription/new']";
    private static final String UPGRADE_ME_START_YOUR_FREE_TRIAL_BUTTON = "[class='panel panel-default'] [class='btn btn-success ']";
    private static final String UPGRADE_ME_BOTTOM_BUTTON = "[class='btn btn-success btn-lg mb10 mt20']";
    public RrpPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnUpgradeForFullReviewButton (){
        openInANewTab(UPGRADE_FOR_FULL_REVIEW_BUTTON);
    }

    public void clickOnUpgradeMeButtonFromStartYourFreeTrialBox(){
        scrollToElement(UPGRADE_ME_START_YOUR_FREE_TRIAL_BUTTON);
        openInANewTab(UPGRADE_ME_START_YOUR_FREE_TRIAL_BUTTON);
    }

    public void clickOnUpgradeMeButtonFromRrpBottomPage(){
        scrollToElement(UPGRADE_ME_BOTTOM_BUTTON);
        openInANewTab(UPGRADE_ME_BOTTOM_BUTTON);
    }


}
