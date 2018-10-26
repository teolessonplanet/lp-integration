package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

import java.util.List;

public class ManageMembershipPage extends LpUiBasePage {

    private static final String OFFER_CONTAINERS = "[class='plan-container']";
    private static final String SELECT_BUTTONS = "[name='button']";

    public ManageMembershipPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.MANAGE_MEMBERSHIP_PAGE_PATH);
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
}
