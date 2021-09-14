package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

import java.util.List;

public class CollectionPlayerPage extends LpUiBasePage {
    private static final String LESSON_PLANET_LOGO = "#player-wrap [class^='lp-player-logo']";
    private static final String LEARNING_EXPLORER_LOGO = "#player-wrap [src*='lessonplanet.com/assets/logos/learning-explorer-square-logo']";
    private static final String HENRY_LOGO = "#player-wrap #logo[src*='henry_county_logo']";
    private static final String NEXT_ITEM = "#player-view-port-slider-next";
    private static final String PREVIOUS_ITEM = "#player-view-port-slider-prev";
    private static final String DOWNLOAD_BUTTON = "#player-action-direct-download[class='player-action']";
    private static final String HIDDEN_DOWNLOAD_BUTTON = "#player-action-direct-download[class$='hide']";
    private static final String FULL_SCREEN_BUTTON = "#player-action-full-screen[class='player-action']";
    private static final String HIDDEN_FULL_SCREEN_BUTTON = "#player-action-full-screen[class$='hide']";
    private static final String POP_OUT_BUTTON = "#player-action-pop-out";
    private static final String HIDDEN_POP_OUT_BUTTON = "#player-action-pop-out[class$='hide']";
    private static final String ASSIGN_FOLDER_BUTTON = "#assign-to-student";
    private static final String SHOW_OR_HIDE_NAVIGATOR_SLIDER = "#player-navigator [class='player-navigator-toggle']";
    private static final String CURRENT_POSITION_IN_LIST_TEXT = "#player-navigator div[class='player-navigator-position']";
    private static final String CLOSE_BUTTON = "[class='player-navigator-toggle'] [class*='close']";
    private static final String UP_ARROW_BUTTON = "[class='player-navigator-toggle'] [class*='fa-angle-up']";
    private static final String COLLECTION_ITEM = "[class='player-item-list'] div[class='non-interactive-container']";
    private static final String COLLECTION_ITEMS_LIST = "[class^='panel-container'] li[class^='panel']";
    private static final String COLLECTION_ITEMS_TYPE = "[class='resource-type-name']";

    public CollectionPlayerPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCollectionItemDisplayed() {
        return isElementDisplayed(COLLECTION_ITEM);
    }

    public boolean isNextItemButtonDisplayed() {
        return isElementDisplayed(NEXT_ITEM);
    }

    public void clickOnNextItemButton() {
        clickElement(NEXT_ITEM);
    }

    public boolean isPreviousButtonDisplayed() {
        return isElementDisplayed(PREVIOUS_ITEM);
    }

    public void clickOnPreviousButton() {
        clickElement(PREVIOUS_ITEM);
    }

    public boolean isLessonPlanetLogoDisplayed() {
        return isElementDisplayed(LESSON_PLANET_LOGO);
    }

    public void clickOnLessonPlanetLogo() {
        clickElement(LESSON_PLANET_LOGO);
    }

    public void clickOnLearningExplorerLogo() {
        clickElement(LEARNING_EXPLORER_LOGO);
    }

    public boolean isHenryLogoDisplayed() {
        return isElementDisplayed(HENRY_LOGO);
    }

    public void clickOnHenryLogo() {
        clickElement(HENRY_LOGO);
    }

    public boolean isDownloadButtonDisplayed() {
        return isElementDisplayed(DOWNLOAD_BUTTON);
    }

    public boolean isDownloadButtonHidden() {
        return isElementDisplayed(HIDDEN_DOWNLOAD_BUTTON);
    }

    public boolean isFullScreenButtonDisplayed() {
        return isElementDisplayed(FULL_SCREEN_BUTTON);
    }

    public boolean isFullScreenButtonHidden() {
        return isElementDisplayed(HIDDEN_FULL_SCREEN_BUTTON);
    }

    public boolean isPopOutButtonDisplayed() {
        return isElementDisplayed(POP_OUT_BUTTON);
    }

    public boolean isPopOutButtonHidden() {
        return isElementDisplayed(HIDDEN_POP_OUT_BUTTON);
    }

    public boolean isUpArrowButtonDisplayed() {
        return isElementDisplayed(UP_ARROW_BUTTON);
    }

    public void clickOnUpArrowButton() {
        clickElement(UP_ARROW_BUTTON);
    }

    public void waitUntilNavigatorItemSliderIsHidden() {
        waitUntilElementIsHidden(CLOSE_BUTTON, TestData.LONG_TIMEOUT);
    }

    public boolean isCloseButtonDisplayed() {
        return isElementDisplayed(CLOSE_BUTTON);
    }

    public void clickOnCloseButton() {
        clickElement(CLOSE_BUTTON);
    }

    public boolean isCurrentPositionInListDisplayed() {
        return isElementDisplayed(CURRENT_POSITION_IN_LIST_TEXT);
    }

    public boolean isAssignFolderButtonDisplayed() {
        return isElementDisplayed(ASSIGN_FOLDER_BUTTON);
    }

    public void clickAssignFolderButton(){
        clickElement(ASSIGN_FOLDER_BUTTON);
    }

    public boolean isCollectionItemsListDisplayed() {
        return isElementDisplayed(COLLECTION_ITEMS_LIST);
    }

    public List<WebElement> getCollectionItemsList() {
        return findElements(COLLECTION_ITEMS_LIST);
    }

    public int getPositionOfSelectedItem() {
        List<WebElement> items = getCollectionItemsList();
        for (int pos = 0; pos < items.size(); pos++) {
            if (items.get(pos).getAttribute("class").contains("selected")) {
                return pos;
            }
        }
        return -1;
    }

    public String getCollectionItemType(WebElement collectionItem) {
        return findElements(collectionItem, COLLECTION_ITEMS_TYPE).get(0).getText();
    }
}
