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
    private StepTwoPage stepTwoPage;
    private LoginPage loginPage;
    private DiscoverResourcesPage discoverResourcesPage;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        headerPage = new HeaderPage(webDriver);
        footerPage = new FooterPage(webDriver);
        signInModal = new SignInModal(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        loginPage = new LoginPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Visitor - Header - lessonp-4565: Header buttons")
    public void testLessonp_4565() {
        testHeaderButtons(TestData.INVALID_EMAIL);
    }

    @Test(description = "Free member - Header - lessonp-4602: Header buttons")
    public void testLessonp_4602() {
        testHeaderButtons(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Active user - Header - lessonp-4617: Header buttons")
    public void testLessonp_4617() {
        testHeaderButtons(TestData.VALID_EMAIL_ACTIVE);
    }

    @Test(description = "Visitor - Header - lessonp-4004: Search box (keyword functionality)")
    public void testLessonp_4004() {
        testSearchBoxKeywordFunctionality(TestData.INVALID_EMAIL);
    }

    @Test(description = "Free member - Header - lessonp-4107: Search box (keyword functionality)")
    public void testLessonp_4107() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testSearchBoxKeywordFunctionality(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Active user - Header - lessonp-4111: Search box (keyword functionality)")
    public void testLessonp_4111() {
        loginPage.performLogin(TestData.VALID_EMAIL_ACTIVE, TestData.VALID_PASSWORD);
        testSearchBoxKeywordFunctionality(TestData.VALID_EMAIL_ACTIVE);
    }

    protected void testHeaderButtons(String account) {
        if (!account.equals(TestData.INVALID_EMAIL)) {
            loginPage.performLogin(account, TestData.VALID_PASSWORD);
        }

        testLogo(account);

        testResourcesButton(account);

        testSolutionsButton();

        testAboutButton(account);

        if (account.equals(TestData.INVALID_EMAIL)) {
            headerPage.clickOnPricingButton();
            Assert.assertEquals(lpHomePage.getPath(), TestData.PRICING_PAGE_PATH);

            headerPage.clickOnSignInButton(false);
            Assert.assertEquals(signInModal.getModalTitle(), TestData.SIGN_IN_MODAL_TITLE_TEXT);
            signInModal.clickOnClose();

            headerPage.clickOnTryItFree(false);
            Assert.assertEquals(stepOneModal.getTitleText(), TestData.STEP_ONE_MODAL_TITLE);
        } else if (account.equals(TestData.VALID_EMAIL_FREEMIUM)) {
            headerPage.clickOnUpgradeMeButton(false);
            Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
            stepTwoPage.goBackOnePage();
            testYourAccountButton(false);
        } else if (account.equals(TestData.VALID_EMAIL_ACTIVE)) {
            testYourAccountButton(false);
        } else if (account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            testYourAccountButton(true);
        }
    }

    private void testLogo(String account) {
        lpHomePage.loadPage();
        if (!account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            Assert.assertTrue(headerPage.isLpLogoClickable());
            headerPage.clickOnLpLogo(false);
        } else {
            Assert.assertTrue(headerPage.isRegularSlLogoClickable());
            headerPage.clickOnRegularSlLogo(false);
        }
        Assert.assertEquals(lpHomePage.getPath(), TestData.LP_HOME_PAGE_PATH);
    }

    private void testResourcesButton(String account) {
        lpHomePage.loadPage();
        headerPage.hoverOverResourcesButton();
        headerPage.clickOnDiscoverResourcesButton();
        Assert.assertEquals(TestData.DISCOVER_RESOURCES_PAGE_PATH, headerPage.getPath());

        headerPage.hoverOverResourcesButton();
        headerPage.clickOnBrowseResourceDirectoryButton();
        Assert.assertEquals(TestData.BROWSE_RESOURCE_DIRECTORY_PAGE_PATH, headerPage.getPath());

        if (account.equals(TestData.INVALID_EMAIL)) {
            headerPage.hoverOverResourcesButton();
            headerPage.hoverOverCurriculumManagerButton();
            Assert.assertTrue(headerPage.isSignInPopupLinkDisplayed());
            Assert.assertTrue(headerPage.isSignUpPopupLinkDisplayed());
            lpHomePage.loadPage();
        } else {
            headerPage.hoverOverResourcesButton();
            headerPage.clickOnCurriculumManagerButton();
            Assert.assertEquals(headerPage.getPath(), TestData.CURRICULUM_MANAGER_PAGE_PATH);
        }

        headerPage.hoverOverResourcesButton();
        headerPage.clickOnCurriculumCalendarButton();
        Assert.assertEquals(TestData.CURRICULUM_CALENDAR_PAGE_PATH, headerPage.getPath());

        if (!account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            headerPage.hoverOverResourcesButton();
            headerPage.clickOnLessonPlanningArticlesButton();
            Assert.assertEquals(TestData.LESSON_PLANNING_ARTICLES_PAGE_PATH, headerPage.getPath());
        }
    }

    private void testSolutionsButton() {
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

    private void testAboutButton(String account) {
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

        if (!account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            headerPage.hoverOverAboutButton();
            headerPage.clickOnTestimonialsButton();
            Assert.assertEquals(headerPage.getPath(), TestData.TESTIMONIALS_PAGE_PATH);
        }
    }

    private void testYourAccountButton(boolean adminManager) {
        headerPage.hoverOverUserDropDownButton();
        headerPage.clickOnMyAccountButton();
        Assert.assertEquals(headerPage.getPath(), TestData.MY_ACCOUNT_PAGE_PATH);

        if (!adminManager) {
            headerPage.hoverOverUserDropDownButton();
            headerPage.clickOnMyMemberProfileButton();
            Assert.assertEquals(headerPage.getPath(), TestData.MEMBER_PROFILE_PAGE_PATH);
        }

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
        Assert.assertTrue(headerPage.isLpLogoClickable());
    }

    protected void testSearchBoxKeywordFunctionality(String account) {
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
        if (!account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            Assert.assertEquals(TestData.SHOWING_ALL_REVIEWED_RESOURCES_MESSAGE, discoverResourcesPage.getSearchMessage());
        } else {
            Assert.assertEquals(TestData.SHOWING_ALL_RESOURCES_MESSAGE, discoverResourcesPage.getSearchMessage());
        }

        headerPage.clickOnSearchInput();
        headerPage.typeSearchText(TestData.VALID_SEARCH_WORD);
        Assert.assertEquals(headerPage.getSearchButtonText(), TestData.SEARCH_BUTTON_TEXT);
        Assert.assertEquals(headerPage.getSearchBoxPlaceholder(), TestData.SEARCH_BOX_PLACEHOLDER_TEXT);
        Assert.assertTrue(headerPage.isClearSearchButtonDisplayed());
        if (!account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
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
        } else if (!account.equals(TestData.VALID_EMAIL_ACTIVE)) {
            Assert.assertEquals(headerPage.getPath(), TestData.LP_HOME_PAGE_PATH);
            Assert.assertEquals(lpHomePage.getAlertMessageText(), TestData.YOU_ARE_NOT_ALLOWED_TO_USE_FEATURE_TEXT);
        } else {
            Assert.assertEquals(headerPage.getPath(), TestData.SEARCH_EDTECH_PAGE_PATH + TestData.VALID_SEARCH_WORD);
        }

        headerPage.goBackOnePage();
        if (!account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
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
        if (!account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
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
