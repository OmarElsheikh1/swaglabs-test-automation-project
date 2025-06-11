package com.swaglabs.listeners;

import com.swaglabs.utils.AllureUtils;
import com.swaglabs.utils.FilesUtils;
import com.swaglabs.utils.LogsUtils;
import com.swaglabs.utils.ScreenshotsUtils;
import org.testng.*;

import java.io.File;

import static com.swaglabs.utils.PropertiesUtils.loadProperties;

public class TestNGListeners implements IExecutionListener, ITestListener, IInvokedMethodListener {

    File allure_Results = new File(AllureUtils.ALLURE_RESULTS_PATH);
    File logs = new File("test-outputs/logs");
    File screenshots = new File("test-outputs/screenshots");

    @Override
    public void onExecutionStart() {
        LogsUtils.info("Test Execution started");
        loadProperties();
        FilesUtils.deleteFiles(allure_Results);
        FilesUtils.cleanDirectory(logs);
        FilesUtils.cleanDirectory(screenshots);
    }

    @Override
    public void onExecutionFinish() {
        LogsUtils.info("Test Execution started");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            switch (testResult.getStatus()) {
                case ITestResult.SUCCESS -> ScreenshotsUtils.takeScreenshot("passed-" + testResult.getName());
                case ITestResult.FAILURE -> ScreenshotsUtils.takeScreenshot("failed-" + testResult.getName());
                case ITestResult.SKIP -> ScreenshotsUtils.takeScreenshot("skipped-" + testResult.getName());
            }
            AllureUtils.attachLogsToAllureReport();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogsUtils.info("Test case", result.getName(), " passed");
        // Moved to afterInvocation method
//        ScreenshotsUtils.takeScreenshot("passed-" + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogsUtils.info("Test case", result.getName(), " failed");
        // Moved to afterInvocation method
//        ScreenshotsUtils.takeScreenshot("failed-" + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogsUtils.info("Test case", result.getName(), " skipped");
        // Moved to afterInvocation method
//        ScreenshotsUtils.takeScreenshot("skipped-" + result.getName());
    }
}