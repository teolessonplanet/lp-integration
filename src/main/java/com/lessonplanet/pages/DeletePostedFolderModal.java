package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class DeletePostedFolderModal extends CopyToModal {

    public DeletePostedFolderModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForReactModalToBeVisible();
    }

    public void clickOnDeleteButton() {
        clickElement(CONFIRM_BUTTON);
    }
}
