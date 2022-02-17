package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

import java.util.List;

public class HomePage extends LpUiBasePage {

    private static final String DISCOVER_AREA = "[class='lpip-hp-hero-section lpip-hp-section']";

    private static final String DISCOVER_TAB = "[data-navname='discover']";
    private static final String DISCOVER_TITLE = "#discover-title";
    private static final String DISCOVER_DESCRIPTION_TEXT = "#discover-text";
    private static final String DISCOVER_CARDS = "#discover-img [class='lpip-resource-card-group'] a";
    private static final String DISCOVER_CARD_IMAGE = "img[src*='media/homepage/']";
    private static final String DISCOVER_CARD_RATING = "img[src*='media/homepage/']";
    private static final String DISCOVER_CARD_TITLE = "#discover-img [class='lpip-resource-card-group'] a [class='resource-info'] [class='resource-title']";

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
    private static final String EXPLORE_OUR_SOLUTIONS_LINK = "[class='lpip-hp-section']:nth-child(3) [href='/contact-us']";

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

    private static final String TESTIMONIALS_AREA = "[class$='lpip-testimonial-section']";
    private static final String TESTIMONIALS_PREVIOUS_BUTTON = "[class$='lpip-testimonial-section'] #prev";
    private static final String TESTIMONIALS_NEXT_BUTTON = "[class$='lpip-testimonial-section'] #next";
    private static final String TESTIMONIALS_BOXES = "[class$='lpip-testimonial-section'] #carousel [class^='lpip-testimonial-member']";

    private static final String TESTIMONIAL_RATING = "[class='lpip-testimonial-rating']";
    private static final String TESTIMONIAL_TEXT = "[class='text']";
    private static final String TESTIMONIAL_IMAGE = "[class='image-wrap']";
    private static final String TESTIMONIAL_NAME = "[class='name']";
    private static final String TESTIMONIAL_ROLE = "[class='role']";

    private static final String INSPIRE_AREA = "[class$='lpip-hp-inspire-section']";
    private static final String INSPIRE_TITLE_TEXT = "[class$='lpip-hp-inspire-section'] [class='lpip-hp-section-title']";
    private static final String INSPIRE_SUBTEXT_TEXT = "[class$='lpip-hp-inspire-section'] [class='lpip-hp-section-subtext']";
    private static final String INSPIRE_PARENT_TAB = "[class$='lpip-hp-inspire-section'] [class^='lpip-hp-inspire-section-option parent']";
    private static final String INSPIRE_PARENT_TAB_START_YOUR_BUTTON = "[class$='lpip-hp-inspire-section'] [class^='lpip-hp-section-actions parent active'] [class='lpip-button']";
    private static final String INSPIRE_PARENT_TAB_SEE_PRICING_BUTTON = "[class$='lpip-hp-inspire-section'] [class^='lpip-hp-section-actions parent active'] [class='lpip-action-link']";
    private static final String INSPIRE_PARENT_UPGRADE_YOUR_ACCOUNT_BUTTON = "[class$='lpip-hp-inspire-section'] [class^='lpip-hp-section-actions parent active'] [href='/subscription/new']";
    private static final String INSPIRE_EDUCATOR_TAB = "[class$='lpip-hp-inspire-section'] [class^='lpip-hp-inspire-section-option educator']";
    private static final String INSPIRE_EDUCATOR_TAB_START_YOUR_10_DAYS_BUTTON = "[class$='lpip-hp-inspire-section'] [class='lpip-hp-section-actions educator active'] [class='lpip-button']";
    private static final String INSPIRE_EDUCATOR_TAB_PRICING_BUTTON = "[class$='lpip-hp-inspire-section'] [class='lpip-hp-section-actions educator active'] [class='lpip-action-link']";
    private static final String INSPIRE_EDUCATOR_UPGRADE_YOUR_ACCOUNT_BUTTON = "[class$='lpip-hp-inspire-section'] [class='lpip-hp-section-actions educator active'] [href='/subscription/new']";
    private static final String INSPIRE_SCHOOL_OR_DISTRICT_TAB = "[class$='lpip-hp-inspire-section'] [class^='lpip-hp-inspire-section-option admin']";
    private static final String INSPIRE_SCHOOL_OR_DISTRICT_REQUEST_A_DEMO_BUTTON = "[class$='lpip-hp-inspire-section'] [class='lpip-hp-section-actions admin active'] [class='lpip-button'][href^='https://www.learningexplorer.com']";

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
        return findElements(String.format(DISCOVER_CARDS)).get(cardPosition);
    }

    public String getCardTextFromDiscoverArea(int index) {
        final List<WebElement> cards = findElements(DISCOVER_CARDS);
        return cards.get(index).getText();
    }

    public void clickOnCardFromDiscoverArea(int index) {
        List<WebElement> cards1 = findElements(DISCOVER_CARD_TITLE);
        cards1.get(index).click();
    }

    public boolean isCardImageDisplayed(int cardPosition) {
        return findElements(getCardFromDiscoverArea(cardPosition), DISCOVER_CARD_IMAGE).size() == 1;
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

    public void scrollToTestimonialsArea() {
        scrollToElement(TESTIMONIALS_AREA);
    }

    public void clickOnTestimonialsPreviousButton() {
        clickElement(TESTIMONIALS_PREVIOUS_BUTTON);
    }

    public void clickOnTestimonialsNextButton() {
        clickElement(TESTIMONIALS_NEXT_BUTTON);
    }

    public WebElement getTestimonialBox(int testimonialPosition) {
        return findElements(TESTIMONIALS_BOXES).get(testimonialPosition);
    }

    public boolean isTestimonialRatingDisplayed(WebElement testimonialBox) {
        return isElementDisplayed(testimonialBox, TESTIMONIAL_RATING);
    }

    public String getTestimonialText(WebElement testimonialBox) {
        return getTextForElement(testimonialBox, TESTIMONIAL_TEXT);
    }

    public boolean isTestimonialImageDisplayed(WebElement testimonialBox) {
        return isElementDisplayed(testimonialBox, TESTIMONIAL_IMAGE);
    }

    public String getTestimonialNameText(WebElement testimonialBox) {
        return getTextForElement(testimonialBox, TESTIMONIAL_NAME);
    }

    public String getTestimonialRoleText(WebElement testimonialBox) {
        return getTextForElement(testimonialBox, TESTIMONIAL_ROLE);
    }

    public void scrollToInspireArea() {
        scrollToElement(INSPIRE_AREA);
    }

    public String getInspireTitleText() {
        return getTextForElement(INSPIRE_TITLE_TEXT);
    }

    public String getInspireSubtextText() {
        return getTextForElement(INSPIRE_SUBTEXT_TEXT);
    }

    public String getInspireParentTabText() {
        return getTextForElement(INSPIRE_PARENT_TAB);
    }

    public void clickOnInspireParentTab() {
        clickElement(INSPIRE_PARENT_TAB);
    }

    public String getParentTabStartYouTenDaysButtonText() {
        return getTextForElement(INSPIRE_PARENT_TAB_START_YOUR_BUTTON);
    }

    public void clickOnParentTabStartYouTenDaysButton() {
        clickElement(INSPIRE_PARENT_TAB_START_YOUR_BUTTON);
    }

    public String getParentTabSeePricingButtonText() {
        return getTextForElement(INSPIRE_PARENT_TAB_SEE_PRICING_BUTTON);
    }

    public void clickOnParentTabSeePricingButton() {
        clickElement(INSPIRE_PARENT_TAB_SEE_PRICING_BUTTON);
    }

    public String getParentTabUpgradeYourAccountButtonText() {
        return getTextForElement(INSPIRE_PARENT_UPGRADE_YOUR_ACCOUNT_BUTTON);
    }

    public void clickOnParentTabUpgradeYourAccountButton() {
        clickElement(INSPIRE_PARENT_UPGRADE_YOUR_ACCOUNT_BUTTON);
    }

    public String getInspireEducatorTabText() {
        return getTextForElement(INSPIRE_EDUCATOR_TAB);
    }

    public String getEducatorTabStartYouTenDaysButtonText() {
        return getTextForElement(INSPIRE_EDUCATOR_TAB_START_YOUR_10_DAYS_BUTTON);
    }

    public void clickOnEducatorTabStartYouTenDaysButton() {
        clickElement(INSPIRE_EDUCATOR_TAB_START_YOUR_10_DAYS_BUTTON);
    }

    public String getEducatorTabSeePricingButtonText() {
        return getTextForElement(INSPIRE_EDUCATOR_TAB_PRICING_BUTTON);
    }

    public void clickOnEducatorTabSeePricingButton() {
        clickElement(INSPIRE_EDUCATOR_TAB_PRICING_BUTTON);
    }

    public String getEducatorTabUpgradeYourAccountButtonText() {
        return getTextForElement(INSPIRE_EDUCATOR_UPGRADE_YOUR_ACCOUNT_BUTTON);
    }

    public void clickOnEducatorTabUpgradeYourAccountButton() {
        clickElement(INSPIRE_EDUCATOR_UPGRADE_YOUR_ACCOUNT_BUTTON);
    }

    public void clickOnInspireSchoolOrDistrictTab() {
        clickElement(INSPIRE_SCHOOL_OR_DISTRICT_TAB);
    }

    public String getInspireSchoolOrDistrictTabText() {
        return getTextForElement(INSPIRE_SCHOOL_OR_DISTRICT_TAB);
    }

    public void clickOnInspireSchoolOrDistrictRequestADemoButton() {
        clickElement(INSPIRE_SCHOOL_OR_DISTRICT_REQUEST_A_DEMO_BUTTON);
    }

    public String getInspireSchoolOrDistrictRequestADemoButtonText() {
        return getTextForElement(INSPIRE_SCHOOL_OR_DISTRICT_REQUEST_A_DEMO_BUTTON);
    }
}
