package com.lessonplanet.pages;

import logs.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestData;

import java.util.ArrayList;
import java.util.List;

public class LpUiBasePage {

    protected WebDriver driver;
    private WebDriverWait webDriverWait;
    private JavascriptExecutor javascriptExecutor;
    private boolean isQaIntegrationCookieCreated = false;

    protected LpUiBasePage(WebDriver driver) {
        this.driver = driver;
        javascriptExecutor = (JavascriptExecutor) driver;
        webDriverWait = new WebDriverWait(driver, TestData.SHORT_TIMEOUT);
    }

    protected WebElement findElement(String cssSelector) {
        Log.logStart("Finding Element " + cssSelector);
        waitForElement(cssSelector);
        Log.logEnd("Element found " + cssSelector);
        return driver.findElement(By.cssSelector(cssSelector));
    }

    protected boolean isElementClickable(String cssSelector) {
        waitForLoad();
        Log.logStart("Is element " + cssSelector + " clickable?");
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
            Log.logEnd("Element " + cssSelector + " is clickable");
            return true;
        } catch (Exception e) {
            Log.warn("Element " + cssSelector + " is not clickable");
            return false;
        }
    }

    protected boolean isElementVisible(String cssSelector) {
        Log.logStart("Is element " + cssSelector + " visible?");
        ;
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
            Log.logEnd("Element " + cssSelector + " is visible");
            return true;
        } catch (TimeoutException timeoutException) {
            Log.warn("Element " + cssSelector + " is not visible");
            return false;
        }
    }

    protected void waitForElementToBeVisible(String cssSelector) {
        waitForLoad();
        Log.logStart("Is element " + cssSelector + " visible?");
        ;
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
            Log.logEnd("Element " + cssSelector + " is visible");
        } catch (TimeoutException timeoutException) {
            Log.warn("Element " + cssSelector + " is not visible");
        }
    }

    private void waitUntilElementIsClickable(WebElement webElement) {
        Log.logStart("Wait until element is visible ");
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        Log.logEnd("Element is visible ");
        Log.logStart("Wait until clickable ");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        Log.logEnd("Element is clickable! ");
    }

    public void uploadUsingTextInput(String fileNameSelector, String path) {
        try {
            sendKeys(fileNameSelector, path);
        } catch (Exception e) {
            Log.error("Cannot upload file");
        }
    }

    protected List<WebElement> findElements(String cssLocator) {
        waitForElement(cssLocator);
        return driver.findElements(By.cssSelector(cssLocator));
    }

    protected List<WebElement> findElements(WebElement element, String cssSelector) {
        List<WebElement> result;
        waitForElement(cssSelector);
        try {
            Log.logStart("Find elements " + cssSelector + " in element" + element);
            result = element.findElements(By.cssSelector(cssSelector));
            Log.logEnd("Elements " + cssSelector + " was found in element " + element);
            return result;
        } catch (Exception e) {
            Log.warn("Element " + cssSelector + " cannot be found in the current " + element);
        }
        return null;
    }

    protected void waitForElement(String cssSelector) {
        waitForLoad();
        Log.info("Wait until " + cssSelector + "is clickable");
        try {
            Log.logStart("Wait until " + cssSelector + " is clickable");
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
            Log.logEnd("Element: " + cssSelector + " is clickable");
            Log.logStart("Wait until " + cssSelector + " is visible");
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
            Log.logEnd("Element: " + cssSelector + " is visible");
        } catch (TimeoutException timeoutException) {
            Log.warn("Element " + cssSelector + " is not visible or clickable");
        }
    }

    protected void sendKeys(String cssLocator, String text) {
        waitForLoad();
        Log.info("Sending " + " text " + "to: " + cssLocator);
        findElement(cssLocator).sendKeys(text);
        Log.info("Sent " + " text " + "to: " + cssLocator);
        waitForLoad();
    }

    protected void setValueForWebElement(WebElement webElement, String value) {
        waitForLoad();
        javascriptExecutor.executeScript("arguments[0].value='" + value + "';", webElement);
        waitForLoad();
    }

    protected void clearText(String cssSelector) {
        Log.info("Clearing text from: " + cssSelector);
        findElement(cssSelector).clear();
        waitForLoad();
        Log.info(cssSelector + " is empty");
    }

    protected void clickElement(String cssLocator) {
        Log.info("Click on element: " + cssLocator);
        try {
            clickElement(findElement(cssLocator));
        } catch (NoSuchElementException e) {
            Log.warn("The element " + cssLocator + " still not clickable");
        }
        Log.info("Clicked on element " + cssLocator);
    }

    public void clickElement(WebElement webElement) {
        waitForLoad();
        boolean elementWasClicked = false;
        int attempts = TestData.LONG_TIMEOUT;
        do {
            try {
                waitUntilElementIsClickable(webElement);
                webElement.click();
                elementWasClicked = true;
            } catch (Exception ex) {
                attempts--;
            }
        } while (!elementWasClicked && attempts > 0);
        if (attempts == 0) {
            throw new Error("Unable to click on webElement " + webElement);
        }
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
        Log.info("Click on element: " + cssSelector + " at position " + position);
        try {
            clickElement(findElements(cssSelector), position);
        } catch (NoSuchElementException e) {
            Log.warn("The element " + cssSelector + " is not clickable at position" + position);
        }
        Log.info("Clicked on element " + cssSelector + " at position " + position);
    }

    protected void clickElement(String parentCssSelector, String childCssSelector, int childPosition) {
        clickElement(findElements(findElement(parentCssSelector), childCssSelector).get(childPosition));
    }

    protected void clickElementUsingJavaScriptExecutor(String cssSelector) {
        javascriptExecutor.executeScript("arguments[0].click();", findElement(cssSelector));
    }

    protected String getTextForElement(WebElement element) {
        waitForLoad();
        return element.getText();
    }

    protected String getTextForElement(WebElement element, String cssLocator) {
        waitForLoad();
        return findElements(element, cssLocator).get(0).getText();
    }

    protected String getTextForElement(String cssSelector) {
        Log.info("Getting text for element: " + cssSelector);
        return getTextForElement(findElement(cssSelector));
    }

    protected String getTextForElement(String cssSelector, int position) {
        return getTextForElement(findElements(cssSelector).get(position));
    }

    protected String getTextForNotification(String cssSelector) {
        int counter = TestData.LONG_TIMEOUT;
        while (counter > 0) {
            counter--;
            try {
                Log.info("Waiting for element " + cssSelector + "to be displayed");
                waitUntilElementIsDisplayed(cssSelector);
                String str = getTextForElement(cssSelector);
                if (!str.equals(""))
                    return str;
            } catch (Exception ex) {
                Log.warn("The element is not displayed " + cssSelector + " " + ex.toString());
            }
        }
        return "";
    }

    protected void loadUrl(String pagePath) {
        if (!isQaIntegrationCookieCreated) {
            try {
                if (!TestData.IP_IS_WHITELISTED) {
                    driver.get(TestData.SERVER_URL.replace("://", "://demo:hqu5duYLqbyi6@"));
                } else {
                    driver.get(TestData.SERVER_URL + TestData.LP_HOME_PAGE_PATH);
                }
                createQaIntegrationBypassCookie();
                isQaIntegrationCookieCreated = true;
            } catch (Exception ex) {
                Log.warn(ex.toString());
            }
        }
        if (getUrl().contains(TestData.SERVER_URL)) {
            waitForLoad();
        }
        final String url = TestData.SERVER_URL + pagePath;
        Log.info("Accessing: " + url);
        driver.get(url);
        waitForLoad();
    }

    public String getPath() {
        waitForLoad();
        try {
            String path[] = getUrl().split(".com/");
            Log.info("Path: " + path[1]);
            return path[1];
        } catch (Exception e) {
            Log.info("The homepage is loaded.");
            return "";
        }
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void waitForPageLoad() {
        Log.logStart("Waiting for jQuery to complete");
        try {
            webDriverWait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    return (Boolean) javascriptExecutor.executeScript("return !!window.jQuery && window.jQuery.active == 0");
                }
            });
            Log.logEnd("jQuery completed");
        } catch (Exception ex) {
            Log.warn("jQuery is not completed: " + ex.toString());
        }
        waitUntilDocumentIsReady();
    }

    public void waitUntilDocumentIsReady() {
        Log.logStart("Waiting for document to be ready");
        webDriverWait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) javascriptExecutor.executeScript("return document.readyState == 'complete'");
            }
        });
        Log.logEnd("Document is ready");
    }

    public void waitForLoad() {
        Log.info("Waiting for load");
        waitForLinkToLoad();
        waitForPageLoad();
        waitUntilDocumentIsReady();
        waitForAngularLoad();
        waitForAxiosRequests();
        Log.info("Waited for load");
    }

    public void waitForAngularLoad() {
        String angularReadyScript = "var ngAppElement = document.querySelectorAll('[ng-app]')[0];" +
            "if (typeof(angular) != 'undefined' && typeof(ngAppElement) != 'undefined') {" +
            "var ngElem = angular.element(ngAppElement); " +
            "return ngElem.injector().get('$http').pendingRequests.length == 0" +
            "} else {" +
            "return true;" +
            "}";
        Log.logStart("Waiting for Angular to load");
        try {
            webDriverWait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    try {
                        return (Boolean) javascriptExecutor.executeScript(angularReadyScript);
                    } catch (Exception ex) {
                        Log.warn("Angular is not defined");
                        return true;
                    }
                }
            });
        } catch (Exception ex) {
            Log.logEnd("The Angular modal is not found " + ex.toString());
        }
        Log.logEnd("Waited for Angular to load");
    }

    public void waitForAxiosRequests() {
        String axiosReadyScript = "if (!Number.isNaN(window.axiosRequests) && window.axiosRequests !== null && typeof(window.axiosRequests) != 'undefined'){" +
            "    return window.axiosRequests <= 0" +
            "  }else{" +
            "    return true;}";
        Log.logStart("Wait for Axios to load");
        try {
            webDriverWait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    return (Boolean) javascriptExecutor.executeScript(axiosReadyScript);
                }
            });
        } catch (Exception ex) {
            Log.warn("The Axios modal is not found " + ex.toString());
        }
        Log.logEnd("Waited for Axios to load");
    }

    public void dragAndDrop(WebElement element, WebElement target) {
        waitForLoad();
        try {
            (new Actions(driver)).dragAndDrop(element, target).perform();
        } catch (Exception e) {
            Log.info("The webElement is not visible");
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
        try {
            (new Actions(driver)).moveToElement(element).build().perform();
        } catch (StaleElementReferenceException exception) {
            Log.warn("Element is stale " + element);
        }
        waitForLoad();
    }

    protected void hoverOverElement(String cssSelector) {
        Log.info("Hovering over " + cssSelector);
        hoverOverElement(findElement(cssSelector));
        Log.info("Hovered over " + cssSelector);
    }

    protected void hoverOverElement(String cssSelector, int position) {
        Log.info("Hovering over " + cssSelector + " at position " + position);
        hoverOverElement(findElements(cssSelector).get(position));
        Log.info("Hovered over " + cssSelector + " at position " + position);
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
        Log.info("Scrolling to element");
        waitForLoad();
        try {
            javascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", element);
        } catch (StaleElementReferenceException staleElementReferenceException) {
            Log.warn("Element is stale " + element);
        }
        waitForLoad();
    }

    protected void scrollToElement(String cssSelector) {
        Log.info("Scrolling to: " + cssSelector);
        scrollToElement(findElement(cssSelector));
    }

    protected void scrollToElement(String cssSelector, int index) {
        scrollToElement(findElements(cssSelector).get(index));
    }

    protected void scrollElementWithOffset(WebElement scrollableElement, WebElement referenceElement) {
        int heightToScroll = (int) (Integer.parseInt(referenceElement.getAttribute("height")) * 2.40) + scrollableElement.getLocation().getY() - referenceElement.getLocation().getY();
        javascriptExecutor.executeScript("arguments[0].scroll(0,arguments[1])", scrollableElement, heightToScroll);
    }

    private void scrollWithOffsetForEditCollection(WebElement scrollableElement, WebElement scrollableElementContentRoot, WebElement referenceElement) {
        int heightToScroll = (int) (referenceElement.getLocation().getY() * 0.5 + scrollableElementContentRoot.getLocation().getY() * 2.1);
        if (heightToScroll > 0) {
            javascriptExecutor.executeScript("arguments[0].scroll(0,arguments[1])", scrollableElement, heightToScroll);
        }
    }

    protected void scrollWithOffsetForEditCollection(String scrollableElement, String scrollableElementContentRoot, String referenceElement) {
        scrollWithOffsetForEditCollection(findElement(scrollableElement), findElement(scrollableElementContentRoot), findElement(referenceElement));
    }

    protected void waitUntilElementIsHidden(String cssSelector) {
        Log.logStart("Waiting until webElement is hidden " + cssSelector);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(cssSelector)));
        Log.logEnd("Waited until webElement was hidden " + cssSelector);
    }

    protected void waitUntilElementIsHidden(String cssSelector, int seconds) {
        Log.logStart("Waiting until webElement is hidden " + cssSelector);
        WebDriverWait customWait = new WebDriverWait(driver, seconds);
        customWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(cssSelector)));
        Log.logEnd("Waited until webElement was hidden " + cssSelector);
    }

    protected void waitUntilElementIsDisplayed(String cssSelector) {
        Log.logStart("Wait until webElement is displayed " + cssSelector);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
        Log.logEnd("Waited to webElement to be displayed " + cssSelector);
    }

    protected void waitUntilElementIsDisplayed(WebElement webElement) {
        Log.logStart("Wait until webElement is displayed ");
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception ex) {
            Log.warn("WebElement is not displayed ");
        }
        Log.logEnd("Waited to webElement to be displayed ");
    }

    protected void waitUntilTextIsDisplayed(String cssSelector, String text) {
        Log.logStart("Waiting until text is " + text + " displayed for webElement " + cssSelector);
        webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(cssSelector), text));
        Log.logEnd("Waited until text was " + text + " displayed for webElement " + cssSelector);
    }

    protected void createQaIntegrationBypassCookie() {
        driver.manage().addCookie(new Cookie(TestData.STAGING_SERVER_QA_INTEGRATION_COOKIE_NAME, ""));
    }

    protected void openInANewTab(String cssSelector) {
        Log.info("Opening a new tab: ");
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
        Log.info("Opening a new tab and accessing the url: " + url);
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
            Log.info("Opening a new tab: ");
            openInANewTab(webElement);
        } else {
            Log.info("Open in the same tab: ");
            clickElement(webElement);
        }
    }

    protected void openInANewTabOrClick(String cssSelector, boolean inANewTab) {
        if (inANewTab) {
            Log.info("Opening a new tab: ");
            openInANewTab(cssSelector);
        } else {
            Log.info("Open in the same tab: ");
            clickElement(cssSelector);
        }
    }

    public void closeTab() {
        Log.info("Closing the tab");
        driver.close();
        Log.info("Closed the tab");
        focusDriverToLastTab();
        waitForLoad();
    }

    public void focusDriverToLastTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        Log.info("Focusing on the last tab");
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
        Log.logStart("Wait for link to load");
        webDriverWait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (!driver.getCurrentUrl().contains(TestData.EMPTY_URL));
            }
        });
        Log.logEnd("Waited for link to load");
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
            Log.error("The option " + option + " was not found.");
        }
        waitForLoad();
    }

    public void selectFromDropdownWithSearch(String dropdownCssSelector, String optionsCssSelector, String textToSearch) {
        boolean optionWasFound = false;
        waitForLoad();
        sendKeys(dropdownCssSelector, textToSearch);
        List<WebElement> results = findElements(optionsCssSelector);
        for (WebElement result : results) {
            if (result.getText().startsWith(textToSearch)) {
                clickElement(result);
                optionWasFound = true;
                break;
            }
        }
        if (!optionWasFound) {
            Log.error("The text " + textToSearch + " was not found.");
        }
        waitForLoad();
    }

    public void waitForBootstrapModalToBeVisible(String modalId) {
        waitForLoad();
        Log.logStart("Waiting for Bootstrap modal to be visible " + modalId);
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
            Log.logEnd("Waited for Bootstrap modal to be visible " + modalId);
            waitForLoad();
        } catch (Exception ex) {
            Log.warn("The Bootstrap modal is not visible " + ex.toString());
        }
    }

    public void waitForReactModalToBeVisible() {
        waitForLoad();
        Log.logStart("Wait for React modal to be visible");
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
            Log.logEnd("Waited for React modal to be visible");
            waitForLoad();
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.react-modal-overlay")));
        } catch (Exception ex) {
            Log.warn("The React modal is not visible " + ex.toString());
        }
    }

    public boolean isElementDisplayed(String cssLocator) {
        waitForLoad();
        try {
            driver.findElement(By.cssSelector(cssLocator)).isDisplayed();
            return true;
        } catch (StaleElementReferenceException | org.openqa.selenium.NoSuchElementException ex) {
            Log.warn("Element  is  not  displayed " + cssLocator);
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
            Log.warn("Element is  not  displayed " + cssLocator);
            return false;
        }
    }

    public String getElementId(String cssSelector) {
        return getElementAttribute(cssSelector, "id");
    }

    protected String getBackgroundColor(String cssSelector) {
        waitForLoad();
        return Color.fromString(findElement(cssSelector).getCssValue("background-color")).asHex();
    }

    public String getElementAttribute(String cssSelector, String attributeName, int position) {
        try {
            return findElements(cssSelector).get(position).getAttribute(attributeName);
        } catch (org.openqa.selenium.NoSuchElementException | java.lang.IndexOutOfBoundsException ex) {
            return null;
        }
    }

    public String getElementAttribute(String cssSelector, String attributeName) {
        return getElementAttribute(cssSelector, attributeName, 0);
    }

    public boolean isElementDisplayed(String cssLocator, int position) {
        waitForLoad();
        try {
            driver.findElements(By.cssSelector(cssLocator)).get(position).isDisplayed();
            return true;
        } catch (StaleElementReferenceException | org.openqa.selenium.NoSuchElementException ex) {
            Log.warn("Element is  not  displayed " + cssLocator);
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
            Log.warn("No alert found on page");
        }
    }
}
