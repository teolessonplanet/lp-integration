package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class PostToModal extends CopyToModal {

    private static final String POST_TO_MODAL_ID = "#post-folder-modal-root";
    private static final String POST_TO_MODAL_TITLE_TEXT = "[class='header'] h3";
    private static final String BODY_TEXT = "[class='content']";
    private static final String YES_POST_BUTTON = "[class='footer'] [class='btn btn-default btn-primary ml10']";

    public PostToModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(POST_TO_MODAL_ID);
    }

    public void clickOnYesPostButton() {
        waitForModal();
        clickElement(YES_POST_BUTTON);
    }

    public String getPostToModalBoxyText() {
        return getTextForElement(BODY_TEXT);
    }

    public String getPostToModalTitleText(){
        return getTextForElement(POST_TO_MODAL_TITLE_TEXT);
    }
}
