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

    @Test(description = "Admin Manager - Regular SL - Footer - lessonp-4150:Footer structure")
    public void testLessonp_4150() {
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        testFooterContainer(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE);
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

    @Test(description = "Admin Manager - Regular SL - Footer - lessonp-4151:Open Educational Resources")
    public void testLessonp_4151() {
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
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

    @Test(description = "Admin Manager - Regular SL - Footer - lessonp4152:Discover Resources")
    public void testLessonp_4152() {
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
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

    @Test(description = "Admin Manager - Regular SL - Footer - lessonp-4153:Manage Curriculum")
    public void testLessonp_4153() {
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        testManageCurriculumSection();
    }

    @Test(description = "Visitor - Footer - lessonp-4033:Bottom footer links")
    public void testLessonp_4033() {
        lpHomePage.loadPage();
        testBottomFooterLinks();
    }

    @Test(description = "Freemium - Footer - lessonp-4112:Bottom footer links")
    public void testLessonp_4112() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testBottomFooterLinks();
    }

    @Test(description = "Active user - Footer - lessonp-4117:Bottom footer links")
    public void testLessonp_4117() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testBottomFooterLinks();
    }

    @Test(description = "Admin Manager - Regular SL - Footer - lessonp-4154:Bottom footer links")
    public void testLessonp_4154() {
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        testBottomFooterLinks();
    }

    @Test(description = "Visitor - Footer - lessonp-4034:Social links")
    public void testLessonp_4034() {
        lpHomePage.loadPage();
        testLessonPlanetSocialLinks();
    }

    @Test(description = "Freemium - Footer - lessonp-4114:Social links")
    public void testLessonp_4114() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testLessonPlanetSocialLinks();
    }

    @Test(description = "Active user - Footer - lessonp-4118:Social links")
    public void testLessonp_4118() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testLessonPlanetSocialLinks();
    }

    @Test(description = "Admin Manager - Regular SL - Footer - lessonp-4155:Social links")
    public void testLessonp_4155() {
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        testLessonPlanetSocialLinks();
    }

    @Test(description = "Visitor - Footer - lessonp-4035:LP logo")
    public void testLessonp_4035() {
        lpHomePage.loadPage();
        testLpLogo();
    }

    @Test(description = "Freemium - Footer - lessonp-4115:LP logo")
    public void testLessonp_4115() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testLpLogo();
    }

    @Test(description = "Active user - Footer - lessonp-4119:LP logo")
    public void testLessonp_4119() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testLpLogo();
    }

    @Test(description = "Admin Manager - Regular SL - Footer -  lessonp-4156:LE Logo")
    public void testLessonp_4156() {
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        testRegularSlLogo();
    }

    @Test(description = "Visitor - Footer - lessonp-4036:Newsletter")
    public void testLessonp_4036() {
        lpHomePage.loadPage();
        testSendEmailNewsletter(TestData.INVALID_EMAIL);
    }

    @Test(description = "Freemium - Footer - lessonp-4116:Newsletter")
    public void testLessonp_4116() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testSendEmailNewsletter(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Active user - Footer - lessonp-4120:Newsletter")
    public void testLessonp_4120() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testSendEmailNewsletter(TestData.VALID_EMAIL_ADMIN);
    }

    private void testFooterContainer(String account) {
        if (!account.equals(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE)) {
            Assert.assertTrue(footerPage.isLpLogoDisplayed());
            Assert.assertTrue(footerPage.isSignUpTextDisplayed());
            Assert.assertTrue(footerPage.isSubscriptionEmailInputDisplayed());
        } else {
            Assert.assertTrue(footerPage.isRegularSlLogoDisplayed());
            Assert.assertFalse(footerPage.isSignUpTextDisplayed());
            Assert.assertFalse(footerPage.isSubscriptionEmailInputDisplayed());
        }
        Assert.assertTrue(footerPage.isOpenEducationalResourcesSectionDisplayed());
        Assert.assertTrue(footerPage.isDiscoverResourcesSectionDisplayed());
        Assert.assertTrue(footerPage.isManageCurriculumSectionDisplayed());
        Assert.assertTrue(footerPage.isContactUsButtonDisplayed());
        Assert.assertTrue(footerPage.isSiteMapButtonDisplayed());
        Assert.assertTrue(footerPage.isPrivacyPolicyLinkDisplayed());
        Assert.assertTrue(footerPage.isTermsOfUseLinkDisplayed());
        Assert.assertTrue(footerPage.isFacebookButtonDisplayed());
        Assert.assertTrue(footerPage.isTwitterButtonDisplayed());
        Assert.assertTrue(footerPage.isLinkedinButtonDisplayed());
        Assert.assertTrue(footerPage.isYoutubeButtonDisplayed());
        Assert.assertTrue(footerPage.isPinterestButtonDisplayed());
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

        footerPage.clickOnFreeLessonPlansLink();
        Assert.assertEquals(browseBySubjectPage.getUrl(), TestData.FREE_LESSON_PLANS_PAGE_URL);
    }

    private void testDiscoverResourcesSection() {
        footerPage.clickOnOurReviewProcessLink();
        Assert.assertEquals(lpHomePage.getPath(), TestData.OUR_REVIEW_PROCESS_PAGE_PATH);

        footerPage.clickOnHowItWorksLink();
        videoContentModal.waitForModal();
        videoContentModal.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.HOW_IT_WORKS_PAGE_PATH);

        footerPage.clickOnHowToSearchLink();
        videoContentModal.waitForModal();
        videoContentModal.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.HOW_TO_SEARCH_PAGE_PATH);

        footerPage.clickOnCreateACollectionLink();
        videoContentModal.waitForModal();
        videoContentModal.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.CREATE_A_COLLECTION_PAGE_PATH);
    }

    private void testManageCurriculumSection() {
        footerPage.clickOnEditACollectionLink();
        videoContentModal.waitForModal();
        videoContentModal.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.EDIT_A_COLLECTION_PAGE_PATH);

        footerPage.clickOnAssignToStudentsLink();
        videoContentModal.waitForModal();
        videoContentModal.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.ASSIGN_TO_STUDENTS_PAGE_PATH);

        footerPage.clickOnManageMyResourcesLink();
        videoContentModal.waitForModal();
        videoContentModal.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.MANAGE_MY_RESOURCES_PAGE_PATH);

        footerPage.clickOnSharingWithOthersLink();
        videoContentModal.waitForModal();
        videoContentModal.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.SHARING_WITH_OTHERS_PAGE_PATH);
    }

    private void testBottomFooterLinks() {
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
        testNewTabUrl(TestData.FACEBOOK_URL, TestData.LESSON_PLANET_TEXT[2]);

        footerPage.clickOnLessonPlanetTwitterButton();
        testNewTabUrl(TestData.TWITTER_URL, TestData.LESSON_PLANET_TEXT[0]);

        footerPage.clickOnLessonPlanetLinkedInButton();
        testNewTabUrl(TestData.LINKEDIN_URL, TestData.LESSON_PLANET_TEXT[1]);

        footerPage.clickOnLessonPlanetYoutubeButton();
        testNewTabUrl(TestData.YOUTUBE_URL, TestData.LESSON_PLANET_TEXT[0]);

        footerPage.clickOnLessonPlanetPinterestButton();
        testNewTabUrl(TestData.PINTEREST_URL, TestData.LESSON_PLANET_TEXT[0]);
    }

    private void testNewTabUrl(String url, String lpText) {
        footerPage.waitForNewTab();
        footerPage.focusDriverToLastTab();
        footerPage.waitForLinkToLoad();
        Assert.assertTrue(footerPage.getUrl().contains(url) && footerPage.getUrl().contains(lpText));
        footerPage.closeTab();
    }

    private void testLpLogo() {
        Assert.assertTrue(footerPage.isLpLogoDisplayed());
        Assert.assertEquals(footerPage.getCopyrightText(), TestData.COPYRIGHT_TEXT);
        footerPage.clickOnLessonPlanetLogo(false);
        Assert.assertEquals(lpHomePage.getPath(), TestData.LP_HOME_PAGE_PATH);
        footerPage.clickOnLessonPlanetLogo(true);
        Assert.assertEquals(lpHomePage.getPath(), TestData.LP_HOME_PAGE_PATH);
    }

    private void testRegularSlLogo() {
        Assert.assertTrue(footerPage.isRegularSlLogoDisplayed());
        Assert.assertEquals(footerPage.getCopyrightText(), TestData.COPYRIGHT_TEXT);
        footerPage.clickOnRegularSlLogo(false);
        Assert.assertEquals(lpHomePage.getPath(), TestData.LP_HOME_PAGE_PATH);
        footerPage.clickOnRegularSlLogo(true);
        Assert.assertEquals(lpHomePage.getPath(), TestData.LP_HOME_PAGE_PATH);
    }

    private void testSendEmailNewsletter(String account) {
        Assert.assertTrue(footerPage.isSubscriptionEmailInputDisplayed());
        Assert.assertTrue(footerPage.isSignUpTextDisplayed());
        Assert.assertEquals(footerPage.getSignUpHintText(), TestData.SIGN_UP_HINT_TEXT);
        if (!account.equals(TestData.INVALID_EMAIL)) {
            Assert.assertEquals(footerPage.getTextFromSubscriptionEmailField(), account);
        } else {
            Assert.assertEquals(footerPage.getTextFromSubscriptionEmailField(), TestData.LP_HOME_PAGE_PATH);
            footerPage.typeEmail(account);
        }
        testSendButton(account);

        footerPage.clearSubscriptionEmail();
        footerPage.clickSendButton();
        Assert.assertEquals(footerPage.getSignUpErrorText(), TestData.REQUIRED_EMAIL_ERROR_TEXT);

        footerPage.typeEmail(TestData.NEW_COLLECTION_NAME);
        Assert.assertEquals(footerPage.getSignUpErrorText(), TestData.VALID_EMAIL_ERROR_TEXT);
    }

    private void testSendButton(String account) {
        footerPage.clickSendButton();
        subscriptionEmailModal.waitForModal();
        Assert.assertEquals(subscriptionEmailModal.getSubscriptionModalText(), TestData.SUBSCRIPTION_MODAL_TEXT);
        subscriptionEmailModal.clickOnCloseButton();
        Assert.assertEquals(footerPage.getTextFromSubscriptionEmailField(), account);
    }
}
