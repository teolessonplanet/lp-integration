import com.lessonplanet.pages.LoginPage;
import org.openqa.selenium.WebDriver;
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

    protected void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Regular SL - Calendar Page - lessonp-5125:Buttons/Links")
    public void testLessonp_5125() {
        testCurriculumCalendarPage(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    protected void testCurriculumCalendarPage(String account) {
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        calendarPageTest.initTest(webDriver);
        calendarPageTest.testCurriculumCalendarPage(account);
    }
}
