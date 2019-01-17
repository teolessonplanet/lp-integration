package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CancelModal extends LpUiBasePage {

    private static final String MODAL_ID ="#cancel_modal";
    private static final String SUGGESTED_SUBSCRIPTION_TEXT = "#cancel_modal h4[class='panel-title']";
    private static final String YES_SIGN_UP_INPUT = "#cancel_modal input[value='Yes, Sign Up']";
    private static final String NO_THANKS_CONFIRM_CANCELLATION_LINK = "#cancel_modal [class*='btn-link']";

    public CancelModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal(){
        waitForBootstrapModalToBeVisible(MODAL_ID);
    }

    public String getSuggestedSubscriptionText() {
        return getTextForElement(SUGGESTED_SUBSCRIPTION_TEXT);
    }

    public void clickOnYesSignUpInput() {
        waitForModal();
        clickElement(YES_SIGN_UP_INPUT);
    }

    public void clickOnNoThanksConfirmCancellationButton() {
        waitForModal();
        clickElement(NO_THANKS_CONFIRM_CANCELLATION_LINK);
    }


}
