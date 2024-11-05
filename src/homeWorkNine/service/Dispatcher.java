package src.homeWorkNine.service;

import src.homeWorkNine.model.Complaint;
import src.homeWorkNine.parser.PhoneNumberFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dispatcher {
    private String name;

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm";
    private static final String PATH_TO_FILE = "resources/call_log.txt";

    public Dispatcher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void handleComplaint(Complaint complaint) {
        try {
            System.out.println("Dispatcher " + this.getName() + " is calling client: " + complaint.getClientName());
            Thread.sleep(3000); // Имитация времени созвона
            System.out.println("Call to client " + complaint.getClientName() + " finished.");
            logCall(complaint);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void logCall(Complaint complaint) {
        String formattedPhone = PhoneNumberFormatter.format(complaint.getPhoneNumber());
        String logEntry = String.format("%d, %s, %s", complaint.getId(), LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_PATTERN)), formattedPhone);
        ComplaintLogger.logToFile(PATH_TO_FILE, logEntry);
    }
}
