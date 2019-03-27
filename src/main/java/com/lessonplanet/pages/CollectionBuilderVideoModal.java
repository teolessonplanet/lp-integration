package com.lessonplanet.pages;
import org.openqa.selenium.WebDriver;

public class CollectionBuilderVideoModal extends LpUiBasePage {

    private static final String COLLECTION_BUILDER_VIDEO_MODAL = "#collection-builder-banner-video";
    private static final String X_BUTTON = "#collection-builder-banner-video [class='close']";

    public CollectionBuilderVideoModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal(){
        waitForBootstrapModalToBeVisible(COLLECTION_BUILDER_VIDEO_MODAL);
    }

    public void clickOnXButton() {
        clickElement(X_BUTTON);
    }
}
