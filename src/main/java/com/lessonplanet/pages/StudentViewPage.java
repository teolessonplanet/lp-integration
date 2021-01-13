package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class StudentViewPage extends LpUiBasePage {

    private static final String PASSWORD_FIELD = "#access_key";
    private static final String SUBMIT_BUTTON = "div[class$='form-submit']";
    private static final String INCORRECT_ACCESS_KEY_TEXT = "#student-access-error";

    public StudentViewPage(WebDriver driver) {
        super(driver);
    }

    public void typePassword(String password) {
        sendKeys(PASSWORD_FIELD, password);
    }

    public String getPasswordText(){
        return findElement(PASSWORD_FIELD).getAttribute("value");
    }

    public void clearPasswordField(){
        clearText(PASSWORD_FIELD);
    }

    public void clickOnSubmitButton() {
        clickElement(SUBMIT_BUTTON);
    }

    public String getIncorrectAccessKeyText() {
        return getTextForElement(INCORRECT_ACCESS_KEY_TEXT);
    }
}
