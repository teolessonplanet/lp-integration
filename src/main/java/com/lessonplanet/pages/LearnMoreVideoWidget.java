package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class LearnMoreVideoWidget extends LpUiBasePage {

    private static final String VIDEO_PLAYER_WIDGET = "[class*='vid-responsive']";

    public LearnMoreVideoWidget(WebDriver driver) {
        super(driver);
    }

    public boolean isVideoPlayerDisplayed() {
        return isElementDisplayed(VIDEO_PLAYER_WIDGET);
    }

    public boolean isVideoPlayerClickable() {
        return isElementClickable(VIDEO_PLAYER_WIDGET);
    }
}
