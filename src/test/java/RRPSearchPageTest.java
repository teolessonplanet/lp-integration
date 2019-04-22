import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;
import java.util.Arrays;
import org.openqa.selenium.WebDriver;

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

    public void reachRRP(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
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
        testPanelItemsOverview(true);
    }

    @Test(description = "Visitor: [RRP Static - RRP Overview]: lessonp-475: Resource Static Page Overview")
    public void testLessonp_475() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testRegularResourceRRPOverview(false);
        testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE);
        testSimilarResourcesSectionOverview();
    }

    @Test(description = "Visitor - RRP Static  - RRP Overview ]: lessonp-944: Shared Resource Static Page Overview")
    public void testLessonp_944() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        testSharedResourceRRPOverview(false);
        testWhatMembersSayWidgetOverview();
        testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_SHARED_RESOURCE);
        testSimilarResourcesSectionOverview();
    }

    @Test(description = "Visitor - RRP Static  - RRP Overview ]: lessonp-476: Collection Static Page Overview")
    public void testLessonp_476() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        testCollectionRRPOverview(false);
        testPanelItemsOverview(false);
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - LP Resources]: lessonp-469: Main buttons")
    public void testLessonp_469() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        testFavoriteButton(true);
        discoverResourcesPage.closeTab();
        testResourceGetFreeAccessForTenDaysButton(true);
        discoverResourcesPage.closeTab();
        testThumbnail(true, true);
        testRegularResourceRRPNavigationButtonsSearchPage();
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - Shared Resources]: lessonp-1254: Main buttons")
    public void testLessonp_1254() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(false);
        testFavoriteButton(true);
        discoverResourcesPage.closeTab();
        testGoToResourceButton(true);
        testThumbnail(true, false);
        testSharedResourceRRPNavigationButtonsSearchPage();
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - Collections]: lessonp-473: Main buttons")
    public void testLessonp_473() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        testSaveCollectionButton(true);
        discoverResourcesPage.closeTab();
        testCollectionGetFreeAccessForTenDaysButton(true);
        discoverResourcesPage.closeTab();
        testCollectionRRPNavigationButtonsSearchPage();
        collectionRrpModal.clickPanelItem(0);
        testItemViewerSection(true);
        collectionRrpModal.clickSeeFullReviewsLink();
        testItemViewerSection(true);
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - LP Resources]: lessonp-4603: Main buttons")
    public void testLessonp_4603() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testFavoriteButton(false);
        discoverResourcesPage.closeTab();
        testResourceGetFreeAccessForTenDaysButton(false);
        discoverResourcesPage.closeTab();
        testThumbnail(false, true);
        testStartYourFreeTrialTryItFreeButton();
        discoverResourcesPage.closeTab();
        testSeeSimilarResourcesDropdown();
        testSeeSimilarResourcesTryItFreeButton();
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - Shared Resources]: lessonp-4608: Main Buttons")
    public void testLessonp_4608() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        testFavoriteButton(false);
        discoverResourcesPage.closeTab();
        testGoToResourceButton(false);
        testThumbnail(false, false);
        testStartYourFreeTrialTryItFreeButton();
        discoverResourcesPage.closeTab();
        testWhatMembersSayWidgetButtons();
        discoverResourcesPage.closeTab();
        testSeeSimilarResourcesDropdown();
        testSeeSimilarResourcesTryItFreeButton();
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - Collections]: lessonp-4609: Main buttons")
    public void testLessonp_4609() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        testSaveCollectionButton(false);
        discoverResourcesPage.closeTab();
        testCollectionGetFreeAccessForTenDaysButton(false);
        discoverResourcesPage.closeTab();
        collectionRrpPage.clickPanelItem(0);
        testItemViewerSection(false);
        collectionRrpPage.clickSeeFullReviewsLink();
        testItemViewerSection(false);
    }

    public void testRegularResourceRRPOverview(boolean modal) {
        if (modal) {
            rrpModal.waitForModal();
            Assert.assertTrue(rrpModal.isTitleDisplayed());
            Assert.assertTrue(rrpModal.isDescriptionDisplayed());
            Assert.assertTrue(rrpModal.isNumberOfViewsDisplayed());
            Assert.assertTrue(rrpModal.isNumberOfDownloadsDisplayed());
            Assert.assertTrue(rrpModal.isConceptsTagsListDisplayed());
            Assert.assertTrue(rrpModal.isReviewerRatingDisplayed());
            Assert.assertTrue(rrpModal.isGetFreeAccessForTenDaysButtonDisplayed());
            Assert.assertTrue(rrpModal.isLimitedAccessReviewDisplayed());
            Assert.assertTrue(rrpModal.isVisitorFavoriteButtonDisplayed());
            Assert.assertTrue(rrpModal.isShareButtonDisplayed());
            Assert.assertTrue(rrpModal.isThumbnailDisplayed());
            if (rrpModal.isLeftSectionBlankDisplayed()) {
                Assert.assertTrue(rrpModal.isLightRrpGradeDisplayed());
                Assert.assertEquals(rrpModal.getLightRrpGradeNumber(), 1);
                Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpModal.getLightRrpSubjectText().get(0)));
                if (rrpModal.getLightRrpSubjectsNumber() > 1) {
                    Assert.assertTrue(rrpModal.getLightRrpSubjectText().get(1).contains(TestData.DISABLED_TEXT));
                }
                Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpPage.getLightRrpResourceTypeText().get(0)));
                if (rrpPage.getLightRrpResourceTypeNumber() > 1) {
                    Assert.assertTrue(rrpPage.getLightRrpResourceTypeText().get(1).contains(TestData.DISABLED_TEXT));
                }
            } else {
                Assert.assertTrue(rrpModal.isFullRrpGradeDisplayed());
                Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpModal.getFullRrpSubjectText().get(0)));
                if (rrpModal.getFullRrpSubjectsNumber() > 1) {
                    Assert.assertTrue(rrpModal.getFullRrpSubjectText().get(1).contains(TestData.DISABLED_TEXT));
                }
                Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpModal.getFullRrpResourceTypeText().get(0)));
                if (rrpModal.getFullRrpResourceTypeNumber() > 1) {
                    Assert.assertTrue(rrpModal.getFullRrpResourceTypeText().get(1).contains(TestData.DISABLED_TEXT));
                }
            }
        } else {
            Assert.assertTrue(rrpPage.isTitleDisplayed());
            Assert.assertTrue(rrpPage.isDescriptionDisplayed());
            Assert.assertTrue(rrpPage.isNumberOfViewsDisplayed());
            Assert.assertTrue(rrpPage.isNumberOfDownloadsDisplayed());
            Assert.assertTrue(rrpPage.isConceptsTagsListDisplayed());
            Assert.assertTrue(rrpPage.isReviewerRatingDisplayed());
            Assert.assertTrue(rrpPage.isGetFreeAccessForTenDaysButtonDisplayed());
            Assert.assertTrue(rrpPage.isLimitedAccessReviewDisplayed());
            Assert.assertTrue(rrpPage.isVisitorFavoriteButtonDisplayed());
            Assert.assertTrue(rrpPage.isShareButtonDisplayed());
            Assert.assertTrue(rrpPage.isThumbnailDisplayed());
            Assert.assertFalse(rrpPage.isPreviousButtonDisplayed());
            if (rrpPage.isLeftSectionBlankDisplayed()) {
                Assert.assertTrue(rrpPage.isLightRrpGradeDisplayed());
                Assert.assertEquals(rrpPage.getLightRrpGradeNumber(), 1);
                Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpPage.getLightRrpSubjectText().get(0)));
                if(rrpPage.getLightRrpSubjectsNumber()>1){
                    Assert.assertTrue((rrpPage.getLightRrpSubjectText().get(1)).contains(TestData.DISABLED_TEXT));
                }
                Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpPage.getLightRrpResourceTypeText().get(0)));
                if(rrpPage.getLightRrpResourceTypeNumber()>1){
                    Assert.assertTrue((rrpPage.getLightRrpResourceTypeText().get(1)).contains(TestData.DISABLED_TEXT));
                }
            } else {
                Assert.assertTrue(rrpPage.isFullRrpGradeDisplayed());
                Assert.assertEquals(rrpPage.getFullRrpGradeNumber(), 1);
                Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpPage.getFullRrpSubjectText().get(0)));
                if (rrpPage.getFullRrpSubjectsNumber() > 1) {
                    Assert.assertTrue(rrpPage.getFullRrpSubjectText().get(1).contains(TestData.DISABLED_TEXT));
                }
                Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpPage.getFullRrpResourceTypeText().get(0)));
                if (rrpPage.getFullRrpResourceTypeNumber() > 1) {
                    Assert.assertTrue(rrpPage.getFullRrpResourceTypeText().get(1).contains(TestData.DISABLED_TEXT));
                }
            }
        }
    }

    public void testStartYourFreeTrialWidgetOverview(String widgetText) {
        Assert.assertTrue(rrpPage.isStartYourFreeTrialWidgetDisplayed());
        Assert.assertEquals(rrpPage.getStartYourFreeTrialText(), widgetText);
        Assert.assertTrue(rrpPage.isStartYourFreeTrialTryItFreeButtonDisplayed());
    }

    public void testSimilarResourcesSectionOverview(){
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

    public void testWhatMembersSayWidgetOverview(){
        Assert.assertTrue(whatMembersSayWidget.isWidgetDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isTestimonialTextDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isMemberPhotoDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isSeeMoreTestimonialsLinkDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isSubmitYourOwnLinkDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isGetFreeTrialButtonDisplayed());
    }

    public void testWhatMembersSayWidgetButtons() {
        whatMembersSayWidget.clickOnSubmitYourOwnButton(false);
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.LOGIN_PAGE_PATH));
        discoverResourcesPage.goBackOnePage();
        whatMembersSayWidget.clickOnSubmitYourOwnButton(true);
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.LOGIN_PAGE_PATH));
        discoverResourcesPage.closeTab();
        whatMembersSayWidget.clickOnSeeMoreTestimonialsButton(false);
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.TESTIMONIALS_PAGE_PATH));
        discoverResourcesPage.goBackOnePage();
        whatMembersSayWidget.clickOnSeeMoreTestimonialsButton(true);
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.TESTIMONIALS_PAGE_PATH));
        discoverResourcesPage.closeTab();
        whatMembersSayWidget.clickSubscriptionButton(false);
        testStepOneModal();
        whatMembersSayWidget.clickSubscriptionButton(true);
        testStepOnePage();
    }

    public void testSharedResourceRRPOverview(boolean modal) {
        if(modal){
            rrpModal.waitForModal();
            Assert.assertTrue(rrpModal.isTitleDisplayed());
            Assert.assertTrue(rrpModal.isDescriptionDisplayed());
            Assert.assertTrue(rrpModal.isNumberOfDownloadsDisplayed());
            Assert.assertTrue(rrpModal.isNumberOfViewsDisplayed());
            Assert.assertTrue(rrpModal.isLightRrpGradeDisplayed());
            for(int i=0; i<rrpModal.getLightRrpSubjectsNumber(); i++){
                Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpModal.getLightRrpSubjectText().get(i)));
            }
            for(int i=1; i<rrpModal.getLightRrpResourceTypeNumber(); i++){
                Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpModal.getLightRrpResourceTypeText().get(i)));
            }
            Assert.assertTrue(rrpModal.isGoToResourceButtonDisplayed());
            Assert.assertTrue(rrpModal.isVisitorFavoriteButtonDisplayed());
            Assert.assertTrue(rrpModal.isShareButtonDisplayed());
            Assert.assertTrue(rrpModal.isThumbnailDisplayed());
        } else{
            Assert.assertTrue(rrpPage.isTitleDisplayed());
            Assert.assertTrue(rrpPage.isDescriptionDisplayed());
            Assert.assertTrue(rrpPage.isNumberOfDownloadsDisplayed());
            Assert.assertTrue(rrpPage.isNumberOfViewsDisplayed());
            Assert.assertTrue(rrpPage.isLightRrpGradeDisplayed());
            Assert.assertEquals(rrpPage.getLightRrpGradeNumber(), 1);
            for(int i=0; i<rrpPage.getLightRrpSubjectsNumber(); i++){
                Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpPage.getLightRrpSubjectText().get(i)));
            }
            for(int i=0; i<rrpPage.getLightRrpResourceTypeNumber(); i++){
                Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpPage.getLightRrpResourceTypeText().get(i)));
            }
            Assert.assertTrue(rrpPage.isGoToResourceButtonDisplayed());
            Assert.assertTrue(rrpPage.isVisitorFavoriteButtonDisplayed());
            Assert.assertTrue(rrpPage.isShareButtonDisplayed());
            Assert.assertTrue(rrpPage.isThumbnailDisplayed());
            Assert.assertFalse(rrpPage.isPreviousButtonDisplayed());
            Assert.assertFalse(rrpPage.isNextButtonDisplayed());
        }
    }

    public void testCollectionRRPOverview(boolean modal) {
        if(modal){
            collectionRrpModal.waitForModal();
            Assert.assertTrue(collectionRrpModal.isCollectionTitleDisplayed());
            Assert.assertTrue(collectionRrpModal.isDescriptionDisplayed());
            Assert.assertTrue(collectionRrpModal.isCollectionItemsCountDisplayed());
            Assert.assertTrue(collectionRrpModal.isNumberOfViewsDisplayed());
            Assert.assertTrue(collectionRrpModal.isNumberOfDownloadsDisplayed());
            Assert.assertTrue(collectionRrpModal.isConceptsTagsListDisplayed());
            Assert.assertTrue(collectionRrpModal.isGradeDisplayed());
            Assert.assertTrue(collectionRrpModal.isSubjectDisplayed());
            Assert.assertTrue(collectionRrpModal.isGetFreeAccessForTenDaysButtonDisplayed());
            Assert.assertTrue(collectionRrpModal.isSaveCollectionButtonDisplayed());
            Assert.assertTrue(collectionRrpModal.isShareButtonDisplayed());
            Assert.assertFalse(collectionRrpModal.isLimitedAccessReviewDisplayed());
            Assert.assertTrue(collectionRrpModal.isSeeFullReviewsLinkVisible());
            Assert.assertEquals(collectionRrpModal.getCollectionItemsCount(), collectionRrpModal.getPanelItemsCount());
        } else {
            Assert.assertTrue(collectionRrpPage.isCollectionTitleDisplayed());
            Assert.assertTrue(collectionRrpPage.isDescriptionDisplayed());
            Assert.assertTrue(collectionRrpPage.isCollectionItemsCountDisplayed());
            Assert.assertTrue(collectionRrpPage.isNumberOfViewsDisplayed());
            Assert.assertTrue(collectionRrpPage.isNumberOfDownloadsDisplayed());
            Assert.assertTrue(collectionRrpPage.isConceptsTagsListDisplayed());
            Assert.assertTrue(collectionRrpPage.isGradeDisplayed());
            Assert.assertTrue(collectionRrpPage.isSubjectDisplayed());
            Assert.assertTrue(collectionRrpPage.isGetFreeAccessForTenDaysButtonDisplayed());
            Assert.assertTrue(collectionRrpPage.isSaveCollectionButtonDisplayed());
            Assert.assertTrue(collectionRrpPage.isShareButtonDisplayed());
            Assert.assertFalse(collectionRrpPage.isLimitedAccessReviewDisplayed());
            Assert.assertTrue(collectionRrpPage.isSeeFullReviewsLinkVisible());
            Assert.assertEquals(collectionRrpPage.getCollectionItemsCount(),collectionRrpPage.getPanelItemsCount());
        }
    }

    public void testPanelItemsOverview(boolean modal) {
        if (modal) {
            if ((collectionRrpModal.getCollectionItemsCount() > 4) && (collectionRrpModal.getCollectionItemsCount() <= 8)) {
                Assert.assertFalse(collectionRrpModal.isPreviousButtonPanelItemsDisplayed());
                Assert.assertTrue(collectionRrpModal.isNextButtonPanelItemsDisplayed());
                collectionRrpModal.clickNextButtonPanelItems();
                Assert.assertTrue(collectionRrpModal.isPreviousButtonPanelItemsDisplayed());
                Assert.assertFalse(collectionRrpModal.isNextButtonPanelItemsDisplayed());
            }
            if (collectionRrpModal.getCollectionItemsCount() <= 4) {
                Assert.assertFalse(collectionRrpModal.isPreviousButtonPanelItemsDisplayed() && collectionRrpModal.isNextButtonPanelItemsDisplayed());
            }
            if (collectionRrpModal.getCollectionItemsCount() >= 9) {
                Assert.assertFalse(collectionRrpModal.isPreviousButtonPanelItemsDisplayed());
                Assert.assertTrue(collectionRrpModal.isNextButtonPanelItemsDisplayed());
                collectionRrpModal.clickNextButtonPanelItems();
                Assert.assertTrue(collectionRrpModal.isPreviousButtonPanelItemsDisplayed() && collectionRrpModal.isNextButtonPanelItemsDisplayed());
            }
        } else {
            if (collectionRrpPage.getCollectionItemsCount() > 4 && collectionRrpPage.getCollectionItemsCount() <= 8) {
                Assert.assertFalse(collectionRrpPage.isPreviousButtonPanelItemsDisplayed());
                Assert.assertTrue(collectionRrpPage.isNextButtonPanelItemsDisplayed());
                collectionRrpPage.clickNextButtonPanelItems();
                Assert.assertTrue(collectionRrpPage.isPreviousButtonPanelItemsDisplayed());
                Assert.assertFalse(collectionRrpPage.isNextButtonPanelItemsDisplayed());
            }
            if (collectionRrpPage.getCollectionItemsCount() <= 4) {
                Assert.assertFalse(collectionRrpPage.isPreviousButtonPanelItemsDisplayed() && collectionRrpPage.isNextButtonPanelItemsDisplayed());
            }
            if (collectionRrpPage.getCollectionItemsCount() >= 9) {
                Assert.assertFalse(collectionRrpPage.isPreviousButtonPanelItemsDisplayed());
                Assert.assertTrue(collectionRrpPage.isNextButtonPanelItemsDisplayed());
                collectionRrpPage.clickNextButtonPanelItems();
                Assert.assertTrue(collectionRrpPage.isPreviousButtonPanelItemsDisplayed() && collectionRrpPage.isNextButtonPanelItemsDisplayed());
            }
        }
    }

    public void testStepOneModal(){
        stepOneModal.waitForModal();
        Assert.assertEquals(stepOneModal.getTitleText(), TestData.STEP_ONE_MODAL_TITLE);
        stepOneModal.clickCloseModal();
    }

    public void testStepOnePage(){
        discoverResourcesPage.waitForNewTab();
        discoverResourcesPage.focusDriverToLastTab();
        discoverResourcesPage.waitForLinkToLoad();
        Assert.assertEquals(stepOnePage.getTitleText(), TestData.STEP_ONE_PAGE_TITLE);
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
    }

    public void testSignInPage(){
        discoverResourcesPage.waitForLinkToLoad();
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.LOGIN_PAGE_PATH));
        Assert.assertEquals(signInPage.getTitleText(), TestData.SIGN_IN_MODAL_TITLE_TEXT);
    }

    public void testSharedResourceUrl(){
        discoverResourcesPage.waitForNewTab();
        discoverResourcesPage.focusDriverToLastTab();
        discoverResourcesPage.waitForLinkToLoad();
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.STAGING_SERVER_SHARED_RESOURCE_URL));
        discoverResourcesPage.closeTab();
    }

    public void testResourceGetFreeAccessForTenDaysButton(boolean modal) {
        if(modal){
            rrpModal.waitForModal();
            rrpModal.clickGetFreeAccessForTenDaysButton(false);
            testStepOneModal();
            rrpModal.clickGetFreeAccessForTenDaysButton(true);
            testStepOnePage();
        } else{
            rrpPage.clickGetFreeAccessForTenDaysButton(false);
            testStepOneModal();
            rrpPage.clickGetFreeAccessForTenDaysButton(true);
            testStepOnePage();
        }
    }

    public void testFavoriteButton(boolean modal) {
        if(modal){
            rrpModal.waitForModal();
            rrpModal.clickVisitorFavoriteButton();
            Assert.assertTrue(rrpModal.isSignInPopupLinkDisplayed() && rrpModal.isJoinNowPopupLinkDisplayed());
            rrpModal.clickJoinNowPopupLink();
            testStepOneModal();
            rrpModal.clickVisitorFavoriteButton();
            rrpModal.clickSignInPopupLink(true);
            testSignInPage();
        } else{
            rrpPage.clickVisitorFavoriteButton();
            Assert.assertTrue(rrpPage.isSignInPopupLinkDisplayed() && rrpPage.isJoinNowPopupLinkDisplayed());
            rrpPage.clickJoinNowPopupLink();
            testStepOneModal();
            rrpPage.clickVisitorFavoriteButton();
            rrpPage.clickSignInPopupLink(true);
            testSignInPage();
        }
    }

    public void testRegularResourceRRPNavigationButtonsSearchPage() {
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

    public void testThumbnail(boolean modal, boolean regularResource) {
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

    public void testGoToResourceButton(boolean modal) {
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

    public void testSharedResourceRRPNavigationButtonsSearchPage() {
        Assert.assertTrue(rrpModal.getModalId().contains(discoverResourcesPage.getSharedResourceCardDataId(0)));
        if(discoverResourcesPage.getResourceCardDataType(0).equals(TestData.REGULAR_RESOURCE_TYPE)) {
            Assert.assertTrue(rrpModal.isPreviousButtonDisplayed());
        } else {
            Assert.assertFalse(rrpModal.isPreviousButtonDisplayed());
        }
        Assert.assertTrue(rrpModal.isNextButtonDisplayed());
        rrpModal.clickNextButton();
        Assert.assertTrue(rrpModal.getModalId().contains(discoverResourcesPage.getSharedResourceCardDataId(1)));
        rrpModal.clickPreviousButton();
        Assert.assertTrue(rrpModal.getModalId().contains(discoverResourcesPage.getSharedResourceCardDataId(0)));
    }

    public void testCollectionGetFreeAccessForTenDaysButton(boolean modal) {
        if(modal){
            collectionRrpModal.waitForModal();
            collectionRrpModal.clickGetFreeAccessForTenDaysButton(false);
            testStepOneModal();
            collectionRrpModal.clickGetFreeAccessForTenDaysButton(true);
            testStepOnePage();
        } else{
            collectionRrpPage.clickGetFreeAccessForTenDaysButton(false);
            testStepOneModal();
            collectionRrpPage.clickGetFreeAccessForTenDaysButton(true);
            testStepOnePage();
        }
    }

    public void testSaveCollectionButton(boolean modal) {
        if(modal){
            collectionRrpModal.waitForModal();
            collectionRrpModal.clickSaveCollectionButton();
            Assert.assertTrue(collectionRrpModal.isSignInPopupLinkDisplayed() && collectionRrpModal.isJoinNowPopupLinkDisplayed());
            collectionRrpModal.clickJoinNowPopupLink();
            testStepOneModal();
            collectionRrpModal.clickSaveCollectionButton();
            collectionRrpModal.clickSignInPopupLink(true);
            testSignInPage();
        } else{
            collectionRrpPage.clickSaveCollectionButton();
            Assert.assertTrue(collectionRrpPage.isSignInPopupLinkDisplayed() && collectionRrpPage.isJoinNowPopupLinkDisplayed());
            collectionRrpPage.clickJoinNowPopupLink();
            testStepOneModal();
            collectionRrpPage.clickSaveCollectionButton();
            collectionRrpPage.clickSignInPopupLink(true);
            testSignInPage();
        }
    }

    public void testCollectionRRPNavigationButtonsSearchPage() {
        collectionRrpModal.waitForModal();
        Assert.assertEquals(collectionRrpModal.getCollectionTitleText(), discoverResourcesPage.getCollectionCardTitle(0));
        collectionRrpModal.clickNextButtonRrp();
        Assert.assertEquals(collectionRrpModal.getCollectionTitleText(),discoverResourcesPage.getCollectionCardTitle(1));
        collectionRrpModal.clickPreviousButtonRrp();
        Assert.assertEquals(collectionRrpModal.getCollectionTitleText(),discoverResourcesPage.getCollectionCardTitle(0));
    }

    public void testItemViewerSection(boolean modal){
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

    public void testStartYourFreeTrialTryItFreeButton() {
        rrpPage.clickStartYourFreeTrialTryItFreeButton(false);
        testStepOneModal();
        rrpPage.clickStartYourFreeTrialTryItFreeButton(true);
        testStepOnePage();
    }

    public void testSeeSimilarResourcesTryItFreeButton() {
        rrpPage.clickBottomPageTryItFreeButton(false);
        testStepOneModal();
        rrpPage.clickBottomPageTryItFreeButton(true);
        testStepOnePage();
    }

    public void testSeeSimilarResourcesDropdown() {
        if (rrpPage.isSimilarResourcesHeaderDisplayed()) {
            rrpPage.clickAllResourceTypesDropdown();
            rrpPage.clickWorksheetsResourceType();
            Assert.assertEquals(rrpPage.getAllResourceTypesDropdownText(), TestData.WORKSHEETS_RESOURCE_TYPE);
            if(rrpPage.getAllSimilarResourceCardsNumber()>0){
                int count = 0;
                for (int i = 0; i < rrpPage.getAllSimilarResourceCardsNumber(); i++) {
                    if (rrpPage.getSimilarResourceCardResourceTypeText(i).equals('"' + TestData.WORKSHEET_RESOURCE_TYPE_CARD + '"')) {
                        count++;
                    }
                }
                Assert.assertTrue(count>=1);
            }
        } else{
            Assert.assertEquals(rrpPage.getSimilarResourcesListText(), TestData.NO_RESOURCES_FOUND_TEXT);
        }
    }
}
