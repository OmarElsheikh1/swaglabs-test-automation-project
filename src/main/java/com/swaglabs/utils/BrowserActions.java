package com.swaglabs.utils;

import org.openqa.selenium.WebDriver;

public class BrowserActions {

    // Constructor to prevent instantiating this class
    private BrowserActions() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void navigateToURL(WebDriver driver, String url) {
        driver.navigate().to(url);
    }

    // Get current URL
    public static String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    // Get page title
    public static String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    // Refresh page
    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }
}
