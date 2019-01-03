package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class EditResourceModal extends LpUiBasePage {
    private static final String EDIT_RESOURCE_MODAL = "#edit-file-modal";
    private static final String TITLE_INPUT = "[name='document[title]']";
    private static final String UPDATE_BUTTON = "[class*='textin 19']";

    public EditResourceModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(EDIT_RESOURCE_MODAL);
    }

    public void typeTitle(String title) {
        sendKeys(TITLE_INPUT, title);
    }

    public void clickOnUpdateButton() {
        clickElement(UPDATE_BUTTON);
    }
}
