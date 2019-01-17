import com.lessonplanet.pages.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.util.List;

public class AccountManagementTest extends BaseTest {
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private StepOneModal stepOneModal;
    private DiscoverResourcesPage discoverResourcesPage;
    private CollectionBuilderPage collectionBuilderPage;
    private BecomeALessonPlanetFreeMemberModal becomeALessonPlanetFreeMemberModal;
    private FreeMemberLimitedAccessModal freeMemberLimitedAccessModal;
    private ThanksForJoiningModal thanksForJoiningModal;
    private StepTwoModal stepTwoModal;
    private StepTwoTest stepTwoTest;
    private MyAccountPage myAccountPage;
    private CustomMembershipPage customMembershipPage;
    private StepOnePage stepOnePage;
    private ManageMembershipPage manageMembershipPage;
    private StepTwoPage stepTwoPage;
    private CancelModal cancelModal;

    private static final int expectedDaysToExpire = 11;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        headerPage = new HeaderPage(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        becomeALessonPlanetFreeMemberModal = new BecomeALessonPlanetFreeMemberModal(webDriver);
        freeMemberLimitedAccessModal = new FreeMemberLimitedAccessModal(webDriver);
        thanksForJoiningModal = new ThanksForJoiningModal(webDriver);
        stepTwoModal = new StepTwoModal(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        customMembershipPage = new CustomMembershipPage(webDriver);
        stepOnePage = new StepOnePage(webDriver);
        manageMembershipPage = new ManageMembershipPage(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        cancelModal = new CancelModal(webDriver);
    }

    @Test(description = "Account management - Create a Free Member account - lessonp-717:Try It Free button")
    public void testLessonp_717() {
        lpHomePage.loadPage();
        Assert.assertEquals(headerPage.getTryItFreeButtonBackgroundColor(), TestData.TRY_IT_FREE_BUTTON_BACKGROUND_COLOR);
        headerPage.clickOnTryItFree(false);
        Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
    }

    @Test(description = "Account management - Create a Free Member account - lessonp-692:Through the 'Become a Lesson Planet Free Member (Limited Access)' modal")
    public void testLessonp_692() {
        discoverResourcesPage.loadPage();
        discoverResourcesPage.changeToListView();
        List<WebElement> getFreeAccessResources = discoverResourcesPage.getAllFreeAccessButtons();
        discoverResourcesPage.dragAndDrop(getFreeAccessResources.get(0), collectionBuilderPage.getCollectionDroppableZone());
        becomeALessonPlanetFreeMemberModal.clickOnFreeMemberLink();
        freeMemberLimitedAccessModal.typeEmailAddress(TestData.GET_NEW_EMAIL());
        freeMemberLimitedAccessModal.typePassword(TestData.VALID_PASSWORD);
        freeMemberLimitedAccessModal.clickOnGetStartedButton();
        Assert.assertEquals(thanksForJoiningModal.getModalText(), TestData.THANKS_FOR_JOINING_MODAL_TEXT);
    }

    @Test(description = "Account management - Create a Free Member account - lessonp-693:Quitting Step 2 registration process")
    public void testLessonp_693() {
        stepTwoTest = new StepTwoTest();
        stepTwoTest.initAndReachStepTwoModal(webDriver);
        stepTwoModal.clickOnCloseModal();
        Assert.assertEquals(headerPage.getUpgradeMeButtonBackgroundColor(), TestData.TRY_IT_FREE_BUTTON_BACKGROUND_COLOR);
        myAccountPage.loadPage();
        Assert.assertEquals(myAccountPage.getPlan(), TestData.FREE_MEMBERSHIP_TEXT);
    }

    @Test(description = "Account management - Create a Free Member account - lessonp-694:After membership is canceled")
    public void testLessonp_694() {
        stepTwoTest = new StepTwoTest();
        stepTwoTest.initAndReachStepTwoModal(webDriver);
        stepTwoModal.completeStepTwoModalWith(TestData.STARTER_OPTION_TEXT);

        myAccountPage.loadPage();
        Assert.assertEquals(myAccountPage.getPlan(), TestData.STARTER_OPTION_TEXT);

        customMembershipPage.loadPage();
        customMembershipPage.clickOnSpecialOffersAndCancellationsLink();
        customMembershipPage.clickOnReasonsDropdown();
        customMembershipPage.selectOptionFromDropDown(TestData.THE_MEMBERSHIP_FEE_WAS_TOO_EXPENSIVE_FOR_ME_TEXT);
        customMembershipPage.clickOnContinueInput();
        cancelModal.clickOnNoThanksConfirmCancellationButton();
        Assert.assertTrue(myAccountPage.isRenewNowButtonDisplayed());
        Assert.assertTrue(myAccountPage.isStatusDateDisplayed());
        Assert.assertEquals(myAccountPage.getPlan(), TestData.STARTER_OPTION_TEXT);

        Assert.assertTrue(TestData.COMPARE_EQUAL_DATES(myAccountPage.getStatusDate(), TestData.ADD_DAYS_TO_DATE(TestData.GET_CURRENT_DATE(), expectedDaysToExpire)));
    }


    @Test(description = "Account management - Create a Free Member account - lessonp-681:Downgrade from paid to free membership")
    public void testLessonp_681() {

    }


    @Test(description = "Account management - Create a Free Member account - lessonp-682:Downgrade from Freemium")
    public void testLessonp_682() {
        lpHomePage.loadPage();
        stepOnePage.completeStepOne(TestData.GET_NEW_EMAIL(), TestData.VALID_PASSWORD);
        myAccountPage.loadPage();
        Assert.assertEquals(myAccountPage.getPlan(), TestData.FREE_MEMBERSHIP_TEXT);
        Assert.assertFalse(myAccountPage.isManageMembershipLinkDisplayed());
        manageMembershipPage.loadPage();
        Assert.assertFalse(manageMembershipPage.getPath().equals(TestData.MANAGE_MEMBERSHIP_PAGE_PATH));
        Assert.assertTrue(stepTwoPage.getPath().equals(TestData.STEP_ONE_PAGE_PATH));
        Assert.assertTrue(stepTwoPage.getTitleText().equals(TestData.STEP_TWO_TITLE_MESSAGE));
    }

    @Test(description = "Account management - Create a Free Member account - lessonp-948:Downgrade from Pro membership")
    public void testLessonp_948() {
        stepTwoTest = new StepTwoTest();
        stepTwoTest.initAndReachStepTwoModal(webDriver);
        stepTwoModal.completeStepTwoModalWith(TestData.PRO_OPTION_TEXT);

        myAccountPage.loadPage();
        Assert.assertEquals(myAccountPage.getPlan(), TestData.PRO_OPTION_TEXT);
        myAccountPage.clickOnManageMembershipLink();
        Assert.assertTrue(manageMembershipPage.getPath().equals(TestData.MANAGE_MEMBERSHIP_PAGE_PATH));
        manageMembershipPage.clickOnMoreAccountOptionsButton();

        customMembershipPage.clickOnSpecialOffersAndCancellationsLink();
        customMembershipPage.clickOnReasonsDropdown();
        customMembershipPage.selectOptionFromDropDown(TestData.THE_MEMBERSHIP_FEE_WAS_TOO_EXPENSIVE_FOR_ME_TEXT);
        customMembershipPage.clickOnContinueInput();

        cancelModal.clickOnYesSignUpInput();
        myAccountPage.loadPage();
        Assert.assertEquals(myAccountPage.getPlan(), TestData.PRIME_OPTION_TEXT);

        manageMembershipPage.loadPage();
        manageMembershipPage.upgradeSubscriptionAndReturn(TestData.PRO_OPTION_TEXT);

        customMembershipPage.loadPage();

        customMembershipPage.clickOnSpecialOffersAndCancellationsLink();
        customMembershipPage.clickOnReasonsDropdown();
        customMembershipPage.selectOptionFromDropDown(TestData.THE_MEMBERSHIP_FEE_WAS_TOO_EXPENSIVE_FOR_ME_TEXT);
        customMembershipPage.clickOnContinueInput();

        cancelModal.clickOnNoThanksConfirmCancellationButton();
        myAccountPage.loadPage();

        Assert.assertTrue(myAccountPage.isRenewNowButtonDisplayed());
        Assert.assertTrue(myAccountPage.isStatusDateDisplayed());
        Assert.assertEquals(myAccountPage.getPlan(), TestData.PRO_OPTION_TEXT);
        Assert.assertTrue(TestData.COMPARE_EQUAL_DATES(myAccountPage.getStatusDate(), TestData.ADD_DAYS_TO_DATE(TestData.GET_CURRENT_DATE(), expectedDaysToExpire)));
    }


}
