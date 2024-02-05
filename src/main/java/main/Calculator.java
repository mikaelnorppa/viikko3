package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Calculator {
    
    public static double getAvgGrade(Student student) {
        List<Grade> grades = student.getGrades();
        if (grades.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (Grade grade : grades) {
            sum += grade.getGrade();
        }

        return (double) sum / grades.size();

    }

    public static double getMedGrade(Student student) {
        List<Grade> grades = student.getGrades();
        if (grades.isEmpty()) {
            return 0.0;
        }

        List<Integer> gradeValue = new ArrayList<>();
        for (Grade grade : grades) {
            gradeValue.add(grade.getGrade());
        }
        Collections.sort(gradeValue);
        int size = gradeValue.size();
        if (size % 2 == 0) {
            int mid1 = gradeValue.get(size / 2 - 1);
            int mid2 = gradeValue.get(size / 2);
            return (double) (mid1 + mid2) / 2;
        } else {
            return gradeValue.get(size / 2);
        }

    }
}

