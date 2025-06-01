package com.swaglabs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

/**
 * PropertiesUtils is a utility class for loading properties from files and retrieving property values.
 * It reads all properties files from a specified directory and merges them into the system properties.
 */
public class PropertiesUtils {

    private PropertiesUtils() {
        // Private constructor to prevent instantiation
        super();
    }
    public final static String PROPERTIES_PATH = "src/mainTry/resources/";

    public static Properties loadProperties() {

        try {
            Properties properties = new Properties();
            Collection<File> propertiesFilesList;
            propertiesFilesList = FilesUtils.listFiles(new File(PROPERTIES_PATH), new String[]{"properties"}, true);
            propertiesFilesList.forEach(propertyFile -> {
                try {
                    properties.load(new FileInputStream(propertyFile));
                } catch (IOException ioe) {
                    LogsUtils.error(ioe.getMessage());
                }
//                properties.putAll(System.getProperties());
//                System.getProperties().putAll(properties);
                System.getProperties().putAll(properties);  // That's enough
            });
            LogsUtils.info("Loading Properties File Data");
            return properties;
        } catch (Exception e) {
            LogsUtils.error("Failed to Load Properties File Data because: " + e.getMessage());
            return null;
        }
    }

    // Get the value of a property by its key
    public static String getPropertyValue(String Key) {

        try {
            return System.getProperty(Key);
        } catch (Exception e) {
            LogsUtils.error(e.getMessage());
            return "";
        }
    }
}