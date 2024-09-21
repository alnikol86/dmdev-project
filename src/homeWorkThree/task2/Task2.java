package src.homeWorkThree.task2;

import java.util.Arrays;

/**
 * Дана строка с текстом, в котором есть цифры от 0 до 9.
 *
 * Написать 2 метода:
 *
 * - возвращающий массив цифр из переданной строки
 * - возвращающий сумму цифр из переданного целочисленного массива
 *
 * Посчитать сумму всех чисел из строки
 *
 * Например:
 * “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)
 */

public class Task2 {
    public static void main(String[] args) {
        int[] digits = extractDigitsFromString("fsf55 sdfsfdsf sfsfsdf85 6 6 dasd 8");
        int sum = sumOfDigitsInArray(digits);

        System.out.println(Arrays.toString(digits));
        System.out.println(sum);
    }

    private static int[] extractDigitsFromString(String str) {
        int count = 0;
        char currentChar = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            currentChar = str.charAt(i);
            if (Character.isDigit(currentChar)) {
                stringBuilder.append(currentChar);
                count++;
            }
        }
        String strDigits = stringBuilder.toString();
        int[] result = new int[count];
        for (int i = 0; i < strDigits.length(); i++) {
            String strForParseToDigit = String.valueOf(strDigits.charAt(i));
            result[i] = Integer.parseInt(strForParseToDigit);
        }
        return result;
    }

    private static int sumOfDigitsInArray(int[] intArray) {
        int acc = 0;
        for (int i = 0; i < intArray.length; i++) {
            acc += intArray[i];
        }
        return acc;
    }

}
