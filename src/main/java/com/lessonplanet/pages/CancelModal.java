package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CancelModal extends LpUiBasePage {

    private static final String MODAL_ID = "#cancel_modal";
    private static final String MODAL_TITLE_TEXT = "#cancel_modal [class='modal-title']";
    private static final String MODAL_QUESTION_TEXT = "#cancel_modal [class='medium-type']";
    private static final String MODAL_YOUR_CURRENT_MEMBERSHIP_TEXT = "#cancel_modal [class*='lead']";
    private static final String MODAL_INDIVIDUAL_MEMBERSHIP_TEXT = "#cancel_modal [class*='modal-body'] h4";
    private static final String MODAL_CONTENT_ITEMS_TEXT = "#cancel_modal [class*='modal-body'] p";
    private static final String CONFIRM_CANCELLATION_INPUT = "#cancel_modal [class*='btn-action']";

    private static final String MODAL_WANT_TO_TRY_A_CHEAPER_PLAN_TEXT = "#cancel_modal h3";
    private static final String MODAL_PLAN_DETAILS_TEXT = "#cancel_modal [class='plan-feature']";


    private static final String YES_SIGN_UP_INPUT = "#cancel_modal input[value='Yes, Sign Up']";
    private static final String NO_THANKS_CONFIRM_CANCELLATION_LINK = "#cancel_modal [class*='btn-link']";


    public CancelModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(MODAL_ID);
    }

    public String getModalTitleText() {
        return getTextForElement(MODAL_TITLE_TEXT);
    }

    public String getModalQuestionText() {
        return getTextForElement(MODAL_QUESTION_TEXT);
    }

    public String getModalYourCurrentMembershipText() {
        return getTextForElement(MODAL_YOUR_CURRENT_MEMBERSHIP_TEXT);
    }

    public String getModalIndividualMembershipText() {
        return getTextForElement(MODAL_INDIVIDUAL_MEMBERSHIP_TEXT);
    }

    public String getCancelQuestionText() {
        return getTextForElement(MODAL_CONTENT_ITEMS_TEXT, 0);
    }

    public String getFullAccessMessageText() {
        return getTextForElement(MODAL_CONTENT_ITEMS_TEXT, 1);
    }

    public String getRenewalAmountText() {
        return getTextForElement(MODAL_CONTENT_ITEMS_TEXT, 2);
    }

    public String getRenewalDateText() {
        return getTextForElement(MODAL_CONTENT_ITEMS_TEXT, 3);
    }

    public String getNumberOfCollectionsText() {
        return getTextForElement(MODAL_PLAN_DETAILS_TEXT, 1);
    }

    public String getFreeTrialText() {
        return getTextForElement(MODAL_PLAN_DETAILS_TEXT, 2);
    }

    public String getBillingText() {
        return getTextForElement(MODAL_PLAN_DETAILS_TEXT, 3);
    }

    public String getModalWantToTryACheaperPlanText() {
        return getTextForElement(MODAL_WANT_TO_TRY_A_CHEAPER_PLAN_TEXT);
    }

    public void clickOnYesSignUpInput() {
        waitForModal();
        clickElement(YES_SIGN_UP_INPUT);
    }

    public void clickOnNoThanksConfirmCancellationButton() {
        waitForModal();
        clickElement(NO_THANKS_CONFIRM_CANCELLATION_LINK);
    }

    public void clickOnConfirmCancellation() {
        waitForModal();
        clickElement(CONFIRM_CANCELLATION_INPUT);
    }
}
