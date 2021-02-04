import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_EditCollectionTest extends BaseTest {
    private LoginPage loginPage;
    private EditCollectionTest editCollectionTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        editCollectionTest = new EditCollectionTest();
        initTest();
    }

    protected void initTest() {
        editCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
    }

    @Test(description = "Cobb - Edit Collection - lessonp-5897: Edit Collection Modal Appearance")
    public void testLessonp_5897() {
        editCollectionTest.testEditFolderAppearance(TestData.VALID_EMAIL_CSL_COBB, false, TestData.NEW_FOLDER_NAME);
    }

    @Test(description = "Cobb - Edit Collection - lessonp-5898: Edit Collection Static Page Appearance")
    public void testLessonp_5898() {
        editCollectionTest.testEditFolderAppearance(TestData.VALID_EMAIL_CSL_COBB, true, TestData.NEW_FOLDER_NAME);
    }

    @Test(description = "Cobb - Edit Collection - lessonp-5899: Publish. Republish")
    public void testLessonp_5899() {
        editCollectionTest.testPublishFromEditFolder(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb - Edit Collection - lessonp-5900: Edit Collection Buttons")
    public void testLessonp_5900() {
        editCollectionTest.testEditFolderButtons(TestData.VALID_EMAIL_CSL_COBB, TestData.COPIED_FOLDER_NAME);
    }

    @Test(description = "Cobb - Edit Collection - lessonp-5901: Item Options")
    public void testLessonp_5901() {
        editCollectionTest.testItemOptions();
    }
}
