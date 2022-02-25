import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_RrpSearchPageTest extends BaseTest {
    private RSL_RrpSearchPageTest rsl_rrpSearchPageTest;
    private CSL_RrpSearchPageTest csl_rrpSearchPageTest;

    @BeforeMethod(alwaysRun = true)
    private void beforeMethod() {
        rsl_rrpSearchPageTest = new RSL_RrpSearchPageTest();
        csl_rrpSearchPageTest = new CSL_RrpSearchPageTest();
    }

    @Test(description = "Cobb SL - RRP Search - RRP Modal - RRP Overview - C2565:LP Resource Modal Overview", groups = {"cobb"})
    public void testC2565() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testResourcePageOverview(TestData.VALID_EMAIL_CSL_COBB, true);
    }

    @Test(description = "Cobb SL - RRP Search - RRP Static - RRP Overview - C2570:LP Resource Static Page Overview", groups = {"cobb"})
    public void testC2570() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testResourcePageOverview(TestData.VALID_EMAIL_CSL_COBB, false);
    }

    @Test(description = "Cobb SL - RRP Search - RRP Modal - RRP Overview - C2566:Collection Modal Overview", groups = {"cobb"})
    public void testC2566() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionPageOverview(TestData.VALID_EMAIL_CSL_COBB, true);
    }

    @Test(description = "Cobb SL - RRP Search - RRP Static - RRP Overview - C2571:Collection Static Page Overview", groups = {"cobb"})
    public void testC2571() {
        rsl_rrpSearchPageTest.initTest(webDriver);
        rsl_rrpSearchPageTest.testCollectionPageOverview(TestData.VALID_EMAIL_CSL_COBB, false);
    }

    @Test(description = "Cobb SL - RRP Search - RRP Modal - RRP Overview - C2567:Site Specific Resource Modal Overview", groups = {"cobb"})
    public void testC2567() {
        csl_rrpSearchPageTest.initTest(webDriver);
        csl_rrpSearchPageTest.testSiteSpecificRrp(true, TestData.VALID_EMAIL_CSL_COBB, TestData.FACET_PROVIDERS_COBB_COUNTRY_SCHOOLS);
    }

    @Test(description = "Cobb SL - RRP Search - RRP Static - RRP Overview - C2572:Site Specific Resource Static Page Overview", groups = {"cobb"})
    public void testC2572() {
        csl_rrpSearchPageTest.initTest(webDriver);
        csl_rrpSearchPageTest.testSiteSpecificRrp(false, TestData.VALID_EMAIL_CSL_COBB, TestData.FACET_PROVIDERS_COBB_COUNTRY_SCHOOLS);
    }

    @Test(description = "Cobb SL - RRP Search - RRP Modal - RRP Overview - C2568:Proprietary Resource Modal Overview", groups = {"cobb"})
    public void testC2568() {
        csl_rrpSearchPageTest.initTest(webDriver);
        csl_rrpSearchPageTest.testProprietaryResource(true, TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - RRP Search - RRP Static - RRP Overview -C2573:Proprietary Resource Static Page Overview", groups = {"cobb"})
    public void testC2573() {
        csl_rrpSearchPageTest.initTest(webDriver);
        csl_rrpSearchPageTest.testProprietaryResource(false, TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - RRP Search - RRP Modal - RRP Overview - C2568:Folder (HMH/McGraw) Modal Overview", groups = {"cobb"})
    public void testC2569() {
        csl_rrpSearchPageTest.initTest(webDriver);
        csl_rrpSearchPageTest.testFolderHmhMcGraw(true, TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - RRP Search - RRP Static - RRP Overview - C2574:Folder (HMH/McGraw) Static Overview", groups = {"cobb"})
    public void testC2574() {
        csl_rrpSearchPageTest.initTest(webDriver);
        csl_rrpSearchPageTest.testFolderHmhMcGraw(false, TestData.VALID_EMAIL_CSL_COBB);
    }
}
