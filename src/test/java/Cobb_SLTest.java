import com.lessonplanet.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_SLTest extends BaseTest {
    private RSL_SearchTest rsl_searchTest;
    private CSL_SearchTest csl_searchTest;
    private SearchTest searchTest;
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        rsl_searchTest = new RSL_SearchTest();
        csl_searchTest = new CSL_SearchTest();
        searchTest = new SearchTest();
        loginPage = new LoginPage(webDriver);
    }

    protected void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Search Page - lessonp-5918: User clicks 'See Collection' footer button")
    public void testLessonp_5918() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testSeeCollection(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Search Page -  lessonp-5919: User clicks 'Go to Resource' footer button")
    public void testLessonp_5919() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testGoToResource(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Search Page -  lessonp-5920: User clicks 'See Full Review' footer button")
    public void testLessonp_5920() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testGoToResource(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Search Page -  lessonp-5940: User clicks 'Open Folder' footer button")
    public void testLessonp_5940() {
        csl_searchTest.initTest(webDriver);
        csl_searchTest.loginAndGetFolderResources(TestData.VALID_EMAIL_CSL_COBB);
        csl_searchTest.testOpenFolderButton();
    }

    @Test(description = "Search Page -  lessonp-5941: User clicks 'Folder Details' footer button")
    public void testLessonp_5941() {
        csl_searchTest.initTest(webDriver);
        csl_searchTest.loginAndGetFolderResources(TestData.VALID_EMAIL_CSL_COBB);
        csl_searchTest.testFolderDetailsButton();
    }

    @Test(description = "Search Page - lessonp-5944: Cards details - Folder: HMH/McGraw Hill")
    public void testLessonp_5944() {
        csl_searchTest.initTest(webDriver);
        csl_searchTest.loginAndGetFolderResources(TestData.VALID_EMAIL_CSL_COBB);
        csl_searchTest.testCardDetailsFolder();
    }

    @Test(description = "Search Page - lessonp-5916: Cards details - LP resource")
    public void testLessonp_5916() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testCardDetailsLpResource(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Search Page - lessonp-5917: Cards details - Collection")
    public void testLessonp_5917() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testCardDetailsCollection(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Search Page - lessonp-5999: Keyword search")
    public void testLessonp_5999() {
        searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        searchTest.testKeywordSearch(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Search Page - lessonp-6000: Keywordless search")
    public void testLessonp_6000() {
        searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        searchTest.testKeywordlessSearch(TestData.VALID_EMAIL_CSL_COBB);
    }
}
