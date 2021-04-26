package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class RemoveSharedFolderModal extends LpUiBasePage {

    private static final String TITLE_TEXT = "[class='react-modal'] [class='header']";
    private static final String CONTINUE_BUTTON = "[class='react-modal'] [class='footer'] [class*='btn btn-default btn-primary']";

    public RemoveSharedFolderModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(TITLE_TEXT);
    }

    public void clickOnContinueButton() {
        clickElement(CONTINUE_BUTTON);
    }
}
