import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_CollectionBuilderTest extends BaseTest {

    private LoginPage loginPage;
    private User_CollectionBuilderTest collectionBuilderTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        collectionBuilderTest = new User_CollectionBuilderTest();
        initCollectionBuilderTestAndLogin();
    }

    private void initCollectionBuilderTestAndLogin() {
        collectionBuilderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
    }

    @Test(description = "Custom SL - Collection Builder - lessonp-4948: Collection Builder Buttons")
    public void testLessonp_4948() {
        collectionBuilderTest.testCollectionBuilderButtonsAppearance(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Collection Builder - lessonp-4949: Collection Builder Items")
    public void testLessonp_4949() {
        collectionBuilderTest.testCollectionBuilderItemsAppearance(TestData.VALID_EMAIL_CSL_HENRY, 10);
    }
}
