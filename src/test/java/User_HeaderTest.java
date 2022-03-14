import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class User_HeaderTest extends BaseTest {
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private FooterPage footerPage;
    private SignInModal signInModal;
    private StepOneModal stepOneModal;
    private StepTwoPage stepTwoPage;
    private LoginPage loginPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private DirectoryPage directoryPage;
    private CurriculumManagerPage curriculumManagerPage;
    private CalendarPage calendarPage;
    private ArticlesPage articlesPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        headerPage = new HeaderPage(webDriver);
        footerPage = new FooterPage(webDriver);
        signInModal = new SignInModal(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        loginPage = new LoginPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        directoryPage = new DirectoryPage(webDriver);
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        calendarPage = new CalendarPage(webDriver);
        articlesPage = new ArticlesPage(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Visitor - Header - C2046: Header buttons", groups = {"visitor"})
    public void testC2046() {
        testHeaderButtons(TestData.PLAN_VISITOR);
    }

    @Test(description = "Free member - Header - C2138: Header buttons", groups = {"freemium"})
    public void testC2138() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testHeaderButtons(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Header - C2257: Header buttons", groups = {"activeUser"})
    public void testC2257() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testHeaderButtons(TestData.PLAN_PRO);
    }

    @Test(description = "Admin - Header - C2258: Header buttons", groups = {"activeUser"})
    public void testC2258() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testHeaderButtons(TestData.VALID_EMAIL_ADMIN);
    }

    @Test(description = "Visitor - Header - C2048: Search box (keyword functionality)", groups = {"visitor"})
    public void testC2048() {
        testSearchBoxKeywordFunctionality(TestData.PLAN_VISITOR);
    }

    @Test(description = "Free member - Header - C2139: Search box (keyword functionality)", groups = {"freemium"})
    public void testC2139() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testSearchBoxKeywordFunctionality(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Header - C2259: Search box (keyword functionality)", groups = {"activeUser"})
    public void testC2259() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testSearchBoxKeywordFunctionality(TestData.PLAN_PRO);
    }

    @Test(description = "Admin - Header - C2260: Search box (keyword functionality)", groups = {"activeUser"})
    public void testC2260() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testSearchBoxKeywordFunctionality(TestData.PLAN_PRO);
    }

    protected void testHeaderButtons(String account) {
        testLogo(account);

        testDiscoverButton(account);

        if (!account.equals(TestData.VALID_EMAIL_RSL_SBCEO) && !account.equals(TestData.VALID_EMAIL_CSL_HENRY) && !account.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            testSolutionsButton();
        }

        if (!account.equals(TestData.VALID_EMAIL_CSL_HENRY) && !account.equals(TestData.VALID_EMAIL_CSL_COBB) && !account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            testAboutButton(account);
        }

        if (account.equals(TestData.VALID_EMAIL_CSL_HENRY) || account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            lpHomePage.loadPage();
            headerPage.hoverOverHelpButton();
            headerPage.clickOnHelpCenterButton();
            headerPage.waitForNewTab();
            headerPage.focusDriverToLastTab();
            headerPage.waitForLinkToLoad();
            Assert.assertEquals(headerPage.getUrl(), TestData.LEARNING_EXPLORER_HELP_URL);
            headerPage.closeTab();
            headerPage.hoverOverHelpButton();
            headerPage.clickOnContactUsButton();
            Assert.assertTrue(headerPage.getUrl().contains(TestData.CONTACT_US_PAGE_PATH));
            headerPage.goBackOnePage();
        }

        if (account.equals(TestData.PLAN_VISITOR)) {
            headerPage.clickOnPricingButton();
            Assert.assertEquals(lpHomePage.getPath(), TestData.PRICING_PAGE_PATH);

            headerPage.clickOnSignInButton(false);
            Assert.assertEquals(signInModal.getModalTitle(), TestData.SIGN_IN_MODAL_TITLE_TEXT);
            lpHomePage.loadPage();
            headerPage.clickOnTryItFree(false);
            Assert.assertEquals(stepOneModal.getTitleText(), TestData.STEP_ONE_MODAL_TITLE);
        } else if (account.equals(TestData.PLAN_FREEMIUM)) {
            headerPage.clickOnUpgradeMeButton(false);
            Assert.assertEquals(stepTwoPage.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
            stepTwoPage.goBackOnePage();
            testYourAccountButton(false, account);
        } else if (account.equals(TestData.VALID_EMAIL_ADMIN) || account.equals(TestData.PLAN_PRO)) {
            testYourAccountButton(false, account);
        } else if (account.equals(TestData.VALID_EMAIL_RSL_SBCEO) || account.equals(TestData.VALID_EMAIL_CSL_HENRY)) {
            testYourAccountButton(true, account);
        }
    }

    private void testLogo(String account) {
        lpHomePage.loadPage();
        switch (account) {
            case TestData.VALID_EMAIL_RSL_SBCEO:
                Assert.assertTrue(headerPage.isRegularSlLogoClickable());
                headerPage.clickOnRegularSlLogo(false);
                Assert.assertEquals(lpHomePage.getPath(), TestData.SEARCH_PAGE_PATH);
                break;
            case TestData.VALID_EMAIL_CSL_HENRY:
                Assert.assertTrue(headerPage.isHenryCustomSlLogoDisplayed());
                break;
            case TestData.PLAN_STARTER:
            case TestData.PLAN_PRO:
            case TestData.PLAN_FREEMIUM:
            case TestData.PLAN_VISITOR:
                Assert.assertTrue(headerPage.isLpLogoClickable());
                headerPage.clickOnLpLogo(false);
                Assert.assertEquals(lpHomePage.getPath(), TestData.LP_HOME_PAGE_PATH);
                break;
            case TestData.VALID_EMAIL_CSL_COBB:
                Assert.assertTrue(headerPage.isResourcesHeaderTextDisplayed());
        }
    }

    private void testDiscoverButton(String account) {
        lpHomePage.loadPage();
        headerPage.hoverOverDiscoverButton();
        headerPage.clickOnDiscoverResourcesButton();
        Assert.assertEquals(TestData.DISCOVER_RESOURCES_PAGE_PATH, headerPage.getPath());
        if (account.equals(TestData.VALID_EMAIL_RSL_SBCEO) || account.equals(TestData.VALID_EMAIL_CSL_HENRY) || account.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            Assert.assertEquals(TestData.SHOWING_ALL_RESOURCES_MESSAGE, discoverResourcesPage.getSearchMessage());
        } else {
            Assert.assertEquals(TestData.SHOWING_ALL_REVIEWED_RESOURCES_MESSAGE, discoverResourcesPage.getSearchMessage());
        }

        headerPage.hoverOverDiscoverButton();
        headerPage.clickOnBrowseResourceDirectoryButton();
        Assert.assertEquals(TestData.BROWSE_RESOURCE_DIRECTORY_PAGE_PATH, headerPage.getPath());
        Assert.assertEquals(TestData.BROWSE_RESOURCE_DIRECTORY_PAGE_TITLE, directoryPage.getTitle());

        if (account.equals(TestData.PLAN_VISITOR)) {
            headerPage.hoverOverDiscoverButton();
            headerPage.hoverOverCurriculumManagerButton();
            Assert.assertTrue(headerPage.isSignInPopupLinkDisplayed());
            Assert.assertTrue(headerPage.isSignUpPopupLinkDisplayed());
            lpHomePage.loadPage();
        } else {
            headerPage.hoverOverDiscoverButton();
            headerPage.clickOnCurriculumManagerButton();
            Assert.assertEquals(headerPage.getPath(), TestData.CURRICULUM_MANAGER_PAGE_PATH);
            if (account.equals(TestData.VALID_EMAIL_CSL_HENRY) || account.equals(TestData.VALID_EMAIL_RSL_SBCEO) || account.equals(TestData.VALID_EMAIL_CSL_COBB)) {
                Assert.assertEquals(TestData.CURRICULUM_MANAGER_PAGE_TITLE, curriculumManagerPage.getTitle());
            } else {
                Assert.assertEquals(TestData.MY_RESOURCES_PAGE_TITLE, curriculumManagerPage.getTitle());
            }
        }

        headerPage.hoverOverDiscoverButton();
        headerPage.clickOnCurriculumCalendarButton();
        Assert.assertEquals(TestData.CURRICULUM_CALENDAR_PAGE_PATH, headerPage.getPath());
        Assert.assertEquals(calendarPage.getCalendarTitle(), TestData.MONTH[TestData.getCurrentMonth()] + TestData.CALENDAR_TITLE);
        if (!account.equals(TestData.VALID_EMAIL_RSL_SBCEO) && !account.equals(TestData.VALID_EMAIL_CSL_HENRY) && !account.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            headerPage.hoverOverDiscoverButton();
            headerPage.clickOnLessonPlanningArticlesButton();
            Assert.assertEquals(TestData.LESSON_PLANNING_ARTICLES_PAGE_PATH, headerPage.getPath());
            Assert.assertEquals(articlesPage.getLessonPlanningArticlesPageTitle(), TestData.LESSON_PLANNING_ARTICLES_TITLE);
        }

        if (account.equals(TestData.VALID_EMAIL_ADMIN)) {
            headerPage.hoverOverDiscoverButton();
            headerPage.clickOnPdLearningNetworkDiscoverButton();
            Assert.assertEquals(TestData.EDTECH_PROFESSIONAL_DEVELOPMENT_COURSES_PAGE_PATH, headerPage.getPath());
        }
    }

    private void testSolutionsButton() {
        lpHomePage.loadPage();
        headerPage.hoverOverSolutionsButton();
        headerPage.clickOnEducatorEditionButton();
        Assert.assertEquals(headerPage.getPath(), TestData.EDUCATOR_EDITION_PAGE_PATH);

        lpHomePage.loadPage();
        headerPage.hoverOverSolutionsButton();
        headerPage.clickOnLearningExplorerButton();
        headerPage.waitForLinkToLoad();
        Assert.assertEquals(headerPage.getUrl(), TestData.LEARNING_EXPLORER_URL);

        lpHomePage.loadPage();
        headerPage.hoverOverSolutionsButton();
        headerPage.clickOnPdLearningNetworkButton();
        Assert.assertEquals(headerPage.getPath(), TestData.PD_LEARNING_NETWORK_PATH);
    }

    private void testAboutButton(String account) {
        lpHomePage.loadPage();
        headerPage.hoverOverAboutButton();
        headerPage.clickOnOurStoryButton();
        Assert.assertEquals(headerPage.getPath(), TestData.OUR_STORY_PAGE_PATH);

        lpHomePage.loadPage();
        headerPage.hoverOverAboutButton();
        if (!account.equals(TestData.PLAN_VISITOR)) {
            headerPage.clickOnHelpCenterButton();
            Assert.assertEquals(headerPage.getPath(), TestData.HELP_CENTER_FAQ_PATH);
        } else {
            headerPage.clickOnFrequentlyAskedQuestionsButton();
            Assert.assertEquals(headerPage.getPath(), TestData.FAQ_PAGE_PATH);
        }

        if (!account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            lpHomePage.loadPage();
            headerPage.hoverOverAboutButton();
            headerPage.clickOnTestimonialsButton();
            Assert.assertEquals(headerPage.getPath(), TestData.TESTIMONIALS_PAGE_PATH);

            headerPage.hoverOverAboutButton();
            headerPage.clickOnContactUsButton();
            Assert.assertEquals(headerPage.getPath(), TestData.CONTACT_US_PAGE_PATH);
            lpHomePage.loadPage();
        }
    }

    private void testYourAccountButton(boolean adminManager, String account) {
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
        if (account.equals(TestData.VALID_EMAIL_CSL_HENRY) || account.equals(TestData.VALID_EMAIL_RSL_SBCEO) || account.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            Assert.assertEquals(TestData.CURRICULUM_MANAGER_PAGE_TITLE, curriculumManagerPage.getTitle());
        } else {
            Assert.assertEquals(TestData.MY_RESOURCES_PAGE_TITLE, curriculumManagerPage.getTitle());
        }

        if (!account.equals(TestData.VALID_EMAIL_CSL_HENRY) && !account.equals(TestData.VALID_EMAIL_CSL_COBB) && !account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            headerPage.hoverOverUserDropDownButton();
            headerPage.clickOnSearchHistoryButton();
            Assert.assertEquals(headerPage.getPath(), TestData.SEARCH_HISTORY_PAGE_PATH);
        }

        if (adminManager) {
            headerPage.hoverOverUserDropDownButton();
            headerPage.clickOnAdminManagerButton();
            Assert.assertTrue(headerPage.getPath().contains(TestData.ACCOUNT_MANAGER_PAGE_PATH));
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

        changeFocus(account);

        headerPage.clickOnClearSearchButton();
        Assert.assertEquals(headerPage.getSearchBoxPlaceholder(), TestData.SEARCH_BOX_PLACEHOLDER_TEXT);
        Assert.assertEquals(headerPage.getSearchText(), TestData.LP_HOME_PAGE_PATH);
        Assert.assertEquals(headerPage.getSearchButtonText(), TestData.LP_HOME_PAGE_PATH);
        if (account.equals(TestData.VALID_EMAIL_RSL_SBCEO) || account.equals(TestData.VALID_EMAIL_CSL_HENRY) || account.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            Assert.assertEquals(TestData.SHOWING_ALL_RESOURCES_MESSAGE, discoverResourcesPage.getSearchMessage());
        } else {
            Assert.assertEquals(TestData.SHOWING_ALL_REVIEWED_RESOURCES_MESSAGE, discoverResourcesPage.getSearchMessage());
        }

        headerPage.clickOnSearchInput();
        headerPage.typeSearchText(TestData.VALID_SEARCH_WORD);
        Assert.assertEquals(headerPage.getSearchButtonText(), TestData.SEARCH_BUTTON_TEXT);
        Assert.assertEquals(headerPage.getSearchBoxPlaceholder(), TestData.SEARCH_BOX_PLACEHOLDER_TEXT);
        Assert.assertTrue(headerPage.isClearSearchButtonDisplayed());
        if (account.equals(TestData.VALID_EMAIL_RSL_SBCEO) || account.equals(TestData.VALID_EMAIL_CSL_HENRY) || account.equals(TestData.VALID_EMAIL_CSL_COBB)) {
            Assert.assertEquals(TestData.SHOWING_ALL_RESOURCES_MESSAGE, discoverResourcesPage.getSearchMessage());
        } else {
            Assert.assertEquals(TestData.SHOWING_ALL_REVIEWED_RESOURCES_MESSAGE, discoverResourcesPage.getSearchMessage());
        }

        changeFocus(account);

        Assert.assertEquals(headerPage.getSearchButtonText(), TestData.LP_HOME_PAGE_PATH);
        headerPage.clickOnClearSearchButton();
        Assert.assertEquals(headerPage.getSearchBoxPlaceholder(), TestData.SEARCH_BOX_PLACEHOLDER_TEXT);


        headerPage.typeSearchText(TestData.VALID_SEARCH_WORD);
        headerPage.clickOnSearchButton();
        Assert.assertTrue(TestData.ZERO_RESOURCES_FOUND < discoverResourcesPage.getTotalResults());
    }

    public void changeFocus(String account) {
        switch (account) {
            case TestData.VALID_EMAIL_RSL_SBCEO:
                footerPage.clickOnRegularSlIframeCopyRightText();
                break;
            case TestData.VALID_EMAIL_CSL_HENRY:
                headerPage.clickOnHenryCustomSlLogo();
                break;
            case TestData.PLAN_STARTER:
            case TestData.PLAN_PRO:
            case TestData.PLAN_FREEMIUM:
            case TestData.PLAN_VISITOR:
                footerPage.clickOnCopyRightText();
                break;
            case TestData.VALID_EMAIL_CSL_COBB:
                headerPage.clickOnResourcesHeaderText();
                break;
        }
    }
}
