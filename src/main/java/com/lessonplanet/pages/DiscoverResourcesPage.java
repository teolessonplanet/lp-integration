package com.lessonplanet.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.TestData;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

public class DiscoverResourcesPage extends ResourcesPage {

    private static final String SEARCH_MESSAGE = "#js-search-heading";
    private static final String SUGGESTIONS_BLOCK_TEXT = "[class*='alert-warning']";
    private static final String RESOURCES_COUNTER_TEXT = "[class='count text-action']";

    private static final String LIST_VIEW_BUTTON = "#list";
    private static final String TILED_VIEW_BUTTON = "#tiled";
    private static final String THUMBNAIL_VIEW_BUTTON = "#thumbnail";

    private static final String FACETS_CATEGORIES = "[class*='lp-filter-group']";
    private static final String FACET_OPTIONS = "li";
    private static final String PROVIDERS_FACET = "#facet-sidebar [class*='lp-filter-group parent-provider_ids'] h4";

    private Map<String, List<String>> facetsMap = new HashMap<>();
    private static final Logger logger = LogManager.getRootLogger();

    public DiscoverResourcesPage(WebDriver driver) {
        super(driver);
        generateFacetFiltersList();
    }

    public void loadPage() {
        loadUrl(TestData.DISCOVER_RESOURCES_PAGE_PATH);
    }

    public void loadPath(String path) {
        loadUrl(path);
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
        selectFacetViaShortcut(new ArrayList<>(Arrays.asList(TestData.FACET_CATEGORY_RESOURCES_TYPE_COLLECTIONS_TYPES)));
        super.clickSeeCollection(inANewTab);
    }

    public void clickSeeCollectionUnit(boolean inANewTab) {
        selectFacetViaShortcut(new ArrayList<>(Arrays.asList(TestData.FACET_CATEGORY_RESOURCES_TYPE_UNIT_MODULES)));
        super.clickSeeCollectionUnit(inANewTab);
    }

    public void clickSeeReview(boolean inANewTab) {
        selectFacetViaShortcut(new ArrayList<>(Arrays.asList(TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS)));
        super.clickSeeReview(inANewTab);
    }

    public void clickGetFreeAccess(boolean inANewTab) {
        selectFacetViaShortcut(new ArrayList<>(Arrays.asList(TestData.FACET_CATEGORY_RESOURCES_TYPE_PRINTABLES_AND_TEMPLATES)));
        super.clickGetFreeAccess(inANewTab);
    }

    public void clickSeePreview(boolean inANewTab) {
        selectFacetViaShortcut(new ArrayList<>(Arrays.asList(TestData.FACET_CATEGORY_RESOURCES_TYPE_ARTICLES)));
        super.clickSeePreview(inANewTab);
    }

    public void clickGoToResourceForSharedResource(boolean inANewTab) {
        selectFacetViaShortcut(new ArrayList<>(Arrays.asList(TestData.FACET_CATEGORY_RESOURCES_TYPE_ARTICLES)));
        super.clickGoToResourceForSharedResource(inANewTab);
    }

    public void clickGoToResourceForRegularResource(boolean inANewTab) {
        selectFacetViaShortcut(new ArrayList<>(Arrays.asList(TestData.FACET_PROVIDERS_LESSONPLANET, TestData.FACET_CATEGORY_RESOURCES_TYPE_PRINTABLES_AND_TEMPLATES)));
        super.clickGoToResourceForRegularResource(inANewTab);
    }

    public void clickSeeFullReview(boolean inANewTab) {
        selectFacetViaShortcut(new ArrayList<>(Arrays.asList(TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS)));
        super.clickSeeFullReview(inANewTab);
    }

    public void clickFreeFullAccessReview(boolean inANewTab) {
        selectFacetViaShortcut(new ArrayList<>(Arrays.asList(TestData.FACET_CATEGORY_RESOURCES_TYPE_PRESENTATIONS)));
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

    public String getCollectionOrUnitCardTitle(int position) {
        return super.getCollectionOrUnitCardTitle(position);
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

    public void checkLessonPlanetProvider() {
        expandProviderFacetIfCollapsed();
        try {
            selectFacetFilter(TestData.FACET_PROVIDERS, TestData.FACET_PROVIDERS_LESSONPLANET);
            //TODO: SELECT CHILD IF POSSIBLE ///
        } catch (NullPointerException exception) {
            logger.info("The facet Provider was not found " + exception.toString());
        }

        try {
            selectFacetFilter(TestData.FACET_CONTENT_CURATORS, TestData.FACET_PROVIDERS_LESSONPLANET);
        } catch (Exception exception) {
            logger.info("The facet Content Curators was not found " + exception.toString());
        }

        try {
            driver.findElement(By.cssSelector("[class='lp-filter-group parent-provider_ids'] [class='lp-filter-head']")).click();
            logger.info("The Provider facet was collapsed ");
        } catch (Exception ex) {
            logger.info("The Provider facet was already collapsed " + ex.toString());
        }
    }

    public void expandProviderFacetIfCollapsed() {
        //the provider is hidden by default for Custom SL - Henry  -  needs to be optimised
        try {
            driver.findElement(By.cssSelector("[class='lp-filter-group parent-provider_ids closed']")).click();
            logger.info("The Provider facet was expanded ");
        } catch (Exception ex) {
            logger.info("The Provider facet was already expanded " + ex.toString());
        }
    }

    public void scrollToTop() {
        scrollToElement(THUMBNAIL_VIEW_BUTTON);
    }

    public void expandProvidersFacet() {
        clickElement(PROVIDERS_FACET);
    }

    public void selectFacetViaShortcut(ArrayList<String> facets) {
        String pathToLoad = getPath();
        if (pathToLoad.contains(TestData.SEARCH_PAGE_PATH + "?")) {
            pathToLoad += "&";
        } else {
            pathToLoad = TestData.SEARCH_PAGE_PATH + "?";
        }

        for (String facet : facets) {
            if (TestData.SKIP_FACET_FILTERS) {
                pathToLoad += facetsMap.get(facet).get(1) + "&";
            } else {
                if (facet.equals(TestData.FACET_PROVIDERS_LESSONPLANET)) {
                    checkLessonPlanetProvider();
                } else {
                    selectFacetFilter(facetsMap.get(facet).get(0), facet);
                }
            }
        }

        if (TestData.SKIP_FACET_FILTERS) {
            loadPath(pathToLoad);
        }
    }

    public void generateFacetFiltersList() {
        facetsMap.put(TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS, new ArrayList<String>() {{
            add(TestData.FACET_CATEGORY_RESOURCES_TYPES);
            add("type_ids[]=357917");
        }});

        facetsMap.put(TestData.FACET_CATEGORY_RESOURCES_TYPE_WEBSITES, new ArrayList<String>() {{
            add(TestData.FACET_CATEGORY_RESOURCES_TYPES);
            add("type_ids[]=39185");
        }});

        facetsMap.put(TestData.FACET_CATEGORY_SUBJECTS_TYPE_MATH, new ArrayList<String>() {{
            add(TestData.FACET_CATEGORY_SUBJECTS);
            add("subject_ids[]=365220");
        }});

        facetsMap.put(TestData.FACET_CATEGORY_RESOURCES_TYPE_GRAPHICS_AND_IMAGES, new ArrayList<String>() {{
            add(TestData.FACET_CATEGORY_RESOURCES_TYPES);
            add("type_ids[]=357964");
        }});

        facetsMap.put(TestData.FACET_CATEGORY_SUBJECTS_TYPE_SPECIAL_EDUCATION_AND_PROGRAMS, new ArrayList<String>() {{
            add(TestData.FACET_CATEGORY_SUBJECTS);
            add("subject_ids[]=370237");
        }});

        facetsMap.put(TestData.FACET_CATEGORY_RESOURCES_TYPE_VIDEOS, new ArrayList<String>() {{
            add(TestData.FACET_CATEGORY_RESOURCES_TYPES);
            add("type_ids[]=365229");
        }});

        facetsMap.put(TestData.FACET_CATEGORY_SUBJECTS_CLASSROOM_SUPPORT, new ArrayList<String>() {{
            add(TestData.FACET_CATEGORY_SUBJECTS);
            add("subject_ids[]=365210");
        }});

        facetsMap.put(TestData.FACET_CATEGORY_RESOURCES_TYPE_PRESENTATIONS, new ArrayList<String>() {{
            add(TestData.FACET_CATEGORY_RESOURCES_TYPES);
            add("type_ids[]=357920");
        }});

        facetsMap.put(TestData.FACET_CATEGORY_RESOURCES_TYPE_HANDOUTS_REFERENCES, new ArrayList<String>() {{
            add(TestData.FACET_CATEGORY_RESOURCES_TYPES);
            add("type_ids[]=989480");
        }});

        facetsMap.put(TestData.FACET_CATEGORY_RESOURCES_TYPE_CURRICULUM_SETS, new ArrayList<String>() {{
            add(TestData.FACET_CATEGORY_RESOURCES_TYPES);
            add("type_ids[]=1173937");
        }});

        facetsMap.put(TestData.FACET_CATEGORY_RESOURCES_TYPE_UNIT_MODULES, new ArrayList<String>() {{
            add(TestData.FACET_CATEGORY_RESOURCES_TYPES);
            add("type_ids[]=1173940");
        }});

        facetsMap.put(TestData.FACET_CATEGORY_RESOURCES_TYPE_COLLECTIONS_TYPES, new ArrayList<String>() {{
            add(TestData.FACET_CATEGORY_RESOURCES_TYPES);
            add("type_ids[]=107764");
        }});

        facetsMap.put(TestData.PRIMARY_SOURCES_TYPE, new ArrayList<String>() {{
            add(TestData.FACET_CATEGORY_RESOURCES_TYPES);
            add("type_ids[]=376224");
        }});

        facetsMap.put(TestData.FACET_CATEGORY_RESOURCES_TYPE_ARTICLES, new ArrayList<String>() {{
            add(TestData.FACET_CATEGORY_RESOURCES_TYPES);
            add("type_ids[]=357927");
        }});

        facetsMap.put(TestData.FACET_CATEGORY_RESOURCES_TYPE_PRINTABLES_AND_TEMPLATES, new ArrayList<String>() {{
            add(TestData.FACET_CATEGORY_RESOURCES_TYPES);
            add("type_ids[]=360805");
        }});

        facetsMap.put(TestData.FACET_PROVIDERS_LESSONPLANET, new ArrayList<String>() {{
            add(TestData.FACET_PROVIDERS);
            add("provider_ids[]=1");
        }});
        facetsMap.put(TestData.FACET_PROVIDERS_HENRY_COUNTRY_SCHOOLS, new ArrayList<String>() {{
            add(TestData.FACET_PROVIDERS);
            add("provider_ids[]=13");
        }});

        facetsMap.put(TestData.FACET_PROVIDERS_COBB_COUNTRY_SCHOOLS, new ArrayList<String>() {{
            add(TestData.FACET_PROVIDERS);
            add("provider_ids[]=8");
        }});

        facetsMap.put(TestData.FACET_PROVIDERS_MCGRAW_HILL_EDUCATION, new ArrayList<String>() {{
            add(TestData.FACET_PROVIDERS);
            add("provider_ids[]=118");
        }});

        facetsMap.put(TestData.FACET_PROVIDERS_CLAIRMONT_PRESS, new ArrayList<String>() {{
            add(TestData.FACET_PROVIDERS);
            add("provider_ids[]=99");
        }});

    }
}
