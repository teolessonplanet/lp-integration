import com.lessonplanet.pages.AssignModal;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import util.TestData;

public class User_AssignFolderModalTest extends BaseTest {
    private AssignModal assignModal;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        assignModal = new AssignModal(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    public void testAssignModal(String password) {
        assignModal.waitForModal();

        assignModal.typeAccessKey(password);
        assignModal.clickOnSaveButton();
        Assert.assertEquals(assignModal.getAccessKeyFieldText(), password);

        assignModal.clickOnGoogleClassroomButton();
        assignModal.focusDriverToLastTab();
        assignModal.waitForLinkToLoad();
        Assert.assertTrue(assignModal.getUrl().contains(TestData.GOOGLE_URL));
        assignModal.closeTab();

        assignModal.clickOnCopyButton();
        Assert.assertTrue(assignModal.getCopiedLinkPopoverText().contains(TestData.COPIED_POPOVER_TEXT));

        assignModal.clickOnShowAccessKeyButton();
        Assert.assertEquals(assignModal.getPasswordText(), password);
        assignModal.clickOnHideAccessKeyButton();

        assignModal.clickOnResetAccessKeyLink();
        Assert.assertEquals(assignModal.getAccessKeyFieldText(), "");
        Assert.assertEquals(assignModal.getShareLinkText(), "");
        Assert.assertFalse(assignModal.isGoogleClassroomButtonEnabled());

        assignModal.typeAccessKey(password);
        assignModal.clickOnSaveButton();
        Assert.assertTrue(assignModal.isGoogleClassroomButtonEnabled());
        Assert.assertTrue(assignModal.getShareLinkText().startsWith(TestData.SERVER_URL));
    }
}
