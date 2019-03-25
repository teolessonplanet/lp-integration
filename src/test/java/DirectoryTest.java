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
    private CategoryModal categoryModal;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        headerPage = new HeaderPage(webDriver);
        directoryPage = new DirectoryPage(webDriver);
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
        categoryModal = new CategoryModal(webDriver);
    }

    @Test(description = "Visitor - Directory Page - lessonp-1015:Page UI")
    public void testLessonp_1015() {
        lpHomePage.loadPage();
        testPageUi();
    }

    @Test(description = "Freemium - Directory Page - lessonp-1035:Page UI")
    public void testLessonp_1035() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testPageUi();
    }

    @Test(description = "Active user - Directory Page - lessonp-1040:Page UI")
    public void testLessonp_1040() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testPageUi();
    }

    @Test(description = "Freemium - Directory Page - lessonp-1330:Tumbnails")
    public void testLessonp_1030() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testThumbnails();
    }

    @Test(description = "Active user - Directory Page - lessonp-1041:Tumbnails")
    public void testLessonp_1041() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testThumbnails();
    }

    @Test(description = "Freemium - Directory Page - lessonp-1331:Links")
    public void testLessonp_1331() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testLinks();
    }

    @Test(description = "Active user - Directory Page - lessonp-1042:Links")
    public void testLessonp_1042() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testLinks();
    }

    @Test(description = "Freemium - Directory Page - lessonp-1332:Show All button")
    public void testLessonp_1332() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testShowAllButton();
    }

    @Test(description = "Active user - Directory Page - lessonp-1043:Show All button")

    public void testLessonp_1043() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testShowAllButton();
    }

    @Test(description = "Visitor - Directory Page - lessonp-1018:Categories modal")
    public void testLessonp_1018() {
        testCategoriesModal();
    }

    @Test(description = "Freemium - Directory Page - lessonp-1039:Categories modal")
    public void testLessonp_1039() {
        loginPage.performLogin(TestData.VALID_EMAIL_FREEMIUM, TestData.VALID_PASSWORD);
        testCategoriesModal();
    }

    @Test(description = "Active user - Directory Page - lessonp-1044:Categories modal")
    public void testLessonp_1044() {
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        testCategoriesModal();
    }

    private void testPageUi() {
        headerPage.hoverOverResourcesButton();
        headerPage.clickOnBrowseResourceDirectoryButton();

        directoryPage.clickOnHealthSubjectLink();
        checkPageTitleAndPagePath(TestData.HEALTH_PAGE_TITLE, TestData.HEALTH_PAGE_PATH);

        directoryPage.clickOnLanguageArtsSubjectLink();
        checkPageTitleAndPagePath(TestData.LANGUAGE_ARTS_PAGE_TITLE, TestData.LANGUAGE_ARTS_PAGE_PATH);

        directoryPage.clickOnLanguagesSubjectLink();
        checkPageTitleAndPagePath(TestData.LANGUAGES_PAGE_TITLE, TestData.LANGUAGES_PAGE_PATH);

        directoryPage.clickOnMathSubjectLink();
        checkPageTitleAndPagePath(TestData.MATH_PAGE_TITLE, TestData.MATH_PAGE_PATH);

        directoryPage.clickOnPhysicalEducationSubjectLink();
        checkPageTitleAndPagePath(TestData.PHYSICAL_EDUCATION_PAGE_TITLE, TestData.PHYSICAL_EDUCATION_PAGE_PATH);

        directoryPage.clickOnScienceSubjectLink();
        checkPageTitleAndPagePath(TestData.SCIENCE_PAGE_TITLE, TestData.SCIENCE_PAGE_PATH);

        directoryPage.clickOnSocialStudiesSubjectLink();
        checkPageTitleAndPagePath(TestData.SOCIAL_STUDIES_PAGE_TITLE, TestData.SOCIAL_STUDIES_PAGE_PATH);

        directoryPage.clickOnSpecialEducationSubjectLink();
        checkPageTitleAndPagePath(TestData.SPECIAL_EDUCATION_PAGE_TITLE, TestData.SPECIAL_EDUCATION_PAGE_PATH);

        directoryPage.clickOnVisualAndPerformingArtsSubjectLink();
        checkPageTitleAndPagePath(TestData.VISUAL_AND_PERFORMING_ARTS_PAGE_TITLE, TestData.VISUAL_AND_PERFORMING_ARTS_PAGE_PATH);

        //Click the carets displayed in front of the categories title-links
        final String healthCategoryAndSubcategoriesText = directoryPage.getHealthCategoryAndSubcategoriesText();
        directoryPage.clickOnFirstCaretFromHealthCategory();
        Assert.assertEquals(directoryPage.getHealthCategoryAndSubcategoriesText(), healthCategoryAndSubcategoriesText);
    }

    private void testThumbnails() {
        directoryPage.loadPage();

        directoryPage.clickOnHealthSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.HEALTH_PAGE_TITLE, TestData.HEALTH_PAGE_PATH);

        directoryPage.clickOnLanguageArtsSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.LANGUAGE_ARTS_PAGE_TITLE, TestData.LANGUAGE_ARTS_PAGE_PATH);

        directoryPage.clickOnLanguagesSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.LANGUAGES_PAGE_TITLE, TestData.LANGUAGES_PAGE_PATH);

        directoryPage.clickOnMathSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.MATH_PAGE_TITLE, TestData.MATH_PAGE_PATH);

        directoryPage.clickOnPhysicalEducationSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.PHYSICAL_EDUCATION_PAGE_TITLE, TestData.PHYSICAL_EDUCATION_PAGE_PATH);

        directoryPage.clickOnScienceSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.SCIENCE_PAGE_TITLE, TestData.SCIENCE_PAGE_PATH);

        directoryPage.clickOnSocialStudiesSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.SOCIAL_STUDIES_PAGE_TITLE, TestData.SOCIAL_STUDIES_PAGE_PATH);

        directoryPage.clickOnSpecialEducationSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.SPECIAL_EDUCATION_PAGE_TITLE, TestData.SPECIAL_EDUCATION_PAGE_PATH);

        directoryPage.clickOnVisualAndPerformingArtsSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.VISUAL_AND_PERFORMING_ARTS_PAGE_TITLE, TestData.VISUAL_AND_PERFORMING_ARTS_PAGE_PATH);
    }

    private void testLinks() {
        directoryPage.loadPage();

        directoryPage.clickOnWellnessAndSafetyLink();
        checkPageTitle(TestData.WELLNESS_AND_SAFETY_PAGE_TITLE);

        directoryPage.clickOnNutritionLink();
        checkPageTitle(TestData.NUTRITION_PAGE_TITLE);

        directoryPage.clickOnGrowthAndDevelopmentLink();
        checkPageTitle(TestData.GROWTH_AND_DEVELOPMENT_PAGE_TITLE);

        directoryPage.clickOnSexEducationLink();
        checkPageTitle(TestData.SEX_EDUCATION_PAGE_TITLE);

        directoryPage.clickOnResearchLink();
        checkPageTitle(TestData.RESEARCH_PAGE_TITLE);

        directoryPage.clickOnLiteratureLink();
        checkPageTitle(TestData.LITERATURE_PAGE_TITLE);

        directoryPage.clickOnGraphicOrganizerLink();
        checkPageTitle(TestData.GRAPHIC_ORGANIZER_PAGE_TITLE);

        directoryPage.clickOnGenreTypesLink();
        checkPageTitle(TestData.GENRE_TYPES_PAGE_TITLE);

        directoryPage.clickOnEnglishLanguageDevelopmentLink();
        checkPageTitle(TestData.ENGLISH_LANGUAGE_DEVELOPMENT_PAGE_TITLE);

        directoryPage.clickOnAmericanSignLanguageLink();
        checkPageTitle(TestData.AMERICAN_SIGN_LANGUAGE_PAGE_TITLE);

        directoryPage.clickOnFrenchLink();
        checkPageTitle(TestData.FRENCH_PAGE_TITLE);

        directoryPage.clickOnSpanishLink();
        checkPageTitle(TestData.SPANISH_PAGE_TITLE);

        directoryPage.clickOnMeasurementLink();
        checkPageTitle(TestData.MEASUREMENT_PAGE_TITLE);

        directoryPage.clickOnTeachingMathLink();
        checkPageTitle(TestData.TEACHING_MATH_PAGE_TITLE);

        directoryPage.clickOnAlgebraLink();
        checkPageTitle(TestData.ALGEBRA_PAGE_TITLE);

        directoryPage.clickOnGraphingLink();
        checkPageTitle(TestData.GRAPHING_PAGE_TITLE);

        directoryPage.clickOnAnaerobicActivityLink();
        checkPageTitle(TestData.ANAEROBIC_ACTIVITY_PAGE_TITLE);

        directoryPage.clickOnDanceFromPyEdLink();
        checkPageTitle(TestData.DANCE_PAGE_TITLES);

        directoryPage.clickOnWaterActivitiesLink();
        checkPageTitle(TestData.WATER_ACTIVITIES_PAGE_TITLE);

        directoryPage.clickOnSportSkillsLink();
        checkPageTitle(TestData.SPORT_SKILLS_PAGE_TITLE);

        directoryPage.clickOnNaturalScienceLink();
        checkPageTitle(TestData.NATURAL_SCIENCE_PAGE_TITLE);

        directoryPage.clickOnScientistsLink();
        checkPageTitle(TestData.SCIENTISTS_PAGE_TITLE);

        directoryPage.clickOnBiologyLink();
        checkPageTitle(TestData.BIOLOGY_PAGE_TITLE);

        directoryPage.clickOnAppliedScienceLink();
        checkPageTitle(TestData.APPLIED_SCIENCE_PAGE_TITLE);

        directoryPage.clickOnTwentyOneCenturyLearningSkillsLink();
        checkPageTitle(TestData.TWENTY_ONE_CENTURY_LEARNING_SKILLS_PAGE_TITLE);

        directoryPage.clickOnGeographyLink();
        checkPageTitle(TestData.GEOGRAPHY_PAGE_TITLE);

        directoryPage.clickOnFlagsLink();
        checkPageTitle(TestData.FLAGS_PAGE_TITLE);

        directoryPage.clickOnHistoryLink();
        checkPageTitle(TestData.HISTORY_PAGE_TITLE);

        directoryPage.clickOnDevelopmentAndBehavioralDisordersLink();
        checkPageTitle(TestData.DEVELOPMENT_AND_BEHAVIORAL_DISORDERS_PAGE_TITLE);

        directoryPage.clickOnPhysicalDisabilitiesLink();
        checkPageTitle(TestData.PHYSICAL_DISABILITIES_PAGE_TITLE);

        directoryPage.clickOnSpecialNeedsTeacherResourcesLink();
        checkPageTitle(TestData.SPECIAL_NEEDS_TEACHER_RESOURCES_PAGE_TITLE);

        directoryPage.clickOnAccommodationsLink();
        checkPageTitle(TestData.ACCOMMODATION_PAGE_TITLE);

        directoryPage.clickOnMusicLink();
        checkPageTitle(TestData.MUSIC_PAGE_TITLE);

        directoryPage.clickOnDanceFromViPerArtsLink();
        checkPageTitle(TestData.DANCE_PAGE_TITLES);

        directoryPage.clickOnVisualArtsLink();
        checkPageTitle(TestData.VISUAL_ARTS_PAGE_TITLE);

        directoryPage.clickOnFilmStudiesLink();
        checkPageTitle(TestData.FILM_STUDIES_PAGE_TITLE);
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

    private void testShowAllButton() {
        directoryPage.loadPage();
        Assert.assertEquals(directoryPage.countShowAllButtons(), TestData.DIRECTORY_CATEGORIES_COUNTER);
        directoryPage.clickOnShowAllButtonFromHealthCategory();
        Assert.assertEquals(categoryModal.getModalTitle(), TestData.HEALTH_CATEGORY_MODAL_TITLE);
        categoryModal.clickOnCloseModalButton();
    }

    private void testCategoriesModal() {
        testShowAllButton();

        directoryPage.clickOnHealthSubjectLink();
        checkPageTitleAndPagePath(TestData.HEALTH_PAGE_TITLE, TestData.HEALTH_PAGE_PATH);

        directoryPage.clickOnHealthSubjectThumbnail();
        checkPageTitleAndPagePath(TestData.HEALTH_PAGE_TITLE, TestData.HEALTH_PAGE_PATH);
        directoryPage.clickOnShowAllButtonFromHealthCategory();
        Assert.assertEquals(categoryModal.getSubcategoriesAsText(), TestData.HEALTH_CATEGORY_MODAL_DEFAULT_TEXT);
        categoryModal.clickOnFirstCaret();
        Assert.assertEquals(categoryModal.getSubcategoriesAsText(), TestData.HEALTH_CATEGORY_MODAL_FIRST_CARET_EXPANDED_TEXT);
        categoryModal.clickOnFirstCaret();
        Assert.assertEquals(categoryModal.getSubcategoriesAsText(), TestData.HEALTH_CATEGORY_MODAL_DEFAULT_TEXT);
        categoryModal.clickOnSecondCaret();
        Assert.assertEquals(categoryModal.getSubcategoriesAsText(), TestData.HEALTH_CATEGORY_MODAL_SECOND_CARET_EXPANDED_TEXT);
        categoryModal.clickOnSecondCaret();
        Assert.assertEquals(categoryModal.getSubcategoriesAsText(), TestData.HEALTH_CATEGORY_MODAL_DEFAULT_TEXT);
    }
}
