package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Rrp extends LpUiBasePage {

    protected static final String RESOURCE_TITLE_TEXT = "[class='resource-title'] h1";
    protected static final String GET_FREE_ACCESS_FOR_TEN_DAYS_BUTTON = "[class*='panel-default panel-review'] a[class*='btn btn-success']";
    private static final String LIMITED_ACCESS_REVIEW_BANNER = "[class='rrp-banner'] [src*='limited-access']";
    private static final String FULL_REVIEW_BANNER = "[class='rrp-banner'] [src*='rrp-banner-fullreview']";
    private static final String FREE_SAMPLE_BADGE = "[class*='rrp-banner'] [src*='/assets/rrp/lp_badge']";
    private static final String FAVORITE_BUTTON = "[class*='panel-default panel-review'] [class*='trk-save-resource']";
    private static final String FAVORITE_BUTTON_DISABLED = "[class*='panel-default panel-review'] div[class*='btn-default disabled']";
    private static final String VISITOR_FAVORITE_BUTTON = "[class*='favorite-join'][data-title='Get Full Access']";
    private static final String VIEW_FAVORITE_RESOURCE_LINK = "[class*='alert alert-success alert-dismissible'] a[href='/my/curriculum_manager']";
    private static final String EXISTING_FOLDER = "#collections-list [class='list-option'] [class*='fa-square-o']";
    private static final String NOTIFICATION_TEXT = "[class*='alert-success alert-dismissible mb0']";
    private static final String ADD_TO_FOLDER_DROPDOWN = "div[class$='add-to-folder-btn']";
    private static final String UPGRADE_FOR_FULL_REVIEW_BUTTON = "[class*='panel-default panel-review'] [class*='btn-success upgrade js-testimonial-popup trk-goto-resource']";
    private static final String SHARE_BUTTON = "[class*='dropdown-toggle rrp-share-resource']";
    private static final String DESCRIPTION = "[class='panel-body'] [class*='js-help-rpp-description'] + p";
    private static final String THUMBNAIL = "[class*='panel-default panel-review'] [class*='resource-img img-thumbnail img-responsive']";
    private static final String NUMBER_OF_VIEWS = "[class*='detail-views']";
    private static final String NUMBER_OF_DOWNLOADS = "[class*='detail-downloads']";
    private static final String CONCEPTS_TAGS_LIST = "[class*='concepts']";
    private static final String RATING = "[itemprop='reviewRating']";
    private static final String FULL_RRP_GRADE = "[class*='panel-review new-rrp'] [class='left-resource-details mt15'] div.row:nth-child(2) div.col-sm-12.pt5.pb5:nth-child(3) dd";
    private static final String FULL_RRP_SUBJECTS = "[class*='panel-review new-rrp'] [class*='left-resource-details'] div.row:nth-child(3) div.col-sm-12.pt5.pb5:nth-child(1) dd";
    private static final String FULL_RRP_RESOURCE_TYPES = "[class*='panel-review new-rrp'] [class*='left-resource-details'] div.row:nth-child(3) div.col-sm-12.pt5.pb5:nth-child(2) dd";
    private static final String LIGHT_RRP_GRADE = "[class='panel panel-default panel-review new-rrp'] div.row:nth-child(1) div.col-sm-4.pt10.pb5:nth-child(1) [itemprop='typicalAgeRange']";
    private static final String LIGHT_RRP_SUBJECTS = "[class*='panel-default panel-review new-rrp'] div.col-sm-4.pt10.pb5:nth-child(2) dd";
    private static final String LIGHT_RRP_RESOURCE_TYPES = "[class*='panel-default panel-review new-rrp'] [class='pl5 mt10'] div.row:nth-child(1) div.col-sm-4.pt10.pb5:nth-child(3) dd";
    private static final String NEXT_BUTTON_RRP = "[class='panel-footer hidden-xs'] [class='pull-right'] a";
    private static final String PREVIOUS_BUTTON_RRP = "[class='panel-footer hidden-xs'] [class='pull-left'] a";
    private static final String SIGN_IN_POPUP = "[class='bold']";
    private static final String JOIN_NOW_POPUP = "[class='bold text-danger']";
    private static final String BLANK_LEFT_SECTION = "[class='panel-body'] [class=row] [class='col-sm-3 hidden-xs'] [class='blank-rrp-left-resource-details mt15']";
    private static final String GO_TO_RESOURCE_BUTTON = "[class*='panel-default panel-review'] [class*='trk-goto-resource']";
    private static final String ADD_TO_NEW_FOLDER_BUTTON = "[class='resource-title-wrap pt5'] [class*='create-new-folder-btn']";
    private static final String EDIT_YOUR_FOLDER_LINK = "[class*='alert-success'] a[href*='/edit']";

    private static final String RESOURCE_POOL_NAME = "[class='pool-name'] [class='text']";
    private static final String ADD_TO_FOLDER_BUTTON = "button[class*='submit-btn']";

    private static final String OPEN_FOLDER_BUTTON = "[class='pull-left'] a[class*='trk-goto-resource'][href*='/pr/goto/']";
    private static final String BREADCRUMBS_CONTAINER = "#breadcrumbs-container";
    private static final String BREADCRUMB_ITEMS = "#breadcrumbs-container li a";
    private static final String FOLDER_DETAILS_DROPDOWN = "div[class*='resource-details'] [class*='detail-collections']";

    private static final String EDUCATOR_RATING_SECTION_DETAILS = "[class='educator-rating-details']";
    private static final String EDUCATOR_RATING_NOT_YET_RATED_TEXT = "[class='not-yet-rated']";
    private static final String EDUCATOR_RATING_ICONS_SECTION = "[class='educator-rating-wrap']";
    private static final String RATE_THIS_RESOURCE_LINK = "[class='user-rating-link']";
    private static final String UPGRADE_YOUR_MEMBERSHIP_POPOVER = "[class='react-popover educator-rating-restricted-popover']";

    private static final String ADD_A_REVIEW_SECTION = "#educator-rating-form-root";
    private static final String ADD_A_REVIEW_TITLE = "#educator-rating-form-root h4";
    private static final String ADD_A_REVIEW_SUBTITLE = "#educator-rating-form-root [class='subtitle']";
    private static final String ADD_A_REVIEW_RATING_ICONS = "[class='rating-selector']";
    private static final String ADD_A_REVIEW_PANEL = "#comment-text-area";

    public Rrp(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed() {
        return isElementClickable(RESOURCE_TITLE_TEXT);
    }

    public boolean isLimitedAccessReviewBannerDisplayed() {
        return isElementClickable(LIMITED_ACCESS_REVIEW_BANNER);
    }

    public boolean isFullReviewBannerDisplayed() {
        return isElementClickable(FULL_REVIEW_BANNER);
    }

    public boolean isFreeSampleBadgeDisplayed() {
        return isElementClickable(FREE_SAMPLE_BADGE);
    }

    public void clickOnViewFavoritesLink() {
        clickElement(VIEW_FAVORITE_RESOURCE_LINK);
    }

    public void clickOnFolderFromAddToFolderDropdown() {
        clickElement(EXISTING_FOLDER);
    }

    public void clickOnFavoriteButton() {
        clickElement(FAVORITE_BUTTON);
    }

    public String getNotificationText() {
        return findElement(NOTIFICATION_TEXT).getText();
    }

    public void clickOnAddToFolderDropdown() {
        scrollToElement(ADD_TO_FOLDER_DROPDOWN);
        clickElement(ADD_TO_FOLDER_DROPDOWN);
    }

    public void clickOnUpgradeForFullReviewButton(boolean inANewTab) {
        openInANewTabOrClick(UPGRADE_FOR_FULL_REVIEW_BUTTON, inANewTab);
    }

    public boolean isGetFreeAccessForTenDaysButtonDisplayed() {
        return isElementDisplayed(GET_FREE_ACCESS_FOR_TEN_DAYS_BUTTON);
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

    public boolean isCuratorRatingDisplayed() {
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

    public int getLightRrpGradeNumber() {
        final List<WebElement> grade = findElements(LIGHT_RRP_GRADE);
        return grade.size();
    }

    public List<String> getLightRrpSubjectText() {
        List<WebElement> subjects = findElements(LIGHT_RRP_SUBJECTS);
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

    public List<String> getFullRrpResourceTypeText() {
        List<WebElement> resourceTypes = findElements(FULL_RRP_RESOURCE_TYPES);
        List<String> displayResourceType = new ArrayList<>();
        for (WebElement resourceType : resourceTypes) {
            displayResourceType.add(getTextForElement(resourceType));
        }
        return displayResourceType;
    }

    public List<String> getLightRrpResourceTypeText() {
        List<WebElement> resourceTypes = findElements(LIGHT_RRP_RESOURCE_TYPES);
        List<String> displayResourceType = new ArrayList<>();
        for (WebElement resourceType : resourceTypes) {
            displayResourceType.add(getTextForElement(resourceType));
        }
        return displayResourceType;
    }

    public void clickOnGetFreeAccessForTenDaysButton(boolean inANewTab) {
        openInANewTabOrClick(GET_FREE_ACCESS_FOR_TEN_DAYS_BUTTON, inANewTab);
    }

    public void clickOnThumbnail() {
        clickElement(THUMBNAIL);
    }

    public void clickOnVisitorFavoriteButton() {
        clickElement(VISITOR_FAVORITE_BUTTON);
    }

    public boolean isSignInPopupLinkDisplayed() {
        return isElementDisplayed(SIGN_IN_POPUP);
    }

    public void clickOnSignInPopupLink(boolean inANewTab) {
        openInANewTabOrClick(SIGN_IN_POPUP, inANewTab);
    }

    public boolean isJoinNowPopupLinkDisplayed() {
        return isElementDisplayed(JOIN_NOW_POPUP);
    }

    public void clickOnJoinNowPopupLink() {
        clickElement(JOIN_NOW_POPUP);
    }

    public void clickOnNextButton() {
        clickElement(NEXT_BUTTON_RRP);
    }

    public void clickOnPreviousButton() {
        clickElement(PREVIOUS_BUTTON_RRP);
    }

    public boolean isLeftSectionBlankDisplayed() {
        return isElementDisplayed(BLANK_LEFT_SECTION);
    }

    public boolean isGoToResourceButtonDisplayed() {
        return isElementDisplayed(GO_TO_RESOURCE_BUTTON);
    }

    public void clickOnGoToResourceButton(boolean inANewTab) {
        openInANewTabOrClick(GO_TO_RESOURCE_BUTTON, inANewTab);
    }

    public boolean isFavoriteButtonDisplayed() {
        return isElementDisplayed(FAVORITE_BUTTON);
    }

    public boolean isFavoriteButtonDisabledDisplayed() {
        return isElementDisplayed(FAVORITE_BUTTON_DISABLED);
    }

    public boolean isAddToFolderDropdownDisplayed() {
        return isElementDisplayed(ADD_TO_FOLDER_DROPDOWN);
    }

    public boolean isUpgradeForFullReviewButtonDisplayed() {
        return isElementDisplayed(UPGRADE_FOR_FULL_REVIEW_BUTTON);
    }

    public void clickOnAddToNewFolderLink() {
        clickElement(ADD_TO_NEW_FOLDER_BUTTON);
    }

    public void clickOnEditYourFolderLink(boolean inANewTab) {
        openInANewTabOrClick(EDIT_YOUR_FOLDER_LINK, inANewTab);
    }

    public String getResourcePoolName() {
        return getTextForElement(RESOURCE_POOL_NAME);
    }

    public void clickOnAddToFolderButton() {
        scrollToElement(ADD_TO_FOLDER_BUTTON);
        clickElement(ADD_TO_FOLDER_BUTTON);
    }

//    Note: Notifications are not always working on Staging server
//    public void waitForNotificationToDisappear() {
//        waitUntilElementIsHidden(NOTIFICATION_TEXT);
//    }

    public boolean isOpenFolderButtonDisplayed() {
        return isElementDisplayed(OPEN_FOLDER_BUTTON);
    }

    public boolean isBreadcrumbsContainerDisplayed() {
        return isElementDisplayed(BREADCRUMBS_CONTAINER);
    }

    public void clickOnBreadcrumbsItem(int position) {
        clickElement(BREADCRUMB_ITEMS, position);
    }

    public int getNumberOfBreadcrumbsItems() {
        return findElements(BREADCRUMB_ITEMS).size();
    }

    public boolean isFolderDetailsDropdownDisplayed() {
        return isElementDisplayed(FOLDER_DETAILS_DROPDOWN);
    }

    public String getEducatorRatingDetails() {
        return getTextForElement(EDUCATOR_RATING_SECTION_DETAILS);
    }

    public boolean isNotYetRatedTextDisplayed() {
        return isElementDisplayed(EDUCATOR_RATING_NOT_YET_RATED_TEXT);
    }

    public boolean isEducatorRatingIconsSectionDisplayed() {
        return isElementDisplayed(EDUCATOR_RATING_ICONS_SECTION);
    }

    public void clickOnRateThisResourceLink() {
        clickElement(RATE_THIS_RESOURCE_LINK);
    }

    public boolean isUpgradeYourMembershipPopoverDisplayed() {
        return isElementDisplayed(UPGRADE_YOUR_MEMBERSHIP_POPOVER);
    }

    public boolean isAddAReviewSectionDisplayed() {
        return isElementDisplayed(ADD_A_REVIEW_SECTION);
    }

    public String getAddAReviewSectionTitle() {
        return getTextForElement(ADD_A_REVIEW_TITLE);
    }

    public String getAddAReviewSectionSubtitle() {
        return getTextForElement(ADD_A_REVIEW_SUBTITLE);
    }

    public boolean isAddAReviewPanelDisplayed() {
        return isElementDisplayed(ADD_A_REVIEW_PANEL);
    }

    public boolean isAddAReviewRatingIconsSectionDisplayed() {
        return isElementDisplayed(ADD_A_REVIEW_RATING_ICONS);
    }
}
