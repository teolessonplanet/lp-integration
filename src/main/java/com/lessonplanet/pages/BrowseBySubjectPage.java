package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class BrowseBySubjectPage extends ResourcesPage {

    private static final String PAGE_TITLE = "[class='media-heading']";

    public BrowseBySubjectPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage(String subjectPath) {
        loadUrl(subjectPath);
    }

    public String getPageTitle() {
        return findElement(PAGE_TITLE).getText();
    }
}
