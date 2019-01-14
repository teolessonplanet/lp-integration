package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

import java.text.NumberFormat;
import java.text.ParseException;

public class Rrp extends LpUiBasePage {

    private static final String LIMITED_ACCESS_REVIEW = "[class='rrp-banner'] [src*='limited-access']";
    private static final String FULL_REVIEW = "[class='rrp-banner'] [src*='rrp-banner-fullreview']";
    private static final String FREE_SAMPLE = "[class*='rrp-banner'] [src*='/assets/rrp/lp_badge']";

    protected static final String RESOURCE_TITLE_TEXT = "[class='resource-title'] h1";

    private static final String GO_TO_RESOURCE_BUTTON = "[class='panel-heading'] a[class*='goto']";
    private static final String FAVORITE_BUTTON = "[class='btn btn-default mb0 js-new-user-resource trk-save-resource']";
    private static final String VIEW_FAVORITE_RESOURCE_LINK = "[class='alert alert-success alert-dismissible mb0'] a[href='/my/curriculum_manager']";
    private static final String EXISTING_COLLECTION = "[class*='create_collection_item clearfix']";
    private static final String NOTIFICATION_TEXT = "[class*='alert-success alert-dismissible mb0']";
    private static final String ADD_TO_COLLECTION_DROPDOWN = "[class='hidden-xs hidden-sm']";

    private static final String ITEMS_COUNT = "[class='rrp-items-count']";

    protected Rrp(WebDriver driver) {
        super(driver);
    }

    public boolean isGoToResourceButtonDisplayed() {
        return isElementClickable(GO_TO_RESOURCE_BUTTON);
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

    public void clickOnUpgradeForFullReviewButton() {
    }

    public void clickOnSaveCollectionButton() {
    }

    public int getItemsCount() {
        String rawNumber = getTextForElement(ITEMS_COUNT);
        int number;
        try {
            number = NumberFormat.getNumberInstance(TestData.LOCALE).parse(rawNumber).intValue();
        } catch (ParseException e) {
            throw new Error("The number " + rawNumber + " cannot be parsed");
        }
        return number;
    }


}
