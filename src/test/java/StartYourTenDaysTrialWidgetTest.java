import com.lessonplanet.pages.LpHomePage;
import com.lessonplanet.pages.StartYourTenDayFreeTrialWidget;
import com.lessonplanet.pages.StepOneModal;
import com.lessonplanet.pages.StepOnePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.TestData;

public class StartYourTenDaysTrialWidgetTest {

    private LpHomePage lpHomePage;
    private StartYourTenDayFreeTrialWidget startYourTenDayFreeTrialWidget;
    private StepOnePage stepOnePage;
    private StepOneModal stepOneModal;

    public StartYourTenDaysTrialWidgetTest(WebDriver webDriver) {
        lpHomePage = new LpHomePage(webDriver);
        startYourTenDayFreeTrialWidget = new StartYourTenDayFreeTrialWidget(webDriver);
        stepOnePage = new StepOnePage(webDriver);
        stepOneModal = new StepOneModal(webDriver);
    }

    public void testStartYourTenDaysTrialWidget() {
        Assert.assertEquals(startYourTenDayFreeTrialWidget.getStartYourTenDaysFreeTrialContentAsText(), TestData.SIDE_WIDGET_START_YOUR_TEN_DAYS_FREE_TRIAL_VISITOR_TEXT);
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(true);
        Assert.assertTrue(stepOnePage.isAlreadyAMemberButtonDisplayed());
        lpHomePage.closeTab();
        lpHomePage.waitForLoad();
        startYourTenDayFreeTrialWidget.clickOnSubscriptionButton(false);
        Assert.assertTrue(stepOneModal.isTitleTextDisplayed());
    }

    public void testStartYourTenDaysTrialWidgetDisplayed() {
        Assert.assertTrue(startYourTenDayFreeTrialWidget.getStartYourTenDaysFreeTrialContentAsText().contains(TestData.SIDE_WIDGET_START_YOUR_TEN_DAYS_FREE_TRIAL));
    }
}
