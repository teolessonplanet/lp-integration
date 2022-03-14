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

    @Test(description = "Visitor - Footer - C2048: Footer structure", groups = {"visitor"})
    public void tesC2048() {
        lpHomePage.loadPage();
        testFooterContainer(TestData.PLAN_VISITOR);
    }

    @Test(description = "Free member - Footer - C2139: Footer structure", groups = {"freemium"})
    public void testC2139() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testFooterContainer(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Footer - C2261: Footer structure", groups = {"activeUser"})
    public void testC2261() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testFooterContainer(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Footer - C2049: Open Educational Resources", groups = {"visitor"})
    public void testC2049() {
        lpHomePage.loadPage();
        testOpenEducationalResourcesSection();
    }

    @Test(description = "Free member - Footer - C2140: Open Educational Resources", groups = {"freemium"})
    public void testC2140() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testOpenEducationalResourcesSection();
    }

    @Test(description = "Active user - Footer - C2262: Open Educational Resources", groups = {"activeUser"})
    public void testC2262() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testOpenEducationalResourcesSection();
    }

    @Test(description = "Visitor - Footer - C2050: Discover Resources", groups = {"visitor"})
    public void testC2050() {
        lpHomePage.loadPage();
        testDiscoverResourcesSection();
    }

    @Test(description = "Free member - Footer - C2141: Discover Resources", groups = {"freemium"})
    public void testC2141() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testDiscoverResourcesSection();
    }

    @Test(description = "Active user - Footer - C2263: Discover Resources", groups = {"activeUser"})
    public void testC2263() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testDiscoverResourcesSection();
    }

    @Test(description = "Visitor - Footer - C2051: Manage Curriculum", groups = {"visitor"})
    public void testC2051() {
        lpHomePage.loadPage();
        testManageCurriculumSection();
    }

    @Test(description = "Free member - Footer - C2142: Manage Curriculum", groups = {"freemium"})
    public void testC2142() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testManageCurriculumSection();
    }

    @Test(description = "Active user - Footer - C2264: Manage Curriculum", groups = {"activeUser"})
    public void testC2264() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testManageCurriculumSection();
    }

    @Test(description = "Visitor - Footer - C2052: Bottom footer links", groups = {"visitor"})
    public void testC2052() {
        lpHomePage.loadPage();
        testBottomFooterLinks(TestData.PLAN_VISITOR);
    }

    @Test(description = "Free member - Footer - C2143: Bottom footer links", groups = {"freemium"})
    public void testC2143() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testBottomFooterLinks(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Footer - C2265: Bottom footer links", groups = {"activeUser"})
    public void testC2265() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testBottomFooterLinks(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Footer - C2053: Social links", groups = {"visitor"})
    public void testC2053() {
        lpHomePage.loadPage();
        testLessonPlanetSocialLinks();
    }

    @Test(description = "Free member - Footer - C2144: Social links", groups = {"freemium"})
    public void testC2144() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testLessonPlanetSocialLinks();
    }

    @Test(description = "Active user - Footer - C2266: Social links", groups = {"activeUser"})
    public void testC2266() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testLessonPlanetSocialLinks();
    }

    @Test(description = "Visitor - Footer - C2054: LP logo", groups = {"visitor"})
    public void testC2054() {
        lpHomePage.loadPage();
        testLpLogo();
    }

    @Test(description = "Free member - Footer - C2145: LP logo", groups = {"freemium"})
    public void testC2145() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testLpLogo();
    }

    @Test(description = "Active user - Footer - C2267: LP logo", groups = {"activeUser"})
    public void testC2267() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testLpLogo();
    }

    @Test(description = "Visitor - Footer - C2055: Newsletter", groups = {"visitor"})
    public void testC2055() {
        lpHomePage.loadPage();
        testSendEmailNewsletter(TestData.PLAN_VISITOR);
    }

    @Test(description = "Free member - Footer - C2146: Newsletter", groups = {"freemium"})
    public void testC2146() {
        String userEmail = stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testSendEmailNewsletter(userEmail);
    }

    @Test(description = "Active user - Footer - C2268: Newsletter", groups = {"activeUser"})
    public void testC2268() {
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
            Assert.assertTrue(footerPage.isNewsletterSubscriptionEmailInputDisplayed());
            Assert.assertTrue(footerPage.isContactUsButtonDisplayed());
            Assert.assertTrue(footerPage.isOpenEducationalResourcesSectionDisplayed());
            Assert.assertTrue(footerPage.isDiscoverResourcesSectionDisplayed());
            Assert.assertTrue(footerPage.isManageCurriculumSectionDisplayed());
            Assert.assertTrue(footerPage.isSiteMapLinkDisplayed());
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

            footerPage.clickOnSiteMapLink();
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
        Assert.assertTrue(footerPage.isNewsletterSubscriptionEmailInputDisplayed());
        Assert.assertTrue(footerPage.isSignUpTextDisplayed());
        Assert.assertEquals(footerPage.getSignUpHintText(), TestData.SIGN_UP_HINT_TEXT);
        String visitorMail = "";
        if (!account.equals(TestData.PLAN_VISITOR)) {
            Assert.assertEquals(footerPage.getTextFromNewsletterSubscriptionEmailField(), account);
        } else {
            Assert.assertEquals(footerPage.getTextFromNewsletterSubscriptionEmailField(), TestData.LP_HOME_PAGE_PATH);
            visitorMail = TestData.GET_NEW_EMAIL();
            footerPage.typeEmail(visitorMail);
        }
        if (account.equals(TestData.PLAN_VISITOR)) {
            testSendButton(visitorMail);
        } else {
            testSendButton(account);
        }

        footerPage.clearNewsletterSubscriptionEmail();
        footerPage.clickOnSendButton();
        Assert.assertEquals(footerPage.getSignUpErrorText(), TestData.REQUIRED_EMAIL_ERROR_TEXT);

        footerPage.typeEmail(TestData.NEW_COLLECTION_NAME);
        Assert.assertEquals(footerPage.getSignUpErrorText(), TestData.VALID_EMAIL_ERROR_TEXT);
    }

    private void testSendButton(String account) {
        footerPage.clickOnSendButton();
        subscriptionEmailModal.waitForModal();
        Assert.assertEquals(subscriptionEmailModal.getSubscriptionModalText(), TestData.SUBSCRIPTION_MODAL_TEXT);
        subscriptionEmailModal.clickOnCloseButton();
        Assert.assertEquals(footerPage.getTextFromNewsletterSubscriptionEmailField(), account);
    }
}
