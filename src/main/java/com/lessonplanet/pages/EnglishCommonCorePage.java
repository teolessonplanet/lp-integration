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

    public boolean isUseFiltersTextDisplayed(){
        return isElementClickable(USE_FILTERS_TEXT);
    }

    //******************************

//    public String


}

