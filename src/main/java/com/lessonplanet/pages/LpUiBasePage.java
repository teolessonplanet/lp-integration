package com.lessonplanet.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestData;

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
}
