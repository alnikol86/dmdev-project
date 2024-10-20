package src.homeWorkSeven;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Задание 1
 *
 * Даны два файла в формате CSV.
 *
 * CSV (Comma-Separated Values) файл - это обычный текстовый файл, где через запятую (может использоваться и любой другой символ) перечислены значения. Также может быть в первой строчке таких файлов заголовок с названием колонок.
 *
 * Формат первого файла items-price.csv:
 *
 * ID,PRICE
 * 1,9.98
 * 2,25.05
 * 3,16.45
 *
 * Формат второго файла items-name.csv:
 *
 * ID,NAME,DESCRIPTION
 * 1,Шарф,Теплый зимний шарф красного цвета
 * 2,Шапка,Вязаная зеленая шапка
 * 3,Ботинки,Осенние ботинки на толстой подошве
 *
 * Задача:
 *
 * Считать оба CSV файла и объединить их по полю ID в один result.csv, где будут следующие поля: ID,NAME,PRICE.
 *
 * Желательно реализовать доп. функционал:
 * Если для каких-то ID не будет значений в обоих файлах, то записать их в один файл errors.csv, где будет лишь одно поле ID.
 */

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
