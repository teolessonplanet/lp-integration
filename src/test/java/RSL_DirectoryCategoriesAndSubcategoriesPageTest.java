import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_DirectoryCategoriesAndSubcategoriesPageTest extends BaseTest {

    private LoginPage loginPage;
    private User_DirectoryCategoriesAndSubcategoriesPageTest user_directoryCategoriesAndSubcategoriesPageTest;
    private BrowseBySubjectPage browseBySubjectPage;
    private RrpModal rrpModal;
    private DiscoverResourcesPage discoverResourcesPage;
    private CreateNewFolderModal createNewFolderModal;
    private LimitedResourceAccessModal limitedResourceAccessModal;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_directoryCategoriesAndSubcategoriesPageTest = new User_DirectoryCategoriesAndSubcategoriesPageTest();
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
        rrpModal = new RrpModal(webDriver);
        createNewFolderModal = new CreateNewFolderModal(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        limitedResourceAccessModal = new LimitedResourceAccessModal(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Regular SL - Directory Page - Categories and subcategories - C2409: Page UI", groups = {"rsl"})
    public void testC2409() {
        testPageUi(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Directory Page - Categories and subcategories - C2410: Resource Tiles", groups = {"rsl"})
    public void testC2410() {
        testResourceTiles(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Directory Page - Categories and subcategories - C2411: RRP modal (Individual resources)", groups = {"rsl"})
    public void testC2411() {
        testRrpIndividualResource(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - Directory Page - Categories and subcategories - C2412: RRP modal (Collections)", groups = {"rsl"})
    public void testC2412() {
        testRrpCollection(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - Directory Page - Categories and subcategories - C2413: RRP static (Individual resources)", groups = {"rsl"})
    public void testC2413() {
        testRrpIndividualResource(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - Directory Page - Categories and subcategories - C2414: RRP static (Collections)", groups = {"rsl"})
    public void testC2414() {
        testRrpCollection(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - Directory Page - Categories and subcategories - C2415: Browse by Subject", groups = {"rsl"})
    public void testC2415() {
        initDirectoryTestAndLogin(TestData.VALID_EMAIL_RSL_SBCEO);
        user_directoryCategoriesAndSubcategoriesPageTest.testBrowseBySubject(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Directory Page - Categories and subcategories - C2416: Related Topics", groups = {"rsl"})
    public void testC2416() {
        initDirectoryTestAndLogin(TestData.VALID_EMAIL_RSL_SBCEO);
        user_directoryCategoriesAndSubcategoriesPageTest.testRelatedTopics();
    }

    protected void initDirectoryTestAndLogin(String account) {
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        user_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
    }

    protected void testPageUi(String account) {
        initDirectoryTestAndLogin(account);
        user_directoryCategoriesAndSubcategoriesPageTest.testPageUi();
    }

    protected void testResourceTiles(String account) {
        initDirectoryTestAndLogin(account);
        user_directoryCategoriesAndSubcategoriesPageTest.testResourceTiles(account);
    }

    protected void testRrpIndividualResource(String account, boolean rrpStatic) {
        initDirectoryTestAndLogin(account);

        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        discoverResourcesPage.changeToListView();
        browseBySubjectPage.clickSeeFullReview(rrpStatic);
        Assert.assertTrue(rrpModal.isTitleDisplayed());
        Assert.assertTrue(rrpModal.isGoToResourceButtonDisplayed());
        Assert.assertTrue(rrpModal.isAddToFolderDropdownDisplayed());
        Assert.assertTrue(rrpModal.isFavoriteButtonDisplayed() || rrpModal.isFavoriteButtonDisabledDisplayed());

        Assert.assertFalse(rrpModal.isShareButtonDisplayed());

        if (rrpStatic) {
            rrpModal.closeTab();
        } else {
            rrpModal.clickCloseModal();
        }

        browseBySubjectPage.clickGoToResourceForRegularResource(true);
        String currentUrl = browseBySubjectPage.getUrl();
        boolean assertResult = currentUrl.contains(TestData.SERVER_URL + TestData.STAGING_SERVER_SHARED_RESOURCE_URL_2) || !currentUrl.contains(TestData.SERVER_URL);
        Assert.assertTrue(assertResult);
        browseBySubjectPage.closeTab();

        browseBySubjectPage.clickSeeFullReview(rrpStatic);
        rrpModal.clickOnAddToFolderDropdown();
        rrpModal.clickAddToNewCollection();
        createNewFolderModal.waitForModal();
        createNewFolderModal.typeName(TestData.GET_NEW_EMAIL());
        createNewFolderModal.clickOnCreateFolderButton();
        //Assert.assertTrue(rrpModal.getNotificationText().contains(TestData.RESOURCE_ADDED_TO_FOLDER_NOTIFICATION_TEXT));
        if (!rrpModal.isFavoriteButtonDisabledDisplayed()) {
            rrpModal.clickOnFavoriteButton();
            Assert.assertTrue(rrpModal.getNotificationText().contains(TestData.RESOURCE_ADDED_TO_FAVORITES_NOTIFICATION_TEXT));
        }
    }

    protected void testRrpCollection(String account, boolean rrpStatic) {
        initDirectoryTestAndLogin(account);

        browseBySubjectPage.loadPage(TestData.DEVELOPMENT_AND_BEHAVIORAL_DISORDERS_PATH);
        discoverResourcesPage.changeToListView();
        browseBySubjectPage.clickSeeCollection(rrpStatic);
        CollectionRrpModal collectionRrpModal = new CollectionRrpModal(webDriver);

        Assert.assertTrue(collectionRrpModal.isSaveCollectionButtonActiveUserDisplayed() || collectionRrpModal.isSavedCollectionButtonDisabled());
        Assert.assertTrue(collectionRrpModal.isPlayCollectionButtonDisplayed());

        Assert.assertFalse(collectionRrpModal.isShareButtonDisplayed());

        if (collectionRrpModal.isSaveCollectionButtonActiveUserDisplayed()) {
            collectionRrpModal.clickSaveCollectionButtonActiveUser();
            if (limitedResourceAccessModal.isModalDisplayed()) {
                Assert.assertEquals(limitedResourceAccessModal.getLimitedResourceAccessModalTitleText(), TestData.LIMITED_RESOURCE_ACCESS_TITLE);
                Assert.assertTrue(limitedResourceAccessModal.getLimitedResourceAccessModalBodyText().contains(TestData.LIMITED_RESOURCE_ACCESS_MODAL_TEXT));
                limitedResourceAccessModal.clickOnSaveButton();
            }
            //Assert.assertTrue(collectionRrpModal.getNotificationText().contains(TestData.COLLECTION_ADDED_TO_CURRICULUM_MANAGER_NOTIFICATION_TEXT));
        }

        collectionRrpModal.clickPlayCollectionButton();
        collectionRrpModal.focusDriverToLastTab();
        collectionRrpModal.waitForLoad();
        Assert.assertTrue(collectionRrpModal.getUrl().contains(TestData.CURRICULUM_PLAYER_PATH));
    }
}
