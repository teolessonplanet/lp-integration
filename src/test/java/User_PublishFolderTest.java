import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.util.List;

public class User_PublishFolderTest extends BaseTest {
    private StepTwoPage stepTwoPage;
    private User_CurriculumManagerPageTest user_curriculumManagerPageTest;
    private CurriculumManagerPage curriculumManagerPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private EditCollectionModal editCollectionModal;
    private CollectionBuilderPage collectionBuilderPage;
    private ConfirmPublishUploadFileModal confirmPublishUploadFileModal;
    private CollectionNotPublishedModal collectionNotPublishedModal;
    private PublishedFolderModal publishedFolderModal;
    private HeaderPage headerPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        stepTwoPage = new StepTwoPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        user_curriculumManagerPageTest = new User_CurriculumManagerPageTest();
        editCollectionModal = new EditCollectionModal(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        confirmPublishUploadFileModal = new ConfirmPublishUploadFileModal(webDriver);
        collectionNotPublishedModal = new CollectionNotPublishedModal(webDriver);
        publishedFolderModal = new PublishedFolderModal(webDriver);
        headerPage = new HeaderPage(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Active User - Publish Folder - C2207: With LP Resources", groups = {"activeUser"})
    public void testC2207() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testAddResourcesToPublishCollection(TestData.PLAN_PRO, 2, 0, 0, false);
    }

    @Test(description = "Active User- Publish Folder - C2208: With LP Resources & Uploaded Resources - include file", groups = {"activeUser"})
    public void testC2208() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testAddResourcesToPublishCollection(TestData.PLAN_STARTER, 2, 0, 1, true);
    }

    @Test(description = "Active User - Publish Folder - C2209: With LP Resources & Uploaded Resources - do not include file", groups = {"activeUser"})
    public void testC2209() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testAddResourcesToPublishCollection(TestData.PLAN_STARTER, 2, 0, 1, false);
    }

    @Test(description = "Active User - Publish Folder - C2210: With LP Resources & Folders", groups = {"activeUser"})
    public void testC2210() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testAddResourcesToPublishCollection(TestData.PLAN_PRO, 2, 1, 0, false);
    }

    @Test(description = "Active User - Publish Folder - C2211: With LP Resources & Folders & Uploaded Resources - include file", groups = {"activeUser"})
    public void testC2211() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testAddResourcesToPublishCollection(TestData.PLAN_STARTER, 2, 1, 1, true);
    }

    @Test(description = "Active User - Publish Folder - C2212: With LP Resources & Folders & Uploaded Resources - do not include file", groups = {"activeUser"})
    public void testC2212() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testAddResourcesToPublishCollection(TestData.PLAN_STARTER, 2, 1, 1, false);
    }

    @Test(description = "Active User - Publish Folder - C2213: Collection not published modal", groups = {"activeUser"})
    public void testC2213() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testCollectionNotPublishedModal(TestData.PLAN_PRO);
    }

    @Test(description = "Active User - Publish Resource - C2214: Publish Uploaded File - from My Resources", groups = {"activeUser"})
    public void tesC2214() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        user_curriculumManagerPageTest.initTest(webDriver);
        user_curriculumManagerPageTest.testUploadResourceFromMyResources(TestData.PLAN_PRO, true);
    }

    @Test(description = "Active User - Publish Resource - C2216: Publish Curriculum Sets folder w lp resources", groups = {"activeUser"})
    public void testC2216() {
        createRequirementAndTestPublishFolders(TestData.PLAN_PRO, TestData.FOLDER_TYPE[1], 2, 0, 0, false);
    }

    @Test(description = "Active User - Publish Resource - C2217: Publish Chapters Folder w lp resources & uploaded resource - include file", groups = {"activeUser"})
    public void testC2217() {
        createRequirementAndTestPublishFolders(TestData.PLAN_PRO, TestData.FOLDER_TYPE[2], 2, 0, 1, true);
    }

    @Test(description = "Active User - Publish Resource - C2218: Publish Lessons Folder w lp resources & uploaded resource - don't include file", groups = {"activeUser"})
    public void testC2218() {
        createRequirementAndTestPublishFolders(TestData.PLAN_PRO, TestData.FOLDER_TYPE[3], 2, 0, 1, false);
    }

    @Test(description = "Active User - Publish Resource - C2219: Publish Assessment Sets folder w lp resources & folders", groups = {"activeUser"})
    public void testC2219() {
        createRequirementAndTestPublishFolders(TestData.PLAN_PRO, TestData.FOLDER_TYPE[4], 2, 1, 0, false);
    }

    @Test(description = "Active User - Publish Resource - C2220: Publish Unit Modules folder w lp resources & folders & uploaded resources - include file", groups = {"activeUser"})
    public void testC2220() {
        createRequirementAndTestPublishFolders(TestData.PLAN_PRO, TestData.FOLDER_TYPE[5], 2, 2, 2, true);
    }

    @Test(description = "Active User - Publish Resource - C2221: Publish Root Folders containing only uploaded & unshared file - don't include files", groups = {"activeUser"})
    public void testC2221() {
        createRequirementAndTestPublishFolders(TestData.PLAN_PRO, TestData.FOLDER_TYPE[7], 0, 0, 2, false);
    }

    private void createRequirementAndTestPublishFolders(String accountPlan, String folderType, int noOfResources, int noOfFolders, int noOfUploadedResources, boolean includeUploadedFiles) {
        final String username = stepTwoPage.createNewAccount(accountPlan);
        curriculumManagerPage.loadPage();
        user_curriculumManagerPageTest.initTest(webDriver);
        user_curriculumManagerPageTest.testCreateFolderFromCurriculumManager(folderType + username, folderType);
        discoverResourcesPage.loadSearchPageInListView();
        testPublishFolders(accountPlan, noOfResources, noOfFolders, noOfUploadedResources, includeUploadedFiles);
    }

    private void testPublishFolders(String accountPlan, int noOfResources, int noOfFolders, int noOfUploadedResources, boolean includeUploadedFiles) {
        if (accountPlan.equals(TestData.VALID_EMAIL_CSL_HENRY) || accountPlan.equals(TestData.PLAN_PRO)) {
            discoverResourcesPage.expandProvidersFacet();
        }
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);

        if (noOfResources > 0) {
            List<WebElement> getFullReviewResources = discoverResourcesPage.getAllSeeFullReviewButtons();
            for (int i = 0; i < noOfResources; i++) {
                discoverResourcesPage.dragAndDrop(getFullReviewResources.get(i), collectionBuilderPage.getCollectionDroppableZone());
            }
        }

        if (noOfFolders > 0) {
            discoverResourcesPage.loadPage();
            discoverResourcesPage.checkLessonPlanetProvider();
            discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_UNIT_MODULES);
            List<WebElement> getSeeCollectionUnitModuleResources = discoverResourcesPage.getAllSeeCollectionsUnitModulesButtons();
            for (int i = 0; i < noOfFolders; i++) {
                discoverResourcesPage.dragAndDrop(getSeeCollectionUnitModuleResources.get(i), collectionBuilderPage.getCollectionDroppableZone());
            }
        }

        headerPage.hoverOverDiscoverButton();
        headerPage.clickOnCurriculumManagerButton();

        curriculumManagerPage.waitForLoad();
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnEditButton();
        editCollectionModal.completeCollectionForPublish(accountPlan, TestData.GET_CURRENT_TIME(), TestData.EDIT_COLLECTION_GRADE_HIGHER_ED, TestData.EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION, TestData.NEW_COLLECTION_DESCRIPTION);

        if (noOfUploadedResources > 0) {
            for (int i = 0; i < noOfUploadedResources; i++) {
                curriculumManagerPage.refreshPageAndDismissBrowserAlert();
                curriculumManagerPage.hoverOverActionsDropdown();
                curriculumManagerPage.clickOnActionsDropdown();
                curriculumManagerPage.clickOnEditButton();
                editCollectionModal.clickOnAddItemsDropdown();
                editCollectionModal.clickFileUploadButton();
                user_curriculumManagerPageTest.testUpload(true, accountPlan, false);
            }
            editCollectionModal.clickMoreDropdown();
            editCollectionModal.clickOnPublishOption();
            editCollectionModal.clickOnPublishFolder();

            if (includeUploadedFiles) {
                confirmPublishUploadFileModal.clickOnIncludeFileOption();
            } else {
                confirmPublishUploadFileModal.clickOnDoNotIncludeFileOption();
            }
            confirmPublishUploadFileModal.checkAgreementOption();
            confirmPublishUploadFileModal.clickOnPublishCollectionButton();
            confirmPublishUploadFileModal.waitUntilConfirmPublishModalIsNotDisplayed();

        } else {
            editCollectionModal.clickOnPublishFolder();
            editCollectionModal.waitUntilPublishFolderSectionIsNotDisplayed();
        }

        if (noOfResources == 0 & noOfFolders == 0 && !includeUploadedFiles) {
            // don't publish
            collectionNotPublishedModal.waitForModal();
            Assert.assertEquals(collectionNotPublishedModal.getModalTitle(), TestData.COLLECTION_NOT_PUBLISHED_MODAL_TITLE);
            Assert.assertEquals(collectionNotPublishedModal.getModalText(), TestData.COLLECTION_NOT_PUBLISHED_MODAL_TEXT);
            collectionNotPublishedModal.clickOnOkButton();
        } else {
            if (!accountPlan.equals(TestData.VALID_EMAIL_CSL_HENRY) && !accountPlan.equals(TestData.VALID_EMAIL_CSL_COBB) && !accountPlan.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
                publishedFolderModal.clickOnCloseButton();
            }

            curriculumManagerPage.loadPage();
            curriculumManagerPage.waitForPageLoad();
            Assert.assertEquals(curriculumManagerPage.getFolderStatus(), TestData.PRIVATE_AND_PUBLISHED_STATUS);
        }
    }

    public void testAddResourcesToPublishCollection(String accountPlan, int noOfResources, int noOfFolders, int noOfUploadedResources, boolean includedFile) {
        discoverResourcesPage.loadSearchPageInListView();
        user_curriculumManagerPageTest.initTest(webDriver);
        user_curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder(TestData.NEW_COLLECTION_NAME);
        testPublishFolders(accountPlan, noOfResources, noOfFolders, noOfUploadedResources, includedFile);
    }

    public void testCollectionNotPublishedModal(String account) {
        discoverResourcesPage.loadSearchPageInListView();
        user_curriculumManagerPageTest.initTest(webDriver);
        user_curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder(TestData.NEW_COLLECTION_NAME);

        curriculumManagerPage.loadPage();
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnEditButton();

        editCollectionModal.completeCollectionForPublish(account, TestData.GET_CURRENT_TIME(), TestData.EDIT_COLLECTION_GRADE_HIGHER_ED, TestData.EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION, TestData.NEW_COLLECTION_DESCRIPTION);

        curriculumManagerPage.refreshPageAndDismissBrowserAlert();
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnEditButton();
        editCollectionModal.clickOnAddItemsDropdown();

        editCollectionModal.clickOnCreatePageOption();
        editCollectionModal.typePageTitle(TestData.PAGE_TITLE);
        editCollectionModal.typePageContent(TestData.HEALTH_CATEGORY_MODAL_DEFAULT_TEXT);
        editCollectionModal.clickSaveButton();

        editCollectionModal.clickOnAddItemsDropdown();
        editCollectionModal.clickFileUploadButton();
        user_curriculumManagerPageTest.testUpload(true, account, false);

        editCollectionModal.clickMoreDropdown();
        editCollectionModal.clickOnPublishOption();
        editCollectionModal.clickOnPublishFolder();

        confirmPublishUploadFileModal.clickOnDoNotIncludeFileOption();
        confirmPublishUploadFileModal.checkAgreementOption();
        confirmPublishUploadFileModal.clickOnPublishCollectionButton();

        collectionNotPublishedModal.waitForModal();
        Assert.assertEquals(collectionNotPublishedModal.getModalTitle(), TestData.COLLECTION_NOT_PUBLISHED_MODAL_TITLE);
        Assert.assertEquals(collectionNotPublishedModal.getModalText(), TestData.COLLECTION_NOT_PUBLISHED_MODAL_TEXT);
        collectionNotPublishedModal.clickOnOkButton();
        editCollectionModal.clickOnCloseButton();
        Assert.assertTrue(curriculumManagerPage.getFolderStatus().contains(TestData.PRIVATE_STATUS));
    }
}
