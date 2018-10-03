package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * Factory to instantiate a WebDriver object.
 * It returns an instance of the driver (local invocation) or an instance of RemoteWebDriver
 *
 */
public class WebDriverFactory {

    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";

    private WebDriverFactory() {
    }

    public static WebDriver getInstance(Browser browser) {
        //TODO: add brower drivers for Firefox, Chrome, IE/Edge, Safari for Windows/Linux/Mac
        WebDriver webDriver = null;
        DesiredCapabilities capability = new DesiredCapabilities();
        String browserName = browser.getName();
        capability.setJavascriptEnabled(true);
        return getInstance(browserName);
    }

    public static WebDriver getInstance(String browser) {

        WebDriver webDriver = null;

        if (CHROME.equals(browser)) {
            setChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            webDriver = new ChromeDriver(options);
        } else if (FIREFOX.equals(browser)) {
            webDriver = new FirefoxDriver();
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }

    private static void setChromeDriver() {
        String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
        String chromeBinary = "src/main/resources/drivers/chrome/chromedriver" + (os.equals("win") ? ".exe" : "");
        System.setProperty("webdriver.chrome.driver", chromeBinary);
    }
}
