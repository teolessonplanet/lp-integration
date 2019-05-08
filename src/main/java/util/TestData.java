package util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TestData {

    public static final int TIMEOUT = 15;
    public static final int SHORT_TIMEOUT = 5;
    public static final String SERVER_URL = "https://staging.lessonplanet.com/";
    public static final String EMPTY_URL = "about:blank";
    public static final Locale LOCALE = java.util.Locale.US;
    public static final String STAGING_SERVER_CAPTCHA_COOKIE_NAME = "bypass_captcha";
    public static final String STAGING_SERVER_SHARED_RESOURCE_REDIRECT_URL = "https://staging.lessonplanet.com/drive/documents/";
    public static final String STAGING_SERVER_SHARED_RESOURCE_URL = "https://s3.amazonaws.com/dev-lessonplanet-files/drive/";
    public static final String STAGING_SERVER_SHARED_RESOURCE_URL_2 = "https://staging.lessonplanet.com/goto/";

    //Paths
    public static final String LP_HOME_PAGE_PATH = "";
    public static final String STEP_ONE_PAGE_PATH = "subscription/new";
    public static final String LOGIN_PAGE_PATH = "auth/users/sign_in";
    public static final String SUBSCRIPTION_SUCCESS_PATH = "subscription/success";
    public static final String MY_ACCOUNT_PAGE_PATH = "profile/account";
    public static final String DISCOVER_RESOURCES_PAGE_PATH = "search";
    public static final String MANAGE_MEMBERSHIP_PAGE_PATH = "subscription/edit";
    public static final String CUSTOM_MEMBERSHIP_PAGE_PATH = "cancellation/new";
    public static final String CURRICULUM_MANAGER_PATH = "my/curriculum_manager";
    public static final String CURRICULUM_PLAYER_PATH = "/player";

    //Collection Builder
    public static final String ALERT_TEXT = "Resource already in collection";

    //Curriculum Calendar Page
    public static final String SEARCH_PAGE_PATH = "search?keywords=";
    public static final String CALENDAR_TITLE = " Curriculum Calendar - Lesson Plan Ideas by Date";
    public static final String CALENDAR_DECRIPTION = "Enhance your current curriculum with this fun reference calendar. Whether you want to highlight historic events, honor birthdays of significant people, or celebrate holidays, this is a valuable tool for every teacher. Click on any event to find a breadth of related teaching resources that will spark new ideas to spice up your daily lessons. There's something worth celebrating every day!";
    public static final String[] MONTH = {"January" , "February" , "March" , "April" , "May" , "June" , "July" , "August" , "September" , "October" , "November" , "December"};
    public static final String[] KEYWORD = {"Creativity" , "Black History" , "Women's History" , "Poetry" , "Mental Health" , "Dairy" , "Watermelon" , "Immunization","Hispanic Heritage" , "Bullying" , "Native Americans" , "Human Rights"};

    //Curriculum Manager

    public static final String UPGRADE_MODAL_TEXT_FROM_EXCEEDED_ITEMS_INSIDE_CREATED_COLLECTION = "You've reached your 10-resource limit for this collection, but don't let that stop you!\n" + "Upgrade today to create more collections of any size and enjoy the benefits of full membership.";
    public static final String UPGRADE_MODAL_TEXT_FROM_EXCEEDED_ITEMS_INSIDE_SAVED_COLLECTION = "As a Free Member you can only save collections with up to 10 items...but don't let that stop you!\n" + "Upgrade today to save unlimited collections, and enjoy the benefits of a Full Membership.";
    public static final String UPGRADE_MODAL_TEXT_FROM_MAX_COLLECTION_LIMIT  = "You've reached your 3-collection limit, but don't let that stop you!\n" + "Upgrade today to create more collections and enjoy the benefits of full membership.";
    public static final String UPGRADE_MODAL_TEXT_FROM_UPLOAD_BUTTON = "Uploading and storing files are not supported by your Free Membership.\n" + "Upgrade today to upload and store your own materials on Lesson Planet.\n" + "For access anytime, anywhere!";
    public static final String UPGRADE_MODAL_TEXT_FROM_ASSIGN_BUTTON = "You`re ready to go PRO.\n" + "Upgrade to a Pro Membership to unleash the power of assigning!";
    public static final String UPGRADE_MODAL_TEXT_FROM_PLAY_BUTTON = "Let's do it!\n" + "Upgrade your membership to unleash the power of the Resource Player.";
    public static final String ASSIGN_RESOURCE_MODAL_TEXT = "Resource Player to students or share with colleagues, please enter a case-sensitive access key below";
    public static final String ASSIGN_COLLECTION_MODAL_TEXT = "Collection Player to students or share with colleagues, please enter a case-sensitive access key below";
    public static final String COLLECTION_CREATED_MESSAGE = "Collection created!";
    public static final String RESOURCE_ADDED_TO_COLLECTION_MESSAGE = "This resource review was added to your collection";
    public static final String REMOVED_FAVORITE_RESOURCE_MESSAGE = "was removed from favorites";
    public static final String CREATED_MESSAGE = "was created";
    public static final String DELETED_MESSAGE= "was deleted";
    public static final String EMAIL_SENT_MESSAGE = "Your email was sent successfully.";
    public static final String ZERO_RESOURCES = "(0)";
    public static final String ONE_RESOURCES = "(1)";
    public static final String TWO_RESOURCES = "(2)";
    public static final String NEW_COLLECTION_NAME = "Test Collection";
    public static final String EDIT_TITLE = "-edit";
    public static final String EDIT_COLLECTION_NAME = NEW_COLLECTION_NAME + EDIT_TITLE ;
    public static final String UPLOAD_RESOURCE_TITLE = "test-upload-file";
    public static final String UPLOAD_RESOURCE_EDIT_TITLE = UPLOAD_RESOURCE_TITLE + EDIT_TITLE;
    public static final String[] collectionName = {"Collection 1", "Collection 2", "Collection 3", "Collection 4"};
    public static final String COPIED_COLLECTION_NAME = "Copy of " + EDIT_COLLECTION_NAME ;
    public static final String NEW_COLLECTION_DESCRIPTION = "testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 ";
    public static final String PUBLISH_RESOURCE_TITLE = "test publish resource";
    public static final String SHARE_LINK_MODAL_TITLE = "Share a Link to this Resource";
    public static final String EDIT_COLLECTION_GRADE_HIGHER_ED = "Higher Ed";
    public static final String EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION = "Special Education & Program: Special Education";
    public static final String UPLOAD_YOUR_FILE_GRADE = "Higher Ed";
    public static final String UPLOAD_YOUR_FILE_SUBJECT = "Special Education & Program: Special Education";
    public static final String UPLOAD_YOUR_FILE_RESOURCE_TYPE = "Interactives";
    public static final String PLAY_COLLECTION_WITH_NO_ITEMS_POPOVER_TEXT = "Please add items to play this collection";
    public static final String PLAY_COLLECTION_WITH_ITEMS_POPOVER_TEXT = "Play Collection";
    public static final String PUBLISH_COLLECTION_WITH_NO_ITEMS_POPOVER_TEXT = "This collection needs additional information in order to publish. Select the Edit button to continue.";
    public static final String PUBLISH_COLLECTION_WITH_ITEMS_POPOVER_TEXT = "Publish to make visible to others";
    public static final String COPIED_POPOVER_TEXT = "Copied!";
    public static final String PUBLISHED_STATUS = "Published";
    public static final String PRIVATE_STATUS = "Private";
    public static final String FREE_SAMPLE_RESOURCE_STATUS = "LP Free Sample";
    public static final String REGULAR_RESOURCE_STATUS = "LP Reviewed";
    public static final String SHARED_RESOURCE_STATUS = "Member Shared";
    public static final String PUBLISHED_RESOURCE_STATUS = "Shared";
    public static final String FACEBOOK_URL = "https://www.facebook.com";
    public static final String TWITTER_URL = "https://twitter.com";
    public static final String GOOGLE_URL = "https://plus.google.com";

    //Footer
    public static final String EDIT_A_COLLECTION_PAGE_PATH = "us/videos?autoplay=collections_edit";
    public static final String ASSIGN_TO_STUDENTS_PAGE_PATH = "us/videos?autoplay=how_to_share_collections";
    public static final String MANAGE_MY_RESOURCES_PAGE_PATH = "us/videos?autoplay=curriculum_manager";
    public static final String SHARING_WITH_OTHERS_PAGE_PATH = "us/videos?autoplay=how_to_share_collections";

    public static final String OUR_REVIEW_PROCESS_PAGE_PATH = "content/how_it_works";
    public static final String HOW_IT_WORKS_PAGE_PATH = "us/videos?autoplay=review";
    public static final String HOW_TO_SEARCH_PAGE_PATH = "us/videos?autoplay=search";
    public static final String CREATE_A_COLLECTION_PAGE_PATH = "us/videos?autoplay=collections_how_to";

    public static final String FACEBOOK_LP_URL = FACEBOOK_URL + "/LessonPlanet";
    public static final String TWITTER_LP_URL = TWITTER_URL + "/lessonplanet";
    public static final String LINKEDIN_URL = "https://www.linkedin.com";
    public static final String LESSON_PLANET_TEXT = "lesson-planet";
    public static final String YOUTUBE_LP_URL = "https://www.youtube.com/user/lessonplanet";
    public static final String PINTEREST_LP_URL = "https://www.pinterest.com/lessonplanet/";

    public static final String SITE_MAP_PAGE_PATH = "content/site_map";
    public static final String PRIVACY_POLICY_PAGE_PATH = "us/privacy_policy";
    public static final String TERMS_OF_USE_PAGE_PATH = "us/terms_of_use";

    public static final String SUBSCRIPTION_MODAL_TEXT = "Thank you for subscribing to Lesson Planet News.";

    //Emails and passwords
    public static final String INVALID_EMAIL = "bla@bla.com";
    public static final String INVALID_PASSWORD = "J*(Y@D#DfJVnd*(^sd";
    public static final String VALID_EMAIL_FREEMIUM = "freemember@mailinator.com";
    public static final String VALID_EMAIL_ADMIN = "genericuser+admin@lessonplanet.com";
    public static final String VALID_PASSWORD = "test123";
    public static final String NEW_EMAIL_PREFIX = "integration_";
    private static final String NEW_EMAIL_SUFFIX = "@lessonplanet.com";
    public static final String VALID_EMAIL_REGULAR_SITE_LICENCE = "testuser+60+959321@lessonplanet.com";

    public static final String INVALID_LOGIN_OR_PASSWORD_MESSAGE = "Invalid login or password.";
    public static final String INVALID_EMAIL_MESSAGE = "Please provide a valid email address.";

    //Search Facet
    public static final String FACET_CATEGORY_RESOURCES_TYPES = "Resource Types";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_COLLECTIONS = "Collections";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_PRESENTATIONS = "Presentations";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_ARTICLES = "Articles";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS = "Lesson Plans";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_PRINTABLES_AND_TEMPLATES = "Printables & Templates";

    //step 1
    public static final String STEP_ONE_PAGE_TITLE = "Ready to start your Free 10 Days?";
    public static final String STEP_ONE_MODAL_TITLE= "Discover 350k+ Teacher Reviewed Resources";

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
    public static final String STEP_TWO_TITLE_MESSAGE = "Select Your Membership";

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

    //Subscription Success Page
    public static final String SUBSCRIPTION_SUCCESS_PAGE_TITLE = "Thank you for signing up for Lesson Planet";

    //Subscription Edit Page
    public static final String MANAGE_MEMBERSHIP_TITLE_MESSAGE = "Manage Membership";
    public static final String THE_MEMBERSHIP_FEE_WAS_TOO_EXPENSIVE_FOR_ME_TEXT = "The membership fee was too expensive for me";

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

    public static Date GET_CURRENT_DATE() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("PST"));
        return calendar.getTime();
    }

    public static Date ADD_DAYS_TO_DATE(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    public static boolean COMPARE_EQUAL_DATES(Date date1, Date date2) {
        return date1.getYear() == date2.getYear() && date1.getMonth() == date2.getMonth() && date1.getDay() == date2.getDay() && date1.getTimezoneOffset() == date2.getTimezoneOffset();
    }

    public static int getCurrentMonth() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.MONTH);
    }

    public static int getCurrentYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    //Search data
    public static final String VALID_SEARCH_WORD = "math";
    public static final String INVALID_SEARCH_WORD = "maeybdhth";

    public static final String INVALID_SEARCH_MESSAGE = "We found 0 reviewed resources for " + INVALID_SEARCH_WORD;
    public static final int ZERO_RESOURCES_FOUND = 0;
    public static final String SEARCH_MESSAGE = "reviewed resources for ";
    public static final String VALID_SEARCH_MESSAGE = "We found %s reviewed resources for " + VALID_SEARCH_WORD;
    public static final String SUGGESTIONS_BLOCK_MESSAGE = "Suggestions\nTry more general keywords\nClear all selections";
    public static final String SHOWING_ALL_REVIEWED_RESOURCES_MESSAGE = "Showing all reviewed resources";
    public static final String SHOWING_ALL_RESOURCES_MESSAGE = "Showing all resources";
    public static final String SEARCH_BOX_PLACEHOLDER_TEXT = "Search 350K+ Teacher Reviewed Resources Including Lesson Plans, Worksheets, Apps, & More";

    public static final String REGULAR_RESOURCE_TYPE = "Resource";
    public static final String SHARED_RESOURCE_TYPE = "Drive::Document";

    public static final String SEARCH_BOX_PLACEHOLDER_ED_TECH_PD_TEXT = "EdTech PD Videos & Courses: What would you like to learn today?";
    public static final String SEARCH_BOX_PLACEHOLDER_COMMON_CORE_STATE_STANDARDS_TEXT = "What concept or skill would you like to find?";

    //Footer
    public static final String SIGN_UP_HINT_TEXT = "Sign up for the Lesson Planet Monthly Newsletter";
    public static final String REQUIRED_EMAIL_ERROR_TEXT = "This field is required.";
    public static final String VALID_EMAIL_ERROR_TEXT = "Please enter a valid email address.";
    public static final String COPYRIGHT_TEXT = "© 1999-2019 Education Planet, Inc.\nAll rights reserved.";

    //RRPs
    public static final String DISABLED_TEXT = "more...";
    public static final String ALL_RESOURCE_TYPES_DROPDOWN = "Curriculum Sets\n"+"Chapters\n"+"Lessons\n"+"Collections\n"+"Assessment Sets\n"+"Activities & Projects\n"+"Unit Modules\n"+"Assessments\n"+"Graphics & Images\n"+"Handouts & References\n"+"Interactives\n"+"Lab Resources\n"+"Learning Games\n"+"Lesson Plans\n"+"Presentations\n"+"Primary Sources\n"+"Printables & Templates\n"+"Professional Documents\n"+"PD Courses\n"+"Study Guides\n"+"Units\n"+"Videos\n"+"Performance Tasks\n"+"Websites\n"+"Graphic Organizers\n"+"Worksheets\n"+"Workbooks\n"+"Writing Prompts\n"+"Constructed Response Items\n"+"Apps\n"+"AP Test Preps\n"+"Articles\n"+"Lesson Planet Articles\n"+"Audios\n"+"Courses\n"+"eBooks\n"+"Interactive Whiteboards\n"+"Home Letters\n"+"Rubrics\n"+"Syllabis\n" + "All Resource Types";
    public static final String WORKSHEETS_RESOURCE_TYPE = "Worksheets";
    public static final String HOME_LETTERS_RESOURCE_TYPE = "Home Letters";
    public static final String WORKSHEET_RESOURCE_TYPE_CARD = "Worksheet";
    public static final String NO_RESOURCES_FOUND_TEXT =  "No resources found.";
    public static final String [] SUBJECTS = {"Math","Arithmetic & Pre-Algebra","Algebra I","Algebra II","Geometry","Trigonometry","Pre-Calculus","Calculus","Statistics & Probability","Consumer Math & Personal Finance","General Math","Science" ,"Agriculture","Biology","Chemistry","Earth Science","Environment","Life Science","Physical Science","Physics","Science Principles","Space Science & Astronomy","General Science","English Language Arts" ,"Grammar","Spelling & Vocabulary","Speaking & Listening","Reading: Foundational Skills","Reading: Informational Text","Reading: Literature", "Narative Writing","Expository Writing","Persuasive Writing","Poetry","Fine Motor Skills","ESL & ELD", "General Writing","Reading & Visual Literacy","General English Language Arts", "Social Studies & History" , "Cultural & Social Studies","Economics & Business","Geography","Government","Holidays","Philosophy","Psychology","World History","General History","Religion","United States History","World History","Physical Education" ,"Activities & Sports","Motor Skills & Movement","Outdoor Education","Physical Fitness","Health" ,"Growth & Development","Nutrition","Sex Education","Substance Abuse", "Wellness & Safety", "Visual & Performing Arts","Art History","Arts & Crafts","Drama","Dance","Music","Visual Arts", "Languages" ,"American Sign Language","Arabic","Chinese","French","German","Italian","Japanese","Latin", "Portuguese","Russian","Spanish","Hindi","Other Languages","STEM","Computer Programming","Engineering", "21st Century Skills", "Social & Emotional Learning", "Family & Consumer Sciences", "Career & Education & Skills", "Computer Skills","Media Literacy","Researcg Process","Study Skills","Digital Citizenship","Classroom Support","Classroom Management","Learning Displays","Classroom Tools","Professional Development","Special Education & Programs","Special Education"};
    public static final String [] RESOURCE_TYPES = {"Collections","Activities & Projects","Assessments","Graphics & Images","Handouts & References","Interactives","Lab Resources","Learning Games","Lesson Plans","Presentations","Primary Sources","Printables & Templates","Professional Documents","PD Courses","Study Guides","Units","Videos","Performance Tasks","Websites","Graphic Organizers","Worksheets","Workbooks","Writing Prompts","Constructed Response Items","Apps","AP Test Preps","Articles","Lesson Planet Articles","Audios","Courses","eBooks","Interactive Whiteboards","Home Letters","Rubrics","Syllabis"};
    public static final String START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE = "Save time and discover engaging curriculum for your classroom. Reviewed and rated by trusted, credentialed teachers.";
    public static final String START_YOUR_FREE_TRIAL_TEXT_SHARED_RESOURCE = "Save time and discover engaging curriculum for your classroom. Quickly find resources you need — reviewed and rated by trusted, credentialed teachers.";

    //Discovery page
    public static final int TOTAL_RESOURCES_PER_PAGE = 24;
    public static final int TOTAL_RESOURCES_PER_PAGE_STARTER_UNLOCKED = 12;
    public static final int TOTAL_RESOURCES_PER_PAGE_STARTER_LOCKED = 12;
    public static final int TOTAL_RESOURCES_PER_PAGE_PRIME_UNLOCKED = 18;
    public static final int TOTAL_RESOURCES_PER_PAGE_PRIME_LOCKED = 6;
    public static final String BROWSE_RESOURCE_DIRECTORY_PAGE_PATH = "lesson-plans";
    public static final String SEARCH_BY_STANDARD_PAGE_PATH = "state-standards";
    public static final String CURRICULUM_MANAGER_PAGE_PATH = "my/curriculum_manager";
    public static final String CURRICULUM_CALENDAR_PAGE_PATH = "calendar";
    public static final String LESSON_PLANNING_ARTICLES_PAGE_PATH = "articles";

    public static final String EDUCATOR_EDITION_PAGE_PATH = "content/how_it_works";
    public static final String LEARNING_EXPLORER_URL = "https://solutions.lessonplanet.com/";
    public static final String PD_LEARNING_NETWORK_URL = "https://solutions.lessonplanet.com/pdln/";

    public static final String CONTACT_US_PAGE_PATH = "us/contact";
    public static final String OUR_STORY_PAGE_PATH = "us/about_us";
    public static final String PRESS_PAGE_PATH = "us/about_us#news";
    public static final String FAQ_PAGE_PATH = "us/faq";
    public static final String TESTIMONIALS_PAGE_PATH = "us/testimonials";

    public static final String PRICING_PAGE_PATH = "pricing";

    public static final String MEMBER_PROFILE_PAGE_PATH = "profile";
    public static final String SEARCH_HISTORY_PAGE_PATH = "my/saved_searches";
    public static final String ACCOUNT_MANAGER_PAGE_PATH = "my/organization";

    public static final String HEALTH_PAGE_PATH = "lesson-plans/health";
    public static final String LANGUAGE_ARTS_PAGE_PATH = "lesson-plans/language-arts";
    public static final String LITERATURE_PAGE_PATH = "lesson-plans/literature";
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

    public static final String BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT = "Browse by Subject\nHealth\nWellness & Safety\nNutrition\nGrowth and Development\nSex Education\nCommunity Health";
    public static final String BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_FIRST_CARET_EXPANDED_TEXT = "Browse by Subject\nHealth\nWellness & Safety\nMental Emotional Health\nInjury Prevention and Safety\nPhysical Health\nSocial Health\nNutrition\nGrowth and Development\nSex Education\nCommunity Health";
    public static final String BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_SECOND_CARET_EXPANDED_TEXT = "Browse by Subject\nHealth\nWellness & Safety\nNutrition\nFood\nHealthy Eating\nNutrition in Schools\nGrowth and Development\nSex Education\nCommunity Health";
    public static final String BROWSE_BY_SUBJECT_FOR_SOCIAL_HEALTH_CATEGORY_TEXT = "Browse by Subject\nSocial Health\nConflict Resolution\nPositive Social Behaviors";
    public static final String BROWSE_BY_SUBJECT_SUGGEST_A_CATEGORY_TEXT = "\nSuggest a Category";

    public static final String SUGGEST_A_CATEGORY_MODAL_TITLE = "Suggest a Category";

    public static final String SIDE_WIDGET_BROWSE_BY_SUBJECT_CATEGORIES = "Browse by Subject";
    public static final String SIDE_WIDGET_BROWSE_BY_SUBJECT_GROWTH_AND_DEVELOPMENT_TYPE = "Growth and Development";
    public static final String SIDE_WIDGET_BROWSE_BY_SUBJECT_SOCIAL_HEALTH_TYPE = "Social Health";

    public static final String GROWTH_AND_DEVELOPMENT_PAGE_PATH = "lesson-plans/growth-and-development";
    public static final String SOCIAL_HEALTH_PAGE_PATH = "lesson-plans/social-health";
    public static final String SOCIAL_HEALTH_PAGE_TITLE = "Social Health Teacher Resources";

    public static final String SIDE_WIDGET_START_YOUR_TEN_DAYS_FREE_TRIAL = "Start Your 10-Day Free Trial";
    public static final String SIDE_WIDGET_START_YOUR_TEN_DAYS_FREE_TRIAL_VISITOR_TEXT = "Start Your 10-Day Free Trial\nSearch 350,000+ online teacher resources.\nFind lesson plans, worksheets, videos, and more.\nInspire your students with great lessons.\nGet Free Trial";
    public static final String SIDE_WIDGET_START_YOUR_TEN_DAYS_FREE_TRIAL_FREEMIUM_TEXT = "Start Your 10-Day Free Trial\nSearch 350,000+ online teacher resources.\nFind lesson plans, worksheets, videos, and more.\nInspire your students with great lessons.\nGet Full Access";

    public static final String SIDE_WIDGET_RELATED_TOPICS = "Related Topics";
    public static final String SIDE_WIDGET_RELATED_TOPICS_TRANSPORTATION_OPTION = "Transportation";
    public static final String SIDE_WIDGET_RELATED_TOPICS_TRANSPORTATION_REDIRECT_PATH = "search?keywords=transportation";
    public static final String SIDE_WIDGET_RELATED_TOPICS_CATEGORY_TEXT = "Related Topics\nHealth Lesson Plans\nStress Management\nMental Heath\nFamily Life and Sexual Health\nClass Introduction\nCalorie\nWeight Loss\nEnvironmental Factors\nFood Systems\nFood Choices\nTransportation";

    public static final String SIDE_WIDGET_WHAT_MEMBERS_SAY = "What Members Say";

    public static final String FEEDBACKS_PAGE_PATH = "feedbacks/new";

    public static final String PAGINATION_FIRST_PAGE_PATH = "";
    public static final String PAGINATION_SECOND_PAGE_PATH = "/2";
    public static final String PAGINATION_ALL_ITEMS_PATH = "/all";

    public static final String ENGLISH_LANGUAGE_ARTS_PAGE_PATH = "standards/common-core/english-language-arts";
    public static final String MATHEMATICS_PAGE_PATH = "standards/common-core/mathematics";
    public static final String NGSS_PAGE_PATH = "state-standards/nrcdsc";
    public static final String COMMON_CORE_CORRELATED_RESOURCES_PAGE_PATH= "standards/resources/14310";

    public static final String SEARCH_STANDARDS_TITLE_TEXT = "Search Standards";
    public static final String STATE_LABEL_TEXT = "Common Core, NGSS, or State";
    public static final String SUBJECT_LABEL_TEXT = "Subject";
    public static final String GRADE_LABEL_TEXT = "Grade";
    public static final String KEYWORD_LABEL_TEXT = "Keyword";
    public static final String SEARCH_BUTTON_TEXT = "Search";

    public static final String ALL_STATES_TEXT = "Common Core\nNext Generation Science (NGSS)\nAlabama\nAlaska\nArizona\nArkansas\nCalifornia\nCobb County\nColorado\nConnecticut\nDelaware\nFlorida\nGeorgia\n" +
        "Hawaii\nIdaho\nIllinois\nIndiana\nIowa\nKansas\nKentucky\nLouisiana\nMaine\nMaryland\nMassachusetts\nMichigan\nMinnesota\nMississippi\nMissouri\nMontana\nNebraska\nNevada\nNew Hampshire\nNew Jersey\nNew Mexico\nNew York\nNorth Carolina\nNorth Dakota\nOhio\nOklahoma\n" +
        "Oregon\nPennsylvania\nRhode Island\nSouth Carolina\nSouth Dakota\nTennessee\nTexas\nUtah\nVermont\nVirginia\nWashington\nWashington DC\nWest Virginia\nWisconsin\nWyoming";
    public static final String SELECT_SUBJECT_TEXT = "Select Subject";
    public static final String ALL_SUBJECTS_TEXT = "Arts Education\nHealth and PE\nLanguage Arts\nMathematics\nScience\nSocial Studies\nWorld Languages\nTechnology Education\nLibrary Media";
    public static final String ALL_GRADES_TEXT = "Kindergarten\n1st\n2nd\n3rd\n4th\n5th\n6th\n7th\n8th\n9th\n10th\n11th\n12th";
    public static final String SELECT_GRADE_TEXT = "Select Grade";

    public static final String SEARCH_FILTER_REVIEWED_RESOURCES = "Reviewed Resources";
    public static final String SEARCH_FILTER_EDTECHPD_VIDEOS_AND_COURSES = "EdTechPD Videos & Courses";
    public static final String SEARCH_FILTER_COMMON_CORE_STATE_STANDARDS = "Common Core State Standards";

    public static final String SEARCH_STANDARDS_STANDARD_OPTION_COMMON_CORE = "Common Core";
    public static final String SEARCH_STANDARDS_STANDARD_OPTION_NGSS = "Next Generation Science (NGSS)";
    public static final String SEARCH_STANDARDS_STANDARD_OPTION_LOUISIANA = "Louisiana";

    public static final String SEARCH_STANDARD_GRADE_OPTION_2ND = "2nd";

    public static final String STATE_STANDARDS_BREADCRUMB_HOME = "Home";
    public static final String COMMON_CORE_BREADCRUMB = "Common Core";
    public static final String COMMON_CORE_ENGLISH_BREADCRUMB = "English Language Arts";
    public static final String COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_BREADCRUMB = "Science & Technical Subjects";
    public static final String COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_INTRODUCTION_TEXT = "Introduction";
    public static final String COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_DESCRIPTION_TEXT = "The standards below begin at grade 6; standards for K-5 reading in history/social studies, science, and technical subjects are integrated into the K-5 Reading standards. The CCR anchor standards and high school standards in literacy work in tandem to define college and career readiness expectations-the former providing broad standards, the latter providing additional specificity.";
    public static final String COMMON_CORE_GRADE_11_12_BREADCRUMB = "Grade 11-12";
    public static final String COMMON_CORE_STANDARD_CODE_RST_11_12_1 = "RST.11-12.1";

    public static final String COMMON_CORE_ENGLISH_STANDARD_KINDERGARTEN_GRADE_5_TEXT = "Kindergarten-Grade 5";
    public static final String COMMON_CORE_ENGLISH_STANDARD_GRADES_6_12_ELA_TEXT = "Grades 6-12 ELA";
    public static final String COMMON_CORE_ENGLISH_STANDARD_GRADES_6_12_LITERACY_TEXT = "Grades 6-12 Literacy";

    public static final String COMMON_CORE_MATHEMATICS_BREADCRUMB = "Mathematics";
    public static final String COMMON_CORE_STANDARDS_FOR_MATHEMATICAL_PRACTICE_BREADCRUMB = "Standards for Mathematical Practice";
    public static final String COMMON_CORE_STANDARDS_FOR_MATHEMATICAL_PRACTICE_INTRODUCTION_TEXT = "Introduction";
    public static final String COMMON_CORE_STANDARD_CODE_MP_1 = "MP1";
    public static final String SEE_TEXT = "See";
    public static final String RESOURCES_TEXT = "Resources";

    public static final String TRY_IT_FREE_BUTTON_BACKGROUND_COLOR = "#5cb85c";

    public static final String THANKS_FOR_JOINING_MODAL_TEXT = "Thanks so much for joining Lesson Planet.\nTo finish signing up, check the email we sent and click the confirmation link to activate your account.";

    public static final String CANCEL_MODAL_FROM_STARTER_MONTHLY_TITLE_TEXT = "Confirm Cancellation";
    public static final String CANCEL_MODAL_FROM_STARTER_MONTHLY_QUESTION_TEXT = "Are you sure you want to cancel your Lesson Planet membership?";
    public static final String CANCEL_MODAL_FROM_STARTER_MONTHLY_YOUR_CURRENT_MEMBERSHIP_TEXT = "Your current membership";
    public static final String CANCEL_MODAL_FROM_STARTER_MONTHLY_INDIVIDUAL_MEMBERSHIP_TEXT = "Individual Membership";
    public static final String CANCEL_MODAL_FROM_STARTER_MONTHLY_RENEWAL_AMOUNT_TEXT = "Renewal Amount: $2.00";
    public static final String CANCEL_MODAL_FROM_STARTER_MONTHLY_RENEWAL_DATE_TEXT = "Renewal Date:";

    public static final String CANCEL_MODAL_FROM_STARTER_QUESTION_TEXT = "Want to take it one month at a time?";
    public static final String CANCEL_MODAL_FROM_STARTER_MONTHLY_PLAN_TEXT = "Continue with a monthly plan today for just $2/mo.";
    public static final String CANCEL_MODAL_FROM_STARTER_FULL_ACCESS_TEXT = "Get full access to all the benefits of Lesson Planet, with no annual commitment.\nYou may cancel your monthly membership at any time.";
    public static final String CANCEL_MODAL_FROM_STARTER_START_MY_MEMBERSHIP_TEXT = "Start my membership\ntoday for $2/mo.";

    public static final String CANCEL_MODAL_CHEAPER_TEXT = "Want to try a cheaper plan?";
    public static final String CANCEL_MODAL_TRIAL_TIME_TEXT = "10-Day\nFree Trial";
    public static final String CANCEL_MODAL_FROM_PRIME_COLLECTION_NO_TEXT = "20\nCollections";
    public static final String CANCEL_MODAL_FROM_PRIME_BILLED_ANNUALLY_TEXT = "* Billed annually at $24";

    public static final String CANCEL_MODAL_FROM_PRO_COLLECTION_NO_TEXT = "50\nCollections";
    public static final String CANCEL_MODAL_FROM_PRO_BILLED_ANNUALLY_TEXT = "* Billed annually at $36";

    public static final String SEARCH_STANDARDS_PAGE_PATH = "standards/search?utf8=%E2%9C%93&keywords=";
    public static final String SEARCH_EDTECH_PAGE_PATH = "professional-development/courses/search?utf8=%E2%9C%93&keywords=";

    public static final String YOU_ARE_NOT_ALLOWED_TO_USE_FEATURE_TEXT = "Sorry, you are not allowed to access that feature.";
    public static final String PLEASE_LOGIN_TO_ACCESS_THIS_PAGE_TEXT = "Please login to access this page.";
}
