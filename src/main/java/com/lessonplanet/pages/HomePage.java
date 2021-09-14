package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

public class HomePage extends LpUiBasePage {

    private static final String DISCOVER_AREA = "[class='lpip-hp-hero-section lpip-hp-section']";

    private static final String DISCOVER_TAB = "[data-navname='discover']";
    private static final String DISCOVER_TITLE = "#discover-title";
    private static final String DISCOVER_DESCRIPTION_TEXT = "#discover-text";
    private static final String DISCOVER_CARDS = "#discover-img [class='lpip-box card-%d']";

    private static final String DISCOVER_CARD_IMAGE = "img[src*='media/homepage/']";
    private static final String DISCOVER_CARD_RATING = "img[src*='media/homepage/']";

    private static final String BLUE_BUTTON = "[class$='hero-actions'] [class$='hero-button']";
    private static final String WATCH_VIDEO_BUTTON = "[class$='hero-actions'] [class$='lp-video-launch']";
    private static final String WATCH_VIDEO_IFRAME = "#lpip-hp-video";
    private static final String WATCH_VIDEO_CLOSE_BUTTON = "#lpip-hp-close-video-box-x";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.LP_HOME_PAGE_PATH);
    }

    public boolean isDiscoverAreaDisplayed() {
        return isElementDisplayed(DISCOVER_AREA);
    }

    public String getDiscoverTitle() {
        return getTextForElement(DISCOVER_TITLE);
    }

    public String getDiscoverTabText() {
        return getTextForElement(DISCOVER_TAB);
    }

    public String getDiscoverDescriptionText() {
        return getTextForElement(DISCOVER_DESCRIPTION_TEXT);
    }

    public WebElement getCardFromDiscoverArea(int cardPosition) {
        return findElement(String.format(DISCOVER_CARDS, cardPosition));
    }

    public String getCardTextFromDiscoverArea(int cardPosition) {
        return getTextForElement(getCardFromDiscoverArea(cardPosition));
    }

    public boolean isCardImageDisplayed(int cardPosition) {
        return findElements(getCardFromDiscoverArea(cardPosition), DISCOVER_CARD_IMAGE).size() == 1;
    }

    public void clickOnCardFromDiscoverArea(int cardPosition) {
        clickElement(getCardFromDiscoverArea(cardPosition));
    }

    public boolean isCardRatingDisplayed(int cardPosition) {
        return findElements(getCardFromDiscoverArea(cardPosition), DISCOVER_CARD_RATING).size() == 1;
    }

    public String getHeroButtonText() {
        return getAfterPseudoElement(BLUE_BUTTON, "before", "content", 0);
    }

    public void clickOnBlueButton() {
        clickElement(BLUE_BUTTON);
    }

    public String getWatchVideoButtonText() {
        return getTextForElement(WATCH_VIDEO_BUTTON);
    }

    public void clickOnWatchVideoButton() {
        clickElement(WATCH_VIDEO_BUTTON);
    }

    public void clickOnCloseVideoButton() {
        clickElement(WATCH_VIDEO_CLOSE_BUTTON);
    }

    public void clickOnStartVideo() {
        clickElement(WATCH_VIDEO_IFRAME);
    }

    public String getVideoSourceText() {
        return getElementAttribute(WATCH_VIDEO_IFRAME, "src");
    }
}