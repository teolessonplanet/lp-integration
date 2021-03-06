import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_CollectionBuilderTest extends BaseTest {

    private LoginPage loginPage;
    private User_CollectionBuilderTest user_collectionBuilderTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_collectionBuilderTest = new User_CollectionBuilderTest();
        initCollectionBuilderTestAndLogin();
    }

    private void initCollectionBuilderTestAndLogin() {
        user_collectionBuilderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
    }

    @Test(description = "Cobb SL - Collection Builder - C2563: Collection Builder Buttons", groups = {"cobb"})
    public void testC2563() {
        user_collectionBuilderTest.testCollectionBuilderButtonsAppearance(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Cobb SL - Collection Builder - C2564: Collection Builder Items", groups = {"cobb"})
    public void testC2564() {
        user_collectionBuilderTest.testCollectionBuilderItemsAppearance(TestData.VALID_EMAIL_CSL_COBB, 10);
    }
}
