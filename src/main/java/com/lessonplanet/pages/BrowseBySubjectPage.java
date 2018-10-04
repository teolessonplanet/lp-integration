package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

public class BrowseBySubjectPage extends ResourcesPage {

    private static final String PAGE_TITLE = "[class='media-heading']";
    private static final String BANNER_IMAGE = "#directory-content [class*='banner']";

    private static final String SIDE_WIDGETS = "[class*='side-widget']";
    private static final String BROWSE_BY_SUBJECT_CARETS = "a[class*='fa-caret']";

    private static final String OPTION_NAME_SELECTOR = "li a[href*='/lesson-plans/']";

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

    public void clickGetFreeAccess(boolean inANewTab) {
        clickFirstButtonOfType(GET_FREE_ACCESS_BUTTON, inANewTab);
    }

    public void clickSeeReview(boolean inANewTab) {
        clickFirstButtonOfType(SEE_REVIEW_BUTTON, inANewTab);
    }

    public WebElement getBrowseBySubjectWidget() {
        return getCategoryFromLeftSide(SIDE_WIDGETS, TestData.SIDE_WIDGET_BROWSE_BY_SUBJECT_CATEGORIES);
    }

    public void clickOptionFromBrowseBySubject(String optionName, boolean inANewTab) {
        WebElement option = getOptionFromLeftSide(SIDE_WIDGETS, TestData.SIDE_WIDGET_BROWSE_BY_SUBJECT_CATEGORIES, OPTION_NAME_SELECTOR, optionName);
        if (inANewTab) {
            openInANewTab(option);
        } else {
            option.click();
        }
    }

    public String getBrowseBySubjectCategoryContentAsText() {
        return getBrowseBySubjectWidget().getText();
    }

    public void clickFirstCaretFromBrowseBySubjectCategory() {
        findElements(getBrowseBySubjectWidget(), BROWSE_BY_SUBJECT_CARETS).get(0).click();
        waitForPageLoad();
    }

    public void clickSecondCaretFromBrowseBySubjectCategory() {
        findElements(getBrowseBySubjectWidget(), BROWSE_BY_SUBJECT_CARETS).get(1).click();
        waitForPageLoad();
    }


}
