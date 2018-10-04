import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class DirectoryCategoriesAndSubcategoriesTest
        extends BaseTest {

    private LoginPage loginPage;
    private DirectoryPage directoryPage;
    private BrowseBySubjectPage browseBySubjectPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private StepOneModal stepOneModal;
    private RrpPage rrpPage;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        directoryPage = new DirectoryPage(webDriver);
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        stepOneModal = new StepOneModal(webDriver);
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
        reachHealthPage();
        Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT);
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
        Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT);

        //Click on the caret icon displayed in front of the subject title link &&
        //Click on the caret icon displayed in front of an expanded subject title link
        browseBySubjectPage.clickFirstCaretFromBrowseBySubjectCategory();
        Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_FIRST_CARET_EXANDED_TEXT);
        browseBySubjectPage.clickFirstCaretFromBrowseBySubjectCategory();
        Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT);

        browseBySubjectPage.clickSecondCaretFromBrowseBySubjectCategory();
        Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_SECOND_CARET_EXANDED_TEXT);
        browseBySubjectPage.clickSecondCaretFromBrowseBySubjectCategory();
        Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_HEALTH_CATEGORY_TEXT);

        //Click on a sub-subject title link or Right click on a sub-subject title link and open in a new tab/window
        browseBySubjectPage.clickFirstCaretFromBrowseBySubjectCategory();
        browseBySubjectPage.clickOptionFromBrowseBySubject(TestData.SIDE_WIDGET_BROWSE_BY_SUBJECT_SOCIAL_HEALTH_TYPE, true);
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.SOCIAL_HEALTH_PAGE_TITLE);
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.SOCIAL_HEALTH_PAGE_PATH);
        Assert.assertEquals(browseBySubjectPage.getBrowseBySubjectCategoryContentAsText(), TestData.BROWSE_BY_SUBJECT_FOR_SOCIAL_HEALTH_CATEGORY_TEXT);
    }

    private void reachHealthPage() {
        directoryPage.loadPage();
        directoryPage.clickOnHealthSubjectLink();
    }

}
