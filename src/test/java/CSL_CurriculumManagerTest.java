import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_CurriculumManagerTest extends BaseTest {

    private LoginPage loginPage;
    private LpHomePage lpHomePage;
    private CurriculumManagerPageTest curriculumManagerPageTest;
    private CurriculumManagerPage curriculumManagerPage;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        lpHomePage = new LpHomePage(webDriver);
        curriculumManagerPageTest = new CurriculumManagerPageTest();
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        initCurriculumManagerPageAndLogin();
    }

    public void initCurriculumManagerPageAndLogin() {
        curriculumManagerPageTest.reachCurriculumManagerPage(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
    }

    @Test(description = "CSL - Curriculum Manager - lessonp-5588: Access Curriculum Manager Page")
    public void testLessonp_5588() {
        lpHomePage.loadPage();
        curriculumManagerPageTest.testAccessCurriculumManagerPageFromHeader(true);
        curriculumManagerPageTest.testAccessCurriculumManagerPageFromSearchPage(true);
    }

    @Test(description = "CSL - Curriculum Manager - lessonp-55899: Create Collections")
    public void testLessonp_5589() {
        curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[0]);
    }

    @Test(description = "CSL - Curriculum Manager - lessonp-5590: Upload Resource & My Uploads Folder")
    public void testLessonp_5590() {
        curriculumManagerPageTest.testUploadResourceUsingTextInput(TestData.VALID_EMAIL_CSL_HENRY);
        curriculumManagerPageTest.testMyUploadsFolderActions(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "CSL - Curriculum Manager - lessonp-5591: Favorite Resource & My Favorites Folder")
    public void testLessonp_5591() {
        curriculumManagerPageTest.testFavoriteResources(TestData.VALID_EMAIL_CSL_HENRY);
        curriculumManagerPageTest.testMyFavoritesFolderActions(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "CSL - Curriculum Manager - lessonp-5592: Collection: Actions Dropdown")
    public void testLessonp_5592() {
        curriculumManagerPage.loadPage();
        curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[0]);
        curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "CSL - Curriculum Manager - lessonp-5593: Folder Actions Dropdown")
    public void testLessonp_5593() {
        curriculumManagerPage.loadPage();
        curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
        curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_CSL_HENRY, true);
    }
}
