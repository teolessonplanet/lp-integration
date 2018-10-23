import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class FooterTest extends BaseTest {

    private LoginPage loginPage;
    private LpHomePage lpHomePage;
    private SubscriptionEmailModal subscriptionEmailModal;
    private FooterPage footerPage;
    private VideoContentModal videoContentModal;
    private BrowseBySubjectPage browseBySubjectPage;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        lpHomePage = new LpHomePage(webDriver);
        subscriptionEmailModal = new SubscriptionEmailModal(webDriver);
        footerPage = new FooterPage(webDriver);
        videoContentModal = new VideoContentModal(webDriver);
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

    @Test(description = "Active user - Footer - lessonp-669:Footer structure")
    public void testLessonp_669() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testFooterContainer(TestData.VALID_EMAIL_ADMIN);
    }

    @Test(description = "Visitor - Footer - lessonp-659:Open Educational Resources")
    public void testLessonp_659() {
        lpHomePage.loadPage();
        testOpenEducationalResourcesSection();
    }

    @Test(description = "Freemium - Footer - lessonp-667:Open Educational Resources")
    public void testLessonp_667() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testOpenEducationalResourcesSection();
    }

    @Test(description = "Active user - Footer - lessonp-671:Open Educational Resources")
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

    private void testSendButton(String account) {
        footerPage.clickSendButton();
        Assert.assertEquals(subscriptionEmailModal.getSubscriptionModalText(), TestData.SUBSCRIPTION_MODAL_TEXT);
        subscriptionEmailModal.clickOnCloseButton();
        Assert.assertEquals(footerPage.getTextFromEmailField(), account);
    }

    private void testSendEmailNewsletter(String account) {
        if (!account.equals(TestData.INVALID_EMAIL) ) {
            Assert.assertEquals(footerPage.getTextFromEmailField(), account);
        } else {
            Assert.assertEquals(footerPage.getTextFromEmailField(), TestData.LP_HOME_PAGE_PATH);
            footerPage.typeEmail(account);
        }
        testSendButton(account);
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
        footerPage.clickOnLessonPlanetFacebookButton();
        footerPage.focusDriverToLastTab();
        footerPage.waitForLinkToLoad();
        Assert.assertEquals(footerPage.getUrl(), TestData.FACEBOOK_PAGE_URL);
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
        Assert.assertEquals(footerPage.getUrl(), TestData.LINKEDIN_PAGE_URL);
        footerPage.closeTab();

        footerPage.clickOnLessonPlanetYoutubeButton();
        footerPage.focusDriverToLastTab();
        footerPage.waitForLinkToLoad();
        Assert.assertEquals(footerPage.getUrl(), TestData.YOUTUBE_PAGE_URL);
        footerPage.closeTab();

        footerPage.clickOnLessonPlanetPinterestButton();
        footerPage.focusDriverToLastTab();
        footerPage.waitForLinkToLoad();
        Assert.assertEquals(footerPage.getUrl(), TestData.PINTEREST_PAGE_URL);
        footerPage.closeTab();
    }

    private void testFooterContainer(String account) {
        testClickOnLessonPlanetLogo();
        testSendEmailNewsletter(account);
        testHelpInformationLinks();
        testLessonPlanetSocialLinks();
    }

    private void testOpenEducationalResourcesSection() {
        footerPage.clickOnHealthLink();
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.HEALTH_PAGE_TITLE);

        footerPage.clickOnLanguageArtsLink();
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.LANGUAGE_ARTS_PAGE_TITLE);

        footerPage.clickOnLanguagesLink();
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.LANGUAGES_PAGE_TITLE);

        footerPage.clickOnMathLink();
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.MATH_PAGE_TITLE);

        footerPage.clickOnPhysicalEducationLink();
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.PHYSICAL_EDUCATION_PAGE_TITLE);

        footerPage.clickOnScienceLink();
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.SCIENCE_PAGE_TITLE);

        footerPage.clickOnSocialStudiesLink();
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.SOCIAL_STUDIES_PAGE_TITLE);

        footerPage.clickOnSpecialEducationLink();
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.SPECIAL_EDUCATION_PAGE_TITLE);

        footerPage.clickOnVisualAndPerformingArtsLink();
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.VISUAL_AND_PERFORMING_ARTS_PAGE_TITLE);
    }

    private void testDiscoverResourcesSection() {
        footerPage.clickOnOurReviewProcessLink();
        Assert.assertEquals(lpHomePage.getPath(), TestData.OUR_REVIEW_PROCESS_PAGE_PATH);

        footerPage.clickOnHowItWorksLink();
        videoContentModal.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.HOW_IT_WORKS_PAGE_PATH);

        footerPage.clickOnHowToSearchLink();
        videoContentModal.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.HOW_TO_SEARCH_PAGE_PATH);

        footerPage.clickOnCreateACollectionLink();
        videoContentModal.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.CREATE_A_COLLECTION_PAGE_PATH);
    }

    private void testManageCurriculumSection() {
        footerPage.clickOnEditACollectionLink();
        videoContentModal.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.EDIT_A_COLLECTION_PAGE_PATH);

        footerPage.clickOnAssignToStudentsLink();
        videoContentModal.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.ASSIGN_TO_STUDENTS_PAGE_PATH);

        footerPage.clickOnManageMyResourcesLink();
        videoContentModal.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.MANAGE_MY_RESOURCES_PAGE_PATH);

        footerPage.clickOnSharingWithOthersLink();
        videoContentModal.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.SHARING_WITH_OTHERS_PAGE_PATH);
    }
}
