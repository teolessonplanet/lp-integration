package com.lessonplanet.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

import java.util.List;

public class ResourcesPage extends LpUiBasePage {

    private static final String UNSELECTED_FACET_OPTIONS = "[class*='fa-square-o']";

    private static final String UNLOCKED_RESOURCES_IN_THUMBNAIL_VIEW = "[class*='thumbnail-card'] [class='panel-body'] [class='trk-show-resource']";
    private static final String LOCKED_RESOURCES_IN_THUMBNAIL_VIEW = "[class*='thumbnail-card'] [class='panel-body'] [class='locked']";

    private static final String UNLOCKED_RESOURCES_IN_TILED_VIEW = "[class*='tiled-card'] [class='trk-show-resource']";
    private static final String LOCKED_RESOURCES_IN_TILED_VIEW = "[class*='tiled-card'] [class='locked']";
    private static final String UNLOCKED_RESOURCES_IN_LIST_VIEW = "[class*='list-card'] [class='trk-show-resource']";
    private static final String LOCKED_RESOURCES_IN_LIST_VIEW = "[class*='list-card'] [class='locked']";

    private static final String SEE_COLLECTION_BUTTON = "[class*='panel-footer'] [href*='/collections/']";
    protected static final String SEE_REVIEW_BUTTON = "[class*='panel-footer'] [href*='teachers']:not([class*='free-sample'])";
    protected static final String GET_FREE_ACCESS_BUTTON = "[class*='panel-footer'] [class*='free-access-btn']";
    protected static final String GO_TO_RESOURCE_BUTTON_FOR_REGULAR_RESOURCE = "[class*='trk-goto-resource'][href^='/goto/']";
    private static final String GO_TO_RESOURCE_BUTTON_FOR_SHARED_RESOURCE = "[class*='trk-goto-resource'][href^='/drive/documents/']";
    private static final String SEE_PREVIEW_BUTTON = "[class*='panel-footer'] [href*='/member/resource']";
    private static final String FREE_FULL_ACCESS_BUTTON = "[class*='panel-footer'] [class*='free-sample']";
    protected static final String SEE_FULL_REVIEW_BUTTON = "[class*='panel-footer'] [class*='trk-show-resource']";

    protected static final String UPGRADE_FOR_ACCESS_BUTTON = "[class='panel-footer'] [href*='/subscription/new?ref=']";

    private static final String PREVIOUS_BUTTON = "[class='pagination'] [class*='previous_page'] a";
    private static final String NEXT_BUTTON = "[class='pagination'] [class*='next_page'] a";
    private static final String SEE_ALL_BUTTON = "[class='pagination'] #see_all";

    private static final String UPGRADE_ME_NOW_BUTTON = "div[class*='vertical-align'] [class*='btn-success']";

    private static final Logger logger = LogManager.getRootLogger();

    public ResourcesPage(WebDriver driver) {
        super(driver);
    }

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


    public void clickOptionFromLeftSide(String widgetCategorySelector, String widgetCategoryName, String optionNameSelector, String optionName) {
        WebElement option = getOptionFromLeftSide(widgetCategorySelector, widgetCategoryName, optionNameSelector, optionName);
        //if the facet is already selected, ignore it
        if (findElements(option, UNSELECTED_FACET_OPTIONS).size() > 0) {
            clickElement(option);
            return;
        } else {
            logger.info("The option " + optionName + " from category " + widgetCategoryName + " is already selected.");
            return;
        }
    }

    public WebElement getOptionFromLeftSide(String widgetSelector, String widgetName, String optionSelector, String optionName) {
        WebElement category = getCategoryFromLeftSide(widgetSelector, widgetName);
        // parse all options and select the option that contains the string facetName
        List<WebElement> options = findElements(category, optionSelector);
        for (WebElement option : options) {
            if (option.getText().contains(optionName)) {
                return option;
            }
        }
        logger.error("The option " + optionName + " from category " + widgetName + " was not found.");
        return null;
    }

    public List<WebElement> getAllResources() {
        return findElements(GO_TO_RESOURCE_BUTTON_FOR_SHARED_RESOURCE);
    }

    public WebElement getFreeAccessResource() {
        waitForPageLoad();
        return findElement(GET_FREE_ACCESS_BUTTON);
    }

    public List<WebElement> getAllFreeAccessButtons() {
        return findElements(GET_FREE_ACCESS_BUTTON);
    }

    public List<WebElement> getAllSeeCollectionsButtons(){
        return findElements(SEE_COLLECTION_BUTTON);
    }

    public int getCountUnlockedResourcesInListMode() {
        return findElements(UNLOCKED_RESOURCES_IN_LIST_VIEW).size();
    }

    public int getCountUnlockedResourcesInTiledMode() {
        return findElements(UNLOCKED_RESOURCES_IN_TILED_VIEW).size();
    }

    public int getCountUnlockedResourcesInThumbnailMode() {
        return findElements(UNLOCKED_RESOURCES_IN_THUMBNAIL_VIEW).size();
    }

    public int getCountLockedResourcesInListMode() {
        return findElements(LOCKED_RESOURCES_IN_LIST_VIEW).size();
    }

    public int getCountLockedResourcesInTiledMode() {
        return findElements(LOCKED_RESOURCES_IN_TILED_VIEW).size();
    }

    public int getCountLockedResourcesInThumbnailMode() {
        return findElements(LOCKED_RESOURCES_IN_THUMBNAIL_VIEW).size();
    }

    protected void clickSeeCollection(boolean inANewTab) {
        clickFirstButtonOfType(SEE_COLLECTION_BUTTON, inANewTab);
    }

    public void clickSeeReview(boolean inANewTab) {
        clickFirstButtonOfType(SEE_REVIEW_BUTTON, inANewTab);
    }

    public void clickGetFreeAccess(boolean inANewTab) {
        clickFirstButtonOfType(GET_FREE_ACCESS_BUTTON, inANewTab);
    }

    public void clickSeePreview(boolean inANewTab) {
        clickFirstButtonOfType(SEE_PREVIEW_BUTTON, inANewTab);
    }

    public void clickGoToResourceForSharedResource(boolean inANewTab) {
        clickFirstButtonOfType(GO_TO_RESOURCE_BUTTON_FOR_SHARED_RESOURCE, inANewTab);
    }

    public void clickGoToResourceForRegularResource(boolean inANewTab) {
        clickFirstButtonOfType(GO_TO_RESOURCE_BUTTON_FOR_REGULAR_RESOURCE, inANewTab);
    }

    public void clickFreeFullAccessReview(boolean inANewTab) {
        clickFirstButtonOfType(FREE_FULL_ACCESS_BUTTON, inANewTab);
    }

    public void clickSeeFullReview(boolean inANewTab) {
        clickFirstButtonOfType(SEE_FULL_REVIEW_BUTTON, inANewTab);
    }

    protected void clickFirstButtonOfType(String cssSelector, boolean inANewTab) {
        //TODO: add here the magic code
        boolean webElementWasFound = false;
        int attempts = TestData.SHORT_TIMEOUT;
        WebElement button = null;
        do {
            try {
                button = findElements(cssSelector).get(0);
                webElementWasFound = true;
            } catch (Exception ex) {
                // element was not found on the current page, click next page
                clickOnNextButton();
                attempts--;
            }
        } while (!webElementWasFound && attempts > 0);
        if (attempts == 0) {
            logger.error("The button " + cssSelector + " was not found on the first " + TestData.SHORT_TIMEOUT + " pages");
        }
        openInANewTabOrClick(button, inANewTab);
    }

    public int getCountFreeAccessButtons() {
        return findElements(GET_FREE_ACCESS_BUTTON).size();
    }

    public int getCountSeeReviewButton() {
        return findElements(SEE_REVIEW_BUTTON).size();
    }

    public int getCountGoToResourceButtons() {
        return findElements(GO_TO_RESOURCE_BUTTON_FOR_REGULAR_RESOURCE).size();
    }

    public int getCountSeeFullReviewButton() {
        return findElements(SEE_FULL_REVIEW_BUTTON).size();
    }

    public int getCountUpgradeForAccessButton() {
        return findElements(UPGRADE_FOR_ACCESS_BUTTON).size();
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

    public void clickOnUpgradeMeNowButton() {
        clickElement(UPGRADE_ME_NOW_BUTTON);
    }
}
