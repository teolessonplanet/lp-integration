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
    private static final String VISITOR_FAVORITE_BUTTON = "[class='btn btn-default favorite-join']";
    private static final String VIEW_FAVORITE_RESOURCE_LINK = "[class='alert alert-success alert-dismissible mb0'] a[href='/my/curriculum_manager']";
    private static final String EXISTING_COLLECTION = "[class*='create_collection_item clearfix']";
    private static final String NOTIFICATION_TEXT = "[class*='alert-success alert-dismissible mb0']";
    private static final String ADD_TO_COLLECTION_DROPDOWN = "[class='hidden-xs hidden-sm']";

    private static final String SUBSCRIPTION_BUTTON = "a[href='/subscription/new']";

    private static final String SHARE_BUTTON = "[class='btn btn-default dropdown-toggle']";
    private static final String REGULAR_RESOURCE_RRP_DETAILS = "[class*='panel-review new-rrp relative']";
    private static final String SHARED_RESOURCE_RRP_DETAILS = "[class*='panel-default panel-review new-rrp']";
    private static final String DESCRIPTION = "[class='panel-body'] [class*='js-help-rpp-description'] + p";
    private static final String THUMBNAIL = "[class='resource-img img-thumbnail img-responsive']";
    private static final String NUMBER_OF_VIEWS = "[class*='detail-views']";
    private static final String NUMBER_OF_DOWNLOADS = "[class*='detail-downloads']";
    private static final String CONCEPTS_TAGS_LIST = "[class='details-list concepts']";
    private static final String RATING = "[itemprop='reviewRating']";
    private static final String REGULAR_RESOURCE_GRADE = "[class*='panel-review new-rrp relative'] [class='left-resource-details mt15'] div.row:nth-child(3) div.col-sm-12.pt5.pb5:nth-child(2) dd";
    private static final String REGULAR_RESOURCE_SUBJECTS = "[class*='panel-review new-rrp relative'] [class='left-resource-details mt15'] div.row:nth-child(3) div.col-sm-12.pt5.pb5:nth-child(3) dd";
    private static final String REGULAR_RESOURCE_RESOURCE_TYPES = "[class*='panel-review new-rrp relative'] [class='left-resource-details mt15'] div.row:nth-child(4) div.col-sm-12.pt5.pb5:nth-child(1) dd";
    private static final String SHARED_RESOURCE_GRADE = "[class*='panel-default panel-review new-rrp'] [class='panel-body'] [class='pl5 mt10'] div.row:nth-child(1) div.col-sm-4.pt10.pb5:nth-child(1) dd";
    private static final String SHARED_RESOURCE_SUBJECTS = "[class*='panel-default panel-review new-rrp'] div.col-sm-4.pt10.pb5:nth-child(2) dd";
    private static final String SHARED_RESOURCE_RESOURCE_TYPES = "[class*='panel-default panel-review new-rrp'] div.col-sm-4.pt10.pb5:nth-child(3) dd";
    private static final String NEXT_BUTTON_RRP = "[class='panel-footer hidden-xs'] [class='pull-right'] a";
    private static final String PREVIOUS_BUTTON_RRP = "[class='panel-footer hidden-xs'] [class='pull-left'] a";
    private static final String SEARCH_RESULTS_POSITION_TEXT = "[class='lead lead-md mb0 text-center']";
    private static final String RETURN_TO_SEARCH_RESULTS_LINK = "[class='panel-footer hidden-xs'] a[href*='/search']";

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
        openInANewTabOrClick(SUBSCRIPTION_BUTTON, inANewTab);
    }

    public boolean isJoinToSeeThisResourceButtonDisplayed() {
        return isElementDisplayed(SUBSCRIPTION_BUTTON);
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

    public boolean isSearchResultsPositionDisplayed() {
        return isElementDisplayed(SEARCH_RESULTS_POSITION_TEXT);
    }

    public boolean isReturnToSearchResultsLinkDisplayed() {
        return isElementDisplayed(RETURN_TO_SEARCH_RESULTS_LINK);
    }

    public boolean isSharedResourceRrpDetailsDisplayed() {
        return isElementDisplayed(SHARED_RESOURCE_RRP_DETAILS);
    }

    public boolean isRegularResourceRrpDetailsDisplayed() {
        return isElementDisplayed(REGULAR_RESOURCE_RRP_DETAILS);
    }

    public boolean isSharedResourceGradeDisplayed() {
        return isElementDisplayed(SHARED_RESOURCE_GRADE);
    }

    public boolean isRegularResourceGradeDisplayed() {
        return isElementDisplayed(REGULAR_RESOURCE_GRADE);
    }

    public int getRegularResourceResourceTypeNumber() {
        final List<WebElement> resourceType = findElements(REGULAR_RESOURCE_RESOURCE_TYPES);
        return resourceType.size();
    }

    public int getSharedResourceResourceTypeNumber() {
        final List<WebElement> resourceType = findElements(SHARED_RESOURCE_RESOURCE_TYPES);
        return resourceType.size();
    }

    public int getSharedResourceSubjectsNumber() {
        final List<WebElement> subjects = findElements(SHARED_RESOURCE_SUBJECTS);
        return subjects.size();
    }

    public int getRegularResourceSubjectsNumber() {
        final List<WebElement> subjects = findElements(REGULAR_RESOURCE_SUBJECTS);
        return subjects.size();
    }

    public int getRegularResourceGradeNumber() {
        final List<WebElement> grade = findElements(REGULAR_RESOURCE_GRADE);
        return grade.size();
    }

    public int getSharedResourceGradeNumber() {
        final List<WebElement> grade = findElements(SHARED_RESOURCE_GRADE);
        return grade.size();
    }

    public List<String> getSharedResourceSubjectText() {
        List<WebElement> subjects= findElements(SHARED_RESOURCE_SUBJECTS);
        List<String> displaySubjects = new ArrayList<>();
        for (WebElement subject : subjects) {
            displaySubjects.add(getTextForElement(subject));
        }
        return displaySubjects;
    }

    public List<String> getRegularResourceSubjectText() {
        List<WebElement> subjects = findElements(REGULAR_RESOURCE_SUBJECTS);
        List<String> displaySubjects = new ArrayList<>();
        for (WebElement subject : subjects) {
            displaySubjects.add(getTextForElement(subject));
        }
        return displaySubjects;
    }

    public List<String> getRegularResourceResourceTypeText(){
        List<WebElement> resourceTypes= findElements(REGULAR_RESOURCE_RESOURCE_TYPES);
        List<String> displayResourceType = new ArrayList<>();
        for (WebElement resourceType : resourceTypes) {
            displayResourceType.add(getTextForElement(resourceType));
        }
        return displayResourceType;
    }

    public List<String> getSharedResourceResourceTypeText(){
        List<WebElement> resourceTypes = findElements(SHARED_RESOURCE_RESOURCE_TYPES);
        List<String> displayResourceType = new ArrayList<>();
        for (WebElement resourceType : resourceTypes) {
            displayResourceType.add(getTextForElement(resourceType));
        }
        return displayResourceType;
    }
}