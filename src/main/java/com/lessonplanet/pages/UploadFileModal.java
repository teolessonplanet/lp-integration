package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class UploadFileModal extends LpUiBasePage {

    private static final String UPLOAD_MODAL = "#upload-file-modal";
    //    private static final String CHOOSE_FILE_BUTTON = "[class*='input-group-btn']";
    private static final String CHOOSE_FILE_ATTACHMENT_INPUT = "#document_attachment";

    private static final String GRADE_OPTIONS = "#select2-drop li";
    private static final String GRADE_LIST_DROPDOWN = "[class='form-group select document_grade_list required'] [class='select2-container select2-container-multi select form-control']";
    private static final String SUBJECT_OPTIONS = "#select2-drop [class='select2-result-label']";
    private static final String SUBJECT_DROPDOWN_INPUT = "[class='form-group tag_hierarchy document_subject_list required'] [class='select2-container select2-container-multi tag_hierarchy form-control']";
    private static final String RESOURCE_OPTIONS = "#select2-drop [class='select2-result-label']";
    private static final String RESOURCE_DROPDOWN_INPUT = "[class='form-group tag_hierarchy document_resource_type_list required'] [class='select2-container select2-container-multi tag_hierarchy form-control']";
    private static final String DESCRIPTION_INPUT = "[class*='form-group text document_description'] [class='note-editable panel-body']";
    private static final String UPLOAD_BUTTON = "[class*='fa-upload mr5']";
    private static final String DONE_BUTTON = "[class*='btn-primary done']";

    private static final String COLLECTION_DROPDOWN = "#s2id_document_collection_id";
    private static final String COLLECTION_DROPDOWN_INPUT = "#select2-drop [class='select2-results'] li:nth-child(1)";

    public UploadFileModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(UPLOAD_MODAL);
    }

    public void uploadUsingTextInput(String path) {
        uploadUsingTextInput(CHOOSE_FILE_ATTACHMENT_INPUT, path);
    }

    public void typeDescription(String description) {
        sendKeys(DESCRIPTION_INPUT, description);
    }

    public void selectGrade(String grade) {
        selectFromDropdown(GRADE_LIST_DROPDOWN, GRADE_OPTIONS, grade);
    }

    public void selectSubject(String subject) {
        selectFromDropdown(SUBJECT_DROPDOWN_INPUT, SUBJECT_OPTIONS, subject);
    }

    public void selectResourceType(String resourceType) {
        selectFromDropdown(RESOURCE_DROPDOWN_INPUT, RESOURCE_OPTIONS, resourceType);
    }

    public void clickOnUploadButton() {
        clickElement(UPLOAD_BUTTON);
    }

    public void clickOnDoneButton() {
        clickElement(DONE_BUTTON);
    }

    public void selectCollection() {
        clickElement(COLLECTION_DROPDOWN);
        clickElement(COLLECTION_DROPDOWN_INPUT);
    }
}
