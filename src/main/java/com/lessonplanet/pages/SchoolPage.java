package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SchoolPage extends ManageDistrictPage {

    private static final String FLASH_NOTIFICATION_TEXT = "#se-flash-message";
    private static final String FLASH_NOTIFICATION_X_BUTTON = "#se-flash-message [class='close']";
    private static final String TEACHER_FIRST_NAME_TEXT = "[class='group-table children'] div[class*='first-name']";
    private static final String TEACHER_LAST_NAME_TEXT = "[class='group-table children'] div[class*='last-name']";
    private static final String TEACHER_EMAIL_TEXT = "[class='group-table children']  div[class*='email']";
    private static final String ADD_LINK_DISABLED = "[class='group-table children'] [class*='placeholder'] [class='bold disabled popup']";

    public SchoolPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTeachersListDisplayed() {
        return isElementDisplayed(TEACHERS_LIST);
    }

    public String getFlashNotificationText() {
        return getTextForElement(FLASH_NOTIFICATION_TEXT);
    }

    public void dismissFlashNotification() {
        clickElement(FLASH_NOTIFICATION_X_BUTTON);
    }

    public boolean isTeacherEmailDisplayed(int position) {
        scrollToElement(TEACHER_EMAIL_TEXT, position);
        return isElementDisplayed(TEACHER_EMAIL_TEXT, position);
    }

    public String getTeacherEmail(int position) {
        scrollToElement(TEACHER_EMAIL_TEXT, position);
        return getTextForElement(TEACHER_EMAIL_TEXT, position);
    }

    public String getTeacherFirstName(int position) {
        scrollToElement(TEACHER_FIRST_NAME_TEXT, position);
        return getTextForElement(TEACHER_FIRST_NAME_TEXT, position);
    }

    public String getTeacherLastName(int position) {
        scrollToElement(TEACHER_LAST_NAME_TEXT, position);
        return getTextForElement(TEACHER_LAST_NAME_TEXT, position);
    }

    public int getAddLinkDisabledNumber() {
        final List<WebElement> linkNumber = findElements(ADD_LINK_DISABLED);
        return linkNumber.size();
    }
}
