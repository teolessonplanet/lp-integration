import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_CalendarPageTest extends BaseTest {

    private LoginPage loginPage;
    private CalendarPageTest calendarPageTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        calendarPageTest = new CalendarPageTest();
    }

    @Test(description = "Regular SL - Calendar Page - lessonp-5125:Buttons/Links")
    public void testLessonp_5125() {
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        calendarPageTest.initTest(webDriver);
        calendarPageTest.testCurriculumCalendarPage(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE);
    }
}
