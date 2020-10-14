package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class DeleteCollectionBuilderResourceModal extends LpUiBasePage {

    private static final String DELETE_RESOURCE_MODAL = "#js-delete-item-modal fade in modal";
    private static final String DELETE_RESOURCE_BUTTON = "[class='modal-footer'] [class^='btn btn-primary confirm remove-']";

    public DeleteCollectionBuilderResourceModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(DELETE_RESOURCE_MODAL);
    }

    public void clickOnDeleteResourceButton() {
        clickElement(DELETE_RESOURCE_BUTTON);
    }
}
