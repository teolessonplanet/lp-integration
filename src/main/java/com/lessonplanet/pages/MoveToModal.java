package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class MoveToModal extends CopyToModal {

    private static final String MY_RESOURCES_CHILD_DESTINATION_FOLDER = "[class='folder-list'] div div";

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

    public void clickOnMyResourcesChildDestinationFolder() {
        clickElement(MY_RESOURCES_CHILD_DESTINATION_FOLDER);
    }
}
