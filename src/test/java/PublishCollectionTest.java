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
    private ConfirmShareFolderModal confirmShareFolderModal;
    private CollectionNotPublishedModal collectionNotPublishedModal;
    private PrivateDocumentsModal privateDocumentsModal;

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
        confirmShareFolderModal = new ConfirmShareFolderModal(webDriver);
        collectionNotPublishedModal = new CollectionNotPublishedModal(webDriver);
        privateDocumentsModal = new PrivateDocumentsModal(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Active User - Publish Collection - lessonp-5826: With LP Resources")
    public void testLessonp_5826() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testAddResourcesToPublishCollection(false, false, TestData.PLAN_PRO, false);
    }

    @Test(description = "Active User- Publish Collection - lessonp-986: With LP Resources & Uploaded Resources - include file")
    public void testLessonp_986() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRIME);
        testAddResourcesToPublishCollection(false, true, TestData.PLAN_PRIME, true);
    }

    @Test(description = "Active User - Publish Collection - lessonp-987: With LP Resources & Uploaded Resources - do not include file")
    public void testLessonp_987() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testAddResourcesToPublishCollection(false, true, TestData.PLAN_STARTER, false);
    }

    @Test(description = "Active User - Publish Collection - lessonp-5827: With LP Resources & Folders")
    public void testLessonp_5827() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testAddResourcesToPublishCollection(true, false, TestData.PLAN_PRO, false);
    }

    @Test(description = "Active User - Publish Collection - lessonp-5794: With LP Resources & Folders & Uploaded Resources - include file")
    public void testLessonp_5794() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRIME);
        testAddResourcesToPublishCollection(true, true, TestData.PLAN_PRIME, true);
    }

    @Test(description = "Active User - Publish Collection - lessonp-5795: With LP Resources & Folders & Uploaded Resources - do not include file")
    public void testLessonp_5795() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        testAddResourcesToPublishCollection(true, true, TestData.PLAN_STARTER, false);
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
        curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder();
        collectionBuilderTest.initTest(webDriver);
        collectionBuilderTest.testUploadResourceFromCollectionBuilder(TestData.PLAN_PRO, true, TestData.PUBLISH_RESOURCE_TITLE);
    }

    @Test(description = "Free member - Publish Collection - lessonp-5849: With LP Resources")
    public void testLessonp_5849() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testAddResourcesToPublishCollection(false, false, TestData.PLAN_FREEMIUM, false);
    }

    @Test(description = "Free Member- Publish Collection - lessonp-5729: With LP Resources & Folders")
    public void testLessonp_5729() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testAddResourcesToPublishCollection(true, false, TestData.PLAN_FREEMIUM, false);
    }

    public void testAddResourcesToPublishCollection(boolean folder, boolean uploadedResource, String account, boolean includedFile) {
        discoverResourcesPage.loadSearchPageInListView();
        curriculumManagerPageTest.initTest(webDriver);
        curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder();
        if(account.equals(TestData.VALID_EMAIL_CSL_HENRY)){
            discoverResourcesPage.expandProvidersFacet();
        }
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);
        List<WebElement> getFullReviewResources = discoverResourcesPage.getAllSeeFullReviewButtons();
        for (int i = 0; i <= 1; i++) {
            discoverResourcesPage.dragAndDrop(getFullReviewResources.get(i), collectionBuilderPage.getCollectionDroppableZone());
        }
        if (folder) {
            if (!account.equals(TestData.PLAN_FREEMIUM)) {
                discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_UNIT_MODULES);
                List<WebElement> getSeeCollectionUnitModuleResources = discoverResourcesPage.getAllSeeCollectionsUnitModulesButtons();
                for (int i = 0; i <= 1; i++) {
                    discoverResourcesPage.dragAndDrop(getSeeCollectionUnitModuleResources.get(i), collectionBuilderPage.getCollectionDroppableZone());
                }
            } else {
                discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_COLLECTIONS_TYPES);
                discoverResourcesPage.scrollToTop();
                discoverResourcesPage.dragAndDrop(discoverResourcesPage.findFirstCollectionWithLess10Items(), collectionBuilderPage.getCollectionDroppableZone());
            }
        }
        curriculumManagerPage.loadPage();
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnEditButton();
        curriculumManagerPageTest.testEditFolderModalDetailsArea();
        if (uploadedResource) {
            editCollectionModal.clickOnAddItemsDropdown();
            editCollectionModal.clickUploadAFileButton();
            curriculumManagerPageTest.testUpload(true, account, false);
            editCollectionModal.waitUntilPublishFolderButtonIsEnabled();
            editCollectionModal.clickOnPublishFolder();
            if (folder) {
                Assert.assertEquals(confirmShareFolderModal.getModalText(), TestData.PUBLISH_FOLDER_WITH_FOLDER_MODAL_TEXT);
                confirmShareFolderModal.clickOnContinueButton();
                if (!account.equals(TestData.VALID_EMAIL_CSL_HENRY)) {
                    if (includedFile) {
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
                if (!account.equals(TestData.VALID_EMAIL_CSL_HENRY)) {
                    if (includedFile) {
                        confirmPublishUploadFileModal.clickOnIncludeFileOption();
                    } else {
                        confirmPublishUploadFileModal.clickOnDoNotIncludeFileOption();
                    }
                    confirmPublishUploadFileModal.checkAgreementOption();
                    confirmPublishUploadFileModal.clickOnPublishCollectionButton();
                } else {
                    testPrivateDocumentsModal();
                }
            }

        } else {
            editCollectionModal.waitUntilPublishFolderButtonIsEnabled();
            editCollectionModal.clickOnPublishFolder();
            if (folder) {
                Assert.assertEquals(confirmShareFolderModal.getModalText(), TestData.PUBLISH_FOLDER_WITH_FOLDER_MODAL_TEXT);
                confirmShareFolderModal.clickOnContinueButton();
            }
        }
        curriculumManagerPageTest.testPublishFolderModal(account);
        if (account.equals(TestData.VALID_EMAIL_CSL_HENRY)) {
            editCollectionModal.isEnabledPublishFolderButtonDisplayed();
        } else {
            if (uploadedResource && !includedFile) {
                editCollectionModal.isEnabledPublishFolderButtonDisplayed();
            } else {
                editCollectionModal.isDisabledPublishFolderButtonDisplayed();
                editCollectionModal.hoverOverDisabledPublishFolderButton();
                Assert.assertEquals(editCollectionModal.getDisabledPublishFolderPopoverText(), TestData.DISABLED_REPUBLISH_BUTTON_POPOVER_TEXT);
            }
        }
        editCollectionModal.clickOnCloseButton();
        curriculumManagerPage.waitUntilPublishedStatusIsDisplayed();
        Assert.assertEquals(curriculumManagerPage.getFolderStatus(), TestData.PRIVATE_AND_PUBLISHED_STATUS);
    }

    public void testCollectionNotPublishedModal(String account) {
        discoverResourcesPage.loadSearchPageInListView();
        curriculumManagerPageTest.initTest(webDriver);
        curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder();

        curriculumManagerPage.loadPage();
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnActionsDropdown();
        curriculumManagerPage.clickOnEditButton();
        curriculumManagerPageTest.testEditFolderModalDetailsArea();

        editCollectionModal.clickOnAddItemsDropdown();
        editCollectionModal.clickOnCreateAPageOption();
        editCollectionModal.typePageTitle(TestData.PAGE_TITLE);
        editCollectionModal.typePageContent(TestData.HEALTH_CATEGORY_MODAL_DEFAULT_TEXT);
        editCollectionModal.clickSaveButton();

        editCollectionModal.clickOnAddItemsDropdown();
        editCollectionModal.clickUploadAFileButton();
        curriculumManagerPageTest.testUpload(true, account, false);

        editCollectionModal.waitUntilPublishFolderButtonIsEnabled();
        editCollectionModal.clickOnPublishFolder();

        if (!account.equals(TestData.VALID_EMAIL_CSL_HENRY)) {
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
