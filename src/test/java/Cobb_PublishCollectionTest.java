import com.lessonplanet.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_PublishCollectionTest extends BaseTest {
    private LoginPage loginPage;
    private PublishCollectionTest publishCollectionTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        publishCollectionTest = new PublishCollectionTest();
        initTest();
    }

    protected void initTest() {
        publishCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
    }

    @Test(description = "Publish Collection - lessonp-5958: With LP Resources")
    public void testLessonp_5958() {
        publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_COBB, 2,0, 0, false);
    }

    @Test(description = "Publish Collection - lessonp-5959: With LP Resources & Uploaded Resources - include")
    public void testLessonp_5959() {
        publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_COBB,2,0, 1 , false);
    }

    @Test(description = "Publish Collection - lessonp-5960: With LP Resources & Folders")
    public void testLessonp_5960() {
        publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_COBB,2,1, 0 , false);
    }

    @Test(description = "Publish Collection - lessonp-5961: With LP Resources & Folders & Uploaded Resources - include")
    public void testLessonp_5961() {
        publishCollectionTest.testAddResourcesToPublishCollection(TestData.VALID_EMAIL_CSL_COBB,2,1, 1, false);
    }

    @Test(description = "Publish Collection - lessonp-5962: Collection not published modal")
    public void testLessonp_5962() {
        publishCollectionTest.testCollectionNotPublishedModal(TestData.VALID_EMAIL_CSL_COBB);
    }
}
