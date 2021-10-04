import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_CurriculumManagerTest extends BaseTest {

    private LoginPage loginPage;
    private LpHomePage lpHomePage;
    private Regular_User_CurriculumManagerPageTest curriculumManagerPageTest;
    private CurriculumManagerPage curriculumManagerPage;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        lpHomePage = new LpHomePage(webDriver);
        curriculumManagerPageTest = new Regular_User_CurriculumManagerPageTest();
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        initCurriculumManagerPageAndLogin();
    }

    public void initCurriculumManagerPageAndLogin() {
        curriculumManagerPageTest.initTest(webDriver);
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
        curriculumManagerPageTest.testUploadResourceFromMyResources(TestData.VALID_EMAIL_CSL_HENRY, false);
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
        curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "CSL - Curriculum Manager - lessonp-5593: Folder Actions Dropdown")
    public void testLessonp_5593() {
        curriculumManagerPage.loadPage();
        curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
        curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5737:Create Folders (Curriculum Sets)")
    public void testLessonp_5737() {
        curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[1]);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5741:Create Folders (Chapters)")
    public void testLessonp_5741() {
        curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[2]);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5742:Create Folders (Lessons)")
    public void testLessonp_5742() {
        curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[3]);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5743:Create Folders (Assessment Sets)")
    public void testLessonp_5743() {
        curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[4]);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5744:Create Folders (Unit Modules)")
    public void testLessonp_5744() {
        curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[5]);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5745:Create Folders (Course Folders)")
    public void testLessonp_5745() {
        curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[6]);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5746:Create Folders (Root Folders)")
    public void testLessonp_5746() {
        curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[7]);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5817:Dragging folders into another folder")
    public void testLessonp_5817() {
        curriculumManagerPageTest.testDraggingFoldersIntoAnotherFolder(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5818:Drilled in view & functionality")
    public void testLessonp_5818() {
        curriculumManagerPageTest.testDrilledInViewAndFunctionality(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Curriculum Manager - lessonp-5825:Drag folders into the CB")
    public void testLessonp_5825() {
        curriculumManagerPageTest.testDragAndDrop(TestData.VALID_EMAIL_CSL_HENRY);
    }
}
