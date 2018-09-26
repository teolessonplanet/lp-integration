package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

public class FooterPage extends LpUiBasePage {

    private static final String CONTACT_US_BUTTON = "[class*='lp-footer-contact-link lp-bottom-footer-link']";
    private static final String SITE_MAP_BUTTON = "[href='/content/site_map']";
    private static final String PRIVACY_POLICY_LINK = "[href='/us/privacy_policy']";
    private static final String TERMS_OF_USE_LINK = "[href='/us/terms_of_use']";

    private static final String EMAIL_INPUT = "[class*='lp-newsletter-email-input form-control required email']";
    private static final String SEND_BUTTON = "[class*='lp-newsletter-email-submit']";

    private static final String LP_LOGO_IMAGE = "[class*='img-responsive']";

    private static final String HEALTH_LINK = "[href='/lesson-plans/health']";
    private static final String LANGUAGE_ARTS_LINK = "[href='/lesson-plans/language-arts']";
    private static final String LANGUAGES_LINK = "[href='/lesson-plans/languages']";
    private static final String MATH_LINK = "[href='/lesson-plans/math']";
    private static final String PHYSICAL_EDUCATION_LINK = "[href='/lesson-plans/physical-education']";
    private static final String SPECIAL_EDUCATION_LINK = "[href='/lesson-plans/special-education']";
    private static final String VISUAL_AND_PERFORMING_ARTS_LINK = "[href='/lesson-plans/visual-and-performing-arts']";
    private static final String SCIENCE_LINK = "[href='/lesson-plans/science']";
    private static final String SOCIAL_STUDIES_LINK = "[href='/lesson-plans/social-studies']";

    private static final String EDIT_A_COLLECTION_LINK = "[href='/us/videos?autoplay=collections_edit']";
    private static final String ASSIGN_TO_STUDENTS_LINK = "[href='/us/videos?autoplay=how_to_share_collections']";
    private static final String MANAGE_MY_RESOURCES_LINK = "[href='/us/videos?autoplay=curriculum_manager']";
    private static final String SHARING_WITH_OTHERS_LINK = "[href='/us/videos?autoplay=how_to_share_collections']";

    private static final String OUR_REVIEW_PROCESS_LINK = "[class='lp-resources-col col-sm-2'] [href='/content/how_it_works']";
    private static final String HOW_IT_WORKS_LINK = "[href='/us/videos?autoplay=review']";
    private static final String HOW_TO_SEARCH_LINK = "[href='/us/videos?autoplay=search']";
    private static final String CREATE_A_COLLECTION_LINK = "[href='/us/videos?autoplay=collections_how_to']";

    private static final String FACEBOOK_BUTTON = "[class*='fa fa-facebook']";
    private static final String TWITTER_BUTTON = "[class*='fa fa-twitter']";
    private static final String GOOGLE_BUTTON = "[class*='fa fa-google-plus']";
    private static final String LINKEDIN_BUTTON = "[class*='fa fa-linkedin']";
    private static final String YOUTUBE_BUTTON = "[class*='fa fa-youtube']";
    private static final String PINTEREST_BUTTON = "[class*='fa fa-pinterest'";

    public FooterPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.LP_HOME_PAGE_PATH);
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

    public void clickOnLessonPlanetLogo() {
        clickElement(LP_LOGO_IMAGE);
    }

    public void clickSendButton() {
        clickElement(SEND_BUTTON);
    }

    public String getTextFromEMailField() {
        return findElement(EMAIL_INPUT).getAttribute("value");
    }

    public void clickOnLanguageArtsLink() {
        clickElement(LANGUAGE_ARTS_LINK);
    }

    public void clickOnLanguagesLink() {
        clickElement(LANGUAGES_LINK);
    }

    public void clickOnMathLink() {
        clickElement(MATH_LINK);
    }

    public void clickOnPhysicalEducationLink() {
        clickElement(PHYSICAL_EDUCATION_LINK);
    }

    public void clickOnHealthLink() {
        clickElement(HEALTH_LINK);
    }

    public void clickOnVisualAndPerformingArtsLink() {
        clickElement(VISUAL_AND_PERFORMING_ARTS_LINK);
    }

    public void clickOnSpecialEducationLink() {
        clickElement(SPECIAL_EDUCATION_LINK);
    }

    public void clickOnSocialStudiesLink() {
        clickElement(SOCIAL_STUDIES_LINK);
    }

    public void clickOnScienceLink() {
        clickElement(SCIENCE_LINK);
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

    public void clickOnLessonPlanetFacebookButton() {
        clickElement(FACEBOOK_BUTTON);
    }

    public void clickOnLessonPlanetTwitterButton() {
        clickElement(TWITTER_BUTTON);
    }

    public void clickOnLessonPlanetGoogleButton() {
        clickElement(GOOGLE_BUTTON);
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

    public void typeEmail(String email) {
        sendKeys(EMAIL_INPUT, email);
    }
}