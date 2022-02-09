package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

public class BrowseBySubjectPage extends ResourcesPage {
    private static final String PAGE_TITLE = "[class='media-heading']";
    private static final String BANNER_IMAGE = "#directory-content [class*='banner']";

    private static final String SIDE_WIDGETS = "[class*='side-widget']";
    private static final String BROWSE_BY_SUBJECT_CARETS = "a[class*='fa-caret']";

    private static final String BROWSE_BY_SUBJECT_OPTIONS_SELECTOR = "li a[href*='/lesson-plans/']";
    private static final String RELATED_TOPICS_OPTIONS_SELECTOR = "li a[href*='/search?keywords=']";

    private static final String SUGGEST_A_CATEGORY_LINK = "[class='suggest-new-directory-term orange']";

    public BrowseBySubjectPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage(String subjectPath) {
        loadUrl(subjectPath);
    }

    public String getPageTitle() {
        return getTextForElement(PAGE_TITLE);
    }

    public boolean isBannerImageDisplayed() {
        return isElementClickable(BANNER_IMAGE);
    }

    public void clickOnUpgradeForAccess(boolean inANewTab) {
        clickOnFirstButtonOfType(UPGRADE_FOR_ACCESS_BUTTON, inANewTab);
    }

    public WebElement getBrowseBySubjectWidget() {
        waitForLoad();
        return getCategoryFromLeftSide(SIDE_WIDGETS, TestData.SIDE_WIDGET_BROWSE_BY_SUBJECT_CATEGORIES);
    }

    private void clickOnOptionFromWidget(String widgetName, String optionName, boolean inANewTab) {
        WebElement option;
        if (widgetName.equals(TestData.SIDE_WIDGET_BROWSE_BY_SUBJECT_CATEGORIES)) {
            option = getOptionFromLeftSide(SIDE_WIDGETS, widgetName, BROWSE_BY_SUBJECT_OPTIONS_SELECTOR, optionName);
        } else {
            option = getOptionFromLeftSide(SIDE_WIDGETS, widgetName, RELATED_TOPICS_OPTIONS_SELECTOR, optionName);
        }
        openInANewTabOrClick(option, inANewTab);
    }

    public void clickOnOptionFromBrowseBySubject(String optionName, boolean inANewTab) {
        clickOnOptionFromWidget(TestData.SIDE_WIDGET_BROWSE_BY_SUBJECT_CATEGORIES, optionName, inANewTab);
    }

    public String getBrowseBySubjectCategoryContentAsText() {
        return getTextForElement(getBrowseBySubjectWidget());
    }

    public void clickOnCaretFromBrowseBySubjectCategory(int index){
        clickElement(findElements(getBrowseBySubjectWidget(), BROWSE_BY_SUBJECT_CARETS), index);
    }

    public void clickOnSuggestACategoryLink() {
        clickElement(SUGGEST_A_CATEGORY_LINK);
    }

    public String getRelatedTopicsContentAsText() {
        return getTextForElement(getCategoryFromLeftSide(SIDE_WIDGETS, TestData.SIDE_WIDGET_RELATED_TOPICS));
    }

    public void clickOnOptionFromRelatedTopics(String optionName, boolean inANewTab) {
        clickOnOptionFromWidget(TestData.SIDE_WIDGET_RELATED_TOPICS, optionName, inANewTab);
    }

    public WebElement getWhatMembersSayWidget() {
        return getCategoryFromLeftSide(SIDE_WIDGETS, TestData.SIDE_WIDGET_WHAT_MEMBERS_SAY);
    }
}
