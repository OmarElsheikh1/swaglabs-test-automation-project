package com.swaglabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {

    // Constructor to prevent instantiating this class
    private ElementActions() {

    }

    // sendKeys
    public static void sendData(WebDriver driver, By locator, String data) {
        // code
        Waits.waitForElementVisibility(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        myFindElement(driver, locator).sendKeys(data);
    }

    // click
    public static void clickElement(WebDriver driver, By locator) {
        // code
        Waits.waitForElementClickability(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        myFindElement(driver, locator).click();
    }

    public static String myGetText(WebDriver driver, By locator) {
        Waits.waitForElementVisibility(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        return myFindElement(driver, locator).getText();
    }

    // Find element
    public static WebElement myFindElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }
}
