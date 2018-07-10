package com.lessonplanet.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EditCollectionModal extends LpUiBasePage {
    private static final String TITLE_INPUT = "[name='collection[title]']";
    private static final String GRADE_LIST_DROPDOWN = "#s2id_collection_grade_list";
    private static final String GRADE_OPTIONS = "#select2-drop li";
    private static final String SUBJECT_DROPDOWN_INPUT = "#s2id_collection_subject_list";
    private static final String SUBJECT_OPTIONS = "#select2-drop [class='select2-result-label']";
    private static final String DESCRIPTION_INPUT = "[class='note-editable panel-body']";
    private static final String PUBLISH_COLLECTION_BUTTON = "[class*='share-collection']";

    private static final Logger logger = LogManager.getRootLogger();

    public EditCollectionModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModalToBeDisplayed() {
        waitUntilAnimationIsDone(TITLE_INPUT);
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

    private void selectFromDropdown(String dropdownCssSelector, String optionsCssSelector, String option) {
        boolean optionWasFound = false;
        waitForPageLoad();
        waitForModalToBeDisplayed();
        findElement(dropdownCssSelector).click();
        waitForPageLoad();
        List<WebElement> results = findElements(optionsCssSelector);
        for (WebElement result : results) {
            if (result.getText().equals(option)) {
                result.click();
                optionWasFound = true;
                break;
            }
        }
        if (!optionWasFound) {
            logger.error("The option " + option + " was not found.");
        }
        waitForPageLoad();
    }

    public void typeDescription(String description) {
        sendKeys(DESCRIPTION_INPUT, description);
    }

    public void clickOnPublishCollection() {
        waitForPageLoad();
        findElement(PUBLISH_COLLECTION_BUTTON).click();
        waitForPageLoad();
    }
}
