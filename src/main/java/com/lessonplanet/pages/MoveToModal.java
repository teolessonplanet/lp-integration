package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class MoveToModal extends CopyToModal {

    private static final String FIRST_FOLDER_DESTINATION_FOLDER = "[class='folder-list'] li:nth-child(2)";
    private static final String BODY_TEXT = "[class='please-text']";
    private static final String CANCEL_BUTTON = "[class='footer modal-footer'] [class='btn btn-default']";

    public MoveToModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForReactModalToBeVisible();
    }

    public void clickOnMoveToSelectedFolderButton() {
        waitForModal();
        clickElement(CONFIRM_BUTTON);
    }

    public void clickOnDestinationFolder() {
        clickElement(FIRST_FOLDER_DESTINATION_FOLDER);
    }

    public void clickOnCancelButton() {
        clickElement(CANCEL_BUTTON);
    }

    public String getMoveToModalBodyText() {
        return getTextForElement(BODY_TEXT);
    }
}
