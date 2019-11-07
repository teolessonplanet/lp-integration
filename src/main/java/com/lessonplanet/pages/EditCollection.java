package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

import java.text.NumberFormat;
import java.text.ParseException;

public class EditCollection extends LpUiBasePage {

    private static final String EDIT_COLLECTION_TITLE = "[class*='edit-title']";

    private static final String COLLECTION_TITLE_INPUT = "[name='collection[title]']";
    private static final String GRADE_LIST_DROPDOWN = "#s2id_collection_grade_list";
    private static final String GRADE_OPTIONS = "#select2-drop li";
    private static final String SUBJECT_LIST_DROPDOWN = "#s2id_collection_subject_list";
    private static final String SUBJECT_OPTIONS = "#select2-drop [class='select2-result-label']";
    private static final String DESCRIPTION_INPUT = "[class='note-editable panel-body']";
    private static final String DISABLED_PUBLISH_COLLECTION_BUTTON = "[class*='share-collection disabled']";
    private static final String ENABLED_PUBLISH_COLLECTION_BUTTON = "[class*='share-collection ok']";

    private static final String MY_COLLECTION_DROPDOWN = "#manage-collections-wrap";
    private static final String CREATE_NEW_COLLECTION_BUTTON = "[class*='manage-collections-dropdown'] li:nth-child(1)";
    private static final String ACTIVE_COLLECTION_MY_COLLECTION_DROPDOWN = "[class*='manage-collections-dropdown'] li:nth-child(2) [class='title']";
    private static final String ACTIVE_COLLECTION_MY_COLLECTION_HEADER = "#crt-col-title";

    private static final String MY_RESOURCES_BUTTON = "#my-resources-button-wrap";

    private static final String ADD_ITEMS_DROPDOWN = "#collection-add-items-wrap";
    private static final String ADD_A_LINK_OPTION = "#js-add-url-btn";
    private static final String ADD_A_LINK_URL_INPUT = "#url";
    private static final String ADD_A_LINK_NAME_FIELD = "[name='collection_item[title]']";
    private static final String ADD_TO_COLLECTION_BUTTON = "#js-create-item [class*='btn-warning']";
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
    private static final String ADD_SELECTED_TO_COLLECTION_BUTTON = "[class*='add-selected']";
    private static final String PIXABAY_ALERT_TEXT = "[class*='alert-info']";
    private static final String CREATE_A_PAGE_OPTION = "#js-add-page-btn";
    private static final String PAGE_TITLE_INPUT = "[name='page_resource[title]']";
    private static final String PAGE_CONTENT_INPUT = "[class='add-a-page-body'] [class*='note-editable']";
    private static final String SAVE_BUTTON = "[class='modal-footer pl25 pr25'] [class='btn btn-primary']";
    private static final String SEARCH_RESOURCES_OPTION = "[href*='/search?keywords=']";

    private static final String COLLECTION_ACTIONS_DROPDOWN = "[class*='collection-actions']";
    private static final String PLAY_COLLECTION_OPTION = "[href*='/player']";
    private static final String ASSIGN_COLLECTION_OPTION = "[href*='/assign_modal']";
    private static final String COPY_THIS_COLLECTION_OPTION = "#js-copy-collection-btn";
    private static final String CREATE_COPY_BUTTON = "[class*='btn btn-default btn-primary']";
    private static final String NAME_INPUT =  "#copy-collection-title";

    private static final String COLLECTION_ITEMS = "[class='collection-item-panel panel']";
    private static final String COLLECTION_ITEMS_COUNT = "[class='js-items-count']";
    private static final String COLLECTION_ITEM_TITLE = "[class*='collection-item-title']";
    private static final String ALERT_NOTIFICATION = "[class='flash-messages-container']";
    private static final String ELLIPSIS_ACTIONS = "[class='show-actions']";
    private static final String EDIT_PAGE_OPTION = "[class*='collection-item-action-popover'] ul li:nth-child(1)";
    private static final String EDIT_PAGE_SAVE_BUTTON = "#edit_collection_item [class*='btn-primary']";
    private static final String HIDE_FROM_PLAYER_OPTION = "[class*='collection-item-action-popover'] ul li:nth-child(2)";
    private static final String HIDE_FROM_PLAYER_ICON = "[class*='lp-play-disabled']";
    private static final String TEACHER_NOTE_OPTION = "[class*='collection-item-action-popover'] ul li:nth-child(3)";
    private static final String TEACHER_NOTE_INPUT = "[name='collection_item[note]']";
    private static final String DELETE_OPTION = "[class*='collection-item-action-popover'] ul li:nth-child(4)";
    private static final String DELETE_ITEM_BUTTON = "[class='modal-footer'] a";

    public EditCollection(WebDriver driver) {
        super(driver);
    }

    public String getEditCollectionTitle() {
        return super.getTextForElement(EDIT_COLLECTION_TITLE);
    }

    public void clickOnMyResourcesButton() {
        clickElement(MY_RESOURCES_BUTTON);
    }

    public void clickCollectionActionsDropdown() {
        scrollToElement(COLLECTION_ACTIONS_DROPDOWN);
        clickElement(COLLECTION_ACTIONS_DROPDOWN);
    }

    public boolean isPlayCollectionOptionDisplayed() {
        return isElementDisplayed(PLAY_COLLECTION_OPTION);
    }

    public boolean isAssignCollectionOptionDisplayed() {
        return isElementDisplayed(ASSIGN_COLLECTION_OPTION);
    }

    public boolean isCopyCollectionOptionDisplayed() {
        return isElementDisplayed(COPY_THIS_COLLECTION_OPTION);
    }

    public void clickPlayCollectionOption() {
        clickElement(PLAY_COLLECTION_OPTION);
    }

    public void clickAssignCollectionOption() {
        clickElement(ASSIGN_COLLECTION_OPTION);
    }

    public void clickCopyCollectionOption() {
        clickElement(COPY_THIS_COLLECTION_OPTION);
    }

    public void clickOnCreateCopyButton() {
        clickElement(CREATE_COPY_BUTTON);
    }

    public int getCollectionItemsCount() {
        String rawNumber = getTextForElement(COLLECTION_ITEMS_COUNT);
        int number;
        try {
            number = NumberFormat.getNumberInstance(TestData.LOCALE).parse(rawNumber).intValue();
        } catch (ParseException e) {
            throw new Error("The number " + rawNumber + " cannot be parsed");
        }
        return number;
    }

    public String getCollectionItemTitle(int index) {
        return findElements(COLLECTION_ITEM_TITLE).get(index).getText();
    }

    public void clickAddToCollectionButton() {
        clickElement(ADD_TO_COLLECTION_BUTTON);
    }

    public void waitUntilNewlyCreatedCollectionIsActive(String collectionTitle) {
        waitUntilTextIsDisplayed(ACTIVE_COLLECTION_MY_COLLECTION_HEADER, collectionTitle);
    }

    public void typeTitle(String title) {
        sendKeys(COLLECTION_TITLE_INPUT, title);
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

    public void clickOnPublishCollection() {
        clickElement(ENABLED_PUBLISH_COLLECTION_BUTTON);
    }

    public void hoverOverDisabledPublishCollectionButton() {
        hoverOverElement(DISABLED_PUBLISH_COLLECTION_BUTTON);
    }

    public String getDisabledPublishCollectionPopoverText() {
        return getElementAttribute(DISABLED_PUBLISH_COLLECTION_BUTTON, "data-content", 0);
    }

    public void waitUntilPublishCollectionButtonIsEnabled() {
        waitUntilElementIsDisplayed(findElement(ENABLED_PUBLISH_COLLECTION_BUTTON));
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

    public void clickMyCollectionDropdown() {
        clickElement(MY_COLLECTION_DROPDOWN);
    }

    public boolean isCreateNewCollectionButtonDisplayed() {
        return isElementDisplayed(CREATE_NEW_COLLECTION_BUTTON);
    }

    public String getActiveCollectionFromMyCollectionDropdown() {
        return getTextForElement(ACTIVE_COLLECTION_MY_COLLECTION_DROPDOWN);
    }

    public String getActiveCollectionFromMyCollectionHeader() {
        return getTextForElement(ACTIVE_COLLECTION_MY_COLLECTION_HEADER);
    }

    public void clickCreateNewCollectionButton() {
        clickElement(CREATE_NEW_COLLECTION_BUTTON);
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

    public void waitUntilAddSelectedToCollectionButtonIsDisplayed() {
        waitUntilElementIsDisplayed(findElement(ADD_SELECTED_TO_COLLECTION_BUTTON));
    }

    public void clickOnPixabayImage(int position) {
        findElements(PIXABAY_IMAGES).get(position).click();
    }

    public void clickAddSelectedToCollectionButton() {
        clickElement(ADD_SELECTED_TO_COLLECTION_BUTTON);
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

    public void waitUntilItemIsAddedIntoCollection() {
        waitUntilElementIsDisplayed(findElements(COLLECTION_ITEMS).get(0));
    }

    public void waitUntilNameFieldIsDisplayed() {
        waitUntilElementIsDisplayed(findElement(ADD_A_LINK_NAME_FIELD));
    }

    public void typeUrlName(String name){
        clearText(ADD_A_LINK_NAME_FIELD);
        sendKeys(ADD_A_LINK_NAME_FIELD, name);
    }

    public void typeName(String name) {
        clearText(NAME_INPUT);
        sendKeys(NAME_INPUT, name);
    }
}
