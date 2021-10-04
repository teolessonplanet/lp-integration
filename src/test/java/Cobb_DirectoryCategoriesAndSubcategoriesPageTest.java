import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_DirectoryCategoriesAndSubcategoriesPageTest extends BaseTest {
    private LoginPage loginPage;
    private RSL_DirectoryCategoriesAndSubcategoriesPageTest rsl_directoryCategoriesAndSubcategoriesPageTest;
    private Regular_User_DirectoryCategoriesAndSubcategoriesPageTest directoryCategoriesAndSubcategoriesPageTest;

    @BeforeMethod
    private void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest = new RSL_DirectoryCategoriesAndSubcategoriesPageTest();
        directoryCategoriesAndSubcategoriesPageTest = new Regular_User_DirectoryCategoriesAndSubcategoriesPageTest();
    }

    @Test(description = "Cobb SL - Directory Page - Categories and subcategories - lessonp-5902: Page UI")
    public void testLessonp_5902() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testPageUi(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Directory Page - Categories and subcategories - lessonp-5903: Resource Tiles")
    public void testLessonp_5903() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testResourceTiles(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Directory Page - Categories and subcategories - lessonp-5904: RRP modal (Individual resources)")
    public void testLessonp_5904() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testRrpIndividualResource(TestData.VALID_EMAIL_CSL_COBB, false);
    }

    @Test(description = "Cobb SL - Directory Page - Categories and subcategories - lessonp-5905: RRP modal (Collections)")
    public void testLessonp_5905() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testRrpCollection(TestData.VALID_EMAIL_CSL_COBB, false);
    }

    @Test(description = "Cobb SL - Directory Page - Categories and subcategories - lessonp-5906: RRP static (Individual resources)")
    public void testLessonp_5906() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testRrpIndividualResource(TestData.VALID_EMAIL_CSL_COBB, true);
    }

    @Test(description = "Cobb SL - Directory Page - Categories and subcategories - lessonp-5907: RRP static (Collections)")
    public void testLessonp_5907() {
        rsl_directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        rsl_directoryCategoriesAndSubcategoriesPageTest.testRrpCollection(TestData.VALID_EMAIL_CSL_COBB, true);
    }

    @Test(description = "Cobb SL - Directory Page - Categories and subcategories - lessonp-5908: Browse by Subject")
    public void testLessonp_5908() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        directoryCategoriesAndSubcategoriesPageTest.testBrowseBySubject(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Directory Page - Categories and subcategories - lessonp-5909: Related Topics")
    public void testLessonp_5909() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        directoryCategoriesAndSubcategoriesPageTest.initTest(webDriver);
        directoryCategoriesAndSubcategoriesPageTest.testRelatedTopics();
    }
}
