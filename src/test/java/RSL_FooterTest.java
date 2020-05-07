import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import util.TestData;
@Ignore
@Deprecated
public class RSL_FooterTest extends BaseTest {
    private LoginPage loginPage;
    private FooterTest footerTest;
    @Ignore
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

    @Test(description = "Regular SL - Footer - lessonp-4151:Open Educational Resources")
    public void testLessonp_4151() {
        footerTest.testOpenEducationalResourcesSection();
    }

    @Test(description = "Regular SL - Footer - lessonp4152:Discover Resources")
    public void testLessonp_4152() {
        footerTest.testDiscoverResourcesSection();
    }

    @Test(description = "Regular SL - Footer - lessonp-4153:Manage Curriculum")
    public void testLessonp_4153() {
        footerTest.testManageCurriculumSection();
    }

    @Test(description = "Regular SL - Footer - lessonp-4154:Bottom footer links")
    public void testLessonp_4154() {
        footerTest.testBottomFooterLinks(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Footer - lessonp-4155:Social links")
    public void testLessonp_4155() {
        footerTest.testLessonPlanetSocialLinks();
    }

    @Test(description = "Regular SL - Footer -  lessonp-4156:LE Logo")
    public void testLessonp_4156() {
        footerTest.testRegularSlLogo();
    }
}
