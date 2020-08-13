import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_CurriculumManagerTest extends BaseTest {

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
        curriculumManagerPageTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
    }

    @Test(description = "RSL - Curriculum Manager - lessonp-5571: Access Curriculum Manager Page")
    public void testLessonp_5571() {
        lpHomePage.loadPage();
        curriculumManagerPageTest.testAccessCurriculumManagerPageFromHeader(true);
        curriculumManagerPageTest.testAccessCurriculumManagerPageFromSearchPage(true);
    }

    @Test(description = "RSL - Curriculum Manager - lessonp-5655: Create Collections")
    public void testLessonp_5655() {
        curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[0]);
    }

    @Test(description = "RSL - Curriculum Manager - lessonp-5575: Upload Resource & My Uploads Folder")
    public void testLessonp_5575() {
        curriculumManagerPageTest.testUploadResourceFromMyResources(TestData.VALID_EMAIL_RSL_SBCEO, false);
        curriculumManagerPageTest.testMyUploadsFolderActions(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "RSL - Curriculum Manager - lessonp-5578: Favorite Resource & My Favorites Folder")
    public void testLessonp_5578() {
        curriculumManagerPageTest.testFavoriteResources(TestData.VALID_EMAIL_RSL_SBCEO);
        curriculumManagerPageTest.testMyFavoritesFolderActions(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "RSL - Curriculum Manager - lessonp-5581: Collection: Actions Dropdown")
    public void testLessonp_5581() {
        curriculumManagerPage.loadPage();
        curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[0]);
        curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "RSL - Curriculum Manager - lessonp-5582: Folder Actions Dropdown")
    public void testLessonp_5582() {
        curriculumManagerPage.loadPage();
        curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
        curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_RSL_SBCEO);
    }
}
