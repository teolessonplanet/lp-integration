import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_DirectoryMainPageTest extends BaseTest {

    private RSL_DirectoryMainPageTest rsl_directoryMainPageTest;

    @BeforeMethod
    private void beforeMethod() {
        rsl_directoryMainPageTest = new RSL_DirectoryMainPageTest();
    }

    @Test(description = "Custom SL - Directory Page - Main Page - lessonp-1730: Page UI")
    public void testLessonp_1730() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testPageUi(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Directory Page - Main Page - lessonp-1726: Thumbnails")
    public void testLessonp_1726() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testThumbnails(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Directory Page - Main Page - lessonp-1727: Links")
    public void testLessonp_1727() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testLinks(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Directory Page - Main Page - lessonp-1727: Show All button")
    public void testLessonp_1728() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testShowAllButton(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Directory Page - Main Page - lessonp-1727: Categories Modal")
    public void testLessonp_1729() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testCategoriesModal(TestData.VALID_EMAIL_CSL_HENRY);
    }
}
