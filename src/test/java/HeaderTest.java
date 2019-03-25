import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class HeaderTest extends BaseTest {
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private FooterPage footerPage;
    private SignInModal signInModal;
    private StepOneModal stepOneModal;
    private LoginPage loginPage;
    private DiscoverResourcesPage discoverResourcesPage;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        headerPage = new HeaderPage(webDriver);
        footerPage = new FooterPage(webDriver);
        signInModal = new SignInModal(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        loginPage = new LoginPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Visitor - Header - lessonp-3970:LP Logo")
    public void testLessonp_3970() {
        testLogo();
    }

    @Test(description = "Freemium - Header - lessonp-4104:LP Logo")
    public void testLessonp_4104() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testLogo();
    }

    @Test(description = "Visitor - Header - lessonp-4108:LP Logo")
    public void testLessonp_4108() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testLogo();
    }

    @Test(description = "Visitor - Header - lessonp-639:Resources")
    public void testLessonp_639() {
        testResourcesButton(TestData.INVALID_EMAIL);
    }

    @Test(description = "Freemium - Header - lessonp-644:Resources")
    public void testLessonp_644() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testResourcesButton(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Active user - Header - lessonp-649:Resources")
    public void testLessonp_649() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testResourcesButton(TestData.VALID_EMAIL_ADMIN);
    }

    @Test(description = "Visitor - Header - lessonp-641:Solutions")
    public void testLessonp_641() {
        testSolutionsButton();
    }

    @Test(description = "Freemium - Header - lessonp-645:Solutions")
    public void testLessonp_645() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testSolutionsButton();
    }

    @Test(description = "Active user - Header - lessonp-650:Solutions")
    public void testLessonp_650() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testSolutionsButton();
    }

    @Test(description = "Visitor - Header - lessonp-642:About")
    public void testLessonp_642() {
        testAboutButton();
    }

    @Test(description = "Freemium - Header - lessonp-646:About")
    public void testLessonp_646() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testAboutButton();
    }

    @Test(description = "Active user - Header - lessonp-651:About")
    public void testLessonp_651() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testAboutButton();
    }

    @Test(description = "Freemium - Header - lessonp-648:Your_Account")
    public void testLessonp_648() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testYourAccountButton(false);
    }

    @Test(description = "Active user - Header - lessonp-653:Your_Account")
    public void testLessonp_653() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testYourAccountButton(false);
    }

    @Test(description = "Visitor - Header - lessonp-4004:Search box (keyword functionality)")
    public void testLessonp_4004() {
        testSearchBoxKeywordFunctionality(TestData.INVALID_EMAIL);
    }

    @Test(description = "Freemium - Header - lessonp-4107:Search box (keyword functionality)")
    public void testLessonp_4107() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testSearchBoxKeywordFunctionality(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Active user - Header - lessonp-4111:Search box (keyword functionality)")
    public void testLessonp_4144() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testSearchBoxKeywordFunctionality(TestData.VALID_EMAIL_ADMIN);
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

    public void testLogo() {
        lpHomePage.loadPage();
        Assert.assertTrue(headerPage.isLpLogoClickable());
        headerPage.clickOnLpLogo(false);

        Assert.assertEquals(lpHomePage.getPath(), TestData.LP_HOME_PAGE_PATH);
        headerPage.clickOnLpLogo(true);

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

    public void testResourcesButton(String account) {
        lpHomePage.loadPage();
        headerPage.hoverOverResourcesButton();
        headerPage.clickOnDiscoverResourcesButton();
        Assert.assertEquals(TestData.DISCOVER_RESOURCES_PAGE_PATH, headerPage.getPath());

        headerPage.hoverOverResourcesButton();
        headerPage.clickOnBrowseResourceDirectoryButton();
        Assert.assertEquals(TestData.BROWSE_RESOURCE_DIRECTORY_PAGE_PATH, headerPage.getPath());

        headerPage.hoverOverResourcesButton();
        headerPage.clickOnSearchByStandardButton();
        if (!account.equals(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE)) {
            Assert.assertEquals(TestData.SEARCH_BY_STANDARD_PAGE_PATH, headerPage.getPath());
        } else {
            Assert.assertEquals(TestData.SEARCH_BY_STANDARD_PAGE_PATH + "/ca", headerPage.getPath());
        }

        if (account.equals(TestData.INVALID_EMAIL)) {
            headerPage.hoverOverResourcesButton();
            headerPage.hoverOverCurriculumManagerButton();
            Assert.assertTrue(headerPage.isSignInPopupLinkDisplayed());
            Assert.assertTrue(headerPage.isSignUpPopupLinkDisplyed());
            lpHomePage.loadPage();
        } else {
            headerPage.hoverOverResourcesButton();
            headerPage.clickOnCurriculumManagerButton();
            Assert.assertEquals(headerPage.getPath(), TestData.CURRICULUM_MANAGER_PAGE_PATH);
        }

        headerPage.hoverOverResourcesButton();
        headerPage.clickOnCurriculumCalendarButton();
        Assert.assertEquals(TestData.CURRICULUM_CALENDAR_PAGE_PATH, headerPage.getPath());

        if (!account.equals(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE)) {
            headerPage.hoverOverResourcesButton();
            headerPage.clickOnLessonPlanningArticlesButton();
            Assert.assertEquals(TestData.LESSON_PLANNING_ARTICLES_PAGE_PATH, headerPage.getPath());
        }
    }

    public void testSolutionsButton() {
        lpHomePage.loadPage();
        headerPage.hoverOverSolutionsButton();
        headerPage.clickOnEducatorEditionButton();
        Assert.assertEquals(headerPage.getPath(), TestData.EDUCATOR_EDITION_PAGE_PATH);

        lpHomePage.loadPage();
        headerPage.hoverOverSolutionsButton();
        headerPage.clickOnLearningExplorer();
        Assert.assertEquals(headerPage.getUrl(), TestData.LEARNING_EXPLORER_URL);

        lpHomePage.loadPage();
        headerPage.hoverOverSolutionsButton();
        headerPage.clickOnPdLearningNetworkButton();
        Assert.assertEquals(headerPage.getUrl(), TestData.PD_LEARNING_NETWORK_URL);
    }

    public void testAboutButton() {
        lpHomePage.loadPage();
        headerPage.hoverOverAboutButton();
        headerPage.clickOnContactUsButton();
        Assert.assertEquals(headerPage.getPath(), TestData.CONTACT_US_PAGE_PATH);

        headerPage.hoverOverAboutButton();
        headerPage.clickOnOurStoryButton();
        Assert.assertEquals(headerPage.getPath(), TestData.OUR_STORY_PAGE_PATH);

        headerPage.hoverOverAboutButton();
        headerPage.clickOnPressButton();
        Assert.assertEquals(headerPage.getPath(), TestData.PRESS_PAGE_PATH);

        headerPage.hoverOverAboutButton();
        headerPage.clickOnFaqButton();
        Assert.assertEquals(headerPage.getPath(), TestData.FAQ_PAGE_PATH);

        headerPage.hoverOverAboutButton();
        headerPage.clickOnTestimonialsButton();
        Assert.assertEquals(headerPage.getPath(), TestData.TESTIMONIALS_PAGE_PATH);
    }

    public void testYourAccountButton(boolean adminManager) {
        headerPage.hoverOverUserDropDownButton();
        headerPage.clickOnMyAccountButton();
        Assert.assertEquals(headerPage.getPath(), TestData.MY_ACCOUNT_PAGE_PATH);

        headerPage.hoverOverUserDropDownButton();
        headerPage.clickOnMyMemberProfileButton();
        Assert.assertEquals(headerPage.getPath(), TestData.MEMBER_PROFILE_PAGE_PATH);

        headerPage.hoverOverUserDropDownButton();
        headerPage.clickOnMyResourcesButton();
        Assert.assertEquals(headerPage.getPath(), TestData.CURRICULUM_MANAGER_PAGE_PATH);

        headerPage.hoverOverUserDropDownButton();
        headerPage.clickOnSearchHistoryButton();
        Assert.assertEquals(headerPage.getPath(), TestData.SEARCH_HISTORY_PAGE_PATH);

        if (adminManager) {
            headerPage.hoverOverUserDropDownButton();
            headerPage.clickOnAdminManagerButton();
            Assert.assertEquals(headerPage.getPath(), TestData.ACCOUNT_MANAGER_PAGE_PATH);
        }

        headerPage.hoverOverUserDropDownButton();
        headerPage.clickOnSignOutButton();
        Assert.assertTrue(headerPage.isSignInButtonDisplayed());
    }

    public void testSearchBoxKeywordFunctionality(String account) {
        discoverResourcesPage.loadPage();
        headerPage.clickOnSearchInput();
        Assert.assertEquals(headerPage.getSearchButtonText(), TestData.SEARCH_BUTTON_TEXT);
        Assert.assertEquals(headerPage.getSearchBoxPlaceholder(), TestData.SEARCH_BOX_PLACEHOLDER_TEXT);

        headerPage.typeSearchText(TestData.VALID_SEARCH_WORD);
        headerPage.clickOnSearchButton();
        Assert.assertTrue(TestData.ZERO_RESOURCES_FOUND < discoverResourcesPage.getTotalResults());
        Assert.assertFalse(discoverResourcesPage.isSuggestionBlockTextDisplayed());
        Assert.assertEquals(headerPage.getSearchButtonText(), TestData.LP_HOME_PAGE_PATH);
        Assert.assertEquals(headerPage.getSearchText(), TestData.VALID_SEARCH_WORD);
        Assert.assertTrue(headerPage.isClearSearchButtonDisplayed());
        footerPage.clickOnCopyRightText();

        headerPage.clickOnClearSearchButton();
        Assert.assertEquals(headerPage.getSearchBoxPlaceholder(), TestData.SEARCH_BOX_PLACEHOLDER_TEXT);
        Assert.assertEquals(headerPage.getSearchText(), TestData.LP_HOME_PAGE_PATH);
        Assert.assertEquals(headerPage.getSearchButtonText(), TestData.LP_HOME_PAGE_PATH);
        if (!account.equals(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE)) {
            Assert.assertEquals(TestData.SHOWING_ALL_REVIEWED_RESOURCES_MESSAGE, discoverResourcesPage.getSearchMessage());
        } else {
            Assert.assertEquals(TestData.SHOWING_ALL_RESOURCES_MESSAGE, discoverResourcesPage.getSearchMessage());
        }

        headerPage.clickOnSearchInput();
        headerPage.typeSearchText(TestData.VALID_SEARCH_WORD);
        Assert.assertEquals(headerPage.getSearchButtonText(), TestData.SEARCH_BUTTON_TEXT);
        Assert.assertEquals(headerPage.getSearchBoxPlaceholder(), TestData.SEARCH_BOX_PLACEHOLDER_TEXT);
        Assert.assertTrue(headerPage.isClearSearchButtonDisplayed());
        if (!account.equals(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE)) {
            Assert.assertEquals(TestData.SHOWING_ALL_REVIEWED_RESOURCES_MESSAGE, discoverResourcesPage.getSearchMessage());
        } else {
            Assert.assertEquals(TestData.SHOWING_ALL_RESOURCES_MESSAGE, discoverResourcesPage.getSearchMessage());
        }

        footerPage.clickOnCopyRightText();
        Assert.assertEquals(headerPage.getSearchButtonText(), TestData.LP_HOME_PAGE_PATH);
        headerPage.clickOnClearSearchButton();

        headerPage.clickOnSearchFilterButton();
        headerPage.setSearchFilter(TestData.SEARCH_FILTER_EDTECHPD_VIDEOS_AND_COURSES);
        Assert.assertEquals(headerPage.getSearchBoxPlaceholder(), TestData.SEARCH_BOX_PLACEHOLDER_ED_TECH_PD_TEXT);

        headerPage.typeSearchText(TestData.VALID_SEARCH_WORD);
        headerPage.clickOnSearchButton();

        if (account.equals(TestData.INVALID_EMAIL)) {
            Assert.assertEquals(headerPage.getPath(), TestData.LOGIN_PAGE_PATH);
            Assert.assertEquals(lpHomePage.getAlertMessageText(), TestData.PLEASE_LOGIN_TO_ACCESS_THIS_PAGE_TEXT);
        } else if (!account.equals(TestData.VALID_EMAIL_ADMIN)) {
            Assert.assertEquals(headerPage.getPath(), TestData.LP_HOME_PAGE_PATH);
            Assert.assertEquals(lpHomePage.getAlertMessageText(), TestData.YOU_ARE_NOT_ALLOWED_TO_USE_FEATURE_TEXT);
        } else {
            Assert.assertEquals(headerPage.getPath(), TestData.SEARCH_EDTECH_PAGE_PATH + TestData.VALID_SEARCH_WORD);
        }

        headerPage.goBackOnePage();
        if (!account.equals(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE)) {
            Assert.assertEquals(TestData.SHOWING_ALL_REVIEWED_RESOURCES_MESSAGE, discoverResourcesPage.getSearchMessage());
        } else {
            Assert.assertEquals(TestData.SHOWING_ALL_RESOURCES_MESSAGE, discoverResourcesPage.getSearchMessage());
        }
        headerPage.clickOnSearchFilterButton();
        headerPage.setSearchFilter(TestData.SEARCH_FILTER_COMMON_CORE_STATE_STANDARDS);
        Assert.assertEquals(headerPage.getSearchBoxPlaceholder(), TestData.SEARCH_BOX_PLACEHOLDER_COMMON_CORE_STATE_STANDARDS_TEXT);
        headerPage.typeSearchText(TestData.VALID_SEARCH_WORD);
        headerPage.clickOnSearchButton();
        Assert.assertEquals(headerPage.getPath(), TestData.SEARCH_STANDARDS_PAGE_PATH + TestData.VALID_SEARCH_WORD);

        headerPage.goBackOnePage();
        if (!account.equals(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE)) {
            Assert.assertEquals(TestData.SHOWING_ALL_REVIEWED_RESOURCES_MESSAGE, discoverResourcesPage.getSearchMessage());
        } else {
            Assert.assertEquals(TestData.SHOWING_ALL_RESOURCES_MESSAGE, discoverResourcesPage.getSearchMessage());
        }
        headerPage.clickOnSearchFilterButton();
        headerPage.setSearchFilter(TestData.SEARCH_FILTER_REVIEWED_RESOURCES);
        Assert.assertEquals(headerPage.getSearchBoxPlaceholder(), TestData.SEARCH_BOX_PLACEHOLDER_TEXT);
        headerPage.typeSearchText(TestData.VALID_SEARCH_WORD);
        headerPage.clickOnSearchButton();
        Assert.assertTrue(TestData.ZERO_RESOURCES_FOUND < discoverResourcesPage.getTotalResults());
    }
}
