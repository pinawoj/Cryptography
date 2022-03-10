package com.pwojcik;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileManager.class);
    private static final String FILE_PATH = "src/main/files";

    public void writeToFile(String message, String fileName) {

        Path filePath = Paths.get(FILE_PATH, fileName);
        try {
            if (!Files.exists(filePath)) {
                LOGGER.info("File {} doesn't exist. Creating new directory...", fileName);
                Files.createDirectories(filePath.getParent());
            }
            Files.write(filePath, message.getBytes());
        } catch (IOException ioe) {
            LOGGER.error("Couldn't write text to file {}", fileName, ioe);
        }

    }

    public String readFromFile(String fileName) {

        String message = "";

        Path filePath = Paths.get(FILE_PATH, fileName);
        try {
            if (Files.exists(filePath)) {
                message = Files.readString(filePath);
            } else {
                LOGGER.warn("File {} doesn't exist. Returned text is empty.", fileName);
            }
        } catch (IOException ioe) {
            LOGGER.error("Couldn't read any text from file {}", fileName);
        }

        return message;
    }

}
