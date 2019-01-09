package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class CustomMembershipPage extends LpUiBasePage {

    private static final String SPECIAL_OFFERS_AND_CANCELLATIONS_LINK = "[class*='special-offers'] a";
    private static final String REASONS_DROPDOWN = "#s2id_cancellation_option_id";
    private static final String REASONS_DROPDOWN_OPTIONS = "[class='select2-result-label']";
    private static final String CONTINUE_BUTTON = "[class='btn btn-primary mt10']";
    private static final String NO_THANKS_CONFIRM_CANCELLATION_LINK = "#cancel_modal [class*='btn-link']";

    public CustomMembershipPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.CUSTOM_MEMBERSHIP_PAGE_PATH);
    }

    public void clickOnSpecialOffersAndCancellationsLink() {
        clickElement(SPECIAL_OFFERS_AND_CANCELLATIONS_LINK);
    }

    public void clickOnReasonsDropdown() {
        clickElement(REASONS_DROPDOWN);
    }

    public void selectOptionFromDropDown(String option) {
        clickElement(findElements(REASONS_DROPDOWN_OPTIONS), option);
    }

    public void clickOnContinueButton() {
        clickElement(CONTINUE_BUTTON);
    }

    public void clickOnNoThanksConfirmCancellationButton() {
        clickElement(NO_THANKS_CONFIRM_CANCELLATION_LINK);
    }
}
