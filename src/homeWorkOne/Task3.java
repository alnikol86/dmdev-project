package src.homeWorkOne;

/**
 * Задание 3
 *
 *         Даны два прямоугольных треугольника.
 *         Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
 *         Написать код, в котором вычисляется площадь каждого треугольника и затем эти площади сравниваются друг с другом.
 *
 *         Для этого понадобится написать 2 функции.
 *         Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
 *         Вторая: сравнивает переданные площади двух треугольников и выводит на консоль первый треугольник больше, меньше или равен второму.
 *         Учитывать, что площадь может быть вещественным числом.
 */

public class Task3 {
    public static void main(String[] args) {
        double firstSquareTriangle = getSquare(10, 5);
        double secondSquareTriangle = getSquare(8, 10);

        compareSquare(firstSquareTriangle, secondSquareTriangle);
    }

    private static double getSquare(int a, int b) {
        // S = (a * b) / 2
        return (a * b) / 2;
    }

    private static void compareSquare(double firstSquare, double secondSquare) {
        if (firstSquare > secondSquare) {
            System.out.printf("First triangle is greater than second triangle (%s > %s)\n", firstSquare, secondSquare);
        } else if (firstSquare < secondSquare) {
            System.out.printf("First triangle is smaller than second triangle (%s > %s)\n", firstSquare, secondSquare);
        } else {
            System.out.println("The triangles are equal.");
        }
    }
}


