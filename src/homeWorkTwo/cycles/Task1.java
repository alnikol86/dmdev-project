package src.homeWorkTwo.cycles;

/**
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число, а возвращать количество четных цифр (вторая функция - нечетных).
 * <p>
 * Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */
public class Task1 {
    public static void main(String[] args) {
        System.out.println(getEvenNumbers(228910));
        System.out.println();
        System.out.println(getOddNumbers(228910));

    }

    private static int getEvenNumbers(int number) {
        int evenCount = 0;

        for (int i = number; i > 0; i /= 10) {
            int lastDigit = i % 10;
            if (lastDigit % 2 == 0) {
                evenCount++;
            }
        }
        return evenCount;
    }

    private static int getOddNumbers(int number) {
        int oddCount = 0;

        for (int i = number; i > 0; i /= 10) {
            int lastDigit = i % 10;
            if (lastDigit % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount;
    }

}
