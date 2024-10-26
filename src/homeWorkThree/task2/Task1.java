package src.homeWorkThree.task2;

/**
 * Дана строка.
 * Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом. Также удалить пробелы.
 * Результат привести к верхнему регистру.
 *
 * Например:
 * "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */

public class Task1 {
    public static void main(String[] args) {
        String result = removeConsecutiveDuplicatesAndSpaces("abc Cpddd Dio OsfWw");
        System.out.println(result);
    }

    private static String removeConsecutiveDuplicatesAndSpaces (String string) {
        String str = string.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        char prevChar = 0;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar != ' ' && currentChar != prevChar) {
                stringBuilder.append(currentChar);
                prevChar = currentChar;
            }
        }
        return stringBuilder.toString().toUpperCase();
    }
}
