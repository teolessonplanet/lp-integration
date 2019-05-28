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
    private UpgradeMaxItemsCollectionModal upgradeMaxItemsCollectionModal;
    private LoginPage loginPage;
    private CreateNewCollectionModal createNewCollectionModal;
    private UpgradeMaxCollectionModal upgradeMaxCollectionModal;
    private DirectoryCategoriesAndSubcategoriesTest directoryCategoriesAndSubcategoriesTest;
    private LpHomePage lpHomePage;
    private CurriculumManagerTest curriculumManagerTest;

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
        upgradeMaxItemsCollectionModal = new UpgradeMaxItemsCollectionModal(webDriver);
        loginPage = new LoginPage(webDriver);
        createNewCollectionModal = new CreateNewCollectionModal(webDriver);
        upgradeMaxCollectionModal = new UpgradeMaxCollectionModal(webDriver);
        directoryCategoriesAndSubcategoriesTest = new DirectoryCategoriesAndSubcategoriesTest();
        lpHomePage = new LpHomePage(webDriver);
        curriculumManagerTest = new CurriculumManagerTest();
    }

    public void reachRRP(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Visitor: [RRP Modal - RRP Overview]: lessonp-467: Resource Modal Overview")
    public void testLessonp_467() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        testRegularResourceRRPOverview(true, TestData.INVALID_EMAIL);
    }

    @Test(description = "Visitor : [RRP Modal - RRP Overview] - lessonp-1282: Shared Resource Modal Overview")
    public void testLessonp_1282() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(false);
        testSharedResourceRRPOverview(true, TestData.INVALID_EMAIL);
    }

    @Test(description = "Visitor : [RRP Modal - RRP Overview] - lessonp-468: Collection Modal Overview")
    public void testLessonp_468() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        testCollectionRRPOverview(true, TestData.INVALID_EMAIL);
        testPanelItemsOverview(true);
    }

    @Test(description = "Visitor: [RRP Static - RRP Overview]: lessonp-475: Resource Static Page Overview")
    public void testLessonp_475() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testRegularResourceRRPOverview(false, TestData.INVALID_EMAIL);
        testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE, TestData.INVALID_EMAIL);
        testSimilarResourcesSectionOverview(TestData.INVALID_EMAIL);
    }

    @Test(description = "Visitor - RRP Static  - RRP Overview ]: lessonp-944: Shared Resource Static Page Overview")
    public void testLessonp_944() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        testSharedResourceRRPOverview(false, TestData.INVALID_EMAIL);
        testWhatMembersSayWidgetOverview(TestData.INVALID_EMAIL);
        testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_SHARED_RESOURCE, TestData.INVALID_EMAIL);
        testSimilarResourcesSectionOverview(TestData.INVALID_EMAIL);
    }

    @Test(description = "Visitor - RRP Static  - RRP Overview ]: lessonp-476: Collection Static Page Overview")
    public void testLessonp_476() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        testCollectionRRPOverview(false, TestData.INVALID_EMAIL);
        testPanelItemsOverview(false);
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - LP Resources]: lessonp-469: Main buttons")
    public void testLessonp_469() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        testFavoriteButton(true);
        testResourceGetFreeAccessForTenDaysButton(true);
        testThumbnail(true, true, TestData.INVALID_EMAIL);
        testRegularResourceRRPNavigationButtonsSearchPage();
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - Shared Resources]: lessonp-1254: Main buttons")
    public void testLessonp_1254() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(false);
        testFavoriteButton(true);
        testGoToResourceButton(true, TestData.INVALID_EMAIL);
        testThumbnail(true, false, TestData.INVALID_EMAIL);
        testSharedResourceRRPNavigationButtonsSearchPage();
    }

    @Test(description = "Visitor: [RRP Modal - RRP Buttons - Collections]: lessonp-473: Main buttons")
    public void testLessonp_473() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        testSaveCollectionButton(true, TestData.INVALID_EMAIL);
        testCollectionGetFreeAccessForTenDaysButton(true);
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
        testResourceGetFreeAccessForTenDaysButton(false);
        testThumbnail(false, true, TestData.INVALID_EMAIL);
        testStartYourFreeTrialTryItFreeButton();
        testSeeSimilarResourcesDropdown();
        testSeeSimilarResourcesTryItFreeButton();
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - Shared Resources]: lessonp-4608: Main Buttons")
    public void testLessonp_4608() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        testGoToResourceButton(false, TestData.INVALID_EMAIL);
        testThumbnail(false, false, TestData.INVALID_EMAIL);
        testStartYourFreeTrialTryItFreeButton();
        directoryCategoriesAndSubcategoriesTest.reachDirectoryCategoriesAndSubcategoriesPage(webDriver);
        directoryCategoriesAndSubcategoriesTest.testTestimonials(TestData.INVALID_EMAIL);
        discoverResourcesPage.closeTab();
        testSeeSimilarResourcesDropdown();
        testSeeSimilarResourcesTryItFreeButton();
    }

    @Test(description = "Visitor: [RRP Static - RRP Buttons - Collections]: lessonp-4609: Main buttons")
    public void testLessonp_4609() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        testSaveCollectionButton(false, TestData.INVALID_EMAIL);
        testCollectionGetFreeAccessForTenDaysButton(false);
        collectionRrpPage.clickPanelItem(0);
        testItemViewerSection(false);
        collectionRrpPage.clickSeeFullReviewsLink();
        testItemViewerSection(false);
    }

    @Test(description = "Freemium: [RRP Modal - RRP Overview]: lessonp-523: Resource Modal Overview")
    public void testLessonp_523() {
        createAFreeMemberAccount();
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        testRegularResourceRRPOverview(true, TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Freemium: [RRP Modal - RRP Overview]: lessonp-535: Free Sample Modal Overview")
    public void testLessonp_535() {
        createAFreeMemberAccount();
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickFreeFullAccessReview(false);
        testFreeSampleResourceRRPOverview(true);
    }

    @Test(description = "Freemium : [RRP Modal - RRP Overview] - lessonp-952: Shared Resource Modal Overview")
    public void testLessonp_952() {
        createAFreeMemberAccount();
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(false);
        testSharedResourceRRPOverview(true, TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Freemium : [RRP Modal - RRP Overview] - lessonp-524: Collection Modal Overview")
    public void testLessonp_524() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        testCollectionRRPOverview(true, TestData.VALID_EMAIL_FREEMIUM);
        testPanelItemsOverview(true);
    }

    @Test(description = "Freemium: [RRP Static - RRP Overview]: lessonp-515: Resource Static Page Overview")
    public void testLessonp_515() {
        createAFreeMemberAccount();
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testRegularResourceRRPOverview(false, TestData.VALID_EMAIL_FREEMIUM);
        testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE, TestData.VALID_EMAIL_FREEMIUM);
        testSimilarResourcesSectionOverview(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Freemium: [RRP Static - RRP Overview]: lessonp-531: Free Sample Static Page Overview")
    public void testLessonp_531() {
        createAFreeMemberAccount();
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickFreeFullAccessReview(true);
        testFreeSampleResourceRRPOverview(false);
        testFreeSampleResourceStartYourFreeTrialWidgetOverview();
        testWhatMembersSayWidgetOverview(TestData.VALID_EMAIL_FREEMIUM);
        testSimilarResourcesSectionOverview(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Freemium - RRP Static  - RRP Overview ]: lessonp-950: Shared Resource Static Page Overview")
    public void testLessonp_950() {
        createAFreeMemberAccount();
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        testSharedResourceRRPOverview(false, TestData.VALID_EMAIL_FREEMIUM);
        testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_SHARED_RESOURCE, TestData.VALID_EMAIL_FREEMIUM);
        testWhatMembersSayWidgetOverview(TestData.VALID_EMAIL_FREEMIUM);
        testSimilarResourcesSectionOverview(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Freemium - RRP Static  - RRP Overview ]: lessonp-516: Collection Static Page Overview")
    public void testLessonp_516() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        testCollectionRRPOverview(false, TestData.VALID_EMAIL_FREEMIUM);
        testPanelItemsOverview(false);
    }

    @Test(description = "Freemium: [RRP Modal - RRP Buttons - LP Resources]: lessonp-4664: Main buttons")
    public void testLessonp_4664() {
        createAFreeMemberAccount();
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        testResourceUpgradeForFullReviewButton(true);
        testRegularResourceRRPNavigationButtonsSearchPage();
        testAddToCollectionDropdown(true);
        testThumbnail(true, true, TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Freemium: [RRP Modal - RRP Buttons - FreeSample Resources]: lessonp-4663: Main buttons")
    public void testLessonp_4663() {
        createAFreeMemberAccount();
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickFreeFullAccessReview(false);
        testThumbnail(true, false, TestData.VALID_EMAIL_FREEMIUM);
        testGoToResourceButton(true, TestData.VALID_EMAIL_FREEMIUM);
        testFreeResourceRRPNavigationButtonsSearchPage();
        testAddToCollectionDropdown(true);
    }

    @Test(description = "Freemium: [RRP Modal - RRP Buttons - Shared Resources]: lessonp-4666: Main buttons")
    public void testLessonp_4666() {
        createAFreeMemberAccount();
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(false);
        testThumbnail(true, false, TestData.VALID_EMAIL_FREEMIUM);
        testSharedResourceRRPNavigationButtonsSearchPage();
        testAddToCollectionDropdown(true);
        testGoToResourceButton(true, TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Freemium: [RRP Modal - RRP Buttons - Collections]: lessonp-4667: Main buttons")
    public void testLessonp_4667() {
        createAFreeMemberAccount();
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        collectionRrpModal.clickPanelItem(0);
        testItemViewerSection(true);
        collectionRrpModal.clickSeeFullReviewsLink();
        testItemViewerSection(true);
        collectionRrpModal.clickPlayCollectionButton();
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testCurriculumPlayerURL();
        testCollectionRRPNavigationButtonsSearchPage();
        testCollectionUpgradeForFullReviewButton(true);
        testSaveCollectionButton(true, TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Freemium: [RRP Static - RRP Buttons - LP Resources]: lessonp-4670: Main buttons")
    public void testLessonp_4670() {
        createAFreeMemberAccount();
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testThumbnail(false, true, TestData.VALID_EMAIL_FREEMIUM);
        testAddToCollectionDropdown(false);
        testResourceUpgradeForFullReviewButton(false);
        testSeeSimilarResourcesDropdown();
        testSeeSimilarResourcesUpgradeMeButton();
        testStartYourFreeTrialUpgradeMeButton();
    }

    @Test(description = "Freemium: [RRP Static - RRP Buttons - FreeSample Resources]: lessonp-4669: Main buttons")
    public void testLessonp_4669() {
        createAFreeMemberAccount();
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickFreeFullAccessReview(true);
        testThumbnail(false, false, TestData.VALID_EMAIL_FREEMIUM);
        testGoToResourceButton(false, TestData.VALID_EMAIL_FREEMIUM);
        testAddToCollectionDropdown(false);
        testSeeSimilarResourcesDropdown();
        testSeeSimilarResourcesUpgradeMeButton();
        testFreeSampleStartYourFreeTrialUpgradeMeButton();
        directoryCategoriesAndSubcategoriesTest.reachDirectoryCategoriesAndSubcategoriesPage(webDriver);
        directoryCategoriesAndSubcategoriesTest.testTestimonials(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Freemium: [RRP Static - RRP Buttons - Shared Resources]: lessonp-4671: Main Buttons")
    public void testLessonp_4671() {
        createAFreeMemberAccount();
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        testThumbnail(false, false, TestData.VALID_EMAIL_FREEMIUM);
        testAddToCollectionDropdown(false);
        testGoToResourceButton(false,  TestData.VALID_EMAIL_FREEMIUM);
        testSeeSimilarResourcesDropdown();
        testSeeSimilarResourcesUpgradeMeButton();
        testStartYourFreeTrialUpgradeMeButton();
        directoryCategoriesAndSubcategoriesTest.reachDirectoryCategoriesAndSubcategoriesPage(webDriver);
        directoryCategoriesAndSubcategoriesTest.testTestimonials(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Freemium: [RRP Static - RRP Buttons - Collections]: lessonp-4668: Main buttons")
    public void testLessonp_4668() {
        createAFreeMemberAccount();
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        collectionRrpPage.clickPanelItem(0);
        testItemViewerSection(false);
        collectionRrpPage.clickSeeFullReviewsLink();
        testItemViewerSection(false);
        collectionRrpPage.clickPlayCollectionButton();
        curriculumManagerTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerTest.testCurriculumPlayerURL();
        testCollectionUpgradeForFullReviewButton(false);
        testSaveCollectionButton(false, TestData.VALID_EMAIL_FREEMIUM);
    }

    public void createAFreeMemberAccount() {
        lpHomePage.loadPage();
        stepOnePage.completeStepOne(TestData.GET_NEW_EMAIL(), TestData.VALID_PASSWORD);
    }

    public void testRegularResourceRRPOverview(boolean modal, String account) {
        if (modal) {
            rrpModal.waitForModal();
            Assert.assertTrue(rrpModal.isTitleDisplayed());
            Assert.assertTrue(rrpModal.isDescriptionDisplayed());
            Assert.assertTrue(rrpModal.isNumberOfViewsDisplayed());
            Assert.assertTrue(rrpModal.isNumberOfDownloadsDisplayed());
            Assert.assertTrue(rrpModal.isConceptsTagsListDisplayed());
            Assert.assertTrue(rrpModal.isReviewerRatingDisplayed());
            if (account.equals(TestData.INVALID_EMAIL)) {
                Assert.assertTrue(rrpModal.isGetFreeAccessForTenDaysButtonDisplayed());
                Assert.assertTrue(rrpModal.isLimitedAccessReviewDisplayed());
                Assert.assertTrue(rrpModal.isVisitorFavoriteButtonDisplayed());
            }
            if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
                Assert.assertTrue(rrpModal.isUpgradeForFullReviewButtonDisplayed());
                Assert.assertTrue(rrpModal.isLimitedAccessReviewDisplayed());
                Assert.assertTrue(rrpModal.isFavoriteButtonDisplayed());
                Assert.assertTrue(rrpModal.isAddToCollectionDropdownDisplayed());
                Assert.assertTrue(rrpModal.isAddACommentLinkDisplayed());
                rrpModal.clickAddACommentLink();
                Assert.assertEquals(rrpModal.getUserConversationPanelText(), TestData.ADD_A_COMMENT_PANEL_TEXT);
                Assert.assertTrue(rrpModal.isAddACommentButtonDisplayed());
            }
            Assert.assertTrue(rrpModal.isShareButtonDisplayed());
            Assert.assertTrue(rrpModal.isThumbnailDisplayed());
            if (rrpModal.isLeftSectionBlankDisplayed()) {
                Assert.assertTrue(rrpModal.isLightRrpGradeDisplayed());
                Assert.assertEquals(rrpModal.getLightRrpGradeNumber(), 1);
                if (account.equals(TestData.INVALID_EMAIL) || account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
                    Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpModal.getLightRrpSubjectText().get(0)));
                    if (rrpModal.getLightRrpSubjectsNumber() > 1) {
                        Assert.assertTrue(rrpModal.getLightRrpSubjectText().get(1).contains(TestData.DISABLED_TEXT));
                    }
                    Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpModal.getLightRrpResourceTypeText().get(0)));
                    if (rrpModal.getLightRrpResourceTypeNumber() > 1) {
                        Assert.assertTrue(rrpModal.getLightRrpResourceTypeText().get(1).contains(TestData.DISABLED_TEXT));
                    }
                }
            } else {
                Assert.assertTrue(rrpModal.isFullRrpGradeDisplayed());
                if (account.equals(TestData.INVALID_EMAIL) || account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
                    Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpModal.getFullRrpSubjectText().get(0)));
                    if (rrpModal.getFullRrpSubjectsNumber() > 1) {
                        Assert.assertTrue(rrpModal.getFullRrpSubjectText().get(1).contains(TestData.DISABLED_TEXT));
                    }
                    Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpModal.getFullRrpResourceTypeText().get(0)));
                    if (rrpModal.getFullRrpResourceTypeNumber() > 1) {
                        Assert.assertTrue(rrpModal.getFullRrpResourceTypeText().get(1).contains(TestData.DISABLED_TEXT));
                    }
                }
            }
        } else {
            Assert.assertTrue(rrpPage.isTitleDisplayed());
            Assert.assertTrue(rrpPage.isDescriptionDisplayed());
            Assert.assertTrue(rrpPage.isNumberOfViewsDisplayed());
            Assert.assertTrue(rrpPage.isNumberOfDownloadsDisplayed());
            Assert.assertTrue(rrpPage.isConceptsTagsListDisplayed());
            Assert.assertTrue(rrpPage.isReviewerRatingDisplayed());
            if (account.equals(TestData.INVALID_EMAIL)) {
                Assert.assertTrue(rrpPage.isGetFreeAccessForTenDaysButtonDisplayed());
                Assert.assertTrue(rrpPage.isLimitedAccessReviewDisplayed());
                Assert.assertTrue(rrpPage.isVisitorFavoriteButtonDisplayed());
            }
            if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
                Assert.assertTrue(rrpPage.isUpgradeForFullReviewButtonDisplayed());
                Assert.assertTrue(rrpPage.isLimitedAccessReviewDisplayed());
                Assert.assertTrue(rrpPage.isFavoriteButtonDisplayed());
                Assert.assertTrue(rrpPage.isAddToCollectionDropdownDisplayed());
                Assert.assertTrue(rrpPage.isAddACommentLinkDisplayed());
                rrpPage.clickAddACommentLink();
                Assert.assertEquals(rrpPage.getUserConversationPanelText(), TestData.ADD_A_COMMENT_PANEL_TEXT);
                Assert.assertTrue(rrpPage.isAddACommentButtonDisplayed());
            }
            Assert.assertTrue(rrpPage.isShareButtonDisplayed());
            Assert.assertTrue(rrpPage.isThumbnailDisplayed());
            Assert.assertFalse(rrpPage.isPreviousButtonDisplayed());
            if (rrpPage.isLeftSectionBlankDisplayed()) {
                Assert.assertTrue(rrpPage.isLightRrpGradeDisplayed());
                Assert.assertEquals(rrpPage.getLightRrpGradeNumber(), 1);
                if (account.equals(TestData.INVALID_EMAIL) || account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
                    Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpPage.getLightRrpSubjectText().get(0)));
                    if(rrpPage.getLightRrpSubjectsNumber()>1){
                        Assert.assertTrue((rrpPage.getLightRrpSubjectText().get(1)).contains(TestData.DISABLED_TEXT));
                    }
                    Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpPage.getLightRrpResourceTypeText().get(0)));
                    if(rrpPage.getLightRrpResourceTypeNumber()>1){
                        Assert.assertTrue((rrpPage.getLightRrpResourceTypeText().get(1)).contains(TestData.DISABLED_TEXT));
                    }
                }
            } else {
                Assert.assertTrue(rrpPage.isFullRrpGradeDisplayed());
                Assert.assertEquals(rrpPage.getFullRrpGradeNumber(), 1);
                if (account.equals(TestData.INVALID_EMAIL) || account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
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
    }

    public void testStartYourFreeTrialWidgetOverview(String widgetText, String account) {
        Assert.assertTrue(rrpPage.isStartYourFreeTrialWidgetDisplayed());
        Assert.assertEquals(rrpPage.getStartYourFreeTrialText(), widgetText);
        if (account.equals(TestData.INVALID_EMAIL)) {
            Assert.assertTrue(rrpPage.isStartYourFreeTrialTryItFreeButtonDisplayed());
        }
        if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
            Assert.assertTrue(rrpPage.isStartYourFreeTrialUpgradeMeButtonDisplayed());
        }
    }

    public void testSimilarResourcesSectionOverview(String account) {
        if(rrpPage.isSimilarResourcesSectionDisplayed()) {
            Assert.assertTrue(rrpPage.isSimilarResourcesHeaderDisplayed());
            Assert.assertTrue(rrpPage.isSimilarResourcesListDisplayed());
            Assert.assertTrue(rrpPage.isAllResourceTypesDropdownDisplayed());
            rrpPage.clickAllResourceTypesDropdown();
            Assert.assertEquals(rrpPage.getAllResourceTypesFromDropdown(), TestData.ALL_RESOURCE_TYPES_DROPDOWN);
        }
        if (account.equals(TestData.INVALID_EMAIL)) {
            Assert.assertTrue(rrpPage.isBottomPageTryItFreeButtonDisplayed());
        }
        if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
            Assert.assertTrue(rrpPage.isBottomPageUpgradeMeButtonDisplayed());
        }
    }

    public void testWhatMembersSayWidgetOverview(String account){
        Assert.assertTrue(whatMembersSayWidget.isWidgetDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isTestimonialTextDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isMemberPhotoDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isSeeMoreTestimonialsLinkDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isSubmitYourOwnLinkDisplayed());
        if (!account.equals(TestData.VALID_EMAIL_ADMIN)) {
            Assert.assertTrue(whatMembersSayWidget.isSubscriptionButtonDisplayed());
        }
    }

    public void testSharedResourceRRPOverview(boolean modal, String account) {
        if(modal){
            rrpModal.waitForModal();
            Assert.assertTrue(rrpModal.isTitleDisplayed());
            Assert.assertTrue(rrpModal.isDescriptionDisplayed());
            Assert.assertTrue(rrpModal.isNumberOfDownloadsDisplayed());
            Assert.assertTrue(rrpModal.isNumberOfViewsDisplayed());
            Assert.assertFalse(rrpModal.isAddACommentLinkDisplayed());
            for(int i=0; i<rrpModal.getLightRrpSubjectsNumber(); i++){
                Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpModal.getLightRrpSubjectText().get(i)));
            }
            for(int i=1; i<rrpModal.getLightRrpResourceTypeNumber(); i++){
                Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpModal.getLightRrpResourceTypeText().get(i)));
            }
            Assert.assertTrue(rrpModal.isGoToResourceButtonDisplayed());
            Assert.assertTrue(rrpModal.isShareButtonDisplayed());
            Assert.assertTrue(rrpModal.isThumbnailDisplayed());
            Assert.assertTrue(rrpModal.isLightRrpGradeDisplayed());
            Assert.assertEquals(rrpModal.getLightRrpGradeNumber(), 1);
            if (account.equals(TestData.INVALID_EMAIL)) {
                Assert.assertTrue(rrpModal.isVisitorFavoriteButtonDisplayed());
            } else {
                Assert.assertTrue(rrpModal.isFavoriteButtonDisplayed());
            }
        } else{
            Assert.assertTrue(rrpPage.isTitleDisplayed());
            Assert.assertTrue(rrpPage.isDescriptionDisplayed());
            Assert.assertTrue(rrpPage.isNumberOfDownloadsDisplayed());
            Assert.assertTrue(rrpPage.isNumberOfViewsDisplayed());
            Assert.assertFalse(rrpPage.isAddACommentLinkDisplayed());
            for(int i=0; i<rrpPage.getLightRrpSubjectsNumber(); i++){
                Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpPage.getLightRrpSubjectText().get(i)));
            }
            for(int i=0; i<rrpPage.getLightRrpResourceTypeNumber(); i++){
                Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpPage.getLightRrpResourceTypeText().get(i)));
            }
            Assert.assertTrue(rrpPage.isGoToResourceButtonDisplayed());
            Assert.assertTrue(rrpPage.isShareButtonDisplayed());
            Assert.assertTrue(rrpPage.isThumbnailDisplayed());
            Assert.assertFalse(rrpPage.isPreviousButtonDisplayed());
            Assert.assertFalse(rrpPage.isNextButtonDisplayed());
            Assert.assertTrue(rrpPage.isLightRrpGradeDisplayed());
            Assert.assertEquals(rrpPage.getLightRrpGradeNumber(), 1);
            if (account.equals(TestData.INVALID_EMAIL)) {
                Assert.assertTrue(rrpPage.isVisitorFavoriteButtonDisplayed());
            } else {
                Assert.assertTrue(rrpPage.isFavoriteButtonDisplayed());
            }
        }
    }

    public void testCollectionRRPOverview(boolean modal, String account) {
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
            Assert.assertFalse(collectionRrpModal.isLimitedAccessReviewDisplayed());
            if (account.equals(TestData.INVALID_EMAIL)) {
                Assert.assertTrue(collectionRrpModal.isGetFreeAccessForTenDaysButtonDisplayed());
                Assert.assertTrue(collectionRrpModal.isSaveCollectionButtonDisplayed());
            }
            if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
                Assert.assertTrue(collectionRrpModal.isUpgradeForFullReviewButtonDisplayed());
                Assert.assertTrue(collectionRrpModal.isPlayCollectionButtonDisplayed());
                Assert.assertTrue(collectionRrpModal.isSaveCollectionButtonActiveUserDisplayed());
            }
            Assert.assertTrue(collectionRrpModal.isShareButtonDisplayed());
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
            Assert.assertFalse(collectionRrpPage.isLimitedAccessReviewDisplayed());
            if (account.equals(TestData.INVALID_EMAIL)) {
                Assert.assertTrue(collectionRrpPage.isGetFreeAccessForTenDaysButtonDisplayed());
                Assert.assertTrue(collectionRrpPage.isSaveCollectionButtonDisplayed());
            }
            if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
                Assert.assertTrue(collectionRrpPage.isUpgradeForFullReviewButtonDisplayed());
                Assert.assertTrue(collectionRrpPage.isPlayCollectionButtonDisplayed());
                Assert.assertTrue(collectionRrpPage.isSaveCollectionButtonActiveUserDisplayed());
            }
            Assert.assertTrue(collectionRrpPage.isShareButtonDisplayed());
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

    public void testSignInPage(){
        discoverResourcesPage.waitForLinkToLoad();
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.LOGIN_PAGE_PATH));
        Assert.assertEquals(signInPage.getTitleText(), TestData.SIGN_IN_MODAL_TITLE_TEXT);
        discoverResourcesPage.closeTab();
    }

    public void testNewTabUrl(String url){
        discoverResourcesPage.waitForNewTab();
        discoverResourcesPage.focusDriverToLastTab();
        discoverResourcesPage.waitForLinkToLoad();
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(url));
        discoverResourcesPage.closeTab();
    }

    public void testPageUrl(String url){
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(url));
        discoverResourcesPage.goBackOnePage();
    }

    public void testResourceGetFreeAccessForTenDaysButton(boolean modal) {
        if(modal){
            rrpModal.waitForModal();
            rrpModal.clickGetFreeAccessForTenDaysButton(false);
            testStepOneModal();
            rrpModal.clickGetFreeAccessForTenDaysButton(true);
            testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
        } else{
            rrpPage.clickGetFreeAccessForTenDaysButton(false);
            testStepOneModal();
            rrpPage.clickGetFreeAccessForTenDaysButton(true);
            testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
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

    public void testThumbnail(boolean modal, boolean regularResource, String account) {
        if(modal){
            rrpModal.waitForModal();
            rrpModal.clickOnThumbnail();
            if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
                if (regularResource) {
                    testPageUrl(TestData.STEP_ONE_PAGE_PATH);
                } else {
                    if (rrpModal.isFreeSampleDisplayed()) {
                        testNewTabUrl(TestData.STAGING_SERVER_SHARED_RESOURCE_URL_2);
                    } else {
                        testNewTabUrl(TestData.STAGING_SERVER_SHARED_RESOURCE_URL);
                    }
                }
            }
        } else {
            rrpPage.clickOnThumbnail();
            if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
                if (regularResource) {
                    testPageUrl(TestData.STEP_ONE_PAGE_PATH);
                } else {
                    if (rrpPage.isFreeSampleDisplayed()) {
                        testNewTabUrl(TestData.STAGING_SERVER_SHARED_RESOURCE_URL_2);
                    } else {
                        testNewTabUrl(TestData.STAGING_SERVER_SHARED_RESOURCE_URL);
                    }
                }
            }
        }
        if (account.equals(TestData.INVALID_EMAIL)) {
            if(regularResource){
                testStepOneModal();
            }else{
                testNewTabUrl(TestData.STAGING_SERVER_SHARED_RESOURCE_URL);
            }
        }
    }

    public void testGoToResourceButton(boolean modal, String account) {
        if(modal){
            rrpModal.waitForModal();
            if (account.equals(TestData.INVALID_EMAIL)) {
                rrpModal.clickGoToResourceButton(true);
                testNewTabUrl(TestData.STAGING_SERVER_SHARED_RESOURCE_URL);
            }
            if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
                if (rrpModal.isFreeSampleDisplayed()) {
                    rrpModal.clickGoToResourceButton(true);
                    testNewTabUrl(TestData.STAGING_SERVER_SHARED_RESOURCE_URL_2);
                } else {
                    rrpModal.clickGoToResourceButton(true);
                    testNewTabUrl(TestData.STAGING_SERVER_SHARED_RESOURCE_URL);
                }
            }
        } else {
            if (account.equals(TestData.INVALID_EMAIL)) {
                rrpPage.clickGoToResourceButton(true);
                testNewTabUrl(TestData.STAGING_SERVER_SHARED_RESOURCE_URL);
            }
            if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
                if (rrpPage.isFreeSampleDisplayed()) {
                    rrpPage.clickGoToResourceButton(true);
                    testNewTabUrl(TestData.STAGING_SERVER_SHARED_RESOURCE_URL_2);
                } else {
                    rrpPage.clickGoToResourceButton(true);
                    testNewTabUrl(TestData.STAGING_SERVER_SHARED_RESOURCE_URL);
                }
            }
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
            testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
        } else{
            collectionRrpPage.clickGetFreeAccessForTenDaysButton(false);
            testStepOneModal();
            collectionRrpPage.clickGetFreeAccessForTenDaysButton(true);
            testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
        }
    }

    public void testCollectionUpgradeForFullReviewButton(boolean modal) {
        if(modal){
            collectionRrpModal.waitForModal();
            collectionRrpModal.clickCollectionUpgradeForFullReviewButton(true);
            testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
        } else {
            collectionRrpPage.clickCollectionUpgradeForFullReviewButton(false);
            testPageUrl(TestData.STEP_ONE_PAGE_PATH);
            collectionRrpPage.clickCollectionUpgradeForFullReviewButton(true);
            testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
        }
    }

    public void testSaveCollectionButton(boolean modal, String account) {
        if (modal) {
            collectionRrpModal.waitForModal();
            if (account.equals(TestData.INVALID_EMAIL)) {
                collectionRrpModal.clickSaveCollectionButton();
                Assert.assertTrue(collectionRrpModal.isSignInPopupLinkDisplayed() && collectionRrpModal.isJoinNowPopupLinkDisplayed());
                collectionRrpModal.clickJoinNowPopupLink();
                testStepOneModal();
                collectionRrpModal.clickSaveCollectionButton();
                collectionRrpModal.clickSignInPopupLink(true);
                testSignInPage();
            }
            if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
                collectionRrpModal.clickSaveCollectionButtonActiveUser();
                if (collectionRrpModal.getCollectionItemsCount() > 10) {
                    Assert.assertEquals(upgradeMaxItemsCollectionModal.getUpgradeModalText(), TestData.UPGRADE_MODAL_TEXT_FROM_EXCEEDED_ITEMS_INSIDE_SAVED_COLLECTION);
                }
                if (collectionRrpModal.getCollectionItemsCount() < 10) {
                    Assert.assertTrue(collectionRrpModal.isSavedCollectionNotificationDisplayed());
                }
            }
        } else{
            if (account.equals(TestData.INVALID_EMAIL)) {
                collectionRrpPage.clickSaveCollectionButton();
                Assert.assertTrue(collectionRrpPage.isSignInPopupLinkDisplayed() && collectionRrpPage.isJoinNowPopupLinkDisplayed());
                collectionRrpPage.clickJoinNowPopupLink();
                testStepOneModal();
                collectionRrpPage.clickSaveCollectionButton();
                collectionRrpPage.clickSignInPopupLink(true);
                testSignInPage();
            }
            if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
                collectionRrpPage.clickSaveCollectionButtonActiveUser();
                if (collectionRrpPage.getCollectionItemsCount() > 10) {
                    Assert.assertEquals(upgradeMaxItemsCollectionModal.getUpgradeModalText(), TestData.UPGRADE_MODAL_TEXT_FROM_EXCEEDED_ITEMS_INSIDE_SAVED_COLLECTION);
                }
                if (collectionRrpPage.getCollectionItemsCount() < 10) {
                    Assert.assertTrue(collectionRrpPage.isSavedCollectionNotificationDisplayed());
                }
            }
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
        testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
    }

    public void testSeeSimilarResourcesTryItFreeButton() {
        rrpPage.clickBottomPageTryItFreeButton(false);
        testStepOneModal();
        rrpPage.clickBottomPageTryItFreeButton(true);
        testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);;
    }

    public void testSeeSimilarResourcesDropdown() {
        if (rrpPage.isSimilarResourcesHeaderDisplayed()) {
            rrpPage.clickAllResourceTypesDropdown();
            rrpPage.clickLessonPlansResourceType();
            Assert.assertEquals(rrpPage.getAllResourceTypesDropdownText(), TestData.LESSON_PLANS_RESOURCE_TYPE);
            if(rrpPage.getAllSimilarResourceCardsNumber()>0){
                int count = 0;
                for (int i = 0; i < rrpPage.getAllSimilarResourceCardsNumber(); i++) {
                    if (rrpPage.getSimilarResourceCardResourceTypeText(i).equals('"' + TestData.LESSON_RESOURCE_TYPE_CARD + '"')) {
                        count++;
                    }
                }
                Assert.assertTrue(count>=1);
            }
        } else{
            Assert.assertEquals(rrpPage.getSimilarResourcesListText(), TestData.NO_RESOURCES_FOUND_TEXT);
        }
    }

    private void testFreeSampleResourceRRPOverview(boolean modal) {
        if (modal) {
            rrpModal.waitForModal();
            Assert.assertTrue(rrpModal.isTitleDisplayed());
            Assert.assertTrue(rrpModal.isDescriptionDisplayed());
            Assert.assertTrue(rrpModal.isNumberOfViewsDisplayed());
            Assert.assertTrue(rrpModal.isNumberOfDownloadsDisplayed());
            Assert.assertTrue(rrpModal.isConceptsTagsListDisplayed());
            Assert.assertTrue(rrpModal.isReviewerRatingDisplayed());
            Assert.assertTrue(rrpModal.isFavoriteButtonDisplayed());
            Assert.assertTrue(rrpModal.isAddToCollectionDropdownDisplayed());
            Assert.assertTrue(rrpModal.isGoToResourceButtonDisplayed());
            Assert.assertTrue(rrpModal.isAddACommentLinkDisplayed());
            rrpModal.clickAddACommentLink();
            Assert.assertEquals(rrpModal.getUserConversationPanelText(), TestData.ADD_A_COMMENT_PANEL_TEXT);
            Assert.assertTrue(rrpModal.isAddACommentButtonDisplayed());
            if (rrpModal.isLeftSectionBlankDisplayed()) {
                Assert.assertTrue(rrpModal.isLightRrpGradeDisplayed());
                Assert.assertEquals(rrpModal.getLightRrpGradeNumber(), 1);
                for (int i = 0; i < rrpModal.getLightRrpSubjectsNumber(); i++) {
                    Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpModal.getLightRrpSubjectText().get(i)));
                }
                for (int i = 1; i < rrpModal.getLightRrpResourceTypeNumber(); i++) {
                    Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpModal.getLightRrpResourceTypeText().get(i)));
                }

            } else {
                Assert.assertTrue(rrpModal.isFullRrpGradeDisplayed());
                for (int i = 0; i < rrpModal.getFullRrpSubjectsNumber(); i++) {
                    Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpModal.getFullRrpSubjectText().get(i)));
                }
                for (int i = 1; i < rrpModal.getFullRrpResourceTypeNumber(); i++) {
                    Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpModal.getFullRrpResourceTypeText().get(i)));
                }
            }
        } else {
            Assert.assertTrue(rrpPage.isTitleDisplayed());
            Assert.assertTrue(rrpPage.isDescriptionDisplayed());
            Assert.assertTrue(rrpPage.isNumberOfViewsDisplayed());
            Assert.assertTrue(rrpPage.isNumberOfDownloadsDisplayed());
            Assert.assertTrue(rrpPage.isConceptsTagsListDisplayed());
            Assert.assertTrue(rrpPage.isReviewerRatingDisplayed());
            Assert.assertTrue(rrpPage.isFavoriteButtonDisplayed());
            Assert.assertTrue(rrpPage.isAddToCollectionDropdownDisplayed());
            Assert.assertTrue(rrpPage.isGoToResourceButtonDisplayed());
            Assert.assertTrue(rrpPage.isAddACommentLinkDisplayed());
            rrpPage.clickAddACommentLink();
            Assert.assertEquals(rrpPage.getUserConversationPanelText(), TestData.ADD_A_COMMENT_PANEL_TEXT);
            Assert.assertTrue(rrpPage.isAddACommentButtonDisplayed());
            if (rrpPage.isLeftSectionBlankDisplayed()) {
                Assert.assertTrue(rrpPage.isLightRrpGradeDisplayed());
                Assert.assertEquals(rrpPage.getLightRrpGradeNumber(), 1);
                for (int i = 0; i < rrpPage.getLightRrpSubjectsNumber(); i++) {
                    Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpPage.getLightRrpSubjectText().get(i)));
                }
                for (int i = 1; i < rrpPage.getLightRrpResourceTypeNumber(); i++) {
                    Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpPage.getLightRrpResourceTypeText().get(i)));
                }

            } else {
                Assert.assertTrue(rrpPage.isFullRrpGradeDisplayed());
                Assert.assertEquals(rrpPage.getFullRrpGradeNumber(), 1);
                for (int i = 0; i < rrpPage.getFullRrpSubjectsNumber(); i++) {
                    Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrpPage.getFullRrpSubjectText().get(i)));
                }
                for (int i = 1; i < rrpPage.getFullRrpResourceTypeNumber(); i++) {
                    Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrpPage.getFullRrpResourceTypeText().get(i)));
                }
            }
        }
    }

    private void testFreeSampleResourceStartYourFreeTrialWidgetOverview() {
        Assert.assertTrue(rrpPage.isFreeSampleResourceStartYourFreeTrialWidgetDisplayed());
        Assert.assertTrue(rrpPage.isFreeSampleResourceStartYourFreeTrialUpgradeMeButtonDisplayed());
        Assert.assertEquals(rrpPage.getFreeSampleResourceStartYourFreeTrialText(), TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE);
    }

    private void testResourceUpgradeForFullReviewButton(boolean modal) {
        if (modal) {
            rrpModal.waitForModal();
            rrpModal.clickUpgradeForFullReviewButton(true);
            testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
        } else {
            rrpPage.clickUpgradeForFullReviewButton(false);
            testPageUrl(TestData.STEP_ONE_PAGE_PATH);
            rrpPage.clickUpgradeForFullReviewButton(true);
            testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
        }
    }

    private void testSeeSimilarResourcesUpgradeMeButton() {
        rrpPage.clickBottomPageUpgradeMeButton(false);
        testPageUrl(TestData.STEP_ONE_PAGE_PATH);
        rrpPage.clickBottomPageUpgradeMeButton(true);
        testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
    }

    private void testStartYourFreeTrialUpgradeMeButton() {
        rrpPage.clickStartYourFreeTrialUpgradeMeButton(false);
        testPageUrl(TestData.STEP_ONE_PAGE_PATH);
        rrpPage.clickStartYourFreeTrialUpgradeMeButton(true);
        testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
    }

    private void testFreeSampleStartYourFreeTrialUpgradeMeButton() {
        rrpPage.clickFreeSampleStartYourFreeTrialUpgradeMeButton(false);
        testPageUrl(TestData.STEP_ONE_PAGE_PATH);
        rrpPage.clickFreeSampleStartYourFreeTrialUpgradeMeButton(true);
        testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
    }

    private void testFreeResourceRRPNavigationButtonsSearchPage() {
        Assert.assertEquals(rrpModal.getTitleText(), discoverResourcesPage.getFreeSampleResourceCardTitle(0));
        Assert.assertTrue(rrpModal.isNextButtonDisplayed());
        rrpModal.clickNextButton();
        int freeSampleResourcePosition = discoverResourcesPage.getFreeSampleResourcePosition();
        System.out.println(freeSampleResourcePosition);
        Assert.assertTrue(rrpModal.getModalId().contains(discoverResourcesPage.getRegularResourceCardDataId(freeSampleResourcePosition + 1)));
        rrpModal.clickPreviousButton();
        Assert.assertTrue((rrpModal.getTitleText().contains(discoverResourcesPage.getFreeSampleResourceCardTitle(0))));
    }

    private void testAddToNewCollection(boolean modal){
        if(modal){
            rrpModal.clickOnAddToCollectionDropdown();
            rrpModal.clickAddToNewCollection();
        }else{
            rrpPage.clickOnAddToCollectionDropdown();
            rrpPage.clickAddToNewCollection();
        }
        createNewCollectionModal.typeName(TestData.NEW_COLLECTION_NAME);
        createNewCollectionModal.typeDescription(TestData.NEW_COLLECTION_DESCRIPTION);
        createNewCollectionModal.clickOnCreateCollectionRrp();
    }

    private void testAddToCollectionDropdown(boolean modal){
        if(modal){
            for(int i=0; i<=2; i++) {
                testAddToNewCollection(true);
            }
            rrpModal.clickOnAddToCollectionDropdown();
            rrpModal.clickAddToNewCollection();
        } else{
            for(int i=0; i<=2; i++) {
                testAddToNewCollection(false);
            }
            rrpPage.clickOnAddToCollectionDropdown();
            rrpPage.clickAddToNewCollection();
        }
        if (upgradeMaxCollectionModal.isModalDisplayed()) {
            Assert.assertEquals(upgradeMaxCollectionModal.getUpgradeModalText(), TestData.UPGRADE_MODAL_TEXT_FROM_MAX_COLLECTION_LIMIT);
            upgradeMaxCollectionModal.clickOnCloseButton();
        } else {
            createNewCollectionModal.typeName(TestData.NEW_COLLECTION_NAME);
            createNewCollectionModal.typeDescription(TestData.NEW_COLLECTION_DESCRIPTION);
            createNewCollectionModal.clickOnCreateCollectionRrp();
        }
    }
}
