import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_RrpSearchPageTest extends BaseTest {
    private RSL_RrpSearchPageTest rsl_rrpSearchPageTest;
    private CSL_RrpSearchPageTest csl_rrpSearchPageTest;

    @BeforeMethod
    private void beforeMethod() {
        rsl_rrpSearchPageTest = new RSL_RrpSearchPageTest();
        csl_rrpSearchPageTest = new CSL_RrpSearchPageTest();
    }

    @Test(description = "Cobb SL - Search Page - RRP Modal - RRP Overview - lessonp-5445:LP Resource Modal Overview")
    public void testlessonp_5445() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testResourcePageOverview(TestData.VALID_EMAIL_CSL_COBB, true);
    }

    @Test(description = "Cobb SL - Search Page - RRP Static - RRP Overview - lessonp-5454:LP Resource Static Page Overview")
    public void testlessonp_5454() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testResourcePageOverview(TestData.VALID_EMAIL_CSL_COBB, false);
    }

    @Test(description = "Cobb SL - Search Page - RRP Modal - RRP Overview - lessonp-5448:Collection Modal Overview")
    public void testlessonp_5448() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionPageOverview(TestData.VALID_EMAIL_CSL_COBB, true);
    }

    @Test(description = "Cobb SL - Search Page - RRP Static - RRP Overview - lessonp-5457:Collection Static Page Overview")
    public void testlessonp_5457() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionPageOverview(TestData.VALID_EMAIL_CSL_COBB, false);
    }

    @Test(description = "Cobb SL - Search Page - RRP Modal - RRP Overview - lessonp-5446:Site Specific Resource Modal Overview")
    public void testlessonp_5446() {
        csl_rrpSearchPageTest.initTest(webDriver);
        csl_rrpSearchPageTest.testSiteSpecificRrp(true, TestData.VALID_EMAIL_CSL_COBB, TestData.FACET_PROVIDERS_COBB_COUNTRY_SCHOOLS);
    }

    @Test(description = "Cobb SL - Search Page - RRP Static - RRP Overview - lessonp-5455:Site Specific Resource Static Page Overview")
    public void testlessonp_5455() {
        csl_rrpSearchPageTest.initTest(webDriver);
        csl_rrpSearchPageTest.testSiteSpecificRrp(false, TestData.VALID_EMAIL_CSL_COBB, TestData.FACET_PROVIDERS_COBB_COUNTRY_SCHOOLS);
    }

    @Test(description = "Cobb SL - Search Page - RRP Modal - RRP Overview - lessonp-5447:Proprietary Resource Modal Overview")
    public void testlessonp_5447() {
        csl_rrpSearchPageTest.initTest(webDriver);
        csl_rrpSearchPageTest.testProprietaryResource(true, TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Search Page - RRP Static - RRP Overview - lessonp-5456:Proprietary Resource Static Page Overview")
    public void testlessonp_5456() {
        csl_rrpSearchPageTest.initTest(webDriver);
        csl_rrpSearchPageTest.testProprietaryResource(false, TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Search Page - RRP Modal - RRP Overview - lessonp-5942:Folder (HMH/McGraw) Modal Overview")
    public void testlessonp_5942() {
        csl_rrpSearchPageTest.initTest(webDriver);
        csl_rrpSearchPageTest.testFolderHmhMcGraw(true, TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Search Page - RRP Static - RRP Overview - lessonp-5943:Folder (HMH/McGraw) Static Overview")
    public void testlessonp_5943() {
        csl_rrpSearchPageTest.initTest(webDriver);
        csl_rrpSearchPageTest.testFolderHmhMcGraw(false, TestData.VALID_EMAIL_CSL_COBB);
    }
}
