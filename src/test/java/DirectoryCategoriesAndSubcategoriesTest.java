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
        reachHealthPage();
    }

    private void reachHealthPage() {
        directoryPage.loadPage();
        directoryPage.clickOnHealthSubjectLink();
    }

}
