import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_DirectoryMainPageTest extends BaseTest {

    private RSL_DirectoryMainPageTest rsl_directoryMainPageTest;

    @BeforeMethod(alwaysRun = true)
    private void beforeMethod() {
        rsl_directoryMainPageTest = new RSL_DirectoryMainPageTest();
    }

    @Test(description = "Custom SL - Directory Page - Main Page - C2472: Page UI", groups = {"csl"})
    public void testC2472() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testPageUi(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Directory Page - Main Page - C2473: Thumbnails", groups = {"csl"})
    public void testC2473() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testThumbnails(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Directory Page - Main Page - C2474: Links", groups = {"csl"})
    public void testC2474() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testLinks(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Directory Page - Main Page - C2475: Show All button", groups = {"csl"})
    public void testC2475() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testShowAllButton(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Directory Page - Main Page - C2476: Categories Modal", groups = {"csl"})
    public void testC2476() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testCategoriesModal(TestData.VALID_EMAIL_CSL_HENRY);
    }
}
