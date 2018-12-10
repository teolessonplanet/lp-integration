package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class StateStandardsPage extends LpUiBasePage {

    private static final String ENGLISH_LANGUAGE_ARTS_BUTTON = "[href*='/english-language-arts']";
    private static final String MATHEMATICS_BUTTON = "[href*='/mathematics']";
    private static final String NGSS_BUTTON = "[href*='/nrcdsc']";

    private static final String MAP = "#us-map-relative";
    private static final String MAP_GEORGIA_STATE = "#georgia";

    public StateStandardsPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.SEARCH_BY_STANDARD_PAGE_PATH);
    }

    public void clickOnEnglishLanguageArtsButton() {
        clickElement(ENGLISH_LANGUAGE_ARTS_BUTTON);
    }

    public void clickOnMathematicsButton() {
        clickElement(MATHEMATICS_BUTTON);
    }

    public void clickOnNgssButton() {
        clickElement(NGSS_BUTTON);
    }
}
