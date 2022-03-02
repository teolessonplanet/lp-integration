import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_EditFolderTest extends BaseTest {
    private LoginPage loginPage;
    private User_EditFolderTest user_editFolderTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_editFolderTest = new User_EditFolderTest();
        initEditCollectionTestAndLogin();
    }

    private void initEditCollectionTestAndLogin() {
        user_editFolderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
    }

    @Test(description = "Custom SL - Edit Folder -C2481: Edit Collection Modal Appearance", groups = {"csl"})
    public void testC2481() {
        user_editFolderTest.testEditFolderAppearance(TestData.VALID_EMAIL_CSL_HENRY, false, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Custom SL - Edit Folder - C2482: Edit Collection Static Page Appearance", groups = {"csl"})
    public void testC24822() {
        user_editFolderTest.testEditFolderAppearance(TestData.VALID_EMAIL_CSL_HENRY, true, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Custom SL - Edit Folder - C2483: Publish. Republish", groups = {"csl"})
    public void testC2483() {
        user_editFolderTest.testPublishFromEditFolder(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Edit Folder - C2484: Edit Collection Buttons", groups = {"csl"})
    public void testC2484() {
        user_editFolderTest.testEditFolderButtons(TestData.VALID_EMAIL_CSL_HENRY, TestData.COPIED_FOLDER_NAME);
    }

    @Test(description = "Custom SL - Edit Folder - C2485: Item Options", groups = {"csl"})
    public void testC2485() {
        user_editFolderTest.testItemOptions();
    }
}
