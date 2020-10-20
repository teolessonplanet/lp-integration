package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CollectionBuilderPage extends LpUiBasePage {

    private static final String CREATE_OR_OPEN_DROPDOWN = "[class*='cb-panel'] [class*='dropdown']";
    private static final String CREATE_NEW_COLLECTION_OPTION = "[href='javascript:void(0)']";
    private static final String FOLDERS_OPTIONS = "[class*='cb-dropdown'] li[class='list-option']";

    private static final String COLLECTION_DROPPABLE_ZONE = "#droppable";
    private static final String GET_STARTED_TEXT = "#not-droppable [class='text']";
    private static final String DRAG_AND_DROP_TEXT = "#droppable [class*='new-empty-collection']";

    private static final String MY_RESOURCES_BUTTON = "#collection-builder-area-inner #collection-builder-button";
    private static final String EDIT_FOLDER_BUTTON = "[class*='cb-actions'] [class*='btn-primary']";

    private static final String SIGN_IN_POPUP = "[class='bold']";
    private static final String SIGN_UP_POPUP = "[class='bold text-danger']";

    private static final String UPLOAD_BUTTON = "div[class*='upload'] [class*='fa-upload']";

    private static final String ADD_A_LINK_BUTON = "[class*='add-link']";
    private static final String URL_FIELD = "[name='collection_item[url]']";
    private static final String NAME_FIELD = "[name='collection_item[title]']";
    private static final String ADD_TO_FOLDER_BUTTON = "#js-create-item [class='modal-footer'] [class*='btn-warning']";

    private static final String COLLECTION_BUILDER_VIDEO = "[class*='fa-play-circle-o']";
    private static final String COLLECTION_BUILDER_ITEMS = "#collection-items-list [class*='cb-item panel']";
    private static final String COLLECTION_BUILDER_ITEM_TITLE = "#collection-items-list [class*='cb-item panel panel'] [class='cb-item-info text-primary']";
    private static final String COLLECTION_BUILDER_ITEM_X_BUTTON = "#collection-items-list [class='cb-remove-item']";
    private static final String COLLECTION_BUILDER_ALERT_TEXT = "[class='contents'] [class*='alert alert-danger']";

    private static final String LOADING_ICON = "[class*='cb-item panel'] [class*='panel-body'] [class*='spinner'] i";

    public CollectionBuilderPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnDropdown() {
        clickElement(CREATE_OR_OPEN_DROPDOWN);
    }

    public void clickOnCreateNewCollection() {
        clickElement(CREATE_NEW_COLLECTION_OPTION);
    }

    public WebElement getCollectionDroppableZone() {
        return findElement(COLLECTION_DROPPABLE_ZONE);
    }

    public void clickOnMyResources() {
        clickElement(MY_RESOURCES_BUTTON);
    }

    public void clickOnEditFolder(boolean inANewTab) {
        openInANewTabOrClick(EDIT_FOLDER_BUTTON, inANewTab);
    }

    public boolean isSignInPopupLinkDisplayed() {
        return isElementClickable(SIGN_IN_POPUP);
    }

    public boolean isSignUpPopupLinkDisplayed() {
        return isElementClickable(SIGN_UP_POPUP);
    }

    public void clickUploadButton() {
        clickElement(UPLOAD_BUTTON);
    }

    public void clickAddALinkButton() {
        clickElement(ADD_A_LINK_BUTON);
    }

    public boolean isMyResourcesButtonDisplayed() {
        return isElementDisplayed(MY_RESOURCES_BUTTON);
    }

    public boolean isMyCollectionDropdownDisplayed() {
        return isElementDisplayed(CREATE_OR_OPEN_DROPDOWN);
    }

    public boolean isEditFolderButtonDisplayed() {
        return isElementDisplayed(EDIT_FOLDER_BUTTON);
    }

    public boolean isCollectionVideoBannerDisplayed() {
        return isElementDisplayed(COLLECTION_BUILDER_VIDEO);
    }

    public void clickOnCollectionBuilderVideoBanner() {
        clickElement(COLLECTION_BUILDER_VIDEO);
    }

    public boolean isUploadButtonDisplayed() {
        return isElementDisplayed(UPLOAD_BUTTON);
    }

    public boolean isAddALinkButtonDisplayed() {
        return isElementDisplayed(ADD_A_LINK_BUTON);
    }

    public String getCollectionBuilderItemTitle(int position) {
        return getTextForElement(COLLECTION_BUILDER_ITEM_TITLE, position);
    }

    public void hoverOverCollectionBuilderItem(int position) {
        hoverOverElement(COLLECTION_BUILDER_ITEMS, true, position);
    }

    public void clickOnXButton(int position) {
        clickElement(COLLECTION_BUILDER_ITEM_X_BUTTON, position);
    }

    public void clickOnCollectionBuilderItem(int position) {
        clickElement(COLLECTION_BUILDER_ITEMS, position);
    }

    public void openResourceInANewTab(int position) {
        openInANewTab(COLLECTION_BUILDER_ITEMS + ' ' + 'a', position);
    }

    public int getCollectionBuilderItemsNumber() {
        final List<WebElement> collectionBuilderItems = findElements(COLLECTION_BUILDER_ITEMS);
        return collectionBuilderItems.size();
    }

    public String getCollectionBuilderAlertText() {
        return getTextForElement(COLLECTION_BUILDER_ALERT_TEXT);
    }

    public void clickAddToFolderButton() {
        clickElement(ADD_TO_FOLDER_BUTTON);
    }

    public void typeUrl(String Url) {
        clearText(URL_FIELD);
        sendKeys(URL_FIELD, Url);
    }

    public void typeName(String name) {
        clearText(NAME_FIELD);
        sendKeys(NAME_FIELD, name);
    }

    public void waitForLoadingIconToDisappear() {
        waitUntilElementIsHidden(LOADING_ICON);
    }

    public boolean isCollectionBuilderDisplayed() {
        return isElementDisplayed(COLLECTION_DROPPABLE_ZONE);
    }

    public String getCreateOrOpenDropdownText() {
        return getTextForElement(CREATE_OR_OPEN_DROPDOWN);
    }

    public int getNumberOfItemsInCollection() {
        return Integer.parseInt(getTextForElement(CREATE_OR_OPEN_DROPDOWN).replaceAll("\\D+", ""));
    }

    public boolean isGetStartedTextDisplayed() {
        return isElementDisplayed(GET_STARTED_TEXT);
    }

    public WebElement getGetStartedNonDroppableArea() {
        return findElement(GET_STARTED_TEXT);
    }

    public void clickOnFolderFromDropdown(int position) {
        clickElement(findElements(FOLDERS_OPTIONS).get(position));
    }

    public String getDragAndDropText() {
        return getTextForElement(DRAG_AND_DROP_TEXT);
    }
}
