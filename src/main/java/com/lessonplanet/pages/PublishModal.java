package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class PublishModal extends LpUiBasePage {

    private static final String PUBLISH_RESOURCE_MODAL = "#share-modal";
    private static final String PUBLISH_COLLECTION_MODAL = "#share-collection-modal";
    private static final String TITLE_INPUT = "[name='document[title]']";
    private static final String AGREEMENT_CHECKBOX = "[class='boolean']";
    private static final String PUBLISH_RESOURCE_BUTTON = "#share-button";
    private static final String PUBLISH_NOW_BUTTON = "[class*='btn-success confirm']";
    private static final String CLOSE_BUTTON = "[class*='btn-modal-green']";

    public PublishModal(WebDriver driver) {
        super(driver);
    }

    public void waitForPublishResourceModal() {
        waitForBootstrapModalToBeVisible(PUBLISH_RESOURCE_MODAL);
    }

    public void waitForPublishCollectionModal() {
        waitForBootstrapModalToBeVisible(PUBLISH_COLLECTION_MODAL);
    }

    public void typeTitle(String title) {
        sendKeys(TITLE_INPUT, title);
    }

    public void checkAgreementOption() {
        clickElement(AGREEMENT_CHECKBOX);
    }

    public void clickOnPublishResourceButton() {
        clickElement(PUBLISH_RESOURCE_BUTTON);
    }

    public void clickOnPublishNowButton() {
        clickElement(PUBLISH_NOW_BUTTON);
    }

    public void clickOnCloseButton() {
        clickElement(CLOSE_BUTTON);
    }
}
