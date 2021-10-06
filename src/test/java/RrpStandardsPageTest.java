import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import util.TestData;

@Ignore
@Deprecated
public class RrpStandardsPageTest extends BaseTest {
    private User_RrpSearchPageTest user_rrpSearchPageTest;
    private CorrelatedResourcesPage correlatedResourcesPage;
    private DiscoverResourcesPage discoverResourcesPage;

    @BeforeMethod
    public void beforeMethod() {
        user_rrpSearchPageTest = new User_RrpSearchPageTest();
        correlatedResourcesPage = new CorrelatedResourcesPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
    }

    private void reachCorrelatedResourcePage() {
        discoverResourcesPage.loadSearchPageInListView();
        correlatedResourcesPage.loadPage(TestData.COMMON_CORE_CORRELATED_RESOURCES_PAGE_PATH);
    }

    @Test(description = "Visitor - State Standards Page - RRP Modal - lessonp-3411: Resource Modal Overview")
    public void testLessonp_3411() {
        reachCorrelatedResourcePage();
        correlatedResourcesPage.clickSeeReview(false);
        user_rrpSearchPageTest.initTest(webDriver);
        user_rrpSearchPageTest.testRegularResourceRRPOverview(true, TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - State Standards Page - RRP Static - lessonp-3428: Resource Static Page Overview)")
    public void testLessonp_3428() {
        reachCorrelatedResourcePage();
        correlatedResourcesPage.clickSeeReview(true);
        user_rrpSearchPageTest.initTest(webDriver);
        user_rrpSearchPageTest.testRegularResourceRRPOverview(false, TestData.PLAN_VISITOR);
        user_rrpSearchPageTest.testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE, TestData.PLAN_VISITOR);
        user_rrpSearchPageTest.testSimilarResourcesSectionOverview(TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - State Standards Page - RRP Modal - lessonp-4614: Main Buttons")
    public void testLessonp_4614() {
        reachCorrelatedResourcePage();
        correlatedResourcesPage.clickSeeReview(false);
        user_rrpSearchPageTest.initTest(webDriver);
        user_rrpSearchPageTest.testFavoriteButton(true);
        user_rrpSearchPageTest.testResourceGetFreeAccessForTenDaysButton(true);
        user_rrpSearchPageTest.testThumbnailForRegularResource(true, TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - State Standards Page - RRP Static - lessonp-4615: Main Buttons")
    public void testLessonp_4615() {
        reachCorrelatedResourcePage();
        correlatedResourcesPage.clickSeeReview(true);
        user_rrpSearchPageTest.initTest(webDriver);
        user_rrpSearchPageTest.testFavoriteButton(false);
        user_rrpSearchPageTest.testResourceGetFreeAccessForTenDaysButton(false);
        user_rrpSearchPageTest.testThumbnailForRegularResource(false, TestData.PLAN_VISITOR);
        user_rrpSearchPageTest.testStartYourFreeTrialTryItFreeButton();
        user_rrpSearchPageTest.testSeeSimilarResourcesDropdown();
        user_rrpSearchPageTest.testSeeSimilarResourcesTryItFreeButton();
    }
}
