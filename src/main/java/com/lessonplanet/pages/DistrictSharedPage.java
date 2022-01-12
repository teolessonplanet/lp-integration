package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DistrictSharedPage extends SharedByMyDistrictPage {

    private static final String EMPTY_DISTRICT_SHARED_PAGE = "[class='group-row empty-folder-row'] [class='empty-folder-text']";
    private static final String POST_FOLDER_BUTTON = "[class='options actions'] [class*='action-item post']";
    private static final String UN_POST_FOLDER_BUTTON = "[class='options actions'] [class*='action-item unpost']";
    private static final String SORT_BY_TITLE_OPTION = "#sort-dropdown-title";

    public DistrictSharedPage(WebDriver driver) {
        super(driver);
    }

    public String getEmptyPageText() {
        return getTextForElement(EMPTY_DISTRICT_SHARED_PAGE);
    }

    public boolean isPostFolderButtonDisplayed(WebElement folder) {
        if (folder == null) {
            return isElementDisplayed(POST_FOLDER_BUTTON);
        }
        return isElementDisplayed(folder, POST_FOLDER_BUTTON);
    }

    public boolean isUnPostFolderButtonDisplayed(WebElement folder) {
        if (folder == null) {
            return isElementDisplayed(UN_POST_FOLDER_BUTTON);
        }
        return isElementDisplayed(folder, UN_POST_FOLDER_BUTTON);
    }

    public void clickOnPostFolderButton() {
        clickElement(POST_FOLDER_BUTTON);
    }

    public void clickOnUnPostFolderButton() {
        clickElement(UN_POST_FOLDER_BUTTON);
    }

    public boolean isSortByTitleOptionDisplayed() {
        return isElementDisplayed(SORT_BY_TITLE_OPTION);
    }
}
