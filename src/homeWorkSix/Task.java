package src.homeWorkSix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Задание 1
 *
 * Дан список студентов с полями:
 * - Имя
 * - Фамилия
 * - Номер курса в университете
 * - Список оценок за учебу
 *
 * Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:
 *
 * Средняя оценка студентов этого курса, количество оценок у которых больше 3-х
 *
 * Список студентов данного курса, но только с полями Имя и Фамилия.
 * Список должен быть отсортированы по этим двум полям
 *
 * Объект с двумя полями:
 * - Отсортированный список студентов с пункта 2
 * - Средняя оценка этих студентов
 *
 * Подумать, как ассоциативный массив можно было представить в коде в виде отсортированного - TreeMap
 */
public class Task {
    public static void main(String[] args) {
        // Пример списка студентов
        List<Student> students = Arrays.asList(
                new Student("John", "Doe", 1, Arrays.asList(5, 4, 3)),
                new Student("Jane", "Smith", 1, Arrays.asList(5, 5, 4, 3)),
                new Student("Alice", "Brown", 2, Arrays.asList(4, 3, 3, 4)),
                new Student("Bob", "Johnson", 2, Arrays.asList(5, 5, 5)),
                new Student("Charlie", "Davis", 1, Arrays.asList(4, 4, 4, 4))
        );

        // Преобразование списка студентов в TreeMap, где ключ - курс, а значение - CourseInfo
        TreeMap<Integer, CourseInfo> courseMap = students.stream()
                .filter(student -> student.getGrades().size() > 3) // Фильтруем студентов с более чем 3 оценками
                .collect(Collectors.groupingBy(
                        Student::getCourseNumber,
                        TreeMap::new, // Используем TreeMap для отсортированного результата
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                Task::createCourseInfo
                        )
                ));

        // Выводим результат
        courseMap.forEach((course, courseInfo) -> {
            System.out.println("Course: " + course);
            System.out.println("Average grade: " + courseInfo.getAverageGrade());
            System.out.println("Students:");
            courseInfo.getStudents().forEach(student -> {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            });
        });
    }

    // Метод для создания объекта CourseInfo на основе списка студентов
    private static CourseInfo createCourseInfo(List<Student> students) {
        // Сортируем студентов по имени и фамилии
        List<StudentName> sortedStudents = students.stream()
                .map(student -> new StudentName(student.getFirstName(), student.getLastName()))
                .sorted(Comparator.comparing(StudentName::getFirstName)
                        .thenComparing(StudentName::getLastName))
                .collect(Collectors.toList());

        // Считаем среднюю оценку для студентов
        double averageGrade = students.stream()
                .flatMap(student -> student.getGrades().stream())
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        return new CourseInfo(sortedStudents, averageGrade);
    }
}
