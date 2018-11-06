package com.lessonplanet.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
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
            findElement(cssSelector);
            WebDriverWait webDriverShortWait = new WebDriverWait(driver, TestData.SHORT_TIMEOUT);
            webDriverShortWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void waitUntilElementIsClickable(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected List<WebElement> findElements(String cssLocator) {
        waitForElement(cssLocator);
        return driver.findElements(By.cssSelector(cssLocator));
    }

    protected List<WebElement> findElements(WebElement element, String cssSelector) {
        waitForElement(cssSelector);
        try {
            return element.findElements(By.cssSelector(cssSelector));
        } catch (Exception e) {
            logger.info("The element " + cssSelector + " cannot be found in the current webElement");
        }
        return null;
    }

    protected void waitForElement(String cssSelector) {
        waitForLoad();
        logger.info("Wait until the webElement is clickable: " + cssSelector);
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
        } catch (TimeoutException timeoutException) {
            logger.error("The element " + cssSelector + " cannot be clicked");
        }
    }

    protected void sendKeys(String cssLocator, String text) {
        findElement(cssLocator).sendKeys(text);
        waitForLoad();
    }

    protected void clearText(String cssSelector) {
        findElement(cssSelector).clear();
        waitForLoad();
    }

    protected void clickElement(String cssLocator) {
        clickElement(findElement(cssLocator));
    }

    protected void clickElement(WebElement webElement) {
        waitForLoad();
        waitUntilElementIsClickable(webElement);
        webElement.click();
        waitForLoad();
    }

    protected void clickElement(List<WebElement> webElements, int position) {
        clickElement(webElements.get(position));
    }

    protected void clickElement(String cssSelector, int position) {
        clickElement(findElements(cssSelector), position);
    }

    protected String getTextForElement(WebElement element) {
        waitForLoad();
        return element.getText();
    }

    protected String getTextForElement(String cssSelector) {
        return getTextForElement(findElement(cssSelector));
    }

    protected String getTextForElement(String cssSelector, int position) {
        return getTextForElement(findElements(cssSelector).get(position));
    }

    protected void loadUrl(String pagePath) {
        if (getUrl().contains(TestData.SERVER_URL)) {
            waitForLoad();
        }
        final String url = TestData.SERVER_URL + pagePath;
        logger.info("Accessing: " + url);
        driver.get(url);
        waitForLoad();
    }

    public String getPath() {
        waitForLoad();
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
        try {
            webDriverWait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    return (Boolean) javascriptExecutor.executeScript("return !!window.jQuery && window.jQuery.active == 0");
                }
            });
            logger.info("jQuery completed");
        } catch (Exception ex) {
            logger.error("jQuery is not completed: " + ex.toString());
        }
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

    public void waitForLoad() {
        waitForLinkToLoad();
        waitForPageLoad();
        waitUntilDocumentIsReady();
    }

    public void dragAndDrop(WebElement element, WebElement target) {
        waitForLoad();
        try {
            (new Actions(driver)).dragAndDrop(element, target).perform();
        } catch (Exception e) {
            logger.info("The webElement is not visible");
            scrollToElement(element);
            (new Actions(driver)).dragAndDrop(element, target).perform();
        }
        waitForLoad();
    }

    protected void hoverOverElement(WebElement element) {
        waitForLoad();
        (new Actions(driver)).moveToElement(element).build().perform();
        waitForLoad();
    }

    protected void hoverOverElement(String cssSelector) {
        hoverOverElement(findElement(cssSelector));
    }

    protected void scrollToElement(WebElement element) {
        logger.info("Scrolling to element");
        waitForLoad();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", element);
        waitForLoad();
    }

    protected void scrollToElement(String cssSelector) {
        scrollToElement(findElement(cssSelector));
    }

    protected void waitUntilAnimationIsDone(String cssSelector) {
        waitForLoad();
        webDriverWait.until(steadinessOfElementLocated(cssSelector));
        waitForLoad();
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
        waitForLoad();
        final String url = webElement.getAttribute("href");
        logger.info("Opening a new tab and accessing the url: " + url);
        javascriptExecutor.executeScript("window.open(arguments[0], '_blank');", "");
        focusDriverToLastTab();
        driver.get(url);
        //Go to resource(shared resource) -> XML error on staging -> it will crash the test because of the jQuery wait
        if (!url.contains(TestData.STAGING_SERVER_SHARED_RESOURCE_REDIRECT_URL)) {
            waitForLoad();
        }
    }

    public void closeTab() {
        logger.info("Closing the tab");
        driver.close();
        focusDriverToLastTab();
        waitForLoad();
    }

    public void focusDriverToLastTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public void goBackOnePage() {
        waitForLoad();
        javascriptExecutor.executeScript("window.history.go(-1)");
        waitForLoad();
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
