import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_PublishCollectionTest extends BaseTest {
    private LoginPage loginPage;
    private User_PublishCollectionTest user_publishCollectionTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_publishCollectionTest = new User_PublishCollectionTest();
    }

    @Test(description = "Custom SL - Publish Collection - C2456: With LP Resources", groups = {"csl"})
    public void testC2456() {
        user_publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2, 0, 0, false);
    }

    @Test(description = "Custom SL - Publish Collection - C2457: With LP Resources & Uploaded Resources - include", groups = {"csl"})
    public void testC2457() {
        user_publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2, 0, 1, true);
    }

    @Test(description = "Custom SL - Publish Collection - C2458: With LP Resources & Uploaded Resources - don't include file", groups = {"csl"})
    public void testC2458() {
        user_publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2, 0, 1, false);
    }

    @Test(description = "Custom SL - Publish Collection - C2459: With LP Resources & Folders", groups = {"csl"})
    public void testC24596() {
        user_publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2, 1, 0, false);
    }

    @Test(description = "Custom SL - Publish Collection - C2460: With LP Resources & Folders & Uploaded Resources - include", groups = {"csl"})
    public void testC2460() {
        user_publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2, 1, 1, true);
    }

    @Test(description = "Custom SL - Publish Collection - C2461: With LP Resources & Folders & Uploaded Resources - don't include file", groups = {"csl"})
    public void testC2461() {
        user_publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2, 1, 1, false);
    }

    @Test(description = "Custom SL - Publish Collection - C2462: Collection not published modal", groups = {"csl"})
    public void testC2462() {
        user_publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_publishCollectionTest.testCollectionNotPublishedModal(TestData.VALID_EMAIL_CSL_HENRY);
    }
}
