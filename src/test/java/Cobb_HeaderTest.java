import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_HeaderTest extends BaseTest {
    private LoginPage loginPage;
    private User_HeaderTest user_headerTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_headerTest = new User_HeaderTest();
    }

    @Test(description = "Cobb SL - Header - C2623: Header buttons", groups = {"cobb"})
    public void testC2623() {
        user_headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        user_headerTest.testHeaderButtons(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Header - C2624", groups = {"cobb"})
    public void testC2624() {
        user_headerTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        user_headerTest.testSearchBoxKeywordFunctionality(TestData.VALID_EMAIL_CSL_COBB);
    }
}
