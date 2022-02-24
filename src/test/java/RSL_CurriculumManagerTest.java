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

    @Test(description = "Regular SL - Curriculum Manager - C2347: Access Curriculum Manager Page", groups = {"rsl"})
    public void testC2347() {
        lpHomePage.loadPage();
        user_curriculumManagerPageTest.testAccessCurriculumManagerPageFromHeader(true);
        user_curriculumManagerPageTest.testAccessCurriculumManagerPageFromSearchPage(true);
    }

    @Test(description = "Regular SL - Curriculum Manager - C2348: Create Collections", groups = {"rsl"})
    public void testC2348() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[0]);
    }

    @Test(description = "Regular SL - Curriculum Manager - C2349: Upload Resource & My Uploads Folder", groups = {"rsl"})
    public void testC2349() {
        user_curriculumManagerPageTest.testUploadResourceFromMyResources(TestData.VALID_EMAIL_RSL_SBCEO, false);
        user_curriculumManagerPageTest.testMyUploadsFolderActions(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Curriculum Manager - C2350: Favorite Resource & My Favorites Folder", groups = {"rsl"})
    public void testC2350() {
        user_curriculumManagerPageTest.testFavoriteResources(TestData.VALID_EMAIL_RSL_SBCEO);
        user_curriculumManagerPageTest.testMyFavoritesFolderActions(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Curriculum Manager - C2351: Collection: Actions Dropdown", groups = {"rsl"})
    public void testC2351() {
        curriculumManagerPage.loadPage();
        user_curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[0]);
        user_curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Curriculum Manager - C2352: Folder Actions Dropdown", groups = {"rsl"})
    public void testC2352() {
        curriculumManagerPage.loadPage();
        user_curriculumManagerPageTest.testCreateFolderFromCurriculumManager(TestData.NEW_FOLDER_NAME, TestData.FOLDER_TYPE[3]);
        user_curriculumManagerPageTest.testFolderActions(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Curriculum Manager - C2353: Create Folders (Curriculum Sets)", groups = {"rsl"})
    public void testC2353() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[1]);
    }

    @Test(description = "Regular SL - Curriculum Manager - C2354: Create Folders (Chapters)", groups = {"rsl"})
    public void testC2354() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[2]);
    }

    @Test(description = "Regular SL - Curriculum Manager - C2355: Create Folders (Lessons)", groups = {"rsl"})
    public void testC2355() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[3]);
    }

    @Test(description = "Regular SL - Curriculum Manager - C2356: Create Folders (Assessment Sets)", groups = {"rsl"})
    public void testC2356() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[4]);
    }

    @Test(description = "Regular SL - Curriculum Manager - C2357: Create Folders (Unit Modules)", groups = {"rsl"})
    public void testC2357() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[5]);
    }

    @Test(description = "Regular SL - Curriculum Manager - C2358: Create Folders (Course Folders)", groups = {"rsl"})
    public void testC2358() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[6]);
    }

    @Test(description = "Regular SL - Curriculum Manager - C2359: Create Folders (Root Folders)", groups = {"rsl"})
    public void testC2359() {
        user_curriculumManagerPageTest.testMaxLimitOfFoldersCreated(TestData.FOLDER_TYPE[7]);
    }

    @Test(description = "Regular SL - Curriculum Manager - C2360: Dragging folders into another folder", groups = {"rsl"})
    public void testC2360() {
        user_curriculumManagerPageTest.testDraggingFoldersIntoAnotherFolder(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Curriculum Manager - C2361: Drilled in view & functionality", groups = {"rsl"})
    public void testC2361() {
        user_curriculumManagerPageTest.testDrilledInViewAndFunctionality(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Curriculum Manager - C2362: Drag folders into the CB", groups = {"rsl"})
    public void testC2362() {
        user_curriculumManagerPageTest.testDragAndDrop(TestData.VALID_EMAIL_RSL_SBCEO);
    }
}
