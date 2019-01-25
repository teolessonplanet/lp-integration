package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CollectionBuilderPage extends LpUiBasePage {

    private static final String CREATE_OR_OPEN_DROPDOWN = "[class*='cb-panel'] [class='dropdown']";
    private static final String CREATE_NEW_COLLECTION_OPTION = "[href='javascript:void(0)']";

    private static final String COLLECTION_DROPPABLE_ZONE = "#droppable";

    private static final String MY_RESOURCES_BUTTON = "#collection-builder-area-inner #collection-builder-button";
    private static final String EDIT_COLLECTION_BUTTON = "[class*='cb-actions'] [class*='btn-primary']";

    private static final String SIGN_IN_POPUP = "[class='bold']";
    private static final String SIGN_UP_POPUP = "[class='bold text-danger']";

    private static final String UPLOAD_BUTTON = "[class='fa fa-upload']";

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

    public void clickOnUploadButton(){
        clickElement(UPLOAD_BUTTON);
    }
}
