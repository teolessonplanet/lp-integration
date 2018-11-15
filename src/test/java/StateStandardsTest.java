import com.lessonplanet.pages.StateStandardsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StateStandardsTest extends BaseTest {
    private StateStandardsPage stateStandardsPage;

    @BeforeMethod
    public void beforeMethod() {
        stateStandardsPage = new StateStandardsPage(webDriver);
    }

//    @Test(description = "LP - Regression Tests - Visitor - State Standards - Main Page - lessonp-1102:Page UI")
//    public void testLessonp_1102() {
//        stateStandardsPage.loadPage();
//        stateStandardsPage.loadPage();
//    }
}
