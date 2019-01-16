package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CollectionRrp extends LpUiBasePage {

    private static final String COLLECTION_TITLE_TEXT = "div h1";
    private static final String SAVE_COLLECTION_BUTTON = "[class='save-collection-btn']";

    protected CollectionRrp(WebDriver driver){
        super(driver);
    }

    public boolean isCollectionTitleDisplayed() {
        return isElementClickable(COLLECTION_TITLE_TEXT);
    }

    public boolean isSaveCollectionButtonDisplayed() {
        return isElementClickable(SAVE_COLLECTION_BUTTON);
    }
}
