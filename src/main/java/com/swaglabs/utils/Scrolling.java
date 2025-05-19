package com.swaglabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scrolling {

    // Constructor to prevent instantiating this class
    private Scrolling() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // Scroll to element
    @Step ("Scroll to element: {locator}")
    public static void scrollToElement(WebDriver driver, By locator) {

        // Log the action of scrolling to the element
        LogsUtils.info("Scrolling to the element:", locator.toString());
        // code
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ElementActions.myFindElement(driver, locator));
    }
}