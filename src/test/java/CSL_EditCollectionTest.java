import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_EditCollectionTest extends BaseTest {
    private LoginPage loginPage;
    private EditCollectionTest editCollectionTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        editCollectionTest = new EditCollectionTest();
        initEditCollectionTestAndLogin();
    }

    private void initEditCollectionTestAndLogin() {
        editCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
    }

    @Test(description = "Custom SL - Edit Collection - lessonp-5731: Edit Collection Modal Appearance")
    public void testLessonp_5731() {
        editCollectionTest.testEditFolderAppearance(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Edit Collection - lessonp-5732: Edit Collection Static Page Appearance")
    public void testLessonp_5732() {
        editCollectionTest.testEditFolderAppearance(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Edit Collection - lessonp-5733: Publish. Republish")
    public void testLessonp_5733() {
        editCollectionTest.testPublishFromEditFolder(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Edit Collection - lessonp-5734: Edit Collection Buttons")
    public void testLessonp_5734() {
        editCollectionTest.testEditFolderButtons(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Edit Collection - lessonp-5735: Item Options")
    public void testLessonp_5735() {
        editCollectionTest.testItemOptions();
    }
}
