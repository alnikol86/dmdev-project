package src.homeWorkOne;

//Задание 2
//
//        Даны 3 переменные:
//
//        - operand1 (double)
//        - operand2 (double)
//        - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
//
//        Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
//        Протестировать функцию в main.
//
//        Например:
//        Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’
//        Результат: 34.5 (24.4 + 10.1)

public class Task2 {
    public static void main(String[] args) {

        System.out.println(calculator(23, 10, '+'));
        System.out.println(calculator(23, 10, '-'));
        System.out.println(calculator(23, 10, '*'));
        System.out.println(calculator(23, 10, '/'));
        System.out.println(calculator(23, 10, '%'));
    }

    public static double calculator(double operand1, double operand2, char operation) {
        switch (operation) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            case '%':
                return operand1 % operand2;
        }
        return -0.0;
    }
}
