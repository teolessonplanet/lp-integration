import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.util.List;

public class PublishCollectionTest extends BaseTest {
    private StepTwoPage stepTwoPage;
    private CurriculumManagerPageTest curriculumManagerPageTest;
    private CollectionBuilderTest collectionBuilderTest;
    private CurriculumManagerPage curriculumManagerPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private EditCollectionModal editCollectionModal;
    private CollectionBuilderPage collectionBuilderPage;
    private ConfirmPublishUploadFileModal confirmPublishUploadFileModal;
    private CollectionNotPublishedModal collectionNotPublishedModal;
    private PrivateDocumentsModal privateDocumentsModal;
    private PublishedFolderModal publishedFolderModal;

    @BeforeMethod
    public void beforeMethod() {
        stepTwoPage = new StepTwoPage(webDriver);
        collectionBuilderTest = new CollectionBuilderTest();
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        curriculumManagerPageTest = new CurriculumManagerPageTest();
        editCollectionModal = new EditCollectionModal(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        confirmPublishUploadFileModal = new ConfirmPublishUploadFileModal(webDriver);
        collectionNotPublishedModal = new CollectionNotPublishedModal(webDriver);
        privateDocumentsModal = new PrivateDocumentsModal(webDriver);
        publishedFolderModal = new PublishedFolderModal(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Active User - Publish Collection - lessonp-5826: With LP Resources")
    public void testLessonp_5826() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testAddResourcesToPublishCollection(TestData.PLAN_PRO, 2, 0, 0, false);
    }

    @Test(description = "Active User- Publish Collection - lessonp-986: With LP Resources & Uploaded Resources - include file")
    public void testLessonp_986() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testAddResourcesToPublishCollection(TestData.PLAN_STARTER, 2, 0, 1, true);
    }

    @Test(description = "Active User - Publish Collection - lessonp-987: With LP Resources & Uploaded Resources - do not include file")
    public void testLessonp_987() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testAddResourcesToPublishCollection(TestData.PLAN_STARTER, 2, 0, 1, false);
    }

    @Test(description = "Active User - Publish Collection - lessonp-5827: With LP Resources & Folders")
    public void testLessonp_5827() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testAddResourcesToPublishCollection(TestData.PLAN_PRO, 2, 1, 0, false);
    }

    @Test(description = "Active User - Publish Collection - lessonp-5794: With LP Resources & Folders & Uploaded Resources - include file")
    public void testLessonp_5794() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testAddResourcesToPublishCollection(TestData.PLAN_STARTER, 2, 1, 1, true);
    }

    @Test(description = "Active User - Publish Collection - lessonp-5795: With LP Resources & Folders & Uploaded Resources - do not include file")
    public void testLessonp_5795() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testAddResourcesToPublishCollection(TestData.PLAN_STARTER, 2, 1, 1, false);
    }

    @Test(description = "Active User - Publish Collection - lessonp-5828: Collection not published modal")
    public void testLessonp_5828() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testCollectionNotPublishedModal(TestData.PLAN_PRO);
    }

    @Test(description = "Active User - Publish Resource - lessonp-995: Publish Uploaded File - from My Resources")
    public void testLessonp_995() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        curriculumManagerPageTest.initTest(webDriver);
        curriculumManagerPageTest.testUploadResourceFromMyResources(TestData.PLAN_PRO, true);
    }

    @Test(description = "Active User - Publish Resource - lessonp-5616: Publish Uploaded FIle - from Collection Builder")
    public void testLessonp_5616() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        curriculumManagerPageTest.initTest(webDriver);
        curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder(TestData.NEW_COLLECTION_NAME);
        collectionBuilderTest.initTest(webDriver);
        collectionBuilderTest.testUploadResourceFromCollectionBuilder(TestData.PLAN_PRO, true, TestData.PUBLISH_RESOURCE_TITLE);
    }

    @Test(description = "Active User - Publish Resource - lessonp-5863:Publish Curriculum Sets folder w lp resources")
    public void testLessonp_5863() {
        createRequirementAndTestPublishFolders(TestData.PLAN_PRO, TestData.FOLDER_TYPE[1], 2, 0, 0, false);
    }

    @Test(description = "Active User - Publish Resource - lessonp-5864:Publish Chapters Folder w lp resources & uploaded resource - include file")
    public void testLessonp_5864() {
        createRequirementAndTestPublishFolders(TestData.PLAN_PRO, TestData.FOLDER_TYPE[2], 2, 0, 1, true);
    }

    @Test(description = "Active User - Publish Resource - 5865:Publish Lessons Folder w lp resources & uploaded resource - don't include file")
    public void testLessonp_5865() {
        createRequirementAndTestPublishFolders(TestData.PLAN_PRO, TestData.FOLDER_TYPE[3], 2, 0, 1, false);
    }

    @Test(description = "Active User - Publish Resource - 5866:Publish Assessment Sets folder w lp resources & folders")
    public void testLessonp_5866() {
        createRequirementAndTestPublishFolders(TestData.PLAN_PRO, TestData.FOLDER_TYPE[4], 2, 1, 0, false);
    }

    @Test(description = "Active User - Publish Resource - lessonp-5867:Publish Unit Modules folder w lp resources & folders & uploaded resources - include file")
    public void testLessonp_5867() {
        createRequirementAndTestPublishFolders(TestData.PLAN_PRO, TestData.FOLDER_TYPE[5], 2, 2, 2, true);
    }

    @Test(description = "Active User - Publish Resource - 5868:Publish Root Folders containing only uploaded & unshared file - don't include files")
    public void testLessonp_5868() {
        createRequirementAndTestPublishFolders(TestData.PLAN_PRO, TestData.FOLDER_TYPE[7], 0, 0, 2, false);
    }

    private void createRequirementAndTestPublishFolders(String accountPlan, String folderType, int noOfResources, int noOfFolders, int noOfUploadedResources, boolean includeUploadedFiles) {
        final String username = stepTwoPage.createNewAccount(accountPlan);
        curriculumManagerPage.loadPage();
        curriculumManagerPageTest.initTest(webDriver);
        curriculumManagerPageTest.testCreateFolderFromCurriculumManager(folderType + username, folderType);
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

        curriculumManagerPage.loadPage();
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnEditButton();
//        editCollectionModal.publishCollection(accountPlan, TestData.GET_CURRENT_TIME(), TestData.EDIT_COLLECTION_GRADE_HIGHER_ED, TestData.EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION, TestData.NEW_COLLECTION_DESCRIPTION);
        editCollectionModal.completeCollectionForPublish(accountPlan, TestData.GET_CURRENT_TIME(), TestData.EDIT_COLLECTION_GRADE_HIGHER_ED, TestData.EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION, TestData.NEW_COLLECTION_DESCRIPTION);

        if (noOfUploadedResources > 0) {
            for (int i = 0; i < noOfUploadedResources; i++) {
                editCollectionModal.clickOnAddItemsDropdown();
                editCollectionModal.clickFileUploadButton();
                curriculumManagerPageTest.testUpload(true, accountPlan, false);
            }
            editCollectionModal.clickMoreDropdown();
            editCollectionModal.clickOnPublishOption();
            editCollectionModal.chooseAudience();
            editCollectionModal.chooseRating();
            editCollectionModal.chooseAdditionalTags();
            editCollectionModal.clickOnPublishFolder();

            if (!accountPlan.equals(TestData.VALID_EMAIL_CSL_HENRY) && (!accountPlan.equals(TestData.VALID_EMAIL_CSL_COBB))) {
                if (includeUploadedFiles) {
                    confirmPublishUploadFileModal.clickOnIncludeFileOption();
                } else {
                    confirmPublishUploadFileModal.clickOnDoNotIncludeFileOption();
                }
                confirmPublishUploadFileModal.checkAgreementOption();
                confirmPublishUploadFileModal.clickOnPublishCollectionButton();
            } else {
                testPrivateDocumentsModal();
            }
        } else {
            editCollectionModal.clickOnPublishFolder();
        }

        if (noOfResources == 0 & noOfFolders == 0 && !includeUploadedFiles) {
            // don't publish
            collectionNotPublishedModal.waitForModal();
            Assert.assertEquals(collectionNotPublishedModal.getModalTitle(), TestData.COLLECTION_NOT_PUBLISHED_MODAL_TITLE);
            Assert.assertEquals(collectionNotPublishedModal.getModalText(), TestData.COLLECTION_NOT_PUBLISHED_MODAL_TEXT);
            collectionNotPublishedModal.clickOnOkButton();
        } else {
            if (!accountPlan.equals(TestData.VALID_EMAIL_CSL_HENRY) && !accountPlan.equals(TestData.VALID_EMAIL_CSL_COBB)) {
                publishedFolderModal.clickOnCloseButton();
            }
            editCollectionModal.clickOnCloseButton();
            curriculumManagerPage.waitUntilPublishedStatusIsDisplayed();
            Assert.assertEquals(curriculumManagerPage.getFolderStatus(), TestData.PRIVATE_AND_PUBLISHED_STATUS);
        }
    }

    public void testAddResourcesToPublishCollection(String accountPlan, int noOfResources, int noOfFolders, int noOfUploadedResources, boolean includedFile) {
        discoverResourcesPage.loadSearchPageInListView();
        curriculumManagerPageTest.initTest(webDriver);
        curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder(TestData.NEW_COLLECTION_NAME);
        testPublishFolders(accountPlan, noOfResources, noOfFolders, noOfUploadedResources, includedFile);
    }

    public void testCollectionNotPublishedModal(String account) {
        discoverResourcesPage.loadSearchPageInListView();
        curriculumManagerPageTest.initTest(webDriver);
        curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder(TestData.NEW_COLLECTION_NAME);

        curriculumManagerPage.loadPage();
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnEditButton();

//        editCollectionModal.publishCollection(account, TestData.GET_CURRENT_TIME(), TestData.EDIT_COLLECTION_GRADE_HIGHER_ED, TestData.EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION, TestData.NEW_COLLECTION_DESCRIPTION);
        editCollectionModal.completeCollectionForPublish(account, TestData.GET_CURRENT_TIME(), TestData.EDIT_COLLECTION_GRADE_HIGHER_ED, TestData.EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION, TestData.NEW_COLLECTION_DESCRIPTION);

        editCollectionModal.clickOnAddItemsDropdown();
        editCollectionModal.clickOnCreatePageOption();
        editCollectionModal.typePageTitle(TestData.PAGE_TITLE);
        editCollectionModal.typePageContent(TestData.HEALTH_CATEGORY_MODAL_DEFAULT_TEXT);
        editCollectionModal.clickSaveButton();

        editCollectionModal.clickOnAddItemsDropdown();
        editCollectionModal.clickFileUploadButton();
        curriculumManagerPageTest.testUpload(true, account, false);

        editCollectionModal.clickMoreDropdown();
        editCollectionModal.clickOnPublishOption();
        editCollectionModal.chooseAudience();
        editCollectionModal.chooseRating();
        editCollectionModal.chooseAdditionalTags();
        editCollectionModal.clickOnPublishFolder();

        if (!account.equals(TestData.VALID_EMAIL_CSL_HENRY) && !account.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            confirmPublishUploadFileModal.clickOnDoNotIncludeFileOption();
            confirmPublishUploadFileModal.checkAgreementOption();
            confirmPublishUploadFileModal.clickOnPublishCollectionButton();
        } else {
            testPrivateDocumentsModal();
        }

        collectionNotPublishedModal.waitForModal();
        Assert.assertEquals(collectionNotPublishedModal.getModalTitle(), TestData.COLLECTION_NOT_PUBLISHED_MODAL_TITLE);
        Assert.assertEquals(collectionNotPublishedModal.getModalText(), TestData.COLLECTION_NOT_PUBLISHED_MODAL_TEXT);
        collectionNotPublishedModal.clickOnOkButton();
        editCollectionModal.clickOnCloseButton();
        Assert.assertTrue(curriculumManagerPage.getFolderStatus().contains(TestData.PRIVATE_STATUS));
    }

    private void testPrivateDocumentsModal() {
        privateDocumentsModal.waitForModal();
        Assert.assertEquals(privateDocumentsModal.getModalTitleText(), TestData.PRIVATE_DOCUMENTS_MODAL_TITLE_TEXT);
        privateDocumentsModal.clickOnContinueButton();
    }
}
