package src.homeWorkNine.model;

import java.time.LocalDateTime;

public class Complaint {
    private final Integer id;
    private final LocalDateTime callTime;
    private final String clientName;
    private final String phoneNumber;
    private final String complaintText;

    public Complaint(Integer id, LocalDateTime callTime, String clientName, String phoneNumber, String complaintText) {
        this.id = id;
        this.callTime = callTime;
        this.clientName = clientName;
        this.phoneNumber = phoneNumber;
        this.complaintText = complaintText;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getCallTime() {
        return callTime;
    }

    public String getClientName() {
        return clientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getComplaintText() {
        return complaintText;
    }
}
