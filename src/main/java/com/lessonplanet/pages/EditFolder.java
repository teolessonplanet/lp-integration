package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class EditFolder extends CreateNewFolderModal {

    private static final String FOLDER_TYPE_DROPDOWN = "[class='select optional collection_resource_type_list']";

    public EditFolder(WebDriver driver) {
        super(driver);
    }

    public void typeName(String name) {
        clearText(NAME_INPUT);
        sendKeys(NAME_INPUT, name);
    }

    public void chooseFolderType(String folderType) {
        selectFromDropdown(FOLDER_TYPE_DROPDOWN, FOLDER_TYPE_OPTIONS, folderType);
    }

    public void clickOnSaveButton() {
        clickElement(CREATE_FOLDER_BUTTON);
    }
}
