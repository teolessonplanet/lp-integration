import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import util.TestData;

public class Admin_CleanCms extends BaseTest {

    private static final String STAGING_CLEAR_CM_URL = "https://staging.lessonplanet.com/users/auto/clear_cm?user_email=%s";
    private LoginPage loginPage;

    @Ignore
    @BeforeMethod
    private void beforeMethod() {
        loginPage = new LoginPage(webDriver);
    }

    @Test
    public void cleanCmsForAllAccountFromTestData() {
        cleanCmForAccount(TestData.VALID_EMAIL_RSL_SBCEO);
        cleanCmForAccount(TestData.VALID_EMAIL_CSL_HENRY);
        cleanCmForAccount(TestData.VALID_EMAIL_CSL_QA_CUSTOM);
        cleanCmForAccount(TestData.VALID_EMAIL_CSL_COBB);
        cleanCmForAccount(TestData.VALID_EMAIL_CSL_COBB);
        cleanCmForAccount(TestData.VALID_EMAIL_RSL_LAGUNA_SCHOOL);
        cleanCmForAccount(TestData.RSL_SBCEO_EXISTING_TEACHER_EMAIL);
        cleanCmForAccount(TestData.CSL_QA_CUSTOM_EXISTING_TEACHER_EMAIL);
        cleanCmForAccount(TestData.CSL_COBB_EXISTING_TEACHER_EMAIL);
    }

    private void cleanCmForAccount(String emailAccount){
        loginPage.performLogin(emailAccount, TestData.VALID_PASSWORD);
        webDriver.get(String.format(STAGING_CLEAR_CM_URL,emailAccount));
        webDriver.manage().deleteAllCookies();
    }
}
