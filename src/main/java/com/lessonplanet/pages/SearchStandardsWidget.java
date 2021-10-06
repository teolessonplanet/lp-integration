package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class SearchStandardsWidget extends LpUiBasePage {

    private static final String SEARCH_STANDARDS_TITLE = "#search-ss-widget h4 [class*='fa-search']";
    private static final String STATE_DROPDOWN = "#s2id_js-ss-state";
    private static final String STATE_DROPDOWN_OPTIONS = "[class*='select2-results-dept-1']";
    private static final String SUBJECT_DROPDOWN = "#s2id_subject";
    private static final String SUBJECT_DROPDOWN_DISABLED = "#s2id_subject[class*='disabled']";
    private static final String SUBJECT_DROPDOWN_ENABLED = "#s2id_subject:not([class*='disabled'])";
    private static final String GRADE_DROPDOWN = "#s2id_grade";
    private static final String GRADE_DROPDOWN_OPTIONS = "[class*='select2-results-dept-0']";
    private static final String KEYWORD_TEXTBOX = "#ss-keywords";
    private static final String SEARCH_BUTTON = "#js-ss-search";
    private static final String ALL_STATES = "#js-ss-state";
    private static final String ALL_SUBJECTS = "#subject";
    private static final String ALL_GRADES = "#grade";
    private static final String CONTROL_LABELS = "[class='control-label']";

    public SearchStandardsWidget(WebDriver driver) {
        super(driver);
    }

    public String getSearchStandardsTitleText() {
        return getTextForElement(SEARCH_STANDARDS_TITLE);
    }

    public void clickOnStateDropdown() {
        clickElement(STATE_DROPDOWN);
    }

    public void setStateDropdownOption(String optionToSelect) {
        clickElement(findElements(STATE_DROPDOWN_OPTIONS), optionToSelect);
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

    public void clickOnSearchButton() {
        clickElement(SEARCH_BUTTON);
    }

    public boolean isSubjectDropdownDisabled() {
        return isElementClickable(SUBJECT_DROPDOWN_DISABLED);
    }

    public boolean isSubjectDropdownEnabled() {
        return isElementClickable(SUBJECT_DROPDOWN_ENABLED);
    }

    public String getStateLabelText() {
        return getTextForElement(findElements(CONTROL_LABELS).get(0));
    }

    public String getSubjectLabelText() {
        return getTextForElement(findElements(CONTROL_LABELS).get(1));
    }

    public String getGradeLabelText() {
        return getTextForElement(findElements(CONTROL_LABELS).get(2));
    }

    public String getKeywordLabelText() {
        return getTextForElement(findElements(CONTROL_LABELS).get(3));
    }

    public String getStateDropdownText() {
        return getTextForElement(STATE_DROPDOWN);
    }

    public String getSubjectDropdownText() {
        return getTextForElement(SUBJECT_DROPDOWN);
    }

    public String getGradeDropdownText() {
        return getTextForElement(GRADE_DROPDOWN);
    }

    public String getKeywordTextboxText() {
        return getTextForElement(KEYWORD_TEXTBOX);
    }

    public String getSearchButtonText() {
        return getTextForElement(SEARCH_BUTTON);
    }

    public String getAllStates() {
        return getTextForElement(ALL_STATES);
    }

    public String getAllSubjects() {
        return getTextForElement(ALL_SUBJECTS);
    }

    public String getAllGrades() {
        return getTextForElement(ALL_GRADES);
    }
}
