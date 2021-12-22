import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_CanViewTest extends BaseTest {
    private LoginPage loginPage;
    private RSL_CanViewTest rsl_canViewTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rsl_canViewTest = new RSL_CanViewTest();
    }

    @Test(description = "Cobb SL - Shared With Me - lessonp-6160: Main Page", priority = 11)
    public void testLessonp_6160() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_canViewTest.initTest(webDriver);
        rsl_canViewTest.testSharedWithMePage();
    }

    @Test(description = "Cobb SL - Shared With Me - lessonp-6161: Share a folder - Can View Permission", priority = 12)
    public void testLessonp_6161() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_canViewTest.initTest(webDriver);
        rsl_canViewTest.testShareFolder(TestData.VALID_EMAIL_CSL_COBB, TestData.SHARE_FOLDER_MODAL_COBB_OWNER_NAME, TestData.CSL_COBB_EXISTING_TEACHER_EMAIL, TestData.CSL_COBB_TEACHER_FIRST_NAME, TestData.CSL_COBB_TEACHER_LAST_NAME, TestData.CSL_COBB_EXISTING_DA_EMAIL, TestData.CSL_COBB_DA_FIRST_NAME, TestData.CSL_COBB_DA_LAST_NAME, true);
    }

    @Test(description = "Cobb SL - Shared With Me - lessonp-6162: Drag-and-drop items - Can View Permission", priority = 13)
    public void testLessonp_6162() {
        loginPage.performLogin(TestData.CSL_COBB_EXISTING_TEACHER_EMAIL, TestData.VALID_PASSWORD);
        rsl_canViewTest.initTest(webDriver);
        rsl_canViewTest.testDragAndDrop(true);
    }

    @Test(description = "Cobb SL - Shared With Me - lessonp-6163: Verify shared folder - Can View Permission", priority = 14)
    public void testLessonp_6163() {
        loginPage.performLogin(TestData.CSL_COBB_EXISTING_TEACHER_EMAIL, TestData.VALID_PASSWORD);
        rsl_canViewTest.initTest(webDriver);
        rsl_canViewTest.testVerifyFolder(TestData.CSL_COBB_EXISTING_TEACHER_EMAIL, true, TestData.SHARED_FOLDER_STATUS_COBB_OWNER);
    }
}
