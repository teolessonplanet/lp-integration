package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class Rrp extends LpUiBasePage {

    private static final String LIMITED_ACCESS_REVIEW = "[class='rrp-banner'] [src*='limited-access']";
    private static final String FULL_REVIEW = "[class='rrp-banner'] [src*='rrp-banner-fullreview']";
    private static final String FREE_SAMPLE = "[class*='rrp-banner'] [src*='/assets/rrp/lp_badge']";

    protected static final String RESOURCE_TITLE_TEXT = "[class='resource-title'] h1";

    private static final String FAVORITE_BUTTON = "[class='btn btn-default mb0 js-new-user-resource trk-save-resource']";
    private static final String VISITOR_FAVORITE_BUTTON = "[class*='favorite-join'][data-title='Get Full Access']";
    private static final String VIEW_FAVORITE_RESOURCE_LINK = "[class*='alert alert-success alert-dismissible'] a[href='/my/curriculum_manager']";
    private static final String EXISTING_COLLECTION = "[class*='create_collection_item clearfix']";
    private static final String NOTIFICATION_TEXT = "[class*='alert-success alert-dismissible mb0']";
    private static final String ADD_TO_COLLECTION_DROPDOWN = "[class='hidden-xs hidden-sm']";

    private static final String JOIN_TO_SEE_THIS_RESOURCE_BUTTON = "[class='panel panel-default panel-review new-rrp relative'] a[href='/subscription/new']";
    private static final String UPGRADE_FOR_FULL_REVIEW_BUTTON = "[class*='btn-success upgrade js-testimonial-popup trk-goto-resource']";

    private static final String SHARE_BUTTON = "[class='btn btn-default dropdown-toggle']";
    private static final String DESCRIPTION = "[class='panel-body'] [class*='js-help-rpp-description'] + p";
    private static final String THUMBNAIL = "[class*='resource-img img-thumbnail']";
    private static final String NUMBER_OF_VIEWS = "[class*='detail-views']";
    private static final String NUMBER_OF_DOWNLOADS = "[class*='detail-downloads']";
    private static final String CONCEPTS_TAGS_LIST = "[class*='concepts']";
    private static final String RATING = "[itemprop='reviewRating']";
    private static final String FULL_RRP_GRADE = "[class*='panel-review new-rrp'] [class='left-resource-details mt15'] div.row:nth-child(3) div.col-sm-12.pt5.pb5:nth-child(2) dd";
    private static final String FULL_RRP_SUBJECTS = "[class*='panel-review new-rrp'] [class='left-resource-details mt15'] div.row:nth-child(3) div.col-sm-12.pt5.pb5:nth-child(3) dd";
    private static final String FULL_RRP_RESOURCE_TYPES = "[class*='panel-review new-rrp'] [class='left-resource-details mt15'] div.row:nth-child(4) div.col-sm-12.pt5.pb5:nth-child(1) dd";
    private static final String LIGHT_RRP_GRADE = "[class*='panel-default panel-review new-rrp'] [class='panel-body'] [class='pl5 mt10'] div.row:nth-child(1) div.col-sm-4.pt10.pb5:nth-child(1) dd";
    private static final String LIGHT_RRP_SUBJECTS = "[class*='panel-default panel-review new-rrp'] div.col-sm-4.pt10.pb5:nth-child(2) dd";
    private static final String LIGHT_RRP_RESOURCE_TYPES = "[class*='panel-default panel-review new-rrp'] [class='pl5 mt10'] div.row:nth-child(1) div.col-sm-4.pt10.pb5:nth-child(3) dd";
    private static final String NEXT_BUTTON_RRP = "[class='panel-footer hidden-xs'] [class='pull-right'] a";
    private static final String PREVIOUS_BUTTON_RRP = "[class='panel-footer hidden-xs'] [class='pull-left'] a";
    private static final String SIGN_IN_POPUP = "[class='bold']";
    private static final String JOIN_NOW_POPUP = "[class='bold text-danger']";
    private static final String BLANK_LEFT_SECTION = "[class='panel-body'] [class=row] [class='col-sm-3 hidden-xs'] [class='blank-rrp-left-resource-details mt15']";

    protected Rrp(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed() {
        return isElementClickable(RESOURCE_TITLE_TEXT);
    }

    public boolean isLimitedAccessReviewDisplayed() {
        return isElementClickable(LIMITED_ACCESS_REVIEW);
    }

    public boolean isFullReviewDisplayed() {
        return isElementClickable(FULL_REVIEW);
    }

    public boolean isFreeSampleDisplayed() {
        return isElementClickable(FREE_SAMPLE);
    }

    public void clickOnViewFavoritesLink() {
        clickElement(VIEW_FAVORITE_RESOURCE_LINK);
    }

    public void clickCollectionFromAddToCollectionDropdown() {
        clickElement(EXISTING_COLLECTION);
    }

    public void clickOnFavoriteButton() {
        clickElement(FAVORITE_BUTTON);
    }

    public String getNotificationText() {
        return findElement(NOTIFICATION_TEXT).getText();
    }

    public void clickOnAddToCollectionDropdown() {
        clickElement(ADD_TO_COLLECTION_DROPDOWN);
    }

    public void clickUpgradeForFullReviewButton (boolean inANewTab){
        openInANewTabOrClick(UPGRADE_FOR_FULL_REVIEW_BUTTON, inANewTab);
    }

    public boolean isJoinToSeeThisResourceButtonDisplayed() {
        return isElementDisplayed(JOIN_TO_SEE_THIS_RESOURCE_BUTTON);
    }

    public boolean isDescriptionDisplayed() {
        return isElementDisplayed(DESCRIPTION);
    }

    public boolean isNumberOfViewsDisplayed() {
        return isElementDisplayed(NUMBER_OF_VIEWS);
    }

    public boolean isNumberOfDownloadsDisplayed() {
        return isElementDisplayed(NUMBER_OF_DOWNLOADS);
    }

    public boolean isConceptsTagsListDisplayed() {
        return isElementDisplayed(CONCEPTS_TAGS_LIST);
    }

    public boolean isReviewerRatingDisplayed() {
        return isElementDisplayed(RATING);
    }

    public String getTitleText() {
        return getTextForElement(RESOURCE_TITLE_TEXT);
    }

    public boolean isVisitorFavoriteButtonDisplayed() {
        return isElementDisplayed(VISITOR_FAVORITE_BUTTON);
    }

    public boolean isShareButtonDisplayed() {
        return isElementDisplayed(SHARE_BUTTON);
    }

    public boolean isThumbnailDisplayed() {
        return isElementDisplayed(THUMBNAIL);
    }

    public boolean isPreviousButtonDisplayed() {
        return isElementDisplayed(PREVIOUS_BUTTON_RRP);
    }

    public boolean isNextButtonDisplayed() {
        return isElementDisplayed(NEXT_BUTTON_RRP);
    }

    public boolean isLightRrpGradeDisplayed() {
        return isElementDisplayed(LIGHT_RRP_GRADE);
    }

    public boolean isFullRrpGradeDisplayed() {
        return isElementDisplayed(FULL_RRP_GRADE);
    }

    public int getFullRrpResourceTypeNumber() {
        final List<WebElement> resourceType = findElements(FULL_RRP_RESOURCE_TYPES);
        return resourceType.size();
    }

    public int getLightRrpResourceTypeNumber() {
        final List<WebElement> resourceType = findElements(LIGHT_RRP_RESOURCE_TYPES);
        return resourceType.size();
    }

    public int getLightRrpSubjectsNumber() {
        final List<WebElement> subjects = findElements(LIGHT_RRP_SUBJECTS);
        return subjects.size();
    }

    public int getFullRrpSubjectsNumber() {
        final List<WebElement> subjects = findElements(FULL_RRP_SUBJECTS);
        return subjects.size();
    }

    public int getFullRrpGradeNumber() {
        final List<WebElement> grade = findElements(FULL_RRP_GRADE);
        return grade.size();
    }

    public int getLightRrpGradeNumber() {
        final List<WebElement> grade = findElements(LIGHT_RRP_GRADE);
        return grade.size();
    }

    public List<String> getLightRrpSubjectText() {
        List<WebElement> subjects= findElements(LIGHT_RRP_SUBJECTS);
        List<String> displaySubjects = new ArrayList<>();
        for (WebElement subject : subjects) {
            displaySubjects.add(getTextForElement(subject));
        }
        return displaySubjects;
    }

    public List<String> getFullRrpSubjectText() {
        List<WebElement> subjects = findElements(FULL_RRP_SUBJECTS);
        List<String> displaySubjects = new ArrayList<>();
        for (WebElement subject : subjects) {
            displaySubjects.add(getTextForElement(subject));
        }
        return displaySubjects;
    }

    public List<String> getFullRrpResourceTypeText(){
        List<WebElement> resourceTypes= findElements(FULL_RRP_RESOURCE_TYPES);
        List<String> displayResourceType = new ArrayList<>();
        for (WebElement resourceType : resourceTypes) {
            displayResourceType.add(getTextForElement(resourceType));
        }
        return displayResourceType;
    }

    public List<String> getLightRrpResourceTypeText(){
        List<WebElement> resourceTypes = findElements(LIGHT_RRP_RESOURCE_TYPES);
        List<String> displayResourceType = new ArrayList<>();
        for (WebElement resourceType : resourceTypes) {
            displayResourceType.add(getTextForElement(resourceType));
        }
        return displayResourceType;
    }

    public void clickJoinToSeeThisResourceButton(boolean inANewTab){
        openInANewTabOrClick(JOIN_TO_SEE_THIS_RESOURCE_BUTTON, inANewTab);
    }

    public void clickOnThumbnail(){
        clickElement(THUMBNAIL);
    }

    public void clickVisitorFavoriteButton(){
        clickElement(VISITOR_FAVORITE_BUTTON);
    }

    public boolean isSignInPopupLinkDisplayed() {
        return isElementDisplayed(SIGN_IN_POPUP);
    }

    public void clickSignInPopupLink(boolean inANewTab){
        openInANewTabOrClick(SIGN_IN_POPUP, inANewTab);
    }

    public boolean isJoinNowPopupLinkDisplayed() {
        return isElementDisplayed(JOIN_NOW_POPUP);
    }

    public void clickJoinNowPopupLink(){
        clickElement(JOIN_NOW_POPUP);
    }

    public void clickNextButton(){
        clickElement(NEXT_BUTTON_RRP);
    }

    public void clickPreviousButton() {
        clickElement(PREVIOUS_BUTTON_RRP);
    }

    public boolean isLeftSectionBlankDisplayed(){
        return isElementDisplayed(BLANK_LEFT_SECTION);
    }
}
