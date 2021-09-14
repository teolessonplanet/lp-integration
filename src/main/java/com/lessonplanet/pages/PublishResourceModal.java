package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class PublishResourceModal extends LpUiBasePage {

    private static final String PUBLISH_RESOURCE_MODAL = "#share-modal";
    private static final String AGREEMENT_CHECKBOX = "[name='license_enum']";
    private static final String PUBLISH_RESOURCE_BUTTON = "#share-button";
    private static final String TITLE_INPUT = "[class='required form-control']";
    private static final String RESOURCE_DROPDOWN_INPUT = "[class*='resource-type-dropdown__dropdown-indicator']";
    private static final String RESOURCE_OPTIONS = "[class*='resource-type-dropdown__option']";
    private static final String GRADE_LIST_DROPDOWN = "[class*='grade-level-dropdown__dropdown-indicator']";
    private static final String GRADE_OPTIONS = "[class*='grade-level-dropdown__option']";
    private static final String SUBJECT_LIST_DROPDOWN = "[class*='subjects-dropdown__dropdown-indicator']";
    private static final String SUBJECT_OPTIONS = "[class*='subjects-dropdown__option']";
    private static final String DESCRIPTION_INPUT = "[class='note-editable']";

    public PublishResourceModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(PUBLISH_RESOURCE_MODAL);
    }

    public void typeTitle(String title) {
        clearText(TITLE_INPUT);
        sendKeys(TITLE_INPUT, title);
    }

    public void selectGrade(String grade) {
        selectFromDropdown(GRADE_LIST_DROPDOWN, GRADE_OPTIONS, grade);
    }

    public void selectSubject(String subject) {
        selectFromDropdown(SUBJECT_LIST_DROPDOWN, SUBJECT_OPTIONS, subject);
    }

    public void typeDescription(String description) {
        sendKeys(DESCRIPTION_INPUT, description);
    }

   public void selectResourceType(String resourceType) {
        selectFromDropdown(RESOURCE_DROPDOWN_INPUT, RESOURCE_OPTIONS, resourceType);
    }

    public void clickAgreementOption() {
        clickElement(AGREEMENT_CHECKBOX);
    }

    public void clickOnPublishResourceButton() {
        clickElement(PUBLISH_RESOURCE_BUTTON);
    }
}
