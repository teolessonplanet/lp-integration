import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.util.ArrayList;
import java.util.Arrays;

public class User_RrpSearchPageTest extends BaseTest {
    private DiscoverResourcesPage discoverResourcesPage;
    private RrpModal rrpModal;
    private RrpPage rrpPage;
    private CollectionRrpModal collectionRrpModal;
    private CollectionRrpPage collectionRrpPage;
    private WhatMembersSayWidget whatMembersSayWidget;
    private StepOneModal stepOneModal;
    private SignInPage signInPage;
    private UpgradeMaxItemsCollectionModal upgradeMaxItemsCollectionModal;
    private UpgradeMaxFolderModal upgradeMaxFolderModal;
    private User_DirectoryCategoriesAndSubcategoriesPageTest user_directoryCategoriesAndSubcategoriesTest;
    private User_CurriculumManagerPageTest user_curriculumManagerTest;
    private StepTwoPage stepTwoPage;
    private ResourcePreviewPage resourcePreviewPage;
    private CollectionRrp collectionRrp;
    private Rrp rrp;
    private LimitedResourceAccessModal limitedResourceAccessModal;
    private CreateNewFolderModal createNewFolderModal;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        rrpModal = new RrpModal(webDriver);
        rrpPage = new RrpPage(webDriver);
        collectionRrpModal = new CollectionRrpModal(webDriver);
        collectionRrpPage = new CollectionRrpPage(webDriver);
        whatMembersSayWidget = new WhatMembersSayWidget(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        signInPage = new SignInPage(webDriver);
        upgradeMaxItemsCollectionModal = new UpgradeMaxItemsCollectionModal(webDriver);
        upgradeMaxFolderModal = new UpgradeMaxFolderModal(webDriver);
        user_directoryCategoriesAndSubcategoriesTest = new User_DirectoryCategoriesAndSubcategoriesPageTest();
        user_curriculumManagerTest = new User_CurriculumManagerPageTest();
        stepTwoPage = new StepTwoPage(webDriver);
        resourcePreviewPage = new ResourcePreviewPage(webDriver);
        collectionRrp = new CollectionRrpModal(webDriver);
        rrp = new Rrp(webDriver);
        limitedResourceAccessModal = new LimitedResourceAccessModal(webDriver);
        createNewFolderModal = new CreateNewFolderModal(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Visitor - Search Page - RRP Modal - RRP Overview - lessonp-467: Resource Modal Overview", groups = {"visitor"})
    public void testLessonp_467() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        testRegularResourceRRPOverview(true, TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - Search Page - RRP Modal - RRP Overview - lessonp-1282: Shared Resource Modal Overview", groups = {"visitor"})
    public void testLessonp_1282() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(false);
        testSharedResourceRRPOverview(true, TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - Search Page - RRP Modal - RRP Overview - lessonp-468: Collection Modal Overview", groups = {"visitor"})
    public void testLessonp_468() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        testCollectionRRPOverview(true, TestData.PLAN_VISITOR);
        testPanelItemsOverview();
    }

    @Test(description = "Visitor - Search Page - RRP Static - RRP Overview - lessonp-475: Resource Static Page Overview", groups = {"visitor"})
    public void testLessonp_475() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testRegularResourceRRPOverview(false, TestData.PLAN_VISITOR);
        testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE, TestData.PLAN_VISITOR);
        testSimilarResourcesSectionOverview(TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - Search Page - RRP Static  - RRP Overview - lessonp-944: Shared Resource Static Page Overview", groups = {"visitor"})
    public void testLessonp_944() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(true);
        testSharedResourceRRPOverview(false, TestData.PLAN_VISITOR);
        testWhatMembersSayWidgetOverview(TestData.PLAN_VISITOR);
        testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_SHARED_RESOURCE, TestData.PLAN_VISITOR);
        testSimilarResourcesSectionOverview(TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - Search Page - RRP Static  - RRP Overview - lessonp-476: Collection Static Page Overview", groups = {"visitor"})
    public void testLessonp_476() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        testCollectionRRPOverview(false, TestData.PLAN_VISITOR);
        testPanelItemsOverview();
    }

    @Test(description = "Visitor - Search Page - RRP Modal - RRP Buttons - lessonp-469: LP Resource Main buttons", groups = {"visitor"})
    public void testLessonp_469() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        testFavoriteButton(true);
        testResourceGetFreeAccessForTenDaysButton(true);
        testThumbnailForRegularResource(true, TestData.PLAN_VISITOR);
        testRegularResourceRRPNavigationButtonsSearchPage(true);
    }

    @Test(description = "Visitor - Search Page - RRP Modal - RRP Buttons - lessonp-1254: Shared Resource Main buttons", groups = {"visitor"})
    public void testLessonp_1254() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(false);
        testFavoriteButton(true);
        testGoToResourceButtonForSharedResource(true);
        testThumbnailForSharedResource(true);
        testSharedResourceRRPNavigationButtonsSearchPage();
    }

    @Test(description = "Visitor - Search Page - RRP Modal - RRP Buttons - lessonp-473: Collection Main buttons", groups = {"visitor"})
    public void testLessonp_473() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        testSaveCollectionButton(true, TestData.PLAN_VISITOR);
        testCollectionGetFreeAccessForTenDaysButton(true);
        testCollectionOrUnitRRPNavigationButtonsSearchPage();
        collectionRrpModal.clickPanelItem(0);
        testItemViewerSection();
        collectionRrpModal.clickSeeFullReviewsLink();
        testItemViewerSection();
    }

    @Test(description = "Visitor - Search Page - RRP Static - RRP Buttons - lessonp-4603: LP Resource Main buttons", groups = {"visitor"})
    public void testLessonp_4603() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeeReview(true);
        testFavoriteButton(false);
        testResourceGetFreeAccessForTenDaysButton(false);
        testThumbnailForRegularResource(false, TestData.PLAN_VISITOR);
        testStartYourFreeTrialTryItFreeButton();
        testSeeSimilarResourcesDropdown();
        testSeeSimilarResourcesTryItFreeButton();
    }

    @Test(description = "Visitor - Search Page - RRP Static - RRP Buttons - lessonp-4608: Shared Resource Main Buttons", groups = {"visitor"})
    public void testLessonp_4608() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(true);
        testGoToResourceButtonForSharedResource(false);
        testThumbnailForSharedResource(false);
        testStartYourFreeTrialTryItFreeButton();
        user_directoryCategoriesAndSubcategoriesTest.initTest(webDriver);
        user_directoryCategoriesAndSubcategoriesTest.testTestimonials(TestData.PLAN_VISITOR);
        discoverResourcesPage.closeTab();
        testSeeSimilarResourcesDropdown();
        testSeeSimilarResourcesTryItFreeButton();
    }

    @Test(description = "Visitor - Search Page - RRP Static - RRP Buttons - lessonp-4609: Collection Main buttons", groups = {"visitor"})
    public void testLessonp_4609() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        testSaveCollectionButton(false, TestData.PLAN_VISITOR);
        testCollectionGetFreeAccessForTenDaysButton(false);
        collectionRrpPage.clickPanelItem(0);
        testItemViewerSection();
        collectionRrpPage.clickSeeFullReviewsLink();
        testItemViewerSection();
    }

    @Test(description = "Free member - Search Page - RRP Modal - RRP Overview - lessonp-523: Resource Modal Overview", groups = {"freemium"})
    public void testLessonp_523() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        testRegularResourceRRPOverview(true, TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Free member - Search Page - RRP Modal - RRP Overview - lessonp-535: Free Sample Modal Overview", groups = {"freemium"})
    public void testLessonp_535() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickFreeFullAccessReview(false);
        testFreeSampleResourceRRPOverview(true);
    }

    @Test(description = "Free member - Search Page - RRP Modal - RRP Overview - lessonp-952: Shared Resource Modal Overview", groups = {"freemium"})
    public void testLessonp_952() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(false);
        testSharedResourceRRPOverview(true, TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Free member - Search Page - RRP Modal - RRP Overview - lessonp-524: Collection Modal Overview", groups = {"freemium"})
    public void testLessonp_524() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        testCollectionRRPOverview(true, TestData.PLAN_FREEMIUM);
        testPanelItemsOverview();
    }

    @Test(description = "Free member - Search Page - RRP Static - RRP Overview - lessonp-515: Resource Static Page Overview", groups = {"freemium"})
    public void testLessonp_515() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testRegularResourceRRPOverview(false, TestData.PLAN_FREEMIUM);
        testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE, TestData.PLAN_FREEMIUM);
        testSimilarResourcesSectionOverview(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Free member - Search Page - RRP Static - RRP Overview - lessonp-531: Free Sample Static Page Overview", groups = {"freemium"})
    public void testLessonp_531() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickFreeFullAccessReview(true);
        testFreeSampleResourceRRPOverview(false);
        testFreeSampleResourceStartYourFreeTrialWidgetOverview();
        testWhatMembersSayWidgetOverview(TestData.PLAN_FREEMIUM);
        testSimilarResourcesSectionOverview(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Free member - Search Page - RRP Static - RRP Overview - lessonp-950: Shared Resource Static Page Overview", groups = {"freemium"})
    public void testLessonp_950() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        testSharedResourceRRPOverview(false, TestData.PLAN_FREEMIUM);
        testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_SHARED_RESOURCE, TestData.PLAN_FREEMIUM);
        testWhatMembersSayWidgetOverview(TestData.PLAN_FREEMIUM);
        testSimilarResourcesSectionOverview(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Free member - Search Page - RRP Static - RRP Overview - lessonp-516: Collection Static Page Overview", groups = {"freemium"})
    public void testLessonp_516() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        testCollectionRRPOverview(false, TestData.PLAN_FREEMIUM);
        testPanelItemsOverview();
    }

    @Test(description = "Free member - Search Page - RRP Modal - RRP Buttons - lessonp-4664: LP Resource Main buttons", groups = {"freemium"})
    public void testLessonp_4664() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        testLpResourceMainButtons(true, true);
    }

    protected void testLpResourceMainButtons(boolean inModal, boolean resourceIsFirstInList) {
        testResourceUpgradeForFullReviewButton(inModal);
        if (inModal) {
            testRegularResourceRRPNavigationButtonsSearchPage(resourceIsFirstInList);
        } else {
            testSeeSimilarResourcesDropdown();
            testSeeSimilarResourcesUpgradeMeButton();
            testStartYourFreeTrialUpgradeMeButton();
        }
        testAddToCollectionDropdown(inModal);
        testThumbnailForRegularResource(inModal, TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Free member - Search Page - RRP Modal - RRP Buttons - lessonp-4663: FreeSample Resource Main buttons", groups = {"freemium"})
    public void testLessonp_4663() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickFreeFullAccessReview(false);
        testThumbnailForFreeSampleResource(true);
        testGoToResourceButtonForFreeSampleResource(true);
        testFreeResourceRRPNavigationButtonsSearchPage();
        testAddToCollectionDropdown(true);
    }

    @Test(description = "Free member - Search Page - RRP Modal - RRP Buttons - lessonp-4666: Shared Resource Main buttons", groups = {"freemium"})
    public void testLessonp_4666() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(false);
        testThumbnailForSharedResource(true);
        testSharedResourceRRPNavigationButtonsSearchPage();
        testAddToCollectionDropdown(true);
        testGoToResourceButtonForSharedResource(true);
    }

    @Test(description = "Free member - Search Page - RRP Modal - RRP Buttons - lessonp-4667: Collection  Main buttons", groups = {"freemium"})
    public void testLessonp_4667() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        testCollectionMainButtonsForFreemium(true);
    }

    protected void testCollectionMainButtonsForFreemium(boolean inModal) {
        collectionRrpModal.clickPanelItem(0);
        testItemViewerSection();
        collectionRrpModal.clickSeeFullReviewsLink();
        testItemViewerSection();
        collectionRrpModal.clickPlayCollectionButton();
        user_curriculumManagerTest.initTest(webDriver);
        user_curriculumManagerTest.testCurriculumPlayerURL();
        testCollectionUpgradeForFullReviewButton(inModal);
        testSaveCollectionButton(inModal, TestData.PLAN_FREEMIUM);
        if (inModal) {
            testCollectionOrUnitRRPNavigationButtonsSearchPage();
        }
    }

    @Test(description = "Free member - Search Page - RRP Static - RRP Buttons - lessonp-4670: LP Resource Main buttons", groups = {"freemium"})
    public void testLessonp_4670() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testLpResourceMainButtons(false, true);
    }

    @Test(description = "Free member - Search Page - RRP Static - RRP Buttons - lessonp-4669: FreeSample Resource Main buttons", groups = {"freemium"})
    public void testLessonp_4669() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickFreeFullAccessReview(true);
        testThumbnailForFreeSampleResource(false);
        testGoToResourceButtonForFreeSampleResource(false);
        testAddToCollectionDropdown(false);
        testSeeSimilarResourcesDropdown();
        testSeeSimilarResourcesUpgradeMeButton();
        testFreeSampleStartYourFreeTrialUpgradeMeButton();
        user_directoryCategoriesAndSubcategoriesTest.initTest(webDriver);
        user_directoryCategoriesAndSubcategoriesTest.testTestimonials(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Free member - Search Page - RRP Static - RRP Buttons  - lessonp-4671: Shared Resource Main Buttons", groups = {"freemium"})
    public void testLessonp_4671() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(true);
        testThumbnailForSharedResource(false);
        testAddToCollectionDropdown(false);
        testGoToResourceButtonForSharedResource(false);
        testSeeSimilarResourcesDropdown();
        testSeeSimilarResourcesUpgradeMeButton();
        testStartYourFreeTrialUpgradeMeButton();
        user_directoryCategoriesAndSubcategoriesTest.initTest(webDriver);
        user_directoryCategoriesAndSubcategoriesTest.testTestimonials(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Free member - Search Page - RRP Static - RRP Buttons - lessonp-4668: Collection Main buttons", groups = {"freemium"})
    public void testLessonp_4668() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        testCollectionMainButtonsForFreemium(false);
    }

    @Test(description = "Active user - Search Page - RRP Modal - RRP Overview - lessonp-586: Resource Modal Overview", groups = {"activeUser"})
    public void testLessonp_586() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(false);
        testRegularResourceRRPOverview(true, TestData.PLAN_PRO);
    }

    @Test(description = "Active user - Search Page - RRP Modal - RRP Overview - lessonp-954: Shared Resource Modal Overview", groups = {"activeUser"})
    public void testLessonp_954() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(false);
        testSharedResourceRRPOverview(true, TestData.PLAN_PRO);
    }

    @Test(description = "Active user - Search Page - RRP Modal - RRP Overview - lessonp-587: Collection Modal Overview", groups = {"activeUser"})
    public void testLessonp_587() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(false);
        testCollectionRRPOverview(true, TestData.PLAN_PRO);
        testPanelItemsOverview();
    }

    @Test(description = "Active user - Search Page - RRP Static - RRP Overview - lessonp-4795: Resource Static Page Overview", groups = {"activeUser"})
    public void testLessonp_4795() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testResourcePageOverview(TestData.PLAN_PRO, false);
    }

    public void testResourcePageOverview(String account, boolean inModal) {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        //TODO: remove check LP prov
        discoverResourcesPage.clickSeeReview(!inModal);
        testRegularResourceRRPOverview(inModal, account);
        if (!(account.equals(TestData.VALID_EMAIL_RSL_SBCEO) || account.equals(TestData.VALID_EMAIL_CSL_HENRY) || account.equals(TestData.VALID_EMAIL_CSL_COBB))) {
            testWhatMembersSayWidgetOverview(account);
        }
        testSimilarResourcesSectionOverview(account);
    }

    @Test(description = "Active user - Search Page - RRP Static  - RRP Overview - lessonp-4796: Shared Resource Static Page Overview", groups = {"activeUser"})
    public void testLessonp_4796() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(true);
        testSharedResourceRRPOverview(false, TestData.PLAN_PRO);
        testWhatMembersSayWidgetOverview(TestData.PLAN_PRO);
        testSimilarResourcesSectionOverview(TestData.PLAN_PRO);
    }

    @Test(description = "Active user - Search Page - RRP Static  - RRP Overview - lessonp-4797: Collection Static Page Overview", groups = {"activeUser"})
    public void testLessonp_4797() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        testCollectionRRPOverview(false, TestData.PLAN_PRO);
        testPanelItemsOverview();
    }

    public void testCollectionStaticPageOverview(String account, boolean inModal) {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(!inModal);
        testCollectionRRPOverview(inModal, account);
        testPanelItemsOverview();
    }

    @Test(description = "Active user - Search Page - RRP Modal - RRP Buttons - lessonp-4792: LP Resource Main buttons", groups = {"activeUser"})
    public void testLessonp_4792() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testLpResourceMainButtons(false, TestData.PLAN_PRO);
    }

    public void testLpResourceMainButtons(boolean inANewTab, String account) {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(inANewTab);
        testLpResourceCommonButtons(inANewTab, account);
    }

    public void testLpResourceCommonButtons(boolean inANewTab, String account) {
        testThumbnailForRegularResource(!inANewTab, account);
        if (inANewTab) {
            testRegularResourceRRPNavigationButtonsSearchPage(true);
        }
        testAddToCollectionDropdown(!inANewTab);
        testGoToResourceButtonForRegularResource(!inANewTab);
    }

    @Test(description = "Active user - Search Page - RRP Modal - RRP Buttons - lessonp-4794: Shared Resource Main buttons", groups = {"activeUser"})
    public void testLessonp_4794() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(false);
        testThumbnailForSharedResource(true);
        testSharedResourceRRPNavigationButtonsSearchPage();
        testAddToCollectionDropdown(true);
        testGoToResourceButtonForSharedResource(true);
    }

    @Test(description = "Active user - Search Page - RRP Modal - RRP Buttons - lessonp-473: Collection Main buttons", groups = {"activeUser"})
    public void testLessonp_4793() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testCollectionMainButtons(true, TestData.PLAN_PRO);
    }

    public void testCollectionMainButtons(boolean inModal, String account) {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(!inModal);
        if (inModal) {
            testCollectionOrUnitRRPNavigationButtonsSearchPage();
        }
        collectionRrpModal.clickPanelItem(0);
        testItemViewerSection();
        collectionRrpModal.clickSeeFullReviewsLink();
        testItemViewerSection();
        collectionRrpModal.clickPlayCollectionButton();
        user_curriculumManagerTest.initTest(webDriver);
        user_curriculumManagerTest.testCurriculumPlayerURL();
        testSaveCollectionButton(inModal, account);
    }

    public void testCollectionOrUnitMainButtons(boolean inModal, String account) {
        if (inModal) {
            testCollectionOrUnitRRPNavigationButtonsSearchPage();
        }
        collectionRrpModal.clickPanelItem(0);
        testItemViewerSection();
        collectionRrpModal.clickSeeFullReviewsLink();
        testItemViewerSection();
        collectionRrpModal.clickPlayCollectionButton();
        user_curriculumManagerTest.initTest(webDriver);
        user_curriculumManagerTest.testCurriculumPlayerURL();
        testSaveCollectionButton(inModal, account);
    }


    @Test(description = "Active user - Search Page - RRP Static - RRP Buttons - lessonp-4805: LP Resource Main buttons", groups = {"activeUser"})
    public void testLessonp_4805() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeReview(true);
        testThumbnailForRegularResource(false, TestData.PLAN_PRO);
        testAddToCollectionDropdown(false);
        testGoToResourceButtonForRegularResource(false);
        user_directoryCategoriesAndSubcategoriesTest.initTest(webDriver);
        user_directoryCategoriesAndSubcategoriesTest.testTestimonials(TestData.PLAN_PRO);
        testSeeSimilarResourcesDropdown();
    }

    @Test(description = "Active user - Search Page - RRP Static - RRP Buttons - lessonp-4811: Shared Resource Main Buttons", groups = {"activeUser"})
    public void testLessonp_4811() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(true);
        testThumbnailForSharedResource(false);
        testAddToCollectionDropdown(false);
        testGoToResourceButtonForSharedResource(false);
        user_directoryCategoriesAndSubcategoriesTest.initTest(webDriver);
        user_directoryCategoriesAndSubcategoriesTest.testTestimonials(TestData.PLAN_PRO);
        testSeeSimilarResourcesDropdown();
    }

    @Test(description = "Active user - Search Page - RRP Static - RRP Buttons - lessonp-4817: Collection Main buttons", groups = {"activeUser"})
    public void testLessonp_4817() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeeCollection(true);
        collectionRrpModal.clickPlayCollectionButton();
        user_curriculumManagerTest.initTest(webDriver);
        user_curriculumManagerTest.testCurriculumPlayerURL();
        collectionRrpModal.clickPanelItem(0);
        testItemViewerSection();
        collectionRrpModal.clickSeeFullReviewsLink();
        testItemViewerSection();
        testSaveCollectionButton(false, TestData.PLAN_PRO);
    }

    public void testRegularResourceRRPOverview(boolean modal, String account) {
        if (modal) {
            rrpModal.waitForModal();
        }
        testRrpGeneralContent();

        if (account.equals(TestData.PLAN_VISITOR)) {
            Assert.assertTrue(rrp.isGetFreeAccessForTenDaysButtonDisplayed());
            Assert.assertTrue(rrp.isLimitedAccessReviewDisplayed());
            Assert.assertTrue(rrp.isVisitorFavoriteButtonDisplayed());
        }

        if (account.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertTrue(rrp.isUpgradeForFullReviewButtonDisplayed());
            Assert.assertTrue(rrp.isLimitedAccessReviewDisplayed());
        }
        if (account.equals(TestData.PLAN_PRO) || account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            Assert.assertTrue(rrp.isGoToResourceButtonDisplayed());
            if (!account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
                Assert.assertTrue(rrp.isFullReviewDisplayed());
            }
        }

        if (account.equals(TestData.PLAN_PRO) || account.equals(TestData.PLAN_FREEMIUM) || account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            Assert.assertTrue(rrp.isFavoriteButtonDisplayed() || rrp.isFavoriteButtonDisabledDisplayed());
            Assert.assertTrue(rrp.isAddToFolderDropdownDisplayed());
        }

        if (!account.equals(TestData.VALID_EMAIL_CSL_HENRY) && !account.equals(TestData.VALID_EMAIL_CSL_COBB) && !account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            Assert.assertTrue(rrp.isShareButtonDisplayed());
        }
        Assert.assertTrue(rrp.isThumbnailDisplayed());

        if (rrp.isLeftSectionBlankDisplayed()) {
            Assert.assertTrue(rrp.isLightRrpGradeDisplayed());
            Assert.assertEquals(rrp.getLightRrpGradeNumber(), 1);
            if (account.equals(TestData.PLAN_VISITOR) || account.equals(TestData.PLAN_FREEMIUM)) {
                Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrp.getLightRrpSubjectText().get(0)));
                if (rrp.getLightRrpSubjectsNumber() > 1) {
                    Assert.assertTrue(rrp.getLightRrpSubjectText().get(1).contains(TestData.DISABLED_TEXT));
                }
                Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrp.getLightRrpResourceTypeText().get(0)));
                if (rrp.getLightRrpResourceTypeNumber() > 1) {
                    Assert.assertTrue(rrp.getLightRrpResourceTypeText().get(1).contains(TestData.DISABLED_TEXT));
                }
            }
            if (account.equals(TestData.PLAN_PRO) || account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
                for (int i = 0; i < rrp.getLightRrpSubjectsNumber(); i++) {
                    Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrp.getLightRrpSubjectText().get(i)));
                }
                for (int i = 1; i < rrp.getLightRrpResourceTypeNumber(); i++) {
                    Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrp.getLightRrpResourceTypeText().get(i)));
                }
            }
        } else {
            Assert.assertTrue(rrp.isFullRrpGradeDisplayed());
            if (account.equals(TestData.PLAN_VISITOR) || account.equals(TestData.PLAN_FREEMIUM)) {
                Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrp.getFullRrpSubjectText().get(0)));
                if (rrp.getFullRrpSubjectsNumber() > 1) {
                    Assert.assertTrue(rrp.getFullRrpSubjectText().get(1).contains(TestData.DISABLED_TEXT));
                }
                Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrp.getFullRrpResourceTypeText().get(0)));
                if (rrp.getFullRrpResourceTypeNumber() > 1) {
                    Assert.assertTrue(rrp.getFullRrpResourceTypeText().get(1).contains(TestData.DISABLED_TEXT));
                }
            }
            if (account.equals(TestData.PLAN_PRO) || account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
                for (int i = 0; i < rrp.getFullRrpSubjectsNumber(); i++) {
                    Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrp.getFullRrpSubjectText().get(i)));
                }
                for (int i = 1; i < rrp.getFullRrpResourceTypeNumber(); i++) {
                    Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrp.getFullRrpResourceTypeText().get(i)));
                }
            }
        }
        testEducatorRatingSection(account);
    }

    public void testEducatorRatingSection(String account) {
        Assert.assertTrue(rrp.getEducatorRatingDetails().contains(TestData.RATE_THIS_RESOURCE) || rrp.getEducatorRatingDetails().contains(TestData.UPDATE_YOUR_RATING));
        if (!rrp.isNotYetRatedTextDisplayed()) {
            Assert.assertTrue(rrp.isEducatorRatingIconsSectionDisplayed());
        }

        rrp.clickOnRateThisResourceLink();
        if (account.equals(TestData.PLAN_VISITOR) || account.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertTrue(rrp.isUpgradeYourMembershipPopoverDisplayed());
        } else {
            Assert.assertTrue(rrp.isAddAReviewSectionDisplayed());
            Assert.assertEquals(rrp.getAddAReviewSectionSubtitle(), TestData.ADD_A_REVIEW_SUBTITLE);
            Assert.assertTrue(rrp.getAddAReviewSectionTitle().contains(TestData.ADD_A_REVIEW_NO_REVIEW_TITLE) || rrp.getAddAReviewSectionTitle().contains(TestData.ADD_A_REVIEW_EXISTING_REVIEW_TITLE));
            Assert.assertTrue(rrp.isAddAReviewPanelDisplayed());
            Assert.assertTrue(rrp.isAddAReviewRatingIconsSectionDisplayed());
        }
    }

    public void testStartYourFreeTrialWidgetOverview(String widgetText, String account) {
        Assert.assertTrue(rrpPage.isStartYourFreeTrialWidgetDisplayed());
        Assert.assertEquals(rrpPage.getStartYourFreeTrialText(), widgetText);
        if (account.equals(TestData.PLAN_VISITOR)) {
            Assert.assertTrue(rrpPage.isStartYourFreeTrialTryItFreeButtonDisplayed());
        }
        if (account.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertTrue(rrpPage.isStartYourFreeTrialUpgradeMeButtonDisplayed());
        }
    }

    public void testSimilarResourcesSectionOverview(String account) {
        if (rrpPage.isSimilarResourcesHeaderDisplayed()) {
            Assert.assertTrue(rrpPage.isSimilarResourcesListDisplayed());
            Assert.assertTrue(rrpPage.isAllResourceTypesDropdownDisplayed());
            rrpPage.clickAllResourceTypesDropdown();
            Assert.assertEquals(rrpPage.getAllResourceTypesFromDropdown(), TestData.ALL_RESOURCE_TYPES_DROPDOWN);
        }
        if (account.equals(TestData.PLAN_VISITOR)) {
            Assert.assertTrue(rrpPage.isBottomPageTryItFreeButtonDisplayed());
        }
        if (account.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertTrue(rrpPage.isBottomPageUpgradeMeButtonDisplayed());
        }
    }

    public void testWhatMembersSayWidgetOverview(String account) {
        Assert.assertTrue(whatMembersSayWidget.isWidgetDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isTestimonialTextDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isMemberPhotoDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isSeeMoreTestimonialsLinkDisplayed());
        Assert.assertTrue(whatMembersSayWidget.isSubmitYourOwnLinkDisplayed());
        if (!account.equals(TestData.PLAN_PRO)) {
            Assert.assertTrue(whatMembersSayWidget.isSubscriptionButtonDisplayed());
        }
    }

    public void testSharedResourceRRPOverview(boolean modal, String account) {
        //TODO: put ticket for this
        if (modal) {
            rrpModal.waitForModal();
        }
        Assert.assertTrue(rrp.isTitleDisplayed());
        Assert.assertTrue(rrp.isDescriptionDisplayed());
        Assert.assertTrue(rrp.isNumberOfDownloadsDisplayed());
        Assert.assertTrue(rrp.isNumberOfViewsDisplayed());
        for (int i = 0; i < rrp.getLightRrpSubjectsNumber(); i++) {
            Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrp.getLightRrpSubjectText().get(i)));
        }
        for (int i = 1; i < rrp.getLightRrpResourceTypeNumber(); i++) {
            Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrp.getLightRrpResourceTypeText().get(i)));
        }
        Assert.assertTrue(rrp.isGoToResourceButtonDisplayed());
        Assert.assertTrue(rrp.isShareButtonDisplayed());
        Assert.assertTrue(rrp.isThumbnailDisplayed());
        if (modal) {
            Assert.assertTrue(rrp.isPreviousButtonDisplayed());
            Assert.assertTrue(rrp.isNextButtonDisplayed());
        } else {
            Assert.assertFalse(rrp.isPreviousButtonDisplayed());
            Assert.assertFalse(rrp.isNextButtonDisplayed());
        }
        Assert.assertTrue(rrp.isLightRrpGradeDisplayed());
        Assert.assertEquals(rrp.getLightRrpGradeNumber(), 1);
        if (account.equals(TestData.PLAN_VISITOR)) {
            Assert.assertTrue(rrp.isVisitorFavoriteButtonDisplayed());
        } else {
            Assert.assertTrue(rrp.isFavoriteButtonDisplayed());
            Assert.assertTrue(rrp.isAddToFolderDropdownDisplayed());
        }

        testEducatorRatingSection(account);
    }

    public void testCollectionRRPOverview(boolean modal, String account) {
        if (modal) {
            collectionRrpModal.waitForModal();
        }
        Assert.assertTrue(collectionRrp.isCollectionTitleDisplayed());
        Assert.assertTrue(collectionRrp.isDescriptionDisplayed());
        Assert.assertTrue(collectionRrp.isCollectionItemsCountDisplayed());
        Assert.assertTrue(collectionRrp.isNumberOfViewsDisplayed());
        Assert.assertTrue(collectionRrp.isNumberOfDownloadsDisplayed());
        Assert.assertTrue(collectionRrp.isConceptsTagsListDisplayed());
        Assert.assertTrue(collectionRrp.isGradeDisplayed());
        Assert.assertTrue(collectionRrp.isSubjectDisplayed());
        Assert.assertFalse(collectionRrp.isLimitedAccessReviewDisplayed());
        if (account.equals(TestData.PLAN_VISITOR)) {
            Assert.assertTrue(collectionRrp.isGetFreeAccessForTenDaysButtonDisplayed());
            Assert.assertTrue(collectionRrp.isSaveCollectionButtonDisplayed());
        }
        if (account.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertTrue(collectionRrp.isUpgradeForFullReviewButtonDisplayed());
        }
        //TODO:editions - add CSL to check Play/Save ?
        if (account.equals(TestData.PLAN_FREEMIUM) || account.equals(TestData.PLAN_PRO) || account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            Assert.assertTrue(collectionRrp.isPlayCollectionButtonDisplayed());
            Assert.assertTrue(collectionRrp.isSaveCollectionButtonActiveUserDisplayed());
        }

        if (!account.equals(TestData.VALID_EMAIL_CSL_HENRY) && !account.equals(TestData.VALID_EMAIL_CSL_COBB) && !account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            Assert.assertTrue(collectionRrp.isShareButtonDisplayed());
        }
        Assert.assertTrue(collectionRrp.isSeeFullReviewsLinkVisible());
        Assert.assertEquals(collectionRrp.getCollectionItemsCount(), collectionRrp.getPanelItemsCount());
        testEducatorRatingSection(account);
    }

    public void testPanelItemsOverview() {
        if ((collectionRrp.getCollectionItemsCount() > 4) && (collectionRrp.getCollectionItemsCount() <= 8)) {
            Assert.assertFalse(collectionRrp.isPreviousButtonPanelItemsDisplayed());
            Assert.assertTrue(collectionRrp.isNextButtonPanelItemsDisplayed());
            collectionRrp.clickNextButtonPanelItems();
            Assert.assertTrue(collectionRrp.isPreviousButtonPanelItemsDisplayed());
            Assert.assertFalse(collectionRrp.isNextButtonPanelItemsDisplayed());
        }
        if (collectionRrp.getCollectionItemsCount() <= 4) {
            Assert.assertFalse(collectionRrp.isPreviousButtonPanelItemsDisplayed() && collectionRrp.isNextButtonPanelItemsDisplayed());
        }
        if (collectionRrp.getCollectionItemsCount() >= 9) {
            Assert.assertFalse(collectionRrp.isPreviousButtonPanelItemsDisplayed());
            Assert.assertTrue(collectionRrp.isNextButtonPanelItemsDisplayed());
            collectionRrp.clickNextButtonPanelItems();
            Assert.assertTrue(collectionRrp.isPreviousButtonPanelItemsDisplayed() && collectionRrp.isNextButtonPanelItemsDisplayed());
        }
    }

    public void testStepOneModal() {
        stepOneModal.waitForModal();
        Assert.assertEquals(stepOneModal.getTitleText(), TestData.STEP_ONE_MODAL_TITLE);
        stepOneModal.clickCloseModal();
    }

    public void testSignInPage() {
        discoverResourcesPage.waitForLinkToLoad();
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.LOGIN_PAGE_PATH));
        Assert.assertEquals(signInPage.getTitleText(), TestData.SIGN_IN_MODAL_TITLE_TEXT);
        discoverResourcesPage.closeTab();
    }

    public void testNewTabUrl(String url) {
        discoverResourcesPage.waitForNewTab();
        discoverResourcesPage.focusDriverToLastTab();
        discoverResourcesPage.waitForLinkToLoad();
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(url));
        discoverResourcesPage.closeTab();
    }

    public void testNewTabRegularResourceUrl() {
        discoverResourcesPage.waitForNewTab();
        discoverResourcesPage.focusDriverToLastTab();
        discoverResourcesPage.waitForLinkToLoad();
//        Assert.assertFalse(discoverResourcesPage.getUrl().contains(TestData.STAGING_SERVER_SHARED_RESOURCE_URL_2) || discoverResourcesPage.getUrl().contains(TestData.SERVER_URL));
        //TODO: above line was removed by mistake in PR 76?  https://github.com/LessonPlanet/lp-integration/pull/76
        //TODO: check if stable in all tests and then remove the comments
        if (discoverResourcesPage.getUrl().contains(TestData.SERVER_URL)) {
            Assert.assertTrue(discoverResourcesPage.getUrl().contains(TestData.SERVER_URL + TestData.STAGING_SERVER_SHARED_RESOURCE_URL_2));
            Assert.assertTrue(resourcePreviewPage.isDownloadResourceButtonDisplayed());
            Assert.assertTrue(resourcePreviewPage.isIframeResourceDisplayed());
        } else {
            Assert.assertFalse(discoverResourcesPage.getUrl().contains(TestData.SERVER_URL + TestData.STAGING_SERVER_SHARED_RESOURCE_URL_2));
        }
        discoverResourcesPage.closeTab();
    }

    public void testPageUrl(String url) {
        Assert.assertTrue(discoverResourcesPage.getUrl().contains(url));
        discoverResourcesPage.goBackOnePage();
    }

    public void testResourceGetFreeAccessForTenDaysButton(boolean modal) {
        if (modal) {
            rrpModal.waitForModal();
        }
        rrpPage.clickGetFreeAccessForTenDaysButton(false);
        testStepOneModal();
        rrpPage.clickGetFreeAccessForTenDaysButton(true);
        testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
    }

    public void testFavoriteButton(boolean modal) {
        if (modal) {
            rrpModal.waitForModal();
        }
        rrpPage.clickVisitorFavoriteButton();
        Assert.assertTrue(rrpPage.isSignInPopupLinkDisplayed() && rrpPage.isJoinNowPopupLinkDisplayed());
        rrpPage.clickJoinNowPopupLink();
        testStepOneModal();
        rrpPage.clickVisitorFavoriteButton();
        rrpPage.clickSignInPopupLink(true);
        testSignInPage();
    }

    public void testRegularResourceRRPNavigationButtonsSearchPage(boolean resourceIsFirstInList) {
        Assert.assertTrue(rrpModal.getModalId().contains(discoverResourcesPage.getRegularResourceCardDataId(0)));
        if (discoverResourcesPage.getResourceCardDataType(0).equals(TestData.SHARED_RESOURCE_TYPE)) {
            Assert.assertTrue(rrpModal.isPreviousButtonDisplayed());
        } else {
            if (resourceIsFirstInList) {
                Assert.assertFalse(rrpModal.isPreviousButtonDisplayed());
            }
        }
        Assert.assertTrue(rrpModal.isNextButtonDisplayed());
    }

    public void testThumbnailForRegularResource(boolean modal, String account) {
        if (modal) {
            rrpModal.waitForModal();
        }
        rrpPage.clickOnThumbnail();
        if (account.equals(TestData.PLAN_VISITOR)) {
            testStepOneModal();
        }
        if (account.equals(TestData.PLAN_FREEMIUM)) {
            testPageUrl(TestData.STEP_ONE_PAGE_PATH);
        }
        if (account.equals(TestData.PLAN_PRO) || account.equals(TestData.VALID_EMAIL_RSL_SBCEO) || account.equals(TestData.VALID_EMAIL_CSL_HENRY)) {
            testNewTabRegularResourceUrl();
        }
    }

    public void testGoToResourceButtonForRegularResource(boolean modal) {
        rrpPage.clickGoToResourceButton(modal);
        testNewTabRegularResourceUrl();
    }

    public void testThumbnailForSharedResource(boolean modal) {
        if (modal) {
            rrpModal.waitForModal();
        }
        rrpPage.clickOnThumbnail();
        testNewTabUrl(TestData.STAGING_SERVER_SHARED_RESOURCE_URL);
    }

    public void testGoToResourceButtonForSharedResource(boolean modal) {
        if (modal) {
            rrpModal.waitForModal();
        }
        rrpPage.clickGoToResourceButton(true);
        testNewTabUrl(TestData.STAGING_SERVER_SHARED_RESOURCE_URL);
    }

    public void testThumbnailForFreeSampleResource(boolean modal) {
        if (modal) {
            rrpModal.waitForModal();
        }
        rrpPage.clickOnThumbnail();
        testNewTabUrl(TestData.SERVER_URL + TestData.STAGING_SERVER_SHARED_RESOURCE_URL_2);
    }

    public void testGoToResourceButtonForFreeSampleResource(boolean modal) {
        if (modal) {
            rrpModal.waitForModal();
        }
        rrpPage.clickGoToResourceButton(true);
        testNewTabUrl(TestData.SERVER_URL + TestData.STAGING_SERVER_SHARED_RESOURCE_URL_2);
    }

    public void testSharedResourceRRPNavigationButtonsSearchPage() {
        Assert.assertTrue(rrpModal.getModalId().contains(discoverResourcesPage.getSharedResourceCardDataId(0)));
        if (discoverResourcesPage.getResourceCardDataType(0).equals(TestData.REGULAR_RESOURCE_TYPE)) {
            Assert.assertTrue(rrpModal.isPreviousButtonDisplayed());
        } else {
            Assert.assertFalse(rrpModal.isPreviousButtonDisplayed());
        }
        Assert.assertTrue(rrpModal.isNextButtonDisplayed());
        rrpModal.clickNextButton();
        rrpModal.waitForModal();
        Assert.assertTrue(rrpModal.getModalId().contains(discoverResourcesPage.getSharedResourceCardDataId(1)));
        rrpModal.clickPreviousButton();
        Assert.assertTrue(rrpModal.getModalId().contains(discoverResourcesPage.getSharedResourceCardDataId(0)));
    }

    public void testCollectionGetFreeAccessForTenDaysButton(boolean modal) {
        if (modal) {
            collectionRrpModal.waitForModal();
        }
        collectionRrpPage.clickGetFreeAccessForTenDaysButton(false);
        testStepOneModal();
        collectionRrpPage.clickGetFreeAccessForTenDaysButton(true);
        testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
    }

    public void testCollectionUpgradeForFullReviewButton(boolean modal) {
        if (modal) {
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
        }
        if (account.equals(TestData.PLAN_VISITOR)) {
            collectionRrpModal.clickSaveCollectionButton();
            Assert.assertTrue(collectionRrpModal.isSignInPopupLinkDisplayed() && collectionRrpModal.isJoinNowPopupLinkDisplayed());
            collectionRrpModal.clickJoinNowPopupLink();
            testStepOneModal();
            collectionRrpModal.clickSaveCollectionButton();
            collectionRrpModal.clickSignInPopupLink(true);
            testSignInPage();
        } else if (account.equals(TestData.PLAN_FREEMIUM)) {
            collectionRrpModal.clickSaveCollectionButtonActiveUser();
            if (collectionRrpModal.getCollectionItemsCount() > 10) {
                Assert.assertEquals(upgradeMaxItemsCollectionModal.getUpgradeModalText(), TestData.UPGRADE_MODAL_TEXT_FROM_EXCEEDED_ITEMS_INSIDE_SAVED_FOLDER);
            }
            if (collectionRrpModal.getCollectionItemsCount() < 10) {
                Assert.assertTrue(collectionRrpModal.isSavedCollectionNotificationDisplayed());
            }
        } else { // ACTIVE & SLs
            collectionRrpModal.clickSaveCollectionButtonActiveUser();

            if (limitedResourceAccessModal.isModalDisplayed()) {
                Assert.assertEquals(limitedResourceAccessModal.getLimitedResourceAccessModalTitleText(), TestData.LIMITED_RESOURCE_ACCESS_TITLE);
                Assert.assertTrue(limitedResourceAccessModal.getLimitedResourceAccessModalBodyText().contains(TestData.LIMITED_RESOURCE_ACCESS_MODAL_TEXT));
                limitedResourceAccessModal.clickOnSaveButton();
            }
            //Assert.assertTrue(collectionRrpModal.isSavedCollectionNotificationDisplayed());
        }
    }

    protected void testCollectionOrUnitRRPNavigationButtonsSearchPage() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_COLLECTIONS_TYPES);
        ArrayList<String> collectionTitles = new ArrayList<>();
        collectionTitles.add(discoverResourcesPage.getCollectionOrUnitCardTitle(0));
        collectionTitles.add(discoverResourcesPage.getCollectionOrUnitCardTitle(1));

        discoverResourcesPage.clickSeeCollection(false);
        collectionRrpModal.waitForModal();
        Assert.assertEquals(collectionRrpModal.getCollectionTitleText(), collectionTitles.get(0));
        collectionRrpModal.clickNextButtonRrp();
        Assert.assertEquals(collectionRrpModal.getCollectionTitleText(), collectionTitles.get(1));
        collectionRrpModal.clickPreviousButtonRrp();
        Assert.assertEquals(collectionRrpModal.getCollectionTitleText(), collectionTitles.get(0));
    }

    public void testItemViewerSection() {
        Assert.assertEquals(collectionRrp.getExpandedRrpDataId(0), collectionRrp.getPanelItemDataId(0));
        Assert.assertFalse(collectionRrp.isSeeFullReviewsLinkVisible());
        Assert.assertFalse(collectionRrp.isPreviousButtonItemViewerDisplayed());
        if (collectionRrp.getCollectionItemsCount() > 1) {
            Assert.assertTrue(collectionRrp.isNextButtonItemViewerDisplayed());
            collectionRrp.clickNextButtonItemViewer();
            Assert.assertEquals(collectionRrp.getExpandedRrpDataId(1), collectionRrp.getPanelItemDataId(1));
            collectionRrp.clickPreviousButtonItemViewer();
            Assert.assertEquals(collectionRrp.getExpandedRrpDataId(0), collectionRrp.getPanelItemDataId(0));
        }
        if (collectionRrp.getCollectionItemsCount() == 1) {
            Assert.assertFalse(collectionRrp.isNextButtonItemViewerDisplayed());
        }
        collectionRrp.clickCloseExpandedRrp();
        Assert.assertTrue(collectionRrp.isSeeFullReviewsLinkVisible());
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
        testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
    }

    public void testSeeSimilarResourcesDropdown() {
        if (rrpPage.isSimilarResourcesHeaderDisplayed()) {
            rrpPage.clickAllResourceTypesDropdown();
            rrpPage.clickLessonPlansResourceType();
            Assert.assertEquals(rrpPage.getAllResourceTypesDropdownText(), TestData.LESSON_PLANS_RESOURCE_TYPE);
            if (rrpPage.getAllSimilarResourceCardsNumber() > 0) {
                int count = 0;
                for (int i = 0; i < rrpPage.getAllSimilarResourceCardsNumber(); i++) {
                    if (rrpPage.getSimilarResourceCardResourceTypeText(i).equals('"' + TestData.LESSON_RESOURCE_TYPE_CARD + '"')) {
                        count++;
                    }
                }
                Assert.assertTrue(count >= 1);
            }
        } else {
            Assert.assertEquals(rrpPage.getSimilarResourcesListText(), TestData.NO_RESOURCES_FOUND_TEXT);
        }
    }

    private void testFreeSampleResourceRRPOverview(boolean modal) {
        if (modal) {
            rrpModal.waitForModal();
        }
        testRrpGeneralContent();
        Assert.assertTrue(rrp.isFavoriteButtonDisplayed());
        Assert.assertTrue(rrp.isAddToFolderDropdownDisplayed());
        Assert.assertTrue(rrp.isGoToResourceButtonDisplayed());

        if (rrp.isLeftSectionBlankDisplayed()) {
            Assert.assertTrue(rrp.isLightRrpGradeDisplayed());
            Assert.assertEquals(rrp.getLightRrpGradeNumber(), 1);
            for (int i = 0; i < rrp.getLightRrpSubjectsNumber(); i++) {
                Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrp.getLightRrpSubjectText().get(i)));
            }
            for (int i = 1; i < rrp.getLightRrpResourceTypeNumber(); i++) {
                Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrp.getLightRrpResourceTypeText().get(i)));
            }
        } else {
            Assert.assertTrue(rrp.isFullRrpGradeDisplayed());
            for (int i = 0; i < rrp.getFullRrpSubjectsNumber(); i++) {
                Assert.assertTrue(Arrays.asList(TestData.SUBJECTS).contains(rrp.getFullRrpSubjectText().get(i)));
            }
            for (int i = 1; i < rrp.getFullRrpResourceTypeNumber(); i++) {
                Assert.assertTrue(Arrays.asList(TestData.RESOURCE_TYPES).contains(rrp.getFullRrpResourceTypeText().get(i)));
            }
        }
        testEducatorRatingSection(TestData.PLAN_FREEMIUM);
    }

    private void testRrpGeneralContent() {
        Assert.assertTrue(rrp.isTitleDisplayed());
        Assert.assertTrue(rrp.isDescriptionDisplayed());
        Assert.assertTrue(rrp.isNumberOfViewsDisplayed());
        Assert.assertTrue(rrp.isNumberOfDownloadsDisplayed());
        Assert.assertTrue(rrp.isConceptsTagsListDisplayed());
        Assert.assertTrue(rrp.isReviewerRatingDisplayed());
    }

    private void testFreeSampleResourceStartYourFreeTrialWidgetOverview() {
        Assert.assertTrue(rrpPage.isFreeSampleResourceStartYourFreeTrialWidgetDisplayed());
        Assert.assertTrue(rrpPage.isFreeSampleResourceStartYourFreeTrialUpgradeMeButtonDisplayed());
        Assert.assertEquals(rrpPage.getFreeSampleResourceStartYourFreeTrialText(), TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE);
    }

    protected void testResourceUpgradeForFullReviewButton(boolean modal) {
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

    protected void testAddToNewCollection() {
        rrp.clickOnAddToFolderDropdown();
        rrp.clickAddToNewCollection();
        createNewFolderModal.waitForModal();
        createNewFolderModal.typeName(TestData.NEW_COLLECTION_NAME);
        createNewFolderModal.typeDescription(TestData.NEW_COLLECTION_DESCRIPTION);
        createNewFolderModal.clickOnCreateFolderButton();
        //TODO: add check for notification
    }

    protected void testAddToCollectionDropdown(boolean modal) {
        for (int i = 0; i <= 2; i++) {
            testAddToNewCollection();
        }
        rrp.clickOnAddToFolderDropdown();
        rrp.clickAddToNewCollection();

        if (upgradeMaxFolderModal.isModalDisplayed()) {
            Assert.assertEquals(upgradeMaxFolderModal.getUpgradeModalText(), TestData.UPGRADE_MODAL_TEXT_FROM_MAX_FOLDER_LIMIT);
            upgradeMaxFolderModal.clickOnCloseButton();
        } else {
            createNewFolderModal.typeName(TestData.NEW_COLLECTION_NAME);
            createNewFolderModal.typeDescription(TestData.NEW_COLLECTION_DESCRIPTION);
            createNewFolderModal.clickOnCreateFolderButton();
        }
    }
}
