import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CalendarPageTest extends BaseTest {
    private CalendarPage calendarPage;
    private HeaderPage headerPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private LpHomePage lpHomePage;

    @BeforeMethod
    public void beforeMethod() {
        calendarPage = new CalendarPage(webDriver);
        headerPage = new HeaderPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        lpHomePage = new LpHomePage(webDriver);
    }

    @Test(description = "Visitor - Calendar Page -  lessonp-4196: Curriculum Calendar Page Buttons/Links")
    public void testLessonp_4196() {
        lpHomePage.loadPage();
        headerPage.hoverOverResourcesButton();
        headerPage.clickOnCurriculumCalendarButton();
        testMonthPage(TestData.getCurrentMonth());
        for (int i = TestData.getCurrentMonth() + 1; i < 12; i++) {
            calendarPage.clickNextArrowLink();
            testMonthPage(i);
        }
        calendarPage.loadPage();
        for (int i = TestData.getCurrentMonth() - 1; i >= 0; i--) {
            calendarPage.clickPreviousArrowLink();
            testMonthPage(i);
        }
    }

    private void testMonthPage(int index) {
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
        Assert.assertEquals(calendarPage.getPath(), TestData.SEARCH_PAGE_PATH + TestData.KEYWORD[index].replace(" ", "+").replace("'", "%27"));
        Assert.assertEquals(headerPage.getSearchText(), TestData.KEYWORD[index]);
        Assert.assertTrue(discoverResourcesPage.getSearchMessage().contains(TestData.SEARCH_MESSAGE + TestData.KEYWORD[index]));
        discoverResourcesPage.goBackOnePage();
        calendarPage.waitForPageLoad();
    }
}
