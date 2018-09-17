import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class DirectoryTest extends BaseTest {

    private LpHomePage lpHomePage;
    private LoginPage loginPage;
    private HeaderPage headerPage;
    private DirectoryPage directoryPage;
    private BrowseBySubjectPage browseBySubjectPage;


    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        headerPage = new HeaderPage(webDriver);
        directoryPage = new DirectoryPage(webDriver);
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
    }

    @Test(description = "Visitor - Directory Page - lessonp-1015:Page UI")
    public void testLessonp_1015() {
        lpHomePage.loadPage();
        headerPage.hoverOverResourcesButton();
        headerPage.clickOnBrowseResourceDirectoryButton();

        directoryPage.clickOnHealthSubjectLink();
        checkPageTitleAndPagePath(TestData.HEALTH_PAGE_TITLE, TestData.HEALTH_PAGE_PATH);
        directoryPage.clickOnHealthSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.HEALTH_PAGE_TITLE, TestData.HEALTH_PAGE_PATH);

        directoryPage.clickOnLanguageArtsSubjectLink();
        checkPageTitleAndPagePath(TestData.LANGUAGE_ARTS_PAGE_TITLE, TestData.LANGUAGE_ARTS_PAGE_PATH);
        directoryPage.clickOnLanguageArtsSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.LANGUAGE_ARTS_PAGE_TITLE, TestData.LANGUAGE_ARTS_PAGE_PATH);

        directoryPage.clickOnLanguagesSubjectLink();
        checkPageTitleAndPagePath(TestData.LANGUAGES_PAGE_TITLE, TestData.LANGUAGES_PAGE_PATH);
        directoryPage.clickOnLanguagesSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.LANGUAGES_PAGE_TITLE, TestData.LANGUAGES_PAGE_PATH);

        directoryPage.clickOnMathSubjectLink();
        checkPageTitleAndPagePath(TestData.MATH_PAGE_TITLE, TestData.MATH_PAGE_PATH);
        directoryPage.clickOnMathSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.MATH_PAGE_TITLE, TestData.MATH_PAGE_PATH);

        directoryPage.clickOnPhysicalEducationSubjectLink();
        checkPageTitleAndPagePath(TestData.PHYSICAL_EDUCATION_PAGE_TITLE, TestData.PHYSICAL_EDUCATION_PAGE_PATH);
        directoryPage.clickOnPhysicalEducationSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.PHYSICAL_EDUCATION_PAGE_TITLE, TestData.PHYSICAL_EDUCATION_PAGE_PATH);

        directoryPage.clickOnScienceSubjectLink();
        checkPageTitleAndPagePath(TestData.SCIENCE_PAGE_TITLE, TestData.SCIENCE_PAGE_PATH);
        directoryPage.clickOnScienceSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.SCIENCE_PAGE_TITLE, TestData.SCIENCE_PAGE_PATH);

        directoryPage.clickOnSocialStudiesSubjectLink();
        checkPageTitleAndPagePath(TestData.SOCIAL_STUDIES_PAGE_TITLE, TestData.SOCIAL_STUDIES_PAGE_PATH);
        directoryPage.clickOnSocialStudiesSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.SOCIAL_STUDIES_PAGE_TITLE, TestData.SOCIAL_STUDIES_PAGE_PATH);

        directoryPage.clickOnSpecialEducationSubjectLink();
        checkPageTitleAndPagePath(TestData.SPECIAL_EDUCATION_PAGE_TITLE, TestData.SPECIAL_EDUCATION_PAGE_PATH);
        directoryPage.clickOnSpecialEducationSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.SPECIAL_EDUCATION_PAGE_TITLE, TestData.SPECIAL_EDUCATION_PAGE_PATH);

        directoryPage.clickOnVisualAndPerformingArtsSubjectLink();
        checkPageTitleAndPagePath(TestData.VISUAL_AND_PERFORMING_ARTS_PAGE_TITLE, TestData.VISUAL_AND_PERFORMING_ARTS_PAGE_PATH);
        directoryPage.clickOnVisualAndPerformingArtsSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.VISUAL_AND_PERFORMING_ARTS_PAGE_TITLE, TestData.VISUAL_AND_PERFORMING_ARTS_PAGE_PATH);

        //check each subcategory
        directoryPage.clickOnWellnessAndSafetyLink();
        checkPageTitle(TestData.WELLNESS_AND_SAFETY_PAGE_TITLE);

        directoryPage.clickOnNutritionLink();
        checkPageTitle(TestData.NUTRITION_PAGE_TITLE);

        directoryPage.clickOnGrowthAndDevelopmentLink();
        checkPageTitle(TestData.GROWTH_AND_DEVELOPMENT_PAGE_TITLE);

    }

    private void checkPageTitleAndPagePath(String expectedTitle, String expectedPath) {
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), expectedTitle);
        Assert.assertEquals(browseBySubjectPage.getPath(), expectedPath);
        browseBySubjectPage.goBackOnePage();
    }

    private void checkPageTitle(String expectedTitle) {
        Assert.assertEquals(browseBySubjectPage.getPageTitle(), expectedTitle);
        browseBySubjectPage.goBackOnePage();
    }
}
