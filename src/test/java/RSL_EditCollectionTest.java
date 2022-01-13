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

    @Test(description = "Regular SL - Edit Collection - lessonp-5617: Edit Collection Modal Appearance", groups = {"rsl"})
    public void testLessonp_5617() {
        user_editCollectionTest.testEditFolderAppearance(TestData.VALID_EMAIL_RSL_SBCEO, false, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Regular SL - Edit Collection - lessonp-5618: Edit Collection Static Page Appearance", groups = {"rsl"})
    public void testLessonp_5618() {
        user_editCollectionTest.testEditFolderAppearance(TestData.VALID_EMAIL_RSL_SBCEO, true, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Regular SL - Edit Collection - lessonp-5619: Publish. Republish", groups = {"rsl"})
    public void testLessonp_5619() {
        user_editCollectionTest.testPublishFromEditFolder(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Edit Collection - lessonp-5620: Edit Collection Buttons", groups = {"rsl"})
    public void testLessonp_5620() {
        user_editCollectionTest.testEditFolderButtons(TestData.VALID_EMAIL_RSL_SBCEO, TestData.COPIED_FOLDER_NAME);
    }

    @Test(description = "Regular SL - Edit Collection - lessonp-5621: Item Options", groups = {"rsl"})
    public void testLessonp_5621() {
        user_editCollectionTest.testItemOptions();
    }
}
