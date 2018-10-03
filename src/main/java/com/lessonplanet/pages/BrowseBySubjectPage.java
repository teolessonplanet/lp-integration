package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class BrowseBySubjectPage extends ResourcesPage {

    private static final String PAGE_TITLE = "[class='media-heading']";
    private static final String BANNER_IMAGE = "#directory-content [class*='banner']";

    private static final String SIDE_WIDGETS = "[class='side-widget']";
    private static final String BROWSE_BY_SUBJECT_CARETS = "[class='side-widget']";

    public BrowseBySubjectPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage(String subjectPath) {
        loadUrl(subjectPath);
    }

    public String getPageTitle() {
//        waitForPageLoad();
        return findElement(PAGE_TITLE).getText();
    }

    public boolean isBannerImageDisplayed() {
        return isElementClickable(BANNER_IMAGE);
    }

    public void clickGetFreeAccess(boolean inANewTab) {
        clickFirstButtonOfType(GET_FREE_ACCESS_BUTTON, inANewTab);
    }

    public void clickSeeReview(boolean inANewTab) {
        clickFirstButtonOfType(SEE_REVIEW_BUTTON, inANewTab);
    }

}
