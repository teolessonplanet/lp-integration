package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class SearchStandardsWidget extends LpUiBasePage {

    private static final String SEARCH_STANDARDS_WIDGET = "#search-ss-widget";
    private static final String COMMON_CORE_DROPDOWN = "#s2id_js-ss-state";
    private static final String COMMON_CORE_DROPDOWN_OPTIONS = "[class*='select2-results-dept-1']";
    private static final String SUBJECT_DROPDOWN = "#s2id_subject";
    private static final String SUBJECT_DROPDOWN_DISABLED = "#s2id_subject[class*='disabled']";
    private static final String SUBJECT_DROPDOWN_ENABLED = "#s2id_subject:not([class*='disabled'])";
    private static final String GRADE_DROPDOWN = "#s2id_grade";
    private static final String GRADE_DROPDOWN_OPTIONS = "[class*='select2-results-dept-0']";
    private static final String KEYWORD_TEXTBOX = "#ss-keywords";
    private static final String SEARCH_BUTTON = "#js-ss-search";

    public SearchStandardsWidget(WebDriver driver) {
        super(driver);
    }

    public String getSearchStandardsWidgetText() {
        return getTextForElement(SEARCH_STANDARDS_WIDGET);
    }

    public void clickOnCommonCoreDropdown() {
        clickElement(COMMON_CORE_DROPDOWN);
    }

    public void setCommonCoreDropdownOption(String optionToSelect) {
        clickElement(findElements(COMMON_CORE_DROPDOWN_OPTIONS), optionToSelect);
    }

    public void clickOnGradeDropdown() {
        clickElement(GRADE_DROPDOWN);
    }

    public void setGradeDropdownOptions(String gradeToSelect) {
        clickElement(findElements(GRADE_DROPDOWN_OPTIONS), gradeToSelect);
    }

    public void typeKeywordSearch(String keyword) {
        sendKeys(KEYWORD_TEXTBOX, keyword);
    }

    public void clearKeywordSearch() {
        clearText(KEYWORD_TEXTBOX);
    }

    public void clickOnSearchButton() {
        clickElement(SEARCH_BUTTON);
    }

    public boolean isSubjectDropdownDisabled() {
        return isElementClickable(SUBJECT_DROPDOWN_DISABLED);
    }

    public boolean isSubjectDropdownEnabled() {
        return isElementClickable(SUBJECT_DROPDOWN_ENABLED);
    }
}
