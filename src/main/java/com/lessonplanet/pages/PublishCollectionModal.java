package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class PublishCollectionModal extends LpUiBasePage {

    private static final String PUBLISH_COLLECTION_MODAL = "#share-collection-modal";
    private static final String PUBLISH_COLLECTION_BUTTON = "input[class*='btn-success']";
    private static final String CLOSE_BUTTON = "[class*='btn-modal-green']";
    private static final String RATING_FIELD = "#s2id_shared_collection_reviewer_rating";
    private static final String AUDIENCE_FIELD = "#s2id_shared_collection_audience_list";
    private static final String CONCEPTS_FIELD = "[class*='shared_collection_concept_list'] [class*='select2-container'] [class*='select2-input']";
    private static final String MATCHING_OPTION = "[class='select2-match']";
    private static final String OPTIONS_DROPDOWN = "#select2-drop [class='select2-results'] li";

    public PublishCollectionModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(PUBLISH_COLLECTION_MODAL);
    }

    public void clickOnPublishCollectionButton() {
        clickElement(PUBLISH_COLLECTION_BUTTON);
    }

    public void clickOnCloseButton() {
        clickElement(CLOSE_BUTTON);
    }

    public void chooseRating() {
        selectFromDropdown(RATING_FIELD, OPTIONS_DROPDOWN, TestData.RATING);
    }

    public void chooseAudience() {
        selectFromDropdown(AUDIENCE_FIELD, OPTIONS_DROPDOWN, TestData.AUDIENCE);
    }

    public void typeConcept() {
        findElement(CONCEPTS_FIELD).sendKeys(TestData.CONCEPT);
        clickElement(MATCHING_OPTION);
    }

    public void publishCollection(String accountPlanText) {
        chooseRating();
        chooseAudience();
        typeConcept();
        clickOnPublishCollectionButton();
        if (!accountPlanText.equals(TestData.VALID_EMAIL_CSL_HENRY)) {
            clickOnCloseButton();
        }
    }
}
