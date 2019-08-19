package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

import java.util.List;

public class DistrictPage extends LpUiBasePage {

    private static final String ADD_BUTTON = "[class*='se-add-school']";
    private static final String ADD_LINK = "[class='group-table children'] [class*='placeholder'] a";
    private static final String ADD_LINK_EDIT_BUTTON = "[class='group-table children'] [class*='placeholder'] [class*='btn-success']";
    private static final String ADD_LINK_REMOVE_BUTTON = "[class='group-table children'] [class*='placeholder'] [class*='btn-danger']";
    private static final String ADD_LINK_SEE_REPORTING_BUTTON = "[class='group-table children'] [class*='placeholder'] [class*='btn-primary']";

    private static final String ORGANIZATION_NAME = "[class='se-org-name']";
    private static final String EDIT_ORGANIZATION_BUTTON = "[class*='se-edit-org-info']";
    private static final String EDIT_ORGANIZATION_BUTTON_POPOVER_TEXT = "[class*='se-edit-org-info'] [class='popuptext show']";
    private static final String MANAGE_ADMINS_BUTTON = "[class*='se-edit-org-admins']";
    private static final String MANAGE_ADMINS_POPOVER_TEXT = "[class*='se-edit-org-admins'] [class='popuptext show']";
    private static final String SEARCH_BUTTON = "[class*='se-member-search']";
    private static final String SEARCH_BUTTON_POPOVER_TEXT = "[class*='se-member-search'] [class='popuptext show']";

    private static final String SCHOOLS_LIST = "[class='group-row org school']";
    private static final String SCHOOL_NAME_TEXT = "[class='group-row org school'] [class*='name'] a";
    private static final String NR_OF_TEACHERS_TEXT = "[class='group-row org school'] [class*='members-count']";
    private static final String NR_OF_RESOURCES_UPLOADED_TEXT = "[class='group-row org school'] [class*='uploads-count']";
    private static final String SEE_SCHOOL_REPORTING_BUTTON = "[class='group-row org school'] [class*='btn-primary']";
    private static final String EDIT_ACTION_BUTTON = "[class='group-table children']  [class*='btn-success']";
    private static final String EDIT_ACTION_BUTTON_POPOVER_TEXT = "[class='group-table children'] [class*='btn-success'] [class='popuptext show']";
    private static final String REMOVE_ACTION_BUTTON = "[class='group-table children']  [class*='btn-danger']";
    private static final String REMOVE_ACTION_BUTTON_POPOVER_TEXT = "[class='group-table children'] [class*='btn-danger'] [class='popuptext show']";

    private static final String NOTIFICATION_TEXT = "#notification";
    private static final String NOTIFICATION_X_BUTTON = "#notification [class='close']";

    private static final String SEARCH_TEXT_FIELD = "#input-field";
    private static final String CLEAR_SEARCH_BUTTON = "#clear-search";
    private static final String RESULTS_SEARCH_TEXT = "[class='search-result-container']";
    private static final String NO_RESULTS_SEARCH_TEXT = "[class='no-results-search']";

    private static final String TEACHERS_LIST = "[class='group-table children'] [class='group-body'] [class='group-row org member']";
    private static final String TEACHER_FIRST_NAME_TEXT = "[class='group-table children'] [class='group-row org member'] div[class*='first-name']";
    private static final String TEACHER_LAST_NAME_TEXT = "[class='group-table children'] [class='group-row org member'] div[class*='last-name']";
    private static final String TEACHER_EMAIL_TEXT = "[class='group-table children'] [class='group-row org member'] div[class*='email']";
    private static final String TEACHER_SCHOOL_TEXT = "[class='group-table children'] [class='group-row org member'] div[class*='school-name']";
    private static final String TEACHER_ROLE_TEXT = "[class='group-table children'] [class='group-row org member'] div[class*='role']";
    private static final String TEACHER_JOINED_DATE_TEXT = "[class='group-table children'] [class='group-row org member'] div[class*='joined-on ']";

    public DistrictPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.ACCOUNT_MANAGER_PAGE_PATH);
    }

    public boolean isSchoolListDisplayed() {
        return isElementDisplayed(SCHOOLS_LIST);
    }

    public String getSchoolName(int position) {
        return getTextForElement(SCHOOL_NAME_TEXT, position);
    }

    public void clickOnSchool(int position) {
        clickElement(SCHOOL_NAME_TEXT, position);
    }

    public void clickOnExistingSchool(String schoolName) {
        for (int i = 0; i < getSchoolsNumber(); i++) {
            if (getTextForElement(SCHOOL_NAME_TEXT, i).equals(schoolName)) {
                clickElement(SCHOOL_NAME_TEXT, i);
            }
        }
    }

    public int getSchoolsNumber() {
        final List<WebElement> resultsNumber = findElements(SCHOOLS_LIST);
        return resultsNumber.size();
    }

    public boolean isOrganizationNameDisplayed() {
        return isElementDisplayed(ORGANIZATION_NAME);
    }

    public String getOrganizationName() {
        return getTextForElement(ORGANIZATION_NAME);
    }

    public boolean isEditOrganizationButtonDisplayed() {
        return isElementDisplayed(EDIT_ORGANIZATION_BUTTON);
    }

    public boolean isManageAdminsButtonDisplayed() {
        return isElementDisplayed(MANAGE_ADMINS_BUTTON);
    }

    public boolean isSearchButtonDisplayed() {
        return isElementDisplayed(SEARCH_BUTTON);
    }

    public void clickOnEditOrganizationButton() {
        clickElement(EDIT_ORGANIZATION_BUTTON);
    }

    public void clickOnManageAdminsButton() {
        clickElement(MANAGE_ADMINS_BUTTON);
    }

    public void clickOnSearchButton() {
        clickElement(SEARCH_BUTTON);
    }

    public String getManageAdminsPopoverText() {
        return getTextForElement(MANAGE_ADMINS_POPOVER_TEXT);
    }

    public String getEditOrganizationButtonPopoverText() {
        return getTextForElement(EDIT_ORGANIZATION_BUTTON_POPOVER_TEXT);
    }

    public String getSearchButtonPopoverText() {
        return getTextForElement(SEARCH_BUTTON_POPOVER_TEXT);
    }

    public void hoverOverManageAdminsButton() {
        hoverOverElement(MANAGE_ADMINS_BUTTON);
    }

    public void hoverOverEditOrganizationButton() {
        hoverOverElement(EDIT_ORGANIZATION_BUTTON);
    }

    public void hoverOverSearchButton() {
        hoverOverElement(SEARCH_BUTTON);
    }

    public boolean isAddButtonDisplayed() {
        return isElementDisplayed(ADD_BUTTON);
    }

    public boolean isSchoolNameDisplayed() {
        return isElementDisplayed(SCHOOL_NAME_TEXT);
    }

    public boolean isNrOfTeachersDisplayed() {
        return isElementDisplayed(NR_OF_TEACHERS_TEXT);
    }

    public boolean isNrOfResourcesUploadedDisplayed() {
        return isElementDisplayed(NR_OF_RESOURCES_UPLOADED_TEXT);
    }

    public boolean isSeeSchoolReportingActionButtonDisplayed(int index) {
        return isElementDisplayed(SEE_SCHOOL_REPORTING_BUTTON, index);
    }

    public boolean isEditActionButtonDisplayed(int position) {
        return isElementDisplayed(EDIT_ACTION_BUTTON, position);
    }

    public void hoverOverEditButton(int position) {
        scrollToElement(EDIT_ACTION_BUTTON, position);
        hoverOverElement(EDIT_ACTION_BUTTON, position);
    }

    public String getEditButtonPopoverText() {
        return getTextForElement(EDIT_ACTION_BUTTON_POPOVER_TEXT);
    }

    public boolean isRemoveActionButtonDisplayed(int position) {
        return isElementDisplayed(REMOVE_ACTION_BUTTON, position);
    }

    public void hoverOverRemoveButton(int i) {
        scrollToElement(REMOVE_ACTION_BUTTON, i);
        hoverOverElement(REMOVE_ACTION_BUTTON, false, i);
    }

    public String getRemoveButtonPopoverText() {
        return getTextForElement(REMOVE_ACTION_BUTTON_POPOVER_TEXT);
    }

    public void clickOnAddButton() {
        clickElement(ADD_BUTTON);
    }

    public void clickEditActionButton(int position) {
        clickElement(EDIT_ACTION_BUTTON, position);
    }

    public void clickRemoveActionButton(int position) {
        clickElement(REMOVE_ACTION_BUTTON, position);
    }

    public String getNotificationText() {
        return getTextForElement(NOTIFICATION_TEXT);
    }

    public void dismissNotification() {
        clickElement(NOTIFICATION_X_BUTTON);
    }

    public void clickOnAddLink() {
        clickElement(ADD_LINK);
    }

    public int getAddLinkNumber() {
        final List<WebElement> linkNumber = findElements(ADD_LINK);
        return linkNumber.size();
    }

    public boolean isAddLinkRemoveButtonDisplayed(int position) {
        return isElementDisplayed(ADD_LINK_REMOVE_BUTTON, position);
    }

    public boolean isAddLinkEditButtonDisplayed(int position) {
        scrollToElement(ADD_LINK_EDIT_BUTTON, position);
        return isElementDisplayed(ADD_LINK_EDIT_BUTTON, position);
    }

    public boolean isAddLinkSeeSchoolReportingButtonDisplayed(int position) {
        scrollToElement(ADD_LINK_SEE_REPORTING_BUTTON, position);
        return isElementDisplayed(ADD_LINK_SEE_REPORTING_BUTTON, position);
    }

    public void typeText(String text) {
        sendKeys(SEARCH_TEXT_FIELD, text);
    }

    public String getSearchResultsText() {
        return getTextForElement(RESULTS_SEARCH_TEXT);
    }

    public void clickClearSearchButton() {
        clickElement(CLEAR_SEARCH_BUTTON);
    }

    public String getNoSearchResultsText() {
        return getTextForElement(NO_RESULTS_SEARCH_TEXT);
    }

    public boolean isTeachersListDisplayed() {
        return isElementDisplayed(TEACHERS_LIST);
    }

    public int getTeachersNumber() {
        final List<WebElement> searchList = findElements(TEACHERS_LIST);
        return searchList.size();
    }

    public boolean isTeacherEmailDisplayed(int position) {
        return isElementDisplayed(TEACHER_EMAIL_TEXT, position);
    }

    public String getTeacherEmail(int position) {
        return getTextForElement(TEACHER_EMAIL_TEXT, position);
    }

    public boolean isTeacherSchoolDisplayed(int position) {
        return isElementDisplayed(TEACHER_SCHOOL_TEXT, position);
    }

    public String getTeacherFirstName(int position) {
        scrollToElement(TEACHER_FIRST_NAME_TEXT, position);
        return getTextForElement(TEACHER_FIRST_NAME_TEXT, position);
    }

    public String getTeacherLastName(int position) {
        scrollToElement(TEACHER_LAST_NAME_TEXT, position);
        return getTextForElement(TEACHER_LAST_NAME_TEXT, position);
    }

    public String getTeacherRole(int position) {
        scrollToElement(TEACHER_ROLE_TEXT, position);
        return getTextForElement(TEACHER_ROLE_TEXT, position);
    }

    public String getTeacherJoinedDate(int position) {
        scrollToElement(TEACHER_JOINED_DATE_TEXT, position);
        return getTextForElement(TEACHER_JOINED_DATE_TEXT, position);
    }
}
