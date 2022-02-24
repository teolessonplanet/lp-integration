import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_CollectionPlayerTest extends BaseTest {
    private User_CollectionPlayerTest user_collectionPlayerTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        user_collectionPlayerTest = new User_CollectionPlayerTest();
        user_collectionPlayerTest.initTest(webDriver);
    }

    @Test(description = "Regular SL - Collection player - C2425: Appearance", groups = {"rsl"})
    public void testC2425() {
        user_collectionPlayerTest.testCollectionPlayerAppearance(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Collection player - C2426: Collection Navigator", groups = {"rsl"})
    public void testC2426() {
        user_collectionPlayerTest.testCollectionNavigator(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Collection player - C2427: Resource Viewer", groups = {"rsl"})
    public void testC2427() {
        user_collectionPlayerTest.testResourceViewer(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Collection player - C2428: Teacher View", groups = {"rsl"})
    public void testC2428() {
        user_collectionPlayerTest.testTeacherView(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Collection player - C2429: Student View", groups = {"rsl"})
    public void testC2429() {
        user_collectionPlayerTest.testStudentView(TestData.VALID_EMAIL_RSL_SBCEO);
    }
}
