import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class StepOneTest extends BaseTest {

    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private StepOneModal stepOneModal;
    private StepTwoModal stepTwoModal;
    private StepOnePage stepOnePage;
    private SignInModal signInModal;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        headerPage = new HeaderPage(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        stepTwoModal = new StepTwoModal(webDriver);
        stepOnePage = new StepOnePage(webDriver);
        signInModal = new SignInModal(webDriver);
    }

    @Test(description = "LP - User Visits Step 1 - lessonp-6:User supplies invalid form data")
    public void testLessonp_6() {
        lpHomePage.loadPage();
        headerPage.clickOnTryItFree(false);
        stepOneModal.typeEmail(TestData.NEW_EMAIL_PREFIX);
        stepOneModal.clickOnGetStartedToday();
        Assert.assertEquals(TestData.INVALID_EMAIL_MESSAGE, stepOneModal.getErrorMessage());
    }

    @Test(description = "LP - User Visits Step 1 - lessonp-5:User supplies valid form data")
    public void testLessonp_5() {
        lpHomePage.loadPage();
        headerPage.clickOnTryItFree(false);
        final String email = TestData.GET_NEW_EMAIL();
        stepOneModal.typeEmail(email);
        stepOneModal.typePassword(TestData.VALID_PASSWORD);
        stepOneModal.clickOnGetStartedToday();
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoModal.getTitleText());
        stepTwoModal.clickOnCloseModal();
        Assert.assertEquals(email, headerPage.getUsernameText());
    }

    @Test(description = "LP - User Visits Step 1 -  lessonp-10:User click 'Already a member' link"
            + "Steps:"
            + "1.Launch Step 1 in  a static page by clicking the Try it free button from the navigation bar"
            + "2.Click on the 'Already a member?' link (ONLY on the Step 1 static page)"
            + "3.Check if Login/Sign Up modal is displayed"
            + "4.Check if the user is not taken away from Step1(check URL)")
    public void testLessonp_10() {
        lpHomePage.loadPage();
        headerPage.clickOnTryItFree(true);
        stepOnePage.clickOnAlreadyAMember();
        Assert.assertEquals(TestData.SIGN_IN_MODAL_TITLE_TEXT, signInModal.getModalTitle());
        Assert.assertEquals(TestData.STEP_ONE_PAGE_PATH, stepOnePage.getPath());
    }
}
