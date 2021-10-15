import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_CanViewTest extends BaseTest {
    private LoginPage loginPage;
    private RSL_CanViewTest rsl_canViewTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rsl_canViewTest = new RSL_CanViewTest();
    }

    @Test(description = "Custom SL - Shared With Me - lessonp-5979: Main Page", priority = 11)
    public void testLessonp_5979() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        rsl_canViewTest.initTest(webDriver);
        rsl_canViewTest.testSharedWithMePage();
    }

    @Test(description = "Custom SL - Shared With Me - lessonp-5980: Share a folder - Can View Permission", priority = 12)
    public void testLessonp_5980() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        rsl_canViewTest.initTest(webDriver);
        rsl_canViewTest.testShareFolder(TestData.VALID_EMAIL_CSL_HENRY, TestData.SHARE_FOLDER_MODAL_CSL_OWNER_NAME, TestData.CSL_HENRY_EXISTING_TEACHER_EMAIL, TestData.CSL_HENRY_TEACHER_FIRST_NAME, TestData.CSL_HENRY_TEACHER_LAST_NAME, TestData.CSL_HENRY_EXISTING_DA_EMAIL, TestData.CSL_HENRY_DA_FIRST_NAME, TestData.CSL_HENRY_DA_LAST_NAME, true);
    }

    @Test(description = "Custom SL - Shared With Me - lessonp-5981: Drag-and-drop items - Can View Permission", priority = 13)
    public void testLessonp_5981() {
        loginPage.performLogin(TestData.CSL_HENRY_EXISTING_TEACHER_EMAIL, TestData.VALID_PASSWORD);
        rsl_canViewTest.initTest(webDriver);
        rsl_canViewTest.testDragAndDrop(true);
    }

    @Test(description = "Custom SL - Shared With Me - lessonp-6012: Verify shared folder - Can View Permission", priority = 14)
    public void testLessonp_6012() {
        loginPage.performLogin(TestData.CSL_HENRY_EXISTING_TEACHER_EMAIL, TestData.VALID_PASSWORD);
        rsl_canViewTest.initTest(webDriver);
        rsl_canViewTest.testVerifyFolder(TestData.VALID_EMAIL_CSL_HENRY, true);
    }
}
