package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CreateNewCollectionModal extends LpUiBasePage {

    private static final String CREATE_NEW_COLLECTION_MODAL = "#js-create-collection-modal";
    private static final String NAME_INPUT = "[name='collection[title]']";
    private static final String DESCRIPTION_INPUT = "[name='collection[description]']";
    private static final String CREATE_COLLECTION_BUTTON = "[class='modal-footer'] [type='submit']";

    public CreateNewCollectionModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(CREATE_NEW_COLLECTION_MODAL);
    }

    public void typeName(String name) {
        sendKeys(NAME_INPUT, name);
    }

    public void typeDescription(String description) {
        sendKeys(DESCRIPTION_INPUT, description);
    }

    public void clickOnCreateCollection() {
        clickElement(CREATE_COLLECTION_BUTTON);
    }
}
