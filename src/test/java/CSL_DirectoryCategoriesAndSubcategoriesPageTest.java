import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_DirectoryCategoriesAndSubcategoriesPageTest extends BaseTest {
    private LoginPage loginPage;
    private RSL_DirectoryCategoriesAndSubcategoriesPageTest rsl_directoryCategoriesAndSubcategoriesPageTest;
    private User_DirectoryCategoriesAndSubcategoriesPageTest user_directoryCategoriesAndSubcategoriesPageTest;

    @BeforeMethod(alwaysRun = true)
    private void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest = new RSL_DirectoryCategoriesAndSubcategoriesPageTest();
        user_directoryCategoriesAndSubcategoriesPageTest = new User_DirectoryCategoriesAndSubcategoriesPageTest();
    }

    @Test(description = "Custom SL - Directory Page - Categories and subcategories - C2464: Page UI", groups = {"csl"})
    public void testC2464() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testPageUi(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Directory Page - Categories and subcategories - C2465: Resource Tiles", groups = {"csl"})
    public void testC2465() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testResourceTiles(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Directory Page - Categories and subcategories - C2466: RRP modal (Individual resources)", groups = {"csl"})
    public void testC2466() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testRrpIndividualResource(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Directory Page - Categories and subcategories - C2467: RRP modal (Collections)", groups = {"csl"})
    public void testC2467() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testRrpCollection(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Directory Page - Categories and subcategories - C2468: RRP static (Individual resources)", groups = {"csl"})
    public void testC2468() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testRrpIndividualResource(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Directory Page - Categories and subcategories - C2469: RRP static (Collections)", groups = {"csl"})
    public void testC2469() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testRrpCollection(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Directory Page - Categories and subcategories - C2470: Browse by Subject", groups = {"csl"})
    public void testC2470() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        user_directoryCategoriesAndSubcategoriesPageTest.testBrowseBySubject(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Directory Page - Categories and subcategories - C2471: Related Topics", groups = {"csl"})
    public void testC2471() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        user_directoryCategoriesAndSubcategoriesPageTest.testRelatedTopics();
    }
}