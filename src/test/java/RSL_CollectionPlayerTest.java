import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_CollectionPlayerTest extends BaseTest {
    private CollectionPlayerTest collectionPlayerTest;

    @BeforeMethod
    public void beforeMethod() {
        collectionPlayerTest = new CollectionPlayerTest();
        collectionPlayerTest.initTest(webDriver);
    }

    @Test(description = "Regular SL - Collection player - lessonp-5088:Appearance")
    public void testLessonp_5129() {
        collectionPlayerTest.testCollectionPlayerAppearance(TestData.VALID_EMAIL_RSL_SBCEO);
    }
}
