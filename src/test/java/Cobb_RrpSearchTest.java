import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_RrpSearchTest extends BaseTest {
    private RSL_RrpSearchTest rsl_rrpSearchTest;
    private CSL_RrpSearchTest csl_rrpSearchTest;

    @BeforeMethod(alwaysRun = true)
    private void beforeMethod() {
        rsl_rrpSearchTest = new RSL_RrpSearchTest();
        csl_rrpSearchTest = new CSL_RrpSearchTest();
    }

    @Test(description = "Cobb SL - RRP Search - RRP Modal - RRP Overview - C2565:LP Resource Modal Overview", groups = {"cobb"})
    public void testC2565() {
        rsl_rrpSearchTest.initTest(webDriver);
        rsl_rrpSearchTest.testResourcePageOverview(TestData.VALID_EMAIL_CSL_COBB, true);
    }

    @Test(description = "Cobb SL - RRP Search - RRP Static - RRP Overview - C2570:LP Resource Static Page Overview", groups = {"cobb"})
    public void testC2570() {
        rsl_rrpSearchTest.initTest(webDriver);
        rsl_rrpSearchTest.testResourcePageOverview(TestData.VALID_EMAIL_CSL_COBB, false);
    }

    @Test(description = "Cobb SL - RRP Search - RRP Modal - RRP Overview - C2566:Collection Modal Overview", groups = {"cobb"})
    public void testC2566() {
        rsl_rrpSearchTest.initTest(webDriver);
        rsl_rrpSearchTest.testCollectionPageOverview(TestData.VALID_EMAIL_CSL_COBB, true);
    }

    @Test(description = "Cobb SL - RRP Search - RRP Static - RRP Overview - C2571:Collection Static Page Overview", groups = {"cobb"})
    public void testC2571() {
        rsl_rrpSearchTest.initTest(webDriver);
        rsl_rrpSearchTest.testCollectionPageOverview(TestData.VALID_EMAIL_CSL_COBB, false);
    }

    @Test(description = "Cobb SL - RRP Search - RRP Modal - RRP Overview - C2567:Site Specific Resource Modal Overview", groups = {"cobb"})
    public void testC2567() {
        csl_rrpSearchTest.initTest(webDriver);
        csl_rrpSearchTest.testSiteSpecificRrp(true, TestData.VALID_EMAIL_CSL_COBB, TestData.FACET_PROVIDERS_COBB_COUNTRY_SCHOOLS);
    }

    @Test(description = "Cobb SL - RRP Search - RRP Static - RRP Overview - C2572:Site Specific Resource Static Page Overview", groups = {"cobb"})
    public void testC2572() {
        csl_rrpSearchTest.initTest(webDriver);
        csl_rrpSearchTest.testSiteSpecificRrp(false, TestData.VALID_EMAIL_CSL_COBB, TestData.FACET_PROVIDERS_COBB_COUNTRY_SCHOOLS);
    }

    @Test(description = "Cobb SL - RRP Search - RRP Modal - RRP Overview - C2568:Proprietary Resource Modal Overview", groups = {"cobb"})
    public void testC2568() {
        csl_rrpSearchTest.initTest(webDriver);
        csl_rrpSearchTest.testProprietaryResource(true, TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - RRP Search - RRP Static - RRP Overview -C2573:Proprietary Resource Static Page Overview", groups = {"cobb"})
    public void testC2573() {
        csl_rrpSearchTest.initTest(webDriver);
        csl_rrpSearchTest.testProprietaryResource(false, TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - RRP Search - RRP Modal - RRP Overview - C2568:Folder (HMH/McGraw) Modal Overview", groups = {"cobb"})
    public void testC2569() {
        csl_rrpSearchTest.initTest(webDriver);
        csl_rrpSearchTest.testFolderHmhMcGraw(true, TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - RRP Search - RRP Static - RRP Overview - C2574:Folder (HMH/McGraw) Static Overview", groups = {"cobb"})
    public void testC2574() {
        csl_rrpSearchTest.initTest(webDriver);
        csl_rrpSearchTest.testFolderHmhMcGraw(false, TestData.VALID_EMAIL_CSL_COBB);
    }
}
