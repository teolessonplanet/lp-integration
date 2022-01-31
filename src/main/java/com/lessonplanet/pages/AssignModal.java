package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class AssignModal extends LpUiBasePage {

    private static final String ASSIGN_MODAL = "#popup-modal";
    private static final String ASSIGN_MODAL_TEXT = "#set-player-password [class='control-label']";
    private static final String ACCESS_KEY_FIELD = "#shared_player_access_key";
    private static final String SAVE_BUTTON = "[class*='form-submit']";
    private static final String COPY_BUTTON = "[class*='copy-to-clipboard']";
    private static final String COPIED_LINK_POPOVER = "[class='tooltip fade top in']";
    private static final String RESET_ACCESS_KEY_LINK = "#reset-player-password";
    private static final String CLOSE_BUTTON = "#popup-modal [class='close']";
    private static final String GOOGLE_CLASSROOM_BUTTON = "#assign-in-google-classroom";
    private static final String ENABLED_GOOGLE_CLASSROOM_BUTTON = "#assign-in-google-classroom [src*='&url']";
    private static final String SHOW_ACCESS_KEY_BUTTON = "#show-player-password";
    private static final String PASSWORD_TEXT = "#player-password-holder [class='pw-text']";
    private static final String HIDE_ACCESS_KEY_BUTTON = "#hide-player-password";
    private static final String SHARE_LINK_TEXT = "input[class$='share-link-input']";

    public AssignModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(ASSIGN_MODAL);
    }

    public String getAssignModalText() {
        return getTextForElement(ASSIGN_MODAL_TEXT);
    }

    public void typeAccessKey(String key) {
        sendKeys(ACCESS_KEY_FIELD, key);
    }

    public String getAccessKeyFieldText() {
        return findElement(ACCESS_KEY_FIELD).getAttribute("value");
    }

    public void clickOnSaveButton() {
        clickElement(SAVE_BUTTON);
    }

    public void clickOnCopyButton() {
        clickElement(COPY_BUTTON);
    }

    public String getCopiedLinkPopoverText() {
        return getTextForElement(COPIED_LINK_POPOVER);
    }

    public void clickOnResetAccessKeyLink() {
        clickElement(RESET_ACCESS_KEY_LINK);
    }

    public boolean isAccessKeyFieldDisplayed() {
        return isElementDisplayed(ACCESS_KEY_FIELD);
    }

    public void clickOnCloseButton() {
        clickElement(CLOSE_BUTTON);
    }

    public void clickOnGoogleClassroomButton() {
        clickElement(GOOGLE_CLASSROOM_BUTTON);
    }

    public boolean isGoogleClassroomButtonEnabled() {
        return isElementDisplayed(ENABLED_GOOGLE_CLASSROOM_BUTTON);
    }

    public void clickOnShowAccessKeyButton() {
        clickElement(SHOW_ACCESS_KEY_BUTTON);
    }

    public String getPasswordText() {
        return getTextForElement(PASSWORD_TEXT);
    }

    public void clickOnHideAccessKeyButton() {
       clickElement(HIDE_ACCESS_KEY_BUTTON);
    }

    public String getShareLinkText() {
        return findElement(SHARE_LINK_TEXT).getAttribute("value");
    }
}
