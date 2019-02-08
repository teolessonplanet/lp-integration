package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class ArticlesPage extends LpUiBasePage {

    public ArticlesPage (WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.LESSON_PLANNING_ARTICLES_PAGE_PATH);
    }
}
