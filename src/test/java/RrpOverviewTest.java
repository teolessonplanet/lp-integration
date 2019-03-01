import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;
import java.util.Arrays;

public class RrpOverviewTest extends BaseTest{
    private DiscoverResourcesPage discoverResourcesPage;
    private RrpModal rrpModal;
    private RrpPage rrpPage;
    private CollectionRrpModal collectionRrpModal;
    private CollectionRrpPage collectionRrpPage;
    private WhatMembersSayWidget whatMembersSayWidget;

    @BeforeMethod
    public void beforeMethod() {
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        rrpModal = new RrpModal (webDriver);
        rrpPage = new RrpPage(webDriver);
        collectionRrpModal = new CollectionRrpModal(webDriver);
        collectionRrpPage= new CollectionRrpPage(webDriver);
        whatMembersSayWidget = new WhatMembersSayWidget(webDriver);
    }

    @Test(description = "Visitor: [RRP Modal - RRP Overview]: lessonp-467: Resource Modal Overview")
    public void testLessonp_467() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        rrpModal.waitForModal();
        Assert.assertTrue(rrpModal.isRegularResourceRrpDetailsDisplayed());
        Assert.assertTrue(rrpModal.isTitleDisplayed());
        Assert.assertTrue(rrpModal.isDescriptionDisplayed());
        Assert.assertTrue(rrpModal.isNumberOfViewsDisplayed());
        Assert.assertTrue(rrpModal.isNumberOfDownloadsDisplayed());
        Assert.assertTrue(rrpModal.isConceptsTagsListDisplayed());
        Assert.assertTrue(rrpModal.isReviewerRatingDisplayed());
        Assert.assertTrue(rrpModal.isRegularResourceGradeDisplayed());
        Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpModal.getRegularResourceSubjectText().get(0)));
        if(rrpModal.getRegularResourceSubjectsNumber()>1){
            Assert.assertTrue((rrpModal.getRegularResourceSubjectText().get(1)).contains(TestData.DISABLED_TEXT));
        }
        Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpModal.getRegularResourceResourceTypeText().get(0)));
        if(rrpModal.getRegularResourceResourceTypeNumber()>1){
            Assert.assertTrue((rrpModal.getRegularResourceResourceTypeText().get(1)).contains(TestData.DISABLED_TEXT));
        }
        Assert.assertTrue(rrpModal.isJoinToSeeThisResourceButtonDisplayed());
        Assert.assertTrue(rrpModal.isLimitedAccessReviewDisplayed());
        Assert.assertTrue(rrpModal.isVisitorFavoriteButtonDisplayed());
        Assert.assertTrue(rrpModal.isShareButtonDisplayed());
        Assert.assertTrue(rrpModal.isThumbnailDisplayed());
        Assert.assertTrue(rrpModal.isNextButtonDisplayed());
        Assert.assertTrue(rrpModal.isSearchResultsPositionDisplayed());
        Assert.assertFalse(rrpModal.isReturnToSearchResultsLinkDisplayed());
    }

    @Test(description = "Visitor : [RRP Modal - RRP Overview] - lessonp-1282: Shared Resource Modal Overview")
    public void testLessonp_1282() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(false);
        rrpModal.waitForModal();
        Assert.assertTrue(rrpModal.isSharedResourceRrpDetailsDisplayed());
        Assert.assertTrue(rrpModal.isTitleDisplayed());
        Assert.assertTrue(rrpModal.isDescriptionDisplayed());
        Assert.assertTrue(rrpModal.isNumberOfDownloadsDisplayed());
        Assert.assertTrue(rrpModal.isNumberOfViewsDisplayed());
        Assert.assertTrue(rrpModal.isSharedResourceGradeDisplayed());
        for(int i=0; i<rrpModal.getSharedResourceSubjectsNumber(); i++){
            Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpModal.getSharedResourceSubjectText().get(i)));
        }
        for(int i=1; i<rrpModal.getSharedResourceResourceTypeNumber(); i++){
            Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpModal.getSharedResourceResourceTypeText().get(i)));
        }
        Assert.assertTrue(rrpModal.isGoToResourceButtonDisplayed());
        Assert.assertTrue(rrpModal.isVisitorFavoriteButtonDisplayed());
        Assert.assertTrue(rrpModal.isShareButtonDisplayed());
        Assert.assertTrue(rrpModal.isThumbnailDisplayed());
        Assert.assertTrue(rrpModal.isNextButtonDisplayed());
        Assert.assertTrue(rrpModal.isSearchResultsPositionDisplayed());
        Assert.assertFalse(rrpModal.isReturnToSearchResultsLinkDisplayed());
    }

    @Test(description = "Visitor : [RRP Modal - RRP Overview] - lessonp-468: Collection Modal Overview")
    public void testLessonp_468() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        collectionRrpModal.waitForModal();
        Assert.assertTrue(collectionRrpModal.isCollectionRrpDetailsDisplayed());
        Assert.assertTrue(collectionRrpModal.isCollectionTitleDisplayed());
        Assert.assertTrue(collectionRrpModal.isDescriptionDisplayed());
        Assert.assertTrue(collectionRrpModal.isCollectionItemsCountDisplayed());
        Assert.assertTrue(collectionRrpModal.isNumberOfViewsDisplayed());
        Assert.assertTrue(collectionRrpModal.isNumberOfDownloadsDisplayed());
        Assert.assertTrue(collectionRrpModal.isConceptsTagsListDisplayed());
        Assert.assertTrue(collectionRrpModal.isGradeDisplayed());
        Assert.assertTrue(collectionRrpModal.isSubjectDisplayed());
        Assert.assertTrue(collectionRrpModal.isCollectionItemsCountDisplayed());
        Assert.assertTrue(collectionRrpModal.isJoinForFullReviewButtonDisplayed());
        Assert.assertTrue(collectionRrpModal.isSaveCollectionButtonDisplayed());
        Assert.assertTrue(collectionRrpModal.isShareButtonDisplayed());
        Assert.assertFalse(collectionRrpModal.isLimitedAccessReviewDisplayed());
        Assert.assertTrue(collectionRrpModal.isNextButtonRrpDisplayed());
        Assert.assertTrue(collectionRrpModal.isSearchResultsPositionDisplayed());
        Assert.assertEquals(collectionRrpModal.getCollectionItemsCount(), collectionRrpModal.getPanelItemsCount());
        if(collectionRrpModal.getCollectionItemsCount() <= 4){
            Assert.assertFalse(collectionRrpModal.isPreviousButtonPanelItemsDisplayed());
            Assert.assertFalse(collectionRrpModal.isNextButtonPanelItemsDisplayed());
        }
        if((collectionRrpModal.getCollectionItemsCount() > 4) && (collectionRrpModal.getCollectionItemsCount() <= 8)) {
            Assert.assertFalse(collectionRrpModal.isPreviousButtonPanelItemsDisplayed());
            Assert.assertTrue(collectionRrpModal.isNextButtonPanelItemsDisplayed());
            collectionRrpModal.clickNextButtonPanelItems();
            Assert.assertTrue(collectionRrpModal.isPreviousButtonPanelItemsDisplayed());
            Assert.assertFalse(collectionRrpModal.isNextButtonPanelItemsDisplayed());
        }
        if(collectionRrpModal.getCollectionItemsCount() >=9 ){
            Assert.assertFalse(collectionRrpModal.isPreviousButtonPanelItemsDisplayed());
            Assert.assertTrue(collectionRrpModal.isNextButtonPanelItemsDisplayed());
            collectionRrpModal.clickNextButtonPanelItems();
            Assert.assertTrue(collectionRrpModal.isPreviousButtonPanelItemsDisplayed());
            Assert.assertTrue(collectionRrpModal.isNextButtonPanelItemsDisplayed());
        }

        Assert.assertTrue(collectionRrpModal.isSeeFullReviewsLinkVisible());
        collectionRrpModal.clickSeeFullReviewsLink();
        Assert.assertEquals(collectionRrpModal.getExpandedRrpDataId(0), collectionRrpModal.getPanelItemDataId(0));
        Assert.assertFalse(collectionRrpModal.isSeeFullReviewsLinkVisible());
        Assert.assertFalse(collectionRrpModal.isPreviousButtonItemViewerDisplayed());
        Assert.assertTrue(collectionRrpModal.isNextButtonItemViewerDisplayed());
        collectionRrpModal.clickCloseExpandedRrp();
        Assert.assertTrue(collectionRrpModal.isSeeFullReviewsLinkVisible());
    }

    @Test(description = "Visitor: [RRP Static - RRP Overview - LP Resources]: lessonp-475: Resource Static Page Overview")
    public void testLessonp_475() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        Assert.assertTrue(rrpPage.isRegularResourceRrpDetailsDisplayed());
        Assert.assertTrue(rrpPage.isStartYourFreeTrialWidgetDisplayed());
        Assert.assertTrue(rrpPage.isSimilarResourcesSectionDisplayed());
    }

    @Test(description = "Visitor: [RRP Static - RRP Overview - LP Resources]: lessonp-4158: RRP section")
    public void testLessonp_4158() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        Assert.assertTrue(rrpPage.isTitleDisplayed());
        Assert.assertTrue(rrpPage.isDescriptionDisplayed());
        Assert.assertTrue(rrpPage.isNumberOfViewsDisplayed());
        Assert.assertTrue(rrpPage.isNumberOfDownloadsDisplayed());
        Assert.assertTrue(rrpPage.isConceptsTagsListDisplayed());
        Assert.assertTrue(rrpPage.isReviewerRatingDisplayed());
        Assert.assertTrue(rrpPage.isRegularResourceGradeDisplayed());
        Assert.assertEquals(rrpPage.getRegularResourceGradeNumber(), 1);
        Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpPage.getRegularResourceSubjectText().get(0)));
        if(rrpPage.getRegularResourceSubjectsNumber()>1){
            Assert.assertTrue((rrpPage.getRegularResourceSubjectText().get(1)).contains(TestData.DISABLED_TEXT));
        }
        Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpPage.getRegularResourceResourceTypeText().get(0)));
        if(rrpPage.getRegularResourceResourceTypeNumber()>1){
            Assert.assertTrue((rrpPage.getRegularResourceResourceTypeText().get(1)).contains(TestData.DISABLED_TEXT));
        }
        Assert.assertTrue(rrpPage.isJoinToSeeThisResourceButtonDisplayed());
        Assert.assertTrue(rrpPage.isLimitedAccessReviewDisplayed());
        Assert.assertTrue(rrpPage.isVisitorFavoriteButtonDisplayed());
        Assert.assertTrue(rrpPage.isShareButtonDisplayed());
        Assert.assertTrue(rrpPage.isThumbnailDisplayed());
        Assert.assertFalse(rrpPage.isPreviousButtonDisplayed());
        Assert.assertFalse(rrpPage.isNextButtonDisplayed());
        Assert.assertFalse(rrpPage.isSearchResultsPositionDisplayed());
        Assert.assertFalse(rrpModal.isReturnToSearchResultsLinkDisplayed());
        Assert.assertTrue(rrpPage.isBottomPageTryItFreeButtonDisplayed());
    }

    @Test(description = "Visitor: [RRP Static - RRP Overview - LP Resources]: lessonp-4121: Start Your Free Trial Widget ")
    public void testLessonp_4121() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testStartYourFreeTrialWidget(TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE);
    }

    @Test(description = "Visitor: [RRP Static  - RRP Overview - LP Resources]: lessonp-4122: See Similar Resources Section")
    public void testLessonp_4122() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testSimilarResourcesSection();
    }

    @Test(description = "Visitor - RRP Static  - RRP Overview - Published Resources - lessonp-944: Published Resource Static Page Overview")
    public void testLessonp_944() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        Assert.assertTrue(rrpPage.isSharedResourceRrpDetailsDisplayed());
        Assert.assertTrue(rrpPage.isStartYourFreeTrialWidgetDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isWidgetDisplayed());
        Assert.assertTrue(rrpPage.isSimilarResourcesSectionDisplayed());
    }

    @Test(description = "Visitor - RRP Static  - RRP Overview - Published Resources - lessonp-4159: RRP Section")
    public void testLessonp_4159() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        Assert.assertTrue(rrpPage.isTitleDisplayed());
        Assert.assertTrue(rrpPage.isDescriptionDisplayed());
        Assert.assertTrue(rrpPage.isNumberOfDownloadsDisplayed());
        Assert.assertTrue(rrpPage.isNumberOfViewsDisplayed());
        Assert.assertTrue(rrpPage.isSharedResourceGradeDisplayed());
        Assert.assertEquals( rrpPage.getSharedResourceGradeNumber(), 1);
        for(int i=0; i<rrpPage.getSharedResourceSubjectsNumber(); i++){
            Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpPage.getSharedResourceSubjectText().get(i)));
        }
        for(int i=0; i<rrpPage.getSharedResourceResourceTypeNumber(); i++){
            Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpPage.getSharedResourceResourceTypeText().get(i)));
        }
        Assert.assertTrue(rrpPage.isGoToResourceButtonDisplayed());
        Assert.assertTrue(rrpPage.isVisitorFavoriteButtonDisplayed());
        Assert.assertTrue(rrpPage.isShareButtonDisplayed());
        Assert.assertTrue(rrpPage.isThumbnailDisplayed());
        Assert.assertFalse(rrpPage.isPreviousButtonDisplayed());
        Assert.assertFalse(rrpPage.isNextButtonDisplayed());
        Assert.assertFalse(rrpPage.isSearchResultsPositionDisplayed());
        Assert.assertTrue(rrpPage.isReturnToSearchResultsLinkDisplayed());
        Assert.assertTrue(rrpPage.isBottomPageTryItFreeButtonDisplayed());
    }

    @Test(description = "Visitor - RRP Static  - RRP Overview - Published Resources - lessonp-4123: What Members Say box")
    public void testLessonp_4123() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        testWhatMembersSayWidget();
    }

    @Test(description = "Visitor - RRP Static  - RRP Overview - Published Resources -  lessonp-4139: Start Your Free Trial box")
    public void testLessonp_4139() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        testStartYourFreeTrialWidget(TestData.START_YOUR_FREE_TRIAL_TEXT_SHARED_RESOURCE);
    }

    @Test(description = "Visitor - RRP Static  - RRP Overview - Published Resources -  lessonp-4140: See Similar Resource section ")
    public void testLessonp_4140() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        testSimilarResourcesSection();
    }

    @Test(description = "Visitor - RRP Static  - RRP Overview - Collections -  lessonp-476: Collection Static Page Overview")
    public void testLessonp_476() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        Assert.assertTrue(collectionRrpPage.isCollectionRrpDetailsDisplayed());
    }

    @Test(description = "Visitor - RRP Static  - RRP Overview - Collections -  lessonp-4160:RRP Section")
    public void testLessonp_4160() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        Assert.assertTrue(collectionRrpPage.isCollectionTitleDisplayed());
        Assert.assertTrue(collectionRrpPage.isDescriptionDisplayed());
        Assert.assertTrue(collectionRrpPage.isGradeDisplayed());
        Assert.assertTrue(collectionRrpPage.isSubjectDisplayed());
        Assert.assertTrue(collectionRrpPage.isCollectionItemsCountDisplayed());
        Assert.assertTrue(collectionRrpPage.isNumberOfViewsDisplayed());
        Assert.assertTrue(collectionRrpPage.isNumberOfDownloadsDisplayed());
        Assert.assertTrue(collectionRrpPage.isConceptsTagsListDisplayed());
        Assert.assertTrue(collectionRrpPage.isCollectionItemsCountDisplayed());
        Assert.assertTrue(collectionRrpPage.isJoinForFullReviewButtonDisplayed());
        Assert.assertTrue(collectionRrpPage.isSaveCollectionButtonDisplayed());
        Assert.assertTrue(collectionRrpPage.isShareButtonDisplayed());
        Assert.assertFalse(collectionRrpPage.isLimitedAccessReviewDisplayed());
        Assert.assertFalse(collectionRrpPage.isPreviousButtonRrpDisplayed());
        Assert.assertFalse(collectionRrpPage.isNextButtonRrpDisplayed());
        Assert.assertFalse(collectionRrpPage.isSearchResultsPositionDisplayed());
        Assert.assertEquals(collectionRrpPage.getCollectionItemsCount(), collectionRrpPage.getPanelItemsCount());
        if(collectionRrpPage.getCollectionItemsCount() <= 4){
            Assert.assertFalse(collectionRrpPage.isPreviousButtonPanelItemsDisplayed());
            Assert.assertFalse(collectionRrpPage.isNextButtonPanelItemsDisplayed());
        }
        if((collectionRrpPage.getCollectionItemsCount() > 4) && (collectionRrpPage.getCollectionItemsCount() <= 8)) {
            Assert.assertFalse(collectionRrpPage.isPreviousButtonPanelItemsDisplayed());
            Assert.assertTrue(collectionRrpPage.isNextButtonPanelItemsDisplayed());
            collectionRrpPage.clickNextButtonPanelItems();
            Assert.assertTrue(collectionRrpPage.isPreviousButtonPanelItemsDisplayed());
            Assert.assertFalse(collectionRrpPage.isNextButtonPanelItemsDisplayed());
        }
        if(collectionRrpPage.getCollectionItemsCount() >= 9 ){
            Assert.assertFalse(collectionRrpPage.isPreviousButtonPanelItemsDisplayed());
            Assert.assertTrue(collectionRrpPage.isNextButtonPanelItemsDisplayed());
            collectionRrpPage.clickNextButtonPanelItems();
            Assert.assertTrue(collectionRrpPage.isPreviousButtonPanelItemsDisplayed());
            Assert.assertTrue(collectionRrpPage.isNextButtonPanelItemsDisplayed());
        }
        Assert.assertTrue(collectionRrpPage.isSeeFullReviewsLinkVisible());
        collectionRrpPage.clickSeeFullReviewsLink();
        Assert.assertEquals(collectionRrpPage.getExpandedRrpDataId(0), collectionRrpPage.getPanelItemDataId(0));
        Assert.assertFalse(collectionRrpPage.isSeeFullReviewsLinkVisible());
        Assert.assertFalse(collectionRrpPage.isPreviousButtonItemViewerDisplayed());
        Assert.assertTrue(collectionRrpPage.isNextButtonItemViewerDisplayed());
        collectionRrpPage.clickCloseExpandedRrp();
        Assert.assertTrue(collectionRrpPage.isSeeFullReviewsLinkVisible());
        Assert.assertTrue(collectionRrpPage.isReturnToSearchResultsLinkDisplayed());
    }

    private void testSimilarResourcesSection(){
        Assert.assertTrue(rrpPage.isSimilarResourcesSectionDisplayed());
        Assert.assertTrue(rrpPage.isSimilarResourcesHeaderDisplayed());
        Assert.assertTrue(rrpPage.isAllResourceTypesDropdownDisplayed());
        Assert.assertTrue(rrpPage.isBottomPageTryItFreeButtonDisplayed());
        rrpPage.clickAllResourceTypesDropdown();
        Assert.assertEquals(rrpPage.getAllResourceTypesFromDropdown(), TestData.ALL_RESOURCE_TYPES_DROPDOWN);
        rrpPage.clickAllResourceTypesDropdown();
        rrpPage.selectWorksheetsResourceType();
        Assert.assertEquals(rrpPage.getTextFromAllResourceTypesDropdown(), TestData.WORKSHEETS_RESOURCE_TYPE);
        Assert.assertEquals(rrpPage.getResourceTypeTextFromResourceCard(), '"' + TestData.WORKSHEET_RESOURCE_TYPE_CARD + '"');
        rrpPage.selectHomeLettersResourceType();
        Assert.assertEquals(rrpPage.getTextFromAllResourceTypesDropdown(), TestData.HOME_LETTERS_RESOURCE_TYPE);
        Assert.assertEquals(rrpPage.getTextFromSimilarResourcesList(), TestData.NO_RESOURCES_FOUND_TEXT);
    }

    private void testStartYourFreeTrialWidget(String widgetText){
        Assert.assertTrue(rrpPage.isStartYourFreeTrialWidgetDisplayed());
        Assert.assertEquals(rrpPage.getStartYourFreeTrialText(), widgetText);
        Assert.assertTrue(rrpPage.isStartYourFreeTrialTryItFreeButtonDisplayed());
    }

    private void testWhatMembersSayWidget(){
        Assert.assertTrue(whatMembersSayWidget.isWidgetDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isTestimonialTextDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isMemberPhotoDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isSeeMoreTestimonialsLinkDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isSubmitYourOwnLinkDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isGetFreeTrialButtonDisplayed());
    }
}
