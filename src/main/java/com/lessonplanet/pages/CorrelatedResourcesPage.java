package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CorrelatedResourcesPage extends ResourcesPage {

    public CorrelatedResourcesPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage(String correlatedResourcesPath) {
        loadUrl(correlatedResourcesPath);
    }

    public void clickSeeReview(boolean inANewTab) {
        super.clickSeeReview(inANewTab);
    }
}
