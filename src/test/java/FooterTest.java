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
    private HowToUseVideoPage howToUseVideoPage;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        lpHomePage = new LpHomePage(webDriver);
        subscriptionPage = new SubscriptionPage(webDriver);
        footerPage = new FooterPage(webDriver);
        howToUseVideoPage = new HowToUseVideoPage(webDriver);
    }

    @Test(description = "Visitor - Footer - lessonp-656:Footer structure")
    public void testLessonp_656() {
        lpHomePage.loadPage();
        testClickOnLessonPlanetLogo();
        testSendEmailNewsletter(TestData.INVALID_EMAIL);
        testBasicInfoLinks();
        testLessonPlanetSocialLinks();
    }
    @Test(description = "Freemium - Footer - lessonp-665:Footer structure")
    public void testLessonp_665() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testClickOnLessonPlanetLogo();
        testSendEmailNewsletter(TestData.VALID_EMAIL_FREEMIUM);
        testBasicInfoLinks();
        testLessonPlanetSocialLinks();
    }

    @Test(description = "Active user- lessonp-669:Footer structure")
    public void testLessonp669() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testClickOnLessonPlanetLogo();
        testSendEmailNewsletter(TestData.VALID_EMAIL_ADMIN);
        testBasicInfoLinks();
        testLessonPlanetSocialLinks();
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

    private void testSendEmailNewsletter(String account) {
        if (footerPage.getTextFromEMailField().equals(TestData.EMPTY_FIELD_TEXT))
            footerPage.typeEmail(account);
        footerPage.clickSendButton();
        Assert.assertEquals(subscriptionPage.getSubscriptionText(), TestData.SUBSCRIPTION_TEXT);
        subscriptionPage.clickOnCloseButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.LP_HOME_PAGE_PATH);
        Assert.assertEquals(footerPage.getTextFromEMailField(), account);
    }

    private void testBasicInfoLinks() {
        lpHomePage.loadPage();
        footerPage.clickOnContactUsButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.CONTACT_US_PATH);

        footerPage.clickOnSiteMapButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.SITE_MAP_PATH);

        footerPage.clickOnPrivacyPolicyButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.PRIVACY_POLICY_PATH);

        footerPage.clickOnTermsOfUseButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.TERMS_OF_USE_PATH);
    }
    private void testLessonPlanetSocialLinks() {
        lpHomePage.loadPage();
        footerPage.clickOnLessonPlanetFacebookButton();;
        footerPage.focusDriverToLastTab();
        footerPage.waitForLinkToLoad();
        Assert.assertTrue(footerPage.getUrl().contains(TestData.FACEBOOK_URL));
        footerPage.closeTab();

        footerPage.clickOnLessonPlanetTwitterButton();
        footerPage.focusDriverToLastTab();
        footerPage.waitForLinkToLoad();
        Assert.assertTrue(footerPage.getUrl().contains(TestData.TWITTER_URL));
        footerPage.closeTab();

        footerPage.clickOnLessonPlanetGoogleButton();
        footerPage.focusDriverToLastTab();
        footerPage.waitForLinkToLoad();
        Assert.assertTrue(footerPage.getUrl().contains(TestData.GOOGLE_URL));
        footerPage.closeTab();

        footerPage.clickOnLessonPlanetLinkedInButton();
        footerPage.focusDriverToLastTab();
        footerPage.waitForLinkToLoad();
        Assert.assertTrue(footerPage.getUrl().contains(TestData.LINKEDIN_URL));
        footerPage.closeTab();

        footerPage.clickOnLessonPlanetYoutubeButton();
        footerPage.focusDriverToLastTab();
        footerPage.waitForLinkToLoad();
        Assert.assertTrue(footerPage.getUrl().contains(TestData.YOUTUBE_URL));
        footerPage.closeTab();

        footerPage.clickOnLessonPlanetPinterestButton();
        footerPage.focusDriverToLastTab();
        footerPage.waitForLinkToLoad();
        Assert.assertTrue(footerPage.getUrl().contains(TestData.PINTEREST_URL));
        footerPage.closeTab();
    }

    private void testOpenEducationalResourcesSection() {
        footerPage.clickOnHealthLink();
        footerPage.waitForLinkToLoad();
        Assert.assertEquals(lpHomePage.getPath(), TestData.HEALTH_PATH);

        lpHomePage.loadPage();
        footerPage.clickOnLanguageArtsLink();
        footerPage.waitForLinkToLoad();
        Assert.assertEquals(lpHomePage.getPath(), TestData.LANGUAGE_ARTS_PATH);

        lpHomePage.loadPage();
        footerPage.clickOnLanguagesLink();
        footerPage.waitForLinkToLoad();
        Assert.assertEquals(lpHomePage.getPath(), TestData.LANGUAGES_PATH);

        lpHomePage.loadPage();
        footerPage.clickOnMathLink();
        footerPage.waitForLinkToLoad();
        Assert.assertEquals(lpHomePage.getPath(), TestData.MATH_PATH);

        lpHomePage.loadPage();
        footerPage.clickOnPhysicalEducationLink();
        footerPage.waitForLinkToLoad();
        Assert.assertEquals(lpHomePage.getPath(), TestData.PHYSICAL_EDUCATION_PATH);

        lpHomePage.loadPage();
        footerPage.clickOnScienceLink();
        footerPage.waitForLinkToLoad();
        Assert.assertEquals(lpHomePage.getPath(), TestData.SCIENCE_PATH);

        lpHomePage.loadPage();
        footerPage.clickOnSocialStudiesLink();
        footerPage.waitForLinkToLoad();
        Assert.assertEquals(lpHomePage.getPath(), TestData.SOCIAL_STUDIES_PATH);

        lpHomePage.loadPage();
        footerPage.clickOnSpecialEducationLink();
        footerPage.waitForLinkToLoad();
        Assert.assertEquals(lpHomePage.getPath(), TestData.SPECIAL_EDUCATION_PATH);

        lpHomePage.loadPage();
        footerPage.clickOnVisualAndPerformingArtsLink();
        footerPage.waitForLinkToLoad();
        Assert.assertEquals(lpHomePage.getPath(), TestData.VISUAL_AND_PERFORMING_ARTS_PATH);
    }

    private void testDiscoverResourcesSection() {
        footerPage.clickOnOurReviewProcessLink();
        Assert.assertEquals(lpHomePage.getPath(), TestData.OUR_REVIEW_PROCESS_PATH);

        footerPage.clickOnHowItWorksLink();
        howToUseVideoPage.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.HOW_IT_WOKKS_PATH);

        footerPage.clickOnHowToSearchLink();
        howToUseVideoPage.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.HOW_TO_SEARCH_PATH);

        footerPage.clickOnCreateACollectionLink();
        howToUseVideoPage.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.CREATE_A_COLLECTION_PATH);
    }

    private void testManageCurriculumSection() {
        footerPage.clickOnEditACollectionLink();
        howToUseVideoPage.waitForModal();
        howToUseVideoPage.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.EDIT_A_COLLECTION_PATH);

        lpHomePage.loadPage();
        footerPage.clickOnAssignToStudentsLink();
        howToUseVideoPage.waitForModal();
        howToUseVideoPage.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.ASSIGN_TO_STUDENTS_PATH);

        lpHomePage.loadPage();
        footerPage.clickOnManageMyResourcesLink();
        howToUseVideoPage.waitForModal();
        howToUseVideoPage.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.MANAGE_MY_RESOURCES_PATH);

        lpHomePage.loadPage();
        footerPage.clickOnSharingWithOthersLink();
        howToUseVideoPage.waitForModal();
        howToUseVideoPage.clickOnXButton();
        Assert.assertEquals(lpHomePage.getPath(), TestData.SHARING_WITH_OTHERS_PATH);
    }

    private void testClickOnLessonPlanetLogo(){
        footerPage.clickOnLessonPlanetLogo();
        Assert.assertEquals(lpHomePage.getPath(), TestData.LP_HOME_PAGE_PATH);

    }
}




