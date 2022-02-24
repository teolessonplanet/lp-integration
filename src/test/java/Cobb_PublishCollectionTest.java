import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_PublishCollectionTest extends BaseTest {
    private LoginPage loginPage;
    private User_PublishCollectionTest user_publishCollectionTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_publishCollectionTest = new User_PublishCollectionTest();
        initTest();
    }

    protected void initTest() {
        user_publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
    }

    @Test(description = "Cobb SL - Publish Collection - C2591: With LP Resources", groups = {"cobb"})
    public void testC2591() {
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_COBB, 2, 0, 0, false);
    }

    @Test(description = "Cobb SL - Publish Collection - C2592: With LP Resources & Uploaded Resources - include", groups = {"cobb"})
    public void testC2592() {
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_COBB, 2, 0, 1, true);
    }

    @Test(description = "Cobb SL - Publish Collection - C2593: With LP Resources & Uploaded Resources - do not include", groups = {"cobb"})
    public void testC2593() {
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_COBB, 2, 0, 1, false);
    }

    @Test(description = "Cobb SL - Publish Collection - C2594: With LP Resources & Folders", groups = {"cobb"})
    public void testC2594() {
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_COBB, 2, 1, 0, false);
    }

    @Test(description = "Cobb SL - Publish Collection - C2595: With LP Resources & Folders & Uploaded Resources - include", groups = {"cobb"})
    public void testC2595() {
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_COBB, 2, 1, 1, true);
    }

    @Test(description = "Cobb SL - Publish Collection - C2596: With LP Resources & Folders & Uploaded Resources - do not include", groups = {"cobb"})
    public void testC2596() {
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_COBB, 2, 1, 1, false);
    }

    @Test(description = "Cobb SL - Publish Collection - C2597: Collection not published modal", groups = {"cobb"})
    public void testC2597() {
        user_publishCollectionTest.testCollectionNotPublishedModal(TestData.VALID_EMAIL_CSL_COBB);
    }
}
