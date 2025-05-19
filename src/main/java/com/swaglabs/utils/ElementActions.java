package com.swaglabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {

    // Constructor to prevent instantiating this class
    private ElementActions() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // sendKeys
    @Step ("Send data to element: {locator} with data: {data}")
    public static void sendData(WebDriver driver, By locator, String data) {
        // code
        Waits.waitForElementVisibility(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        myFindElement(driver, locator).sendKeys(data);

        // Log the data sent to the element
        LogsUtils.info("Data entered:", data, "in the field", locator.toString());
    }

    // click
    @Step ("Click on element: {locator}")
    public static void clickElement(WebDriver driver, By locator) {
        // code
        Waits.waitForElementClickability(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        myFindElement(driver, locator).click();

        // Log the click action
        LogsUtils.info("Clicked on the element:", locator.toString());
    }

    @Step ("Get text from element: {locator}")
    public static String myGetText(WebDriver driver, By locator) {
        Waits.waitForElementVisibility(driver, locator);
        Scrolling.scrollToElement(driver, locator);

        // Log the text retrieved from the element
        LogsUtils.info("Getting text from the element:", locator.toString(), "Text:", myFindElement(driver, locator).getText());

        return myFindElement(driver, locator).getText();
    }

    // Find element
    public static WebElement myFindElement(WebDriver driver, By locator) {

        // Log the action of finding the element
        LogsUtils.info("Finding element: ", locator.toString());

        return driver.findElement(locator);
    }
}
