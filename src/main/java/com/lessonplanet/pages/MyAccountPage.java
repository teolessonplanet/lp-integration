package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class MyAccountPage extends LpUiBasePage {

    private static final String PLAN_TEXT = "h5[class='mt5']";

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.MY_ACCOUNT_PAGE_PATH);
    }

    public String getPlan() {
        return findElement(PLAN_TEXT).getText();
    }
}
