import com.lessonplanet.pages.LearnMoreVideoWidget;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LearnMoreVideoWidgetTest {

    private LearnMoreVideoWidget learnMoreVideoWidget;

    public LearnMoreVideoWidgetTest(WebDriver driver) {
        learnMoreVideoWidget = new LearnMoreVideoWidget(driver);
    }

    public void testLearnMoreVideoWidgetIsDisplayed() {
        Assert.assertTrue(learnMoreVideoWidget.isVideoPlayerClickable());
    }
}
