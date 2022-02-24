import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_CalendarPageTest extends BaseTest {
    private RSL_CalendarPageTest rsl_calendarPageTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        rsl_calendarPageTest = new RSL_CalendarPageTest();
    }

    @Test(description = "Custom SL - Calendar page - C2463:Buttons/Links", groups = {"csl"})
    public void testC2463() {
        rsl_calendarPageTest.initTest(webDriver);
        rsl_calendarPageTest.testCurriculumCalendarPage(TestData.VALID_EMAIL_CSL_HENRY);
    }
}
