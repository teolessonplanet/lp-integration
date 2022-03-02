import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_SharedWithMe_CanEditTest extends BaseTest {
    private LoginPage loginPage;
    private RSL_SharedWithMe_CanViewTest rsl_SharedWithMe_canViewTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rsl_SharedWithMe_canViewTest = new RSL_SharedWithMe_CanViewTest();
    }

    @Test(description = "Regular SL - Shared With Me - Can Edit - C2327: Share a folder", priority = 1, groups = {"rsl"})
    public void testC2327() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        rsl_SharedWithMe_canViewTest.initTest(webDriver);
        rsl_SharedWithMe_canViewTest.testShareFolder(TestData.VALID_EMAIL_RSL_SBCEO, TestData.SHARE_FOLDER_MODAL_RSL_OWNER_NAME, TestData.RSL_SBCEO_EXISTING_TEACHER_EMAIL, TestData.RSL_SBCEO_TEACHER_FIRST_NAME, TestData.RSL_SBCEO_TEACHER_LAST_NAME, TestData.RSL_SBCEO_EXISTING_DISTRICT_ADMIN_EMAIL, TestData.RSL_SBCEO_DA_FIRST_NAME, TestData.RSL_SBCEO_DA_LAST_NAME, false);
    }

    @Test(description = "Regular SL - Shared With Me - Can Edit - C2328: Drag-and-drop items", priority = 2, groups = {"rsl"})
    public void testC2328() {
        loginPage.performLogin(TestData.RSL_SBCEO_EXISTING_TEACHER_EMAIL, TestData.VALID_PASSWORD);
        rsl_SharedWithMe_canViewTest.initTest(webDriver);
        rsl_SharedWithMe_canViewTest.testDragAndDrop(false);
    }

    @Test(description = "Regular SL - Shared With Me - Can Edit - C2329: Verify shared folder", priority = 3, groups = {"rsl"})
    public void testC2329() {
        loginPage.performLogin(TestData.RSL_SBCEO_EXISTING_TEACHER_EMAIL, TestData.VALID_PASSWORD);
        rsl_SharedWithMe_canViewTest.initTest(webDriver);
        rsl_SharedWithMe_canViewTest.testVerifyFolder(TestData.VALID_EMAIL_RSL_SBCEO,false, TestData.SHARED_FOLDER_STATUS_RSL_OWNER);
    }
}
