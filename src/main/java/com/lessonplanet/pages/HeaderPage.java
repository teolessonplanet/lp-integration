package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class HeaderPage extends LpUiBasePage {

    private static final String LOGO_IMAGE = "[class='lp-logo-wrap lp-logo'] #logo";
    private static final String TRY_IT_FREE_BUTTON = "[class='lp-try-it-free'] a";
    private static final String UPGRADE_ME_BUTTON = "[class='lp-upgrade']";
    private static final String USER_DROPDOWN_BUTTON = "#lp-username";

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
}
