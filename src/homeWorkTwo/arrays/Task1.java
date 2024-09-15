package src.homeWorkTwo.arrays;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы (удалить - значит создать новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 */
public class Task1 {
    public static void main(String[] args) {
        int[] arr = {3, 5, -6, 3, 2, -9, 0, -123};
        int[] arrResult = getArrayWithPositiveNumbers(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrResult));

    }

    private static int[] getArrayWithPositiveNumbers (int[] array) {
        int[] tempArray = new int[array.length];
        int count = 0;

        for (int el : array) {
            if (el >= 0) {
                tempArray[count++] = el;
            }
        }

        int [] positiveArray = new int[count];

        for (int i = 0; i < positiveArray.length; i++) {
            positiveArray[i] = tempArray[i] * count;
        }

        return positiveArray;
    }
}
