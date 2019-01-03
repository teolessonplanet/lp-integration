import com.lessonplanet.pages.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.util.List;

public class AccountManagementTest extends BaseTest {
    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private StepOneModal stepOneModal;
    private DiscoverResourcesPage discoverResourcesPage;
    private CollectionBuilderPage collectionBuilderPage;
    private BecomeALessonPlanetFreeMemberModal becomeALessonPlanetFreeMemberModal;
    private FreeMemberLimitedAccessModal freeMemberLimitedAccessModal;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        headerPage = new HeaderPage(webDriver);
        stepOneModal = new StepOneModal(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        becomeALessonPlanetFreeMemberModal = new BecomeALessonPlanetFreeMemberModal(webDriver);
        freeMemberLimitedAccessModal = new FreeMemberLimitedAccessModal(webDriver);
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
        discoverResourcesPage.loadPage();
        discoverResourcesPage.changeToListView();
        List<WebElement> getFreeAccessResources = discoverResourcesPage.getAllFreeAccessButtons();
        discoverResourcesPage.dragAndDrop(getFreeAccessResources.get(0), collectionBuilderPage.getCollectionDroppableZone());
        becomeALessonPlanetFreeMemberModal.clickOnFreeMemberButton();
        freeMemberLimitedAccessModal.typeEmailAddress(TestData.GET_NEW_EMAIL());
        freeMemberLimitedAccessModal.typePassword(TestData.VALID_PASSWORD);
        freeMemberLimitedAccessModal.clickOnGetStartedButton();

        //TODO: no thanks message
        discoverResourcesPage.loadPage();
    }


    @Test(description = "Account management - Create a Free Member account - lessonp-693:Quitting Step 2 registration process")
    public void testLessonp_693() {
        discoverResourcesPage.loadPage();
        discoverResourcesPage.changeToListView();
    }


    @Test(description = "Account management - Create a Free Member account - lessonp-694:After membership is canceled")
    public void testLessonp_694() {
        discoverResourcesPage.loadPage();
        discoverResourcesPage.changeToListView();
    }



}
