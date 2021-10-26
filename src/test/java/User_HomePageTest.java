import com.lessonplanet.pages.HomePage;
import com.lessonplanet.pages.StepTwoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class User_HomePageTest extends BaseTest {

    private HomePage homePage;
    private StepTwoPage stepTwoPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePage(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Visitor - Homepage - lessonp-5295:Discover")
    public void testLessonp_5295() {
        testDiscoverTab();
    }

    @Test(description = "Free Member - Homepage - lessonp-5306:Discover")
    public void testLessonp_5306() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testDiscoverTab();
    }

    @Test(description = "Active User - Homepage - lessonp-5322:Discover")
    public void testLessonp_5322() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testDiscoverTab();
    }

    @Test(description = "Visitor - Homepage - lessonp-5296:Collect")
    public void testLessonp_5296() {
        testCollectTab();
    }

    @Test(description = "Freemium - Homepage - lessonp-5307:Collect")
    public void testLessonp_5307() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testCollectTab();
    }

    @Test(description = "Active user - Homepage - lessonp-5323:Collect")
    public void testLessonp_5323() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testCollectTab();
    }

    @Test(description = "Visitor - Homepage - lessonp-5297:Design")
    public void testLessonp_5297() {
        testDesignTab();
    }

    @Test(description = "Freemium - Homepage - lessonp-5308:Design")
    public void testLessonp_5308() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testDesignTab();
    }

    @Test(description = "Active user - Homepage - lessonp-5324:Design")
    public void testLessonp_5324() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testDesignTab();
    }

    @Test(description = "Visitor - Homepage - lessonp-5298:Deliver")
    public void testLessonp_5298() {
        testDeliverTab();
    }

    @Test(description = "Freemium - Homepage - lessonp-5309:Deliver")
    public void testLessonp_5309() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testDeliverTab();
    }

    @Test(description = "Active user - Homepage - lessonp-5325:Deliver")
    public void testLessonp_5325() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testDeliverTab();
    }

    @Test(description = "Visitor - Homepage - lessonp-5286:Parent")
    public void testLessonp_5286() {
        testParentEdition(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - lessonp-5311:Parent")
    public void testLessonp_5311() {
        testParentEdition(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - lessonp-5327:Parent")
    public void testLessonp_5327() {
        testParentEdition(TestData.PLAN_STARTER);
    }

    @Test(description = "Visitor - Homepage - lessonp-5300:Educator")
    public void testLessonp_5300() {
        testEducatorSection(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - lessonp-5312:Educator")
    public void testLessonp_5312() {
        testEducatorSection(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - lessonp-5328:Educator")
    public void testLessonp_5328() {
        testEducatorSection(TestData.PLAN_STARTER);
    }

    @Test(description = "Visitor - Homepage - lessonp-5301:School or District")
    public void testLessonp_5301() {
        testSchoolOrDistrictSection(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - lessonp-5313:School or District")
    public void testLessonp_5313() {
        testSchoolOrDistrictSection(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - lessonp-5329:School or District")
    public void testLessonp_5329() {
        testSchoolOrDistrictSection(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Homepage - lessonp-5302:Explore our solutions")
    public void testLessonp_5302() {
        testExploreOurSolution(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - lessonp-5314:Explore our solutions")
    public void testLessonp_5314() {
        testExploreOurSolution(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - lessonp-5330:Explore our solutions")
    public void testLessonp_5330() {
        testExploreOurSolution(TestData.PLAN_PRO);
    }

    @Test(description = "Visitor - Homepage - lessonp-5288:Educator Edition section")
    public void testLessonp_5288() {
        testEducatorEdition(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - lessonp-5315:Educator Edition section")
    public void testLessonp_5315() {
        testEducatorEdition(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - lessonp-5331:Educator Edition section")
    public void testLessonp_5331() {
        testEducatorEdition(TestData.PLAN_STARTER);
    }

    @Test(description = "Visitor - Homepage - lessonp-5289:Learning Explorer section")
    public void testLessonp_5289() {
        testLearningExplorerArea(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - lessonp-5316:Learning Explorer section")
    public void testLessonp_5316() {
        testLearningExplorerArea(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - lessonp-5332:Learning Explorer section")
    public void testLessonp_5332() {
        testLearningExplorerArea(TestData.PLAN_STARTER);
    }

    @Test(description = "Visitor - Homepage - lessonp-5290:PD Learning Network section")
    public void testLessonp_5290() {
        testPdLearningArea(TestData.PLAN_VISITOR);
    }

    @Test(description = "Freemium - Homepage - lessonp-5317:PD Learning Network section")
    public void testLessonp_5317() {
        testPdLearningArea(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Homepage - lessonp-5333:PD Learning Network section")
    public void testLessonp_5333() {
        testPdLearningArea(TestData.PLAN_PRO);
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
        final String card1Text = homePage.getCardTextFromDiscoverArea(1);
        final String card2Text = homePage.getCardTextFromDiscoverArea(2);
        final String card3Text = homePage.getCardTextFromDiscoverArea(3);
        final String card4Text = homePage.getCardTextFromDiscoverArea(4);

        Assert.assertEquals(TestData.HOMEPAGE_DISCOVER_TAB_TEXT, discoverTabText);
        Assert.assertEquals(TestData.HOMEPAGE_DISCOVER_TITLE, discoverTitle);
        Assert.assertEquals(TestData.HOMEPAGE_DISCOVER_TEXT, discoverDescription);
        Assert.assertEquals(TestData.HOMEPAGE_START_SEARCHING_BUTTON_TEXT, discoverBlueButtonText.replace("\"", ""));
        Assert.assertEquals(TestData.HOMEPAGE_WATCH_VIDEO_BUTTON_TEXT, discoverWatchVideoButtonText);
        Assert.assertEquals(TestData.HOMEPAGE_DISCOVER_CARD_1_TEXT, card1Text);
        Assert.assertTrue(homePage.isCardImageDisplayed(1));
        Assert.assertTrue(homePage.isCardRatingDisplayed(1));
        Assert.assertEquals(TestData.HOMEPAGE_DISCOVER_CARD_2_TEXT, card2Text);
        Assert.assertTrue(homePage.isCardImageDisplayed(2));
        Assert.assertTrue(homePage.isCardRatingDisplayed(2));
        Assert.assertEquals(TestData.HOMEPAGE_DISCOVER_CARD_3_TEXT, card3Text);
        Assert.assertTrue(homePage.isCardImageDisplayed(3));
        Assert.assertTrue(homePage.isCardRatingDisplayed(3));
        Assert.assertEquals(TestData.HOMEPAGE_DISCOVER_CARD_4_TEXT, card4Text);
        Assert.assertTrue(homePage.isCardImageDisplayed(4));
        Assert.assertTrue(homePage.isCardRatingDisplayed(4));

        homePage.clickOnCardFromDiscoverArea(1);
        Assert.assertEquals(TestData.PRODUCTION_URL + TestData.HOMEPAGE_DISCOVER_CARD_1_PATH, homePage.getUrl());
        homePage.goBackOnePage();

        homePage.clickOnCardFromDiscoverArea(2);
        Assert.assertEquals(TestData.PRODUCTION_URL + TestData.HOMEPAGE_DISCOVER_CARD_2_PATH, homePage.getUrl());
        homePage.goBackOnePage();

        homePage.clickOnCardFromDiscoverArea(3);
        Assert.assertEquals(TestData.PRODUCTION_URL + TestData.HOMEPAGE_DISCOVER_CARD_3_PATH, homePage.getUrl());
        homePage.goBackOnePage();

        homePage.clickOnCardFromDiscoverArea(4);
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
}
