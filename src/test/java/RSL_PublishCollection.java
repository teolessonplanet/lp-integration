import com.lessonplanet.pages.*;
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
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5236: With LP Resources")
    public void testLessonp_5236() {
        testAddResourcesToCollection(false, false);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5237: With LP Resources & Uploaded Resources")
    public void testLessonp_5237() {
        testAddResourcesToCollection(false, true);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5612: With LP Resources & Folders")
    public void testLessonp_5612() {
        testAddResourcesToCollection(true, false);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5613: With LP Resources & Folders & Uploaded Resources")
    public void testLessonp_5613() {
        testAddResourcesToCollection(true, true);
    }

    private void testAddResourcesToCollection(boolean folder, boolean uploadedResource) {
        discoverResourcesPage.loadSearchPageInListView();
        curriculumManagerPageTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder();
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
            curriculumManagerPageTest.testUpload(true, TestData.VALID_EMAIL_RSL_SBCEO);
            editCollectionModal.waitUntilPublishFolderButtonIsEnabled();
            editCollectionModal.clickOnPublishFolder();
            if (folder) {
                Assert.assertEquals(confirmShareFolderModal.getModalText(), TestData.PUBLISH_COLLECTION_WITH_FOLDER_MODAL_TEXT);
                confirmShareFolderModal.clickOnContinueButton();
                confirmPublishUploadFileModal.clickAgreementOption();
            } else {
                confirmPublishUploadFileModal.clickAgreementOption();
            }
            confirmPublishUploadFileModal.clickOnPublishCollectionButton();
        } else {
            editCollectionModal.waitUntilPublishFolderButtonIsEnabled();
            editCollectionModal.clickOnPublishFolder();
            if (folder) {
                Assert.assertEquals(confirmShareFolderModal.getModalText(), TestData.PUBLISH_COLLECTION_WITH_FOLDER_MODAL_TEXT);
                confirmShareFolderModal.clickOnContinueButton();
            }
        }
        curriculumManagerPageTest.testPublishCollectionModal(TestData.VALID_EMAIL_RSL_SBCEO);
        editCollectionModal.hoverOverDisabledPublishFolderButton();
        Assert.assertTrue(editCollectionModal.getDisabledPublishFolderPopoverText().contains(TestData.DISABLED_REPUBLISH_BUTTON_POPOVER_TEXT));
        editCollectionModal.clickOnCloseButton();
        Assert.assertTrue(curriculumManagerPage.getFolderStatus().contains(TestData.PUBLISHED_STATUS));
    }
}
