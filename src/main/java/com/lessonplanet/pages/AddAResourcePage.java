package com.lessonplanet.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AddAResourcePage extends LpUiBasePage {

    private static final String ADD_A_RESOURCE_STEP = "[class*='progress-indicator lp-progress-indicator'] [class='step active ']";

    private static final String RESOURCE_URL_TEXT_FIELD = "[class*='add-resource-url-group'] #url";
    private static final String RESOURCE_URL_ERROR_TEXT = "[class*='add-resource-url-group has-error'] div.error";
    private static final String TITLE_TEXT_FIELD = "[class*='add-resource-title-group'] input";
    private static final String TITLE_ERROR_TEXT = "[class*='add-resource-title-group has-error'] div.error";
    private static final String RESOURCE_TYPE_DROPDOWN = "[class*='add-resource-type-list-group'] input";
    private static final String RESOURCE_TYPE_MATCHING_OPTIONS = "[class*='add-resource-type-list-group'] [class='Select-menu-outer']";
    private static final String RESOURCE_TYPE_DROPDOWN_PLACEHOLDER_TEXT = "[class*='add-resource-type-list-group'] [class='Select-placeholder']";
    private static final String RESOURCE_TYPE_DROPDOWN_ERROR_TEXT = "[class*='add-resource-type-list-group has-error'] div.error";
    private static final String SUBJECT_DROPDOWN = "[class*='add-resource-subject-list-group'] input";
    private static final String SUBJECT_MATCHING_OPTIONS = "[class*='add-resource-subject-list-group '] [class='Select-menu-outer']";
    private static final String SUBJECT_DROPDOWN_PLACEHOLDER_TEXT = "[class*='add-resource-subject-list-group'] [class='Select-placeholder']";
    private static final String SUBJECT_DROPDOWN_ERROR_TEXT = "[class*='add-resource-subject-list-group has-error'] div.error";
    private static final String GRADE_DROPDOWN = "[class*='add-resource-grade-list-group'] input";
    private static final String GRADE_MATCHING_OPTIONS = "[class*='add-resource-grade-list-group '] [class='Select-menu-outer']";
    private static final String GRADE_DROPDOWN_PLACEHOLDER_TEXT = "[class*='add-resource-grade-list-group'] [class='Select-placeholder']";
    private static final String GRADE_DROPDOWN_ERROR_TEXT = "[class*='add-resource-grade-list-group has-error'] div.error";
    private static final String RATING_DROPDOWN = "[class*='add-resource-reviewer-rating-group'] input";
    private static final String RATING_MATCHING_OPTIONS = "[class*='add-resource-reviewer-rating-group'] [class='Select-menu-outer']";
    private static final String RATING_DROPDOWN_PLACEHOLDER_TEXT = "[class*='add-resource-reviewer-rating-group'] [class='Select-placeholder']";
    private static final String RATING_I_ICON = "[class*='add-resource-reviewer-rating-group'] i";
    private static final String CONCEPT_DROPDOWN = "[class*='add-resource-concept-list-group'] input";
    private static final String CONCEPT_DROPDOWN_MATCHING_OPTIONS = "[class*='add-resource-concept-list-group'] [class='Select-menu-outer']";
    private static final String CONCEPT_DROPDOWN_PLACEHOLDER_TEXT = "[class*='add-resource-concept-list-group'] [class='Select-placeholder']";
    private static final String CONCEPT_DROPDOWN_ERROR_TEXT = "[class*='add-resource-concept-list-group has-error'] div.error";
    private static final String CONCEPT_DROPDOWN_I_ICON = "[class*='add-resource-concept-list-group'] i";
    private static final String ADDITIONAL_TAG_DROPDOWN = "[class*='add-resource-keyterm-list-group'] [class='Select-control']";
    private static final String ADDITIONAL_TAG_DROPDOWN_PLACEHOLDER_TEXT = "[class*='add-resource-keyterm-list-group'] [class='Select-placeholder']";
    private static final String ADDITIONAL_TAG_DROPDOWN_ERROR_TEXT = "[class*='add-resource-keyterm-list-group has-error'] div.error";
    private static final String ADDITIONAL_TAG_I_ICON = "[class*='add-resource-keyterm-list-group '] i";
    private static final String DESCRIPTION_FIELD = "[class*='lp-form'] div[class*='add-resource-description-group'] div[class='richtext'] [class='ql-editor ql-blank']";
    private static final String DESCRIPTION_ERROR_TEXT = "[class*='lp-form'] div[class*='add-resource-description-group has-error'] div.error";
    private static final String DESCRIPTION_I_ICON = "[class*='lp-form'] div[class*='add-resource-description-group'] i";

    private static final String THUMBNAIL_URL = "[class*='add-thumbnail-paste-url-wrap'] [class='add-thumbnail-paste-url lp-input']";
    private static final String THUMBNAIL_LOGO = "[class*='ecc container add-thumbnail-image-wrap'] img";
    private static final String UPLOADED_FILE_TEXT = "[class*='add-thumbnail-upload-file-wrap'] [class='add-thumbnail-upload-file lp-input']";

    private static final String CCSS_STANDARDS_DROPDOWN = "[class*='add-resource-cc-nodes-group'] input";
    private static final String CCSS_STANDARDS_MATCHING_OPTIONS = "[class*='add-resource-cc-nodes-group'] [class='Select-menu-outer']";
    private static final String CCSS_STANDARDS_DROPDOWN_PLACEHOLDER_TEXT = "[class*='add-resource-cc-nodes-group'] [class='Select-placeholder']";
    private static final String NGSS_STANDARDS_DROPDOWN = "[class*='add-resource-ngss-nodes-group'] input";
    private static final String NGSS_STANDARDS_DROPDOWN_PLACEHOLDER_TEXT = "[class*='add-resource-ngss-nodes-group'] [class='Select-placeholder']";
    private static final String NGSS_STANDARDS_MATCHING_OPTIONS = "[class*='add-resource-ngss-nodes-group'] [class='Select-menu-outer']";
    private static final String STATE_STANDARDS_DROPDOWN = "[class*='add-resource-state-standard-nodes-group'] input";
    private static final String STATE_STANDARDS_MATCHING_OPTIONS = "[class*='add-resource-state-standard-nodes-group'] [class='Select-menu-outer']";
    private static final String STATE_STANDARDS_DROPDOWN_PLACEHOLDER_TEXT = "[class*='add-resource-state-standard-nodes-group'] [class='Select-placeholder']";

    private static final String ENABLED_FINISH_BUTTON = "[class*='ecc container'] [class='lp-button lp-green-button float-right']";
    private static final String CONTINUE_BUTTON = "[class*='ecc container'] [class*='add-resource-action-wrap'] [class*='lp-button lp-orange-button']";
    private static final String CANCEL_BUTTON = "[class*='ecc container'] [class*='add-resource-action-wrap'] [class*='lp-button lp-white-button']";
    private static final String DISABLED_FINISH_BUTTON = "[class*='lp-button lp-green-button float-right disabled popup']";
    private static final String DISABLED_FINISH_BUTTON_POPOVER_TEXT = "[class*='ecc container'] [class='lp-button lp-green-button float-right disabled popup'] [class='popuptext show']";
    private static final String PREVIOUS_BUTTON = "[class*='ecc container'] [class='lp-button lp-gray-button float-left']";

    private static final String AUTHOR_TEXT_FIELD = "[class*='add-resource-author-group'] input";
    private static final String AUTHOR_TEXT_FIELD_PLACEHOLDER_TEXT = "[class*='add-resource-author-group'] input";
    private static final String PUBLISHER_TEXT_FIELD = "[class*='add-resource-publisher-group'] input";
    private static final String PUBLISHER_TEXT_FIELD_PLACEHOLDER_TEXT = "[class*='add-resource-publisher-group'] input";
    private static final String USAGE_PERMISSIONS_DROPDOWN = "[class*='add-resource-usage-permission-list-group'] input";
    private static final String USAGE_PERMISSIONS_DROPDOWN_PLACEHOLDER_TEXT = "[class*='add-resource-usage-permission-list-group'] [class='Select-placeholder']";
    private static final String USAGE_PERMISSIONS_MATCHING_OPTIONS = "[class*='add-resource-usage-permission-list-group'] [class='Select-menu-outer']";
    private static final String USAGE_PERMISSIONS_I_ICON = "[class*='add-resource-usage-permission-list-group'] i";
    private static final String CUSTOM_LICENSE_LINK_TEXT_FIELD = "[class*='add-resource-custom-license-link-group'] input";
    private static final String CUSTOM_LICENSE_LINK_I_ICON = "[class*='add-resource-custom-license-link-group'] i";
    private static final String AUDIENCE_DROPDOWN = "[class*='add-resource-audience-list-group'] input";
    private static final String AUDIENCE_DROPDOWN_PLACEHOLDER_TEXT = "[class*='add-resource-audience-list-group'] [class='Select-placeholder']";
    private static final String AUDIENCE_MATCHING_OPTIONS = "[class*='add-resource-audience-list-group'] [class='Select-menu-outer']";
    private static final String AUDIENCE_I_ICON = "[class*='add-resource-audience-list-group'] i";
    private static final String INSTRUCTIONAL_STRATEGY_DROPDOWN = "[class*='add-resource-instructional-design-list-group'] input";
    private static final String INSTRUCTIONAL_STRATEGY_DROPDOWN_PLACEHOLDER_TEXT = "[class*='add-resource-instructional-design-list-group'] [class='Select-placeholder']";
    private static final String INSTRUCTIONAL_STRATEGY_MATCHING_OPTIONS = "[class*='add-resource-instructional-design-list-group'] [class='Select-menu-outer']";
    private static final String INSTRUCTIONAL_STRATEGY_I_ICON = "[class*='add-resource-instructional-design-list-group'] i";
    private static final String LANGUAGE_DROPDOWN = "[class*='add-resource-language-list-group'] input";
    private static final String LANGUAGE_DROPDOWN_PLACEHOLDER_TEXT = "[class*='add-resource-language-list-group'] [class='Select-placeholder']";
    private static final String LANGUAGE_MATCHING_OPTIONS = "[class*='add-resource-language-list-group'] [class='Select-menu-outer']";
    private static final String LANGUAGE_I_ICON = "[class*='add-resource-language-list-group'] i";
    private static final String LEXILE_DROPDOWN = "[class*='add-resource-lexile-measure-list-group'] input";
    private static final String LEXILE_DROPDOWN_MATCHING_OPTION = "[class*='add-resource-lexile-measure-list-group'] [class='Select-menu-outer']";
    private static final String ACCESSIBILITY_DROPDOWN = "[class*='add-resource-accessibility-list-group'] input";
    private static final String ACCESSIBILITY_DROPDOWN_MATCHING_OPTION = "[class*='add-resource-accessibility-list-group'] [class='Select-menu-outer']";
    private static final String YEAR_DROPDOWN = "[class*='add-resource-year-group'] input";
    private static final String YEAR_DROPDOWN_PLACEHOLDER_TEXT = "[class*='add-resource-year-group'] [class='Select-placeholder']";
    private static final String YEAR_MATCHING_OPTIONS = "[class*='add-resource-year-group'] [class='Select-menu-outer']";
    private static final String DURATION_DROPDOWN = "[class*='add-resource-duration-group'] input";
    private static final String DURATION_DROPDOWN_PLACEHOLDER_TEXT = "[class*='add-resource-duration-group'] [class='Select-placeholder']";
    private static final String DURATION_MATCHING_OPTIONS = "[class*='add-resource-duration-group '] [class='Select-menu-outer']";
    private static final String PROS_TEXT_FIELD = "[class*='add-resource-pros-group'] [class='ql-editor ql-blank']";
    private static final String PROS_I_ICON = "[class*='add-resource-pros-group'] i";
    private static final String CONS_TEXT_FIELD = "[class*='add-resource-cons-group'] [class='ql-editor ql-blank']";
    private static final String CONS_I_ICON = "[class*='add-resource-cons-group'] i";
    private static final String INSTRUCTIONAL_IDEAS_TEXT_FIELD = "[class*='add-resource-instructional-ideas-group'] [class='ql-editor ql-blank']";
    private static final String INSTRUCTIONAL_IDEAS_I_ICON = "[class*='add-resource-instructional-ideas-group'] i";
    private static final String CLASSROOM_CONSIDERATIONS_TEXT_FIELD = "[class*='add-resource-classroom-considerations-group'] [class='ql-editor ql-blank']";
    private static final String CLASSROOM_CONSIDERATIONS_I_ICON = "[class*='add-resource-classroom-considerations-group'] i";
    private static final String ADD_NEW_MATERIAL_BUTTON = "[class*='lp-button lp-small-button float-right']";
    private static final String INCLUDED_MATERIAL_RESOURCE_TYPE_DROPDOWN = "[class*='ecc container included-materials-input'] input";
    private static final String INCLUDED_MATERIAL_RESOURCE_TYPE_MATCHING_OPTIONS = "[class*='ecc container included-materials-input'] [class='Select-menu-outer']";
    private static final String INCLUDED_MATERIAL_RESOURCE_TITLE_TEXT_FIELD = "[class*='ecc container included-materials-input'] [class*='add-included-material-title-group'] #title";
    private static final String INCLUDED_MATERIAL_RESOURCE_URL_TEXT_FIELD = "[class*='ecc container included-materials-input'] [class*=' add-included-material-url-group'] #url";
    private static final String UPLOADED_THUMBNAIL_IMAGE = "#uploaded_thumbnail";

    private HeaderPage headerPage;

    public AddAResourcePage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
    }

    public void clickOnContinueButton() {
        scrollToElement(CONTINUE_BUTTON);
        clickElement(CONTINUE_BUTTON);
    }

    public boolean isResourceUrlErrorTextDisplayed() {
        return isElementDisplayed(RESOURCE_URL_ERROR_TEXT);
    }

    public boolean isResourceUrlTextFieldDisplayed() {
        return isElementDisplayed(RESOURCE_URL_TEXT_FIELD);
    }

    public String getResourceUrlTextFieldPlaceholderText() {
        return getElementAttribute(RESOURCE_URL_TEXT_FIELD, "placeholder");
    }

    public boolean isTitleErrorTextDisplayed() {
        return isElementDisplayed(TITLE_ERROR_TEXT);
    }

    public boolean isTitleTextFieldDisplayed() {
        return isElementDisplayed(TITLE_TEXT_FIELD);
    }

    public String getTitleTextFieldPlaceholderText() {
        return getElementAttribute(TITLE_TEXT_FIELD, "placeholder");
    }

    public boolean isResourceTypeErrorTextDisplayed() {
        return isElementDisplayed(RESOURCE_TYPE_DROPDOWN_ERROR_TEXT);
    }

    public boolean isResourceTypeDropdownDisplayed() {
        return isElementDisplayed(RESOURCE_TYPE_DROPDOWN);
    }

    public String getResourceTypeDropdownPlaceholderText() {
        return getTextForElement(RESOURCE_TYPE_DROPDOWN_PLACEHOLDER_TEXT);
    }

    public boolean isSubjectErrorTextDisplayed() {
        return isElementDisplayed(SUBJECT_DROPDOWN_ERROR_TEXT);
    }

    public boolean isSubjectDropdownDisplayed() {
        return isElementDisplayed(SUBJECT_DROPDOWN);
    }

    public String getSubjectDropdownPlaceholderText() {
        return getTextForElement(SUBJECT_DROPDOWN_PLACEHOLDER_TEXT);
    }

    public boolean isGradeErrorTextDisplayed() {
        return isElementDisplayed(GRADE_DROPDOWN_ERROR_TEXT);
    }

    public boolean isGradeDropdownDisplayed() {
        return isElementDisplayed(GRADE_DROPDOWN);
    }

    public String getGradeDropdownPlaceholderText() {
        return getTextForElement(GRADE_DROPDOWN_PLACEHOLDER_TEXT);
    }

    public boolean isRatingDropdownDisplayed() {
        return isElementDisplayed(RATING_DROPDOWN);
    }

    public String getRatingDropdownPlaceholderText() {
        return getTextForElement(RATING_DROPDOWN_PLACEHOLDER_TEXT);
    }

    public boolean isConceptErrorTextDisplayed() {
        return isElementDisplayed(CONCEPT_DROPDOWN_ERROR_TEXT);
    }

    public boolean isConceptDropdownDisplayed() {
        return isElementDisplayed(CONCEPT_DROPDOWN);
    }

    public String getConceptDropdownPlaceholderText() {
        return getTextForElement(CONCEPT_DROPDOWN_PLACEHOLDER_TEXT);
    }

    public boolean isAdditionalTagErrorTextDisplayed() {
        return isElementDisplayed(ADDITIONAL_TAG_DROPDOWN_ERROR_TEXT);
    }

    public boolean isAdditionalTagsDropdownDisplayed() {
        return isElementDisplayed(ADDITIONAL_TAG_DROPDOWN);
    }

    public String getAdditionalTagDropdownPlaceholderText() {
        return getTextForElement(ADDITIONAL_TAG_DROPDOWN_PLACEHOLDER_TEXT);
    }

    public boolean isDescriptionErrorTextDisplayed() {
        return isElementDisplayed(DESCRIPTION_ERROR_TEXT);
    }

    public boolean isDescriptionTextFieldDisplayed() {
        return isElementDisplayed(DESCRIPTION_FIELD);
    }

    public String getDescriptionTextFieldPlaceholderText() {
        return getElementAttribute(DESCRIPTION_FIELD, "data-placeholder");
    }

    public void typeTitle(String title) {
        sendKeys(TITLE_TEXT_FIELD, title);
    }

    public void typeDescription(String description) {
        sendKeys(DESCRIPTION_FIELD, description);
    }

    public void selectGrade(String grade) {
        sendKeys(GRADE_DROPDOWN, grade);
        clickElement(GRADE_MATCHING_OPTIONS, 0);
    }

    public void selectSubject(String subject) {
        sendKeys(SUBJECT_DROPDOWN, subject);
        clickElement(SUBJECT_MATCHING_OPTIONS, 0);
    }

    public void selectResourceType(String resourceType) {
        sendKeys(RESOURCE_TYPE_DROPDOWN, resourceType);
        clickElement(RESOURCE_TYPE_MATCHING_OPTIONS, 0);
    }

    public void selectConcept(String concept) {
        sendKeys(CONCEPT_DROPDOWN, concept);
        clickElement(CONCEPT_DROPDOWN_MATCHING_OPTIONS, 0);
    }

    public void selectCCSSStandard(String ccssStandard) {
        sendKeys(CCSS_STANDARDS_DROPDOWN, ccssStandard);
        clickElement(CCSS_STANDARDS_MATCHING_OPTIONS, 0);
    }

    public void selectGeorgiaStandard(String georgiaStandard) {
        sendKeys(STATE_STANDARDS_DROPDOWN, georgiaStandard);
        clickElement(STATE_STANDARDS_MATCHING_OPTIONS, 0);
    }

    public void selectNGSSStandard(String ngssStandard) {
        sendKeys(NGSS_STANDARDS_DROPDOWN, ngssStandard);
        clickElement(NGSS_STANDARDS_MATCHING_OPTIONS, 0);
    }

    public boolean isCCSSStandardDropdownDisplayed() {
        return isElementDisplayed(CCSS_STANDARDS_DROPDOWN);
    }

    public boolean isNGSStandardDropdownDisplayed() {
        return isElementDisplayed(NGSS_STANDARDS_DROPDOWN);
    }

    public boolean isStateStandardDropdownDisplayed() {
        return isElementDisplayed(STATE_STANDARDS_DROPDOWN);
    }

    public void pasteResourceUrl(String url) {
        pasteTextUsingSearchField(RESOURCE_URL_TEXT_FIELD, url);
    }

    public void waitUntilUploadedFileIsDisplayed(String text) {
        waitUntilTextIsDisplayed(UPLOADED_FILE_TEXT, text);
    }

    public String getAddResourceStep() {
        return getTextForElement(ADD_A_RESOURCE_STEP);
    }

    public void pasteImageUrl(String url) {
        pasteTextUsingSearchField(THUMBNAIL_URL, url);
    }

    public String getPasteImageUrlFieldText() {
        return getTextForElement(THUMBNAIL_URL);
    }

    public void uploadThumbnailImage(String path) {
        sendKeys(UPLOADED_THUMBNAIL_IMAGE, path);
    }

    public String getThumbnailAttribute() {
        return getElementAttribute(THUMBNAIL_LOGO, "src", 0);
    }

    public void clickOnFinishButton() {
        clickElement(ENABLED_FINISH_BUTTON);
    }

    public void hoverOverFinishButton() {
        hoverOverElement(DISABLED_FINISH_BUTTON);
    }

    public String getDisabledFinishButtonPopoverText() {
        return getTextForElement(DISABLED_FINISH_BUTTON_POPOVER_TEXT);
    }

    public void waitUntilThumbnailIsDisplayed() {
        waitForElementToBeVisible(findElement(THUMBNAIL_LOGO).getAttribute("src"));
    }

    public boolean isAuthorTextFieldDisplayed() {
        return isElementDisplayed(AUTHOR_TEXT_FIELD);
    }

    public boolean isPublisherTextFieldDisplayed() {
        return isElementDisplayed(PUBLISHER_TEXT_FIELD);
    }

    public boolean isUsagePermissionsDropdownDisplayed() {
        return isElementDisplayed(USAGE_PERMISSIONS_DROPDOWN);
    }

    public boolean isCustomLicenseLinkTextFieldDisplayed() {
        return isElementDisplayed(CUSTOM_LICENSE_LINK_TEXT_FIELD);
    }

    public boolean iAudienceDropdownDisplayed() {
        return isElementDisplayed(AUDIENCE_DROPDOWN);
    }

    public boolean isInstructionalStrategyDropdownDisplayed() {
        return isElementDisplayed(INSTRUCTIONAL_STRATEGY_DROPDOWN);
    }

    public boolean isLanguageDropdownDisplayed() {
        return isElementDisplayed(LANGUAGE_DROPDOWN);
    }

    public boolean isYearDropdownDisplayed() {
        return isElementDisplayed(YEAR_DROPDOWN);
    }

    public boolean isDurationDropdownDisplayed() {
        return isElementDisplayed(DURATION_DROPDOWN);
    }

    public void typeAuthor(String authorName) {
        sendKeys(AUTHOR_TEXT_FIELD, authorName);
    }

    public void typePublisher(String publisherName) {
        sendKeys(PUBLISHER_TEXT_FIELD, publisherName);
    }

    public void selectUsagePermissions(String usagePermission) {
        sendKeys(USAGE_PERMISSIONS_DROPDOWN, usagePermission);
        clickElement(USAGE_PERMISSIONS_MATCHING_OPTIONS, 0);
    }

    public void selectAudience(String audience) {
        sendKeys(AUDIENCE_DROPDOWN, audience);
        clickElement(AUDIENCE_MATCHING_OPTIONS, 0);
    }

    public void selectInstructionalStrategy(String instructionalStrategy) {
        sendKeys(INSTRUCTIONAL_STRATEGY_DROPDOWN, instructionalStrategy);
        clickElement(INSTRUCTIONAL_STRATEGY_MATCHING_OPTIONS, 0);
    }

    public void selectLanguage(String language) {
        sendKeys(LANGUAGE_DROPDOWN, language);
        clickElement(LANGUAGE_MATCHING_OPTIONS, 0);
    }

    public void selectYear(String year) {
        sendKeys(YEAR_DROPDOWN, year);
        clickElement(YEAR_MATCHING_OPTIONS, 0);
    }

    public void selectDuration(String duration) {
        sendKeys(DURATION_DROPDOWN, duration);
        clickElement(DURATION_MATCHING_OPTIONS, 0);
    }

    public void typePros(String pros) {
        scrollToElement(PROS_TEXT_FIELD);
        sendKeys(PROS_TEXT_FIELD, pros);
    }

    public void typeCons(String cons) {
        scrollToElement(CONS_TEXT_FIELD);
        sendKeys(CONS_TEXT_FIELD, cons);
    }

    public void typeInstructionalIdeas(String instructionalIdeas) {
        scrollToElement(INSTRUCTIONAL_IDEAS_TEXT_FIELD);
        sendKeys(INSTRUCTIONAL_IDEAS_TEXT_FIELD, instructionalIdeas);
    }

    public void typeClassroomConsiderations(String clasroomConsiderations) {
        scrollToElement(CLASSROOM_CONSIDERATIONS_TEXT_FIELD);
        sendKeys(CLASSROOM_CONSIDERATIONS_TEXT_FIELD, clasroomConsiderations);
    }

    public void clickOnAddNewMaterialButton() {
        scrollToElement(ADD_NEW_MATERIAL_BUTTON);
        clickElement(ADD_NEW_MATERIAL_BUTTON);
    }

    public void selectIncludedMaterialResourceType(String resourceType) {
        sendKeys(INCLUDED_MATERIAL_RESOURCE_TYPE_DROPDOWN, resourceType);
        clickElement(INCLUDED_MATERIAL_RESOURCE_TYPE_MATCHING_OPTIONS, 0);
    }

    public void typeIncludedMaterialResourceTitle(String includedMaterialTitle) {
        sendKeys(INCLUDED_MATERIAL_RESOURCE_TITLE_TEXT_FIELD, includedMaterialTitle);
    }

    public void pasteIncludedMaterialResourceUrl(String url) {
        pasteTextUsingSearchField(INCLUDED_MATERIAL_RESOURCE_URL_TEXT_FIELD, url);
    }

    public boolean isDisabledFinishButtonDisplayed() {
        return isElementDisplayed(DISABLED_FINISH_BUTTON);
    }

    public boolean isContinueButtonDisplayed() {
        return isElementDisplayed(CONTINUE_BUTTON);
    }

    public boolean isCancelButtonDisplayed() {
        return isElementDisplayed(CANCEL_BUTTON);
    }

    public boolean isPreviousButtonDisplayed() {
        return isElementDisplayed(PREVIOUS_BUTTON);
    }

    public String getNGSSStandardDropdownPlaceholderText() {
        return getTextForElement(NGSS_STANDARDS_DROPDOWN_PLACEHOLDER_TEXT);
    }

    public String getCCSSStandardDropdownPlaceholderText() {
        return getTextForElement(CCSS_STANDARDS_DROPDOWN_PLACEHOLDER_TEXT);
    }

    public String getStateStandardDropdownPlaceholderText() {
        return getTextForElement(STATE_STANDARDS_DROPDOWN_PLACEHOLDER_TEXT);
    }

    public String getAuthorTextFieldPlaceholderText() {
        return getElementAttribute(AUTHOR_TEXT_FIELD_PLACEHOLDER_TEXT, "placeholder");
    }

    public String getPublisherTextFieldPlaceholderText() {
        return getElementAttribute(PUBLISHER_TEXT_FIELD_PLACEHOLDER_TEXT, "placeholder");
    }

    public String getAudienceDropdownPlaceholderText() {
        return getTextForElement(AUDIENCE_DROPDOWN_PLACEHOLDER_TEXT);
    }

    public String getInstructionalStrategyPlaceholderText() {
        return getTextForElement(INSTRUCTIONAL_STRATEGY_DROPDOWN_PLACEHOLDER_TEXT);
    }

    public String getLanguageDropdownPlaceholderText() {
        return getTextForElement(LANGUAGE_DROPDOWN_PLACEHOLDER_TEXT);
    }

    public String getYearDropdownPlaceholderText() {
        return getTextForElement(YEAR_DROPDOWN_PLACEHOLDER_TEXT);
    }

    public String getUsagePermissionsDropdownPlaceholderText() {
        return getTextForElement(USAGE_PERMISSIONS_DROPDOWN_PLACEHOLDER_TEXT);
    }

    public String getDurationDropdownPlaceholderText() {
        return getTextForElement(DURATION_DROPDOWN_PLACEHOLDER_TEXT);
    }

    public String getConceptsIconPopoverText() {
        return getElementAttribute(CONCEPT_DROPDOWN_I_ICON, "data-tip");
    }

    public String getRatingIconPopoverText() {
        return getElementAttribute(RATING_I_ICON, "data-tip");
    }

    public String getAdditionalTagsIconPopoverText() {
        return getElementAttribute(ADDITIONAL_TAG_I_ICON, "data-tip");
    }

    public String getDescriptionIconPopoverText() {
        return getElementAttribute(DESCRIPTION_I_ICON, "data-tip");
    }

    public void hoverOverRatingIcon() {
        hoverOverElement(RATING_I_ICON, true);
    }

    public void hoverOverConceptsIcon() {
        hoverOverElement(CONCEPT_DROPDOWN_I_ICON, true);
    }

    public void hoverOverAdditionalTagsIcon() {
        hoverOverElement(ADDITIONAL_TAG_I_ICON, true);
    }

    public void hoverOverDescriptionIcon() {
        scrollToElement(DESCRIPTION_I_ICON);
        hoverOverElement(DESCRIPTION_I_ICON, false);
    }

    public void hoverOverUsagePermissionsIcon() {
        hoverOverElement(USAGE_PERMISSIONS_I_ICON);
    }

    public void hoverOverCustomLicenceLinkIcon() {
        hoverOverElement(CUSTOM_LICENSE_LINK_I_ICON);
    }

    public void hoverOverAudienceIcon() {
        hoverOverElement(AUDIENCE_I_ICON);
    }

    public void hoverOverInstructionalStrategyIcon() {
        hoverOverElement(INSTRUCTIONAL_STRATEGY_I_ICON);
    }

    public void hoverOverProsIcon() {
        scrollToElement(PROS_I_ICON);
        hoverOverElement(PROS_I_ICON);
    }

    public void hoverOverConsIcon() {
        scrollToElement(CONS_I_ICON);
        hoverOverElement(CONS_I_ICON);
    }

    public void hoverOverInstructionalIdeasIcon() {
        scrollToElement(INSTRUCTIONAL_IDEAS_I_ICON);
        hoverOverElement(INSTRUCTIONAL_IDEAS_I_ICON);
    }

    public void hoverOverClassroomConsiderationsIcon() {
        scrollToElement(CLASSROOM_CONSIDERATIONS_I_ICON);
        hoverOverElement(CLASSROOM_CONSIDERATIONS_I_ICON);
    }

    public void hoverOverLanguageIcon() {
        scrollToElement(LANGUAGE_I_ICON);
        hoverOverElement(LANGUAGE_I_ICON);
    }

    public String getLanguagePopoverText() {
        return getElementAttribute(LANGUAGE_I_ICON, "data-tip");
    }

    public String getUsagePermissionsPopoverText() {
        return getElementAttribute(USAGE_PERMISSIONS_I_ICON, "data-tip");
    }

    public String getCustomLicenceLinkIconPopoverText() {
        return getElementAttribute(CUSTOM_LICENSE_LINK_I_ICON, "data-tip");
    }

    public String getAudienceIconPopoverText() {
        return getElementAttribute(AUDIENCE_I_ICON, "data-tip");
    }

    public String getInstructionalStrategyIconPopoverText() {
        return getElementAttribute(INSTRUCTIONAL_STRATEGY_I_ICON, "data-tip");
    }

    public String getProsIconPopoverText() {
        return getElementAttribute(PROS_I_ICON, "data-tip");
    }

    public String getConsIconPopoverText() {
        return getElementAttribute(CONS_I_ICON, "data-tip");
    }

    public String getClassroomConsiderationsIconPopoverText() {
        return getElementAttribute(CLASSROOM_CONSIDERATIONS_I_ICON, "data-tip");
    }

    public String getInstructionalIdeasIconPopoverText() {
        return getElementAttribute(INSTRUCTIONAL_IDEAS_I_ICON, "data-tip");
    }

    public boolean isLexileDropdownDisplayed() {
        return isElementDisplayed(LEXILE_DROPDOWN);
    }

    public boolean isAccessibilityDropdownDisplayed() {
        return isElementDisplayed(ACCESSIBILITY_DROPDOWN);
    }

    public String getUploadedFileText() {
        return getTextForElement(UPLOADED_FILE_TEXT);
    }

    public void selectRating(String rating) {
        sendKeys(RATING_DROPDOWN, rating);
        clickElement(RATING_MATCHING_OPTIONS, 0);
    }

    public boolean isEnabledFinishButtonDisplayed() {
        return isElementDisplayed(ENABLED_FINISH_BUTTON);
    }

    public void selectLexile(String lexile) {
        sendKeys(LEXILE_DROPDOWN, lexile);
        clickElement(LEXILE_DROPDOWN_MATCHING_OPTION, 0);
    }

    public void selectAccessibility(String accessibility) {
        sendKeys(ACCESSIBILITY_DROPDOWN, accessibility);
        clickElement(ACCESSIBILITY_DROPDOWN_MATCHING_OPTION, 0);
    }

    private void pasteTextUsingSearchField(String cssSelector, String text) {
        headerPage.typeSearchText(text);
        if (!System.getProperty("os.name").toUpperCase().contains("MAC")) {
            headerPage.typeSearchText(Keys.CONTROL + "a");
            headerPage.typeSearchText(Keys.CONTROL + "c");
        } else {
            headerPage.typeSearchText(Keys.COMMAND + "a");
            headerPage.typeSearchText(Keys.COMMAND + "c");
        }
        headerPage.deleteSearchText();
        if (!System.getProperty("os.name").toUpperCase().contains("MAC")) {
            sendKeys(cssSelector, Keys.CONTROL + "v");
        } else {
            sendKeys(cssSelector, Keys.COMMAND + "v");
        }
    }
}
