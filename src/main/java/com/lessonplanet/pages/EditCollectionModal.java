package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class EditCollectionModal extends LpUiBasePage {
    private static final String EDIT_COLLECTION_MODAL = "#edit-collection-modal";
    private static final String TITLE_INPUT = "[name='collection[title]']";
    private static final String GRADE_LIST_DROPDOWN = "#s2id_collection_grade_list";
    private static final String GRADE_OPTIONS = "#select2-drop li";
    private static final String SUBJECT_DROPDOWN_INPUT = "#s2id_collection_subject_list";
    private static final String SUBJECT_OPTIONS = "#select2-drop [class='select2-result-label']";
    private static final String DESCRIPTION_INPUT = "[class='note-editable panel-body']";
    private static final String PUBLISH_COLLECTION_BUTTON = "[class*='share-collection']";
    private static final String MY_RESOURCES_BUTTON = "[class*='btn btn-default btn-text-sm']";
    private static final String CLOSE_BUTTON = "#edit-collection-modal [class*='edit-collection-modal-close']";

    private static final String UPLOAD_A_FILE_BUTTON = "[class='upload-files btn btn-default btn-text-sm fixed-width-button']";

    public EditCollectionModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(EDIT_COLLECTION_MODAL);
    }

    public void typeTitle(String title) {
        sendKeys(TITLE_INPUT, title);
    }

    public void selectGrade(String grade) {
        selectFromDropdown(GRADE_LIST_DROPDOWN, GRADE_OPTIONS, grade);
    }

    public void selectSubject(String subject) {
        selectFromDropdown(SUBJECT_DROPDOWN_INPUT, SUBJECT_OPTIONS, subject);
    }

    public void typeDescription(String description) {
        sendKeys(DESCRIPTION_INPUT, description);
    }

    public void clickOnPublishCollection() {
        clickElement(PUBLISH_COLLECTION_BUTTON);
    }

    public void clickOnMyResourceButton() {
        clickElement(MY_RESOURCES_BUTTON);
    }

    public void clickOnCloseButton() {
        clickElement(CLOSE_BUTTON);
    }

    public void clickOnUploadAFileButton(){
        clickElement(UPLOAD_A_FILE_BUTTON);
    }
}
