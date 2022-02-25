import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_CollectionBuilderTest extends BaseTest {

    private LoginPage loginPage;
    private User_CollectionBuilderTest collectionBuilderTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        collectionBuilderTest = new User_CollectionBuilderTest();
        initCollectionBuilderTestAndLogin();
    }

    private void initCollectionBuilderTestAndLogin() {
        collectionBuilderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
    }

    @Test(description = "Custom SL - Collection Builder - C2477: Collection Builder Buttons", groups = {"csl"})
    public void testC2477() {
        collectionBuilderTest.testCollectionBuilderButtonsAppearance(TestData.VALID_EMAIL_CSL_HENRY);
    }

    @Test(description = "Custom SL - Collection Builder - C2478: Collection Builder Items", groups = {"csl"})
    public void testC2478() {
        collectionBuilderTest.testCollectionBuilderItemsAppearance(TestData.VALID_EMAIL_CSL_HENRY, 10);
    }
}
