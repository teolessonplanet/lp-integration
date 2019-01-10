package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class RrpPage extends Rrp {
    private static final String UPGRADE_FOR_FULL_REVIEW_BUTTON = "a[href='/subscription/new']";
    public RrpPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnUpgradeForFullReviewButton (){
        openInANewTab(UPGRADE_FOR_FULL_REVIEW_BUTTON);
    }
}
