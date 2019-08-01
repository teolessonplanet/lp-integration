package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class CalendarPage extends LpUiBasePage {

    private static final String CALENDAR_TITLE = "#content-main h1";
    private static final String CALENDAR_DESCRIPTION = "#content-main p";
    private static final String CALENDAR = "#calendar";
    private static final String MONTH_LINK = "#calendar a[href*='/search?keywords=']";
    private static final String NEXT_ARROW_LINK = "#calendar a.arrows:nth-child(3)";
    private static final String PREVIOUS_ARROW_LINK = "#calendar a.arrows:nth-child(1)";

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.CURRICULUM_CALENDAR_PAGE_PATH);
    }

    public boolean isCalendarTitleDisplayed() {
        return isElementDisplayed(CALENDAR_TITLE);
    }

    public String getCalendarTitle() {
        return getTextForElement(CALENDAR_TITLE);
    }

    public boolean isCalendarDescriptionDisplayed() {
        return isElementDisplayed(CALENDAR_DESCRIPTION);
    }

    public String getCalendarDescription() {
        return getTextForElement(CALENDAR_DESCRIPTION);
    }

    public boolean isCalendarDisplayed() {
        return isElementDisplayed(CALENDAR);
    }

    public void clickNextArrowLink() {
        clickElement(NEXT_ARROW_LINK);
    }

    public void clickPreviousArrowLink() {
        clickElement(PREVIOUS_ARROW_LINK);
    }

    public boolean isMonthLinkDisplayed() {
        return isElementDisplayed(MONTH_LINK);
    }

    public void clickOnMonthLink() {
        clickElement(MONTH_LINK);
    }

    public String getMonthLinkText() {
        return getTextForElement(MONTH_LINK);
    }
}
