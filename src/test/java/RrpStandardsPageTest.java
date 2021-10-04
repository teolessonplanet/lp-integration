import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import util.TestData;
@Ignore
@Deprecated
public class RrpStandardsPageTest extends BaseTest {
    private Regular_User_RrpSearchPageTest rrpSearchPageTest;
    private CorrelatedResourcesPage correlatedResourcesPage;
    private DiscoverResourcesPage discoverResourcesPage;

    @BeforeMethod
    public void beforeMethod() {
        rrpSearchPageTest = new Regular_User_RrpSearchPageTest();
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
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testRegularResourceRRPOverview(true, TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - State Standards Page - RRP Static - lessonp-3428: Resource Static Page Overview)")
    public void testLessonp_3428() {
        reachCorrelatedResourcePage();
        correlatedResourcesPage.clickSeeReview(true);
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testRegularResourceRRPOverview(false, TestData.PLAN_VISITOR);
        rrpSearchPageTest.testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE, TestData.PLAN_VISITOR);
        rrpSearchPageTest.testSimilarResourcesSectionOverview(TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - State Standards Page - RRP Modal - lessonp-4614: Main Buttons")
    public void testLessonp_4614() {
        reachCorrelatedResourcePage();
        correlatedResourcesPage.clickSeeReview(false);
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testFavoriteButton(true);
        rrpSearchPageTest.testResourceGetFreeAccessForTenDaysButton(true);
        rrpSearchPageTest.testThumbnailForRegularResource(true, TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - State Standards Page - RRP Static - lessonp-4615: Main Buttons")
    public void testLessonp_4615() {
        reachCorrelatedResourcePage();
        correlatedResourcesPage.clickSeeReview(true);
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testFavoriteButton(false);
        rrpSearchPageTest.testResourceGetFreeAccessForTenDaysButton(false);
        rrpSearchPageTest.testThumbnailForRegularResource(false, TestData.PLAN_VISITOR);
        rrpSearchPageTest.testStartYourFreeTrialTryItFreeButton();
        rrpSearchPageTest.testSeeSimilarResourcesDropdown();
        rrpSearchPageTest.testSeeSimilarResourcesTryItFreeButton();
    }
}
