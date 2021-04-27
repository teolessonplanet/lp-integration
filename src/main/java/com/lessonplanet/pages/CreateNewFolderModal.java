package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CreateNewFolderModal extends LpUiBasePage {

    protected static final String CREATE_FOLDER_BUTTON = "[class*='modal-footer'] [type='submit']";
    protected static final String CANCEL_BUTTON = "[class='modal-footer'] button[class='btn btn-default']";
    protected static final String NAME_INPUT = "[name='collection[title]']";
    private static final String FOLDER_TYPE_OPTIONS = "#select2-drop [class='select2-results'] li";
    private static final String CREATE_NEW_FOLDER_MODAL = "#js-create-collection-modal";
    private static final String CREATE_NEW_FOLDER_MODAL_TITLE_NAVIGATION_DROPDOWN = "#newCollection h3";
    private static final String CREATE_NEW_FOLDER_MODAL_TITLE_MY_RESOURCES = "#js-create-collection-modal h3";
    private static final String DESCRIPTION_INPUT = "[name='collection[description]']";
    private static final String FOLDER_TYPE_DROPDOWN = "[class='form-group type_list']";

    public CreateNewFolderModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(CREATE_NEW_FOLDER_MODAL);
    }

    public void typeName(String name) {
        waitForModal();
        sendKeys(NAME_INPUT, name);
    }

    public void typeDescription(String description) {
        sendKeys(DESCRIPTION_INPUT, description);
    }

    public void clickOnCreateFolderButton() {
        clickElement(CREATE_FOLDER_BUTTON);
    }

    public void clickOnCancelButton() {
        clickElement(CANCEL_BUTTON);
    }

    public String getCreateNewFolderModalTitleFromMyResources() {
        return getTextForElement(CREATE_NEW_FOLDER_MODAL_TITLE_MY_RESOURCES);
    }

    public String getCreateNewFolderModalTitleFromEditCollection() {
        return getTextForElement(CREATE_NEW_FOLDER_MODAL_TITLE_NAVIGATION_DROPDOWN);
    }

    public void chooseFolderType(String folderType) {
        selectFromDropdown(FOLDER_TYPE_DROPDOWN, FOLDER_TYPE_OPTIONS, folderType);
    }
}
