import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class User_RrpBrowseResourceDirectoryTest extends BaseTest {
    private BrowseBySubjectPage browseBySubjectPage;
    private CollectionRrpModal collectionRrpModal;
    private CollectionRrpPage collectionRrpPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private User_RrpSearchTest user_rrpSearchTest;
    private RrpModal rrpModal;
    private StepTwoPage stepTwoPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
        collectionRrpModal = new CollectionRrpModal(webDriver);
        rrpModal = new RrpModal(webDriver);
        collectionRrpPage = new CollectionRrpPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        user_rrpSearchTest = new User_RrpSearchTest();
        stepTwoPage = new StepTwoPage(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    public void reachDirectoryPage() {
        discoverResourcesPage.loadSearchPageInListView();
        browseBySubjectPage.loadPage(TestData.SOCIAL_AND_EMOTIONAL_LEARNING_PATH);
    }

    @Test(description = "Visitor - RRP Browse Resource Directory - RRP Modal - RRP Overview: C2065: Resource Modal Overview", groups = {"visitor"})
    public void testC2065() {
        testLpResourceOverview(TestData.PLAN_VISITOR, true);
    }

    @Test(description = "Visitor - RRP Browse Resource Directory - RRP Static - RRP Overview: C2069: Resource Static Page Overview)", groups = {"visitor"})
    public void testC2069() {
        testLpResourceOverview(TestData.PLAN_VISITOR, false);
    }

    @Test(description = "Free Member - RRP Browse Resource Directory - RRP Modal - RRP Overview - C2179: LP Resource Modal Overview", groups = {"freemium"})
    public void testC2179() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testLpResourceOverview(TestData.PLAN_FREEMIUM, true);
    }

    @Test(description = "Free Member - RRP Browse Resource Directory - RRP Static - RRP Overview -C2181: Resource Static Page Overview", groups = {"freemium"})
    public void testC2181() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testLpResourceOverview(TestData.PLAN_FREEMIUM, false);
    }

    @Test(description = "Active - RRP Browse Resource Directory - RRP Modal - RRP Overview - C2295: Resource Modal Overview", groups = {"activeUser"})
    public void testC2295() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testLpResourceOverview(TestData.PLAN_PRO, true);
    }

    @Test(description = "Active - RRP Browse Resource Directory - RRP Static - RRP Overview - C2297: Resource Static Page Overview", groups = {"activeUser"})
    public void testC2297() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testLpResourceOverview(TestData.PLAN_PRO, false);
    }

    @Test(description = "Visitor - RRP Browse Resource Directory - RRP Modal - RRP Overview: C2066: Collection Modal Overview", groups = {"visitor"})
    public void testC2066() {
        testCollectionOverview(TestData.PLAN_VISITOR, true);
    }

    @Test(description = "Visitor - RRP Browse Resource Directory  - RRP Static - RRP Overview: C2070: Collection Static Page Overview", groups = {"visitor"})
    public void testC2070() {
        testCollectionOverview(TestData.PLAN_VISITOR, false);
    }

    @Test(description = "Free Member - RRP Browse Resource Directory - RRP Modal - RRP Overview - C2180: Collection Modal Overview", groups = {"freemium"})
    public void testC2180() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testCollectionOverview(TestData.PLAN_FREEMIUM, true);
    }

    @Test(description = "Free Member - RRP Browse Resource Directory - RRP Static - RRP Overview - C2182: Collection Static Page Overview", groups = {"freemium"})
    public void testC2182() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testCollectionOverview(TestData.PLAN_FREEMIUM, false);
    }

    @Test(description = "Active user - RRP Browse Resource Directory - RRP Modal - RRP Overview - C2294: Collection Modal Overview", groups = {"activeUser"})
    public void testC2294() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testCollectionOverview(TestData.PLAN_PRO, true);
    }

    @Test(description = "Active user - RRP Browse Resource Directory - RRP Static - RRP Overview - C2296: Collection Static Page Overview", groups = {"activeUser"})
    public void testC2296() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testCollectionOverview(TestData.PLAN_PRO, false);
    }

    @Test(description = " Visitor - RRP Browse Resource Directory - RRP Modal - RRP Buttons: C2068: LP Resource Main Buttons", groups = {"visitor"})
    public void testC2068() {
        testLpResourceMainButtonsForVisitor(true);
    }

    @Test(description = "Visitor - RRP Browse Resource Directory - RRP Static - RRP Buttons - C2071: LP Resource Main Buttons", groups = {"visitor"})
    public void testC2071() {
        testLpResourceMainButtonsForVisitor(false);
        user_rrpSearchTest.testStartYourFreeTrialTryItFreeButton();
        user_rrpSearchTest.testSeeSimilarResourcesDropdown();
        user_rrpSearchTest.testSeeSimilarResourcesTryItFreeButton();
    }

    @Test(description = "Freemium - RRP Browse Resource Directory - Rrp Modal - Rrp Buttons - Lp resources - C3759: Main Buttons", groups = {"freemium"})
    public void testC3759() {
        testLpResourceMainButtons(true);
    }

    @Test(description = "Freemium - RRP Browse Resource Directory - Rrp Static - Rrp Buttons - Lp resources -C3762: Main Buttons", groups = {"freemium"})
    public void testC3762() {
        testLpResourceMainButtons(false);
    }

    @Test(description = "Active user - RRP Browse Resource Directory - Rrp Modal - Rrp Buttons - Lp resources - C3763: Main Buttons", groups = {"activeUser"})
    public void testC3763() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testLpResourceMainButtonsForActiveUser(TestData.PLAN_PRO, true);
    }

    @Test(description = "Active user - RRP Browse Resource Directory - Rrp Static - Rrp Buttons - Lp Resources - C3764: Main Buttons", groups = {"activeUser"})
    public void testC3764() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testLpResourceMainButtonsForActiveUser(TestData.PLAN_PRO, false);
    }

    @Test(description = "Visitor - RRP Browse Resource Directory - RRP Modal - RRP Buttons - C2067: Collection Main Buttons", groups = {"visitor"})
    public void testC2067() {
        reachDirectoryPage();
        String firstCollectionCardTitle = browseBySubjectPage.getCollectionCardTitle(0);
        browseBySubjectPage.clickOnSeeCollection(false);
        Assert.assertEquals(collectionRrpModal.getCollectionTitleText(), firstCollectionCardTitle);
        user_rrpSearchTest.initTest(webDriver);
        user_rrpSearchTest.testSaveCollectionButton(true, TestData.PLAN_VISITOR);
        user_rrpSearchTest.testCollectionGetFreeAccessForTenDaysButton(true);
        collectionRrpModal.clickOnPanelItem(0);
        user_rrpSearchTest.testItemViewerSection();
        collectionRrpModal.clickOnSeeFullReviewsLink();
        user_rrpSearchTest.testItemViewerSection();
    }

    @Test(description = "Visitor - RRP Browse Resource Directory - RRP Static - RRP Buttons - C2072: Collection Main Buttons", groups = {"visitor"})
    public void testC2072() {
        reachDirectoryPage();
        browseBySubjectPage.clickOnSeeCollection(true);
        user_rrpSearchTest.initTest(webDriver);
        user_rrpSearchTest.testSaveCollectionButton(false, TestData.PLAN_VISITOR);
        user_rrpSearchTest.testCollectionGetFreeAccessForTenDaysButton(false);
        collectionRrpPage.clickOnPanelItem(0);
        user_rrpSearchTest.testItemViewerSection();
        collectionRrpPage.clickOnSeeFullReviewsLink();
        user_rrpSearchTest.testItemViewerSection();
    }

    @Test(description = "Freemium - RRP Browse Resource Directory - Rrp Modal - Rrp Buttons - Collections - C3760: Main Buttons", groups = {"freemium"})
    public void testC3760() {
        testCollectionButtonsForFreemium(true);
    }

    @Test(description = "Freemium - RRP Browse Resource Directory - Rrp Static - Rrp Buttons - Collections - C3761: Main Buttons", groups = {"freemium"})
    public void testC3761() {
        testCollectionButtonsForFreemium(false);
    }

    @Test(description = "Active user - RRP Browse Resource Directory - Rrp Modal - Rrp Buttons - Collections - C3765: Main Buttons", groups = {"activeUser"})
    public void testC3765() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        reachDirectoryPage();
        browseBySubjectPage.clickOnSeeCollection(true);
        user_rrpSearchTest.initTest(webDriver);
        user_rrpSearchTest.testCollectionMainButtons(true, TestData.PLAN_PRO);
    }

    @Test(description = "Active user - RRP Browse Resource Directory - Rrp Static - Rrp Buttons - Collections - C3766: Collection Main Buttons", groups = {"activeUser"})
    public void testC3766() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        reachDirectoryPage();
        browseBySubjectPage.clickOnSeeCollection(true);
        user_rrpSearchTest.initTest(webDriver);
        user_rrpSearchTest.testCollectionRRPOverview(false, TestData.PLAN_PRO);
        user_rrpSearchTest.testPanelItemsOverview();
    }

    protected void testLpResourceOverview(String accountPlan, boolean inModal) {
        reachDirectoryPage();
        browseBySubjectPage.clickOnSeeReview(!inModal);
        user_rrpSearchTest.initTest(webDriver);
        user_rrpSearchTest.testRegularResourceRRPOverview(inModal, accountPlan);
        if (!inModal) {
            if (accountPlan.equals(TestData.PLAN_VISITOR) || accountPlan.equals(TestData.PLAN_FREEMIUM)) {
                user_rrpSearchTest.testStartYourFreeTrialWidgetOverview(TestData.START_YOUR_FREE_TRIAL_TEXT_LP_RESOURCE, accountPlan);
            }
            user_rrpSearchTest.testSimilarResourcesSectionOverview(accountPlan);
        }
    }

    private void testLpResourceMainButtons(boolean inModal) {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        reachDirectoryPage();
        browseBySubjectPage.clickOnSeeReview(!inModal);
        user_rrpSearchTest.initTest(webDriver);
        user_rrpSearchTest.testLpResourceMainButtons(inModal, false);
    }

    protected void testLpResourceMainButtonsForActiveUser(String accountPlan, boolean inModal) {
        reachDirectoryPage();
        browseBySubjectPage.clickOnSeeReview(!inModal);
        user_rrpSearchTest.initTest(webDriver);
        user_rrpSearchTest.testRegularResourceRRPOverview(inModal, accountPlan);
    }

    private void testLpResourceMainButtonsForVisitor(boolean inModal) {
        reachDirectoryPage();
        browseBySubjectPage.clickOnSeeReview(!inModal);
        if (inModal) {
            Assert.assertTrue(rrpModal.getModalId().contains(browseBySubjectPage.getRegularResourceCardDataId(0)));
        }
        user_rrpSearchTest.initTest(webDriver);
        user_rrpSearchTest.testFavoriteButton(inModal);
        user_rrpSearchTest.testResourceGetFreeAccessForTenDaysButton(inModal);
        user_rrpSearchTest.testThumbnailForRegularResource(inModal, TestData.PLAN_VISITOR);
    }

    private void testCollectionButtonsForFreemium(boolean inModal) {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        reachDirectoryPage();
        browseBySubjectPage.clickOnSeeCollection(!inModal);
        user_rrpSearchTest.initTest(webDriver);
        user_rrpSearchTest.testCollectionMainButtonsForFreemium(inModal);
    }

    protected void testCollectionOverview(String accountPlan, boolean inModal) {
        reachDirectoryPage();
        browseBySubjectPage.clickOnSeeCollection(!inModal);
        user_rrpSearchTest.initTest(webDriver);
        user_rrpSearchTest.testCollectionRRPOverview(inModal, accountPlan);
        user_rrpSearchTest.testPanelItemsOverview();
    }
}
