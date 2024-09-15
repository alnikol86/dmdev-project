package src.homeWorkTwo.cycles;

/**
 * Дано целое число.
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на консоль.
 * Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321
 *
 * Примечание: для решения может понадобится функция возведение числа в степень: Math.pow(число, степень)
 */
public class Task2 {
    public static void main(String[] args) {
        int reverseNumber4508 = getReversNumber(4508);
        int reverseNumber4700 = getReversNumber(4700);
        int reverseNumber1234567 = getReversNumber(1234567);

        System.out.println(reverseNumber4508);
        System.out.println(reverseNumber4700);
        System.out.println(reverseNumber1234567);
    }

    private static int getReversNumber(int number) {
        int reverseNumber = 0;

        while (number != 0) {
            int lastDigit = number % 10;
            reverseNumber = reverseNumber * 10 + lastDigit;
            number /= 10;
        }
        return reverseNumber;
    }
}
