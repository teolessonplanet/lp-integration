import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_BrowseResourceDirectory_MainPageTest extends BaseTest {

    private RSL_BrowseResourceDirectory_MainPageTest rsl_BrowseResource_directoryMainPageTest;

    @BeforeMethod(alwaysRun = true)
    private void beforeMethod() {
        rsl_BrowseResource_directoryMainPageTest = new RSL_BrowseResourceDirectory_MainPageTest();
    }

    @Test(description = "Cobb SL - Browse Resource Directory -  Main Page - C2618: Page UI", groups = {"cobb"})
    public void testC2618() {
        rsl_BrowseResource_directoryMainPageTest.initTest(webDriver);
        rsl_BrowseResource_directoryMainPageTest.testPageUi(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Browse Resource Directory -  Main Page - C2619: Thumbnails", groups = {"cobb"})
    public void testC2619() {
        rsl_BrowseResource_directoryMainPageTest.initTest(webDriver);
        rsl_BrowseResource_directoryMainPageTest.testThumbnails(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Browse Resource Directory - Main Page - C2620: Links", groups = {"cobb"})
    public void testC2620() {
        rsl_BrowseResource_directoryMainPageTest.initTest(webDriver);
        rsl_BrowseResource_directoryMainPageTest.testLinks(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Browse Resource Directory - Main Page - C2621: Show All button", groups = {"cobb"})
    public void testC2621() {
        rsl_BrowseResource_directoryMainPageTest.initTest(webDriver);
        rsl_BrowseResource_directoryMainPageTest.testShowAllButton(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Browse Resource Directory  - Main Page - C2622: Categories Modal", groups = {"cobb"})
    public void testC2622() {
        rsl_BrowseResource_directoryMainPageTest.initTest(webDriver);
        rsl_BrowseResource_directoryMainPageTest.testCategoriesModal(TestData.VALID_EMAIL_CSL_COBB);
    }
}
