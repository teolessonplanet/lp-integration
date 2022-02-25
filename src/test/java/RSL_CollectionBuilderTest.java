import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_CollectionBuilderTest extends BaseTest {

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
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
    }

    @Test(description = "Regular SL - Collection Builder - C2363: Collection Builder Buttons", groups = {"rsl"})
    public void testC2363() {
        user_collectionBuilderTest.testCollectionBuilderButtonsAppearance(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Collection Builder - C2364: Collection Builder Items", groups = {"rsl"})
    public void testC2364() {
        user_collectionBuilderTest.testCollectionBuilderItemsAppearance(TestData.VALID_EMAIL_RSL_SBCEO, 10);
    }
}
