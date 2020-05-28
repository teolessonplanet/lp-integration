package util;

import helpers.BrowserName;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    private final static String BROWSER_SYSTEM_VAR = "browser";
    private final static String HEADLESS_SYSTEM_VAR = "headless";
    private final static String IP_WHITELISTED_SYSTEM_VAR = "ipwhitelisted";

    private boolean headlessBrowser = false;
    protected static final Logger logger = LogManager.getRootLogger();

    public WebDriver getInstance() {

        if (StringUtils.isBlank(System.getProperty(BROWSER_SYSTEM_VAR))) {
            throw new IllegalArgumentException("Browser name is not set in VM options. " +
                "Please make sure you're setting the <browser> value before starting the tests " +
                "-- https://www.screencast.com/t/CGYCEL6bc3U --");
        }
        final String browserVariable = System.getProperty(BROWSER_SYSTEM_VAR).toLowerCase();

        try {
            if (System.getProperty(HEADLESS_SYSTEM_VAR).equals("true")) {
                headlessBrowser = true;
            }
        } catch (NullPointerException ex) {
            logger.info("HEADLESS is not set in VM options");
        }

        WebDriver webDriver;

        if (browserVariable.equals(BrowserName.CHROME.getName())) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("disable-infobars");
            if (headlessBrowser) {
                options.addArguments("headless");
                options.addArguments("window-size=1920x1080");
            }
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver(options);
        } else if (browserVariable.equals(BrowserName.FIREFOX.getName())) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (headlessBrowser) {
                firefoxOptions.addArguments("--headless");
            }
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver(firefoxOptions);
            if (headlessBrowser) {
                webDriver.manage().window().setSize(new Dimension(1920, 1080));
            }
        } else {
            throw new IllegalArgumentException("Browser name is incorrectly set in VM options");
        }
        if (!headlessBrowser) {
            webDriver.manage().window().maximize();
        }
        webDriver.manage().timeouts().implicitlyWait(TestData.SHORT_TIMEOUT, TimeUnit.SECONDS);

        try {
            if (System.getProperty(IP_WHITELISTED_SYSTEM_VAR).equals("false")) {
                TestData.IP_IS_WHITELISTED = false;

            }
        } catch (NullPointerException ex) {
            logger.info("WFH is not set in VM options");
        }

        return webDriver;
    }
}
