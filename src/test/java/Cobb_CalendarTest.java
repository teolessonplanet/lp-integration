import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_CalendarTest extends BaseTest {
    private RSL_CalendarTest rsl_calendarTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        rsl_calendarTest = new RSL_CalendarTest();
    }

    @Test(description = "Cobb SL - Calendar - C2640: Buttons/Links", groups = {"cobb"})
    public void testC2640() {
        rsl_calendarTest.initTest(webDriver);
        rsl_calendarTest.testCurriculumCalendarPage(TestData.VALID_EMAIL_CSL_COBB);
    }
}
