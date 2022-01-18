import com.lessonplanet.pages.ArticlesPage;
import com.lessonplanet.pages.HeaderPage;
import com.lessonplanet.pages.LpHomePage;
import com.lessonplanet.pages.StepTwoPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class User_ArticlesPageTest extends BaseTest {
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private ArticlesPage articlesPage;
    private User_DirectoryCategoriesAndSubcategoriesPageTest user_directoryCategoriesAndSubcategoriesTest;
    private User_RrpSearchPageTest user_rrpSearchPageTest;
    private StepTwoPage stepTwoPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        headerPage = new HeaderPage(webDriver);
        articlesPage = new ArticlesPage(webDriver);
        user_directoryCategoriesAndSubcategoriesTest = new User_DirectoryCategoriesAndSubcategoriesPageTest();
        lpHomePage = new LpHomePage(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        user_rrpSearchPageTest = new User_RrpSearchPageTest();
    }

    @Test(description = "Visitor - Lesson Planet Articles - lessonp-3331: Articles Main Page", groups = {"visitor"})
    public void testLessonp_3331() {
        testArticlesMainPage(TestData.PLAN_VISITOR);
    }

    @Test(description = "Free Member - Lesson Planet Articles - lessonp-5256: Articles Main Page", groups = {"freemium"})
    public void testLessonp_5256() {
        testArticlesMainPage(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active - Lesson Planet Articles - lessonp-5258: Articles Main Page", groups = {"activeUser"})
    public void testLessonp_5258() {
        testArticlesMainPage(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Lesson Planet Articles -  lessonp-3398: Article Page", groups = {"visitor"})
    public void testLessonp_3398() {
        testArticlesPage(TestData.PLAN_VISITOR);
    }

    @Test(description = "Free Member - Lesson Planet Articles -  lessonp-5255: Article Page", groups = {"freemium"})
    public void testLessonp_5255() {
        testArticlesPage(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active - Lesson Planet Articles -  lessonp-5257: Article Page", groups = {"activeUser"})
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
            user_directoryCategoriesAndSubcategoriesTest.initTest(webDriver);
            user_directoryCategoriesAndSubcategoriesTest.testStartYourTenDayFreeTrial(account);
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
        user_directoryCategoriesAndSubcategoriesTest.initTest(webDriver);
        if (!account.equals(TestData.PLAN_PRO)) {
            user_directoryCategoriesAndSubcategoriesTest.testStartYourTenDayFreeTrial(account);
        }
        if (account.equals(TestData.PLAN_FREEMIUM)) {
            lpHomePage.goBackOnePage();
        }
        user_rrpSearchPageTest.initTest(webDriver);
        user_rrpSearchPageTest.testWhatMembersSayWidgetOverview(account);
        user_directoryCategoriesAndSubcategoriesTest.initTest(webDriver);
        user_directoryCategoriesAndSubcategoriesTest.testTestimonials(account);
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
