package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class ShareLinkModal extends LpUiBasePage {

    private static final String SHARE_RESOURCE_VIA_LINK_MODAL = "#js-link-share-modal";
    private static final String TITLE_TEXT = "[class='modal-header mb10']";
    private static final String CLOSE_BUTTON = "[class='modal-footer'] [class='btn btn-default']";

    public ShareLinkModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(SHARE_RESOURCE_VIA_LINK_MODAL);
    }

    public String getTitleText() {
        return getTextForElement(TITLE_TEXT);
    }

    public void clickOnCloseButton() {
        clickElement(CLOSE_BUTTON);
    }
}
