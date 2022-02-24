import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_CurriculumManagerTest extends BaseTest {

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
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
    }

    @Test(description = "Cobb SL - Curriculum Manager - C2575: Access Curriculum Manager Page", groups = {"cobb"})
    public void testC2575() {
        lpHomePage.loadPage();
        user_curriculumManagerPageTest.testAccessCurriculumManagerPageFromHeader(true);
        user_curriculumManagerPageTest.testAccessCurriculumManagerPageFromSearchPage(true);
    }

    @Test(description = "Cobb SL - Curriculum Manager - C2576: Create Collections", groups = {"cobb"})
    public void testC2576() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[0]);
    }

    @Test(description = "Cobb SL - Curriculum Manager - C2577: Upload Resource & My Uploads Folder", groups = {"cobb"})
    public void testC2577() {
        user_curriculumManagerPageTest.testUploadResourceFromMyResources(TestData.VALID_EMAIL_CSL_COBB, false);
        user_curriculumManagerPageTest.testMyUploadsFolderActions(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Curriculum Manager - C2578: Favorite Resource & My Favorites Folder", groups = {"cobb"})
    public void testC2578() {
        user_curriculumManagerPageTest.testFavoriteResources(TestData.VALID_EMAIL_CSL_COBB);
        user_curriculumManagerPageTest.testMyFavoritesFolderActions(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Curriculum Manager - C2579: Collection: Actions Dropdown", groups = {"cobb"})
    public void testC2579() {
        curriculumManagerPage.loadPage();
        user_curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[0]);
        user_curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Curriculum Manager - C2580: Folder Actions Dropdown", groups = {"cobb"})
    public void testC2580() {
        curriculumManagerPage.loadPage();
        user_curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
        user_curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Curriculum Manager - C2581:Create Folders (Curriculum Sets)", groups = {"cobb"})
    public void testC2581() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[1]);
    }

    @Test(description = "Cobb SL - Curriculum Manager - C2582:Create Folders (Chapters)", groups = {"cobb"})
    public void testC2582() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[2]);
    }

    @Test(description = "Cobb SL - Curriculum Manager - C2583:Create Folders (Lessons)", groups = {"cobb"})
    public void testC2583() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[3]);
    }

    @Test(description = "Cobb SL - Curriculum Manager - C2584:Create Folders (Assessment Sets)", groups = {"cobb"})
    public void testC2584() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[4]);
    }

    @Test(description = "Cobb SL - Curriculum Manager - C2585:Create Folders (Unit Modules)", groups = {"cobb"})
    public void testC2585() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[5]);
    }

    @Test(description = "Cobb SL - Curriculum Manager - C2586:Create Folders (Course Folders)", groups = {"cobb"})
    public void testC2586() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[6]);
    }

    @Test(description = "Cobb SL - Curriculum Manager - C2587:Create Folders (Root Folders)", groups = {"cobb"})
    public void testC2587() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[7]);
    }

    @Test(description = "Cobb SL - Curriculum Manager - C2589:Dragging folders into another folder", groups = {"cobb"})
    public void testC2589() {
        user_curriculumManagerPageTest.testDraggingFoldersIntoAnotherFolder(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Curriculum Manager - C2588:Drilled in view & functionality", groups = {"cobb"})
    public void testC2588() {
        user_curriculumManagerPageTest.testDrilledInViewAndFunctionality(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Curriculum Manager - C2590:Drag folders into the CB", groups = {"cobb"})
    public void testC2590() {
        user_curriculumManagerPageTest.testDragAndDrop(TestData.VALID_EMAIL_CSL_COBB);
    }
}
