package com.lessonplanet.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResourcesPage extends LpUiBasePage {

    private static final String LISTVIEW_BUTTON = "[class='fa fa-th-list']";
    private static final String RESOURCE_CARDS = "[class*='list-card']";

    private static final String FACETS_CATEGORIES = "[class='panel panel-default mb5']";
    private static final String FACET_OPTIONS = "li";

    private static final String SEE_COLLECTION_BUTTON = "[class='panel-footer'] [class*='trk-show-resource']";
    private static final String GO_TO_RESOURCE_BUTTON = "[class*='trk-goto-resource']";

    private static final Logger logger = LogManager.getRootLogger();

    public ResourcesPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnListViewButton() {
        clickElement(LISTVIEW_BUTTON);
        waitForPageLoad();
    }

    public List<WebElement> getAllResourceCards() {
        return findElements(RESOURCE_CARDS);
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
        List<WebElement> options = category.findElements(By.cssSelector(FACET_OPTIONS));
        for (WebElement option : options) {
            if (option.getText().contains(facetName)) {
                option.click();
                waitForPageLoad();
                return;
            }
        }
        logger.error("The option " + facetName + " from category " + facetCategory + " was not found.");
    }

    public List<WebElement> getAllResources() {
        waitForPageLoad();
        return findElements(GO_TO_RESOURCE_BUTTON);
    }
}
