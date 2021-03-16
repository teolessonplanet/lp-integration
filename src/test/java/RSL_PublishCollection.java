import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_PublishCollection extends BaseTest {
    private LoginPage loginPage;
    private PublishCollectionTest publishCollectionTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        publishCollectionTest = new PublishCollectionTest();
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5236: With LP Resources")
    public void testLessonp_5236() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_RSL_SBCEO, 2, 0, 0, false);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5237: With LP Resources & Uploaded Resources - include file")
    public void testLessonp_5237() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_RSL_SBCEO, 2, 0, 1, true);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5796: With LP Resources & Uploaded Resources - do not include file")
    public void testLessonp_5796() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_RSL_SBCEO, 2,0,1,false);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5612: With LP Resources & Folders")
    public void testLessonp_5612() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_RSL_SBCEO, 2,1,0,false);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5613: With LP Resources & Folders & Uploaded Resources - include file")
    public void testLessonp_5613() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_RSL_SBCEO, 2,1,1,true);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5797: With LP Resources & Folders & Uploaded Resources - do not include file")
    public void testLessonp_5797() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_RSL_SBCEO, 2,1,1,false);
    }

    @Test(description = "Regular SL - Publish Collection - lessonp-5798: Collection not published modal")
    public void testLessonp_5798() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        publishCollectionTest.testCollectionNotPublishedModal(TestData.VALID_EMAIL_RSL_SBCEO);
    }
}
