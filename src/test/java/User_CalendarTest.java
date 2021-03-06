import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class User_CalendarTest extends BaseTest {
    private CalendarPage calendarPage;
    private HeaderPage headerPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private LpHomePage lpHomePage;
    private StepTwoPage stepTwoPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        calendarPage = new CalendarPage(webDriver);
        headerPage = new HeaderPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        lpHomePage = new LpHomePage(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
    }

    protected void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Visitor - Calendar - C2043: Buttons/Links", groups = {"visitor"})
    public void testC2043() {
        testCurriculumCalendarPage(TestData.PLAN_VISITOR);
    }

    @Test(description = "Free Member - Calendar - C2190: Buttons/Links", groups = {"freemium"})
    public void testC2190() {
        stepTwoPage.createNewAccount(TestData.PLAN_FREEMIUM);
        testCurriculumCalendarPage(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Calendar - C2305: Buttons/Links", groups = {"activeUser"})
    public void testC2305() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        testCurriculumCalendarPage(TestData.PLAN_PRO);
    }

    protected void testCurriculumCalendarPage(String account) {
        lpHomePage.loadPage();
        headerPage.hoverOverDiscoverButton();
        headerPage.clickOnCurriculumCalendarButton();
        testMonthPage(TestData.getCurrentMonth(), account);
        for (int i = TestData.getCurrentMonth() + 1; i < 12; i++) {
            calendarPage.clickOnNextArrowLink();
            testMonthPage(i, account);
        }
        calendarPage.loadPage();
        for (int i = TestData.getCurrentMonth() - 1; i > 0; i--) {
            calendarPage.clickOnPreviousArrowLink();
            testMonthPage(i, account);
        }
    }

    private void testMonthPage(int index, String account) {
        if (index != TestData.getCurrentMonth()) {
            Assert.assertEquals(calendarPage.getPath(), TestData.CURRICULUM_CALENDAR_PAGE_PATH + "/" + (TestData.MONTH[index]).toLowerCase());
        } else {
            Assert.assertEquals(calendarPage.getPath(), TestData.CURRICULUM_CALENDAR_PAGE_PATH);
        }
        Assert.assertTrue(calendarPage.isCalendarTitleDisplayed());
        Assert.assertEquals(calendarPage.getCalendarTitle(), TestData.MONTH[index] + TestData.CALENDAR_TITLE);
        Assert.assertTrue(calendarPage.isCalendarDescriptionDisplayed());
        Assert.assertEquals(calendarPage.getCalendarDescription(), TestData.CALENDAR_DECRIPTION);
        Assert.assertTrue(calendarPage.isCalendarDisplayed());
        Assert.assertTrue(calendarPage.isMonthLinkDisplayed());
        Assert.assertEquals(calendarPage.getMonthLinkText(), TestData.MONTH[index] + " " + TestData.getCurrentYear());
        calendarPage.clickOnMonthLink();
        calendarPage.waitForPageLoad();
        Assert.assertEquals(calendarPage.getPath(), TestData.SEARCH_PAGE_WITH_KEYWORD_PATH + TestData.KEYWORD[index].replace(" ", "+").replace("'", "%27"));
        Assert.assertEquals(headerPage.getSearchText(), TestData.KEYWORD[index]);
        if (account.equals(TestData.VALID_EMAIL_CSL_HENRY) || account.equals(TestData.VALID_EMAIL_CSL_COBB) || account.equalsIgnoreCase(TestData.VALID_EMAIL_RSL_SBCEO)) {
            Assert.assertTrue(discoverResourcesPage.getSearchMessage().contains(TestData.SEARCH_MESSAGE_FOUND_1));
            Assert.assertTrue(discoverResourcesPage.getSearchMessage().contains(TestData.SEARCH_MESSAGE_FOUND_2 + TestData.KEYWORD[index]));
        } else {
            Assert.assertTrue(discoverResourcesPage.getSearchMessage().contains(TestData.SEARCH_MESSAGE + TestData.KEYWORD[index]));
        }
        discoverResourcesPage.goBackOnePage();
        calendarPage.waitForPageLoad();
    }
}
