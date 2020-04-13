package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class DirectoryPage extends LpUiBasePage {

    private static final String HEALTH_SUBJECT_LINK = "[class*='panel-default']:not([class*='react-modal']) h4 [href*='/health']";
    private static final String HEALTH_SUBJECT_THUMBNAIL = "[class*='panel-default']:not([class*='react-modal']) [class*='img'][href*='/health']";
    private static final String LANGUAGE_ARTS_SUBJECT_LINK = "h4 [href*='/language-arts']";
    private static final String LANGUAGE_ARTS_SUBJECT_THUMBNAIL = "[class*='img'][href*='/language-arts']";
    private static final String LANGUAGES_SUBJECT_LINK = "h4 [href*='/languages']";
    private static final String LANGUAGES_SUBJECT_THUMBNAIL = "[class*='img'][href*='/languages']";
    private static final String MATH_SUBJECT_LINK = "h4 [href*='/math']";
    private static final String MATH_SUBJECT_THUMBNAIL = "[class*='img'][href*='/math']";
    private static final String PHYSICAL_EDUCATION_SUBJECT_LINK = "h4 [href*='/physical-education']";
    private static final String PHYSICAL_EDUCATION_SUBJECT_THUMBNAIL = "[class*='img'][href*='/physical-education']";
    private static final String SCIENCE_SUBJECT_LINK = "h4 [href*='/science']";
    private static final String SCIENCE_SUBJECT_THUMBNAIL = "[class*='img'][href*='/science']";
    private static final String SOCIAL_STUDIES_SUBJECT_LINK = "h4 [href*='/social-studies']";
    private static final String SOCIAL_STUDIES_SUBJECT_THUMBNAIL = "[class*='img'][href*='/social-studies']";
    private static final String SPECIAL_EDUCATION_SUBJECT_LINK = "h4 [href*='/special-education']";
    private static final String SPECIAL_EDUCATION_SUBJECT_THUMBNAIL = "[class*='img'][href*='/special-education']";
    private static final String VISUAL_AND_PERFORMING_ARTS_SUBJECT_LINK = "h4 [href*='/visual-and-performing-arts']";
    private static final String VISUAL_AND_PERFORMING_ARTS_SUBJECT_THUMBNAIL = "[class*='img'][href*='/visual-and-performing-arts']";
    private static final String SHOW_ALL_BUTTONS = "[class*='open-modal']";

    private static final String WELLNESS_AND_SAFETY_LINK = "[href='/lesson-plans/health-triangle']";
    private static final String SOCIAL_EMOTIONAL_LEARNING_LINK = "li:nth-child(2) a[href='/lesson-plans/mental-emotional-health']";
    private static final String GROWTH_AND_DEVELOPMENT_LINK = "[href='/lesson-plans/growth-and-development']";
    private static final String SEX_EDUCATION_LINK = "[href='/lesson-plans/sex-education']";
    private static final String RESEARCH_LINK = "[href='/lesson-plans/research']";
    private static final String LITERATURE_LINK = "[href='/lesson-plans/literature']";
    private static final String GRAPHIC_ORGANIZER_LINK = "[href='/lesson-plans/graphic-organizer']";
    private static final String GENRE_TYPES_LINK = "[href='/lesson-plans/genre-types']";
    private static final String ENGLISH_LANGUAGE_DEVELOPMENT_LINK = "[href='/lesson-plans/english-language-development']";
    private static final String AMERICAN_SIGN_LANGUAGE_LINK = "[href='/lesson-plans/american-sign-language']";
    private static final String FRENCH_LINK = "[href='/lesson-plans/french']";
    private static final String SPANISH_LINK = "[href='/lesson-plans/spanish']";
    private static final String MEASUREMENT_LINK = "[href='/lesson-plans/measurement']";
    private static final String TEACHING_MATH_LINK = "[href='/lesson-plans/teaching-math']";
    private static final String ALGEBRA_LINK = "[href='/lesson-plans/algebra']";
    private static final String GRAPHING_LINK = "[href='/lesson-plans/graphing']";
    private static final String ANAEROBIC_ACTIVITY_LINK = "[href='/lesson-plans/anaerobic-activity']";
    private static final String WATER_ACTIVITIES_LINK = "[href='/lesson-plans/water-activities']";
    private static final String SPORT_SKILLS_LINK = "[href='/lesson-plans/sports-skills']";
    private static final String NATURAL_SCIENCE_LINK = "[href='/lesson-plans/natural-science']";
    private static final String SCIENTISTS_LINK = "[href='/lesson-plans/scientist']";
    private static final String BIOLOGY_LINK = "[href='/lesson-plans/biology']";
    private static final String APPLIED_SCIENCE_LINK = "[href='/lesson-plans/applied-science']";
    private static final String TWENTY_ONE_CENTURY_LEARNING_SKILLS_LINK = "[href='/lesson-plans/21st-century-learning-skills']";
    private static final String GEOGRAPHY_LINK = "[href='/lesson-plans/geography']";
    private static final String FLAGS_LINK = "[href='/lesson-plans/flags']";
    private static final String HISTORY_LINK = "[href='/lesson-plans/history']";
    private static final String DEVELOPMENT_AND_BEHAVIORAL_DISORDERS_LINK = "[href='/lesson-plans/developmental-and-behavioral-disorders']";
    private static final String PHYSICAL_DISABILITIES_LINK = "[href='/lesson-plans/physical-disabilities']";
    private static final String SPECIAL_NEEDS_TEACHER_RESOURCES_LINK = "[href='/lesson-plans/special-needs-teacher-resources']";
    private static final String ACCOMMODATION_LINK = "[href='/lesson-plans/accommodations']";
    private static final String MUSIC_LINK = "[href='/lesson-plans/music']";
    private static final String VISUAL_ARTS_LINK = "[href='/lesson-plans/visual-arts']";
    private static final String FILM_STUDIES_LINK = "[href='/lesson-plans/film-studies']";
    private static final String DANCE_LINKS = "[href='/lesson-plans/dance']";

    private static final String CARETS = "[class=''] [class*='fa-caret-right']";
    private static final String CATEGORY_AND_SUBCATEGORY_CARDS = "div[class='panel-body']";

    public DirectoryPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.BROWSE_RESOURCE_DIRECTORY_PAGE_PATH);
    }

    public void clickOnHealthSubjectLink() {
        clickElement(HEALTH_SUBJECT_LINK);
    }

    public void clickOnHealthSubjectThumbnail() {
        clickElement(HEALTH_SUBJECT_THUMBNAIL);
    }

    public void clickOnLanguageArtsSubjectLink() {
        clickElement(LANGUAGE_ARTS_SUBJECT_LINK);
    }

    public void clickOnLanguageArtsSubjectThumbnail() {
        clickElement(LANGUAGE_ARTS_SUBJECT_THUMBNAIL);
    }

    public void clickOnLanguagesSubjectLink() {
        clickElement(LANGUAGES_SUBJECT_LINK);
    }

    public void clickOnLanguagesSubjectThumbnail() {
        clickElement(LANGUAGES_SUBJECT_THUMBNAIL);
    }

    public void clickOnMathSubjectLink() {
        clickElement(MATH_SUBJECT_LINK);
    }

    public void clickOnMathSubjectThumbnail() {
        clickElement(MATH_SUBJECT_THUMBNAIL);
    }

    public void clickOnPhysicalEducationSubjectLink() {
        clickElement(PHYSICAL_EDUCATION_SUBJECT_LINK);
    }

    public void clickOnPhysicalEducationSubjectThumbnail() {
        clickElement(PHYSICAL_EDUCATION_SUBJECT_THUMBNAIL);
    }

    public void clickOnScienceSubjectLink() {
        clickElement(SCIENCE_SUBJECT_LINK);
    }

    public void clickOnScienceSubjectThumbnail() {
        clickElement(SCIENCE_SUBJECT_THUMBNAIL);
    }

    public void clickOnSocialStudiesSubjectLink() {
        clickElement(SOCIAL_STUDIES_SUBJECT_LINK);
    }

    public void clickOnSocialStudiesSubjectThumbnail() {
        clickElement(SOCIAL_STUDIES_SUBJECT_THUMBNAIL);
    }

    public void clickOnSpecialEducationSubjectLink() {
        clickElement(SPECIAL_EDUCATION_SUBJECT_LINK);
    }

    public void clickOnSpecialEducationSubjectThumbnail() {
        clickElement(SPECIAL_EDUCATION_SUBJECT_THUMBNAIL);
    }

    public void clickOnVisualAndPerformingArtsSubjectLink() {
        clickElement(VISUAL_AND_PERFORMING_ARTS_SUBJECT_LINK);
    }

    public void clickOnVisualAndPerformingArtsSubjectThumbnail() {
        clickElement(VISUAL_AND_PERFORMING_ARTS_SUBJECT_THUMBNAIL);
    }

    public void clickOnWellnessAndSafetyLink() {
        clickElement(WELLNESS_AND_SAFETY_LINK);
    }

    public void clickOnSocialEmotionalLearningLink() {
        findElements(SOCIAL_EMOTIONAL_LEARNING_LINK).get(0).click();
    }

    public void clickOnGrowthAndDevelopmentLink() {
        clickElement(GROWTH_AND_DEVELOPMENT_LINK);
    }

    public void clickOnSexEducationLink() {
        clickElement(SEX_EDUCATION_LINK);
    }

    public void clickOnResearchLink() {
        clickElement(RESEARCH_LINK);
    }

    public void clickOnLiteratureLink() {
        clickElement(LITERATURE_LINK);
    }

    public void clickOnGraphicOrganizerLink() {
        clickElement(GRAPHIC_ORGANIZER_LINK);
    }

    public void clickOnGenreTypesLink() {
        clickElement(GENRE_TYPES_LINK);
    }

    public void clickOnEnglishLanguageDevelopmentLink() {
        clickElement(ENGLISH_LANGUAGE_DEVELOPMENT_LINK);
    }

    public void clickOnAmericanSignLanguageLink() {
        clickElement(AMERICAN_SIGN_LANGUAGE_LINK);
    }

    public void clickOnFrenchLink() {
        clickElement(FRENCH_LINK);
    }

    public void clickOnSpanishLink() {
        clickElement(SPANISH_LINK);
    }

    public void clickOnMeasurementLink() {
        clickElement(MEASUREMENT_LINK);
    }

    public void clickOnTeachingMathLink() {
        clickElement(TEACHING_MATH_LINK);
    }

    public void clickOnAlgebraLink() {
        clickElement(ALGEBRA_LINK);
    }

    public void clickOnGraphingLink() {
        clickElement(GRAPHING_LINK);
    }

    public void clickOnAnaerobicActivityLink() {
        clickElement(ANAEROBIC_ACTIVITY_LINK);
    }

    public void clickOnDanceFromPyEdLink() {
        clickElement(DANCE_LINKS, 0);
    }

    public void clickOnWaterActivitiesLink() {
        clickElement(WATER_ACTIVITIES_LINK);
    }

    public void clickOnSportSkillsLink() {
        clickElement(SPORT_SKILLS_LINK);
    }

    public void clickOnNaturalScienceLink() {
        clickElement(NATURAL_SCIENCE_LINK);
    }

    public void clickOnScientistsLink() {
        clickElement(SCIENTISTS_LINK);
    }

    public void clickOnBiologyLink() {
        clickElement(BIOLOGY_LINK);
    }

    public void clickOnAppliedScienceLink() {
        clickElement(APPLIED_SCIENCE_LINK);
    }

    public void clickOnTwentyOneCenturyLearningSkillsLink() {
        clickElement(TWENTY_ONE_CENTURY_LEARNING_SKILLS_LINK);
    }

    public void clickOnGeographyLink() {
        clickElement(GEOGRAPHY_LINK);
    }

    public void clickOnFlagsLink() {
        clickElement(FLAGS_LINK);
    }

    public void clickOnHistoryLink() {
        clickElement(HISTORY_LINK);
    }

    public void clickOnDevelopmentAndBehavioralDisordersLink() {
        clickElement(DEVELOPMENT_AND_BEHAVIORAL_DISORDERS_LINK);
    }

    public void clickOnPhysicalDisabilitiesLink() {
        clickElement(PHYSICAL_DISABILITIES_LINK);
    }

    public void clickOnSpecialNeedsTeacherResourcesLink() {
        clickElement(SPECIAL_NEEDS_TEACHER_RESOURCES_LINK);
    }

    public void clickOnAccommodationsLink() {
        clickElement(ACCOMMODATION_LINK);
    }

    public void clickOnMusicLink() {
        clickElement(MUSIC_LINK);
    }

    public void clickOnDanceFromViPerArtsLink() {
        clickElement(DANCE_LINKS, 1);
    }

    public void clickOnVisualArtsLink() {
        clickElement(VISUAL_ARTS_LINK);
    }

    public void clickOnFilmStudiesLink() {
        clickElement(FILM_STUDIES_LINK);
    }

    public String getHealthCategoryAndSubcategoriesText() {
        return getTextForElement(CATEGORY_AND_SUBCATEGORY_CARDS, 0);
    }

    public void clickOnFirstCaretFromHealthCategory() {
        clickElement(CARETS, 0);
    }

    public int countShowAllButtons() {
        return findElements(SHOW_ALL_BUTTONS).size();
    }

    public void clickOnShowAllButtonFromHealthCategory() {
        clickElement(SHOW_ALL_BUTTONS, 0);
    }
}
