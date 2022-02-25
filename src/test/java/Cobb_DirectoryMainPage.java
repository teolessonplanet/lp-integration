import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_DirectoryMainPage extends BaseTest {

    private RSL_DirectoryMainPageTest rsl_directoryMainPageTest;

    @BeforeMethod(alwaysRun = true)
    private void beforeMethod() {
        rsl_directoryMainPageTest = new RSL_DirectoryMainPageTest();
    }

    @Test(description = "Cobb SL - Directory Main Page - C2618: Page UI", groups = {"cobb"})
    public void testC2618() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testPageUi(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Directory Main Page - C2619: Thumbnails", groups = {"cobb"})
    public void testC2619() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testThumbnails(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Directory Main Page - C2620: Links", groups = {"cobb"})
    public void testC2620() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testLinks(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Directory Main Page - C2621: Show All button", groups = {"cobb"})
    public void testC2621() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testShowAllButton(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Directory  Main Page - C2622: Categories Modal", groups = {"cobb"})
    public void testC2622() {
        rsl_directoryMainPageTest.initTest(webDriver);
        rsl_directoryMainPageTest.testCategoriesModal(TestData.VALID_EMAIL_CSL_COBB);
    }
}
