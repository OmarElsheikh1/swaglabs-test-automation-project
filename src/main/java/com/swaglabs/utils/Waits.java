package com.swaglabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    // Constructor to prevent instantiating this class
    private Waits() {

    }

    // present - visible - clickable

    // Wait for element to be present
    public static WebElement waitForElementPresence(WebDriver driver, By locator) {
        // code
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 -> driver1.findElement(locator));
    }

    // Wait for element to be visible
    public static WebElement waitForElementVisibility(WebDriver driver, By locator) {
        // code
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 ->
                        {
                            WebElement element = waitForElementPresence(driver, locator);
                            return element.isDisplayed() ? element : null;
                        }
                );
    }

    // Wait for element to be clickable
    public static WebElement waitForElementClickability(WebDriver driver, By locator) {
        // code
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 ->
                        {
                            WebElement element = waitForElementVisibility(driver, locator);
                            return element.isEnabled() ? element : null;
                        }
                );
    }
}