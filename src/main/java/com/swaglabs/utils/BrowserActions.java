package com.swaglabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BrowserActions {

    // Constructor to prevent instantiating this class
    private BrowserActions() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Step ("Navigate to URL: {url}")
    public static void navigateToURL(WebDriver driver, String url) {
        driver.navigate().to(url);

        // Log the navigation action
        LogsUtils.info("Navigated to URL:", url);
    }

    // Get current URL
    @Step ("Get current URL")
    public static String getCurrentURL(WebDriver driver) {
        // Log the current URL
        LogsUtils.info("Current URL:", driver.getCurrentUrl());

        return driver.getCurrentUrl();
    }

    // Get page title
    @Step ("Get page title")
    public static String getPageTitle(WebDriver driver) {
        // Log the page title
        LogsUtils.info("Page title:", driver.getTitle());

        return driver.getTitle();
    }

    // Refresh page
    @Step ("Refresh page")
    public static void refreshPage(WebDriver driver) {
        // Log the refresh action
        LogsUtils.info("Refreshing the page");

        driver.navigate().refresh();
    }

    // Close browser
    @Step ("Closing the browser")
    public static void closeBrowser(WebDriver driver) {
        // Log the action of closing the browser
        LogsUtils.info("Closing the browser");

        driver.quit();
    }
}
