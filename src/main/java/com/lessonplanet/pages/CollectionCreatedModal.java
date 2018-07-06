package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CollectionCreatedModal extends LpUiBasePage {

    private static final String TITLE_TEXT = "[class='modal-header'] h3";
    private static final String SUBMIT_BUTTON = "#share-unit-submit";

    public CollectionCreatedModal(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return findElement(TITLE_TEXT).getText();
    }

    public void clickOnSubmitButton() {
        findElement(SUBMIT_BUTTON).click();
    }
}
