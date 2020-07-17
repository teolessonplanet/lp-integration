package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CreateNewCollectionModal extends LpUiBasePage {

    private static final String CREATE_NEW_COLLECTION_MODAL = "#js-create-collection-modal";
    private static final String CREATE_NEW_COLLECTION_MODAL_TITLE = "#newCollection h3";
    private static final String NAME_INPUT = "[name='collection[title]']";
    private static final String DESCRIPTION_INPUT = "[name='collection[description]']";
    private static final String CREATE_COLLECTION_BUTTON = "[class*='modal-footer'] [type='submit']";
    private static final String CLOSE_MODAL_BUTTON = "[class*='modal-footer'] [data-dismiss='modal']";

    public CreateNewCollectionModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(CREATE_NEW_COLLECTION_MODAL);
    }

    public void typeName(String name) {
        waitForModal();
        sendKeys(NAME_INPUT, name);
    }

    public void typeDescription(String description) {
        sendKeys(DESCRIPTION_INPUT, description);
    }

    public void clickOnCreateCollection() {
        clickElement(CREATE_COLLECTION_BUTTON);
    }

    public String getTitle() {
        return getTextForElement(CREATE_NEW_COLLECTION_MODAL_TITLE);
    }

    public void clickOnCloseModalButton() {
        clickElement(CLOSE_MODAL_BUTTON);
    }
}
