package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

import java.util.List;

public class CurriculumManagerPage extends LpUiBasePage {
    private static final String ALERT_NOTIFICATION = "[class='alert mb5 alert-danger']";
    private static final String REFRESH_ICON = "[class*='fa-refresh']";
    private static final String CURRICULUM_MANAGER_PAGE_TITLE = "#curriculum_manager h1";
    private static final String POPOVER_TEXT = "[class*='popuptext show']";

    private static final String MY_FAVORITES_FOLDER_ROW = "#folder-1";
    private static final String FAVORITE_RESOURCE_ROW = "#folder-1 div.resource.group-row";
    private static final String GO_TO_RESOURCE_BUTTON = "[class*='fa-external-link']";
    private static final String DELETE_RESOURCE_BUTTON = "[class='options actions'] button[class*='action-item unfavorite']";

    private static final String MY_UPLOADS_FOLDER_ACTIONS_DROPDOWN = "#folder-2 [class*='actions'] i";
    private static final String MY_UPLOADS_FOLDER_ROW = "#folder-2";
    private static final String UPLOAD_RESOURCE_ROW = "#folder-2 div.resource.group-row";

    private static final String FOLDER_ROW = "div.collection.group-row";
    private static final String FOLDER_TYPE = " .info.type.persistent";
    private static final String FOLDER_STATUS = " .info.status";
    private static final String FOLDER_TITLE = " .resource-title-text.folder";

    private static final String RESOURCE_ROW = " div.resource.group-row";
    private static final String UPLOADED_RESOURCE_TITLE = "[class*='group-row resource user-added'] [class='resource-title-text-wrap']";
    private static final String RESOURCE_TITLE = " .resource-title-text:nth-child(1)";
    private static final String RESOURCE_TYPE = " div.info.type.persistent";
    private static final String RESOURCE_STATUS = " div.info.status";
    private static final String RESOURCE_DETAILS_ICON = " .info.persistent.details";

    private static final String ITEM_NUMBER = " .number-of-items";

    private static final String CREATE_A_FOLDER_BUTTON = "[class*='cm-create-collection-btn']";
    private static final String UPLOAD_RESOURCE_BUTTON = "[class*='cm-upload-resource-btn']";
    private static final String SHOW_AND_HIDE_DETAILS_BUTTON = "[class*='cm-show-details-btn']";
    private static final String STATUS_COLUMN = "[class='info status']";
    private static final String DATE_COLUMN = "[class='info date']";
    private static final String SORT_BY_DROPDOWN = "#sort-widget";
    private static final String SORT_BY_VALUE_TEXT = "[class='sort-by-value']";

    private static final String SORT_BY_TITLE_OPTION = "#sort-dropdown-title";
    private static final String SORT_BY_STATUS_OPTION = "#sort-dropdown-license_enum";
    private static final String SORT_BY_DATE_UPDATED_OPTION = "#sort-dropdown-updated_at";
    private static final String SORT_BY_MY_ORDER_OPTION = "#sort-dropdown-sequence";
    private static final String SORT_BY_ASCENDING_OPTION = "[class='cm-sort-ascending']";
    private static final String SORT_BY_DESCENDING_OPTION = "[class='cm-sort-descending']";

    private static final String ACTIONS_DROPDOWN_BUTTON = "[class*='group-info'] [class='action-dropdown']";
    private static final String EDIT_FOLDER_BUTTON = "[class='options actions'] button[class*='action-item edit']";
    private static final String PLAY_FOLDER_BUTTON = "[class='options actions'] button[class*='action-item play']";
    private static final String PLAY_FOLDER_DISABLED_BUTTON = "[class='options actions'] button[class*='action-item play  disabled']";
    private static final String ASSIGN_FOLDER_BUTTON = "[class='options actions'] button[class*='action-item assign']";
    private static final String ASSIGN_FOLDER_DISABLED_BUTTON = "[class='options actions'] button[class*='action-item assign  disabled']";
    private static final String PUBLISH_FOLDER_BUTTON = "[class='options actions'] button[class*='action-item publish']";
    private static final String COPY_FOLDER_TO_BUTTON = "[class='options actions'] button[class*='action-item copy-to']";
    private static final String MOVE_FOLDER_TO_BUTTON = "[class='options actions'] button[class*='action-item move-to']";
    private static final String DELETE_FOLDER_BUTTON = "[class='options actions'] button[class*='action-item delete']";
    private static final String ACTIVITY_BUTTON = "[class='options actions'] button[class*='action-item activity']";
    private static final String SHARE_BUTTON = "[class='options actions'] [class*='action-item share']";


    private static final String FOLDERS = "[class='group-table'] [id^='collection-']:not([id^='collection-item-']) [class='group-info']";
    private static final String FOLDERS_CHILDS = "[class='children-container'] div[id^='collection-item-']";
    private static final String BREADCRUMBS_ITEMS = "[class='breadcrumbs-list'] li";
    private static final String BREADCRUMBS_LAST_ITEM = "[class='breadcrumbs-list'] [class='focused-title']";
    private static final String ACTIONS_HEADER_BUTTON = "[class^='cm-table-header'] [class^='action-dropdown']";

    private static final String VIEW_FOLDER_BUTTON = " .view-folder-btn";

    private static final String SHARED_WITH_ME_TAB_BUTTON = "[href='/my/shared_with_me/by_users']";
    private static final String SHARED_WITH_ME_TAB_EMPTY_MESSAGE_TEXT = "[class='no-resources-shared-message']";
    private static final String REMOVE_SHARED_FOLDER_BUTTON = "[class='options actions'] button[class^='action-item remove']";
    private static final String FOLDER_LAST_CHILD = "div[id^='collection-item-']:last-child";

    private static final String SPINNER_ICON = "[class='fa fa-circle-o-notch fa-spin']";
    private static final String SHARED_BY_DISTRICT_TAB = "[href='/my/shared_with_me/by_district']";

    public CurriculumManagerPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.CURRICULUM_MANAGER_PAGE_PATH);
    }

    public String getNotificationText() {
        return getTextForNotification(ALERT_NOTIFICATION);
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
        clickElement(ACTIONS_DROPDOWN_BUTTON);
    }

    public void hoverOverPlayFolderButton() {
        hoverOverElement(PLAY_FOLDER_BUTTON);
    }

    public void clickOnPlayFolderButton() {
        clickElement(PLAY_FOLDER_BUTTON);
    }

    public void clickOnPlayFavoriteButton() {
        clickElement(PLAY_FOLDER_BUTTON);
    }

    public void hoverOverPublishButton() {
        hoverOverElement(PUBLISH_FOLDER_BUTTON, false);
    }

    public void clickOnPublishButton() {
        clickElement(PUBLISH_FOLDER_BUTTON);
    }

    public String getPopoverText() {
        return getTextForElement(POPOVER_TEXT);
    }

    public void clickOnDeleteButton() {
        clickElement(DELETE_FOLDER_BUTTON);
    }

    public void clickOnUnFavoriteButton() {
        clickElement(DELETE_RESOURCE_BUTTON);
    }

    public void clickOnCopyToButton() {
        clickElement(COPY_FOLDER_TO_BUTTON);
    }

    public void clickOnAssignButton() {
        clickElement(ASSIGN_FOLDER_BUTTON);
    }

    public void clickOnEditButton() {
        clickElement(EDIT_FOLDER_BUTTON);
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

    public void clickOnFirstFolder() {
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

    public int getFolderItemNumber() {
        return Integer.parseInt(getTextForElement('#' + getElementId(FOLDER_ROW) + ITEM_NUMBER).replaceAll("[()]", ""));
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

    public boolean isPublishButtonDisplayed() {
        return isElementDisplayed(PUBLISH_FOLDER_BUTTON);
    }

    public void clickOnMoveToOption() {
        clickElement(MOVE_FOLDER_TO_BUTTON);
    }

    public void hoverOverActionsDropdown() {
        hoverOverElement(ACTIONS_DROPDOWN_BUTTON);
    }

    public String getFolderStatus() {
        return getTextForElement('#' + getElementId(FOLDER_ROW) + FOLDER_STATUS);
    }

    public int getFoldersNumber() {
        final List<WebElement> foldersNumber = findElements(FOLDER_ROW);
        return foldersNumber.size();
    }

    public boolean isActionsDropdownOptionsDisplayed() {
        return isElementDisplayed(ACTIONS_DROPDOWN_BUTTON);
    }

    public String getTitle() {
        return getTextForElement(CURRICULUM_MANAGER_PAGE_TITLE);
    }

    public int getCountFolders() {
        return findElements(FOLDERS + FOLDER_TITLE).size();
    }

    public WebElement getFolder(int position) {
        return findElements(FOLDERS).get(position);
    }

    public void clickOnFolder(int position) {
        clickElement(findElements(getFolder(position), RESOURCE_TITLE).get(0));
    }

    public int getCountFolderChilds() {
        return findElements(FOLDERS_CHILDS).size();
    }

    public int getCountBreadcrumbs() {
        return findElements(BREADCRUMBS_ITEMS).size();
    }

    public String getBreadcrumbLastItemText() {
        return getTextForElement(BREADCRUMBS_LAST_ITEM);
    }

    public boolean isActionsHeaderButtonDisplayed() {
        return isElementVisible(ACTIONS_HEADER_BUTTON);
    }

    public void clickActionsDropdown(WebElement folder) {
        clickElement(findElements(folder, ACTIONS_DROPDOWN_BUTTON).get(0));
    }

    public void clickOnActionsDropdownButton(WebElement folder) {
        clickElement(findElements(folder, ACTIONS_DROPDOWN_BUTTON).get(0));
    }

    public boolean isEditFolderButtonDisplayed(WebElement folder) {
        if (folder == null) {   //if null -> get the Edit button from Header -> Actions
            return isElementDisplayed(EDIT_FOLDER_BUTTON);
        }
        return isElementDisplayed(folder, EDIT_FOLDER_BUTTON);
    }

    public boolean isPlayFolderButtonDisplayed(WebElement folder) {
        if (folder == null) {
            return isElementDisplayed(PLAY_FOLDER_BUTTON);
        }
        return isElementDisplayed(folder, PLAY_FOLDER_BUTTON);
    }

    public boolean isPlayFolderButtonDisabled(WebElement folder) {
        if (folder == null) {
            return isElementDisplayed(PLAY_FOLDER_DISABLED_BUTTON);
        }
        return isElementDisplayed(folder, PLAY_FOLDER_DISABLED_BUTTON);
    }

    public boolean isAssignFolderButtonDisplayed(WebElement folder) {
        if (folder == null) {
            return isElementDisplayed(ASSIGN_FOLDER_BUTTON);
        }
        return isElementDisplayed(folder, ASSIGN_FOLDER_BUTTON);
    }

    public boolean isPublishFolderButtonDisplayed(WebElement folder) {
        if (folder == null) {
            return isElementDisplayed(PUBLISH_FOLDER_BUTTON);
        }
        return isElementDisplayed(folder, PUBLISH_FOLDER_BUTTON);
    }

    public boolean isCopyFolderToButtonDisplayed(WebElement folder) {
        if (folder == null) {
            return isElementDisplayed(COPY_FOLDER_TO_BUTTON);
        }
        return isElementDisplayed(folder, COPY_FOLDER_TO_BUTTON);
    }

    public boolean isMoveFolderToButtonDisplayed(WebElement folder) {
        if (folder == null) {
            return isElementDisplayed(MOVE_FOLDER_TO_BUTTON);
        }
        return isElementDisplayed(folder, MOVE_FOLDER_TO_BUTTON);
    }

    public boolean isDeleteFolderButtonDisplayed(WebElement folder) {
        if (folder == null) {
            return isElementDisplayed(DELETE_FOLDER_BUTTON);
        }
        return isElementDisplayed(folder, DELETE_FOLDER_BUTTON);
    }

    public void clickOnEditFolderButton(WebElement folder) {
        if (folder == null) {
            clickElement(EDIT_FOLDER_BUTTON);
        } else {
            clickElement(findElements(folder, EDIT_FOLDER_BUTTON).get(0));
        }
    }

    public void clickOnPlayFolderButton(WebElement folder) {
        if (folder == null) {
            clickElement(PLAY_FOLDER_BUTTON);
        } else {
            clickElement(findElements(folder, PLAY_FOLDER_BUTTON).get(0));
        }
    }

    public void clickOnAssignFolderButton(WebElement folder) {
        if (folder == null) {
            clickElement(ASSIGN_FOLDER_BUTTON);
        } else {
            clickElement(findElements(folder, ASSIGN_FOLDER_BUTTON).get(0));
        }
    }

    public void clickOnPublishFolderButton(WebElement folder) {
        if (folder == null) {
            clickElement(PUBLISH_FOLDER_BUTTON);
        } else {
            clickElement(findElements(folder, PUBLISH_FOLDER_BUTTON).get(0));
        }
    }

    public void clickOnCopyFolderToButton(WebElement folder) {
        if (folder == null) {
            clickElement(COPY_FOLDER_TO_BUTTON);
        } else {
            clickElement(findElements(folder, COPY_FOLDER_TO_BUTTON).get(0));
        }
    }

    public void clickOnMoveFolderToButton(WebElement folder) {
        if (folder == null) {
            clickElement(MOVE_FOLDER_TO_BUTTON);
        } else {
            clickElement(findElements(folder, MOVE_FOLDER_TO_BUTTON).get(0));
        }
    }

    public void clickOnDeleteFolderButton(WebElement folder) {
        if (folder == null) {
            clickElement(DELETE_FOLDER_BUTTON);
        } else {
            clickElement(findElements(folder, DELETE_FOLDER_BUTTON).get(0));
        }
    }

    public void clickOnActionsFromHeaderDropdownButton() {
        clickElement(ACTIONS_HEADER_BUTTON);
    }

    public List<WebElement> getFolders() {
        return findElements(FOLDERS);
    }

    public void hoverOverChild(int index) {
        hoverOverElement(FOLDERS_CHILDS, index);
    }

    public void clickOnViewChildFolderButton() {
        clickElement(FOLDERS_CHILDS + VIEW_FOLDER_BUTTON);
    }

    public void clickOnFavoriteResourceInfoIcon() {
        clickElement('#' + getElementId(FAVORITE_RESOURCE_ROW) + RESOURCE_DETAILS_ICON);
    }

    public String getFavoriteResourceType() {
        return getTextForElement('#' + getElementId(FAVORITE_RESOURCE_ROW) + RESOURCE_TYPE);
    }

    public void clickOnUploadedFileInfoIcon() {
        clickElement('#' + getElementId(UPLOAD_RESOURCE_ROW) + RESOURCE_DETAILS_ICON);
    }

    public boolean isShareFolderButtonDisplayed(WebElement folder) {
        if (folder == null) {
            return isElementDisplayed(SHARE_BUTTON);
        }
        return isElementDisplayed(folder, SHARE_BUTTON);
    }

    public WebElement getExpandedFolderChild(int childPosition) {
        return findElements(FOLDERS_CHILDS + " [class='group-info']").get(childPosition);
    }

    public String getChildFolderStatus(int childPosition) {
        return getTextForElement(findElements(FOLDERS_CHILDS + FOLDER_STATUS).get(childPosition));
    }

    public void clickOnFolderResourceInfoIcon(int index) {
        findElements(FOLDERS_CHILDS + RESOURCE_DETAILS_ICON).get(index).click();
    }

    public void clickOnSharedWithMeTabButton() {
        clickElement(SHARED_WITH_ME_TAB_BUTTON);
    }

    public String getSharedWithMeEmptyPageText() {
        return getTextForElement(SHARED_WITH_ME_TAB_EMPTY_MESSAGE_TEXT);
    }

    public void clickOnShareFolderButton() {
        clickElement(SHARE_BUTTON);
    }

    public boolean isFolderListDisplayed() {
        return isElementDisplayed(FOLDER_ROW);
    }

    public WebElement getFolderLastChild() {
        return findElement(FOLDER_LAST_CHILD);
    }

    public boolean isRemoveFolderToButtonDisplayed(WebElement folder) {
        if (folder == null) {
            return isElementDisplayed(REMOVE_SHARED_FOLDER_BUTTON);
        }
        return isElementDisplayed(folder, REMOVE_SHARED_FOLDER_BUTTON);
    }

    public void clickOnRemoveFolderButton(WebElement folder) {
        if (folder == null) {
            clickElement(REMOVE_SHARED_FOLDER_BUTTON);
        } else {
            clickElement(findElements(folder, REMOVE_SHARED_FOLDER_BUTTON).get(0));
        }
    }

    public String getUploadedResourceTitle(int position) {
        return findElements(UPLOADED_RESOURCE_TITLE).get(position).getText();
    }

    public int getUploadedResourcesNumber() {
        return findElements(UPLOAD_RESOURCE_ROW + RESOURCE_TITLE).size();
    }

    public void waitUntilSpinnerIsNotDisplayed() {
        waitUntilElementIsHidden(SPINNER_ICON);
    }

    public boolean isCreateAFolderButtonDisplayed() {
        return isElementDisplayed(CREATE_A_FOLDER_BUTTON);
    }

    public void clickOnSharedByDistrictTab() {
        clickElement(SHARED_BY_DISTRICT_TAB);
    }

    public boolean isShowHideDetailsButtonDisplayed() {
        return isElementDisplayed(SHOW_AND_HIDE_DETAILS_BUTTON);
    }

    public boolean isSortByDropdownDisplayed() {
        return isElementDisplayed(SORT_BY_DROPDOWN);
    }

    public void hoverOverFolder(int i) {
        hoverOverElement(FOLDERS, i);
    }

    public String getSortByValue() {
        return getTextForElement(SORT_BY_VALUE_TEXT);
    }

    public boolean isSortByStatusOptionDisplayed() {
        return isElementDisplayed(SORT_BY_STATUS_OPTION);
    }

    public boolean isSortByTitleOptionDisplayed() {
        return isElementDisplayed(SORT_BY_TITLE_OPTION);
    }

    public boolean isSortByDateUpdatedOptionDisplayed() {
        return isElementDisplayed(SORT_BY_DATE_UPDATED_OPTION);
    }

    public boolean isSortByMyOrderOptionDisplayed() {
        return isElementDisplayed(SORT_BY_MY_ORDER_OPTION);
    }

    public boolean isSortAscendingOptionDisplayed() {
        return isElementDisplayed(SORT_BY_ASCENDING_OPTION);
    }

    public boolean isSortDescendingOptionDisplayed() {
        return isElementDisplayed(SORT_BY_ASCENDING_OPTION);
    }

    public void clickOnSortByDescending() {
        clickElement(SORT_BY_DESCENDING_OPTION);
    }

    public void clickOnSortByDate() {
        clickElement(SORT_BY_DATE_UPDATED_OPTION);
    }

    public boolean isUploadResourceButtonDisplayed() {
        return isElementDisplayed(UPLOAD_RESOURCE_BUTTON);
    }

    public void clickOnFolderInfoIcon(int index) {
        findElements(FOLDERS + RESOURCE_DETAILS_ICON).get(index).click();
    }

    public void clickOnViewFolderButton() {
        clickElement(FOLDERS + VIEW_FOLDER_BUTTON);
    }
}
