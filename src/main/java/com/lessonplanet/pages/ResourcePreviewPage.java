package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class ResourcePreviewPage extends LpUiBasePage {

    private static final String DOWNLOAD_RESOURCE_BUTTON = "[class='pull-right'] a[class*='btn-action']";
    private static final String IFRAME_RESOURCE = "iframe[src*='https://docs.google.com/viewer?embedded=true&url=']";

    public ResourcePreviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDownloadResourceButtonDisplayed() {
        return isElementDisplayed(DOWNLOAD_RESOURCE_BUTTON);
    }

    public boolean isIframeResourceDisplayed() {
        return isElementDisplayed(IFRAME_RESOURCE);
    }
}
