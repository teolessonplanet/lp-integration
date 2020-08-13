import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_CollectionBuilderTest extends BaseTest {

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
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
    }

    @Test(description = "Collection Builder - lessonp-4948: Collection Builder Buttons")
    public void testLessonp_4948() {
        discoverResourcesPage.loadPage();
        collectionBuilderTest.testMyResourcesButton(TestData.VALID_EMAIL_CSL_HENRY);
        collectionBuilderTest.testCollectionBuilderButtons(TestData.VALID_EMAIL_CSL_HENRY);
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        collectionBuilderTest.testCollectionBuilderButtons(TestData.VALID_EMAIL_CSL_HENRY);
        collectionBuilderTest.testMyResourcesButton(TestData.VALID_EMAIL_CSL_HENRY);
        curriculumManagerPage.loadPage();
        collectionBuilderTest.testCollectionBuilderButtons(TestData.VALID_EMAIL_CSL_HENRY);
        collectionBuilderTest.testMaxCollectionCreated(TestData.VALID_EMAIL_CSL_HENRY);
        goToFolderNavigator(TestData.FACET_PROVIDERS_MCGRAW_HILL_EDUCATION, TestData.FACET_CATEGORY_RESOURCES_TYPE_UNIT_MODULES);
        collectionBuilderTest.testCollectionBuilderButtons(TestData.VALID_EMAIL_CSL_HENRY);
        collectionBuilderTest.testMaxCollectionCreated(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Collection Builder - lessonp-4949: Collection Builder Items")
    public void testLessonp_4949() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);
        curriculumManagerPageTest.initTest(webDriver);
        curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder();
        collectionBuilderTest.testDragAndDropMaxItemsInsideCollection(TestData.VALID_EMAIL_CSL_HENRY);
        discoverResourcesPage.refreshPageAndDismissBrowserAlert();
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 11);
        collectionBuilderTest.testDragAndDropItem(TestData.VALID_EMAIL_CSL_HENRY);
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 12);
        curriculumManagerPage.loadPage();
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 12);
        goToFolderNavigator(TestData.FACET_PROVIDERS_MCGRAW_HILL_EDUCATION, TestData.FACET_CATEGORY_RESOURCES_TYPE_UNIT_MODULES);
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 12);
        collectionBuilderTest.testCollectionBuilderItem();
    }

    private void goToFolderNavigator(String provider, String folderType) {
        discoverResourcesPage.loadPage();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_PROVIDERS, provider);
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, folderType);
        discoverResourcesPage.clickOpenFolder(true);
        Assert.assertTrue(discoverResourcesPage.getPath().contains(TestData.OPEN_FOLDER_PATH));
    }
}
