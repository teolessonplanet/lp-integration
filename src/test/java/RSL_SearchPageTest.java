
import com.lessonplanet.pages.DiscoverResourcesPage;
import com.lessonplanet.pages.HeaderPage;
import com.lessonplanet.pages.LoginPage;
import com.lessonplanet.pages.LpHomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_SearchPageTest extends BaseTest {
    private LoginPage loginPage;
    private HeaderPage headerPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private LpHomePage lpHomePage;

    private HeaderTest headerTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        headerPage = new HeaderPage(webDriver);
        lpHomePage = new LpHomePage(webDriver);
        headerTest = new HeaderTest();
    }

    @Test(description = "Admin Manager - Regular SL - Search Page - Header - lessonp-4141:Logo")
    public void testLessonp_4141() {
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);

        lpHomePage.loadPage();
        Assert.assertTrue(headerPage.isRegularSlLogoClickable());
        headerPage.clickOnRegularSlLogo(false);
        Assert.assertEquals(lpHomePage.getPath(), TestData.LP_HOME_PAGE_PATH);

        headerPage.clickOnRegularSlLogo(true);
        Assert.assertEquals(lpHomePage.getPath(), TestData.LP_HOME_PAGE_PATH);
    }

    @Test(description = "Admin Manager - Regular SL - Search Page - Header - lessonp-4147:Header structure")
    public void testLessonp_4147() {
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);

        discoverResourcesPage.loadPage();
        Assert.assertTrue(headerPage.isSearchBarDisplayed());
        Assert.assertTrue(headerPage.isResourcesDropdownDisplayed());
        Assert.assertTrue(headerPage.isSolutionDropdownDisplayed());
        Assert.assertTrue(headerPage.isAboutDropdownDisplayed());
        Assert.assertTrue(headerPage.isMyAccountDropdownDisplayed());

        lpHomePage.loadPage();
        Assert.assertFalse(headerPage.isSearchBarDisplayed());
        Assert.assertTrue(headerPage.isResourcesDropdownDisplayed());
        Assert.assertTrue(headerPage.isSolutionDropdownDisplayed());
        Assert.assertTrue(headerPage.isAboutDropdownDisplayed());
        Assert.assertTrue(headerPage.isMyAccountDropdownDisplayed());
    }

    @Test(description = "Admin Manager - Regular SL - Search Page - Header - lessonp-4142:Search box (UI)")
    public void testLessonp_4142() {
        headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        headerTest.testSearchBox();
    }

    @Test(description = "Admin Manager - Regular SL - Search Page - Header - lessonp-4145:Resources")
    public void testLessonp_4145() {
        headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        headerTest.testResourcesButton(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE);
    }

    @Test(description = "Admin Manager - Regular SL - Search Page - Header - lessonp-4146:Solutions")
    public void testLessonp_4146() {
        headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        headerTest.testSolutionsButton();
    }

    @Test(description = "Admin Manager - Regular SL - Search Page - Header - lessonp-4148:About")
    public void testLessonp_4148() {
        headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        headerTest.testAboutButton();
    }

    @Test(description = "Admin Manager - Regular SL - Search Page - Header - lessonp-4149:Your_Account")
    public void testLessonp_4149() {
        headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        headerTest.testYourAccountButton(true);
    }

    @Test(description = "Admin Manager - Regular SL - Search Page - Header - lessonp-4144:Search box (keyword functionality)")
    public void testLessonp_4144() {
        headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        headerTest.testSearchBoxKeywordFunctionality(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE);
    }
}
