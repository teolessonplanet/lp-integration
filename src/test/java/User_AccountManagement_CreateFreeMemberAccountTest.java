import com.lessonplanet.pages.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User_AccountManagement_CreateFreeMemberAccountTest extends BaseTest {
    private static final int expectedDaysToExpire = 11;
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private StepOneModal stepOneModal;
    private DiscoverResourcesPage discoverResourcesPage;
    private CollectionBuilderPage collectionBuilderPage;
    private BecomeALessonPlanetFreeMemberModal becomeALessonPlanetFreeMemberModal;
    private FreeMemberLimitedAccessModal freeMemberLimitedAccessModal;
    private ThanksForJoiningModal thanksForJoiningModal;
    private User_AccountManagement_StepTwoTest user_AccountManagement_stepTwoTest;
    private MyAccountPage myAccountPage;
    private CustomMembershipPage customMembershipPage;
    private StepTwoPage stepTwoPage;
    private CancelModal cancelModal;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        headerPage = new HeaderPage(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        becomeALessonPlanetFreeMemberModal = new BecomeALessonPlanetFreeMemberModal(webDriver);
        freeMemberLimitedAccessModal = new FreeMemberLimitedAccessModal(webDriver);
        thanksForJoiningModal = new ThanksForJoiningModal(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        customMembershipPage = new CustomMembershipPage(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        cancelModal = new CancelModal(webDriver);
    }

    @Test(description = "Account management - Create a Free Member account - C2443: Try It Free button", groups = {"accountManagement"})
    public void testC2443() {
        lpHomePage.loadPage();
        Assert.assertEquals(headerPage.getTryItFreeButtonBackgroundColor(), TestData.TRY_IT_FREE_BUTTON_BACKGROUND_COLOR);
        headerPage.clickOnTryItFree(false);
        Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
    }

    @Test(description = "Account management - Create a Free Member account - C2444: Through the 'Become a Lesson Planet Free Member' modal", groups = {"accountManagement"})
    public void testC2444() {
        discoverResourcesPage.loadPage();
        discoverResourcesPage.changeToListView();
        discoverResourcesPage.selectFacetViaShortcut(new ArrayList<>(Arrays.asList(TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS)));
        List<WebElement> getFreeAccessResources = discoverResourcesPage.getAllFreeAccessButtons();
        discoverResourcesPage.dragAndDrop(getFreeAccessResources.get(0), collectionBuilderPage.getCollectionDroppableZone());
        becomeALessonPlanetFreeMemberModal.waitForModal();
        becomeALessonPlanetFreeMemberModal.clickOnFreeMemberLink();
        freeMemberLimitedAccessModal.typeEmailAddress(TestData.GET_NEW_EMAIL());
        freeMemberLimitedAccessModal.typePassword(TestData.VALID_PASSWORD);
        freeMemberLimitedAccessModal.clickOnGetStartedButton();
        Assert.assertEquals(thanksForJoiningModal.getModalText(), TestData.THANKS_FOR_JOINING_MODAL_TEXT);
    }

    @Test(description = "Account management - Create a Free Member account - C2445: Quitting Step 2 registration process", groups = {"accountManagement"})
    public void testC2445() {
        user_AccountManagement_stepTwoTest = new User_AccountManagement_StepTwoTest();
        user_AccountManagement_stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.goBackOnePage();
        Assert.assertEquals(headerPage.getUpgradeMeButtonBackgroundColor(), TestData.TRY_IT_FREE_BUTTON_BACKGROUND_COLOR);
        myAccountPage.loadPage();
        Assert.assertEquals(myAccountPage.getPlan(), TestData.FREE_MEMBERSHIP_TEXT);
    }

    @Test(description = "Account management - Create a Free Member account - C2446: After membership is canceled", groups = {"accountManagement"})
    public void testC2446() {
        user_AccountManagement_stepTwoTest = new User_AccountManagement_StepTwoTest();
        user_AccountManagement_stepTwoTest.initAndReachStepTwoPage(webDriver);
        stepTwoPage.completeStepTwoPageWith(TestData.PLAN_STARTER);

        myAccountPage.loadPage();
        Assert.assertTrue(TestData.PLAN_STARTER.startsWith(myAccountPage.getPlan().toLowerCase()));

        customMembershipPage.loadPage();
        customMembershipPage.clickOnSpecialOffersAndCancellationsLink();
        customMembershipPage.clickOnReasonsDropdown();
        customMembershipPage.selectOptionFromDropDown(TestData.THE_MEMBERSHIP_FEE_WAS_TOO_EXPENSIVE_FOR_ME_TEXT);
        customMembershipPage.clickOnContinueInput();
        cancelModal.clickOnNoThanksConfirmCancellationButton();
        Assert.assertTrue(myAccountPage.isRenewNowButtonDisplayed());
        Assert.assertTrue(myAccountPage.isStatusDateDisplayed());
        Assert.assertTrue(TestData.PLAN_STARTER.startsWith(myAccountPage.getPlan().toLowerCase()));

        Assert.assertTrue(TestData.COMPARE_EQUAL_DATES(myAccountPage.getStatusDate(), TestData.ADD_DAYS_TO_DATE(TestData.GET_CURRENT_DATE(), expectedDaysToExpire)));
    }
}
