import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_EditCollectionTest extends BaseTest {
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
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
    }

    @Test(description = "Regular SL - Edit Collection - C2365: Edit Collection Modal Appearance", groups = {"rsl"})
    public void testC2365() {
        user_editCollectionTest.testEditFolderAppearance(TestData.VALID_EMAIL_RSL_SBCEO, false, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Regular SL - Edit Collection - C2366: Edit Collection Static Page Appearance", groups = {"rsl"})
    public void testC2366() {
        user_editCollectionTest.testEditFolderAppearance(TestData.VALID_EMAIL_RSL_SBCEO, true, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Regular SL - Edit Collection - C2367: Publish. Republish", groups = {"rsl"})
    public void testC2367() {
        user_editCollectionTest.testPublishFromEditFolder(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Edit Collection - C2368: Edit Collection Buttons", groups = {"rsl"})
    public void testC2368() {
        user_editCollectionTest.testEditFolderButtons(TestData.VALID_EMAIL_RSL_SBCEO, TestData.COPIED_FOLDER_NAME);
    }

    @Test(description = "Regular SL - Edit Collection - C2369: Item Options", groups = {"rsl"})
    public void testC2369() {
        user_editCollectionTest.testItemOptions();
    }
}
