import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class ArticlesPageTest extends BaseTest {
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private ArticlesPage articlesPage;
    private DirectoryCategoriesAndSubcategoriesPageTest directoryCategoriesAndSubcategoriesTest;
    private LoginPage loginPage;
    private RRPSearchPageTest rrpSearchPageTest;
    private StepTwoPage stepTwoPage;

    @BeforeMethod
    public void beforeMethod() {
        headerPage = new HeaderPage(webDriver);
        articlesPage = new ArticlesPage(webDriver);
        directoryCategoriesAndSubcategoriesTest = new DirectoryCategoriesAndSubcategoriesPageTest();
        lpHomePage = new LpHomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        rrpSearchPageTest = new RRPSearchPageTest();
    }

    @Test(description = "Visitor - Lesson Planet Articles - lessonp-3331: Articles Main Page")
    public void testLessonp_3331() {
        testArticlesMainPage(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Lesson Planet Articles - lessonp-5256: Articles Main Page")
    public void testLessonp_5256() {
        testArticlesMainPage(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active - Lesson Planet Articles - lessonp-5258: Articles Main Page")
    public void testLessonp_5258() {
        testArticlesMainPage(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Lesson Planet Articles -  lessonp-3398: Article Page")
    public void testLessonp_3398() {
        testArticlesPage(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Lesson Planet Articles -  lessonp-5255: Article Page")
    public void testLessonp_5255() {
        testArticlesPage(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active - Lesson Planet Articles -  lessonp-5257: Article Page")
    public void testLessonp_5257() {
        testArticlesPage(TestData.PLAN_PRO);
    }

    private void testArticleCard() {
        Assert.assertTrue(articlesPage.isArticleCardTitleDisplayed());
        Assert.assertTrue(articlesPage.isArticleCardDescriptionDisplayed());
        Assert.assertTrue(articlesPage.isArticleCardPhotoDisplayed());
    }

    private void testArticlesPage(String account) {
        stepTwoPage.createNewAccount(account);
        articlesPage.loadPage();
        String articleCardTitle = articlesPage.getArticleCardTitle(0);
        articlesPage.clickOnArticleCard(0);
        Assert.assertEquals(articlesPage.getArticlePageTitle(), articleCardTitle);
        Assert.assertTrue(articlesPage.isArticlePageDescriptionDisplayed());
        Assert.assertTrue(articlesPage.isArticlePageAuthorDisplayed());
        Assert.assertTrue(articlesPage.isFacebookShareButtonDisplayed());
        Assert.assertTrue(articlesPage.isTwitterShareButtonDisplayed());
        Assert.assertTrue(articlesPage.isPinterestShareButtonDisplayed());
        Assert.assertTrue(articlesPage.isLinkShareButtonDisplayed());
        if (articlesPage.isRecentArticlesSectionDisplayed()) {
            Assert.assertTrue(articlesPage.getRecentArticlesNumber() > 1);
            String recentArticleTitle = articlesPage.getRecentArticleTitle(0);
            articlesPage.clickOnRecentArticle(0);
            Assert.assertEquals(articlesPage.getArticlePageTitle(), recentArticleTitle);
        }
        if (!account.equals(TestData.PLAN_PRO)) {
            directoryCategoriesAndSubcategoriesTest.initTest(webDriver);
            directoryCategoriesAndSubcategoriesTest.testStartYourTenDayFreeTrial(account);
        }
    }

    private void testArticlesMainPage(String account) {
        stepTwoPage.createNewAccount(account);
        lpHomePage.loadPage();
        headerPage.hoverOverDiscoverButton();
        headerPage.clickOnLessonPlanningArticlesButton();
        Assert.assertEquals(TestData.LESSON_PLANNING_ARTICLES_PAGE_PATH, headerPage.getPath());
        Assert.assertEquals(articlesPage.getLessonPlanningArticlesPageTitle(), TestData.LESSON_PLANNING_ARTICLES_TITLE);
        Assert.assertTrue(articlesPage.isLessonPlanningArticlesDescriptionDisplayed());
        Assert.assertTrue(articlesPage.getArticlesCardNumber() > 1);
        testArticleCard();
        Assert.assertEquals(articlesPage.getArticleTopics(), TestData.ARTICLE_TOPICS);
        directoryCategoriesAndSubcategoriesTest.initTest(webDriver);
        if (!account.equals(TestData.PLAN_PRO)) {
            directoryCategoriesAndSubcategoriesTest.testStartYourTenDayFreeTrial(account);
        }
        if (account.equals(TestData.PLAN_FREEMIUM)) {
            lpHomePage.goBackOnePage();
        }
        rrpSearchPageTest.initTest(webDriver);
        rrpSearchPageTest.testWhatMembersSayWidgetOverview(account);
        directoryCategoriesAndSubcategoriesTest.initTest(webDriver);
        directoryCategoriesAndSubcategoriesTest.testTestimonials(account);
        if (!account.equals(TestData.PLAN_PRO)) {
            articlesPage.closeTab();
        }
        articlesPage.clickOnArticleTopicLink();
        Assert.assertEquals(articlesPage.getArticleTopics(), TestData.ARTICLE_TOPICS);
        Assert.assertEquals(articlesPage.getPath(), TestData.ART_AND_MUSIC_TOPIC_PATH);
        Assert.assertEquals(articlesPage.getArticleTopicPageTitle(), TestData.ART_AND_MUSIC_TOPIC_TITLE);
        Assert.assertTrue(articlesPage.getArticlesCardNumber() > 1);
        testArticleCard();
        if (articlesPage.isGuideSectionDisplayed()) {
            Assert.assertEquals(articlesPage.getGuideSectionTitle(), TestData.ART_AND_MUSIC_ARTICLE_GUIDE_SECTION_TITLE);
            Assert.assertTrue(articlesPage.isGuideSectionContributorNameDisplayed());
            Assert.assertTrue(articlesPage.isGuideSectionContributorPhotoDisplayed());
        }
    }
}
