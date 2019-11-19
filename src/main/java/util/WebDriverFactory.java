package util;

import helpers.BrowserName;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    private final static String BROWSER_SYSTEM_VAR = "browser";

    public WebDriver getInstance() {

        if (StringUtils.isBlank(System.getProperty(BROWSER_SYSTEM_VAR))) {
            throw new IllegalArgumentException("Browser name is not set in VM options. " +
                "Please make sure you're setting the <browser> value before starting the tests " +
                "-- https://www.screencast.com/t/CGYCEL6bc3U --");
        }
        final String browserVariable = System.getProperty(BROWSER_SYSTEM_VAR).toLowerCase();
        WebDriver webDriver;

        if (browserVariable.equals(BrowserName.CHROME.getName())) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("disable-infobars");
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver(options);
        } else if (browserVariable.equals(BrowserName.FIREFOX.getName())) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Browser name is incorrectly set in VM options");
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(TestData.SHORT_TIMEOUT, TimeUnit.SECONDS);
        return webDriver;
    }
}
