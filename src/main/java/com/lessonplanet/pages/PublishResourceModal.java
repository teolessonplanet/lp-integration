package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class PublishResourceModal extends LpUiBasePage {

    private static final String PUBLISH_RESOURCE_MODAL = "#share-modal";
    private static final String TITLE_INPUT = "[name='document[title]']";
    private static final String AGREEMENT_CHECKBOX = "[class='boolean rights-checkbox']";
    private static final String PUBLISH_RESOURCE_BUTTON = "#share-button";

    public PublishResourceModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(PUBLISH_RESOURCE_MODAL);
    }

    public void typeTitle(String title) {
        sendKeys(TITLE_INPUT, title);
    }

    public void clickAgreementOption() {
        clickElement(AGREEMENT_CHECKBOX);
    }

    public void clickOnPublishResourceButton() {
        clickElement(PUBLISH_RESOURCE_BUTTON);
    }
}
