package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class SignInModal extends LpUiBasePage {

    private static final String MODAL_TITLE = "h4[class='modal-title']";
    private static final String CLOSE_BUTTON = "[class='close']";

    public SignInModal(WebDriver driver) {
        super(driver);
    }

    public String getModalTitle() {
        return findElement(MODAL_TITLE).getText();
    }

    public void clickOnClose() {
        clickElement(CLOSE_BUTTON);
    }
}
