package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TestData {

    public static final int LONG_TIMEOUT = 10;
    public static final int SHORT_TIMEOUT = 5;
    public static String SERVER_URL = "https://staging.lessonplanet.com/";
    public static final String FEATURE_URL = "https://feature.lessonplanet.com/";
    public static boolean IP_IS_WHITELISTED = true;
    public static final String EMPTY_URL = "about:blank";
    public static final Locale LOCALE = java.util.Locale.US;
    public static final String STAGING_SERVER_QA_INTEGRATION_COOKIE_NAME = "qa_integration";
    public static final String STAGING_SERVER_SHARED_RESOURCE_REDIRECT_URL = "https://staging.lessonplanet.com/drive/documents/";
    public static final String STAGING_SERVER_SHARED_RESOURCE_URL = "https://s3.amazonaws.com/dev-lessonplanet-files/drive/";
    public static final String STAGING_SERVER_SHARED_RESOURCE_URL_2 = "https://staging.lessonplanet.com/goto/";

    //Paths
    public static final String LP_HOME_PAGE_PATH = "";
    public static final String STEP_ONE_PAGE_PATH = "subscription/new";
    public static final String STEP_TWO_PAGE_PATH = "subscription/new";
    public static final String LOGIN_PAGE_PATH = "auth/users/sign_in";
    public static final String SUBSCRIPTION_SUCCESS_PATH = "subscription/success";
    public static final String MY_ACCOUNT_PAGE_PATH = "profile/account";
    public static final String DISCOVER_RESOURCES_PAGE_PATH = "search";
    public static final String MANAGE_MEMBERSHIP_PAGE_PATH = "subscription/edit";
    public static final String CUSTOM_MEMBERSHIP_PAGE_PATH = "cancellation/new";
    public static final String CURRICULUM_MANAGER_PATH = "my/curriculum_manager";
    public static final String CURRICULUM_PLAYER_PATH = "/player";
    public static final String SEARCH_PAGE_SHARED_RESOURCES_PATH = "search?provider_ids[]=1&layout=thumbnail&type_ids[]=357927&subject_ids[]=196";

    //Collection Builder
    public static final String EXISTING_RESOURCE_COLLECTION_ERROR_TEXT = "Resource already in collection";
    public static final String COLLECTION_BUILDER_LINK = "https://en.wikipedia.org/wiki/World_War_I";
    public static final String DISABLED_PUBLISH_UPLOADED_FILE_POPOVER_TEXT = "Resource publishing is not yet available for your Site License";
    public static final String COLLECTION_BUILDER_CREATE_OR_OPEN_DROPDOWN_TEXT = "Create or Open";
    public static final String COLLECTION_BUILDER_UPGRADE_YOUR_MEMBERSHIP_TEXT = "Upgrade your membership to add more collections";
    public static final String COLLECTION_BUILDER_DRAG_AND_DROP_TEXT = "Drag & Drop resources from the left here";
    public static final String COLLECTION_BUILDER_EMPTY_TEXT = "Get started: Choose a Folder above or create a new one";

    public static final String COLLECTION_PLAYER_PAGE_PATH_1 = "users/";
    public static final String COLLECTION_PLAYER_PAGE_PATH_2 = "/collections/";
    public static final String COLLECTION_PLAYER_PAGE_PATH_3 = "/player";

    //Curriculum Calendar Page
    public static final String SEARCH_PAGE_PATH = "search?keywords=";
    public static final String CALENDAR_TITLE = " Curriculum Calendar - Lesson Plan Ideas by Date";
    public static final String CALENDAR_DECRIPTION = "Enhance your current curriculum with this fun reference calendar. Whether you want to highlight historic events, honor birthdays of significant people, or celebrate holidays, this is a valuable tool for every teacher. Click on any event to find a breadth of related teaching resources that will spark new ideas to spice up your daily lessons. There's something worth celebrating every day!";
    public static final String[] MONTH = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public static final String[] KEYWORD = {"", "Creativity", "Black History", "Women's History", "Poetry", "Mental Health", "Dairy", "Watermelon", "Immunization", "Hispanic Heritage", "Bullying", "Native Americans", "Human Rights"};

    //Publish Modal
    public static final String PRIVATE_DOCUMENTS_MODAL_TITLE_TEXT = "Private Documents";
    public static final String PUBLISH_FOLDER_WITH_FOLDER_MODAL_TEXT = "This Folder contains other Folder items, which are currently not supported with publishing. Select “Continue” to publish the folder without these items.";

    //Articles Page
    public static final String LESSON_PLANNING_ARTICLES_TITLE = "Lesson Planning Articles";
    public static final String ART_AND_MUSIC_TOPIC_PATH = "articles/art-and-music";
    public static final String ART_AND_MUSIC_TOPIC_TITLE = "Art and Music Education Articles for Teachers";
    public static final String ART_AND_MUSIC_ARTICLE_GUIDE_SECTION_TITLE = "Art and Music Guide";
    public static final String ARTICLE_TOPICS = "Article Topics\n" + "Art and Music\n" + "Art\n" + "Arts and Crafts\n" + "Drama\n" + "Elementary Art\n" + "Music\n" + "Computers\n" + "Education\n" + "Alternative Education\n" + "Early Childhood Education\n" + "Educational Technology\n" + "Gifted And Talented Education\n" + "Higher Education\n" + "Homeschooling\n" + "Kindergarten\n" + "Parent Resources\n" + "Special Education\n" + "Teacher Education\n" + "Teacher Resources\n" + "Test Preparation\n" + "Geography\n" + "World Cultures\n" + "Health\n" + "Careers\n" + "Mental Health\n" + "Nutrition\n" + "Nutrition and Diet\n" + "Personal Growth\n" + "Physical Education\n" + "Language Arts\n" + "Calendar\n" + "Elementary Language Arts\n" + "English\n" + "ESL\n" + "Foreign Languages\n" + "Grammar\n" + "Literature\n" + "Middle School Writing\n" + "Poetry\n" + "Reading\n" + "Writing\n" + "Writing Technique\n" + "Math\n" + "Algebra\n" + "Arithmetic\n" + "Elementary Math\n" + "Science\n" + "Biology\n" + "Earth Science\n" + "Elementary Science\n" + "Environment\n" + "Life Science\n" + "Marine Science\n" + "Physics\n" + "Seasons\n" + "Space\n" + "Technology\n" + "Social Studies\n" + "Civics\n" + "Economics\n" + "Economics and Business\n" + "Elementary Social Studies\n" + "Family History\n" + "Government\n" + "History\n" + "Holidays\n" + "U.S. Government\n" + "U.S. History\n" + "Teacher Resources\n" + "Professional Development\n" + "Teacher Tools\n" + "Technology\n" + "Technology Integration\n" + "Seasonal Articles";

    //Limited Resource Access
    public static final String LIMITED_RESOURCE_ACCESS_TITLE = "Limited Resource Access";
    public static final String LIMITED_RESOURCE_ACCESS_MODAL_TEXT = "Your access is limited to";

    //Edit collection
    public static final String EDIT_COLLECTION_TITLE = "Edit Folder";
    public static final String CREATE_A_NEW_COLLECTION_TITLE = "Create a New Collection";
    public static final String PIXABAY_IMAGE_TITLE = "Mango";
    public static final String PAGE_TITLE = "Page Title";
    public static final String UPDATED_NOTIFICATION_TEXT = "was successfully updated.";
    public static final String IMAGES_ADDED_NOTIFICATION_TEXT = "Images added to collection.";
    public static final String LIMIT_ALERT_PIXABAY_NOTIFICATION_TEXT = "You can't add more than 10 images at once";
    public static final String IMAGE_ALREADY_IN_COLLECTION_NOTIFICATION_TEXT = "Image already in collection";
    public static final String PIXABAY_IMAGE_LINK = "https://pixabay.com/";
    public static final String LEARN_MORE_LINK = "https://pixabay.com/service/faq/";
    public static final String CSL_PUBLISHED_COLLECTION_NOTIFICATION_TEXT = "Folder has been added to";
    public static final String CREATE_A_NEW_FOLDER_MODAL_TITLE = "Create a New Folder";
    public static final String COLLECTION_NOT_PUBLISHED_MODAL_TEXT = "Sorry, your folder was not published because it does not include at least two resources.";
    public static final String COLLECTION_NOT_PUBLISHED_MODAL_TITLE = "Folder not published!";
    public static final String FOLDER_NOT_PUBLISHED_TEXT = "This folder has not been published.";
    public static final String FOLDER_DEFAULT_STATUS = "This folder is private";
    public static final String FOLDER_PUBLISHED_STATUS_TEXT = "A version of it was published on ";
    public static final String FOLDER_CHANGES_SAVED_TEXT = "Changes saved";
    public static final String EDIT_FOLDER_UPGRADE_UPLOAD_TEXT = "Upgrade your membership  to upload your original curriculum to Lesson Planet.\n" +
        "Uploaded files can be managed and shared in My Resources.";

    //Add a Resource
    public static final String ADD_A_RESOURCE_PATH = "/content-tool/resources/new";
    public static final String ADD_A_RESOURCE_RESOURCE_TYPE = "Interactive";
    public static final String ADD_A_RESOURCE_TITLE = "TestNewResource" + GET_CURRENT_TIME();
    public static final String RESOURCE_URL_PLACEHOLDER_TEXT = "Paste a resource URL";
    public static final String TITLE_PLACEHOLDER_TEXT = "Provide a title";
    public static final String RESOURCE_TYPE_PLACEHOLDER_TEXT = "Select a resource type";
    public static final String SUBJECT_PLACEHOLDER_TEXT = "Select a subject";
    public static final String GRADE_PLACEHOLDER_TEXT = "Select a grade level";
    public static final String RATING_PLACEHOLDER_TEXT = "Select a rating";
    public static final String RATING_I_ICON_POPOVER_TEXT = "This resource will have a default rating of 4 stars unless otherwise selected.";
    public static final String CONCEPT_PLACEHOLDER_TEXT = "Select a concept";
    public static final String CONCEPT_I_ICON_POPOVER_TEXT = "Select and start typing to see a list of available concepts. If you can't find the one you are looking for, consider adding your custom concept as an additional tag.";
    public static final String ADDITIONAL_TAG_PLACEHOLDER_TEXT = "Provide additional tags";
    public static final String ADDITIONAL_TAG_I_ICON_POPOVER_TEXT = "Add any tags, separated by a comma, to this list. These tags will help this resource display on the Search Results page.";
    public static final String DESCRIPTION_PLACEHOLDER_TEXT = "Provide an overview of the resource including its intended use and the topic it covers";
    public static final String DESCRIPTION_I_ICON_POPOVER_TEXT = "Provide an overview of the resource including tips for use and keywords. We request a minimum of 100 characters.";
    public static final String DISABLED_FINISH_BUTTON_POPOVER_TEXT = "Fill in all the required fields and correct any errors";
    public static final String ADD_A_RESOURCE_STEP_TITLE = "Add a Resource";
    public static final String ADD_A_THUMBNAIL_STEP_TITLE = "Add a Thumbnail";
    public static final String ADD_STANDARDS_INFO_STEP_TITLE = "Add Standards Info";
    public static final String ADD_ADDITIONAL_INFO_TITLE = "Add Additional Info";
    public static final String UPLOADED_FILE_TITLE_TEXT = "test-upload-file.png";
    public static final String THUMBNAIL_IMAGE_URL = "https://images.pexels.com/photos/36717/amazing-animal-beautiful-beautifull.jpg?auto=compress&cs=tinysrgb&dpr=1&w=500";
    public static final String ADD_RESOURCE_NOTIFICATION = "Resource is currently being processed\n" + "×";
    public static final String UPDATE_RESOURCE_NOTIFICATION = "Resource was successfully updated\n" + "×";
    public static final String REMOVE_RESOURCE_NOTIFICATION = "Resource scheduled for removal\n" + "×";
    public static final String NGSS_STANDARDS = "PS2";
    public static final String NGSS_STANDARDS_PLACEHOLDER_TEXT = "Select NGSS identifiers";
    public static final String CCSS_STANDARDS = "CCRA.R.1";
    public static final String CCSS_STANDARDS_PLACEHOLDER_TEXT = "Select CCSS identifiers";
    public static final String STATE_STANDARDS = "3a";
    public static final String STATE_STANDARDS_PLACEHOLDER_TEXT = "Select a state standard identifiers";
    public static final String RESOURCE_URL = "https://en.wikipedia.org/wiki/Timeline_of_World_War_II" + GET_CURRENT_TIME();
    public static final String INSTRUCTIONAL_STRATEGY = "Demonstration";
    public static final String LANGUAGE = "English";
    public static final String RATING_VALUE = "5";
    public static final String YEAR = "2017";
    public static final String LEXILE = "30";
    public static final String ACCESSIBILITY = "High Contrast";
    public static final String DURATION = "1 hour";
    public static final String USAGE_PERMISSIONS = "NC-ND";
    public static final String USAGE_PERMISSIONS_I_ICON_POPOVER_TEXT = "Select and start typing to find a list of usage permissions";
    public static final String CUSTOM_LICENCE_LINK_I_ICON_POPOVER_TEXT = "First select usage permissions and then paste a URL link to the terms of use page";
    public static final String AUDIENCE_I_ICON_POPOVER_TEXT = "The default entry is \"For Teacher Use\". However, you may edit this field.";
    public static final String INSTRUCTIONAL_STRATEGY_I_ICON_POPOVER_TEXT = "Select and start typing to find a list of instructional strategies";
    public static final String LANGUAGE_I_ICON_POPOVER_TEXT = "Select language resource is written in";
    public static final String PROS_I_ICON_POPOVER_TEXT = "Provide a bulleted list of pros for this resource";
    public static final String CONS_I_ICON_POPOVER_TEXT = "Provide a bulleted list of cons for this resource";
    public static final String INSTRUCTIONAL_IDEAS_I_ICON_POPOVER_TEXT = "What ideas do you have for using this resource?";
    public static final String CLASSROOM_CONSIDERATIONS_I_ICON_POPOVER_TEXT = "Is there anything another educator should consider before using this resource?";
    public static final String AUTHOR_PLACEHOLDER_TEXT = "Provide an author name";
    public static final String PUBLISHER_PLACEHOLDER_TEXT = "Provide a publisher name";
    public static final String USAGE_PERMISSIONS_PLACEHOLDER_TEXT = "Select usage permissions";
    public static final String AUDIENCE_PLACEHOLDER_TEXT = "Select the intended audience";
    public static final String INSTRUCTIONAL_STRATEGY_PLACEHOLDER_TEXT = "Select an instructional strategy";
    public static final String LANGUAGE_PLACEHOLDER_TEXT = "Select the language(s) in which the resource is written";
    public static final String YEAR_PLACEHOLDER_TEXT = "Select a publication year";
    public static final String DURATION_PLACEHOLDER_TEXT = "Select a duration";
    public static final String EDIT_RESOURCE_PAGE_TITLE = "Edit Resource";

    //Curriculum Manager
    public static final String CURRICULUM_MANAGER_PAGE_TITLE = "Curriculum Manager";
    public static final String MY_RESOURCES_PAGE_TITLE = "My Resources";
    public static final String UPGRADE_MODAL_TEXT_FROM_EXCEEDED_ITEMS_INSIDE_CREATED_FOLDER = "You've reached your 10-resource limit for this folder, but don't let that stop you!\n" + "Upgrade today to create more folders of any size and enjoy the benefits of full membership.";
    public static final String UPGRADE_MODAL_TEXT_FROM_EXCEEDED_ITEMS_INSIDE_SAVED_FOLDER = "As a Free Member you can only save folders with up to 10 items...but don't let that stop you!\n" + "Upgrade today to save unlimited folders, and enjoy the benefits of a Full Membership.";
    public static final String UPGRADE_MODAL_TEXT_FROM_MAX_FOLDER_LIMIT = "You've reached your 3-folder limit, but don't let that stop you!\n" + "Upgrade today to create more folders and enjoy the benefits of full membership.";
    public static final String UPGRADE_MODAL_TEXT_FROM_UPLOAD_BUTTON = "Uploading and storing files are not supported by your Free Membership.\n" + "Upgrade today to upload and store your own materials on Lesson Planet.\n" + "For access anytime, anywhere!";
    public static final String UPGRADE_MODAL_TEXT_FROM_ASSIGN_BUTTON = "You`re ready to go PRO.\n" + "Upgrade to a Pro Membership to unleash the power of assigning!";
    public static final String UPGRADE_MODAL_TEXT_FROM_PLAY_BUTTON = "Let's do it!\n" + "Upgrade your membership to unleash the power of the Resource Player.";
    public static final String ASSIGN_RESOURCE_MODAL_TEXT = "Resource Player to students or share with colleagues, please enter a case-sensitive access key below";
    public static final String ASSIGN_FOLDER_PLAYER_MODAL_TEXT = "Folder Player to students or share with colleagues, please enter a case-sensitive access key below.";

    public static final String ASSIGN_FOLDER_MODAL_TEXT = "Folder Player to students or share with colleagues, please enter a case-sensitive access key below";
    public static final String RESOURCE_ADDED_TO_FOLDER_MESSAGE = "Resource(s) added to your folder. Click here to Edit your Folder.";
    public static final String RESOURCE_ADDED_TO_FAVORITES_MESSAGE = "This resource review was added to your Favorites. Click here to view your Favorites.";
    public static final String COLLECTION_ADDED_TO_CURRICULUM_MANAGER = "This Collection was added to your Curriculum Manager. Click here to view and remix this Collection.";
    public static final String REMOVED_FAVORITE_RESOURCE_MESSAGE = "was removed from \"My Favorites\"";
    public static final String CREATED_MESSAGE = "was created";
    public static final String COPIED_MESSAGE = "was copied";
    public static final String REMOVED_MESSAGE = "was removed";
    public static final String ZERO_RESOURCES = "(0)";
    public static final String ONE_RESOURCES = "(1)";
    public static final String TWO_RESOURCES = "(2)";
    public static final String NEW_COLLECTION_NAME = "Test Collection";
    public static final String REPLACED_COLLECTION_NAME = "ReplacedColection";
    public static final String NEW_FOLDER_NAME = "Test Folder";
    public static final String EDIT_TITLE = "-edit";
    public static final String UPLOAD_RESOURCE_TITLE = "test-upload-file";
    public static final String UPLOAD_RESOURCE_EDIT_TITLE = UPLOAD_RESOURCE_TITLE + EDIT_TITLE;
    public static final String COPIED_FOLDER_NAME = "Copy of " + NEW_FOLDER_NAME;
    public static final String NEW_COLLECTION_DESCRIPTION = "testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 ";
    public static final String PUBLISH_RESOURCE_TITLE = "test publish resource";
    public static final String EDIT_COLLECTION_GRADE_HIGHER_ED = "Higher Ed";
    public static final String EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION = "Special Education & Program: Special Education";
    public static final String UPLOAD_YOUR_FILE_GRADE = "Higher Ed";
    public static final String UPLOAD_YOUR_FILE_SUBJECT = "Special Education & Program: Special Education";
    public static final String UPLOAD_YOUR_FILE_RESOURCE_TYPE = "Interactives";
    public static final String PLAY_FOLDER_WITH_NO_ITEMS_POPOVER_TEXT = "Please add items to play this folder";
    public static final String PLAY_FOLDER_WITH_ITEMS_POPOVER_TEXT = "Play Folder";
    public static final String PUBLISH_FOLDER_WITH_NO_ITEMS_POPOVER_TEXT = "This folder needs additional information in order to publish. Select the Edit button to continue.";
    public static final String PUBLISH_FOLDER_WITH_ITEMS_POPOVER_TEXT = "Publish to make visible to others";
    public static final String PUBLISH_FOLDER_ADDITIONAL_INFORMATION_TEXT = "This folder needs additional information in order to publish. Select the Edit button to continue.";
    public static final String COPIED_POPOVER_TEXT = "Copied!";
    public static final String PUBLISHED_STATUS = "Published";
    public static final String PRIVATE_STATUS = "Private";
    public static final String PRIVATE_AND_PUBLISHED_STATUS = PRIVATE_STATUS + ", " + PUBLISHED_STATUS;
    public static final String FREE_SAMPLE_RESOURCE_STATUS = "LP Free Sample";
    public static final String REGULAR_RESOURCE_STATUS = "LP Reviewed";
    public static final String SHARED_RESOURCE_STATUS = "Member Shared";
    public static final String PUBLISHED_RESOURCE_STATUS = "Published";
    public static final String FACEBOOK_URL = "https://www.facebook.com";
    public static final String TWITTER_URL = "https://twitter.com";
    public static final String GOOGLE_URL = "google.com";
    public static final String RATING = "5";
    public static final String AUDIENCE = "For Teacher Use";
    public static final String CONCEPT = "Articles";
    public static final String ADDITIONAL_TAGS = "auto";
    public static final String[] FOLDER_TYPE = {"Collections", "Curriculum Sets", "Chapters", "Lessons", "Assessment Sets", "Unit Modules", "Course Folders", "Root Folders"};
    public static final String MOVED_MESSAGE = "was moved";
    public static final String NEW_FOLDER_DESCRIPTION = "testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123 testAutomation 123";
    public static final String LESSON_FOLDER_TYPE = "Lesson";
    public static final String CHAPTER_FOLDER_TYPE = "Chapter";
    public static final String COLLECTION_FOLDER_TYPE = "Collection";
    public static final int CURRICULUM_MANAGER_PAGINATION_MAX_FOLDERS = 20;

    public static final String SHARED_FOLDER_NAME = "Shared Folder";
    public static final String SHARED_WITH_ME_PAGE_PERMISSION_VIEW_ONLY = "View only";
    public static final String SHARED_WITH_ME_PAGE_NOTIFICATION_TEXT = "is now shared.";
    public static final String SHARED_WITH_ME_PAGE_EMPTY_TEXT = "When resources are shared with you, they will be listed here";
    public static final String SHARED_WITH_ME_PAGE_PATH = "my/shared_with_me";
    public static final String SHARED_WITH_ME_PAGE_FOLDER_STATUS = "Shared by";
    public static final String SHARE_FOLDER_MODAL_FOLDER_PRIVATE_STATUS = "This folder is currently: Private";
    public static final String SHARE_FOLDER_MODAL_FOLDER_SHARED_STATUS = "This folder is currently: Shared";
    public static final String SHARE_FOLDER_MODAL_TITLE = "Share Folder";
    public static final String SHARE_FOLDER_MODAL_SHARE_WITH_TEXT = "Share folder with these people:";
    public static final String SHARE_FOLDER_MODAL_OWNER_ROLE = "Owner";
    public static final String SHARE_FOLDER_MODAL_RSL_OWNER_NAME = "Connor Kyle";
    public static final String SHARE_FOLDER_MODAL_CSL_OWNER_NAME = "Henry Thomas";
    public static final String SHARE_FOLDER_MODAL_ADD_EMAIL_INPUT_PLACEHOLDER_TEXT = "Start typing email address to select";
    public static final String SHARE_FOLDER_MODAL_NO_USER_FOUND_TEXT = "No results found.";
    public static final String SHARE_FOLDER_MODAL_DEFAULT_PERMISSION_TEXT = "Can View";

    //Footer
    public static final String EDIT_A_COLLECTION_PAGE_PATH = "us/videos?autoplay=collections_edit";
    public static final String ASSIGN_TO_STUDENTS_PAGE_PATH = "us/videos?autoplay=how_to_share_collections";
    public static final String MANAGE_MY_RESOURCES_PAGE_PATH = "us/videos?autoplay=curriculum_manager";
    public static final String SHARING_WITH_OTHERS_PAGE_PATH = "us/videos?autoplay=how_to_share_collections";

    public static final String OUR_REVIEW_PROCESS_PAGE_PATH = "educator-edition?review-process";
    public static final String HOW_IT_WORKS_PAGE_PATH = "us/videos?autoplay=review";
    public static final String HOW_TO_SEARCH_PAGE_PATH = "us/videos?autoplay=search";
    public static final String CREATE_A_COLLECTION_PAGE_PATH = "us/videos?autoplay=collections_how_to";

    public static final String LINKEDIN_URL = "linkedin.com";
    public static final String[] LESSON_PLANET_TEXT = {"lessonplanet", "lesson-planet", "LessonPlanet"};
    public static final String YOUTUBE_URL = "youtube.com";
    public static final String YOUTUBE_CHANNEL_PATH = "channel/UCYEvQfQB9GAgCWUS7HsVh2A";
    public static final String PINTEREST_URL = "pinterest.com";

    public static final String SITE_MAP_PAGE_PATH = "content/site_map";
    public static final String PRIVACY_POLICY_PAGE_PATH = "privacy-policy";
    public static final String TERMS_OF_USE_PAGE_PATH = "terms-of-use";

    public static final String SUBSCRIPTION_MODAL_TEXT = "Thank you for subscribing to Lesson Planet News.";

    public static final String INVALID_EMAIL = "bla@bla.com";
    public static final String INVALID_PASSWORD = "J*(Y@D#DfJVnd*(^sd";
    public static final String VALID_EMAIL_ADMIN = "admin";
    public static final String VALID_EMAIL_PRO = "pro-user@lp.com";
    public static final String VALID_EMAIL_STARTER = "starter-user@lp.com";
    public static final String VALID_PASSWORD = "test123";
    public static final String NEW_EMAIL_PREFIX = "i_";
    private static final String NEW_EMAIL_SUFFIX = "@lp.com";
    public static final String VALID_EMAIL_RSL_LAGUNA_SCHOOL = " i_o_rsl_laguna@lp.com";
    public static final String VALID_EMAIL_RSL_SBCEO = "i_o_rsl_sbceo@lp.com";
    public static final String VALID_EMAIL_CSL_HENRY = "i_o_csl_henry@lp.com";
    public static final String VALID_EMAIL_CSL_QA_CUSTOM = "i_o_csl_qa_custom@lp.com";
    public static final String VALID_EMAIL_CSL_COBB = "i_o_csl_cobb@lp.com";
    public static final String INVALID_LOGIN_OR_PASSWORD_MESSAGE = "Invalid login or password.";
    public static final String INVALID_EMAIL_MESSAGE = "Please provide a valid email address.";

    public static final String PLAN_VISITOR = "visitor";
    public static final String PLAN_FREEMIUM = "freemium";
    public static final String PLAN_STARTER = "starter_48_annual";
    public static final String PLAN_PRO = "video_pro_boclips_9";

    //Search Facet
    public static final String FACET_CONTENT_CURATORS = "Content Curators";
    public static final String FACET_PROVIDERS = "Providers";
    public static final String FACET_PROVIDERS_LESSONPLANET = "Lesson Planet";
    public static final String FACET_PROVIDERS_HENRY_COUNTRY_SCHOOLS = "Henry County Schools";
    public static final String FACET_PROVIDERS_COBB_COUNTRY_SCHOOLS = "CTLS";
    public static final String FACET_PROVIDERS_MCGRAW_HILL_EDUCATION = "McGraw-Hill Education";
    public static final String FACET_PROVIDERS_CLAIRMONT_PRESS = "Clairmont Press";
    public static final String FACET_CATEGORY_RESOURCES_TYPES = "Resource Types";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_FOLDER_TYPES = "Folder Types";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_UNIT_MODULES = "Unit Modules";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_CURRICULUM_SETS = "Curriculum Sets";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_COLLECTIONS_TYPES = "Collections";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_PRESENTATIONS = "Presentations";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_ARTICLES = "Articles";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS = "Lesson Plans";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_PRINTABLES_AND_TEMPLATES = "Printables & Templates";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_HANDOUTS_REFERENCES = "Handouts & References";
    public static final String FACET_CATEGORY_SUBJECTS = "Subjects";
    public static final String FACET_CATEGORY_SUBJECTS_TYPE_SOCIAL_STUDIES_AND_HISTORY = "Social Studies & History";
    public static final String FACET_CATEGORY_SUBJECTS_TYPE_SPECIAL_EDUCATION_AND_PROGRAMS = "Special Education & Programs";
    public static final String FACET_CATEGORY_SUBJECTS_TYPE_MATH = "Math";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_WEBSITES = "Websites";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_GRAPHICS_AND_IMAGES = "Graphics & Images";
    public static final String FACET_CATEGORY_RESOURCES_TYPE_VIDEOS = "Videos";
    public static final String FACET_CATEGORY_SUBJECTS_CLASSROOM_SUPPORT = "Classroom Support";
    public static final String FACET_CATEGORY_SUBJECTS_WORLD_LANGUAGES = "World Languages";

    public static final String RESOURCE_TYPE_PRESENTATION = "Presentation";
    public static final String RESOURCE_TYPE_VIDEO = "Video";
    public static final String RESOURCE_TYPE_AP_TEST_PREP = "AP Test Prep";
    public static final String RESOURCE_TYPE_GRAPHICS_AND_IMAGE = "Graphics & Image";
    public static final String RESOURCE_TYPE_WEBSITE = "Website";
    public static final String PRIMARY_SOURCES_TYPE = "Primary Sources";
    public static final String RESOURCE_TYPE_ARTICLE = "Article";
    public static final String RESOURCE_TYPE_LESSON = "Lesson Plan";

    //Account Manager
    public static final String DISTRICT_NAME_SL_POPOVER_TEXT = "If you'd like to change the district name, please contact Lesson Planet.";
    public static final String SCHOOL_NAME_SL_POPOVER_TEXT = "If you'd like to change the school name, please contact Lesson Planet.";
    public static final String SCHOOL_SHORT_NAME_POPOVER_TEXT = "This is a name your teachers and staff are used to seeing. It could be your school's initials or a shorter version of your school's name. 20 characters max.";
    public static final String DISTRICT_SL_SHORT_NAME_POPOVER_TEXT = "This is a name your teachers and staff are used to seeing. It could be your district's initials or a shorter version of your district's name. 20 characters max.";
    public static final String SCHOOL_SL_SHORT_NAME_POPOVER_TEXT = "This is a name your teachers and staff are used to seeing. It could be your school's initials or a shorter version of your school's name. 20 characters max.";
    public static final String ENABLED_EDIT_TEACHER_POPOVER_TEXT = "Edit Teacher";
    public static final String DISABLED_EDIT_TEACHER_POPOVER_TEXT = "Teacher has already joined, and information cannot be edited.";
    public static final String ENABLED_EDIT_SCHOOL_ADMIN_POPOVER_TEXT = "Edit School Admin";
    public static final String DISABLED_EDIT_SCHOOL_ADMIN_POPOVER_TEXT = "School Admin has already joined, and information cannot be edited.";
    public static final String ENABLED_EDIT_DISTRICT_ADMIN_POPOVER_TEXT = "Edit District Admin";
    public static final String DISABLED_EDIT_DISTRICT_ADMIN_POPOVER_TEXT = "District Admin has already joined, and information cannot be edited.";
    public static final String ENABLED_EDIT_OWNER_POPOVER_TEXT = "Edit Owner";
    public static final String DISABLED_EDIT_OWNER_POPOVER_TEXT = "Owner has already joined, and information cannot be edited.";
    public static final String REMOVE_TEACHER_POPOVER_TEXT = "Remove Teacher";
    public static final String REMOVE_SCHOOL_ADMIN_POPOVER_TEXT = "Remove School Admin";
    public static final String REMOVE_DISTRICT_ADMIN_POPOVER_TEXT = "Remove District Admin";
    public static final String REMOVE_OWNER_POPOVER_TEXT = "Please contact Lesson Planet Member Services if you want to be removed from this organization";
    public static final String BULK_UPLOAD_SCHOOLS_POPOVER_TEXT = "To bulk upload multiple schools at once, download the CSV template here and add each school to the file. Once you're finished, upload the file here.";
    public static final String BULK_UPLOAD_TEACHERS_POPOVER_TEXT = "To bulk upload multiple Teachers at once, download the CSV template here and add each Teacher's email, first name, and last name. Once you're finished, upload the file here.";
    public static final String SHARING_PRIVILEGES_DISTRICT_POPOVER_TEXT = "This privilege gives a user the ability to publish collections to the learning object repository. The following options grant this privilege to users district-wide. To apply this privilege more selectively use the school-level or user-level settings.";
    public static final String SHARING_PRIVILEGES_SCHOOL_POPOVER_TEXT = "Applying this privilege gives a user the ability to publish collections to the learning object repository. If the options below are unavailable, they have been preset at the district level.";
    public static final String PUBLISHING_PRIVILEGES_POPOVER_TEXT = "Applying this privilege gives a user the ability to publish collections to the learning object repository";
    public static final String REMOVE_TEACHER_ROSTER_ON_POPOVER_TEXT = "Teacher cannot be removed because it is managed by the Automated Rostering";
    public static final String REMOVE_OWNER_ROSTER_ON_POPOVER_TEXT = "Please contact Lesson Planet Member Services if you want to be removed from this organization";
    public static final String REMOVE_DISTRICT_ADMIN_ROSTER_ON_POPOVER_TEXT = "District Admin cannot be removed because it is managed by the Automated Rostering";
    public static final String ADD_SCHOOLS_ROSTER_ON_BUTTON_POPOVER_TEXT = "Automated rostering is enabled. Please contact your system administrator to add a new school.";
    public static final String ADD_TEACHERS_BUTTON_ROSTER_ON_POPOVER_TEXT = "Automated rostering is enabled. Please contact your system administrator to add a new teacher.";
    public static final String ADD_SCHOOL_ADMIN_BUTTON_ROSTER_ON_POPOVER_TEXT = "Automated rostering is enabled. Please contact your system administrator to add a new school admin.";
    public static final String ADD_DISTRICT_ADMIN_ROSTER_ON_NOTIFICATION_TEXT = "You cannot add admins to an organization if they're not a teacher first";
    public static final String STAR_ICON_ROSTER_ON_POPOVER_TEXT = "This user was individually added to this list by an administrator, not as part of an automatic roster update.";

    public static final String RSL_LAGUNA_SCHOOL_NAME = "Laguna Blanca School";
    public static final String RSL_LAGUNA_SCHOOL_EXISTING_TEACHER_EMAIL = "i_t_rsl_laguna@lp.com";
    public static final String RSL_LAGUNA_SCHOOL_TEACHER_FIRST_NAME = "Stephen";
    public static final String RSL_LAGUNA_SCHOOL_TEACHER_LAST_NAME = "Carl";
    public static final String RSL_LAGUNA_SCHOOL_OWNER_FIRST_NAME = "Abbey";
    public static final String RSL_LAGUNA_SCHOOL_LAST_NAME = "Lilian";
    public static final String RSL_SBCEO_DISTRICT_NAME = "SBCEO";
    public static final String RSL_SBCEO_EXISTING_SCHOOL_NAME = "All SBCEO";
    public static final String RSL_SBCEO_EXISTING_TEACHER_EMAIL = "i_t_rsl_sbceo@lp.com";
    public static final String RSL_SBCEO_EXISTING_DISTRICT_ADMIN_EMAIL = "i_da_rsl_sbceo@lp.com";
    public static final String RSL_SBCEO_OWNER_FIRST_NAME = "Connor";
    public static final String RSL_SBCEO_OWNER_LAST_NAME = "Kyle";
    public static final String RSL_SBCEO_TEACHER_FIRST_NAME = "William";
    public static final String RSL_SBCEO_TEACHER_LAST_NAME = "Damian";
    public static final String RSL_SBCEO_DA_FIRST_NAME = "Lisa";
    public static final String RSL_SBCEO_DA_LAST_NAME = "Michaels";
    public static final String CSL_HENRY_DISTRICT_NAME = "Henry County Schools";
    public static final String CSL_HENRY_EXISTING_SCHOOL_NAME = "LP Elementary";
    public static final String CSL_HENRY_EXISTING_TEACHER_EMAIL = "i_t_csl_henry@lp.com";
    public static final String CSL_HENRY_EXISTING_DA_EMAIL = "i_da_csl_henry@lp.com";
    public static final String CSL_HENRY_OWNER_FIRST_NAME =  "Henry";
    public static final String CSL_HENRY_OWNER_LAST_NAME = "Thomas";
    public static final String CSL_HENRY_DA_FIRST_NAME = "Borris";
    public static final String CSL_HENRY_DA_LAST_NAME = "Thompson";
    public static final String CSL_HENRY_TEACHER_FIRST_NAME = "George";
    public static final String CSL_HENRY_TEACHER_LAST_NAME = "Reese";
    public static final String CSL_QA_CUSTOM_DISTRICT_NAME = "QA Custom SL Test";
    public static final String CSL_QA_CUSTOM_EXISTING_SCHOOL_NAME = "rita's school 11";
    public static final String CSL_PARENTS_SCHOOL_NAME = "Parents School";
    public static final String CSL_QA_CUSTOM_EXISTING_TEACHER_EMAIL = "i_t_csl_qa_custom@lp.com";
    public static final String CSL_QA_CUSTOM_OWNER_FIRST_NAME = "Michelle";
    public static final String CSL_QA_CUSTOM_OWNER_LAST_NAME = "Tracey";
    public static final String CSL_QA_CUSTOM_TEACHER_FIRST_NAME = "Jones";
    public static final String CSL_QA_CUSTOM_TEACHER_LAST_NAME = "Smith";
    public static final String CSL_COBB_SCHOOL_DISTRICT_NAME = "Cobb County School District";
    public static final String CSL_COBB_SCHOOL_DISTRICT_EXISTING_SCHOOL_NAME = "Cobb Online Learning Academy - HS";
    public static final String CSL_COBB_EXISTING_TEACHER_EMAIL = "i_t_csl_cobb@lp.com";
    public static final String CSL_COBB_OWNER_FIRST_NAME = "Jane";
    public static final String CSL_COBB_OWNER_LAST_NAME = "Maryland";
    public static final String CSL_COBB_TEACHER_FIRST_NAME = "Anthony";
    public static final String CSL_COBB_TEACHER_LAST_NAME = "Simpson";
    public static final String TEACHER_ROLE = "Teacher";
    public static final String ADMIN_ROLE = "Admin";
    public static final String OWNER_ROLE = "Owner";
    public static final String PUBLISHER_ROLE = "Publisher";
    public static final String MANAGE_DISTRICT_ADMINS_TITLE = "Manage District Admins";
    public static final String MANAGE_SCHOOL_ADMINS_TITLE = "Manage School Admins";
    public static final String UNREGISTERED_TEACHER_STATUS = "Not Active";

    public static final String NO_SEARCH_RESULTS_TEXT = "There were no results found";
    public static final String SEARCH_RESULTS_TEXT = "results were found for";

    public static final String REMOVE_DISTRICT_ADMIN_MODAL_TEXT = "If this District Admin is also a Teacher, their account will remain active with the Teacher role. If this District Admin did not have another role, their account will be removed from this Site License.";
    public static final String REMOVE_SCHOOL_ADMIN_MODAL_TEXT = "If this School Admin is also a Teacher, their account will remain active with the Teacher role. Are you sure you want to remove this School Admin?";
    public static final String REMOVE_TEACHER_MODAL_TEXT = "If this Teacher is also registered as a Teacher at another school, their School Edition account will remain active at that school.";
    public static final String REMOVE_TEACHER_SCHOOL_SL_MODAL_TEXT = "Are you sure you want to remove this Teacher?";
    public static final String REMOVE_SCHOOL_MODAL_TEXT = "Are you sure you want to remove this school? If there are any teachers registered with this school, their accounts may be removed as well.";

    public static final String REQUIRED_FIELD_ERROR_TEXT = "This field is required";
    public static final String EXISTING_SCHOOL_ERROR_TEXT = "Already exists in this district";
    public static final String EXISTING_USER_ANOTHER_SL_ERROR_TEXT = "User present in another site license";
    public static final String EXISTING_DISTRICT_ADMIN_ERROR_TEXT = "The user is already a District Admin";
    public static final String VALID_EMAIL_FORMAT_ERROR_TEXT = "Please enter a valid email";
    public static final String NO_TEACHER_ADDED_NOTIFICATION_TEXT = "Welcome to School Edition. Let's get started by adding the first Teacher to your School";
    public static final String NO_SCHOOL_ADMIN_ADDED_NOTIFICATION_TEXT = "This school doesn't have a School Admin assigned. To assign one, please click here";
    public static final String CREATED_SCHOOL_NOTIFICATION_TEXT = "has been added to your district.";
    public static final String REMOVED_SCHOOL_NOTIFICATION_TEXT = "was removed from your district";
    public static final String CREATED_DISTRICT_ADMIN_NOTIFICATION_TEXT = "has been added as a District Admin";
    public static final String REMOVED_DISTRICT_ADMIN_NOTIFICATION_TEXT = "is no longer a District Admin";
    public static final String CREATED_SCHOOL_ADMIN_NOTIFICATION_TEXT = "has been added as a School Admin";
    public static final String REMOVED_SCHOOL_ADMIN_NOTIFICATION_TEXT = "is no longer a School Admin";
    public static final String CREATED_TEACHER_NOTIFICATION_TEXT = "has been added to your school";
    public static final String REMOVED_TEACHER_NOTIFICATION_TEXT = "was removed from your school";
    public static final String ADMIN_PUBLISH_SCHOOL_OPTION_TEXT = "All admins at this school have the ability to publish";
    public static final String TEACHER_PUBLISH_SCHOOL_OPTION_TEXT = "All teachers at this school have the ability to publish";
    public static final String ADMIN_PUBLISH_DISTRICT_OPTION_TEXT = "All admins in this district have the ability to publish";
    public static final String TEACHER_PUBLISH_DISTRICT_OPTION_TEXT = "All teachers in this district have the ability to publish";
    public static final String OWNER_PUBLISH_OPTION_TEXT = "This owner may publish collections to the learning object repository";
    public static final String DISTRICT_ADMIN_PUBLISH_OPTION_TEXT = "This district admin may publish collections to the learning object repository";
    public static final String SCHOOL_ADMIN_PUBLISH_OPTION_TEXT = "This school admin may publish collections to the learning object repository";

    public static final String STEP_ONE_PAGE_TITLE = "Ready to start your Free 10 Days?";
    public static final String STEP_ONE_MODAL_TITLE = "Discover 2.5 Million\n" + "Teacher Reviewed Resources";

    //Step 2
    public static final String SELECTED_TEXT = "Selected";
    public static final String SELECT_TEXT = "Select";

    public static final String STARTER_OPTION_TEXT = "Starter";
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

    public static final String THANK_YOU_FOR_UPDATING_TEXT = "Thank you for updating your profile! Enjoy using Lesson Planet.";

    public static final String FREE_MEMBERSHIP_TEXT = "Free Membership";

    //Credit card info STAGING
    public static final String FIRSTNAME = "FistnameTest";
    public static final String LASTNAME = "LastnameTest";
    public static final String CARD_NUMBER = "4012888888881881";
    public static final String INVALID_CARD_NUMBER = "5555555555555555";
    public static final String CARD_EXPIRATION = "09/23";
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

    public static String GET_NEW_SCHOOL_NAME() {
        return STARTER_OPTION_TEXT + GET_CURRENT_TIME();
    }

    public static String GET_CURRENT_TIME() {
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
        return Integer.parseInt(dateFormat.format(cal.getTime()));
    }

    public static int getCurrentYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    public static String getCurrentDateWithTimezone() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        return dateFormat.format(cal.getTime());
    }

    //Search data
    public static final String VALID_SEARCH_WORD = "math";
    public static final String INVALID_SEARCH_WORD = "maeybdhth";

    public static final String INVALID_SEARCH_MESSAGE = "We found 0 reviewed resources for " + INVALID_SEARCH_WORD;
    public static final int ZERO_RESOURCES_FOUND = 0;
    public static final String SEARCH_MESSAGE = "reviewed resources for ";
    public static final String VALID_SEARCH_MESSAGE = "We found %s reviewed resources for " + VALID_SEARCH_WORD;
    public static final String SEARCH_MESSAGE_FOUND_1 = "We found ";
    public static final String SEARCH_MESSAGE_FOUND_2 = " resources for ";
    public static final String SUGGESTIONS_BLOCK_MESSAGE = "Suggestions\nTry more general keywords\nClear all selections";
    public static final String SHOWING_ALL_REVIEWED_RESOURCES_MESSAGE = "Showing all reviewed resources";
    public static final String SHOWING_ALL_RESOURCES_MESSAGE = "Showing all resources";
    public static final String SEARCH_BOX_PLACEHOLDER_TEXT = "Search educational resources";

    public static final String REGULAR_RESOURCE_TYPE = "Resource";
    public static final String SHARED_RESOURCE_TYPE = "Drive::Document";

    //Footer
    public static final String SIGN_UP_HINT_TEXT = "Sign up for the Lesson Planet Monthly Newsletter";
    public static final String REQUIRED_EMAIL_ERROR_TEXT = "This field is required.";
    public static final String VALID_EMAIL_ERROR_TEXT = "Please enter a valid email address.";
    public static final String COPYRIGHT_TEXT = "© 1999-2021 Education Planet, Inc.\n" + "Teacher Lesson Plans, Worksheets and Resources";
    public static final String RSL_IFRAME_COPYRIGHT_TEXT = "© 2021 Learning Explorer";
    public static final String LEARNING_EXPLORER_PRIVACY_POLICY_URL = "https://www.learningexplorer.com/privacy-policy/";
    public static final String LEARNING_EXPLORER_TERMS_URL = "https://www.learningexplorer.com/terms";
    public static final String LEARNING_EXPLORER_HELP_URL = "https://www.learningexplorer.com/help-center";

    //RRPs
    public static final String DISABLED_TEXT = "more...";
    public static final String ALL_RESOURCE_TYPES_DROPDOWN = "Folder Types\n" + "Activities & Projects\n" + "Assessments\n" + "Graphics & Images\n" + "Handouts & References\n" + "Interactives\n" + "Lab Resources\n" + "Learning Games\n" + "Lesson Plans\n" + "Presentations\n" + "Primary Sources\n" + "Printables & Templates\n" + "Professional Documents\n" + "PD Courses\n" + "Study Guides\n" + "Units\n" + "Videos\n" + "Performance Tasks\n" + "Websites\n" + "Graphic Organizers\n" + "Worksheets\n" + "Workbooks\n" + "Writing Prompts\n" + "Constructed Response Items\n" + "Apps\n" + "AP Test Preps\n" + "Articles\n" + "Lesson Planet Articles\n" + "Audios\n" + "Courses\n" + "eBooks\n" + "Interactive Whiteboards\n" + "Home Letters\n" + "Rubrics\n" + "Syllabis\n" + "Unknown Types\n" + "All Resource Types";
    public static final String LESSON_PLANS_RESOURCE_TYPE = "Lesson Plans";
    public static final String LESSON_RESOURCE_TYPE_CARD = "Lesson";
    public static final String NO_RESOURCES_FOUND_TEXT = "No resources found.";
    public static final String[] SUBJECTS = {"Math", "Arithmetic & Pre-Algebra", "Algebra I", "Algebra II", "Geometry", "Trigonometry", "Pre-Calculus", "Calculus", "Statistics & Probability", "Consumer Math & Personal Finance", "General Math", "Science", "Agriculture", "Biology", "Chemistry", "Earth Science", "Environment", "Life Science", "Physical Science", "Physics", "Science Principles", "Space Science & Astronomy", "General Science", "English Language Arts", "Grammar", "Spelling & Vocabulary", "Speaking & Listening", "Reading: Foundational Skills", "Reading: Informational Text", "Reading: Literature", "Narrative Writing", "Expository Writing", "Persuasive Writing", "Poetry", "Fine Motor Skills", "ESL & ELD", "General Writing", "Reading & Visual Literacy", "General English Language Arts", "Social Studies & History", "Cultural & Social Studies", "Economics & Business", "Geography", "Government", "Holidays", "Philosophy", "Psychology", "General History", "Religion", "United States History", "World History", "Physical Education", "Activities & Sports", "Motor Skills & Movement", "Outdoor Education", "Physical Fitness", "Health", "Growth & Development", "Nutrition", "Sex Education", "Substance Abuse", "Wellness & Safety", "Visual & Performing Arts", "Art History", "Arts & Crafts", "Drama", "Dance", "Music", "Visual Arts", "Languages", "American Sign Language", "Arabic", "Chinese", "French", "German", "Italian", "Japanese", "Latin", "Portuguese", "Russian", "Spanish", "Hindi", "Other Languages", "STEM", "Computer Programming", "Engineering", "21st Century Skills", "Social & Emotional Learning", "Family & Consumer Sciences", "Career & Education & Skills", "Computer Skills", "Media Literacy", "Research Process", "Study Skills", "Digital Citizenship", "Classroom Support", "Classroom Management", "Learning Displays", "Classroom Tools", "Professional Development", "Special Education & Programs", "Special Education", "Social & Emotional Learning", "CASEL Competencies", "Mindfulness"};
    public static final String[] RESOURCE_TYPES = {"Collections", "Activities & Projects", "Standardized Tests", "Presentations", "Assessments", "Graphics & Images", "Handouts & References", "Interactives", "Lab Resources", "Learning Games", "Lesson Plans", "Presentations", "Primary Sources", "Printables & Templates", "Professional Documents", "PD Courses", "Study Guides", "Units", "Videos", "Performance Tasks", "Websites", "Graphic Organizers", "Worksheets", "Workbooks", "Writing Prompts", "Constructed Response Items", "Apps", "AP Test Preps", "Articles", "Lesson Planet Articles", "Audios", "Courses", "eBooks", "Interactive Whiteboards", "Home Letters", "Rubrics", "Syllabis"};
    public static final String START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE = "Save time and discover engaging curriculum for your classroom. Reviewed and rated by trusted, credentialed teachers.";
    public static final String START_YOUR_FREE_TRIAL_TEXT_SHARED_RESOURCE = "Save time and discover engaging curriculum for your classroom. Quickly find resources you need — reviewed and rated by trusted, credentialed teachers.";
    public static final String RATE_THIS_RESOURCE = "Rate this Resource";
    public static final String UPDATE_YOUR_RATING = "Update your Rating";
    public static final String ADD_A_REVIEW_EXISTING_REVIEW_TITLE = "Update your Rating";
    public static final String ADD_A_REVIEW_NO_REVIEW_TITLE = "Rate this Resource";
    public static final String ADD_A_REVIEW_SUBTITLE = "Rate this resource by selecting an apple";

    //Discovery page
    public static final int TOTAL_RESOURCES_PER_PAGE = 24;
    public static final int TOTAL_RESOURCES_PER_PAGE_STARTER_UNLOCKED = 18;
    public static final int TOTAL_RESOURCES_PER_PAGE_STARTER_LOCKED = 6;
    public static final String BROWSE_RESOURCE_DIRECTORY_PAGE_TITLE = "Educational Resources by Subject";
    public static final String BROWSE_RESOURCE_DIRECTORY_PAGE_PATH = "lesson-plans";
    public static final String SEARCH_BY_STANDARD_PAGE_PATH = "state-standards";
    public static final String CURRICULUM_MANAGER_PAGE_PATH = "my/curriculum_manager";
    public static final String CURRICULUM_MANAGER_FOLDERS_SUFIX_PATH = "/folders/";
    public static final String CURRICULUM_CALENDAR_PAGE_PATH = "calendar";
    public static final String LESSON_PLANNING_ARTICLES_PAGE_PATH = "articles";
    public static final String EDTECH_PROFESSIONAL_DEVELOPMENT_COURSES_PAGE_PATH = "professional-development/courses";

    public static final String EDUCATOR_EDITION_PAGE_PATH = "educator-edition";
    public static final String LEARNING_EXPLORER_URL = "https://www.learningexplorer.com/";
    public static final String PD_LEARNING_NETWORK_PATH = "pdln";

    public static final String CONTACT_US_PAGE_PATH = "us/contact";
    public static final String OUR_STORY_PAGE_PATH = "about";
    public static final String FAQ_PAGE_PATH = "faq";
    public static final String HELP_CENTER_FAQ_PATH = "help-center";
    public static final String TESTIMONIALS_PAGE_PATH = "us/testimonials";

    public static final String PRICING_PAGE_PATH = "pricing";

    public static final String MEMBER_PROFILE_PAGE_PATH = "profile";
    public static final String SEARCH_HISTORY_PAGE_PATH = "my/saved_searches";
    public static final String ACCOUNT_MANAGER_PAGE_PATH = "my/admin-manager/account/";

    public static final String HEALTH_PAGE_PATH = "lesson-plans/health";
    public static final String DEVELOPMENT_AND_BEHAVIORAL_DISORDERS_PATH = "lesson-plans/developmental-and-behavioral-disorders";
    public static final String LANGUAGE_ARTS_PAGE_PATH = "lesson-plans/language-arts";
    public static final String LANGUAGE_ARTS_RESEAERCH_PAGE_2_PATH = "lesson-plans/research/2";
    public static final String SOCIAL_AND_EMOTIONAL_LEARNING_PATH = "lesson-plans/social-and-emotional-learning";
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
    public static final String HEALTH_CATEGORY_MODAL_DEFAULT_TEXT = "Wellness & Safety\nSocial and Emotional Learning\nGrowth and Development\nSex Education";
    public static final String HEALTH_CATEGORY_MODAL_FIRST_CARET_EXPANDED_TEXT = "Wellness & Safety\nCommunication\nDisorders\nMental Disorders\nSocial and Emotional Learning\nNutrition\nConflict Resolution\nInjury Prevention and Safety\nPhysical Health\nSocial and Emotional Learning\nGrowth and Development\nSex Education";
    public static final String HEALTH_CATEGORY_MODAL_SECOND_CARET_EXPANDED_TEXT = "Wellness & Safety\nSocial and Emotional Learning\nAdverse Childhood Experiences\nSchool Culture & Climate\nCASEL Competencies\nMindfullness\nEquity & Access\nGrowth and Development\nSex Education";

    public static final String HEALTH_PAGE_TITLE = "Health Teacher Resources";
    public static final String LANGUAGE_ARTS_PAGE_TITLE = "Language Arts Teacher Resources";
    public static final String LANGUAGES_PAGE_TITLE = "Languages Teacher Resources";
    public static final String MATH_PAGE_TITLE = "Math Teacher Resources";
    public static final String PHYSICAL_EDUCATION_PAGE_TITLE = "Physical Education Teacher Resources";
    public static final String SCIENCE_PAGE_TITLE = "Science Teacher Resources";
    public static final String SOCIAL_STUDIES_PAGE_TITLE = "Social Studies Teacher Resources";
    public static final String SPECIAL_EDUCATION_PAGE_TITLE = "Special Education Teacher Resources";
    public static final String VISUAL_AND_PERFORMING_ARTS_PAGE_TITLE = "Visual and Performing Arts Teacher Resources";
    public static final String VIEW_ALL_LESSON_PLANS_PAGE_URL = "lesson-plans";

    public static final String WELLNESS_AND_SAFETY_PAGE_TITLE = "Wellness & Safety Teacher Resources";
    public static final String SOCIAL_EMOTIONAL_LEARNING_PAGE_TITLE = "Social and Emotional Learning Teacher Resources";
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

    public static final String BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT = "Browse by Subject\nHealth\nWellness & Safety\nSocial and Emotional Learning\nGrowth and Development\nSex Education";
    public static final String BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_FIRST_CARET_EXPANDED_TEXT = "Browse by Subject\nHealth\nWellness & Safety\nCommunication\nDisorders\nMental Disorders\nSocial and Emotional Learning\nNutrition\nConflict Resolution\nInjury Prevention and Safety\nPhysical Health\nSocial and Emotional Learning\nGrowth and Development\nSex Education";
    public static final String BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_SECOND_CARET_EXPANDED_TEXT = "Browse by Subject\nHealth\nWellness & Safety\nSocial and Emotional Learning\nAdverse Childhood Experiences\nSchool Culture & Climate\nCASEL Competencies\nMindfullness\nEquity & Access\nGrowth and Development\nSex Education";
    public static final String BROWSE_BY_SUBJECT_FOR_PHYSICAL_HEALTH_CATEGORY_TEXT = "Browse by Subject\nPhysical Health\nAutoimmune disease\nDental Health\nDental and Personal Hygiene\nHeart Condition\nPhysical Activity\nPersonal Health Management\nHospital\nSubstance Abuse";
    public static final String BROWSE_BY_SUBJECT_SUGGEST_A_CATEGORY_TEXT = "\nSuggest a Category";

    public static final String SUGGEST_A_CATEGORY_MODAL_TITLE = "Suggest a Category";

    public static final String SIDE_WIDGET_BROWSE_BY_SUBJECT_CATEGORIES = "Browse by Subject";
    public static final String SIDE_WIDGET_BROWSE_BY_SUBJECT_GROWTH_AND_DEVELOPMENT_TYPE = "Growth and Development";
    public static final String SIDE_WIDGET_BROWSE_BY_SUBJECT_PHYSICAL_HEALTH_TYPE = "Physical Health";

    public static final String GROWTH_AND_DEVELOPMENT_PAGE_PATH = "lesson-plans/growth-and-development";
    public static final String PHYSICAL_HEALTH_PAGE_PATH = "lesson-plans/physical-health";
    public static final String PHYSICAL_HEALTH_PAGE_TITLE = "Physical Health Teacher Resources";

    public static final String SIDE_WIDGET_START_YOUR_TEN_DAYS_FREE_TRIAL = "Start Your 10-Day Free Trial";
    public static final String SIDE_WIDGET_START_YOUR_TEN_DAYS_FREE_TRIAL_VISITOR_TEXT = "Start Your 10-Day Free Trial\nSearch 350,000+ online teacher resources.\nFind lesson plans, worksheets, videos, and more.\nInspire your students with great lessons.\nGet Free Trial";
    public static final String SIDE_WIDGET_START_YOUR_TEN_DAYS_FREE_TRIAL_FREEMIUM_TEXT = "Start Your 10-Day Free Trial\nSearch 350,000+ online teacher resources.\nFind lesson plans, worksheets, videos, and more.\nInspire your students with great lessons.\nGet Full Access";

    public static final String SIDE_WIDGET_RELATED_TOPICS = "Related Topics";
    public static final String SIDE_WIDGET_RELATED_TOPICS_STRESS_MANAGEMENT_OPTION = "Stress Management";
    public static final String SIDE_WIDGET_RELATED_TOPICS_STRESS_MANAGEMEMT_REDIRECT_PATH = "search?keywords=stress+management";
    public static final String SIDE_WIDGET_WHAT_MEMBERS_SAY = "What Members Say";

    public static final String FEEDBACKS_PAGE_PATH = "feedbacks/new";

    public static final String PAGINATION_FIRST_PAGE_PATH = "";
    public static final String PAGINATION_SECOND_PAGE_PATH = "/2";
    public static final String PAGINATION_ALL_ITEMS_PATH = "/all";

    public static final String ENGLISH_LANGUAGE_ARTS_PAGE_PATH = "standards/common-core/english-language-arts";
    public static final String MATHEMATICS_PAGE_PATH = "standards/common-core/mathematics";
    public static final String NGSS_PAGE_PATH = "state-standards/nrcdsc";
    public static final String COMMON_CORE_CORRELATED_RESOURCES_PAGE_PATH = "standards/resources/14310";

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

    public static final String CANCEL_MODAL_FROM_PRO_COLLECTION_NO_TEXT = "50\nLesson Collections";
    public static final String CANCEL_MODAL_FROM_PRO_BILLED_ANNUALLY_TEXT = "* Billed annually at $48";

    public static final String GET_FREE_ACCESS_BUTTON_TEXT = "Get Free Access";
    public static final String SEE_REVIEW_BUTTON_TEXT = "See Review";
    public static final String SEE_COLLECTION_BUTTON_TEXT = "See Collection";
    public static final String GO_TO_RESOURCE_BUTTON_TEXT = "Go to Resource";
    public static final String SEE_PREVIEW_BUTTON_TEXT = "See Preview";
    public static final String SEE_FULL_REVIEW_BUTTON_TEXT = "See Full Review";
    public static final String FREE_SAMPLE_BUTTON_TEXT = "Free: Full Access Review";
    public static final String OPEN_FOLDER_BUTTON_TEXT = "Open Folder";
    public static final String FOLDER_DETAILS_BUTTON_TEXT = "Folder Details";

    public static final String CONTENT_MANAGER_PAGE_TITLE_TEXT = "Content Manager";
    public static final String CONTENT_MANAGER_PAGE_SUBTITLE_TEXT = "View and manage your learning object repository";
    public static final String CONTENT_MANAGER_SORT_BY_DEFAULT_TEXT = "Sort By: Newest";

    public static final String CONTENT_MANAGER_RESOURCE_REDIRECT_PATH = "teachers/";
    public static final String CONTENT_MANAGER_CONCEPT_REDIRECT_PATH = "/content-tool?concept_ids=";
    public static final String CONTENT_MANAGER_STANDARD_REDIRECT_PATH = "standards/resources/";
    public static final String CONTENT_MANAGER_RESOURCES_FOR_TEXT = " resources found for ";

    public static final String OPEN_FOLDER_PATH = "pr/teachers/";

    public static final String DELETE_FOLDER_MODAL_TITLE_TEXT = "Please Confirm";
    public static final String DELETE_FOLDER_MESSAGE_TEXT = "Are you sure you want to delete this Folder?";

    public static final String INCORRECT_ACCESS_KEY_MESSAGE_TEXT = "Sorry, this access key is incorrect. Need help?";
}
