import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_CurriculumManagerTest extends BaseTest {

    private LoginPage loginPage;
    private LpHomePage lpHomePage;
    private User_CurriculumManagerPageTest user_curriculumManagerPageTest;
    private CurriculumManagerPage curriculumManagerPage;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        lpHomePage = new LpHomePage(webDriver);
        user_curriculumManagerPageTest = new User_CurriculumManagerPageTest();
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        initCurriculumManagerPageAndLogin();
    }

    public void initCurriculumManagerPageAndLogin() {
        user_curriculumManagerPageTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
    }

    @Test(description = "Cobb SL - Curriculum Manager - lessonp-5945: Access Curriculum Manager Page")
    public void testLessonp_5945() {
        lpHomePage.loadPage();
        user_curriculumManagerPageTest.testAccessCurriculumManagerPageFromHeader(true);
        user_curriculumManagerPageTest.testAccessCurriculumManagerPageFromSearchPage(true);
    }

    @Test(description = "Cobb SL - Curriculum Manager - lessonp-5946: Create Collections")
    public void testLessonp_5946() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[0]);
    }

    @Test(description = "Cobb SL - Curriculum Manager - lessonp-5947: Upload Resource & My Uploads Folder")
    public void testLessonp_5947() {
        user_curriculumManagerPageTest.testUploadResourceFromMyResources(TestData.VALID_EMAIL_CSL_COBB, false);
        user_curriculumManagerPageTest.testMyUploadsFolderActions(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Curriculum Manager - lessonp-5948: Favorite Resource & My Favorites Folder")
    public void testLessonp_5948() {
        user_curriculumManagerPageTest.testFavoriteResources(TestData.VALID_EMAIL_CSL_COBB);
        user_curriculumManagerPageTest.testMyFavoritesFolderActions(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Curriculum Manager - lessonp-5949: Collection: Actions Dropdown")
    public void testLessonp_5949() {
        curriculumManagerPage.loadPage();
        user_curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[0]);
        user_curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Curriculum Manager - lessonp-5950: Folder Actions Dropdown")
    public void testLessonp_5950() {
        curriculumManagerPage.loadPage();
        user_curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
        user_curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Curriculum Manager - lessonp-5951:Create Folders (Curriculum Sets)")
    public void testLessonp_5951() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[1]);
    }

    @Test(description = "Cobb SL - Curriculum Manager - lessonp-5952:Create Folders (Chapters)")
    public void testLessonp_5952() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[2]);
    }

    @Test(description = "Cobb SL - Curriculum Manager - lessonp-5953:Create Folders (Lessons)")
    public void testLessonp_5953() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[3]);
    }

    @Test(description = "Cobb SL - Curriculum Manager - lessonp-5954:Create Folders (Assessment Sets)")
    public void testLessonp_5954() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[4]);
    }

    @Test(description = "Cobb SL - Curriculum Manager - lessonp-5955:Create Folders (Unit Modules)")
    public void testLessonp_5955() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[5]);
    }

    @Test(description = "Cobb SL - Curriculum Manager - lessonp-5956:Create Folders (Course Folders)")
    public void testLessonp_5956() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[6]);
    }

    @Test(description = "Cobb SL - Curriculum Manager - lessonp-5957:Create Folders (Root Folders)")
    public void testLessonp_5957() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[7]);
    }

    @Test(description = "Cobb SL - Curriculum Manager - lessonp-5996:Dragging folders into another folder")
    public void testLessonp_5996() {
        user_curriculumManagerPageTest.testDraggingFoldersIntoAnotherFolder(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Curriculum Manager - lessonp-5997:Drilled in view & functionality")
    public void testLessonp_5997() {
        user_curriculumManagerPageTest.testDrilledInViewAndFunctionality(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Curriculum Manager - lessonp-5998:Drag folders into the CB")
    public void testLessonp_5998() {
        user_curriculumManagerPageTest.testDragAndDrop(TestData.VALID_EMAIL_CSL_COBB);
    }
}
