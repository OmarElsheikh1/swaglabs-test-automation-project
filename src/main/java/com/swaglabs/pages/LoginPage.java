package com.swaglabs.pages;

import com.swaglabs.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    // Variables
    private final WebDriver driver;

    // Locators
    private final By username = By.id("user-name");
    private final By password = By.cssSelector("#password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test = 'error']");


    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    // Navigate to the login page
    public void navigateToLoginPage() {
        BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/");
    }


    // Actions >>> wait - scroll - find - sendKeys
    public LoginPage enterUsername(String username) {
        // driver, locator, value
        ElementActions.sendData(driver, this.username, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        // driver, locator, value
        ElementActions.sendData(driver, this.password, password);
        return this;
    }

    public LoginPage clickLoginButton() {
        ElementActions.clickElement(driver, this.loginButton);
        return this;
    }


    // Error message in case of unsuccessful login
    public String getErrorMessage() {
        return ElementActions.myGetText(driver, errorMessage);
    }


    // Validations (TestNG)
    public LoginPage assertLoginPageURL() {
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentURL(driver), "https://www.saucedemo.com/inventory.html", "URL isn't as expected");
        return this;
    }

    public LoginPage assertLoginPageTitle() {
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getPageTitle(driver), "Swag Labs", "Title isn't as expected");
        return this;
    }

    public LoginPage assertSuccessfulLoginSoft() {
        assertLoginPageURL().assertLoginPageTitle();
        return this;
    }

    public LoginPage assertSuccessfulLogin() {
        Validations.validatePageURL(driver, "https://www.saucedemo.com/inventory.html");
        return this;
    }

    public LoginPage assertUnsuccessfulLogin() {
        Validations.validateEquals(getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Error message isn't as expected");
        return this;
    }

}