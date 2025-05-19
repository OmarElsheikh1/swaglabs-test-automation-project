package com.swaglabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {

    // Constructor to prevent instantiating this class
    private Validations() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Step ("Validate True")
    public static void validateTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    @Step ("Validate False")
    public static void validateFalse(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    @Step ("Validate Equals")
    public static void validateEquals(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    @Step ("Validate Not Equals")
    public static void validateNotEquals(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    @Step ("Validate Page URL: {expected}")
    public static void validatePageURL(WebDriver driver, String expected) {
//        Assert.assertEquals(driver.getCurrentUrl(), expected);
        Assert.assertEquals(BrowserActions.getCurrentURL(driver), expected);
    }

    @Step ("Validate Page Title: {expected}")
    public static void validatePageTitle(WebDriver driver, String expected) {
//         Assert.assertEquals(driver.getTitle(), expected);
        Assert.assertEquals(BrowserActions.getPageTitle(driver), expected);
    }
}