package src.homeWorkOne;

//Задание 3
//
//        Даны два прямоугольных треугольника.
//        Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
//        Написать код, в котором вычисляется площадь каждого треугольника и затем эти площади сравниваются друг с другом.
//
//        Для этого понадобится написать 2 функции.
//        Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
//        Вторая: сравнивает переданные площади двух треугольников и выводит на консоль первый треугольник больше, меньше или равен второму.
//        Учитывать, что площадь может быть вещественным числом.

public class Task3 {
    public static void main(String[] args) {
        double firstSquareTriangle = getSquare(10, 5);
        double secondSquareTriangle = getSquare(8, 10);

        getMaxSquare(firstSquareTriangle, secondSquareTriangle);
    }

    public static double getSquare(int a, int b) {
        // S = (a * b) / 2
        return (a * b) / 2;
    }

    public static void getMaxSquare(double firstSquare, double secondSquare) {
        if (firstSquare > secondSquare) {
            System.out.println("The first triangle is larger than the second.");
        } else if (firstSquare < secondSquare) {
            System.out.println("The first triangle is smaller than the second.");
        } else {
            System.out.println("The triangles are equal.");
        }
    }
}


