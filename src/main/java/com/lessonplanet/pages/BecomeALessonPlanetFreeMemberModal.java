package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class BecomeALessonPlanetFreeMemberModal extends LpUiBasePage {

    private static final String BECOME_FREEMIUM_USER_MODAL = "#freemium-get-free-trial-modal";
    private static final String CLOSE_BUTTON = "#freemium-get-free-trial-modal [class='close']";

    public BecomeALessonPlanetFreeMemberModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(BECOME_FREEMIUM_USER_MODAL);
    }

    public void clickOnCloseButton() {
        clickElement(CLOSE_BUTTON);
    }
}
