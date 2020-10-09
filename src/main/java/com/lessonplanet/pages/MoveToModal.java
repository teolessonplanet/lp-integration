package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class MoveToModal extends CopyToModal {

    private static final String MY_RESOURCES_CHILD_DESTINATION_FOLDER = "[class='folder-list'] li:nth-child(2)";
    private static final String MY_RESOURCES_DESTINATION = "[class='folder-list'] li[class^='list-option my-resources']";

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

    public void clickOnMyResourcesDestinationFolder(){
        clickElement(MY_RESOURCES_DESTINATION);
    }
}
