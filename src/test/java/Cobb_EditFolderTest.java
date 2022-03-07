import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_EditFolderTest extends BaseTest {
    private LoginPage loginPage;
    private User_EditFolderTest user_editFolderTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_editFolderTest = new User_EditFolderTest();
        initTest();
    }

    protected void initTest() {
        user_editFolderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
    }

    @Test(description = "Cobb SL - Edit Folder - C2625: Edit Collection Modal Appearance", groups = {"cobb"})
    public void testC2625() {
        user_editFolderTest.testEditFolderAppearance(TestData.VALID_EMAIL_CSL_COBB, false, TestData.NEW_FOLDER_NAME);
    }

    @Test(description = "Cobb SL - Edit Folder - C2626: Edit Collection Static Page Appearance", groups = {"cobb"})
    public void testC2626() {
        user_editFolderTest.testEditFolderAppearance(TestData.VALID_EMAIL_CSL_COBB, true, TestData.NEW_FOLDER_NAME);
    }

    @Test(description = "Cobb SL - Edit Folder - C2627: Publish. Republish", groups = {"cobb"})
    public void testC2627() {
        user_editFolderTest.testPublishFromEditFolder(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Edit Folder - C2628: Edit Collection Buttons", groups = {"cobb"})
    public void testC2628() {
        user_editFolderTest.testEditFolderButtons(TestData.VALID_EMAIL_CSL_COBB, TestData.COPIED_FOLDER_NAME);
    }

    @Test(description = "Cobb SL - Edit Folder - C2629: Item Options", groups = {"cobb"})
    public void testC2629() {
        user_editFolderTest.testItemOptions();
    }
}
