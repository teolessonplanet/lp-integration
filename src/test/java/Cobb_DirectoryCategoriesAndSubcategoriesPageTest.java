import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_DirectoryCategoriesAndSubcategoriesPageTest extends BaseTest {
    private LoginPage loginPage;
    private RSL_DirectoryCategoriesAndSubcategoriesPageTest rsl_directoryCategoriesAndSubcategoriesPageTest;
    private User_DirectoryCategoriesAndSubcategoriesPageTest user_directoryCategoriesAndSubcategoriesPageTest;

    @BeforeMethod(alwaysRun = true)
    private void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest = new RSL_DirectoryCategoriesAndSubcategoriesPageTest();
        user_directoryCategoriesAndSubcategoriesPageTest = new User_DirectoryCategoriesAndSubcategoriesPageTest();
    }

    @Test(description = "Cobb SL - Directory Page - Categories and subcategories - C2610: Page UI", groups = {"cobb"})
    public void testC2610() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testPageUi(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Directory Page - Categories and subcategories - C2611: Resource Tiles", groups = {"cobb"})
    public void testC2611() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testResourceTiles(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Directory Page - Categories and subcategories - C2612: RRP modal (Individual resources)", groups = {"cobb"})
    public void testC2612() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testRrpIndividualResource(TestData.VALID_EMAIL_CSL_COBB, false);
    }

    @Test(description = "Cobb SL - Directory Page - Categories and subcategories - C2613: RRP modal (Collections)", groups = {"cobb"})
    public void testC2613() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testRrpCollection(TestData.VALID_EMAIL_CSL_COBB, false);
    }

    @Test(description = "Cobb SL - Directory Page - Categories and subcategories - C2614: RRP static (Individual resources)", groups = {"cobb"})
    public void testC2614() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testRrpIndividualResource(TestData.VALID_EMAIL_CSL_COBB, true);
    }

    @Test(description = "Cobb SL - Directory Page - Categories and subcategories - C2615: RRP static (Collections)", groups = {"cobb"})
    public void testC2615() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testRrpCollection(TestData.VALID_EMAIL_CSL_COBB, true);
    }

    @Test(description = "Cobb SL - Directory Page - Categories and subcategories - C2616: Browse by Subject", groups = {"cobb"})
    public void testC2616() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        user_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        user_directoryCategoriesAndSubcategoriesPageTest.testBrowseBySubject(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Directory Page - Categories and subcategories - C2617: Related Topics", groups = {"cobb"})
    public void testC2617() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        user_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        user_directoryCategoriesAndSubcategoriesPageTest.testRelatedTopics();
    }
}
