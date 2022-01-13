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

    @Test(description = "Cobb SL - Publish Collection - lessonp-5958: With LP Resources", groups = {"cobb"})
    public void testLessonp_5958() {
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_COBB, 2, 0, 0, false);
    }

    @Test(description = "Cobb SL - Publish Collection - lessonp-6128: With LP Resources & Uploaded Resources - include", groups = {"cobb"})
    public void testLessonp_6128() {
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_COBB, 2, 0, 1, true);
    }

    @Test(description = "Cobb SL - Publish Collection - lessonp-6131: With LP Resources & Uploaded Resources - do not include", groups = {"cobb"})
    public void testLessonp_6131() {
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_COBB, 2, 0, 1, false);
    }

    @Test(description = "Cobb SL - Publish Collection - lessonp-5961: With LP Resources & Folders", groups = {"cobb"})
    public void testLessonp_5961() {
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_COBB, 2, 1, 0, false);
    }

    @Test(description = "Cobb SL - Publish Collection - lessonp-5962: With LP Resources & Folders & Uploaded Resources - include", groups = {"cobb"})
    public void testLessonp_5962() {
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_COBB, 2, 1, 1, true);
    }

    @Test(description = "Cobb SL - Publish Collection - lessonp-6132: With LP Resources & Folders & Uploaded Resources - do not include", groups = {"cobb"})
    public void testLessonp_6132() {
        user_publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_COBB, 2, 1, 1, false);
    }

    @Test(description = "Cobb SL - Publish Collection - lessonp-6130: Collection not published modal", groups = {"cobb"})
    public void testLessonp_6130() {
        user_publishCollectionTest.testCollectionNotPublishedModal(TestData.VALID_EMAIL_CSL_COBB);
    }
}
