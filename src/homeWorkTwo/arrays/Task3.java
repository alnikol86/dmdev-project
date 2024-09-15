package src.homeWorkTwo.arrays;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * <p>
 * Написать функцию, которая принимает этот массив и разбивает на 3 других: с только отрицательными числами, только положительными и только нули.
 * Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.
 * <p>
 * Пример:
 * <p>
 * [-4, -18]
 * <p>
 * [-4, 0, 1, 9, 0, -18, 3] -> [0, 0]
 * <p>
 * [1, 9, 3]
 */
public class Task3 {
    public static void main(String[] args) {
        int[] arr = {-4, 0, 1, 9, 0, -18, 3};
        int[][] splitArr = splitArrayBySign(arr);

        for(int i = 0; i < splitArr.length; i++) {
            System.out.println(Arrays.toString(splitArr[i]));
        }
    }

    private static int[][] splitArrayBySign(int[] arr) {
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroInt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positiveCount++;
            } else if (arr[i] < 0) {
                negativeCount++;
            } else {
                zeroInt++;
            }
        }

        int[] positiveArr = new int[positiveCount];
        int[] negativeArr = new int[negativeCount];
        int[] zeroArr = new int[zeroInt];

        int positiv = 0;
        int negative = 0;
        int zero = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positiveArr[positiv] = arr[i];
                positiv++;
            } else if (arr[i] < 0) {
                negativeArr[negative] = arr[i];
                negative++;
            } else {
                zeroArr[zero] = arr[i];
                zero++;
            }
        }

        int[][] splitArr = new int[3][];
        splitArr[0] = positiveArr;
        splitArr[1] = negativeArr;
        splitArr[2] = zeroArr;

        return splitArr;
    }
}
