import com.lessonplanet.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_SLTest extends BaseTest {
    private RSL_SearchTest rsl_searchTest;
    private CSL_SearchTest csl_searchTest;
    private SearchTest searchTest;
    private LoginPage loginPage;
    private RSL_CalendarPageTest rsl_calendarPageTest;
    private EditCollectionTest editCollectionTest;

    @BeforeMethod
    public void beforeMethod() {
        rsl_searchTest = new RSL_SearchTest();
        csl_searchTest = new CSL_SearchTest();
        searchTest = new SearchTest();
        loginPage = new LoginPage(webDriver);
        rsl_calendarPageTest = new RSL_CalendarPageTest();
        editCollectionTest = new EditCollectionTest();
    }

    protected void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Search Page - lessonp-5918: User clicks 'See Collection' footer button")
    public void testLessonp_5918() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testSeeCollection(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Search Page -  lessonp-5919: User clicks 'Go to Resource' footer button")
    public void testLessonp_5919() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testGoToResource(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Search Page -  lessonp-5920: User clicks 'See Full Review' footer button")
    public void testLessonp_5920() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testGoToResource(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Search Page -  lessonp-5940: User clicks 'Open Folder' footer button")
    public void testLessonp_5940() {
        csl_searchTest.initTest(webDriver);
        csl_searchTest.loginAndGetFolderResources(TestData.VALID_EMAIL_CSL_COBB);
        csl_searchTest.testOpenFolderButton();
    }

    @Test(description = "Search Page -  lessonp-5941: User clicks 'Folder Details' footer button")
    public void testLessonp_5941() {
        csl_searchTest.initTest(webDriver);
        csl_searchTest.loginAndGetFolderResources(TestData.VALID_EMAIL_CSL_COBB);
        csl_searchTest.testFolderDetailsButton();
    }

    @Test(description = "Search Page - lessonp-5944: Cards details - Folder: HMH/McGraw Hill")
    public void testLessonp_5944() {
        csl_searchTest.initTest(webDriver);
        csl_searchTest.loginAndGetFolderResources(TestData.VALID_EMAIL_CSL_COBB);
        csl_searchTest.testCardDetailsFolder();
    }

    @Test(description = "Search Page - lessonp-5916: Cards details - LP resource")
    public void testLessonp_5916() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testCardDetailsLpResource(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Search Page - lessonp-5917: Cards details - Collection")
    public void testLessonp_5917() {
        rsl_searchTest.initTest(webDriver);
        rsl_searchTest.testCardDetailsCollection(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Search Page - lessonp-5999: Keyword search")
    public void testLessonp_5999() {
        searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        searchTest.testKeywordSearch(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Search Page - lessonp-6000: Keywordless search")
    public void testLessonp_6000() {
        searchTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        searchTest.testKeywordlessSearch(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Calendar page - lessonp-5514:Buttons/Links")
    public void testLessonp_5514() {
        rsl_calendarPageTest.initTest(webDriver);
        rsl_calendarPageTest.testCurriculumCalendarPage(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Edit Collection - lessonp-5897: Edit Collection Modal Appearance")
    public void testLessonp_5897() {
        editCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        editCollectionTest.testEditFolderAppearance(TestData.VALID_EMAIL_CSL_COBB, false, TestData.NEW_FOLDER_NAME);
    }

    @Test(description = "Edit Collection - lessonp-5898: Edit Collection Static Page Appearance")
    public void testLessonp_5898() {
        editCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        editCollectionTest.testEditFolderAppearance(TestData.VALID_EMAIL_CSL_COBB, true, TestData.NEW_FOLDER_NAME);
    }

    @Test(description = "Edit Collection - lessonp-5899: Publish. Republish")
    public void testLessonp_5899() {
        editCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        editCollectionTest.testPublishFromEditFolder(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Edit Collection - lessonp-5900: Edit Collection Buttons")
    public void testLessonp_5900() {
        editCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        editCollectionTest.testEditFolderButtons(TestData.VALID_EMAIL_CSL_COBB, TestData.COPIED_FOLDER_NAME);
    }

    @Test(description = "Edit Collection - lessonp-5901: Item Options")
    public void testLessonp_5901() {
        editCollectionTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        editCollectionTest.testItemOptions();
    }
}
