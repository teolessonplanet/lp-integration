import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class User_DirectoryCategoriesAndSubcategoriesPageTest extends BaseTest {

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

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Visitor - Directory Page - Categories and subcategories - lessonp-1020: Page UI")
    public void testLessonp_1020() {
        testPageUi();
    }

    @Test(description = "Free member - Directory Page - Categories and subcategories - lessonp-1197: Page UI")
    public void testLessonp_1197() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testPageUi();
    }

    @Test(description = "Active user - Directory Page - Categories and subcategories - lessonp-1209: Page UI")
    public void testLessonp_1209() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testPageUi();
    }

    @Test(description = "Visitor - Directory Page - Categories and subcategories - lessonp-1022: Resource Tiles")
    public void testLessonp_1022() {
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        Assert.assertTrue(browseBySubjectPage.getCountUnlockedResourcesInThumbnailMode() % TestData.TOTAL_RESOURCES_PER_PAGE == 0);
        discoverResourcesPage.changeToTiledView();
        Assert.assertTrue(browseBySubjectPage.getCountUnlockedResourcesInTiledMode() % TestData.TOTAL_RESOURCES_PER_PAGE == 0);
        discoverResourcesPage.changeToListView();
        Assert.assertTrue(browseBySubjectPage.getCountUnlockedResourcesInListMode() % TestData.TOTAL_RESOURCES_PER_PAGE == 0);

        Assert.assertTrue(browseBySubjectPage.getCountFreeAccessButtons() % TestData.TOTAL_RESOURCES_PER_PAGE == 0);
        Assert.assertTrue(browseBySubjectPage.getCountSeeReviewButton() % TestData.TOTAL_RESOURCES_PER_PAGE == 0);

        browseBySubjectPage.clickGetFreeAccess(false);
        Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
        stepOneModal.clickCloseModal();

        browseBySubjectPage.clickSeeReview(true);
        browseBySubjectPage.focusDriverToLastTab();

        Assert.assertTrue(rrpPage.isTitleDisplayed());
    }

    @Test(description = "Active user - Directory Page - Categories and subcategories - lessonp-1211: Resource Tiles")
    public void testLessonp_1211() {
        lpHomePage.loadPage();
        stepOnePage.completeStepOne(TestData.GET_NEW_EMAIL(), TestData.VALID_PASSWORD);

        //account = freemium
        testResourceTiles(TestData.PLAN_FREEMIUM);

        //upgrade to STARTER
        headerPage.clickOnUpgradeMeButton(false);
        stepTwoPage.completeStepTwoPageWith(TestData.PLAN_STARTER);
        testResourceTiles(TestData.PLAN_STARTER);

        //upgrade to PRO
        manageMembershipPage.upgradeSubscriptionAndReturn(TestData.PLAN_PRO);
        testResourceTiles(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Directory Page - Categories and subcategories - lessonp-1023: Browse by Subject")
    public void testLessonp_1023() {
        testBrowseBySubject(TestData.PLAN_VISITOR);
    }

    @Test(description = "Free member - Directory Page - Categories and subcategories - lessonp-1204: Browse by Subject")
    public void testLessonp_1204() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testBrowseBySubject(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Directory Page - Categories and subcategories - lessonp-1216: Browse by Subject")
    public void testLessonp_1216() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testBrowseBySubject(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Directory Page - Categories and subcategories - lessonp-1024: Start your 10 day free trial")
    public void testLessonp_1024() {
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        testStartYourTenDayFreeTrial(TestData.PLAN_VISITOR);
    }

    @Test(description = "Free member - Directory Page - Categories and subcategories - lessonp-1205: Start your 10 day free trial")
    public void testLessonp_1205() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        testStartYourTenDayFreeTrial(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Visitor - Directory Page - Categories and subcategories - lessonp-1025: Related Topics")
    public void testLessonp_1025() {
        testRelatedTopics();
    }

    @Test(description = "Free member - Directory Page - Categories and subcategories - lessonp-1206: Related Topics")
    public void testLessonp_1206() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testRelatedTopics();
    }

    @Test(description = "Active user - Directory Page - Categories and subcategories - lessonp-1218: Related Topics")
    public void testLessonp_1218() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testRelatedTopics();
    }

    @Test(description = "Visitor - Directory Page - Categories and subcategories - lessonp-1026: What members say")
    public void testLessonp_1026() {
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        testTestimonials(TestData.PLAN_VISITOR);
    }

    @Test(description = "Free member - Directory Page - Categories and subcategories - lessonp-1207: What members say")
    public void testLessonp_1207() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        testTestimonials(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Directory Page - Categories and subcategories - lessonp-1219: What members say")
    public void testLessonp_1219() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        testTestimonials(TestData.PLAN_PRO);
    }

    protected void testPageUi() {
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.HEALTH_PAGE_TITLE);
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.HEALTH_PAGE_PATH);

        Assert.assertTrue(browseBySubjectPage.isBannerImageDisplayed());
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.HEALTH_PAGE_TITLE);

        Assert.assertFalse(browseBySubjectPage.isSeeAllButtonDisplayed());
        Assert.assertFalse(browseBySubjectPage.isNextButtonDisplayed());
        Assert.assertFalse(browseBySubjectPage.isPreviousButtonDisplayed());

        final int noOfCardsBeforeScroll = browseBySubjectPage.getCountOfAllResources();
        browseBySubjectPage.scrollAndFetchResourcesList();
        Assert.assertTrue(browseBySubjectPage.getCountOfAllResources() > noOfCardsBeforeScroll);
    }

    protected void testResourceTiles(String account) {
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        discoverResourcesPage.changeToThumbnailView();
        if (account.equals(TestData.PLAN_VISITOR) || account.equals(TestData.PLAN_FREEMIUM) || account.equals(TestData.PLAN_PRO) || account.equals(TestData.VALID_EMAIL_RSL_SBCEO) || account.equals(TestData.VALID_EMAIL_CSL_HENRY) || account.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            Assert.assertTrue(browseBySubjectPage.getCountUnlockedResourcesInThumbnailMode() % TestData.TOTAL_RESOURCES_PER_PAGE == 0);
            Assert.assertEquals(browseBySubjectPage.getCountLockedResourcesInThumbnailMode(), TestData.ZERO_RESOURCES_FOUND);
        } else if (account.equals(TestData.PLAN_STARTER)) {
            Assert.assertTrue(browseBySubjectPage.getCountUnlockedResourcesInThumbnailMode() % TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_UNLOCKED == 0);
            Assert.assertTrue(browseBySubjectPage.getCountLockedResourcesInThumbnailMode() % TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_LOCKED == 0);
        }

        discoverResourcesPage.changeToTiledView();
        if (account.equals(TestData.PLAN_VISITOR) || account.equals(TestData.PLAN_FREEMIUM) || account.equals(TestData.PLAN_PRO) || account.equals(TestData.VALID_EMAIL_RSL_SBCEO) || account.equals(TestData.VALID_EMAIL_CSL_HENRY) || account.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            Assert.assertTrue(browseBySubjectPage.getCountUnlockedResourcesInTiledMode() % TestData.TOTAL_RESOURCES_PER_PAGE == 0);
            Assert.assertEquals(browseBySubjectPage.getCountLockedResourcesInTiledMode(), TestData.ZERO_RESOURCES_FOUND);
        } else if (account.equals(TestData.PLAN_STARTER)) {
            Assert.assertTrue(browseBySubjectPage.getCountUnlockedResourcesInTiledMode() % TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_UNLOCKED == 0);
            Assert.assertTrue(browseBySubjectPage.getCountLockedResourcesInTiledMode() % TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_LOCKED == 0);
        }

        discoverResourcesPage.changeToListView();
        if (account.equals(TestData.PLAN_VISITOR) || account.equals(TestData.PLAN_FREEMIUM) || account.equals(TestData.PLAN_PRO) || account.equals(TestData.VALID_EMAIL_RSL_SBCEO) || account.equals(TestData.VALID_EMAIL_CSL_HENRY) || account.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            Assert.assertTrue(browseBySubjectPage.getCountUnlockedResourcesInListMode() % TestData.TOTAL_RESOURCES_PER_PAGE == 0);
            Assert.assertEquals(browseBySubjectPage.getCountLockedResourcesInListMode(), TestData.ZERO_RESOURCES_FOUND);
        } else if (account.equals(TestData.PLAN_STARTER)) {
            Assert.assertTrue(browseBySubjectPage.getCountUnlockedResourcesInListMode() % TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_UNLOCKED == 0);
            Assert.assertTrue(browseBySubjectPage.getCountLockedResourcesInListMode() % TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_LOCKED == 0);
        }


        if (account.equals(TestData.PLAN_VISITOR) || account.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertTrue(browseBySubjectPage.getCountFreeAccessButtons() % TestData.TOTAL_RESOURCES_PER_PAGE == 0);
            Assert.assertTrue(browseBySubjectPage.getCountSeeReviewButton() % TestData.TOTAL_RESOURCES_PER_PAGE == 0);
        } else if (account.equals(TestData.PLAN_STARTER)) {
            Assert.assertTrue(browseBySubjectPage.getCountGoToResourceButtons() % TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_UNLOCKED == 0);
            Assert.assertTrue(browseBySubjectPage.getCountSeeFullReviewButton() % TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_UNLOCKED == 0);
            Assert.assertTrue(browseBySubjectPage.getCountUpgradeForAccessButton() % TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_LOCKED == 0);
        } else {
            Assert.assertTrue(browseBySubjectPage.getCountGoToResourceButtons() % TestData.TOTAL_RESOURCES_PER_PAGE == 0);
            Assert.assertTrue(browseBySubjectPage.getCountSeeFullReviewButton() % TestData.TOTAL_RESOURCES_PER_PAGE == 0);
        }

        if (account.equals(TestData.PLAN_VISITOR) || account.equals(TestData.PLAN_FREEMIUM)) {
            browseBySubjectPage.clickGetFreeAccess(false);
            if (account.equals(TestData.PLAN_VISITOR)) {
                Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
                stepOneModal.clickCloseModal();
            }
            if (account.equals(TestData.PLAN_FREEMIUM)) {
                Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
                stepTwoPage.goBackOnePage();
            }

            browseBySubjectPage.clickSeeReview(true);
            browseBySubjectPage.focusDriverToLastTab();
            Assert.assertTrue(rrpPage.isTitleDisplayed());
            Assert.assertTrue(rrpPage.isLimitedAccessReviewDisplayed());
            rrpPage.closeTab();
        } else {
            if (account.equals(TestData.PLAN_STARTER)) {
                browseBySubjectPage.clickUpgradeForAccess(true);
                Assert.assertTrue(manageMembershipPage.getPath().startsWith(TestData.MANAGE_MEMBERSHIP_PAGE_PATH));
                manageMembershipPage.closeTab();
            }
            browseBySubjectPage.clickGoToResourceForRegularResource(true);
            Assert.assertTrue(!browseBySubjectPage.getUrl().contains(TestData.SERVER_URL));
            browseBySubjectPage.closeTab();
            browseBySubjectPage.clickSeeFullReview(true);

            rrpPage.closeTab();
        }
    }

    protected void testBrowseBySubject(String account) {
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        if (!account.equals(TestData.PLAN_VISITOR)) {
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
        final String pagePath = browseBySubjectPage.getPath();
        browseBySubjectPage.clickOptionFromBrowseBySubject(TestData.SIDE_WIDGET_BROWSE_BY_SUBJECT_GROWTH_AND_DEVELOPMENT_TYPE, false);
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.GROWTH_AND_DEVELOPMENT_PAGE_TITLE);
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.GROWTH_AND_DEVELOPMENT_PAGE_PATH);
        browseBySubjectPage.loadPage(pagePath);
        if (!account.equals(TestData.PLAN_VISITOR)) {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT + TestData.BROWSE_BY_SUBJECT_SUGGEST_A_CATEGORY_TEXT);
        } else {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT);
        }

        //Click on the caret icon displayed in front of the subject title link &&
        //Click on the caret icon displayed in front of an expanded subject title link
        browseBySubjectPage.clickCaretFromBrowseBySubjectCategory(0);
        if (!account.equals(TestData.PLAN_VISITOR)) {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_FIRST_CARET_EXPANDED_TEXT + TestData.BROWSE_BY_SUBJECT_SUGGEST_A_CATEGORY_TEXT);
        } else {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_FIRST_CARET_EXPANDED_TEXT);
        }
        browseBySubjectPage.clickCaretFromBrowseBySubjectCategory(0);
        if (!account.equals(TestData.PLAN_VISITOR)) {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT + TestData.BROWSE_BY_SUBJECT_SUGGEST_A_CATEGORY_TEXT);
        } else {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT);
        }
        browseBySubjectPage.clickCaretFromBrowseBySubjectCategory(1);
        if (!account.equals(TestData.PLAN_VISITOR)) {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_SECOND_CARET_EXPANDED_TEXT + TestData.BROWSE_BY_SUBJECT_SUGGEST_A_CATEGORY_TEXT);
        } else {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_SECOND_CARET_EXPANDED_TEXT);
        }
        browseBySubjectPage.clickCaretFromBrowseBySubjectCategory(1);
        if (!account.equals(TestData.PLAN_VISITOR)) {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT + TestData.BROWSE_BY_SUBJECT_SUGGEST_A_CATEGORY_TEXT);
        } else {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT);
        }
        //Click on a sub-subject title link or Right click on a sub-subject title link and open in a new tab/window
        browseBySubjectPage.clickCaretFromBrowseBySubjectCategory(0);
        browseBySubjectPage.clickOptionFromBrowseBySubject(TestData.SIDE_WIDGET_BROWSE_BY_SUBJECT_PHYSICAL_HEALTH_TYPE, true);
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.PHYSICAL_HEALTH_PAGE_TITLE);
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.PHYSICAL_HEALTH_PAGE_PATH);
        if (!account.equals(TestData.PLAN_VISITOR)) {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_PHYSICAL_HEALTH_CATEGORY_TEXT + TestData.BROWSE_BY_SUBJECT_SUGGEST_A_CATEGORY_TEXT);
        } else {
            Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_PHYSICAL_HEALTH_CATEGORY_TEXT);
        }
        if (!account.equals(TestData.PLAN_VISITOR)) {
            browseBySubjectPage.clickOnSuggestACategoryButton();
            Assert.assertEquals(suggestACategoryModal.getModalTitle(), TestData.SUGGEST_A_CATEGORY_MODAL_TITLE);
        }
    }

    public void testStartYourTenDayFreeTrial(String account) {
        if (account.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(startYourTenDayFreeTrialWidget.getStartYourTenDaysFreeTrialContentAsText(), TestData.SIDE_WIDGET_START_YOUR_TEN_DAYS_FREE_TRIAL_FREEMIUM_TEXT);
        } else {
            Assert.assertEquals(startYourTenDayFreeTrialWidget.getStartYourTenDaysFreeTrialContentAsText(), TestData.SIDE_WIDGET_START_YOUR_TEN_DAYS_FREE_TRIAL_VISITOR_TEXT);
        }
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(true);
        if (account.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
        } else {
            Assert.assertTrue(stepOnePage.isAlreadyAMemberButtonDisplayed());
        }
        browseBySubjectPage.closeTab();
        browseBySubjectPage.waitForPageLoad();
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(false);
        if (account.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
        } else {
            Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
            stepOneModal.clickCloseModal();
        }
    }

    protected void testRelatedTopics() {
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        Assert.assertTrue(verifyRelatedTopics(browseBySubjectPage.getRelatedTopicsContentAsText()));
        browseBySubjectPage.clickOptionFromRelatedTopics(TestData.SIDE_WIDGET_RELATED_TOPICS_STRESS_MANAGEMENT_OPTION, true);
        Assert.assertEquals(headerPage.getSearchText(), TestData.SIDE_WIDGET_RELATED_TOPICS_STRESS_MANAGEMENT_OPTION.toLowerCase());
        Assert.assertEquals(discoverResourcesPage.getPath(), TestData.SIDE_WIDGET_RELATED_TOPICS_STRESS_MANAGEMEMT_REDIRECT_PATH);

        discoverResourcesPage.closeTab();
        browseBySubjectPage.clickOptionFromRelatedTopics(TestData.SIDE_WIDGET_RELATED_TOPICS_STRESS_MANAGEMENT_OPTION, false);
        Assert.assertEquals(headerPage.getSearchText(), TestData.SIDE_WIDGET_RELATED_TOPICS_STRESS_MANAGEMENT_OPTION.toLowerCase());
        Assert.assertEquals(discoverResourcesPage.getPath(), TestData.SIDE_WIDGET_RELATED_TOPICS_STRESS_MANAGEMEMT_REDIRECT_PATH);
    }

    public void testTestimonials(String account) {
        Assert.assertTrue(whatMembersSayWidget.isTestimonialTextDisplayed());
        whatMembersSayWidget.clickOnSeeMoreTestimonialsButton(false);
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.TESTIMONIALS_PAGE_PATH);
        browseBySubjectPage.goBackOnePage();
        whatMembersSayWidget.clickOnSeeMoreTestimonialsButton(true);
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.TESTIMONIALS_PAGE_PATH);
        browseBySubjectPage.closeTab();

        whatMembersSayWidget.clickOnSubmitYourOwnButton(false);
        if (account.equals(TestData.PLAN_VISITOR)) {
            Assert.assertEquals(loginPage.getPath(), TestData.LOGIN_PAGE_PATH);
        } else {
            Assert.assertEquals(browseBySubjectPage.getPath(), TestData.FEEDBACKS_PAGE_PATH);
        }
        browseBySubjectPage.goBackOnePage();

        whatMembersSayWidget.clickOnSubmitYourOwnButton(true);
        if (account.equals(TestData.PLAN_VISITOR)) {
            Assert.assertEquals(loginPage.getPath(), TestData.LOGIN_PAGE_PATH);
        } else {
            Assert.assertEquals(browseBySubjectPage.getPath(), TestData.FEEDBACKS_PAGE_PATH);
        }
        browseBySubjectPage.closeTab();

        //no Get free trial or Upgrade Me button if active user
        if (!account.equals(TestData.PLAN_PRO)) {
            whatMembersSayWidget.clickSubscriptionButton(false);
            if (account.equals(TestData.PLAN_VISITOR)) {
                Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
                stepOneModal.clickCloseModal();
            } else {
                Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
                stepTwoPage.goBackOnePage();
            }

            whatMembersSayWidget.clickSubscriptionButton(true);
            if (account.equals(TestData.PLAN_VISITOR)) {
                Assert.assertTrue(stepOnePage.isAlreadyAMemberButtonDisplayed());
            } else {
                Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
            }
        }
    }

    private boolean verifyRelatedTopics(String actual) {
        String[] actualWords = actual.split("\n");

        if (actualWords.length == TestData.TOTAL_RESOURCES_PER_PAGE_STARTER_LOCKED) {
            return true;
        }
        return false;
    }

}
