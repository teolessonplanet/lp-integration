import com.lessonplanet.pages.EnglishCommonCorePage;
import com.lessonplanet.pages.StateStandardsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CommonCoreStateStandardsTest extends BaseTest {

    private StateStandardsPage stateStandardsPage;
    private EnglishCommonCorePage englishCommonCorePage;

    private SearchStandardWidgetTest searchStandardWidgetTest;
    private StartYourTenDaysTrialWidgetTest startYourTenDaysTrialWidgetTest;
    private LearnMoreVideoWidgetTest learnMoreVideoWidgetTest;

    @BeforeMethod
    public void beforeMethod() {
        stateStandardsPage = new StateStandardsPage(webDriver);
        englishCommonCorePage = new EnglishCommonCorePage(webDriver);
        searchStandardWidgetTest = new SearchStandardWidgetTest(webDriver);
        startYourTenDaysTrialWidgetTest = new StartYourTenDaysTrialWidgetTest(webDriver);
        learnMoreVideoWidgetTest = new LearnMoreVideoWidgetTest(webDriver);
    }

    @Test(description = "LP - Regression Tests - Visitor - State Standards - Standard Types - Common Core State Standards - lessonp-1106:English Language Arts page")
    public void testLessonp_1106() {
        stateStandardsPage.loadPage();
        stateStandardsPage.clickOnEnglishLanguageArtsButton();

        String expectedPageHeaderPath = TestData.COMMON_CORE_BREADCRUMB_PATH + TestData.COMMON_CORE_ENGLISH_BREADCRUMB_PATH;
        Assert.assertEquals(englishCommonCorePage.getPageHeaderPathText(), expectedPageHeaderPath);
        Assert.assertEquals(englishCommonCorePage.getPageTitle(), TestData.COMMON_CORE_ENGLISH_BREADCRUMB_PATH);
        Assert.assertTrue(englishCommonCorePage.isBackButtonDisplayed());
        Assert.assertTrue(englishCommonCorePage.isUseFiltersTextDisplayed());

        Assert.assertEquals(englishCommonCorePage.getFirstGradeCategory(), TestData.COMMON_CORE_ENGLISH_STANDARD_KINDERGARTEN_GRADE_5_TEXT);
        Assert.assertEquals(englishCommonCorePage.getSecondGradeCategory(), TestData.COMMON_CORE_ENGLISH_STANDARD_GRADES_6_12_ELA_TEXT);
        Assert.assertEquals(englishCommonCorePage.getThirdGradeCategory(), TestData.COMMON_CORE_ENGLISH_STANDARD_GRADES_6_12_LITERACY_TEXT);

        searchStandardWidgetTest.testSearchStandardWidgetIsDisplayed();
        startYourTenDaysTrialWidgetTest.testStartYourTenDaysTrialWidgetDisplayed();
        learnMoreVideoWidgetTest.testLearnMoreVideoWidgetIsDisplayed();

        expectedPageHeaderPath += TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_BREADCRUMB_PATH;
        englishCommonCorePage.clickOnSubject(TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_BREADCRUMB_PATH);
        Assert.assertEquals(englishCommonCorePage.getPageHeaderPathText(), expectedPageHeaderPath);
        Assert.assertEquals(englishCommonCorePage.getFirstGradeCategory(), TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_INTRODUCTION_TEXT);
        Assert.assertEquals(englishCommonCorePage.getStandardDescription(), TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_DESCRIPTION_TEXT);

        expectedPageHeaderPath += TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_GRADE_11_12_BREADCRUMB_PATH;
        englishCommonCorePage.clickOnSubject(TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_BREADCRUMB_PATH);
        Assert.assertEquals(englishCommonCorePage.getPageHeaderPathText(), expectedPageHeaderPath);

        expectedPageHeaderPath += TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_GRADE_11_12_STANDARD_CODE_RST_11_12_1;
        englishCommonCorePage.clickOnStandardCodeButton(TestData.COMMON_CORE_ENGLISH_SCIENCE_AND_TECHNICAL_SUBJECTS_GRADE_11_12_STANDARD_CODE_RST_11_12_1);
        Assert.assertEquals(englishCommonCorePage.getPageHeaderPathText(), expectedPageHeaderPath);
        Assert.assertEquals(englishCommonCorePage.getSeeResourcesButtonText(),TestData.STANDARD_CODE_RST_11_12_1_SEE_RESOURCES_BUTTON_TEXT);

        englishCommonCorePage.clickOnSeeResourcesButton();
        //TODO: fasfasfasf

//        englishCommonCorePage.clicOn

//        englishCommonCoreP


//        englishCommonCorePage.loadPage();
        englishCommonCorePage.loadPage();
    }
}
