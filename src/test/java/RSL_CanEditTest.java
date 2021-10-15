import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_CanEditTest extends BaseTest {
    private LoginPage loginPage;
    private RSL_CanViewTest rsl_canViewTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rsl_canViewTest = new RSL_CanViewTest();
    }

    @Test(description = "Regular SL - Shared With Me - lessonp-5973:Share a folder - Can Edit Permission", priority = 1)
    public void testLessonp_5973() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        rsl_canViewTest.initTest(webDriver);
        rsl_canViewTest.testShareFolder(TestData.VALID_EMAIL_RSL_SBCEO, TestData.SHARE_FOLDER_MODAL_RSL_OWNER_NAME, TestData.RSL_SBCEO_EXISTING_TEACHER_EMAIL, TestData.RSL_SBCEO_TEACHER_FIRST_NAME, TestData.RSL_SBCEO_TEACHER_LAST_NAME, TestData.RSL_SBCEO_EXISTING_DISTRICT_ADMIN_EMAIL, TestData.RSL_SBCEO_DA_FIRST_NAME, TestData.RSL_SBCEO_DA_LAST_NAME, false);
    }

    @Test(description = "Regular SL - Shared With Me - lessonp-6116:Drag-and-drop items - Can Edit Permission", priority = 2)
    public void testLessonp_6116() {
        loginPage.performLogin(TestData.RSL_SBCEO_EXISTING_TEACHER_EMAIL, TestData.VALID_PASSWORD);
        rsl_canViewTest.initTest(webDriver);
        rsl_canViewTest.testDragAndDrop(false);
    }

    @Test(description = "Regular SL - Shared With Me - lessonp-6117:Verify shared folder - Can Edit Permission", priority = 3)
    public void testLessonp_6117() {
        loginPage.performLogin(TestData.RSL_SBCEO_EXISTING_TEACHER_EMAIL, TestData.VALID_PASSWORD);
        rsl_canViewTest.initTest(webDriver);
        rsl_canViewTest.testVerifyFolder(TestData.VALID_EMAIL_RSL_SBCEO,false);
    }
}
