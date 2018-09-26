package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class HowToUseVideoPage extends LpUiBasePage {

    private static final String X_BUTTON ="[class*='modal-content'] [class*='fa fa-times']";
    private static final String HOW_TO_USE_VIDEO_MODAL ="[class*='modal-content']";

    public HowToUseVideoPage(WebDriver driver) { super(driver); }

    public void clickOnXButton() { clickElement(X_BUTTON); }

    public void waitForModal() {
        waitForPageLoad();
        waitForElement(HOW_TO_USE_VIDEO_MODAL);
    }
}