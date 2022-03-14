package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CollectionBuilderPage extends LpUiBasePage {

    private static final String CREATE_OR_OPEN_DROPDOWN = "div[class^='dropdown cb-dropdown']";
    private static final String CREATE_A_NEW_FOLDER_OPTION = "[class*='cb-dropdown'] li[class='list-option create-new-collection']";
    private static final String FOLDERS_OPTIONS = "[class*='cb-dropdown'] li[class='list-option']";
    private static final String SHARED_FOLDER_CB = "[class*='cb-dropdown'] li[class='list-option']:last-child";

    private static final String COLLECTION_DROPPABLE_ZONE = "#new-builder [class*='builder-dropzone']";
    private static final String GET_STARTED_TEXT = "#not-droppable [class='text']";

    private static final String VIEW_MY_RESOURCES_BUTTON = "[class='view-manage-button']";
    private static final String EDIT_FOLDER_BUTTON = "[class='edit-folder-button']";

    private static final String VIEW_MY_RESOURCES_SIGN_IN_POPUP = "[class*='visitor-popover js-cm-btn-popover'] [class='bold']";
    private static final String VIEW_MY_RESOURCES_SIGN_UP_POPUP = "[class*='visitor-popover js-cm-btn-popover'] [class='bold text-danger']";

    private static final String SIGN_IN_POPUP = "[class='bold']";
    private static final String SIGN_UP_POPUP = "[class='bold text-danger']";
    private static final String COLLECTION_BUILDER_ITEMS = "[class='ui-droppable'] div[class^='builder-item ']";
    private static final String COLLECTION_BUILDER_ITEM_TITLE = "[class='ui-droppable'] div[class^='builder-item '] [class='builder-item-title']";
    private static final String COLLECTION_BUILDER_ITEM_X_BUTTON = "[class='ui-droppable'] div[class^='builder-item '] [class='builder-close-x']";

    private static final String ITEM_LOADER_ICON = "[class='loader']";

    public CollectionBuilderPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnDropdown() {
        scrollToElement(CREATE_OR_OPEN_DROPDOWN);
        clickElement(CREATE_OR_OPEN_DROPDOWN);
    }

    public void clickOnCreateNewFolderOption() {
        clickElement(CREATE_A_NEW_FOLDER_OPTION);
    }

    public WebElement getCollectionDroppableZone() {
        scrollToElement(COLLECTION_DROPPABLE_ZONE);
        return findElement(COLLECTION_DROPPABLE_ZONE);
    }

    public void clickOnViewMyResourcesButton() {
        scrollToElement(VIEW_MY_RESOURCES_BUTTON);
        clickElement(VIEW_MY_RESOURCES_BUTTON);
    }

    public void clickOnEditFolderButton(boolean inANewTab) {
        scrollToElement(EDIT_FOLDER_BUTTON);
        openInANewTabOrClick(EDIT_FOLDER_BUTTON, inANewTab);
    }

    public boolean isSignInPopupLinkDisplayed() {
        return isElementClickable(SIGN_IN_POPUP);
    }

    public boolean isViewMyResourcesButtonSignInPopupLinkDisplayed() {
        return isElementClickable(VIEW_MY_RESOURCES_SIGN_IN_POPUP);
    }

    public boolean isViewMyResourcesButtonSignUpPopupLinkDisplayed() {
        return isElementClickable(VIEW_MY_RESOURCES_SIGN_UP_POPUP);
    }

    public boolean isSignUpPopupLinkDisplayed() {
        return isElementClickable(SIGN_UP_POPUP);
    }

    public boolean isViewMyResourcesButtonDisplayed() {
        return isElementDisplayed(VIEW_MY_RESOURCES_BUTTON);
    }

    public boolean isMyCollectionDropdownDisplayed() {
        return isElementDisplayed(CREATE_OR_OPEN_DROPDOWN);
    }

    public boolean isEditFolderButtonDisplayed() {
        return isElementDisplayed(EDIT_FOLDER_BUTTON);
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

    public void clickOnFolderFromDropdown(int position) {
        clickElement(findElements(FOLDERS_OPTIONS).get(position));
    }

    public void clickOnSharedFolderFromCollectionBuilder() {
        clickElement(SHARED_FOLDER_CB);
    }

    public void waitUntilItemIsDisplayed() {
        waitUntilElementIsHidden(ITEM_LOADER_ICON);
    }

    public boolean isCreateANewFolderOptionDisplayed() {
        return isElementDisplayed(CREATE_A_NEW_FOLDER_OPTION);
    }
}
