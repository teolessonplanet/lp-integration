import com.lessonplanet.pages.BrowseBySubjectPage;
import com.lessonplanet.pages.DirectoryPage;
import com.lessonplanet.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class DirectoryCategoriesAndSubcategoriesTest extends BaseTest {

    private LoginPage loginPage;
    private DirectoryPage directoryPage;
    private BrowseBySubjectPage browseBySubjectPage;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        directoryPage = new DirectoryPage(webDriver);
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
    }

    @Test(description = "Visitor - Directory Page - Categories ans subcategories - lessonp-1209:Page UI")
    public void testLessonp_1209() {
//        directoryPage.loadPage();
        directoryPage.loadPage();
        directoryPage.clickOnHealthSubjectLink();
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.HEALTH_PAGE_TITLE);
        Assert.assertEquals(browseBySubjectPage.getPath(), TestData.HEALTH_PAGE_PATH);

        Assert.assertTrue(browseBySubjectPage.isBannerImageDisplayed());




        Assert.assertEquals(browseBySubjectPage.getPageTitle(), TestData.HEALTH_PAGE_TITLE);
    }


}
