package src.homeWorkNine.service;

import java.io.FileWriter;
import java.io.IOException;

public class ComplaintLogger {
    public static synchronized void logToFile(String filePath, String logEntry) {
    try (FileWriter writer = new FileWriter(filePath, true)) {
        writer.write(logEntry + System.lineSeparator());
    } catch (IOException e) {
        System.err.println("Error writing to file: " + e.getMessage());
    }
    }
}
