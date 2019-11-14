package com.lessonplanet.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

import java.util.ArrayList;
import java.util.List;

public class ResourcesPage extends LpUiBasePage {

    protected static final String SEE_REVIEW_BUTTON = "[class*='panel-footer'] [href*='teachers']:not([class*='free-sample'])";
    protected static final String GET_FREE_ACCESS_BUTTON = "[class*='panel-footer'] [class*='free-access-btn']";
    protected static final String GO_TO_RESOURCE_BUTTON_FOR_REGULAR_RESOURCE = "[class*='trk-goto-resource'][href^='/goto/']";
    protected static final String SEE_FULL_REVIEW_BUTTON = "[class*='panel-footer'] [class*='trk-show-resource']";
    protected static final String UPGRADE_FOR_ACCESS_BUTTON = "[class='panel-footer'] [href*='/subscription/new?ref=']";
    private static final String UNSELECTED_FACET_OPTIONS = "[class*='fa-square-o']";
    private static final String UNLOCKED_RESOURCES_IN_THUMBNAIL_VIEW = "[class*='thumbnail-card'] [class='panel-body'] [class='trk-show-resource']";
    private static final String LOCKED_RESOURCES_IN_THUMBNAIL_VIEW = "[class*='thumbnail-card'] [class='panel-body'] [class='locked']";
    private static final String UNLOCKED_RESOURCES_IN_TILED_VIEW = "[class*='tiled-card'] [class='trk-show-resource']";
    private static final String LOCKED_RESOURCES_IN_TILED_VIEW = "[class*='tiled-card'] [class='locked']";
    private static final String UNLOCKED_RESOURCES_IN_LIST_VIEW = "[class*='list-card'] [class='trk-show-resource']";
    private static final String LOCKED_RESOURCES_IN_LIST_VIEW = "[class*='list-card'] [class='locked']";
    private static final String SEE_COLLECTION_BUTTON = "[class*='panel-footer'] [href*='/collections/']";
    private static final String GO_TO_RESOURCE_BUTTON_FOR_SHARED_RESOURCE = "[class*='trk-goto-resource'][href^='/drive/documents/']";
    private static final String SEE_PREVIEW_BUTTON = "[class*='panel-footer'] [href*='/member/resource']";
    private static final String FREE_FULL_ACCESS_BUTTON = "[class*='panel-footer'] [class*='free-sample']";
    private static final String PREVIOUS_BUTTON = "[class='pagination'] [class*='previous_page'] a";
    private static final String NEXT_BUTTON = "[class='pagination'] [class*='next_page'] a";
    private static final String SEE_ALL_BUTTON = "[class='pagination'] #see_all";

    private static final String UPGRADE_ME_NOW_BUTTON = "a[data-track-click='Limited Search Upgrade'][data-track-label='Search Page']";

    private static final String RESOURCE_CARDS = "#search-results [class*='search-result-item']";
    private static final String COLLECTION_CARD_TITLE = "#search-results [class='col-xs-12 list-card'] div h4";
    private static final String REGULAR_RESOURCE_CARD = "#search-results [data-type='Resource']";
    private static final String SHARED_RESOURCE_CARD = "#search-results [data-type='Drive::Document']";
    private static final String FREE_SAMPLE_RESOURCE_CARD = "#search-results [data-type='Resource'] [class='panel panel-default panel-resource free-sample'] h4";


    private static final String ALL_RESOURCES_CARDS = "#search-results [class*='panel-resource']";
    private static final String CARD_ICON = "[class*='file-icon']";
    private static final String CARD_RESOURCE_TYPE = "div[class*='resource-icon']";
    private static final String CARD_TITLE_TEXT = "h4[class*='resource-title']";
    private static final String CARD_STAR_RATING = "span[class='star-rating']";
    private static final String CARD_FA_GRADUATION = "span[class*='detail-grades']";
    private static final String CARD_CSS_OPTIONAL = "span[class*='details-ccss']";
    private static final String CARD_DESCRIPTION_TEXT = "div[class='resource-description']";
    private static final String CARD_UNIVERSITY_TEXT = "span[class*='detail-subject']";
    private static final String CARD_SHARED_RESOURCE_TAG = "span[class*='shared-resource-tag']";
    private static final String CARD_SHARED_RESOURCE_TAG_LIST_OR_TILED_VIEW = "[class*='star-rating'] [class*='label-info']";
    private static final String CARD_FREE_SAMPLE_STAMP_ICON = "div[class*='free-sample-stamp']";

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
        List<WebElement> options = category.findElements(By.cssSelector(optionSelector));
        for (WebElement option : options) {
            if (option.getText().contains(optionName)) {
                return option;
            }
        }
        logger.error("The option " + optionName + " from category " + widgetName + " was not found.");
        return null;
    }

    public WebElement getFreeAccessResource() {
        waitForPageLoad();
        return findElement(GET_FREE_ACCESS_BUTTON);
    }

    public List<WebElement> getAllFreeAccessButtons() {
        return findElements(GET_FREE_ACCESS_BUTTON);
    }

    public List<WebElement> getAllSeeCollectionsButtons() {
        return findElements(SEE_COLLECTION_BUTTON);
    }

    public List<WebElement> getAllSeeFullReviewButtons() {
        return findElements(SEE_FULL_REVIEW_BUTTON);
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

    public void clickSeeCollection(boolean inANewTab) {
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

    public String getCollectionCardTitle(int position) {
        return getTextForElement(COLLECTION_CARD_TITLE, position);
    }

    public String getRegularResourceCardDataId(int position) {
        return getElementAttribute(REGULAR_RESOURCE_CARD, "data-id", position);
    }

    public String getSharedResourceCardDataId(int position) {
        return getElementAttribute(SHARED_RESOURCE_CARD, "data-id", position);
    }

    public String getResourceCardDataType(int position) {
        return getElementAttribute(RESOURCE_CARDS, "data-type", position);
    }

    public String getFreeSampleResourceCardTitle(int position) {
        return getElementAttribute(FREE_SAMPLE_RESOURCE_CARD, "title", position);
    }

    public int getFreeSampleResourcePosition() {
        final List<WebElement> resourceCards = findElements(REGULAR_RESOURCE_CARD);
        int freeSamplePosition = 0;
        for (int i = 0; i < resourceCards.size(); i++) {
            if (findElements(("#search-results [class*='panel-footer'] a:nth-child(1)")).get(i).getText().equals("Free: Full Access Review")) {
                freeSamplePosition = i;
            }
        }
        return freeSamplePosition;
    }

    public List<WebElement> getLimitedLpResourcesCards() {
        return getResourceOfType(GET_FREE_ACCESS_BUTTON);
    }

    public List<WebElement> getCollectionCards() {
        return getResourceOfType(SEE_COLLECTION_BUTTON);
    }

    public List<WebElement> getSharedResourcesCards() {
        return getResourceOfType(GO_TO_RESOURCE_BUTTON_FOR_SHARED_RESOURCE);
    }

    public List<WebElement> getSampleResourceCards() {
        return getResourceOfType(FREE_FULL_ACCESS_BUTTON);
    }

    public List<WebElement> getFullLpResourcesCards() {
        return getResourceOfType(GO_TO_RESOURCE_BUTTON_FOR_REGULAR_RESOURCE);
    }

    private List<WebElement> getResourceOfType(String buttonCssSelector) {
        List<WebElement> allCards = getAllResources();
        List<WebElement> lpResources = new ArrayList<>();
        for (WebElement card : allCards) {
            try {
                card.findElement(By.cssSelector(buttonCssSelector));
                lpResources.add(card);
            } catch (org.openqa.selenium.NoSuchElementException ex) {
                logger.info("Card does not contain the required item ");
            }
        }
        return lpResources;
    }

    private List<WebElement> getAllResources() {
        try {
            return findElements(ALL_RESOURCES_CARDS);
        } catch (org.openqa.selenium.NoSuchElementException ex) {
            logger.error("Elements were not found! ");
            return null;
        }
    }

    public WebElement getGetFreeAccessButtonForCard(WebElement card) {
        return card.findElement(By.cssSelector(GET_FREE_ACCESS_BUTTON));
    }

    public String getFreeAccessButtonText(WebElement card) {
        return getTextForButton(getGetFreeAccessButtonForCard(card));
    }

    public WebElement getSeeReviewButtonForCard(WebElement card) {
        return card.findElement(By.cssSelector(SEE_REVIEW_BUTTON));
    }

    public String getSeeReviewButtonText(WebElement card) {
        return getTextForButton(getSeeReviewButtonForCard(card));
    }

    public WebElement getSeeCollectionButtonForCard(WebElement card) {
        return card.findElement(By.cssSelector(SEE_COLLECTION_BUTTON));
    }

    public String getSeeCollectionButtonTextForCard(WebElement card) {
        return getTextForButton(getSeeCollectionButtonForCard(card));
    }

    public WebElement getGoToResourceButtonForSharedCard(WebElement card) {
        return card.findElement(By.cssSelector(GO_TO_RESOURCE_BUTTON_FOR_SHARED_RESOURCE));
    }

    public String getGoToResourceButtonTextForSharedCard(WebElement card) {
        return getTextForButton(getGoToResourceButtonForSharedCard(card));
    }

    public WebElement getSeePreviewButtonForSharedCard(WebElement card) {
        return card.findElement(By.cssSelector(SEE_PREVIEW_BUTTON));
    }

    public String getSeePreviewButtonTextForSharedCard(WebElement card) {
        return getTextForButton(getSeePreviewButtonForSharedCard(card));
    }

    public WebElement getGoToResourceButtonForRegularCard(WebElement card) {
        return card.findElement(By.cssSelector(GO_TO_RESOURCE_BUTTON_FOR_REGULAR_RESOURCE));
    }

    public String getGoToResourceButtonTextForRegularCard(WebElement card) {
        return getTextForButton(getGoToResourceButtonForRegularCard(card));
    }

    public WebElement getSeeFullReviewButtonForRegularCard(WebElement card) {
        return card.findElement(By.cssSelector(SEE_FULL_REVIEW_BUTTON));
    }

    public String getSeeFullReviewButtonTextForRegularCard(WebElement card) {
        return getTextForButton(getSeeFullReviewButtonForRegularCard(card));
    }

    public WebElement getFreeFullAccessButtonForCard(WebElement card) {
        return card.findElement(By.cssSelector(FREE_FULL_ACCESS_BUTTON));
    }

    public String getFreeFullAccessButtonTextForCard(WebElement card) {
        return getTextForButton(getFreeFullAccessButtonForCard(card));
    }

    private String getTextForButton(WebElement button) {
        waitForLoad();
        waitUntilElementIsDisplayed(button);
        return button.getText();
    }

    public boolean isCardIconDisplayed(WebElement card) {
        return isElementDisplayed(card, CARD_ICON);
    }

    public boolean isCardResourceTypeDisplayed(WebElement card) {
        return isElementDisplayed(card, CARD_RESOURCE_TYPE);
    }

    public boolean isCardTitleDisplayed(WebElement card) {
        return isElementDisplayed(card, CARD_TITLE_TEXT);
    }

    public boolean isCardStarRatingDisplayed(WebElement card) {
        return isElementDisplayed(card, CARD_STAR_RATING);
    }

    public boolean isCardGraduationDisplayed(WebElement card) {
        return isElementDisplayed(card, CARD_FA_GRADUATION);
    }

    public boolean isCardCssDisplayed(WebElement card) {
        return isElementDisplayed(card, CARD_CSS_OPTIONAL);
    }

    public String getCardDescription(WebElement card) {
        return getTextForElement(card, CARD_DESCRIPTION_TEXT);
    }

    public boolean isCardUniversityDisplayed(WebElement card) {
        return isElementDisplayed(card, CARD_UNIVERSITY_TEXT);
    }

    public boolean isCardSharedResourceTagInThumbnailViewDisplayed(WebElement card) {
        return isElementDisplayed(card, CARD_SHARED_RESOURCE_TAG);
    }

    public boolean isCardSharedResourceTagInListOrTiledViewDisplayed(WebElement card) {
        return isElementDisplayed(card, CARD_SHARED_RESOURCE_TAG_LIST_OR_TILED_VIEW) && getTextForElement(card, CARD_SHARED_RESOURCE_TAG_LIST_OR_TILED_VIEW).equals("Shared Resource");
    }

    public boolean isFreeSampleStampIconDisplayed(WebElement card) {
        return isElementDisplayed(card, CARD_FREE_SAMPLE_STAMP_ICON);
    }
}
