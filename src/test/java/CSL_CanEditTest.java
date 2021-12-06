import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_CanEditTest extends BaseTest {
    private LoginPage loginPage;
    private RSL_CanViewTest rsl_canViewTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rsl_canViewTest = new RSL_CanViewTest();
    }

    @Test(description = "Custom SL - Shared With Me - lessonp-5982: Share a folder - Can View Permission", priority = 1)
    public void testLessonp_5980() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        rsl_canViewTest.initTest(webDriver);
        rsl_canViewTest.testShareFolder(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.SHARE_FOLDER_MODAL_QA_CUSTOM_OWNER_NAME, TestData.CSL_QA_CUSTOM_EXISTING_TEACHER_EMAIL, TestData.CSL_QA_CUSTOM_TEACHER_FIRST_NAME, TestData.CSL_QA_CUSTOM_TEACHER_LAST_NAME, TestData.CSL_QA_CUSTOM_EXISTING_DISTRICT_ADMIN_EMAIL, TestData.CSL_QA_CUSTOM_EXISTING_DISTRICT_ADMIN_FIRST_NAME, TestData.CSL_QA_CUSTOM_EXISTING_DISTRICT_ADMIN_LAST_NAME, false);
    }

    @Test(description = "Custom SL - Shared With Me - lessonp-5991: Drag-and-drop items - Can View Permission", priority = 2)
    public void testLessonp_5991() {
        loginPage.performLogin(TestData.CSL_QA_CUSTOM_EXISTING_TEACHER_EMAIL, TestData.VALID_PASSWORD);
        rsl_canViewTest.initTest(webDriver);
        rsl_canViewTest.testDragAndDrop(false);
    }

    @Test(description = "Custom SL - Shared With Me - lessonp-5983: Verify shared folder - Can View Permission", priority = 3)
    public void testLessonp_5983() {
        loginPage.performLogin(TestData.CSL_QA_CUSTOM_EXISTING_TEACHER_EMAIL, TestData.VALID_PASSWORD);
        rsl_canViewTest.initTest(webDriver);
        rsl_canViewTest.testVerifyFolder(TestData.VALID_EMAIL_CSL_QA_CUSTOM, false, TestData.SHARED_FOLDER_STATUS_QA_CUSTOM_OWNER);
    }
}