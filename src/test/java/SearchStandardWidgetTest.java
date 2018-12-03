import com.lessonplanet.pages.SearchStandardsWidget;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.TestData;

public class SearchStandardWidgetTest {

    private SearchStandardsWidget searchStandardsWidget;

    public SearchStandardWidgetTest(WebDriver webDriver) {
        searchStandardsWidget = new SearchStandardsWidget(webDriver);
    }

    public void testStateStandardWidgetDefaultContent() {
        Assert.assertEquals(searchStandardsWidget.getSearchStandardsTitleText(), TestData.SEARCH_STANDARDS_TITLE_TEXT);
        Assert.assertEquals(searchStandardsWidget.getStateLabelText(), TestData.STATE_LABEL_TEXT);
        Assert.assertEquals(searchStandardsWidget.getStateDropdownText(), TestData.SEARCH_STANDARDS_STANDARD_OPTION_COMMON_CORE);
        Assert.assertEquals(searchStandardsWidget.getAllStates(), TestData.ALL_STATES_TEXT);
        Assert.assertEquals(searchStandardsWidget.getSubjectLabelText(), TestData.SUBJECT_LABEL_TEXT);
        Assert.assertEquals(searchStandardsWidget.getSubjectDropdownText(), TestData.SELECT_SUBJECT_TEXT);
        Assert.assertEquals(searchStandardsWidget.getAllSubjects(), TestData.ALL_SUBJECTS_TEXT);
        Assert.assertEquals(searchStandardsWidget.getGradeLabelText(), TestData.GRADE_LABEL_TEXT);
        Assert.assertEquals(searchStandardsWidget.getGradeDropdownText(), TestData.SELECT_GRADE_TEXT);
        Assert.assertEquals(searchStandardsWidget.getAllGrades(), TestData.ALL_GRADES_TEXT);
        Assert.assertEquals(searchStandardsWidget.getKeywordLabelText(), TestData.KEYWORD_LABEL_TEXT);
        Assert.assertEquals(searchStandardsWidget.getKeywordTextboxText(), TestData.LP_HOME_PAGE_PATH);
        Assert.assertEquals(searchStandardsWidget.getSearchButtonText(), TestData.SEARCH_BUTTON_TEXT);
    }

    public void testSearchStandardWidgetIsDisplayed() {
        Assert.assertTrue(searchStandardsWidget.getSearchStandardsTitleText().equals(TestData.SEARCH_STANDARDS_TITLE_TEXT));
    }


}
