package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class StepTwoPage extends LpUiBasePage {

    private static final String TITLE_TEXT = "[class='panel-title']";

    public StepTwoPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return findElement(TITLE_TEXT).getText();
    }
}
