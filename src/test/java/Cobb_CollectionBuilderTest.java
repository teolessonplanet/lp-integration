import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_CollectionBuilderTest extends BaseTest {

    private LoginPage loginPage;
    private CollectionBuilderTest collectionBuilderTest;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        collectionBuilderTest = new CollectionBuilderTest();
        initCollectionBuilderTestAndLogin();
    }

    private void initCollectionBuilderTestAndLogin() {
        collectionBuilderTest.initTest(webDriver);
        loginPage.performLogin(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
    }

    @Test(description = "Collection Builder - lessonp-4948: Collection Builder Buttons")
    public void testLessonp_4948() {
        collectionBuilderTest.testCollectionBuilderButtonsAppearance(TestData.VALID_EMAIL_CSL_COBB);
    }

    @Test(description = "Collection Builder - lessonp-4949: Collection Builder Items")
    public void testLessonp_4949() {
        collectionBuilderTest.testCollectionBuilderItemsAppearance(TestData.VALID_EMAIL_CSL_COBB, 10);
    }
}
