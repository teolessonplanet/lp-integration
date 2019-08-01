package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class FAQPage extends LpUiBasePage {

    public FAQPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.FAQ_PAGE_PATH);
    }
}
