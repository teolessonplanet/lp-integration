package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class SearchByStandardsPage extends LpUiBasePage {

    private static final String RESULTS_FOR = "#standard-content h2";

    public SearchByStandardsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isResultsForDisplayed(String searchedText) {
        return getTextForElement(RESULTS_FOR).contains(searchedText);
    }

}
