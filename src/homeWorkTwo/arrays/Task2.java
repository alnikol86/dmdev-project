package src.homeWorkTwo.arrays;

import java.util.Arrays;

/**
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел, где число - это код символа (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
 * <p>
 * Далее определить среднее арифметическое всех элементов целочисленного массива и вывести на консоль только те элементы, которые больше этого среднего арифметического.
 */
public class Task2 {
    public static void main(String[] args) {
        char[] charArr = {'a', '6', 'y', 'P', 'T', 'q', '9', '+'};
        int[] charToInt = transformCharToInt(charArr);
        System.out.println(Arrays.toString(charToInt));
        System.out.println("Arithmetic mean: " + meanValue(charToInt));
        System.out.println();
        printCharToIntElementsAboveAverage(charArr);
    }

    private static int[] transformCharToInt(char[] charArr) {
        int[] charToInt = new int[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            charToInt[i] = Character.getNumericValue(charArr[i]);
        }
        return charToInt;
    }

    private static int meanValue(int[] values) {
        int accValue = 0;
        for (int i = 0; i < values.length; i++) {
            accValue += values[i];
        }
        return accValue / values.length;
    }

    private static void printCharToIntElementsAboveAverage(char[] charArr) {
        int[] charToInt = transformCharToInt(charArr);
        int meanValue = meanValue(charToInt);
        for (int i = 0; i < charToInt.length; i++) {
            if (meanValue < charToInt[i]) {
                System.out.print(charToInt[i]);
                System.out.print(" ");
            }
        }
    }
}
