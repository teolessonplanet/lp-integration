package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class StateStandardsPage extends LpUiBasePage {

    private static final String ENGLISH_LANGUAGE_ARTS_BUTTON = "[href*='/english-language-arts']";
    private static final String MATHEMATICS_BUTTON = "[href*='/mathematics']";
    private static final String NGSS_BUTTON = "[href*='/nrcdsc']";

    private static final String SEARCH_STANDARDS_WIDGET = "#search-ss-widget";
    private static final String COMMON_CORE_DROPDOWN = "#s2id_js-ss-state";
    private static final String SUBJECT_DROPDOWN = "#s2id_subject";
    //    select2-container select2-container-disabled form-control
    private static final String GRADE_DROPDOWN = "#s2id_grade";
    private static final String KEYWORD_TEXTBOX = "#ss-keywords";
    private static final String SEARCH_BUTTON = "#js-ss-search";


    private static final String MAP = "#us-map-relative";
    private static final String MAP_GEORGIA_STATE = "#georgia";

    public StateStandardsPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.SEARCH_BY_STANDARD_PAGE_PATH);
    }

    public void clickOnEngilishLanguageArtsButton() {
        clickElement(ENGLISH_LANGUAGE_ARTS_BUTTON);
    }

    public void clickOnMathematicsButton() {
        clickElement(MATHEMATICS_BUTTON);
    }

    public void clickOnNgssButton() {
        clickElement(NGSS_BUTTON);
    }

    private void clickOnCommonCoreDropdown() {
        clickElement(COMMON_CORE_DROPDOWN);
    }

    private void clickOnGradeDropdown() {
        clickElement(GRADE_DROPDOWN);
    }

    public void typeKeywordSearch(String keyword) {
        sendKeys(KEYWORD_TEXTBOX, keyword);
    }
}
