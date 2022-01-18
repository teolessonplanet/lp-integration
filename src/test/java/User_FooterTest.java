import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class User_FooterTest extends BaseTest {

    private StepTwoPage stepTwoPage;
    private LpHomePage lpHomePage;
    private SubscriptionEmailModal subscriptionEmailModal;
    private FooterPage footerPage;
    private VideoContentModal videoContentModal;
    private BrowseBySubjectPage browseBySubjectPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        stepTwoPage = new StepTwoPage(webDriver);
        lpHomePage = new LpHomePage(webDriver);
        subscriptionEmailModal = new SubscriptionEmailModal(webDriver);
        footerPage = new FooterPage(webDriver);
        videoContentModal = new VideoContentModal(webDriver);
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
    }

    @Test(description = "Visitor - Footer - lessonp-656: Footer structure", groups = {"visitor"})
    public void testLessonp_656() {
        lpHomePage.loadPage();
        testFooterContainer(TestData.PLAN_VISITOR);
    }

    @Test(description = "Free member - Footer - lessonp-665: Footer structure", groups = {"freemium"})
    public void testLessonp_665() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testFooterContainer(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Footer - lessonp-669: Footer structure", groups = {"activeUser"})
    public void testLessonp_669() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testFooterContainer(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Footer - lessonp-659: Open Educational Resources", groups = {"visitor"})
    public void testLessonp_659() {
        lpHomePage.loadPage();
        testOpenEducationalResourcesSection();
    }

    @Test(description = "Free member - Footer - lessonp-667: Open Educational Resources", groups = {"freemium"})
    public void testLessonp_667() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testOpenEducationalResourcesSection();
    }

    @Test(description = "Active user - Footer - lessonp-671: Open Educational Resources", groups = {"activeUser"})
    public void testLessonp_671() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testOpenEducationalResourcesSection();
    }

    @Test(description = "Visitor - Footer - lessonp-660: Discover Resources", groups = {"visitor"})
    public void testLessonp_660() {
        lpHomePage.loadPage();
        testDiscoverResourcesSection();
    }

    @Test(description = "Free member - Footer - lessonp-668: Discover Resources", groups = {"freemium"})
    public void testLessonp_668() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testDiscoverResourcesSection();
    }

    @Test(description = "Active user - Footer - lessonp672: Discover Resources", groups = {"activeUser"})
    public void testLessonp_672() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testDiscoverResourcesSection();
    }

    @Test(description = "Visitor - Footer - lessonp-658: Manage Curriculum", groups = {"visitor"})
    public void testLessonp_658() {
        lpHomePage.loadPage();
        testManageCurriculumSection();
    }

    @Test(description = "Free member - Footer - lessonp-666: Manage Curriculum", groups = {"freemium"})
    public void testLessonp_666() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testManageCurriculumSection();
    }

    @Test(description = "Active user - Footer - lessonp-670: Manage Curriculum", groups = {"activeUser"})
    public void testLessonp_670() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testManageCurriculumSection();
    }

    @Test(description = "Visitor - Footer - lessonp-4033: Bottom footer links", groups = {"visitor"})
    public void testLessonp_4033() {
        lpHomePage.loadPage();
        testBottomFooterLinks(TestData.PLAN_VISITOR);
    }

    @Test(description = "Free member - Footer - lessonp-4112: Bottom footer links", groups = {"freemium"})
    public void testLessonp_4112() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testBottomFooterLinks(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Footer - lessonp-4117: Bottom footer links", groups = {"activeUser"})
    public void testLessonp_4117() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testBottomFooterLinks(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Footer - lessonp-4034: Social links", groups = {"visitor"})
    public void testLessonp_4034() {
        lpHomePage.loadPage();
        testLessonPlanetSocialLinks();
    }

    @Test(description = "Free member - Footer - lessonp-4114: Social links", groups = {"freemium"})
    public void testLessonp_4114() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testLessonPlanetSocialLinks();
    }

    @Test(description = "Active user - Footer - lessonp-4118: Social links", groups = {"activeUser"})
    public void testLessonp_4118() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testLessonPlanetSocialLinks();
    }

    @Test(description = "Visitor - Footer - lessonp-4035: LP logo", groups = {"visitor"})
    public void testLessonp_4035() {
        lpHomePage.loadPage();
        testLpLogo();
    }

    @Test(description = "Free member - Footer - lessonp-4115: LP logo", groups = {"freemium"})
    public void testLessonp_4115() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testLpLogo();
    }

    @Test(description = "Active user - Footer - lessonp-4119: LP logo", groups = {"activeUser"})
    public void testLessonp_4119() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testLpLogo();
    }

    @Test(description = "Visitor - Footer - lessonp-4036: Newsletter", groups = {"visitor"})
    public void testLessonp_4036() {
        lpHomePage.loadPage();
        testSendEmailNewsletter(TestData.PLAN_VISITOR);
    }

    @Test(description = "Free member - Footer - lessonp-4116: Newsletter", groups = {"freemium"})
    public void testLessonp_4116() {
        String userEmail = stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testSendEmailNewsletter(userEmail);
    }

    @Test(description = "Active user - Footer - lessonp-4120: Newsletter", groups = {"activeUser"})
    public void testLessonp_4120() {
        String userEmail = stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testSendEmailNewsletter(userEmail);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    public void testFooterContainer(String account) {
        if (!account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            Assert.assertTrue(footerPage.isLpLogoDisplayed());
            Assert.assertTrue(footerPage.isSignUpTextDisplayed());
            Assert.assertTrue(footerPage.isSubscriptionEmailInputDisplayed());
            Assert.assertTrue(footerPage.isContactUsButtonDisplayed());
            Assert.assertTrue(footerPage.isOpenEducationalResourcesSectionDisplayed());
            Assert.assertTrue(footerPage.isDiscoverResourcesSectionDisplayed());
            Assert.assertTrue(footerPage.isManageCurriculumSectionDisplayed());
            Assert.assertTrue(footerPage.isSiteMapButtonDisplayed());
            Assert.assertTrue(footerPage.isPrivacyPolicyLinkDisplayed());
            Assert.assertTrue(footerPage.isTermsOfUseLinkDisplayed());
            Assert.assertTrue(footerPage.isFacebookButtonDisplayed());
            Assert.assertTrue(footerPage.isTwitterButtonDisplayed());
            Assert.assertTrue(footerPage.isLinkedinButtonDisplayed());
            Assert.assertTrue(footerPage.isYoutubeButtonDisplayed());
            Assert.assertTrue(footerPage.isPinterestButtonDisplayed());
        } else {
            Assert.assertTrue(footerPage.isRegularSlLogoDisplayed());
            Assert.assertTrue(footerPage.isRegularSlIframeCopyrightTextDisplayed());
            Assert.assertEquals(footerPage.getRegularSlIframeCopyrightText(), TestData.RSL_IFRAME_COPYRIGHT_TEXT);
            Assert.assertTrue(footerPage.isRegularSlIframeTermsLinkDisplayed());
        }
    }

    public void testOpenEducationalResourcesSection() {
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

        footerPage.clickOnViewAllLessonPlansLink();
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.VIEW_ALL_LESSON_PLANS_PAGE_URL);
    }

    public void testDiscoverResourcesSection() {
        footerPage.clickOnOurReviewProcessLink();
        Assert.assertEquals(lpHomePage.getPath(), TestData.OUR_REVIEW_PROCESS_PAGE_PATH);

        footerPage.clickOnHowItWorksLink();
        videoContentModal.waitForModal();
        videoContentModal.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.HOW_IT_WORKS_PAGE_PATH);
        lpHomePage.loadPage();

        footerPage.clickOnHowToSearchLink();
        videoContentModal.waitForModal();
        videoContentModal.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.HOW_TO_SEARCH_PAGE_PATH);

        footerPage.clickOnCreateACollectionLink();
        videoContentModal.waitForModal();
        videoContentModal.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.CREATE_A_COLLECTION_PAGE_PATH);
    }

    public void testManageCurriculumSection() {
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

    public void testBottomFooterLinks(String account) {
        if (!account.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            footerPage.clickOnContactUsButton();
            Assert.assertEquals(lpHomePage.getPath(), TestData.CONTACT_US_PAGE_PATH);

            footerPage.clickOnSiteMapButton();
            Assert.assertEquals(lpHomePage.getPath(), TestData.SITE_MAP_PAGE_PATH);

            footerPage.clickOnPrivacyPolicyButton();
            Assert.assertEquals(lpHomePage.getPath(), TestData.PRIVACY_POLICY_PAGE_PATH);

            footerPage.clickOnTermsOfUseButton();
            Assert.assertEquals(lpHomePage.getPath(), TestData.TERMS_OF_USE_PAGE_PATH);
        } else {
            footerPage.clickOnRegularSlIframeTermsLink();
            footerPage.waitForNewTab();
            footerPage.focusDriverToLastTab();
            footerPage.waitForLinkToLoad();
            Assert.assertEquals(lpHomePage.getUrl(), TestData.LEARNING_EXPLORER_TERMS_URL);
        }
    }

    public void testLessonPlanetSocialLinks() {
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

    public void testNewTabUrl(String url, String lpText) {
        footerPage.waitForNewTab();
        footerPage.focusDriverToLastTab();
        footerPage.waitForLinkToLoad();
        final String urlText = footerPage.getUrl();
        Assert.assertTrue(urlText.contains(url));
        if (url.equals(TestData.YOUTUBE_URL)) {
            Assert.assertTrue(urlText.contains(lpText) || urlText.endsWith(TestData.YOUTUBE_CHANNEL_PATH));
        } else {
            Assert.assertTrue(urlText.contains(lpText));
        }
        footerPage.closeTab();
    }

    public void testLpLogo() {
        Assert.assertTrue(footerPage.isLpLogoDisplayed());
        Assert.assertEquals(footerPage.getCopyrightText(), TestData.COPYRIGHT_TEXT);
        footerPage.clickOnLessonPlanetLogo(false);
        Assert.assertEquals(lpHomePage.getPath(), TestData.LP_HOME_PAGE_PATH);
        footerPage.clickOnLessonPlanetLogo(true);
        Assert.assertEquals(lpHomePage.getPath(), TestData.LP_HOME_PAGE_PATH);
    }

    public void testRegularSlLogo() {
        Assert.assertTrue(footerPage.isRegularSlLogoDisplayed());
        footerPage.clickOnRegularSlLogo(false);
        footerPage.waitForLinkToLoad();
        Assert.assertEquals(lpHomePage.getPath(), TestData.DISCOVER_RESOURCES_PAGE_PATH);
        lpHomePage.goBackOnePage();
        footerPage.waitForPageLoad();
        footerPage.clickOnRegularSlLogo(true);
        Assert.assertEquals(lpHomePage.getPath(), TestData.DISCOVER_RESOURCES_PAGE_PATH);
    }

    private void testSendEmailNewsletter(String account) {
        lpHomePage.loadPage();
        Assert.assertTrue(footerPage.isSubscriptionEmailInputDisplayed());
        Assert.assertTrue(footerPage.isSignUpTextDisplayed());
        Assert.assertEquals(footerPage.getSignUpHintText(), TestData.SIGN_UP_HINT_TEXT);
        String visitorMail = "";
        if (!account.equals(TestData.PLAN_VISITOR)) {
            Assert.assertEquals(footerPage.getTextFromSubscriptionEmailField(), account);
        } else {
            Assert.assertEquals(footerPage.getTextFromSubscriptionEmailField(), TestData.LP_HOME_PAGE_PATH);
            visitorMail = TestData.GET_NEW_EMAIL();
            footerPage.typeEmail(visitorMail);
        }
        if (account.equals(TestData.PLAN_VISITOR)) {
            testSendButton(visitorMail);
        } else {
            testSendButton(account);
        }

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
