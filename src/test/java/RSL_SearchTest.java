import com.lessonplanet.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_SearchTest extends BaseTest {

    private User_SearchTest user_searchTest;
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        user_searchTest = new User_SearchTest();
        loginPage = new LoginPage(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Regular SL - Search Page - lessonp-5173:Keywordless search")
    public void testLessonp_5173() {
        user_searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_searchTest.testKeywordlessSearch(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Search Page - lessonp-5174:Keyword search")
    public void testLessonp_5174() {
        user_searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_searchTest.testKeywordSearch(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Search Page - lessonp-4016: Cards details - LP resource")
    public void testLessonp_4016() {
        testCardDetailsLpResource(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Search Page - lessonp-4017: Cards details - Collection")
    public void testLessonp_4017() {
        testCardDetailsCollection(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Search Page - lessonp-4038: User clicks See Collection footer button")
    public void testLessonp_4038() {
        testSeeCollection(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Search Page - lessonp-4039: User clicks 'Go to Resource' footer button")
    public void testLessonp_4039() {
        testGoToResource(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Search Page - lessonp-4040: User clicks 'See Full Review' footer button")
    public void testLessonp_4040() {
        testSeeFullReview(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    protected void testSeeCollection(String account) {
        user_searchTest.initTest(webDriver);
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        user_searchTest.reachSearchPageInListView();
        user_searchTest.testSeeCollection();
    }

    protected void testGoToResource(String account) {
        user_searchTest.initTest(webDriver);
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        user_searchTest.reachSearchPageInListView();
        user_searchTest.testGoToResourceButtonForRegularResource(account);
    }

    protected void testSeeFullReview(String account) {
        user_searchTest.initTest(webDriver);
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        user_searchTest.testSeeFullReviewButton(account);
    }

    protected void testCardDetailsLpResource(String account) {
        user_searchTest.initTest(webDriver);
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        user_searchTest.testLpResource(account, false);
    }

    protected void testCardDetailsCollection(String account) {
        user_searchTest.initTest(webDriver);
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        user_searchTest.testCollectionResource();
    }
}
