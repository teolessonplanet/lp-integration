import com.lessonplanet.pages.CommonCorePage;
import com.lessonplanet.pages.StateStandardsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import util.TestData;

@Ignore
@Deprecated
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
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(0), TestData.STATE_STANDARDS_BREADCRUMB_HOME);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(1), TestData.COMMON_CORE_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(2), TestData.COMMON_CORE_ENGLISH_BREADCRUMB);

        Assert.assertEquals(commonCorePage.getPageTitle(), TestData.COMMON_CORE_ENGLISH_BREADCRUMB);
        Assert.assertTrue(commonCorePage.isBackButtonDisplayed());
        Assert.assertTrue(commonCorePage.isBackButtonClickable());
        Assert.assertTrue(commonCorePage.isUseFiltersTextDisplayed());

        Assert.assertEquals(commonCorePage.getFirstGradeCategory(), TestData.COMMON_CORE_ENGLISH_STANDARD_KINDERGARTEN_GRADE_5_TEXT);
        Assert.assertEquals(commonCorePage.getSecondGradeCategory(), TestData.COMMON_CORE_ENGLISH_STANDARD_GRADES_6_12_ELA_TEXT);
        Assert.assertEquals(commonCorePage.getThirdGradeCategory(), TestData.COMMON_CORE_ENGLISH_STANDARD_GRADES_6_12_LITERACY_TEXT);

        searchStandardWidgetTest.testSearchStandardWidgetIsDisplayed();
        startYourTenDaysTrialWidgetTest.testStartYourTenDaysTrialWidgetDisplayed();
        learnMoreVideoWidgetTest.testLearnMoreVideoWidgetIsDisplayed();
        learnMoreVideoWidgetTest.testLearnMoreVideoWidgetIsClickable();

        commonCorePage.clickOnSubject(TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(0), TestData.STATE_STANDARDS_BREADCRUMB_HOME);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(1), TestData.COMMON_CORE_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(2), TestData.COMMON_CORE_ENGLISH_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(3), TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getFirstGradeCategory(), TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_INTRODUCTION_TEXT);
        Assert.assertEquals(commonCorePage.getStandardDescription(), TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_DESCRIPTION_TEXT);

        commonCorePage.clickOnSubject(TestData.COMMON_CORE_GRADE_11_12_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(0), TestData.STATE_STANDARDS_BREADCRUMB_HOME);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(1), TestData.COMMON_CORE_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(2), TestData.COMMON_CORE_ENGLISH_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(3), TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(4), TestData.COMMON_CORE_GRADE_11_12_BREADCRUMB);

        commonCorePage.clickOnStandardCodeButton(TestData.COMMON_CORE_STANDARD_CODE_RST_11_12_1);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(0), TestData.STATE_STANDARDS_BREADCRUMB_HOME);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(1), TestData.COMMON_CORE_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(2), TestData.COMMON_CORE_ENGLISH_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(3), TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(4), TestData.COMMON_CORE_GRADE_11_12_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(5), TestData.COMMON_CORE_STANDARD_CODE_RST_11_12_1);
        Assert.assertTrue(commonCorePage.getSeeResourcesButtonText().contains(TestData.SEE_TEXT));
        Assert.assertTrue(commonCorePage.getSeeResourcesButtonText().contains(TestData.RESOURCES_TEXT));
        Assert.assertTrue(commonCorePage.getSeeResourcesNoOfItems() > TestData.ZERO_RESOURCES_FOUND);

        commonCorePage.clickOnBackButton();
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(0), TestData.STATE_STANDARDS_BREADCRUMB_HOME);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(1), TestData.COMMON_CORE_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(2), TestData.COMMON_CORE_ENGLISH_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(3), TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(4), TestData.COMMON_CORE_GRADE_11_12_BREADCRUMB);

        commonCorePage.clickOnBackButton();
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(0), TestData.STATE_STANDARDS_BREADCRUMB_HOME);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(1), TestData.COMMON_CORE_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(2), TestData.COMMON_CORE_ENGLISH_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(3), TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_BREADCRUMB);
    }

    @Test(description = "LP - Regression Tests - Visitor - State Standards - Standard Types - Common Core State Standards - lessonp-1107:Mathematics page")
    public void testLessonp_1107() {
        stateStandardsPage.loadPage();
        stateStandardsPage.clickOnMathematicsButton();

        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(0), TestData.STATE_STANDARDS_BREADCRUMB_HOME);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(1), TestData.COMMON_CORE_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(2), TestData.COMMON_CORE_MATHEMATICS_BREADCRUMB);

        Assert.assertEquals(commonCorePage.getPageTitle(), TestData.COMMON_CORE_MATHEMATICS_BREADCRUMB);
        Assert.assertTrue(commonCorePage.isBackButtonDisplayed());
        Assert.assertTrue(commonCorePage.isBackButtonClickable());
        Assert.assertTrue(commonCorePage.isUseFiltersTextDisplayed());

        searchStandardWidgetTest.testSearchStandardWidgetIsDisplayed();
        startYourTenDaysTrialWidgetTest.testStartYourTenDaysTrialWidgetDisplayed();
        learnMoreVideoWidgetTest.testLearnMoreVideoWidgetIsDisplayed();
        learnMoreVideoWidgetTest.testLearnMoreVideoWidgetIsClickable();

        commonCorePage.clickOnSubject(TestData.COMMON_CORE_STANDARDS_FOR_MATHEMATICAL_PRACTICE_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(0), TestData.STATE_STANDARDS_BREADCRUMB_HOME);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(1), TestData.COMMON_CORE_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(2), TestData.COMMON_CORE_MATHEMATICS_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(3), TestData.COMMON_CORE_STANDARDS_FOR_MATHEMATICAL_PRACTICE_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getFirstGradeCategory(), TestData.COMMON_CORE_STANDARDS_FOR_MATHEMATICAL_PRACTICE_INTRODUCTION_TEXT);

        commonCorePage.clickOnStandardCodeButton(TestData.COMMON_CORE_STANDARD_CODE_MP_1);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(0), TestData.STATE_STANDARDS_BREADCRUMB_HOME);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(1), TestData.COMMON_CORE_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(2), TestData.COMMON_CORE_MATHEMATICS_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(3), TestData.COMMON_CORE_STANDARDS_FOR_MATHEMATICAL_PRACTICE_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(4), TestData.COMMON_CORE_STANDARD_CODE_MP_1);
        Assert.assertTrue(commonCorePage.getSeeResourcesButtonText().contains(TestData.SEE_TEXT));
        Assert.assertTrue(commonCorePage.getSeeResourcesButtonText().contains(TestData.RESOURCES_TEXT));
        Assert.assertTrue(commonCorePage.getSeeResourcesNoOfItems() > TestData.ZERO_RESOURCES_FOUND);

        commonCorePage.clickOnBackButton();
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(0), TestData.STATE_STANDARDS_BREADCRUMB_HOME);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(1), TestData.COMMON_CORE_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(2), TestData.COMMON_CORE_MATHEMATICS_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(3), TestData.COMMON_CORE_STANDARDS_FOR_MATHEMATICAL_PRACTICE_BREADCRUMB);

        commonCorePage.clickOnBackButton();
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(0), TestData.STATE_STANDARDS_BREADCRUMB_HOME);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(1), TestData.COMMON_CORE_BREADCRUMB);
        Assert.assertEquals(commonCorePage.getPageBreadcrumbText(2), TestData.COMMON_CORE_MATHEMATICS_BREADCRUMB);
    }
}
