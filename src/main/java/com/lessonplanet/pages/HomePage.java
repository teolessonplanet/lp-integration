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

    private static final String COLLECT_TAB = "[data-navname='collect']";
    private static final String COLLECT_TEXT = "#collect-text";
    private static final String COLLECT_CARDS = "#collect-img [class$='card-%s']";
    private static final String COLLECT_DRAG_COLUMN = "#collect-img [class*='drag-column-in-progress']";
    private static final String COLLECT_DRAG_AND_DROP_ZONE = "#collect-img [class='lpip-cb-drop']";
    private static final String COLLECT_COLLECTION_ITEMS = "#collect-img #cb-result-%d";

    private static final String DESIGN_TAB = "[data-navname='design']";
    private static final String DESIGN_TEXT = "#design-text";
    private static final String DELIVER_IMAGE = "#design-img img[src*='lessonplanet.com/packs/media/homepage/curriculum-manager-organization']";

    private static final String DELIVER_TAB = "[data-navname='deliver']";
    private static final String DELIVER_TEXT = "#deliver-text";
    private static final String DELIVER_IMAGE_0 = "#deliver-img img[src*='lessonplanet.com/packs/media/homepage/collection-player-tablet']";
    private static final String DELIVER_IMAGE_1 = "#deliver-img img[src*='lessonplanet.com/packs/media/homepage/collection-player-mobile']";

    private static final String BLUE_BUTTON = "[class$='hero-actions'] [class$='hero-button']";
    private static final String WATCH_VIDEO_BUTTON = "[class$='hero-actions'] [class$='lp-video-launch']";
    private static final String WATCH_VIDEO_IFRAME = "#lpip-hp-video";
    private static final String WATCH_VIDEO_CLOSE_BUTTON = "#lpip-hp-close-video-box-x";

    private static final String WHICH_SOLUTION_AREA = "[class='lpip-hp-solution-section lpip-hp-section']";
    private static final String WHICH_SOLUTION_TITLE = "[class*='solution-section'] [class='lpip-hp-section-title']";
    private static final String PARENT_BOX = "[class*='solution-section'] [href='/parent-edition']";
    private static final String PARENT_PICTURE = "[class*='solution-section'] [href='/parent-edition'] img[src*='lessonplanet.com/packs/media/homepage/parent-icon']";
    private static final String SELECT_SOLUTION = "[class='lpip-action-link']";
    private static final String EDUCATOR_BOX = "[class*='solution-section'] [href='/educator-edition']";
    private static final String EDUCATOR_PICTURE = "[class*='solution-section'] [href='/educator-edition'] img[src*='lessonplanet.com/packs/media/homepage/globe-icon']";
    private static final String SCHOOL_OR_DISTRICT_BOX = "[class*='solution-section'] [href='https://www.learningexplorer.com']";
    private static final String SCHOOL_OR_DISTRICT_PICTURE = "[class*='solution-section'] [href='https://www.learningexplorer.com'] img[src*='lessonplanet.com/packs/media/homepage/school-icon']";

    private static final String EXPLORE_OUR_SOLUTION_AREA = "[class='lpip-hp-section']:nth-child(3)";
    private static final String EXPLORE_OUR_SOLUTIONS_TITLE = "[class='lpip-hp-section']:nth-child(3) [class='lpip-hp-section-title']";
    private static final String EXPLORE_OUR_SOLUTIONS_TEXT = "[class='lpip-hp-section']:nth-child(3) [class='lpip-hp-section-subtext']";
    private static final String EXPLORE_OUR_SOLUTIONS_LINK = "[class='lpip-hp-section']:nth-child(3) [href='/us/contact']";

    private static final String EDUCATOR_EDITION_AREA = "[class$='lpip-learning-explorer-section']";
    private static final String EDUCATOR_EDITION_IPAD_IMAGE = "[class='lpip-hp-section']:nth-child(3) img[src*='lessonplanet.com/packs/media/homepage/resource-review-tablet']";
    private static final String EDUCATOR_EDITION_ICON = "[class='lpip-hp-section']:nth-child(3) i[class$='fa-globe']";
    private static final String EDUCATOR_EDITION_TITLE_TEXT = "[class='lpip-hp-section']:nth-child(3) [class='lpip-hp-large-title']";
    private static final String EDUCATOR_EDITION_TEXT = "[class='lpip-hp-section']:nth-child(3) [class='text']";
    private static final String EDUCATOR_EDITION_GIVE_A_TRY_BUTTON = "[class='lpip-hp-section']:nth-child(3) [href='/search']";
    private static final String EDUCATOR_EDITION_LEARN_MORE_BUTTON = "[class='lpip-hp-section']:nth-child(3) [href='/educator-edition']";

    private static final String LEARNING_EXPLORER_AREA = "[class$='lpip-learning-explorer-section']";
    private static final String LEARNING_EXPLORER_LAPTOP_IMAGE = "[class$='lpip-learning-explorer-section'] [src*='lessonplanet.com/packs/media/homepage/learning-explorer-search-and-filter']";
    private static final String LEARNING_EXPLORER_ICON = "[class$='lpip-learning-explorer-section'] img[src*='lessonplanet.com/packs/media/homepage/le-icon']";
    private static final String LEARNING_EXPLORER_TITLE_TEXT = "[class$='lpip-learning-explorer-section'] div[class$='large-title']";
    private static final String LEARNING_EXPLORER_TEXT = "[class$='lpip-learning-explorer-section'] div[class='text']";
    private static final String LEARNING_EXPLORER_LEARN_MORE_BUTTON = "[class$='lpip-learning-explorer-section'] [href='https://www.learningexplorer.com']";

    private static final String PD_LEARNING_AREA = "[class='lpip-hp-section']:nth-child(5)";
    private static final String PD_LEARNING_IPHONE_IMAGE = "[class='lpip-hp-section']:nth-child(5) [src*='lessonplanet.com/packs/media/homepage/pdln-course-mobile']";
    private static final String PD_LEARNING_FLIPPED_CLASSROOM_IMAGE = "[class='lpip-hp-section']:nth-child(5) [src*='lessonplanet.com/packs/media/homepage/pdln-flipped-classroom-badge']";
    private static final String PD_LEARNING_CITIZENSHIP_IMAGE = "[class='lpip-hp-section']:nth-child(5) [src*='lessonplanet.com/packs/media/homepage/pdln-digital-citizenship-badge']";
    private static final String PD_LEARNING_GOOGLE_CLASSROOM_IMAGE = "[class='lpip-hp-section']:nth-child(5) [src*='lessonplanet.com/packs/media/homepage/pdln-google-classroom-badge']";
    private static final String PD_LEARNING_CHROMEBOOK_IMAGE = "[class='lpip-hp-section']:nth-child(5) [src*='lessonplanet.com/packs/media/homepage/pdln-chromebook-essentials-badge']";
    private static final String PD_LEARNING_ICON = "[class='lpip-hp-section']:nth-child(5) [src*='lessonplanet.com/packs/media/homepage/pdln-icon']";
    private static final String PD_LEARNING_TITLE_TEXT = "[class='lpip-hp-section']:nth-child(5) [class='lpip-hp-large-title']";
    private static final String PD_LEARNING_TEXT = "[class='lpip-hp-section']:nth-child(5) [class='text']";
    private static final String PD_LEARNING_LEARN_MORE_BUTTON = "[class='lpip-hp-section']:nth-child(5) [href='/pdln']";

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

    public void clickOnDiscoverTab() {
        clickElement(DISCOVER_TAB);
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

    public void clickOnCollectTab() {
        clickElement(COLLECT_TAB);
    }

    public String getCollectTabText() {
        return getTextForElement(COLLECT_TAB);
    }

    public String getCollectText() {
        return getTextForElement(COLLECT_TEXT);
    }

    public String getCollectCardText(int cardPosition) {
        return getTextForElement(String.format(COLLECT_CARDS, cardPosition));
    }

    public WebElement getCollectCardElement(int cardPosition) {
        return findElement(String.format(COLLECT_CARDS, cardPosition));
    }

    public String getCollectCollectionBuilderText() {
        return getTextForElement(COLLECT_DRAG_COLUMN);
    }

    public WebElement getCollectCollectionDropZone() {
        return findElement(COLLECT_DRAG_AND_DROP_ZONE);
    }

    public WebElement getCollectItemFromCollection(int itemPosition) {
        return findElement(String.format(COLLECT_COLLECTION_ITEMS, itemPosition));
    }

    public void clickOnDesignTab() {
        clickElement(DESIGN_TAB);
    }

    public String getDesignTabText() {
        return getTextForElement(DESIGN_TAB);
    }

    public String getDesignText() {
        return getTextForElement(DESIGN_TEXT);
    }

    public boolean isDesignImageDisplayed() {
        return isElementDisplayed(DELIVER_IMAGE);
    }

    public void clickOnDeliverTab() {
        clickElement(DELIVER_TAB);
    }

    public void clickOnTab(String tabToClick) {
        switch (tabToClick) {
            case TestData.HOMEPAGE_DISCOVER_TAB_TEXT:
                clickOnDiscoverTab();
                break;
            case (TestData.HOMEPAGE_COLLECT_TAB_TEXT):
                clickOnCollectTab();
                break;
            case TestData.HOMEPAGE_DESIGN_TAB_TEXT:
                clickOnDesignTab();
                break;
            case TestData.HOMEPAGE_DELIVER_TAB_TEXT:
                clickOnDeliverTab();
                break;
        }
    }

    public String getDeliverTabText() {
        return getTextForElement(DELIVER_TAB);
    }

    public String getDeliverText() {
        return getTextForElement(DELIVER_TEXT);
    }

    public boolean areDeliverImagesDisplayed() {
        return isElementDisplayed(DELIVER_IMAGE_0) && isElementDisplayed(DELIVER_IMAGE_1);
    }

    public String getWhichSolutionTitleText() {
        return getTextForElement(WHICH_SOLUTION_TITLE);
    }

    public void scrollToParentSolutionSection() {
        scrollToElement(PARENT_BOX);
    }

    public String getParentBoxText() {
        return getTextForElement(PARENT_BOX);
    }

    public boolean isParentPictureDisplayed() {
        return isElementDisplayed(PARENT_PICTURE);
    }

    public void clickOnSelectSolutionForParent() {
        clickElement(PARENT_BOX, SELECT_SOLUTION, 0);
    }

    public String getEducatorBoxText() {
        return getTextForElement(EDUCATOR_BOX);
    }

    public boolean isEducatorPictureDisplayed() {
        return isElementDisplayed(EDUCATOR_PICTURE);
    }

    public void clickOnSelectSolutionForEducator() {
        clickElement(EDUCATOR_BOX, SELECT_SOLUTION, 0);
    }

    public String getSchoolOrDistrictBoxText() {
        return getTextForElement(SCHOOL_OR_DISTRICT_BOX);
    }

    public boolean isSchoolOrDistrictPictureDisplayed() {
        return isElementDisplayed(SCHOOL_OR_DISTRICT_PICTURE);
    }

    public void clickOnSelectSolutionForSchoolOrDistrict() {
        clickElement(SCHOOL_OR_DISTRICT_BOX, SELECT_SOLUTION, 0);
    }

    public boolean isExplorerOurSolutionAreaDisplayed() {
        return isElementDisplayed(EXPLORE_OUR_SOLUTION_AREA);
    }

    public void scrollToExploreOurSolutionArea() {
        scrollToElement(EXPLORE_OUR_SOLUTION_AREA);
    }

    public String getExploreOurSolutionsTitleText() {
        return getTextForElement(EXPLORE_OUR_SOLUTIONS_TITLE);
    }

    public String getExploreOurSolutionsText() {
        return getTextForElement(EXPLORE_OUR_SOLUTIONS_TEXT);
    }

    public void clickOnContactUsAnytime() {
        clickElement(EXPLORE_OUR_SOLUTIONS_LINK);
    }

    public boolean isEducatorEditionAreaDisplayed() {
        return isElementVisible(EDUCATOR_EDITION_AREA);
    }

    public void scrollToEducatorEditionArea() {
        scrollToElement(EDUCATOR_EDITION_AREA);
    }

    public boolean areEducatorEditionImagesDisplayed() {
        return isElementVisible(EDUCATOR_EDITION_IPAD_IMAGE) && isElementVisible(EDUCATOR_EDITION_ICON);
    }

    public String getEducatorEditionTitleText() {
        return getTextForElement(EDUCATOR_EDITION_TITLE_TEXT);
    }

    public String getEducatorEditionText() {
        return getTextForElement(EDUCATOR_EDITION_TEXT);
    }

    public void clickOnEducatorEditionGiveATryButton() {
        clickElement(EDUCATOR_EDITION_GIVE_A_TRY_BUTTON);
    }

    public String getEducatorEditionGiveATryButtonText() {
        return getTextForElement(EDUCATOR_EDITION_GIVE_A_TRY_BUTTON);
    }

    public void clickOnEducatorEditionLearnMoreButton() {
        clickElement(EDUCATOR_EDITION_LEARN_MORE_BUTTON);
    }

    public String getEducatorEditionLearnMoreButtonText() {
        return getTextForElement(EDUCATOR_EDITION_LEARN_MORE_BUTTON);
    }

    public void scrollToLearningExplorerArea() {
        scrollToElement(LEARNING_EXPLORER_AREA);
    }

    public boolean areLearningExplorerImagesDisplayed() {
        return isElementVisible(LEARNING_EXPLORER_LAPTOP_IMAGE) && isElementVisible(LEARNING_EXPLORER_ICON);
    }

    public String getLearningExplorerTitleText() {
        return getTextForElement(LEARNING_EXPLORER_TITLE_TEXT);
    }

    public String getLearningExplorerText() {
        return getTextForElement(LEARNING_EXPLORER_TEXT);
    }

    public String getLearningExplorerLearnMoreButtonText() {
        return getTextForElement(LEARNING_EXPLORER_LEARN_MORE_BUTTON);
    }

    public void clickOnLearningExplorerLearnMoreButton() {
        clickElement(LEARNING_EXPLORER_LEARN_MORE_BUTTON);
    }

    public void scrollToPdLearningArea() {
        scrollToElement(PD_LEARNING_AREA);
    }

    public boolean arePdLearningImagesDisplayed() {
        return isElementVisible(PD_LEARNING_IPHONE_IMAGE) && isElementVisible(PD_LEARNING_FLIPPED_CLASSROOM_IMAGE) && isElementVisible(PD_LEARNING_CITIZENSHIP_IMAGE) && isElementVisible(PD_LEARNING_GOOGLE_CLASSROOM_IMAGE) && isElementVisible(PD_LEARNING_CHROMEBOOK_IMAGE) && isElementVisible(PD_LEARNING_ICON);
    }

    public String getPdLearningTitleText() {
        return getTextForElement(PD_LEARNING_TITLE_TEXT);
    }

    public String getPdLearningText() {
        return getTextForElement(PD_LEARNING_TEXT);
    }

    public String getPdLearningLearnMoreButtonText() {
        return getTextForElement(PD_LEARNING_LEARN_MORE_BUTTON);
    }

    public void clickOnPdLearningLearnMoreButton() {
        clickElement(PD_LEARNING_LEARN_MORE_BUTTON);
    }
}
