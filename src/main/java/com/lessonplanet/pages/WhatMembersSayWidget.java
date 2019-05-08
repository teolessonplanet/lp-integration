package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

public class WhatMembersSayWidget extends BrowseBySubjectPage{
    private static final String TESTIMONIALS_THUMBNAIL = "[class='img-thumbnail']";
    private static final String TESTIMONIALS_TEXT = "div[class='clearfix']";
    private static final String SEE_MORE_TESTIMONIALS_LINK = "[class='more'] a[href='/us/testimonials']";
    private static final String SUBMIT_YOUR_OWN_LINK = "[class='more'] a[href='/feedbacks/new']";
    private static final String WHAT_MEMBERS_SAY_SUBSCRIPTION_BUTTON = "a[href*='/subscription/new']";
    private static final String WHAT_MEMBERS_SAY_WIDGET = "[class='side-widget testimonial-widget']";
    private static final String MEMBER_PHOTO = "[class='side-widget testimonial-widget'] img";

     public WhatMembersSayWidget(WebDriver driver) {
         super(driver);
     }

    public boolean isTestimonialTextDisplayed() {
        return findElements(getWhatMembersSayWidget(), TESTIMONIALS_TEXT).get(0).getText().length() > TestData.ZERO_RESOURCES_FOUND;
    }

    public void clickOnSeeMoreTestimonialsButton(boolean inANewTab) {
        openInANewTabOrClick(SEE_MORE_TESTIMONIALS_LINK, inANewTab);
    }

    public void clickOnSubmitYourOwnButton(boolean inANewTab) {
        openInANewTabOrClick(SUBMIT_YOUR_OWN_LINK, inANewTab);
    }

    public void clickSubscriptionButton(boolean inANewTab) {
        waitForPageLoad();
        final WebElement subscriptionButton = findElements(getWhatMembersSayWidget(), WHAT_MEMBERS_SAY_SUBSCRIPTION_BUTTON).get(0);
        openInANewTabOrClick(subscriptionButton, inANewTab);
    }

    public boolean isWidgetDisplayed(){
        return isElementDisplayed(WHAT_MEMBERS_SAY_WIDGET);
    }

    public boolean isSeeMoreTestimonialsLinkDisplayed(){
        return isElementDisplayed(SEE_MORE_TESTIMONIALS_LINK);
    }

    public boolean isSubmitYourOwnLinkDisplayed(){
        return isElementDisplayed(SUBMIT_YOUR_OWN_LINK);
    }

    public boolean isMemberPhotoDisplayed(){
        return isElementDisplayed(MEMBER_PHOTO);
    }

    public boolean isSubscriptionButtonDisplayed(){
        return isElementDisplayed(WHAT_MEMBERS_SAY_SUBSCRIPTION_BUTTON);
    }
}
