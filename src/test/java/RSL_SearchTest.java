import com.lessonplanet.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_SearchTest extends BaseTest {

    private User_SearchTest user_searchTest;
    private LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        user_searchTest = new User_SearchTest();
        loginPage = new LoginPage(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Regular SL - Search - C2378:Keywordless search", groups = {"rsl"})
    public void testC2378() {
        user_searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_searchTest.testKeywordlessSearch(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Search - C2379:Keyword search", groups = {"rsl"})
    public void testC2379() {
        user_searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_searchTest.testKeywordSearch(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Search - C2380: Cards details - LP resource", groups = {"rsl"})
    public void testC2380() {
        testCardDetailsLpResource(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Search - C2381: Cards details - Collection", groups = {"rsl"})
    public void testC2381() {
        testCardDetailsCollection(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Search - C2382: User clicks See Collection footer button", groups = {"rsl"})
    public void testC2382() {
        testSeeCollection(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Search - C2383: User clicks 'Go to Resource' footer button", groups = {"rsl"})
    public void testC2383() {
        testGoToResource(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Search - C2384: User clicks 'See Full Review' footer button", groups = {"rsl"})
    public void testC2384() {
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
