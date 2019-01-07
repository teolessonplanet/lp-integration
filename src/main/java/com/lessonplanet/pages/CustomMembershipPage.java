package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class CustomMembershipPage extends LpUiBasePage {

    private static final String SPECIAL_OFFERS_AND_CANCELLATIONS = "[class*='special-offers'] a";
    private static final String REASONS_DROPDOWN = "#s2id_cancellation_option_id";
    private static final String REASONS_DROPDOWN_OPTIONS = "[class='select2-result-label']";
    private static final String CONTINUE_BUTTON = "[value='Continue']";
    private static final String NO_THANKS_CONFIRM_CANCELLATION_BUTTON = "[data-method='delete']";

    public CustomMembershipPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.CUSTOM_MEMBERSHIP_PAGE_PATH);
    }

    public void clickOnSpecialOffersAndCancelationsButton() {
        clickElement(SPECIAL_OFFERS_AND_CANCELLATIONS);
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
        clickElement(NO_THANKS_CONFIRM_CANCELLATION_BUTTON);
    }
}
