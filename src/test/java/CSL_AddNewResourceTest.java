import com.lessonplanet.pages.AddAResourcePage;
import com.lessonplanet.pages.CSL_ContentManagerPage;
import com.lessonplanet.pages.LoginPage;
import com.lessonplanet.pages.RemoveResourceModal;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.io.File;

public class CSL_AddNewResourceTest extends BaseTest {

    private LoginPage loginPage;
    private CSL_ContentManagerPage csl_contentManagerPage;
    private RSL_ContentManagerTest rsl_contentManagerTest;
    private AddAResourcePage addAResourcePage;
    private RemoveResourceModal removeResourceModal;

    @BeforeMethod
    private void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        addAResourcePage = new AddAResourcePage(webDriver);
        removeResourceModal = new RemoveResourceModal(webDriver);
        csl_contentManagerPage = new CSL_ContentManagerPage(webDriver);
        rsl_contentManagerTest = new RSL_ContentManagerTest();
    }

    @Test(description = "Custom SL - Content Manager - lessonp-1692:Add/Edit/Remove Site Specific Resource")
    public void testLessonp_1673() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        rsl_contentManagerTest.initTest(webDriver);
        rsl_contentManagerTest.reachContentManagerPage();
        csl_contentManagerPage.clickOnAddAResourceButton();
        Assert.assertTrue(csl_contentManagerPage.getUrl().contains(TestData.ADD_A_RESOURCE_PATH));

        Assert.assertEquals(addAResourcePage.getAddResourceStep(), TestData.ADD_A_RESOURCE_STEP_TITLE);
        Assert.assertTrue(addAResourcePage.isResourceUrlTextFieldDisplayed());
        Assert.assertTrue(addAResourcePage.isTitleTextFieldDisplayed());
        Assert.assertTrue(addAResourcePage.isResourceTypeDropdownDisplayed());
        Assert.assertTrue(addAResourcePage.isSubjectDropdownDisplayed());
        Assert.assertTrue(addAResourcePage.isGradeDropdownDisplayed());
        Assert.assertTrue(addAResourcePage.isRatingDropdownDisplayed());
        Assert.assertTrue(addAResourcePage.isConceptDropdownDisplayed());
        Assert.assertTrue(addAResourcePage.isAdditionalTagsDropdownDisplayed());
        Assert.assertTrue(addAResourcePage.isDescriptionTextFieldDisplayed());
        Assert.assertTrue(addAResourcePage.isCancelButtonDisplayed());
        Assert.assertTrue(addAResourcePage.isDisabledFinishButtonDisplayed());
        Assert.assertTrue(addAResourcePage.isContinueButtonDisplayed());

        Assert.assertEquals(addAResourcePage.getResourceUrlTextFieldPlaceholderText(), TestData.RESOURCE_URL_PLACEHOLDER_TEXT);
        Assert.assertEquals(addAResourcePage.getTitleTextFieldPlaceholderText(), TestData.TITLE_PLACEHOLDER_TEXT);

        Assert.assertEquals(addAResourcePage.getResourceTypeDropdownPlaceholderText(), TestData.RESOURCE_TYPE_PLACEHOLDER_TEXT);
        Assert.assertEquals(addAResourcePage.getSubjectDropdownPlaceholderText(), TestData.SUBJECT_PLACEHOLDER_TEXT);
        Assert.assertEquals(addAResourcePage.getGradeDropdownPlaceholderText(), TestData.GRADE_PLACEHOLDER_TEXT);
        Assert.assertEquals(addAResourcePage.getRatingDropdownPlaceholderText(), TestData.RATING_PLACEHOLDER_TEXT);
        Assert.assertEquals(addAResourcePage.getConceptDropdownPlaceholderText(), TestData.CONCEPT_PLACEHOLDER_TEXT);
        Assert.assertEquals(addAResourcePage.getDescriptionTextFieldPlaceholderText(), TestData.DESCRIPTION_PLACEHOLDER_TEXT);
        Assert.assertEquals(addAResourcePage.getAdditionalTagDropdownPlaceholderText(), TestData.ADDITIONAL_TAG_PLACEHOLDER_TEXT);

        addAResourcePage.hoverOverRatingIcon();
        Assert.assertEquals(addAResourcePage.getRatingIconPopoverText(), TestData.RATING_I_ICON_POPOVER_TEXT);
        addAResourcePage.hoverOverConceptsIcon();
        Assert.assertEquals(addAResourcePage.getConceptsIconPopoverText(), TestData.CONCEPT_I_ICON_POPOVER_TEXT);
        addAResourcePage.hoverOverAdditionalTagsIcon();
        Assert.assertEquals(addAResourcePage.getAdditionalTagsIconPopoverText(), TestData.ADDITIONAL_TAG_I_ICON_POPOVER_TEXT);
        addAResourcePage.hoverOverDescriptionIcon();
        Assert.assertEquals(addAResourcePage.getDescriptionIconPopoverText(), TestData.DESCRIPTION_I_ICON_POPOVER_TEXT);
        addAResourcePage.clickOnContinueButton();
        Assert.assertTrue(addAResourcePage.isResourceUrlErrorTextDisplayed());
        Assert.assertTrue(addAResourcePage.isTitleErrorTextDisplayed());
        Assert.assertTrue(addAResourcePage.isResourceTypeErrorTextDisplayed());
        Assert.assertTrue(addAResourcePage.isSubjectErrorTextDisplayed());
        Assert.assertTrue(addAResourcePage.isGradeErrorTextDisplayed());
        Assert.assertTrue(addAResourcePage.isConceptErrorTextDisplayed());
        Assert.assertTrue(addAResourcePage.isAdditionalTagErrorTextDisplayed());
        Assert.assertTrue(addAResourcePage.isDescriptionErrorTextDisplayed());
        addAResourcePage.hoverOverFinishButton();
        Assert.assertEquals(addAResourcePage.getDisabledFinishButtonPopoverText(), TestData.DISABLED_FINISH_BUTTON_POPOVER_TEXT);
        String resourceTitle = TestData.ADD_A_RESOURCE_TITLE;
        addAResourcePage.pasteResourceUrl(TestData.RESOURCE_URL);
        addAResourcePage.typeTitle(resourceTitle);
        addAResourcePage.selectResourceType(TestData.ADD_A_RESOURCE_RESOURCE_TYPE);
        addAResourcePage.selectSubject(TestData.FACET_CATEGORY_SUBJECTS_TYPE_SOCIAL_STUDIES_AND_HISTORY);
        addAResourcePage.selectGrade(TestData.EDIT_COLLECTION_GRADE_HIGHER_ED);
        addAResourcePage.selectRating(TestData.RATING_VALUE);
        addAResourcePage.selectConcept(TestData.CONCEPT);
        addAResourcePage.typeDescription(TestData.NEW_COLLECTION_DESCRIPTION);
        Assert.assertFalse(addAResourcePage.isAdditionalTagErrorTextDisplayed());
        Assert.assertTrue(addAResourcePage.isEnabledFinishButtonDisplayed());

        addAResourcePage.clickOnContinueButton();
        Assert.assertEquals(addAResourcePage.getAddResourceStep(), TestData.ADD_A_THUMBNAIL_STEP_TITLE);
        Assert.assertTrue(addAResourcePage.isCancelButtonDisplayed());
        Assert.assertTrue(addAResourcePage.isEnabledFinishButtonDisplayed());
        Assert.assertTrue(addAResourcePage.isContinueButtonDisplayed());
        Assert.assertTrue(addAResourcePage.isPreviousButtonDisplayed());
        addAResourcePage.pasteImageUrl(TestData.THUMBNAIL_IMAGE_URL);
        addAResourcePage.waitUntilThumbnailIsDisplayed();
        Assert.assertEquals(addAResourcePage.getThumbnailAttribute(), TestData.THUMBNAIL_IMAGE_URL);
        File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "images" + File.separator + TestData.UPLOADED_FILE_TITLE_TEXT);
        addAResourcePage.uploadThumbnailImage(file.getPath());
        addAResourcePage.waitUntilUploadedFileIsDisplayed(TestData.UPLOADED_FILE_TITLE_TEXT);
        Assert.assertEquals(addAResourcePage.getUploadedFileText(), TestData.UPLOADED_FILE_TITLE_TEXT);
        Assert.assertFalse(addAResourcePage.getThumbnailAttribute().contains(TestData.THUMBNAIL_IMAGE_URL));
        Assert.assertEquals(addAResourcePage.getPasteImageUrlFieldText(), "");

        addAResourcePage.clickOnContinueButton();
        Assert.assertEquals(addAResourcePage.getAddResourceStep(), TestData.ADD_STANDARDS_INFO_STEP_TITLE);
        Assert.assertTrue(addAResourcePage.isNGSStandardDropdownDisplayed());
        Assert.assertTrue(addAResourcePage.isCCSSStandardDropdownDisplayed());
        Assert.assertTrue(addAResourcePage.isStateStandardDropdownDisplayed());
        Assert.assertEquals(addAResourcePage.getNGSSStandardDropdownPlaceholderText(), TestData.NGSS_STANDARDS_PLACEHOLDER_TEXT);
        Assert.assertEquals(addAResourcePage.getCCSSStandardDropdownPlaceholderText(), TestData.CCSS_STANDARDS_PLACEHOLDER_TEXT);
        Assert.assertEquals(addAResourcePage.getStateStandardDropdownPlaceholderText(), TestData.STATE_STANDARDS_PLACEHOLDER_TEXT);
        addAResourcePage.selectCCSSStandard(TestData.CCSS_STANDARDS);
        addAResourcePage.selectNGSSStandard(TestData.NGSS_STANDARDS);
        addAResourcePage.selectGeorgiaStandard(TestData.STATE_STANDARDS);

        addAResourcePage.clickOnContinueButton();
        Assert.assertEquals(addAResourcePage.getAddResourceStep(), TestData.ADD_ADDITIONAL_INFO_TITLE);
        Assert.assertTrue(addAResourcePage.isCancelButtonDisplayed());
        Assert.assertTrue(addAResourcePage.isEnabledFinishButtonDisplayed());
        Assert.assertFalse(addAResourcePage.isContinueButtonDisplayed());
        Assert.assertTrue(addAResourcePage.isPreviousButtonDisplayed());

        Assert.assertTrue(addAResourcePage.isAuthorTextFieldDisplayed());
        Assert.assertTrue(addAResourcePage.isPublisherTextFieldDisplayed());
        Assert.assertTrue(addAResourcePage.isUsagePermissionsDropdownDisplayed());
        Assert.assertTrue(addAResourcePage.isCustomLicenseLinkTextFieldDisplayed());
        Assert.assertTrue(addAResourcePage.iAudienceDropdownDisplayed());
        Assert.assertTrue(addAResourcePage.isInstructionalStrategyDropdownDisplayed());
        Assert.assertTrue(addAResourcePage.isLanguageDropdownDisplayed());
        Assert.assertTrue(addAResourcePage.isYearDropdownDisplayed());
        Assert.assertTrue(addAResourcePage.isDurationDropdownDisplayed());
        Assert.assertTrue(addAResourcePage.isLexileDropdownDisplayed());
        Assert.assertTrue(addAResourcePage.isAccessibilityDropdownDisplayed());

        Assert.assertEquals(addAResourcePage.getAuthorTextFieldPlaceholderText(), TestData.AUTHOR_PLACEHOLDER_TEXT);
        Assert.assertEquals(addAResourcePage.getPublisherTextFieldPlaceholderText(), TestData.PUBLISHER_PLACEHOLDER_TEXT);
        Assert.assertEquals(addAResourcePage.getUsagePermissionsDropdownPlaceholderText(), TestData.USAGE_PERMISSIONS_PLACEHOLDER_TEXT);
        Assert.assertEquals(addAResourcePage.getAudienceDropdownPlaceholderText(), TestData.AUDIENCE_PLACEHOLDER_TEXT);
        Assert.assertEquals(addAResourcePage.getInstructionalStrategyPlaceholderText(), TestData.INSTRUCTIONAL_STRATEGY_PLACEHOLDER_TEXT);
        Assert.assertEquals(addAResourcePage.getLanguageDropdownPlaceholderText(), TestData.LANGUAGE_PLACEHOLDER_TEXT);
        Assert.assertEquals(addAResourcePage.getYearDropdownPlaceholderText(), TestData.YEAR_PLACEHOLDER_TEXT);
        Assert.assertEquals(addAResourcePage.getDurationDropdownPlaceholderText(), TestData.DURATION_PLACEHOLDER_TEXT);

        addAResourcePage.hoverOverUsagePermissionsIcon();
        Assert.assertEquals(addAResourcePage.getUsagePermissionsPopoverText(), TestData.USAGE_PERMISSIONS_I_ICON_POPOVER_TEXT);
        addAResourcePage.hoverOverCustomLicenceLinkIcon();
        Assert.assertEquals(addAResourcePage.getCustomLicenceLinkIconPopoverText(), TestData.CUSTOM_LICENCE_LINK_I_ICON_POPOVER_TEXT);
        addAResourcePage.hoverOverAudienceIcon();
        Assert.assertEquals(addAResourcePage.getAudienceIconPopoverText(), TestData.AUDIENCE_I_ICON_POPOVER_TEXT);
        addAResourcePage.hoverOverInstructionalStrategyIcon();
        Assert.assertEquals(addAResourcePage.getInstructionalStrategyIconPopoverText(), TestData.INSTRUCTIONAL_STRATEGY_I_ICON_POPOVER_TEXT);
        addAResourcePage.hoverOverLanguageIcon();
        Assert.assertEquals(addAResourcePage.getLanguagePopoverText(), TestData.LANGUAGE_I_ICON_POPOVER_TEXT);
        addAResourcePage.hoverOverProsIcon();
        Assert.assertEquals(addAResourcePage.getProsIconPopoverText(), TestData.PROS_I_ICON_POPOVER_TEXT);
        addAResourcePage.hoverOverConsIcon();
        Assert.assertEquals(addAResourcePage.getConsIconPopoverText(), TestData.CONS_I_ICON_POPOVER_TEXT);
        addAResourcePage.hoverOverInstructionalIdeasIcon();
        Assert.assertEquals(addAResourcePage.getInstructionalIdeasIconPopoverText(), TestData.INSTRUCTIONAL_IDEAS_I_ICON_POPOVER_TEXT);
        addAResourcePage.hoverOverClassroomConsiderationsIcon();
        Assert.assertEquals(addAResourcePage.getClassroomConsiderationsIconPopoverText(), TestData.CLASSROOM_CONSIDERATIONS_I_ICON_POPOVER_TEXT);

        addAResourcePage.typeAuthor(TestData.RSL_SBCEO_TEACHER_LAST_NAME);
        addAResourcePage.typePublisher(TestData.CSL_HENRY_TEACHER_FIRST_NAME);
        addAResourcePage.selectUsagePermissions(TestData.USAGE_PERMISSIONS);
        addAResourcePage.selectAudience(TestData.AUDIENCE);
        addAResourcePage.selectInstructionalStrategy(TestData.INSTRUCTIONAL_STRATEGY);
        addAResourcePage.selectLanguage(TestData.LANGUAGE);
        addAResourcePage.selectYear(TestData.YEAR);
        addAResourcePage.selectLexile(TestData.LEXILE);
        addAResourcePage.selectAccessibility(TestData.ACCESSIBILITY);
        addAResourcePage.selectDuration(TestData.DURATION);
        addAResourcePage.typePros(TestData.REGULAR_RESOURCE_TYPE);
        addAResourcePage.typeCons(TestData.HEALTH_PAGE_TITLE);
        addAResourcePage.typeInstructionalIdeas(TestData.NEW_COLLECTION_NAME);
        addAResourcePage.typeClassroomConsiderations(TestData.NEW_FOLDER_NAME);

        addAResourcePage.clickOnAddNewMaterialButton();
        addAResourcePage.selectIncludedMaterialResourceType(TestData.LESSON_RESOURCE_TYPE_CARD);
        addAResourcePage.typeIncludedMaterialResourceTitle(TestData.PIXABAY_IMAGE_TITLE);
        addAResourcePage.pasteIncludedMaterialResourceUrl(TestData.COLLECTION_BUILDER_LINK);

        addAResourcePage.clickOnFinishButton();
        Assert.assertEquals(csl_contentManagerPage.getNotificationText(), TestData.ADD_RESOURCE_NOTIFICATION);
        int noOfRefreshes = TestData.SHORT_TIMEOUT;
        do {
            csl_contentManagerPage.refreshPageAndDismissBrowserAlert();
            noOfRefreshes--;
        } while (!(csl_contentManagerPage.getResourceTitle(0).equals(resourceTitle) || noOfRefreshes > 0));
        Assert.assertEquals(csl_contentManagerPage.getResourceTitle(0), resourceTitle);
        Assert.assertTrue(csl_contentManagerPage.getResourceType(0).contains(TestData.ADD_A_RESOURCE_RESOURCE_TYPE));
        Assert.assertTrue(csl_contentManagerPage.getResourceGrades(0).contains(TestData.EDIT_COLLECTION_GRADE_HIGHER_ED));

        csl_contentManagerPage.clickOnEditResourceButton(0);
        Assert.assertEquals(addAResourcePage.getEditResourcePageTitle(), TestData.EDIT_RESOURCE_PAGE_TITLE);
        addAResourcePage.typeTitle(TestData.EDIT_TITLE);
        addAResourcePage.clickOnFinishButton();
        Assert.assertEquals(csl_contentManagerPage.getNotificationText(), TestData.UPDATE_RESOURCE_NOTIFICATION);
        noOfRefreshes = TestData.SHORT_TIMEOUT;
        do {
            csl_contentManagerPage.refreshPageAndDismissBrowserAlert();
            noOfRefreshes--;
        } while (!(csl_contentManagerPage.getResourceTitle(0).equals(resourceTitle + TestData.EDIT_TITLE) || noOfRefreshes > 0));
        Assert.assertEquals(csl_contentManagerPage.getResourceTitle(0), resourceTitle + TestData.EDIT_TITLE);

        csl_contentManagerPage.clickOnRemoveButton(0);
        removeResourceModal.clickOnRemoveButton();
        Assert.assertEquals(csl_contentManagerPage.getNotificationText(), TestData.REMOVE_RESOURCE_NOTIFICATION);
        csl_contentManagerPage.waitForNotificationToDisappear();

        csl_contentManagerPage.refreshPageAndDismissBrowserAlert();
        Assert.assertTrue(!csl_contentManagerPage.getResourceTitle(0).equals(resourceTitle + TestData.EDIT_TITLE));
    }
}
