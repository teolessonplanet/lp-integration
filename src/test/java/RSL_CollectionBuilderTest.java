import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_CollectionBuilderTest extends BaseTest {

    private LoginPage loginPage;
    private CollectionBuilderTest collectionBuilderTest;
    private CollectionBuilderPage collectionBuilderPage;
    private CurriculumManagerPage curriculumManagerPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private BrowseBySubjectPage browseBySubjectPage;
    private CurriculumManagerPageTest curriculumManagerPageTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        collectionBuilderTest = new CollectionBuilderTest();
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
        curriculumManagerPageTest = new CurriculumManagerPageTest();
        initCollectionBuilderTestAndLogin();
    }

    private void initCollectionBuilderTestAndLogin() {
        collectionBuilderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
    }

    @Test(description = "Collection Builder - lessonp-5141: Collection Builder Buttons")
    public void testLessonp_5141() {
        discoverResourcesPage.loadPage();
        collectionBuilderTest.testMyResourcesButton(TestData.VALID_EMAIL_RSL_SBCEO);
        collectionBuilderTest.testCollectionBuilderButtons(TestData.VALID_EMAIL_RSL_SBCEO);
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        collectionBuilderTest.testCollectionBuilderButtons(TestData.VALID_EMAIL_RSL_SBCEO);
        collectionBuilderTest.testMyResourcesButton(TestData.VALID_EMAIL_RSL_SBCEO);
        curriculumManagerPage.loadPage();
        collectionBuilderTest.testCollectionBuilderButtons(TestData.VALID_EMAIL_RSL_SBCEO);
        collectionBuilderTest.testMaxCollectionCreated(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Collection Builder - lessonp-5142: Collection Builder Items")
    public void testLessonp_5142() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);
        curriculumManagerPageTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder();
        collectionBuilderTest.testDragAndDropMaxItemsInsideCollection(TestData.VALID_EMAIL_RSL_SBCEO);
        discoverResourcesPage.refreshPageAndDismissBrowserAlert();
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 11);
        collectionBuilderTest.testDragAndDropItem(TestData.VALID_EMAIL_RSL_SBCEO);
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 12);
        curriculumManagerPage.loadPage();
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 12);
        collectionBuilderTest.testCollectionBuilderItem();
    }
}
