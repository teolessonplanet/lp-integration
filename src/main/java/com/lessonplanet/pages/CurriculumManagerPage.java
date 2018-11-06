
package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CurriculumManagerPage extends LpUiBasePage {
        private static final String ALERT_NOTIFICATION = "[class*='alert']";
        private static final String REFRESH_ICON = "[class*='fa-refresh']";
        private static final String ACTIONS_DROPDOWN = " i.lp-ellipsis-icon";
        private static final String PLAY_BUTTON = "[class*='fa-play-circle-o']";
        private static final String SHARE_BUTTON = "[class*='fa-share-alt']";
        private static final String EMAIL_OPTION = "[class*='fa-envelope-square']";
        private static final String LINK_OPTION = "[class*='fa-link']";
        private static final String FACEBOOK_OPTION = "[class*='fa-facebook-square']";
        private static final String TWITTER_OPTION = "[class*='fa-twitter-square']";
        private static final String GOOGLE_OPTION = "[class*='fa-google-plus-square']";
        private static final String PUBLISH_BUTTON = "[class='fa fa-book']";
        private static final String POPOVER_TEXT = "[class*='popuptext show']";
        private static final String DELETE_BUTTON = "[class*='fa-trash']";
        private static final String CLONE_BUTTON = "[class='fa fa-clone']";
        private static final String ASSIGN_BUTTON = "[class*='fa-paper-plane']";
        private static final String EDIT_BUTTON = "[class*='fa-edit']";
        private static final String GO_TO_RESOURCE_BUTTON = "[class*='fa-external-link']";
        private static final String MY_FAVORITES_FOLDER_ROW = "#folder-1";
        private static final String MY_UPLOADS_FOLDER_ROW = "#folder-2";
        private static final String COLLECTION_ROW = "div.collection.group-row";
        private static final String RESOURCE_ROW = " div.resource.group-row";
        private static final String FAVORITE_RESOURCE_ROW = "#folder-1 div.resource.group-row";
        private static final String UPLOAD_RESOURCE_ROW = "#folder-2 div.resource.group-row";
        private static final String COLLECTION_STATUS = " div.info.status:nth-child(3)";
        private static final String RESOURCE_STATUS = " div.info.status";
        private static final String ITEM_NUMBER = " .number-of-items";
        private static final String RESOURCE_TITLE = " .resource-title-text:nth-child(1)";
        private static final String FOLDER_TITLE = " .resource-title-text";
        private static final String CREATE_A_COLLECTION_BUTTON = "[class*='cm-create-collection-btn']";
        private static final String UPLOAD_RESOURCE_BUTTON = "[class*='cm-upload-resource-btn']";
        private static final String SHOW_MORE_AND_LESS_BUTTON = "[class*='collection-info-view-toggle']";
        private static final String STATUS_COLUMN = "#sort-header-license_enum";
        private static final String DATE_COLUMN = "#sort-header-updated_at";
        private static final String SORT_BY_DROPDOWN = "#sort-widget";
        private static final String STATUS_SORT_BY_OPTION = "#sort-dropdown-license_enum";
        private static final String DATE_SORT_BY_OPTION = "#sort-dropdown-updated_at";
        private static final String RESOURCE_TITLE_SORT_BY_OPTION = "#sort-dropdown-title";
        private static final String MY_ORDER_SORT_BY_OPTION = "#sort-dropdown-custom";

        public CurriculumManagerPage(WebDriver driver) {
                super(driver);
        }

        public void loadPage(String subjectPath) {
                loadUrl(subjectPath);
        }

        public String getNotificationText(){
                return getTextForElement(ALERT_NOTIFICATION);
        }

        public void waitForNotificationToDisappear() {
                waitUntilElementIsHidden(ALERT_NOTIFICATION);
        }

        public void waitForRefreshIconToDisappear() {
                waitUntilElementIsHidden(REFRESH_ICON);
        }

        public boolean isActionsDropdownDisplayed(){
                return isElementDisplayed(ACTIONS_DROPDOWN);
        }

        public void hoverOverActionsDropdown() {
                hoverOverElement(ACTIONS_DROPDOWN);
        }

        public void hoverOverPlayButton() {
                hoverOverElement(PLAY_BUTTON);
        }

        public void clickOnPlayButton() {
                clickElement(PLAY_BUTTON);
        }

        public void hoverOverShareButton() {
                hoverOverElement(SHARE_BUTTON);
        }

        public void clickOnFacebookOption() {
                clickElement(FACEBOOK_OPTION);
        }

        public void clickOnGoogleOption() {
                clickElement(GOOGLE_OPTION);
        }

        public void clickOnEmailOption() {
                clickElement(EMAIL_OPTION);
        }

        public void clickOnLinkOption() {
                clickElement(LINK_OPTION);
        }

        public void clickOnTwitterOption() {
                clickElement(TWITTER_OPTION);
        }

        public void hoverOverPublishButton() {
                hoverOverElement(PUBLISH_BUTTON);
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

        public void clickOnCopyCollectionButton() {
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

        public void clickOnACollectionFolder() {
                findElement('#' + getElementId(COLLECTION_ROW) + RESOURCE_TITLE).click();
        }

        public boolean isCollectionFolderDisplayed() {
                String id = getElementId(COLLECTION_ROW);
                if (id != null) {
                        return isElementDisplayed('#' + id);
                } else {
                        return false;
                }
        }

        public boolean isResourceInCollectionDisplayed() {
                return isElementDisplayed('#' + getElementId(RESOURCE_ROW) + RESOURCE_TITLE);
        }

        public String getCollectionFolderTitle() {
                return getTextForElement('#' + getElementId(COLLECTION_ROW) + RESOURCE_TITLE);
        }

        public String getCollectionFolderStatus() {
                return getTextForElement('#' + getElementId(COLLECTION_ROW) + COLLECTION_STATUS);
        }

        public String getCollectionFolderItemNumber() {
                return getTextForElement('#' + getElementId(COLLECTION_ROW) + ITEM_NUMBER);
        }

        public void clickOnCreateACollectionButton() {
                waitForNotificationToDisappear();
                clickElement(CREATE_A_COLLECTION_BUTTON);
                waitForLoad();
        }

        public void clickOnUploadResourceButton() {
                clickElement(UPLOAD_RESOURCE_BUTTON);
        }

        public void clickOnShowMoreAndLessButton() {
                clickElement(SHOW_MORE_AND_LESS_BUTTON);
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

        public boolean isMyOrderOptionDisplayed() {
                return isElementDisplayed(MY_ORDER_SORT_BY_OPTION);
        }
    }
