import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class ArticlesTest extends BaseTest{
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private ArticlesPage articlesPage;
    private DirectoryCategoriesAndSubcategoriesTest directoryCategoriesAndSubcategoriesTest ;
    private RRPSearchPageTest rrpSearchPageTest;

    @BeforeMethod
    public void beforeMethod() {
        headerPage = new HeaderPage(webDriver);
        articlesPage = new ArticlesPage(webDriver);
        directoryCategoriesAndSubcategoriesTest = new DirectoryCategoriesAndSubcategoriesTest();
        lpHomePage = new LpHomePage(webDriver);
        rrpSearchPageTest = new RRPSearchPageTest();
    }

    @Test(description = "Automation Test Suite - Visitor - Lesson Planet Articles - lessonp-3331: Articles Main Page")
    public void testLessonp_3331() {
        lpHomePage.loadPage();
        headerPage.hoverOverResourcesButton();
        headerPage.clickOnLessonPlanningArticlesButton();
        Assert.assertEquals(TestData.LESSON_PLANNING_ARTICLES_PAGE_PATH, headerPage.getPath());
        Assert.assertEquals(articlesPage.getLessonPlanningArticlesPageTitle(), TestData.LESSON_PLANNING_ARTICLES_TITLE);
        Assert.assertTrue(articlesPage.isLessonPlanningArticlesDescriptionDisplayed());
        Assert.assertTrue(articlesPage.getArticlesCardNumber() > 1);
        testArticleCard();
        Assert.assertEquals(articlesPage.getArticleTopics(), TestData.ARTICLE_TOPICS);
        directoryCategoriesAndSubcategoriesTest.reachDirectoryCategoriesAndSubcategoriesPage(webDriver);
        directoryCategoriesAndSubcategoriesTest.testStartYourTenDayFreeTrial(TestData.INVALID_EMAIL);
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testWhatMembersSayWidgetOverview(TestData.INVALID_EMAIL);
        directoryCategoriesAndSubcategoriesTest.reachDirectoryCategoriesAndSubcategoriesPage(webDriver);
        directoryCategoriesAndSubcategoriesTest.testTestimonials(TestData.INVALID_EMAIL);
        articlesPage.closeTab();
        articlesPage.clickOnArticleTopicLink();
        Assert.assertEquals(articlesPage.getArticleTopics(), TestData.ARTICLE_TOPICS);
        Assert.assertEquals(articlesPage.getPath(), TestData.ART_AND_MUSIC_TOPIC_PATH);
        Assert.assertEquals(articlesPage.getArticleTopicPageTitle(), TestData.ART_AND_MUSIC_TOPIC_TITLE);
        Assert.assertTrue(articlesPage.getArticlesCardNumber() > 1);
        testArticleCard();
        if(articlesPage.isGuideSectionDisplayed()){
            Assert.assertEquals(articlesPage.getGuideSectionTitle(), TestData.ART_AND_MUSIC_ARTICLE_GUIDE_SECTION_TITLE);
            Assert.assertTrue(articlesPage.isGuideSectionContributorNameDisplayed());
            Assert.assertTrue(articlesPage.isGuideSectionContributorPhotoDisplayed());
        }
    }

    private void testArticleCard() {
        Assert.assertTrue(articlesPage.isArticleCardTitleDisplayed());
        Assert.assertTrue(articlesPage.isArticleCardDescriptionDisplayed());
        Assert.assertTrue(articlesPage.isArticleCardPhotoDisplayed());
        Assert.assertTrue(articlesPage.isArticleCardDateDisplayed());
    }

    @Test(description = "Automation Test Suite - Visitor - Lesson Planet Articles -  lessonp-3398: Article Page")
    public void testLessonp_3398() {
        articlesPage.loadPage();
        String articleCardTitle = articlesPage.getArticleCardTitle(0);
        articlesPage.clickOnArticleCard(0);
        Assert.assertEquals(articlesPage.getArticlePageTitle(), articleCardTitle);
        Assert.assertTrue(articlesPage.isArticlePageDescriptionDisplayed());
        Assert.assertTrue(articlesPage.isArticlePageAuthorDisplayed());
        Assert.assertTrue(articlesPage.isArticlePageDateDisplayed());
        Assert.assertTrue(articlesPage.isFacebookShareButtonDisplayed());
        Assert.assertTrue(articlesPage.isTwitterShareButtonDisplayed());
        Assert.assertTrue(articlesPage.isPinterestShareButtonDisplayed());
        Assert.assertTrue(articlesPage.isLinkShareButtonDisplayed());
        if(articlesPage.isRecentArticlesSectionDisplayed()){
            Assert.assertTrue(articlesPage.getRecentArticlesNumber() > 1);
            String recentArticleTitle = articlesPage.getRecentArticleTitle(0);
            articlesPage.clickOnRecentArticle(0);
            Assert.assertEquals(articlesPage.getArticlePageTitle(), recentArticleTitle);
        }
        directoryCategoriesAndSubcategoriesTest.reachDirectoryCategoriesAndSubcategoriesPage(webDriver);
        directoryCategoriesAndSubcategoriesTest.testStartYourTenDayFreeTrial(TestData.INVALID_EMAIL);
    }
}
