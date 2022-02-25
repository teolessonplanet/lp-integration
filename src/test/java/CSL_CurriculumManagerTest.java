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

    @Test(description = "CSL - Curriculum Manager - C2486: Access Curriculum Manager Page", groups = {"csl"})
    public void testC2486() {
        lpHomePage.loadPage();
        user_curriculumManagerPageTest.testAccessCurriculumManagerPageFromHeader(true);
        user_curriculumManagerPageTest.testAccessCurriculumManagerPageFromSearchPage(true);
    }

    @Test(description = "CSL - Curriculum Manager - C2487: Create Collections", groups = {"csl"})
    public void testC2487() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[0]);
    }

    @Test(description = "CSL - Curriculum Manager - C2488: Upload Resource & My Uploads Folder", groups = {"csl"})
    public void testC2488() {
        user_curriculumManagerPageTest.testUploadResourceFromMyResources(TestData.VALID_EMAIL_CSL_HENRY, false);
        user_curriculumManagerPageTest.testMyUploadsFolderActions(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "CSL - Curriculum Manager - C2489: Favorite Resource & My Favorites Folder", groups = {"csl"})
    public void testC2489() {
        user_curriculumManagerPageTest.testFavoriteResources(TestData.VALID_EMAIL_CSL_HENRY);
        user_curriculumManagerPageTest.testMyFavoritesFolderActions(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "CSL - Curriculum Manager - C2490: Collection: Actions Dropdown", groups = {"csl"})
    public void testC2490() {
        curriculumManagerPage.loadPage();
        user_curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[0]);
        user_curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "CSL - Curriculum Manager - C2491: Folder Actions Dropdown", groups = {"csl"})
    public void testC2491() {
        curriculumManagerPage.loadPage();
        user_curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
        user_curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Curriculum Manager - C2492: Create Folders (Curriculum Sets)", groups = {"csl"})
    public void testC2492() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[1]);
    }

    @Test(description = "Custom SL - Curriculum Manager - C2493: Create Folders (Chapters)", groups = {"csl"})
    public void testC2493() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[2]);
    }

    @Test(description = "Custom SL - Curriculum Manager - C2494: Create Folders (Lessons)", groups = {"csl"})
    public void testC2494() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[3]);
    }

    @Test(description = "Custom SL - Curriculum Manager - C2495: Create Folders (Assessment Sets)", groups = {"csl"})
    public void testC2495() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[4]);
    }

    @Test(description = "Custom SL - Curriculum Manager - C2496: Create Folders (Unit Modules)", groups = {"csl"})
    public void testC2496() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[5]);
    }

    @Test(description = "Custom SL - Curriculum Manager - C2497: Create Folders (Course Folders)", groups = {"csl"})
    public void testC2497() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[6]);
    }

    @Test(description = "Custom SL - Curriculum Manager - C2498: Create Folders (Root Folders)", groups = {"csl"})
    public void testC2498() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[7]);
    }

    @Test(description = "Custom SL - Curriculum Manager - C2499: Dragging folders into another folder", groups = {"csl"})
    public void testC2499() {
        user_curriculumManagerPageTest.testDraggingFoldersIntoAnotherFolder(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Curriculum Manager - C2500: Drilled in view & functionality", groups = {"csl"})
    public void testC2500() {
        user_curriculumManagerPageTest.testDrilledInViewAndFunctionality(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Curriculum Manager - C2501: Drag folders into the CB", groups = {"csl"})
    public void testC2501() {
        user_curriculumManagerPageTest.testDragAndDrop(TestData.VALID_EMAIL_CSL_HENRY);
    }
}
