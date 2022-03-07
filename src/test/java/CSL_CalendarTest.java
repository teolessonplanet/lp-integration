import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_CalendarTest extends BaseTest {
    private RSL_CalendarTest rsl_calendarTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        rsl_calendarTest = new RSL_CalendarTest();
    }

    @Test(description = "Custom SL - Calendar - C2463:Buttons/Links", groups = {"csl"})
    public void testC2463() {
        rsl_calendarTest.initTest(webDriver);
        rsl_calendarTest.testCurriculumCalendarPage(TestData.VALID_EMAIL_CSL_HENRY);
    }
}
