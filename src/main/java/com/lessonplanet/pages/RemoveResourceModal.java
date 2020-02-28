package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class RemoveResourceModal extends LpUiBasePage {

    private static final String REMOVE_BUTTON = "[class='footer'] [class='lp-button lp-small-button lp-orange-button']";

    public RemoveResourceModal(WebDriver driver) {
        super(driver);
    }

    public void clickOnRemoveButton() {
        waitForElement(REMOVE_BUTTON);
        clickElement(REMOVE_BUTTON);
    }
}
