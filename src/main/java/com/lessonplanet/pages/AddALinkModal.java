package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class AddALinkModal extends LpUiBasePage {
    private static final String URL_FIELD = "#add-url-modal [name='url']";
    private static final String NAME_FIELD = "#add-url-modal [name='title']";
    private static final String ADD_TO_FOLDER_BUTTON = "#add-url-modal [class='modal-footer'] [class='btn btn-warning']";

    public AddALinkModal(WebDriver driver) {
        super(driver);
    }

    public void waitUntilTitleFieldIsDisplayed() {
        waitUntilElementIsDisplayed(NAME_FIELD);
    }

    public void clickAddToFolderButton() {
        clickElement(ADD_TO_FOLDER_BUTTON);
    }

    public void typeUrl(String Url) {
        clearText(URL_FIELD);
        sendKeys(URL_FIELD, Url);
    }

    public void typeName(String name) {
        clearText(NAME_FIELD);
        sendKeys(NAME_FIELD, name);
    }
}
