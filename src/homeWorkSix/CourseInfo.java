package src.homeWorkSix;

import java.util.List;

public class CourseInfo {
    private List<StudentName> students;
    private Double averageGrade;

    public CourseInfo(List<StudentName> students, double averageGrade) {
        this.students = students;
        this.averageGrade = averageGrade;
    }

    public List<StudentName> getStudents() {
        return students;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}
