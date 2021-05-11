package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class EditCollection extends CreateNewFolderModal {
    private static final String EDIT_FOLDER_TITLE = "[class='edit-folder-title'] h1";
    private static final String FOLDER_TYPE = "#edit-folder-type";
    private static final String FOLDER_STATUS = "[class='edit-folder-items'] [class='edit-folder-status-wrap'] [class='default-text']";
    private static final String FOLDER_PUBLISHED_STATUS = "[class='edit-folder-items'] [class='edit-folder-status-wrap'] [class='text']";
    private static final String FOLDER_TYPE_DROPDOWN = "[class='select optional collection_resource_type_list']";
    private static final String FOLDER_TYPE_OPTIONS = "#select2-drop [class='select2-results'] li";
    private static final String FOLDER_PUBLISH_STATUS_TEXT = "[class='publish-status']";

    private static final String EDIT_DETAILS_OPTION = "[class='edit-folder-actions'] [class='edit-folder-details edit-folder-action-item']";

    private static final String FOLDER_TITLE_INPUT = "#content-root [name='title']";
    private static final String EDIT_COLLECTION_SCROLLABLE_ZONE = "[class^='edit-folder-panel']";
    private static final String EDIT_COLLECTION_SCROLLABLE_ZONE_CONTENT_ROOT = "#content-root";
    private static final String GRADE_LIST_DROPDOWN = "[class*='grade-level-dropdown__dropdown-indicator']";
    private static final String GRADE_OPTIONS = "[class*='grade-level-dropdown__option']";
    private static final String SUBJECT_LIST_DROPDOWN = "[class*='subjects-dropdown__dropdown-indicator']";
    private static final String SUBJECT_OPTIONS = "[class*='subjects-dropdown__option']";
    private static final String DESCRIPTION_INPUT = "#content-root  [class='note-editable']";
    private static final String ENABLED_PUBLISH_FOLDER_BUTTON = "[class='edit-details-panel-footer-right'] button[class$='success']";

    private static final String NAVIGATE_FOLDER_DROPDOWN = "[class='navigator-toggle ']";
    private static final String NAVIGATE_FOLDER_TITLE = "#folder-navigator [class='edit-folder-navigator-title']";
    private static final String ACTIVE_FOLDER = "#folder-navigator [class='list-option active']";
    private static final String ACTIVE_FOLDER_TITLE = "#folder-navigator [class='list-option active'] a";

    private static final String ADD_ITEMS_DROPDOWN = "#collection-add-items-wrap";
    private static final String WEB_LINK_OPTION = "#add-to-folder-toolbox [class='toolbox-items'] [class='toolbox-item-wrap']:nth-child(1)";
    private static final String ADD_A_LINK_URL_INPUT = "#js-create-item [name='url']";
    private static final String ADD_A_LINK_NAME_FIELD = "#js-create-item [name='title']";
    private static final String ADD_TO_FOLDER_BUTTON = "[class='modal-footer'] [class='btn btn-warning']";
    private static final String FILE_UPLOAD_OPTION = "#add-to-folder-toolbox [class='toolbox-items'] [class='toolbox-item-wrap']:nth-child(2)";
    private static final String UPGRADE_UPLOAD_TEXT = "[class='mt25 mb25 ml30 subtext']";
    private static final String UPGRADE_NOW_BUTTON = "#upload-modal-root [class='btn btn-success']";
    private static final String PIXABAY_PANEL = "[class='edit-folder-panel add-pixabay-image']";
    private static final String PIXABAY_IMAGE_OPTION = "#add-to-folder-toolbox [class='toolbox-items'] [class='toolbox-item-wrap']:nth-child(3)";
    private static final String PIXABAY_SUBTITLE = "[class='pixabay-license-title']";
    private static final String PIXABAY_ALL_BUTTON = "#image-type label:nth-child(1) [class='image-type']";
    private static final String PIXABAY_PHOTOS_BUTTON = "#image-type label:nth-child(2) [class='image-type']";
    private static final String PIXABAY_ILLUSTRATION_BUTTON = "#image-type label:nth-child(3) [class='image-type']";
    private static final String PIXABAY_VECTOR_BUTTON = "#image-type label:nth-child(4) [class='image-type']";
    private static final String PIXABAY_SEARCH_BAR = "#pixabay-search-bar";
    private static final String PIXABAY_SEARCH_BUTTON = "#pixabay-search-btn";
    private static final String PIXABAY_IMAGE_LINK = "a[href='https://pixabay.com']";
    private static final String PIXABAY_LEARN_MORE_LINK = "a[href='https://pixabay.com/service/faq']";
    private static final String PIXABAY_IMAGES = "#add-pixabay-image-wrap [class*='pixabay-image-container'] img";
    private static final String ADD_SELECTED_TO_FOLDER_BUTTON = "[class*='add-selected']";
    private static final String PIXABAY_ALERT_TEXT = "[class*='alert-info']";
    private static final String CREATE_PAGE_OPTION = "#add-to-folder-toolbox [class='toolbox-items'] [class='toolbox-item-wrap']:nth-child(4)";
    private static final String PAGE_TITLE_INPUT = "[name='page_resource[title]']";
    private static final String PAGE_CONTENT_INPUT = "[class='add-a-page-body'] [class*='note-editable']";
    private static final String SAVE_BUTTON = "[class*='modal-footer'] [class='btn btn-primary']";
    private static final String NEW_FOLDER_BUTTON = "#add-to-folder-toolbox [class='toolbox-items'] [class='toolbox-item-wrap']:nth-child(5)";
    private static final String CREATE_FOLDER_BUTTON = "[class*='modal-footer'] [class='btn btn-default btn-primary ml10']";
    private static final String FOLDER_NAME = "[class='create-new-folder-container'] [name='title']";
    private static final String RESOURCE_LIBRARY_OPTION = "#add-to-folder-toolbox [class='toolbox-items'] [class='toolbox-item-wrap']:nth-child(6)";

    private static final String PLAY_OPTION = "[class='edit-folder-action-item button play-folder']";
    private static final String MORE_DROPDOWN = "#collection-actions-wrap";
    private static final String PUBLISH_OPTION = "[class='dropdown-menu collection-actions-dropdown'] [class='fa fa-book']";
    private static final String ASSIGN_OPTION = "[class='dropdown-menu collection-actions-dropdown'] [class='fa fa-paper-plane']";
    private static final String COPY_TO_OPTION = "[class='dropdown-menu collection-actions-dropdown'] [class='fa fa-clone']";
    private static final String COPY_TO_SELECTED_FOLDER_BUTTON = "[class*='btn btn-default btn-primary']";
    private static final String NAME_INPUT = "[name='collection[title]']";
    private static final String MY_RESOURCES_DESTINATION_FOLDER = "[class='list-option my-resources']";

    private static final String FOLDER_ITEMS = "[class='collection-item-panel panel']";
    private static final String FOLDER_ITEMS_COUNT = "[class='ef-number-of-items']";
    private static final String FOLDER_ITEM_TITLE = "[class*='collection-item-title']";
    private static final String ALERT_NOTIFICATION = "[class='details-updated-message success']";
    private static final String ELLIPSIS_ACTIONS = "[class='show-actions dropdown-toggle']";
    private static final String EDIT_PAGE_OPTION = "[class*='collection-item-actions-list'] li:nth-child(1)";
    private static final String EDIT_PAGE_SAVE_BUTTON = "[class*='btn btn-primary'][value='Save']:not([disabled=''])";
    private static final String HIDE_FROM_PLAYER_OPTION = "[class*='collection-item-actions-list'] li:nth-child(2)";
    private static final String HIDE_FROM_PLAYER_ICON = "[class*='lp-play-disabled']";
    private static final String TEACHER_NOTE_OPTION = "[class*='collection-item-actions-list'] li:nth-child(3)";
    private static final String TEACHER_NOTE_INPUT = "[name='collection_item[note]']";
    private static final String DELETE_OPTION = "[class*='collection-item-actions-list'] li:nth-child(4)";
    private static final String DELETE_ITEM_BUTTON = "[class='modal-footer'] a";

    private static final String PUBLISHED_COLLECTION_NOTIFICATION = "[class*='alert alert-success alert-dismissible']";

    private static final String PUBLISH_COLLECTION_MODAL = "#share-collection-modal";
    private static final String PUBLISH_COLLECTION_BUTTON = "button[class$='btn-success']";
    private static final String CLOSE_BUTTON = "button[class$='edit-collection-modal-close']";
    private static final String RATING_FIELD = "[class^='rating-dropdown__indicators']";
    private static final String RATING_OPTIONS = "[class^='rating-dropdown__option']";
    private static final String AUDIENCE_FIELD = "[class^='audience-dropdown__indicators']";
    private static final String AUDIENCE_OPTIONS = "[class^='audience-dropdown__option']";
    private static final String CONCEPTS_FIELD = "#react-select-7-input";
    private static final String CONCEPTS_OPTIONS = "[class^='concepts-dropdown__option']";

    private static final String ADDITIONAL_TAGS_FIELD = "[class='additional-tags-dropdown__input'] [id^='react-select-']";
    private static final String ADDITIONAL_TAGS_OPTIONS = "[class^='additional-tags-dropdown__option']";

    private PublishedFolderModal publishedFolderModal;

    public EditCollection(WebDriver driver) {
        super(driver);
        publishedFolderModal = new PublishedFolderModal(driver);
    }

    public void clickOnCloseButton() {
        clickElement(CLOSE_BUTTON);
    }

    public String getEditFolderTitle() {
        return super.getTextForElement(EDIT_FOLDER_TITLE);
    }

    public void clickMoreDropdown() {
        scrollToElement(MORE_DROPDOWN);
        clickElement(MORE_DROPDOWN);
    }

    public boolean isPlayOptionDisplayed() {
        return isElementDisplayed(PLAY_OPTION);
    }

    public boolean isAssignOptionDisplayed() {
        return isElementDisplayed(ASSIGN_OPTION);
    }

    public boolean isCopyToOptionDisplayed() {
        return isElementDisplayed(COPY_TO_OPTION);
    }

    public void clickPlayOption() {
        clickElement(PLAY_OPTION);
    }

    public void clickAssignOption() {
        clickElement(ASSIGN_OPTION);
    }

    public void clickCopyToOption() {
        clickElement(COPY_TO_OPTION);
    }

    public void clickOnCopyToSelectedFolderButton() {
        clickElement(COPY_TO_SELECTED_FOLDER_BUTTON);
    }

    public int getFolderItemsCount() {
        return Integer.parseInt(getTextForElement(FOLDER_ITEMS_COUNT).replaceAll("\\D+", ""));
    }

    public String getFolderItemTitle(int index) {
        return findElements(FOLDER_ITEM_TITLE).get(index).getText();
    }

    public void clickAddToFolderButton() {
        clickElement(ADD_TO_FOLDER_BUTTON);
    }

    public void typeTitle(String title) {
        sendKeys(FOLDER_TITLE_INPUT, title);
    }

    public void selectGrade(String grade) {
        scrollWithOffsetForEditCollection(EDIT_COLLECTION_SCROLLABLE_ZONE, EDIT_COLLECTION_SCROLLABLE_ZONE_CONTENT_ROOT, GRADE_LIST_DROPDOWN);
        selectFromDropdown(GRADE_LIST_DROPDOWN, GRADE_OPTIONS, grade);
    }

    public void selectSubject(String subject) {
        scrollWithOffsetForEditCollection(EDIT_COLLECTION_SCROLLABLE_ZONE, EDIT_COLLECTION_SCROLLABLE_ZONE_CONTENT_ROOT, SUBJECT_LIST_DROPDOWN);
        selectFromDropdown(SUBJECT_LIST_DROPDOWN, SUBJECT_OPTIONS, subject);
    }

    public void typeDescription(String description) {
        sendKeys(DESCRIPTION_INPUT, description);
    }

    public void clickOnPublishFolder() {
        clickElement(ENABLED_PUBLISH_FOLDER_BUTTON);
    }

    public void waitUntilPublishFolderButtonIsEnabled() {
        waitUntilElementIsDisplayed(findElement(ENABLED_PUBLISH_FOLDER_BUTTON));
    }

    public void clickEllipsisActions(int index) {
        findElements(ELLIPSIS_ACTIONS).get(index).click();
    }

    public boolean isEditPageOptionDisplayed() {
        return isElementDisplayed(EDIT_PAGE_OPTION);
    }

    public boolean isHideFromPlayerOptionDisplayed() {
        return isElementDisplayed(HIDE_FROM_PLAYER_OPTION);
    }

    public boolean isHideFromPlayerIconDisplayed() {
        return isElementVisible(HIDE_FROM_PLAYER_ICON);
    }

    public boolean isTeacherNoteOptionDisplayed() {
        return isElementDisplayed(TEACHER_NOTE_OPTION);
    }

    public boolean isDeleteOptionDisplayed() {
        return isElementDisplayed(DELETE_OPTION);
    }

    public void clickEditPageOption() {
        clickElement(EDIT_PAGE_OPTION);
    }

    public void clickTeacherNoteOption() {
        clickElement(TEACHER_NOTE_OPTION);
    }

    public void clickHideFromPlayerOption() {
        clickElement(HIDE_FROM_PLAYER_OPTION);
    }

    public void typeTeacherNote(String teacherNote) {
        findElement(TEACHER_NOTE_INPUT).sendKeys(teacherNote);
    }

    public void clickSaveNoteButton() {
        clickElement(EDIT_PAGE_SAVE_BUTTON);
    }

    public void waitForNotificationToDisappear() {
        waitUntilElementIsHidden(ALERT_NOTIFICATION);
    }

    public String getUpdatedNotificationText() {
        return getTextForNotification(ALERT_NOTIFICATION);
    }

    public void clickDeleteOption() {
        clickElement(DELETE_OPTION);
    }

    public void clickDeleteItemButton() {
        clickElement(DELETE_ITEM_BUTTON);
    }

    public void clickOnAddItemsDropdown() {
        scrollToElement(ADD_ITEMS_DROPDOWN);
        clickElement(ADD_ITEMS_DROPDOWN);
    }

    public boolean isWebLinkOptionDisplayed() {
        return isElementDisplayed(WEB_LINK_OPTION);
    }

    public boolean isFileUploadOptionDisplayed() {
        return isElementDisplayed(FILE_UPLOAD_OPTION);
    }

    public boolean isPixabayImageOptionDisplayed() {
        return isElementDisplayed(PIXABAY_IMAGE_OPTION);
    }

    public boolean isCreatePageOptionDisplayed() {
        return isElementDisplayed(CREATE_PAGE_OPTION);
    }

    public boolean isSearchResourcesOptionDisplayed() {
        return isElementDisplayed(RESOURCE_LIBRARY_OPTION);
    }

    public void clickFileUploadButton() {
        clickElement(FILE_UPLOAD_OPTION);
    }

    public void clickOnCreatePageOption() {
        clickElement(CREATE_PAGE_OPTION);
    }

    public void typePageTitle(String text) {
        findElement(PAGE_TITLE_INPUT).sendKeys(text);
    }

    public void clearPageTitle() {
        clearText(PAGE_TITLE_INPUT);
    }

    public void typeUrl(String Url) {
        clearText(ADD_A_LINK_URL_INPUT);
        sendKeys(ADD_A_LINK_URL_INPUT, Url);
    }

    public void clickWebLinkOption() {
        clickElement(WEB_LINK_OPTION);
    }

    public void typePageContent(String description) {
        findElement(PAGE_CONTENT_INPUT).sendKeys(description);
    }

    public void clickSaveButton() {
        clickElement(SAVE_BUTTON);
    }

    public void clickOnSearchResourcesOption() {
        clickElement(RESOURCE_LIBRARY_OPTION);
    }

    public void clickNavigateFolderDropdown() {
        clickElement(NAVIGATE_FOLDER_DROPDOWN);
    }

    public boolean isNewFolderOptionDisplayed() {
        return isElementDisplayed(NEW_FOLDER_BUTTON);
    }

    public boolean isResourceLibraryOptionDisplayed() {
        return isElementDisplayed(RESOURCE_LIBRARY_OPTION);
    }

    public void clickNewFolderButton() {
        clickElement(NEW_FOLDER_BUTTON);
    }

    public void clickOnPixabayImageOption() {
        clickElement(PIXABAY_IMAGE_OPTION);
    }

    public void searchPixabayImage(String text) {
        findElement(PIXABAY_SEARCH_BAR).sendKeys(text);
    }

    public void clickPixabaySearchButton() {
        clickElement(PIXABAY_SEARCH_BUTTON);
    }

    public void waitUntilAddSelectedToFolderButtonIsDisplayed() {
        waitUntilElementIsDisplayed(findElement(ADD_SELECTED_TO_FOLDER_BUTTON));
    }

    public void clickOnPixabayImage(int position) {
        findElements(PIXABAY_IMAGES).get(position).click();
    }

    public void scrollPixabayPanel() {
        scrollElementWithOffset(findElement(PIXABAY_PANEL), findElement(PIXABAY_IMAGES));
    }

    public void clickAddSelectedToFolderButton() {
        clickElement(ADD_SELECTED_TO_FOLDER_BUTTON);
    }

    public void clickOnPixabayLink() {
        clickElement(PIXABAY_IMAGE_LINK);
    }

    public void clickOnLearnMoreLink() {
        clickElement(PIXABAY_LEARN_MORE_LINK);
    }

    public String getPixabayAlertText() {
        return getTextForElement(PIXABAY_ALERT_TEXT);
    }

    public boolean isPixabayLinkDisplayed() {
        return isElementDisplayed(PIXABAY_IMAGE_LINK);
    }

    public boolean isLearnMoreLinkDisplayed() {
        return isElementDisplayed(PIXABAY_LEARN_MORE_LINK);
    }

    public boolean isAddPixabayImageSubtitleDisplayed() {
        return isElementDisplayed(PIXABAY_SUBTITLE);
    }

    public boolean isPixabaySearchButtonDisplayed() {
        return isElementDisplayed(PIXABAY_SEARCH_BUTTON);
    }

    public boolean isPixabaySearchBarDisplayed() {
        return isElementDisplayed(PIXABAY_SEARCH_BAR);
    }

    public boolean isPixabayAllButtonDisplayed() {
        return isElementDisplayed(findElement(PIXABAY_ALL_BUTTON).getAttribute("value"));
    }

    public boolean isPixabayPhotosButtonDisplayed() {
        return isElementDisplayed(findElement(PIXABAY_PHOTOS_BUTTON).getAttribute("value"));
    }

    public boolean isPixabayIllustrationButtonDisplayed() {
        return isElementDisplayed(findElement(PIXABAY_ILLUSTRATION_BUTTON).getAttribute("value"));
    }

    public boolean isPixabayVectorButtonDisplayed() {
        return isElementDisplayed(findElement(PIXABAY_VECTOR_BUTTON).getAttribute("value"));
    }

    public void waitUntilNotificationIsDisplayed(String text) {
        waitUntilTextIsDisplayed(ALERT_NOTIFICATION, text);
    }

    public void waitUntilItemIsAddedIntoFolder() {
        waitUntilElementIsDisplayed(findElements(FOLDER_ITEMS).get(0));
    }

    public void waitUntilNameFieldIsDisplayed() {
        waitUntilElementIsDisplayed(findElement(ADD_A_LINK_NAME_FIELD));
    }

    public void typeUrlName(String name) {
        clearText(ADD_A_LINK_NAME_FIELD);
        sendKeys(ADD_A_LINK_NAME_FIELD, name);
    }

    public void typeName(String name) {
        clearText(NAME_INPUT);
        sendKeys(NAME_INPUT, name);
    }

    public void clickMyResourcesDestinationFolder() {
        clickElement(MY_RESOURCES_DESTINATION_FOLDER);
    }

    public void chooseFolderType(String folderType) {
        selectFromDropdown(FOLDER_TYPE_DROPDOWN, FOLDER_TYPE_OPTIONS, folderType);
    }

    public String getFolderTitle() {
        return findElement(EDIT_FOLDER_TITLE).getText();
    }

    public String getAlertNotificationText() {
        return getTextForNotification(PUBLISHED_COLLECTION_NOTIFICATION);
    }

    public boolean isEnabledPublishFolderButtonDisplayed() {
        return isElementDisplayed(ENABLED_PUBLISH_FOLDER_BUTTON);
    }

    public String getFolderPublishStatusText() {
        return getTextForElement(FOLDER_PUBLISH_STATUS_TEXT);
    }

    public String getPublishedFolderMonth() {
        if (TestData.getCurrentMonth() < 10) {
            return String.format("%02d", TestData.getCurrentMonth());
        } else return String.format("%01d", TestData.getCurrentMonth());
    }

    public void waitUntilCopiedCollectionIsDisplayed() {
        waitUntilTextIsDisplayed(EDIT_FOLDER_TITLE, TestData.COPIED_FOLDER_NAME);
    }

    public boolean isActiveFolderDisplayed() {
        return isElementDisplayed(ACTIVE_FOLDER);
    }

    public String getActiveFolderTitle() {
        return getTextForElement(ACTIVE_FOLDER_TITLE);
    }

    public boolean isAddDropdownDisplayed() {
        return isElementDisplayed(ADD_ITEMS_DROPDOWN);
    }

    public boolean isMoreDropdownDisplayed() {
        return isElementDisplayed(MORE_DROPDOWN);
    }

    public String getFolderStatus() {
        return getTextForElement(FOLDER_STATUS);
    }

    public String getFolderPublishedStatus() {
        return getTextForElement(FOLDER_PUBLISHED_STATUS);
    }

    public boolean isFolderTypeDisplayed() {
        return isElementDisplayed(FOLDER_TYPE);
    }

    public boolean isNavigateFolderDropdownDisplayed() {
        return isElementDisplayed(NAVIGATE_FOLDER_DROPDOWN);
    }

    public void clickOnNewFolderOption() {
        clickElement(NEW_FOLDER_BUTTON);
    }

    public void typeNewFolderName() {
        findElement(FOLDER_NAME).sendKeys("test");
    }

    public void clickOnCreateFolderButton() {
        clickElement(CREATE_FOLDER_BUTTON);
    }

    public boolean isPublishOptionDisplayed() {
        return isElementDisplayed(PUBLISH_OPTION);
    }

    public void clickOnPublishOption() {
        clickElement(PUBLISH_OPTION);
    }

    public String getNavigateFolderTitle() {
        return getTextForElement(NAVIGATE_FOLDER_TITLE);
    }

    public boolean isEditDetailsOptionDisplayed() {
        return isElementDisplayed(EDIT_DETAILS_OPTION);
    }

    public void clickEditDetails() {
        clickElement(EDIT_DETAILS_OPTION);
    }

    public void clickOnUpgradeNowButton() {
        clickElement(UPGRADE_NOW_BUTTON);
    }

    public String getUpgradeModalText() {
        return getTextForElement(UPGRADE_UPLOAD_TEXT);
    }

    public void chooseRating() {
        scrollWithOffsetForEditCollection(EDIT_COLLECTION_SCROLLABLE_ZONE, EDIT_COLLECTION_SCROLLABLE_ZONE_CONTENT_ROOT, RATING_FIELD);
        selectFromDropdown(RATING_FIELD, RATING_OPTIONS, TestData.RATING);
    }

    public void chooseAudience() {
        scrollWithOffsetForEditCollection(EDIT_COLLECTION_SCROLLABLE_ZONE, EDIT_COLLECTION_SCROLLABLE_ZONE_CONTENT_ROOT, AUDIENCE_FIELD);
        selectFromDropdown(AUDIENCE_FIELD, AUDIENCE_OPTIONS, TestData.AUDIENCE);
    }

    public void chooseConcepts() {
        scrollWithOffsetForEditCollection(EDIT_COLLECTION_SCROLLABLE_ZONE, EDIT_COLLECTION_SCROLLABLE_ZONE_CONTENT_ROOT, CONCEPTS_FIELD);
        selectFromDropdownWithSearch(CONCEPTS_FIELD, CONCEPTS_OPTIONS, TestData.CONCEPT);
    }

    public void chooseAdditionalTags() {
        scrollWithOffsetForEditCollection(EDIT_COLLECTION_SCROLLABLE_ZONE, EDIT_COLLECTION_SCROLLABLE_ZONE_CONTENT_ROOT, ADDITIONAL_TAGS_FIELD);
        selectFromDropdownWithSearch(ADDITIONAL_TAGS_FIELD, ADDITIONAL_TAGS_OPTIONS, TestData.ADDITIONAL_TAGS);
    }

    public void clickOnPublishCollectionButton() {
        clickElement(PUBLISH_COLLECTION_BUTTON);
    }

    public void publishCollection(String accountPlanText, String collectionTitle, String grade, String subject, String description) {


        completeCollectionForPublish(accountPlanText, collectionTitle, grade, subject, description);
        clickOnPublishCollectionButton();
        if (!(accountPlanText.equals(TestData.VALID_EMAIL_CSL_HENRY) || accountPlanText.equals(TestData.VALID_EMAIL_CSL_COBB))) {
            publishedFolderModal.clickOnCloseButton();
        }
    }

    public void completeCollectionForPublish(String accountPlanText, String collectionTitle, String grade, String subject, String description) {
        clickMoreDropdown();
        clickOnPublishOption();

        completePublishCollectionRequirements(collectionTitle, grade, subject, description);
    }

    public void completePublishCollectionRequirements(String collectionTitle, String grade, String subject, String description) {
        typeTitle(collectionTitle);
        typeDescription(description);
        selectGrade(grade);
        selectSubject(subject);
        chooseRating();
        chooseAudience();
        chooseConcepts();
        chooseAdditionalTags();
    }
}
