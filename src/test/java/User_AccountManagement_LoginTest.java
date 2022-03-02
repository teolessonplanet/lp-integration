import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class User_AccountManagement_LoginTest extends BaseTest {
    private LpHomePage lpHomePage;
    private LoginPage loginPage;
    private HeaderPage headerPage;
    private SignInModal signInModal;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        headerPage = new HeaderPage(webDriver);
        signInModal = new SignInModal(webDriver);
    }

    @Test(description = "Account Management - Login In Free Member- C2136: Sing in button and functionality", groups = {"accountManagement"})
    public void testC2136() {
        testLoginFlow(createNewUser(TestData.PLAN_FREEMIUM));
    }

    @Test(description = "Account Management - Login In Active Member- C2256: Sign in button and functionality", groups = {"accountManagement"})
    public void testC2256() {
        testLoginFlow(createNewUser(TestData.PLAN_STARTER));
    }

    private void testLoginFlow(String email) {
        lpHomePage.loadPage();
        headerPage.clickOnSignInButton(false);
        Assert.assertEquals(TestData.SIGN_IN_MODAL_TITLE_TEXT, signInModal.getModalTitle());

        signInModal.typeEmail(email);
        signInModal.typePassword(TestData.INVALID_PASSWORD);
        signInModal.clickOnSignInButton();

        Assert.assertEquals(loginPage.getContentAlertMessage(), TestData.INVALID_LOGIN_OR_PASSWORD_NOTIFICATION_TEXT);
        loginPage.typeEmail(email);
        loginPage.typePassword(TestData.VALID_PASSWORD);
        loginPage.clickOnSignInButton();

        Assert.assertTrue(headerPage.isUsernameDropDownDisplayed());
        Assert.assertEquals(lpHomePage.getPath(), TestData.LP_HOME_PAGE_PATH);
    }
}
