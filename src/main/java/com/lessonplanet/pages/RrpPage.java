package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RrpPage extends Rrp {

    private static final String START_YOUR_FREE_TRIAL_UPGRADE_ME_BUTTON = "a[data-track-click='Upgrade Me'][data-track-label='review_page_button']";
    private static final String START_YOUR_FREE_TRIAL_TRY_IT_FREE_BUTTON = "a[data-track-click='Try It Free'][data-track-label='review_page_button']";
    private static final String BOTTOM_PAGE_UPGRADE_ME_BUTTON = "a[data-track-click='Upgrade Me'][data-track-label='side_widget_button']";
    private static final String BOTTOM_PAGE_TRY_IT_FREE_BUTTON = "a[data-track-click='Try It Free'][data-track-label='side_widget_button']";
    private static final String START_YOUR_FREE_TRIAL_WIDGET = "[class='col-md-4 col-sm-12'] [class='panel panel-default']";
    private static final String START_YOUR_FREE_TRIAL_TEXT = "[class='col-md-4 col-sm-12'] [class='panel-body'] p";
    private static final String SIMILAR_RESOURCES_HEADER = "#related-options";
    private static final String SIMILAR_RESOURCES_LIST = "#related-resources";
    private static final String ALL_RESOURCE_TYPES_DROPDOWN = "#related-dropdown";
    private static final String ALL_RESOURCE_TYPES_OPTIONS = "#related-dropdown [class='dropdown-menu']";

    private static final String LESSON_PLANS_RESOURCE_TYPE = "a[href*='id=357917']";
    private static final String SIMILAR_RESOURCE_CARD = "[class*='panel-resource'] [class='panel-body'] [class='trk-show-resource'] [class='resource-icon'] [class*='type-resource']";
    private static final String FREE_SAMPLE_RESOURCE_START_YOUR_FREE_TRIAL_WIDGET = "[class='panel panel-default']";
    private static final String FREE_SAMPLE_RESOURCE_START_YOUR_FREE_TRIAL_WIDGET_TEXT = "[class='panel panel-default'] p";
    private static final String FREE_SAMPLE_RESOURCE_START_YOUR_FREE_TRIAL_SUBSCRIPTION_BUTTON = "[class='panel panel-default'] a[data-track-click='Upgrade Me']";

    public RrpPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnStartYourFreeTrialUpgradeMeButton(boolean inANewTab) {
        openInANewTabOrClick(START_YOUR_FREE_TRIAL_UPGRADE_ME_BUTTON, inANewTab);
    }

    public void clickOnBottomPageUpgradeMeButton(boolean inANewTab) {
        openInANewTabOrClick(BOTTOM_PAGE_UPGRADE_ME_BUTTON, inANewTab);
    }

    public boolean isStartYourFreeTrialTryItFreeButtonDisplayed() {
        return isElementDisplayed(START_YOUR_FREE_TRIAL_TRY_IT_FREE_BUTTON);
    }

    public boolean isBottomPageTryItFreeButtonDisplayed() {
        return isElementDisplayed(BOTTOM_PAGE_TRY_IT_FREE_BUTTON);
    }

    public boolean isStartYourFreeTrialWidgetDisplayed() {
        return isElementDisplayed(START_YOUR_FREE_TRIAL_WIDGET);
    }

    public String getStartYourFreeTrialText() {
        return getTextForElement(START_YOUR_FREE_TRIAL_TEXT);
    }

    public boolean isSimilarResourcesHeaderDisplayed() {
        return isElementDisplayed(SIMILAR_RESOURCES_HEADER);
    }

    public boolean isSimilarResourcesListDisplayed() {
        return isElementDisplayed(SIMILAR_RESOURCES_LIST);
    }

    public boolean isAllResourceTypesDropdownDisplayed() {
        return isElementDisplayed(ALL_RESOURCE_TYPES_DROPDOWN);
    }

    public void clickOnAllResourceTypesDropdown() {
        scrollToElement(ALL_RESOURCE_TYPES_DROPDOWN);
        clickElement(ALL_RESOURCE_TYPES_DROPDOWN);
    }

    public String getAllResourceTypesFromDropdown() {
        return getTextForElement(ALL_RESOURCE_TYPES_OPTIONS);
    }

    public void clickOnStartYourFreeTrialTryItFreeButton(boolean inANewTab) {
        openInANewTabOrClick(START_YOUR_FREE_TRIAL_TRY_IT_FREE_BUTTON, inANewTab);
    }

    public void clickOnBottomPageTryItFreeButton(boolean inANewTab) {
        openInANewTabOrClick(BOTTOM_PAGE_TRY_IT_FREE_BUTTON, inANewTab);
    }

    public void clickOnLessonPlansResourceType() {
        clickElement(LESSON_PLANS_RESOURCE_TYPE);
    }

    public String getAllResourceTypesDropdownText() {
        return getTextForElement(ALL_RESOURCE_TYPES_DROPDOWN);
    }

    public String getSimilarResourceCardResourceTypeText(int index) {
        return getAfterPseudoElement(SIMILAR_RESOURCE_CARD, "after", "content", index);
    }

    public int getAllSimilarResourceCardsNumber() {
        final List<WebElement> relatedResources = findElements(SIMILAR_RESOURCE_CARD);
        return relatedResources.size();
    }

    public String getSimilarResourcesListText() {
        return getTextForElement(SIMILAR_RESOURCES_LIST);
    }

    public boolean isBottomPageUpgradeMeButtonDisplayed() {
        return isElementDisplayed(BOTTOM_PAGE_UPGRADE_ME_BUTTON);
    }

    public boolean isStartYourFreeTrialUpgradeMeButtonDisplayed() {
        return isElementDisplayed(START_YOUR_FREE_TRIAL_UPGRADE_ME_BUTTON);
    }

    public String getFreeSampleResourceStartYourFreeTrialText() {
        return getTextForElement(FREE_SAMPLE_RESOURCE_START_YOUR_FREE_TRIAL_WIDGET_TEXT);
    }

    public boolean isFreeSampleResourceStartYourFreeTrialWidgetDisplayed() {
        return isElementDisplayed(FREE_SAMPLE_RESOURCE_START_YOUR_FREE_TRIAL_WIDGET);
    }

    public boolean isFreeSampleResourceStartYourFreeTrialUpgradeMeButtonDisplayed() {
        return isElementDisplayed(FREE_SAMPLE_RESOURCE_START_YOUR_FREE_TRIAL_SUBSCRIPTION_BUTTON);
    }

    public void clickOnFreeSampleStartYourFreeTrialUpgradeMeButton(boolean inANewTab) {
        openInANewTabOrClick(FREE_SAMPLE_RESOURCE_START_YOUR_FREE_TRIAL_SUBSCRIPTION_BUTTON, inANewTab);
    }
}
