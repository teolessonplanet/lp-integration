import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.util.ArrayList;
import java.util.Arrays;

public class User_RrpSearchTest extends BaseTest {
    private DiscoverResourcesPage discoverResourcesPage;
    private RrpModal rrpModal;
    private RrpPage rrpPage;
    private CollectionRrpModal collectionRrpModal;
    private CollectionRrpPage collectionRrpPage;
    private WhatMembersSayWidget whatMembersSayWidget;
    private StepOneModal stepOneModal;
    private SignInPage signInPage;
    private User_BrowseResourceDirectory_SubjectsTest user_directoryCategoriesAndSubcategoriesTest;
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
        user_directoryCategoriesAndSubcategoriesTest = new User_BrowseResourceDirectory_SubjectsTest();
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

    @Test(description = "Visitor - RRP Search - RRP Modal - RRP Overview - C2091: Resource Modal Overview", groups = {"visitor"})
    public void testC2091() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeReview(false);
        testRegularResourceRRPOverview(true, TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - RRP Search - RRP Modal - RRP Overview - C2092: Shared Resource Modal Overview", groups = {"visitor"})
    public void testC2092() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(false);
        testSharedResourceRRPOverview(true, TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - RRP Search - RRP Modal - RRP Overview - C2093: Collection Modal Overview", groups = {"visitor"})
    public void testC2093() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeCollection(false);
        testCollectionRRPOverview(true, TestData.PLAN_VISITOR);
        testPanelItemsOverview();
    }

    @Test(description = "Visitor - RRP Search - RRP Static - RRP Overview - C2085: Resource Static Page Overview", groups = {"visitor"})
    public void testC2085() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeReview(true);
        testRegularResourceRRPOverview(false, TestData.PLAN_VISITOR);
        testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE, TestData.PLAN_VISITOR);
        testSimilarResourcesSectionOverview(TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - RRP Search - RRP Static  - RRP Overview - C2086: Shared Resource Static Page Overview", groups = {"visitor"})
    public void testC2086() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(true);
        testSharedResourceRRPOverview(false, TestData.PLAN_VISITOR);
        testWhatMembersSayWidgetOverview(TestData.PLAN_VISITOR);
        testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_SHARED_RESOURCE, TestData.PLAN_VISITOR);
        testSimilarResourcesSectionOverview(TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - RRP Search - RRP Static  - RRP Overview - C2087: Collection Static Page Overview", groups = {"visitor"})
    public void testC2087() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeCollection(true);
        testCollectionRRPOverview(false, TestData.PLAN_VISITOR);
        testPanelItemsOverview();
    }

    @Test(description = "Visitor - RRP Search - RRP Modal - RRP Buttons - C2094: LP Resource Main buttons", groups = {"visitor"})
    public void testC2094() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeReview(false);
        testFavoriteButton(true);
        testResourceGetFreeAccessForTenDaysButton(true);
        testThumbnailForRegularResource(true, TestData.PLAN_VISITOR);
        testRegularResourceRRPNavigationButtonsSearchPage(true);
    }

    @Test(description = "Visitor - RRP Search - RRP Modal - RRP Buttons - C2096: Shared Resource Main buttons", groups = {"visitor"})
    public void testC2096() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(false);
        testFavoriteButton(true);
        testGoToResourceButtonForSharedResource(true);
        testThumbnailForSharedResource(true);
        testSharedResourceRRPNavigationButtonsSearchPage();
    }

    @Test(description = "Visitor - RRP Search - RRP Modal - RRP Buttons - C2095: Collection Main buttons", groups = {"visitor"})
    public void testC2095() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeCollection(false);
        testSaveCollectionButton(true, TestData.PLAN_VISITOR);
        testCollectionGetFreeAccessForTenDaysButton(true);
        testCollectionOrUnitRRPNavigationButtonsSearchPage();
        collectionRrpModal.clickOnPanelItem(0);
        testItemViewerSection();
        collectionRrpModal.clickOnSeeFullReviewsLink();
        testItemViewerSection();
    }

    @Test(description = "Visitor - RRP Search - RRP Static - RRP Buttons - C2090: LP Resource Main buttons", groups = {"visitor"})
    public void testC2090() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickOnSeeReview(true);
        testFavoriteButton(false);
        testResourceGetFreeAccessForTenDaysButton(false);
        testThumbnailForRegularResource(false, TestData.PLAN_VISITOR);
        testStartYourFreeTrialTryItFreeButton();
        testSeeSimilarResourcesDropdown();
        testSeeSimilarResourcesTryItFreeButton();
    }

    @Test(description = "Visitor - RRP Search - RRP Static - RRP Buttons - C2088: Shared Resource Main Buttons", groups = {"visitor"})
    public void testC2088() {
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

    @Test(description = "Visitor - RRP Search - RRP Static - RRP Buttons - C2089: Collection Main buttons", groups = {"visitor"})
    public void testC2089() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeCollection(true);
        testSaveCollectionButton(false, TestData.PLAN_VISITOR);
        testCollectionGetFreeAccessForTenDaysButton(false);
        collectionRrpPage.clickOnPanelItem(0);
        testItemViewerSection();
        collectionRrpPage.clickOnSeeFullReviewsLink();
        testItemViewerSection();
    }

    @Test(description = "Free member - RRP Search - RRP Modal - RRP Overview - C2158: Resource Modal Overview", groups = {"freemium"})
    public void testC2158() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeReview(false);
        testRegularResourceRRPOverview(true, TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Free member - RRP Search - RRP Modal - RRP Overview - C2159: Free Sample Modal Overview", groups = {"freemium"})
    public void testC2159() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnFreeFullAccessReview(false);
        testFreeSampleResourceRRPOverview(true);
    }

    @Test(description = "Free member - RRP Search - RRP Modal - RRP Overview - C2160: Shared Resource Modal Overview", groups = {"freemium"})
    public void testC2160() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(false);
        testSharedResourceRRPOverview(true, TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Free member - RRP Search - RRP Modal - RRP Overview - C2161: Collection Modal Overview", groups = {"freemium"})
    public void testC2161() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeCollection(false);
        testCollectionRRPOverview(true, TestData.PLAN_FREEMIUM);
        testPanelItemsOverview();
    }

    @Test(description = "Free member - RRP Search - RRP Static - RRP Overview - C2166: Resource Static Page Overview", groups = {"freemium"})
    public void testC2166() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeReview(true);
        testRegularResourceRRPOverview(false, TestData.PLAN_FREEMIUM);
        testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE, TestData.PLAN_FREEMIUM);
        testSimilarResourcesSectionOverview(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Free member - RRP Search - RRP Static - RRP Overview - C2167: Free Sample Static Page Overview", groups = {"freemium"})
    public void testC2167() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnFreeFullAccessReview(true);
        testFreeSampleResourceRRPOverview(false);
        testFreeSampleResourceStartYourFreeTrialWidgetOverview();
        testWhatMembersSayWidgetOverview(TestData.PLAN_FREEMIUM);
        testSimilarResourcesSectionOverview(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Free member - RRP Search - RRP Static - RRP Overview - C2168: Shared Resource Static Page Overview", groups = {"freemium"})
    public void testC2168() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(true);
        testSharedResourceRRPOverview(false, TestData.PLAN_FREEMIUM);
        testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_SHARED_RESOURCE, TestData.PLAN_FREEMIUM);
        testWhatMembersSayWidgetOverview(TestData.PLAN_FREEMIUM);
        testSimilarResourcesSectionOverview(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Free member - RRP Search - RRP Static - RRP Overview - C2169: Collection Static Page Overview", groups = {"freemium"})
    public void testC2169() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeCollection(true);
        testCollectionRRPOverview(false, TestData.PLAN_FREEMIUM);
        testPanelItemsOverview();
    }

    @Test(description = "Free member - RRP Search - RRP Modal - RRP Buttons - C2162: LP Resource Main buttons", groups = {"freemium"})
    public void testC2162() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeReview(false);
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

    @Test(description = "Free member - Search Page - RRP Modal - RRP Buttons - C2163: FreeSample Resource Main buttons", groups = {"freemium"})
    public void testC2163() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnFreeFullAccessReview(false);
        testThumbnailForFreeSampleResource(true);
        testGoToResourceButtonForFreeSampleResource(true);
        testFreeResourceRRPNavigationButtonsSearchPage();
        testAddToCollectionDropdown(true);
    }

    @Test(description = "Free member - Search Page - RRP Modal - RRP Buttons - C2165: Shared Resource Main buttons", groups = {"freemium"})
    public void testC2165() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(false);
        testThumbnailForSharedResource(true);
        testSharedResourceRRPNavigationButtonsSearchPage();
        testAddToCollectionDropdown(true);
        testGoToResourceButtonForSharedResource(true);
    }

    @Test(description = "Free member - Search Page - RRP Modal - RRP Buttons - C2164: Collection  Main buttons", groups = {"freemium"})
    public void testC2164() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeCollection(false);
        testCollectionMainButtonsForFreemium(true);
    }

    protected void testCollectionMainButtonsForFreemium(boolean inModal) {
        collectionRrpModal.clickOnPanelItem(0);
        testItemViewerSection();
        collectionRrpModal.clickOnSeeFullReviewsLink();
        testItemViewerSection();
        collectionRrpModal.clickOnPlayCollectionButton();
        user_curriculumManagerTest.initTest(webDriver);
        user_curriculumManagerTest.testCurriculumPlayerURL();
        testCollectionUpgradeForFullReviewButton(inModal);
        testSaveCollectionButton(inModal, TestData.PLAN_FREEMIUM);
        if (inModal) {
            testCollectionOrUnitRRPNavigationButtonsSearchPage();
        }
    }

    @Test(description = "Free member - Search Page - RRP Static - RRP Buttons - C2170: LP Resource Main buttons", groups = {"freemium"})
    public void testC2170() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeReview(true);
        testLpResourceMainButtons(false, true);
    }

    @Test(description = "Free member - Search Page - RRP Static - RRP Buttons -C2171: FreeSample Resource Main buttons", groups = {"freemium"})
    public void testC2171() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnFreeFullAccessReview(true);
        testThumbnailForFreeSampleResource(false);
        testGoToResourceButtonForFreeSampleResource(false);
        testAddToCollectionDropdown(false);
        testSeeSimilarResourcesDropdown();
        testSeeSimilarResourcesUpgradeMeButton();
        testFreeSampleStartYourFreeTrialUpgradeMeButton();
        user_directoryCategoriesAndSubcategoriesTest.initTest(webDriver);
        user_directoryCategoriesAndSubcategoriesTest.testTestimonials(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Free member - Search Page - RRP Static - RRP Buttons  - C2173: Shared Resource Main Buttons", groups = {"freemium"})
    public void testC2173() {
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

    @Test(description = "Free member - Search Page - RRP Static - RRP Buttons - C2172: Collection Main buttons", groups = {"freemium"})
    public void testC2172() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeCollection(true);
        testCollectionMainButtonsForFreemium(false);
    }

    @Test(description = "Active user - Search Page - RRP Modal - RRP Overview - C2283: Resource Modal Overview", groups = {"activeUser"})
    public void testC2283() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeReview(false);
        testRegularResourceRRPOverview(true, TestData.PLAN_PRO);
    }

    @Test(description = "Active user - Search Page - RRP Modal - RRP Overview -  C2285: Shared Resource Modal Overview", groups = {"activeUser"})
    public void testC2285() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(false);
        testSharedResourceRRPOverview(true, TestData.PLAN_PRO);
    }

    @Test(description = "Active user - Search Page - RRP Modal - RRP Overview - C2284: Collection Modal Overview", groups = {"activeUser"})
    public void testC2284() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeCollection(false);
        testCollectionRRPOverview(true, TestData.PLAN_PRO);
        testPanelItemsOverview();
    }

    @Test(description = "Active user - Search Page - RRP Static - RRP Overview - C2277: Resource Static Page Overview", groups = {"activeUser"})
    public void testC2277() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testResourcePageOverview(TestData.PLAN_PRO, false);
    }

    public void testResourcePageOverview(String account, boolean inModal) {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        //TODO: remove check LP prov
        discoverResourcesPage.clickOnSeeReview(!inModal);
        testRegularResourceRRPOverview(inModal, account);
        if (!(account.equals(TestData.VALID_EMAIL_RSL_SBCEO) || account.equals(TestData.VALID_EMAIL_CSL_HENRY) || account.equals(TestData.VALID_EMAIL_CSL_COBB))) {
            testWhatMembersSayWidgetOverview(account);
        }
        testSimilarResourcesSectionOverview(account);
    }

    @Test(description = "Active user - Search Page - RRP Static  - RRP Overview - C2278: Shared Resource Static Page Overview", groups = {"activeUser"})
    public void testC2278() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(true);
        testSharedResourceRRPOverview(false, TestData.PLAN_PRO);
        testWhatMembersSayWidgetOverview(TestData.PLAN_PRO);
        testSimilarResourcesSectionOverview(TestData.PLAN_PRO);
    }

    @Test(description = "Active user - Search Page - RRP Static  - RRP Overview - C2279: Collection Static Page Overview", groups = {"activeUser"})
    public void testC2279() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeCollection(true);
        testCollectionRRPOverview(false, TestData.PLAN_PRO);
        testPanelItemsOverview();
    }

    public void testCollectionStaticPageOverview(String account, boolean inModal) {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeCollection(!inModal);
        testCollectionRRPOverview(inModal, account);
        testPanelItemsOverview();
    }

    @Test(description = "Active user - Search Page - RRP Modal - RRP Buttons - C2287: LP Resource Main buttons", groups = {"activeUser"})
    public void testC2287() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testLpResourceMainButtons(false, TestData.PLAN_PRO);
    }

    public void testLpResourceMainButtons(boolean inANewTab, String account) {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeReview(inANewTab);
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

    @Test(description = "Active user - Search Page - RRP Modal - RRP Buttons - C2286: Shared Resource Main buttons", groups = {"activeUser"})
    public void testC2286() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.clickSeePreview(false);
        testThumbnailForSharedResource(true);
        testSharedResourceRRPNavigationButtonsSearchPage();
        testAddToCollectionDropdown(true);
        testGoToResourceButtonForSharedResource(true);
    }

    @Test(description = "Active user - Search Page - RRP Modal - RRP Buttons - C2288: Collection Main buttons", groups = {"activeUser"})
    public void testC2288() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testCollectionMainButtons(true, TestData.PLAN_PRO);
    }

    public void testCollectionMainButtons(boolean inModal, String account) {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeCollection(!inModal);
        if (inModal) {
            testCollectionOrUnitRRPNavigationButtonsSearchPage();
        }
        collectionRrpModal.clickOnPanelItem(0);
        testItemViewerSection();
        collectionRrpModal.clickOnSeeFullReviewsLink();
        testItemViewerSection();
        collectionRrpModal.clickOnPlayCollectionButton();
        user_curriculumManagerTest.initTest(webDriver);
        user_curriculumManagerTest.testCurriculumPlayerURL();
        testSaveCollectionButton(inModal, account);
    }

    public void testCollectionOrUnitMainButtons(boolean inModal, String account) {
        if (inModal) {
            testCollectionOrUnitRRPNavigationButtonsSearchPage();
        }
        collectionRrpModal.clickOnPanelItem(0);
        testItemViewerSection();
        collectionRrpModal.clickOnSeeFullReviewsLink();
        testItemViewerSection();
        collectionRrpModal.clickOnPlayCollectionButton();
        user_curriculumManagerTest.initTest(webDriver);
        user_curriculumManagerTest.testCurriculumPlayerURL();
        testSaveCollectionButton(inModal, account);
    }


    @Test(description = "Active user - Search Page - RRP Static - RRP Buttons - C2280: LP Resource Main buttons", groups = {"activeUser"})
    public void testC2280() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeReview(true);
        testThumbnailForRegularResource(false, TestData.PLAN_PRO);
        testAddToCollectionDropdown(false);
        testGoToResourceButtonForRegularResource(false);
        user_directoryCategoriesAndSubcategoriesTest.initTest(webDriver);
        user_directoryCategoriesAndSubcategoriesTest.testTestimonials(TestData.PLAN_PRO);
        testSeeSimilarResourcesDropdown();
    }

    @Test(description = "Active user - Search Page - RRP Static - RRP Buttons -C2281: Shared Resource Main Buttons", groups = {"activeUser"})
    public void testC2281() {
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

    @Test(description = "Active user - Search Page - RRP Static - RRP Buttons - C2282: Collection Main buttons", groups = {"activeUser"})
    public void testC2282() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickOnSeeCollection(true);
        collectionRrpModal.clickOnPlayCollectionButton();
        user_curriculumManagerTest.initTest(webDriver);
        user_curriculumManagerTest.testCurriculumPlayerURL();
        collectionRrpModal.clickOnPanelItem(0);
        testItemViewerSection();
        collectionRrpModal.clickOnSeeFullReviewsLink();
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
            Assert.assertTrue(rrp.isLimitedAccessReviewBannerDisplayed());
            Assert.assertTrue(rrp.isVisitorFavoriteButtonDisplayed());
        }

        if (account.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertTrue(rrp.isUpgradeForFullReviewButtonDisplayed());
            Assert.assertTrue(rrp.isLimitedAccessReviewBannerDisplayed());
        }
        if (account.equals(TestData.PLAN_PRO) || account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            Assert.assertTrue(rrp.isGoToResourceButtonDisplayed());
            if (!account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
                Assert.assertTrue(rrp.isFullReviewBannerDisplayed());
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
            rrpPage.clickOnAllResourceTypesDropdown();
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
        Assert.assertFalse(collectionRrp.isLimitedAccessReviewBannerDisplayed());
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
            collectionRrp.clickOnNextButtonPanelItems();
            Assert.assertTrue(collectionRrp.isPreviousButtonPanelItemsDisplayed());
            Assert.assertFalse(collectionRrp.isNextButtonPanelItemsDisplayed());
        }
        if (collectionRrp.getCollectionItemsCount() <= 4) {
            Assert.assertFalse(collectionRrp.isPreviousButtonPanelItemsDisplayed() && collectionRrp.isNextButtonPanelItemsDisplayed());
        }
        if (collectionRrp.getCollectionItemsCount() >= 9) {
            Assert.assertFalse(collectionRrp.isPreviousButtonPanelItemsDisplayed());
            Assert.assertTrue(collectionRrp.isNextButtonPanelItemsDisplayed());
            collectionRrp.clickOnNextButtonPanelItems();
            Assert.assertTrue(collectionRrp.isPreviousButtonPanelItemsDisplayed() && collectionRrp.isNextButtonPanelItemsDisplayed());
        }
    }

    public void testStepOneModal() {
        stepOneModal.waitForModal();
        Assert.assertEquals(stepOneModal.getTitleText(), TestData.STEP_ONE_MODAL_TITLE);
        stepOneModal.clickOnCloseModal();
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

    public void testNewTabFreeSampleResourceUrl() {
        discoverResourcesPage.waitForNewTab();
        discoverResourcesPage.focusDriverToLastTab();
        discoverResourcesPage.waitForLinkToLoad();
        Assert.assertTrue(!discoverResourcesPage.getUrl().contains(TestData.SERVER_URL));
        discoverResourcesPage.closeTab();
    }

    public void testNewTabRegularResourceUrl() {
        discoverResourcesPage.waitForNewTab();
        discoverResourcesPage.focusDriverToLastTab();
        discoverResourcesPage.waitForLinkToLoad();
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
        rrpPage.clickOnGetFreeAccessForTenDaysButton(false);
        testStepOneModal();
        rrpPage.clickOnGetFreeAccessForTenDaysButton(true);
        testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
    }

    public void testFavoriteButton(boolean modal) {
        if (modal) {
            rrpModal.waitForModal();
        }
        rrpPage.clickOnVisitorFavoriteButton();
        Assert.assertTrue(rrpPage.isSignInPopupLinkDisplayed() && rrpPage.isJoinNowPopupLinkDisplayed());
        rrpPage.clickOnJoinNowPopupLink();
        testStepOneModal();
        rrpPage.clickOnVisitorFavoriteButton();
        rrpPage.clickOnSignInPopupLink(true);
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
        rrpPage.clickOnGoToResourceButton(modal);
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
        rrpPage.clickOnGoToResourceButton(true);
        testNewTabUrl(TestData.STAGING_SERVER_SHARED_RESOURCE_URL);
    }

    public void testThumbnailForFreeSampleResource(boolean modal) {
        if (modal) {
            rrpModal.waitForModal();
        }
        rrpPage.clickOnThumbnail();
        testNewTabFreeSampleResourceUrl();
    }

    public void testGoToResourceButtonForFreeSampleResource(boolean modal) {
        if (modal) {
            rrpModal.waitForModal();
        }

        rrpPage.clickOnGoToResourceButton(true);
        testNewTabFreeSampleResourceUrl();
    }

    public void testSharedResourceRRPNavigationButtonsSearchPage() {
        Assert.assertTrue(rrpModal.getModalId().contains(discoverResourcesPage.getSharedResourceCardDataId(0)));
        if (discoverResourcesPage.getResourceCardDataType(0).equals(TestData.REGULAR_RESOURCE_TYPE)) {
            Assert.assertTrue(rrpModal.isPreviousButtonDisplayed());
        } else {
            Assert.assertFalse(rrpModal.isPreviousButtonDisplayed());
        }
        Assert.assertTrue(rrpModal.isNextButtonDisplayed());
        rrpModal.clickOnNextButton();
        rrpModal.waitForModal();
        Assert.assertTrue(rrpModal.getModalId().contains(discoverResourcesPage.getSharedResourceCardDataId(1)));
        rrpModal.clickOnPreviousButton();
        Assert.assertTrue(rrpModal.getModalId().contains(discoverResourcesPage.getSharedResourceCardDataId(0)));
    }

    public void testCollectionGetFreeAccessForTenDaysButton(boolean modal) {
        if (modal) {
            collectionRrpModal.waitForModal();
        }
        collectionRrpPage.clickOnGetFreeAccessForTenDaysButton(false);
        testStepOneModal();
        collectionRrpPage.clickOnGetFreeAccessForTenDaysButton(true);
        testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
    }

    public void testCollectionUpgradeForFullReviewButton(boolean modal) {
        if (modal) {
            collectionRrpModal.waitForModal();
            collectionRrpModal.clickOnCollectionUpgradeForFullReviewButton(true);
            testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
        } else {
            collectionRrpPage.clickOnCollectionUpgradeForFullReviewButton(false);
            testPageUrl(TestData.STEP_ONE_PAGE_PATH);
            collectionRrpPage.clickOnCollectionUpgradeForFullReviewButton(true);
            testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
        }
    }

    public void testSaveCollectionButton(boolean modal, String account) {
        if (modal) {
            collectionRrpModal.waitForModal();
        }
        if (account.equals(TestData.PLAN_VISITOR)) {
            collectionRrpModal.clickOnSaveCollectionButton();
            Assert.assertTrue(collectionRrpModal.isSignInPopupLinkDisplayed() && collectionRrpModal.isJoinNowPopupLinkDisplayed());
            collectionRrpModal.clickOnJoinNowPopupLink();
            testStepOneModal();
            collectionRrpModal.clickOnSaveCollectionButton();
            collectionRrpModal.clickOnSignInPopupLink(true);
            testSignInPage();
        } else { // ACTIVE & SLs
            collectionRrpModal.clickOnSaveCollectionButtonActiveUser();

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

        discoverResourcesPage.clickOnSeeCollection(false);
        collectionRrpModal.waitForModal();
        Assert.assertEquals(collectionRrpModal.getCollectionTitleText(), collectionTitles.get(0));
        collectionRrpModal.clickOnNextButtonRrp();
        Assert.assertEquals(collectionRrpModal.getCollectionTitleText(), collectionTitles.get(1));
        collectionRrpModal.clickOnPreviousButtonRrp();
        Assert.assertEquals(collectionRrpModal.getCollectionTitleText(), collectionTitles.get(0));
    }

    public void testItemViewerSection() {
        Assert.assertEquals(collectionRrp.getExpandedRrpDataId(0), collectionRrp.getPanelItemDataId(0));
        Assert.assertFalse(collectionRrp.isSeeFullReviewsLinkVisible());
        Assert.assertFalse(collectionRrp.isPreviousButtonItemViewerDisplayed());
        if (collectionRrp.getCollectionItemsCount() > 1) {
            Assert.assertTrue(collectionRrp.isNextButtonItemViewerDisplayed());
            collectionRrp.clickOnNextButtonItemViewer();
            Assert.assertEquals(collectionRrp.getExpandedRrpDataId(1), collectionRrp.getPanelItemDataId(1));
            collectionRrp.clickOnPreviousButtonItemViewer();
            Assert.assertEquals(collectionRrp.getExpandedRrpDataId(0), collectionRrp.getPanelItemDataId(0));
        }
        if (collectionRrp.getCollectionItemsCount() == 1) {
            Assert.assertFalse(collectionRrp.isNextButtonItemViewerDisplayed());
        }
        collectionRrp.clickOnCloseExpandedRrp();
        Assert.assertTrue(collectionRrp.isSeeFullReviewsLinkVisible());
    }

    public void testStartYourFreeTrialTryItFreeButton() {
        rrpPage.clickOnStartYourFreeTrialTryItFreeButton(false);
        testStepOneModal();
        rrpPage.clickOnStartYourFreeTrialTryItFreeButton(true);
        testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
    }

    public void testSeeSimilarResourcesTryItFreeButton() {
        rrpPage.clickOnBottomPageTryItFreeButton(false);
        testStepOneModal();
        rrpPage.clickOnBottomPageTryItFreeButton(true);
        testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
    }

    public void testSeeSimilarResourcesDropdown() {
        if (rrpPage.isSimilarResourcesHeaderDisplayed()) {
            rrpPage.clickOnAllResourceTypesDropdown();
            rrpPage.clickOnLessonPlansResourceType();
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
        Assert.assertTrue(rrp.isCuratorRatingDisplayed());
    }

    private void testFreeSampleResourceStartYourFreeTrialWidgetOverview() {
        Assert.assertTrue(rrpPage.isFreeSampleResourceStartYourFreeTrialWidgetDisplayed());
        Assert.assertTrue(rrpPage.isFreeSampleResourceStartYourFreeTrialUpgradeMeButtonDisplayed());
        Assert.assertEquals(rrpPage.getFreeSampleResourceStartYourFreeTrialText(), TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE);
    }

    protected void testResourceUpgradeForFullReviewButton(boolean modal) {
        if (modal) {
            rrpModal.waitForModal();
            rrpModal.clickOnUpgradeForFullReviewButton(true);
            testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
        } else {
            rrpPage.clickOnUpgradeForFullReviewButton(false);
            testPageUrl(TestData.STEP_ONE_PAGE_PATH);
            rrpPage.clickOnUpgradeForFullReviewButton(true);
            testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
        }
    }

    private void testSeeSimilarResourcesUpgradeMeButton() {
        rrpPage.clickOnBottomPageUpgradeMeButton(false);
        testPageUrl(TestData.STEP_ONE_PAGE_PATH);
        rrpPage.clickOnBottomPageUpgradeMeButton(true);
        testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
    }

    private void testStartYourFreeTrialUpgradeMeButton() {
        rrpPage.clickOnStartYourFreeTrialUpgradeMeButton(false);
        testPageUrl(TestData.STEP_ONE_PAGE_PATH);
        rrpPage.clickOnStartYourFreeTrialUpgradeMeButton(true);
        testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
    }

    private void testFreeSampleStartYourFreeTrialUpgradeMeButton() {
        rrpPage.clickOnFreeSampleStartYourFreeTrialUpgradeMeButton(false);
        testPageUrl(TestData.STEP_ONE_PAGE_PATH);
        rrpPage.clickOnFreeSampleStartYourFreeTrialUpgradeMeButton(true);
        testNewTabUrl(TestData.STEP_ONE_PAGE_PATH);
    }

    private void testFreeResourceRRPNavigationButtonsSearchPage() {
        Assert.assertEquals(rrpModal.getTitleText(), discoverResourcesPage.getFreeSampleResourceCardTitle(0));
        Assert.assertTrue(rrpModal.isNextButtonDisplayed());
        rrpModal.clickOnNextButton();
        int freeSampleResourcePosition = discoverResourcesPage.getFreeSampleResourcePosition();
        System.out.println(freeSampleResourcePosition);
        Assert.assertTrue(rrpModal.getModalId().contains(discoverResourcesPage.getRegularResourceCardDataId(freeSampleResourcePosition + 1)));
        rrpModal.clickOnPreviousButton();
        Assert.assertTrue((rrpModal.getTitleText().contains(discoverResourcesPage.getFreeSampleResourceCardTitle(0))));
    }

    protected void testAddToNewCollection() {
        rrp.clickOnAddToFolderDropdown();
        rrp.clickOnAddToNewFolderLink();
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
        rrp.clickOnAddToNewFolderLink();
        createNewFolderModal.typeName(TestData.NEW_COLLECTION_NAME);
        createNewFolderModal.typeDescription(TestData.NEW_COLLECTION_DESCRIPTION);
        createNewFolderModal.clickOnCreateFolderButton();
    }
}
