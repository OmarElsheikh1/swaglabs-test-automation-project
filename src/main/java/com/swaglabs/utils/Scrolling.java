package com.swaglabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scrolling {

    // Constructor to prevent instantiating this class
    private Scrolling() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // Scroll to element
    public static void scrollToElement(WebDriver driver, By locator) {
        // code
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ElementActions.myFindElement(driver, locator));
    }
}