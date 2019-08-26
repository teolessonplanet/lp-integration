package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CollectionBuilderPage extends LpUiBasePage {

    private static final String CREATE_OR_OPEN_DROPDOWN = "[class*='cb-panel'] [class='dropdown']";
    private static final String CREATE_NEW_COLLECTION_OPTION = "[href='javascript:void(0)']";

    private static final String COLLECTION_DROPPABLE_ZONE = "#droppable";

    private static final String MY_RESOURCES_BUTTON = "#collection-builder-area-inner #collection-builder-button";
    private static final String EDIT_COLLECTION_BUTTON = "[class*='cb-actions'] [class*='btn-primary']";

    private static final String SIGN_IN_POPUP = "[class='bold']";
    private static final String SIGN_UP_POPUP = "[class='bold text-danger']";

    private static final String UPLOAD_BUTTON = "div[class*='upload'] [class*='fa-upload']";

    private static final String ADD_A_LINK_BUTON = "[class*='add-link']";
    private static final String COLLECTION_BUILDER_VIDEO = "[class*='fa-play-circle-o']";
    private static final String COLLECTION_BUILDER_ITEMS = "#collection-items-list [class*='cb-item panel']";
    private static final String COLLECTION_BUILDER_ITEM_TITLE = "#collection-items-list [class*='cb-item panel panel'] [class='cb-item-info text-primary']";
    private static final String COLLECTION_BUILDER_ITEM_X_BUTTON = "#collection-items-list [class='cb-remove-item']";
    private static final String COLLECTION_BUILDER_ALERT_TEXT = "[class='contents'] [class*='alert alert-danger']";

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

    public void clickOnEditCollection() {
        clickElement(EDIT_COLLECTION_BUTTON);
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

    public boolean isEditCollectionButtonDisplayed() {
        return isElementDisplayed(EDIT_COLLECTION_BUTTON);
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
}
