import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_SearchTest extends BaseTest {

    private RSL_SearchTest rsl_searchTest;

    @BeforeMethod
    private void beforeMethod() {
        rsl_searchTest = new RSL_SearchTest();
    }

    @Test(description = "Custom SL - Search Page - lessonp-1673:User clicks 'See Collection' footer button")
    public void testLessonp_1673() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testSeeCollection(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Search Page -  lessonp-1672:User clicks 'See Full Review' footer button")
    public void testLessonp_1672() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testGoToResource(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Search Page -  lessonp-1671:User clicks 'Go to Resource' footer button")
    public void testLessonp_1671() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testGoToResource(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Search Page - lessonp-5274:Cards details - LP resource")
    public void testLessonp_5274() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testCardDetailsLpResource(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Search Page - lessonp-5275:Cards details - Collection")
    public void testLessonp_5275() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testCardDetailsCollection(TestData.VALID_EMAIL_CSL_HENRY);
    }
}
