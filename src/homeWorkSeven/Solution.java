package src.homeWorkSeven;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String priceFilePath = "src/homeWorkSeven/items-price.csv";
        String nameFilePath = "src/homeWorkSeven/items-name.csv";
        String resultFilePath = "src/homeWorkSeven/result.csv";
        String errorFilePath = "src/homeWorkSeven/errors.csv";

        Map<String, String> itemPrices = readPrices(priceFilePath);
        Map<String, String[]> itemNames = readNames(nameFilePath);
        writeResultsAndErrors(itemPrices, itemNames, resultFilePath, errorFilePath);
    }

    // Метод для чтения файла с ценами (items-price.csv)
    private static Map<String, String> readPrices(String priceFilePath) {
        Map<String, String> itemPrices = new HashMap<>();
        try (BufferedReader priceReader = new BufferedReader(new FileReader(priceFilePath))) {
            String line;
            priceReader.readLine(); // Пропускаем заголовок
            while ((line = priceReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    itemPrices.put(parts[0], parts[1]); // ID -> PRICE
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemPrices;
    }

    // Метод для чтения файла с именами и описаниями (items-name.csv)
    private static Map<String, String[]> readNames(String nameFilePath) {
        Map<String, String[]> itemNames = new HashMap<>();
        try (BufferedReader nameReader = new BufferedReader(new FileReader(nameFilePath))) {
            String line;
            nameReader.readLine(); // Пропускаем заголовок
            while ((line = nameReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    itemNames.put(parts[0], new String[]{parts[1], parts[2]}); // ID -> [NAME, DESCRIPTION]
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemNames;
    }

    // Метод для записи результата и ошибок
    private static void writeResultsAndErrors(Map<String, String> itemPrices, Map<String, String[]> itemNames, String resultFilePath, String errorFilePath) {
        try (BufferedWriter resultWriter = new BufferedWriter(new FileWriter(resultFilePath));
             BufferedWriter errorWriter = new BufferedWriter(new FileWriter(errorFilePath))) {

            // Запись заголовка result.csv
            resultWriter.write("ID,NAME,PRICE\n");

            // Собираем все уникальные ID
            Set<String> allIds = new HashSet<>();
            allIds.addAll(itemPrices.keySet());
            allIds.addAll(itemNames.keySet());

            // Проходим по каждому ID
            for (String id : allIds) {
                String[] nameAndDesc = itemNames.get(id);
                String price = itemPrices.get(id);

                if (nameAndDesc != null && price != null) {
                    resultWriter.write(id + "," + nameAndDesc[0] + "," + price + "\n");
                } else {
                    errorWriter.write(id + "\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
