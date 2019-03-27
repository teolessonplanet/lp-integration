package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class BecomeALessonPlanetFreeMemberModal extends LpUiBasePage {

    private static final String BECOME_A_LESSON_PLANET_FREE_MEMBER_MODAL = "#freemium-get-free-trial-modal";
    private static final String FREE_MEMBER_LINK = "#freemium-get-free-trial-modal a[class='free-member-link']";
    private static final String TEN_DAYS_FREE_TRIAL_BUTTON = "#freemium-get-free-trial-modal a[class='get-free-trial-button']";
    private static final String CLOSE_MODAL_BUTTON = "#freemium-get-free-trial-modal button[class='close']";

    public BecomeALessonPlanetFreeMemberModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(BECOME_A_LESSON_PLANET_FREE_MEMBER_MODAL);
    }

    public void clickOnFreeMemberLink() {
        waitForModal();
        clickElement(FREE_MEMBER_LINK);
    }

    public void clickOnTenDaysFreeTrialButton() {
        clickElement(TEN_DAYS_FREE_TRIAL_BUTTON);
    }

    public void clickOnCloseModalButton() {
        clickElement(CLOSE_MODAL_BUTTON);
    }

    public boolean isModalDisplayed(){
        return isElementDisplayed(BECOME_A_LESSON_PLANET_FREE_MEMBER_MODAL);
    }
}
