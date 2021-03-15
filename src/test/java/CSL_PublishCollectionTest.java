import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_PublishCollectionTest extends BaseTest {
    private LoginPage loginPage;
    private PublishCollectionTest publishCollectionTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        publishCollectionTest = new PublishCollectionTest();
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-5799: With LP Resources")
    public void testLessonp_5799() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2, 0, 0, false);
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-5800: With LP Resources & Uploaded Resources - include")
    public void testLessonp_5800() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2, 0, 1, false);
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-5802: With LP Resources & Folders")
    public void testLessonp_5802() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        publishCollectionTest.testAddResourcesToPublishCollection( TestData.VALID_EMAIL_CSL_HENRY, 2,1,0,false);
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-5803: With LP Resources & Folders & Uploaded Resources - include")
    public void testLessonp_5803() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2,1,1,false);
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-5805: Collection not published modal")
    public void testLessonp_5805() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        publishCollectionTest.testCollectionNotPublishedModal(TestData.VALID_EMAIL_CSL_HENRY);
    }
}
