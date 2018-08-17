package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CollectionRrpPage extends RrpPage {

    private static final String SAVE_COLLECTION_BUTTON = "[class='save-collection-btn'] a";

    public CollectionRrpPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSaveCollectionButtonDisplayed() {
        return isElementClickable(SAVE_COLLECTION_BUTTON);
    }
}
