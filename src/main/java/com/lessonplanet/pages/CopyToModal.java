package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CopyToModal extends LpUiBasePage {

    protected static final String CONFIRM_BUTTON = "[class='footer'] [class*='btn-primary']";
    private static final String NAME_INPUT = "[name='collectionTitle']";
    private static final String MY_RESOURCES_DESTINATION_FOLDER = "[class='folder-list'] li[class='list-option my-resources']";

    public CopyToModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForReactModalToBeVisible();
    }

    public void typeName(String name) {
        clearText(NAME_INPUT);
        sendKeys(NAME_INPUT, name);
    }

    public void clickOnCopyToSelectedFolderButton() {
        waitForModal();
        clickElement(CONFIRM_BUTTON);
    }

    public void clickMyResourcesDestinationFolder() {
        clickElement(MY_RESOURCES_DESTINATION_FOLDER);
    }
}
