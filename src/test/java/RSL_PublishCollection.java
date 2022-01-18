import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_PublishCollection extends BaseTest {
    private LoginPage loginPage;
    private User_PublishCollectionTest user_publishCollectionTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_publishCollectionTest = new User_PublishCollectionTest();
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5236: With LP Resources", groups = {"rsl"})
    public void testLessonp_5236() {
        user_publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_RSL_SBCEO, 2, 0, 0, false);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5237: With LP Resources & Uploaded Resources - include file", groups = {"rsl"})
    public void testLessonp_5237() {
        user_publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_RSL_SBCEO, 2, 0, 1, true);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5796: With LP Resources & Uploaded Resources - do not include file", groups = {"rsl"})
    public void testLessonp_5796() {
        user_publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_RSL_SBCEO, 2, 0, 1, false);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5612: With LP Resources & Folders", groups = {"rsl"})
    public void testLessonp_5612() {
        user_publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_RSL_SBCEO, 2, 1, 0, false);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5613: With LP Resources & Folders & Uploaded Resources - include file", groups = {"rsl"})
    public void testLessonp_5613() {
        user_publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_RSL_SBCEO, 2, 1, 1, true);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5797: With LP Resources & Folders & Uploaded Resources - do not include file", groups = {"rsl"})
    public void testLessonp_5797() {
        user_publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_RSL_SBCEO, 2, 1, 1, false);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5798: Collection not published modal", groups = {"rsl"})
    public void testLessonp_5798() {
        user_publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_publishCollectionTest.testCollectionNotPublishedModal(TestData.VALID_EMAIL_RSL_SBCEO);
    }
}
