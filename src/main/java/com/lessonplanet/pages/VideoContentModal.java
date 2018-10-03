package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class VideoContentModal extends LpUiBasePage {

    private static final String X_BUTTON = "[class='modal-header'] [class='close']";

    public VideoContentModal(WebDriver driver) {
        super(driver);
    }

    public void clickOnXButton() {
        waitForElement(X_BUTTON);
        clickElement(X_BUTTON);
    }
}
