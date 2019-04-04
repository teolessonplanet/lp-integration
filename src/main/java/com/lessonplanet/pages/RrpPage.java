package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RrpPage extends Rrp {

    private static final String START_YOUR_FREE_TRIAL_UPGRADE_ME_BUTTON = "a[data-track-click='Upgrade Me'][data-track-label='review_page_button']";
    private static final String START_YOUR_FREE_TRIAL_TRY_IT_FREE_BUTTON = "a[data-track-click='Try It Free'][data-track-label='review_page_button']";
    private static final String BOTTOM_PAGE_UPGRADE_ME_BUTTON = "a[data-track-click='Upgrade Me'][data-track-label='side_widget_button']";
    private static final String BOTTOM_PAGE_TRY_IT_FREE_BUTTON = "a[data-track-click='Try It Free'][data-track-label='side_widget_button']";
    private static final String GO_TO_RESOURCE_BUTTON = "[class*='trk-goto-resource'][href^='/drive/documents/']";
    private static final String START_YOUR_FREE_TRIAL_WIDGET = "[class='col-md-4 col-sm-12'] [class='panel panel-default']";
    private static final String START_YOUR_FREE_TRIAL_TEXT = "[class='col-md-4 col-sm-12'] [class='panel-body'] p";
    private static final String SIMILAR_RESOURCES_SECTION = "#related-container";
    private static final String SIMILAR_RESOURCES_HEADER = "#related-options";
    private static final String SIMILAR_RESOURCES_LIST = "#related-resources";
    private static final String ALL_RESOURCE_TYPES_DROPDOWN = "#related-dropdown";
    private static final String ALL_RESOURCE_TYPES_OPTIONS = "[class='dropdown-menu']";

    private static final String WORKSHEETS_RESOURCE_TYPE = "a[href*='id=357918']";
    private static final String SIMILAR_RESOURCE_CARD = "[class*='panel-resource'] [class='panel-body'] [class='trk-show-resource'] [class='resource-icon'] [class*='type-resource']";

    public RrpPage(WebDriver driver) {
        super(driver);
    }

    public void clickStartYourFreeTrialUpgradeMeButton(boolean inANewTab) {
        openInANewTabOrClick(START_YOUR_FREE_TRIAL_UPGRADE_ME_BUTTON, inANewTab);
    }

    public void clickBottomPageUpgradeMeButton(boolean inANewTab){
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

    public boolean isGoToResourceButtonDisplayed() {
        return isElementClickable(GO_TO_RESOURCE_BUTTON);
    }

    public boolean isSimilarResourcesSectionDisplayed() {
        return isElementDisplayed(SIMILAR_RESOURCES_SECTION);
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

    public void clickAllResourceTypesDropdown() {
        scrollToElement(ALL_RESOURCE_TYPES_DROPDOWN);
        clickElement(ALL_RESOURCE_TYPES_DROPDOWN);
    }

    public String getAllResourceTypesFromDropdown() {
        return getTextForElement(ALL_RESOURCE_TYPES_OPTIONS);
    }

    public void clickStartYourFreeTrialTryItFreeButton(boolean inANewTab) {
        openInANewTabOrClick(START_YOUR_FREE_TRIAL_TRY_IT_FREE_BUTTON, inANewTab);
    }

    public void clickBottomPageTryItFreeButton (boolean inANewTab){
        openInANewTabOrClick(BOTTOM_PAGE_TRY_IT_FREE_BUTTON, inANewTab);
    }

    public void clickGoToResourceButton(boolean inANewTab){
        openInANewTabOrClick(GO_TO_RESOURCE_BUTTON, inANewTab);
    }

    public void clickWorksheetsResourceType(){
        clickElement(WORKSHEETS_RESOURCE_TYPE);
    }

    public String getAllResourceTypesDropdownText(){
        return getTextForElement(ALL_RESOURCE_TYPES_DROPDOWN);
    }

    public String getSimilarResourceCardResourceTypeText(int index){
        return getAfterPseudoElement(SIMILAR_RESOURCE_CARD,"after","content", index);
    }

    public int getAllSimilarResourceCardsNumber() {
        final List<WebElement> relatedResources = findElements(SIMILAR_RESOURCE_CARD);
        return relatedResources.size();
    }

    public String getSimilarResourcesListText(){
        return getTextForElement(SIMILAR_RESOURCES_LIST);
    }
}
