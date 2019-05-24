import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RRPStandardsPageTest extends BaseTest{
    private RRPSearchPageTest rrpSearchPageTest;
    private CorrelatedResourcesPage correlatedResourcesPage;
    private DiscoverResourcesPage discoverResourcesPage;

    @BeforeMethod
    public void beforeMethod() {
        rrpSearchPageTest = new RRPSearchPageTest();
        correlatedResourcesPage = new CorrelatedResourcesPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
    }

    private void reachCorrelatedResourcePage(){
        discoverResourcesPage.loadSearchPageInListView();
        correlatedResourcesPage.loadPage(TestData.COMMON_CORE_CORRELATED_RESOURCES_PAGE_PATH);
    }

    @Test(description = "Visitor: [Standards: RRP Modal - RRP Overview]: lessonp-3411: Resource Modal Overview")
    public void testLessonp_3411() {
        reachCorrelatedResourcePage();
        correlatedResourcesPage.clickSeeReview(false);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testRegularResourceRRPOverview(true, TestData.INVALID_EMAIL);
    }

    @Test(description = "Visitor: [Standards: RRP Static - RRP Overview]: lessonp-3428: Resource Static Page Overview)")
    public void testLessonp_3428() {
        reachCorrelatedResourcePage();
        correlatedResourcesPage.clickSeeReview(true);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testRegularResourceRRPOverview(false, TestData.INVALID_EMAIL);
        rrpSearchPageTest.testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE, TestData.INVALID_EMAIL);
        rrpSearchPageTest.testSimilarResourcesSectionOverview(TestData.INVALID_EMAIL);
    }

    @Test(description = "Visitor: [Standards: RRP Modal - RRP Buttons]: lessonp-4614: Main Buttons")
    public void testLessonp_4614() {
        reachCorrelatedResourcePage();
        correlatedResourcesPage.clickSeeReview(false);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testFavoriteButton(true);
        rrpSearchPageTest.testResourceGetFreeAccessForTenDaysButton(true);
        rrpSearchPageTest.testThumbnail(true, true, TestData.INVALID_EMAIL);
    }

    @Test(description = "Visitor: [Standards: RRP Static - RRP Buttons]: lessonp-4615: Main Buttons")
    public void testLessonp_4615() {
        reachCorrelatedResourcePage();
        correlatedResourcesPage.clickSeeReview(true);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testFavoriteButton(false);
        rrpSearchPageTest.testResourceGetFreeAccessForTenDaysButton(false);
        rrpSearchPageTest.testThumbnail(false, true, TestData.INVALID_EMAIL);
        rrpSearchPageTest.testStartYourFreeTrialTryItFreeButton();
        rrpSearchPageTest.testSeeSimilarResourcesDropdown();
        rrpSearchPageTest.testSeeSimilarResourcesTryItFreeButton();
    }
}
