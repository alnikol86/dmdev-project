package src.homeWorkNine.support;

import src.homeWorkNine.service.ComplaintService;
import src.homeWorkNine.service.Dispatcher;
import src.homeWorkNine.parser.ComplaintParser;
import src.homeWorkNine.testData.RandomComplaintGenerator;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) throws IOException {
        ComplaintParser parser = new ComplaintParser();
        Dispatcher dispatcher1 = new Dispatcher("Bob");
        Dispatcher dispatcher2 = new Dispatcher("Tom");
        ComplaintService service = new ComplaintService(Arrays.asList(dispatcher1, dispatcher2), parser);

        service.processComplaint("resources/complaints_log.txt");

//        RandomComplaintGenerator.addRandomComplaint();
    }
}
