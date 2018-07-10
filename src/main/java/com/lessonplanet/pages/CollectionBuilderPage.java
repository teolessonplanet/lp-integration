package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CollectionBuilderPage extends LpUiBasePage {

    private static final String CREATE_OR_OPEN_DROPDOWN = "[class*='cb-panel'] [class='dropdown']";
    private static final String CREATE_NEW_COLLECTION_OPTION = "[href='javascript:void(0)']";

    private static final String COLLECTION_DROPPABLE_ZONE = "#droppable";

    private static final String MY_RESOURCES_BUTTON = "#collection-builder-area-inner #collection-builder-button";
    private static final String EDIT_COLLECTION_BUTTON = "[class*='cb-actions'] [class*='btn-primary']";

    public CollectionBuilderPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnDropdown() {
        findElement(CREATE_OR_OPEN_DROPDOWN).click();
    }

    public void clickOnCreateNewCollection() {
        findElement(CREATE_NEW_COLLECTION_OPTION).click();
    }

    public WebElement getCollectionDroppableZone() {
        return findElement(COLLECTION_DROPPABLE_ZONE);
    }

    public void clickOnMyResources() {
        findElement(MY_RESOURCES_BUTTON).click();
    }

    public void clickOnEditCollection() {
        findElement(EDIT_COLLECTION_BUTTON).click();
    }
}
