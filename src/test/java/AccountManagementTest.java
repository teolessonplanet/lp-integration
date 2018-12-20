import com.lessonplanet.pages.HeaderPage;
import com.lessonplanet.pages.LpHomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class AccountManagementTest extends BaseTest {
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        headerPage = new HeaderPage(webDriver);
    }

    @Test(description = "Account management - Create a Free Member account - lessonp-717:Try It Free button")
    public void testLessonp_717() {
        lpHomePage.loadPage();
        headerPage.clickOnTryItFree(false);
        Assert.assertEquals(TestData.STEP);
        headerPage.clickOnTryItFree(false);
    }
}
