package com.swaglabs.drivers;

import com.swaglabs.utils.PropertiesUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;

public class BrowserFactory {
    public static WebDriver getBrowser(String browserName) {
        return switch (browserName.toLowerCase()) {
            case "chrome" -> {
                ChromeOptions options = getChromeOptions();
                yield new ChromeDriver(options);
            }
            case "firefox" -> {
                FirefoxOptions firefoxOptions = getFirefoxOptions();
                yield new FirefoxDriver(firefoxOptions);
            }
            default -> {
                EdgeOptions edgeOptions = getEdgeOptions();
                yield new EdgeDriver(edgeOptions);
            }
        };
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--notifications");
        options.addArguments("--remote-allow-origins=*");
        if (PropertiesUtils.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            options.addArguments("--headless");
        }
        Map<String, Object> prefs = Map.of("profile.default_content_setting_values.notifications", 2,
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false,
                "autofill.profile_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return options;
    }

    private static EdgeOptions getEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("start-maximized");
        edgeOptions.addArguments("disable-infobars");
        edgeOptions.addArguments("--disable-extensions");
        edgeOptions.addArguments("--notifications");
        edgeOptions.addArguments("--remote-allow-origins=*");
        if (PropertiesUtils.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            edgeOptions.addArguments("--headless");
        }
        Map<String, Object> edgePrefs = Map.of("profile.default_content_setting_values.notifications", 2,
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false,
                "autofill.profile_enabled", false);
        edgeOptions.setExperimentalOption("prefs", edgePrefs);
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return edgeOptions;
    }

    private static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");
        firefoxOptions.addArguments("disable-infobars");
        firefoxOptions.addArguments("--disable-extensions");
        firefoxOptions.addArguments("--notifications");
        firefoxOptions.addArguments("--remote-allow-origins=*");
        if (PropertiesUtils.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            firefoxOptions.addArguments("--headless");
        }
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        firefoxOptions.setAcceptInsecureCerts(true);
        return firefoxOptions;
    }
}