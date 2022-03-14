package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CopyToModal extends LpUiBasePage {

    protected static final String CONFIRM_BUTTON = "[class*='footer'] [class*='btn btn-default btn-primary']";
    private static final String NAME_INPUT = "[name='collection[title]']";
    private static final String MY_RESOURCES_DESTINATION_FOLDER = "[class='folder-list'] li[class='list-option my-resources']";
    private static final String MY_RESOURCES_TAB = "[class='content modal-body transfer-modal'] [class='root-option']:nth-child(2)";

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

    public void clickOnMyResourcesDestinationFolder() {
        clickElement(MY_RESOURCES_DESTINATION_FOLDER);
    }

    public void chooseMyResourcesTab() {
        clickElement(MY_RESOURCES_TAB);
    }

    public boolean isMyResourcesTabDisplayed() {
        return isElementDisplayed(MY_RESOURCES_TAB);
    }
}
