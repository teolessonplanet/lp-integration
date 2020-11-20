package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CollectionPlayerPage extends LpUiBasePage {
    private static final String LESSON_PLANET_LOGO = "#player-wrap [class^='lp-player-logo']";
    private static final String NEXT_ITEM = "#player-view-port-slider-next";
    private static final String PREVIOUS_ITEM = "#player-view-port-slider-prev";
    private static final String DOWNLOAD_BUTTON = "#player-action-direct-download";
    private static final String ASSIGN_FOLDER_BUTTON = "#assign-to-student";
    private static final String SHOW_OR_HIDE_NAVIGATOR_SLIDER = "#player-navigator [class='player-navigator-toggle']";
    private static final String CURRENT_POSITION_IN_LIST_TEXT = "#player-navigator div[class='player-navigator-position']";
    private static final String CLOSE_BUTTON = "[class='player-navigator-toggle'] [class*='close']";
    private static final String UP_ARROW_BUTTON = "[class='player-navigator-toggle'] [class*='fa-angle-up']";
    private static final String COLLECTION_ITEM = "[class='player-item-list'] div[class='non-interactive-container']";
    private static final String COLLECTION_ITEMS_LIST = "[class^='panel-container'] li[class^='panel']";

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

    public boolean isDownloadButtonDisplayed() {
        return isElementDisplayed(DOWNLOAD_BUTTON);
    }

    public boolean isUpArrowButtonDisplayed() {
        return isElementDisplayed(UP_ARROW_BUTTON);
    }

    public void clickOnUpArrowButton() {
        clickElement(UP_ARROW_BUTTON);
    }

    public void waitUntilNavigatorItemSliderIsHidden() {
        waitUntilElementIsHidden(CLOSE_BUTTON);
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
}
