package com.lessonplanet.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestData;

import java.util.ArrayList;
import java.util.List;

public class LpUiBasePage {

    protected static final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private JavascriptExecutor javascriptExecutor;

    protected LpUiBasePage(WebDriver driver) {
        this.driver = driver;
        javascriptExecutor = (JavascriptExecutor) driver;
        webDriverWait = new WebDriverWait(driver, TestData.TIMEOUT);
    }

    protected WebElement findElement(String cssLocator) {
        waitForElement(cssLocator);
        return driver.findElement(By.cssSelector(cssLocator));
    }

    protected boolean isElementClickable(String cssSelector) {
        try {
            driver.findElement(By.cssSelector(cssSelector));
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected List<WebElement> findElements(String cssLocator) {
        waitForElement(cssLocator);
        return driver.findElements(By.cssSelector(cssLocator));
    }

    protected List<WebElement> findElements(WebElement element, String cssSelector) {
        waitForLinkToLoad();
        waitForPageLoad();
        try {
            return element.findElements(By.cssSelector(cssSelector));
        } catch (Exception e) {
            logger.info("The element " + cssSelector + " cannot be found in the current webElement");
        }
        return null;
    }

    protected void waitForElement(String cssSelector) {
        logger.info("Wait until the webElement is clickable: " + cssSelector);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
        } catch (TimeoutException timeoutException) {
            logger.error("The element " + cssSelector + " cannot be clicked");
        }
    }

    protected void sendKeys(String cssLocator, String text) {
        findElement(cssLocator).sendKeys(text);
    }

    protected void clearText(String cssSelector) {
        findElement(cssSelector).clear();
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

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void waitForPageLoad() {
        logger.info("Waiting for jQuery to complete");
        webDriverWait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) javascriptExecutor.executeScript("return !!window.jQuery && window.jQuery.active == 0");
            }
        });
        logger.info("jQuery completed");
        waitUntilDocumentIsReady();
    }

    public void waitUntilDocumentIsReady() {
        logger.info("Waiting for document to be ready");
        webDriverWait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) javascriptExecutor.executeScript("return document.readyState == 'complete'");
            }
        });
        logger.info("document is ready");
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

    protected void hoverOverElement(WebElement element) {
        (new Actions(driver)).moveToElement(element).build().perform();
    }

    protected void hoverOverElement(String cssSelector) {
        hoverOverElement(findElement(cssSelector));
    }

    private void scrollToElement(WebElement element) {
        logger.info("Scrolling to element");
        waitForPageLoad();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", element);
        waitForPageLoad();
    }

    protected void waitUntilAnimationIsDone(String cssSelector) {
        webDriverWait.until(steadinessOfElementLocated(cssSelector));
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
        return (boolean) javascriptExecutor.executeScript(
                "var elm = arguments[0];" +
                        "var doc = elm.ownerDocument || document;" +
                        "var rect = elm.getBoundingClientRect();" +
                        "return elm === doc.elementFromPoint(rect.left + (rect.width / 2), rect.top + (rect.height / 2));"
                , element);
    }

    protected void createCaptchaBypassCookie() {
        driver.manage().addCookie(new Cookie(TestData.STAGING_SERVER_CAPTCHA_COOKIE_NAME, ""));
    }

    protected void openInANewTab(String cssSelector) {
        openInANewTab(findElement(cssSelector));
    }

    protected void openInANewTab(WebElement webElement) {
        waitForPageLoad();
        final String url = webElement.getAttribute("href");
        logger.info("Opening a new tab and accessing the url: " + url);
        javascriptExecutor.executeScript("window.open(arguments[0], '_blank');", "");
        focusDriverToLastTab();
        driver.get(url);
        //Go to resource(shared resource) -> XML error on staging -> it will crash the test because of the jQuery wait
        if (!url.contains(TestData.STAGING_SERVER_SHARED_RESOURCE_REDIRECT_URL)) {
            waitForPageLoad();
        }
    }

    public void closeTab() {
        logger.info("Closing the tab");
        driver.close();
        focusDriverToLastTab();
        waitForPageLoad();
    }

    public void focusDriverToLastTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public void goBackOnePage() {
        waitForLinkToLoad();
        waitForPageLoad();
        javascriptExecutor.executeScript("window.history.go(-1)");
        waitForLinkToLoad();
        waitForPageLoad();
    }

    public void waitForLinkToLoad() {
        webDriverWait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (!driver.getCurrentUrl().contains(TestData.EMPTY_URL));
            }
        });
    }

    public void waitForNewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        webDriverWait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (driver.getWindowHandles().size() > 1);
            }
        });
    }
}
