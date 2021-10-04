package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

public class PricingPage extends LpUiBasePage {

    private static final String SELECT_PLAN_STARTER_BUTTON = "#starter-btn a";
    private static final String SELECT_PLAN_PRO_BUTTON = "#pro-btn a";

    public PricingPage(WebDriver driver) {
        super(driver);
    }

    public void selectOffer(String offer) {
        switch (offer) {
            case TestData.PLAN_STARTER:
                clickElement(SELECT_PLAN_STARTER_BUTTON);
                break;
            case TestData.PLAN_PRO:
                clickElement(SELECT_PLAN_PRO_BUTTON);
                break;
            default:
                logger.error("No option is selected");
                break;
        }
    }
}
