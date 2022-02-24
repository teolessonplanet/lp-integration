import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_SearchTest extends BaseTest {
    private RSL_SearchTest rsl_searchTest;
    private CSL_SearchTest csl_searchTest;
    private User_SearchTest user_searchTest;
    private LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        rsl_searchTest = new RSL_SearchTest();
        csl_searchTest = new CSL_SearchTest();
        user_searchTest = new User_SearchTest();
        loginPage = new LoginPage(webDriver);
    }

    @Test(description = "Cobb SL - Search Page - C2630: User clicks 'See Collection' footer button", groups = {"cobb"})
    public void testC2630() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testSeeCollection(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Search Page - C2631: User clicks 'Go to Resource' footer button", groups = {"cobb"})
    public void testC2631() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testGoToResource(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Search Page - C2632: User clicks 'See Full Review' footer button", groups = {"cobb"})
    public void testC2632() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testGoToResource(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Search Page - C2633: User clicks 'Open Folder' footer button", groups = {"cobb"})
    public void testC2633() {
        csl_searchTest.initTest(webDriver);
        csl_searchTest.loginAndGetFolderResources(TestData.VALID_EMAIL_CSL_COBB);
        csl_searchTest.testOpenFolderButton();
    }

    @Test(description = "Cobb SL - Search Page - C2634: User clicks 'Folder Details' footer button", groups = {"cobb"})
    public void testC2634() {
        csl_searchTest.initTest(webDriver);
        csl_searchTest.loginAndGetFolderResources(TestData.VALID_EMAIL_CSL_COBB);
        csl_searchTest.testFolderDetailsButton();
    }

    @Test(description = "Cobb SL - Search Page - C2635: Cards details - Folder: HMH/McGraw Hill", groups = {"cobb"})
    public void testC2635() {
        csl_searchTest.initTest(webDriver);
        csl_searchTest.loginAndGetFolderResources(TestData.VALID_EMAIL_CSL_COBB);
        csl_searchTest.testCardDetailsFolder();
    }

    @Test(description = "Cobb SL - Search Page - C2636: Cards details - LP resource", groups = {"cobb"})
    public void testC2636() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testCardDetailsLpResource(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Search Page - C2637: Cards details - Collection", groups = {"cobb"})
    public void testC2637() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testCardDetailsCollection(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Search Page - C2638: Keyword search", groups = {"cobb"})
    public void testC2638() {
        user_searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        user_searchTest.testKeywordSearch(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Search Page - C2639: Keywordless search", groups = {"cobb"})
    public void testC2639() {
        user_searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        user_searchTest.testKeywordlessSearch(TestData.VALID_EMAIL_CSL_COBB);
    }
}
