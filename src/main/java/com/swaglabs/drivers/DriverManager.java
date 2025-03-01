package com.swaglabs.drivers;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;


/**
 * The DriverManager class handles the creation and retrieval of the WebDriver instance.
 * It uses a ThreadLocal to ensure that each thread running tests gets its own WebDriver instance.
 */

public class DriverManager {

    // ThreadLocal to store the WebDriver instance per thread.
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    // Constructor to prevent instantiating this class
    private DriverManager() {
        // We can remove super() , as it's added automatically by Java
        super();
    }

    /**
     * Creates a new WebDriver instance based on the provided browser name.
     * It retrieves the appropriate WebDriver from the BrowserFactory,
     * stores it in a ThreadLocal variable, and then returns it.
     *
     * @param browserName The name of the browser for which to create the WebDriver.
     * @return The WebDriver instance for the current thread.
     */

    public static WebDriver createInstance(String browserName) {
        // Get the WebDriver instance for the specified browser.
        WebDriver driver = BrowserFactory.getBrowser(browserName);
        // Store the instance in the ThreadLocal variable.
        setDriver(driver);
        // Return the stored WebDriver instance.
        return getDriver();
    }

    /**
     * Retrieves the WebDriver instance for the current thread.
     * If no driver has been set, the test will fail with an error message.
     *
     * @return The WebDriver instance for the current thread.
     */
    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            // If the driver is not set, fail the test with an appropriate message.
            fail("Driver is null. Please set the driver.");
        }
        return driverThreadLocal.get();
    }

    /**
     * Sets the WebDriver instance for the current thread.
     *
     * @param driver The WebDriver instance to store.
     */

    public static void setDriver(WebDriver driver) {
        DriverManager.driverThreadLocal.set(driver);
    }

}