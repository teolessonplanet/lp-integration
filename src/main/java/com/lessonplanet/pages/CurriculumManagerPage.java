package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

import java.util.List;

public class CurriculumManagerPage extends LpUiBasePage {
    private static final String ALERT_NOTIFICATION = "[class*='alert']";
    private static final String REFRESH_ICON = "[class*='fa-refresh']";
    private static final String ACTIONS_DROPDOWN = " .info.actions.persistent [class='action-dropdown']";
    private static final String MY_UPLOADS_FOLDER_ACTIONS_DROPDOWN = "#folder-2 [class*='actions'] i";
    private static final String PLAY_RESOURCE_BUTTON = "[class*='fa-play-circle-o']";
    private static final String PLAY_FOLDER_BUTTON = "div.options.actions button:nth-child(2)";
    private static final String PUBLISH_BUTTON = "[class='fa fa-book']";
    private static final String POPOVER_TEXT = "[class*='popuptext show']";
    private static final String DELETE_BUTTON = "[class*='fa-trash']";
    private static final String CLONE_BUTTON = "[class='fa fa-clone']";
    private static final String ASSIGN_BUTTON = "[class*='fa-paper-plane']";
    private static final String EDIT_BUTTON = "[class*='fa-edit']";
    private static final String GO_TO_RESOURCE_BUTTON = "[class*='fa-external-link']";
    private static final String MY_FAVORITES_FOLDER_ROW = "#folder-1";
    private static final String MY_UPLOADS_FOLDER_ROW = "#folder-2";
    private static final String FOLDER_ROW = "div.collection.group-row";
    private static final String RESOURCE_ROW = " div.resource.group-row";
    private static final String FAVORITE_RESOURCE_ROW = "#folder-1 div.resource.group-row";
    private static final String UPLOAD_RESOURCE_ROW = "#folder-2 div.resource.group-row";
    private static final String FOLDER_STATUS = " .info.status";
    private static final String RESOURCE_STATUS = " div.info.status";
    private static final String ITEM_NUMBER = " .number-of-items";
    private static final String RESOURCE_TITLE = " .resource-title-text:nth-child(1)";
    private static final String FOLDER_TITLE = " .resource-title-text";
    private static final String CREATE_A_FOLDER_BUTTON = "[class*='cm-create-collection-btn']";
    private static final String UPLOAD_RESOURCE_BUTTON = "[class*='cm-upload-resource-btn']";
    private static final String SHOW_AND_HIDE_DETAILS_BUTTON = "[class*='cm-show-details-btn']";
    private static final String STATUS_COLUMN = "[class='info status']";
    private static final String DATE_COLUMN = "[class='info date']";
    private static final String SORT_BY_DROPDOWN = "#sort-widget";
    private static final String STATUS_SORT_BY_OPTION = "#sort-dropdown-license_enum";
    private static final String DATE_SORT_BY_OPTION = "#sort-dropdown-updated_at";
    private static final String RESOURCE_TITLE_SORT_BY_OPTION = "#sort-dropdown-title";
    private static final String MOVE_TO_OPTION = "div.options.actions button:nth-child(6)";
    private static final String FOLDER_TYPE = " .info.type.persistent";
    private static final String ACTIONS_DROPDOWN_OPTIONS = "[class='action-dropdown'] [class='options actions']";
    private static final String CURRICULUM_MANAGER_PAGE_TITLE = "#new_curriculum_manager h1";

    public CurriculumManagerPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.CURRICULUM_MANAGER_PAGE_PATH);
    }

    public String getNotificationText() {
        return getTextForElement(ALERT_NOTIFICATION);
    }

    public void waitForNotificationToDisappear() {
        waitUntilElementIsHidden(ALERT_NOTIFICATION);
    }

    public void waitForRefreshIconToDisappear() {
        waitUntilElementIsHidden(REFRESH_ICON);
    }

    public boolean isMyUploadsFolderActionsDropdownDisplayed() {
        return isElementVisible(MY_UPLOADS_FOLDER_ACTIONS_DROPDOWN);
    }

    public void clickOnActionsDropdown() {
        clickElement(ACTIONS_DROPDOWN);
    }

    public void hoverOverPlayFolderButton() {
        hoverOverElement(PLAY_FOLDER_BUTTON);
    }

    public void clickOnPlayFolderButton() {
        clickElement(PLAY_FOLDER_BUTTON);
    }

    public void clickOnPlayFavoriteButton() {
        clickElement(PLAY_RESOURCE_BUTTON);
    }

    public void hoverOverPublishButton() {
        hoverOverElement(PUBLISH_BUTTON, false);
    }

    public void clickOnPublishButton() {
        clickElement(PUBLISH_BUTTON);
    }

    public String getPopoverText() {
        return getTextForElement(POPOVER_TEXT);
    }

    public void clickOnDeleteButton() {
        clickElement(DELETE_BUTTON);
    }

    public void clickOnCopyToButton() {
        clickElement(CLONE_BUTTON);
    }

    public void clickOnAssignButton() {
        clickElement(ASSIGN_BUTTON);
    }

    public void clickOnEditButton() {
        clickElement(EDIT_BUTTON);
    }

    public void clickOnGoToResourceButton() {
        clickElement(GO_TO_RESOURCE_BUTTON);
    }

    public void clickOnMyUploadsFolder() {
        clickElement(MY_UPLOADS_FOLDER_ROW + FOLDER_TITLE);
    }

    public boolean isUploadResourceDisplayed() {
        String id = getElementId(UPLOAD_RESOURCE_ROW);
        if (id != null) {
            return isElementDisplayed('#' + id);
        } else {
            return false;
        }
    }

    public String getUploadResourceTitle() {
        return getTextForElement('#' + getElementId(UPLOAD_RESOURCE_ROW) + RESOURCE_TITLE);
    }

    public String getUploadResourceStatus() {
        return getTextForElement('#' + getElementId(UPLOAD_RESOURCE_ROW) + RESOURCE_STATUS);
    }

    public String getMyUploadsFolderItemNumber() {
        return getTextForElement(MY_UPLOADS_FOLDER_ROW + ITEM_NUMBER);
    }

    public String getMyUploadsFolderStatus() {
        return getTextForElement(MY_UPLOADS_FOLDER_ROW + RESOURCE_STATUS);
    }

    public void clickOnMyFavoritesFolder() {
        clickElement(MY_FAVORITES_FOLDER_ROW + FOLDER_TITLE);
    }

    public boolean isFavoriteResourceDisplayed() {
        String id = getElementId(FAVORITE_RESOURCE_ROW);
        if (id != null) {
            return isElementDisplayed('#' + id);
        } else {
            return false;
        }
    }

    public String getFavoriteResourceStatus() {
        return getTextForElement('#' + getElementId(FAVORITE_RESOURCE_ROW) + RESOURCE_STATUS);
    }

    public String getMyFavoritesFolderStatus() {
        return getTextForElement(MY_FAVORITES_FOLDER_ROW + RESOURCE_STATUS);
    }

    public void clickOnAFolder() {
        findElement('#' + getElementId(FOLDER_ROW) + RESOURCE_TITLE).click();
    }

    public boolean isResourceInFolderDisplayed() {
        return isElementDisplayed('#' + getElementId(RESOURCE_ROW) + RESOURCE_TITLE);
    }

    public String getFolderTitle() {
        return getTextForElement('#' + getElementId(FOLDER_ROW) + RESOURCE_TITLE);
    }

    public String getFolderType() {
        return getTextForElement('#' + getElementId(FOLDER_ROW) + FOLDER_TYPE);
    }

    public String getFolderItemNumber() {
        return getTextForElement('#' + getElementId(FOLDER_ROW) + ITEM_NUMBER);
    }

    public void clickOnCreateAFolderButton() {
        waitForNotificationToDisappear();
        clickElement(CREATE_A_FOLDER_BUTTON);
        waitForLoad();
    }

    public void clickOnUploadResourceButton() {
        clickElement(UPLOAD_RESOURCE_BUTTON);
    }

    public void clickOnShowAndHideDetailsButton() {
        clickElement(SHOW_AND_HIDE_DETAILS_BUTTON);
    }

    public boolean isStatusColumnDisplayed() {
        return isElementVisible(STATUS_COLUMN);
    }

    public boolean isDateColumnDisplayed() {
        return isElementVisible(DATE_COLUMN);
    }

    public void clickOnSortByDropdown() {
        clickElement(SORT_BY_DROPDOWN);
    }

    public boolean isStatusOptionDisplayed() {
        return isElementDisplayed(STATUS_SORT_BY_OPTION);
    }

    public boolean isResourceTitleOptionDisplayed() {
        return isElementDisplayed(RESOURCE_TITLE_SORT_BY_OPTION);
    }

    public boolean isDateOptionDisplayed() {
        return isElementDisplayed(DATE_SORT_BY_OPTION);
    }

    public boolean isPublishButtonDisplayed() {
        return isElementDisplayed(PUBLISH_BUTTON);
    }

    public void clickOnMoveToOption() {
        clickElement(MOVE_TO_OPTION);
    }

    public void hoverOverPlayButton() {
        hoverOverElement(PLAY_FOLDER_BUTTON);
    }

    public void hoverOverActionsDropdown() {
        hoverOverElement(ACTIONS_DROPDOWN);
    }

    public String getFolderStatus() {
        return getTextForElement('#' + getElementId(FOLDER_ROW) + FOLDER_STATUS);
    }

    public int getFoldersNumber() {
        final List<WebElement> foldersNumber = findElements(FOLDER_ROW);
        return foldersNumber.size();
    }

    public void hoverOverAssignButton() {
        hoverOverElement(ASSIGN_BUTTON, false);
    }

    public boolean isActionsDropdownOptionsDisplayed() {
        return isElementDisplayed(ACTIONS_DROPDOWN_OPTIONS);
    }

    public String getTitle() {
        return getTextForElement(CURRICULUM_MANAGER_PAGE_TITLE);
    }

    public void waitUntilPublishedStatusIsDisplayed() {
        waitUntilTextIsDisplayed('#' + getElementId(FOLDER_ROW) + FOLDER_STATUS, TestData.PUBLISHED_STATUS);
    }
}
