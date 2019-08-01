package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SchoolPage extends DistrictPage {

    private static final String DISTRICT_BREADCRUMBS = "[class='go-to-parent']";
    private static final String FLASH_NOTIFICATION_TEXT = "#se-flash-message";
    private static final String FLASH_NOTIFICATION_X_BUTTON = "#se-flash-message [class='close']";
    private static final String TEACHERS_LIST = "[class='group-table children'] [class='group-body'] [class='group-row member member']";
    private static final String TEACHER_FIRST_NAME_TEXT = "[class='group-table children'] div[class*='first-name']";
    private static final String TEACHER_LAST_NAME_TEXT = "[class='group-table children'] div[class*='last-name']";
    private static final String TEACHER_EMAIL_TEXT = "[class='group-table children']  div[class*='email']";
    private static final String TEACHER_ROLE_TEXT = "[class='group-table children'] div[class*='role']";
    private static final String TEACHER_JOINED_DATE_TEXT = "[class='group-table children'] div[class*='joined-on ']";

    public SchoolPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDistrictBreadcrumbsDisplayed() {
        return isElementDisplayed(DISTRICT_BREADCRUMBS);
    }

    public void clickOnDistrictBreadcrumbs() {
        clickElement(DISTRICT_BREADCRUMBS);
    }

    public boolean isTeachersListDisplayed() {
        return isElementDisplayed(TEACHERS_LIST);
    }

    public int getTeachersNumber() {
        final List<WebElement> searchList = findElements(TEACHERS_LIST);
        return searchList.size();
    }

    public String getFlashNotificationText() {
        return getTextForElement(FLASH_NOTIFICATION_TEXT);
    }

    public void dismissFlashNotification() {
        clickElement(FLASH_NOTIFICATION_X_BUTTON);
    }

    public boolean isTeacherEmailDisplayed(int position) {
        return isElementDisplayed(TEACHER_EMAIL_TEXT, position);
    }

    public String getTeacherEmail(int position) {
        return getTextForElement(TEACHER_EMAIL_TEXT, position);
    }

    public String getTeacherFirstName(int position) {
        return getTextForElement(TEACHER_FIRST_NAME_TEXT, position);
    }

    public String getTeacherLastName(int position) {
        return getTextForElement(TEACHER_LAST_NAME_TEXT, position);
    }

    public String getTeacherRole(int position) {
        return getTextForElement(TEACHER_ROLE_TEXT, position);
    }

    public String getTeacherJoinedDate(int position) {
        return getTextForElement(TEACHER_JOINED_DATE_TEXT, position);
    }
}
