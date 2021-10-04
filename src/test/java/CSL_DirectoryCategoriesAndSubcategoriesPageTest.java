import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_DirectoryCategoriesAndSubcategoriesPageTest extends BaseTest {
    private LoginPage loginPage;
    private RSL_DirectoryCategoriesAndSubcategoriesPageTest rsl_directoryCategoriesAndSubcategoriesPageTest;
    private Regular_User_DirectoryCategoriesAndSubcategoriesPageTest directoryCategoriesAndSubcategoriesPageTest;

    @BeforeMethod
    private void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest = new RSL_DirectoryCategoriesAndSubcategoriesPageTest();
        directoryCategoriesAndSubcategoriesPageTest = new Regular_User_DirectoryCategoriesAndSubcategoriesPageTest();
    }

    @Test(description = "Custom SL - Directory Page - Categories and subcategories - lessonp-1730: Page UI")
    public void testLessonp_1730() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testPageUi(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Directory Page - Categories and subcategories - lessonp-1731: Resource Tiles")
    public void testLessonp_1731() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testResourceTiles(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Directory Page - Categories and subcategories - lessonp-1732: RRP modal (Individual resources)")
    public void testLessonp_1732() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testRrpIndividualResource(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Directory Page - Categories and subcategories - lessonp-1737: RRP modal (Collections)")
    public void testLessonp_1737() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testRrpCollection(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Directory Page - Categories and subcategories - lessonp-1733: RRP static (Individual resources)")
    public void testLessonp_1733() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testRrpIndividualResource(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Directory Page - Categories and subcategories - lessonp-1739: RRP static (Collections)")
    public void testLessonp_1739() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testRrpCollection(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Directory Page - Categories and subcategories - lessonp-1734: Browse by Subject")
    public void testLessonp_1734() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        directoryCategoriesAndSubcategoriesPageTest.testBrowseBySubject(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Directory Page - Categories and subcategories - lessonp-1735: Related Topics")
    public void testLessonp_1735() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        directoryCategoriesAndSubcategoriesPageTest.testRelatedTopics();
    }
}