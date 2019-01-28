package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;
import java.text.NumberFormat;
import java.text.ParseException;

public class CollectionRrp extends LpUiBasePage {

    private static final String COLLECTION_TITLE_TEXT = "div h1";
    private static final String SAVE_COLLECTION_BUTTON = "[class='save-collection-btn'] [class='btn btn-default']";
    private static final String ITEMS_COUNT = "[class='rrp-items-count']";

    protected CollectionRrp(WebDriver driver){
        super(driver);
    }

    public boolean isCollectionTitleDisplayed() {
        return isElementClickable(COLLECTION_TITLE_TEXT);
    }

    public boolean isSaveCollectionButtonDisplayed() {
        return isElementClickable(SAVE_COLLECTION_BUTTON);
    }

    public void clickOnSaveCollectionButton() {
        clickElement(SAVE_COLLECTION_BUTTON);
    }

    public int getCollectionItemsCount() {
        String rawNumber = getTextForElement(ITEMS_COUNT);
        int number;
        try {
            number = NumberFormat.getNumberInstance(TestData.LOCALE).parse(rawNumber).intValue();
            } catch (ParseException e) {
            throw new Error("The number " + rawNumber + " cannot be parsed");
        }
        return number;
    }
}
