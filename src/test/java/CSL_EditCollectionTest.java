import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_EditCollectionTest extends BaseTest {
    private LoginPage loginPage;
    private User_EditCollectionTest user_editCollectionTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_editCollectionTest = new User_EditCollectionTest();
        initEditCollectionTestAndLogin();
    }

    private void initEditCollectionTestAndLogin() {
        user_editCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
    }

    @Test(description = "Custom SL - Edit Collection -C2481: Edit Collection Modal Appearance", groups = {"csl"})
    public void testC2481() {
        user_editCollectionTest.testEditFolderAppearance(TestData.VALID_EMAIL_CSL_HENRY, false, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Custom SL - Edit Collection - C2482: Edit Collection Static Page Appearance", groups = {"csl"})
    public void testC24822() {
        user_editCollectionTest.testEditFolderAppearance(TestData.VALID_EMAIL_CSL_HENRY, true, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Custom SL - Edit Collection - C2483: Publish. Republish", groups = {"csl"})
    public void testC2483() {
        user_editCollectionTest.testPublishFromEditFolder(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Edit Collection - C2484: Edit Collection Buttons", groups = {"csl"})
    public void testC2484() {
        user_editCollectionTest.testEditFolderButtons(TestData.VALID_EMAIL_CSL_HENRY, TestData.COPIED_FOLDER_NAME);
    }

    @Test(description = "Custom SL - Edit Collection - C2485: Item Options", groups = {"csl"})
    public void testC2485() {
        user_editCollectionTest.testItemOptions();
    }
}
