import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_SharedByMyDistrictTest extends BaseTest {
    private LoginPage loginPage;
    private RSL_AdminManager_ContentTest rsl_adminManagerContentTest;
    private CSL_ContentManagerPage csl_contentManagerPage;
    private CurriculumManagerPage curriculumManagerPage;
    private CollectionBuilderPage collectionBuilderPage;
    private CreateNewFolderModal createNewFolderModal;
    private EditCollectionModal editCollectionModal;
    private PostToModal postToModal;
    private DeletePostedFolderModal deletePostedFolderModal;
    private DistrictSharedPage districtSharedPage;
    private SharedByMyDistrictPage sharedByMyDistrictPage;

    @BeforeMethod(alwaysRun = true)
    private void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rsl_adminManagerContentTest = new RSL_AdminManager_ContentTest();
        csl_contentManagerPage = new CSL_ContentManagerPage(webDriver);
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        createNewFolderModal = new CreateNewFolderModal(webDriver);
        editCollectionModal = new EditCollectionModal(webDriver);
        postToModal = new PostToModal(webDriver);
        deletePostedFolderModal = new DeletePostedFolderModal(webDriver);
        districtSharedPage = new DistrictSharedPage(webDriver);
        sharedByMyDistrictPage = new SharedByMyDistrictPage(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Custom SL - Shared By My District - C2451: Content Manager Tab", priority = 1, groups = {"csl"})
    public void testC2451() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        rsl_adminManagerContentTest.initTest(webDriver);
        rsl_adminManagerContentTest.reachContentManagerPage();
        csl_contentManagerPage.clickOnDistrictSharedTab();

        Assert.assertTrue(csl_contentManagerPage.getUrl().contains(TestData.DISTRICT_SHARED_PATH));
        Assert.assertTrue(districtSharedPage.isCreateAFolderButtonDisplayed());
        Assert.assertTrue(districtSharedPage.isSortByDropdownDisplayed());
        Assert.assertTrue(districtSharedPage.isShowHideDetailsButtonDisplayed());
        Assert.assertFalse(districtSharedPage.isUploadResourceButtonDisplayed());

        int currentNoOfFolders = districtSharedPage.getCountFolders();
        if (currentNoOfFolders > 0) {
            Assert.assertTrue(districtSharedPage.isFolderListDisplayed());
        } else {
            Assert.assertEquals(districtSharedPage.getEmptyPageText(), TestData.EMPTY_DISTRICT_SHARED_TAB);
        }

        Assert.assertTrue(collectionBuilderPage.isMyCollectionDropdownDisplayed());
        collectionBuilderPage.clickOnDropdown();
        Assert.assertTrue(collectionBuilderPage.isCreateNewCollectionButtonDisplayed());

        districtSharedPage.clickOnCreateAFolderButton();
        createNewFolderModal.waitForModal();
        createNewFolderModal.typeName(TestData.SHARED_WITH_FOLDER);
        createNewFolderModal.chooseFolderType(TestData.FOLDER_TYPE[0]);
        createNewFolderModal.typeDescription(TestData.NEW_FOLDER_DESCRIPTION);
        createNewFolderModal.clickOnCreateFolderButton();
        Assert.assertEquals(districtSharedPage.getFolderTitle(), TestData.SHARED_WITH_FOLDER);
        Assert.assertEquals(districtSharedPage.getFolderType(), TestData.FOLDER_TYPE[0]);
        Assert.assertEquals(districtSharedPage.getFolderStatus(), TestData.UNPOSTED_STATUS);

        collectionBuilderPage.clickOnEditFolder(false);

        editCollectionModal.clickOnAddItemsDropdown();
        editCollectionModal.clickOnPixabayImageOption();
        editCollectionModal.typePageTitle(TestData.PAGE_TITLE);
        editCollectionModal.typePageContent(TestData.HEALTH_CATEGORY_MODAL_DEFAULT_TEXT);
        editCollectionModal.clickSaveButton();
        Assert.assertEquals(editCollectionModal.getFolderItemTitle(0), TestData.PAGE_TITLE);

        editCollectionModal.clickOnAddItemsDropdown();
        editCollectionModal.clickOnCreatePageOption();
        editCollectionModal.typeNewFolderName();
        editCollectionModal.clickOnCreateFolderButton();

        editCollectionModal.clickOnCloseButton();
        districtSharedPage.clickOnActionsDropdown();
        Assert.assertTrue(districtSharedPage.isPostFolderButtonDisplayed(null));
        Assert.assertTrue(districtSharedPage.isEditFolderButtonDisplayed(null));
        Assert.assertTrue(districtSharedPage.isPlayFolderButtonDisplayed(null));
        Assert.assertTrue(districtSharedPage.isPlayFolderButtonDisplayed(null));
        Assert.assertTrue(districtSharedPage.isPublishFolderButtonDisplayed(null));
        Assert.assertTrue(districtSharedPage.isCopyFolderToButtonDisplayed(null));
        Assert.assertTrue(districtSharedPage.isMoveFolderToButtonDisplayed(null));
        Assert.assertTrue(districtSharedPage.isDeleteFolderButtonDisplayed(null));

        districtSharedPage.clickOnPostFolderButton();
        Assert.assertEquals(postToModal.getPostToModalTitleText(), TestData.POST_TO_MODAL_TITLE);
        Assert.assertTrue(postToModal.getPostToModalBoxyText().contains(TestData.POST_TO_MODAL_BODY));
        postToModal.clickOnPostButton();
        Assert.assertEquals(districtSharedPage.getFolderStatus(), TestData.POSTED_STATUS);

        Assert.assertEquals(districtSharedPage.getSortByValue(), TestData.SORT_BY_DISTRICT_ORDER);
        districtSharedPage.refreshPageAndDismissBrowserAlert();
        districtSharedPage.clickOnSortByDropdown();
        Assert.assertTrue(districtSharedPage.isSortByTitleOptionDisplayed());
        Assert.assertTrue(districtSharedPage.isSortByDateUpdatedOptionDisplayed());
        Assert.assertTrue(districtSharedPage.isSortByDatePostedOptionDisplayed());
        Assert.assertTrue(districtSharedPage.isSortByStatusOptionDisplayed());
        Assert.assertTrue(districtSharedPage.isSortByDistrictOrderOptionDisplayed());

        districtSharedPage.clickOnDatePostedOption();
        Assert.assertEquals(districtSharedPage.getSortByValue(), TestData.SORT_BY_DATE_POSTED);
        rsl_adminManagerContentTest.reachContentManagerPage();
        csl_contentManagerPage.clickOnDistrictSharedTab();
        Assert.assertEquals(districtSharedPage.getSortByValue(), TestData.SORT_BY_DISTRICT_ORDER);

        districtSharedPage.clickOnShowAndHideDetailsButton();
        Assert.assertFalse(districtSharedPage.isDateColumnDisplayed());
        Assert.assertFalse(districtSharedPage.isStatusColumnDisplayed());
        districtSharedPage.clickOnShowAndHideDetailsButton();
        Assert.assertTrue(districtSharedPage.isStatusColumnDisplayed());
        Assert.assertTrue(districtSharedPage.isDateColumnDisplayed());

        districtSharedPage.clickOnFolderInfoIcon(0);
        Assert.assertEquals(districtSharedPage.getFolderStatus(), TestData.POSTED_STATUS);
        Assert.assertEquals(districtSharedPage.getFolderType(), TestData.FOLDER_TYPE[0]);

        districtSharedPage.hoverOverFolder(0);
        districtSharedPage.clickOnViewFolderButton();

        WebElement resource0 = districtSharedPage.getResourceDrilledIn(0);
        WebElement resource1 = districtSharedPage.getResourceDrilledIn(1);

        districtSharedPage.clickOnActionsDropdownButton(resource0);
        Assert.assertTrue(districtSharedPage.isUnPostFolderButtonDisplayed(resource0));
        Assert.assertTrue(districtSharedPage.isEditFolderButtonDisplayed(resource0));
        Assert.assertTrue(districtSharedPage.isPlayFolderButtonDisplayed(resource0));
        Assert.assertTrue(districtSharedPage.isPlayFolderButtonDisplayed(resource0));
        Assert.assertTrue(districtSharedPage.isPublishFolderButtonDisplayed(resource0));
        Assert.assertTrue(districtSharedPage.isCopyFolderToButtonDisplayed(resource0));
        Assert.assertTrue(districtSharedPage.isMoveFolderToButtonDisplayed(resource0));
        Assert.assertTrue(districtSharedPage.isDeleteFolderButtonDisplayed(resource0));

        districtSharedPage.clickOnActionsDropdownButton(resource0);
        districtSharedPage.clickOnActionsDropdownButton(resource1);
        Assert.assertTrue(districtSharedPage.isCopyFolderToButtonDisplayed(resource1));
        Assert.assertTrue(districtSharedPage.isMoveFolderToButtonDisplayed(resource1));
        Assert.assertTrue(districtSharedPage.isDeleteFolderButtonDisplayed(resource1));
        districtSharedPage.clickOnActionsDropdownButton(resource1);
    }

    @Test(description = "Custom SL - Shared By My District - C2450: Curriculum Manager Tab", priority = 2, groups = {"csl"})
    public void testC2450() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnSharedByDistrictTab();
        Assert.assertEquals(districtSharedPage.getFolderTitle(), TestData.SHARED_WITH_FOLDER);
        Assert.assertTrue(csl_contentManagerPage.getUrl().contains(TestData.SHARED_BY_PATH));

        int currentNoOfFolders = sharedByMyDistrictPage.getCountFolders();
        if (currentNoOfFolders > 0) {
            Assert.assertTrue(sharedByMyDistrictPage.isFolderListDisplayed());
        } else {
            Assert.assertEquals(sharedByMyDistrictPage.getEmptyPageText(), TestData.SHARED_BY_EMPTY_TEXT);
        }

        Assert.assertTrue(collectionBuilderPage.isMyCollectionDropdownDisplayed());
        collectionBuilderPage.clickOnDropdown();
        Assert.assertTrue(collectionBuilderPage.isCreateNewCollectionButtonDisplayed());
        collectionBuilderPage.clickOnCreateNewCollection();
        createNewFolderModal.waitForModal();
        createNewFolderModal.typeName(TestData.RESOURCE_TYPE_ARTICLE);
        createNewFolderModal.clickOnCreateFolderButton();

        Assert.assertEquals(sharedByMyDistrictPage.getCountFolders(), currentNoOfFolders);
        Assert.assertEquals(sharedByMyDistrictPage.getFolderTitle(), TestData.SHARED_WITH_FOLDER);

        Assert.assertFalse(sharedByMyDistrictPage.isCreateAFolderButtonDisplayed());
        Assert.assertFalse(sharedByMyDistrictPage.isShowHideDetailsButtonDisplayed());
        Assert.assertTrue(sharedByMyDistrictPage.isSortByDropdownDisplayed());

        sharedByMyDistrictPage.clickOnSortByDropdown();
        Assert.assertTrue(sharedByMyDistrictPage.isSortByTitleOptionDisplayed());
        Assert.assertTrue(sharedByMyDistrictPage.isSortByDatePostedOptionDisplayed());
        Assert.assertTrue(sharedByMyDistrictPage.isSortByDistrictOrderOptionDisplayed());

        sharedByMyDistrictPage.clickOnDatePostedOption();
        Assert.assertEquals(sharedByMyDistrictPage.getSortByValue(), TestData.SORT_BY_DATE_POSTED);
        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnSharedByDistrictTab();
        Assert.assertEquals(sharedByMyDistrictPage.getSortByValue(), TestData.SORT_BY_DISTRICT_ORDER);

        sharedByMyDistrictPage.hoverOverFolder(0);
        sharedByMyDistrictPage.clickOnViewFolderButton();

        WebElement resource0 = sharedByMyDistrictPage.getResourceDrilledIn(0);
        WebElement resource1 = sharedByMyDistrictPage.getResourceDrilledIn(1);

        sharedByMyDistrictPage.clickOnActionsDropdownButton(resource0);
        Assert.assertTrue(sharedByMyDistrictPage.isPlayFolderButtonDisplayed(resource0));
        Assert.assertTrue(sharedByMyDistrictPage.isCopyFolderToButtonDisplayed(resource0));

        districtSharedPage.clickOnActionsDropdownButton(resource0);
        districtSharedPage.clickOnActionsDropdownButton(resource1);
        Assert.assertTrue(sharedByMyDistrictPage.isCopyFolderToButtonDisplayed(resource1));
        sharedByMyDistrictPage.clickOnActionsDropdownButton(resource1);
    }

    @Test(description = "Custom SL - Shared By My District - C2452: Unpost", priority = 3, groups = {"csl"})
    public void testC2452() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        rsl_adminManagerContentTest.initTest(webDriver);
        rsl_adminManagerContentTest.reachContentManagerPage();
        csl_contentManagerPage.clickOnDistrictSharedTab();

        districtSharedPage.clickOnFolderInfoIcon(0);
        Assert.assertEquals(districtSharedPage.getFolderStatus(), TestData.POSTED_STATUS);

        districtSharedPage.clickOnActionsDropdown();
        districtSharedPage.clickOnUnPostFolderButton();
        Assert.assertEquals(districtSharedPage.getFolderStatus(), TestData.UNPOSTED_STATUS);

        districtSharedPage.clickOnFolderInfoIcon(0);
        Assert.assertEquals(districtSharedPage.getFolderStatus(), TestData.UNPOSTED_STATUS);

        districtSharedPage.hoverOverFolder(0);
        districtSharedPage.clickOnViewFolderButton();

        WebElement resource0 = districtSharedPage.getResourceDrilledIn(0);
        districtSharedPage.clickOnActionsDropdownButton(resource0);
        Assert.assertTrue(districtSharedPage.isPostFolderButtonDisplayed(resource0));

        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnSharedByDistrictTab();
        Assert.assertEquals(sharedByMyDistrictPage.getEmptyPageText(), TestData.SHARED_BY_EMPTY_TEXT);

        rsl_adminManagerContentTest.initTest(webDriver);
        rsl_adminManagerContentTest.reachContentManagerPage();
        csl_contentManagerPage.clickOnDistrictSharedTab();
        districtSharedPage.clickOnActionsDropdown();
        districtSharedPage.clickOnDeleteFolderButton(null);
        deletePostedFolderModal.clickOnDeleteButton();
    }
}
