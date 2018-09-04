import com.lessonplanet.pages.HeaderPage;
import com.lessonplanet.pages.LoginPage;
import com.lessonplanet.pages.LpHomePage;
import com.lessonplanet.pages.SignInModal;
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

    @Test(description = "Freemium - Login In/Sign in - lessonp-714: 'Sign In' button")
    public void testLessonp_714() {
        lpHomePage.loadPage();
        headerPage.clickOnSignInButton(false);
        Assert.assertEquals(TestData.SIGN_IN_MODAL_TITLE_TEXT,signInModal.getModalTitle());
    }

    @Test(description = "Freemium - Login In/Sign in - lessonp-716 - User supplies invalid form data")
    public void testLessonp_716() {
        loginPage.loadPage();
        loginPage.typeEmail(TestData.INVALID_EMAIL);
        loginPage.typePassword(TestData.INVALID_PASSWORD);
        loginPage.clickOnSignInButton();
        final String errorMessage = loginPage.getContentAlertMessage();
        Assert.assertEquals(TestData.INVALID_LOGIN_OR_PASSWORD_MESSAGE, errorMessage);
    }

    @Test(description = "Freemium - Login In/Sign in - lessonp-715 - User supplies valid form data ")
    public void testLessonp_715() {
        loginPage.loadPage();
        loginPage.typeEmail(TestData.VALID_EMAIL_FREEMIUM);
        loginPage.typePassword(TestData.VALID_PASSWORD);
        loginPage.clickOnSignInButton();
        final String path = lpHomePage.getPath();
        Assert.assertEquals(TestData.LP_HOME_PAGE_PATH, path);
    }
}
