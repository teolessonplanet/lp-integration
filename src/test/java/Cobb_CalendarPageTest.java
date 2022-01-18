import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_CalendarPageTest extends BaseTest {
    private RSL_CalendarPageTest rsl_calendarPageTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        rsl_calendarPageTest = new RSL_CalendarPageTest();
    }

    @Test(description = "Cobb SL - Calendar page - lessonp-5514:Buttons/Links", groups = {"cobb"})
    public void testLessonp_5514() {
        rsl_calendarPageTest.initTest(webDriver);
        rsl_calendarPageTest.testCurriculumCalendarPage(TestData.VALID_EMAIL_CSL_COBB);
    }
}
