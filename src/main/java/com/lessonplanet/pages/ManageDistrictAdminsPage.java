package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ManageDistrictAdminsPage extends DistrictPage {

    protected static final String ADD_ADMIN_LINK = "[class='group-table admins'] [class*='placeholder'] a";
    private static final String TITLE_TEXT = "[class='se-manage-admins-title']";
    private static final String X_BUTTON = "[class='se-close-manage-admins']";
    private static final String ADMINS_LIST = "[class='group-table admins'] [class='group-row member member']";
    private static final String ADMIN_EMAIL_TEXT = "[class='group-table admins'] [class='group-row member member'] [class*='email']";
    private static final String REMOVE_BUTTON = "[class='group-table admins'] [class='group-row member member'] [class*='btn-danger']";
    private static final String REMOVE_BUTTON_POPOVER_TEXT = "[class='group-table admins'] [class='popuptext show']";
    private static final String ADD_ADMIN_LINK_REMOVE_BUTTON = "[class='group-table admins'] [class='group-row member placeholder'] [class*='btn-danger disabled']";
    private static final String EDIT_BUTTON = "[class='group-table admins'] [class='group-row member member'] [class*='btn-success']";
    private static final String EDIT_BUTTON_POPOVER_TEXT = "[class='group-table admins'] [class*='btn-success'] [class='popuptext show']";
    private static final String ADD_ADMIN_LINK_EDIT_BUTTON = "[class='group-table admins'] [class='group-row member placeholder'] [class*='btn-success disabled']";
    private static final String STARRED_ADMIN_ICON = "[class='group-table admins'] [class='group-row member member'] [class*='fa-asterisk']";
    private static final String STARRED_ADMIN_ICON_POPOVER_TEXT = "[class='group-table admins'] [class='group-row member member'] [class='popuptext show']";

    public ManageDistrictAdminsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return getTextForElement(TITLE_TEXT);
    }

    public void clickXButton() {
        clickElement(X_BUTTON);
    }

    public boolean isAdminsListDisplayed() {
        return isElementDisplayed(ADMINS_LIST);
    }

    public int getAdminsNumber() {
        final List<WebElement> resultsNumber = findElements(ADMINS_LIST);
        return resultsNumber.size();
    }

    public boolean isAdminEmailDisplayed(int index) {
        scrollToElement(ADMIN_EMAIL_TEXT, index);
        return isElementDisplayed(ADMIN_EMAIL_TEXT, index);
    }

    public String getAdminEmail(int adminPosition) {
        scrollToElement(ADMIN_EMAIL_TEXT, adminPosition);
        return getTextForElement(ADMIN_EMAIL_TEXT, adminPosition);
    }

    public boolean isRemoveButtonDisplayed(int index) {
        scrollToElement(REMOVE_BUTTON, index);
        return isElementDisplayed(REMOVE_BUTTON, index);
    }

    public void clickOnRemoveButton(int adminPosition) {
        scrollToElement(REMOVE_BUTTON, adminPosition);
        clickElement(REMOVE_BUTTON, adminPosition);
    }

    public void hoverOverRemoveButton(int i) {
        scrollToElement(REMOVE_BUTTON, i);
        hoverOverElement(REMOVE_BUTTON, i);
    }

    public String getRemoveButtonPopoverText() {
        return getTextForElement(REMOVE_BUTTON_POPOVER_TEXT);
    }

    public int getAddAdminLinkNumber() {
        final List<WebElement> linkNumber = findElements(ADD_ADMIN_LINK);
        return linkNumber.size();
    }

    public void clickOnAddAdminLink() {
        clickElement(ADD_ADMIN_LINK);
    }

    public boolean isAddAdminLinkRemoveButtonDisplayed(int i) {
        scrollToElement(ADD_ADMIN_LINK_REMOVE_BUTTON, i);
        return isElementDisplayed(ADD_ADMIN_LINK_REMOVE_BUTTON, i);
    }

    public boolean isEditButtonDisplayed(int index) {
        scrollToElement(EDIT_BUTTON, index);
        return isElementDisplayed(EDIT_BUTTON, index);
    }

    public void clickOnEditButton(int adminPosition) {
        clickElement(EDIT_BUTTON, adminPosition);
    }

    public void hoverOverEditButton(int i) {
        scrollToElement(EDIT_BUTTON, i);
        hoverOverElement(EDIT_BUTTON, i);
    }

    public String getEditButtonPopoverText() {
        return getTextForElement(EDIT_BUTTON_POPOVER_TEXT);
    }

    public boolean isAddAdminLinkEditButtonDisplayed(int i) {
        return isElementDisplayed(ADD_ADMIN_LINK_EDIT_BUTTON, i);
    }

    public void hoverOverStarredAdminIcon(int adminPos) {
        hoverOverElement(STARRED_ADMIN_ICON, adminPos);
    }

    public String getStarredAdminIconPopoverText(){
        return getTextForElement(STARRED_ADMIN_ICON_POPOVER_TEXT);
    }
}
