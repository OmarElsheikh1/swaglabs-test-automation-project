package com.swaglabs.pages;

import com.swaglabs.utils.*;
import io.qameta.allure.Step;
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
    @Step ("Navigate to login page")
    public void navigateToLoginPage() {
        BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/");
    }


    // Actions >>> wait - scroll - find - sendKeys
    @Step ("Enter username: {0}")
    public LoginPage enterUsername(String username) {
        // driver, locator, value
        ElementActions.sendData(driver, this.username, username);
        return this;
    }

    @Step ("Enter password: {0}")
    public LoginPage enterPassword(String password) {
        // driver, locator, value
        ElementActions.sendData(driver, this.password, password);
        return this;
    }

    @Step ("Click on login button")
    public LoginPage clickLoginButton() {
        ElementActions.clickElement(driver, this.loginButton);
        return this;
    }


    // Error message in case of unsuccessful login
    @Step ("Get error message")
    public String getErrorMessage() {
        return ElementActions.myGetText(driver, errorMessage);
    }


    // Validations (TestNG)
    @Step ("Assert login page URL")
    public LoginPage assertLoginPageURL() {
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentURL(driver), "https://www.saucedemo.com/inventory.html", "URL isn't as expected");
        return this;
    }

    @Step ("Assert login page title")
    public LoginPage assertLoginPageTitle() {
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getPageTitle(driver), "Swag Labs", "Title isn't as expected");
        return this;
    }

    @Step ("Assert successful login Soft")
    public LoginPage assertSuccessfulLoginSoft() {
        assertLoginPageURL().assertLoginPageTitle();
        return this;
    }

    @Step ("Assert successful login")
    public LoginPage assertSuccessfulLogin() {
        Validations.validatePageURL(driver, "https://www.saucedemo.com/inventory.html");
        return this;
    }

    @Step ("Assert unsuccessful login")
    public LoginPage assertUnsuccessfulLogin() {
        Validations.validateEquals(getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Error message isn't as expected");
        return this;
    }

}