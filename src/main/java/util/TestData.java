package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestData {

    public static final int TIMEOUT = 15;
    public static final String SERVER_URL = "https://staging.lessonplanet.com/";
    public static final String EMPTY_URL = "about:blank";
    public static final Locale LOCALE = java.util.Locale.US;
    public static final String STAGING_SERVER_CAPTCHA_COOKIE_NAME = "bypass_captcha";
    public static final String STAGING_SERVER_SHARED_RESOURCE_REDIRECT_URL = "https://staging.lessonplanet.com/drive/documents/";
    public static final String STAGING_SERVER_SHARED_RESOURCE_URL = "https://s3.amazonaws.com/dev-lessonplanet-files/drive/";
    public static final String STAGING_SERVER_SHARED_RESOURCE_URL_2 = "https://staging.lessonplanet.com/goto/";

    public static final String LP_HOME_PAGE_PATH = "";
    public static final String STEP_ONE_PAGE_PATH = "subscription/new";
    public static final String LOGIN_PAGE_PATH = "auth/users/sign_in";
    public static final String SUBSCRIPTION_SUCCESS_PATH = "subscription/success";
    public static final String MY_ACCOUNT_PAGE_PATH = "profile/account";
    public static final String DISCOVER_RESOURCES_PAGE_PATH = "search";

    public static final String INVALID_EMAIL = "bla@bla.com";
    public static final String INVALID_PASSWORD = "J*(Y@D#DfJVnd*(^sd";
    public static final String VALID_EMAIL_FREEMIUM = "freemium@mailinator.com";
    public static final String VALID_EMAIL_ADMIN = "genericuser+admin@lessonplanet.com";
    public static final String VALID_PASSWORD = "test123";
    public static final String NEW_EMAIL_PREFIX = "integration_";
    private static final String NEW_EMAIL_SUFFIX = "@lessonplanet.com";

    public static final String INVALID_LOGIN_OR_PASSWORD_MESSAGE = "Invalid login or password.";
    public static final String INVALID_EMAIL_MESSAGE = "Please provide a valid email address.";

    public static final String STEP_TWO_TITLE_MESSAGE = "Select Your Membership";

    public static final String FACET_CATEGORY_RESOURCES_TYPES = "Resource Types";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_COLLECTIONS = "Collections";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_PRESENTATIONS = "Presentations";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_ACTIVITIES_AND_PROJECTS = "Activities & Projects";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS = "Lesson Plans";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_PRINTABLES_AND_TEMPLATES = "Printables & Templates";

    public static final String NEW_COLLECTION_NAME = "testAutomation";
    public static final String NEW_COLLECTION_DESCRIPTION = "testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 ";

    public static final String EDIT_COLLECTION_GRADE_HIGHER_ED = "Higher Ed";

    public static final String EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION = "Special Education & Program: Special Education";

    public static final String COLLECTION_CREATED_MESSAGE = "Collection created!";

    //Step 2
    public static final String SELECTED_TEXT = "Selected";
    public static final String SELECT_TEXT = "Select";

    public static final String STARTER_OPTION_TEXT = "Starter";
    public static final String PRIME_OPTION_TEXT = "Prime";
    public static final String PRO_OPTION_TEXT = "Pro";
    public static final String THIS_FIELD_IS_REQUIRED_ERROR_MESSAGE = "This field is required.";
    public static final String INVALID_CARD_NUMBER_ERROR_MESSAGE = "Please enter a valid credit card number";
    public static final String INVALID_CARD_EXPIRATION_ERROR_MESSAGE = "Please enter a valid expiration date";
    public static final String INVALID_CARD_CVV_ERROR_MESSAGE = "Please enter a valid security code";
    private static final String BILLING_TERMS_MESSAGE = "By clicking the Get Your Risk-Free Trial button, I agree to the Lesson Planet Terms of Use. To ensure your full, uninterrupted access to Lesson Planet, your credit card will be charged the 12-Month ($%s/mo.) %s Membership price of $%s after your risk-free 10-Day Free Trial. Your membership comes with convenient automatic renewal at $%s on your anniversary date. You may cancel at any time via Contact Us.";
    private static final String STARTER_MONTHLY = "2";
    private static final String STARTER_ANNUALLY = "24";
    private static final String PRIME_MONTHLY = "3";
    private static final String PRIME_ANNUALLY = "36";
    private static final String PRO_MONTHLY = "6";
    private static final String PRO_ANNUALLY = "72";

    public static String GET_STARTER_BILLING_TERMS_MESSAGE() {
        return String.format(BILLING_TERMS_MESSAGE, STARTER_MONTHLY, STARTER_OPTION_TEXT, STARTER_ANNUALLY, STARTER_ANNUALLY);
    }

    public static String GET_PRIME_BILLING_TERMS_MESSAGE() {
        return String.format(BILLING_TERMS_MESSAGE, PRIME_MONTHLY, PRIME_OPTION_TEXT, PRIME_ANNUALLY, PRIME_ANNUALLY);
    }

    public static String GET_PRO_BILLING_TERMS_MESSAGE() {
        return String.format(BILLING_TERMS_MESSAGE, PRO_MONTHLY, PRO_OPTION_TEXT, PRO_ANNUALLY, PRO_ANNUALLY);
    }

    public static final String FREE_MEMBERSHIP_TEXT = "Free Membership";

    //Credit card info STAGING
    public static final String FIRSTNAME = "FistnameTest";
    public static final String LASTNAME = "LastnameTest";
    public static final String CARD_NUMBER = "4012888888881881";
    public static final String INVALID_CARD_NUMBER = "5555555555555555";
    public static final String CARD_EXPIRATION = "01/20";
    public static final String INVALID_CARD_EXPIRATION = "04/11";
    public static final String CARD_CVV = "123";
    public static final String INVALID_CARD_CVV = "22";
    public static final String ZIP_CODE = "578631";

    //Subscription success page
    public static final String SUBSCRIPTION_SUCCESS_PAGE_TITLE = "Thank you for signing up for Lesson Planet";

    //Sign In Modal
    public static final String SIGN_IN_MODAL_TITLE_TEXT = "Sign in to Lesson Planet";

    public static String GET_NEW_EMAIL() {
        return NEW_EMAIL_PREFIX + GET_CURRENT_TIME() + NEW_EMAIL_SUFFIX;
    }

    private static String GET_CURRENT_TIME() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Date date = new Date();
        return formatter.format(date);
    }

    //Search data
    public static final String VALID_SEARCH_WORD = "math";
    public static final String INVALID_SEARCH_WORD = "maeybdhth";

    public static final String INVALID_SEARCH_MESSAGE = "We found 0 reviewed resources for " + INVALID_SEARCH_WORD;
    public static final int ZERO_RESOURCES_FOUND = 0;
    public static final String VALID_SEARCH_MESSAGE = "We found %s reviewed resources for " + VALID_SEARCH_WORD;
    public static final String SUGGESTIONS_BLOCK_MESSAGE = "Suggestions\nTry more general keywords\nClear all selections";
    public static final String SHOWING_ALL_REVIEWED_RESROUCES_MESSAGE = "Showing all reviewed resources";

    //Discovery page
    public static final int TOTAL_RESOURCES_PER_PAGE = 24;


    public static final String BROWSE_RESOURCE_DIRECTORY_PAGE_PATH = "lesson-plans";
    public static final String SEARCH_BY_STANDARD_PAGE_PATH = "state-standards";
    public static final String CURRICULUM_MANAGER_PAGE_PATH = "my/curriculum_manager";
    public static final String CURRICULUM_CALENDAR_PAGE_PATH = "calendar";
    public static final String LESSON_PLANNING_ARTICLES_PAGE_PATH = "articles";

    public static final String EDUCATOR_EDITION_PAGE_PATH = "content/how_it_works";
    public static final String SCHOOL_EDITION_URL = "https://schooledition.lessonplanet.com/";
    public static final String SCHOOL_EDITION_AND_PD_LEARNING_NETWORK_URL = "https://schooledition.lessonplanet.com/pdln";

    public static final String CONTACT_US_PAGE_PATH = "us/contact";
    public static final String OUR_STORY_PAGE_PATH = "us/about_us";
    public static final String PRESS_PAGE_PATH = "us/about_us#news";
    public static final String FAQ_PAGE_PATH = "us/faq";
    public static final String TESTIMONIALS_PAGE_PATH = "us/testimonials";

    public static final String PRICING_PAGE_PATH = "pricing";

}
