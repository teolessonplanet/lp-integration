import com.lessonplanet.pages.DiscoverResourcesPage;
import com.lessonplanet.pages.HeaderPage;
import com.lessonplanet.pages.LpHomePage;
import com.lessonplanet.pages.StepOneModal;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class AccountManagementTest extends BaseTest {
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private StepOneModal stepOneModal;
    private DiscoverResourcesPage discoverResourcesPage;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        headerPage = new HeaderPage(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
    }

    @Test(description = "Account management - Create a Free Member account - lessonp-717:Try It Free button")
    public void testLessonp_717() {
        lpHomePage.loadPage();
        Assert.assertEquals(headerPage.getTryItFreeButtonBackgroundColor(), TestData.TRY_IT_FREE_BUTTON_BACKGROUND_COLOR);
        headerPage.clickOnTryItFree(false);
        Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
    }

    @Test(description = "Account management - Create a Free Member account - lessonp-692:Through the 'Become a Lesson Planet Free Member (Limited Access)' modal")
    public void testLessonp_692() {
        /*

    - Go to the search page and drag one resource into the Collection Builder
    * the "Find, Collect & Organize" modal is displayed, allowing users to choose between an Limited Access (Free Member) and a Full Access.

    - Click the "Free Member" link at the bottom of the modal
    * the "Become a Lesson Planet Free Member (Limited Access)" modal is displayed.

    - Enter an email and password and click Get Started
    * The following message is displayed:

Thanks so much for joining Lesson Planet.
To finish signing up, check the email we sent and click the confirmation link to activate your account.
         */

        discoverResourcesPage.loadPage();
        List<WebElement> getFreeAccess = discoverResourcesPage.clickGetFreeAccess(false);
//drag and drop it

        discoverResourcesPage.loadPage();



    }
}
