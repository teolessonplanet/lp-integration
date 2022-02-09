import com.lessonplanet.pages.HomePage;
import com.lessonplanet.pages.StepOneModal;
import com.lessonplanet.pages.StepTwoModal;
import com.lessonplanet.pages.StepTwoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class User_HomepageTest extends BaseTest {

    private HomePage homePage;
    private StepOneModal stepOneModal;
    private StepTwoPage stepTwoPage;
    private StepTwoModal stepTwoModal;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        homePage = new HomePage(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        stepTwoModal = new StepTwoModal(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Visitor - Homepage - C2100: Discover", groups = {"visitor"})
    public void testC2100() {
        testDiscoverTab();
    }

    @Test(description = "Free Member - Homepage - C2194: Discover", groups = {"freemium"})
    public void tesC2194() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testDiscoverTab();
    }

    @Test(description = "Active User - Homepage - C2315: Discover", groups = {"activeUser"})
    public void testC2315() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testDiscoverTab();
    }

    @Test(description = "Visitor - Homepage - C2101: Collect", groups = {"visitor"})
    public void testC2101() {
        testCollectTab();
    }

    @Test(description = "Freemium - Homepage - C2200: Collect", groups = {"freemium"})
    public void testC2200() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testCollectTab();
    }

    @Test(description = "Active user - Homepage - C2320: Collect", groups = {"activeUser"})
    public void testC2320() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testCollectTab();
    }

    @Test(description = "Visitor - Homepage - C2102 :Design", groups = {"visitor"})
    public void testC2102() {
        testDesignTab();
    }

    @Test(description = "Freemium - Homepage - C2201: Design", groups = {"freemium"})
    public void testC2201() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testDesignTab();
    }

    @Test(description = "Active user - Homepage - C2321: Design", groups = {"activeUser"})
    public void testC2321() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testDesignTab();
    }

    @Test(description = "Visitor - Homepage - C2099: Deliver", groups = {"visitor"})
    public void testC2099() {
        testDeliverTab();
    }

    @Test(description = "Freemium - Homepage - C2202: Deliver", groups = {"freemium"})
    public void testC2202() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testDeliverTab();
    }

    @Test(description = "Active user - Homepage -C2322: Deliver", groups = {"activeUser"})
    public void testC2322() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testDeliverTab();
    }

    @Test(description = "Visitor - Homepage - C2103: Parent", groups = {"visitor"})
    public void testC2103() {
        testParentEdition(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - C2203: Parent", groups = {"freemium"})
    public void testC2203() {
        testParentEdition(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - C2323 :Parent", groups = {"activeUser"})
    public void testC2323() {
        testParentEdition(TestData.PLAN_STARTER);
    }

    @Test(description = "Visitor - Homepage - C2104: Educator", groups = {"visitor"})
    public void testC2104() {
        testEducatorSection(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - C2204: Educator", groups = {"freemium"})
    public void testC2204() {
        testEducatorSection(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - C2324: Educator", groups = {"activeUser"})
    public void testC2324() {
        testEducatorSection(TestData.PLAN_STARTER);
    }

    @Test(description = "Visitor - Homepage - C2105: School or District", groups = {"visitor"})
    public void testC2105() {
        testSchoolOrDistrictSection(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - C2205: School or District", groups = {"freemium"})
    public void testC2205() {
        testSchoolOrDistrictSection(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - C2325: School or District", groups = {"activeUser"})
    public void testC2325() {
        testSchoolOrDistrictSection(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Homepage - C2106 Explore our solutions", groups = {"visitor"})
    public void testC2106() {
        testExploreOurSolution(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - C2206: Explore our solutions", groups = {"freemium"})
    public void testC2206() {
        testExploreOurSolution(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - C2326:E xplore our solutions", groups = {"activeUser"})
    public void testC2326() {
        testExploreOurSolution(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Homepage - C2107: Educator Edition section", groups = {"visitor"})
    public void testC2107() {
        testEducatorEdition(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - C2195: Educator Edition section", groups = {"freemium"})
    public void testC2195() {
        testEducatorEdition(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - C2316: Educator Edition section", groups = {"activeUser"})
    public void testC2316() {
        testEducatorEdition(TestData.PLAN_STARTER);
    }

    @Test(description = "Visitor - Homepage - C2108: Learning Explorer section", groups = {"visitor"})
    public void testC2108() {
        testLearningExplorerArea(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - C2196: Learning Explorer section", groups = {"freemium"})
    public void testC2196() {
        testLearningExplorerArea(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - C2317: Learning Explorer section", groups = {"activeUser"})
    public void testC2317() {
        testLearningExplorerArea(TestData.PLAN_STARTER);
    }

    @Test(description = "Visitor - Homepage - C2109: PD Learning Network section", groups = {"visitor"})
    public void testC2109() {
        testPdLearningArea(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - C2197: PD Learning Network section", groups = {"freemium"})
    public void testC2197() {
        testPdLearningArea(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - C2318: PD Learning Network section", groups = {"activeUser"})
    public void testC2318() {
        testPdLearningArea(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Homepage - C2110: What educators and parents are saying: section", groups = {"visitor"})
    public void testC2110() {
        testTestimonials(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - C2198: What educators and parents are saying: section", groups = {"freemium"})
    public void testC2198() {
        testTestimonials(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user- Homepage - C2319: What educators and parents are saying: section", groups = {"visitor"})
    public void testC2319() {
        testTestimonials(TestData.PLAN_STARTER);
    }

    @Test(description = "Visitor - Homepage - C2111: Discover.Create.Inspire section", groups = {"visitor"})
    public void testC2111() {
        testInspireArea(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - C2199: Discover.Create.Inspire section", groups = {"freemium"})
    public void testC2199() {
        testInspireArea(TestData.PLAN_FREEMIUM);
    }

    protected void testDiscoverTab() {
        homePage.loadPage();
        Assert.assertEquals(TestData.LP_HOME_PAGE_PATH, homePage.getPath());
        Assert.assertTrue(homePage.isDiscoverAreaDisplayed());

        homePage.clickOnBlueButton();
        Assert.assertEquals(TestData.SEARCH_PAGE_PATH, homePage.getPath());
        homePage.goBackOnePage();

        homePage.clickOnWatchVideoButton();
        homePage.clickOnStartVideo();
        Assert.assertEquals(TestData.HOMEPAGE_VIDEO_SRC, homePage.getVideoSourceText());
        homePage.clickOnCloseVideoButton();

        final String discoverTabText = homePage.getDiscoverTabText();
        final String discoverTitle = homePage.getDiscoverTitle();
        final String discoverDescription = homePage.getDiscoverDescriptionText();
        final String discoverBlueButtonText = homePage.getHeroButtonText();
        final String discoverWatchVideoButtonText = homePage.getWatchVideoButtonText();
        final String card1Text = homePage.getCardTextFromDiscoverArea(0);
        final String card2Text = homePage.getCardTextFromDiscoverArea(1);
        final String card3Text = homePage.getCardTextFromDiscoverArea(2);
        final String card4Text = homePage.getCardTextFromDiscoverArea(3);

        Assert.assertEquals(TestData.HOMEPAGE_DISCOVER_TAB_TEXT, discoverTabText);
        Assert.assertEquals(TestData.HOMEPAGE_DISCOVER_TITLE, discoverTitle);
        Assert.assertEquals(TestData.HOMEPAGE_DISCOVER_TEXT, discoverDescription);
        Assert.assertEquals(TestData.HOMEPAGE_START_SEARCHING_BUTTON_TEXT, discoverBlueButtonText.replace("\"", ""));
        Assert.assertEquals(TestData.HOMEPAGE_WATCH_VIDEO_BUTTON_TEXT, discoverWatchVideoButtonText);
        Assert.assertEquals(TestData.HOMEPAGE_DISCOVER_CARD_1_TEXT, card1Text);
        Assert.assertTrue(homePage.isCardImageDisplayed(0));
        Assert.assertTrue(homePage.isCardRatingDisplayed(0));
        Assert.assertEquals(TestData.HOMEPAGE_DISCOVER_CARD_2_TEXT, card2Text);
        Assert.assertTrue(homePage.isCardImageDisplayed(1));
        Assert.assertTrue(homePage.isCardRatingDisplayed(1));
        Assert.assertEquals(TestData.HOMEPAGE_DISCOVER_CARD_3_TEXT, card3Text);
        Assert.assertTrue(homePage.isCardImageDisplayed(2));
        Assert.assertTrue(homePage.isCardRatingDisplayed(2));
        Assert.assertEquals(TestData.HOMEPAGE_DISCOVER_CARD_4_TEXT, card4Text);
        Assert.assertTrue(homePage.isCardImageDisplayed(3));
        Assert.assertTrue(homePage.isCardRatingDisplayed(3));

        homePage.loadPage();
        homePage.clickOnCardFromDiscoverArea(0);
        Assert.assertEquals(TestData.PRODUCTION_URL + TestData.HOMEPAGE_DISCOVER_CARD_1_PATH, homePage.getUrl());
        homePage.goBackOnePage();

        homePage.clickOnCardFromDiscoverArea(1);
        Assert.assertEquals(TestData.PRODUCTION_URL + TestData.HOMEPAGE_DISCOVER_CARD_2_PATH, homePage.getUrl());
        homePage.goBackOnePage();

        homePage.clickOnCardFromDiscoverArea(2);
        Assert.assertEquals(TestData.PRODUCTION_URL + TestData.HOMEPAGE_DISCOVER_CARD_3_PATH, homePage.getUrl());
        homePage.goBackOnePage();

        homePage.clickOnCardFromDiscoverArea(3);
        Assert.assertEquals(TestData.PRODUCTION_URL + TestData.HOMEPAGE_DISCOVER_CARD_4_PATH, homePage.getUrl());
    }

    private void testWatchVideoAndGetStartedButtons(String tabToTest, String blueButtonText) {
        final String discoverBlueButtonText = homePage.getHeroButtonText();
        final String discoverWatchVideoButtonText = homePage.getWatchVideoButtonText();

        Assert.assertEquals(blueButtonText, discoverBlueButtonText.replace("\"", ""));
        Assert.assertEquals(TestData.HOMEPAGE_WATCH_VIDEO_BUTTON_TEXT, discoverWatchVideoButtonText);

        homePage.clickOnBlueButton();
        Assert.assertEquals(TestData.SEARCH_PAGE_PATH, homePage.getPath());
        homePage.goBackOnePage();

        homePage.clickOnTab(tabToTest);

        homePage.clickOnWatchVideoButton();
        homePage.clickOnStartVideo();
        Assert.assertEquals(TestData.HOMEPAGE_VIDEO_SRC, homePage.getVideoSourceText());
        homePage.clickOnCloseVideoButton();
    }

    private void testCollectTab() {
        homePage.loadPage();
        homePage.clickOnCollectTab();
        Assert.assertEquals(TestData.HOMEPAGE_COLLECT_TAB_TEXT, homePage.getCollectTabText());
        Assert.assertEquals(TestData.HOMEPAGE_COLLECT_TEXT, homePage.getCollectText());
        String card1Text = homePage.getCollectCardText(1);
        String card2Text = homePage.getCollectCardText(2);
        String incompleteCollection = homePage.getCollectCollectionBuilderText();
        WebElement card1 = homePage.getCollectCardElement(1);
        WebElement card2 = homePage.getCollectCardElement(2);
        WebElement dropZone = homePage.getCollectCollectionDropZone();
        homePage.customDragAndDrop(card1, dropZone);
        homePage.customDragAndDrop(card2, dropZone);
        String completeCollection = homePage.getCollectCollectionBuilderText();

        Assert.assertEquals(TestData.HOMEPAGE_COLLECT_CARD_1_TEXT, card1Text);
        Assert.assertEquals(TestData.HOMEPAGE_COLLECT_CARD_2_TEXT, card2Text);
        Assert.assertEquals(TestData.HOMEPAGE_COLLECT_INCOMPLETE_COLLECTION, incompleteCollection);
        Assert.assertEquals(TestData.HOMEPAGE_COLLECT_COMPLETED_COLLECTION, completeCollection);

        //change position for the first item
        homePage.customDragAndDrop(homePage.getCollectItemFromCollection(1), dropZone);
        Assert.assertNotEquals(completeCollection, homePage.getCollectCollectionBuilderText());

        testWatchVideoAndGetStartedButtons(TestData.HOMEPAGE_COLLECT_TAB_TEXT, TestData.HOMEPAGE_GET_STARTED_BUTTON_TEXT);
        //page is refreshed, so the collection should be incomplete
        Assert.assertEquals(TestData.HOMEPAGE_COLLECT_INCOMPLETE_COLLECTION, homePage.getCollectCollectionBuilderText());
    }

    private void testDesignTab() {
        homePage.loadPage();
        homePage.clickOnDesignTab();
        Assert.assertEquals(TestData.HOMEPAGE_DESIGN_TAB_TEXT, homePage.getDesignTabText());
        Assert.assertEquals(TestData.HOMEPAGE_DESIGN_TEXT, homePage.getDesignText());
        Assert.assertTrue(homePage.isDesignImageDisplayed());
        testWatchVideoAndGetStartedButtons(TestData.HOMEPAGE_DESIGN_TAB_TEXT, TestData.HOMEPAGE_GET_STARTED_BUTTON_TEXT);
    }

    private void testDeliverTab() {
        homePage.loadPage();
        homePage.clickOnDeliverTab();
        Assert.assertEquals(TestData.HOMEPAGE_DELIVER_TAB_TEXT, homePage.getDeliverTabText());
        Assert.assertEquals(TestData.HOMEPAGE_DELIVER_TEXT, homePage.getDeliverText());
        Assert.assertTrue(homePage.areDeliverImagesDisplayed());
        testWatchVideoAndGetStartedButtons(TestData.HOMEPAGE_DELIVER_TAB_TEXT, TestData.HOMEPAGE_GET_STARTED_BUTTON_TEXT);
    }

    private void testParentEdition(String accountPlan) {
        testWhichSolutionFirstPart(accountPlan);
        Assert.assertEquals(TestData.PARENT_BOX_TEXT, homePage.getParentBoxText());
        Assert.assertTrue(homePage.isParentPictureDisplayed());
        homePage.clickOnSelectSolutionForParent();
        Assert.assertEquals(TestData.PARENT_EDITION_PAGE_PATH, homePage.getPath());
    }

    private void testEducatorSection(String accountPlan) {
        testWhichSolutionFirstPart(accountPlan);
        Assert.assertEquals(TestData.EDUCATOR_BOX_TEXT, homePage.getEducatorBoxText());
        Assert.assertTrue(homePage.isEducatorPictureDisplayed());
        homePage.clickOnSelectSolutionForEducator();
        Assert.assertEquals(TestData.EDUCATOR_EDITION_PAGE_PATH, homePage.getPath());
    }

    private void testSchoolOrDistrictSection(String accountPlan) {
        testWhichSolutionFirstPart(accountPlan);
        Assert.assertEquals(TestData.SCHOOL_OR_DISTRICT_BOX_TEXT, homePage.getSchoolOrDistrictBoxText());
        Assert.assertTrue(homePage.isSchoolOrDistrictPictureDisplayed());
        homePage.clickOnSelectSolutionForSchoolOrDistrict();
        Assert.assertEquals(TestData.LEARNING_EXPLORER_URL, homePage.getUrl());
    }

    private void testWhichSolutionFirstPart(String accountPlan) {
        if (!accountPlan.equals(TestData.PLAN_VISITOR)) {
            stepTwoPage.createNewAccount(accountPlan);
        }
        homePage.loadPage();
        homePage.scrollToParentSolutionSection();
        Assert.assertEquals(TestData.WHICH_SOLUTION_TITLE_TEXT, homePage.getWhichSolutionTitleText());
    }

    private void loginInAndReachHomepage(String accountPlan) {
        if (!accountPlan.equals(TestData.PLAN_VISITOR)) {
            stepTwoPage.createNewAccount(accountPlan);
        }
        homePage.loadPage();
    }

    private void testExploreOurSolution(String accountPlan) {
        loginInAndReachHomepage(accountPlan);
        Assert.assertTrue(homePage.isExplorerOurSolutionAreaDisplayed());
        Assert.assertEquals(TestData.EXPLORE_OUR_SOLUTION_TITLE_TEXT, homePage.getExploreOurSolutionsTitleText());
        Assert.assertEquals(TestData.EXPLORE_OUR_SOLUTION_TEXT, homePage.getExploreOurSolutionsText());
        homePage.clickOnContactUsAnytimeLink();
        Assert.assertEquals(TestData.CONTACT_US_PAGE_PATH, homePage.getPath());
        homePage.goBackOnePage();
        Assert.assertEquals(TestData.LP_HOME_PAGE_PATH, homePage.getPath());
        Assert.assertTrue(homePage.isDiscoverAreaDisplayed());
    }

    private void testEducatorEdition(String accountPlan) {
        loginInAndReachHomepage(accountPlan);
        homePage.scrollToEducatorEditionArea();
        homePage.scrollToExploreOurSolutionArea();
        Assert.assertTrue(homePage.isEducatorEditionAreaDisplayed());
        Assert.assertEquals(TestData.EDUCATOR_EDITION_TITLE_TEXT, homePage.getEducatorEditionTitleText());
        Assert.assertEquals(TestData.EDUCATOR_EDITION_TEXT, homePage.getEducatorEditionText());
        Assert.assertEquals(TestData.EDUCATOR_EDITION_GIVE_IT_A_TRY_BUTTON_TEXT, homePage.getEducatorEditionGiveItATryButtonText());
        Assert.assertEquals(TestData.LEARN_MORE_BUTTON_TEXT, homePage.getEducatorEditionLearnMoreButtonText());
        Assert.assertTrue(homePage.areEducatorEditionImagesDisplayed());
        homePage.clickOnEducatorEditionGiveItATryButton();
        Assert.assertEquals(TestData.SEARCH_PAGE_PATH, homePage.getPath());
        homePage.goBackOnePage();
        homePage.clickOnEducatorEditionLearnMoreButton();
        Assert.assertEquals(TestData.EDUCATOR_EDITION_PAGE_PATH, homePage.getPath());
    }

    private void testLearningExplorerArea(String accountPlan) {
        loginInAndReachHomepage(accountPlan);
        homePage.scrollToExploreOurSolutionArea();
        homePage.scrollToLearningExplorerArea();
        Assert.assertTrue(homePage.areLearningExplorerImagesDisplayed());
        Assert.assertEquals(TestData.LEARNING_EXPLORER_TITLE_TEXT, homePage.getLearningExplorerTitleText());
        Assert.assertEquals(TestData.LEARNING_EXPLORER_TEXT, homePage.getLearningExplorerText());
        Assert.assertEquals(TestData.LEARN_MORE_BUTTON_TEXT, homePage.getLearningExplorerLearnMoreButtonText());
        homePage.clickOnLearningExplorerLearnMoreButton();
        Assert.assertEquals(TestData.LEARNING_EXPLORER_URL, homePage.getUrl());
    }

    private void testPdLearningArea(String accountPlan) {
        loginInAndReachHomepage(accountPlan);
        homePage.scrollToLearningExplorerArea();
        homePage.scrollToPdLearningArea();
        Assert.assertEquals(TestData.PD_LEARNING_TITLE_TEXT, homePage.getPdLearningTitleText());
        Assert.assertEquals(TestData.PD_LEARNING_TEXT, homePage.getPdLearningText());
        Assert.assertTrue(homePage.arePdLearningImagesDisplayed());
        Assert.assertEquals(TestData.LEARN_MORE_BUTTON_TEXT, homePage.getPdLearningLearnMoreButtonText());
        homePage.clickOnPdLearningLearnMoreButton();
        Assert.assertEquals(TestData.PD_LEARNING_NETWORK_PATH, homePage.getPath());
    }

    private void testTestimonials(String accountPlan) {
        loginInAndReachHomepage(accountPlan);
        homePage.scrollToPdLearningArea();
        homePage.scrollToTestimonialsArea();

        WebElement firstVisibleTestimonial = homePage.getTestimonialBox(1);
        WebElement secondVisibleTestimonial = homePage.getTestimonialBox(2);
        WebElement thirdVisibleTestimonial = homePage.getTestimonialBox(3);

        testTestimonialsStrings(firstVisibleTestimonial, 1);
        testTestimonialsStrings(secondVisibleTestimonial, 2);
        testTestimonialsStrings(thirdVisibleTestimonial, 3);

        homePage.clickOnTestimonialsPreviousButton();
        waitUntilTestimonialsAnimationIsDone(firstVisibleTestimonial);
        firstVisibleTestimonial = homePage.getTestimonialBox(1);
        secondVisibleTestimonial = homePage.getTestimonialBox(2);
        thirdVisibleTestimonial = homePage.getTestimonialBox(3);

        testTestimonialsStrings(firstVisibleTestimonial, 0);
        testTestimonialsStrings(secondVisibleTestimonial, 1);
        testTestimonialsStrings(thirdVisibleTestimonial, 2);

        homePage.loadPage();
        homePage.scrollToPdLearningArea();
        homePage.scrollToTestimonialsArea();
        firstVisibleTestimonial = homePage.getTestimonialBox(1);
        homePage.clickOnTestimonialsNextButton();
        waitUntilTestimonialsAnimationIsDone(firstVisibleTestimonial);
        firstVisibleTestimonial = homePage.getTestimonialBox(1);
        secondVisibleTestimonial = homePage.getTestimonialBox(2);
        thirdVisibleTestimonial = homePage.getTestimonialBox(3);
        testTestimonialsStrings(firstVisibleTestimonial, 2);
        testTestimonialsStrings(secondVisibleTestimonial, 3);
        testTestimonialsStrings(thirdVisibleTestimonial, 4);
    }

    private void testTestimonialsStrings(WebElement testimonialBox, int expectedPosition) {
        Assert.assertTrue(homePage.isTestimonialRatingDisplayed(testimonialBox));
        Assert.assertTrue(homePage.isTestimonialImageDisplayed(testimonialBox));
        Assert.assertEquals(homePage.getTestimonialText(testimonialBox), TestData.TESTIMONIAL_TITLES[expectedPosition]);
        Assert.assertEquals(homePage.getTestimonialNameText(testimonialBox), TestData.TESTIMONIAL_NAMES[expectedPosition]);
        Assert.assertEquals(homePage.getTestimonialRoleText(testimonialBox), TestData.TESTIMONIAL_ROLES[expectedPosition]);
    }

    private void waitUntilTestimonialsAnimationIsDone(WebElement oldFirstTestimonial) {
        int noOfAttempts = TestData.SHORT_TIMEOUT;
        String oldFirstTestimonialText = homePage.getTestimonialText(oldFirstTestimonial);
        boolean testimonialWasChanged = false;
        while (noOfAttempts > 0 && !testimonialWasChanged) {
            testimonialWasChanged = !homePage.getTestimonialText(homePage.getTestimonialBox(1)).equals(oldFirstTestimonialText);
            noOfAttempts--;
        }
    }

    private void testInspireArea(String accountPlan) {
        loginInAndReachHomepage(accountPlan);

        homePage.scrollToTestimonialsArea();
        homePage.scrollToInspireArea();

        Assert.assertEquals(TestData.INSPIRE_TITLE_TEXT, homePage.getInspireTitleText());
        Assert.assertEquals(TestData.INSPIRE_SUBTEXT_TEXT, homePage.getInspireSubtextText());

        homePage.clickOnInspireParentTab();
        Assert.assertEquals(TestData.INSPIRE_AREA_PARENT_TAB_TEXT, homePage.getInspireParentTabText());
        if (accountPlan.equals(TestData.PLAN_VISITOR)) {
            Assert.assertEquals(TestData.INSPIRE_AREA_START_YOUR_10_DAYS_BUTTON_TEXT, homePage.getParentTabStartYouTenDaysButtonText());
            Assert.assertEquals(TestData.INSPIRE_AREA_SEE_PRICING_BUTTON_TEXT, homePage.getParentTabSeePricingButtonText());

            homePage.clickOnParentTabStartYouTenDaysButton();
            Assert.assertEquals(stepOneModal.getTitleText(), TestData.STEP_ONE_MODAL_TITLE);
            stepOneModal.clickOnCloseModal();
            homePage.clickOnParentTabSeePricingButton();
            Assert.assertEquals(TestData.PRICING_PAGE_PATH, homePage.getPath());

        } else {
            Assert.assertEquals(TestData.INSPIRE_UPGRADE_YOUR_ACCOUNT_BUTTON_TEXT, homePage.getParentTabUpgradeYourAccountButtonText());
            homePage.clickOnParentTabUpgradeYourAccountButton();
            stepTwoModal.waitForModal();
            Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoModal.getTitleText());
        }

        homePage.loadPage();
        homePage.scrollToTestimonialsArea();
        homePage.scrollToInspireArea();

        Assert.assertEquals(TestData.INSPIRE_AREA_EDUCATOR_TAB_TEXT, homePage.getInspireEducatorTabText());
        if (accountPlan.equals(TestData.PLAN_VISITOR)) {
            Assert.assertEquals(TestData.INSPIRE_AREA_START_YOUR_10_DAYS_BUTTON_TEXT, homePage.getEducatorTabStartYouTenDaysButtonText());
            Assert.assertEquals(TestData.INSPIRE_AREA_SEE_PRICING_BUTTON_TEXT, homePage.getEducatorTabSeePricingButtonText());
            homePage.clickOnEducatorTabStartYouTenDaysButton();
            Assert.assertEquals(stepOneModal.getTitleText(), TestData.STEP_ONE_MODAL_TITLE);
            stepOneModal.clickOnCloseModal();
            homePage.clickOnEducatorTabSeePricingButton();
            Assert.assertEquals(TestData.PRICING_PAGE_PATH, homePage.getPath());
        } else {
            Assert.assertEquals(TestData.INSPIRE_UPGRADE_YOUR_ACCOUNT_BUTTON_TEXT, homePage.getEducatorTabUpgradeYourAccountButtonText());
            homePage.clickOnEducatorTabUpgradeYourAccountButton();
            Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoModal.getTitleText());
        }

        homePage.loadPage();
        homePage.scrollToTestimonialsArea();
        homePage.scrollToInspireArea();

        homePage.clickOnInspireSchoolOrDistrictTab();
        Assert.assertEquals(TestData.INSPIRE_AREA_SCHOOL_OR_DISTRICT_TAB_TEXT, homePage.getInspireSchoolOrDistrictTabText());
        Assert.assertEquals(TestData.INSPIRE_AREA_REQUEST_A_DEMO_BUTTON_TEXT, homePage.getInspireSchoolOrDistrictRequestADemoButtonText());
        homePage.clickOnInspireSchoolOrDistrictRequestADemoButton();
        Assert.assertEquals(TestData.LEARNING_EXPLORER_DEMO_REQUESTED_URL, homePage.getUrl());
    }
}
