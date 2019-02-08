package com.lessonplanet.pages;
import org.openqa.selenium.WebDriver;
import util.TestData;

public class ContactUsPage extends LpUiBasePage {

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.CONTACT_US_PAGE_PATH);
    }
}
