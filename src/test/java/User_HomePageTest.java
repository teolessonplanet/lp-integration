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

public class User_HomePageTest extends BaseTest {

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

    @Test(description = "Visitor - Homepage - lessonp-5295:Discover", groups = {"visitor"})
    public void testLessonp_5295() {
        testDiscoverTab();
    }

    @Test(description = "Free Member - Homepage - lessonp-5306:Discover", groups = {"freemium"})
    public void testLessonp_5306() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testDiscoverTab();
    }

    @Test(description = "Active User - Homepage - lessonp-5322:Discover", groups = {"activeUser"})
    public void testLessonp_5322() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testDiscoverTab();
    }

    @Test(description = "Visitor - Homepage - lessonp-5296:Collect", groups = {"visitor"})
    public void testLessonp_5296() {
        testCollectTab();
    }

    @Test(description = "Freemium - Homepage - lessonp-5307:Collect", groups = {"freemium"})
    public void testLessonp_5307() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testCollectTab();
    }

    @Test(description = "Active user - Homepage - lessonp-5323:Collect", groups = {"activeUser"})
    public void testLessonp_5323() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testCollectTab();
    }

    @Test(description = "Visitor - Homepage - lessonp-5297:Design", groups = {"visitor"})
    public void testLessonp_5297() {
        testDesignTab();
    }

    @Test(description = "Freemium - Homepage - lessonp-5308:Design", groups = {"freemium"})
    public void testLessonp_5308() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testDesignTab();
    }

    @Test(description = "Active user - Homepage - lessonp-5324:Design", groups = {"activeUser"})
    public void testLessonp_5324() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testDesignTab();
    }

    @Test(description = "Visitor - Homepage - lessonp-5298:Deliver", groups = {"visitor"})
    public void testLessonp_5298() {
        testDeliverTab();
    }

    @Test(description = "Freemium - Homepage - lessonp-5309:Deliver", groups = {"freemium"})
    public void testLessonp_5309() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testDeliverTab();
    }

    @Test(description = "Active user - Homepage - lessonp-5325:Deliver", groups = {"activeUser"})
    public void testLessonp_5325() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testDeliverTab();
    }

    @Test(description = "Visitor - Homepage - lessonp-5286:Parent", groups = {"visitor"})
    public void testLessonp_5286() {
        testParentEdition(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - lessonp-5311:Parent", groups = {"freemium"})
    public void testLessonp_5311() {
        testParentEdition(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - lessonp-5327:Parent", groups = {"activeUser"})
    public void testLessonp_5327() {
        testParentEdition(TestData.PLAN_STARTER);
    }

    @Test(description = "Visitor - Homepage - lessonp-5300:Educator", groups = {"visitor"})
    public void testLessonp_5300() {
        testEducatorSection(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - lessonp-5312:Educator", groups = {"freemium"})
    public void testLessonp_5312() {
        testEducatorSection(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - lessonp-5328:Educator", groups = {"activeUser"})
    public void testLessonp_5328() {
        testEducatorSection(TestData.PLAN_STARTER);
    }

    @Test(description = "Visitor - Homepage - lessonp-5301:School or District", groups = {"visitor"})
    public void testLessonp_5301() {
        testSchoolOrDistrictSection(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - lessonp-5313:School or District", groups = {"freemium"})
    public void testLessonp_5313() {
        testSchoolOrDistrictSection(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - lessonp-5329:School or District", groups = {"activeUser"})
    public void testLessonp_5329() {
        testSchoolOrDistrictSection(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Homepage - lessonp-5302:Explore our solutions", groups = {"visitor"})
    public void testLessonp_5302() {
        testExploreOurSolution(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - lessonp-5314:Explore our solutions", groups = {"freemium"})
    public void testLessonp_5314() {
        testExploreOurSolution(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - lessonp-5330:Explore our solutions", groups = {"activeUser"})
    public void testLessonp_5330() {
        testExploreOurSolution(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Homepage - lessonp-5288:Educator Edition section", groups = {"visitor"})
    public void testLessonp_5288() {
        testEducatorEdition(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - lessonp-5315:Educator Edition section", groups = {"freemium"})
    public void testLessonp_5315() {
        testEducatorEdition(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - lessonp-5331:Educator Edition section", groups = {"activeUser"})
    public void testLessonp_5331() {
        testEducatorEdition(TestData.PLAN_STARTER);
    }

    @Test(description = "Visitor - Homepage - lessonp-5289:Learning Explorer section", groups = {"visitor"})
    public void testLessonp_5289() {
        testLearningExplorerArea(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - lessonp-5316:Learning Explorer section", groups = {"freemium"})
    public void testLessonp_5316() {
        testLearningExplorerArea(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - lessonp-5332:Learning Explorer section", groups = {"activeUser"})
    public void testLessonp_5332() {
        testLearningExplorerArea(TestData.PLAN_STARTER);
    }

    @Test(description = "Visitor - Homepage - lessonp-5290:PD Learning Network section", groups = {"visitor"})
    public void testLessonp_5290() {
        testPdLearningArea(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - lessonp-5317:PD Learning Network section", groups = {"freemium"})
    public void testLessonp_5317() {
        testPdLearningArea(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - lessonp-5333:PD Learning Network section", groups = {"activeUser"})
    public void testLessonp_5333() {
        testPdLearningArea(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Homepage - lessonp-5291:What educators and parents are saying: section", groups = {"visitor"})
    public void testLessonp_5291() {
        testTestimonials(TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - Homepage - lessonp-5318:What educators and parents are saying: section", groups = {"visitor"})
    public void testLessonp_5318() {
        testTestimonials(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Visitor - Homepage - lessonp-5334:What educators and parents are saying: section", groups = {"visitor"})
    public void testLessonp_5334() {
        testTestimonials(TestData.PLAN_STARTER);
    }

    @Test(description = "Visitor - Homepage - lessonp-5292:Discover.Create.Inspire section", groups = {"visitor"})
    public void testLessonp_5292() {
        testInspireArea(TestData.PLAN_VISITOR);
    }

    @Test(description = "Visitor - Homepage - lessonp-5319:Discover.Create.Inspire section", groups = {"visitor"})
    public void testLessonp_5319() {
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
        homePage.clickOnContactUsAnytime();
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
        Assert.assertEquals(TestData.EDUCATOR_EDITION_GIVE_IT_A_TRY_BUTTON_TEXT, homePage.getEducatorEditionGiveATryButtonText());
        Assert.assertEquals(TestData.LEARN_MORE_BUTTON_TEXT, homePage.getEducatorEditionLearnMoreButtonText());
        Assert.assertTrue(homePage.areEducatorEditionImagesDisplayed());
        homePage.clickOnEducatorEditionGiveATryButton();
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
            stepOneModal.clickCloseModal();
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
            stepOneModal.clickCloseModal();
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
