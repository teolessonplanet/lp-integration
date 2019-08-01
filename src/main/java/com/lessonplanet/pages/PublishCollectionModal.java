package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class PublishCollectionModal extends LpUiBasePage {

    private static final String PUBLISH_COLLECTION_MODAL = "#share-collection-modal";
    private static final String PUBLISH_COLLECTION_BUTTON = "input[class*='btn-success']";
    private static final String CLOSE_BUTTON = "[class*='btn-modal-green']";
    private static final String RATING_FIELD = "#shared_collection_reviewer_rating option";
    private static final String AUDIENCE_FIELD = "#shared_collection_audience_list option";
    private static final String CONCEPTS_FIELD = "[class*='shared_collection_concept_list'] [class*='select2-container'] [class*='select2-input']";
    private static final String MATCHING_OPTION = "[class='select2-match']";

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

    public void typeRating() {
        findElement(RATING_FIELD).sendKeys(TestData.RATING);
    }

    public void typeAudience() {
        findElement(AUDIENCE_FIELD).sendKeys(TestData.AUDIENCE);
    }

    public void typeConcept() {
        findElement(CONCEPTS_FIELD).sendKeys(TestData.CONCEPT);
        clickElement(MATCHING_OPTION);
    }
}
