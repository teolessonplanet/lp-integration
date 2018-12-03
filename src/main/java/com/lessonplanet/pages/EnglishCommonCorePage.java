package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class EnglishCommonCorePage extends CommonCoreStateStandardsPage {

    private static final String PAGE_HEADER_PATH = "[class='breadcrumb']";
    private static final String PAGE_TITLE = "#standard-content h3";
    private static final String BACK_BUTTON = "#standard-content [class*='pull-right']";
    private static final String USE_FILTERS_TEXT = "[class='search-controls'] [class='text-muted']";


    private static final String STANDARD_HEADERS = "[class='strand-header']";
    private static final String STANDARD_INTRO = "[class='standard-intro']";

    private static final String STANDARD_CATEGORIES = "[class='standard']";
    private static final String STANDARD_SEE_RESOURCES_BUTTON = "[class*='btn-res-count']";
    private static final String STANDARD_CODE_BUTTONS = "[class='standard-row'] [class*='btn-success']";

    public EnglishCommonCorePage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.ENGLISH_LANGUAGE_ARTS_PAGE_PATH);
    }

    public String getPageHeaderPathText() {
        return getTextForElement(PAGE_HEADER_PATH);
    }

    public String getPageTitle() {
        return getTextForElement(PAGE_TITLE);
    }

    public boolean isBackButtonDisplayed() {
        return isElementClickable(BACK_BUTTON);
    }

    public void clickOnBackButton() {
        clickElement(BACK_BUTTON);
    }

    public boolean isUseFiltersTextDisplayed() {
        return isElementClickable(USE_FILTERS_TEXT);
    }

    //******************************

    public String getFirstGradeCategory() {
        return getTextForElement(STANDARD_HEADERS, 0);
    }

    public String getSecondGradeCategory() {
        return getTextForElement(STANDARD_HEADERS, 1);
    }

    public String getThirdGradeCategory() {
        return getTextForElement(STANDARD_HEADERS, 2);
    }

    public void clickOnSubject(String subject) {
        clickElement(findElements(STANDARD_CATEGORIES), subject);
    }

    public String getStandardDescription() {
        return getTextForElement(STANDARD_INTRO);
    }

    public void clickOnStandardCodeButton(String standardCode) {
        clickElement(findElements(STANDARD_CODE_BUTTONS), standardCode);
    }

    public String getSeeResourcesButtonText() {
        return getTextForElement(STANDARD_SEE_RESOURCES_BUTTON);
    }

    public void clickOnSeeResourcesButton() {
        clickElement(STANDARD_SEE_RESOURCES_BUTTON);
    }

}

