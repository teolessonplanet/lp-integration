package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class Rrp extends LpUiBasePage {

    private static final String LIMITED_ACCESS_REVIEW = "[class='rrp-banner'] [src*='limited-access']";
    private static final String FULL_REVIEW = "[class='rrp-banner'] [src*='rrp-banner-fullreview']";
    private static final String FREE_SAMPLE = "[class*='rrp-banner'] [src*='/assets/rrp/lp_badge']";

    protected static final String RESOURCE_TITLE_TEXT = "[class='resource-title'] h1";

    private static final String GO_TO_RESOURCE_BUTTON = "[class='panel-heading'] a[class*='goto']";

    protected Rrp(WebDriver driver) {
        super(driver);
    }

    public boolean isGoToResourceButtonDisplayed() {
        return isElementClickable(GO_TO_RESOURCE_BUTTON);
    }

    public boolean isTitleDisplayed() {
        return isElementClickable(RESOURCE_TITLE_TEXT);
    }

    public boolean isLimitedAccessReviewDisplayed() {
        return isElementClickable(LIMITED_ACCESS_REVIEW);
    }

    public boolean isFullReviewDisplayed() {
        return isElementClickable(FULL_REVIEW);
    }

    public boolean isFreeSampleDisplayed() {
        return isElementClickable(FREE_SAMPLE);
    }
}
