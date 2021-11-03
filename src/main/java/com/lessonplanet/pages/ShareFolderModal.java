package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class ShareFolderModal extends LpUiBasePage {

    private static final String SHARE_FOLDER_MODAL = "#share-modal-content-container";
    private static final String SHARE_FOLDER_MODAL_TEXT = "[class='share-with-title']";
    private static final String SHARE_FOLDER_MODAL_TITLE_TEXT = "[class='header'] h3";
    private static final String CANCEL_BUTTON = "[class='footer'] [class*='btn btn-default']";
    private static final String FOLDER_STATUS = "[class='folder-share-status']";
    private static final String ADD_EMAIL_INPUT_PLACEHOLDER_TEXT = "[class='email-container add-user-input'] input";
    private static final String DEFAULT_PERMISSION_TEXT = "#permissions-select-container [class='mr5']";
    private static final String MATCHING_OPTION = "[class='search-results'] li";
    private static final String ADD_EMAIL_INPUT = "[class='email-container add-user-input'] input";
    private static final String SHARE_FOLDER_BUTTON = "[class='footer'] [class*='btn btn-default btn-primary']";
    private static final String USER_NAME = "[class='users-container enabled'] [class='sw-user-container'] [class='sw-user']";
    private static final String USER_EMAIL = "[class='users-container enabled'] [class='sw-user-container'] [class='sw-user'] [class='sw-user-email']";
    private static final String OWNER_ROLE = "[class='users-container enabled'] [class='sw-user-container']:nth-child(1) [class*='sw-owner']";
    private static final String X_BUTTON = "[class='users-container enabled'] [class='sw-user-container'] [class='remove-user-button']";
    private static final String PERMISSION_OPTION_TEXT = "[class='users-container enabled'] [class='sw-user-container'] [class='permissions-container'] #permissions-select-container";
    private static final String PERMISSIONS_DROPDOWN = "#permissions-select-container i";
    private static final String CAN_EDIT_PERMISSION = "[data-permission='can_edit']";

    public ShareFolderModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(SHARE_FOLDER_MODAL);
    }

    public boolean isShareFolderModalDisplayed() {
        return isElementDisplayed(SHARE_FOLDER_MODAL);
    }

    public String getShareFolderModalTitle() {
        return getTextForElement(SHARE_FOLDER_MODAL_TITLE_TEXT);
    }

    public String getShareFolderModalText() {
        return getTextForElement(SHARE_FOLDER_MODAL_TEXT);
    }

    public void clickOnCancelButton() {
        clickElement(CANCEL_BUTTON);
    }

    public void clickOnShareFolderButton() {
        clickElement(SHARE_FOLDER_BUTTON);
    }

    public String getFolderStatus() {
        return getTextForElement(FOLDER_STATUS);
    }

    public String getPermissionText() {
        return getTextForElement(DEFAULT_PERMISSION_TEXT);
    }

    public void typeUser(String email) {
        findElement(ADD_EMAIL_INPUT).sendKeys(email);
        clickElement(MATCHING_OPTION);
    }

    public String getAddEmailInputPlaceholderText() {
        return findElement(ADD_EMAIL_INPUT_PLACEHOLDER_TEXT).getAttribute("placeholder");
    }

    public void clearEmailInput() {
        clearText(ADD_EMAIL_INPUT);
    }

    public String getNoUserFoundText() {
        return getTextForElement(MATCHING_OPTION);
    }

    public void hoverOverUser() {
        hoverOverElement(USER_NAME, 1);
    }

    public String getUserPermission() {
        return getTextForElement(PERMISSION_OPTION_TEXT, 0);
    }

    public void hoverOverOwner() {
        hoverOverElement(USER_NAME, 0);
    }

    public String getUserEmail() {
        return getTextForElement(USER_EMAIL, 1);
    }

    public String getOwnerEmail() {
        return getTextForElement(USER_EMAIL, 0);
    }

    public String getUserName() {
        return getTextForElement(USER_NAME, 1);
    }

    public String getOwnerName() {
        return getTextForElement(USER_NAME, 0);
    }

    public String getOwnerRole() {
        return getTextForElement(OWNER_ROLE);
    }

    public boolean isXButtonDisplayed() {
        return isElementDisplayed(X_BUTTON, 0);
    }

    public void removeUser() {
        clickElement(X_BUTTON, 0);
    }

    public void chooseCanEditPermissions() {
        clickElement(PERMISSIONS_DROPDOWN);
        clickElementUsingJavaScriptExecutor(CAN_EDIT_PERMISSION);
    }
}
