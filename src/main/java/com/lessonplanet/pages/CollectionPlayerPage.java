package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CollectionPlayerPage extends LpUiBasePage {
    private static final String LESSON_PLANET_LOGO = "#player-wrap [class^='lp-player-logo']";
    private static final String NEXT_ITEM = "#player-view-port-slider-next";
    private static final String PREVIOUS_ITEM = "#player-view-port-slider-prev";
    private static final String DOWNLOAD_BUTTON = "#player-action-direct-download";
    private static final String ASSIGN_BUTTON = "#assign-to-student";
    private static final String CLOSE_BUTTON = "[class='player-navigator-toggle'] [class*='close']";
    private static final String UP_ARROW_BUTTON = "[class='player-navigator-toggle'] [class*='fa-angle-up']";
    private static final String COLLECTION_ITEM = "[class^='panel-container'] li[class^='panel']";
    private static final String COLLECTION_ITEfM = "[class='player-item-list'] div[class='non-interactive-container']";

    public CollectionPlayerPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCollectionItemDisplayed() {
        return isElementDisplayed(COLLECTION_ITEM);
    }

    public boolean isNextItemButtonDisplayed() {
        return isElementDisplayed(NEXT_ITEM);
    }

    public boolean isPreviousButtonDisplayed() {
        return isElementDisplayed(PREVIOUS_ITEM);
    }
}
