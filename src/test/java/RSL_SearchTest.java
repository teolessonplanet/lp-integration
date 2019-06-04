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

    @Test(description = "LP - Regression Tests - Admin Manager - Search Page - lessonp-4016:Cards details - LP resource")
    public void testLessonp_4016() {
        searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        searchTest.testLpResource(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE,false);
    }

    @Test(description = "LP - Regression Tests - Admin Manager - Search Page - lessonp-4017:Cards details - Collection")
    public void testLessonp_4017() {
        searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        searchTest.testCollectionResource();
    }
}
