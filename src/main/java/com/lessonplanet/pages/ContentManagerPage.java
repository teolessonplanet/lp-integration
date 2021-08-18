package com.lessonplanet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

public class ContentManagerPage extends DiscoverResourcesPage {

    private static final String CONTENT_MANAGER_TAB_BUTTON = "[href$='/content-tool']";
    private static final String PAGE_TITLE_TEXT = "[class*='content-manager-header'] h2";
    private static final String PAGE_SUBTITLE_TEXT = "[class*='content-manager-header'] [class*='text-lg']";

    private static final String SEARCH_TEXT_FIELD_TEXT = "#resources-heading";
    private static final String TOTAL_RESOURCES_FOUND_TEXT = "#resources-heading strong";
    private static final String SORT_BY_OPTION_DROPDOWN = "[class*='sort'] [class='text text-blue-700']";
    private static final String SORT_DROPDOWN_AZ_OPTION = "[class*='sort'] #titleAZ";
    private static final String SORT_DROPDOWN_ZA_OPTION = "[class*='sort'] #titleZA";
    private static final String SORT_DROPDOWN_NEWEST_OPTION = "[class*='sort'] #newest";
    private static final String SORT_DROPDOWN_OLDEST_OPTION = "[class*='sort'] #oldest";

    private static final String RESOURCES_CARDS = "[class='resources'] [class*='resource']";
    private static final String RESOURCE_PROVIDER = "[class='pool-area'] [class*='pool']";
    private static final String RESOURCE_TITLE = "[class='main-panel'] [class*='resource-heading'] [href*='/']";
    private static final String RESOURCE_THUMBNAIL = "[class*='resource'] img[class*='thumbnail-img']";
    private static final String RESOURCE_TYPE = "[class='resource-content'] [class*='type-resource']";
    private static final String RESOURCE_GRADES = "[class='resource-content'] [class*='detail-grades']";
    private static final String RESOURCE_RATING = "[class='resource-content'] [class*='star-rating']";
    private static final String RESOURCE_VIEWS = "[class='resource-content'] [class='views']";
    private static final String RESOURCE_DESCRIPTION = "[class='resource-content'] [class*='description']";
    private static final String RESOURCE_CONCEPTS = "[class='resource-content'] [class*='concepts'] [class*='concept']";
    private static final String RESOURCE_STANDARDS = "[class='resource-content'] [href*='/standards/resources/']";
    private static final String RESOURCE_QUICK_VIEW_BUTTON = "[class*='action-panel-actions'] [class*='lp-button']";
    private static final String RESOURCE_HIDE_FROM_SEARCH_LINK = "[class*='action-panel-actions'] [class*='checkbox-item']";

    private static final String SEARCH_INPUT = "[class*='keywords-search-bar'] #keywords";
    private static final String SEARCH_X_BUTTON = "[class*='keywords-search-bar'] #clear-search";
    private static final String SEARCH_BUTTON = "[class*='keywords-search-bar'] #content-search-btn";
    private static final String SEARCH_ALERT_WARNING = "[class='resources'] [class*='alert-warning']";

    private static final String FACETS_SIDEBAR = "#cm-facet-sidebar";

    public ContentManagerPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.ACCOUNT_MANAGER_PAGE_PATH);
        clickElement(CONTENT_MANAGER_TAB_BUTTON);
    }

    public void clickOnContentManagerTab() {
        clickElement(CONTENT_MANAGER_TAB_BUTTON);
    }

    public String getTitleText() {
        return getTextForElement(PAGE_TITLE_TEXT);
    }

    public String getPageSubtitleText() {
        return getTextForElement(PAGE_SUBTITLE_TEXT);
    }

    public boolean isSearchTextFieldTextDisplayed() {
        return isElementDisplayed(SEARCH_TEXT_FIELD_TEXT);
    }

    public String getSearchTextFieldText() {
        return getTextForElement(SEARCH_TEXT_FIELD_TEXT);
    }

    public int getTotalResourcesFound() {
        String rawNumber = getTextForElement(TOTAL_RESOURCES_FOUND_TEXT);
        int number;
        try {
            number = NumberFormat.getNumberInstance(TestData.LOCALE).parse(rawNumber).intValue();
        } catch (ParseException e) {
            throw new Error("The number " + rawNumber + " cannot be parsed");
        }
        return number;
    }

    public String getSortByOptionDropdownText() {
        return getTextForElement(SORT_BY_OPTION_DROPDOWN);
    }

    public void clickOnSortByDropdown() {
        clickElement(SORT_BY_OPTION_DROPDOWN);
    }

    public void clickOnDropdownAzOption() {
        clickElement(SORT_DROPDOWN_AZ_OPTION);
    }

    public void clickOnDropdownZaOption() {
        clickElement(SORT_DROPDOWN_ZA_OPTION);
    }

    public void clickOnDropdownNewestOption() {
        clickElement(SORT_DROPDOWN_NEWEST_OPTION);
    }

    public void clickOnDropdownOldestOption() {
        clickElement(SORT_DROPDOWN_OLDEST_OPTION);
    }

    public boolean isResourceCardDisplayed() {
        return isElementDisplayed(RESOURCES_CARDS);
    }

    public boolean isFacetSidebarDisplayed() {
        return isElementDisplayed(FACETS_SIDEBAR);
    }

    public List<WebElement> getResourceCards() {
        return findElements(RESOURCES_CARDS);
    }

    public boolean isResourceProviderDisplayed(WebElement resourceCard) {
        return isElementDisplayed(resourceCard, RESOURCE_PROVIDER);
    }

    public boolean isResourceHideFromViewDisplayed(WebElement resourceCard) {
        return isElementDisplayed(resourceCard, RESOURCE_HIDE_FROM_SEARCH_LINK);
    }

    public boolean isResourceTitleDisplayed(WebElement resourceCard) {
        return isElementDisplayed(resourceCard, RESOURCE_TITLE);
    }

    public boolean isResourceThumbnailDisplayed(WebElement resourceCard) {
        return isElementDisplayed(resourceCard, RESOURCE_THUMBNAIL);
    }

    public boolean isResourceTypeDisplayed(WebElement resourceCard) {
        return isElementDisplayed(resourceCard, RESOURCE_TYPE);
    }

    public boolean isResourceGradesDisplayed(WebElement resourceCard) {
        return isElementDisplayed(resourceCard, RESOURCE_GRADES);
    }

    public boolean isResourceRatingDisplayed(WebElement resourceCard) {
        return isElementDisplayed(resourceCard, RESOURCE_RATING);
    }

    public boolean isResourceViewsDisplayed(WebElement resourceCard) {
        return isElementDisplayed(resourceCard, RESOURCE_VIEWS);
    }

    public boolean isResourceDescriptionDisplayed(WebElement resourceCard) {
        return isElementDisplayed(resourceCard, RESOURCE_DESCRIPTION);
    }

    public boolean isResourceConceptDisplayed(WebElement resourceCard) {
        return isElementDisplayed(resourceCard, RESOURCE_CONCEPTS);
    }

    public boolean isResourceStandardDisplayed(WebElement resourceCard) {
        return isElementDisplayed(resourceCard, RESOURCE_STANDARDS);
    }

    public void clickOnResourceTitle(WebElement resourceCard) {
        clickElement(resourceCard.findElement(By.cssSelector(RESOURCE_TITLE)));
    }

    public void clickOnConceptLink(WebElement resourceCard, int conceptPosition) {
        clickElement(findElements(resourceCard, RESOURCE_CONCEPTS), conceptPosition);
    }

    public void clickOnStandardLink(WebElement resourceCard, int standardPosition) {
        clickElement(findElements(resourceCard, RESOURCE_STANDARDS), standardPosition);
    }

    public void clickOnQuickViewButton(WebElement resourceCard) {
        clickElement(resourceCard.findElement(By.cssSelector(RESOURCE_QUICK_VIEW_BUTTON)));
    }

    public void typeSearchText(String searchText) {
        sendKeys(SEARCH_INPUT, searchText);
    }

    public String getSearchInputText() {
        return findElement(SEARCH_INPUT).getAttribute("value");
    }

    public void clickOnSearchCloseButton() {
        clickElement(SEARCH_X_BUTTON);
    }

    public void clickOnSearchButton() {
        clickElement(SEARCH_BUTTON);
    }

    public boolean isAlertWarningDisplayed() {
        return isElementDisplayed(SEARCH_ALERT_WARNING);
    }

    public String getResourceTitle(int i) {
        return findElements(RESOURCE_TITLE).get(i).getText();
    }

    public String getResourceType(int i) {
        return getAfterPseudoElement(RESOURCE_TYPE, "after", "content", i);
    }

    public String getResourceGrades(int i) {
        return getTextForElement(RESOURCE_GRADES, i);
    }
}
