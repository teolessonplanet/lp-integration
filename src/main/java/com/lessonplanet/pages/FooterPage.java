package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class FooterPage extends LpUiBasePage {

    private static final String LP_LOGO_IMAGE = "[class='lp-footer-logo'] #footer-logo /*[name()='svg']";
    private static final String REGULAR_SL_LOGO_IMAGE = "[class='lp-footer-logo'] [src*='/assets/logos/learning-explorer-logo-long-light']";
    private static final String COPY_RIGHT_TEXT = "[class='copyright-text']";

    private static final String SUBSCRIPTION_EMAIL_INPUT = "[class*='lp-newsletter-email-input']";
    private static final String SEND_BUTTON = "[class*='lp-newsletter-email-submit']";

    private static final String CONTACT_US_BUTTON = "[class*='footer-container'] [href='/us/contact']";
    private static final String SITE_MAP_BUTTON = "[class*='footer-container'] [href='/content/site_map']";
    private static final String PRIVACY_POLICY_LINK = "[class*='footer-container'] [href='/privacy-policy']";
    private static final String TERMS_OF_USE_LINK = "[class*='footer-container'] [href*='/terms-of-use']";

    private static final String FACEBOOK_BUTTON = "[class*='fa-facebook']";
    private static final String TWITTER_BUTTON = "[class*='fa-twitter']";
    private static final String LINKEDIN_BUTTON = "[class*='fa-linkedin']";
    private static final String YOUTUBE_BUTTON = "[class='lp-icon fa fa-youtube-play']";
    private static final String PINTEREST_BUTTON = "[class*='fa-pinterest']";

    private static final String HEALTH_LINK = "[class*='lp-oer-col'] [href*='/health']";
    private static final String LANGUAGE_ARTS_LINK = "[class*='lp-oer-col'] [href*='/language-arts']";
    private static final String LANGUAGES_LINK = "[class*='lp-oer-col'] [href*='/languages']";
    private static final String MATH_LINK = "[class*='lp-oer-col'] [href*='/math']";
    private static final String PHYSICAL_EDUCATION_LINK = "[class*='lp-oer-col'] [href*='/physical-education']";
    private static final String SCIENCE_LINK = "[class*='lp-oer-col'] [href*='/science']";
    private static final String SOCIAL_STUDIES_LINK = "[class*='lp-oer-col'] [href*='/social-studies']";
    private static final String SPECIAL_EDUCATION_LINK = "[class='lp-footer-top'] [href*='/special-education']";
    private static final String VISUAL_AND_PERFORMING_ARTS_LINK = "[class*='lp-oer-col'] [href*='/visual-and-performing-arts']";
    private static final String VIEW_ALL_LESSON_PLANS_LINK = "[class*='lp-oer-col'] [class='lp-footer-view-all-lesson-plans-link']";

    private static final String OUR_REVIEW_PROCESS_LINK = "[class*='lp-resources-col'] [href='/educator-edition?review-process']";
    private static final String HOW_IT_WORKS_LINK = "[class*='lp-resources-col'] [href*='/us/videos?autoplay=review']";
    private static final String HOW_TO_SEARCH_LINK = "[class*='lp-resources-col'] [href*='/us/videos?autoplay=search']";
    private static final String CREATE_A_COLLECTION_LINK = "[class*='lp-resources-col'] [href*='/us/videos?autoplay=collections_how_to']";

    private static final String EDIT_A_COLLECTION_LINK = "[class*='lp-curriculum-col'] [href='/us/videos?autoplay=collections_edit']";
    private static final String ASSIGN_TO_STUDENTS_LINK = "[class*='lp-curriculum-col'] [href='/us/videos?autoplay=how_to_share_collections']";
    private static final String MANAGE_MY_RESOURCES_LINK = "[class*='lp-curriculum-col'] [href='/us/videos?autoplay=curriculum_manager']";
    private static final String SHARING_WITH_OTHERS_LINK = "[class*='lp-curriculum-col'] [href='/us/videos?autoplay=how_to_share_collections']";

    private static final String OPEN_EDUCATIONAL_RESOURCES_CATEGORY = "[class='lp-footer-top'] [class*='lp-oer-col'] [class='footer-col-title']";
    private static final String DISCOVER_RESOURCES_CATEGORY = "[class='lp-footer-top'] [class*='lp-resources-col'] [class='footer-col-title']";
    private static final String MANAGE_CURRICULUM_CATEGORY = "[class='lp-footer-top'] [class*='lp-curriculum-col'] [class='footer-col-title']";

    private static final String SIGN_UP_HINT_TEXT = "[class='lp-footer-top'] [class='newsletter-box'] [class='text']";
    private static final String SIGN_UP_ERROR_TEXT = "#email_subscription_email-error";

    private static final String RSL_IFRAME_COPY_RIGHT_TEXT = "[class='le-footer-meta-item']:nth-child(1)";
    private static final String RSL_IFRAME_TERMS_LINK = "[class='le-footer-meta'] [href*='https://www.learningexplorer.com/term']";
    public FooterPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.LP_HOME_PAGE_PATH);
    }

    public void clickOnLessonPlanetLogo(boolean inANewTab) {
        openInANewTabOrClick(LP_LOGO_IMAGE, inANewTab);
    }

    public void clickOnCopyRightText() {
        clickElement(COPY_RIGHT_TEXT);
    }

    public String getTextFromSubscriptionEmailField() {
        return findElement(SUBSCRIPTION_EMAIL_INPUT).getAttribute("value");
    }

    public void typeEmail(String email) {
        sendKeys(SUBSCRIPTION_EMAIL_INPUT, email);
    }

    public void clickSendButton() {
        clickElement(SEND_BUTTON);
    }

    public void clickOnContactUsButton() {
        clickElement(CONTACT_US_BUTTON);
    }

    public void clickOnSiteMapButton() {
        clickElement(SITE_MAP_BUTTON);
    }

    public void clickOnPrivacyPolicyButton() {
        clickElement(PRIVACY_POLICY_LINK);
    }

    public void clickOnTermsOfUseButton() {
        clickElement(TERMS_OF_USE_LINK);
    }

    public void clickOnLessonPlanetFacebookButton() {
        clickElement(FACEBOOK_BUTTON);
    }

    public void clickOnLessonPlanetTwitterButton() {
        clickElement(TWITTER_BUTTON);
    }

    public void clickOnLessonPlanetLinkedInButton() {
        clickElement(LINKEDIN_BUTTON);
    }

    public void clickOnLessonPlanetYoutubeButton() {
        clickElement(YOUTUBE_BUTTON);
    }

    public void clickOnLessonPlanetPinterestButton() {
        clickElement(PINTEREST_BUTTON);
    }

    private void scrollToElementAndClick(String cssSelector) {
        scrollToElement(cssSelector);
        clickElement(cssSelector);
    }

    public void clickOnHealthLink() {
        scrollToElementAndClick(HEALTH_LINK);
    }

    public void clickOnLanguageArtsLink() {
        scrollToElementAndClick(LANGUAGE_ARTS_LINK);
    }

    public void clickOnLanguagesLink() {
        scrollToElementAndClick(LANGUAGES_LINK);
    }

    public void clickOnMathLink() {
        scrollToElementAndClick(MATH_LINK);
    }

    public void clickOnPhysicalEducationLink() {
        scrollToElementAndClick(PHYSICAL_EDUCATION_LINK);
    }

    public void clickOnScienceLink() {
        scrollToElementAndClick(SCIENCE_LINK);
    }

    public void clickOnSocialStudiesLink() {
        scrollToElementAndClick(SOCIAL_STUDIES_LINK);
    }

    public void clickOnSpecialEducationLink() {
        scrollToElementAndClick(SPECIAL_EDUCATION_LINK);
    }

    public void clickOnVisualAndPerformingArtsLink() {
        scrollToElementAndClick(VISUAL_AND_PERFORMING_ARTS_LINK);
    }

    public void clickOnViewAllLessonPlansLink() {
        scrollToElementAndClick(VIEW_ALL_LESSON_PLANS_LINK);
    }

    public void clickOnOurReviewProcessLink() {
        clickElement(OUR_REVIEW_PROCESS_LINK);
    }

    public void clickOnHowItWorksLink() {
        clickElement(HOW_IT_WORKS_LINK);
    }

    public void clickOnHowToSearchLink() {
        clickElement(HOW_TO_SEARCH_LINK);
    }

    public void clickOnCreateACollectionLink() {
        clickElement(CREATE_A_COLLECTION_LINK);
    }

    public void clickOnEditACollectionLink() {
        clickElement(EDIT_A_COLLECTION_LINK);
    }

    public void clickOnAssignToStudentsLink() {
        clickElement(ASSIGN_TO_STUDENTS_LINK);
    }

    public void clickOnManageMyResourcesLink() {
        clickElement(MANAGE_MY_RESOURCES_LINK);
    }

    public void clickOnSharingWithOthersLink() {
        clickElement(SHARING_WITH_OTHERS_LINK);
    }

    public boolean isSubscriptionEmailInputDisplayed() {
        return isElementDisplayed(SUBSCRIPTION_EMAIL_INPUT);
    }

    public void clearSubscriptionEmail() {
        clearText(SUBSCRIPTION_EMAIL_INPUT);
    }

    public boolean isLpLogoDisplayed() {
        return isElementDisplayed(LP_LOGO_IMAGE);
    }

    public boolean isRegularSlLogoDisplayed() {
        return isElementDisplayed(REGULAR_SL_LOGO_IMAGE);
    }

    public void clickOnRegularSlLogo(boolean inANewTab) {
        openInANewTabOrClick(REGULAR_SL_LOGO_IMAGE, inANewTab);
    }

    public String getCopyrightText() {
        return getTextForElement(COPY_RIGHT_TEXT);
    }

    public boolean isSignUpTextDisplayed() {
        return isElementDisplayed(SIGN_UP_HINT_TEXT);
    }

    public String getSignUpHintText() {
        return getTextForElement(SIGN_UP_HINT_TEXT);
    }

    public String getSignUpErrorText() {
        return getTextForElement(SIGN_UP_ERROR_TEXT);
    }

    public boolean isOpenEducationalResourcesSectionDisplayed() {
        return isElementDisplayed(OPEN_EDUCATIONAL_RESOURCES_CATEGORY);
    }

    public boolean isDiscoverResourcesSectionDisplayed() {
        return isElementDisplayed(DISCOVER_RESOURCES_CATEGORY);
    }

    public boolean isManageCurriculumSectionDisplayed() {
        return isElementDisplayed(MANAGE_CURRICULUM_CATEGORY);
    }

    public boolean isContactUsButtonDisplayed() {
        return isElementDisplayed(CONTACT_US_BUTTON);
    }

    public boolean isSiteMapButtonDisplayed() {
        return isElementDisplayed(SITE_MAP_BUTTON);
    }

    public boolean isPrivacyPolicyLinkDisplayed() {
        return isElementDisplayed(PRIVACY_POLICY_LINK);
    }

    public boolean isTermsOfUseLinkDisplayed() {
        return isElementDisplayed(TERMS_OF_USE_LINK);
    }

    public boolean isFacebookButtonDisplayed() {
        return isElementDisplayed(FACEBOOK_BUTTON);
    }

    public boolean isTwitterButtonDisplayed() {
        return isElementDisplayed(TWITTER_BUTTON);
    }

    public boolean isLinkedinButtonDisplayed() {
        return isElementDisplayed(LINKEDIN_BUTTON);
    }

    public boolean isYoutubeButtonDisplayed() {
        return isElementDisplayed(YOUTUBE_BUTTON);
    }

    public boolean isPinterestButtonDisplayed() {
        return isElementDisplayed(PINTEREST_BUTTON);
    }

    public String getRegularSlIframeCopyrightText() {
        return getTextForElement(RSL_IFRAME_COPY_RIGHT_TEXT);
    }

    public boolean isRegularSlIframeCopyrightTextDisplayed() {
        return isElementDisplayed(RSL_IFRAME_COPY_RIGHT_TEXT);
    }

    public boolean isRegularSlIframeTermsLinkDisplayed() {
        return isElementDisplayed(RSL_IFRAME_TERMS_LINK);
    }

    public void clickOnRegularSlIframeCopyRightText() {
        clickElement(RSL_IFRAME_COPY_RIGHT_TEXT);
    }

    public void clickOnRegularSlIframeTermsLink() {
        scrollToElement(RSL_IFRAME_TERMS_LINK);
        clickElement(RSL_IFRAME_TERMS_LINK);
    }
}
