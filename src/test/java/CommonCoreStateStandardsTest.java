import com.lessonplanet.pages.CommonCorePage;
import com.lessonplanet.pages.StateStandardsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CommonCoreStateStandardsTest extends BaseTest {

    private StateStandardsPage stateStandardsPage;
    private CommonCorePage commonCorePage;
    private SearchStandardWidgetTest searchStandardWidgetTest;
    private StartYourTenDaysTrialWidgetTest startYourTenDaysTrialWidgetTest;
    private LearnMoreVideoWidgetTest learnMoreVideoWidgetTest;

    @BeforeMethod
    public void beforeMethod() {
        stateStandardsPage = new StateStandardsPage(webDriver);
        commonCorePage = new CommonCorePage(webDriver);
        searchStandardWidgetTest = new SearchStandardWidgetTest(webDriver);
        startYourTenDaysTrialWidgetTest = new StartYourTenDaysTrialWidgetTest(webDriver);
        learnMoreVideoWidgetTest = new LearnMoreVideoWidgetTest(webDriver);
    }

    @Test(description = "LP - Regression Tests - Visitor - State Standards - Standard Types - Common Core State Standards - lessonp-1106:English Language Arts page")
    public void testLessonp_1106() {
        stateStandardsPage.loadPage();

        stateStandardsPage.clickOnEnglishLanguageArtsButton();
        String expectedPageHeaderPath = TestData.COMMON_CORE_BREADCRUMB_PATH + TestData.COMMON_CORE_ENGLISH_BREADCRUMB_PATH;
        Assert.assertEquals(commonCorePage.getPageHeaderPathText(), expectedPageHeaderPath);
        Assert.assertEquals(commonCorePage.getPageTitle(), TestData.COMMON_CORE_ENGLISH_BREADCRUMB_PATH);
        Assert.assertTrue(commonCorePage.isBackButtonDisplayed());
        Assert.assertTrue(commonCorePage.isUseFiltersTextDisplayed());

        Assert.assertEquals(commonCorePage.getFirstGradeCategory(), TestData.COMMON_CORE_ENGLISH_STANDARD_KINDERGARTEN_GRADE_5_TEXT);
        Assert.assertEquals(commonCorePage.getSecondGradeCategory(), TestData.COMMON_CORE_ENGLISH_STANDARD_GRADES_6_12_ELA_TEXT);
        Assert.assertEquals(commonCorePage.getThirdGradeCategory(), TestData.COMMON_CORE_ENGLISH_STANDARD_GRADES_6_12_LITERACY_TEXT);

        searchStandardWidgetTest.testSearchStandardWidgetIsDisplayed();
        startYourTenDaysTrialWidgetTest.testStartYourTenDaysTrialWidgetDisplayed();
        learnMoreVideoWidgetTest.testLearnMoreVideoWidgetIsDisplayed();

        commonCorePage.clickOnSubject(TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_BREADCRUMB_PATH);
        expectedPageHeaderPath += TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_BREADCRUMB_PATH;
        Assert.assertEquals(commonCorePage.getPageHeaderPathText(), expectedPageHeaderPath);
        Assert.assertEquals(commonCorePage.getFirstGradeCategory(), TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_INTRODUCTION_TEXT);
        Assert.assertEquals(commonCorePage.getStandardDescription(), TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_DESCRIPTION_TEXT);

        commonCorePage.clickOnSubject(TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_GRADE_11_12_BREADCRUMB_PATH);
        expectedPageHeaderPath += TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_GRADE_11_12_BREADCRUMB_PATH;
        Assert.assertEquals(commonCorePage.getPageHeaderPathText(), expectedPageHeaderPath);

        commonCorePage.clickOnStandardCodeButton(TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_GRADE_11_12_STANDARD_CODE_RST_11_12_1);
        expectedPageHeaderPath += TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_GRADE_11_12_STANDARD_CODE_RST_11_12_1;
        Assert.assertEquals(commonCorePage.getPageHeaderPathText(), expectedPageHeaderPath);
        Assert.assertEquals(commonCorePage.getSeeResourcesButtonText(), TestData.STANDARD_CODE_RST_11_12_1_SEE_RESOURCES_BUTTON_TEXT);

        commonCorePage.clickOnBackButton();
        expectedPageHeaderPath = expectedPageHeaderPath.replaceAll(TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_GRADE_11_12_STANDARD_CODE_RST_11_12_1, "");
        Assert.assertEquals(commonCorePage.getPageHeaderPathText(), expectedPageHeaderPath);

        commonCorePage.clickOnBackButton();
        expectedPageHeaderPath = expectedPageHeaderPath.replaceAll(TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_GRADE_11_12_BREADCRUMB_PATH, "");
        Assert.assertEquals(commonCorePage.getPageHeaderPathText(), expectedPageHeaderPath);
    }

    @Test(description = "LP - Regression Tests - Visitor - State Standards - Standard Types - Common Core State Standards - lessonp-1107:Mathematics page")
    public void testLessonp_1107() {
        stateStandardsPage.loadPage();
        stateStandardsPage.clickOnMathematicsButton();

        String expectedPageHeaderPath = TestData.COMMON_CORE_BREADCRUMB_PATH + TestData.COMMON_CORE_MATHEMATICS_BREADCRUMB_PATH;
        Assert.assertEquals(commonCorePage.getPageHeaderPathText(), expectedPageHeaderPath);
        Assert.assertEquals(commonCorePage.getPageTitle(), TestData.COMMON_CORE_MATHEMATICS_BREADCRUMB_PATH);
        Assert.assertTrue(commonCorePage.isBackButtonDisplayed());
        Assert.assertTrue(commonCorePage.isUseFiltersTextDisplayed());

        searchStandardWidgetTest.testSearchStandardWidgetIsDisplayed();
        startYourTenDaysTrialWidgetTest.testStartYourTenDaysTrialWidgetDisplayed();
        learnMoreVideoWidgetTest.testLearnMoreVideoWidgetIsDisplayed();

        expectedPageHeaderPath += TestData.COMMON_CORE_MATHEMATICS_STANDARDS_FOR_MATHEMATICAL_PRACTICE_BREADCRUMB_PATH;
        commonCorePage.clickOnSubject(TestData.COMMON_CORE_MATHEMATICS_STANDARDS_FOR_MATHEMATICAL_PRACTICE_BREADCRUMB_PATH);
        Assert.assertEquals(commonCorePage.getPageHeaderPathText(), expectedPageHeaderPath);
        Assert.assertEquals(commonCorePage.getFirstGradeCategory(), TestData.COMMON_CORE_MATHEMATICS_STANDARDS_FOR_MATHEMATICAL_PRACTICE_INTRODUCTION_TEXT);

        expectedPageHeaderPath += TestData.COMMON_CORE_MATHEMATICS_STANDARDS_FOR_MATHEMATICAL_PRACTICE_STANDARD_CODE_MP_1;
        commonCorePage.clickOnStandardCodeButton(TestData.COMMON_CORE_MATHEMATICS_STANDARDS_FOR_MATHEMATICAL_PRACTICE_STANDARD_CODE_MP_1);
        Assert.assertEquals(commonCorePage.getPageHeaderPathText(), expectedPageHeaderPath);
        Assert.assertEquals(commonCorePage.getSeeResourcesButtonText(), TestData.STANDARD_CODE_MP_1_SEE_RESOURCES_BUTTON_TEXT);

        commonCorePage.clickOnBackButton();
        expectedPageHeaderPath = expectedPageHeaderPath.replaceAll(TestData.COMMON_CORE_MATHEMATICS_STANDARDS_FOR_MATHEMATICAL_PRACTICE_STANDARD_CODE_MP_1, "");
        Assert.assertEquals(commonCorePage.getPageHeaderPathText(), expectedPageHeaderPath);
    }
}
