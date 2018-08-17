package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class StepOnePage extends LpUiBasePage {

    private static final String EMAIL_INPUT = "#user_email";
    private static final String PASSWORD_INPUT = "[class*='password optional'] #user_password";
    private static final String PRIVACY_POLICY_BUTTON = "[class='help-block text-muted'] a";
    private static final String GET_FREE_TRIAL_BUTTON = "#qa";
    private static final String ALREADY_A_MEMBER_BUTTON = "#login-link-no-underline";
    private static final String EMAIL_ERROR = "#user_email-error";

    public StepOnePage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.STEP_ONE_PAGE_PATH);
    }

    public void typeEmail(String email) {
        sendKeys(EMAIL_INPUT, email);
    }

    public void typePassword(String password) {
        sendKeys(PASSWORD_INPUT, password);
    }

    public void clickOnGetFreeTrialButton() {
        clickElement(GET_FREE_TRIAL_BUTTON);
        waitForPageLoad();
    }

    public void completeStepOne(String email, String password) {
        final String currentPath = getPath();
        loadPage();
        typeEmail(email);
        typePassword(password);
        clickOnGetFreeTrialButton();
        loadUrl(currentPath);
    }

    public void clickOnAlreayAMember() {
        clickElement(ALREADY_A_MEMBER_BUTTON);
    }

    public boolean isAlreadyAMemberButtonDisplayed() {
        return isElementClickable(ALREADY_A_MEMBER_BUTTON);
    }
}
