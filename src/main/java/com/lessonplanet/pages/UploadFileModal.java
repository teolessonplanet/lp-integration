package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class UploadFileModal extends LpUiBasePage {
    private static final String UPLOAD_MODAL = "#upload-file-modal";
    private static final String CHOOSE_FILE_BUTTON = "#file";
    private static final String UPLOAD_BUTTON = "[class*='btn btn-action ml10 ']";
    private static final String DONE_BUTTON = "[class*='btn-primary done']";
    private static final String FOLDER_DROPDOWN = "[class*='folders-dropdown__dropdown-indicator']";
    private static final String FOLDER_DROPDOWN_INPUT = "[class*='folders-dropdown__indicator']";
    private static final String DISABLED_PUBLISH_BUTTON = "#upload-confirmation-content [class*='btn-primary disabled']";
    private static final String DISABLED_PUBLISH_BUTTON_POPOVER_TEXT = "[class*='popover'] [class='popover-content']";
    private static final String PUBLISH_ON_LESSON_PLANET_BUTTON = "[class*='confirm-buttons-group'] [class='btn btn-primary']:nth-child(1)";

    public UploadFileModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(UPLOAD_MODAL);
    }

    public void uploadUsingTextInput(String path) {
        uploadUsingTextInput(CHOOSE_FILE_BUTTON, path);
    }

    public void clickOnUploadButton() {
        scrollToElement(UPLOAD_BUTTON);
        clickElement(UPLOAD_BUTTON);
    }

    public void clickOnDoneButton() {
        scrollToElement(DONE_BUTTON);
        clickElement(DONE_BUTTON);
    }

    public void selectFolder() {
        clickElement(FOLDER_DROPDOWN);
        clickElement(FOLDER_DROPDOWN_INPUT);
    }

    public void hoverOverDisabledPublishButton() {
        hoverOverElement(DISABLED_PUBLISH_BUTTON);
    }

    public String getDisabledPublishButtonPopoverText() {
        return getTextForElement(DISABLED_PUBLISH_BUTTON_POPOVER_TEXT);
    }

    public void clickOnPublishOnLessonPlanetButton() {
        clickElement(PUBLISH_ON_LESSON_PLANET_BUTTON);
    }
}
