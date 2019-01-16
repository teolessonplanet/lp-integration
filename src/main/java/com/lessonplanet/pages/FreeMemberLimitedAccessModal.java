package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class FreeMemberLimitedAccessModal extends LpUiBasePage {

    private static final String FREE_MEMBER_LIMITED_ACCESS_MODAL = "#free-signup-modal";
    private static final String EMAIL_ADDRESS_FIELD = "#free-signup-modal #free-signup-email";
    private static final String PASSWORD_FIELD = "#free-signup-modal #free-signup-password";
    private static final String GET_STARTED_BUTTON = "#free-signup-modal input[type='submit']";

    public FreeMemberLimitedAccessModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(FREE_MEMBER_LIMITED_ACCESS_MODAL);
    }

    public void typeEmailAddress(String email) {
        waitForModal();
        sendKeys(EMAIL_ADDRESS_FIELD, email);
    }

    public void typePassword(String password) {
        sendKeys(PASSWORD_FIELD, password);
    }

    public void clickOnGetStartedButton() {
        clickElement(GET_STARTED_BUTTON);
    }
}
