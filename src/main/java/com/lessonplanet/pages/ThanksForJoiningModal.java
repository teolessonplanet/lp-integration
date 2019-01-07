package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class ThanksForJoiningModal extends LpUiBasePage {

    private static final String MODAL_TEXT = "div[class='modal-body'] p";

    public ThanksForJoiningModal(WebDriver driver) {
        super(driver);
    }

    public String getModalText(){
        return getTextForElement(MODAL_TEXT);
    }
}
