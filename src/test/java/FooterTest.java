import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class FooterTest extends BaseTest {

    private LoginPage loginPage;
    private LpHomePage lpHomePage;
    private SubscriptionPage subscriptionPage;
    private FooterPage footerPage;
    private VideoContentModalPage videoContentModalPage;
    private BrowseBySubjectPage browseBySubjectPage;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        lpHomePage = new LpHomePage(webDriver);
        subscriptionPage = new SubscriptionPage(webDriver);
        footerPage = new FooterPage(webDriver);
        videoContentModalPage = new VideoContentModalPage(webDriver);
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
    }

    @Test(description = "Visitor - Footer - lessonp-656:Footer structure")
    public void testLessonp_656() {
        lpHomePage.loadPage();
        testFooterContainer(TestData.INVALID_EMAIL);
    }

    @Test(description = "Freemium - Footer - lessonp-665:Footer structure")
    public void testLessonp_665() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testFooterContainer(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Active user- lessonp-669:Footer structure")
    public void testLessonp669() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testFooterContainer(TestData.VALID_EMAIL_ADMIN);
    }

    @Test(description = "Visitor - Footer - lessonp-659:Open Educational Resources")
    public void testLessonp_659() {
        lpHomePage.loadPage();
        testOpenEducationalResourcesSection();
    }

    @Test(description = "Freemium - lessonp-667:Open Educational Resources")
    public void testLessonp_667() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testOpenEducationalResourcesSection();
    }

    @Test(description = "Active user - lessonp-671:Open Educational Resources")
    public void testLessonp_671() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testOpenEducationalResourcesSection();
    }

    @Test(description = "Visitor - Footer - lessonp-660:Discover Resources")
    public void testLessonp_660() {
        lpHomePage.loadPage();
        testDiscoverResourcesSection();
    }

    @Test(description = "Freemium - Footer - lessonp-668:Discover Resources")
    public void testLessonp_668() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testDiscoverResourcesSection();
    }

    @Test(description = "Active user - Footer - lessonp672:Discover Resources")
    public void testLessonp_672() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testDiscoverResourcesSection();
    }

    @Test(description = "Visitor - Footer - lessonp-658:Manage Curriculum")
    public void testLessonp_658() {
        lpHomePage.loadPage();
        testManageCurriculumSection();
    }

    @Test(description = "Freemium - Footer - lessonp-666:Manage Curriculum")
    public void testLessonp_666() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testManageCurriculumSection();
    }

    @Test(description = "Active user - Footer - lessonp-670:Manage Curriculum")
    public void testLessonp_670() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testManageCurriculumSection();
    }

    private void testClickOnLessonPlanetLogo() {
        footerPage.clickOnLessonPlanetLogo();
        Assert.assertEquals(lpHomePage.getPath(), TestData.LP_HOME_PAGE_PATH);
    }

    private void testSendEmailNewsletter(String account) {
        if (account.equals(TestData.VALID_EMAIL_FREEMIUM) || account.equals(TestData.VALID_EMAIL_ADMIN)) {
            Assert.assertEquals(footerPage.getTextFromEMailField(), account);
            testSendButton(account);
        } else {
            Assert.assertEquals(footerPage.getTextFromEMailField(), TestData.EMPTY_FIELD_TEXT);
            footerPage.typeEmail(account);
            testSendButton(account);
        }
    }

    private void testSendButton(String account) {
        footerPage.clickSendButton();
        Assert.assertEquals(subscriptionPage.getSubscriptionModalText(), TestData.SUBSCRIPTION_TEXT);
        subscriptionPage.clickOnCloseButton();
        Assert.assertEquals(footerPage.getTextFromEMailField(), account);
    }

    private void testHelpInformationLinks() {
        footerPage.clickOnContactUsButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.CONTACT_US_PAGE_PATH);

        footerPage.clickOnSiteMapButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.SITE_MAP_PAGE_PATH);

        footerPage.clickOnPrivacyPolicyButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.PRIVACY_POLICY_PAGE_PATH);

        footerPage.clickOnTermsOfUseButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.TERMS_OF_USE_PAGE_PATH);
    }

    private void testLessonPlanetSocialLinks() {
        lpHomePage.loadPage();

        footerPage.clickOnLessonPlanetFacebookButton();
        footerPage.focusDriverToLastTab();
        footerPage.waitForLinkToLoad();
        Assert.assertTrue(footerPage.getUrl().contains(TestData.FACEBOOK_PAGE_URL));
        footerPage.closeTab();

        footerPage.clickOnLessonPlanetTwitterButton();
        footerPage.focusDriverToLastTab();
        footerPage.waitForLinkToLoad();
        Assert.assertEquals(footerPage.getUrl(), TestData.TWITTER_PAGE_URL);
        footerPage.closeTab();

        footerPage.clickOnLessonPlanetGoogleButton();
        footerPage.focusDriverToLastTab();
        footerPage.waitForLinkToLoad();
        Assert.assertEquals(footerPage.getUrl(), TestData.GOOGLE_PAGE_URL);
        footerPage.closeTab();

        footerPage.clickOnLessonPlanetLinkedInButton();
        footerPage.focusDriverToLastTab();
        footerPage.waitForLinkToLoad();
        Assert.assertTrue(footerPage.getUrl().contains(TestData.LINKEDIN_PAGE_URL));
        footerPage.closeTab();

        footerPage.clickOnLessonPlanetYoutubeButton();
        footerPage.focusDriverToLastTab();
        footerPage.waitForLinkToLoad();
        Assert.assertTrue(footerPage.getUrl().contains(TestData.YOUTUBE_PAGE_URL));
        footerPage.closeTab();

        footerPage.clickOnLessonPlanetPinterestButton();
        footerPage.focusDriverToLastTab();
        footerPage.waitForLinkToLoad();
        Assert.assertTrue(footerPage.getUrl().contains(TestData.PINTEREST_PAGE_URL));
        footerPage.closeTab();
    }

    private void testFooterContainer(String account) {
        testClickOnLessonPlanetLogo();

        testSendEmailNewsletter(account);

        testHelpInformationLinks();

        testLessonPlanetSocialLinks();
    }

    private void checkPageTitle(String expectedTitle) {
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), expectedTitle);
        browseBySubjectPage.goBackOnePage();
    }

    private void testOpenEducationalResourcesSection() {
        footerPage.loadPage();

        footerPage.clickOnHealthLink();
        checkPageTitle(TestData.HEALTH_PAGE_TITLE);

        footerPage.clickOnLanguageArtsLink();
        checkPageTitle(TestData.LANGUAGE_ARTS_PAGE_TITLE);

        footerPage.clickOnLanguagesLink();
        checkPageTitle(TestData.LANGUAGES_PAGE_TITLE);

        footerPage.clickOnMathLink();
        checkPageTitle(TestData.MATH_PAGE_TITLE);

        footerPage.clickOnPhysicalEducationLink();
        checkPageTitle(TestData.PHYSICAL_EDUCATION_PAGE_TITLE);

        footerPage.clickOnScienceLink();
        checkPageTitle(TestData.SCIENCE_PAGE_TITLE);

        footerPage.clickOnSocialStudiesLink();
        checkPageTitle(TestData.SOCIAL_STUDIES_PAGE_TITLE);

        footerPage.clickOnSpecialEducationLink();
        checkPageTitle(TestData.SPECIAL_EDUCATION_PAGE_TITLE);

        footerPage.clickOnVisualAndPerformingArtsLink();
        checkPageTitle(TestData.VISUAL_AND_PERFORMING_ARTS_PAGE_TITLE);
    }

    private void testDiscoverResourcesSection() {
        footerPage.clickOnOurReviewProcessLink();
        Assert.assertEquals(lpHomePage.getPath(), TestData.OUR_REVIEW_PROCESS_PAGE_PATH);

        footerPage.clickOnHowItWorksLink();
        videoContentModalPage.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.HOW_IT_WORKS_PAGE_PATH);

        footerPage.clickOnHowToSearchLink();
        videoContentModalPage.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.HOW_TO_SEARCH_PAGE_PATH);

        footerPage.clickOnCreateACollectionLink();
        videoContentModalPage.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.CREATE_A_COLLECTION_PAGE_PATH);
    }

    private void testManageCurriculumSection() {
        footerPage.clickOnEditACollectionLink();
        videoContentModalPage.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.EDIT_A_COLLECTION_PAGE_PATH);

        lpHomePage.loadPage();
        footerPage.clickOnAssignToStudentsLink();
        videoContentModalPage.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.ASSIGN_TO_STUDENTS_PAGE_PATH);

        lpHomePage.loadPage();
        footerPage.clickOnManageMyResourcesLink();
        videoContentModalPage.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.MANAGE_MY_RESOURCES_PAGE_PATH);

        lpHomePage.loadPage();
        footerPage.clickOnSharingWithOthersLink();
        videoContentModalPage.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.SHARING_WITH_OTHERS_PAGE_PATH);
    }
}
