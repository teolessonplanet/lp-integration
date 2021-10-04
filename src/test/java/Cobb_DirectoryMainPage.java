import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_DirectoryMainPage extends BaseTest {

    private RSL_DirectoryMainPageTest rsl_directoryMainPageTest;

    @BeforeMethod
    private void beforeMethod() {
        rsl_directoryMainPageTest = new RSL_DirectoryMainPageTest();
    }

    @Test(description = "Cobb SL - Directory Main Page - lessonp-5910: Page UI")
    public void testLessonp_5910() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testPageUi(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Directory Main Page - lessonp-5911: Thumbnails")
    public void testLessonp_5911() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testThumbnails(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Directory Main Page - lessonp-5912: Links")
    public void testLessonp_5912() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testLinks(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Directory Main Page - lessonp-5913: Show All button")
    public void testLessonp_5913() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testShowAllButton(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Directory  Main Page - lessonp-5914: Categories Modal")
    public void testLessonp_5914() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testCategoriesModal(TestData.VALID_EMAIL_CSL_COBB);
    }
}
