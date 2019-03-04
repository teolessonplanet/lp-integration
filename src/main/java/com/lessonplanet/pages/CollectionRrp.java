package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;
import java.text.NumberFormat;
import java.text.ParseException;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CollectionRrp extends LpUiBasePage {

    private static final String COLLECTION_TITLE_TEXT = "div h1";
    private static final String SAVE_COLLECTION_BUTTON = "span[class='save-collection-btn'] button[type='submit']";
    private static final String ITEMS_COUNT = "[class='rrp-items-count']";
    private static final String COLLECTION_RRP_DETAILS = "div.shared_collection [class*='panel-default panel-review']";
    private static final String JOIN_FOR_FULL_REVIEW_BUTTON = "a[href='/subscription/new']";
    private static final String SHARE_BUTTON = "[class='btn btn-default hidden-xs dropdown-toggle']";
    private static final String LIMITED_ACCESS_REVIEW = "[class='rrp-banner'] [src*='limited-access']";
    private static final String DESCRIPTION = "div.shared_collection div[class*='rrp-details panel-body'] div.row:nth-child(2) p:nth-child(1)";
    private static final String GRADES = "div.shared_collection span[class*='detail-grades'][title='Grades']";
    private static final String SUBJECTS = "div.shared_collection span[title='Subject']";
    private static final String NUMBER_OF_VIEWS = "[class='col-xs-9 col-sm-10']" + " div.resource-details.small span:nth-child(3)";
    private static final String NUMBER_OF_DOWNLOADS = "[class='col-xs-9 col-sm-10']" + " div.resource-details.small span:last-child";
    private static final String CONCEPTS_TAGS_LIST = "[class='col-sm-11 details-list concepts']";
    private static final String NEXT_BUTTON_RRP = "div.shared_collection div.panel-footer a[data-transition='right']";
    private static final String PREVIOUS_BUTTON_RRP = "div.shared_collection div.panel-footer a[data-transition='left']";
    private static final String SEARCH_RESULTS_POSITION_TEXT = "[class='lead lead-md mb0 text-center']";
    private static final String RETURN_TO_SEARCH_RESULTS_LINK = "[class='link-as-text']";
    private static final String PANEL_ITEMS_LIST = "[class='panel-items'] [class='item-list'] li";
    private static final String PANEL_ITEM = "[class='panel-items'] ul[class='item-list'] li.shared-collection-item a.item-rrp-link[data-type='resource']";
    private static final String NEXT_BUTTON_PANEL_ITEMS = "[class='panel-items'] a[class='bx-next']";
    private static final String PREVIOUS_BUTTON_PANEL_ITEMS = "[class='panel-items'] a[class='bx-prev']";
    private static final String SEE_FULL_REVIEWS_LINK = "[class='see-full-reviews-link'] h4";
    private static final String EXPANDED_RRP = "[class='expanded-item-rrps'] ul[class='rrp-list'] li[data-type='resource']";
    private static final String NEXT_BUTTON_ITEM_VIEWER = "[class='expanded-item-rrps'] a[class='bx-next']";
    private static final String PREVIOUS_BUTTON_ITEM_VIEWER = "[class='expanded-item-rrps'] a[class='bx-prev']";
    private static final String X_BUTTON_EXPANDED_RRP = "[class='expanded-item-rrps'] [class*='close-item-rrp-view text-muted']";

    protected CollectionRrp(WebDriver driver){
        super(driver);
    }

    public boolean isCollectionTitleDisplayed() {
        return isElementClickable(COLLECTION_TITLE_TEXT);
    }

    public boolean isSaveCollectionButtonDisplayed() {
        return isElementClickable(SAVE_COLLECTION_BUTTON);
    }

    public void clickSaveCollectionButton() {
        clickElement(SAVE_COLLECTION_BUTTON);
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

    public boolean isCollectionRrpDetailsDisplayed(){
        return isElementDisplayed(COLLECTION_RRP_DETAILS);
    }

    public boolean isJoinForFullReviewButtonDisplayed(){
        return isElementDisplayed(JOIN_FOR_FULL_REVIEW_BUTTON);
    }

    public boolean isLimitedAccessReviewDisplayed() {
        return isElementDisplayed(LIMITED_ACCESS_REVIEW);
    }

    public boolean isShareButtonDisplayed(){
        return isElementDisplayed(SHARE_BUTTON);
    }

    public boolean isDescriptionDisplayed(){
        return isElementDisplayed(DESCRIPTION);
    }

    public boolean isNumberOfDownloadsDisplayed(){
        return isElementDisplayed(NUMBER_OF_DOWNLOADS);
    }

    public boolean isGradeDisplayed(){
        return isElementDisplayed(GRADES);
    }

    public boolean isSubjectDisplayed(){
        return isElementDisplayed(SUBJECTS);
    }

    public boolean isConceptsTagsListDisplayed(){
        return isElementDisplayed(CONCEPTS_TAGS_LIST);
    }

    public boolean isNumberOfViewsDisplayed(){
        return isElementDisplayed(NUMBER_OF_VIEWS);
    }

    public boolean isCollectionItemsCountDisplayed(){
        return isElementDisplayed(ITEMS_COUNT);
    }

    public int getPanelItemsCount() {
        final List<WebElement> panelItems = findElements(PANEL_ITEMS_LIST);
        return panelItems.size();
    }

    public String getPanelItemDataId(int position){
        return getElementDataId(PANEL_ITEM,"data-id", position);
    }

    public boolean isPreviousButtonRrpDisplayed(){
        return isElementDisplayed(PREVIOUS_BUTTON_RRP);
    }

    public boolean isNextButtonRrpDisplayed(){
        return isElementDisplayed(NEXT_BUTTON_RRP);
    }

    public boolean isSearchResultsPositionDisplayed(){
        return isElementDisplayed(SEARCH_RESULTS_POSITION_TEXT);
    }

    public boolean isReturnToSearchResultsLinkDisplayed(){
        return isElementDisplayed(RETURN_TO_SEARCH_RESULTS_LINK);
    }

    public boolean isPreviousButtonPanelItemsDisplayed(){
        return isElementDisplayed(PREVIOUS_BUTTON_PANEL_ITEMS);
    }

    public boolean isNextButtonPanelItemsDisplayed(){
        return isElementDisplayed(NEXT_BUTTON_PANEL_ITEMS);
    }

    public void clickNextButtonPanelItems(){
        clickElement(NEXT_BUTTON_PANEL_ITEMS);
    }

    public boolean isSeeFullReviewsLinkVisible(){
        return isElementVisible(SEE_FULL_REVIEWS_LINK);
    }

    public void clickSeeFullReviewsLink(){
        clickElement(SEE_FULL_REVIEWS_LINK);
    }

    public boolean isNextButtonItemViewerDisplayed(){
        return isElementDisplayed(NEXT_BUTTON_ITEM_VIEWER);
    }

    public boolean isPreviousButtonItemViewerDisplayed(){
        return isElementDisplayed(PREVIOUS_BUTTON_ITEM_VIEWER);
    }

    public void clickCloseExpandedRrp(){
        clickElement(X_BUTTON_EXPANDED_RRP);
    }

    public String getExpandedRrpDataId(int position) {
        return getElementDataId(EXPANDED_RRP, "data-id", position);
    }
}
