package com.lessonplanet.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestData;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class LpUiBasePage {

    protected static final Logger logger = LogManager.getRootLogger();
    protected WebDriver driver;
    private WebDriverWait webDriverWait;
    private JavascriptExecutor javascriptExecutor;
    private boolean isQaIntegrationCookieCreated = false;

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
        waitForLoad();
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
            sendKeys(fileNameSelector, path);
            //TODO: remove this if upload is stable
//            clickElement(fileNameSelector);
//            driver.switchTo().activeElement().sendKeys(path);
//            Robot robot = new Robot();
//            robot.waitForIdle();
//            robot.keyPress(KeyEvent.VK_ESCAPE);
//            robot.keyRelease(KeyEvent.VK_ESCAPE);
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
        waitForLoad();
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

    public void clickElement(WebElement webElement) {
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

    protected void clickElementIfStartsWith(List<WebElement> webElements, String textToClick) {
        for (WebElement webElement : webElements) {
            if (webElement.getText().startsWith(textToClick)) {
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

    protected String getTextForElement(WebElement element, String cssLocator) {
        waitForLoad();
        findElement(cssLocator);
        return findElements(element, cssLocator).get(0).getText();
    }

    protected String getTextForElement(String cssSelector) {
        return getTextForElement(findElement(cssSelector));
    }

    protected String getTextForElement(String cssSelector, int position) {
        return getTextForElement(findElements(cssSelector).get(position));
    }

    protected void loadUrl(String pagePath) {
        if (!isQaIntegrationCookieCreated) {
            try {
                if (!TestData.IP_IS_WHITELISTED) {
                    driver.get("https://demo:hqu5duYLqbyi6@staging.lessonplanet.com");
                } else {
                    driver.get(TestData.SERVER_URL + TestData.LP_HOME_PAGE_PATH);
                }
                createQaIntegrationBypassCookie();
                isQaIntegrationCookieCreated = true;
            } catch (Exception ex) {
                logger.info(ex.toString());
            }
        }
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

        try {
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
        } catch (Exception ex) {
            logger.info("The Angular modal is not found " + ex.toString());
        }
    }

    public void waitForAxiosRequests() {
        String axiosReadyScript = "if (typeof(window.axios_requests) != 'undefined'){" +
            "    return window.axios_requests == 0" +
            "  }else{" +
            "    return true;}";
        //Wait for Axios to load
        try {
            webDriverWait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    return (Boolean) javascriptExecutor.executeScript(axiosReadyScript);
                }
            });
        } catch (Exception ex) {
            logger.info("The Axios modal is not found " + ex.toString());
        }

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

    public void customDragAndDrop(WebElement element, WebElement target) {
        waitForLoad();
        try {
            // https://gist.github.com/florentbr/60ef7cb8d9b1ae690cafc82aad52da73#file-drag-drop-js
            String html5dnd = "function e(e,t,n,i){var r=a.createEvent('DragEvent');r.initMouseEvent(t,!0,!0,o,0,0,0,c,g,!1,!1,!1,!1,0,null),Object.defineProperty(r,'dataTransfer',{get:function(){return d}}),e.dispatchEvent(r),o.setTimeout(i,n)}var t=arguments[0],n=arguments[1],i=arguments[2]||0,r=arguments[3]||0;if(!t.draggable)throw new Error('Source element is not draggable.');var a=t.ownerDocument,o=a.defaultView,l=t.getBoundingClientRect(),u=n?n.getBoundingClientRect():l,c=l.left+(l.width>>1),g=l.top+(l.height>>1),s=u.left+(u.width>>1)+i,f=u.top+(u.height>>1)+r,d=Object.create(Object.prototype,{_items:{value:{}},effectAllowed:{value:'all',writable:!0},dropEffect:{value:'move',writable:!0},files:{get:function(){return this._items.Files}},types:{get:function(){return Object.keys(this._items)}},setData:{value:function(e,t){this._items[e]=t}},getData:{value:function(e){return this._items[e]}},clearData:{value:function(e){delete this._items[e]}},setDragImage:{value:function(e){}}});if(n=a.elementFromPoint(s,f),!n)throw new Error('The target element is not interactable and need to be scrolled into the view.');u=n.getBoundingClientRect(),e(t,'dragstart',101,function(){var i=n.getBoundingClientRect();c=i.left+s-u.left,g=i.top+f-u.top,e(n,'dragenter',1,function(){e(n,'dragover',101,function(){n=a.elementFromPoint(c,g),e(n,'drop',1,function(){e(t,'dragend',1,callback)})})})})";
            javascriptExecutor.executeScript(html5dnd, element, target);
            waitForLoad();
        } catch (Exception e) {
            dragAndDrop(element, target);
        }
        waitForLoad();
    }

    public void hoverOverElement(WebElement element) {
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

    public void hoverOverElement(WebElement webElement, boolean resetPosition) {
        if (resetPosition) {
            hoverOverElement("[class*='lp-header-search-icon']");
        }
        hoverOverElement(webElement);
    }

    protected void hoverOverElement(String cssSelector, boolean resetPosition) {
        hoverOverElement(findElement(cssSelector), resetPosition);
    }

    protected void hoverOverElement(String cssSelector, boolean resetPosition, int position) {
        hoverOverElement(findElements(cssSelector).get(position), resetPosition);
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

    protected void scrollToElement(String cssSelector, int index) {
        scrollToElement(findElements(cssSelector).get(index));
    }

    protected void waitUntilElementIsHidden(String cssSelector) {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(cssSelector)));
    }

    protected void waitUntilElementIsDisplayed(WebElement webElement) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception ex) {
            logger.info("Element is not visible");
        }
    }

    protected void waitUntilTextIsDisplayed(String cssSelector, String text) {
        webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(cssSelector), text));
    }

    private boolean isOnTop(WebElement element) {
        return (boolean) javascriptExecutor.executeScript(
            "var elm = arguments[0];" +
                "var doc = elm.ownerDocument || document;" +
                "var rect = elm.getBoundingClientRect();" +
                "return elm === doc.elementFromPoint(rect.left + (rect.width / 2), rect.top + (rect.height / 2));"
            , element);
    }

    protected void createQaIntegrationBypassCookie() {
        driver.manage().addCookie(new Cookie(TestData.STAGING_SERVER_QA_INTEGRATION_COOKIE_NAME, ""));
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
        try {
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
//            TODO: uodate modal-backdrop
//            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.modal-backdrop")));
        } catch (Exception ex) {
            logger.info("The Bootstrap modal is not visible " + ex.toString());
        }
    }

    public void waitForReactModalToBeVisible() {
        waitForLoad();
        try {
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
        } catch (Exception ex) {
            logger.info("The React modal is not visible " + ex.toString());
        }
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

    public boolean isElementDisplayed(WebElement webElement, String cssLocator) {
        waitForLoad();
        try {
            waitForElement(cssLocator);
            webElement.findElement(By.cssSelector(cssLocator)).isDisplayed();
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

    public String getElementAttribute(String cssSelector, String attributeName, int position) {
        try {
            return driver.findElements(By.cssSelector(cssSelector)).get(position).getAttribute(attributeName);
        } catch (org.openqa.selenium.NoSuchElementException ex) {
            return null;
        }
    }

    public String getElementAttribute(String cssSelector, String attributeName) {
        try {
            return driver.findElement(By.cssSelector(cssSelector)).getAttribute(attributeName);
        } catch (org.openqa.selenium.NoSuchElementException ex) {
            return null;
        }
    }

    public boolean isElementDisplayed(String cssLocator, int position) {
        try {
            driver.findElements(By.cssSelector(cssLocator)).get(position).isDisplayed();
            return true;
        } catch (StaleElementReferenceException | org.openqa.selenium.NoSuchElementException ex) {
            System.out.println("Element  is  not  displayed");
            return false;
        }
    }

    public String getAfterPseudoElement(String cssSelector, String position, String cssPropertyName, int index) {
        WebElement div = findElements(cssSelector).get(index);
        try {
            return ((JavascriptExecutor) driver)
                .executeScript("return window.getComputedStyle(arguments[0], ':" + position + "').getPropertyValue('" + cssPropertyName + "');", div).toString();
        } catch (org.openqa.selenium.NoSuchElementException ex) {
            return null;
        }
    }

    public void clearTextUsingActions(String cssSelector) {
        clickElement(cssSelector);
        Actions action = new Actions(driver);
        String text = findElement(cssSelector).getAttribute("value");
        int lenText = text.length();
        for (int i = 0; i < lenText; i++) {
            action.sendKeys(Keys.ARROW_LEFT);
        }
        action.build().perform();

        for (int i = 0; i < lenText; i++) {
            action.sendKeys(Keys.DELETE);
        }
        action.build().perform();
    }

    public void refreshPageAndDismissBrowserAlert() {
        driver.navigate().refresh();
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (NoAlertPresentException noe) {
            System.out.println("No alert found on page");
        }
    }

    public void pasteTextUsingKeys(String text, String cssSelector) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        element.click();
        element.sendKeys(Keys.CONTROL + "v");
    }

    public void uploadUsingKeys(String fileNameSelector, String path) throws AWTException {
        Robot robot = new Robot();
        Actions builder = new Actions(driver);
        Action myAction = builder.click(driver.findElement(By.cssSelector(fileNameSelector)))
            .release()
            .build();
        myAction.perform();
        robot.setAutoDelay(2000);
        StringSelection str = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        robot.setAutoDelay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.setAutoDelay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
