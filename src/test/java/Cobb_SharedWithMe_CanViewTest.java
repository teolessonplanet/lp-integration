import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_SharedWithMe_CanViewTest extends BaseTest {
    private LoginPage loginPage;
    private RSL_SharedWithMe_CanViewTest rsl_SharedWithMe_canViewTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rsl_SharedWithMe_canViewTest = new RSL_SharedWithMe_CanViewTest();
    }

    @Test(description = "Cobb SL - Shared With Me - Can View - C2559: Main Page", priority = 11, groups = {"cobb"})
    public void testC2559() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_SharedWithMe_canViewTest.initTest(webDriver);
        rsl_SharedWithMe_canViewTest.testSharedWithMePage();
    }

    @Test(description = "Cobb SL - Shared With Me - Can View - C2560: Share a folder", priority = 12, groups = {"cobb"})
    public void testC2560() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_SharedWithMe_canViewTest.initTest(webDriver);
        rsl_SharedWithMe_canViewTest.testShareFolder(TestData.VALID_EMAIL_CSL_COBB, TestData.SHARE_FOLDER_MODAL_COBB_OWNER_NAME, TestData.CSL_COBB_EXISTING_TEACHER_EMAIL, TestData.CSL_COBB_TEACHER_FIRST_NAME, TestData.CSL_COBB_TEACHER_LAST_NAME, TestData.CSL_COBB_EXISTING_DA_EMAIL, TestData.CSL_COBB_DA_FIRST_NAME, TestData.CSL_COBB_DA_LAST_NAME, true);
    }

    @Test(description = "Cobb SL - Shared With Me - Can View -  C2561: Drag-and-drop items ", priority = 13, groups = {"cobb"})
    public void testC2561() {
        loginPage.performLogin(TestData.CSL_COBB_EXISTING_TEACHER_EMAIL, TestData.VALID_PASSWORD);
        rsl_SharedWithMe_canViewTest.initTest(webDriver);
        rsl_SharedWithMe_canViewTest.testDragAndDrop(true);
    }

    @Test(description = "Cobb SL - Shared With Me - Can View - C2562: Verify shared folder", priority = 14, groups = {"cobb"})
    public void testC2562() {
        loginPage.performLogin(TestData.CSL_COBB_EXISTING_TEACHER_EMAIL, TestData.VALID_PASSWORD);
        rsl_SharedWithMe_canViewTest.initTest(webDriver);
        rsl_SharedWithMe_canViewTest.testVerifyFolder(TestData.CSL_COBB_EXISTING_TEACHER_EMAIL, true, TestData.SHARED_FOLDER_STATUS_COBB_OWNER);
    }
}
