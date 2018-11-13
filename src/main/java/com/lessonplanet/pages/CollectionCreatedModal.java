package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CollectionCreatedModal extends LpUiBasePage {

    private static final String TITLE_TEXT = "[class='modal-header'] h3";
    private static final String SUBMIT_BUTTON = "#share-unit-submit";

    public CollectionCreatedModal(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        waitUntilAnimationIsDone(TITLE_TEXT);
        return getTextForElement(TITLE_TEXT);
    }

    public void clickOnSubmitButton() {
        clickElement(SUBMIT_BUTTON);
    }
}
