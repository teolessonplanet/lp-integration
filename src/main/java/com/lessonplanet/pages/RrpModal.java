package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class RrpModal extends Rrp {
    private static final String RRP_MODAL = "#resource-modal";
    private static final String CLOSE_MODAL_BUTTON = "[class*='resource-modal-close']";
    private static final String FAVORITE_BUTTON = "[class='btn btn-default mb0 js-new-user-resource trk-save-resource']";
    private static final String ADD_TO_COLLECTION_DROPDOWN = "[class='hidden-xs hidden-sm']";
    private static final String EXISTING_COLLECTION = "[class*='create_collection_item clearfix']";
    private static final String NOTIFICATION_TEXT = "[class*='alert-success alert-dismissible mb0']";
    private static final String VIEW_FAVORITE_RESOURCE_LINK = "[class='alert alert-success alert-dismissible mb0'] a[href='/my/curriculum_manager']";

    public RrpModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(RRP_MODAL);
    }

    public void clickCloseModal() {
        clickElement(CLOSE_MODAL_BUTTON);
    }

    public boolean isTitleDisplayed() {
        waitForModal();
        return super.isTitleDisplayed();
    }

    public void clickOnFavoriteButton() {
        clickElement(FAVORITE_BUTTON);
    }

    public void clickOnViewFavoritesLink() {
        clickElement(VIEW_FAVORITE_RESOURCE_LINK);
    }

    public String getNotificationText() {
        return findElement(NOTIFICATION_TEXT).getText();
    }

    public void clickOnAddToCollectionDropdown() {
        clickElement(ADD_TO_COLLECTION_DROPDOWN);
    }

    public void chooseACollectionFromAddToCollectionDropdown() {
        clickElement(EXISTING_COLLECTION);
    }
}
