import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_CollectionPlayerTest extends BaseTest {
    private User_CollectionPlayerTest collectionPlayerTest;

    @BeforeMethod
    public void beforeMethod() {
        collectionPlayerTest = new User_CollectionPlayerTest();
        collectionPlayerTest.initTest(webDriver);
    }

    @Test(description = "Custom SL - Collection player - lessonp-5088:Appearance")
    public void testLessonp_5088() {
        collectionPlayerTest.testCollectionPlayerAppearance(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Collection player - lessonp-5093:Collection Navigator")
    public void testLessonp_5093() {
        collectionPlayerTest.testCollectionNavigator(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Collection player - lessonp-5094:Resource Viewer")
    public void testLessonp_5094() {
        collectionPlayerTest.testResourceViewer(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Collection player - lessonp-5091:Teacher View")
    public void testLessonp_5191() {
        collectionPlayerTest.testTeacherView(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Collection player - lessonp-5090:Student View")
    public void testLessonp_5090() {
        collectionPlayerTest.testStudentView(TestData.VALID_EMAIL_CSL_HENRY);
    }
}
