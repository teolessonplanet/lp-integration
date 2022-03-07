import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_SharedWithMe_CanViewTest extends BaseTest {
    private LoginPage loginPage;
    private RSL_SharedWithMe_CanViewTest rsl_SharedWithMe_canViewTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rsl_SharedWithMe_canViewTest = new RSL_SharedWithMe_CanViewTest();
    }

    @Test(description = "Custom SL - Shared With Me - Can view - C2553: Main Page", priority = 11, groups = {"csl"})
    public void testC2553() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        rsl_SharedWithMe_canViewTest.initTest(webDriver);
        rsl_SharedWithMe_canViewTest.testSharedWithMePage();
    }

    @Test(description = "Custom SL - Shared With Me - Can view - C2554: Share a folder", priority = 12, groups = {"csl"})
    public void testC2554() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        rsl_SharedWithMe_canViewTest.initTest(webDriver);
        rsl_SharedWithMe_canViewTest.testShareFolder(TestData.VALID_EMAIL_CSL_HENRY, TestData.SHARE_FOLDER_MODAL_CSL_OWNER_NAME, TestData.CSL_HENRY_EXISTING_TEACHER_EMAIL, TestData.CSL_HENRY_TEACHER_FIRST_NAME, TestData.CSL_HENRY_TEACHER_LAST_NAME, TestData.CSL_HENRY_EXISTING_DA_EMAIL, TestData.CSL_HENRY_DA_FIRST_NAME, TestData.CSL_HENRY_DA_LAST_NAME, true);
    }

    @Test(description = "Custom SL - Shared With Me - Can view - C2555: Drag-and-drop items", priority = 13, groups = {"csl"})
    public void testC2555() {
        loginPage.performLogin(TestData.CSL_HENRY_EXISTING_TEACHER_EMAIL, TestData.VALID_PASSWORD);
        rsl_SharedWithMe_canViewTest.initTest(webDriver);
        rsl_SharedWithMe_canViewTest.testDragAndDrop(true);
    }

    @Test(description = "Custom SL - Shared With Me - Can view - C2556: Verify shared folder", priority = 14, groups = {"csl"})
    public void testC2556() {
        loginPage.performLogin(TestData.CSL_HENRY_EXISTING_TEACHER_EMAIL, TestData.VALID_PASSWORD);
        rsl_SharedWithMe_canViewTest.initTest(webDriver);
        rsl_SharedWithMe_canViewTest.testVerifyFolder(TestData.VALID_EMAIL_CSL_HENRY, true, TestData.SHARED_FOLDER_STATUS_CSL_OWNER);
    }
}
