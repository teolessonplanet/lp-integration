package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SharedByMyDistrictPage extends CurriculumManagerPage {

    private static final String EMPTY_SHARED_BY_PAGE = "[class='no-resources-shared-message']";
    private static final String SORT_BY_TITLE_OPTION = "#sort-dropdown-collections-title";
    private static final String SORT_BY_DATE_POSTED_OPTION = "#sort-dropdown-user_shared_folders-created_at";
    private static final String SORT_BY_DISTRICT_ORDER_OPTION = "#sort-dropdown-district_sequence";
    private static final String DRILLED_IN_RESOURCE_ROW = "[class='group-table'] [class*='group-row resource']";

    public SharedByMyDistrictPage(WebDriver driver) {
        super(driver);
    }

    public String getEmptyPageText() {
        return getTextForElement(EMPTY_SHARED_BY_PAGE);
    }

    public boolean isSortByTitleOptionDisplayed() {
        return isElementDisplayed(SORT_BY_TITLE_OPTION);
    }

    public boolean isSortByDatePostedOptionDisplayed() {
        return isElementDisplayed(SORT_BY_DATE_POSTED_OPTION);
    }

    public void clickOnDatePostedOption() {
        clickElement(SORT_BY_DATE_POSTED_OPTION);
    }

    public boolean isSortByDistrictOrderOptionDisplayed() {
        return isElementDisplayed(SORT_BY_DISTRICT_ORDER_OPTION);
    }

    public WebElement getResourceDrilledIn(int i) {
        return findElements(DRILLED_IN_RESOURCE_ROW).get(i);
    }
}
