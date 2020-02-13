import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_RrpSearchPageTest extends BaseTest {

    private RSL_RrpSearchPageTest rsl_rrpSearchPageTest;

    @BeforeMethod
    private void beforeMethod() {
        rsl_rrpSearchPageTest = new RSL_RrpSearchPageTest();
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-1311:LP Resource Modal Overview")
    public void lessonp_1311() {
        rsl_rrpSearchPageTest.initiTest(webDriver);
        rsl_rrpSearchPageTest.testResourcePageOverview(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-1363:LP Resource Static Page Overview")
    public void lessonp_1363() {
        rsl_rrpSearchPageTest.initiTest(webDriver);
        rsl_rrpSearchPageTest.testResourcePageOverview(TestData.VALID_EMAIL_CSL_HENRY, false);
    }

    @Test(description = "Custom SL - Search Page - RRP Modal - RRP Overview - lessonp-4479:Collection Modal Overview")
    public void lessonp_4497() {
        rsl_rrpSearchPageTest.initiTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionPageOverview(TestData.VALID_EMAIL_CSL_HENRY, true);
    }

    @Test(description = "Custom SL - Search Page - RRP Static - RRP Overview - lessonp-4480:Collection Static Page Overview")
    public void lessonp_4480() {
        rsl_rrpSearchPageTest.initiTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionPageOverview(TestData.VALID_EMAIL_CSL_HENRY, false);
    }
}
