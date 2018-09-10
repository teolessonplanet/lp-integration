package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class HeaderPage extends LpUiBasePage {

    private static final String LOGO_IMAGE = "[class='lp-logo-wrap lp-logo'] #logo";
    private static final String TRY_IT_FREE_BUTTON = "[class='lp-try-it-free'] a";
    private static final String UPGRADE_ME_BUTTON = "[class='lp-upgrade']";
    private static final String USER_DROPDOWN_BUTTON = "#lp-username";
    private static final String SIGN_IN_BUTTON = "[class='lp-sign-in'] a";


    private static final String RESOURCES_BUTTON = "[class='lp-resources']";
    private static final String DISCOVER_RESOURCES_BUTTON = "[class='lp-resources'] [href='/search']";
    private static final String BROWSE_RESOURCE_DIRECTORY = "[class='lp-resources'] [href='/lesson-plans']";
    private static final String SEARCH_BY_STANDARD_BUTTON = "[class='lp-resources'] [href='/state-standards']";
    private static final String CURRICULUM_MANAGER_BUTTON = "#curriculum-manager-menu-item";
    private static final String SIGN_IN_POPUP = "[class='lp-sign-in-popup-link']";
    private static final String SIGN_UP_POPUP = "[class='lp-sign-up-popup-link']";
    private static final String CURRICULUM_CALENDAR_BUTTON = "[class='lp-resources'] [href='/calendar']";
    private static final String LESSON_PLANNING_ARTICLES_BUTTON = "[class='lp-resources'] [href='/articles']";

    private static final String SOLUTIONS_BUTTON = "[class='lp-solutions']";
    private static final String EDUCATOR_EDITION_BUTTON = "[class='lp-solutions-ee']";
    private static final String SCHOOL_EDITION_BUTTON = "[class='lp-solutions-se']";
    private static final String SCHOOL_EDITION_AND_PD_LEARNING_NETWORK_BUTTON = "[class='lp-solutions-se-pd']";

    private static final String ABOUT_BUTTON = "[class='lp-about']";

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public String getUsernameText() {
        return findElement(USER_DROPDOWN_BUTTON).getText();
    }

    public boolean isUsernameDropDownDisplayed() {
        return isElementClickable(USER_DROPDOWN_BUTTON);
    }

    public void clickOnTryItFree(boolean openInANewTab) {
        if (openInANewTab) {
            openInANewTab(TRY_IT_FREE_BUTTON);
        } else {
            clickElement(TRY_IT_FREE_BUTTON);
        }
    }

    public void clickOnUpgradeMe() {
        clickElement(UPGRADE_ME_BUTTON);
    }

    public boolean isLogoClicable() {
        return isElementClickable(LOGO_IMAGE);
    }

    public void clickOnSignInButton(boolean openInANewTab) {
        if (openInANewTab) {
            openInANewTab(SIGN_IN_BUTTON);
        } else {
            clickElement(SIGN_IN_BUTTON);
        }
    }

    public void hoverOverResourcesButton() {
        hoverOverElement(RESOURCES_BUTTON);
    }

    public void clickOnDiscoverResourcesButton() {
        clickElement(DISCOVER_RESOURCES_BUTTON);
    }

    public void clickOnBrowseResourceDirectoryButton() {
        clickElement(BROWSE_RESOURCE_DIRECTORY);
    }

    public void clickOnSearchByStandardButton() {
        clickElement(SEARCH_BY_STANDARD_BUTTON);
    }

    public void clickOnCurriculumManagerButton() {
        clickElement(CURRICULUM_MANAGER_BUTTON);
    }

    public void hoverOverCurriculumManagerButton() {
        hoverOverElement(CURRICULUM_MANAGER_BUTTON);
    }

    public boolean isSignInPopupLinkDisplayed(){
        return isElementClickable(SIGN_IN_POPUP);
    }

    public boolean isSignUpPopupLinkDisplyed(){
        return isElementClickable(SIGN_UP_POPUP);
    }

    public void clickOnCurriculumCalendarButton() {
        clickElement(CURRICULUM_CALENDAR_BUTTON);
    }

    public void clickOnLessonPlanningArticlesButton() {
        clickElement(LESSON_PLANNING_ARTICLES_BUTTON);
    }

    public void hoverOverSolutionsButton() {
        hoverOverElement(SOLUTIONS_BUTTON);
    }

    public void clickOnEducatorEditionButton() {
        clickElement(EDUCATOR_EDITION_BUTTON);
    }

    public void clickOnSchoolEdition() {
        clickElement(SCHOOL_EDITION_BUTTON);
    }

    public void clickOnSchoolEditionAndPdLearningNetworkButton() {
        clickElement(SCHOOL_EDITION_AND_PD_LEARNING_NETWORK_BUTTON);
    }

    public void hoverOverAboutButton() {
        hoverOverElement(ABOUT_BUTTON);
    }
}
