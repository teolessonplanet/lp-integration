import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_PublishCollectionTest extends BaseTest {
    private LoginPage loginPage;
    private RSL_PublishCollection rsl_publishCollectionTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rsl_publishCollectionTest = new RSL_PublishCollection();
        initRslPublishCollectionTest();
    }

    public void initRslPublishCollectionTest() {
        rsl_publishCollectionTest.initTest(webDriver);
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-5799: With LP Resources")
    public void testLessonp_5799() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        rsl_publishCollectionTest.testAddResourcesToPublishCollection(false, false, TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-5800: With LP Resources & Uploaded Resources - include")
    public void testLessonp_5800() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        rsl_publishCollectionTest.testAddResourcesToPublishCollection(false, true, TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-5801: With LP Resources & Uploaded Resources - do not include")
    public void testLessonp_5801() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        rsl_publishCollectionTest.testAddResourcesToPublishCollection(false, true, TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-5802: With LP Resources & Folders")
    public void testLessonp_5802() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        rsl_publishCollectionTest.testAddResourcesToPublishCollection(true, false, TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-5803: With LP Resources & Folders & Uploaded Resources - include")
    public void testLessonp_5803() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        rsl_publishCollectionTest.testAddResourcesToPublishCollection(true, true, TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-5804: With LP Resources & Folders & Uploaded Resources - do not include")
    public void testLessonp_5804() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        rsl_publishCollectionTest.testAddResourcesToPublishCollection(true, true, TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Publish Collection - lessonp-5805: Collection not published modal")
    public void testLessonp_5805() {
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        rsl_publishCollectionTest.testCollectionNotPublishedModal(TestData.VALID_EMAIL_CSL_HENRY);
    }
}
