package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class LpHomePage extends LpUiBasePage {

    public LpHomePage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.LP_HOME_PAGE_PATH);
        createCaptchaBypassCookie();
    }
}
