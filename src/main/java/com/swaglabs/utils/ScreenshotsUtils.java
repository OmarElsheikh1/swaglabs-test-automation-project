package com.swaglabs.utils;

import com.swaglabs.drivers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotsUtils {

    public static final String SCREENSHOTS_PATH = "test-outputs/screenshots";

    private ScreenshotsUtils() {
        // Prevent instantiation
        super();
    }

    public static void takeScreenshot(String screenshotName) {
        // code
        try {
            File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            // ✅ Create the target directory if it doesn't exist
            File directory = new File(SCREENSHOTS_PATH);
            if (!directory.exists()) {
                directory.mkdirs(); // create parent folders if necessary
            }

            // ✅ Create the target file, we created it couple of lines below
            //  screenshotFile = new File(SCREENSHOTS_PATH + File.separator + screenshotName + ".png");

            // Add timestamp to the file name
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            // Create the screenshot file with timestamp
            File screenshotFile = new File(SCREENSHOTS_PATH + File.separator + screenshotName + "_" + timestamp + ".png");


            FilesUtils.copyFile(screenshot, screenshotFile);
            AllureUtils.attachScreenshotToAllure(screenshotName, screenshotFile.getPath());
        } catch (Exception e) {
            LogsUtils.error("Failed to take screenshot: " + e.getMessage());
        }
    }
}