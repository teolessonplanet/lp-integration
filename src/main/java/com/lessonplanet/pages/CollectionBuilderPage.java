package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CollectionBuilderPage extends LpUiBasePage {

    private static final String CREATE_OR_OPEN_DROPDOWN = "[class*='cb-panel'] [class='dropdown']";
    private static final String CREATE_NEW_COLLECTION_OPTION = "[href='javascript:void(0)']";
    private static final String COLLECTION_DROPPABLE_ZONE = "#droppable";
    private static final String EDIT_COLLECTION_BUTTON = "[class*='cb-actions'] [class*='btn-primary']";

    public CollectionBuilderPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnDropdown() {
        clickElement(CREATE_OR_OPEN_DROPDOWN);
    }

    public void clickOnCreateNewCollection() { clickElement(CREATE_NEW_COLLECTION_OPTION); }

    public WebElement getCollectionDroppableZone() { return findElement(COLLECTION_DROPPABLE_ZONE); }

    public void clickOnEditCollection() { clickElement(EDIT_COLLECTION_BUTTON); }

}
