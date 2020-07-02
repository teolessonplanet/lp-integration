import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.util.List;

public class RSL_PublishCollection extends BaseTest {
    private LoginPage loginPage;
    private CurriculumManagerPageTest curriculumManagerPageTest;
    private CurriculumManagerPage curriculumManagerPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private EditCollectionModal editCollectionModal;
    private CollectionBuilderPage collectionBuilderPage;
    private ConfirmPublishUploadFileModal confirmPublishUploadFileModal;
    private ConfirmShareFolderModal confirmShareFolderModal;
    private CollectionNotPublishedModal collectionNotPublishedModal;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        curriculumManagerPageTest = new CurriculumManagerPageTest();
        editCollectionModal = new EditCollectionModal(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        confirmPublishUploadFileModal = new ConfirmPublishUploadFileModal(webDriver);
        confirmShareFolderModal = new ConfirmShareFolderModal(webDriver);
        collectionNotPublishedModal = new CollectionNotPublishedModal(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5236: With LP Resources")
    public void testLessonp_5236() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        testAddResourcesToPublishCollection(false, false, TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5237: With LP Resources & Uploaded Resources - include file")
    public void testLessonp_5237() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        testAddResourcesToPublishCollection(false, true, TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5796: With LP Resources & Uploaded Resources - do not include file")
    public void testLessonp_5796() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        testAddResourcesToPublishCollection(false, true, TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5612: With LP Resources & Folders")
    public void testLessonp_5612() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        testAddResourcesToPublishCollection(true, false, TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5613: With LP Resources & Folders & Uploaded Resources - include file")
    public void testLessonp_5613() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        testAddResourcesToPublishCollection(true, true, TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5797: With LP Resources & Folders & Uploaded Resources - do not include file")
    public void testLessonp_5797() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        testAddResourcesToPublishCollection(true, true, TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5798: Collection not published modal")
    public void testLessonp_5798() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        testCollectionNotPublishedModal(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    public void testAddResourcesToPublishCollection(boolean folder, boolean uploadedResource, String account, boolean includedFile) {
        discoverResourcesPage.loadSearchPageInListView();
        curriculumManagerPageTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);
        List<WebElement> getFullReviewResources = discoverResourcesPage.getAllSeeFullReviewButtons();
        for (int i = 0; i <= 1; i++) {
            discoverResourcesPage.dragAndDrop(getFullReviewResources.get(i), collectionBuilderPage.getCollectionDroppableZone());
        }
        if (folder) {
            discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_UNIT_MODULES);
            List<WebElement> getSeeCollectionUnitModuleResources = discoverResourcesPage.getAllSeeCollectionsUnitModulesButtons();
            for (int i = 0; i <= 1; i++) {
                discoverResourcesPage.dragAndDrop(getSeeCollectionUnitModuleResources.get(i), collectionBuilderPage.getCollectionDroppableZone());
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
            curriculumManagerPageTest.testUpload(true, account);
            editCollectionModal.waitUntilPublishFolderButtonIsEnabled();
            editCollectionModal.clickOnPublishFolder();
            if (folder) {
                Assert.assertEquals(confirmShareFolderModal.getModalText(), TestData.PUBLISH_FOLDER_WITH_FOLDER_MODAL_TEXT);
                confirmShareFolderModal.clickOnContinueButton();
                if (includedFile) {
                    confirmPublishUploadFileModal.clickOnIncludeFileOption();
                } else {
                    confirmPublishUploadFileModal.clickOnDoNotIncludeFileOption();
                }
                confirmPublishUploadFileModal.checkAgreementOption();
            } else {
                if (includedFile) {
                    confirmPublishUploadFileModal.clickOnIncludeFileOption();
                } else {
                    confirmPublishUploadFileModal.clickOnDoNotIncludeFileOption();
                }
                confirmPublishUploadFileModal.checkAgreementOption();
            }
            confirmPublishUploadFileModal.clickOnPublishCollectionButton();
        } else {
            editCollectionModal.waitUntilPublishFolderButtonIsEnabled();
            editCollectionModal.clickOnPublishFolder();
            if (folder) {
                Assert.assertEquals(confirmShareFolderModal.getModalText(), TestData.PUBLISH_FOLDER_WITH_FOLDER_MODAL_TEXT);
                confirmShareFolderModal.clickOnContinueButton();
            }
        }
        curriculumManagerPageTest.testPublishFolderModal(account);
        if (uploadedResource && !includedFile) {
            editCollectionModal.isEnabledPublishFolderButtonDisplayed();
        } else {
            editCollectionModal.isDisabledPublishFolderButtonDisplayed();
            editCollectionModal.hoverOverDisabledPublishFolderButton();
            Assert.assertTrue(editCollectionModal.getDisabledPublishFolderPopoverText().contains(TestData.DISABLED_REPUBLISH_BUTTON_POPOVER_TEXT));
        }
        editCollectionModal.clickOnCloseButton();
        Assert.assertTrue(curriculumManagerPage.getFolderStatus().contains(TestData.PUBLISHED_STATUS));
    }

    public void testCollectionNotPublishedModal(String account) {
        discoverResourcesPage.loadSearchPageInListView();
        curriculumManagerPageTest.reachCurriculumManagerPage(webDriver);
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
        curriculumManagerPageTest.testUpload(true, account);

        editCollectionModal.waitUntilPublishFolderButtonIsEnabled();
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
