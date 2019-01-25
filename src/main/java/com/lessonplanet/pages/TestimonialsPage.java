package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class TestimonialsPage extends BrowseBySubjectPage {

    public TestimonialsPage (WebDriver driver){
        super(driver);
    }
    public void loadPage() {
        loadUrl(TestData.TESTIMONIALS_PAGE_PATH);
    }
}
