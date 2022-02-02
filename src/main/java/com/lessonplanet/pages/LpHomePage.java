package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class LpHomePage extends LpUiBasePage {

    private static final String UPGRADE_ME_BUTTON = "a[data-track-click='Upgrade Me'][data-track-label='Homepage Button']";
    private static final String ALERT_MESSAGE_TEXT = "#content-header [class*='alert']";

    public LpHomePage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.LP_HOME_PAGE_PATH);
    }

    public String getAlertMessageText() {
        return getTextForElement(ALERT_MESSAGE_TEXT);
    }
}
