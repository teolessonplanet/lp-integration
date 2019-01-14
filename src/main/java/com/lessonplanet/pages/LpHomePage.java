package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class LpHomePage extends LpUiBasePage {

    private static final String SEARCH_INPUT = "#keywords";
    private static final String SEARCH_BUTTON = "#Search";
    private static final String UPGRADE_ME_BUTTON = "[class='btn btn-success btn-lg btn-action mt20']";

    public LpHomePage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.LP_HOME_PAGE_PATH);
        createCaptchaBypassCookie();
    }

    public void typeSearchText(String search) {
        sendKeys(SEARCH_INPUT, search);
    }

    public void clickOnSearch() {
        clickElement(SEARCH_BUTTON);
    }

    public void clickOnUpdateMeButton() {
        openInANewTab(UPGRADE_ME_BUTTON);
    }
}
