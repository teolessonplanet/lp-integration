package util;

import com.microsoft.edge.seleniumtools.EdgeDriver;
import com.microsoft.edge.seleniumtools.EdgeOptions;
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
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    private final static String BROWSER_SYSTEM_VAR = "browser";
    private final static String HEADLESS_SYSTEM_VAR = "headless";
    private final static String FIREFOX_PROFILE = "ffprof";
    private final static String IP_WHITELISTED_SYSTEM_VAR = "ipwhitelisted";
    private final static String SERVER_URL_SYSTEM_VAR = "server";
    private final static String SKIP_FACETS = "skipfacets";
    private final static String DRIVER_VERSION = "driverversion";
    private static String browserName;
    private static String driverVersion = "";

    private static boolean headlessBrowser = false;
    private static boolean firefoxDefaultProfile = false;
    protected static final Logger logger = LogManager.getRootLogger();


    public static void getDriverFromInternet() {
        if (StringUtils.isBlank(System.getProperty(BROWSER_SYSTEM_VAR))) {
            throw new IllegalArgumentException("Browser name is not set in VM options. " +
                "Please make sure you're setting the <browser> value before starting the tests " +
                "-- https://www.screencast.com/t/CGYCEL6bc3U --");
        }

        browserName = System.getProperty(BROWSER_SYSTEM_VAR).toLowerCase();

        if (StringUtils.isNoneEmpty(System.getProperty(DRIVER_VERSION))) {
            driverVersion = System.getProperty(DRIVER_VERSION);
        }

        if (browserName.equals(BrowserName.CHROME.getName())) {
            //https://chromedriver.chromium.org/downloads
            if (!driverVersion.isEmpty()) {
                WebDriverManager.chromedriver().driverVersion(driverVersion);
            }
            WebDriverManager.chromedriver().setup();
        }

        if (browserName.equals(BrowserName.FIREFOX.getName())) {
            //https://github.com/mozilla/geckodriver/releases
            if (!driverVersion.isEmpty()) {
                WebDriverManager.firefoxdriver().driverVersion(driverVersion);
            }
            WebDriverManager.firefoxdriver().setup();
        }

        if (browserName.equals(BrowserName.EDGE.getName())) {
            //https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
            //https://msedgewebdriverstorage.z22.web.core.windows.net/
            if (!driverVersion.isEmpty()) {
                WebDriverManager.edgedriver().driverVersion(driverVersion);
            }
            WebDriverManager.edgedriver().setup();
        }
    }

    public static WebDriver getInstance() {

        if (StringUtils.isBlank(System.getProperty(BROWSER_SYSTEM_VAR))) {
            throw new IllegalArgumentException("Browser name is not set in VM options. " +
                "Please make sure you're setting the <browser> value before starting the tests " +
                "-- https://www.screencast.com/t/CGYCEL6bc3U --");
        }

        try {
            if (System.getProperty(HEADLESS_SYSTEM_VAR).equals("true")) {
                headlessBrowser = true;
            }
        } catch (NullPointerException ex) {
            logger.info("HEADLESS is not set in VM options");
        }

        try {
            if (System.getProperty(FIREFOX_PROFILE).equals("true")) {
                firefoxDefaultProfile = true;
            }
        } catch (NullPointerException ex) {
            logger.info("ffprof is not set in VM options");
        }

        WebDriver webDriver;

        if (browserName.equals(BrowserName.CHROME.getName())) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("disable-infobars");

            if (headlessBrowser) {
                options.addArguments("headless");
                options.addArguments("window-size=1920x2160");
            }
            webDriver = new ChromeDriver(options);
        } else if (browserName.equals(BrowserName.FIREFOX.getName())) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();

            if (firefoxDefaultProfile) {
                ProfilesIni profile = new ProfilesIni();
                FirefoxProfile firefoxProfile = profile.getProfile("default");
                firefoxOptions.setProfile(firefoxProfile);
            }

            if (headlessBrowser) {
                firefoxOptions.addArguments("--headless");
            }

            webDriver = new FirefoxDriver(firefoxOptions);
            if (headlessBrowser) {
                webDriver.manage().window().setSize(new Dimension(1920, 2160));
            }
        } else if (browserName.equals(BrowserName.EDGE.getName())) {
            webDriver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser name is incorrectly set in VM options");
        }
        if (!headlessBrowser || browserName.equals(BrowserName.EDGE.getName())) {
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

        try {
            if (System.getProperty(SERVER_URL_SYSTEM_VAR).equals("feature")) {
                TestData.SERVER_URL = TestData.FEATURE_URL;
            }
        } catch (NullPointerException ex) {
            logger.info("Server is not set in VM options - running on Staging by default");
        }

        try {
            if (System.getProperty(SKIP_FACETS).equals("true")) {
                TestData.SKIP_FACET_FILTERS = true;
            }
        } catch (NullPointerException ex) {
            logger.info("SKIP facet filter is not set in VM options");
        }

        return webDriver;
    }
}
