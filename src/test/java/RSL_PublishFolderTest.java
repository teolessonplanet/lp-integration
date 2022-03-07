import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_PublishFolderTest extends BaseTest {
    private LoginPage loginPage;
    private User_PublishFolderTest user_publishFolderTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_publishFolderTest = new User_PublishFolderTest();
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Regular SL - Publish Folder - C2337: With LP Resources", groups = {"rsl"})
    public void testC2337() {
        user_publishFolderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_publishFolderTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_RSL_SBCEO, 2, 0, 0, false);
    }

    @Test(description = "Regular SL - Publish Folder - C2338: With LP Resources & Uploaded Resources - include file", groups = {"rsl"})
    public void testC2338() {
        user_publishFolderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_publishFolderTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_RSL_SBCEO, 2, 0, 1, true);
    }

    @Test(description = "Regular SL - Publish Folder - C2339: With LP Resources & Uploaded Resources - do not include file", groups = {"rsl"})
    public void testC2339() {
        user_publishFolderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_publishFolderTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_RSL_SBCEO, 2, 0, 1, false);
    }

    @Test(description = "Regular SL - Publish Folder - C2340: With LP Resources & Folders", groups = {"rsl"})
    public void testC2340() {
        user_publishFolderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_publishFolderTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_RSL_SBCEO, 2, 1, 0, false);
    }

    @Test(description = "Regular SL - Publish Folder - C2341: With LP Resources & Folders & Uploaded Resources - include file", groups = {"rsl"})
    public void testC2341() {
        user_publishFolderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_publishFolderTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_RSL_SBCEO, 2, 1, 1, true);
    }

    @Test(description = "Regular SL - Publish Folder - C2342: With LP Resources & Folders & Uploaded Resources - do not include file", groups = {"rsl"})
    public void testC2342() {
        user_publishFolderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_publishFolderTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_RSL_SBCEO, 2, 1, 1, false);
    }

    @Test(description = "Regular SL - Publish Folder - C2343: Collection not published modal", groups = {"rsl"})
    public void testC2343() {
        user_publishFolderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        user_publishFolderTest.testCollectionNotPublishedModal(TestData.VALID_EMAIL_RSL_SBCEO);
    }
}
