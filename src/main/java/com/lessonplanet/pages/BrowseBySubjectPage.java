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

    private static final String GET_FREE_TRIAL_BUTTON = "a[href='/subscription/new']";

    private static final String SUGGEST_A_CATEGORY_BUTTON = "[class='suggest-new-directory-term orange']";

    private static final String TESTIMONIALS_THUMBNAIL = "[class='img-thumbnail']";
    private static final String TESTIMONIALS_TEXT = "div[class='clearfix']";
    private static final String SEE_MORE_TESTIMONIALS_BUTTON = "[class='more'] a[href='/us/testimonials']";
    private static final String SUBMIT_YOUR_OWN_BUTTON = "[class='more'] a[href='/feedbacks/new']";
    private static final String TESTIMONIALS_GET_FREE_TRIAL_BUTTON = "a[href*='/subscription/new']";

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
    
    public void clickUpgradeForAccess(boolean inANewTab) {
        clickFirstButtonOfType(UPGRADE_FOR_ACCESS_BUTTON, inANewTab);
    }

    public WebElement getBrowseBySubjectWidget() {
        waitForLoad();
        return getCategoryFromLeftSide(SIDE_WIDGETS, TestData.SIDE_WIDGET_BROWSE_BY_SUBJECT_CATEGORIES);
    }

    private void clickOptionFromWidget(String widgetName, String optionName, boolean inANewTab) {
        WebElement option;
        if (widgetName.equals(TestData.SIDE_WIDGET_BROWSE_BY_SUBJECT_CATEGORIES)) {
            option = getOptionFromLeftSide(SIDE_WIDGETS, widgetName, BROWSE_BY_SUBJECT_OPTIONS_SELECTOR, optionName);
        } else {
            option = getOptionFromLeftSide(SIDE_WIDGETS, widgetName, RELATED_TOPICS_OPTIONS_SELECTOR, optionName);
        }
        if (inANewTab) {
            openInANewTab(option);
        } else {
            clickElement(option);
        }
    }

    public void clickOptionFromBrowseBySubject(String optionName, boolean inANewTab) {
        clickOptionFromWidget(TestData.SIDE_WIDGET_BROWSE_BY_SUBJECT_CATEGORIES, optionName, inANewTab);
    }

    public String getBrowseBySubjectCategoryContentAsText() {
        return getTextForElement(getBrowseBySubjectWidget());
    }

    public void clickFirstCaretFromBrowseBySubjectCategory() {
        clickElement(findElements(getBrowseBySubjectWidget(), BROWSE_BY_SUBJECT_CARETS), 0);
    }

    public void clickSecondCaretFromBrowseBySubjectCategory() {
        clickElement(findElements(getBrowseBySubjectWidget(), BROWSE_BY_SUBJECT_CARETS), 1);
    }

    public String getStartYourTenDaysFreeTrialContentAsText() {
        return getTextForElement(getCategoryFromLeftSide(SIDE_WIDGETS, TestData.SIDE_WIDGET_START_YOUR_TEN_DAYS_FREE_TRIAL));
    }

    public void clickGetFreeTrialButton(boolean inANewTab) {
        WebElement getFreeTrialButton = findElements(getCategoryFromLeftSide(SIDE_WIDGETS, TestData.SIDE_WIDGET_START_YOUR_TEN_DAYS_FREE_TRIAL), GET_FREE_TRIAL_BUTTON).get(0);
        if (inANewTab) {
            openInANewTab(getFreeTrialButton);
        } else {
            clickElement(getFreeTrialButton);
        }
    }

    public void clickOnSuggestACategoryButton() {
        clickElement(SUGGEST_A_CATEGORY_BUTTON);
    }

    public String getRelatedTopicsContentAsText() {
        return getTextForElement(getCategoryFromLeftSide(SIDE_WIDGETS, TestData.SIDE_WIDGET_RELATED_TOPICS));
    }

    public void clickOptionFromRelatedTopics(String optionName, boolean inANewTab) {
        clickOptionFromWidget(TestData.SIDE_WIDGET_RELATED_TOPICS, optionName, inANewTab);
    }

    public WebElement getWhatMembersSayWidget() {
        return getCategoryFromLeftSide(SIDE_WIDGETS, TestData.SIDE_WIDGET_WHAT_MEMBERS_SAY);
    }

    public boolean isTestimonialTextDisplayed() {
        return findElements(getWhatMembersSayWidget(), TESTIMONIALS_TEXT).get(0).getText().length() > TestData.ZERO_RESOURCES_FOUND;
    }

    public void clickOnSeeMoreTestimonialsButton(boolean inANewTab) {
        if (inANewTab) {
            openInANewTab(SEE_MORE_TESTIMONIALS_BUTTON);
        } else {
            clickElement(SEE_MORE_TESTIMONIALS_BUTTON);
        }
    }

    public void clickOnSubmitYourOwnButton(boolean inANewTab) {
        if (inANewTab) {
            openInANewTab(SUBMIT_YOUR_OWN_BUTTON);
        } else {
            clickElement(SUBMIT_YOUR_OWN_BUTTON);
        }
    }

    public void clickTestimonialsGreenButton(boolean inANewTab) {
        waitForPageLoad();
        final WebElement seeMoreTestimonialsButton = findElements(getWhatMembersSayWidget(), TESTIMONIALS_GET_FREE_TRIAL_BUTTON).get(0);
        if (inANewTab) {
            openInANewTab(seeMoreTestimonialsButton);
        } else {
            clickElement(seeMoreTestimonialsButton);
        }
    }
}
