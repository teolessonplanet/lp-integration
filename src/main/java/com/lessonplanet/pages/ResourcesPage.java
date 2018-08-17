package com.lessonplanet.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

import java.util.List;

public class ResourcesPage extends LpUiBasePage {

    private static final String RESOURCE_CARDS = "[class*='list-card']";

    private static final String FACETS_CATEGORIES = "[class='panel panel-default mb5']";
    private static final String FACET_OPTIONS = "li";
    private static final String UNSELECTED_FACET_OPTIONS = "[class*='fa-square-o']";

    private static final String RESOURCES_IN_THUMBNAIL_VIEW = "[class*='thumbnail-card']";
    private static final String RESOURCES_IN_TILED_VIEW = "[class*='tiled-card']";
    private static final String RESOURCES_IN_LIST_VIEW = "[class*='list-card']";

    private static final String SEE_COLLECTION_BUTTON = "[class*='panel-footer'] [href*='/collections/']";
    private static final String SEE_REVIEW_BUTTON = "[class*='panel-footer'] [href*='teachers']:not([class*='free-sample'])";
    private static final String GET_FREE_ACCESS_BUTTON = "[class*='panel-footer'] [class*='free-access-btn']";
    private static final String GO_TO_RESOURCE_BUTTON_FOR_REGULAR_RESOURCE = "[class*='trk-goto-resource'][href^='/goto/']";
    private static final String GO_TO_RESOURCE_BUTTON_FOR_SHARED_RESOURCE = "[class*='trk-goto-resource'][href^='/drive/documents/']";
    private static final String SEE_PREVIEW_BUTTON = "[class*='panel-footer'] [href*='/member/resource']";
    private static final String FREE_FULL_ACCESS_BUTTON = "[class*='panel-footer'] [class*='free-sample']";
    private static final String SEE_FULL_REVIEW_BUTTON = "[class*='panel-footer'] [class*='trk-show-resource']";

    private static final Logger logger = LogManager.getRootLogger();

    public ResourcesPage(WebDriver driver) {
        super(driver);
    }

    private WebElement selectFacetCategory(String facetCategory) {
        //returns the entire category with all options
        List<WebElement> categories = findElements(FACETS_CATEGORIES);
        for (WebElement category : categories) {
            if (category.getText().startsWith(facetCategory)) {
                return category;
            }
        }
        logger.error("The facet category " + facetCategory + " was not found");
        return null;
    }

    public void selectFacetFilter(String facetCategory, String facetName) {
        waitForPageLoad();
        WebElement category = selectFacetCategory(facetCategory);
        // parse all options and select the option that contains the string facetName
        List<WebElement> options = findElements(category, FACET_OPTIONS);
        for (WebElement option : options) {
            if (option.getText().contains(facetName)) {
                if (findElements(option, UNSELECTED_FACET_OPTIONS).size() > 0) {
                    option.click();
                    waitForPageLoad();
                    return;
                } else {
                    logger.info("The option " + facetName + " from category " + facetCategory + " is already selected.");
                    return;
                }
            }
        }
        logger.error("The option " + facetName + " from category " + facetCategory + " was not found.");
    }

    public List<WebElement> getAllResources() {
        waitForPageLoad();
        return findElements(GO_TO_RESOURCE_BUTTON_FOR_SHARED_RESOURCE);
    }

    public int getCountResourcesInListMode() {
        return findElements(RESOURCES_IN_LIST_VIEW).size();
    }

    public int getCountResourcesInTiledMode() {
        return findElements(RESOURCES_IN_TILED_VIEW).size();
    }

    public int getCountResourcesInThumbnailMode() {
        return findElements(RESOURCES_IN_THUMBNAIL_VIEW).size();
    }

    public void clickSeeCollection(boolean inANewTab) {
        selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_COLLECTIONS);
        clickFirstButtonOfType(SEE_COLLECTION_BUTTON, inANewTab);
    }

    public void clickSeeReview(boolean inANewTab) {
        selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);
        clickFirstButtonOfType(SEE_REVIEW_BUTTON, inANewTab);
    }

    public void clickGetFreeAccess(boolean inANewTab) {
        selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_PRINTABLES_AND_TEMPLATES);
        clickFirstButtonOfType(GET_FREE_ACCESS_BUTTON, inANewTab);
    }

    public void clickSeePreview(boolean inANewTab) {
        selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_PRINTABLES_AND_TEMPLATES);
        clickFirstButtonOfType(SEE_PREVIEW_BUTTON, inANewTab);
    }

    public void clickGoToResourceForSharedResource(boolean inANewTab) {
        selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_PRESENTATIONS);
        clickFirstButtonOfType(GO_TO_RESOURCE_BUTTON_FOR_SHARED_RESOURCE, inANewTab);
    }

    public void clickGoToResourceForRegularResource(boolean inANewTab) {
        selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_PRESENTATIONS);
        clickFirstButtonOfType(GO_TO_RESOURCE_BUTTON_FOR_REGULAR_RESOURCE, inANewTab);
    }

    public void clickFreeFullAccessReview(boolean inANewTab) {
        clickFirstButtonOfType(FREE_FULL_ACCESS_BUTTON, inANewTab);
    }

    public void clickSeeFullReview(boolean inANewTab) {
        selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);
        clickFirstButtonOfType(SEE_FULL_REVIEW_BUTTON, inANewTab);
    }

    private void clickFirstButtonOfType(String cssSelector, boolean inANewTab) {
        WebElement button = findElements(cssSelector).get(0);
        if (inANewTab) {
            openInANewTab(button);
        } else {
            button.click();
        }
    }
}
