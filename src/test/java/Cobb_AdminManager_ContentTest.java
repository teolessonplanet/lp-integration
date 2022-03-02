import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_AdminManager_ContentTest extends BaseTest {
    private LoginPage loginPage;
    private RSL_AdminManager_ContentTest rsl_adminManagerContentTest;
    private CSL_AdminManager_ContentTest csl_adminManagerContentTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rsl_adminManagerContentTest = new RSL_AdminManager_ContentTest();
        csl_adminManagerContentTest = new CSL_AdminManager_ContentTest();
        rsl_adminManagerContentTest.initTest(webDriver);
    }

    @Test(description = "Cobb SL - Admin Manager - Content - C2598: Main Page", groups = {"cobb"})
    public void testC2598() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_adminManagerContentTest.testContentManagerMainPage();
    }

    @Test(description = "Cobb SL - Admin Manager - Content - C2601: Cards list", groups = {"cobb"})
    public void testC2601() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_adminManagerContentTest.testContentManagerCardsList(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Admin Manager - Content - C2599: Search", groups = {"cobb"})
    public void testC2599() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_adminManagerContentTest.testContentManagerSearch();
    }

    @Test(description = "Cobb SL - Admin Manager - Content - C2600: Sort By", groups = {"cobb"})
    public void testC2600() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_adminManagerContentTest.testContentManagerSortBy();
    }

    @Test(description = "Cobb SL - Admin Manager - Content - C2602: Add/Edit/Remove Site Specific Resource", groups = {"cobb"})
    public void testC2602() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        csl_adminManagerContentTest.initTest(webDriver);
        csl_adminManagerContentTest.testAddEditRemoveSiteSpecificResource(TestData.VALID_EMAIL_CSL_COBB);
    }
}
