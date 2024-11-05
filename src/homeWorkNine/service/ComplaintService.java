package src.homeWorkNine.service;

import src.homeWorkNine.model.Complaint;
import src.homeWorkNine.parser.ComplaintParser;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComplaintService {
    private final List<Dispatcher> dispatchers;
    private ComplaintParser parser;

    public ComplaintService(List<Dispatcher> dispatchers, ComplaintParser parser) {
        this.dispatchers = dispatchers;
        this.parser = parser;
    }

    public void processComplaint(String logFilePath) throws IOException {
        List<Complaint> complaints = parser.parseComplaintFromFile(logFilePath);
        ExecutorService executor = Executors.newFixedThreadPool(dispatchers.size());
        for (int i = 0; i < complaints.size(); i++) {
            int dispatcherIndex = i % dispatchers.size(); // Индекс диспетчера для обработки текущей жалобы
            Complaint complaint = complaints.get(i);
            executor.execute(() -> dispatchers.get(dispatcherIndex).handleComplaint(complaint));
        }
        executor.shutdown();
    }
}

