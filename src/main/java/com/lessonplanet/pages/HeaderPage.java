package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderPage extends LpUiBasePage {

    private static final String LP_LOGO_IMAGE = "[class='lp-logo-wrap lp-logo'] #logo[src*='/assets/logos/lessonplanet-logo@1x']";
    private static final String REGULAR_SL_LOGO_IMAGE =  "[class*='lp-logo-wrap lp-logo'] #logo[src^='/assets/logos/learning-explorer-logo-'][src$='.png']";
    private static final String HENRY_CUSTOM_SL_LOGO = "[class*='custom-sl-logo-search-wrap'] #logo[src^='https://staging.lessonplanet.com/assets/logos/whitelabel/henry_county_logo-'][src$='.png']";
    private static final String TRY_IT_FREE_BUTTON = "[class='lp-try-it-free'] a";
    private static final String UPGRADE_ME_BUTTON = "[class='lp-upgrade'] a";
    private static final String USER_DROPDOWN_BUTTON = "#lp-username";
    private static final String SIGN_IN_BUTTON = "[class='lp-sign-in'] a";

    private static final String DISCOVER_BUTTON = "[class='lp-resources']";
    private static final String DISCOVER_RESOURCES_BUTTON = "[class='lp-resources'] [href='/search']";
    private static final String BROWSE_RESOURCE_DIRECTORY = "[class='lp-resources'] [href='/lesson-plans']";
    private static final String CURRICULUM_MANAGER_BUTTON = "#curriculum-manager-menu-item";
    private static final String SIGN_IN_POPUP = "[class='lp-sign-in-popup-link']";
    private static final String SIGN_UP_POPUP = "[class='lp-sign-up-popup-link']";
    private static final String CURRICULUM_CALENDAR_BUTTON = "[class='lp-resources'] [href='/calendar']";
    private static final String LESSON_PLANNING_ARTICLES_BUTTON = "[class='lp-resources'] [href='/articles']";
    private static final String PD_LEARNING_NETWORK_DISCOVER_BUTTON = "[class='lp-resources'] [href='/professional-development/courses']";

    private static final String SOLUTIONS_BUTTON = "[class='lp-solutions']";
    private static final String EDUCATOR_EDITION_BUTTON = "[class='lp-solutions-ee']";
    private static final String LEARNING_EXPLORER_BUTTON = "[class='lp-solutions-se']";
    private static final String PD_LEARNING_NETWORK_SOLUTIONS_BUTTON = "[class='lp-solutions-se-pd']";

    private static final String ABOUT_BUTTON = "[class='lp-about']";
    private static final String CONTACT_US_BUTTON = "[class='lp-about'] [href='/us/contact']";
    private static final String OUR_STORY_BUTTON = "[class='lp-about'] [href='/about']";
    private static final String FREQUENTLY_ASKED_QUESTIONS_BUTTON = "[class='lp-about'] [href='/faq']";
    private static final String HELP_CENTER_FAQ_BUTTON = "[class='lp-about'] [href='/help-center/']";
    private static final String TESTIMONIALS_BUTTON = "[class='lp-about'] [href='/us/testimonials']";

    private static final String PRICING_BUTTON = "[class='lp-pricing']";

    private static final String MY_ACCOUNT_BUTTON = "[class='lp-username'] [href='/profile/account']";
    private static final String MY_MEMBER_PROFILE_BUTTON = "[class='lp-username'] [href='/profile']";
    private static final String MY_RESOURCES_BUTTON = "[class='lp-username'] [href='/my/curriculum_manager']";
    private static final String SEARCH_HISTORY_BUTTON = "[class='lp-username'] [href='/my/saved_searches']";
    private static final String ADMIN_MANAGER_BUTTON = "[class='lp-username'] [href*='/my/admin-manager/account/']";
    private static final String SIGN_OUT_BUTTON = "[class='lp-username'] [href='/logout']";

    private static final String SEARCH_INPUT = "#keywords";
    private static final String SEARCH_BUTTON = "[class='lp-header-search-button']";
    private static final String SEARCH_FILTER = "[class='lp-header-search-filter']";
    private static final String SEARCH_FILTER_DROPDOWN_OPTIONS = "[class*='search-filter-item']";
    private static final String SEARCH_FILTER_DROPDOWN_SELECTED_OPTION = "[class*='search-filter-item selected']";
    private static final String SEARCH_CLEAR_SEARCH_BUTTON = "[class*='lp-header-clear-search']";
    private static final String HELP_BUTTON = "[href='https://www.learningexplorer.com/help-center/']";

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public String getUsernameText() {
        return getTextForElement(USER_DROPDOWN_BUTTON);
    }

    public boolean isUsernameDropDownDisplayed() {
        return isElementClickable(USER_DROPDOWN_BUTTON);
    }

    public void hoverOverUserDropDownButton() {
        hoverOverElement(USER_DROPDOWN_BUTTON, true);
    }

    public void clickOnTryItFree(boolean openInANewTab) {
        openInANewTabOrClick(TRY_IT_FREE_BUTTON, openInANewTab);
    }

    public void clickOnUpgradeMeButton(boolean inANewTab) {
        openInANewTabOrClick(UPGRADE_ME_BUTTON, inANewTab);
    }

    public boolean isLpLogoClickable() {
        return isElementClickable(LP_LOGO_IMAGE);
    }

    public void clickOnLpLogo(boolean inANewTab) {
        openInANewTabOrClick(LP_LOGO_IMAGE, inANewTab);
    }

    public boolean isRegularSlLogoClickable() {
        return isElementClickable(REGULAR_SL_LOGO_IMAGE);
    }

    public void clickOnRegularSlLogo(boolean inANewTab) {
        openInANewTabOrClick(REGULAR_SL_LOGO_IMAGE, inANewTab);
    }

    public void clickOnSignInButton(boolean openInANewTab) {
        openInANewTabOrClick(SIGN_IN_BUTTON, openInANewTab);
    }

    public boolean isSignInButtonDisplayed() {
        return isElementClickable(SIGN_IN_BUTTON);
    }

    public void hoverOverDiscoverButton() {
        hoverOverElement(DISCOVER_BUTTON, true);
    }

    public void clickOnDiscoverResourcesButton() {
        clickElement(DISCOVER_RESOURCES_BUTTON);
    }

    public void clickOnBrowseResourceDirectoryButton() {
        clickElement(BROWSE_RESOURCE_DIRECTORY);
    }

    public void hoverOverCurriculumManagerButton() {
        hoverOverElement(CURRICULUM_MANAGER_BUTTON);
        waitForLoad();
    }

    public void clickOnCurriculumManagerButton() {
        clickElement(CURRICULUM_MANAGER_BUTTON);
    }

    public boolean isSignInPopupLinkDisplayed() {
        return isElementDisplayed(SIGN_IN_POPUP);
    }

    public boolean isSignUpPopupLinkDisplayed() {
        return isElementDisplayed(SIGN_UP_POPUP);
    }

    public void clickOnCurriculumCalendarButton() {
        clickElement(CURRICULUM_CALENDAR_BUTTON);
    }

    public void clickOnLessonPlanningArticlesButton() {
        clickElement(LESSON_PLANNING_ARTICLES_BUTTON);
    }

    public void hoverOverSolutionsButton() {
        hoverOverElement(SOLUTIONS_BUTTON, true);
    }

    public void clickOnEducatorEditionButton() {
        clickElement(EDUCATOR_EDITION_BUTTON);
    }

    public void clickOnLearningExplorer() {
        clickElement(LEARNING_EXPLORER_BUTTON);
    }

    public void clickOnPdLearningNetworkSolutionsButton() {
        clickElement(PD_LEARNING_NETWORK_SOLUTIONS_BUTTON);
    }

    public void hoverOverAboutButton() {
        hoverOverElement(ABOUT_BUTTON, true);
    }

    public void clickOnContactUsButton() {
        clickElement(CONTACT_US_BUTTON);
    }

    public void clickOnOurStoryButton() {
        clickElement(OUR_STORY_BUTTON);
    }

    public void clickOnFrequentlyAskedQuestionsButton() {
        clickElement(FREQUENTLY_ASKED_QUESTIONS_BUTTON);
    }

    public void clickOnTestimonialsButton() {
        clickElement(TESTIMONIALS_BUTTON);
    }

    public void clickOnPricingButton() {
        clickElement(PRICING_BUTTON);
    }

    public void clickOnMyAccountButton() {
        clickElement(MY_ACCOUNT_BUTTON);
    }

    public void clickOnMyMemberProfileButton() {
        clickElement(MY_MEMBER_PROFILE_BUTTON);
    }

    public void clickOnMyResourcesButton() {
        clickElement(MY_RESOURCES_BUTTON);
    }

    public void clickOnSearchHistoryButton() {
        clickElement(SEARCH_HISTORY_BUTTON);
    }

    public void clickOnAdminManagerButton() {
        clickElement(ADMIN_MANAGER_BUTTON);
    }

    public void clickOnSignOutButton() {
        clickElement(SIGN_OUT_BUTTON);
    }

    public String getSearchText() {
        return findElement(SEARCH_INPUT).getAttribute("value");
    }

    public void typeSearchText(String searchText) {
        sendKeys(SEARCH_INPUT, searchText);
    }

    public void clickOnSearchButton() {
        clickElement(SEARCH_BUTTON);
    }

    public void clickOnSearchFilterButton() {
        clickElement(SEARCH_FILTER);
    }

    public String getSearchFilter() {
        return getTextForElement(SEARCH_FILTER_DROPDOWN_SELECTED_OPTION);
    }

    public void setSearchFilter(String optionToSelect) {
        List<WebElement> options = findElements(SEARCH_FILTER_DROPDOWN_OPTIONS);
        for (WebElement option : options) {
            if (option.getText().equals(optionToSelect)) {
                clickElement(option);
                break;
            }
        }
    }

    public String getTryItFreeButtonBackgroundColor() {
        return getBackgroundColor(TRY_IT_FREE_BUTTON);
    }

    public String getUpgradeMeButtonBackgroundColor() {
        return getBackgroundColor(UPGRADE_ME_BUTTON);
    }

    public boolean isSearchBarDisplayed() {
        return isElementDisplayed(SEARCH_INPUT) &&
            isElementDisplayed(SEARCH_BUTTON) &&
            isElementDisplayed(SEARCH_FILTER);
    }

    public boolean isDiscoverDropdownDisplayed() {
        return isElementDisplayed(DISCOVER_BUTTON);
    }

    public boolean isSolutionDropdownDisplayed() {
        return isElementDisplayed(SOLUTIONS_BUTTON);
    }

    public boolean isAboutDropdownDisplayed() {
        return isElementDisplayed(ABOUT_BUTTON);
    }

    public boolean isPricingButtonDisplayed() {
        return isElementDisplayed(PRICING_BUTTON);
    }

    public boolean isTryItFreeButtonDisplayed() {
        return isElementDisplayed(TRY_IT_FREE_BUTTON);
    }

    public boolean isMyAccountDropdownDisplayed() {
        return isElementDisplayed(MY_ACCOUNT_BUTTON);
    }

    public String getSearchBoxPlaceholder() {
        return findElement(SEARCH_INPUT).getAttribute("placeholder");
    }

    public void clickOnSearchInput() {
        clickElement(SEARCH_INPUT);
    }

    public String getSearchButtonText() {
        return getTextForElement(SEARCH_BUTTON);
    }

    public boolean isClearSearchButtonDisplayed() {
        return isElementDisplayed(SEARCH_CLEAR_SEARCH_BUTTON);
    }

    public void clickOnClearSearchButton() {
        clickElement(SEARCH_CLEAR_SEARCH_BUTTON);
    }

    public void clickOnPdLearningNetworkDiscoverButton() {
        clickElement(PD_LEARNING_NETWORK_DISCOVER_BUTTON);
    }

    public boolean isHenryCustomSlLogoDisplayed() {
        return isElementDisplayed(HENRY_CUSTOM_SL_LOGO);
    }

    public void clickOnHenryCustomSlLogo(){
        clickElement(HENRY_CUSTOM_SL_LOGO);
    }

    public void clickOnHelpButton() {
        clickElement(HELP_BUTTON);
    }

    public void clickOnHelpCenterFaqButton() {
        clickElement(HELP_CENTER_FAQ_BUTTON);
    }
}
