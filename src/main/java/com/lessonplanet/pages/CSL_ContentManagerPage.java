package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CSL_ContentManagerPage extends ContentManagerPage {

    private static final String RESOURCE_REMOVE_BUTTON = "[class='resources'] [class*='resource'] [class='action-panel'] button";
    private static final String RESOURCE_EDIT_BUTTON = "[class='resources'] [class*='resource'] [class='action-panel'] [href*='/edit']";

    private static final String ADD_A_RESOURCE_BUTTON = "[class*='content-manager-header'] [class*='add-resource lp-button']";
    private static final String NOTIFICATION_TEXT = "[class*='alert-success']";

    public CSL_ContentManagerPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddAResourceButton() {
        clickElement(ADD_A_RESOURCE_BUTTON);
    }

    public String getNotificationText() {
        return getTextForElement(NOTIFICATION_TEXT);
    }

    public void waitForNotificationToDisappear() {
        waitUntilElementIsHidden(NOTIFICATION_TEXT);
    }

    public void clickOnRemoveButton(int index) {
        findElements(RESOURCE_REMOVE_BUTTON).get(index).click();
    }

    public void clickOnEditResourceButton(int index) {
        findElements(RESOURCE_EDIT_BUTTON).get(index).click();
    }
}
