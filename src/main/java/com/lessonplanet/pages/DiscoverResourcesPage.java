package com.lessonplanet.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final String FACETS_CATEGORIES = "[class*='lp-filter-group']";
    private static final String FACET_OPTIONS = "li";

    private static final Logger logger = LogManager.getRootLogger();

    public DiscoverResourcesPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.DISCOVER_RESOURCES_PAGE_PATH);
    }

    public String getSearchMessage() {
        return getTextForElement(SEARCH_MESSAGE);
    }

    public void clickOnSearchMessage() {
        clickElement(SEARCH_MESSAGE);
    }

    public String getSuggestionsBlockText() {
        return getTextForElement(SUGGESTIONS_BLOCK_TEXT);
    }

    public boolean isSuggestionBlockTextDisplayed() {
        return isElementClickable(SUGGESTIONS_BLOCK_TEXT);
    }

    public int getTotalResults() {
        String rawNumber = getTextForElement(RESOURCES_COUNTER_TEXT, 0);
        int number;
        try {
            number = NumberFormat.getNumberInstance(TestData.LOCALE).parse(rawNumber).intValue();
        } catch (ParseException e) {
            throw new Error("The number " + rawNumber + " cannot be parsed");
        }
        return number;
    }

    public void clickOnListView() {
        clickViewModeButton(LIST_VIEW_BUTTON);
    }

    public void clickOnTiledView() {
        clickViewModeButton(TILED_VIEW_BUTTON);
    }

    public void clickOnThumbnailView() {
        clickViewModeButton(THUMBNAIL_VIEW_BUTTON);
    }

    private void clickViewModeButton(String cssSelector) {
        waitForLoad();
        try {
            clickElement(cssSelector);
        } catch (Exception ex) {
            logger.info("The desired view mode is already selected " + ex.toString());
        }
        waitForLoad();
    }

    public void clickSeeCollection(boolean inANewTab) {
        selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_COLLECTIONS);
        super.clickSeeCollection(inANewTab);
    }

    public void clickSeeReview(boolean inANewTab) {
        selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);
        super.clickSeeReview(inANewTab);
    }

    public void clickGetFreeAccess(boolean inANewTab) {
        selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_PRINTABLES_AND_TEMPLATES);
        super.clickGetFreeAccess(inANewTab);
    }

    public void clickSeePreview(boolean inANewTab) {
        selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_ARTICLES);
        super.clickSeePreview(inANewTab);
    }

    public void clickGoToResourceForSharedResource(boolean inANewTab) {
        selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_ARTICLES);
        super.clickGoToResourceForSharedResource(inANewTab);
    }

    public void clickGoToResourceForRegularResource(boolean inANewTab) {
        selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_PRINTABLES_AND_TEMPLATES);
        super.clickGoToResourceForRegularResource(inANewTab);
    }

    public void clickSeeFullReview(boolean inANewTab) {
        selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);
        super.clickSeeFullReview(inANewTab);
    }

    public void clickFreeFullAccessReview(boolean inANewTab) {
        selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_PRESENTATIONS);
        super.clickFreeFullAccessReview(inANewTab);
    }

    public void selectFacetFilter(String facetCategoryName, String facetName) {
        clickOptionFromLeftSide(FACETS_CATEGORIES, facetCategoryName, FACET_OPTIONS, facetName);
    }

    public void loadSearchPageInListView() {
        loadPage();
        clickOnListView();
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
        clickOnThumbnailView();
        loadUrl(currentPath);
    }

    public String getRegularResourceCardDataId(int position) {
        return super.getRegularResourceCardDataId(position);
    }

    public String getSharedResourceCardDataId(int position) {
        return super.getSharedResourceCardDataId(position);
    }

    public String getCollectionCardTitle(int position) {
        return super.getCollectionCardTitle(position);
    }

    public String getResourceCardDataType(int position) {
        return super.getResourceCardDataType(position);
    }

    public String getFreeSampleResourceCardTitle(int position) {
        return super.getFreeSampleResourceCardTitle(position);
    }

    public int getFreeSampleResourcePosition() {
        return super.getFreeSampleResourcePosition();
    }
}
