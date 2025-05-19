package com.swaglabs.utils;

import io.qameta.allure.Allure;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllureUtils {

    public static final String ALLURE_RESULTS_PATH = "test-outputs/allure-results";

    private AllureUtils() {
        // Prevent instantiation
        super();
    }

    public static void attachLogsToAllureReport() {
        try {
            File logFile = FilesUtils.getLatestFile(LogsUtils.LOGS_PATH);
            if (logFile == null || !logFile.exists()) {
                LogsUtils.warn("Log file doesn't exist:" + LogsUtils.LOGS_PATH);
                return;
            }

            Allure.addAttachment("logs.log", Files.readString(Path.of(logFile.getPath())));
            LogsUtils.info("Attached logs to Allure report");
        } catch (Exception e) {
            LogsUtils.error("Failed to attach logs to Allure report: " + e.getMessage());
        }
    }

    public static void attachScreenshotToAllure(String screenshotName, String screenshotPath) {
        try {
            Allure.addAttachment(screenshotName, "image/png", Files.newInputStream(Path.of(screenshotPath)), "png");
//            Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenshotPath)));
        } catch (Exception e) {
            LogsUtils.error("Failed to attach screenshot to Allure report: " + e.getMessage());
        }
    }
}