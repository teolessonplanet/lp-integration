package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class AssignModal extends LpUiBasePage {

    private static final String ASSIGN_MODAL = "#popup-modal";
    private static final String ASSIGN_MODAL_TEXT = "[class='control-label']";
    private static final String ACCESS_KEY_FIELD = "#shared_player_access_key";
    private static final String SAVE_BUTTON = "[class*='form-submit']";
    private static final String COPY_BUTTON = "[class*='copy-to-clipboard']";
    private static final String COPIED_LINK_POPOVER = "[class='tooltip fade top in']";
    private static final String RESET_ACCESS_KEY_LINK = "#reset-player-password";
    private static final String CLOSE_BUTTON = "#popup-modal [class='close']";

    public AssignModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(ASSIGN_MODAL);
    }

    public String getAssignModalText() {
        return getTextForElement(ASSIGN_MODAL_TEXT );
    }

    public void typeAccessKey(String key) {
        sendKeys(ACCESS_KEY_FIELD, key);
    }

    public void clickOnSaveButton(){
        clickElement(SAVE_BUTTON);
    }

    public void clickOnCopyButton(){
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
}
