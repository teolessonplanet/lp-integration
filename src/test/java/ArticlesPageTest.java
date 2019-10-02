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

    @BeforeMethod
    public void beforeMethod() {
        headerPage = new HeaderPage(webDriver);
        articlesPage = new ArticlesPage(webDriver);
        directoryCategoriesAndSubcategoriesTest = new DirectoryCategoriesAndSubcategoriesPageTest();
        lpHomePage = new LpHomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        rrpSearchPageTest = new RRPSearchPageTest();
    }

    @Test(description = "Visitor - Lesson Planet Articles - lessonp-3331: Articles Main Page")
    public void testLessonp_3331() {
        testArticlesMainPage(TestData.INVALID_EMAIL);
    }

    @Test(description = "Freemium - Lesson Planet Articles - lessonp-5256: Articles Main Page")
    public void testLessonp_5256() {
        testArticlesMainPage(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Active - Lesson Planet Articles - lessonp-5258: Articles Main Page")
    public void testLessonp_5258() {
        testArticlesMainPage(TestData.VALID_EMAIL_ACTIVE);
    }

    @Test(description = "Visitor - Lesson Planet Articles -  lessonp-3398: Article Page")
    public void testLessonp_3398() {
        testArticlesPage(TestData.INVALID_EMAIL);
    }

    @Test(description = "Freemium - Lesson Planet Articles -  lessonp-5255: Article Page")
    public void testLessonp_5255() {
        testArticlesPage(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Active - Lesson Planet Articles -  lessonp-5257: Article Page")
    public void testLessonp_5257() {
        testArticlesPage(TestData.VALID_EMAIL_ACTIVE);
    }

    private void testArticleCard() {
        Assert.assertTrue(articlesPage.isArticleCardTitleDisplayed());
        Assert.assertTrue(articlesPage.isArticleCardDescriptionDisplayed());
        Assert.assertTrue(articlesPage.isArticleCardPhotoDisplayed());
        Assert.assertTrue(articlesPage.isArticleCardDateDisplayed());
    }

    private void testArticlesPage(String account) {
        if (!account.equals(TestData.INVALID_EMAIL)) {
            loginPage.performLogin(account, TestData.VALID_PASSWORD);
        }
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
        if (articlesPage.isRecentArticlesSectionDisplayed()) {
            Assert.assertTrue(articlesPage.getRecentArticlesNumber() > 1);
            String recentArticleTitle = articlesPage.getRecentArticleTitle(0);
            articlesPage.clickOnRecentArticle(0);
            Assert.assertEquals(articlesPage.getArticlePageTitle(), recentArticleTitle);
        }
        if (!account.equals(TestData.VALID_EMAIL_ACTIVE)) {
            directoryCategoriesAndSubcategoriesTest.reachDirectoryCategoriesAndSubcategoriesPage(webDriver);
            directoryCategoriesAndSubcategoriesTest.testStartYourTenDayFreeTrial(account);
        }
    }

    private void testArticlesMainPage(String account) {
        if (!account.equals(TestData.INVALID_EMAIL)) {
            loginPage.performLogin(account, TestData.VALID_PASSWORD);
        }

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
        if (!account.equals(TestData.VALID_EMAIL_ACTIVE)) {
            directoryCategoriesAndSubcategoriesTest.testStartYourTenDayFreeTrial(account);
        }
        if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
            lpHomePage.goBackOnePage();
        }
        rrpSearchPageTest.reachRRP(webDriver);
        rrpSearchPageTest.testWhatMembersSayWidgetOverview(account);
        directoryCategoriesAndSubcategoriesTest.reachDirectoryCategoriesAndSubcategoriesPage(webDriver);
        directoryCategoriesAndSubcategoriesTest.testTestimonials(account);
        if (!account.equals(TestData.VALID_EMAIL_ACTIVE)) {
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
