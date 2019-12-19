import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_EditCollectionTest extends BaseTest {
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
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
    }

    @Test(description = "Regular SL - Edit Collection - lessonp-5279: Edit Collection Modal Appearance")
    public void testLessonp_5279() {
        editCollectionTest.testEditCollectionAppearance(TestData.VALID_EMAIL_RSL_SBCEO, false);
    }

    @Test(description = "Regular SL - Edit Collection - lessonp-5169: Edit Collection Static Page Appearance")
    public void testLessonp_5169() {
        editCollectionTest.testEditCollectionAppearance(TestData.VALID_EMAIL_RSL_SBCEO, true);
    }

    @Test(description = "Regular SL - Edit Collection - lessonp-5261: Publish. Republish")
    public void testLessonp_5261() {
        editCollectionTest.testPublishFromEditCollection();
    }

    @Test(description = "Regular SL - Edit Collection - lessonp-497: Edit Collection Buttons")
    public void testLessonp_497() {
        editCollectionTest.testEditCollectionButtons(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Edit Collection - lessonp-5263: Item Options")
    public void testLessonp_5263() {
        editCollectionTest.testItemOptions();
    }
}
