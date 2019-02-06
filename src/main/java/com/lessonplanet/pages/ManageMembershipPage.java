package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

import java.util.ArrayList;
import java.util.List;

public class ManageMembershipPage extends LpUiBasePage {

    private static final String OFFER_CONTAINERS = "[class='plan-container']";
    private static final String SELECT_BUTTONS = "button[name='button']";
    private static final String TITLE_TEXT = "[class='mt0']";
    private static final String DISPLAYED_OFFERS_TEXT = "[class*='panel-offer'] [class*='panel-title']";
    private static final String MORE_ACCOUNT_OPTIONS_BUTTON = "[class*='more-options-button'] [href='/cancellation/new']";
    private static final String DISPLAYED_OFFERS_TEXT = "[class*='panel-offer'] [class*='panel-title']";

<<<<<<< HEAD
=======
    private static final String CURRENT_PLAN_TEXT = "Current Plan";

>>>>>>> WIP
    public ManageMembershipPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.MANAGE_MEMBERSHIP_PAGE_PATH);
    }

    public String getTitleText() {
        return getTextForElement(TITLE_TEXT);
    }

    private void upgradeSubscription(String newSubscription) {
        List<WebElement> offerContainers = findElements(OFFER_CONTAINERS);
        for (WebElement offer : offerContainers) {
            if (offer.getText().contains(newSubscription)) {
                clickElement(findElements(offer, SELECT_BUTTONS), 0);
                break;
            }
        }
    }

    public void upgradeSubscriptionAndReturn(String newSubscription) {
        final String currentPath = getPath();
        loadPage();
        upgradeSubscription(newSubscription);
        loadUrl(currentPath);
    }

    public void clickOnMoreAccountOptionsButton() {
        clickElement(MORE_ACCOUNT_OPTIONS_BUTTON);
    }

<<<<<<< HEAD
    public int getNumberOfDisplayedOffers() {
        List<WebElement> allOffers = findElements(SELECT_BUTTONS);
        return allOffers.size();
    }

    public List<String> getDisplayedOffers() {
        List<WebElement> offers = findElements(DISPLAYED_OFFERS_TEXT);
        List<String> displayedOffers = new ArrayList<>();
        for (WebElement offer : offers) {
            displayedOffers.add(getTextForElement(offer));
        }
        return displayedOffers;
=======
    public String getCurrentPlan() {
        List<WebElement> allOffers = findElements(SELECT_BUTTONS);
        if (allOffers.get(0).getText().equals(CURRENT_PLAN_TEXT)) {
            switch (allOffers.size()) {
                case 1:
                    return TestData.PRO_OPTION_TEXT;
                case 2:
                    return TestData.PRIME_OPTION_TEXT;
                case 3:
                    return TestData.STARTER_OPTION_TEXT;
            }
        }
        return "No plan found!";
    }

    public int getNumberOfDisplayedOffers() {
        List<WebElement> allOffers = findElements(SELECT_BUTTONS);
        return allOffers.size();
>>>>>>> WIP
    }

    public List<String> getDisplayedOffers() {
        List<WebElement> offers = findElements(DISPLAYED_OFFERS_TEXT);
        List<String> displayedOffers = new ArrayList<>();
        for (WebElement offer : offers) {
            displayedOffers.add(getTextForElement(offer));
        }
        return displayedOffers;
    }
}
