import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_PublishFolderTest extends BaseTest {
    private LoginPage loginPage;
    private User_PublishFolderTest user_publishFolderTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_publishFolderTest = new User_PublishFolderTest();
    }

    @Test(description = "Custom SL - Publish Folder - C2456: With LP Resources", groups = {"csl"})
    public void testC2456() {
        user_publishFolderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_publishFolderTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2, 0, 0, false);
    }

    @Test(description = "Custom SL - Publish Folder - C2457: With LP Resources & Uploaded Resources - include", groups = {"csl"})
    public void testC2457() {
        user_publishFolderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_publishFolderTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2, 0, 1, true);
    }

    @Test(description = "Custom SL - Publish Folder - C2458: With LP Resources & Uploaded Resources - don't include file", groups = {"csl"})
    public void testC2458() {
        user_publishFolderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_publishFolderTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2, 0, 1, false);
    }

    @Test(description = "Custom SL - Publish Folder - C2459: With LP Resources & Folders", groups = {"csl"})
    public void testC24596() {
        user_publishFolderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_publishFolderTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2, 1, 0, false);
    }

    @Test(description = "Custom SL - Publish Folder - C2460: With LP Resources & Folders & Uploaded Resources - include", groups = {"csl"})
    public void testC2460() {
        user_publishFolderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_publishFolderTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2, 1, 1, true);
    }

    @Test(description = "Custom SL - Publish Folder - C2461: With LP Resources & Folders & Uploaded Resources - don't include file", groups = {"csl"})
    public void testC2461() {
        user_publishFolderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_publishFolderTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_HENRY, 2, 1, 1, false);
    }

    @Test(description = "Custom SL - Publish Folder - C2462: Collection not published modal", groups = {"csl"})
    public void testC2462() {
        user_publishFolderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        user_publishFolderTest.testCollectionNotPublishedModal(TestData.VALID_EMAIL_CSL_HENRY);
    }
}
