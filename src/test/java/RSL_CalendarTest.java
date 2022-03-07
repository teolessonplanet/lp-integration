import com.lessonplanet.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_CalendarTest extends BaseTest {

    private LoginPage loginPage;
    private User_CalendarTest user_calendarTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_calendarTest = new User_CalendarTest();
    }

    protected void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Regular SL - Calendar - C2371: Buttons/Links", groups = {"rsl"})
    public void testC2371() {
        testCurriculumCalendarPage(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    protected void testCurriculumCalendarPage(String account) {
        loginPage.performLogin(account, TestData.VALID_PASSWORD);
        user_calendarTest.initTest(webDriver);
        user_calendarTest.testCurriculumCalendarPage(account);
    }
}
