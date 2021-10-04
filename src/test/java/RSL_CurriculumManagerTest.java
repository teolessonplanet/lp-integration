import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_CurriculumManagerTest extends BaseTest {

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
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5571: Access Curriculum Manager Page")
    public void testLessonp_5571() {
        lpHomePage.loadPage();
        curriculumManagerPageTest.testAccessCurriculumManagerPageFromHeader(true);
        curriculumManagerPageTest.testAccessCurriculumManagerPageFromSearchPage(true);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5655: Create Collections")
    public void testLessonp_5655() {
        curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[0]);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5575: Upload Resource & My Uploads Folder")
    public void testLessonp_5575() {
        curriculumManagerPageTest.testUploadResourceFromMyResources(TestData.VALID_EMAIL_RSL_SBCEO, false);
        curriculumManagerPageTest.testMyUploadsFolderActions(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5578: Favorite Resource & My Favorites Folder")
    public void testLessonp_5578() {
        curriculumManagerPageTest.testFavoriteResources(TestData.VALID_EMAIL_RSL_SBCEO);
        curriculumManagerPageTest.testMyFavoritesFolderActions(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5581: Collection: Actions Dropdown")
    public void testLessonp_5581() {
        curriculumManagerPage.loadPage();
        curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[0]);
        curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5582: Folder Actions Dropdown")
    public void testLessonp_5582() {
        curriculumManagerPage.loadPage();
        curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
        curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5806:Create Folders (Curriculum Sets)")
    public void testLessonp_5806() {
        curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[1]);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5809:Create Folders (Chapters)")
    public void testLessonp_5809() {
        curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[2]);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5810:Create Folders (Lessons)")
    public void testLessonp_5810() {
        curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[3]);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5811:Create Folders (Assessment Sets)")
    public void testLessonp_5811() {
        curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[4]);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5812:Create Folders (Unit Modules)")
    public void testLessonp_5812() {
        curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[5]);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5813:Create Folders (Course Folders)")
    public void testLessonp_5813() {
        curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[6]);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5814:Create Folders (Root Folders)")
    public void testLessonp_5814() {
        curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[7]);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5807:Dragging folders into another folder")
    public void testLessonp_5807() {
        curriculumManagerPageTest.testDraggingFoldersIntoAnotherFolder(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5808:Drilled in view & functionality")
    public void testLessonp_5808() {
        curriculumManagerPageTest.testDrilledInViewAndFunctionality(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Curriculum Manager - lessonp-5815:Drag folders into the CB")
    public void testLessonp_5815() {
        curriculumManagerPageTest.testDragAndDrop(TestData.VALID_EMAIL_RSL_SBCEO);
    }
}
