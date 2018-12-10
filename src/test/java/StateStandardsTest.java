import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class StateStandardsTest extends BaseTest {
    private StateStandardsPage stateStandardsPage;
    private HeaderPage headerPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private SearchStandardsWidget searchStandardsWidget;
    private SearchByStandardsPage searchByStandardsPage;

    private SearchStandardWidgetTest searchStandardWidgetTest;
    private StartYourTenDaysTrialWidgetTest startYourTenDaysTrialWidgetTest;
    private LearnMoreVideoWidgetTest learnMoreVideoWidgetTest;

    @BeforeMethod
    public void beforeMethod() {
        stateStandardsPage = new StateStandardsPage(webDriver);
        headerPage = new HeaderPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        searchStandardsWidget = new SearchStandardsWidget(webDriver);
        searchByStandardsPage = new SearchByStandardsPage(webDriver);
        searchStandardWidgetTest = new SearchStandardWidgetTest(webDriver);
        startYourTenDaysTrialWidgetTest = new StartYourTenDaysTrialWidgetTest(webDriver);
        learnMoreVideoWidgetTest = new LearnMoreVideoWidgetTest(webDriver);
    }

    @Test(description = "LP - Regression Tests - Visitor - State Standards - Main Page - lessonp-1102:Page UI")
    public void testLessonp_1102() {
        stateStandardsPage.loadPage();
        Assert.assertEquals(stateStandardsPage.getPath(), TestData.SEARCH_BY_STANDARD_PAGE_PATH);

        stateStandardsPage.clickOnEnglishLanguageArtsButton();
        Assert.assertEquals(stateStandardsPage.getPath(), TestData.ENGLISH_LANGUAGE_ARTS_PAGE_PATH);
        stateStandardsPage.goBackOnePage();

        stateStandardsPage.clickOnMathematicsButton();
        Assert.assertEquals(stateStandardsPage.getPath(), TestData.MATHEMATICS_PAGE_PATH);
        stateStandardsPage.goBackOnePage();

        stateStandardsPage.clickOnNgssButton();
        Assert.assertEquals(stateStandardsPage.getPath(), TestData.NGSS_PAGE_PATH);
        stateStandardsPage.goBackOnePage();

        searchStandardWidgetTest.testStateStandardWidgetDefaultContent();
        learnMoreVideoWidgetTest.testLearnMoreVideoWidgetIsDisplayed();
        learnMoreVideoWidgetTest.testLearnMoreVideoWidgetIsClickable();
    }

    @Test(description = "LP - Regression Tests - Visitor - State Standards - Main Page - lessonp-1103:Header search bar")
    public void testLessonp_1103() {
        stateStandardsPage.loadPage();
        headerPage.clickOnSearchFilterButton();
        Assert.assertEquals(headerPage.getSearchFilter(), TestData.SEARCH_FILTER_COMMON_CORE_STATE_STANDARDS);
        headerPage.setSearchFilter(TestData.SEARCH_FILTER_REVIEWED_RESOURCES);
        headerPage.typeSearchText(TestData.INVALID_SEARCH_WORD);
        headerPage.clickOnSearchButton();
        Assert.assertTrue(discoverResourcesPage.isSuggestionBlockTextDisplayed());
    }

    @Test(description = "LP - Regression Tests - Visitor - State Standards - Main Page - lessonp-1076:Start your 10 day free trail")
    public void testLessonp_1076() {
        stateStandardsPage.loadPage();
        startYourTenDaysTrialWidgetTest.testStartYourTenDaysTrialWidget();
    }

    @Test(description = "LP - Regression Tests - Visitor - State Standards - Main Page - 1101:Search Standards widget")
    public void testLessonp_1101() {
        stateStandardsPage.loadPage();
        searchStandardWidgetTest.testStateStandardWidgetDefaultContent();

        searchStandardsWidget.clickOnStateDropdown();
        searchStandardsWidget.setStateDropdownOption(TestData.SEARCH_STANDARDS_STANDARD_OPTION_COMMON_CORE);
        searchStandardsWidget.clickOnGradeDropdown();
        searchStandardsWidget.setGradeDropdownOptions(TestData.SEARCH_STANDARD_GRADE_OPTION_2ND);
        Assert.assertTrue(searchStandardsWidget.isSubjectDropdownDisabled());
        searchStandardsWidget.typeKeywordSearch(TestData.VALID_SEARCH_WORD);
        searchStandardsWidget.clickOnSearchButton();
        Assert.assertTrue(searchByStandardsPage.isResultsForDisplayed(TestData.VALID_SEARCH_WORD));

        stateStandardsPage.loadPage();
        searchStandardsWidget.clickOnStateDropdown();
        searchStandardsWidget.setStateDropdownOption(TestData.SEARCH_STANDARDS_STANDARD_OPTION_NGSS);
        searchStandardsWidget.clickOnGradeDropdown();
        searchStandardsWidget.setGradeDropdownOptions(TestData.SEARCH_STANDARD_GRADE_OPTION_2ND);
        Assert.assertTrue(searchStandardsWidget.isSubjectDropdownDisabled());
        searchStandardsWidget.clickOnSearchButton();
        Assert.assertTrue(searchByStandardsPage.isResultsForDisplayed(TestData.SEARCH_STANDARDS_STANDARD_OPTION_NGSS));

        stateStandardsPage.loadPage();
        searchStandardsWidget.clickOnStateDropdown();
        searchStandardsWidget.setStateDropdownOption(TestData.SEARCH_STANDARDS_STANDARD_OPTION_LOUISIANA);
        searchStandardsWidget.clickOnGradeDropdown();
        searchStandardsWidget.setGradeDropdownOptions(TestData.SEARCH_STANDARD_GRADE_OPTION_2ND);
        Assert.assertTrue(searchStandardsWidget.isSubjectDropdownEnabled());
        searchStandardsWidget.clickOnSearchButton();
        Assert.assertTrue(searchByStandardsPage.isResultsForDisplayed(TestData.SEARCH_STANDARDS_STANDARD_OPTION_LOUISIANA));
    }
}
