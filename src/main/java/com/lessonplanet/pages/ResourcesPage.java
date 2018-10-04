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
    protected static final String SEE_REVIEW_BUTTON = "[class*='panel-footer'] [href*='teachers']:not([class*='free-sample'])";
    protected static final String GET_FREE_ACCESS_BUTTON = "[class*='panel-footer'] [class*='free-access-btn']";
    private static final String GO_TO_RESOURCE_BUTTON_FOR_REGULAR_RESOURCE = "[class*='trk-goto-resource'][href^='/goto/']";
    private static final String GO_TO_RESOURCE_BUTTON_FOR_SHARED_RESOURCE = "[class*='trk-goto-resource'][href^='/drive/documents/']";
    private static final String SEE_PREVIEW_BUTTON = "[class*='panel-footer'] [href*='/member/resource']";
    private static final String FREE_FULL_ACCESS_BUTTON = "[class*='panel-footer'] [class*='free-sample']";
    private static final String SEE_FULL_REVIEW_BUTTON = "[class*='panel-footer'] [class*='trk-show-resource']";

    private static final String PREVIOUS_BUTTON = "[class='pagination'] [class*='previous_page'] a";
    private static final String NEXT_BUTTON = "[class='pagination'] [class*='next_page'] a";
    private static final String SEE_ALL_BUTTON = "[class='pagination'] #see_all";

    private static final Logger logger = LogManager.getRootLogger();

    public ResourcesPage(WebDriver driver) {
        super(driver);
    }

//    private WebElement selectFacetCategory(String facetCategory) {
//        //returns the entire category with all options
//        List<WebElement> categories = findElements(FACETS_CATEGORIES);
//        for (WebElement category : categories) {
//            if (category.getText().startsWith(facetCategory)) {
//                return category;
//            }
//        }
//        logger.error("The facet category " + facetCategory + " was not found");
//        return null;
//    }

    //    private WebElement selectWidgetCategory(String widgetSelector, String widgetCategory) {
    protected WebElement getCategoryFromLeftSide(String widgetSelector, String widgetCategory) {
        //returns the entire category with all options
        List<WebElement> categories = findElements(widgetSelector);
        for (WebElement category : categories) {
            if (category.getText().startsWith(widgetCategory)) {
                return category;
            }
        }
        logger.error("The facet category " + widgetCategory + " was not found");
        return null;
    }

    public void selectFacetFilter(String facetCategoryName, String facetName) {
        clickOptionFromLeftSide(FACETS_CATEGORIES, facetCategoryName, FACET_OPTIONS, facetName);
    }

    public void clickOptionFromLeftSide(String widgetCategorySelector, String widgetCategoryName, String optionNameSelector, String optionName) {
        WebElement option = getOptionFromLeftSide(widgetCategorySelector, widgetCategoryName, optionNameSelector, optionName);
        if (findElements(option, UNSELECTED_FACET_OPTIONS).size() >= 0) {
            option.click();
            waitForPageLoad();
            return;
        } else {
            logger.info("The option " + optionName + " from category " + widgetCategoryName + " is already selected.");
            return;
        }
    }

    public WebElement getOptionFromLeftSide(String widgetCategorySelector, String widgetCategoryName, String optionNameSelector, String optionName) {
        waitForPageLoad();
        WebElement category = getCategoryFromLeftSide(widgetCategorySelector, widgetCategoryName);
        // parse all options and select the option that contains the string facetName
        List<WebElement> options = findElements(category, optionNameSelector);
        for (WebElement option : options) {
            if (option.getText().contains(optionName)) {
                return option;
            }
        }
        logger.error("The option " + optionName + " from category " + widgetCategoryName + " was not found.");
        return null;
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

    protected void clickFirstButtonOfType(String cssSelector, boolean inANewTab) {
        WebElement button = findElements(cssSelector).get(0);
        if (inANewTab) {
            openInANewTab(button);
        } else {
            button.click();
        }
    }

    public int getCountFreeAcessButtons() {
        return findElements(GET_FREE_ACCESS_BUTTON).size();
    }

    public int getCountSeeReviewButton() {
        return findElements(SEE_REVIEW_BUTTON).size();
    }

    public void clickOnPreviousButton() {
        clickElement(PREVIOUS_BUTTON);
    }

    public boolean isPreviousButtonDisplayed() {
        return isElementClickable(PREVIOUS_BUTTON);
    }

    public void clickOnNextButton() {
        clickElement(NEXT_BUTTON);
    }

    public boolean isSeeAllButtonDisplayed() {
        return isElementClickable(SEE_ALL_BUTTON);
    }

    public void clickOnSeeAllButton() {
        clickElement(SEE_ALL_BUTTON);
    }
}
