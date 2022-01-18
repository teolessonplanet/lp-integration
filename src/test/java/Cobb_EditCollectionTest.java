import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_EditCollectionTest extends BaseTest {
    private LoginPage loginPage;
    private User_EditCollectionTest user_editCollectionTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_editCollectionTest = new User_EditCollectionTest();
        initTest();
    }

    protected void initTest() {
        user_editCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
    }

    @Test(description = "Cobb SL - Edit Collection - lessonp-5897: Edit Collection Modal Appearance", groups = {"cobb"})
    public void testLessonp_5897() {
        user_editCollectionTest.testEditFolderAppearance(TestData.VALID_EMAIL_CSL_COBB, false, TestData.NEW_FOLDER_NAME);
    }

    @Test(description = "Cobb SL - Edit Collection - lessonp-5898: Edit Collection Static Page Appearance", groups = {"cobb"})
    public void testLessonp_5898() {
        user_editCollectionTest.testEditFolderAppearance(TestData.VALID_EMAIL_CSL_COBB, true, TestData.NEW_FOLDER_NAME);
    }

    @Test(description = "Cobb SL - Edit Collection - lessonp-5899: Publish. Republish", groups = {"cobb"})
    public void testLessonp_5899() {
        user_editCollectionTest.testPublishFromEditFolder(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Edit Collection - lessonp-5900: Edit Collection Buttons", groups = {"cobb"})
    public void testLessonp_5900() {
        user_editCollectionTest.testEditFolderButtons(TestData.VALID_EMAIL_CSL_COBB, TestData.COPIED_FOLDER_NAME);
    }

    @Test(description = "Cobb SL - Edit Collection - lessonp-5901: Item Options", groups = {"cobb"})
    public void testLessonp_5901() {
        user_editCollectionTest.testItemOptions();
    }
}
