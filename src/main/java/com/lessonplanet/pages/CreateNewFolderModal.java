package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CreateNewFolderModal extends LpUiBasePage {

    protected static final String CREATE_FOLDER_BUTTON = "[class*='modal-footer'] [class='btn btn-default btn-primary ml10']";
    protected static final String CANCEL_BUTTON = "[class='modal-footer'] button[class='btn btn-default']";
    protected static final String NAME_INPUT = "#create-folder-modal [name='title']";
    private static final String FOLDER_TYPE_OPTIONS = "[class*='folder-type-dropdown__option']";
    private static final String CREATE_NEW_FOLDER_MODAL = "#create-folder-modal";
    private static final String CREATE_NEW_FOLDER_MODAL_TITLE_MY_RESOURCES = "#create-folder-modal h4";
    private static final String DESCRIPTION_INPUT = "#create-folder-modal [class='note-editable']";
    private static final String FOLDER_TYPE_DROPDOWN = "[class*='folder-type-dropdown__indicator']";

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

    public void chooseFolderType(String folderType) {
        selectFromDropdown(FOLDER_TYPE_DROPDOWN, FOLDER_TYPE_OPTIONS, folderType);
    }
}
