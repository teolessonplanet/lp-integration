package com.lessonplanet.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import java.awt.Robot;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestData;

import java.awt.event.KeyEvent;
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
            WebDriverWait webDriverShortWait = new WebDriverWait(driver, TestData.SHORT_TIMEOUT);
            webDriverShortWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isElementVisible(String cssSelector) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
            return true;
        } catch (TimeoutException timeoutException) {
            logger.error("The element " + cssSelector + " is not visible");
            return false;
        }
    }

    public WebElement findElementToBeVisible(String cssLocator) {
        waitForElementToBeVisible(cssLocator);
        return driver.findElement(By.cssSelector(cssLocator));
    }

    protected void waitForElementToBeVisible(String cssSelector) {
        waitForLoad();
        logger.info("Wait until the webElement is visible: " + cssSelector);
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
        } catch (TimeoutException timeoutException) {
            logger.error("The element " + cssSelector + " cannot be clicked");
        }
    }

    private void waitUntilElementIsClickable(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void uploadUsingTextInput(String fileNameSelector, String path) {
        try {
            clickElement(fileNameSelector);
            driver.switchTo().activeElement().sendKeys(path);
            Robot robot = new Robot();
            robot.waitForIdle();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (Exception e) {
            logger.info("Cannot upload file");
        }
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
        boolean elementWasClicked = false;
        int attempts = TestData.SHORT_TIMEOUT;
        do {
            try {
                waitUntilElementIsClickable(webElement);
                webElement.click();
                elementWasClicked = true;
            } catch (Exception ex) {
                logger.error("The element " + webElement + " still no clickable");
                attempts--;
            }
        } while (!elementWasClicked && attempts > 0);
        waitForLoad();
    }

    protected void clickElement(List<WebElement> webElements, int position) {
        clickElement(webElements.get(position));
    }

    protected void clickElement(List<WebElement> webElements, String textToClick) {
        for (WebElement webElement : webElements) {
            if (webElement.getText().equals(textToClick)) {
                clickElement(webElement);
                break;
            }
        }
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
        waitForAngularLoad();
        waitForAxiosRequests();
    }

    //Wait for Angular Load
    public void waitForAngularLoad() {
        String angularReadyScript = "var ngAppElement = document.querySelectorAll('[ng-app]')[0];" +
            "if (typeof(angular) != 'undefined' && typeof(ngAppElement) != 'undefined') {" +
            "var ngElem = angular.element(ngAppElement); " +
            "return ngElem.injector().get('$http').pendingRequests.length == 0" +
            "} else {" +
            "return true;" +
            "}";

        webDriverWait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return (Boolean) javascriptExecutor.executeScript(angularReadyScript);
                } catch (Exception ex) {
                    logger.info("Angular is not defined");
                    return true;
                }
            }
        });
    }

    public void waitForAxiosRequests() {
        String axiosReadyScript = "if (typeof(window.axios_requests) != 'undefined'){" +
            "    return window.axios_requests == 0" +
            "  }else{" +
            "    return true;}";
        //Wait for Axios to load
        webDriverWait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) javascriptExecutor.executeScript(axiosReadyScript);
            }
        });
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

    protected void hoverOverElement(String cssSelector, int position) {
        hoverOverElement(findElements(cssSelector).get(position));
    }

    protected void hoverOverElement(WebElement webElement, boolean resetPosition) {
        if (resetPosition) {
            hoverOverElement("#logo");
        }
        hoverOverElement(webElement);
    }

    protected void hoverOverElement(String cssSelector, boolean resetPosition) {
        hoverOverElement(findElement(cssSelector), resetPosition);
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

    protected void waitUntilElementIsHidden(String cssSelector) {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(cssSelector)));
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

    protected void openInANewTab(String cssSelector, int position) {
        openInANewTab(findElements(cssSelector).get(position));
    }

    protected void openInANewTab(WebElement webElement) {
        waitForLoad();
        String url;
        if ((url = webElement.getAttribute("href")) == null) {
            //try to get the href for parent element, eg: Header - Logo
            url = webElement.findElement(By.xpath("..")).getAttribute("href");
        }
        logger.info("Opening a new tab and accessing the url: " + url);
        javascriptExecutor.executeScript("window.open(arguments[0], '_blank');", "");
        focusDriverToLastTab();
        driver.get(url);
        //Go to resource(shared resource) -> XML error on staging -> it will crash the test because of the jQuery wait
        if (!url.contains(TestData.STAGING_SERVER_SHARED_RESOURCE_REDIRECT_URL)) {
            waitForLoad();
        }
    }

    public void openInANewTabOrClick(WebElement webElement, boolean inANewTab) {
        if (inANewTab) {
            openInANewTab(webElement);
        } else {
            clickElement(webElement);
        }
    }

    protected void openInANewTabOrClick(String cssSelector, boolean inANewTab) {
        if (inANewTab) {
            openInANewTab(cssSelector);
        } else {
            clickElement(cssSelector);
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

    public int getCountOpenedTabs() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        return tabs.size();
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

    public void selectFromDropdown(String dropdownCssSelector, String optionsCssSelector, String option) {
        boolean optionWasFound = false;
        waitForLoad();
        clickElement(dropdownCssSelector);
        waitForLoad();
        List<WebElement> results = findElements(optionsCssSelector);
        for (WebElement result : results) {
            if (result.getText().equals(option)) {
                clickElement(result);
                optionWasFound = true;
                break;
            }
        }
        if (!optionWasFound) {
            logger.error("The option " + option + " was not found.");
        }
        waitForLoad();
    }

    public void waitForBootstrapModalToBeVisible(String modalId) {
        waitForLoad();
        webDriverWait.until(ExpectedConditions.and(
            new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver webDriver) {
                    return webDriver.findElement(By.cssSelector(modalId))
                        .getCssValue("opacity").equals("1");
                }
            },
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(modalId))
        ));
        waitForLoad();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.modal-backdrop")));
    }

    public void waitForReactModalToBeVisible() {
        waitForLoad();
        webDriverWait.until(ExpectedConditions.and(
            new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver webDriver) {
                    return webDriver.findElement(By.cssSelector("div.react-modal"))
                        .getCssValue("opacity").equals("1");
                }
            },
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.react-modal"))
        ));
        waitForLoad();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.react-modal-overlay")));
    }

    public boolean isElementDisplayed(String cssLocator) {
        try {
            driver.findElement(By.cssSelector(cssLocator)).isDisplayed();
            return true;
        } catch (StaleElementReferenceException | org.openqa.selenium.NoSuchElementException ex) {
            System.out.println("Element  is  not  displayed");
            return false;
        }
    }

    public String getElementId(String cssSelector) {
        try {
            return driver.findElement(By.cssSelector(cssSelector)).getAttribute("id");
        } catch (org.openqa.selenium.NoSuchElementException ex) {
            return null;
        }
    }

    protected String getBackgroundColor(String cssSelector) {
        waitForLoad();
        return Color.fromString(findElement(cssSelector).getCssValue("background-color")).asHex();
    }

    public String getElementAttribute(String cssSelector, String attributeName,  int position) {
        try {
            return driver.findElements(By.cssSelector(cssSelector)).get(position).getAttribute(attributeName);
        } catch (org.openqa.selenium.NoSuchElementException ex) {
            return null;
        }
    }

    public boolean isElementDisplayed(String cssLocator, int position) {
        try {
            driver.findElements(By.cssSelector(cssLocator)).get(position).isDisplayed();
            return true;
        } catch(StaleElementReferenceException | org.openqa.selenium.NoSuchElementException ex) {
            System.out.println("Element  is  not  displayed");
            return false;
        }
    }

    public String getAfterPseudoElement(String cssSelector, String position, String cssPropertyName, int index){
        WebElement div = findElements(cssSelector).get(index);
        try{
            return ((JavascriptExecutor)driver)
                .executeScript("return window.getComputedStyle(arguments[0], ':"+position+"').getPropertyValue('"+cssPropertyName+"');",div).toString();
        } catch( org.openqa.selenium.NoSuchElementException ex) {
            return null;
        }
    }
}
