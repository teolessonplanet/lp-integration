import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;
import java.util.Arrays;

public class RRPSearchPageTest extends BaseTest{
    private DiscoverResourcesPage discoverResourcesPage;
    private RrpModal rrpModal;
    private RrpPage rrpPage;
    private CollectionRrpModal collectionRrpModal;
    private CollectionRrpPage collectionRrpPage;
    private WhatMembersSayWidget whatMembersSayWidget;
    private StepOneModal stepOneModal;
    private SignInPage signInPage;
    private StepOnePage stepOnePage;

    @BeforeMethod
    public void beforeMethod() {
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        rrpModal = new RrpModal (webDriver);
        rrpPage = new RrpPage(webDriver);
        collectionRrpModal = new CollectionRrpModal(webDriver);
        collectionRrpPage= new CollectionRrpPage(webDriver);
        whatMembersSayWidget = new WhatMembersSayWidget(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        signInPage = new SignInPage(webDriver);
        stepOnePage = new StepOnePage(webDriver);
    }

    @Test(description = "Visitor: [RRP Modal - RRP Overview]: lessonp-467: Resource Modal Overview")
    public void testLessonp_467() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        testRegularResourceRRPOverview(true);
    }

    @Test(description = "Visitor : [RRP Modal - RRP Overview] - lessonp-1282: Shared Resource Modal Overview")
    public void testLessonp_1282() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(false);
        testSharedResourceRRPOverview(true);
    }

    @Test(description = "Visitor : [RRP Modal - RRP Overview] - lessonp-468: Collection Modal Overview")
    public void testLessonp_468() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        testCollectionRRPOverview(true);
    }

    @Test(description = "Visitor: [RRP Static - RRP Overview - LP Resources]: lessonp-475: Resource Static Page Overview")
    public void testLessonp_475() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testRegularResourceRRPOverview(false);
    }

    @Test(description = "Visitor: [RRP Static - RRP Overview - LP Resources]: lessonp-4158: RRP section")
    public void testLessonp_4158() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testRegularResourceRRPSection();
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
        testSharedResourceRRPOverview(false);
    }

    @Test(description = "Visitor - RRP Static  - RRP Overview - Published Resources - lessonp-4159: RRP Section")
    public void testLessonp_4159() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        testSharedResourceRRPSection();
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
        testCollectionRRPOverview(false);
    }

    @Test(description = "Visitor - RRP Static  - RRP Overview - Collections -  lessonp-4160: RRP Section")
    public void testLessonp_4160() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        testCollectionRRPSection();
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - LP Resources]: lessonp-469: Join to See this Resource")
    public void testLessonp_469() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        testJoinToSeeThisResourceButton(true);
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - LP Resources]: lessonp-1321: Thumbnail")
    public void testLessonp_1321() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        testThumbnail(true, true);
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - LP Resources]: lessonp-470: Favorite")
    public void testLessonp_470() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        testFavoriteButton(true);
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - LP Resources]: lessonp-472: Next/Previous Buttons")
    public void testLessonp_472() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        testRegularResourceRRPNavigationButtons();
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - Shared Resources]: lessonp-1254: Go to Resource button")
    public void testLessonp_1254() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(false);
        testGoToResourceButton(true);
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - Shared Resources]: lessonp-1320: Thumbnail")
    public void testLessonp_1320() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(false);
        testThumbnail(true, false);
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - Shared Resources]: lessonp-4163: Favorite Button")
    public void testLessonp_4163() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(false);
        testFavoriteButton(true);
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - Shared Resources]: lessonp-4161: Next/Previous Buttons")
    public void testLessonp_4161() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(false);
        testSharedResourceRRPNavigationButtons();
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - Collections]: lessonp-473: Join for Full Review button")
    public void testLessonp_473() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        testJoinForFullReviewButton(true);
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - Collections]: lessonp-474: Save Collection button")
    public void testLessonp_474() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        testSaveCollectionButton(true);
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - Collections]: lessonp-4162: Next/Previous Buttons - RRP")
    public void testLessonp_4162() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        testCollectionRRPNavigationButtons();
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - Collections]: lessonp-4175: Next/Previous Buttons - Panel Items")
    public void testLessonp_4175() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        testPanelItemsNavigationButtons(true);
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - Collections]: lessonp-4173: Item Viewer: from Panel Items")
    public void testLessonp_4173() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        collectionRrpModal.waitForModal();
        collectionRrpModal.clickPanelItem(0);
        testItemViewerSection(true);
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - Collections]: lessonp-4174: Item Viewer: from See Full Reviews link")
    public void testLessonp_4174() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        collectionRrpModal.waitForModal();
        collectionRrpModal.clickSeeFullReviewsLink();
        testItemViewerSection(true);
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - LP Resources]: lessonp-477: Join to See this Resource button")
    public void testLessonp_477() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testJoinToSeeThisResourceButton(false);
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - LP Resources]: lessonp-478: Favorite")
    public void testLessonp_478() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testFavoriteButton(false);
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - LP Resources]: lessonp-1318: Thumbnail")
    public void testLessonp_1318() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testThumbnail(false, true);
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - LP Resources]: lessonp-4124: Try It Free Button (Start Your Free Trial)")
    public void testLessonp_4124() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testStartYourFreeTrialTryItFreeButton();
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - LP Resources]: lessonp-4125: Try It free(See similar resources)")
    public void testLessonp_4125() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testSeeSimilarResourcesTryItFreeButton();
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - LP Resources]: lessonp-4133: See similar resources dropdown")
    public void testLessonp_4133() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testSeeSimilarResourcesDropdown();
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - Shared Resources]: lessonp-1253: Go to Resource button")
    public void testLessonp_1253() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        testGoToResourceButton(false);
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - Shared Resources]: lessonp-1317: Thumbnail")
    public void testLessonp_1317() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        testThumbnail(false, false);
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - Shared Resources]: lessonp-4130: Favorite")
    public void testLessonp_4130() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        testFavoriteButton(false);
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - Shared Resources]: lessonp-4127: Submit Your Own Link")
    public void testLessonp_4127() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        whatMembersSayWidget.clickOnSubmitYourOwnButton(false);
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.LOGIN_PAGE_PATH));
        discoverResourcesPage.goBackOnePage();
        whatMembersSayWidget.clickOnSubmitYourOwnButton(true);
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.LOGIN_PAGE_PATH));
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - Shared Resources]: lessonp-4126: See more testimonials link")
    public void testLessonp_4126() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        whatMembersSayWidget.clickOnSeeMoreTestimonialsButton(false);
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.TESTIMONIALS_PAGE_PATH));
        discoverResourcesPage.goBackOnePage();
        whatMembersSayWidget.clickOnSeeMoreTestimonialsButton(true);
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.TESTIMONIALS_PAGE_PATH));
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - Shared Resources]: lessonp-4128: Get Free Trial button (What Members Say box)")
    public void testLessonp_4128() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        whatMembersSayWidget.clickSubscriptionButton(false);
        testStepOneModal();
        whatMembersSayWidget.clickSubscriptionButton(true);
        testStepOnePage();
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - Shared Resources]: lessonp--4131: Try It Free Button (Start Your Free Trial box)")
    public void testLessonp_4131() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        testStartYourFreeTrialTryItFreeButton();
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - Shared Resources]: lessonp-4132: Try it free button (See similar resources box)")
    public void testLessonp_4132() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        testSeeSimilarResourcesTryItFreeButton();
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - Shared Resources]: lessonp-4134: See similar resources dropdown")
    public void testLessonp_4134() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        testSeeSimilarResourcesDropdown();
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - Collections]: lessonp-481: Join for Full Review")
    public void testLessonp_481() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        testJoinForFullReviewButton(false);
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - Collections]: lessonp-482: Save Collection")
    public void testLessonp_482() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        testSaveCollectionButton(false);
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - Collections]: lessonp-4136: Next/Previous  - Panel Items")
    public void testLessonp_4136() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        testPanelItemsNavigationButtons(false);
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - Collections]: lessonp-4135: Item Viewer: from Panel Item")
    public void testLessonp_4135() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        collectionRrpPage.clickPanelItem(0);
        testItemViewerSection(false);
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - Collections]: lessonp-4138: Item Viewer: from See Full Reviews link")
    public void testLessonp_4138() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        collectionRrpPage.clickSeeFullReviewsLink();
        testItemViewerSection(false);
    }

    private void testRegularResourceRRPOverview(boolean modal) {
        if (modal) {
            rrpModal.waitForModal();
            Assert.assertTrue(rrpModal.isResourceRrpDetailsDisplayed());
            Assert.assertTrue(rrpModal.isTitleDisplayed());
            Assert.assertTrue(rrpModal.isDescriptionDisplayed());
            Assert.assertTrue(rrpModal.isNumberOfViewsDisplayed());
            Assert.assertTrue(rrpModal.isNumberOfDownloadsDisplayed());
            Assert.assertTrue(rrpModal.isConceptsTagsListDisplayed());
            Assert.assertTrue(rrpModal.isReviewerRatingDisplayed());
            Assert.assertTrue(rrpModal.isRegularResourceGradeDisplayed());
            Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpModal.getRegularResourceSubjectText().get(0)));
            if (rrpModal.getRegularResourceSubjectsNumber() > 1) {
                Assert.assertTrue((rrpModal.getRegularResourceSubjectText().get(1)).contains(TestData.DISABLED_TEXT));
            }
            Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpModal.getRegularResourceResourceTypeText().get(0)));
            if (rrpModal.getRegularResourceResourceTypeNumber() > 1) {
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
        } else {
            Assert.assertTrue(rrpPage.isResourceRrpDetailsDisplayed());
            Assert.assertTrue(rrpPage.isStartYourFreeTrialWidgetDisplayed());
            Assert.assertTrue(rrpPage.isSimilarResourcesSectionDisplayed());
        }
    }

    private void testRegularResourceRRPSection(){
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

    private void testSimilarResourcesSection(){
        if(rrpPage.isSimilarResourcesSectionDisplayed()) {
            Assert.assertTrue(rrpPage.isSimilarResourcesHeaderDisplayed());
            Assert.assertTrue(rrpPage.isSimilarResourcesListDisplayed());
            Assert.assertTrue(rrpPage.isAllResourceTypesDropdownDisplayed());
            Assert.assertTrue(rrpPage.isBottomPageTryItFreeButtonDisplayed());
            rrpPage.clickAllResourceTypesDropdown();
            Assert.assertEquals(rrpPage.getAllResourceTypesFromDropdown(), TestData.ALL_RESOURCE_TYPES_DROPDOWN);
        } else {
            Assert.assertTrue(rrpPage.isBottomPageTryItFreeButtonDisplayed());
        }
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

    private void testSharedResourceRRPOverview(boolean modal) {
        if(modal){
            rrpModal.waitForModal();
            Assert.assertTrue(rrpModal.isResourceRrpDetailsDisplayed());
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
        } else{
            Assert.assertTrue(rrpPage.isResourceRrpDetailsDisplayed());
            Assert.assertTrue(rrpPage.isStartYourFreeTrialWidgetDisplayed());
            Assert.assertTrue(whatMembersSayWidget.isWidgetDisplayed());
            Assert.assertTrue(rrpPage.isSimilarResourcesSectionDisplayed());
        }
    }

    private void testSharedResourceRRPSection() {
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

    private void testCollectionRRPOverview(boolean modal) {
        if(modal){
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
            testPanelItemsNavigationButtons(false);
            Assert.assertTrue(collectionRrpModal.isSeeFullReviewsLinkVisible());
            collectionRrpModal.clickSeeFullReviewsLink();
            Assert.assertEquals(collectionRrpModal.getExpandedRrpDataId(0), collectionRrpModal.getPanelItemDataId(0));
            Assert.assertFalse(collectionRrpModal.isSeeFullReviewsLinkVisible());
            Assert.assertFalse(collectionRrpModal.isPreviousButtonItemViewerDisplayed());
            Assert.assertTrue(collectionRrpModal.isNextButtonItemViewerDisplayed());
            collectionRrpModal.clickCloseExpandedRrp();
            Assert.assertTrue(collectionRrpModal.isSeeFullReviewsLinkVisible());
        } else {
            Assert.assertTrue(collectionRrpPage.isCollectionRrpDetailsDisplayed());
        }
    }

    private void testCollectionRRPSection(){
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
        testPanelItemsNavigationButtons(true);
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

    private void testStepOneModal(){
        stepOneModal.waitForModal();
        Assert.assertEquals(stepOneModal.getTitleText(), TestData.STEP_ONE_MODAL_TITLE);
        stepOneModal.clickCloseModal();
    }

    private void testStepOnePage(){
        Assert.assertEquals(stepOnePage.getTitleText(), TestData.STEP_ONE_PAGE_TITLE);
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
    }

    private void testSignInPage(){
        discoverResourcesPage.waitForLinkToLoad();
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.LOGIN_PAGE_PATH));
        Assert.assertEquals(signInPage.getTitleText(), TestData.SIGN_IN_MODAL_TITLE_TEXT);
    }

    private void testSharedResourceUrl(){
        discoverResourcesPage.waitForNewTab();
        discoverResourcesPage.focusDriverToLastTab();
        discoverResourcesPage.waitForLinkToLoad();
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.STAGING_SERVER_SHARED_RESOURCE_URL));
        discoverResourcesPage.closeTab();
    }

    private void testJoinToSeeThisResourceButton(boolean modal) {
        if(modal){
            rrpModal.waitForModal();
            rrpModal.clickJoinToSeeThisResourceButton(false);
            testStepOneModal();
            rrpModal.clickJoinToSeeThisResourceButton(true);
            testStepOnePage();
        } else{
            rrpPage.clickJoinToSeeThisResourceButton(false);
            testStepOneModal();
            rrpPage.clickJoinToSeeThisResourceButton(true);
            testStepOnePage();
        }
    }

    private void testFavoriteButton(boolean modal) {
        if(modal){
            rrpModal.waitForModal();
            rrpModal.clickVisitorFavoriteButton();
            Assert.assertTrue(rrpModal.isSignInPopupLinkDisplayed() && rrpModal.isJoinNowPopupLinkDisplayed());
            rrpModal.clickJoinNowPopupLink();
            testStepOneModal();
            rrpModal.clickVisitorFavoriteButton();
            rrpModal.clickSignInPopupLink();
            testSignInPage();
        } else{
            rrpPage.clickVisitorFavoriteButton();
            Assert.assertTrue(rrpPage.isSignInPopupLinkDisplayed() && rrpPage.isJoinNowPopupLinkDisplayed());
            rrpPage.clickJoinNowPopupLink();
            testStepOneModal();
            rrpPage.clickVisitorFavoriteButton();
            rrpPage.clickSignInPopupLink();
            testSignInPage();
        }
    }

    private void testRegularResourceRRPNavigationButtons() {
        Assert.assertTrue(rrpModal.getModalId().contains(discoverResourcesPage.getRegularResourceCardDataId(0)));
        if(discoverResourcesPage.getResourceCardDataType(0).equals(TestData.SHARED_RESOURCE_TYPE)){
            Assert.assertTrue(rrpModal.isPreviousButtonDisplayed());
        } else {
            Assert.assertFalse(rrpModal.isPreviousButtonDisplayed());
        }
        Assert.assertTrue(rrpModal.isNextButtonDisplayed());
        rrpModal.clickNextButton();
        Assert.assertTrue(rrpModal.getModalId().contains(discoverResourcesPage.getRegularResourceCardDataId(1)));
        rrpModal.clickPreviousButton();
        Assert.assertTrue((rrpModal.getModalId().contains(discoverResourcesPage.getRegularResourceCardDataId(0))));
    }

    private void testThumbnail(boolean modal, boolean regularResource) {
        if(modal){
            rrpModal.waitForModal();
            rrpModal.clickOnThumbnail();
        } else {
            rrpPage.clickOnThumbnail();
        }
        if(regularResource){
            testStepOneModal();
        }else{
            testSharedResourceUrl();
        }
    }

    private void testGoToResourceButton(boolean modal) {
        if(modal){
            rrpModal.waitForModal();
            rrpModal.clickGoToResourceButton(false);
            testSharedResourceUrl();
            rrpModal.clickGoToResourceButton(true);
            testSharedResourceUrl();
        } else {
            rrpPage.clickGoToResourceButton(false);
            testSharedResourceUrl();
            rrpPage.clickGoToResourceButton(true);
            testSharedResourceUrl();
        }
    }

    private void testSharedResourceRRPNavigationButtons() {
        Assert.assertTrue((rrpModal.getModalId().contains(discoverResourcesPage.getSharedResourceCardDataId(0))));
        if(discoverResourcesPage.getResourceCardDataType(0).equals(TestData.REGULAR_RESOURCE_TYPE)) {
            Assert.assertTrue(rrpModal.isPreviousButtonDisplayed());
        } else {
            Assert.assertFalse(rrpModal.isPreviousButtonDisplayed());
        }
        Assert.assertTrue(rrpModal.isNextButtonDisplayed());
        rrpModal.clickNextButton();
        Assert.assertTrue((rrpModal.getModalId().contains(discoverResourcesPage.getSharedResourceCardDataId(1))));
        rrpModal.clickPreviousButton();
        Assert.assertTrue((rrpModal.getModalId().contains(discoverResourcesPage.getSharedResourceCardDataId(0))));
    }

    private void testJoinForFullReviewButton(boolean modal) {
        if(modal){
            collectionRrpModal.waitForModal();
            collectionRrpModal.clickJoinForFullReviewButton(false);
            testStepOneModal();
            collectionRrpModal.clickJoinForFullReviewButton(true);
            testStepOnePage();
        } else{
            collectionRrpPage.clickJoinForFullReviewButton(false);
            testStepOneModal();
            collectionRrpPage.clickJoinForFullReviewButton(true);
            testStepOnePage();
        }
    }

    private void testSaveCollectionButton(boolean modal) {
        if(modal){
            collectionRrpModal.waitForModal();
            collectionRrpModal.clickSaveCollectionButton();
            Assert.assertTrue(collectionRrpModal.isSignInPopupLinkDisplayed() && collectionRrpModal.isJoinNowPopupLinkDisplayed());
            collectionRrpModal.clickJoinNowPopupLink();
            testStepOneModal();
            collectionRrpModal.clickSaveCollectionButton();
            collectionRrpModal.clickSignInPopupLink();
            testSignInPage();
        } else{
            collectionRrpPage.clickSaveCollectionButton();
            Assert.assertTrue(collectionRrpPage.isSignInPopupLinkDisplayed() && collectionRrpPage.isJoinNowPopupLinkDisplayed());
            collectionRrpPage.clickJoinNowPopupLink();
            testStepOneModal();
            collectionRrpPage.clickSaveCollectionButton();
            collectionRrpPage.clickSignInPopupLink();
            testSignInPage();
        }
    }

    private void testCollectionRRPNavigationButtons() {
        collectionRrpModal.waitForModal();
        Assert.assertEquals(collectionRrpModal.getCollectionTitleText(), discoverResourcesPage.getCollectionCardTitle(0));
        collectionRrpModal.clickNextButtonRrp();
        Assert.assertEquals(collectionRrpModal.getCollectionTitleText(),discoverResourcesPage.getCollectionCardTitle(1));
        collectionRrpModal.clickPreviousButtonRrp();
        Assert.assertEquals(collectionRrpModal.getCollectionTitleText(),discoverResourcesPage.getCollectionCardTitle(0));
    }

    private void testPanelItemsNavigationButtons(boolean modal) {
        if(modal){
            if((collectionRrpModal.getCollectionItemsCount() > 4) && (collectionRrpModal.getCollectionItemsCount() <= 8)) {
                Assert.assertFalse(collectionRrpModal.isPreviousButtonPanelItemsDisplayed());
                Assert.assertTrue(collectionRrpModal.isNextButtonPanelItemsDisplayed());
                collectionRrpModal.clickNextButtonPanelItems();
                Assert.assertTrue(collectionRrpModal.isPreviousButtonPanelItemsDisplayed());
                Assert.assertFalse(collectionRrpModal.isNextButtonPanelItemsDisplayed());
            }
            if(collectionRrpModal.getCollectionItemsCount() <= 4){
                Assert.assertFalse(collectionRrpModal.isPreviousButtonPanelItemsDisplayed() && collectionRrpModal.isNextButtonPanelItemsDisplayed());
            }
            if(collectionRrpModal.getCollectionItemsCount() >= 9 ){
                Assert.assertFalse(collectionRrpModal.isPreviousButtonPanelItemsDisplayed());
                Assert.assertTrue(collectionRrpModal.isNextButtonPanelItemsDisplayed());
                collectionRrpModal.clickNextButtonPanelItems();
                Assert.assertTrue(collectionRrpModal.isPreviousButtonPanelItemsDisplayed()&& collectionRrpModal.isNextButtonPanelItemsDisplayed());
            }
        }else{
            if((collectionRrpPage.getCollectionItemsCount() > 4) && (collectionRrpPage.getCollectionItemsCount() <= 8)) {
                Assert.assertFalse(collectionRrpPage.isPreviousButtonPanelItemsDisplayed());
                Assert.assertTrue(collectionRrpPage.isNextButtonPanelItemsDisplayed());
                collectionRrpPage.clickNextButtonPanelItems();
                Assert.assertTrue(collectionRrpPage.isPreviousButtonPanelItemsDisplayed());
                Assert.assertFalse(collectionRrpPage.isNextButtonPanelItemsDisplayed());
            }
            if(collectionRrpPage.getCollectionItemsCount() <= 4){
                Assert.assertFalse(collectionRrpPage.isPreviousButtonPanelItemsDisplayed() && collectionRrpPage.isNextButtonPanelItemsDisplayed() );
            }
            if(collectionRrpPage.getCollectionItemsCount() >= 9 ){
                Assert.assertFalse(collectionRrpPage.isPreviousButtonPanelItemsDisplayed());
                Assert.assertTrue(collectionRrpPage.isNextButtonPanelItemsDisplayed());
                collectionRrpPage.clickNextButtonPanelItems();
                Assert.assertTrue(collectionRrpPage.isPreviousButtonPanelItemsDisplayed() && collectionRrpPage.isNextButtonPanelItemsDisplayed() );
            }
        }
    }

    private void testItemViewerSection(boolean modal){
        if(modal){
            Assert.assertEquals(collectionRrpModal.getExpandedRrpDataId(0), collectionRrpModal.getPanelItemDataId(0));
            Assert.assertFalse(collectionRrpModal.isSeeFullReviewsLinkVisible());
            Assert.assertFalse(collectionRrpModal.isPreviousButtonItemViewerDisplayed());
            if(collectionRrpModal.getCollectionItemsCount()>1) {
                Assert.assertTrue(collectionRrpModal.isNextButtonItemViewerDisplayed());
                collectionRrpModal.clickNextButtonItemViewer();
                Assert.assertEquals(collectionRrpModal.getExpandedRrpDataId(1), collectionRrpModal.getPanelItemDataId(1));
                collectionRrpModal.clickPreviousButtonItemViewer();
                Assert.assertEquals(collectionRrpModal.getExpandedRrpDataId(0), collectionRrpModal.getPanelItemDataId(0));
            }
            if(collectionRrpModal.getCollectionItemsCount()==1) {
                Assert.assertFalse(collectionRrpModal.isNextButtonItemViewerDisplayed());
            }
            collectionRrpModal.clickCloseExpandedRrp();
            Assert.assertTrue(collectionRrpModal.isSeeFullReviewsLinkVisible());
        }else{
            Assert.assertEquals(collectionRrpPage.getExpandedRrpDataId(0), collectionRrpPage.getPanelItemDataId(0));
            Assert.assertFalse(collectionRrpPage.isSeeFullReviewsLinkVisible());
            Assert.assertFalse(collectionRrpPage.isPreviousButtonItemViewerDisplayed());
            if(collectionRrpPage.getCollectionItemsCount()>1) {
                Assert.assertTrue(collectionRrpPage.isNextButtonItemViewerDisplayed());
                collectionRrpPage.clickNextButtonItemViewer();
                Assert.assertEquals(collectionRrpPage.getExpandedRrpDataId(1), collectionRrpPage.getPanelItemDataId(1));
                collectionRrpPage.clickPreviousButtonItemViewer();
                Assert.assertEquals(collectionRrpPage.getExpandedRrpDataId(0), collectionRrpPage.getPanelItemDataId(0));
            }
            if(collectionRrpPage.getCollectionItemsCount()==1) {
                Assert.assertFalse( collectionRrpPage.isNextButtonItemViewerDisplayed());
            }
            collectionRrpPage.clickCloseExpandedRrp();
            Assert.assertTrue(collectionRrpPage.isSeeFullReviewsLinkVisible());
        }
    }

    private void testStartYourFreeTrialTryItFreeButton() {
        rrpPage.clickStartYourFreeTrialTryItFreeButton(false);
        testStepOneModal();
        rrpPage.clickStartYourFreeTrialTryItFreeButton(true);
        testStepOnePage();
    }

    private void testSeeSimilarResourcesTryItFreeButton() {
        rrpPage.clickBottomPageTryItFreeButton(false);
        testStepOneModal();
        rrpPage.clickBottomPageTryItFreeButton(true);
        testStepOnePage();
    }

    private void testSeeSimilarResourcesDropdown() {
        rrpPage.clickAllResourceTypesDropdown();
        rrpPage.clickWorksheetsResourceType();
        Assert.assertEquals(rrpPage.getAllResourceTypesDropdownText(), TestData.WORKSHEETS_RESOURCE_TYPE);
        if(rrpPage.isSimilarResourceCardDisplayed()){
            Assert.assertEquals(rrpPage.getResourceCardResourceTypeText(), '"' + TestData.WORKSHEET_RESOURCE_TYPE_CARD + '"');
        }
        else{
            Assert.assertEquals(rrpPage.getSimilarResourcesListText(), TestData.NO_RESOURCES_FOUND_TEXT);
        }
    }
}