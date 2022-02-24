import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_Iframe_FooterTest extends BaseTest {
    private LoginPage loginPage;
    private User_FooterTest user_footerTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_footerTest = new User_FooterTest();
        reachRslLoginPage();
    }

    public void reachRslLoginPage() {
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_footerTest.initTest(webDriver);
    }

    @Test(description = "Regular SL - Footer - C2344: Footer structure", groups = {"rsl"})
    public void testC2344() {
        user_footerTest.testFooterContainer(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Footer - C2346: Bottom footer links", groups = {"rsl"})
    public void testC2346() {
        user_footerTest.testBottomFooterLinks(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Footer - C2345: LE Logo", groups = {"rsl"})
    public void testC2345() {
        user_footerTest.testRegularSlLogo();
    }
}
