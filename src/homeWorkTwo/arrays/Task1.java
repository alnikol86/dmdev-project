package src.homeWorkTwo.arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы (удалить - значит создать новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 */
public class Task1 {
    public static void main(String[] args) {
        int[] arr = {3, 5, -6, 3, 2, -9, 0, -123};
        int length = calculateLengthOfArray(arr);
        int[] newArr = createNewArray(arr, length);
        printArray(newArr);
    }

    private static int calculateLengthOfArray(int[] array) {
        int length = 0;
        for (int j : array) {
            if (j >= 0) {
                length++;
            }
        }
        return length;
    }

    private static int[] createNewArray(int[] array, int length) {
        int[] newArray = new int[length];
        int count = 0;
        for (int j : array) {
            if (j >= 0) {
                newArray[count] = getAnInt(j, newArray);
                count++;
            }
        }
        return newArray;
    }

    private static int getAnInt(int j, int[] newArray) {
        return j * newArray.length;
    }

    private static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}
