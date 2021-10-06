import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_CollectionPlayerTest extends BaseTest {
    private User_CollectionPlayerTest user_collectionPlayerTest;

    @BeforeMethod
    public void beforeMethod() {
        user_collectionPlayerTest = new User_CollectionPlayerTest();
        user_collectionPlayerTest.initTest(webDriver);
    }

    @Test(description = "Regular SL - Collection player - lessonp-5088:Appearance")
    public void testLessonp_5129() {
        user_collectionPlayerTest.testCollectionPlayerAppearance(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Collection player - lessonp-5127:Collection Navigator")
    public void testLessonp_5127() {
        user_collectionPlayerTest.testCollectionNavigator(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Collection player - lessonp-5128:Resource Viewer")
    public void testLessonp_5128() {
        user_collectionPlayerTest.testResourceViewer(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Collection player - lessonp-5130:Teacher View")
    public void testLessonp_5130() {
        user_collectionPlayerTest.testTeacherView(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Collection player - lessonp-5126:Student View")
    public void testLessonp_5126() {
        user_collectionPlayerTest.testStudentView(TestData.VALID_EMAIL_RSL_SBCEO);
    }
}
