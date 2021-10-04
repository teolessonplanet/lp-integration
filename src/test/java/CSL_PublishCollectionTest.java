import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_PublishCollectionTest extends BaseTest {
    private LoginPage loginPage;
    private Regular_User_PublishCollectionTest publishCollectionTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        publishCollectionTest = new Regular_User_PublishCollectionTest();
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-6133: With LP Resources")
    public void testLessonp_6133() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2, 0, 0, false);
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-6134: With LP Resources & Uploaded Resources - include")
    public void testLessonp_6134() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2, 0, 1, true);
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-6135: With LP Resources & Uploaded Resources - don't include file")
    public void testLessonp_6135() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2, 0, 1, false);
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-6136: With LP Resources & Folders")
    public void testLessonp_6136() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        publishCollectionTest.testAddResourcesToPublishCollection( TestData.VALID_EMAIL_CSL_HENRY, 2,1,0,false);
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-6137: With LP Resources & Folders & Uploaded Resources - include")
    public void testLessonp_6137() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2,1,1,true);
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-6138: With LP Resources & Folders & Uploaded Resources - don't include file")
    public void testLessonp_6138() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2,1,1,false);
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-6139: Collection not published modal")
    public void testLessonp_6139() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        publishCollectionTest.testCollectionNotPublishedModal(TestData.VALID_EMAIL_CSL_HENRY);
    }
}
