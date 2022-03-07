import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_EditFolderTest extends BaseTest {
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
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
    }

    @Test(description = "Regular SL - Edit Folder - C2365: Edit Collection Modal Appearance", groups = {"rsl"})
    public void testC2365() {
        user_editFolderTest.testEditFolderAppearance(TestData.VALID_EMAIL_RSL_SBCEO, false, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Regular SL - Edit Folder - C2366: Edit Collection Static Page Appearance", groups = {"rsl"})
    public void testC2366() {
        user_editFolderTest.testEditFolderAppearance(TestData.VALID_EMAIL_RSL_SBCEO, true, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Regular SL - Edit Folder - C2367: Publish. Republish", groups = {"rsl"})
    public void testC2367() {
        user_editFolderTest.testPublishFromEditFolder(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Edit Folder - C2368: Edit Collection Buttons", groups = {"rsl"})
    public void testC2368() {
        user_editFolderTest.testEditFolderButtons(TestData.VALID_EMAIL_RSL_SBCEO, TestData.COPIED_FOLDER_NAME);
    }

    @Test(description = "Regular SL - Edit Folder - C2369: Item Options", groups = {"rsl"})
    public void testC2369() {
        user_editFolderTest.testItemOptions();
    }
}
