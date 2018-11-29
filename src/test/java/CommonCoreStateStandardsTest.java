import com.lessonplanet.pages.EnglishCommonCorePage;
import com.lessonplanet.pages.StateStandardsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CommonCoreStateStandardsTest extends BaseTest {

    private StateStandardsPage stateStandardsPage;
    private EnglishCommonCorePage englishCommonCorePage;

    @BeforeMethod
    public void beforeMethod() {
        stateStandardsPage = new StateStandardsPage(webDriver);
        englishCommonCorePage = new EnglishCommonCorePage(webDriver);
    }

    @Test(description = "LP - Regression Tests - Visitor - State Standards - Standard Types - Common Core State Standards - lessonp-1106:English Language Arts page")
    public void testLessonp_1106() {
        stateStandardsPage.loadPage();
        stateStandardsPage.clickOnEnglishLanguageArtsButton();

        englishCommonCorePage.getPageHeaderPathText();



//        englishCommonCorePage.loadPage();
        englishCommonCorePage.loadPage();
    }
}
