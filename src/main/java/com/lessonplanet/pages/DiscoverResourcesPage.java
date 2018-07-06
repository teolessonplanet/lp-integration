package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class DiscoverResourcesPage extends ResourcesPage {

    public DiscoverResourcesPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.DISCOVER_RESOURCES_PAGE_PATH);
    }
}
