import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_CurriculumManagerTest extends BaseTest {

    private LoginPage loginPage;
    private LpHomePage lpHomePage;
    private User_CurriculumManagerPageTest user_curriculumManagerPageTest;
    private CurriculumManagerPage curriculumManagerPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        lpHomePage = new LpHomePage(webDriver);
        user_curriculumManagerPageTest = new User_CurriculumManagerPageTest();
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        initCurriculumManagerPageAndLogin();
    }

    public void initCurriculumManagerPageAndLogin() {
        user_curriculumManagerPageTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
    }

    @Test(description = "CSL - Curriculum Manager - lessonp-5588: Access Curriculum Manager Page", groups = {"csl"})
    public void testLessonp_5588() {
        lpHomePage.loadPage();
        user_curriculumManagerPageTest.testAccessCurriculumManagerPageFromHeader(true);
        user_curriculumManagerPageTest.testAccessCurriculumManagerPageFromSearchPage(true);
    }

    @Test(description = "CSL - Curriculum Manager - lessonp-55899: Create Collections", groups = {"csl"})
    public void testLessonp_5589() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[0]);
    }

    @Test(description = "CSL - Curriculum Manager - lessonp-5590: Upload Resource & My Uploads Folder", groups = {"csl"})
    public void testLessonp_5590() {
        user_curriculumManagerPageTest.testUploadResourceFromMyResources(TestData.VALID_EMAIL_CSL_HENRY, false);
        user_curriculumManagerPageTest.testMyUploadsFolderActions(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "CSL - Curriculum Manager - lessonp-5591: Favorite Resource & My Favorites Folder", groups = {"csl"})
    public void testLessonp_5591() {
        user_curriculumManagerPageTest.testFavoriteResources(TestData.VALID_EMAIL_CSL_HENRY);
        user_curriculumManagerPageTest.testMyFavoritesFolderActions(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "CSL - Curriculum Manager - lessonp-5592: Collection: Actions Dropdown", groups = {"csl"})
    public void testLessonp_5592() {
        curriculumManagerPage.loadPage();
        user_curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[0]);
        user_curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "CSL - Curriculum Manager - lessonp-5593: Folder Actions Dropdown", groups = {"csl"})
    public void testLessonp_5593() {
        curriculumManagerPage.loadPage();
        user_curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
        user_curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5737:Create Folders (Curriculum Sets)", groups = {"csl"})
    public void testLessonp_5737() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[1]);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5741:Create Folders (Chapters)", groups = {"csl"})
    public void testLessonp_5741() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[2]);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5742:Create Folders (Lessons)", groups = {"csl"})
    public void testLessonp_5742() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[3]);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5743:Create Folders (Assessment Sets)", groups = {"csl"})
    public void testLessonp_5743() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[4]);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5744:Create Folders (Unit Modules)", groups = {"csl"})
    public void testLessonp_5744() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[5]);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5745:Create Folders (Course Folders)", groups = {"csl"})
    public void testLessonp_5745() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[6]);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5746:Create Folders (Root Folders)", groups = {"csl"})
    public void testLessonp_5746() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[7]);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5817:Dragging folders into another folder", groups = {"csl"})
    public void testLessonp_5817() {
        user_curriculumManagerPageTest.testDraggingFoldersIntoAnotherFolder(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5818:Drilled in view & functionality", groups = {"csl"})
    public void testLessonp_5818() {
        user_curriculumManagerPageTest.testDrilledInViewAndFunctionality(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5825:Drag folders into the CB", groups = {"csl"})
    public void testLessonp_5825() {
        user_curriculumManagerPageTest.testDragAndDrop(TestData.VALID_EMAIL_CSL_HENRY);
    }
}
