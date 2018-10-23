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

    public static final String EDIT_A_COLLECTION_PAGE_PATH = "us/videos?autoplay=collections_edit";
    public static final String ASSIGN_TO_STUDENTS_PAGE_PATH = "us/videos?autoplay=how_to_share_collections";
    public static final String MANAGE_MY_RESOURCES_PAGE_PATH = "us/videos?autoplay=curriculum_manager";
    public static final String SHARING_WITH_OTHERS_PAGE_PATH = "us/videos?autoplay=how_to_share_collections";

    public static final String OUR_REVIEW_PROCESS_PAGE_PATH = "content/how_it_works";
    public static final String HOW_IT_WORKS_PAGE_PATH = "us/videos?autoplay=review";
    public static final String HOW_TO_SEARCH_PAGE_PATH = "us/videos?autoplay=search";
    public static final String CREATE_A_COLLECTION_PAGE_PATH = "us/videos?autoplay=collections_how_to";

    public static final String FACEBOOK_PAGE_URL = "https://www.facebook.com/LessonPlanet";
    public static final String TWITTER_PAGE_URL = "https://twitter.com/lessonplanet";
    public static final String GOOGLE_PAGE_URL = "https://plus.google.com/117101455580789057170/?prsrc=3";
    public static final String LINKEDIN_PAGE_URL = "https://www.linkedin.com/company/lesson-planet";
    public static final String YOUTUBE_PAGE_URL = "https://www.youtube.com/user/lessonplanet";
    public static final String PINTEREST_PAGE_URL = "https://www.pinterest.com/lessonplanet/";

    public static final String SITE_MAP_PAGE_PATH ="content/site_map";
    public static final String PRIVACY_POLICY_PAGE_PATH ="us/privacy_policy";
    public static final String TERMS_OF_USE_PAGE_PATH ="us/terms_of_use";

    public static final String SUBSCRIPTION_MODAL_TEXT="Thank you for subscribing to Lesson Planet News.";

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

    public static final String MEMBER_PROFILE_PAGE_PATH = "profile";
    public static final String SEARCH_HISTORY_PAGE_PATH = "my/saved_searches";

    public static final String HEALTH_PAGE_PATH = "lesson-plans/health";
    public static final String LANGUAGE_ARTS_PAGE_PATH = "lesson-plans/language-arts";
    public static final String LANGUAGES_PAGE_PATH = "lesson-plans/languages";
    public static final String MATH_PAGE_PATH = "lesson-plans/math";
    public static final String PHYSICAL_EDUCATION_PAGE_PATH = "lesson-plans/physical-education";
    public static final String SCIENCE_PAGE_PATH = "lesson-plans/science";
    public static final String SOCIAL_STUDIES_PAGE_PATH = "lesson-plans/social-studies";
    public static final String SPECIAL_EDUCATION_PAGE_PATH = "lesson-plans/special-education";
    public static final String VISUAL_AND_PERFORMING_ARTS_PAGE_PATH = "lesson-plans/visual-and-performing-arts";

    public static final int DIRECTORY_CATEGORIES_COUNTER = 9;
    public static final String HEALTH_CATEGORY_MODAL_TITLE = "Health";
    public static final String HEALTH_CATEGORY_MODAL_DEFAULT_TEXT = "Wellness & Safety\nNutrition\nGrowth and Development\nSex Education\nCommunity Health";
    public static final String HEALTH_CATEGORY_MODAL_FIRST_CARET_EXPANDED_TEXT = "Wellness & Safety\nMental Emotional Health\nInjury Prevention and Safety\nPhysical Health\nSocial Health\nNutrition\nGrowth and Development\nSex Education\nCommunity Health";
    public static final String HEALTH_CATEGORY_MODAL_SECOND_CARET_EXPANDED_TEXT = "Wellness & Safety\nNutrition\nFood\nHealthy Eating\nNutrition in Schools\nGrowth and Development\nSex Education\nCommunity Health";

    public static final String HEALTH_PAGE_TITLE = "Health Teacher Resources";
    public static final String LANGUAGE_ARTS_PAGE_TITLE = "Language Arts Teacher Resources";
    public static final String LANGUAGES_PAGE_TITLE = "Languages Teacher Resources";
    public static final String MATH_PAGE_TITLE = "Math Teacher Resources";
    public static final String PHYSICAL_EDUCATION_PAGE_TITLE = "Physical Education Teacher Resources";
    public static final String SCIENCE_PAGE_TITLE = "Science Teacher Resources";
    public static final String SOCIAL_STUDIES_PAGE_TITLE = "Social Studies Teacher Resources";
    public static final String SPECIAL_EDUCATION_PAGE_TITLE = "Special Education Teacher Resources";
    public static final String VISUAL_AND_PERFORMING_ARTS_PAGE_TITLE = "Visual and Performing Arts Teacher Resources";

    public static final String WELLNESS_AND_SAFETY_PAGE_TITLE = "Wellness & Safety Teacher Resources";
    public static final String NUTRITION_PAGE_TITLE = "Nutrition Teacher Resources";
    public static final String GROWTH_AND_DEVELOPMENT_PAGE_TITLE = "Growth and Development Teacher Resources";
    public static final String SEX_EDUCATION_PAGE_TITLE = "Sex Education Teacher Resources";
    public static final String RESEARCH_PAGE_TITLE = "Research Teacher Resources";
    public static final String LITERATURE_PAGE_TITLE = "Literature Teacher Resources";
    public static final String GRAPHIC_ORGANIZER_PAGE_TITLE = "Graphic Organizer Teacher Resources";
    public static final String GENRE_TYPES_PAGE_TITLE = "Genre Types Teacher Resources";
    public static final String ENGLISH_LANGUAGE_DEVELOPMENT_PAGE_TITLE = "English Language Development Teacher Resources";
    public static final String AMERICAN_SIGN_LANGUAGE_PAGE_TITLE = "American Sign Language Teacher Resources";
    public static final String FRENCH_PAGE_TITLE = "French Teacher Resources";
    public static final String SPANISH_PAGE_TITLE = "Spanish Teacher Resources";
    public static final String MEASUREMENT_PAGE_TITLE = "Measurement Teacher Resources";
    public static final String TEACHING_MATH_PAGE_TITLE = "Teaching Math Teacher Resources";
    public static final String ALGEBRA_PAGE_TITLE = "Algebra Teacher Resources";
    public static final String GRAPHING_PAGE_TITLE = "Graphing Teacher Resources";
    public static final String ANAEROBIC_ACTIVITY_PAGE_TITLE = "Anaerobic Activity Teacher Resources";
    public static final String WATER_ACTIVITIES_PAGE_TITLE = "Water Activities Teacher Resources";
    public static final String SPORT_SKILLS_PAGE_TITLE = "Sports Skills Teacher Resources";
    public static final String NATURAL_SCIENCE_PAGE_TITLE = "Natural Science Teacher Resources";
    public static final String SCIENTISTS_PAGE_TITLE = "Scientists Teacher Resources";
    public static final String BIOLOGY_PAGE_TITLE = "Biology Teacher Resources";
    public static final String APPLIED_SCIENCE_PAGE_TITLE = "Applied Science Teacher Resources";
    public static final String TWENTY_ONE_CENTURY_LEARNING_SKILLS_PAGE_TITLE = "21st Century Learning Skills Teacher Resources";
    public static final String GEOGRAPHY_PAGE_TITLE = "Geography Teacher Resources";
    public static final String FLAGS_PAGE_TITLE = "Flags Teacher Resources";
    public static final String HISTORY_PAGE_TITLE = "History Teacher Resources";
    public static final String DEVELOPMENT_AND_BEHAVIORAL_DISORDERS_PAGE_TITLE = "Developmental & Behavioral Disorders Teacher Resources";
    public static final String PHYSICAL_DISABILITIES_PAGE_TITLE = "Physical Disabilities Teacher Resources";
    public static final String SPECIAL_NEEDS_TEACHER_RESOURCES_PAGE_TITLE = "Special Needs Teacher Resources Teacher Resources";
    public static final String ACCOMMODATION_PAGE_TITLE = "Accommodations Teacher Resources";
    public static final String MUSIC_PAGE_TITLE = "Music Teacher Resources";
    public static final String VISUAL_ARTS_PAGE_TITLE = "Visual Arts Teacher Resources";
    public static final String FILM_STUDIES_PAGE_TITLE = "Film Studies Teacher Resources";
    public static final String DANCE_PAGE_TITLES = "Dance Teacher Resources";
}
