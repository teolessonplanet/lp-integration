package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class DeleteFolderModal extends LpUiBasePage {

    private static final String TITLE_TEXT = "[class='react-modal'] [class='header']";
    private static final String CONTENT_TEXT = "[class='react-modal'] [class='content']";
    private static final String DELETE_BUTTON = "[class='react-modal'] [class='footer'] [class='btn btn-default btn-primary ml10']";

    public DeleteFolderModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(TITLE_TEXT);
    }

    public String getTitleText() {
        return getTextForElement(TITLE_TEXT);
    }

    public String getContentText(){
        return getTextForElement(CONTENT_TEXT);
    }

    public void clickOnDeleteButton(){
        clickElement(DELETE_BUTTON);
    }
}
