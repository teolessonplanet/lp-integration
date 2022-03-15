import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_HomepageTest extends BaseTest {

    private User_HomepageTest user_homepageTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        user_homepageTest= new User_HomepageTest();
        user_homepageTest.initTest(webDriver);
    }

    @Test(description = "Cobb SL - Homepage - lessonp-5295:Discover", groups = {"cobb"})
    public void testLessonp_5295() {
        user_homepageTest.testDiscoverTab(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Cobb SL - Homepage - lessonp-5296:Collect", groups = {"cobb"})
    public void testLessonp_5296() {
        user_homepageTest.testCollectTab(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Cobb SL - Homepage - lessonp-5297:Design", groups = {"cobb"})
    public void testLessonp_5297() {
        user_homepageTest.testDesignTab(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Cobb SL - Homepage - lessonp-5298:Deliver", groups = {"cobb"})
    public void testLessonp_5298() {
        user_homepageTest.testDeliverTab(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Cobb SL - Homepage - lessonp-5286:Parent", groups = {"cobb"})
    public void testLessonp_5286() {
        user_homepageTest.testParentEdition(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Cobb SL - Homepage - lessonp-5300:Educator", groups = {"cobb"})
    public void testLessonp_5300() {
        user_homepageTest.testEducatorSection(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Cobb SL - Homepage - lessonp-5301:School or District", groups = {"cobb"})
    public void testLessonp_5301() {
        user_homepageTest.testSchoolOrDistrictSection(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Cobb SL - Homepage - lessonp-5302:Explore our solutions", groups = {"cobb"})
    public void testLessonp_5302() {
        user_homepageTest.testExploreOurSolution(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Cobb SL - Homepage - lessonp-5288:Educator Edition section", groups = {"cobb"})
    public void testLessonp_5288() {
        user_homepageTest.testEducatorEdition(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Cobb SL - Homepage - lessonp-5289:Learning Explorer section", groups = {"cobb"})
    public void testLessonp_5289() {
        user_homepageTest.testLearningExplorerArea(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Cobb SL - Homepage - lessonp-5290:PD Learning Network section", groups = {"cobb"})
    public void testLessonp_5290() {
        user_homepageTest.testPdLearningArea(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Cobb SL - Homepage - lessonp-5291:What educators and parents are saying: section", groups = {"cobb"})
    public void testLessonp_5291() {
        user_homepageTest.testTestimonials(TestData.VALID_EMAIL_CSL_HENRY);
    }
}
