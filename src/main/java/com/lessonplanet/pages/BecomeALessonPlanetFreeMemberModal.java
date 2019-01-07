package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class BecomeALessonPlanetFreeMemberModal extends LpUiBasePage {

    private static final String FREE_MEMBER_BUTTON = "a[class='free-member-link']";
    private static final String TEN_DAYS_FREE_TRIAL_BUTTON = "a[class='get-free-trial-button']";
    private static final String CLOSE_MODAL_BUTTON = "[class*='modal-body'] button[class='close']";

    public BecomeALessonPlanetFreeMemberModal(WebDriver driver) {
        super(driver);
    }

    public void clickOnFreeMemberButton() {
        clickElement(FREE_MEMBER_BUTTON);
    }

    public void clickOnTenDaysFreeTrialButton() {
        clickElement(TEN_DAYS_FREE_TRIAL_BUTTON);
    }

    public void clickOnCloseModalButton() {
        clickElement(CLOSE_MODAL_BUTTON);
    }
}
