package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CategoryModal extends LpUiBasePage {

    private static final String CLOSE_MODAL_BUTTON = "div[class*='close-modal']";
    private static final String THUMBNAIL = "[class*='panel-container'] img[class*='full-card-img']";
    private static final String MODAL_TITLE = "[class*='panel-container'] h4 a";
    private static final String CARETS = "[class*='panel-container'] a[class*='subcategory']";
    private static final String SUBCATEGORIES_TEXT = "[class*='react-modal'] [class='fa-ul mb0']";
//    private static final String CARETS = "[class=''] [class*='fa-caret-right']";
    private static final String CATEGORY_AND_SUBCATEGORY_CARDS = "div[class='panel-body']";
    public CategoryModal(WebDriver driver) {
        super(driver);
    }

    public String getModalTitle() {
        return findElement(MODAL_TITLE).getText();
    }

    public void clickOnFirstCaret() {
        findElements(CARETS).get(0).click();
    }

    public void clickOnSecondCaret() {
        findElements(CARETS).get(1).click();
    }

    public void clickOnCloseModalButton() {
        findElement(CLOSE_MODAL_BUTTON).click();
    }

    public String getSubcategoriesAsText() {
        return findElement(SUBCATEGORIES_TEXT).getText();
    }

    public String getCategoryAndSubcategoriesText() {
        return findElements(CATEGORY_AND_SUBCATEGORY_CARDS).get(0).getText();
    }
}
