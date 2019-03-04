import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class HeaderTest extends BaseTest {
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private SignInModal signInModal;
    private StepOneModal stepOneModal;
    private LoginPage loginPage;
    private DiscoverResourcesPage discoverResourcesPage;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        headerPage = new HeaderPage(webDriver);
        signInModal = new SignInModal(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        loginPage = new LoginPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
    }

    public void init(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Visitor - Header - lessonp-3970:LP Logo")
    public void testLessonp_3970() {
        testLogo(false);
    }

    @Test(description = "Freemium - Header - lessonp-4104:LP Logo")
    public void testLessonp_4104() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testLogo(false);
    }

    @Test(description = "Visitor - Header - lessonp-4108:LP Logo")
    public void testLessonp_4108() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testLogo(false);
    }

    @Test(description = "Visitor - Header - lessonp-643:Header structure")
    public void testLessonp_643() {
        discoverResourcesPage.loadPage();
        Assert.assertTrue(headerPage.isSearchBarDisplayed());
        testButtonsVisitor();

        lpHomePage.loadPage();
        Assert.assertFalse(headerPage.isSearchBarDisplayed());
        testDropdowns();
        Assert.assertTrue(headerPage.isPricingButtonDisplayed());
        Assert.assertTrue(headerPage.isSignInButtonDisplayed());
        Assert.assertTrue(headerPage.isTryItFreeButtonDisplayed());

        headerPage.clickOnPricingButton();
        Assert.assertEquals(headerPage.getPath(), TestData.PRICING_PAGE_PATH);

        headerPage.clickOnSignInButton(false);
        Assert.assertEquals(signInModal.getModalTitle(), TestData.SIGN_IN_MODAL_TITLE_TEXT);
        signInModal.clickOnClose();

        headerPage.clickOnTryItFree(false);
        Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
    }

    @Test(description = "Visitor - Header - lessonp-3966:Search box (UI)")
    public void testLessonp_3966() {
        testSearchBox();
    }

    @Test(description = "Visitor - Header - lessonp-4105:Search box (UI)")
    public void testLessonp_4105() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testSearchBox();
    }

    @Test(description = "Active user - Header - lessonp-4109:Search box (UI)")
    public void testLessonp_4109() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testSearchBox();
    }

    public void testLogo(boolean regularSiteLicence) {
        lpHomePage.loadPage();
        if (!regularSiteLicence) {
            Assert.assertTrue(headerPage.isLpLogoClickable());
            headerPage.clickOnLpLogo(false);
        } else {
            Assert.assertTrue(headerPage.isRegularSlLogoClickable());
            headerPage.clickOnRegularSlLogo(false);
        }
        Assert.assertEquals(lpHomePage.getPath(), TestData.LP_HOME_PAGE_PATH);
        if (!regularSiteLicence) {
            headerPage.clickOnLpLogo(true);
        } else {
            headerPage.clickOnRegularSlLogo(true);
        }
        Assert.assertEquals(lpHomePage.getPath(), TestData.LP_HOME_PAGE_PATH);
    }

    private void testButtonsVisitor() {
        Assert.assertTrue(headerPage.isPricingButtonDisplayed());
        Assert.assertTrue(headerPage.isSignInButtonDisplayed());
        Assert.assertTrue(headerPage.isTryItFreeButtonDisplayed());
        testDropdowns();
    }

    private void testDropdowns() {
        Assert.assertTrue(headerPage.isResourcesDropdownDisplayed());
        Assert.assertTrue(headerPage.isSolutionDropdownDisplayed());
        Assert.assertTrue(headerPage.isAboutDropdownDisplayed());
    }

    public void testSearchBox() {
        discoverResourcesPage.loadPage();
        Assert.assertTrue(headerPage.isSearchBarDisplayed());
        Assert.assertEquals(headerPage.getSearchBoxPlaceholder(), TestData.SEARCH_BOX_PLACEHOLDER_TEXT);
    }
}
