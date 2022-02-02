package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class MoveToModal extends CopyToModal {

    private static final String FIRST_FOLDER_DESTINATION_FOLDER = "[class='folder-list'] li:nth-child(2)";

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
}
