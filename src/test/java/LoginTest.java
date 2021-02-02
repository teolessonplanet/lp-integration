import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class LoginTest extends BaseTest {
    private LpHomePage lpHomePage;
    private LoginPage loginPage;
    private HeaderPage headerPage;
    private SignInModal signInModal;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        headerPage = new HeaderPage(webDriver);
        signInModal = new SignInModal(webDriver);
    }

    @Test(description = "Free member - Login In/Sign in - lessonp-5033: Sing in button and functionality")
    public void testLessonp_5033() {
        testLoginFlow(TestData.VALID_EMAIL_FREEMIUM);
    }

    @Test(description = "Active user - Login In/Sign in - lessonp-5034: Sign in button and functionality")
    public void testLessonp_5034() {
        testLoginFlow(TestData.VALID_EMAIL_ACTIVE);
    }

    private void testLoginFlow(String email) {
        lpHomePage.loadPage();
        headerPage.clickOnSignInButton(false);
        Assert.assertEquals(TestData.SIGN_IN_MODAL_TITLE_TEXT, signInModal.getModalTitle());

        signInModal.typeEmail(email);
        signInModal.typePassword(TestData.INVALID_PASSWORD);
        signInModal.clickOnSignInButton();

        Assert.assertEquals(loginPage.getContentAlertMessage(), TestData.INVALID_LOGIN_OR_PASSWORD_MESSAGE);
        loginPage.typeEmail(email);
        loginPage.typePassword(TestData.VALID_PASSWORD);
        loginPage.clickOnSignInButton();

        Assert.assertTrue(headerPage.isUsernameDropDownDisplayed());
        Assert.assertEquals(lpHomePage.getPath(), TestData.LP_HOME_PAGE_PATH);
    }
}
