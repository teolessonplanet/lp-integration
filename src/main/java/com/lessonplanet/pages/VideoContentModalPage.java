package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class VideoContentModalPage extends LpUiBasePage {

    private static final String X_BUTTON = "[class='modal-header'] [class='close']";
    private static final String VIDEO_CONTENT_MODAL = "[class*='modal-content']";

    public VideoContentModalPage(WebDriver driver) {
        super(driver);
    }

    private void waitForModal() {
        waitForPageLoad();
        waitForElement(VIDEO_CONTENT_MODAL);
    }

    public void clickOnXButton() {
        waitForModal();
        clickElement(X_BUTTON);
    }
}
