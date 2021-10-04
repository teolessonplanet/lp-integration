import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_EditCollectionTest extends BaseTest {
    private LoginPage loginPage;
    private Regular_User_EditCollectionTest editCollectionTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        editCollectionTest = new Regular_User_EditCollectionTest();
        initEditCollectionTestAndLogin();
    }

    private void initEditCollectionTestAndLogin() {
        editCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
    }

    @Test(description = "Regular SL - Edit Collection - lessonp-5617: Edit Collection Modal Appearance")
    public void testLessonp_5617() {
        editCollectionTest.testEditFolderAppearance(TestData.VALID_EMAIL_RSL_SBCEO, false, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Regular SL - Edit Collection - lessonp-5618: Edit Collection Static Page Appearance")
    public void testLessonp_5618() {
        editCollectionTest.testEditFolderAppearance(TestData.VALID_EMAIL_RSL_SBCEO, true, TestData.NEW_COLLECTION_NAME);
    }

    @Test(description = "Regular SL - Edit Collection - lessonp-5619: Publish. Republish")
    public void testLessonp_5619() {
        editCollectionTest.testPublishFromEditFolder(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Edit Collection - lessonp-5620: Edit Collection Buttons")
    public void testLessonp_5620() {
        editCollectionTest.testEditFolderButtons(TestData.VALID_EMAIL_RSL_SBCEO, TestData.COPIED_FOLDER_NAME);
    }

    @Test(description = "Regular SL - Edit Collection - lessonp-5621: Item Options")
    public void testLessonp_5621() {
        editCollectionTest.testItemOptions();
    }
}
