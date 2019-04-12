import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class DirectoryCategoriesAndSubcategoriesTest extends BaseTest {

    private LpHomePage lpHomePage;
    private LoginPage loginPage;
    private BrowseBySubjectPage browseBySubjectPage;
    private StartYourTenDayFreeTrialWidget startYourTenDayFreeTrialWidget;
    private WhatMembersSayWidget whatMembersSayWidget;
    private DiscoverResourcesPage discoverResourcesPage;
    private StepOneModal stepOneModal;
    private StepOnePage stepOnePage;
    private StepTwoPage stepTwoPage;
    private SuggestACategoryModal suggestACategoryModal;
    private HeaderPage headerPage;
    private RrpPage rrpPage;
    private ManageMembershipPage manageMembershipPage;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
        startYourTenDayFreeTrialWidget = new StartYourTenDayFreeTrialWidget(webDriver);
        whatMembersSayWidget = new WhatMembersSayWidget(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        stepOnePage = new StepOnePage(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        suggestACategoryModal = new SuggestACategoryModal(webDriver);
        headerPage = new HeaderPage(webDriver);
        rrpPage = new RrpPage(webDriver);
        manageMembershipPage = new ManageMembershipPage(webDriver);
    }

    @Test(description = "Visitor - Directory Page - Categories and subcategories - lessonp-1020:Page UI")
    public void testLessonp_1020() {
        testPageUi(TestData.INVALID_EMAIL);
    }

    @Test(description = "Freemium - Directory Page - Categories and subcategories - lessonp-1197:Page UI")
    public void testLessonp_1197() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testPageUi(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Active user - Directory Page - Categories and subcategories - lessonp-1209:Page UI")
    public void testLessonp_1209() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testPageUi(TestData.VALID_EMAIL_ADMIN);
    }

    @Test(description = "Visitor - Directory Page - Categories and subcategories - lessonp-1022:Resource Tiles")
    public void testLessonp_1022() {
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        Assert.assertEquals(browseBySubjectPage.getCountUnlockedResourcesInThumbnailMode(), TestData.TOTAL_RESOURCES_PER_PAGE);
        discoverResourcesPage.changeToTiledView();
        Assert.assertEquals(browseBySubjectPage.getCountUnlockedResourcesInTiledMode(), TestData.TOTAL_RESOURCES_PER_PAGE);
        discoverResourcesPage.changeToListView();
        Assert.assertEquals(browseBySubjectPage.getCountUnlockedResourcesInListMode(), TestData.TOTAL_RESOURCES_PER_PAGE);

        Assert.assertEquals(browseBySubjectPage.getCountFreeAccessButtons(), TestData.TOTAL_RESOURCES_PER_PAGE);
        Assert.assertEquals(browseBySubjectPage.getCountSeeReviewButton(), TestData.TOTAL_RESOURCES_PER_PAGE);

        browseBySubjectPage.clickGetFreeAccess(false);
        Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
        stepOneModal.clickCloseModal();

        browseBySubjectPage.clickSeeReview(true);
        browseBySubjectPage.focusDriverToLastTab();

        Assert.assertTrue(rrpPage.isTitleDisplayed());
    }

    @Test(description = "Active user - Directory Page - Categories and subcategories - lessonp-1211:Resource Tiles")
    public void testLessonp_1211() {
        lpHomePage.loadPage();
        stepOnePage.completeStepOne(TestData.GET_NEW_EMAIL(), TestData.VALID_PASSWORD);

        //account = freemium
        testResourceTiles(TestData.VALID_EMAIL_FREEMIUM);

        //upgrade to STARTER
        headerPage.clickOnUpgradeMeButton(false);
        stepTwoPage.completeStepTwoPageWith(TestData.STARTER_OPTION_TEXT);
        testResourceTiles(TestData.STARTER_OPTION_TEXT);

        //upgrade to PRIME
        manageMembershipPage.upgradeSubscriptionAndReturn(TestData.PRIME_OPTION_TEXT);
        testResourceTiles(TestData.PRIME_OPTION_TEXT);

        //upgrade to PRO
        manageMembershipPage.upgradeSubscriptionAndReturn(TestData.PRO_OPTION_TEXT);
        testResourceTiles(TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Visitor - Directory Page - Categories and subcategories - lessonp-1023:Browse by Subject")
    public void testLessonp_1023() {
        testBrowseBySubject(TestData.INVALID_EMAIL);
    }

    @Test(description = "Freemium - Directory Page - Categories and subcategories - lessonp-1204:Browse by Subject")
    public void testLessonp_1204() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testBrowseBySubject(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Active user - Directory Page - Categories and subcategories - lessonp-1216:Browse by Subject")
    public void testLessonp_1216() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testBrowseBySubject(TestData.VALID_EMAIL_ADMIN);
    }

    @Test(description = "Visitor - Directory Page - Categories and subcategories - lessonp-1024:Start your 10 day free trial")
    public void testLessonp_1024() {
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        testStartYourTenDayFreeTrial(TestData.INVALID_EMAIL);
    }

    @Test(description = "Freemium - Directory Page - Categories and subcategories - lessonp-1205:Start your 10 day free trial")
    public void testLessonp_1205() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testStartYourTenDayFreeTrial(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Visitor - Directory Page - Categories and subcategories - lessonp-1025:Related Topics")
    public void testLessonp_1025() {
        testRelatedTopics();
    }

    @Test(description = "Freemium - Directory Page - Categories and subcategories - lessonp-1206:Related Topics")
    public void testLessonp_1206() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testRelatedTopics();
    }

    @Test(description = "Active user - Directory Page - Categories and subcategories - lessonp-1218:Related Topics")
    public void testLessonp_1218() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testRelatedTopics();
    }

    @Test(description = "Visitor - Directory Page - Categories and subcategories - lessonp-1026:What members say")
    public void testLessonp_1026() {
        testTestimonials(TestData.INVALID_EMAIL);
    }

    @Test(description = "Freemium - Directory Page - Categories and subcategories - lessonp-1207:What members say")
    public void testLessonp_1207() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testTestimonials(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Active user - Directory Page - Categories and subcategories - lessonp-1219:What members say")
    public void testLessonp_1219() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testTestimonials(TestData.VALID_EMAIL_ADMIN);
    }

    private void testPageUi(String account) {
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.HEALTH_PAGE_TITLE);
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.HEALTH_PAGE_PATH);

        Assert.assertTrue(browseBySubjectPage.isBannerImageDisplayed());
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.HEALTH_PAGE_TITLE);

        if (account.equals(TestData.INVALID_EMAIL)) {
            Assert.assertTrue(browseBySubjectPage.isSeeAllButtonDisplayed());
        } else {
            Assert.assertFalse(browseBySubjectPage.isSeeAllButtonDisplayed());
        }
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.HEALTH_PAGE_PATH + TestData.PAGINATION_FIRST_PAGE_PATH);
        browseBySubjectPage.clickOnNextButton();
        Assert.assertTrue(browseBySubjectPage.isPreviousButtonDisplayed());
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.HEALTH_PAGE_PATH + TestData.PAGINATION_SECOND_PAGE_PATH);

        if (account.equals(TestData.INVALID_EMAIL)) {
            browseBySubjectPage.clickOnSeeAllButton();
            Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.HEALTH_PAGE_TITLE);
            Assert.assertEquals(browseBySubjectPage.getPath(), TestData.HEALTH_PAGE_PATH + TestData.PAGINATION_ALL_ITEMS_PATH);
        }
    }

    private void testResourceTiles(String account) {
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        discoverResourcesPage.changeToThumbnailView();
        if (account.equals(TestData.INVALID_EMAIL) || account.equals(TestData.VALID_EMAIL_FREEMIUM) || account.equals(TestData.PRO_OPTION_TEXT)) {
            Assert.assertEquals(browseBySubjectPage.getCountUnlockedResourcesInThumbnailMode(), TestData.TOTAL_RESOURCES_PER_PAGE);
            Assert.assertEquals(browseBySubjectPage.getCountLockedResourcesInThumbnailMode(), TestData.ZERO_RESOURCES_FOUND);
        } else if (account.equals(TestData.STARTER_OPTION_TEXT)) {
            Assert.assertEquals(browseBySubjectPage.getCountUnlockedResourcesInThumbnailMode(), TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_UNLOCKED);
            Assert.assertEquals(browseBySubjectPage.getCountLockedResourcesInThumbnailMode(), TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_LOCKED);
        } else {
            Assert.assertEquals(browseBySubjectPage.getCountUnlockedResourcesInThumbnailMode(), TestData.TOTAL_RESOURCES_PER_PAGE_PRIME_UNLOCKED);
            Assert.assertEquals(browseBySubjectPage.getCountLockedResourcesInThumbnailMode(), TestData.TOTAL_RESOURCES_PER_PAGE_PRIME_LOCKED);
        }

        discoverResourcesPage.changeToTiledView();
        if (account.equals(TestData.INVALID_EMAIL) || account.equals(TestData.VALID_EMAIL_FREEMIUM) || account.equals(TestData.PRO_OPTION_TEXT)) {
            Assert.assertEquals(browseBySubjectPage.getCountUnlockedResourcesInTiledMode(), TestData.TOTAL_RESOURCES_PER_PAGE);
            Assert.assertEquals(browseBySubjectPage.getCountLockedResourcesInTiledMode(), TestData.ZERO_RESOURCES_FOUND);
        } else if (account.equals(TestData.STARTER_OPTION_TEXT)) {
            Assert.assertEquals(browseBySubjectPage.getCountUnlockedResourcesInTiledMode(), TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_UNLOCKED);
            Assert.assertEquals(browseBySubjectPage.getCountLockedResourcesInTiledMode(), TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_LOCKED);
        } else {
            Assert.assertEquals(browseBySubjectPage.getCountUnlockedResourcesInTiledMode(), TestData.TOTAL_RESOURCES_PER_PAGE_PRIME_UNLOCKED);
            Assert.assertEquals(browseBySubjectPage.getCountLockedResourcesInTiledMode(), TestData.TOTAL_RESOURCES_PER_PAGE_PRIME_LOCKED);
        }

        discoverResourcesPage.changeToListView();
        if (account.equals(TestData.INVALID_EMAIL) || account.equals(TestData.VALID_EMAIL_FREEMIUM) || account.equals(TestData.PRO_OPTION_TEXT)) {
            Assert.assertEquals(browseBySubjectPage.getCountUnlockedResourcesInListMode(), TestData.TOTAL_RESOURCES_PER_PAGE);
            Assert.assertEquals(browseBySubjectPage.getCountLockedResourcesInListMode(), TestData.ZERO_RESOURCES_FOUND);
        } else if (account.equals(TestData.STARTER_OPTION_TEXT)) {
            Assert.assertEquals(browseBySubjectPage.getCountUnlockedResourcesInListMode(), TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_UNLOCKED);
            Assert.assertEquals(browseBySubjectPage.getCountLockedResourcesInListMode(), TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_LOCKED);
        } else {
            Assert.assertEquals(browseBySubjectPage.getCountUnlockedResourcesInListMode(), TestData.TOTAL_RESOURCES_PER_PAGE_PRIME_UNLOCKED);
            Assert.assertEquals(browseBySubjectPage.getCountLockedResourcesInListMode(), TestData.TOTAL_RESOURCES_PER_PAGE_PRIME_LOCKED);
        }


        if (account.equals(TestData.INVALID_EMAIL) || account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
            Assert.assertEquals(browseBySubjectPage.getCountFreeAccessButtons(), TestData.TOTAL_RESOURCES_PER_PAGE);
            Assert.assertEquals(browseBySubjectPage.getCountSeeReviewButton(), TestData.TOTAL_RESOURCES_PER_PAGE);
        } else if (account.equals(TestData.STARTER_OPTION_TEXT)) {
            Assert.assertEquals(browseBySubjectPage.getCountGoToResourceButtons(), TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_UNLOCKED);
            Assert.assertEquals(browseBySubjectPage.getCountSeeFullReviewButton(), TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_UNLOCKED);
            Assert.assertEquals(browseBySubjectPage.getCountUpgradeForAccessButton(), TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_LOCKED);
        } else if (account.equals(TestData.PRIME_OPTION_TEXT)) {
            Assert.assertEquals(browseBySubjectPage.getCountGoToResourceButtons(), TestData.TOTAL_RESOURCES_PER_PAGE_PRIME_UNLOCKED);
            Assert.assertEquals(browseBySubjectPage.getCountSeeFullReviewButton(), TestData.TOTAL_RESOURCES_PER_PAGE_PRIME_UNLOCKED);
            Assert.assertEquals(browseBySubjectPage.getCountUpgradeForAccessButton(), TestData.TOTAL_RESOURCES_PER_PAGE_PRIME_LOCKED);
        } else {
            Assert.assertEquals(browseBySubjectPage.getCountGoToResourceButtons(), TestData.TOTAL_RESOURCES_PER_PAGE);
            Assert.assertEquals(browseBySubjectPage.getCountSeeFullReviewButton(), TestData.TOTAL_RESOURCES_PER_PAGE);
        }

        if (account.equals(TestData.INVALID_EMAIL) || account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
            browseBySubjectPage.clickGetFreeAccess(false);
            if (account.equals(TestData.INVALID_EMAIL)) {
                Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
                stepOneModal.clickCloseModal();
            }
            if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
                Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
                stepTwoPage.goBackOnePage();
            }

            browseBySubjectPage.clickSeeReview(true);
            browseBySubjectPage.focusDriverToLastTab();
            Assert.assertTrue(rrpPage.isTitleDisplayed());
            Assert.assertTrue(rrpPage.isLimitedAccessReviewDisplayed());
            rrpPage.closeTab();
        } else {
            if ((account.equals(TestData.STARTER_OPTION_TEXT) || account.equals(TestData.PRIME_OPTION_TEXT))) {
                browseBySubjectPage.clickUpgradeForAccess(true);
                Assert.assertTrue(manageMembershipPage.getPath().startsWith(TestData.MANAGE_MEMBERSHIP_PAGE_PATH));
                manageMembershipPage.closeTab();
            }
            browseBySubjectPage.clickGoToResourceForRegularResource(true);
            Assert.assertTrue(!browseBySubjectPage.getUrl().contains(TestData.SERVER_URL));
            browseBySubjectPage.closeTab();
            browseBySubjectPage.clickSeeFullReview(true);
            Assert.assertTrue(rrpPage.isFullReviewDisplayed());
            rrpPage.closeTab();
        }
    }

    private void testBrowseBySubject(String account) {
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        if (!account.equals(TestData.INVALID_EMAIL)) {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT + TestData.BROWSE_BY_SUBJECT_SUGGEST_A_CATEGORY_TEXT);
        } else {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT);
        }
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.HEALTH_PAGE_PATH);

        //Right click on a subject title link and open in a new tab/page
        browseBySubjectPage.clickOptionFromBrowseBySubject(TestData.SIDE_WIDGET_BROWSE_BY_SUBJECT_GROWTH_AND_DEVELOPMENT_TYPE, true);
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.GROWTH_AND_DEVELOPMENT_PAGE_TITLE);
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.GROWTH_AND_DEVELOPMENT_PAGE_PATH);
        browseBySubjectPage.closeTab();

        //Click on a subject title link
        browseBySubjectPage.clickOptionFromBrowseBySubject(TestData.SIDE_WIDGET_BROWSE_BY_SUBJECT_GROWTH_AND_DEVELOPMENT_TYPE, false);
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.GROWTH_AND_DEVELOPMENT_PAGE_TITLE);
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.GROWTH_AND_DEVELOPMENT_PAGE_PATH);
        browseBySubjectPage.goBackOnePage();
        browseBySubjectPage.waitForLinkToLoad();
        browseBySubjectPage.waitForPageLoad();
        if (!account.equals(TestData.INVALID_EMAIL)) {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT + TestData.BROWSE_BY_SUBJECT_SUGGEST_A_CATEGORY_TEXT);
        } else {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT);
        }

        //Click on the caret icon displayed in front of the subject title link &&
        //Click on the caret icon displayed in front of an expanded subject title link
        browseBySubjectPage.clickFirstCaretFromBrowseBySubjectCategory();
        if (!account.equals(TestData.INVALID_EMAIL)) {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_FIRST_CARET_EXPANDED_TEXT + TestData.BROWSE_BY_SUBJECT_SUGGEST_A_CATEGORY_TEXT);
        } else {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_FIRST_CARET_EXPANDED_TEXT);
        }
        browseBySubjectPage.clickFirstCaretFromBrowseBySubjectCategory();
        if (!account.equals(TestData.INVALID_EMAIL)) {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT + TestData.BROWSE_BY_SUBJECT_SUGGEST_A_CATEGORY_TEXT);
        } else {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT);
        }
        browseBySubjectPage.clickSecondCaretFromBrowseBySubjectCategory();
        if (!account.equals(TestData.INVALID_EMAIL)) {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_SECOND_CARET_EXPANDED_TEXT + TestData.BROWSE_BY_SUBJECT_SUGGEST_A_CATEGORY_TEXT);
        } else {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_SECOND_CARET_EXPANDED_TEXT);
        }
        browseBySubjectPage.clickSecondCaretFromBrowseBySubjectCategory();
        if (!account.equals(TestData.INVALID_EMAIL)) {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT + TestData.BROWSE_BY_SUBJECT_SUGGEST_A_CATEGORY_TEXT);
        } else {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT);
        }
        //Click on a sub-subject title link or Right click on a sub-subject title link and open in a new tab/window
        browseBySubjectPage.clickFirstCaretFromBrowseBySubjectCategory();
        browseBySubjectPage.clickOptionFromBrowseBySubject(TestData.SIDE_WIDGET_BROWSE_BY_SUBJECT_SOCIAL_HEALTH_TYPE, true);
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.SOCIAL_HEALTH_PAGE_TITLE);
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.SOCIAL_HEALTH_PAGE_PATH);
        if (!account.equals(TestData.INVALID_EMAIL)) {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_SOCIAL_HEALTH_CATEGORY_TEXT + TestData.BROWSE_BY_SUBJECT_SUGGEST_A_CATEGORY_TEXT);
        } else {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_SOCIAL_HEALTH_CATEGORY_TEXT);
        }
        if (!account.equals(TestData.INVALID_EMAIL)) {
            browseBySubjectPage.clickOnSuggestACategoryButton();
            Assert.assertEquals(suggestACategoryModal.getModalTitle(), TestData.SUGGEST_A_CATEGORY_MODAL_TITLE);
        }
    }

    private void testStartYourTenDayFreeTrial(String account) {
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
            Assert.assertEquals(startYourTenDayFreeTrialWidget.getStartYourTenDaysFreeTrialContentAsText(), TestData.SIDE_WIDGET_START_YOUR_TEN_DAYS_FREE_TRIAL_FREEMIUM_TEXT);
        } else {
            Assert.assertEquals(startYourTenDayFreeTrialWidget.getStartYourTenDaysFreeTrialContentAsText(), TestData.SIDE_WIDGET_START_YOUR_TEN_DAYS_FREE_TRIAL_VISITOR_TEXT);
        }
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(true);
        if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
            Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
        } else {
            Assert.assertTrue(stepOnePage.isAlreadyAMemberButtonDisplayed());
        }
        browseBySubjectPage.closeTab();
        browseBySubjectPage.waitForPageLoad();
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(false);
        if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
            Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
        } else {
            Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
        }
    }

    private void testRelatedTopics() {
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        Assert.assertEquals(browseBySubjectPage.getRelatedTopicsContentAsText(), TestData.SIDE_WIDGET_RELATED_TOPICS_CATEGORY_TEXT);
        browseBySubjectPage.clickOptionFromRelatedTopics(TestData.SIDE_WIDGET_RELATED_TOPICS_TRANSPORTATION_OPTION, true);
        Assert.assertEquals(headerPage.getSearchText(), TestData.SIDE_WIDGET_RELATED_TOPICS_TRANSPORTATION_OPTION.toLowerCase());
        Assert.assertEquals(discoverResourcesPage.getPath(), TestData.SIDE_WIDGET_RELATED_TOPICS_TRANSPORTATION_REDIRECT_PATH);

        discoverResourcesPage.closeTab();
        browseBySubjectPage.clickOptionFromRelatedTopics(TestData.SIDE_WIDGET_RELATED_TOPICS_TRANSPORTATION_OPTION, false);
        Assert.assertEquals(headerPage.getSearchText(), TestData.SIDE_WIDGET_RELATED_TOPICS_TRANSPORTATION_OPTION.toLowerCase());
        Assert.assertEquals(discoverResourcesPage.getPath(), TestData.SIDE_WIDGET_RELATED_TOPICS_TRANSPORTATION_REDIRECT_PATH);
    }

    private void testTestimonials(String account) {
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        browseBySubjectPage.waitForPageLoad();
        Assert.assertTrue(whatMembersSayWidget.isTestimonialTextDisplayed());
        Assert.assertTrue(browseBySubjectPage.isBannerImageDisplayed());
        whatMembersSayWidget.clickOnSeeMoreTestimonialsButton(false);
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.TESTIMONIALS_PAGE_PATH);
        browseBySubjectPage.goBackOnePage();
        whatMembersSayWidget.clickOnSeeMoreTestimonialsButton(true);
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.TESTIMONIALS_PAGE_PATH);
        browseBySubjectPage.closeTab();

        whatMembersSayWidget.clickOnSubmitYourOwnButton(false);
        if (account.equals(TestData.INVALID_EMAIL)) {
            Assert.assertEquals(loginPage.getPath(), TestData.LOGIN_PAGE_PATH);
        } else {
            Assert.assertEquals(browseBySubjectPage.getPath(), TestData.FEEDBACKS_PAGE_PATH);
        }
        browseBySubjectPage.goBackOnePage();

        whatMembersSayWidget.clickOnSubmitYourOwnButton(true);
        if (account.equals(TestData.INVALID_EMAIL)) {
            Assert.assertEquals(loginPage.getPath(), TestData.LOGIN_PAGE_PATH);
        } else {
            Assert.assertEquals(browseBySubjectPage.getPath(), TestData.FEEDBACKS_PAGE_PATH);
        }
        browseBySubjectPage.closeTab();

        //no Get free trial or Upgrade Me button if active user
        if (!account.equals(TestData.VALID_EMAIL_ADMIN)) {
            whatMembersSayWidget.clickSubscriptionButton(false);
            if (account.equals(TestData.INVALID_EMAIL)) {
                Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
                stepOneModal.clickCloseModal();
            } else {
                Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
                stepTwoPage.goBackOnePage();
            }

            whatMembersSayWidget.clickSubscriptionButton(true);
            if (account.equals(TestData.INVALID_EMAIL)) {
                Assert.assertTrue(stepOnePage.isAlreadyAMemberButtonDisplayed());
            } else {
                Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
            }
        }
    }
}
