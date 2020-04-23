import com.lessonplanet.pages.DiscoverResourcesPage;
import com.lessonplanet.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_SearchTest extends BaseTest {

    private RSL_SearchTest rsl_searchTest;
    private LoginPage loginPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private SearchTest searchTest;

    @BeforeMethod
    private void beforeMethod() {
        rsl_searchTest = new RSL_SearchTest();
        loginPage = new LoginPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        searchTest = new SearchTest();
    }

    @Test(description = "Custom SL - Search Page - lessonp-1673:User clicks 'See Collection' footer button")
    public void testLessonp_1673() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testSeeCollection(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Search Page -  lessonp-1672:User clicks 'See Full Review' footer button")
    public void testLessonp_1672() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testGoToResource(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Search Page -  lessonp-1671:User clicks 'Go to Resource' footer button")
    public void testLessonp_1671() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testGoToResource(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Search Page - lessonp-5274:Cards details - LP resource")
    public void testLessonp_5274() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testCardDetailsLpResource(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Search Page - lessonp-5275:Cards details - Collection")
    public void testLessonp_5275() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testCardDetailsCollection(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Search Page - lessonp-5664:Cards details - Folder: HMH/McGraw")
    public void testLessonp_5664() {
        searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        discoverResourcesPage.loadPage();
        discoverResourcesPage.clickOnThumbnailView();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_PROVIDERS, TestData.FACET_PROVIDERS_MCGRAW_HILL_EDUCATION);
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_CURRICULUM_SETS);
        discoverResourcesPage.scrollToTop();

        WebElement folderResourceCard = discoverResourcesPage.getFolderResourceCardsInThumbnailView().get(0);
        testFolderResourceCardInThumbnailView(folderResourceCard);
        discoverResourcesPage.hoverOverElement(folderResourceCard);
        testFolderResourceCardInThumbnailView(folderResourceCard);

        discoverResourcesPage.clickOnTiledView();
        folderResourceCard = discoverResourcesPage.getFolderResourceCards().get(0);
        testFolderResourceCard(folderResourceCard);

        discoverResourcesPage.clickOnListView();
        folderResourceCard = discoverResourcesPage.getFolderResourceCards().get(0);
        testFolderResourceCard(folderResourceCard);
    }

    private void testFolderResourceCardInThumbnailView(WebElement folderResourceCard) {
        Assert.assertTrue(discoverResourcesPage.getOpenFolderInThumbnailViewButtonTextForCard(folderResourceCard).equals(TestData.OPEN_FOLDER_BUTTON_TEXT));
        Assert.assertTrue(discoverResourcesPage.getFolderDetailsInThumbnailViewButtonTextForCard(folderResourceCard).equals(TestData.FOLDER_DETAILS_BUTTON_TEXT));
        searchTest.testCommonItemsInThumbnailView(folderResourceCard);
        Assert.assertTrue(discoverResourcesPage.isCardProviderDisplayed(folderResourceCard));
    }

    private void testFolderResourceCard(WebElement folderResourceCard) {
        Assert.assertEquals(discoverResourcesPage.getOpenFolderButtonTextForCard(folderResourceCard), TestData.OPEN_FOLDER_BUTTON_TEXT);
        Assert.assertEquals(discoverResourcesPage.getFolderDetailsButtonTextForCard(folderResourceCard), TestData.FOLDER_DETAILS_BUTTON_TEXT);
        Assert.assertTrue(discoverResourcesPage.isCardIconDisplayed(folderResourceCard));
        Assert.assertTrue(discoverResourcesPage.isCardTitleDisplayed(folderResourceCard));
        Assert.assertTrue(discoverResourcesPage.isCardResourceTypeDisplayed(folderResourceCard));
        Assert.assertTrue(discoverResourcesPage.isCardProviderDisplayed(folderResourceCard));
    }
}
