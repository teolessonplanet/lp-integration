import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_ContentManagerTest extends BaseTest {
    private LoginPage loginPage;
    private RSL_ContentManagerTest rsl_contentManagerTest;
    private CSL_ContentManagerTest csl_contentManagerTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rsl_contentManagerTest = new RSL_ContentManagerTest();
        csl_contentManagerTest = new CSL_ContentManagerTest();
        rsl_contentManagerTest.initTest(webDriver);
    }

    @Test(description = "Cobb SL - Content Manager - C2598: Main Page", groups = {"cobb"})
    public void testC2598() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_contentManagerTest.testContentManagerMainPage();
    }

    @Test(description = "Cobb SL - Content Manager - C2601: Cards list", groups = {"cobb"})
    public void testC2601() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_contentManagerTest.testContentManagerCardsList(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Content Manager - C2599: Search", groups = {"cobb"})
    public void testC2599() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_contentManagerTest.testContentManagerSearch();
    }

    @Test(description = "Cobb SL - Content Manager - C2600: Sort By", groups = {"cobb"})
    public void testC2600() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_contentManagerTest.testContentManagerSortBy();
    }

    @Test(description = "Cobb SL - Content Manager - C2602:Add/Edit/Remove Site Specific Resource", groups = {"cobb"})
    public void testC2602() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        csl_contentManagerTest.initTest(webDriver);
        csl_contentManagerTest.testAddEditRemoveSiteSpecificResource(TestData.VALID_EMAIL_CSL_COBB);
    }
}
