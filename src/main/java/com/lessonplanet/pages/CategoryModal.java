package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CategoryModal extends LpUiBasePage {

    private static final String CLOSE_MODAL_BUTTON = "div[class*='close-modal']";
    private static final String MODAL_TITLE = "[class*='panel-container'] h4 a";
    private static final String CARETS = "[class*='panel-container'] a[class*='subcategory']";
    private static final String SUBCATEGORIES_TEXT = "[class*='react-modal'] [class='fa-ul mb0']";

    public CategoryModal(WebDriver driver) {
        super(driver);
    }

    public String getModalTitle() {
        waitForReactModalToBeVisible();
        return getTextForElement(findElementToBeVisible(MODAL_TITLE));
    }

    public void clickOnFirstCaret() {
        clickElement(CARETS, 0);
    }

    public void clickOnSecondCaret() {
        clickElement(CARETS, 1);
    }

    public void clickOnCloseModalButton() {
        clickElement(CLOSE_MODAL_BUTTON);
    }

    public String getSubcategoriesAsText() {
        return getTextForElement(SUBCATEGORIES_TEXT);
    }
}
