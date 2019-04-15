import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RRPStandardsPageTest extends BaseTest{
    private RRPSearchPageTest rrpSearchPageTest;
    private StateStandardsPage stateStandardsPage;
    private CommonCorePage commonCorePage;
    private CorrelatedResourcesPage correlatedResourcesPage;
    private DiscoverResourcesPage discoverResourcesPage;

    @BeforeMethod
    public void beforeMethod() {
        rrpSearchPageTest = new RRPSearchPageTest();
        stateStandardsPage = new StateStandardsPage(webDriver);
        commonCorePage = new CommonCorePage(webDriver);
        correlatedResourcesPage = new CorrelatedResourcesPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
    }

    private void reachCorrelatedResourcePage(){
        discoverResourcesPage.loadSearchPageInListView();
        stateStandardsPage.loadPage();
        stateStandardsPage.clickOnEnglishLanguageArtsButton();
        commonCorePage.clickOnSubject(TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_BREADCRUMB);
        commonCorePage.clickOnSubject(TestData.COMMON_CORE_GRADE_11_12_BREADCRUMB);
        commonCorePage.clickOnStandardCodeButton(TestData.COMMON_CORE_STANDARD_CODE_RST_11_12_1);
        commonCorePage.clickOnSeeResourcesButton();
    }

    @Test(description = "Visitor: [Standards: RRP Modal - RRP Overview]: lessonp-3411: Resource Modal Overview")
    public void testLessonp_3411() {
        reachCorrelatedResourcePage();
        correlatedResourcesPage.clickSeeReview(false);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testRegularResourceRRPOverview(true);
    }

    @Test(description = "Visitor: [Standards: RRP Static - RRP Overview]: lessonp-3428: Resource Static Page Overview)")
    public void testLessonp_3428() {
        reachCorrelatedResourcePage();
        correlatedResourcesPage.clickSeeReview(true);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testRegularResourceRRPOverview(false);
        rrpSearchPageTest.testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE);
        rrpSearchPageTest.testSimilarResourcesSectionOverview();
    }

    @Test(description = "Visitor: [Standards: RRP Modal - RRP Buttons]: lessonp-4614: Main Buttons")
    public void testLessonp_4614() {
        reachCorrelatedResourcePage();
        correlatedResourcesPage.clickSeeReview(false);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testFavoriteButton(true);
        discoverResourcesPage.closeTab();
        rrpSearchPageTest.testJoinToSeeThisResourceButton(true);
        discoverResourcesPage.closeTab();
        rrpSearchPageTest.testThumbnail(true, true);
    }

    @Test(description = "Visitor: [Standards: RRP Static - RRP Buttons]: lessonp-4615: Main Buttons")
    public void testLessonp_4615() {
        reachCorrelatedResourcePage();
        correlatedResourcesPage.clickSeeReview(true);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testFavoriteButton(false);
        discoverResourcesPage.closeTab();
        rrpSearchPageTest.testJoinToSeeThisResourceButton(false);
        discoverResourcesPage.closeTab();
        rrpSearchPageTest.testThumbnail(false, true);
        rrpSearchPageTest.testStartYourFreeTrialTryItFreeButton();
        discoverResourcesPage.closeTab();
        rrpSearchPageTest.testSeeSimilarResourcesDropdown();
        rrpSearchPageTest.testSeeSimilarResourcesTryItFreeButton();
    }
}
