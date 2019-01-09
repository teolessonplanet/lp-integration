package com.lessonplanet.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import util.TestData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MyAccountPage extends LpUiBasePage {

    private static final String PLAN_TEXT = "h5[class='mt5']";
    private static final String RENEW_NOW_BUTTON = "td [data-track-click='Renew Now']";
    private static final String STATUS_DATE = "td [class='text-success']";

    private static final Logger logger = LogManager.getRootLogger();

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.MY_ACCOUNT_PAGE_PATH);
    }

    public String getPlan() {
        return getTextForElement(PLAN_TEXT);
    }

    public boolean isRenewNowButtonDisplayed() {
        return isElementDisplayed(RENEW_NOW_BUTTON);
    }

    public boolean isStatusDateDisplayed() {
        return isElementDisplayed(STATUS_DATE);
    }

    public Date getStatusDate() {
        Date statusDate = null;
        String statusDateString = getTextForElement(STATUS_DATE);
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM dd,yyyy", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
            statusDate = simpleDateFormat.parse(statusDateString);
        } catch (Exception e) {
            logger.error("Cannot parse the status date: " + statusDateString);
        }
        return statusDate;
    }
}
