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
        testSignInButton();
    }

    @Test(description = "Freemium - Login In/Sign in - lessonp-716 - User supplies invalid form data")
    public void testLessonp_716() {
        testInvalidData();
    }

    @Test(description = "Freemium - Login In/Sign in - lessonp-715 - User supplies valid form data")
    public void testLessonp_715() {
        testValidData(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
    }

    @Test(description = "Active user - Login In/Sign in - lessonp-735: 'Sign In' button")
    public void testLessonp_735() {
        testSignInButton();
    }

    @Test(description = "Active user - Login In/Sign in - lessonp-736 - User supplies invalid form data")
    public void testLessonp_736() {
        testInvalidData();
    }

    @Test(description = "Active user - Login In/Sign in - lessonp-737 - User supplies valid form data")
    public void testLessonp_737() {
        testValidData(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
    }

    private void testSignInButton() {
        lpHomePage.loadPage();
        headerPage.clickOnSignInButton(false);
        Assert.assertEquals(TestData.SIGN_IN_MODAL_TITLE_TEXT, signInModal.getModalTitle());
    }

    private void testInvalidData() {
        fillDataAndClickSubmit(TestData.INVALID_EMAIL, TestData.INVALID_PASSWORD);
        final String errorMessage = loginPage.getContentAlertMessage();
        Assert.assertEquals(TestData.INVALID_LOGIN_OR_PASSWORD_MESSAGE, errorMessage);
    }

    private void testValidData(String username, String password) {
        fillDataAndClickSubmit(username, password);
        final String path = lpHomePage.getPath();
        Assert.assertEquals(TestData.LP_HOME_PAGE_PATH, path);
    }

    private void fillDataAndClickSubmit(String username, String password) {
        loginPage.loadPage();
        loginPage.typeEmail(username);
        loginPage.typePassword(password);
        loginPage.clickOnSignInButton();
    }
}
