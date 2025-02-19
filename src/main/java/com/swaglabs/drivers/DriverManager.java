package com.swaglabs.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.fail;

public class DriverManager {
    // code
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    // Constructor to prevent instantiating this class
    private DriverManager() {
        super();
    }

    public static WebDriver createInstance(String browserName) {
        // code
        WebDriver driver = BrowserFactory.getBrowser(browserName);
        setDriver(driver);
        return getDriver();
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            // code
            fail("Driver is null. Please set the driver.");
        }
        return driverThreadLocal.get();
    }


    public static void setDriver(WebDriver driver) {
        DriverManager.driverThreadLocal.set(driver);
    }


}