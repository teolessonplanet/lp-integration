import com.lessonplanet.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_SearchTest extends BaseTest {

    private SearchTest searchTest;
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        searchTest = new SearchTest();
        loginPage = new LoginPage(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Regular SL - Search Page - lessonp-5173:Keywordless search")
    public void testLessonp_5173() {
        searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        searchTest.testKeywordlessSearch(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Search Page - lessonp-5174:Keyword search")
    public void testLessonp_5174() {
        searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        searchTest.testKeywordSearch(TestData.VALID_EMAIL_RSL_SBCEO);
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
        searchTest.initTest(webDriver);
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        searchTest.reachSearchPageInListView();
        searchTest.testSeeCollection();
    }

    protected void testGoToResource(String account) {
        searchTest.initTest(webDriver);
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        searchTest.reachSearchPageInListView();
        searchTest.testGoToResourceButtonForRegularResource(account);
    }

    protected void testSeeFullReview(String account) {
        searchTest.initTest(webDriver);
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        searchTest.testSeeFullReviewButton();
    }

    protected void testCardDetailsLpResource(String account) {
        searchTest.initTest(webDriver);
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        searchTest.testLpResource(account, false);
    }

    protected void testCardDetailsCollection(String account) {
        searchTest.initTest(webDriver);
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        searchTest.testCollectionResource();
    }
}
