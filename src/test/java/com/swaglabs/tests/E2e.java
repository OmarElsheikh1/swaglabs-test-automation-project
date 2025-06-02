package com.swaglabs.tests;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.*;
import org.testng.annotations.*;

import java.io.File;

import static com.swaglabs.utils.PropertiesUtils.getPropertyValue;
import static com.swaglabs.utils.PropertiesUtils.loadProperties;

public class E2e {

    // Variables

//    private WebDriver driver;

    // Load properties
    JsonUtils testData;
    File allure_Results = new File(AllureUtils.ALLURE_RESULTS_PATH);
//    File allure_Results = new File("test-outputs/allure-results");


    // Tests
    @Test
    public void successfulLogin() {
//        new LoginPage(DriverManager.getDriver()).enterUsername("standard_user")
//                .enterPassword("secret_sauce")
//                .clickLoginButton()
//                .assertSuccessfulLogin();
//        ScreenshotsUtils.takeScreenshot("successfulLogin");
        new LoginPage(DriverManager.getDriver()).enterUsername(testData.getJsonData("login-credentials.username"))
                .enterPassword(testData.getJsonData("login-credentials.password"))
                .clickLoginButton()
                .assertSuccessfulLogin();
        ScreenshotsUtils.takeScreenshot("successfulLogin");
    }

    // Configurations
    @BeforeSuite
    public void beforeSuite() {
        // Load properties
        loadProperties();
        FilesUtils.deleteFiles(allure_Results);
        testData = new JsonUtils("test-data");
    }

    @BeforeMethod
    public void setup() {
        // code
        String browserName = getPropertyValue("browserType");
        System.out.println("Browser Name: " + browserName);     // Debug
        if (browserName == null) {
            throw new IllegalStateException("browserType property is not set in web.properties");
        }
        DriverManager.createInstance(browserName);
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