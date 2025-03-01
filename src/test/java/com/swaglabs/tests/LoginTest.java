package com.swaglabs.tests;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    // Variables
//    private WebDriver driver;

    // Tests
    @Test
    public void successfulLogin() {
        new LoginPage(DriverManager.getDriver()).enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton()
                .assertSuccessfulLogin();
    }

    // Configurations
    @BeforeMethod
    public void setup() {
        // code
        DriverManager.createInstance("edge");
        new LoginPage(DriverManager.getDriver()).navigateToLoginPage();
    }

    @AfterMethod
    public void tearDown() {
        // code
        //DriverManager.getDriver().quit();

        // Assert all
        // CustomSoftAssertion.customAssertAll();
    }
}