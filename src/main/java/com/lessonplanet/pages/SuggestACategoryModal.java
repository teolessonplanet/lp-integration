package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class SuggestACategoryModal extends LpUiBasePage {

    private static final String SUGGEST_A_CATEGORY_MODAL = "#suggest-new-directory-term";
    private static final String MODAL_TITLE = "[class='modal-title']";

    public SuggestACategoryModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(SUGGEST_A_CATEGORY_MODAL);
    }

    public String getModalTitle() {
        waitForModal();
        return getTextForElement(MODAL_TITLE);
    }
}
