import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class HeaderTest extends BaseTest {
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private SignInModal signInModal;
    private StepOneModal stepOneModal;
    private StepTwoModal stepTwoModal;
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        headerPage = new HeaderPage(webDriver);
        signInModal = new SignInModal(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        stepTwoModal = new StepTwoModal(webDriver);
        loginPage = new LoginPage(webDriver);
    }

    @Test(description = "Visitor - Header - lessonp-639:Resources")
    public void testLessonp_639() {
        testResourcesButton(false);
    }

    @Test(description = "Freemium - Header - lessonp-644:Resources")
    public void testLessonp_644() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testResourcesButton(true);
    }

    @Test(description = "Active user - Header - lessonp-649:Resources")
    public void testLessonp_649() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testResourcesButton(true);
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

    @Test(description = "Visitor - Header - lessonp-643:Header buttons")
    public void testLessonp_643() {
        testHeaderButtons(TestData.INVALID_EMAIL);
    }

    @Test(description = "Freemium - Header - lessonp-647:Header buttons")
    public void testLessonp_647() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testHeaderButtons(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Active user - Header - lessonp-652:Header buttons")
    public void testLessonp_652() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testHeaderButtons(TestData.VALID_EMAIL_ADMIN);
    }

    @Test(description = "Freemium - Header - lessonp-648:Your_Account")
    public void testLessonp_648() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testYourAccountButton();
    }

    private void testResourcesButton(boolean loggedIn) {
        lpHomePage.loadPage();
        headerPage.hoverOverResourcesButton();
        headerPage.clickOnDiscoverResourcesButton();
        Assert.assertEquals(TestData.DISCOVER_RESOURCES_PAGE_PATH, headerPage.getPath());

        headerPage.hoverOverResourcesButton();
        headerPage.clickOnBrowseResourceDirectoryButton();
        Assert.assertEquals(TestData.BROWSE_RESOURCE_DIRECTORY_PAGE_PATH, headerPage.getPath());

        headerPage.hoverOverResourcesButton();
        headerPage.clickOnSearchByStandardButton();
        Assert.assertEquals(TestData.SEARCH_BY_STANDARD_PAGE_PATH, headerPage.getPath());

        if (!loggedIn) {
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

        headerPage.hoverOverResourcesButton();
        headerPage.clickOnLessonPlanningArticlesButton();
        Assert.assertEquals(TestData.LESSON_PLANNING_ARTICLES_PAGE_PATH, headerPage.getPath());
    }

    private void testSolutionsButton() {
        lpHomePage.loadPage();
        headerPage.hoverOverSolutionsButton();
        headerPage.clickOnEducatorEditionButton();
        Assert.assertEquals(headerPage.getPath(), TestData.EDUCATOR_EDITION_PAGE_PATH);

        lpHomePage.loadPage();
        headerPage.hoverOverSolutionsButton();
        headerPage.clickOnSchoolEdition();
        Assert.assertEquals(headerPage.getUrl(), TestData.SCHOOL_EDITION_URL);

        lpHomePage.loadPage();
        headerPage.hoverOverSolutionsButton();
        headerPage.clickOnSchoolEditionAndPdLearningNetworkButton();
        Assert.assertEquals(headerPage.getUrl(), TestData.SCHOOL_EDITION_AND_PD_LEARNING_NETWORK_URL);
    }

    private void testAboutButton() {
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

    private void testHeaderButtons(String emailAddress) {
        lpHomePage.loadPage();
        headerPage.hoverOverResourcesButton();
        headerPage.hoverOverSolutionsButton();
        headerPage.hoverOverAboutButton();
        if (emailAddress.equals(TestData.INVALID_EMAIL)) {
            headerPage.clickOnPricingButton();
            Assert.assertEquals(headerPage.getPath(), TestData.PRICING_PAGE_PATH);
            headerPage.clickOnSignInButton(false);
            Assert.assertEquals(signInModal.getModalTitle(), TestData.SIGN_IN_MODAL_TITLE_TEXT);
            lpHomePage.loadPage();
            headerPage.clickOnTryItFree(false);
            Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
        } else {
            Assert.assertTrue(headerPage.isUsernameDropDownDisplayed());

            if (emailAddress.equals(TestData.VALID_EMAIL_FREEMIUM)) {
                headerPage.clickOnUpgradeMeButton();
                Assert.assertEquals(stepTwoModal.getTitleText(), TestData.STEP_TWO_TITLE_MESSAGE);
            }
        }
    }

    private void testYourAccountButton() {
        headerPage.hoverOverUserDropDownButton();
        headerPage.clickOnMyAccountButton();
    }

}
