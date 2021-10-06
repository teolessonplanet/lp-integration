import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_CollectionBuilderTest extends BaseTest {

    private LoginPage loginPage;
    private User_CollectionBuilderTest user_collectionBuilderTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        user_collectionBuilderTest = new User_CollectionBuilderTest();
        initCollectionBuilderTestAndLogin();
    }

    private void initCollectionBuilderTestAndLogin() {
        user_collectionBuilderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
    }

    @Test(description = "Regular SL - Collection Builder - lessonp-5141: Collection Builder Buttons")
    public void testLessonp_5141() {
        user_collectionBuilderTest.testCollectionBuilderButtonsAppearance(TestData.VALID_EMAIL_RSL_SBCEO);
    }

    @Test(description = "Regular SL - Collection Builder - lessonp-5142: Collection Builder Items")
    public void testLessonp_5142() {
        user_collectionBuilderTest.testCollectionBuilderItemsAppearance(TestData.VALID_EMAIL_RSL_SBCEO, 10);
    }
}
