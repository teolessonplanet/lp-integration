import com.lessonplanet.pages.HeaderPage;
import com.lessonplanet.pages.LpHomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class HeaderTest extends BaseTest {
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        headerPage = new HeaderPage(webDriver);
    }

    @Test(description = "Visitor - Header - lessonp-639:Resources")
    public void testLessonp_639() {
        lpHomePage.loadPage();
        headerPage.hoverOverResourcesButton();
        headerPage.clickOnDiscoverResourcesButton();
        Assert.assertEquals(TestData.DISCOVER_RESOURCES_PAGE_PATH, headerPage.getPath());

        headerPage.hoverOverResourcesButton();
        headerPage.clickOnBrowseResourceDirectoryButton();
        Assert.assertEquals(TestData.BROWSE_RESOURCE_DIRECTORY_PAGE_PATH, headerPage.getPath());

        headerPage.hoverOverResourcesButton();
        headerPage.clickOnSearchByStandardButton();
        Assert.assertEquals(TestData.SEARCH_BY_STANDARD_PAGE_PATH, headerPage.getPath());

        headerPage.hoverOverResourcesButton();
        headerPage.hoverOverCurriculumManagerButton();
        Assert.assertTrue(headerPage.isSignInPopupLinkDisplayed());
        Assert.assertTrue(headerPage.isSignUpPopupLinkDisplyed());
        lpHomePage.loadPage();

        headerPage.hoverOverResourcesButton();
        headerPage.clickOnCurriculumCalendarButton();
        Assert.assertEquals(TestData.CURRICULUM_CALENDAR_PAGE_PATH, headerPage.getPath());

        headerPage.hoverOverResourcesButton();
        headerPage.clickOnLessonPlanningArticlesButton();
        Assert.assertEquals(TestData.LESSON_PLANNING_ARTICLES_PAGE_PATH, headerPage.getPath());
    }

    @Test(description = "Visitor - Header - lessonp-641:Solutions")
    public void testLessonp_641() {
        lpHomePage.loadPage();
        headerPage.hoverOverSolutionsButton();
        headerPage.clickOnEducatorEditionButton();
        Assert.assertEquals(headerPage.getPath(), TestData.EDUCATOR_EDITION_PAGE_PATH);

        lpHomePage.loadPage();
        headerPage.hoverOverSolutionsButton();
        headerPage.clickOnSchoolEdition();
        Assert.assertEquals(headerPage.getUrl(), TestData.SCHOOL_EDITION_URL);

        lpHomePage.loadPage();
        headerPage.hoverOverSolutionsButton();
        headerPage.clickOnSchoolEditionAndPdLearningNetworkButton();
        Assert.assertEquals(headerPage.getUrl(), TestData.SCHOOL_EDITION_AND_PD_LEARNING_NETWORK_URL);
    }

    @Test(description = "Visitor - Header - lessonp-642:About")
    public void testLessonp_642() {

    }
}
