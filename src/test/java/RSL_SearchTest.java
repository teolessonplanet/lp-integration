import com.lessonplanet.pages.LoginPage;
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

    @Test(description = "Regular SL - Search Page - lessonp-4016: Cards details - LP resource")
    public void testLessonp_4016() {
        searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        searchTest.testLpResource(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE,false);
    }

    @Test(description = "Regular SL - Search Page - lessonp-4017: Cards details - Collection")
    public void testLessonp_4017() {
        searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        searchTest.testCollectionResource();
    }

    @Test(description = "Regular SL - Search Page - lessonp-4038: User clicks See Collection footer button")
    public void testLessonp_4038() {
        searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        searchTest.reachSearchPageInListView();
        searchTest.testSeeCollection();
    }

    @Test(description = "Regular SL - Search Page - lessonp-4039: User clicks 'Go to Resource' footer button")
    public void testLessonp_4039() {
        searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        searchTest.reachSearchPageInListView();
        searchTest.testGoToResourceButtonForRegularResource();
    }

    @Test(description = "Regular SL - Search Page - lessonp-4040: User clicks 'See Full Review' footer button")
    public void testLessonp_4040() {
        searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        searchTest.testSeeFullReviewButton();
    }
}
