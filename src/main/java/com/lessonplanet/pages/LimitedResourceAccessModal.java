package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class LimitedResourceAccessModal extends LpUiBasePage {

    private static final String LIMITED_RESOURCE_ACCESS_MODAL = "#limited-resource-access-modal";
    private static final String LIMITED_RESOURCE_ACCESS_MODAL_BODY_TEXT = "#limited-resource-access-modal [class='modal-body']";
    private static final String LIMITED_RESOURCE_ACCESS_MODAL_TITLE_TEXT = "[class='modal-header'] h3";
    private static final String SAVE_BUTTON = "#limited-resource-access-modal [class='modal-footer'] [class='btn btn-primary']";

    public LimitedResourceAccessModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(LIMITED_RESOURCE_ACCESS_MODAL);
    }

    public boolean isModalDisplayed() {
        return isElementDisplayed(LIMITED_RESOURCE_ACCESS_MODAL);
    }

    public String getLimitedResourceAccessModalTitleText() {
        return getTextForElement(LIMITED_RESOURCE_ACCESS_MODAL_TITLE_TEXT);
    }

    public String getLimitedResourceAccessModalBodyText() {
        return getTextForElement(LIMITED_RESOURCE_ACCESS_MODAL_BODY_TEXT);
    }

    public void clickOnSaveButton() {
        clickElement(SAVE_BUTTON);
    }
}
