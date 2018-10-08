import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class DirectoryCategoriesAndSubcategoriesTest extends BaseTest {

    private LoginPage loginPage;
    private DirectoryPage directoryPage;
    private BrowseBySubjectPage browseBySubjectPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private StepOneModal stepOneModal;
    private StepOnePage stepOnePage;
    private StepTwoModal stepTwoModal;
    private StepTwoPage stepTwoPage;
    private SuggestACategoryModal suggestACategoryModal;
    private RrpPage rrpPage;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        directoryPage = new DirectoryPage(webDriver);
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        stepOnePage = new StepOnePage(webDriver);
        stepTwoModal = new StepTwoModal(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        suggestACategoryModal = new SuggestACategoryModal(webDriver);
        rrpPage = new RrpPage(webDriver);
    }

    @Test(description = "Visitor - Directory Page - Categories ans subcategories - lessonp-1209:Page UI")
    public void testLessonp_1209() {
        reachHealthPage();
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.HEALTH_PAGE_TITLE);
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.HEALTH_PAGE_PATH);

        Assert.assertTrue(browseBySubjectPage.isBannerImageDisplayed());
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.HEALTH_PAGE_TITLE);

        Assert.assertTrue(browseBySubjectPage.isSeeAllButtonDisplayed());
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.HEALTH_PAGE_PATH + TestData.PAGINATION_FIRST_PAGE_PATH);
        browseBySubjectPage.clickOnNextButton();
        Assert.assertTrue(browseBySubjectPage.isPreviousButtonDisplayed());
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.HEALTH_PAGE_PATH + TestData.PAGINATION_SECOND_PAGE_PATH);
        browseBySubjectPage.clickOnSeeAllButton();

        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.HEALTH_PAGE_TITLE);
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.HEALTH_PAGE_PATH + TestData.PAGINATION_ALL_ITEMS_PATH);
    }


    @Test(description = "Visitor - Directory Page - Categories ans subcategories - lessonp-1022:Resource Tiles")
    public void testLessonp_1022() {
        reachHealthPage();
        Assert.assertEquals(browseBySubjectPage.getCountResourcesInThumbnailMode(), TestData.TOTAL_RESOURCES_PER_PAGE);
        discoverResourcesPage.changeToTiledView();
        Assert.assertEquals(browseBySubjectPage.getCountResourcesInTiledMode(), TestData.TOTAL_RESOURCES_PER_PAGE);
        discoverResourcesPage.changeToListView();
        Assert.assertEquals(browseBySubjectPage.getCountResourcesInListMode(), TestData.TOTAL_RESOURCES_PER_PAGE);

        Assert.assertEquals(browseBySubjectPage.getCountFreeAcessButtons(), TestData.TOTAL_RESOURCES_PER_PAGE);
        Assert.assertEquals(browseBySubjectPage.getCountSeeReviewButton(), TestData.TOTAL_RESOURCES_PER_PAGE);

        browseBySubjectPage.clickGetFreeAccess(false);
        Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
        stepOneModal.clickCloseModal();

        browseBySubjectPage.clickSeeReview(true);
        browseBySubjectPage.focusDriverToLastTab();

        Assert.assertTrue(rrpPage.isTitleDisplayed());
    }

    @Test(description = "Visitor - Directory Page - Categories ans subcategories - lessonp-1023:Browse by Subject")
    public void testLessonp_1023() {
        testBrowseBySubject(TestData.INVALID_EMAIL);
    }

    @Test(description = "Freemium - Directory Page - Categories ans subcategories - lessonp-1204:Browse by Subject")
    public void testLessonp_1204() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testBrowseBySubject(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Active user - Directory Page - Categories ans subcategories - lessonp-1216:Browse by Subject")
    public void testLessonp_1216() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testBrowseBySubject(TestData.VALID_EMAIL_ADMIN);
    }

    @Test(description = "Visitor - Directory Page - Categories ans subcategories - lessonp-1024:Start your 10 day free trial")
    public void testLessonp_1024() {
        reachHealthPage();
        testStartYourTenDayFreeTrial(TestData.INVALID_EMAIL);
    }

    @Test(description = "Freemium - Directory Page - Categories ans subcategories - lessonp-1205:Start your 10 day free trial")
    public void testLessonp_1205() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testStartYourTenDayFreeTrial(TestData.VALID_EMAIL_FREEMIUM);
    }

    private void reachHealthPage() {
        directoryPage.loadPage();
        directoryPage.clickOnHealthSubjectLink();
    }

    private void testBrowseBySubject(String account) {
        reachHealthPage();
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
        reachHealthPage();
        if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
            Assert.assertEquals(browseBySubjectPage.getStartYourTenDaysFreeTrialContentAsText(), TestData.SIDE_WIDGET_START_YOUR_TEN_DAYS_FREE_TRIAL_FREEMIUM_TEXT);
        } else {
            Assert.assertEquals(browseBySubjectPage.getStartYourTenDaysFreeTrialContentAsText(), TestData.SIDE_WIDGET_START_YOUR_TEN_DAYS_FREE_TRIAL_VISITOR_TEXT);
        }
        browseBySubjectPage.clickGetFreeTrialButton(true);
        if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
            Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
        } else {
            Assert.assertTrue(stepOnePage.isAlreadyAMemberButtonDisplayed());
        }
        browseBySubjectPage.closeTab();
        browseBySubjectPage.waitForPageLoad();
        browseBySubjectPage.clickGetFreeTrialButton(false);
        if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
            Assert.assertEquals(stepTwoModal.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
        } else {
            Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
        }
    }
}
