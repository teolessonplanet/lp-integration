package com.lessonplanet.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestData;

import java.util.List;

public class LpUiBasePage {

    private static final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;

    protected LpUiBasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement findElement(String cssLocator) {
        waitForElement(cssLocator);
        return driver.findElement(By.cssSelector(cssLocator));
    }

    protected List<WebElement> findElements(String cssLocator) {
        waitForElement(cssLocator);
        return driver.findElements(By.cssSelector(cssLocator));
    }

    protected void waitForElement(String cssSelector) {
        WebDriverWait wait = new WebDriverWait(driver, TestData.TIMEOUT);
        logger.info("Wait until the webElement is clickable: " + cssSelector);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
    }

    protected void sendKeys(String cssLocator, String text) {
        findElement(cssLocator).sendKeys(text);
    }

    protected void clickElement(String cssLocator) {
        findElement(cssLocator).click();
    }

    protected void loadUrl(String pagePath) {
        final String url = TestData.SERVER_URL + pagePath;
        logger.info("Accessing: " + url);
        driver.get(url);
    }

    public String getPath() {
        waitForPageLoad();
        try {
            String path[] = getUrl().split(".com/");
            logger.info("Path: " + path[1]);
            return path[1];
        } catch (Exception e) {
            logger.info("The homepage is loaded.");
            return "";
        }
    }

    protected String getUrl() {
        return driver.getCurrentUrl();
    }

    protected void waitForPageLoad() {
        logger.info("Waiting for jQuery to complete");
        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                JavascriptExecutor js = (JavascriptExecutor) webDriver;
                return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
            }
        });
        logger.info("jQuery completed");
    }

    public void dragAndDrop(WebElement element, WebElement target) {
        try {
            (new Actions(driver)).dragAndDrop(element, target).perform();
        } catch (Exception e) {
            logger.info("The webElement is not visible");
            scrollToElement(element);
            (new Actions(driver)).dragAndDrop(element, target).perform();
        }
        waitForPageLoad();
    }

    private void scrollToElement(WebElement element) {
        logger.info("Scrolling to element");
        waitForPageLoad();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        waitForPageLoad();
    }

    protected void waitUntilAnimationIsDone(String cssSelector) {
        WebElement element = new WebDriverWait(driver, TestData.TIMEOUT).until(steadinessOfElementLocated(cssSelector));
    }

    private ExpectedCondition<WebElement> steadinessOfElementLocated(String cssSelector) {
        return new ExpectedCondition<WebElement>() {
            private WebElement element = null;
            private Point location = null;

            @Override
            public WebElement apply(WebDriver driver) {
                if (element == null) {
                    try {
                        element = driver.findElement(By.cssSelector(cssSelector));
                    } catch (NoSuchElementException e) {
                        return null;
                    }
                }

                try {
                    if (element.isDisplayed()) {
                        Point currentLocation = element.getLocation();
                        if (currentLocation.equals(location) && isOnTop(element)) {
                            return element;
                        }
                        location = currentLocation;
                    }
                } catch (StaleElementReferenceException e) {
                    element = null;
                }
                return null;
            }
        };
    }

    private boolean isOnTop(WebElement element) {
        WebDriver driver = ((RemoteWebElement) element).getWrappedDriver();
        return (boolean) ((JavascriptExecutor) driver).executeScript(
                "var elm = arguments[0];" +
                        "var doc = elm.ownerDocument || document;" +
                        "var rect = elm.getBoundingClientRect();" +
                        "return elm === doc.elementFromPoint(rect.left + (rect.width / 2), rect.top + (rect.height / 2));"
                , element);
    }
}
