package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ManageDistrictPage extends DistrictPage {
    private static final String ACCOUNT_MANAGER_BREADCRUMBS = "[class*='go-to-parent']";
    private static final String EDIT_ORGANIZATION_BUTTON = "[class*='se-edit-org-info']";
    private static final String MANAGE_ADMINS_BUTTON = "[class*='se-edit-org-admins']";
    protected static final String TEACHERS_LIST = "[class='group-table children'] [class='group-body'] [class='group-row member member']";
    private static final String TEACHER_ROLE_TEXT = "[class='group-table children'] [class='group-row member member'] [class='info role']";
    private static final String TEACHER_JOINED_DATE_TEXT = "[class='group-table children'] div[class*='joined-on ']";

    public ManageDistrictPage(WebDriver driver) {
        super(driver);
    }

    public boolean isManageAdminsButtonDisplayed() {
        return isElementDisplayed(MANAGE_ADMINS_BUTTON);
    }

    public void clickOnManageAdminsButton() {
        clickElement(MANAGE_ADMINS_BUTTON);
    }

    public void clickOnEditOrganizationButton() {
        clickElement(EDIT_ORGANIZATION_BUTTON);
    }

    public boolean isEditOrganizationButtonDisplayed() {
        return isElementDisplayed(EDIT_ORGANIZATION_BUTTON);
    }

    public boolean isAccountManagerBreadcrumbsDisplayed() {
        return isElementDisplayed(ACCOUNT_MANAGER_BREADCRUMBS);
    }

    public void clickOnAccountManagerBreadcrumbs() {
        clickElement(ACCOUNT_MANAGER_BREADCRUMBS);
    }

    public int getTeachersNumber() {
        final List<WebElement> searchList = findElements(TEACHERS_LIST);
        return searchList.size();
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
