package com.swaglabs.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;

public class FilesUtils {
    private FilesUtils() {
        // Prevent instantiation
        super();
    }

    public static File getLatestFile(String foldrPath) {
        File folder = new File(foldrPath);
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            LogsUtils.warn("No files found in directory: " + foldrPath);
            return null;
        }
        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }
        return latestFile;
    }

    public static void deleteFiles(File dirPath) {
        if (dirPath == null || !dirPath.exists()) {
            LogsUtils.warn("Directory does not exist: " + dirPath);
            return;
        }

        File[] fileList = dirPath.listFiles();
        if (fileList == null) {
            LogsUtils.warn("Failed to list files in: " + dirPath);
            return;
        }

        for (File file : fileList) {
            if (file.isDirectory()) {
                deleteFiles(file);
            } else {
                try {
                    Files.delete(file.toPath());
                } catch (IOException e) {
                    LogsUtils.error("Failed to delete file: " + file + " - " + e.getMessage());
                }

            }
        }
    }

    public static void copyFile(File source, File destination) throws IOException {
        Files.copy(source.toPath(), destination.toPath());
    }


    // Revise this section again
    public static Collection<File> listFiles(File file, String[] strings, boolean b) {
        return java.util.List.of();
    }
}