package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

import java.text.NumberFormat;
import java.text.ParseException;

import org.openqa.selenium.WebElement;

import java.util.List;

public class CollectionRrp extends Rrp {

    private static final String COLLECTION_TITLE_TEXT = "[class*='panel-default panel-review'] div h1";
    private static final String SAVE_COLLECTION_BUTTON = "[class*='panel-default panel-review'] span[class='save-collection-btn']";
    private static final String SAVE_COLLECTION_BUTTON_ACTIVE_USER = "[class*='panel-default panel-review'] [class='save-collection-btn'] [action*='/remix_collection']";
    private static final String SAVED_COLLECTION_BUTTON = "[class='save-collection-btn'] div[disabled='disabled']";
    private static final String ITEMS_COUNT = "[class='rrp-items-count']";
    private static final String SHARE_BUTTON = "[class='top-buttons'] button[class*='rrp-share-resource']";
    private static final String LIMITED_ACCESS_REVIEW = "[class='rrp-banner'] [src*='limited-access']";
    private static final String DESCRIPTION = "div.shared_collection div[class*='rrp-details panel-body'] div.row:nth-child(2) p:nth-child(1)";
    private static final String GRADES = "div.shared_collection span[class*='detail-grades'][title='Grades']";
    private static final String SUBJECTS = "div.shared_collection span[title='Subject']";
    private static final String NUMBER_OF_VIEWS = "[class='col-xs-9 col-sm-10']" + " div.resource-details.small span:nth-child(3)";
    private static final String NUMBER_OF_DOWNLOADS = "[class='col-xs-9 col-sm-10']" + " div.resource-details.small span:last-child";
    private static final String CONCEPTS_TAGS_LIST = "[class='col-sm-11 details-list concepts']";
    private static final String NEXT_BUTTON_RRP = "div.shared_collection div.panel-footer a[data-transition='right']";
    private static final String PREVIOUS_BUTTON_RRP = "[class*='panel-default panel-review'] div.panel-footer a[data-transition='left']";
    private static final String PANEL_ITEMS_LIST = "[class='panel-items'] [class='item-list'] li";
    private static final String PANEL_ITEM = "[class='panel-items'] ul[class='item-list'] li.panel.shared-collection-item div.panel-flip .item-rrp-link";
    private static final String NEXT_BUTTON_PANEL_ITEMS = "[class='panel-items'] a[class='bx-next']";
    private static final String PREVIOUS_BUTTON_PANEL_ITEMS = "[class='panel-items'] a[class='bx-prev']";
    private static final String SEE_FULL_REVIEWS_LINK = "[class='see-full-reviews-link'] h4";
    private static final String EXPANDED_RRP = "[class='rrp-list'] li[class='rrp-content']";
    private static final String NEXT_BUTTON_ITEM_VIEWER = "[class='expanded-item-rrps'] a[class='bx-next']";
    private static final String PREVIOUS_BUTTON_ITEM_VIEWER = "[class='expanded-item-rrps'] a[class='bx-prev']";
    private static final String X_BUTTON_EXPANDED_RRP = "[class='expanded-item-rrps'] [class*='close-item-rrp-view text-muted']";
    private static final String SIGN_IN_POPUP = "[class='bold']";
    private static final String JOIN_NOW_POPUP = "[class='bold text-danger']";
    private static final String SAVED_COLLECTION_NOTIFICATION = "[class='alert alert-success alert-dismissible mb0']";
    private static final String COLLECTION_UPGRADE_FOR_FULL_REVIEW_BUTTON = "[class*='panel-default panel-review'] [class*='join-btn']";
    private static final String PLAY_COLLECTION_BUTTON = "[class*='panel-default panel-review'] [class='play-collection-btn']";

    protected CollectionRrp(WebDriver driver) {
        super(driver);
    }

    public boolean isCollectionTitleDisplayed() {
        return isElementClickable(COLLECTION_TITLE_TEXT);
    }

    public boolean isSaveCollectionButtonDisplayed() {
        return isElementClickable(SAVE_COLLECTION_BUTTON);
    }

    public boolean isSavedCollectionButtonDisabled() {
        return isElementDisplayed(SAVED_COLLECTION_BUTTON);
    }

    public void clickSaveCollectionButton() {
        clickElement(SAVE_COLLECTION_BUTTON);
    }

    public void clickSaveCollectionButtonActiveUser() {
        clickElement(SAVE_COLLECTION_BUTTON_ACTIVE_USER);
    }

    public int getCollectionItemsCount() {
        String rawNumber = getTextForElement(ITEMS_COUNT);
        int number;
        try {
            number = NumberFormat.getNumberInstance(TestData.LOCALE).parse(rawNumber).intValue();
        } catch (ParseException e) {
            throw new Error("The number " + rawNumber + " cannot be parsed");
        }
        return number;
    }

    public boolean isGetFreeAccessForTenDaysButtonDisplayed() {
        return isElementDisplayed(GET_FREE_ACCESS_FOR_TEN_DAYS_BUTTON);
    }

    public boolean isLimitedAccessReviewDisplayed() {
        return isElementDisplayed(LIMITED_ACCESS_REVIEW);
    }

    public boolean isShareButtonDisplayed() {
        return isElementDisplayed(SHARE_BUTTON);
    }

    public boolean isDescriptionDisplayed() {
        return isElementDisplayed(DESCRIPTION);
    }

    public boolean isNumberOfDownloadsDisplayed() {
        return isElementDisplayed(NUMBER_OF_DOWNLOADS);
    }

    public boolean isGradeDisplayed() {
        return isElementDisplayed(GRADES);
    }

    public boolean isSubjectDisplayed() {
        return isElementDisplayed(SUBJECTS);
    }

    public boolean isConceptsTagsListDisplayed() {
        return isElementDisplayed(CONCEPTS_TAGS_LIST);
    }

    public boolean isNumberOfViewsDisplayed() {
        return isElementDisplayed(NUMBER_OF_VIEWS);
    }

    public boolean isCollectionItemsCountDisplayed() {
        return isElementDisplayed(ITEMS_COUNT);
    }

    public int getPanelItemsCount() {
        final List<WebElement> panelItems = findElements(PANEL_ITEMS_LIST);
        return panelItems.size();
    }

    public String getPanelItemDataId(int position) {
        return getElementAttribute(PANEL_ITEM, "data-id", position);
    }

    public boolean isPreviousButtonPanelItemsDisplayed() {
        return isElementDisplayed(PREVIOUS_BUTTON_PANEL_ITEMS);
    }

    public boolean isNextButtonPanelItemsDisplayed() {
        return isElementDisplayed(NEXT_BUTTON_PANEL_ITEMS);
    }

    public void clickNextButtonPanelItems() {
        clickElement(NEXT_BUTTON_PANEL_ITEMS);
    }

    public boolean isSeeFullReviewsLinkVisible() {
        return isElementVisible(SEE_FULL_REVIEWS_LINK);
    }

    public void clickSeeFullReviewsLink() {
        clickElement(SEE_FULL_REVIEWS_LINK);
    }

    public boolean isNextButtonItemViewerDisplayed() {
        return isElementDisplayed(NEXT_BUTTON_ITEM_VIEWER);
    }

    public boolean isPreviousButtonItemViewerDisplayed() {
        return isElementDisplayed(PREVIOUS_BUTTON_ITEM_VIEWER);
    }

    public void clickCloseExpandedRrp() {
        clickElement(X_BUTTON_EXPANDED_RRP);
    }

    public String getExpandedRrpDataId(int position) {
        return getElementAttribute(EXPANDED_RRP, "data-id", position);
    }

    public void clickGetFreeAccessForTenDaysButton(boolean inANewTab) {
        openInANewTabOrClick(GET_FREE_ACCESS_FOR_TEN_DAYS_BUTTON, inANewTab);
    }

    public boolean isSignInPopupLinkDisplayed() {
        return isElementDisplayed(SIGN_IN_POPUP);
    }

    public void clickSignInPopupLink(boolean inANewTab) {
        openInANewTabOrClick(SIGN_IN_POPUP, inANewTab);
    }

    public boolean isJoinNowPopupLinkDisplayed() {
        return isElementDisplayed(JOIN_NOW_POPUP);
    }

    public void clickJoinNowPopupLink() {
        clickElement(JOIN_NOW_POPUP);
    }

    public String getCollectionTitleText() {
        return getTextForElement(COLLECTION_TITLE_TEXT);
    }

    public void clickNextButtonItemViewer() {
        clickElement(NEXT_BUTTON_ITEM_VIEWER);
    }

    public void clickPreviousButtonItemViewer() {
        clickElement(PREVIOUS_BUTTON_ITEM_VIEWER);
    }

    public void clickPanelItem(int position) {
        clickElement(PANEL_ITEMS_LIST, position);
    }

    public void clickNextButtonRrp() {
        clickElement(NEXT_BUTTON_RRP);
    }

    public void clickPreviousButtonRrp() {
        clickElement(PREVIOUS_BUTTON_RRP);
    }

    public boolean isSaveCollectionButtonActiveUserDisplayed() {
        return isElementClickable(SAVE_COLLECTION_BUTTON_ACTIVE_USER);
    }

    public boolean isSavedCollectionNotificationDisplayed() {
        return isElementDisplayed(SAVED_COLLECTION_NOTIFICATION);
    }

    public boolean isUpgradeForFullReviewButtonDisplayed() {
        return isElementDisplayed(COLLECTION_UPGRADE_FOR_FULL_REVIEW_BUTTON);
    }

    public void clickCollectionUpgradeForFullReviewButton(boolean inANewTab) {
        openInANewTabOrClick(COLLECTION_UPGRADE_FOR_FULL_REVIEW_BUTTON, inANewTab);
    }

    public boolean isPlayCollectionButtonDisplayed() {
        return isElementDisplayed(PLAY_COLLECTION_BUTTON);
    }

    public void clickPlayCollectionButton() {
        clickElement(PLAY_COLLECTION_BUTTON);
    }
}
