package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class BrowseBySubjectPage extends ResourcesPage {

    private static final String PAGE_TITLE = "[class='media-heading']";
    private static final String BANNER_IMAGE = "#directory-content [class*='banner']";

    private static final String PREVIOUS_BUTTON = "[class='pagination'] [class*='previous_page']";
    private static final String FIRST_PAGE_BUTTON = "[class='pagination'] [rel='start']";
    private static final String NEXT_BUTTON = "[class='pagination'] [class*='next_page']";
    private static final String SEE_ALL_BUTTON = "[class='pagination'] [class*='next_page']";

    public BrowseBySubjectPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage(String subjectPath) {
        loadUrl(subjectPath);
    }

    public String getPageTitle() {
        return findElement(PAGE_TITLE).getText();
    }

    public boolean isBannerImageDisplayed() {
        return isElementClickable(BANNER_IMAGE);
    }

    public void clickOnPreviousButt() {
        clickElement(PREVIOUS_BUTTON);
    }

    public boolean isFirstPageButtonDisplayed() {
        return isElementClickable(FIRST_PAGE_BUTTON);
    }

    public void clickOnNextButton() {
        clickElement(NEXT_BUTTON);
    }

    public boolean isSeeAllButtonDisplayed() {
        return isElementClickable(SEE_ALL_BUTTON);
    }
}
