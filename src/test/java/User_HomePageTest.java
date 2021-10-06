import com.lessonplanet.pages.HomePage;
import com.lessonplanet.pages.StepTwoPage;
import org.openqa.selenium.WebDriver;
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
}
