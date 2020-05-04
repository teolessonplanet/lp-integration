import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_Iframe_FooterTest extends BaseTest {
    private LoginPage loginPage;
    private FooterTest footerTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        footerTest = new FooterTest();
        reachRslLoginPage();
    }

    public void reachRslLoginPage() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        footerTest.initTest(webDriver);
    }

    @Test(description = "Regular SL - Footer - lessonp-4150:Footer structure")
    public void testLessonp_4150() {
        footerTest.testFooterContainer(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Footer - lessonp-4154:Bottom footer links")
    public void testLessonp_4154() {
        footerTest.testBottomFooterLinks(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Footer -  lessonp-4156:LE Logo")
    public void testLessonp_4156() {
        footerTest.testRegularSlLogo();
    }
}
