import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_CollectionPlayerTest extends BaseTest {
    private User_CollectionPlayerTest collectionPlayerTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        collectionPlayerTest = new User_CollectionPlayerTest();
        collectionPlayerTest.initTest(webDriver);
    }

    @Test(description = "Custom SL - Collection player - C2543: Appearance", groups = {"csl"})
    public void testC2543() {
        collectionPlayerTest.testCollectionPlayerAppearance(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Collection player - C2546: Collection Navigator", groups = {"csl"})
    public void testC2546() {
        collectionPlayerTest.testCollectionNavigator(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Collection player - C2547: Resource Viewer", groups = {"csl"})
    public void testC2547() {
        collectionPlayerTest.testResourceViewer(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Collection player - C2545: Teacher View", groups = {"csl"})
    public void testC25451() {
        collectionPlayerTest.testTeacherView(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Collection player - C2544: Student View", groups = {"csl"})
    public void testC2544() {
        collectionPlayerTest.testStudentView(TestData.VALID_EMAIL_CSL_HENRY);
    }
}
