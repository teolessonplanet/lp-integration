import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_CurriculumManagerTest extends BaseTest {

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
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5571: Access Curriculum Manager Page", groups = {"rsl"})
    public void testLessonp_5571() {
        lpHomePage.loadPage();
        user_curriculumManagerPageTest.testAccessCurriculumManagerPageFromHeader(true);
        user_curriculumManagerPageTest.testAccessCurriculumManagerPageFromSearchPage(true);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5655: Create Collections", groups = {"rsl"})
    public void testLessonp_5655() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[0]);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5575: Upload Resource & My Uploads Folder", groups = {"rsl"})
    public void testLessonp_5575() {
        user_curriculumManagerPageTest.testUploadResourceFromMyResources(TestData.VALID_EMAIL_RSL_SBCEO, false);
        user_curriculumManagerPageTest.testMyUploadsFolderActions(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5578: Favorite Resource & My Favorites Folder", groups = {"rsl"})
    public void testLessonp_5578() {
        user_curriculumManagerPageTest.testFavoriteResources(TestData.VALID_EMAIL_RSL_SBCEO);
        user_curriculumManagerPageTest.testMyFavoritesFolderActions(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5581: Collection: Actions Dropdown", groups = {"rsl"})
    public void testLessonp_5581() {
        curriculumManagerPage.loadPage();
        user_curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[0]);
        user_curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5582: Folder Actions Dropdown", groups = {"rsl"})
    public void testLessonp_5582() {
        curriculumManagerPage.loadPage();
        user_curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
        user_curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5806:Create Folders (Curriculum Sets)", groups = {"rsl"})
    public void testLessonp_5806() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[1]);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5809:Create Folders (Chapters)", groups = {"rsl"})
    public void testLessonp_5809() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[2]);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5810:Create Folders (Lessons)", groups = {"rsl"})
    public void testLessonp_5810() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[3]);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5811:Create Folders (Assessment Sets)", groups = {"rsl"})
    public void testLessonp_5811() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[4]);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5812:Create Folders (Unit Modules)", groups = {"rsl"})
    public void testLessonp_5812() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[5]);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5813:Create Folders (Course Folders)", groups = {"rsl"})
    public void testLessonp_5813() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[6]);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5814:Create Folders (Root Folders)", groups = {"rsl"})
    public void testLessonp_5814() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[7]);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5807:Dragging folders into another folder", groups = {"rsl"})
    public void testLessonp_5807() {
        user_curriculumManagerPageTest.testDraggingFoldersIntoAnotherFolder(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5808:Drilled in view & functionality", groups = {"rsl"})
    public void testLessonp_5808() {
        user_curriculumManagerPageTest.testDrilledInViewAndFunctionality(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5815:Drag folders into the CB", groups = {"rsl"})
    public void testLessonp_5815() {
        user_curriculumManagerPageTest.testDragAndDrop(TestData.VALID_EMAIL_RSL_SBCEO);
    }
}
