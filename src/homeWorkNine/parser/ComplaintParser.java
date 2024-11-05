package src.homeWorkNine.parser;

import src.homeWorkNine.model.Complaint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ComplaintParser {
    private static final int CLIENT_ID = 0;
    private static final int CALL_TIME = 1;
    private static final int CLIENT_NAME = 2;
    private static final int CLIENT_PHONE = 3;
    private static final int COMPLAINT_TEXT = 4;

    public List<Complaint> parseComplaintFromFile(String filePath) throws IOException {
        List<Complaint> complaints = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",\\s*");
                if (parts.length == 5) {
                    int clientID = Integer.parseInt(parts[CLIENT_ID]);
                    LocalDateTime callTime = LocalDateTime.parse(parts[CALL_TIME]);
                    String clientName = parts[CLIENT_NAME];
                    String clientPhone = parts[CLIENT_PHONE];
                    String complaintText = parts[COMPLAINT_TEXT];
                    complaints.add(new Complaint(clientID, callTime, clientName, clientPhone, complaintText));
                }
            }
        }
        return complaints;
    }
}
