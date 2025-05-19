package com.swaglabs.tests;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.AllureUtils;
import com.swaglabs.utils.BrowserActions;
import com.swaglabs.utils.FilesUtils;
import com.swaglabs.utils.ScreenshotsUtils;
import org.testng.annotations.*;

import java.io.File;

public class LoginTest {

    // Variables
//    private WebDriver driver;

    File allure_Results = new File(AllureUtils.ALLURE_RESULTS_PATH);
//    File allure_Results = new File("test-outputs/allure-results");


    // Tests
    @Test
    public void successfulLogin() {
        new LoginPage(DriverManager.getDriver()).enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton()
                .assertSuccessfulLogin();
        ScreenshotsUtils.takeScreenshot("successfulLogin");
    }

    // Configurations
    @BeforeSuite
    public void beforeSuite() {
        // code
        FilesUtils.deleteFiles(allure_Results);
    }

    @BeforeMethod
    public void setup() {
        // code
        DriverManager.createInstance("edge");
        new LoginPage(DriverManager.getDriver()).navigateToLoginPage();
    }

    @AfterMethod
    public void tearDown() {
        // code
        BrowserActions.closeBrowser(DriverManager.getDriver());

        // Assert all
        // CustomSoftAssertion.customAssertAll();
    }

    @AfterClass
    public void afterClass() {
        // code
        AllureUtils.attachLogsToAllureReport();
    }
}