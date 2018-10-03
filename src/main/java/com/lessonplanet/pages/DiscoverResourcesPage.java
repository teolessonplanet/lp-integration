package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

import java.text.NumberFormat;
import java.text.ParseException;

public class DiscoverResourcesPage extends ResourcesPage {

    private static final String SEARCH_MESSAGE = "#js-search-heading";
    private static final String SUGGESTIONS_BLOCK_TEXT = "[class*='alert-warning']";
    private static final String RESOURCES_COUNTER_TEXT = "[class='count text-action']";

    private static final String LIST_VIEW_BUTTON = "#list";
    private static final String TILED_VIEW_BUTTON = "#tiled";
    private static final String THUMBNAIL_VIEW_BUTTON = "#thumbnail";

    public DiscoverResourcesPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.DISCOVER_RESOURCES_PAGE_PATH);
    }

    public String getSearchMessage() {
        return findElement(SEARCH_MESSAGE).getText();
    }

    public String getSuggestionsBlockText() {
        return findElement(SUGGESTIONS_BLOCK_TEXT).getText();
    }

    public boolean isSuggestionBlockTextDisplayed() {
        return isElementClickable(SUGGESTIONS_BLOCK_TEXT);
    }

    public int getTotalResults() {
        String rawNumber = findElements(RESOURCES_COUNTER_TEXT).get(0).getText();
        int number;
        try {
            number = NumberFormat.getNumberInstance(TestData.LOCALE).parse(rawNumber).intValue();
        } catch (ParseException e) {
            throw new Error("The number " + rawNumber + " cannot be parsed");
        }
        return number;
    }

    public void clickOnListView() {
        clickElement(LIST_VIEW_BUTTON);
        waitForPageLoad();
    }

    public void clickOnTiledView() {
        clickElement(TILED_VIEW_BUTTON);
        waitForPageLoad();
    }

    public void clickThumbnailView() {
        clickElement(THUMBNAIL_VIEW_BUTTON);
        waitForPageLoad();
    }

    public void changeToListView() {
        final String currentPath = getPath();
        loadPage();
        clickOnListView();
        loadUrl(currentPath);
    }

    public void changeToTiledView() {
        final String currentPath = getPath();
        loadPage();
        clickOnTiledView();
        loadUrl(currentPath);
    }


    public void changeToThumbnailView() {
        final String currentPath = getPath();
        loadPage();
        clickThumbnailView();
        loadUrl(currentPath);
    }

}
