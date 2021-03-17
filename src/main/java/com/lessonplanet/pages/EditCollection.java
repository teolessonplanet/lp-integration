package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

import java.text.NumberFormat;
import java.text.ParseException;

public class EditCollection extends CreateNewFolderModal {

    private static final String EDIT_FOLDER_TITLE = "[class='edit-folder-title'] h1";
    private static final String FOLDER_TYPE = "#edit-folder-type";
    private static final String FOLDER_TYPE_DROPDOWN = "[class='select optional collection_resource_type_list']";
    private static final String FOLDER_TYPE_OPTIONS = "#select2-drop [class='select2-results'] li";
    private static final String FOLDER_PUBLISH_STATUS_TEXT = "[class='publish-status']";
    private static final String WHAT_IS_PUBLISHING_LINK = "#share-help-text-link";

    private static final String FOLDER_TITLE_INPUT = "[name='collection[title]']";
    private static final String GRADE_LIST_DROPDOWN = "#s2id_collection_grade_list";
    private static final String GRADE_OPTIONS = "#select2-drop li";
    private static final String SUBJECT_LIST_DROPDOWN = "#s2id_collection_subject_list";
    private static final String SUBJECT_OPTIONS = "#select2-drop [class='select2-result-label']";
    private static final String DESCRIPTION_INPUT = "[class='note-editing-area'] [class='note-editable']";
    private static final String ENABLED_PUBLISH_FOLDER_BUTTON = "[class*='share-collection ok']";

    private static final String NAVIGATE_FOLDER_DROPDOWN = "#folders-dropdown";
    private static final String CREATE_NEW_FOLDER_BUTTON = "[class*='manage-collections-dropdown'] [class='list-option create-new-collection']";
    private static final String ACTIVE_FOLDER = "[class*='manage-collections-dropdown'] [class='list-option active']";
    private static final String ACTIVE_FOLDER_TITLE = "[class*='manage-collections-dropdown'] [class='list-option active'] a";

    private static final String ADD_ITEMS_DROPDOWN = "#collection-add-items-wrap";
    private static final String ADD_A_LINK_OPTION = "#edit-add-url-btn";
    private static final String ADD_A_LINK_URL_INPUT = "#js-add-url-content [name='url']";
    private static final String ADD_A_LINK_NAME_FIELD = "#js-add-url-content [name='title']";
    private static final String ADD_TO_FOLDER_BUTTON = "#js-add-url-content [class='modal-footer'] [class='btn btn-warning']";
    private static final String UPLOAD_A_FILE_OPTION = "#upload-file-button";
    private static final String ADD_PIXABAY_IMAGE_OPTION = "#js-add-pixabay-image-btn";
    private static final String PIXABAY_SUBTITLE = "[class='pixabay-license-title']";
    private static final String PIXABAY_ALL_BUTTON = "#image-type label:nth-child(1) [class='image-type']";
    private static final String PIXABAY_PHOTOS_BUTTON = "#image-type label:nth-child(2) [class='image-type']";
    private static final String PIXABAY_ILLUSTRATION_BUTTON = "#image-type label:nth-child(3) [class='image-type']";
    private static final String PIXABAY_VECTOR_BUTTON = "#image-type label:nth-child(4) [class='image-type']";
    private static final String PIXABAY_SEARCH_BAR = "#pixabay-search-bar";
    private static final String PIXABAY_SEARCH_BUTTON = "#pixabay-search-btn";
    private static final String PIXABAY_IMAGE_LINK = "a[href='https://pixabay.com']";
    private static final String PIXABAY_LEARN_MORE_LINK = "a[href='https://pixabay.com/service/faq']";
    private static final String PIXABAY_IMAGES = "[class*='pixabay-image-container']";
    private static final String ADD_SELECTED_TO_FOLDER_BUTTON = "[class*='add-selected']";
    private static final String PIXABAY_ALERT_TEXT = "[class*='alert-info']";
    private static final String CREATE_A_PAGE_OPTION = "#js-add-page-btn";
    private static final String PAGE_TITLE_INPUT = "[name='page_resource[title]']";
    private static final String PAGE_CONTENT_INPUT = "[class='add-a-page-body'] [class*='note-editable']";
    private static final String SAVE_BUTTON = "[class*='modal-footer'] [class='btn btn-primary']";
    private static final String SEARCH_RESOURCES_OPTION = "[href*='/search?keywords=']";

    private static final String PLAY_OPTION = "[class='edit-folder-action-item'][href$='/player']";
    private static final String MORE_DROPDOWN = "#collection-actions-wrap";
    private static final String ASSIGN_OPTION = "[class='dropdown-menu collection-actions-dropdown'] [href*='/assign_modal']";
    private static final String COPY_TO_OPTION = "#js-copy-collection-btn";
    private static final String COPY_TO_SELECTED_FOLDER_BUTTON = "[class*='btn btn-default btn-primary']";
    private static final String NAME_INPUT = "#copy-collection-title";
    private static final String MY_RESOURCES_DESTINATION_FOLDER = "[class='folder-list'] [class='my-resources list-option']";

    private static final String FOLDER_ITEMS = "[class='collection-item-panel panel']";
    private static final String FOLDER_ITEMS_COUNT = "[class='edit-folder-num-wrap'] [class='js-items-count']";
    private static final String FOLDER_ITEM_TITLE = "[class*='collection-item-title']";
    private static final String ALERT_NOTIFICATION = "[class='flash-messages-container']";
    private static final String ELLIPSIS_ACTIONS = "[class='show-actions dropdown-toggle']";
    private static final String EDIT_PAGE_OPTION = "[class*='collection-item-actions-list'] li:nth-child(1)";
    private static final String EDIT_PAGE_SAVE_BUTTON = "[class*='btn btn-primary'][value='Save']";
    private static final String HIDE_FROM_PLAYER_OPTION = "[class*='collection-item-actions-list'] li:nth-child(2)";
    private static final String HIDE_FROM_PLAYER_ICON = "[class*='lp-play-disabled']";
    private static final String TEACHER_NOTE_OPTION = "[class*='collection-item-actions-list'] li:nth-child(3)";
    private static final String TEACHER_NOTE_INPUT = "[name='collection_item[note]']";
    private static final String DELETE_OPTION = "[class*='collection-item-actions-list'] li:nth-child(4)";
    private static final String DELETE_ITEM_BUTTON = "[class='modal-footer'] a";

    private static final String PUBLISHED_COLLECTION_NOTIFICATION = "[class*='alert alert-success alert-dismissible']";

    private static final String FOLDER_STATUS = "[class='edit-folder-items'] [class='edit-folder-status-wrap'] [class='default-text']";

    public EditCollection(WebDriver driver) {
        super(driver);
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

    public boolean isFolderItemsCountDisplayed() {
        return isElementDisplayed(FOLDER_ITEMS_COUNT);
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
        selectFromDropdown(GRADE_LIST_DROPDOWN, GRADE_OPTIONS, grade);
    }

    public void selectSubject(String subject) {
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

    public boolean isAddALinkOptionDisplayed() {
        return isElementDisplayed(ADD_A_LINK_OPTION);
    }

    public boolean isUploadAFileOptionDisplayed() {
        return isElementDisplayed(UPLOAD_A_FILE_OPTION);
    }

    public boolean isAddPixabayImageOptionDisplayed() {
        return isElementDisplayed(ADD_PIXABAY_IMAGE_OPTION);
    }

    public boolean isCreateAPageOptionDisplayed() {
        return isElementDisplayed(CREATE_A_PAGE_OPTION);
    }

    public boolean isSearchResourcesOptionDisplayed() {
        return isElementDisplayed(SEARCH_RESOURCES_OPTION);
    }

    public void clickUploadAFileButton() {
        clickElement(UPLOAD_A_FILE_OPTION);
    }

    public void clickOnCreateAPageOption() {
        clickElement(CREATE_A_PAGE_OPTION);
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

    public void clickAddALinkOption() {
        clickElement(ADD_A_LINK_OPTION);
    }

    public void typePageContent(String description) {
        findElement(PAGE_CONTENT_INPUT).sendKeys(description);
    }

    public void clickSaveButton() {
        clickElement(SAVE_BUTTON);
    }

    public void clickOnSearchResourcesOption() {
        clickElement(SEARCH_RESOURCES_OPTION);
    }

    public void clickNavigateFolderDropdown() {
        clickElement(NAVIGATE_FOLDER_DROPDOWN);
    }

    public boolean isCreateNewFolderButtonDisplayed() {
        return isElementDisplayed(CREATE_NEW_FOLDER_BUTTON);
    }

    public void clickCreateNewFolderButton() {
        clickElement(CREATE_NEW_FOLDER_BUTTON);
    }

    public void clickOnAddPixabayImageOption() {
        clickElement(ADD_PIXABAY_IMAGE_OPTION);
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
        return findElement(FOLDER_TITLE_INPUT).getAttribute("value");
    }

    public String getAlertNotificationText() {
        return getTextForElement(PUBLISHED_COLLECTION_NOTIFICATION);
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

    public boolean isWhatIsPublishingLinkDisplayed() {
        return isElementDisplayed(WHAT_IS_PUBLISHING_LINK);
    }

    public void publishCollection(String collectionTitle, String grade, String subject, String description) {
        typeTitle(collectionTitle);
        typeDescription(description);
        selectGrade(grade);
        selectSubject(subject);
        waitUntilPublishFolderButtonIsEnabled();
        clickOnPublishFolder();
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

    public boolean isFolderTypeDisplayed() {
        return isElementDisplayed(FOLDER_TYPE);
    }

    public boolean isNavigateFolderDropdownDisplayed() {
        return isElementDisplayed(NAVIGATE_FOLDER_DROPDOWN);
    }
}
