package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

import java.util.List;

public class CollectionBuilderPage extends LpUiBasePage {

    private static final String CREATE_OR_OPEN_DROPDOWN = "[class*='cb-panel'] [class*='dropdown']";
    private static final String CREATE_NEW_COLLECTION_OPTION = "[class*='create-new-collection']";
    private static final String FOLDERS_OPTIONS = "[class*='cb-dropdown'] li[class='list-option']";

    private static final String COLLECTION_DROPPABLE_ZONE = "#droppable";
    private static final String GET_STARTED_TEXT = "#not-droppable [class='text']";
    private static final String DRAG_AND_DROP_TEXT = "#droppable [class*='new-empty-collection']";

    private static final String MY_RESOURCES_BUTTON = "#collection-builder-area-inner #collection-builder-button";
    private static final String EDIT_FOLDER_BUTTON = "[class='cb-action-button edit']";

    private static final String MY_RESOURCES_SIGN_IN_POPUP = "[class*='visitor-popover js-cm-btn-popover'] [class='bold']";
    private static final String MY_RESOURCES_SIGN_UP_POPUP = "[class*='visitor-popover js-cm-btn-popover'] [class='bold text-danger']";

    private static final String SIGN_IN_POPUP = "[class='bold']";
    private static final String SIGN_UP_POPUP = "[class='bold text-danger']";

    private static final String COLLECTION_BUILDER_VIDEO = "[class*='fa-play-circle-o']";
    private static final String COLLECTION_BUILDER_ITEMS = "#collection-items-list [class^='cb-item panel panel-default clickable clearfix']";
    private static final String COLLECTION_BUILDER_ITEM_TITLE = "#collection-items-list [class*='cb-item panel'] [class='cb-item-info text-primary']";
    private static final String COLLECTION_BUILDER_ITEM_X_BUTTON = "#collection-items-list [class='cb-remove-item']";
    private static final String COLLECTION_BUILDER_ALERT_TEXT = "[class='contents'] [class*='alert alert-danger']";

    private static final String LOADING_ICON = "[class*='cb-item panel'] [class*='panel-body'] [class*='spinner'] i";

    private static final String SHARED_FOLDER_COLLECTION_BUILDER = "[class*='cb-dropdown'] li[class='list-option']:last-child";

    public CollectionBuilderPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnDropdown() {
        scrollToElement(CREATE_OR_OPEN_DROPDOWN);
        clickElement(CREATE_OR_OPEN_DROPDOWN);
    }

    public void clickOnCreateNewCollection() {
        clickElement(CREATE_NEW_COLLECTION_OPTION);
    }

    public WebElement getCollectionDroppableZone() {
        return findElement(COLLECTION_DROPPABLE_ZONE);
    }

    public void clickOnMyResources() {
        scrollToElement(MY_RESOURCES_BUTTON);
        clickElement(MY_RESOURCES_BUTTON);
    }

    public void clickOnEditFolder(boolean inANewTab) {
        scrollToElement(EDIT_FOLDER_BUTTON);
        openInANewTabOrClick(EDIT_FOLDER_BUTTON, inANewTab);
    }

    public boolean isSignInPopupLinkDisplayed() {
        return isElementClickable(SIGN_IN_POPUP);
    }

    public boolean isMyResourcesButtonSignInPopupLinkDisplayed() {
        return isElementClickable(MY_RESOURCES_SIGN_IN_POPUP);
    }

    public boolean isMyResourcesButtonSignUpPopupLinkDisplayed() {
        return isElementClickable(MY_RESOURCES_SIGN_UP_POPUP);
    }

    public boolean isSignUpPopupLinkDisplayed() {
        return isElementClickable(SIGN_UP_POPUP);
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
        String[] noOfItems = getTextForElement(CREATE_OR_OPEN_DROPDOWN).split("\n");
        return Integer.parseInt(noOfItems[1].replaceAll("\\D+", ""));
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

    public void waitUntilGetStartedTextIsDisplayed() {
        waitUntilTextIsDisplayed(GET_STARTED_TEXT, TestData.COLLECTION_BUILDER_EMPTY_TEXT);
    }

    public void clickOnSharedFolderFromCollectionBuilder() {
        clickElement(SHARED_FOLDER_COLLECTION_BUILDER);
    }
}
