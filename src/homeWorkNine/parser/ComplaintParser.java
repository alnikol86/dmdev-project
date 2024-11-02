package src.homeWorkNine.parser;

import src.homeWorkNine.model.Complaint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ComplaintParser {
    public List<Complaint> parseComplaintFromFile(String filePath) throws IOException {
        List<Complaint> complaints = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",\\s*");
                if (parts.length == 5) {
                    int clientID = Integer.parseInt(parts[0]);
                    LocalDateTime callTime = LocalDateTime.parse(parts[1]);
                    String clientName = parts[2];
                    String clientPhone = parts[3];
                    String complaintText = parts[4];
                    complaints.add(new Complaint(clientID, callTime, clientName, clientPhone, complaintText));
                }
            }
        }
        return complaints;
    }
}
