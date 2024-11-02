package src.homeWorkNine.testData;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RandomComplaintGenerator {
    private static final String FILE_PATH = "resources/complaints_log.txt";
    private static final String[] NAMES = {"Ivan", "Petr", "Vasya", "Maria", "Anna"};
    private static final String[] COMPLAINTS = {
            "Не включается свет",
            "Почему опять не работает интернет?",
            "Кто-то оборвал мне телефонный кабель",
            "Шумный сосед",
            "Не работает кондиционер"
    };
    private static final Random RANDOM = new Random();
    private static Integer complaintNumber = 1;

    public static void addRandomComplaint() throws IOException {
        if (Files.exists(Path.of(FILE_PATH))) {
            complaintNumber = (int) Files.lines(Path.of(FILE_PATH)).count() + 1;
        }

        while (true) {
            try {
                String dateTime = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
                String randomName = NAMES[RANDOM.nextInt(NAMES.length)];
                String randomPhone = generateRandomPhoneNumber();
                String randomComplaint = COMPLAINTS[RANDOM.nextInt(COMPLAINTS.length)];

                String complaintRecord = complaintNumber + ", " + dateTime + ", " + randomName + ", " + randomPhone + ", " + randomComplaint;

                try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
                    writer.write(complaintRecord + System.lineSeparator());
                    System.out.println("The record was added" + complaintRecord);
                }
                complaintNumber++;
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }

    }

    private static String generateRandomPhoneNumber() {
        String[] operatorCodes = {"29", "33", "44"};
        String[] prefixes = {"+375", " "};
        String[] separators = {" ", ""};

        String operatorCode = operatorCodes[RANDOM.nextInt(operatorCodes.length)];
        String prefix = prefixes[RANDOM.nextInt(prefixes.length)];
        String separator = separators[RANDOM.nextInt(separators.length)];
        String firstPart = Integer.toString(100 + RANDOM.nextInt(900));
        String secondPart = Integer.toString(10 + RANDOM.nextInt(90));
        String thirdPart = Integer.toString(10 + RANDOM.nextInt(90));


        StringBuilder sb = new StringBuilder(prefix).append(operatorCode)
                .append(firstPart).append(separator).append(secondPart)
                .append(separator).append(thirdPart);
        return sb.toString();
    }
}
