package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class DirectoryPage extends LpUiBasePage {

    private static final String HEALTH_SUBJECT_LINK = "h4 [href*='/health']";
    private static final String LANGUAGE_ARTS_SUBJECT_LINK = "h4 [href*='/language-arts']";
    private static final String LANGUAGES_SUBJECT_LINK = "h4 [href*='/languages']";
    private static final String MATH_SUBJECT_LINK = "h4 [href*='/math']";
    private static final String PHYSICAL_EDUCATION_SUBJECT_LINK = "h4 [href*='/physical-education']";
    private static final String SCIENCE_SUBJECT_LINK = "h4 [href*='/science']";
    private static final String SOCIAL_STUDIES_SUBJECT_LINK = "h4 [href*='/social-studies']";
    private static final String SPECIAL_EDUCATION_SUBJECT_LINK = "h4 [href*='/special-education']";
    private static final String VISUAL_AND_PERFORMING_ARTS_SUBJECT_LINK = "h4 [href*='/visual-and-performing-arts']";
    private static final String ALL_VISIBLE_CATEGORIES = ".panel-body [class='fa-ul mb0'] li[class='']";
    private static final String SHOW_ALL_BUTTONS = "[class*='open-modal']";


    public DirectoryPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.BROWSE_RESOURCE_DIRECTORY_PAGE_PATH);
    }

    public void clickOnHealthSubjectLink() {
        clickElement(HEALTH_SUBJECT_LINK);
    }

    public void clickOnLanguageArtsSubjectLink() {
        clickElement(LANGUAGE_ARTS_SUBJECT_LINK);
    }

    public void clickOnLanguagesSubjectLink() {
        clickElement(LANGUAGES_SUBJECT_LINK);
    }

    public void clickOnMathSubjectLink() {
        clickElement(MATH_SUBJECT_LINK);
    }

    public void clickOnPhysicalEducationSubjectLink() {
        clickElement(PHYSICAL_EDUCATION_SUBJECT_LINK);
    }

    public void clickOnScienceSubjectLink() {
        clickElement(SCIENCE_SUBJECT_LINK);
    }

    public void clickOnSocialStudiesSubjectLink() {
        clickElement(SOCIAL_STUDIES_SUBJECT_LINK);
    }

    public void clickOnSpecialEducationSubjectLink() {
        clickElement(SPECIAL_EDUCATION_SUBJECT_LINK);
    }

    public void clickOnVisualAndPerformingArtsSubjectLink() {
        clickElement(VISUAL_AND_PERFORMING_ARTS_SUBJECT_LINK);
    }
}
