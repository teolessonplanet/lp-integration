package com.lessonplanet.pages;
import org.openqa.selenium.WebDriver;

public class SignInPage extends LpUiBasePage {
    private static final String TITLE_TEXT = "#content-main h2";

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText(){
        return getTextForElement(TITLE_TEXT);
    }
}
